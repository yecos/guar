package com.hpplay.common.utils;

import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.os.Build;
import android.provider.Settings;
import android.text.TextUtils;
import com.hpplay.common.log.LeLog;

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
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String getIPAddress(android.content.Context r8) {
        /*
            java.lang.String r0 = ""
            java.lang.String r1 = "connectivity"
            java.lang.Object r8 = r8.getSystemService(r1)     // Catch: java.lang.Exception -> L98
            android.net.ConnectivityManager r8 = (android.net.ConnectivityManager) r8     // Catch: java.lang.Exception -> L98
            android.net.NetworkInfo r8 = r8.getActiveNetworkInfo()     // Catch: java.lang.Exception -> L98
            r1 = 0
            if (r8 == 0) goto L44
            boolean r2 = r8.isConnected()     // Catch: java.lang.Exception -> L98
            if (r2 == 0) goto L44
            java.lang.String r8 = r8.getTypeName()     // Catch: java.lang.Exception -> L98
            java.lang.String r2 = "Ethernet"
            boolean r2 = r8.equalsIgnoreCase(r2)     // Catch: java.lang.Exception -> L98
            r3 = 1
            if (r2 != 0) goto L41
            java.lang.String r2 = "ETH"
            boolean r2 = r8.equalsIgnoreCase(r2)     // Catch: java.lang.Exception -> L98
            if (r2 == 0) goto L2d
            goto L41
        L2d:
            java.lang.String r2 = "WIFI"
            boolean r2 = r8.equalsIgnoreCase(r2)     // Catch: java.lang.Exception -> L98
            if (r2 == 0) goto L37
            r8 = 0
            goto L46
        L37:
            java.lang.String r2 = "MOBILE"
            boolean r8 = r8.equalsIgnoreCase(r2)     // Catch: java.lang.Exception -> L98
            if (r8 == 0) goto L44
            r8 = 1
            goto L45
        L41:
            r8 = 0
            r1 = 1
            goto L45
        L44:
            r8 = 0
        L45:
            r3 = 0
        L46:
            java.util.Enumeration r2 = java.net.NetworkInterface.getNetworkInterfaces()     // Catch: java.lang.Exception -> L98
            if (r2 != 0) goto L4d
            return r0
        L4d:
            boolean r4 = r2.hasMoreElements()     // Catch: java.lang.Exception -> L98
            if (r4 == 0) goto L9e
            java.lang.Object r4 = r2.nextElement()     // Catch: java.lang.Exception -> L98
            java.net.NetworkInterface r4 = (java.net.NetworkInterface) r4     // Catch: java.lang.Exception -> L98
            java.util.Enumeration r5 = r4.getInetAddresses()     // Catch: java.lang.Exception -> L98
        L5d:
            boolean r6 = r5.hasMoreElements()     // Catch: java.lang.Exception -> L98
            if (r6 == 0) goto L4d
            java.lang.Object r6 = r5.nextElement()     // Catch: java.lang.Exception -> L98
            java.net.InetAddress r6 = (java.net.InetAddress) r6     // Catch: java.lang.Exception -> L98
            boolean r7 = r6.isLoopbackAddress()     // Catch: java.lang.Exception -> L98
            if (r7 != 0) goto L5d
            boolean r7 = r6 instanceof java.net.Inet4Address     // Catch: java.lang.Exception -> L98
            if (r7 == 0) goto L5d
            java.lang.String r0 = r6.getHostAddress()     // Catch: java.lang.Exception -> L98
            if (r1 == 0) goto L86
            java.lang.String r4 = r4.getDisplayName()     // Catch: java.lang.Exception -> L98
            java.lang.String r5 = "eth0"
            boolean r4 = r4.equals(r5)     // Catch: java.lang.Exception -> L98
            if (r4 == 0) goto L4d
            return r0
        L86:
            if (r3 == 0) goto L95
            java.lang.String r4 = r4.getDisplayName()     // Catch: java.lang.Exception -> L98
            java.lang.String r5 = "wlan0"
            boolean r4 = r4.equals(r5)     // Catch: java.lang.Exception -> L98
            if (r4 == 0) goto L4d
            return r0
        L95:
            if (r8 == 0) goto L4d
            return r0
        L98:
            r8 = move-exception
            java.lang.String r1 = "DeviceUtil"
            com.hpplay.common.log.LeLog.w(r1, r8)
        L9e:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hpplay.common.utils.DeviceUtil.getIPAddress(android.content.Context):java.lang.String");
    }

    public static String getOAID(Context context) {
        return sOAID;
    }

    public static void setOAID(String str) {
        sOAID = str;
    }
}
