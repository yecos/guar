package anet.channel.status;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.telephony.SubscriptionManager;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Pair;
import anet.channel.AwcnConfig;
import anet.channel.status.NetworkStatusHelper;
import anet.channel.thread.ThreadPoolExecutorFactory;
import anet.channel.util.ALog;
import java.lang.reflect.Method;
import java.net.InetAddress;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

/* loaded from: classes.dex */
class b {

    /* renamed from: t, reason: collision with root package name */
    private static Method f4138t;

    /* renamed from: m, reason: collision with root package name */
    private static String[] f4131m = {"net.dns1", "net.dns2", "net.dns3", "net.dns4"};

    /* renamed from: a, reason: collision with root package name */
    static volatile Context f4119a = null;

    /* renamed from: b, reason: collision with root package name */
    static volatile boolean f4120b = false;

    /* renamed from: c, reason: collision with root package name */
    static volatile NetworkStatusHelper.NetworkStatus f4121c = NetworkStatusHelper.NetworkStatus.NONE;

    /* renamed from: d, reason: collision with root package name */
    static volatile String f4122d = "unknown";

    /* renamed from: e, reason: collision with root package name */
    static volatile String f4123e = "";

    /* renamed from: f, reason: collision with root package name */
    static volatile String f4124f = "";

    /* renamed from: g, reason: collision with root package name */
    static volatile String f4125g = "";

    /* renamed from: h, reason: collision with root package name */
    static volatile String f4126h = "unknown";

    /* renamed from: i, reason: collision with root package name */
    static volatile String f4127i = "";

    /* renamed from: j, reason: collision with root package name */
    static volatile Pair<String, Integer> f4128j = null;

    /* renamed from: k, reason: collision with root package name */
    static volatile boolean f4129k = false;

    /* renamed from: l, reason: collision with root package name */
    static volatile List<InetAddress> f4130l = Collections.EMPTY_LIST;

    /* renamed from: n, reason: collision with root package name */
    private static volatile boolean f4132n = false;

    /* renamed from: o, reason: collision with root package name */
    private static volatile boolean f4133o = false;

    /* renamed from: p, reason: collision with root package name */
    private static ConnectivityManager f4134p = null;

    /* renamed from: q, reason: collision with root package name */
    private static TelephonyManager f4135q = null;

    /* renamed from: r, reason: collision with root package name */
    private static WifiManager f4136r = null;

    /* renamed from: s, reason: collision with root package name */
    private static SubscriptionManager f4137s = null;

    /* renamed from: u, reason: collision with root package name */
    private static BroadcastReceiver f4139u = new BroadcastReceiver() { // from class: anet.channel.status.NetworkStatusMonitor$2
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (ALog.isPrintLog(1)) {
                ALog.d("awcn.NetworkStatusMonitor", "receiver:" + intent.getAction(), null, new Object[0]);
            }
            ThreadPoolExecutorFactory.submitScheduledTask(new d(this));
        }
    };

    public static void a() {
        if (f4132n || f4119a == null) {
            return;
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        try {
            if (Build.VERSION.SDK_INT >= 33) {
                f4119a.registerReceiver(f4139u, intentFilter, 2);
            } else {
                f4119a.registerReceiver(f4139u, intentFilter);
            }
        } catch (Exception unused) {
            ALog.e("awcn.NetworkStatusMonitor", "registerReceiver failed", null, new Object[0]);
        }
        d();
        f4132n = true;
    }

    public static void b() {
        if (f4119a != null) {
            f4119a.unregisterReceiver(f4139u);
        }
    }

    public static void c() {
        if (Build.VERSION.SDK_INT < 24 || f4133o) {
            return;
        }
        NetworkInfo e10 = e();
        f4120b = e10 != null && e10.isConnected();
        f4134p.registerDefaultNetworkCallback(new c());
        f4133o = true;
    }

    public static void d() {
        NetworkInfo networkInfo;
        boolean z10;
        WifiInfo i10;
        ALog.d("awcn.NetworkStatusMonitor", "[checkNetworkStatus]", null, new Object[0]);
        NetworkStatusHelper.NetworkStatus networkStatus = f4121c;
        String str = f4123e;
        String str2 = f4124f;
        try {
            try {
                networkInfo = e();
                z10 = false;
            } catch (Exception e10) {
                ALog.e("awcn.NetworkStatusMonitor", "getNetworkInfo exception", null, e10, new Object[0]);
                a(NetworkStatusHelper.NetworkStatus.NONE, "unknown");
                networkInfo = null;
                z10 = true;
            }
            if (!z10) {
                if (networkInfo != null && networkInfo.isConnected()) {
                    ALog.i("awcn.NetworkStatusMonitor", "checkNetworkStatus", null, "info.isConnected", Boolean.valueOf(networkInfo.isConnected()), "info.isAvailable", Boolean.valueOf(networkInfo.isAvailable()), "info.getType", Integer.valueOf(networkInfo.getType()));
                    if (networkInfo.getType() == 0) {
                        String subtypeName = networkInfo.getSubtypeName();
                        String replace = TextUtils.isEmpty(subtypeName) ? "" : subtypeName.replace(" ", "");
                        a(a(networkInfo.getSubtype(), replace), replace);
                        f4123e = a(networkInfo.getExtraInfo());
                        h();
                    } else if (networkInfo.getType() == 1) {
                        a(NetworkStatusHelper.NetworkStatus.WIFI, "wifi");
                        if (AwcnConfig.isWifiInfoEnable() && (i10 = i()) != null && b("android.permission.ACCESS_FINE_LOCATION")) {
                            f4125g = i10.getBSSID();
                            f4124f = i10.getSSID();
                        }
                        f4126h = "wifi";
                        f4127i = "wifi";
                        f4128j = j();
                    } else {
                        a(NetworkStatusHelper.NetworkStatus.NONE, "unknown");
                    }
                    f4129k = networkInfo.isRoaming();
                    anet.channel.util.c.e();
                }
                a(NetworkStatusHelper.NetworkStatus.NO, "no network");
                ALog.i("awcn.NetworkStatusMonitor", "checkNetworkStatus", null, "no network");
            }
            if (f4121c == networkStatus && f4123e.equalsIgnoreCase(str) && f4124f.equalsIgnoreCase(str2)) {
                return;
            }
            if (ALog.isPrintLog(2)) {
                NetworkStatusHelper.printNetworkDetail();
            }
            NetworkStatusHelper.notifyStatusChanged(f4121c);
        } catch (Exception e11) {
            ALog.e("awcn.NetworkStatusMonitor", "checkNetworkStatus", null, e11, new Object[0]);
        }
    }

    public static NetworkInfo e() {
        if (f4134p == null) {
            f4134p = (ConnectivityManager) f4119a.getSystemService("connectivity");
        }
        return f4134p.getActiveNetworkInfo();
    }

    public static String f() {
        try {
            Method method = Class.forName("android.os.SystemProperties").getMethod("get", String.class);
            for (String str : f4131m) {
                String str2 = (String) method.invoke(null, str);
                if (!TextUtils.isEmpty(str2)) {
                    return str2;
                }
            }
        } catch (Exception unused) {
        }
        return null;
    }

    public static int g() {
        int restrictBackgroundStatus;
        if (f4134p == null || Build.VERSION.SDK_INT < 24) {
            return -1;
        }
        restrictBackgroundStatus = f4134p.getRestrictBackgroundStatus();
        return restrictBackgroundStatus;
    }

    private static void h() {
        CharSequence carrierName;
        SubscriptionManager from;
        try {
            if (AwcnConfig.isCarrierInfoEnable() && b("android.permission.READ_PHONE_STATE")) {
                if (f4135q == null) {
                    f4135q = (TelephonyManager) f4119a.getSystemService("phone");
                }
                f4127i = f4135q.getSimOperator();
                if (Build.VERSION.SDK_INT >= 22) {
                    if (f4137s == null) {
                        from = SubscriptionManager.from(f4119a);
                        f4137s = from;
                        f4138t = from.getClass().getDeclaredMethod("getDefaultDataSubscriptionInfo", new Class[0]);
                    }
                    Method method = f4138t;
                    if (method != null) {
                        carrierName = h.a(method.invoke(f4137s, new Object[0])).getCarrierName();
                        f4126h = carrierName.toString();
                    }
                }
            }
        } catch (Exception unused) {
        }
    }

    private static WifiInfo i() {
        try {
            if (f4136r == null) {
                f4136r = (WifiManager) f4119a.getSystemService("wifi");
            }
            return f4136r.getConnectionInfo();
        } catch (Throwable th) {
            ALog.e("awcn.NetworkStatusMonitor", "getWifiInfo", null, th, new Object[0]);
            return null;
        }
    }

    private static Pair<String, Integer> j() {
        try {
            String property = System.getProperty("http.proxyHost");
            if (TextUtils.isEmpty(property)) {
                return null;
            }
            return Pair.create(property, Integer.valueOf(Integer.parseInt(System.getProperty("http.proxyPort"))));
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    private static boolean b(String str) {
        int checkSelfPermission;
        if (Build.VERSION.SDK_INT < 23) {
            return false;
        }
        checkSelfPermission = f4119a.checkSelfPermission(str);
        return checkSelfPermission == 0;
    }

    private static void a(NetworkStatusHelper.NetworkStatus networkStatus, String str) {
        f4121c = networkStatus;
        f4122d = str;
        f4123e = "";
        f4124f = "";
        f4125g = "";
        f4128j = null;
        f4126h = "";
        f4127i = "";
    }

    private static NetworkStatusHelper.NetworkStatus a(int i10, String str) {
        switch (i10) {
            case 1:
            case 2:
            case 4:
            case 7:
            case 11:
            case 16:
                return NetworkStatusHelper.NetworkStatus.G2;
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
                return NetworkStatusHelper.NetworkStatus.G3;
            case 13:
            case 18:
            case 19:
                return NetworkStatusHelper.NetworkStatus.G4;
            case 20:
                return NetworkStatusHelper.NetworkStatus.G5;
            default:
                if (!str.equalsIgnoreCase("TD-SCDMA") && !str.equalsIgnoreCase("WCDMA") && !str.equalsIgnoreCase("CDMA2000")) {
                    return NetworkStatusHelper.NetworkStatus.NONE;
                }
                return NetworkStatusHelper.NetworkStatus.G3;
        }
    }

    private static String a(String str) {
        if (!TextUtils.isEmpty(str)) {
            String lowerCase = str.toLowerCase(Locale.US);
            if (lowerCase.contains("cmwap")) {
                return "cmwap";
            }
            if (lowerCase.contains("uniwap")) {
                return "uniwap";
            }
            if (lowerCase.contains("3gwap")) {
                return "3gwap";
            }
            if (lowerCase.contains("ctwap")) {
                return "ctwap";
            }
            if (lowerCase.contains("cmnet")) {
                return "cmnet";
            }
            if (lowerCase.contains("uninet")) {
                return "uninet";
            }
            if (lowerCase.contains("3gnet")) {
                return "3gnet";
            }
            if (lowerCase.contains("ctnet")) {
                return "ctnet";
            }
        }
        return "unknown";
    }
}
