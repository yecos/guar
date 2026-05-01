package com.hpplay.logwriter;

import android.text.TextUtils;
import com.raizlabs.android.dbflow.sql.language.Operator;
import io.jsonwebtoken.Header;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;

/* loaded from: classes2.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    public static final long f7378a = 5242880;

    /* renamed from: b, reason: collision with root package name */
    public static final long f7379b = 4194304;

    /* renamed from: c, reason: collision with root package name */
    public static final int f7380c = 6;

    /* renamed from: d, reason: collision with root package name */
    public static final String f7381d = ".txt";

    /* renamed from: e, reason: collision with root package name */
    public static final String f7382e = ".zip";

    /* renamed from: f, reason: collision with root package name */
    private static final String f7383f = "hpplay-java:Cache";

    /* renamed from: g, reason: collision with root package name */
    private String f7384g;

    /* renamed from: j, reason: collision with root package name */
    private String f7387j;

    /* renamed from: h, reason: collision with root package name */
    private File f7385h = null;

    /* renamed from: i, reason: collision with root package name */
    private FileOutputStream f7386i = null;

    /* renamed from: k, reason: collision with root package name */
    private File f7388k = null;

    /* renamed from: l, reason: collision with root package name */
    private FileOutputStream f7389l = null;

    public void a(String str) {
        if (str.endsWith(Operator.Operation.DIVISION)) {
            this.f7384g = str + "0";
            this.f7387j = str + "1";
        } else {
            this.f7384g = str + "/0";
            this.f7387j = str + "/1";
        }
        a(this.f7384g, false);
        a(this.f7387j, true);
    }

    public void b(byte[] bArr) {
        String str = this.f7387j;
        if (str == null) {
            return;
        }
        b(str);
        a(this.f7387j, this.f7388k, this.f7389l, true);
        a(bArr, this.f7389l);
    }

    private String b(String str, boolean z10) {
        String str2;
        if (z10) {
            str2 = "1-" + h.a() + f7381d;
        } else {
            str2 = "0-" + h.a() + f7381d;
        }
        if (str.endsWith(Operator.Operation.DIVISION)) {
            return str + str2;
        }
        return str + Operator.Operation.DIVISION + str2;
    }

    private void a(String str, boolean z10) {
        File file = new File(str);
        if (!file.exists()) {
            file.mkdirs();
        } else if (file.isDirectory()) {
            a(file, z10);
        }
    }

    private void b(String str) {
        File file = new File(str);
        if (file.exists() && file.isDirectory()) {
            a(file);
        }
    }

    private void a(File file, boolean z10) {
        File[] listFiles = file.listFiles();
        if (listFiles == null || listFiles.length <= 0) {
            return;
        }
        int length = listFiles.length;
        for (int i10 = 0; i10 < length; i10++) {
            if (listFiles[i10].getName() != null && !listFiles[i10].getName().equalsIgnoreCase(Header.COMPRESSION_ALGORITHM) && listFiles[i10].length() < f7379b) {
                try {
                    if (z10) {
                        this.f7388k = listFiles[i10];
                        this.f7389l = new FileOutputStream(this.f7388k, true);
                    } else {
                        this.f7385h = listFiles[i10];
                        this.f7386i = new FileOutputStream(this.f7385h, true);
                    }
                    return;
                } catch (Exception e10) {
                    g.a(f7383f, e10);
                    return;
                }
            }
        }
    }

    public void a(byte[] bArr) {
        String str = this.f7384g;
        if (str == null) {
            return;
        }
        b(str);
        a(this.f7384g, this.f7385h, this.f7386i, false);
        a(bArr, this.f7386i);
    }

    private void a(byte[] bArr, OutputStream outputStream) {
        if (bArr == null || outputStream == null) {
            return;
        }
        try {
            outputStream.write(bArr);
            outputStream.flush();
        } catch (Exception e10) {
            g.a(f7383f, e10);
            try {
                outputStream.flush();
                outputStream.close();
            } catch (Exception e11) {
                g.a(f7383f, e11);
            }
        }
    }

    private void a(String str, File file, FileOutputStream fileOutputStream, boolean z10) {
        String a10;
        if (file == null || fileOutputStream == null) {
            a(str, fileOutputStream, z10);
            return;
        }
        if (file.length() >= f7378a) {
            if (!TextUtils.isEmpty(file.getName())) {
                a10 = file.getName().replace(f7381d, f7382e);
            } else {
                a10 = h.a();
            }
            if (!str.endsWith(Operator.Operation.DIVISION)) {
                str = str + Operator.Operation.DIVISION;
            }
            a(fileOutputStream);
            e.a(file.getAbsolutePath(), str + a10);
            e.a(file.getAbsolutePath());
            a(str, fileOutputStream, z10);
        }
    }

    private void a(String str, FileOutputStream fileOutputStream, boolean z10) {
        a(fileOutputStream);
        String b10 = b(str, z10);
        try {
            if (z10) {
                File file = new File(b10);
                this.f7388k = file;
                file.createNewFile();
                this.f7389l = new FileOutputStream(this.f7388k, true);
            } else {
                File file2 = new File(b10);
                this.f7385h = file2;
                file2.createNewFile();
                this.f7386i = new FileOutputStream(this.f7385h, true);
            }
        } catch (Exception e10) {
            g.a(f7383f, e10);
        }
    }

    private void a(File file) {
        File[] listFiles = file.listFiles();
        if (listFiles == null || listFiles.length < 6) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (File file2 : listFiles) {
            arrayList.add(file2);
        }
        Collections.sort(arrayList, new d());
        for (int i10 = 0; i10 < (arrayList.size() - 6) + 1; i10++) {
            try {
                ((File) arrayList.get(i10)).delete();
            } catch (Exception e10) {
                g.a(f7383f, e10);
            }
        }
    }

    private void a(OutputStream outputStream) {
        if (outputStream == null) {
            return;
        }
        try {
            outputStream.close();
        } catch (Exception e10) {
            g.a(f7383f, e10);
        }
    }

    public void a() {
        a(this.f7386i);
        this.f7386i = null;
        this.f7385h = null;
        a(this.f7389l);
        this.f7389l = null;
        this.f7388k = null;
    }
}
