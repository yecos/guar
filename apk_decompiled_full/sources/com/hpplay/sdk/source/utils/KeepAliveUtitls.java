package com.hpplay.sdk.source.utils;

import android.text.TextUtils;
import com.google.common.net.HttpHeaders;
import com.hpplay.a.a.a.d;
import com.hpplay.common.utils.CertUtils;
import com.hpplay.component.common.ParamsMap;
import com.hpplay.component.protocol.ProtocolBuilder;
import com.hpplay.cybergarage.xml.XML;
import com.hpplay.sdk.source.bean.SinkParameterBean;
import com.hpplay.sdk.source.browse.data.BrowserInfo;
import com.hpplay.sdk.source.business.cloud.CloudAPI;
import com.hpplay.sdk.source.c.a;
import com.hpplay.sdk.source.common.global.Constant;
import com.hpplay.sdk.source.common.store.Session;
import com.hpplay.sdk.source.log.SourceLog;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.NetworkInterface;
import java.net.Socket;
import java.net.URL;
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
    */
    public static String httpPostCheckDeviceStateByDsn(List<HTTPInfoBean> list) {
        OutputStream outputStream;
        InputStream inputStream;
        HttpURLConnection httpURLConnection;
        InputStream inputStream2;
        JSONObject jSONObject;
        HttpURLConnection httpURLConnection2;
        String str;
        BufferedReader bufferedReader;
        BufferedReader bufferedReader2 = null;
        ?? r22 = 0;
        bufferedReader2 = null;
        bufferedReader2 = null;
        BufferedReader bufferedReader3 = null;
        bufferedReader2 = null;
        bufferedReader2 = null;
        bufferedReader2 = null;
        bufferedReader2 = null;
        if (list == null || list.isEmpty()) {
            SourceLog.w(TAG, "httpPostCheckDeviceStateByDsn,value is invalid");
            return null;
        }
        SourceLog.i(TAG, "httpPostCheckDeviceStateByDsn");
        try {
            jSONObject = new JSONObject();
            jSONObject.put(ParamsMap.DeviceParams.KEY_UID, Session.getInstance().getUID());
            jSONObject.put(ParamsMap.DeviceParams.KEY_APPID, Session.getInstance().appKey);
            jSONObject.put(ParamsMap.DeviceParams.KEY_AUTH_TOKEN, a.a());
            jSONObject.put(BrowserInfo.KEY_VER, "1.0");
            ?? jSONArray = new JSONArray();
            for (HTTPInfoBean hTTPInfoBean : list) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("ra", hTTPInfoBean.appID);
                jSONObject2.put("dsn", hTTPInfoBean.dsn);
                jSONArray.put(jSONObject2);
            }
            jSONObject.put("tvList", jSONArray.toString());
            SourceLog.i(TAG, "httpPostCheckTvState parameter:" + CloudAPI.sGetDeviceStatusByDsn);
            SourceLog.i(TAG, "httpPostCheckTvState parameter:" + jSONObject.toString());
            httpURLConnection2 = CertUtils.getHttpURLConnection(new URL(CloudAPI.sGetDeviceStatusByDsn));
            try {
                long j10 = CONNECT_TIMEOUT;
                httpURLConnection2.setConnectTimeout((int) j10);
                httpURLConnection2.setReadTimeout((int) j10);
                httpURLConnection2.setDoOutput(true);
                httpURLConnection2.setDoInput(true);
                httpURLConnection2.setUseCaches(false);
                httpURLConnection2.setRequestMethod("POST");
                httpURLConnection2.setRequestProperty("Content-type", d.MIME_HTML);
                httpURLConnection2.setRequestProperty(HttpHeaders.ACCEPT_CHARSET, XML.CHARSET_UTF8);
                httpURLConnection2.setRequestProperty("contentType", XML.CHARSET_UTF8);
                httpURLConnection2.connect();
                outputStream = httpURLConnection2.getOutputStream();
            } catch (Exception e10) {
                httpURLConnection = httpURLConnection2;
                e = e10;
                outputStream = null;
                inputStream = null;
            } catch (Throwable th) {
                httpURLConnection = httpURLConnection2;
                th = th;
                outputStream = null;
                inputStream = null;
            }
        } catch (Exception e11) {
            e = e11;
            outputStream = null;
            inputStream = null;
            httpURLConnection = null;
            inputStream2 = null;
        } catch (Throwable th2) {
            th = th2;
            outputStream = null;
            inputStream = null;
            httpURLConnection = null;
        }
        try {
            outputStream.write(jSONObject.toString().getBytes());
            outputStream.flush();
            if (200 == httpURLConnection2.getResponseCode()) {
                inputStream = httpURLConnection2.getInputStream();
                try {
                    bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
                } catch (Exception e12) {
                    inputStream2 = null;
                    httpURLConnection = httpURLConnection2;
                    e = e12;
                } catch (Throwable th3) {
                    httpURLConnection = httpURLConnection2;
                    th = th3;
                }
                try {
                    StringBuffer stringBuffer = new StringBuffer();
                    while (true) {
                        String readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            break;
                        }
                        stringBuffer.append(readLine);
                        stringBuffer.append("\r\n");
                    }
                    r22 = stringBuffer.toString();
                    SourceLog.i(TAG, "httpPostCheckTvState result:" + r22);
                    str = r22;
                    bufferedReader3 = bufferedReader;
                } catch (Exception e13) {
                    httpURLConnection = httpURLConnection2;
                    e = e13;
                    inputStream2 = r22;
                    bufferedReader2 = bufferedReader;
                    try {
                        SourceLog.w(TAG, e);
                        if (bufferedReader2 != null) {
                        }
                        if (outputStream != null) {
                        }
                        if (inputStream != null) {
                        }
                        if (httpURLConnection != null) {
                        }
                        return inputStream2;
                    } catch (Throwable th4) {
                        th = th4;
                        if (bufferedReader2 != null) {
                            try {
                                bufferedReader2.close();
                            } catch (Exception e14) {
                                SourceLog.w(TAG, e14);
                            }
                        }
                        if (outputStream != null) {
                            try {
                                outputStream.close();
                            } catch (Exception e15) {
                                SourceLog.w(TAG, e15);
                            }
                        }
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (Exception e16) {
                                SourceLog.w(TAG, e16);
                            }
                        }
                        if (httpURLConnection != null) {
                            throw th;
                        }
                        try {
                            httpURLConnection.disconnect();
                            throw th;
                        } catch (Exception e17) {
                            SourceLog.w(TAG, e17);
                            throw th;
                        }
                    }
                } catch (Throwable th5) {
                    httpURLConnection = httpURLConnection2;
                    th = th5;
                    bufferedReader2 = bufferedReader;
                    if (bufferedReader2 != null) {
                    }
                    if (outputStream != null) {
                    }
                    if (inputStream != null) {
                    }
                    if (httpURLConnection != null) {
                    }
                }
            } else {
                inputStream = null;
                str = null;
            }
            if (bufferedReader3 != null) {
                try {
                    bufferedReader3.close();
                } catch (Exception e18) {
                    SourceLog.w(TAG, e18);
                }
            }
            try {
                outputStream.close();
            } catch (Exception e19) {
                SourceLog.w(TAG, e19);
            }
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (Exception e20) {
                    SourceLog.w(TAG, e20);
                }
            }
            try {
                httpURLConnection2.disconnect();
                return str;
            } catch (Exception e21) {
                SourceLog.w(TAG, e21);
                return str;
            }
        } catch (Exception e22) {
            httpURLConnection = httpURLConnection2;
            e = e22;
            inputStream = null;
            inputStream2 = inputStream;
            SourceLog.w(TAG, e);
            if (bufferedReader2 != null) {
                try {
                    bufferedReader2.close();
                } catch (Exception e23) {
                    SourceLog.w(TAG, e23);
                }
            }
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (Exception e24) {
                    SourceLog.w(TAG, e24);
                }
            }
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (Exception e25) {
                    SourceLog.w(TAG, e25);
                }
            }
            if (httpURLConnection != null) {
                try {
                    httpURLConnection.disconnect();
                } catch (Exception e26) {
                    SourceLog.w(TAG, e26);
                }
            }
            return inputStream2;
        } catch (Throwable th6) {
            httpURLConnection = httpURLConnection2;
            th = th6;
            inputStream = null;
        }
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
    */
    public static String httpPostCheckTvStateByUID(List<HTTPInfoBean> list) {
        OutputStream outputStream;
        InputStream inputStream;
        HttpURLConnection httpURLConnection;
        InputStream inputStream2;
        JSONObject jSONObject;
        HttpURLConnection httpURLConnection2;
        String str;
        BufferedReader bufferedReader;
        BufferedReader bufferedReader2 = null;
        ?? r22 = 0;
        bufferedReader2 = null;
        bufferedReader2 = null;
        BufferedReader bufferedReader3 = null;
        bufferedReader2 = null;
        bufferedReader2 = null;
        bufferedReader2 = null;
        bufferedReader2 = null;
        if (list == null || list.isEmpty()) {
            SourceLog.w(TAG, "httpPostCheckTvStateByUID,value is invalid");
            return null;
        }
        SourceLog.i(TAG, "httpPostCheckTvStateByUID");
        try {
            jSONObject = new JSONObject();
            jSONObject.put(ParamsMap.DeviceParams.KEY_UID, Session.getInstance().getUID());
            jSONObject.put(ParamsMap.DeviceParams.KEY_APPID, Session.getInstance().appKey);
            jSONObject.put(ParamsMap.DeviceParams.KEY_AUTH_TOKEN, a.a());
            jSONObject.put(BrowserInfo.KEY_VER, Constant.DATAREPORT_PROTOCOL_VER);
            ?? jSONArray = new JSONArray();
            for (HTTPInfoBean hTTPInfoBean : list) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("u", hTTPInfoBean.uid);
                jSONObject2.put("ra", hTTPInfoBean.appID);
                jSONArray.put(jSONObject2);
            }
            jSONObject.put("tvList", jSONArray.toString());
            SourceLog.i(TAG, "httpPostCheckTvState parameter:" + CloudAPI.sGetTVListStatus);
            SourceLog.i(TAG, "httpPostCheckTvState parameter:" + jSONObject.toString());
            httpURLConnection2 = CertUtils.getHttpURLConnection(new URL(CloudAPI.sGetTVListStatus));
            try {
                long j10 = CONNECT_TIMEOUT;
                httpURLConnection2.setConnectTimeout((int) j10);
                httpURLConnection2.setReadTimeout((int) j10);
                httpURLConnection2.setDoOutput(true);
                httpURLConnection2.setDoInput(true);
                httpURLConnection2.setUseCaches(false);
                httpURLConnection2.setRequestMethod("POST");
                httpURLConnection2.setRequestProperty("Content-type", d.MIME_HTML);
                httpURLConnection2.setRequestProperty(HttpHeaders.ACCEPT_CHARSET, XML.CHARSET_UTF8);
                httpURLConnection2.setRequestProperty("contentType", XML.CHARSET_UTF8);
                httpURLConnection2.connect();
                outputStream = httpURLConnection2.getOutputStream();
            } catch (Exception e10) {
                httpURLConnection = httpURLConnection2;
                e = e10;
                outputStream = null;
                inputStream = null;
            } catch (Throwable th) {
                httpURLConnection = httpURLConnection2;
                th = th;
                outputStream = null;
                inputStream = null;
            }
        } catch (Exception e11) {
            e = e11;
            outputStream = null;
            inputStream = null;
            httpURLConnection = null;
            inputStream2 = null;
        } catch (Throwable th2) {
            th = th2;
            outputStream = null;
            inputStream = null;
            httpURLConnection = null;
        }
        try {
            outputStream.write(jSONObject.toString().getBytes());
            outputStream.flush();
            if (200 == httpURLConnection2.getResponseCode()) {
                inputStream = httpURLConnection2.getInputStream();
                try {
                    bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
                } catch (Exception e12) {
                    inputStream2 = null;
                    httpURLConnection = httpURLConnection2;
                    e = e12;
                } catch (Throwable th3) {
                    httpURLConnection = httpURLConnection2;
                    th = th3;
                }
                try {
                    StringBuffer stringBuffer = new StringBuffer();
                    while (true) {
                        String readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            break;
                        }
                        stringBuffer.append(readLine);
                        stringBuffer.append("\r\n");
                    }
                    r22 = stringBuffer.toString();
                    SourceLog.i(TAG, "httpPostCheckTvState result:" + r22);
                    str = r22;
                    bufferedReader3 = bufferedReader;
                } catch (Exception e13) {
                    httpURLConnection = httpURLConnection2;
                    e = e13;
                    inputStream2 = r22;
                    bufferedReader2 = bufferedReader;
                    try {
                        SourceLog.w(TAG, e);
                        if (bufferedReader2 != null) {
                        }
                        if (outputStream != null) {
                        }
                        if (inputStream != null) {
                        }
                        if (httpURLConnection != null) {
                        }
                        return inputStream2;
                    } catch (Throwable th4) {
                        th = th4;
                        if (bufferedReader2 != null) {
                            try {
                                bufferedReader2.close();
                            } catch (Exception e14) {
                                SourceLog.w(TAG, e14);
                            }
                        }
                        if (outputStream != null) {
                            try {
                                outputStream.close();
                            } catch (Exception e15) {
                                SourceLog.w(TAG, e15);
                            }
                        }
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (Exception e16) {
                                SourceLog.w(TAG, e16);
                            }
                        }
                        if (httpURLConnection != null) {
                            throw th;
                        }
                        try {
                            httpURLConnection.disconnect();
                            throw th;
                        } catch (Exception e17) {
                            SourceLog.w(TAG, e17);
                            throw th;
                        }
                    }
                } catch (Throwable th5) {
                    httpURLConnection = httpURLConnection2;
                    th = th5;
                    bufferedReader2 = bufferedReader;
                    if (bufferedReader2 != null) {
                    }
                    if (outputStream != null) {
                    }
                    if (inputStream != null) {
                    }
                    if (httpURLConnection != null) {
                    }
                }
            } else {
                inputStream = null;
                str = null;
            }
            if (bufferedReader3 != null) {
                try {
                    bufferedReader3.close();
                } catch (Exception e18) {
                    SourceLog.w(TAG, e18);
                }
            }
            try {
                outputStream.close();
            } catch (Exception e19) {
                SourceLog.w(TAG, e19);
            }
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (Exception e20) {
                    SourceLog.w(TAG, e20);
                }
            }
            try {
                httpURLConnection2.disconnect();
                return str;
            } catch (Exception e21) {
                SourceLog.w(TAG, e21);
                return str;
            }
        } catch (Exception e22) {
            httpURLConnection = httpURLConnection2;
            e = e22;
            inputStream = null;
            inputStream2 = inputStream;
            SourceLog.w(TAG, e);
            if (bufferedReader2 != null) {
                try {
                    bufferedReader2.close();
                } catch (Exception e23) {
                    SourceLog.w(TAG, e23);
                }
            }
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (Exception e24) {
                    SourceLog.w(TAG, e24);
                }
            }
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (Exception e25) {
                    SourceLog.w(TAG, e25);
                }
            }
            if (httpURLConnection != null) {
                try {
                    httpURLConnection.disconnect();
                } catch (Exception e26) {
                    SourceLog.w(TAG, e26);
                }
            }
            return inputStream2;
        } catch (Throwable th6) {
            httpURLConnection = httpURLConnection2;
            th = th6;
            inputStream = null;
        }
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
