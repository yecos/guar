package com.alibaba.sdk.android.httpdns;

import com.umeng.analytics.pro.by;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;

/* loaded from: classes.dex */
public class m implements Callable<String[]> {

    /* renamed from: a, reason: collision with root package name */
    private static m f5912a;

    /* renamed from: d, reason: collision with root package name */
    private int f5913d;

    /* renamed from: d, reason: collision with other field name */
    private long f23d = 0;

    public static m a() {
        if (f5912a == null) {
            f5912a = new m();
        }
        return f5912a;
    }

    public void a(int i10) {
        this.f5913d = i10;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0127 A[Catch: all -> 0x0158, TRY_LEAVE, TryCatch #13 {all -> 0x0158, blocks: (B:54:0x0119, B:56:0x0127, B:58:0x012b, B:61:0x013e), top: B:53:0x0119, inners: #8 }] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0143 A[Catch: all -> 0x0170, TRY_ENTER, TRY_LEAVE, TryCatch #7 {, blocks: (B:3:0x0001, B:75:0x015b, B:85:0x0160, B:78:0x0168, B:83:0x016f, B:82:0x016c, B:64:0x0143, B:72:0x0148, B:67:0x0150, B:46:0x0154, B:44:0x010c, B:37:0x00fb, B:50:0x0100, B:40:0x0108), top: B:2:0x0001, inners: #11 }] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0150 A[Catch: IOException -> 0x014c, all -> 0x0170, TRY_LEAVE, TryCatch #4 {IOException -> 0x014c, blocks: (B:72:0x0148, B:67:0x0150), top: B:71:0x0148 }] */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0148 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:75:0x015b A[Catch: all -> 0x0170, TRY_ENTER, TRY_LEAVE, TryCatch #7 {, blocks: (B:3:0x0001, B:75:0x015b, B:85:0x0160, B:78:0x0168, B:83:0x016f, B:82:0x016c, B:64:0x0143, B:72:0x0148, B:67:0x0150, B:46:0x0154, B:44:0x010c, B:37:0x00fb, B:50:0x0100, B:40:0x0108), top: B:2:0x0001, inners: #11 }] */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0168 A[Catch: IOException -> 0x0164, all -> 0x0170, TRY_LEAVE, TryCatch #11 {IOException -> 0x0164, blocks: (B:85:0x0160, B:78:0x0168), top: B:84:0x0160, outer: #7 }] */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0160 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r1v14, types: [int] */
    /* JADX WARN: Type inference failed for: r1v17 */
    /* JADX WARN: Type inference failed for: r1v18 */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v6, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r1v7, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v12 */
    /* JADX WARN: Type inference failed for: r3v14 */
    /* JADX WARN: Type inference failed for: r3v16 */
    /* JADX WARN: Type inference failed for: r3v2 */
    /* JADX WARN: Type inference failed for: r3v21 */
    /* JADX WARN: Type inference failed for: r3v22 */
    /* JADX WARN: Type inference failed for: r3v4, types: [java.io.BufferedReader] */
    /* JADX WARN: Type inference failed for: r3v5, types: [java.io.BufferedReader] */
    /* JADX WARN: Type inference failed for: r3v9 */
    @Override // java.util.concurrent.Callable
    /* renamed from: a, reason: collision with other method in class and merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized String[] call() {
        ?? r32;
        Object obj;
        Throwable th;
        ?? r12;
        Exception exc;
        int i10;
        InputStream inputStream;
        BufferedReader bufferedReader;
        this.f23d = System.currentTimeMillis();
        HttpURLConnection httpURLConnection = null;
        try {
            final String m19d = n.a().m19d();
            if (m19d != null) {
                i.d("StartIp call start");
                HttpURLConnection httpURLConnection2 = (HttpURLConnection) new URL(m19d).openConnection();
                try {
                    httpURLConnection2.setConnectTimeout(by.f10132b);
                    httpURLConnection2.setReadTimeout(by.f10132b);
                    if (httpURLConnection2 instanceof HttpsURLConnection) {
                        ((HttpsURLConnection) httpURLConnection2).setHostnameVerifier(new HostnameVerifier() { // from class: com.alibaba.sdk.android.httpdns.m.1
                            @Override // javax.net.ssl.HostnameVerifier
                            public boolean verify(String str, SSLSession sSLSession) {
                                i.d("StartIp Https request, set hostnameVerifier. StartIp url：" + m19d);
                                return HttpsURLConnection.getDefaultHostnameVerifier().verify("203.107.1.1", sSLSession);
                            }
                        });
                    }
                    r12 = httpURLConnection2.getResponseCode();
                    r32 = 200;
                    r32 = 200;
                } catch (Exception e10) {
                    e = e10;
                    obj = null;
                    httpURLConnection = httpURLConnection2;
                    exc = e;
                    r12 = obj;
                    r32 = obj;
                    try {
                        i.a(exc);
                        n.a().c(exc);
                        i10 = this.f5913d;
                        if (i10 > 0) {
                        }
                        if (httpURLConnection != null) {
                        }
                        if (r12 != 0) {
                        }
                        if (r32 != 0) {
                        }
                        return new String[0];
                    } catch (Throwable th2) {
                        th = th2;
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                        }
                        if (r12 != 0) {
                            try {
                                r12.close();
                            } catch (IOException e11) {
                                i.a(e11);
                                throw th;
                            }
                        }
                        if (r32 != 0) {
                            r32.close();
                        }
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    r32 = 0;
                    httpURLConnection = httpURLConnection2;
                    th = th;
                    r12 = r32;
                    if (httpURLConnection != null) {
                    }
                    if (r12 != 0) {
                    }
                    if (r32 != 0) {
                    }
                    throw th;
                }
                try {
                    try {
                        if (r12 != 200) {
                            BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(httpURLConnection2.getErrorStream(), "UTF-8"));
                            StringBuilder sb = new StringBuilder();
                            while (true) {
                                String readLine = bufferedReader2.readLine();
                                if (readLine == null) {
                                    i.f("StartIp response code is " + httpURLConnection2.getResponseCode() + " expect 200. response body is " + sb.toString());
                                    g gVar = new g(httpURLConnection2.getResponseCode(), sb.toString());
                                    throw new h(gVar.getErrorCode(), gVar.b());
                                }
                                sb.append(readLine);
                            }
                        } else {
                            inputStream = httpURLConnection2.getInputStream();
                            bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
                            StringBuilder sb2 = new StringBuilder();
                            while (true) {
                                String readLine2 = bufferedReader.readLine();
                                if (readLine2 == null) {
                                    break;
                                }
                                sb2.append(readLine2);
                            }
                            n.a().a(new o(sb2.toString()), System.currentTimeMillis() - this.f23d);
                            httpURLConnection = httpURLConnection2;
                        }
                    } catch (Exception e12) {
                        r32 = 0;
                        httpURLConnection = httpURLConnection2;
                        exc = e12;
                        r12 = r12;
                        i.a(exc);
                        n.a().c(exc);
                        i10 = this.f5913d;
                        if (i10 > 0) {
                            this.f5913d = i10 - 1;
                            try {
                                j.a().schedule(new Runnable() { // from class: com.alibaba.sdk.android.httpdns.m.2
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        try {
                                            if (n.f24h) {
                                                return;
                                            }
                                            m.this.call();
                                        } catch (Exception e13) {
                                            i.a(e13);
                                        }
                                    }
                                }, 300000L, TimeUnit.MILLISECONDS);
                            } catch (Exception e13) {
                                i.a(e13);
                                if (httpURLConnection != null) {
                                    httpURLConnection.disconnect();
                                }
                                if (r12 != 0) {
                                    try {
                                        r12.close();
                                    } catch (IOException e14) {
                                        e = e14;
                                        i.a(e);
                                        return new String[0];
                                    }
                                }
                                if (r32 != 0) {
                                    r32.close();
                                }
                                return new String[0];
                            }
                        }
                        if (httpURLConnection != null) {
                        }
                        if (r12 != 0) {
                        }
                        if (r32 != 0) {
                        }
                        return new String[0];
                    } catch (Throwable th4) {
                        r32 = 0;
                        httpURLConnection = httpURLConnection2;
                        th = th4;
                        if (httpURLConnection != null) {
                        }
                        if (r12 != 0) {
                        }
                        if (r32 != 0) {
                        }
                        throw th;
                    }
                } catch (Exception e15) {
                    exc = e15;
                    httpURLConnection = httpURLConnection2;
                    r12 = r12;
                    i.a(exc);
                    n.a().c(exc);
                    i10 = this.f5913d;
                    if (i10 > 0) {
                    }
                    if (httpURLConnection != null) {
                    }
                    if (r12 != 0) {
                    }
                    if (r32 != 0) {
                    }
                    return new String[0];
                } catch (Throwable th5) {
                    th = th5;
                    httpURLConnection = httpURLConnection2;
                    if (httpURLConnection != null) {
                    }
                    if (r12 != 0) {
                    }
                    if (r32 != 0) {
                    }
                    throw th;
                }
            } else {
                inputStream = null;
                bufferedReader = null;
            }
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e16) {
                    e = e16;
                    i.a(e);
                    return new String[0];
                }
            }
            if (bufferedReader != null) {
                bufferedReader.close();
            }
        } catch (Exception e17) {
            e = e17;
            obj = null;
        } catch (Throwable th6) {
            th = th6;
            r32 = 0;
        }
        return new String[0];
    }
}
