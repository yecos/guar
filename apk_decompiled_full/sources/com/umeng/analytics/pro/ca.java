package com.umeng.analytics.pro;

import android.text.TextUtils;
import com.umeng.commonsdk.statistics.common.HelperUtils;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.UnknownHostException;
import java.security.SecureRandom;
import java.util.Map;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLSession;

/* loaded from: classes3.dex */
public class ca {

    /* renamed from: a, reason: collision with root package name */
    private static final String f10154a = "HttpClient";

    /* renamed from: f, reason: collision with root package name */
    private static HostnameVerifier f10155f;

    /* renamed from: b, reason: collision with root package name */
    private String f10156b;

    /* renamed from: c, reason: collision with root package name */
    private a f10157c;

    /* renamed from: d, reason: collision with root package name */
    private Map<String, String> f10158d;

    /* renamed from: e, reason: collision with root package name */
    private cb f10159e;

    public enum a {
        POST,
        GET
    }

    public ca(String str, a aVar, Map<String, String> map, cb cbVar) {
        this.f10156b = str;
        this.f10157c = aVar;
        this.f10158d = map;
        this.f10159e = cbVar;
    }

    private static HostnameVerifier a() {
        if (f10155f == null) {
            f10155f = new HostnameVerifier() { // from class: com.umeng.analytics.pro.ca.1
                @Override // javax.net.ssl.HostnameVerifier
                public boolean verify(String str, SSLSession sSLSession) {
                    return !TextUtils.isEmpty(str) && by.f10131a.equalsIgnoreCase(str);
                }
            };
        }
        return f10155f;
    }

    /* JADX WARN: Code restructure failed: missing block: B:50:0x00ef, code lost:
    
        if (r1 == null) goto L62;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x00ea, code lost:
    
        if (r1 == null) goto L62;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x00e5, code lost:
    
        if (r1 == null) goto L62;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x00e0, code lost:
    
        if (r1 == null) goto L62;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x00db, code lost:
    
        if (r1 == null) goto L62;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x00d6, code lost:
    
        if (r1 == null) goto L62;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String a(int i10, String str) {
        HttpsURLConnection httpsURLConnection;
        try {
            httpsURLConnection = (HttpsURLConnection) new URL(this.f10156b).openConnection();
            try {
                SSLContext sSLContext = SSLContext.getInstance("TLS");
                sSLContext.init(null, null, new SecureRandom());
                httpsURLConnection.setSSLSocketFactory(sSLContext.getSocketFactory());
                httpsURLConnection.setHostnameVerifier(a());
                Map<String, String> map = this.f10158d;
                if (map != null && !map.isEmpty()) {
                    for (String str2 : this.f10158d.keySet()) {
                        if (!TextUtils.isEmpty(str2)) {
                            httpsURLConnection.setRequestProperty(str2, this.f10158d.get(str2));
                        }
                    }
                }
                httpsURLConnection.setConnectTimeout(i10);
                httpsURLConnection.setReadTimeout(i10);
                if (this.f10157c == a.POST) {
                    httpsURLConnection.setRequestMethod("POST");
                    httpsURLConnection.setDoOutput(true);
                    httpsURLConnection.setDoInput(true);
                    httpsURLConnection.setDefaultUseCaches(false);
                    if (!TextUtils.isEmpty(str)) {
                        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(httpsURLConnection.getOutputStream());
                        outputStreamWriter.write(str);
                        outputStreamWriter.flush();
                        outputStreamWriter.close();
                    }
                    httpsURLConnection.connect();
                } else {
                    httpsURLConnection.setRequestMethod("GET");
                }
                if (httpsURLConnection.getResponseCode() == 200) {
                    InputStream inputStream = httpsURLConnection.getInputStream();
                    byte[] readStreamToByteArray = HelperUtils.readStreamToByteArray(inputStream);
                    String str3 = "";
                    if (readStreamToByteArray != null) {
                        try {
                            if (readStreamToByteArray.length > 1) {
                                str3 = new String(readStreamToByteArray);
                            }
                        } finally {
                            HelperUtils.safeClose(inputStream);
                        }
                    }
                    cb cbVar = this.f10159e;
                    if (cbVar != null) {
                        cbVar.a(str3);
                    }
                    httpsURLConnection.disconnect();
                    return str3;
                }
            } catch (MalformedURLException unused) {
            } catch (SocketTimeoutException unused2) {
            } catch (UnknownHostException unused3) {
            } catch (SSLHandshakeException unused4) {
            } catch (IOException unused5) {
            } catch (Throwable unused6) {
            }
        } catch (MalformedURLException unused7) {
            httpsURLConnection = null;
        } catch (SocketTimeoutException unused8) {
            httpsURLConnection = null;
        } catch (UnknownHostException unused9) {
            httpsURLConnection = null;
        } catch (SSLHandshakeException unused10) {
            httpsURLConnection = null;
        } catch (IOException unused11) {
            httpsURLConnection = null;
        } catch (Throwable unused12) {
            httpsURLConnection = null;
        }
        httpsURLConnection.disconnect();
        return null;
    }
}
