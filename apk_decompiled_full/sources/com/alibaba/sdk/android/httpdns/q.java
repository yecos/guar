package com.alibaba.sdk.android.httpdns;

import android.content.Context;
import android.net.TrafficStats;
import com.hpplay.cybergarage.soap.SOAP;
import com.raizlabs.android.dbflow.sql.language.Operator;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;

/* loaded from: classes.dex */
class q implements Callable<String[]> {

    /* renamed from: a, reason: collision with root package name */
    private static Context f5951a;

    /* renamed from: a, reason: collision with other field name */
    private s f37a;

    /* renamed from: d, reason: collision with root package name */
    private int f5952d;

    /* renamed from: d, reason: collision with other field name */
    private long f38d;

    /* renamed from: e, reason: collision with root package name */
    private String[] f5953e;
    private Map<String, String> extra;
    private String hostName;

    /* renamed from: j, reason: collision with root package name */
    private boolean f5954j;

    /* renamed from: k, reason: collision with root package name */
    private String f5955k;

    /* renamed from: l, reason: collision with root package name */
    private String f5956l;
    private static d hostManager = d.a();

    /* renamed from: a, reason: collision with other field name */
    private static final Object f36a = new Object();

    public q(String str, s sVar) {
        this.f5952d = 1;
        this.f5955k = null;
        this.f5953e = f.f20c;
        this.f5954j = false;
        this.f5956l = null;
        this.extra = new HashMap();
        this.f38d = 0L;
        this.hostName = str;
        this.f37a = sVar;
    }

    private boolean d(String str) {
        return str.matches("[a-zA-Z0-9\\-_]+");
    }

    private boolean e(String str) {
        return str.matches("[a-zA-Z0-9\\-_=]+");
    }

    private String getExtra() {
        boolean z10;
        StringBuilder sb = new StringBuilder();
        Map<String, String> map = this.extra;
        boolean z11 = true;
        if (map != null) {
            z10 = true;
            for (Map.Entry<String, String> entry : map.entrySet()) {
                sb.append("&sdns-");
                sb.append(entry.getKey());
                sb.append(Operator.Operation.EQUALS);
                sb.append(URLEncoder.encode(entry.getValue(), "UTF-8"));
                if (!d(entry.getKey())) {
                    i.f("设置自定义参数失败，自定义key不合法：" + entry.getKey());
                    z11 = false;
                }
                if (!e(entry.getValue())) {
                    i.f("设置自定义参数失败，自定义value不合法：" + entry.getValue());
                    z10 = false;
                }
            }
        } else {
            z10 = true;
        }
        if (z11 && z10) {
            String sb2 = sb.toString();
            if (sb2.getBytes("UTF-8").length <= 1000) {
                return sb2;
            }
            i.f("设置自定义参数失败，自定义参数过长");
        }
        return "";
    }

    public static void setContext(Context context) {
        f5951a = context;
    }

    public void a(int i10) {
        if (i10 >= 0) {
            this.f5952d = i10;
        }
    }

    public q(String str, s sVar, Map<String, String> map, String str2) {
        this.f5952d = 1;
        this.f5955k = null;
        this.f5953e = f.f20c;
        this.f5954j = false;
        this.f5956l = null;
        HashMap hashMap = new HashMap();
        this.extra = hashMap;
        this.f38d = 0L;
        this.hostName = str;
        this.f37a = sVar;
        this.f5956l = str2;
        hashMap.putAll(map);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:75:0x03bd A[Catch: all -> 0x03ea, TryCatch #5 {all -> 0x03ea, blocks: (B:73:0x03af, B:75:0x03bd, B:82:0x03c4), top: B:72:0x03af }] */
    /* JADX WARN: Removed duplicated region for block: B:77:0x03cc  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x03d1 A[Catch: IOException -> 0x03d5, TRY_ENTER, TryCatch #2 {IOException -> 0x03d5, blocks: (B:26:0x038a, B:28:0x038f, B:79:0x03d1, B:81:0x03d9), top: B:19:0x0049 }] */
    /* JADX WARN: Removed duplicated region for block: B:81:0x03d9 A[Catch: IOException -> 0x03d5, TRY_LEAVE, TryCatch #2 {IOException -> 0x03d5, blocks: (B:26:0x038a, B:28:0x038f, B:79:0x03d1, B:81:0x03d9), top: B:19:0x0049 }] */
    /* JADX WARN: Removed duplicated region for block: B:82:0x03c4 A[Catch: all -> 0x03ea, TRY_LEAVE, TryCatch #5 {all -> 0x03ea, blocks: (B:73:0x03af, B:75:0x03bd, B:82:0x03c4), top: B:72:0x03af }] */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r3v43 */
    /* JADX WARN: Type inference failed for: r3v64 */
    /* JADX WARN: Type inference failed for: r3v65 */
    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r4v1, types: [java.io.BufferedReader] */
    /* JADX WARN: Type inference failed for: r4v3 */
    /* JADX WARN: Type inference failed for: r4v4 */
    /* JADX WARN: Type inference failed for: r4v6 */
    @Override // java.util.concurrent.Callable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String[] call() {
        ?? r32;
        ?? r42;
        int i10;
        StringBuilder sb;
        String sb2;
        int responseCode;
        InputStream inputStream;
        BufferedReader bufferedReader;
        StringBuilder sb3;
        this.f38d = System.currentTimeMillis();
        if (!this.f5954j) {
            synchronized (f36a) {
                if (hostManager.m11a(this.hostName)) {
                    i.d("host:" + this.hostName + " is already resolving");
                    return this.f5953e;
                }
                hostManager.m9a(this.hostName);
                this.f5954j = true;
            }
        }
        HttpURLConnection httpURLConnection = null;
        try {
            try {
                TrafficStats.setThreadStatsTag(40965);
                String a10 = u.a(this.f37a);
                this.f5955k = a10;
                if (a10 == null) {
                    i.d("serverIp is null, give up query for hostname:" + this.hostName);
                    inputStream = null;
                    bufferedReader = null;
                } else {
                    com.alibaba.sdk.android.httpdns.c.a.a().c(f5951a);
                    if (a.a()) {
                        String timestamp = a.getTimestamp();
                        if (com.alibaba.sdk.android.httpdns.c.a.a().h()) {
                            sb3 = new StringBuilder();
                            sb3.append(f.PROTOCOL);
                            sb3.append(this.f5955k);
                            sb3.append(SOAP.DELIM);
                            sb3.append(f.f5904d);
                            sb3.append(Operator.Operation.DIVISION);
                            sb3.append(f.f5903c);
                            sb3.append("/sign_d?host=");
                            sb3.append(this.hostName);
                            sb3.append("&sdk=android_");
                            sb3.append("1.3.2.3-no-bssid-ssid");
                            sb3.append("&t=");
                            sb3.append(timestamp);
                            sb3.append("&s=");
                            sb3.append(a.a(this.hostName, timestamp));
                            sb3.append("&sid=");
                            sb3.append(com.alibaba.sdk.android.httpdns.e.a.a().getSessionId());
                            sb3.append("&net=");
                            sb3.append(com.alibaba.sdk.android.httpdns.e.a.a().l());
                            sb3.append(getExtra());
                        } else {
                            sb3 = new StringBuilder();
                            sb3.append(f.PROTOCOL);
                            sb3.append(this.f5955k);
                            sb3.append(SOAP.DELIM);
                            sb3.append(f.f5904d);
                            sb3.append(Operator.Operation.DIVISION);
                            sb3.append(f.f5903c);
                            sb3.append("/sign_d?host=");
                            sb3.append(this.hostName);
                            sb3.append("&sdk=android_");
                            sb3.append("1.3.2.3-no-bssid-ssid");
                            sb3.append("&t=");
                            sb3.append(timestamp);
                            sb3.append("&s=");
                            sb3.append(a.a(this.hostName, timestamp));
                            sb3.append("&sid=");
                            sb3.append(com.alibaba.sdk.android.httpdns.e.a.a().getSessionId());
                            sb3.append("&net=");
                            sb3.append(com.alibaba.sdk.android.httpdns.e.a.a().l());
                            sb3.append(getExtra());
                        }
                        sb2 = sb3.toString();
                    } else {
                        if (com.alibaba.sdk.android.httpdns.c.a.a().h()) {
                            sb = new StringBuilder();
                            sb.append(f.PROTOCOL);
                            sb.append(this.f5955k);
                            sb.append(SOAP.DELIM);
                            sb.append(f.f5904d);
                            sb.append(Operator.Operation.DIVISION);
                            sb.append(f.f5903c);
                            sb.append("/d?host=");
                            sb.append(this.hostName);
                            sb.append("&sdk=android_");
                            sb.append("1.3.2.3-no-bssid-ssid");
                            sb.append("&sid=");
                            sb.append(com.alibaba.sdk.android.httpdns.e.a.a().getSessionId());
                            sb.append("&net=");
                            sb.append(com.alibaba.sdk.android.httpdns.e.a.a().l());
                            sb.append(getExtra());
                        } else {
                            sb = new StringBuilder();
                            sb.append(f.PROTOCOL);
                            sb.append(this.f5955k);
                            sb.append(SOAP.DELIM);
                            sb.append(f.f5904d);
                            sb.append(Operator.Operation.DIVISION);
                            sb.append(f.f5903c);
                            sb.append("/d?host=");
                            sb.append(this.hostName);
                            sb.append("&sdk=android_");
                            sb.append("1.3.2.3-no-bssid-ssid");
                            sb.append("&sid=");
                            sb.append(com.alibaba.sdk.android.httpdns.e.a.a().getSessionId());
                            sb.append("&net=");
                            sb.append(com.alibaba.sdk.android.httpdns.e.a.a().l());
                            sb.append(getExtra());
                        }
                        sb2 = sb.toString();
                    }
                    if (com.alibaba.sdk.android.httpdns.net64.a.a().m20a()) {
                        sb2 = sb2 + "&query=4,6";
                    }
                    i.f("resolve url: " + sb2);
                    HttpURLConnection httpURLConnection2 = (HttpURLConnection) new URL(sb2).openConnection();
                    try {
                        httpURLConnection2.setConnectTimeout(f.f5901a);
                        httpURLConnection2.setReadTimeout(f.f5901a);
                        if (httpURLConnection2 instanceof HttpsURLConnection) {
                            ((HttpsURLConnection) httpURLConnection2).setHostnameVerifier(new HostnameVerifier() { // from class: com.alibaba.sdk.android.httpdns.q.1
                                @Override // javax.net.ssl.HostnameVerifier
                                public boolean verify(String str, SSLSession sSLSession) {
                                    i.d("Https request, set hostnameVerifier");
                                    return HttpsURLConnection.getDefaultHostnameVerifier().verify("203.107.1.1", sSLSession);
                                }
                            });
                        }
                        responseCode = httpURLConnection2.getResponseCode();
                        r42 = 200;
                    } catch (Throwable th) {
                        r42 = 0;
                        httpURLConnection = httpURLConnection2;
                        th = th;
                        r32 = 0;
                    }
                    try {
                        try {
                            if (responseCode != 200) {
                                BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(httpURLConnection2.getErrorStream(), "UTF-8"));
                                StringBuilder sb4 = new StringBuilder();
                                while (true) {
                                    String readLine = bufferedReader2.readLine();
                                    if (readLine == null) {
                                        i.f("response code is " + httpURLConnection2.getResponseCode() + " expect 200. response body is " + sb4.toString());
                                        throw new h(httpURLConnection2.getResponseCode(), new g(httpURLConnection2.getResponseCode(), sb4.toString()).b());
                                    }
                                    sb4.append(readLine);
                                }
                            } else {
                                inputStream = httpURLConnection2.getInputStream();
                                bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
                                StringBuilder sb5 = new StringBuilder();
                                while (true) {
                                    String readLine2 = bufferedReader.readLine();
                                    if (readLine2 == null) {
                                        break;
                                    }
                                    sb5.append(readLine2);
                                }
                                i.d("resolve host: " + this.hostName + ", return: " + sb5.toString());
                                e eVar = new e(sb5.toString());
                                eVar.setCacheKey(this.f5956l);
                                if (hostManager.count() >= 100) {
                                    throw new Exception("the total number of hosts is exceed 100");
                                }
                                hostManager.m10a(this.hostName, eVar);
                                u.a(this.hostName, this.f5955k, System.currentTimeMillis() - this.f38d);
                                hostManager.b(this.hostName);
                                this.f5953e = eVar.getIps();
                                this.extra = eVar.m15a();
                                httpURLConnection = httpURLConnection2;
                            }
                        } catch (Throwable th2) {
                            httpURLConnection = httpURLConnection2;
                            th = th2;
                            r42 = 0;
                            r32 = responseCode;
                            try {
                                i.a(th);
                                u.a(this.hostName, this.f5955k, th);
                                i10 = this.f5952d;
                                if (i10 <= 0) {
                                    this.f5952d = i10 - 1;
                                    call();
                                } else {
                                    u.reportHttpDnsSuccess(this.hostName, 0);
                                }
                                if (httpURLConnection != null) {
                                    httpURLConnection.disconnect();
                                }
                                if (r32 != 0) {
                                    r32.close();
                                }
                                if (r42 != 0) {
                                    r42.close();
                                }
                                hostManager.b(this.hostName);
                                return this.f5953e;
                            } catch (Throwable th3) {
                                if (httpURLConnection != null) {
                                    httpURLConnection.disconnect();
                                }
                                if (r32 != 0) {
                                    try {
                                        r32.close();
                                    } catch (IOException e10) {
                                        i.a(e10);
                                        throw th3;
                                    }
                                }
                                if (r42 != 0) {
                                    r42.close();
                                }
                                throw th3;
                            }
                        }
                    } catch (Throwable th4) {
                        httpURLConnection = httpURLConnection2;
                        th = th4;
                        r32 = responseCode;
                        i.a(th);
                        u.a(this.hostName, this.f5955k, th);
                        i10 = this.f5952d;
                        if (i10 <= 0) {
                        }
                        if (httpURLConnection != null) {
                        }
                        if (r32 != 0) {
                        }
                        if (r42 != 0) {
                        }
                        hostManager.b(this.hostName);
                        return this.f5953e;
                    }
                }
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                if (inputStream != null) {
                    inputStream.close();
                }
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
            } catch (IOException e11) {
                i.a(e11);
            }
        } catch (Throwable th5) {
            th = th5;
            r32 = 0;
            r42 = 0;
        }
        hostManager.b(this.hostName);
        return this.f5953e;
    }
}
