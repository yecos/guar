package anet.channel.session;

import android.os.Build;
import android.util.Pair;
import anet.channel.RequestCb;
import anet.channel.appmonitor.AppMonitor;
import anet.channel.bytes.ByteArray;
import anet.channel.bytes.a;
import anet.channel.request.Request;
import anet.channel.statist.ExceptionStatistic;
import anet.channel.status.NetworkStatusHelper;
import anet.channel.util.ALog;
import anet.channel.util.ErrorConstant;
import anet.channel.util.HttpConstant;
import anet.channel.util.StringUtils;
import com.hpplay.cybergarage.soap.SOAP;
import com.taobao.accs.common.Constants;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CancellationException;
import java.util.zip.GZIPInputStream;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocketFactory;

/* loaded from: classes.dex */
public class b {

    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public int f4101a;

        /* renamed from: b, reason: collision with root package name */
        public byte[] f4102b;

        /* renamed from: c, reason: collision with root package name */
        public Map<String, List<String>> f4103c;

        /* renamed from: d, reason: collision with root package name */
        public int f4104d;

        /* renamed from: e, reason: collision with root package name */
        public boolean f4105e;
    }

    private b() {
    }

    /* JADX WARN: Can't wrap try/catch for region: R(14:8|(6:9|10|(2:128|129)|12|13|(3:14|15|16))|(3:17|18|19)|(4:20|21|(1:94)(2:25|(8:27|28|29|30|31|32|34|35)(3:58|59|60))|61)|(11:72|(1:74)|(1:76)|77|78|79|(1:81)|(1:83)|85|86|49)|92|78|79|(0)|(0)|85|86|49|6) */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x026b, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x026c, code lost:
    
        anet.channel.util.ALog.e("awcn.HttpConnector", "http disconnect", null, r0, new java.lang.Object[0]);
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x0220, code lost:
    
        r22.onResponseCode(r10.f4101a, r10.f4103c);
     */
    /* JADX WARN: Removed duplicated region for block: B:100:0x03cf A[Catch: all -> 0x028e, TRY_LEAVE, TryCatch #21 {all -> 0x028e, blocks: (B:10:0x0033, B:129:0x003d, B:12:0x00a3, B:15:0x00a8, B:18:0x00b1, B:21:0x00b7, B:23:0x0119, B:25:0x0123, B:27:0x0129, B:30:0x0132, B:41:0x0296, B:43:0x029c, B:44:0x02a3, B:46:0x02ab, B:47:0x02bf, B:56:0x02ba, B:60:0x0196, B:61:0x01ad, B:63:0x01cf, B:72:0x01e2, B:74:0x01fd, B:76:0x020b, B:77:0x0212, B:78:0x022f, B:81:0x0246, B:83:0x025f, B:91:0x0220, B:92:0x0227, B:109:0x033c, B:111:0x0367, B:98:0x03a4, B:100:0x03cf, B:162:0x02e0, B:202:0x0315, B:153:0x0409, B:180:0x0431, B:193:0x0457, B:171:0x047d), top: B:9:0x0033, inners: #27, #31, #32, #29 }] */
    /* JADX WARN: Removed duplicated region for block: B:102:0x03f5 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0367 A[Catch: all -> 0x028e, TRY_LEAVE, TryCatch #21 {all -> 0x028e, blocks: (B:10:0x0033, B:129:0x003d, B:12:0x00a3, B:15:0x00a8, B:18:0x00b1, B:21:0x00b7, B:23:0x0119, B:25:0x0123, B:27:0x0129, B:30:0x0132, B:41:0x0296, B:43:0x029c, B:44:0x02a3, B:46:0x02ab, B:47:0x02bf, B:56:0x02ba, B:60:0x0196, B:61:0x01ad, B:63:0x01cf, B:72:0x01e2, B:74:0x01fd, B:76:0x020b, B:77:0x0212, B:78:0x022f, B:81:0x0246, B:83:0x025f, B:91:0x0220, B:92:0x0227, B:109:0x033c, B:111:0x0367, B:98:0x03a4, B:100:0x03cf, B:162:0x02e0, B:202:0x0315, B:153:0x0409, B:180:0x0431, B:193:0x0457, B:171:0x047d), top: B:9:0x0033, inners: #27, #31, #32, #29 }] */
    /* JADX WARN: Removed duplicated region for block: B:113:0x038d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x029c A[Catch: all -> 0x028e, TryCatch #21 {all -> 0x028e, blocks: (B:10:0x0033, B:129:0x003d, B:12:0x00a3, B:15:0x00a8, B:18:0x00b1, B:21:0x00b7, B:23:0x0119, B:25:0x0123, B:27:0x0129, B:30:0x0132, B:41:0x0296, B:43:0x029c, B:44:0x02a3, B:46:0x02ab, B:47:0x02bf, B:56:0x02ba, B:60:0x0196, B:61:0x01ad, B:63:0x01cf, B:72:0x01e2, B:74:0x01fd, B:76:0x020b, B:77:0x0212, B:78:0x022f, B:81:0x0246, B:83:0x025f, B:91:0x0220, B:92:0x0227, B:109:0x033c, B:111:0x0367, B:98:0x03a4, B:100:0x03cf, B:162:0x02e0, B:202:0x0315, B:153:0x0409, B:180:0x0431, B:193:0x0457, B:171:0x047d), top: B:9:0x0033, inners: #27, #31, #32, #29 }] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x02ab A[Catch: all -> 0x028e, TryCatch #21 {all -> 0x028e, blocks: (B:10:0x0033, B:129:0x003d, B:12:0x00a3, B:15:0x00a8, B:18:0x00b1, B:21:0x00b7, B:23:0x0119, B:25:0x0123, B:27:0x0129, B:30:0x0132, B:41:0x0296, B:43:0x029c, B:44:0x02a3, B:46:0x02ab, B:47:0x02bf, B:56:0x02ba, B:60:0x0196, B:61:0x01ad, B:63:0x01cf, B:72:0x01e2, B:74:0x01fd, B:76:0x020b, B:77:0x0212, B:78:0x022f, B:81:0x0246, B:83:0x025f, B:91:0x0220, B:92:0x0227, B:109:0x033c, B:111:0x0367, B:98:0x03a4, B:100:0x03cf, B:162:0x02e0, B:202:0x0315, B:153:0x0409, B:180:0x0431, B:193:0x0457, B:171:0x047d), top: B:9:0x0033, inners: #27, #31, #32, #29 }] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x02cd A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x02ba A[Catch: all -> 0x028e, TryCatch #21 {all -> 0x028e, blocks: (B:10:0x0033, B:129:0x003d, B:12:0x00a3, B:15:0x00a8, B:18:0x00b1, B:21:0x00b7, B:23:0x0119, B:25:0x0123, B:27:0x0129, B:30:0x0132, B:41:0x0296, B:43:0x029c, B:44:0x02a3, B:46:0x02ab, B:47:0x02bf, B:56:0x02ba, B:60:0x0196, B:61:0x01ad, B:63:0x01cf, B:72:0x01e2, B:74:0x01fd, B:76:0x020b, B:77:0x0212, B:78:0x022f, B:81:0x0246, B:83:0x025f, B:91:0x0220, B:92:0x0227, B:109:0x033c, B:111:0x0367, B:98:0x03a4, B:100:0x03cf, B:162:0x02e0, B:202:0x0315, B:153:0x0409, B:180:0x0431, B:193:0x0457, B:171:0x047d), top: B:9:0x0033, inners: #27, #31, #32, #29 }] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x02a1  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0246 A[Catch: Exception -> 0x0276, SSLException -> 0x0278, SSLHandshakeException -> 0x027b, all -> 0x028e, IOException -> 0x02dc, CancellationException -> 0x0311, ConnectException -> 0x0405, ConnectTimeoutException -> 0x042d, SocketTimeoutException -> 0x0453, UnknownHostException -> 0x0479, TRY_ENTER, TryCatch #3 {Exception -> 0x0276, blocks: (B:30:0x0132, B:60:0x0196, B:61:0x01ad, B:63:0x01cf, B:72:0x01e2, B:74:0x01fd, B:76:0x020b, B:77:0x0212, B:78:0x022f, B:81:0x0246, B:83:0x025f, B:91:0x0220, B:92:0x0227), top: B:29:0x0132 }] */
    /* JADX WARN: Removed duplicated region for block: B:83:0x025f A[Catch: Exception -> 0x0276, SSLException -> 0x0278, SSLHandshakeException -> 0x027b, all -> 0x028e, IOException -> 0x02dc, CancellationException -> 0x0311, ConnectException -> 0x0405, ConnectTimeoutException -> 0x042d, SocketTimeoutException -> 0x0453, UnknownHostException -> 0x0479, TRY_LEAVE, TryCatch #3 {Exception -> 0x0276, blocks: (B:30:0x0132, B:60:0x0196, B:61:0x01ad, B:63:0x01cf, B:72:0x01e2, B:74:0x01fd, B:76:0x020b, B:77:0x0212, B:78:0x022f, B:81:0x0246, B:83:0x025f, B:91:0x0220, B:92:0x0227), top: B:29:0x0132 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static anet.channel.session.b.a a(anet.channel.request.Request r21, anet.channel.RequestCb r22) {
        /*
            Method dump skipped, instructions count: 1230
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: anet.channel.session.b.a(anet.channel.request.Request, anet.channel.RequestCb):anet.channel.session.b$a");
    }

    private static void a(Request request, a aVar, RequestCb requestCb, int i10, Throwable th) {
        String errMsg = ErrorConstant.getErrMsg(i10);
        ALog.e("awcn.HttpConnector", "onException", request.getSeq(), "errorCode", Integer.valueOf(i10), "errMsg", errMsg, "url", request.getUrlString(), Constants.KEY_HOST, request.getHost());
        if (aVar != null) {
            aVar.f4101a = i10;
        }
        if (!request.f4045a.isDone.get()) {
            request.f4045a.statusCode = i10;
            request.f4045a.msg = errMsg;
            request.f4045a.rspEnd = System.currentTimeMillis();
            if (i10 != -204) {
                AppMonitor.getInstance().commitStat(new ExceptionStatistic(i10, errMsg, request.f4045a, th));
            }
        }
        if (requestCb != null) {
            requestCb.onFinish(i10, errMsg, request.f4045a);
        }
    }

    private static HttpURLConnection a(Request request) {
        HttpURLConnection httpURLConnection;
        Pair<String, Integer> wifiProxy = NetworkStatusHelper.getWifiProxy();
        Proxy proxy = wifiProxy != null ? new Proxy(Proxy.Type.HTTP, new InetSocketAddress((String) wifiProxy.first, ((Integer) wifiProxy.second).intValue())) : null;
        anet.channel.util.g a10 = anet.channel.util.g.a();
        if (NetworkStatusHelper.getStatus().isMobile() && a10 != null) {
            proxy = a10.b();
        }
        URL url = request.getUrl();
        if (proxy != null) {
            httpURLConnection = (HttpURLConnection) url.openConnection(proxy);
        } else {
            httpURLConnection = (HttpURLConnection) url.openConnection();
        }
        httpURLConnection.setConnectTimeout(request.getConnectTimeout());
        httpURLConnection.setReadTimeout(request.getReadTimeout());
        httpURLConnection.setRequestMethod(request.getMethod());
        if (request.containsBody()) {
            httpURLConnection.setDoOutput(true);
        }
        Map<String, String> headers = request.getHeaders();
        for (Map.Entry<String, String> entry : headers.entrySet()) {
            httpURLConnection.addRequestProperty(entry.getKey(), entry.getValue());
        }
        String str = headers.get("Host");
        if (str == null) {
            str = request.getHost();
        }
        String concatString = request.getHttpUrl().containsNonDefaultPort() ? StringUtils.concatString(str, SOAP.DELIM, String.valueOf(request.getHttpUrl().getPort())) : str;
        httpURLConnection.setRequestProperty("Host", concatString);
        if (NetworkStatusHelper.getApn().equals("cmwap")) {
            httpURLConnection.setRequestProperty(HttpConstant.X_ONLINE_HOST, concatString);
        }
        if (!headers.containsKey("Accept-Encoding")) {
            httpURLConnection.setRequestProperty("Accept-Encoding", "gzip");
        }
        if (a10 != null) {
            httpURLConnection.setRequestProperty("Authorization", a10.c());
        }
        if (url.getProtocol().equalsIgnoreCase("https")) {
            a(httpURLConnection, request, str);
        }
        httpURLConnection.setInstanceFollowRedirects(false);
        return httpURLConnection;
    }

    private static void a(HttpURLConnection httpURLConnection, Request request, String str) {
        if (Integer.parseInt(Build.VERSION.SDK) < 8) {
            ALog.e("awcn.HttpConnector", "supportHttps", "[supportHttps]Froyo 以下版本不支持https", new Object[0]);
            return;
        }
        HttpsURLConnection httpsURLConnection = (HttpsURLConnection) httpURLConnection;
        if (request.getSslSocketFactory() != null) {
            httpsURLConnection.setSSLSocketFactory(request.getSslSocketFactory());
        } else {
            SSLSocketFactory sSLSocketFactory = anet.channel.util.b.f4270a;
            if (sSLSocketFactory != null) {
                httpsURLConnection.setSSLSocketFactory(sSLSocketFactory);
                if (ALog.isPrintLog(2)) {
                    ALog.i("awcn.HttpConnector", "HttpSslUtil", request.getSeq(), "SslSocketFactory", anet.channel.util.b.f4270a);
                }
            }
        }
        if (request.getHostnameVerifier() != null) {
            httpsURLConnection.setHostnameVerifier(request.getHostnameVerifier());
            return;
        }
        HostnameVerifier hostnameVerifier = anet.channel.util.b.f4271b;
        if (hostnameVerifier != null) {
            httpsURLConnection.setHostnameVerifier(hostnameVerifier);
            if (ALog.isPrintLog(2)) {
                ALog.i("awcn.HttpConnector", "HttpSslUtil", request.getSeq(), "HostnameVerifier", anet.channel.util.b.f4271b);
                return;
            }
            return;
        }
        httpsURLConnection.setHostnameVerifier(new c(str));
    }

    private static int a(HttpURLConnection httpURLConnection, Request request) {
        int i10 = 0;
        if (request.containsBody()) {
            OutputStream outputStream = null;
            try {
                try {
                    outputStream = httpURLConnection.getOutputStream();
                    int postBody = request.postBody(outputStream);
                    if (outputStream != null) {
                        try {
                            outputStream.flush();
                            outputStream.close();
                        } catch (IOException e10) {
                            ALog.e("awcn.HttpConnector", com.hpplay.a.a.a.b.f7232a, request.getSeq(), e10, new Object[0]);
                        }
                    }
                    i10 = postBody;
                } catch (Exception e11) {
                    ALog.e("awcn.HttpConnector", "postData error", request.getSeq(), e11, new Object[0]);
                    if (outputStream != null) {
                        try {
                            outputStream.flush();
                            outputStream.close();
                        } catch (IOException e12) {
                            ALog.e("awcn.HttpConnector", com.hpplay.a.a.a.b.f7232a, request.getSeq(), e12, new Object[0]);
                        }
                    }
                }
                long j10 = i10;
                request.f4045a.reqBodyInflateSize = j10;
                request.f4045a.reqBodyDeflateSize = j10;
                request.f4045a.sendDataSize = j10;
            } catch (Throwable th) {
                if (outputStream != null) {
                    try {
                        outputStream.flush();
                        outputStream.close();
                    } catch (IOException e13) {
                        ALog.e("awcn.HttpConnector", com.hpplay.a.a.a.b.f7232a, request.getSeq(), e13, new Object[0]);
                    }
                }
                throw th;
            }
        }
        return i10;
    }

    private static void a(HttpURLConnection httpURLConnection, Request request, a aVar, RequestCb requestCb) {
        InputStream inputStream;
        ByteArrayOutputStream byteArrayOutputStream;
        httpURLConnection.getURL().toString();
        anet.channel.util.a aVar2 = null;
        try {
            inputStream = httpURLConnection.getInputStream();
        } catch (IOException e10) {
            if (e10 instanceof FileNotFoundException) {
                ALog.w("awcn.HttpConnector", "File not found", request.getSeq(), "url", request.getUrlString());
            }
            try {
                inputStream = httpURLConnection.getErrorStream();
            } catch (Exception e11) {
                ALog.e("awcn.HttpConnector", "get error stream failed.", request.getSeq(), e11, new Object[0]);
                inputStream = null;
            }
        }
        if (inputStream == null) {
            a(request, aVar, requestCb, -404, null);
            return;
        }
        if (requestCb == null) {
            int i10 = aVar.f4104d;
            if (i10 <= 0) {
                i10 = 1024;
            } else if (aVar.f4105e) {
                i10 *= 2;
            }
            byteArrayOutputStream = new ByteArrayOutputStream(i10);
        } else {
            byteArrayOutputStream = null;
        }
        try {
            anet.channel.util.a aVar3 = new anet.channel.util.a(inputStream);
            try {
                InputStream gZIPInputStream = aVar.f4105e ? new GZIPInputStream(aVar3) : aVar3;
                ByteArray byteArray = null;
                while (!Thread.currentThread().isInterrupted()) {
                    if (byteArray == null) {
                        byteArray = a.C0063a.f3894a.a(2048);
                    }
                    int readFrom = byteArray.readFrom(gZIPInputStream);
                    if (readFrom != -1) {
                        if (byteArrayOutputStream != null) {
                            byteArray.writeTo(byteArrayOutputStream);
                        } else {
                            requestCb.onDataReceive(byteArray, false);
                            byteArray = null;
                        }
                        long j10 = readFrom;
                        request.f4045a.recDataSize += j10;
                        request.f4045a.rspBodyInflateSize += j10;
                    } else {
                        if (byteArrayOutputStream != null) {
                            byteArray.recycle();
                        } else {
                            requestCb.onDataReceive(byteArray, true);
                        }
                        if (byteArrayOutputStream != null) {
                            aVar.f4102b = byteArrayOutputStream.toByteArray();
                        }
                        request.f4045a.recDataTime = System.currentTimeMillis() - request.f4045a.rspStart;
                        request.f4045a.rspBodyDeflateSize = aVar3.a();
                        try {
                            gZIPInputStream.close();
                            return;
                        } catch (IOException unused) {
                            return;
                        }
                    }
                }
                throw new CancellationException("task cancelled");
            } catch (Throwable th) {
                th = th;
                aVar2 = aVar3;
                request.f4045a.recDataTime = System.currentTimeMillis() - request.f4045a.rspStart;
                request.f4045a.rspBodyDeflateSize = aVar2.a();
                try {
                    inputStream.close();
                } catch (IOException unused2) {
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }
}
