package com.hpplay.common.utils;

import android.app.Application;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;
import com.hpplay.common.log.LeLog;

/* loaded from: classes2.dex */
public class NetworkUtil {
    private static final int NETWORK_TYPE_GSM = 16;
    private static final int NETWORK_TYPE_IWLAN = 18;
    private static final int NETWORK_TYPE_TD_SCDMA = 17;
    public static final int NET_TYPE_2_4_G = 1;
    public static final int NET_TYPE_5_G = 2;
    public static final int NET_TYPE_AP = 4;
    public static final int NET_TYPE_CABLE = 3;
    public static final int NET_TYPE_OTHER = 5;
    public static final int NET_TYPE_UNKNOWN = 0;
    private static final String TAG = "NetworkUtil";
    private static boolean enableBSSID = true;
    private static boolean enableSSID = true;

    public enum NetworkType {
        NETWORK_WIFI,
        NETWORK_4G,
        NETWORK_3G,
        NETWORK_2G,
        NETWORK_UNKNOWN,
        NETWORK_NO
    }

    private static String getAPName(Context context) {
        if (!(context instanceof Application)) {
            context = context.getApplicationContext();
        }
        isWifiApOpen(context);
        return "";
    }

    private static NetworkInfo getActiveNetworkInfo(Context context) {
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager == null) {
                return null;
            }
            return connectivityManager.getActiveNetworkInfo();
        } catch (Exception e10) {
            LeLog.w(TAG, "getActiveNetworkInfo error:" + e10.getMessage());
            return null;
        }
    }

    public static int getNetType(Context context) {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
                return 0;
            }
            String typeName = activeNetworkInfo.getTypeName();
            if (!typeName.equalsIgnoreCase("Ethernet") && !typeName.equalsIgnoreCase("ETH")) {
                if (typeName.equalsIgnoreCase("WIFI")) {
                    String wifiSSID = getWifiSSID(context);
                    if (TextUtils.isEmpty(wifiSSID) || !(wifiSSID.contains("unknown") || wifiSSID.contains("0x"))) {
                        return getWifiType(context) == 0 ? 1 : 2;
                    }
                    return 3;
                }
                if (!TextUtils.isEmpty(getAPName(context))) {
                    return 4;
                }
            }
            return 3;
        } catch (Exception e10) {
            LeLog.w(TAG, e10);
            return 0;
        }
    }

    public static String getNetWorkName(Context context) {
        return getNetWorkName(context, "有线网络", "无线网络", "移动网络", "网络错误");
    }

    public static NetworkType getNetworkType(Context context) {
        NetworkType networkType;
        NetworkType networkType2 = NetworkType.NETWORK_NO;
        NetworkInfo activeNetworkInfo = getActiveNetworkInfo(context);
        if (activeNetworkInfo == null || !activeNetworkInfo.isAvailable()) {
            return networkType2;
        }
        if (activeNetworkInfo.getType() == 1) {
            return NetworkType.NETWORK_WIFI;
        }
        if (activeNetworkInfo.getType() != 0) {
            return NetworkType.NETWORK_UNKNOWN;
        }
        switch (activeNetworkInfo.getSubtype()) {
            case 1:
            case 2:
            case 4:
            case 7:
            case 11:
            case 16:
                networkType = NetworkType.NETWORK_2G;
                break;
            case 3:
            case 5:
            case 6:
            case 8:
            case 9:
            case 10:
            case 12:
            case 14:
            case 15:
            case 17:
                networkType = NetworkType.NETWORK_3G;
                break;
            case 13:
            case 18:
                networkType = NetworkType.NETWORK_4G;
                break;
            default:
                String subtypeName = activeNetworkInfo.getSubtypeName();
                if (!subtypeName.equalsIgnoreCase("TD-SCDMA") && !subtypeName.equalsIgnoreCase("WCDMA") && !subtypeName.equalsIgnoreCase("CDMA2000")) {
                    networkType = NetworkType.NETWORK_UNKNOWN;
                    break;
                } else {
                    networkType = NetworkType.NETWORK_3G;
                    break;
                }
                break;
        }
        return networkType;
    }

    private static int getTypeUnder21(Context context) {
        return 0;
    }

    public static String getWifiBSSID(Context context) {
        return "";
    }

    public static String getWifiBSSIDNoneColon(Context context) {
        return getWifiBSSID(context);
    }

    public static String getWifiSSID(Context context) {
        return "";
    }

    public static int getWifiType(Context context) {
        return getTypeUnder21(context);
    }

    public static boolean isWiFiOpen(Context context) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.getType() == 1;
    }

    private static boolean isWifiApOpen(Context context) {
        return false;
    }

    public static boolean isWifiConnected(Context context) {
        NetworkInfo activeNetworkInfo;
        try {
            activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        } catch (Exception unused) {
        }
        if (activeNetworkInfo == null || activeNetworkInfo.getType() != 1) {
            LeLog.i(TAG, "WIFI disconnected");
            return false;
        }
        LeLog.i(TAG, "WIFI is connected");
        return true;
    }

    public static void setBSSIDStatus(boolean z10) {
        enableBSSID = z10;
    }

    public static void setSSIDStatus(boolean z10) {
        enableSSID = z10;
    }

    public static String getNetWorkName(Context context, String str, String str2) {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
                String aPName = getAPName(context);
                return !TextUtils.isEmpty(aPName) ? aPName : str2;
            }
            String typeName = activeNetworkInfo.getTypeName();
            if (typeName.equalsIgnoreCase("Ethernet") || typeName.equalsIgnoreCase("ETH") || !typeName.equalsIgnoreCase("WIFI")) {
                return str;
            }
            String wifiSSID = getWifiSSID(context);
            if (wifiSSID == null || (!wifiSSID.contains("unknown") && !wifiSSID.contains("0x"))) {
                return wifiSSID;
            }
            return str;
        } catch (Exception e10) {
            LeLog.w(TAG, e10);
            return str2;
        }
    }

    private static String getNetWorkName(Context context, String str, String str2, String str3, String str4) {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
                String typeName = activeNetworkInfo.getTypeName();
                if (!typeName.equalsIgnoreCase("Ethernet") && !typeName.equalsIgnoreCase("ETH")) {
                    if (!typeName.equalsIgnoreCase("WIFI")) {
                        return typeName.equalsIgnoreCase("MOBILE") ? str3 : str4;
                    }
                    String wifiSSID = getWifiSSID(context);
                    if (wifiSSID == null || (!wifiSSID.contains("unknown") && !wifiSSID.contains("0x"))) {
                        return wifiSSID;
                    }
                    return str2;
                }
                return str;
            }
            String aPName = getAPName(context);
            return !TextUtils.isEmpty(aPName) ? aPName : str4;
        } catch (Exception e10) {
            LeLog.w(TAG, e10);
            return str4;
        }
    }
}
