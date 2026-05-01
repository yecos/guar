package com.uc.crashsdk.a;

import com.google.common.base.Ascii;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: classes3.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    static final /* synthetic */ boolean f9607a = true;

    /* renamed from: b, reason: collision with root package name */
    private static String f9608b = "";

    public static byte[] a(byte[] bArr, byte[] bArr2) {
        return a(bArr, bArr2, true, false);
    }

    public static byte[] b(byte[] bArr, byte[] bArr2) {
        return a(bArr, bArr2, true, true);
    }

    public static byte[] a(byte[] bArr, byte[] bArr2, boolean z10) {
        return a(bArr, bArr2, z10, true);
    }

    private static boolean b(File file, String str, String str2) {
        try {
            byte[] a10 = a(file);
            if (a10 != null && a10.length != 0) {
                return a(a10, str, str2);
            }
            return false;
        } catch (Exception e10) {
            g.a(e10);
            return false;
        }
    }

    private static byte[] a(byte[] bArr, byte[] bArr2, boolean z10, boolean z11) {
        IvParameterSpec ivParameterSpec = new IvParameterSpec(new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0});
        SecretKeySpec secretKeySpec = new SecretKeySpec(bArr2, "AES");
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(z10 ? 1 : 2, secretKeySpec, ivParameterSpec);
        if (!z10) {
            return cipher.doFinal(bArr);
        }
        if (!z11) {
            bArr = a(bArr);
        }
        return cipher.doFinal(bArr);
    }

    private static byte[] a(byte[] bArr) {
        byte[] bArr2 = new byte[bArr.length + 16];
        int length = bArr.length;
        bArr2[0] = (byte) ((length >> 0) & 255);
        bArr2[1] = (byte) ((length >> 8) & 255);
        bArr2[2] = (byte) ((length >> 16) & 255);
        bArr2[3] = (byte) ((length >> 24) & 255);
        for (int i10 = 4; i10 < 16; i10++) {
            bArr2[i10] = 0;
        }
        System.arraycopy(bArr, 0, bArr2, 16, bArr.length);
        return bArr2;
    }

    public static byte[] a() {
        return new byte[]{48, Ascii.EM, 6, 55};
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0094 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r4v1, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r4v2 */
    /* JADX WARN: Type inference failed for: r4v3 */
    /* JADX WARN: Type inference failed for: r4v4, types: [java.io.ByteArrayOutputStream, java.io.Closeable] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static byte[] a(java.lang.String r7, byte[] r8) {
        /*
            r0 = 0
            java.net.URL r1 = new java.net.URL     // Catch: java.lang.Throwable -> L85
            r1.<init>(r7)     // Catch: java.lang.Throwable -> L85
            java.net.URLConnection r7 = r1.openConnection()     // Catch: java.lang.Throwable -> L85
            java.net.HttpURLConnection r7 = (java.net.HttpURLConnection) r7     // Catch: java.lang.Throwable -> L85
            r1 = 5000(0x1388, float:7.006E-42)
            r7.setConnectTimeout(r1)     // Catch: java.lang.Throwable -> L83
            r7.setReadTimeout(r1)     // Catch: java.lang.Throwable -> L83
            r1 = 1
            r7.setDoInput(r1)     // Catch: java.lang.Throwable -> L83
            r7.setDoOutput(r1)     // Catch: java.lang.Throwable -> L83
            java.lang.String r1 = "POST"
            r7.setRequestMethod(r1)     // Catch: java.lang.Throwable -> L83
            r1 = 0
            r7.setUseCaches(r1)     // Catch: java.lang.Throwable -> L83
            java.lang.String r2 = "Content-Type"
            java.lang.String r3 = "application/x-www-form-urlencoded"
            r7.setRequestProperty(r2, r3)     // Catch: java.lang.Throwable -> L83
            java.lang.String r2 = "Content-Length"
            int r3 = r8.length     // Catch: java.lang.Throwable -> L83
            java.lang.String r3 = java.lang.String.valueOf(r3)     // Catch: java.lang.Throwable -> L83
            r7.setRequestProperty(r2, r3)     // Catch: java.lang.Throwable -> L83
            java.io.OutputStream r2 = r7.getOutputStream()     // Catch: java.lang.Throwable -> L83
            r2.write(r8)     // Catch: java.lang.Throwable -> L80
            int r8 = r7.getResponseCode()     // Catch: java.lang.Throwable -> L80
            r3 = 200(0xc8, float:2.8E-43)
            if (r8 == r3) goto L51
            com.uc.crashsdk.a.g.a(r2)
            com.uc.crashsdk.a.g.a(r0)
            com.uc.crashsdk.a.g.a(r0)
            r7.disconnect()     // Catch: java.lang.Throwable -> L50
        L50:
            return r0
        L51:
            java.io.InputStream r8 = r7.getInputStream()     // Catch: java.lang.Throwable -> L80
            r3 = 1024(0x400, float:1.435E-42)
            byte[] r3 = new byte[r3]     // Catch: java.lang.Throwable -> L7e
            java.io.ByteArrayOutputStream r4 = new java.io.ByteArrayOutputStream     // Catch: java.lang.Throwable -> L7e
            int r5 = r8.available()     // Catch: java.lang.Throwable -> L7e
            r4.<init>(r5)     // Catch: java.lang.Throwable -> L7e
        L62:
            int r5 = r8.read(r3)     // Catch: java.lang.Throwable -> L89
            r6 = -1
            if (r5 == r6) goto L6d
            r4.write(r3, r1, r5)     // Catch: java.lang.Throwable -> L89
            goto L62
        L6d:
            byte[] r0 = r4.toByteArray()     // Catch: java.lang.Throwable -> L89
            com.uc.crashsdk.a.g.a(r2)
            com.uc.crashsdk.a.g.a(r8)
            com.uc.crashsdk.a.g.a(r4)
            r7.disconnect()     // Catch: java.lang.Throwable -> L7d
        L7d:
            return r0
        L7e:
            r4 = r0
            goto L89
        L80:
            r8 = r0
            r4 = r8
            goto L89
        L83:
            r8 = r0
            goto L87
        L85:
            r7 = r0
            r8 = r7
        L87:
            r2 = r8
            r4 = r2
        L89:
            com.uc.crashsdk.a.g.a(r2)
            com.uc.crashsdk.a.g.a(r8)
            com.uc.crashsdk.a.g.a(r4)
            if (r7 == 0) goto L97
            r7.disconnect()     // Catch: java.lang.Throwable -> L97
        L97:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uc.crashsdk.a.c.a(java.lang.String, byte[]):byte[]");
    }

    public static void a(byte[] bArr, int i10, byte[] bArr2) {
        if (!f9607a && bArr2.length != 4) {
            throw new AssertionError();
        }
        for (int i11 = 0; i11 < 4; i11++) {
            bArr[i11 + i10] = bArr2[i11];
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v14 */
    /* JADX WARN: Type inference failed for: r1v2, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v5, types: [byte[]] */
    /* JADX WARN: Type inference failed for: r1v6 */
    private static byte[] a(File file) {
        FileInputStream fileInputStream;
        byte[] bArr;
        int length;
        BufferedInputStream bufferedInputStream;
        ?? r12 = 0;
        byte[] bArr2 = null;
        r1 = null;
        Closeable closeable = null;
        r12 = 0;
        try {
            if (!file.isFile()) {
                return null;
            }
            try {
                length = (int) file.length();
                fileInputStream = new FileInputStream(file);
                try {
                    bufferedInputStream = new BufferedInputStream(fileInputStream);
                } catch (Exception e10) {
                    e = e10;
                    bArr = null;
                }
            } catch (Exception e11) {
                e = e11;
                bArr = null;
                fileInputStream = null;
            } catch (Throwable th) {
                th = th;
                fileInputStream = null;
            }
            try {
                bArr2 = new byte[length];
                int i10 = 0;
                while (i10 < length) {
                    int read = bufferedInputStream.read(bArr2, i10, length - i10);
                    if (-1 == read) {
                        break;
                    }
                    i10 += read;
                }
                g.a(bufferedInputStream);
                g.a(fileInputStream);
                r12 = bArr2;
            } catch (Exception e12) {
                e = e12;
                byte[] bArr3 = bArr2;
                closeable = bufferedInputStream;
                bArr = bArr3;
                g.b(e);
                g.a(closeable);
                g.a(fileInputStream);
                r12 = bArr;
                return r12;
            } catch (Throwable th2) {
                th = th2;
                r12 = bufferedInputStream;
                g.a((Closeable) r12);
                g.a(fileInputStream);
                throw th;
            }
            return r12;
        } catch (Throwable th3) {
            th = th3;
        }
    }

    public static boolean a(File file, String str, String str2) {
        for (int i10 = 0; i10 < 2; i10++) {
            if (b(file, str, str2)) {
                return true;
            }
            a.a("crashsdk", "upload try again: " + str);
        }
        return false;
    }

    private static boolean a(byte[] bArr, String str, String str2) {
        InputStream inputStream;
        HttpURLConnection httpURLConnection;
        ByteArrayOutputStream byteArrayOutputStream;
        a.a("Uploading to " + str2);
        OutputStream outputStream = null;
        try {
            httpURLConnection = (HttpURLConnection) new URL(str2).openConnection();
            try {
                httpURLConnection.setConnectTimeout(10000);
                httpURLConnection.setReadTimeout(60000);
                httpURLConnection.setDoInput(true);
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setUseCaches(false);
                StringBuilder sb = new StringBuilder();
                sb.append("------------izQ290kHh6g3Yn2IeyJCoc\r\n");
                sb.append("Content-Disposition: form-data; name=\"file\";");
                sb.append(" filename=\"");
                sb.append(str);
                sb.append("\"\r\n");
                sb.append("Content-Type: application/octet-stream\r\n");
                sb.append("\r\n");
                int length = sb.length() + 40 + bArr.length;
                httpURLConnection.setRequestProperty("Content-Type", "multipart/form-data; boundary=----------izQ290kHh6g3Yn2IeyJCoc");
                httpURLConnection.setRequestProperty("Content-Disposition", "form-data; name=\"file\"; filename=" + str);
                httpURLConnection.setRequestProperty("Content-Length", String.valueOf(length));
                OutputStream outputStream2 = httpURLConnection.getOutputStream();
                try {
                    outputStream2.write(sb.toString().getBytes());
                    outputStream2.write(bArr);
                    outputStream2.write("\r\n------------izQ290kHh6g3Yn2IeyJCoc--\r\n".getBytes());
                    int responseCode = httpURLConnection.getResponseCode();
                    a.a("crashsdk", "Response code: " + responseCode);
                    if (responseCode != 200) {
                        g.a(outputStream2);
                        g.a((Closeable) null);
                        g.a((Closeable) null);
                        try {
                            httpURLConnection.disconnect();
                        } catch (Throwable unused) {
                        }
                        return false;
                    }
                    inputStream = httpURLConnection.getInputStream();
                    try {
                        byte[] bArr2 = new byte[1024];
                        byteArrayOutputStream = new ByteArrayOutputStream(inputStream.available());
                        while (true) {
                            try {
                                int read = inputStream.read(bArr2);
                                if (read == -1) {
                                    break;
                                }
                                byteArrayOutputStream.write(bArr2, 0, read);
                            } catch (Throwable th) {
                                th = th;
                                outputStream = outputStream2;
                                try {
                                    g.b(th);
                                    g.a(outputStream);
                                    g.a(inputStream);
                                    g.a(byteArrayOutputStream);
                                    if (httpURLConnection != null) {
                                        try {
                                            httpURLConnection.disconnect();
                                        } catch (Throwable unused2) {
                                        }
                                    }
                                    return false;
                                } catch (Throwable th2) {
                                    g.a(outputStream);
                                    g.a(inputStream);
                                    g.a(byteArrayOutputStream);
                                    if (httpURLConnection != null) {
                                        try {
                                            httpURLConnection.disconnect();
                                        } catch (Throwable unused3) {
                                        }
                                    }
                                    throw th2;
                                }
                            }
                        }
                        byte[] byteArray = byteArrayOutputStream.toByteArray();
                        if (byteArray != null) {
                            a.a("crashsdk", "Log upload response: " + new String(byteArray));
                            g.a(outputStream2);
                            g.a(inputStream);
                            g.a(byteArrayOutputStream);
                            try {
                                httpURLConnection.disconnect();
                            } catch (Throwable unused4) {
                            }
                            return true;
                        }
                        g.a(outputStream2);
                        g.a(inputStream);
                        g.a(byteArrayOutputStream);
                        try {
                            httpURLConnection.disconnect();
                        } catch (Throwable unused5) {
                        }
                        return false;
                    } catch (Throwable th3) {
                        th = th3;
                        byteArrayOutputStream = null;
                    }
                } catch (Throwable th4) {
                    th = th4;
                    inputStream = null;
                    byteArrayOutputStream = null;
                }
            } catch (Throwable th5) {
                th = th5;
                inputStream = null;
                byteArrayOutputStream = null;
            }
        } catch (Throwable th6) {
            th = th6;
            inputStream = null;
            httpURLConnection = null;
            byteArrayOutputStream = null;
        }
    }
}
