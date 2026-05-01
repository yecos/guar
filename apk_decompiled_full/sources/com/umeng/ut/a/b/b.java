package com.umeng.ut.a.b;

import android.content.Context;
import android.text.TextUtils;
import com.umeng.commonsdk.utils.UMUtils;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLEncoder;
import javax.net.ssl.HttpsURLConnection;

/* loaded from: classes3.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private static d f12353a;

    /* renamed from: a, reason: collision with other field name */
    private static e f58a;

    static {
        System.setProperty("http.keepAlive", "true");
        f58a = null;
        f12353a = null;
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x0239 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:109:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0215  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static a a(String str, String str2, boolean z10) {
        DataOutputStream dataOutputStream;
        Throwable th;
        DataInputStream dataInputStream;
        a aVar = new a();
        if (TextUtils.isEmpty(str)) {
            return aVar;
        }
        Context m69a = com.umeng.ut.a.a.a().m69a();
        String appkey = UMUtils.getAppkey(m69a);
        if (TextUtils.isEmpty(appkey)) {
            return aVar;
        }
        try {
            URL url = new URL(str);
            if (TextUtils.isEmpty(url.getHost())) {
                return aVar;
            }
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            if (httpURLConnection instanceof HttpsURLConnection) {
                if (f58a == null) {
                    f58a = new e(url.getHost());
                }
                if (f12353a == null) {
                    f12353a = new d(url.getHost());
                }
                ((HttpsURLConnection) httpURLConnection).setSSLSocketFactory(f58a);
                ((HttpsURLConnection) httpURLConnection).setHostnameVerifier(f12353a);
            }
            if (httpURLConnection != null) {
                httpURLConnection.setDoInput(true);
                if (z10) {
                    httpURLConnection.setDoOutput(true);
                    try {
                        httpURLConnection.setRequestMethod("POST");
                    } catch (ProtocolException e10) {
                        com.umeng.ut.a.c.e.a("", e10, new Object[0]);
                        return aVar;
                    }
                } else {
                    try {
                        httpURLConnection.setRequestMethod("GET");
                    } catch (ProtocolException e11) {
                        com.umeng.ut.a.c.e.a("", e11, new Object[0]);
                    }
                }
                httpURLConnection.setUseCaches(false);
                httpURLConnection.setConnectTimeout(10000);
                httpURLConnection.setReadTimeout(10000);
                httpURLConnection.setInstanceFollowRedirects(true);
                httpURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
                httpURLConnection.setRequestProperty("Charset", "UTF-8");
                StringBuilder sb = new StringBuilder();
                httpURLConnection.setRequestProperty("x-audid-appkey", appkey);
                sb.append(appkey);
                String packageName = m69a.getPackageName();
                if (!TextUtils.isEmpty(packageName)) {
                    try {
                        httpURLConnection.setRequestProperty("x-audid-appname", URLEncoder.encode(packageName, "UTF-8"));
                        sb.append(packageName);
                    } catch (Exception unused) {
                    }
                }
                httpURLConnection.setRequestProperty("x-audid-sdk", "1.0.0");
                sb.append("1.0.0");
                String m70a = com.umeng.ut.a.a.a().m70a();
                httpURLConnection.setRequestProperty("x-audid-timestamp", m70a);
                com.umeng.ut.a.c.e.m72a("", "timestamp:" + m70a);
                sb.append(m70a);
                sb.append(str2);
                httpURLConnection.setRequestProperty(com.umeng.ccg.a.f10664x, com.umeng.ut.b.a.a.a.a(com.umeng.ut.a.c.b.c(sb.toString()).getBytes(), 2));
                long currentTimeMillis = System.currentTimeMillis();
                DataOutputStream dataOutputStream2 = null;
                DataInputStream dataInputStream2 = null;
                DataInputStream dataInputStream3 = null;
                try {
                    httpURLConnection.connect();
                    if (str2 == null || str2.length() <= 0) {
                        dataOutputStream = null;
                    } else {
                        dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
                        try {
                            dataOutputStream.writeBytes(str2);
                            dataOutputStream.flush();
                        } catch (Throwable th2) {
                            th = th2;
                            dataOutputStream2 = dataOutputStream;
                            try {
                                com.umeng.ut.a.c.e.m72a("", th);
                                aVar.f12352b = System.currentTimeMillis() - currentTimeMillis;
                                if (dataOutputStream2 != null) {
                                    try {
                                        dataOutputStream2.close();
                                    } catch (IOException e12) {
                                        com.umeng.ut.a.c.e.m72a("", e12);
                                    }
                                }
                                return aVar;
                            } finally {
                            }
                        }
                    }
                    if (dataOutputStream != null) {
                        try {
                            dataOutputStream.close();
                        } catch (IOException e13) {
                            com.umeng.ut.a.c.e.m72a("", e13);
                        }
                    }
                    try {
                        aVar.f12351a = httpURLConnection.getResponseCode();
                        aVar.signature = httpURLConnection.getHeaderField(com.umeng.ccg.a.f10664x);
                    } catch (Exception e14) {
                        com.umeng.ut.a.c.e.m72a("", e14);
                    }
                    try {
                        aVar.timestamp = Long.parseLong(httpURLConnection.getHeaderField("x-audid-timestamp"));
                        com.umeng.ut.a.c.e.m72a("", "repsonse.timestamp:" + aVar.timestamp);
                        long m68a = com.umeng.ut.a.a.a().m68a();
                        long j10 = aVar.timestamp;
                        if (j10 > 0 && (j10 > m68a + 1800000 || j10 < m68a - 1800000)) {
                            com.umeng.ut.a.a.a().a(aVar.timestamp);
                        }
                    } catch (Exception unused2) {
                    }
                    aVar.f12352b = System.currentTimeMillis() - currentTimeMillis;
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    try {
                        try {
                            dataInputStream = new DataInputStream(httpURLConnection.getInputStream());
                        } catch (Throwable th3) {
                            th = th3;
                            if (dataInputStream2 != null) {
                                throw th;
                            }
                            try {
                                dataInputStream2.close();
                                throw th;
                            } catch (Exception e15) {
                                com.umeng.ut.a.c.e.m72a("", e15);
                                throw th;
                            }
                        }
                    } catch (IOException e16) {
                        e = e16;
                    }
                    try {
                        try {
                            byte[] bArr = new byte[2048];
                            while (true) {
                                int read = dataInputStream.read(bArr, 0, 2048);
                                if (read != -1) {
                                    byteArrayOutputStream.write(bArr, 0, read);
                                } else {
                                    try {
                                        break;
                                    } catch (Exception e17) {
                                        com.umeng.ut.a.c.e.m72a("", e17);
                                    }
                                }
                            }
                            dataInputStream.close();
                        } catch (IOException e18) {
                            e = e18;
                            dataInputStream3 = dataInputStream;
                            com.umeng.ut.a.c.e.m72a("", e);
                            try {
                                dataInputStream = new DataInputStream(httpURLConnection.getErrorStream());
                            } catch (Exception e19) {
                                e = e19;
                            }
                            try {
                                byte[] bArr2 = new byte[2048];
                                while (true) {
                                    int read2 = dataInputStream.read(bArr2, 0, 2048);
                                    if (read2 != -1) {
                                        byteArrayOutputStream.write(bArr2, 0, read2);
                                    } else {
                                        try {
                                            break;
                                        } catch (Exception e20) {
                                            com.umeng.ut.a.c.e.m72a("", e20);
                                        }
                                    }
                                }
                                dataInputStream.close();
                                if (byteArrayOutputStream.size() > 0) {
                                }
                                return aVar;
                            } catch (Exception e21) {
                                e = e21;
                                dataInputStream3 = dataInputStream;
                                com.umeng.ut.a.c.e.m72a("", e);
                                if (dataInputStream3 != null) {
                                    try {
                                        dataInputStream3.close();
                                    } catch (Exception e22) {
                                        com.umeng.ut.a.c.e.m72a("", e22);
                                    }
                                }
                                return aVar;
                            }
                        }
                        if (byteArrayOutputStream.size() > 0) {
                            aVar.data = byteArrayOutputStream.toByteArray();
                        }
                    } catch (Throwable th4) {
                        th = th4;
                        dataInputStream2 = dataInputStream;
                        if (dataInputStream2 != null) {
                        }
                    }
                } catch (Throwable th5) {
                    th = th5;
                }
            }
            return aVar;
        } catch (MalformedURLException e23) {
            com.umeng.ut.a.c.e.a("", e23, new Object[0]);
            return aVar;
        } catch (IOException e24) {
            com.umeng.ut.a.c.e.a("", e24, new Object[0]);
            return aVar;
        } catch (Throwable th6) {
            com.umeng.ut.a.c.e.a("", th6, new Object[0]);
            return aVar;
        }
    }
}
