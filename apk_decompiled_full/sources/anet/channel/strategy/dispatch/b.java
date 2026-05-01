package anet.channel.strategy.dispatch;

import android.text.TextUtils;
import android.util.Base64InputStream;
import anet.channel.AwcnConfig;
import anet.channel.GlobalAppRuntimeInfo;
import anet.channel.appmonitor.AppMonitor;
import anet.channel.entity.ENV;
import anet.channel.flow.FlowStat;
import anet.channel.flow.NetworkAnalysis;
import anet.channel.statist.AmdcStatistic;
import anet.channel.status.NetworkStatusHelper;
import anet.channel.strategy.ConnEvent;
import anet.channel.strategy.IConnStrategy;
import anet.channel.strategy.StrategyCenter;
import anet.channel.util.ALog;
import anet.channel.util.HttpConstant;
import anet.channel.util.j;
import com.hpplay.cybergarage.http.HTTP;
import com.hpplay.cybergarage.soap.SOAP;
import com.hpplay.cybergarage.xml.XML;
import com.hpplay.sdk.source.api.LelinkSourceSDK;
import com.taobao.accs.common.Constants;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.zip.GZIPInputStream;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

/* loaded from: classes.dex */
class b {

    /* renamed from: a, reason: collision with root package name */
    static AtomicInteger f4195a = new AtomicInteger(0);

    /* renamed from: b, reason: collision with root package name */
    static HostnameVerifier f4196b = new c();

    /* renamed from: c, reason: collision with root package name */
    static Random f4197c = new Random();

    public static List<IConnStrategy> a(String str) {
        List<IConnStrategy> list = Collections.EMPTY_LIST;
        if (!NetworkStatusHelper.isProxy()) {
            list = StrategyCenter.getInstance().getConnStrategyListByHost(DispatchConstants.getAmdcServerDomain());
            ListIterator<IConnStrategy> listIterator = list.listIterator();
            while (listIterator.hasNext()) {
                if (!listIterator.next().getProtocol().protocol.equalsIgnoreCase(str)) {
                    listIterator.remove();
                }
            }
        }
        return list;
    }

    public static void a(Map map) {
        String a10;
        IConnStrategy iConnStrategy;
        String str;
        if (map == null) {
            return;
        }
        String schemeByHost = AmdcRuntimeInfo.isForceHttps() ? "https" : StrategyCenter.getInstance().getSchemeByHost(DispatchConstants.getAmdcServerDomain(), HttpConstant.HTTP);
        List<IConnStrategy> a11 = a(schemeByHost);
        for (int i10 = 0; i10 < 3; i10++) {
            HashMap hashMap = new HashMap(map);
            if (i10 != 2) {
                iConnStrategy = !a11.isEmpty() ? a11.remove(0) : null;
                if (iConnStrategy != null) {
                    str = a(schemeByHost, iConnStrategy.getIp(), iConnStrategy.getPort(), hashMap, i10);
                } else {
                    str = a(schemeByHost, (String) null, 0, hashMap, i10);
                }
            } else {
                String[] amdcServerFixIp = DispatchConstants.getAmdcServerFixIp();
                if (amdcServerFixIp != null && amdcServerFixIp.length > 0) {
                    a10 = a(schemeByHost, amdcServerFixIp[f4197c.nextInt(amdcServerFixIp.length)], 0, hashMap, i10);
                } else {
                    a10 = a(schemeByHost, (String) null, 0, hashMap, i10);
                }
                String str2 = a10;
                iConnStrategy = null;
                str = str2;
            }
            int a12 = a(str, hashMap, i10);
            if (iConnStrategy != null) {
                ConnEvent connEvent = new ConnEvent();
                connEvent.isSuccess = a12 == 0;
                StrategyCenter.getInstance().notifyConnEvent(DispatchConstants.getAmdcServerDomain(), iConnStrategy, connEvent);
            }
            if (a12 == 0 || a12 == 2) {
                return;
            }
        }
    }

    private static String a(String str, String str2, int i10, Map<String, String> map, int i11) {
        StringBuilder sb = new StringBuilder(64);
        if (!AmdcRuntimeInfo.isForceHttps() && i11 == 2 && "https".equalsIgnoreCase(str) && f4197c.nextBoolean()) {
            str = HttpConstant.HTTP;
        }
        sb.append(str);
        sb.append(HttpConstant.SCHEME_SPLIT);
        if (str2 != null) {
            if (anet.channel.util.c.a() && anet.channel.strategy.utils.d.a(str2)) {
                try {
                    str2 = anet.channel.util.c.a(str2);
                } catch (Exception unused) {
                }
            }
            if (anet.channel.strategy.utils.d.b(str2)) {
                sb.append('[');
                sb.append(str2);
                sb.append(']');
            } else {
                sb.append(str2);
            }
            if (i10 == 0) {
                i10 = "https".equalsIgnoreCase(str) ? Constants.PORT : 80;
            }
            sb.append(SOAP.DELIM);
            sb.append(i10);
        } else {
            sb.append(DispatchConstants.getAmdcServerDomain());
        }
        sb.append(DispatchConstants.serverPath);
        TreeMap treeMap = new TreeMap();
        treeMap.put("appkey", map.remove("appkey"));
        treeMap.put("v", map.remove("v"));
        treeMap.put(DispatchConstants.PLATFORM, map.remove(DispatchConstants.PLATFORM));
        sb.append('?');
        sb.append(anet.channel.strategy.utils.d.a(treeMap, XML.CHARSET_UTF8));
        return sb.toString();
    }

    /* JADX WARN: Can't wrap try/catch for region: R(7:21|(5:26|27|28|29|30)|35|27|28|29|30) */
    /* JADX WARN: Can't wrap try/catch for region: R(7:38|(5:43|44|45|46|47)|51|44|45|46|47) */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0123, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0124, code lost:
    
        anet.channel.util.ALog.e("awcn.DispatchCore", "http disconnect failed", null, r0, new java.lang.Object[0]);
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x0166, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x0167, code lost:
    
        anet.channel.util.ALog.e("awcn.DispatchCore", "http disconnect failed", null, r0, new java.lang.Object[0]);
     */
    /* JADX WARN: Removed duplicated region for block: B:122:0x02a5 A[Catch: all -> 0x02e1, TryCatch #0 {all -> 0x02e1, blocks: (B:120:0x029b, B:122:0x02a5, B:123:0x02a9, B:126:0x02b1, B:128:0x02b5, B:130:0x02b9, B:132:0x02bd, B:133:0x02c7, B:142:0x02c3), top: B:119:0x029b }] */
    /* JADX WARN: Removed duplicated region for block: B:126:0x02b1 A[Catch: all -> 0x02e1, TRY_ENTER, TryCatch #0 {all -> 0x02e1, blocks: (B:120:0x029b, B:122:0x02a5, B:123:0x02a9, B:126:0x02b1, B:128:0x02b5, B:130:0x02b9, B:132:0x02bd, B:133:0x02c7, B:142:0x02c3), top: B:119:0x029b }] */
    /* JADX WARN: Removed duplicated region for block: B:136:0x02d3 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int a(String str, Map map, int i10) {
        URL url;
        HttpURLConnection httpURLConnection;
        String message;
        int i11;
        String str2;
        String str3;
        int i12;
        int i13;
        String str4 = "AMDC" + String.valueOf(f4195a.incrementAndGet());
        String str5 = "awcn.DispatchCore";
        ALog.i("awcn.DispatchCore", "send amdc request", str4, "url", str, "\nhost", map.get("domain").toString());
        ENV env = (ENV) map.remove("Env");
        try {
            url = new URL(str);
            try {
                httpURLConnection = (HttpURLConnection) url.openConnection();
                try {
                    httpURLConnection.setConnectTimeout(20000);
                    httpURLConnection.setReadTimeout(20000);
                    httpURLConnection.setRequestMethod("POST");
                    httpURLConnection.setDoOutput(true);
                    httpURLConnection.setDoInput(true);
                    httpURLConnection.addRequestProperty("Connection", HTTP.CLOSE);
                    httpURLConnection.addRequestProperty("Accept-Encoding", "gzip");
                    httpURLConnection.addRequestProperty("Host", DispatchConstants.getAmdcServerDomain());
                    httpURLConnection.setInstanceFollowRedirects(false);
                    if (url.getProtocol().equals("https")) {
                        ((HttpsURLConnection) httpURLConnection).setHostnameVerifier(f4196b);
                        if (AwcnConfig.isHttpsSniEnable()) {
                            ((HttpsURLConnection) httpURLConnection).setSSLSocketFactory(new j(DispatchConstants.getAmdcServerDomain()));
                        }
                    }
                    if (ALog.isPrintLog(1)) {
                        ALog.d("awcn.DispatchCore", "amdc request.", str4, "headers", httpURLConnection.getRequestProperties().toString());
                    }
                    httpURLConnection.getOutputStream().write(anet.channel.strategy.utils.d.a(map, XML.CHARSET_UTF8).getBytes());
                    int responseCode = httpURLConnection.getResponseCode();
                    if (ALog.isPrintLog(1)) {
                        ALog.d("awcn.DispatchCore", "amdc response. code: " + responseCode, str4, "\nheaders", httpURLConnection.getHeaderFields());
                    }
                    if (responseCode != 200) {
                        if (responseCode != 302 && responseCode != 307) {
                            i13 = 1;
                            a(String.valueOf(responseCode), "response code not 200", url, i10, i13);
                            httpURLConnection.disconnect();
                            return i13;
                        }
                        i13 = 2;
                        a(String.valueOf(responseCode), "response code not 200", url, i10, i13);
                        httpURLConnection.disconnect();
                        return i13;
                    }
                    String headerField = httpURLConnection.getHeaderField("x-am-code");
                    if (!"1000".equals(headerField)) {
                        if (!LelinkSourceSDK.FEEDBACK_PUSH_AV_ASYNC.equals(headerField) && !LelinkSourceSDK.FEEDBACK_PUSH_OTHER.equals(headerField)) {
                            i12 = 1;
                            a(headerField, "return code: " + headerField, url, i10, i12);
                            httpURLConnection.disconnect();
                            return i12;
                        }
                        i12 = 2;
                        a(headerField, "return code: " + headerField, url, i10, i12);
                        httpURLConnection.disconnect();
                        return i12;
                    }
                    String headerField2 = httpURLConnection.getHeaderField("x-am-sign");
                    if (TextUtils.isEmpty(headerField2)) {
                        a("-1001", "response sign is empty", url, i10, 1);
                        try {
                            httpURLConnection.disconnect();
                        } catch (Exception e10) {
                            ALog.e("awcn.DispatchCore", "http disconnect failed", null, e10, new Object[0]);
                        }
                        return 1;
                    }
                    String a10 = a(httpURLConnection.getInputStream(), "gzip".equalsIgnoreCase(httpURLConnection.getContentEncoding()));
                    if (ALog.isPrintLog(1)) {
                        ALog.d("awcn.DispatchCore", "amdc response body", str4, "\nbody", a10);
                    }
                    try {
                        a(str, r1.length, httpURLConnection.getContentLength());
                        if (TextUtils.isEmpty(a10)) {
                            a("-1002", "read answer error", url, i10, 1);
                            try {
                                httpURLConnection.disconnect();
                            } catch (Exception e11) {
                                ALog.e("awcn.DispatchCore", "http disconnect failed", null, e11, new Object[0]);
                            }
                            return 1;
                        }
                        str5 = "awcn.DispatchCore";
                        IAmdcSign sign = AmdcRuntimeInfo.getSign();
                        if (sign != null) {
                            str3 = sign.sign(a10);
                            str2 = headerField2;
                        } else {
                            str2 = headerField2;
                            str3 = null;
                        }
                        if (!str3.equalsIgnoreCase(str2)) {
                            ALog.e(str5, "check ret sign failed", str4, "retSign", str2, "checkSign", str3);
                            a("-1003", "check sign failed", url, i10, 1);
                            try {
                                httpURLConnection.disconnect();
                            } catch (Exception e12) {
                                ALog.e(str5, "http disconnect failed", null, e12, new Object[0]);
                            }
                            return 1;
                        }
                        try {
                            JSONObject jSONObject = (JSONObject) new JSONTokener(a10).nextValue();
                            if (GlobalAppRuntimeInfo.getEnv() != env) {
                                ALog.w(str5, "env change, do not notify result", str4, new Object[0]);
                                try {
                                    httpURLConnection.disconnect();
                                    return 0;
                                } catch (Exception e13) {
                                    ALog.e(str5, "http disconnect failed", null, e13, new Object[0]);
                                    return 0;
                                }
                            }
                            HttpDispatcher.getInstance().a(new DispatchEvent(1, jSONObject));
                            a(headerField, "request success", url, i10, 0);
                            try {
                                httpURLConnection.disconnect();
                            } catch (Exception e14) {
                                ALog.e(str5, "http disconnect failed", null, e14, new Object[0]);
                            }
                            return 0;
                        } catch (JSONException unused) {
                            HttpDispatcher.getInstance().a(new DispatchEvent(0, null));
                            ALog.e(str5, "resolve amdc anser failed", str4, new Object[0]);
                            a("-1004", "resolve answer failed", url, i10, 1);
                            try {
                                httpURLConnection.disconnect();
                            } catch (Exception e15) {
                                ALog.e(str5, "http disconnect failed", null, e15, new Object[0]);
                            }
                            return 1;
                        }
                    } catch (Throwable th) {
                        th = th;
                        str5 = "awcn.DispatchCore";
                        try {
                            message = th.getMessage();
                            if (TextUtils.isEmpty(message)) {
                                message = th.toString();
                            }
                            if (AmdcRuntimeInfo.isTimeoutRetryEnable() && ((th instanceof SocketTimeoutException) || (th instanceof ConnectException) || (th instanceof UnknownHostException))) {
                                a("-1000", message, url, i10, 2);
                                i11 = 2;
                            } else {
                                a("-1000", message, url, i10, 1);
                                i11 = 1;
                            }
                            ALog.i(str5, "amdc request fail", str4, th);
                            if (httpURLConnection != null) {
                                try {
                                    httpURLConnection.disconnect();
                                } catch (Exception e16) {
                                    ALog.e(str5, "http disconnect failed", null, e16, new Object[0]);
                                }
                            }
                            return i11;
                        } finally {
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    message = th.getMessage();
                    if (TextUtils.isEmpty(message)) {
                    }
                    if (AmdcRuntimeInfo.isTimeoutRetryEnable()) {
                    }
                    a("-1000", message, url, i10, 1);
                    i11 = 1;
                    ALog.i(str5, "amdc request fail", str4, th);
                    if (httpURLConnection != null) {
                    }
                    return i11;
                }
            } catch (Throwable th3) {
                th = th3;
                httpURLConnection = null;
                message = th.getMessage();
                if (TextUtils.isEmpty(message)) {
                }
                if (AmdcRuntimeInfo.isTimeoutRetryEnable()) {
                }
                a("-1000", message, url, i10, 1);
                i11 = 1;
                ALog.i(str5, "amdc request fail", str4, th);
                if (httpURLConnection != null) {
                }
                return i11;
            }
        } catch (Throwable th4) {
            th = th4;
            url = null;
        }
    }

    public static String a(InputStream inputStream, boolean z10) {
        IOException e10;
        FilterInputStream base64InputStream;
        FilterInputStream bufferedInputStream = new BufferedInputStream(inputStream);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(1024);
        try {
            if (z10) {
                try {
                    bufferedInputStream = new GZIPInputStream(bufferedInputStream);
                } catch (IOException e11) {
                    e10 = e11;
                    ALog.e("awcn.DispatchCore", "", null, e10, new Object[0]);
                    try {
                        bufferedInputStream.close();
                    } catch (IOException unused) {
                    }
                    return null;
                }
            }
            base64InputStream = new Base64InputStream(bufferedInputStream, 0);
        } catch (Throwable th) {
            th = th;
        }
        try {
            byte[] bArr = new byte[1024];
            while (true) {
                int read = base64InputStream.read(bArr);
                if (read == -1) {
                    break;
                }
                byteArrayOutputStream.write(bArr, 0, read);
            }
            String str = new String(byteArrayOutputStream.toByteArray(), XML.CHARSET_UTF8);
            try {
                base64InputStream.close();
            } catch (IOException unused2) {
            }
            return str;
        } catch (IOException e12) {
            e10 = e12;
            bufferedInputStream = base64InputStream;
            ALog.e("awcn.DispatchCore", "", null, e10, new Object[0]);
            bufferedInputStream.close();
            return null;
        } catch (Throwable th2) {
            th = th2;
            bufferedInputStream = base64InputStream;
            try {
                bufferedInputStream.close();
            } catch (IOException unused3) {
            }
            throw th;
        }
    }

    public static void a(String str, String str2, URL url, int i10, int i11) {
        if ((i11 != 1 || i10 == 2) && GlobalAppRuntimeInfo.isTargetProcess()) {
            try {
                AmdcStatistic amdcStatistic = new AmdcStatistic();
                amdcStatistic.errorCode = str;
                amdcStatistic.errorMsg = str2;
                if (url != null) {
                    amdcStatistic.host = url.getHost();
                    amdcStatistic.url = url.toString();
                }
                amdcStatistic.retryTimes = i10;
                AppMonitor.getInstance().commitStat(amdcStatistic);
            } catch (Exception unused) {
            }
        }
    }

    public static void a(String str, long j10, long j11) {
        try {
            FlowStat flowStat = new FlowStat();
            flowStat.refer = "amdc";
            flowStat.protocoltype = HttpConstant.HTTP;
            flowStat.req_identifier = str;
            flowStat.upstream = j10;
            flowStat.downstream = j11;
            NetworkAnalysis.getInstance().commitFlow(flowStat);
        } catch (Exception e10) {
            ALog.e("awcn.DispatchCore", "commit flow info failed!", null, e10, new Object[0]);
        }
    }
}
