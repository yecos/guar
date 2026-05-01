package com.uyumao;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.SystemClock;
import android.telephony.CellIdentity;
import android.telephony.CellIdentityCdma;
import android.telephony.CellIdentityGsm;
import android.telephony.CellIdentityLte;
import android.telephony.CellIdentityNr;
import android.telephony.CellIdentityTdscdma;
import android.telephony.CellIdentityWcdma;
import android.telephony.CellInfo;
import android.telephony.CellInfoCdma;
import android.telephony.CellInfoGsm;
import android.telephony.CellInfoLte;
import android.telephony.CellInfoWcdma;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Log;
import anet.channel.strategy.dispatch.DispatchConstants;
import com.hpplay.sdk.source.browse.data.BrowserInfo;
import com.umeng.commonsdk.UMConfigure;
import com.umeng.commonsdk.debug.UMLog;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Future;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    public static Context f12405a;

    /* renamed from: b, reason: collision with root package name */
    public static WeakReference<Future<?>> f12406b;

    /* renamed from: c, reason: collision with root package name */
    public static WeakReference<Future<?>> f12407c;

    public static Context a() {
        return f12405a;
    }

    public static Boolean b() {
        Boolean bool = Boolean.FALSE;
        try {
            UMLog uMLog = UMConfigure.umDebugLog;
            Method declaredMethod = UMConfigure.class.getDeclaredMethod("isInForeground", new Class[0]);
            if (declaredMethod == null) {
                return bool;
            }
            declaredMethod.setAccessible(true);
            return (Boolean) declaredMethod.invoke(UMConfigure.class, new Object[0]);
        } catch (Throwable th) {
            th.printStackTrace();
            return bool;
        }
    }

    public static String[] c(Context context) {
        String[] strArr = {"", ""};
        if (context == null) {
            return strArr;
        }
        if (!a(context, "android.permission.ACCESS_NETWORK_STATE")) {
            strArr[0] = "";
            return strArr;
        }
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager == null) {
            strArr[0] = "";
            return strArr;
        }
        NetworkInfo networkInfo = connectivityManager.getNetworkInfo(1);
        if (networkInfo != null && networkInfo.getState() == NetworkInfo.State.CONNECTED) {
            strArr[0] = "Wi-Fi";
            return strArr;
        }
        NetworkInfo networkInfo2 = connectivityManager.getNetworkInfo(0);
        if (networkInfo2 != null && networkInfo2.getState() == NetworkInfo.State.CONNECTED) {
            strArr[0] = "mobile_network";
            strArr[1] = networkInfo2.getSubtypeName();
        }
        return strArr;
    }

    public static String d(Context context) {
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            return telephonyManager != null ? telephonyManager.getNetworkOperatorName() : "";
        } catch (Throwable unused) {
            return "";
        }
    }

    public static JSONArray e(Context context) {
        WifiManager wifiManager;
        if (context == null || !h(context)) {
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        JSONObject jSONObject = new JSONObject();
        try {
            WifiInfo connectionInfo = (!a(context, "android.permission.ACCESS_WIFI_STATE") || (wifiManager = (WifiManager) context.getSystemService("wifi")) == null) ? null : wifiManager.getConnectionInfo();
            if (connectionInfo == null) {
                return null;
            }
            String bssid = connectionInfo.getBSSID();
            String replace = connectionInfo.getSSID().replace("\"", "");
            long currentTimeMillis = System.currentTimeMillis();
            jSONObject.put("bssid", bssid);
            jSONObject.put(BrowserInfo.KEY_SSID, replace);
            jSONObject.put("ts", currentTimeMillis);
            jSONArray.put(jSONObject);
            return jSONArray;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static JSONArray f(Context context) {
        List<ScanResult> scanResults;
        if (!h(context)) {
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        try {
            WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
            if (wifiManager != null && a(context, "android.permission.ACCESS_WIFI_STATE") && a(context, "android.permission.ACCESS_FINE_LOCATION") && (scanResults = wifiManager.getScanResults()) != null) {
                int size = scanResults.size();
                if (size > 100) {
                    size = 100;
                }
                for (int i10 = 0; i10 < size; i10++) {
                    ScanResult scanResult = scanResults.get(i10);
                    if (scanResult != null) {
                        String str = scanResult.BSSID;
                        String str2 = scanResult.SSID;
                        String valueOf = String.valueOf(scanResult.level);
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("bssid", str);
                        jSONObject.put(BrowserInfo.KEY_SSID, str2);
                        jSONObject.put("rssi", valueOf);
                        jSONArray.put(jSONObject);
                    }
                }
                return jSONArray;
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    public static String[] g(Context context) {
        WifiManager wifiManager;
        WifiInfo connectionInfo;
        String[] strArr = {"", ""};
        try {
            if (a(context, "android.permission.ACCESS_WIFI_STATE") && a(context, "android.permission.ACCESS_COARSE_LOCATION") && a(context, "android.permission.ACCESS_FINE_LOCATION") && (wifiManager = (WifiManager) context.getApplicationContext().getSystemService("wifi")) != null && (connectionInfo = wifiManager.getConnectionInfo()) != null) {
                String ssid = connectionInfo.getSSID();
                String bssid = connectionInfo.getBSSID();
                if (ssid.length() > 2 && ssid.charAt(0) == '\"' && ssid.charAt(ssid.length() - 1) == '\"') {
                    strArr[0] = ssid.substring(1, ssid.length() - 1);
                }
                if (bssid != null) {
                    strArr[1] = bssid;
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return strArr;
    }

    public static boolean h(Context context) {
        WifiManager wifiManager;
        if (context == null) {
            return false;
        }
        return 3 == ((!a(context, "android.permission.ACCESS_WIFI_STATE") || (wifiManager = (WifiManager) context.getSystemService("wifi")) == null) ? -1 : wifiManager.getWifiState());
    }

    public static byte[] a(byte[] bArr, byte[] bArr2) {
        if (bArr != null && bArr.length != 0 && bArr2 != null && bArr2.length != 0) {
            for (int i10 = 0; i10 < bArr.length; i10++) {
                bArr[i10] = (byte) ((bArr[i10] ^ bArr2[i10 % bArr2.length]) ^ (i10 & 255));
            }
        }
        return bArr;
    }

    public static JSONObject a(JSONObject jSONObject, String str, String str2, boolean z10) {
        SystemClock.elapsedRealtime();
        return new JSONObject(a(jSONObject.toString(), (HttpURLConnection) new URL(str).openConnection(), str2));
    }

    public static String b(File file) {
        FileInputStream fileInputStream;
        String str = "";
        if (file.exists()) {
            try {
                fileInputStream = new FileInputStream(file);
                try {
                    byte[] bArr = new byte[1024];
                    StringBuilder sb = new StringBuilder();
                    while (true) {
                        int read = fileInputStream.read(bArr);
                        if (read <= 0) {
                            break;
                        }
                        sb.append(new String(bArr, 0, read));
                    }
                    str = sb.toString();
                } catch (Throwable th) {
                    th = th;
                    try {
                        Log.e("efs.util.file", "read file error", th);
                        return str;
                    } finally {
                        a(fileInputStream);
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                fileInputStream = null;
            }
        }
        return str;
    }

    public static void a(byte[] bArr, OutputStream outputStream) {
        GZIPInputStream gZIPInputStream;
        try {
            gZIPInputStream = new GZIPInputStream(new ByteArrayInputStream(bArr));
            try {
                byte[] bArr2 = new byte[1024];
                while (true) {
                    int read = gZIPInputStream.read(bArr2);
                    if (read == -1) {
                        break;
                    } else {
                        outputStream.write(bArr2, 0, read);
                    }
                }
            } catch (Throwable unused) {
            }
        } catch (Throwable unused2) {
            gZIPInputStream = null;
        }
        n.a(gZIPInputStream);
    }

    public static boolean a(File file, byte[] bArr, boolean z10) {
        FileOutputStream fileOutputStream;
        try {
            fileOutputStream = new FileOutputStream(file, z10);
            try {
                fileOutputStream.write(bArr);
                fileOutputStream.flush();
                a(fileOutputStream);
                return true;
            } catch (Throwable th) {
                th = th;
                try {
                    Log.e("efs.util.file", "write file error, filename is " + file.getName(), th);
                    a(fileOutputStream);
                    return false;
                } catch (Throwable th2) {
                    a(fileOutputStream);
                    throw th2;
                }
            }
        } catch (Throwable th3) {
            th = th3;
            fileOutputStream = null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x0039, code lost:
    
        if (r4.contains("network") != false) goto L18;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static org.json.JSONObject b(android.content.Context r13) {
        /*
            java.lang.String r0 = "network"
            java.lang.String r1 = "gps"
            r2 = 0
            if (r13 != 0) goto L8
            return r2
        L8:
            org.json.JSONObject r3 = new org.json.JSONObject
            r3.<init>()
            java.lang.String r4 = "android.permission.ACCESS_FINE_LOCATION"
            boolean r4 = a(r13, r4)     // Catch: java.lang.Throwable -> L86
            if (r4 == 0) goto L86
            java.lang.String r4 = "android.permission.ACCESS_COARSE_LOCATION"
            boolean r4 = a(r13, r4)     // Catch: java.lang.Throwable -> L86
            if (r4 == 0) goto L86
            java.lang.String r4 = "location"
            java.lang.Object r13 = r13.getSystemService(r4)     // Catch: java.lang.Throwable -> L86
            android.location.LocationManager r13 = (android.location.LocationManager) r13     // Catch: java.lang.Throwable -> L86
            if (r13 != 0) goto L28
            return r2
        L28:
            r4 = 1
            java.util.List r4 = r13.getProviders(r4)     // Catch: java.lang.Throwable -> L86
            boolean r5 = r4.contains(r1)     // Catch: java.lang.Throwable -> L86
            if (r5 == 0) goto L35
            r0 = r1
            goto L3b
        L35:
            boolean r1 = r4.contains(r0)     // Catch: java.lang.Throwable -> L86
            if (r1 == 0) goto L86
        L3b:
            android.location.Location r13 = r13.getLastKnownLocation(r0)     // Catch: java.lang.Throwable -> L86
            if (r13 == 0) goto L86
            r13.getLatitude()     // Catch: java.lang.Throwable -> L86
            r13.getLongitude()     // Catch: java.lang.Throwable -> L86
            double r0 = r13.getLatitude()     // Catch: java.lang.Throwable -> L86
            double r4 = r13.getLongitude()     // Catch: java.lang.Throwable -> L86
            boolean r6 = r13.hasAltitude()     // Catch: java.lang.Throwable -> L86
            r7 = 0
            if (r6 == 0) goto L5c
            double r9 = r13.getAltitude()     // Catch: java.lang.Throwable -> L86
            goto L5d
        L5c:
            r9 = r7
        L5d:
            boolean r6 = r13.hasSpeed()     // Catch: java.lang.Throwable -> L86
            if (r6 == 0) goto L68
            float r6 = r13.getSpeed()     // Catch: java.lang.Throwable -> L86
            double r7 = (double) r6     // Catch: java.lang.Throwable -> L86
        L68:
            long r11 = r13.getTime()     // Catch: java.lang.Throwable -> L86
            java.lang.String r13 = "c_lat"
            r3.put(r13, r0)     // Catch: java.lang.Throwable -> L86
            java.lang.String r13 = "c_lng"
            r3.put(r13, r4)     // Catch: java.lang.Throwable -> L86
            java.lang.String r13 = "c_alt"
            r3.put(r13, r9)     // Catch: java.lang.Throwable -> L86
            java.lang.String r13 = "c_acc"
            r3.put(r13, r7)     // Catch: java.lang.Throwable -> L86
            java.lang.String r13 = "c_lts"
            r3.put(r13, r11)     // Catch: java.lang.Throwable -> L86
            return r3
        L86:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uyumao.e.b(android.content.Context):org.json.JSONObject");
    }

    public static String a(String str, HttpURLConnection httpURLConnection, String str2) {
        GZIPOutputStream gZIPOutputStream;
        InputStream errorStream;
        byte[] bytes = str2.getBytes();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bytes2 = str.getBytes();
        InputStream inputStream = null;
        try {
            gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
            try {
                gZIPOutputStream.write(bytes2);
            } catch (Throwable unused) {
            }
        } catch (Throwable unused2) {
            gZIPOutputStream = null;
        }
        n.a(gZIPOutputStream);
        byte[] a10 = a(byteArrayOutputStream.toByteArray(), bytes);
        httpURLConnection.setRequestMethod("POST");
        httpURLConnection.setReadTimeout(30000);
        httpURLConnection.setConnectTimeout(30000);
        httpURLConnection.addRequestProperty("Content-Type", "application/octet-stream");
        httpURLConnection.addRequestProperty("Content-Encoding", "xgzip");
        httpURLConnection.addRequestProperty("appkey", str2);
        httpURLConnection.setFixedLengthStreamingMode(a10.length);
        httpURLConnection.setDoOutput(true);
        try {
            inputStream = httpURLConnection.getOutputStream();
            inputStream.write(a10);
            n.a(inputStream);
            int responseCode = httpURLConnection.getResponseCode();
            if (responseCode < 400) {
                errorStream = httpURLConnection.getInputStream();
            } else {
                errorStream = httpURLConnection.getErrorStream();
            }
            byteArrayOutputStream.reset();
            if (inputStream != null) {
                byte[] bArr = new byte[8192];
                while (true) {
                    try {
                        int read = inputStream.read(bArr);
                        if (read == -1) {
                            break;
                        }
                        byteArrayOutputStream.write(bArr, 0, read);
                    } finally {
                    }
                }
            }
            try {
                httpURLConnection.disconnect();
            } catch (Throwable unused3) {
            }
            if (responseCode == 200 && TextUtils.equals("xgzip", httpURLConnection.getHeaderField("Content-Encoding"))) {
                byte[] a11 = a(byteArrayOutputStream.toByteArray(), bytes);
                byteArrayOutputStream.reset();
                a(a11, byteArrayOutputStream);
            }
            String byteArrayOutputStream2 = byteArrayOutputStream.toString();
            if (responseCode == 200) {
                return byteArrayOutputStream2;
            }
            throw new IOException("code:" + responseCode + " msg:" + byteArrayOutputStream2);
        } finally {
        }
    }

    public static JSONArray a(Context context) {
        String substring;
        String valueOf;
        String substring2;
        String valueOf2;
        String substring3;
        String valueOf3;
        CellIdentityTdscdma cellIdentity;
        int cid;
        int lac;
        String mncString;
        String mccString;
        CellIdentity cellIdentity2;
        int pci;
        long nci;
        int tac;
        String mncString2;
        String mccString2;
        JSONArray jSONArray = new JSONArray();
        JSONArray jSONArray2 = null;
        if (context == null) {
            return null;
        }
        try {
            if (a(context, "android.permission.ACCESS_FINE_LOCATION")) {
                TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                String networkOperator = telephonyManager.getNetworkOperator();
                if (!TextUtils.isEmpty(networkOperator)) {
                    try {
                        networkOperator.substring(0, 3);
                        networkOperator.substring(3);
                    } catch (Throwable unused) {
                    }
                }
                List<CellInfo> allCellInfo = telephonyManager.getAllCellInfo();
                if (allCellInfo != null) {
                    for (CellInfo cellInfo : allCellInfo) {
                        if (cellInfo.isRegistered()) {
                            int i10 = Build.VERSION.SDK_INT;
                            if (i10 >= 29) {
                                if (w8.a.a(cellInfo)) {
                                    JSONObject jSONObject = new JSONObject();
                                    cellIdentity2 = w8.c.a(cellInfo).getCellIdentity();
                                    CellIdentityNr a10 = w8.g.a(cellIdentity2);
                                    pci = a10.getPci();
                                    nci = a10.getNci();
                                    tac = a10.getTac();
                                    mncString2 = a10.getMncString();
                                    mccString2 = a10.getMccString();
                                    try {
                                        jSONObject.put("nt", "Nr");
                                        jSONObject.put("pci", pci);
                                        jSONObject.put("nci", nci);
                                        jSONObject.put("tac", tac);
                                        jSONObject.put(DispatchConstants.MNC, mncString2);
                                        jSONObject.put("mcc", mccString2);
                                        jSONObject.put("ts", System.currentTimeMillis());
                                        jSONArray.put(jSONObject);
                                    } catch (Throwable unused2) {
                                        return null;
                                    }
                                } else if (w8.n.a(cellInfo)) {
                                    JSONObject jSONObject2 = new JSONObject();
                                    cellIdentity = w8.l.a(cellInfo).getCellIdentity();
                                    cid = cellIdentity.getCid();
                                    lac = cellIdentity.getLac();
                                    mncString = cellIdentity.getMncString();
                                    mccString = cellIdentity.getMccString();
                                    jSONObject2.put("nt", "Tdscdma");
                                    jSONObject2.put("cid", cid);
                                    jSONObject2.put("lac", lac);
                                    jSONObject2.put(DispatchConstants.MNC, mncString);
                                    jSONObject2.put("mcc", mccString);
                                    jSONObject2.put("ts", System.currentTimeMillis());
                                    jSONArray.put(jSONObject2);
                                }
                                jSONArray2 = null;
                            }
                            if (cellInfo instanceof CellInfoLte) {
                                JSONObject jSONObject3 = new JSONObject();
                                CellIdentityLte cellIdentity3 = ((CellInfoLte) cellInfo).getCellIdentity();
                                int pci2 = cellIdentity3.getPci();
                                int tac2 = cellIdentity3.getTac();
                                if (i10 >= 28) {
                                    substring3 = cellIdentity3.getMncString();
                                    valueOf3 = cellIdentity3.getMccString();
                                } else {
                                    substring3 = ("00" + String.valueOf(cellIdentity3.getMnc())).substring(r4.length() - 2);
                                    valueOf3 = String.valueOf(cellIdentity3.getMcc());
                                }
                                jSONObject3.put("nt", "Lte");
                                jSONObject3.put("pci", pci2);
                                jSONObject3.put("tac", tac2);
                                jSONObject3.put(DispatchConstants.MNC, substring3);
                                jSONObject3.put("mcc", valueOf3);
                                jSONObject3.put("ts", System.currentTimeMillis());
                                jSONArray.put(jSONObject3);
                            } else if (cellInfo instanceof CellInfoWcdma) {
                                JSONObject jSONObject4 = new JSONObject();
                                CellIdentityWcdma cellIdentity4 = ((CellInfoWcdma) cellInfo).getCellIdentity();
                                int cid2 = cellIdentity4.getCid();
                                int lac2 = cellIdentity4.getLac();
                                if (i10 >= 28) {
                                    substring2 = cellIdentity4.getMncString();
                                    valueOf2 = cellIdentity4.getMccString();
                                } else {
                                    substring2 = ("00" + String.valueOf(cellIdentity4.getMnc())).substring(r4.length() - 2);
                                    valueOf2 = String.valueOf(cellIdentity4.getMcc());
                                }
                                jSONObject4.put("nt", "Wcdma");
                                jSONObject4.put("cid", cid2);
                                jSONObject4.put("lac", lac2);
                                jSONObject4.put(DispatchConstants.MNC, substring2);
                                jSONObject4.put("mcc", valueOf2);
                                jSONObject4.put("ts", System.currentTimeMillis());
                                jSONArray.put(jSONObject4);
                            } else if (cellInfo instanceof CellInfoCdma) {
                                JSONObject jSONObject5 = new JSONObject();
                                CellIdentityCdma cellIdentity5 = ((CellInfoCdma) cellInfo).getCellIdentity();
                                int basestationId = cellIdentity5.getBasestationId();
                                int networkId = cellIdentity5.getNetworkId();
                                int systemId = cellIdentity5.getSystemId();
                                jSONObject5.put("nt", "Cdma");
                                jSONObject5.put("bid", basestationId);
                                jSONObject5.put("nid", networkId);
                                jSONObject5.put("sid", systemId);
                                jSONObject5.put(DispatchConstants.MNC, "03");
                                jSONObject5.put("mcc", "460");
                                jSONObject5.put("ts", System.currentTimeMillis());
                                jSONArray.put(jSONObject5);
                            } else if (cellInfo instanceof CellInfoGsm) {
                                JSONObject jSONObject6 = new JSONObject();
                                CellIdentityGsm cellIdentity6 = ((CellInfoGsm) cellInfo).getCellIdentity();
                                int cid3 = cellIdentity6.getCid();
                                int lac3 = cellIdentity6.getLac();
                                if (i10 >= 28) {
                                    substring = cellIdentity6.getMncString();
                                    valueOf = cellIdentity6.getMccString();
                                } else {
                                    substring = ("00" + String.valueOf(cellIdentity6.getMnc())).substring(r4.length() - 2);
                                    valueOf = String.valueOf(cellIdentity6.getMcc());
                                }
                                jSONObject6.put("nt", "Gsm");
                                jSONObject6.put("cid", cid3);
                                jSONObject6.put("lac", lac3);
                                jSONObject6.put(DispatchConstants.MNC, substring);
                                jSONObject6.put("mcc", valueOf);
                                jSONObject6.put("ts", System.currentTimeMillis());
                                jSONArray.put(jSONObject6);
                            }
                            jSONArray2 = null;
                        }
                    }
                }
            }
            return jSONArray;
        } catch (Throwable unused3) {
            return jSONArray2;
        }
    }

    public static void a(JSONObject jSONObject, String str, String str2) {
        GZIPOutputStream gZIPOutputStream;
        HttpURLConnection httpURLConnection;
        OutputStream outputStream;
        boolean z10;
        String jSONObject2 = jSONObject.toString();
        byte[] bytes = str2.getBytes();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bytes2 = jSONObject2.getBytes();
        InputStream inputStream = null;
        try {
            gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
            try {
                gZIPOutputStream.write(bytes2);
            } catch (Throwable unused) {
            }
        } catch (Throwable unused2) {
            gZIPOutputStream = null;
        }
        n.a(gZIPOutputStream);
        byte[] a10 = a(byteArrayOutputStream.toByteArray(), bytes);
        SystemClock.elapsedRealtime();
        try {
            httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            try {
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setReadTimeout(60000);
                httpURLConnection.setConnectTimeout(60000);
                httpURLConnection.addRequestProperty("Content-Type", "application/octet-stream");
                httpURLConnection.addRequestProperty("appkey", str2);
                if (TextUtils.isEmpty(jSONObject.optString("uuid"))) {
                    z10 = true;
                } else {
                    httpURLConnection.addRequestProperty("Rich-Resp-Code", "1");
                    z10 = false;
                }
                httpURLConnection.setFixedLengthStreamingMode(a10.length);
                httpURLConnection.setDoOutput(true);
                outputStream = httpURLConnection.getOutputStream();
                try {
                    outputStream.write(a10);
                    int responseCode = httpURLConnection.getResponseCode();
                    if (responseCode < 400) {
                        inputStream = httpURLConnection.getInputStream();
                    } else {
                        inputStream = httpURLConnection.getErrorStream();
                    }
                    byteArrayOutputStream.reset();
                    if (inputStream != null) {
                        byte[] bArr = new byte[8192];
                        while (true) {
                            int read = inputStream.read(bArr);
                            if (read == -1) {
                                break;
                            } else {
                                byteArrayOutputStream.write(bArr, 0, read);
                            }
                        }
                    }
                    n.a(outputStream);
                    n.a(inputStream);
                    try {
                        httpURLConnection.disconnect();
                    } catch (Throwable unused3) {
                    }
                    if (responseCode == 200) {
                        byte[] a11 = a(byteArrayOutputStream.toByteArray(), bytes);
                        byteArrayOutputStream.reset();
                        if (z10) {
                            a(a11, byteArrayOutputStream);
                            byteArrayOutputStream.toString();
                        } else {
                            new String(a11);
                        }
                    }
                    if (responseCode == 200) {
                        return;
                    }
                    throw new Exception("response code " + responseCode);
                } catch (Throwable th) {
                    th = th;
                    n.a(outputStream);
                    n.a(inputStream);
                    if (httpURLConnection != null) {
                        try {
                            httpURLConnection.disconnect();
                        } catch (Throwable unused4) {
                        }
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                outputStream = null;
            }
        } catch (Throwable th3) {
            th = th3;
            httpURLConnection = null;
            outputStream = null;
        }
    }

    public static void a(File file) {
        File[] listFiles;
        if (file != null) {
            try {
                if (file.exists()) {
                    if (file.isDirectory() && (listFiles = file.listFiles()) != null && listFiles.length > 0) {
                        for (File file2 : listFiles) {
                            a(file2);
                        }
                    }
                    file.delete();
                }
            } catch (Exception e10) {
                e10.printStackTrace();
            }
        }
    }

    public static String a(NetworkInfo networkInfo) {
        int subtype;
        try {
            subtype = networkInfo.getSubtype();
        } catch (Throwable th) {
            th.printStackTrace();
            return "";
        }
        if (subtype == 20) {
            return "5G";
        }
        switch (subtype) {
            case 1:
            case 2:
            case 4:
            case 7:
            case 11:
                return "2G";
            case 3:
            case 5:
            case 6:
            case 8:
            case 9:
            case 10:
            case 12:
            case 14:
            case 15:
                return "3G";
            case 13:
                return "4G";
            default:
                String subtypeName = networkInfo.getSubtypeName();
                if (TextUtils.isEmpty(subtypeName)) {
                    return "";
                }
                if (!"TD-SCDMA".equalsIgnoreCase(subtypeName) && !"WCDMA".equalsIgnoreCase(subtypeName)) {
                    if (!"CDMA2000".equalsIgnoreCase(subtypeName)) {
                        return subtypeName;
                    }
                }
                return "3G";
        }
        th.printStackTrace();
        return "";
    }

    public static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Throwable th) {
                Log.e("efs.util.file", "safe close error", th);
            }
        }
    }

    public static boolean a(Context context, String str) {
        if (context == null) {
            return false;
        }
        if (Build.VERSION.SDK_INT >= 23) {
            try {
                if (((Integer) Class.forName("android.content.Context").getMethod("checkSelfPermission", String.class).invoke(context, str)).intValue() != 0) {
                    return false;
                }
            } catch (Throwable unused) {
                return false;
            }
        } else if (context.getPackageManager().checkPermission(str, context.getPackageName()) != 0) {
            return false;
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static JSONArray a(JSONObject jSONObject, JSONObject jSONObject2) {
        try {
            try {
                if (jSONObject != null && jSONObject2 != null) {
                    JSONObject jSONObject3 = new JSONObject(jSONObject.toString());
                    if (jSONObject2.length() > 0) {
                        Iterator<String> keys = jSONObject2.keys();
                        while (keys.hasNext()) {
                            String next = keys.next();
                            jSONObject3.put(next, jSONObject2.get(next));
                        }
                    }
                    JSONArray jSONArray = new JSONArray();
                    jSONArray.put(jSONObject3);
                    jSONObject = jSONArray;
                } else {
                    if (jSONObject != null) {
                        JSONArray jSONArray2 = new JSONArray();
                        try {
                            jSONArray2.put(jSONObject);
                            return jSONArray2;
                        } catch (Throwable unused) {
                            return jSONArray2;
                        }
                    }
                    JSONArray jSONArray3 = new JSONArray();
                    jSONArray3.put(jSONObject2);
                    jSONObject = jSONArray3;
                }
            } catch (Throwable unused2) {
            }
            return jSONObject;
        } catch (Throwable unused3) {
            return null;
        }
    }
}
