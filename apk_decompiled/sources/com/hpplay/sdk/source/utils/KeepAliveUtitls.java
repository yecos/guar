package com.hpplay.sdk.source.utils;

import android.text.TextUtils;
import com.hpplay.component.protocol.ProtocolBuilder;
import com.hpplay.sdk.source.bean.SinkParameterBean;
import com.hpplay.sdk.source.browse.data.BrowserInfo;
import com.hpplay.sdk.source.log.SourceLog;
import java.io.IOException;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.NetworkInterface;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class KeepAliveUtitls {
    private static final long CONNECT_TIMEOUT = TimeUnit.SECONDS.toMillis(5);
    private static final String TAG = "KeepAliveUtitls";

    public static class HTTPInfoBean {
        public String appID;
        public String dsn;
        public String uid;
    }

    private static String findValidLocalIP(String str) {
        String substring;
        Enumeration<NetworkInterface> networkInterfaces;
        try {
            substring = str.substring(0, str.lastIndexOf("."));
            networkInterfaces = NetworkInterface.getNetworkInterfaces();
        } catch (Exception e10) {
            SourceLog.w(TAG, e10);
        }
        if (networkInterfaces == null) {
            return null;
        }
        while (networkInterfaces.hasMoreElements()) {
            Enumeration<InetAddress> inetAddresses = networkInterfaces.nextElement().getInetAddresses();
            while (inetAddresses.hasMoreElements()) {
                InetAddress nextElement = inetAddresses.nextElement();
                if (!nextElement.isLoopbackAddress() && (nextElement instanceof Inet4Address)) {
                    String hostAddress = nextElement.getHostAddress();
                    if (!TextUtils.isEmpty(hostAddress) && TextUtils.equals(substring, hostAddress.substring(0, hostAddress.lastIndexOf(".")))) {
                        return hostAddress;
                    }
                }
            }
        }
        return null;
    }

    public static String getSinkServerInfo(SinkParameterBean sinkParameterBean) {
        if (sinkParameterBean == null) {
            SourceLog.w(TAG, "getSinkServerInfo,value is invalid");
            return null;
        }
        HTTPInfoBean hTTPInfoBean = new HTTPInfoBean();
        hTTPInfoBean.appID = sinkParameterBean.appID;
        hTTPInfoBean.uid = sinkParameterBean.uid;
        hTTPInfoBean.dsn = sinkParameterBean.dsn;
        ArrayList arrayList = new ArrayList();
        arrayList.add(hTTPInfoBean);
        return sinkParameterBean.createType == SinkParameterBean.CREATE_BY_SINK_DSN ? httpPostCheckDeviceStateByDsn(arrayList) : httpPostCheckTvStateByUID(arrayList);
    }

    public static String getSinkServerInfoList(List<SinkParameterBean> list) {
        if (list == null || list.size() <= 0) {
            SourceLog.w(TAG, "getSinkServerInfoList,value is invalid");
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (SinkParameterBean sinkParameterBean : list) {
            HTTPInfoBean hTTPInfoBean = new HTTPInfoBean();
            hTTPInfoBean.appID = sinkParameterBean.appID;
            hTTPInfoBean.uid = sinkParameterBean.uid;
            hTTPInfoBean.dsn = sinkParameterBean.dsn;
            arrayList.add(hTTPInfoBean);
        }
        return list.get(0).createType == SinkParameterBean.CREATE_BY_SINK_DSN ? httpPostCheckDeviceStateByDsn(arrayList) : httpPostCheckTvStateByUID(arrayList);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:100:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:101:0x01e0 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:106:0x01d6 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:111:0x01cc A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x01bf A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:72:0x01b5 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:77:0x01ab A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:82:0x01a1 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:93:0x01ea A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r2v10, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r2v19 */
    /* JADX WARN: Type inference failed for: r2v8 */
    /* JADX WARN: Type inference failed for: r4v6, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r5v17, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r5v6, types: [org.json.JSONArray] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String httpPostCheckDeviceStateByDsn(java.util.List<com.hpplay.sdk.source.utils.KeepAliveUtitls.HTTPInfoBean> r11) {
        /*
            Method dump skipped, instructions count: 505
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hpplay.sdk.source.utils.KeepAliveUtitls.httpPostCheckDeviceStateByDsn(java.util.List):java.lang.String");
    }

    public static String httpPostCheckTvState(List<BrowserInfo> list) {
        String str;
        String str2;
        if (list == null || list.isEmpty()) {
            SourceLog.i(TAG, "httpPostCheckTvState is empty");
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (BrowserInfo browserInfo : list) {
            HTTPInfoBean hTTPInfoBean = new HTTPInfoBean();
            hTTPInfoBean.uid = browserInfo.getUid();
            try {
                hTTPInfoBean.appID = browserInfo.getExtras().get("a");
            } catch (Exception e10) {
                SourceLog.w(TAG, e10);
            }
            arrayList.add(hTTPInfoBean);
        }
        String httpPostCheckTvStateByUID = httpPostCheckTvStateByUID(arrayList);
        if (TextUtils.isEmpty(httpPostCheckTvStateByUID)) {
            Iterator<BrowserInfo> it = list.iterator();
            while (it.hasNext()) {
                it.next().setOnLine(false);
            }
            return null;
        }
        try {
            if (httpPostCheckTvStateByUID.contains(ProtocolBuilder.LELINK_STATE_SUCCESS)) {
                JSONObject jSONObject = new JSONObject(httpPostCheckTvStateByUID);
                JSONObject optJSONObject = jSONObject.optJSONObject("data");
                jSONObject.optJSONObject("capblity");
                JSONArray optJSONArray = optJSONObject.optJSONArray("tvList");
                if (optJSONArray != null && optJSONArray.length() > 0) {
                    HashMap hashMap = new HashMap();
                    int length = optJSONArray.length();
                    int i10 = 0;
                    while (true) {
                        str = "uk";
                        str2 = "0";
                        if (i10 >= length) {
                            break;
                        }
                        JSONObject optJSONObject2 = optJSONArray.optJSONObject(i10);
                        optJSONObject2.optString("ra");
                        String optString = optJSONObject2.optString("u");
                        String optString2 = optJSONObject2.optString(BrowserInfo.KEY_POL);
                        boolean optBoolean = optJSONObject2.optBoolean("online");
                        String optString3 = optJSONObject2.optString("pt");
                        if (!TextUtils.isEmpty(optString2)) {
                            str2 = optString2;
                        }
                        if (!TextUtils.isEmpty(optString3)) {
                            str = optString3;
                        }
                        hashMap.put(optString, String.valueOf(optBoolean) + "@" + str2 + "@" + str);
                        i10++;
                    }
                    StringBuilder sb = new StringBuilder();
                    sb.append("doCheck httpCheck:");
                    sb.append("\r\n");
                    Boolean bool = null;
                    for (BrowserInfo browserInfo2 : list) {
                        String str3 = (String) hashMap.get(browserInfo2.getUid());
                        if (!TextUtils.isEmpty(str3)) {
                            String[] split = str3.split("@");
                            bool = Boolean.valueOf(split[0]);
                            str2 = split[1];
                            str = split[2];
                        }
                        if (bool == null) {
                            bool = Boolean.FALSE;
                        }
                        browserInfo2.setLocalWifi(false);
                        browserInfo2.setOnLine(bool.booleanValue());
                        if (browserInfo2.getExtras() != null) {
                            browserInfo2.getExtras().put(BrowserInfo.KEY_POL, str2);
                            browserInfo2.getExtras().put("pt", str);
                        }
                        sb.append("name:");
                        sb.append(browserInfo2.getName());
                        sb.append(" alive state:");
                        sb.append(browserInfo2.isOnLine());
                        sb.append("\r\n");
                    }
                    return sb.toString();
                }
            }
        } catch (Exception e11) {
            SourceLog.w(TAG, e11);
        }
        return httpPostCheckTvStateByUID;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:100:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:101:0x01e0 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:106:0x01d6 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:111:0x01cc A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x01bf A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:72:0x01b5 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:77:0x01ab A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:82:0x01a1 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:93:0x01ea A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r2v10, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r2v19 */
    /* JADX WARN: Type inference failed for: r2v8 */
    /* JADX WARN: Type inference failed for: r4v6, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r5v17, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r5v6, types: [org.json.JSONArray] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String httpPostCheckTvStateByUID(java.util.List<com.hpplay.sdk.source.utils.KeepAliveUtitls.HTTPInfoBean> r11) {
        /*
            Method dump skipped, instructions count: 505
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hpplay.sdk.source.utils.KeepAliveUtitls.httpPostCheckTvStateByUID(java.util.List):java.lang.String");
    }

    public static boolean tcpCheckTvState(String str, String str2, int i10, int i11) {
        Socket socket;
        Socket socket2 = null;
        try {
            try {
                socket = new Socket();
            } catch (Exception unused) {
            }
        } catch (Throwable th) {
            th = th;
        }
        try {
            socket.setReuseAddress(true);
            socket.setSoTimeout(i11);
            String findValidLocalIP = findValidLocalIP(str2);
            if (!TextUtils.isEmpty(findValidLocalIP)) {
                socket.bind(new InetSocketAddress(findValidLocalIP, 0));
            }
            socket.connect(new InetSocketAddress(str2, i10), i11);
            try {
                socket.close();
            } catch (IOException e10) {
                SourceLog.w(TAG, e10);
            }
            return true;
        } catch (Exception unused2) {
            socket2 = socket;
            SourceLog.i(TAG, str + " +++++++++++ is offline ++++++++++++++" + str2);
            if (socket2 == null) {
                return false;
            }
            try {
                socket2.close();
                return false;
            } catch (IOException e11) {
                SourceLog.w(TAG, e11);
                return false;
            }
        } catch (Throwable th2) {
            th = th2;
            socket2 = socket;
            if (socket2 != null) {
                try {
                    socket2.close();
                } catch (IOException e12) {
                    SourceLog.w(TAG, e12);
                }
            }
            throw th;
        }
    }

    public static boolean tcpCheckTvState(String str, String str2, int i10) {
        return tcpCheckTvState(str, str2, i10, (int) CONNECT_TIMEOUT);
    }
}
