package com.hpplay.common.utils;

import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.provider.Settings;
import android.text.TextUtils;
import com.hpplay.common.log.LeLog;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;

/* loaded from: classes2.dex */
public class DeviceUtil {
    private static final String TAG = "DeviceUtil";
    private static String sAID = "";
    private static String sOAID = "";

    public static String getAID(Context context) {
        if (!TextUtils.isEmpty(sAID)) {
            return sAID;
        }
        try {
            String string = Settings.Secure.getString(context.getContentResolver(), FieldUtil.getString(FieldUtil.f7331a));
            sAID = string;
            return string;
        } catch (Error unused) {
            LeLog.w(TAG, "getAID Settings.Secure can not get aID");
            try {
                String string2 = Settings.System.getString(context.getContentResolver(), FieldUtil.getString(FieldUtil.f7331a));
                sAID = string2;
                return string2;
            } catch (Error unused2) {
                LeLog.w(TAG, "getAID Settings.System can not get aID");
                return "";
            } catch (Exception unused3) {
                LeLog.w(TAG, "getAID Settings.System can not get aID");
                return "";
            }
        } catch (Exception unused4) {
            LeLog.w(TAG, "getAID Settings.Secure can not get aID");
            String string22 = Settings.System.getString(context.getContentResolver(), FieldUtil.getString(FieldUtil.f7331a));
            sAID = string22;
            return string22;
        }
    }

    public static String getBluetoothName() {
        try {
            return BluetoothAdapter.getDefaultAdapter().getName();
        } catch (Exception unused) {
            return Build.MANUFACTURER + " " + Build.MODEL;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x004c A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x004d A[Catch: Exception -> 0x0098, LOOP:0: B:19:0x004d->B:39:0x004d, LOOP_START, PHI: r0
      0x004d: PHI (r0v3 java.lang.String) = (r0v0 java.lang.String), (r0v4 java.lang.String) binds: [B:16:0x004a, B:39:0x004d] A[DONT_GENERATE, DONT_INLINE], TryCatch #0 {Exception -> 0x0098, blocks: (B:3:0x0002, B:5:0x0011, B:7:0x0017, B:9:0x0024, B:12:0x002d, B:15:0x0046, B:19:0x004d, B:21:0x0053, B:22:0x005d, B:24:0x0063, B:27:0x006f, B:30:0x0073, B:47:0x0079, B:41:0x0088, B:59:0x0037), top: B:2:0x0002 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String getIPAddress(Context context) {
        NetworkInfo activeNetworkInfo;
        boolean z10;
        boolean z11;
        Enumeration<NetworkInterface> networkInterfaces;
        String str = "";
        try {
            activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            z10 = false;
        } catch (Exception e10) {
            LeLog.w(TAG, e10);
        }
        if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
            String typeName = activeNetworkInfo.getTypeName();
            boolean z12 = true;
            if (!typeName.equalsIgnoreCase("Ethernet") && !typeName.equalsIgnoreCase("ETH")) {
                if (typeName.equalsIgnoreCase("WIFI")) {
                    z11 = false;
                    networkInterfaces = NetworkInterface.getNetworkInterfaces();
                    if (networkInterfaces != null) {
                        return "";
                    }
                    while (networkInterfaces.hasMoreElements()) {
                        NetworkInterface nextElement = networkInterfaces.nextElement();
                        Enumeration<InetAddress> inetAddresses = nextElement.getInetAddresses();
                        while (true) {
                            if (inetAddresses.hasMoreElements()) {
                                InetAddress nextElement2 = inetAddresses.nextElement();
                                if (!nextElement2.isLoopbackAddress() && (nextElement2 instanceof Inet4Address)) {
                                    str = nextElement2.getHostAddress();
                                    if (z10) {
                                        if (nextElement.getDisplayName().equals("eth0")) {
                                            return str;
                                        }
                                    } else if (z12) {
                                        if (nextElement.getDisplayName().equals("wlan0")) {
                                            return str;
                                        }
                                    } else if (z11) {
                                        return str;
                                    }
                                }
                            }
                        }
                    }
                    return str;
                }
                if (typeName.equalsIgnoreCase("MOBILE")) {
                    z11 = true;
                    z12 = false;
                    networkInterfaces = NetworkInterface.getNetworkInterfaces();
                    if (networkInterfaces != null) {
                    }
                }
            }
            z11 = false;
            z10 = true;
            z12 = false;
            networkInterfaces = NetworkInterface.getNetworkInterfaces();
            if (networkInterfaces != null) {
            }
        }
        z11 = false;
        z12 = false;
        networkInterfaces = NetworkInterface.getNetworkInterfaces();
        if (networkInterfaces != null) {
        }
    }

    public static String getOAID(Context context) {
        return sOAID;
    }

    public static void setOAID(String str) {
        sOAID = str;
    }
}
