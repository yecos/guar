package com.uc.crashsdk.a;

import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.zip.GZIPOutputStream;

/* loaded from: classes3.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    private static final int[] f9604a = {126, 147, 115, 241, 101, 198, 215, 134};

    /* renamed from: b, reason: collision with root package name */
    private static final int[] f9605b = {125, 185, 233, 226, 129, 142, 151, 176};

    /* renamed from: c, reason: collision with root package name */
    private static final int[] f9606c = {238, 185, 233, 179, 129, 142, 151, 167};

    public static String a(String str) {
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2;
        File file = new File(str);
        FileInputStream fileInputStream3 = null;
        if (!file.exists()) {
            return null;
        }
        try {
            fileInputStream2 = new FileInputStream(file);
        } catch (Exception e10) {
            e = e10;
            fileInputStream = null;
        } catch (Throwable th) {
            th = th;
        }
        try {
            byte[] bArr = new byte[(int) file.length()];
            fileInputStream2.read(bArr);
            g.a(fileInputStream2);
            byte[] a10 = a(bArr, f9604a);
            if (a10 == null || a10.length <= 0) {
                g.a((Closeable) null);
                return null;
            }
            int length = a10.length - 1;
            String str2 = a10[length] == 10 ? new String(a10, 0, length) : new String(a10);
            g.a((Closeable) null);
            return str2;
        } catch (Exception e11) {
            fileInputStream = fileInputStream2;
            e = e11;
            try {
                g.a(e);
                g.a(fileInputStream);
                return null;
            } catch (Throwable th2) {
                th = th2;
                fileInputStream3 = fileInputStream;
                g.a(fileInputStream3);
                throw th;
            }
        } catch (Throwable th3) {
            fileInputStream3 = fileInputStream2;
            th = th3;
            g.a(fileInputStream3);
            throw th;
        }
    }

    private static byte[] b(byte[] bArr, int[] iArr) {
        if (bArr != null && iArr != null && iArr.length == 8) {
            int length = bArr.length;
            try {
                byte[] bArr2 = new byte[length + 2];
                byte b10 = 0;
                for (int i10 = 0; i10 < length; i10++) {
                    byte b11 = bArr[i10];
                    bArr2[i10] = (byte) (iArr[i10 % 8] ^ b11);
                    b10 = (byte) (b10 ^ b11);
                }
                bArr2[length] = (byte) (iArr[0] ^ b10);
                bArr2[length + 1] = (byte) (iArr[1] ^ b10);
                return bArr2;
            } catch (Exception e10) {
                g.a(e10);
            }
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0022, code lost:
    
        r1 = com.uc.crashsdk.a.g.e(r0);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String a(String str, String str2, boolean z10) {
        byte[] e10;
        String str3;
        boolean z11;
        String str4;
        boolean z12;
        GZIPOutputStream gZIPOutputStream;
        Throwable th;
        ByteArrayOutputStream byteArrayOutputStream;
        boolean z13;
        if (!z10 || g.a(str)) {
            return str;
        }
        File file = new File(str);
        if (file.exists() && file.length() <= 3145728 && e10 != null && e10.length > 0) {
            boolean z14 = true;
            if (z10) {
                try {
                    byteArrayOutputStream = new ByteArrayOutputStream();
                    try {
                        gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
                        try {
                            gZIPOutputStream.write(e10);
                            byteArrayOutputStream.flush();
                            g.a(byteArrayOutputStream);
                        } catch (Throwable th2) {
                            th = th2;
                            try {
                                g.a(th);
                                g.a(byteArrayOutputStream);
                                g.a(gZIPOutputStream);
                                e10 = byteArrayOutputStream.toByteArray();
                                z13 = true;
                                if (z13) {
                                }
                                return str;
                            } catch (Throwable th3) {
                                g.a(byteArrayOutputStream);
                                g.a(gZIPOutputStream);
                                throw th3;
                            }
                        }
                    } catch (Throwable th4) {
                        gZIPOutputStream = null;
                        th = th4;
                    }
                } catch (Throwable th5) {
                    gZIPOutputStream = null;
                    th = th5;
                    byteArrayOutputStream = null;
                }
                g.a(gZIPOutputStream);
                try {
                    e10 = byteArrayOutputStream.toByteArray();
                    z13 = true;
                } catch (Throwable th6) {
                    g.a(th6);
                    z13 = false;
                }
                if (z13 || e10 == null || e10.length <= 0) {
                    return str;
                }
                str3 = str + str2;
                z11 = true;
            } else {
                str3 = str;
                z11 = false;
            }
            if (z11) {
                if (str3.equals(file.getName())) {
                    str4 = str3 + ".tmp";
                    z12 = true;
                } else {
                    str4 = str3;
                    z12 = false;
                }
                File file2 = new File(str4);
                if (!g.a(file2, e10)) {
                    z14 = false;
                } else if (z12) {
                    file.delete();
                    file2.renameTo(file);
                }
                if (z14) {
                    return str3;
                }
            }
        }
        return str;
    }

    private static byte[] a(byte[] bArr, int[] iArr) {
        if (bArr.length - 0 >= 2 && iArr != null && iArr.length == 8) {
            int length = (bArr.length - 2) - 0;
            try {
                byte[] bArr2 = new byte[length];
                byte b10 = 0;
                for (int i10 = 0; i10 < length; i10++) {
                    byte b11 = (byte) (bArr[i10 + 0] ^ iArr[i10 % 8]);
                    bArr2[i10] = b11;
                    b10 = (byte) (b10 ^ b11);
                }
                if (bArr[length + 0] == ((byte) ((iArr[0] ^ b10) & 255)) && bArr[length + 1 + 0] == ((byte) ((iArr[1] ^ b10) & 255))) {
                    return bArr2;
                }
                return null;
            } catch (Exception e10) {
                g.a(e10);
            }
        }
        return null;
    }

    public static boolean a(String str, String str2) {
        FileOutputStream fileOutputStream;
        try {
            File file = new File(str);
            if (file.exists()) {
                file.delete();
            }
            fileOutputStream = new FileOutputStream(file);
        } catch (Throwable th) {
            g.a(th);
            fileOutputStream = null;
        }
        if (fileOutputStream == null) {
            return false;
        }
        byte[] b10 = b(str2.getBytes(), f9604a);
        if (b10 == null) {
            return false;
        }
        try {
            fileOutputStream.write(b10);
            g.a(fileOutputStream);
            return true;
        } catch (Throwable th2) {
            try {
                g.a(th2);
                return false;
            } finally {
                g.a(fileOutputStream);
            }
        }
    }
}
