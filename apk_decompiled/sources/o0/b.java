package o0;

import android.content.Context;
import android.content.SharedPreferences;
import com.umeng.umcrash.UMCrash;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileFilter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipOutputStream;

/* loaded from: classes.dex */
public final class b implements Closeable {

    /* renamed from: a, reason: collision with root package name */
    public final File f17445a;

    /* renamed from: b, reason: collision with root package name */
    public final long f17446b;

    /* renamed from: c, reason: collision with root package name */
    public final File f17447c;

    /* renamed from: d, reason: collision with root package name */
    public final RandomAccessFile f17448d;

    /* renamed from: e, reason: collision with root package name */
    public final FileChannel f17449e;

    /* renamed from: f, reason: collision with root package name */
    public final FileLock f17450f;

    public class a implements FileFilter {
        public a() {
        }

        @Override // java.io.FileFilter
        public boolean accept(File file) {
            return !file.getName().equals("MultiDex.lock");
        }
    }

    /* renamed from: o0.b$b, reason: collision with other inner class name */
    public static class C0301b extends File {

        /* renamed from: a, reason: collision with root package name */
        public long f17452a;

        public C0301b(File file, String str) {
            super(file, str);
            this.f17452a = -1L;
        }
    }

    public b(File file, File file2) {
        StringBuilder sb = new StringBuilder();
        sb.append("MultiDexExtractor(");
        sb.append(file.getPath());
        sb.append(", ");
        sb.append(file2.getPath());
        sb.append(")");
        this.f17445a = file;
        this.f17447c = file2;
        this.f17446b = m(file);
        File file3 = new File(file2, "MultiDex.lock");
        RandomAccessFile randomAccessFile = new RandomAccessFile(file3, "rw");
        this.f17448d = randomAccessFile;
        try {
            FileChannel channel = randomAccessFile.getChannel();
            this.f17449e = channel;
            try {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Blocking on lock ");
                sb2.append(file3.getPath());
                this.f17450f = channel.lock();
                StringBuilder sb3 = new StringBuilder();
                sb3.append(file3.getPath());
                sb3.append(" locked");
            } catch (IOException e10) {
                e = e10;
                b(this.f17449e);
                throw e;
            } catch (Error e11) {
                e = e11;
                b(this.f17449e);
                throw e;
            } catch (RuntimeException e12) {
                e = e12;
                b(this.f17449e);
                throw e;
            }
        } catch (IOException | Error | RuntimeException e13) {
            b(this.f17448d);
            throw e13;
        }
    }

    public static void b(Closeable closeable) {
        try {
            closeable.close();
        } catch (IOException unused) {
        }
    }

    public static void c(ZipFile zipFile, ZipEntry zipEntry, File file, String str) {
        InputStream inputStream = zipFile.getInputStream(zipEntry);
        File createTempFile = File.createTempFile("tmp-" + str, com.hpplay.logwriter.b.f7382e, file.getParentFile());
        StringBuilder sb = new StringBuilder();
        sb.append("Extracting ");
        sb.append(createTempFile.getPath());
        try {
            ZipOutputStream zipOutputStream = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(createTempFile)));
            try {
                ZipEntry zipEntry2 = new ZipEntry("classes.dex");
                zipEntry2.setTime(zipEntry.getTime());
                zipOutputStream.putNextEntry(zipEntry2);
                byte[] bArr = new byte[16384];
                for (int read = inputStream.read(bArr); read != -1; read = inputStream.read(bArr)) {
                    zipOutputStream.write(bArr, 0, read);
                }
                zipOutputStream.closeEntry();
                zipOutputStream.close();
                if (!createTempFile.setReadOnly()) {
                    throw new IOException("Failed to mark readonly \"" + createTempFile.getAbsolutePath() + "\" (tmp of \"" + file.getAbsolutePath() + "\")");
                }
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Renaming to ");
                sb2.append(file.getPath());
                if (createTempFile.renameTo(file)) {
                    return;
                }
                throw new IOException("Failed to rename \"" + createTempFile.getAbsolutePath() + "\" to \"" + file.getAbsolutePath() + "\"");
            } catch (Throwable th) {
                zipOutputStream.close();
                throw th;
            }
        } finally {
            b(inputStream);
            createTempFile.delete();
        }
    }

    public static SharedPreferences e(Context context) {
        return context.getSharedPreferences("multidex.version", 4);
    }

    public static long f(File file) {
        long lastModified = file.lastModified();
        return lastModified == -1 ? lastModified - 1 : lastModified;
    }

    public static long m(File file) {
        long c10 = c.c(file);
        return c10 == -1 ? c10 - 1 : c10;
    }

    public static boolean n(Context context, File file, long j10, String str) {
        SharedPreferences e10 = e(context);
        if (e10.getLong(str + UMCrash.SP_KEY_TIMESTAMP, -1L) == f(file)) {
            if (e10.getLong(str + "crc", -1L) == j10) {
                return false;
            }
        }
        return true;
    }

    public static void v(Context context, String str, long j10, long j11, List list) {
        SharedPreferences.Editor edit = e(context).edit();
        edit.putLong(str + UMCrash.SP_KEY_TIMESTAMP, j10);
        edit.putLong(str + "crc", j11);
        edit.putInt(str + "dex.number", list.size() + 1);
        Iterator it = list.iterator();
        int i10 = 2;
        while (it.hasNext()) {
            C0301b c0301b = (C0301b) it.next();
            edit.putLong(str + "dex.crc." + i10, c0301b.f17452a);
            edit.putLong(str + "dex.time." + i10, c0301b.lastModified());
            i10++;
        }
        edit.commit();
    }

    public final void a() {
        File[] listFiles = this.f17447c.listFiles(new a());
        if (listFiles == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("Failed to list secondary dex dir content (");
            sb.append(this.f17447c.getPath());
            sb.append(").");
            return;
        }
        for (File file : listFiles) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Trying to delete old file ");
            sb2.append(file.getPath());
            sb2.append(" of size ");
            sb2.append(file.length());
            if (file.delete()) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append("Deleted old file ");
                sb3.append(file.getPath());
            } else {
                StringBuilder sb4 = new StringBuilder();
                sb4.append("Failed to delete old file ");
                sb4.append(file.getPath());
            }
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f17450f.release();
        this.f17449e.close();
        this.f17448d.close();
    }

    public List q(Context context, String str, boolean z10) {
        List u10;
        List list;
        StringBuilder sb = new StringBuilder();
        sb.append("MultiDexExtractor.load(");
        sb.append(this.f17445a.getPath());
        sb.append(", ");
        sb.append(z10);
        sb.append(", ");
        sb.append(str);
        sb.append(")");
        if (!this.f17450f.isValid()) {
            throw new IllegalStateException("MultiDexExtractor was closed");
        }
        if (!z10 && !n(context, this.f17445a, this.f17446b, str)) {
            try {
                list = s(context, str);
            } catch (IOException unused) {
                u10 = u();
                v(context, str, f(this.f17445a), this.f17446b, u10);
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append("load found ");
            sb2.append(list.size());
            sb2.append(" secondary dex files");
            return list;
        }
        u10 = u();
        v(context, str, f(this.f17445a), this.f17446b, u10);
        list = u10;
        StringBuilder sb22 = new StringBuilder();
        sb22.append("load found ");
        sb22.append(list.size());
        sb22.append(" secondary dex files");
        return list;
    }

    public final List s(Context context, String str) {
        String str2 = this.f17445a.getName() + ".classes";
        SharedPreferences e10 = e(context);
        int i10 = e10.getInt(str + "dex.number", 1);
        ArrayList arrayList = new ArrayList(i10 + (-1));
        int i11 = 2;
        while (i11 <= i10) {
            C0301b c0301b = new C0301b(this.f17447c, str2 + i11 + com.hpplay.logwriter.b.f7382e);
            if (!c0301b.isFile()) {
                throw new IOException("Missing extracted secondary dex file '" + c0301b.getPath() + "'");
            }
            c0301b.f17452a = m(c0301b);
            long j10 = e10.getLong(str + "dex.crc." + i11, -1L);
            long j11 = e10.getLong(str + "dex.time." + i11, -1L);
            long lastModified = c0301b.lastModified();
            if (j11 == lastModified) {
                String str3 = str2;
                SharedPreferences sharedPreferences = e10;
                if (j10 == c0301b.f17452a) {
                    arrayList.add(c0301b);
                    i11++;
                    e10 = sharedPreferences;
                    str2 = str3;
                }
            }
            throw new IOException("Invalid extracted dex: " + c0301b + " (key \"" + str + "\"), expected modification time: " + j11 + ", modification time: " + lastModified + ", expected crc: " + j10 + ", file crc: " + c0301b.f17452a);
        }
        return arrayList;
    }

    public final List u() {
        String str = this.f17445a.getName() + ".classes";
        a();
        ArrayList arrayList = new ArrayList();
        ZipFile zipFile = new ZipFile(this.f17445a);
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("classes");
            int i10 = 2;
            sb.append(2);
            sb.append(".dex");
            ZipEntry entry = zipFile.getEntry(sb.toString());
            while (entry != null) {
                C0301b c0301b = new C0301b(this.f17447c, str + i10 + com.hpplay.logwriter.b.f7382e);
                arrayList.add(c0301b);
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Extraction is needed for file ");
                sb2.append(c0301b);
                int i11 = 0;
                boolean z10 = false;
                while (i11 < 3 && !z10) {
                    i11++;
                    c(zipFile, entry, c0301b, str);
                    try {
                        c0301b.f17452a = m(c0301b);
                        z10 = true;
                    } catch (IOException unused) {
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append("Failed to read crc from ");
                        sb3.append(c0301b.getAbsolutePath());
                        z10 = false;
                    }
                    StringBuilder sb4 = new StringBuilder();
                    sb4.append("Extraction ");
                    sb4.append(z10 ? "succeeded" : "failed");
                    sb4.append(" '");
                    sb4.append(c0301b.getAbsolutePath());
                    sb4.append("': length ");
                    sb4.append(c0301b.length());
                    sb4.append(" - crc: ");
                    sb4.append(c0301b.f17452a);
                    if (!z10) {
                        c0301b.delete();
                        if (c0301b.exists()) {
                            StringBuilder sb5 = new StringBuilder();
                            sb5.append("Failed to delete corrupted secondary dex '");
                            sb5.append(c0301b.getPath());
                            sb5.append("'");
                        }
                    }
                }
                if (!z10) {
                    throw new IOException("Could not create zip file " + c0301b.getAbsolutePath() + " for secondary dex (" + i10 + ")");
                }
                i10++;
                entry = zipFile.getEntry("classes" + i10 + ".dex");
            }
            try {
                zipFile.close();
            } catch (IOException unused2) {
            }
            return arrayList;
        } catch (Throwable th) {
            try {
                zipFile.close();
            } catch (IOException unused3) {
            }
            throw th;
        }
    }
}
