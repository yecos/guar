package com.hpplay.logwriter;

import com.raizlabs.android.dbflow.sql.language.Operator;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/* loaded from: classes2.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    private static final String f7392a = "FileUtils";

    /* renamed from: b, reason: collision with root package name */
    private static final String f7393b = "anr.zip";

    /* renamed from: c, reason: collision with root package name */
    private static final String f7394c = "/data/anr";

    public static void a(String str, String str2) {
        a(false, str, str2);
    }

    public static void b(String str, String str2) {
        a(true, str, str2);
    }

    public static void c(String str) {
        File file = new File(str, f7393b);
        if (file.exists()) {
            file.delete();
            file = new File(str, f7393b);
        }
        b(f7394c, file.getAbsolutePath());
    }

    private static void a(boolean z10, String str, String str2) {
        try {
            ZipOutputStream zipOutputStream = new ZipOutputStream(new FileOutputStream(str2));
            File file = new File(str);
            a(z10, file.getParent() + File.separator, file.getName(), zipOutputStream);
            zipOutputStream.flush();
            zipOutputStream.finish();
            zipOutputStream.close();
        } catch (Exception unused) {
        }
    }

    public static long b(String str) {
        long j10 = 0;
        try {
            File[] listFiles = new File(str).listFiles();
            for (int i10 = 0; i10 < listFiles.length; i10++) {
                j10 += listFiles[i10].isDirectory() ? b(listFiles[i10].getAbsolutePath()) : listFiles[i10].length();
            }
        } catch (Exception unused) {
        }
        return j10;
    }

    private static void a(boolean z10, String str, String str2, ZipOutputStream zipOutputStream) {
        ZipEntry zipEntry;
        if (zipOutputStream == null) {
            return;
        }
        File file = new File(str + str2);
        if (file.isFile()) {
            if (z10) {
                zipEntry = new ZipEntry(str.split(Operator.Operation.DIVISION)[r6.length - 1] + File.separator + str2);
            } else {
                zipEntry = new ZipEntry(str2);
            }
            FileInputStream fileInputStream = new FileInputStream(file);
            zipOutputStream.putNextEntry(zipEntry);
            byte[] bArr = new byte[4096];
            while (true) {
                int read = fileInputStream.read(bArr);
                if (read != -1) {
                    zipOutputStream.write(bArr, 0, read);
                } else {
                    zipOutputStream.closeEntry();
                    return;
                }
            }
        } else {
            String[] list = file.list();
            if (list != null) {
                if (list.length <= 0) {
                    zipOutputStream.putNextEntry(new ZipEntry(str2 + File.separator));
                    zipOutputStream.closeEntry();
                }
                for (String str3 : list) {
                    a(z10, str + str2 + Operator.Operation.DIVISION, str3, zipOutputStream);
                }
            }
        }
    }

    public static void a(String str) {
        File file = new File(str);
        if (file.isDirectory()) {
            File[] listFiles = file.listFiles();
            for (File file2 : listFiles) {
                a(file2.getAbsolutePath());
            }
            return;
        }
        if (file.exists()) {
            file.delete();
        }
    }
}
