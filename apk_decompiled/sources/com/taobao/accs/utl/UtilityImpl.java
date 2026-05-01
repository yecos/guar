package com.taobao.accs.utl;

import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Process;
import android.text.TextUtils;
import anet.channel.GlobalAppRuntimeInfo;
import anet.channel.util.HMacUtil;
import com.hpplay.cybergarage.soap.SOAP;
import com.hpplay.cybergarage.xml.XML;
import com.taobao.accs.client.GlobalClientInfo;
import com.taobao.accs.common.Constants;
import com.taobao.accs.utl.ALog;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/* loaded from: classes3.dex */
public class UtilityImpl {
    public static final String NET_TYPE_2G = "2g";
    public static final String NET_TYPE_3G = "3g";
    public static final String NET_TYPE_4G = "4g";
    public static final String NET_TYPE_UNKNOWN = "unknown";
    public static final String NET_TYPE_WIFI = "wifi";

    /* renamed from: a, reason: collision with root package name */
    private static final byte[] f9316a = new byte[0];

    public static String a(Context context) {
        String string = context.getSharedPreferences(Constants.SP_FILE_NAME, 4).getString(Constants.KEY_PROXY_HOST, null);
        if (!TextUtils.isEmpty(string)) {
            return string;
        }
        String f10 = f();
        if (TextUtils.isEmpty(f10)) {
            return null;
        }
        return f10;
    }

    public static int b() {
        return -1;
    }

    public static byte[] c() {
        return null;
    }

    public static String d() {
        return "null";
    }

    public static void disableService(Context context) {
        ComponentName componentName = new ComponentName(context, j.channelService);
        PackageManager packageManager = context.getPackageManager();
        try {
            ALog.d("UtilityImpl", "disableService, cn=" + componentName.toString(), new Object[0]);
            if (packageManager.getServiceInfo(componentName, 128).enabled) {
                packageManager.setComponentEnabledSetting(componentName, 2, 1);
                killService(context);
            }
        } catch (Throwable unused) {
        }
    }

    public static boolean e(Context context) {
        try {
        } catch (Exception e10) {
            e10.printStackTrace();
            ALog.e("UtilityImpl", j.a(e10), new Object[0]);
        }
        return context.getPackageManager().getServiceInfo(new ComponentName(context, j.channelService), 128).enabled;
    }

    public static void enableService(Context context) {
        ComponentName componentName = new ComponentName(context, j.channelService);
        ALog.d("UtilityImpl", "enableService", "comptName", componentName);
        try {
            context.getPackageManager().setComponentEnabledSetting(componentName, 1, 1);
        } catch (Exception e10) {
            ALog.w("UtilityImpl", "enableService", e10, new Object[0]);
        }
    }

    public static boolean f(Context context) {
        context.getPackageName();
        ComponentName componentName = new ComponentName(context, com.taobao.accs.client.a.b());
        PackageManager packageManager = context.getPackageManager();
        if (!componentName.getPackageName().equals("!")) {
            return packageManager.getServiceInfo(componentName, 128).enabled;
        }
        ALog.e("UtilityImpl", "getAgooServiceEnabled,exception,comptName.getPackageName()=" + componentName.getPackageName(), new Object[0]);
        return false;
    }

    public static void focusDisableService(Context context) {
        try {
            synchronized (f9316a) {
                SharedPreferences.Editor edit = context.getSharedPreferences(Constants.SP_FILE_NAME, 0).edit();
                edit.putBoolean(Constants.KEY_FOUCE_DISABLE, true);
                edit.apply();
                disableService(context);
            }
        } catch (Throwable th) {
            ALog.e("UtilityImpl", "focusDisableService", th, new Object[0]);
        }
    }

    public static void focusEnableService(Context context) {
        try {
            synchronized (f9316a) {
                SharedPreferences.Editor edit = context.getSharedPreferences(Constants.SP_FILE_NAME, 0).edit();
                edit.putBoolean(Constants.KEY_FOUCE_DISABLE, false);
                edit.apply();
                enableService(context);
            }
        } catch (Throwable th) {
            ALog.e("UtilityImpl", "focusEnableService", th, new Object[0]);
        }
    }

    public static String g(Context context) {
        NetworkInfo networkInfo;
        try {
            networkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        } catch (Throwable unused) {
            networkInfo = null;
        }
        if (networkInfo == null) {
            return "unknown";
        }
        if (networkInfo.getType() == 1) {
            return "wifi";
        }
        String subtypeName = networkInfo.getSubtypeName();
        return !TextUtils.isEmpty(subtypeName) ? subtypeName.replaceAll(" ", "") : "";
    }

    public static String h(Context context) {
        NetworkInfo activeNetworkInfo;
        try {
            activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        } catch (Throwable th) {
            ALog.e("UtilityImpl", "getNetworkTypeExt", th, new Object[0]);
            return null;
        }
        if (activeNetworkInfo == null) {
            return "unknown";
        }
        if (activeNetworkInfo.getType() == 1) {
            return "wifi";
        }
        switch (activeNetworkInfo.getSubtype()) {
            case 1:
            case 2:
            case 4:
            case 7:
            case 11:
                return "2g";
            case 3:
            case 5:
            case 6:
            case 8:
            case 9:
            case 10:
            case 12:
            case 14:
            case 15:
                return "3g";
            case 13:
                return "4g";
            default:
                String subtypeName = activeNetworkInfo.getSubtypeName();
                if (TextUtils.isEmpty(subtypeName)) {
                    return "unknown";
                }
                if (!subtypeName.equalsIgnoreCase("td-scdma") && !subtypeName.equalsIgnoreCase("td_scdma")) {
                    if (!subtypeName.equalsIgnoreCase("tds_hsdpa")) {
                        return "unknown";
                    }
                }
                return "3g";
        }
        ALog.e("UtilityImpl", "getNetworkTypeExt", th, new Object[0]);
        return null;
    }

    public static boolean i(Context context) {
        if (context != null) {
            try {
                NetworkInfo activeNetworkInfo = GlobalClientInfo.getInstance(context).getConnectivityManager().getActiveNetworkInfo();
                if (activeNetworkInfo != null) {
                    return activeNetworkInfo.isConnected();
                }
            } catch (Throwable th) {
                ALog.e("UtilityImpl", "isNetworkConnected", th, new Object[0]);
            }
        }
        return false;
    }

    public static boolean isMainProcess(Context context) {
        return j.a(context);
    }

    public static String j(Context context) {
        return j.b(context);
    }

    public static long k(Context context) {
        long j10 = 0;
        try {
            SharedPreferences sharedPreferences = context.getSharedPreferences(Constants.SP_CHANNEL_FILE_NAME, 0);
            long j11 = sharedPreferences.getLong(Constants.SP_KEY_SERVICE_START, 0L);
            long j12 = j11 > 0 ? sharedPreferences.getLong(Constants.SP_KEY_SERVICE_END, 0L) - j11 : 0L;
            try {
                SharedPreferences.Editor edit = sharedPreferences.edit();
                edit.putLong(Constants.SP_KEY_SERVICE_START, 0L);
                edit.putLong(Constants.SP_KEY_SERVICE_END, 0L);
                edit.apply();
                return j12;
            } catch (Throwable th) {
                th = th;
                j10 = j12;
                ALog.e("UtilityImpl", "getServiceAliveTime:", th, new Object[0]);
                return j10;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static void killService(Context context) {
        try {
            int myUid = Process.myUid();
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            if (activityManager == null) {
                return;
            }
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : activityManager.getRunningAppProcesses()) {
                if (runningAppProcessInfo.uid == myUid) {
                    if (!TextUtils.isEmpty(com.taobao.accs.client.a.f9048d) && com.taobao.accs.client.a.f9048d.equals(runningAppProcessInfo.processName)) {
                        ALog.e("UtilityImpl", "killService", "processName", runningAppProcessInfo.processName);
                        Process.killProcess(runningAppProcessInfo.pid);
                        return;
                    } else if (runningAppProcessInfo.processName.endsWith(":channel")) {
                        ALog.e("UtilityImpl", "killService", "processName", runningAppProcessInfo.processName);
                        Process.killProcess(runningAppProcessInfo.pid);
                        return;
                    }
                }
            }
            ALog.e("UtilityImpl", "kill nothing", new Object[0]);
        } catch (Throwable th) {
            ALog.e("UtilityImpl", "killService", th, new Object[0]);
        }
    }

    public static String l(Context context) {
        try {
            return GlobalClientInfo.getInstance(context).getPackageInfo().versionName;
        } catch (Exception e10) {
            e10.printStackTrace();
            return "";
        }
    }

    public static String m(Context context) {
        try {
            return context.getSharedPreferences(Constants.SP_COOKIE_FILE_NAME, 4).getString(Constants.SP_KEY_COOKIE_SEC, null);
        } catch (Exception e10) {
            ALog.e("UtilityImpl", "reStoreCookie fail", e10, new Object[0]);
            return null;
        }
    }

    public static void n(Context context) {
        try {
            GlobalClientInfo.f9033c = null;
            SharedPreferences.Editor edit = context.getSharedPreferences(Constants.SP_COOKIE_FILE_NAME, 0).edit();
            edit.clear();
            edit.apply();
        } catch (Throwable th) {
            ALog.e("UtilityImpl", "clearCookie fail", th, new Object[0]);
        }
    }

    public static String o(Context context) {
        return j.c(context);
    }

    private static void p(Context context) {
        try {
            SharedPreferences.Editor edit = context.getSharedPreferences(Constants.SP_FILE_NAME, 0).edit();
            edit.putInt(Constants.KEY_APP_VERSION_CODE, GlobalClientInfo.getInstance(context).getPackageInfo().versionCode);
            edit.putString(Constants.KEY_APP_VERSION_NAME, GlobalClientInfo.getInstance(context).getPackageInfo().versionName);
            edit.apply();
        } catch (Throwable th) {
            ALog.e("UtilityImpl", "saveAppVersion", th, new Object[0]);
        }
    }

    public static int b(Context context) {
        int i10 = context.getSharedPreferences(Constants.SP_FILE_NAME, 4).getInt(Constants.KEY_PROXY_PORT, -1);
        if (i10 > 0) {
            return i10;
        }
        if (a(context) == null) {
            return -1;
        }
        try {
            return g();
        } catch (NumberFormatException unused) {
            return -1;
        }
    }

    public static boolean c(Context context) {
        String str;
        int i10;
        synchronized (f9316a) {
            SharedPreferences sharedPreferences = context.getSharedPreferences(Constants.SP_FILE_NAME, 0);
            PackageInfo packageInfo = GlobalClientInfo.getInstance(context).getPackageInfo();
            int i11 = sharedPreferences.getInt(Constants.KEY_APP_VERSION_CODE, -1);
            String string = sharedPreferences.getString(Constants.KEY_APP_VERSION_NAME, "");
            if (packageInfo != null) {
                i10 = packageInfo.versionCode;
                str = packageInfo.versionName;
            } else {
                str = null;
                i10 = 0;
            }
            if (i11 == i10 && string.equals(str)) {
                return false;
            }
            p(context);
            ALog.i("UtilityImpl", "appVersionChanged", "oldV", Integer.valueOf(i11), "nowV", Integer.valueOf(i10), "oldN", string, "nowN", str);
            return true;
        }
    }

    public static boolean d(Context context) {
        boolean z10;
        if (context == null) {
            return false;
        }
        try {
        } catch (Exception e10) {
            e = e10;
            context = null;
        }
        try {
            synchronized (f9316a) {
                try {
                    z10 = context.getSharedPreferences(Constants.SP_FILE_NAME, 0).getBoolean(Constants.KEY_FOUCE_DISABLE, false);
                    return z10;
                } catch (Throwable th) {
                    th = th;
                    context = null;
                    try {
                        throw th;
                    } catch (Exception e11) {
                        e = e11;
                        ALog.e("UtilityImpl", "getFocusDisableStatus", e, new Object[0]);
                        z10 = context;
                        return z10;
                    }
                }
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static boolean j() {
        try {
            Class<?> cls = Class.forName("com.huawei.system.BuildEx");
            return "harmony".equalsIgnoreCase((String) cls.getMethod("getOsBrand", new Class[0]).invoke(cls, new Object[0]));
        } catch (Throwable unused) {
            return false;
        }
    }

    public static String i() {
        Class<?>[] clsArr = {String.class};
        Object[] objArr = {"ro.build.version.emui"};
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            String str = (String) cls.getDeclaredMethod("get", clsArr).invoke(cls, objArr);
            ALog.d("UtilityImpl", "getEmuiVersion", "result", str);
            return !TextUtils.isEmpty(str) ? str : "";
        } catch (Exception e10) {
            ALog.e("UtilityImpl", "getEmuiVersion", e10, new Object[0]);
            return "";
        }
    }

    public static String a(long j10) {
        try {
            return new SimpleDateFormat("yyyy-MM-dd", Locale.US).format(Long.valueOf(j10));
        } catch (Throwable th) {
            ALog.e("UtilityImpl", "formatDay", th, new Object[0]);
            return "";
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static boolean b(String str, Context context) {
        boolean z10;
        try {
            try {
            } catch (Throwable th) {
                th = th;
            }
        } catch (Throwable th2) {
            th = th2;
            str = null;
        }
        synchronized (f9316a) {
            try {
                z10 = !context.getSharedPreferences(str, 0).getString(Constants.SP_KEY_NOTIFICATION_STATE, "").equals(j.c(context));
                return z10;
            } catch (Throwable th3) {
                th = th3;
                str = null;
                try {
                    throw th;
                } catch (Throwable th4) {
                    th = th4;
                    ALog.e("UtilityImpl", "notificationStateChanged", th, new Object[0]);
                    z10 = str;
                    return z10;
                }
            }
        }
    }

    public static String d(String str, Context context) {
        String string;
        try {
            synchronized (f9316a) {
                string = context.getSharedPreferences(str, 0).getString("utdid", j.b(context));
            }
            return string;
        } catch (Throwable th) {
            ALog.e("UtilityImpl", "getUtdid", th, new Object[0]);
            return "";
        }
    }

    public static String f() {
        return System.getProperty("http.proxyHost");
    }

    public static int g() {
        try {
            return Integer.parseInt(System.getProperty("http.proxyPort"));
        } catch (NumberFormatException unused) {
            return -1;
        }
    }

    public static long e() {
        return j.a();
    }

    public static boolean a() {
        try {
            return !GlobalAppRuntimeInfo.isAppBackground();
        } catch (Throwable th) {
            ALog.e("UtilityImpl", "isForeground error ", th, new Object[0]);
            return false;
        }
    }

    public static String k() {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            String str = (String) cls.getDeclaredMethod("get", String.class).invoke(cls, "hw_sc.build.platform.version");
            ALog.d("UtilityImpl", "getOhosVersion", "result", str);
            return !TextUtils.isEmpty(str) ? str : "";
        } catch (Exception e10) {
            ALog.e("UtilityImpl", "getOhosVersion", e10, new Object[0]);
            return "";
        }
    }

    public static String a(String str, String str2, String str3) {
        String str4 = null;
        if (TextUtils.isEmpty(str)) {
            ALog.e("UtilityImpl", "getAppsign appkey null", new Object[0]);
            return null;
        }
        try {
            if (!TextUtils.isEmpty(str2)) {
                str4 = HMacUtil.hmacSha1Hex(str2.getBytes(), (str + str3).getBytes());
            } else {
                ALog.e("UtilityImpl", "getAppsign secret null", new Object[0]);
            }
        } catch (Throwable th) {
            ALog.e("UtilityImpl", "getAppsign", th, new Object[0]);
        }
        return str4;
    }

    public static String h() {
        String str = f() + SOAP.DELIM + g();
        if (ALog.isPrintLog(ALog.Level.D)) {
            ALog.d("UtilityImpl", "getProxy:" + str, new Object[0]);
        }
        return str;
    }

    public static void b(Context context, String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            GlobalClientInfo.f9033c = str;
            SharedPreferences.Editor edit = context.getSharedPreferences(Constants.SP_COOKIE_FILE_NAME, 0).edit();
            edit.putString(Constants.SP_KEY_COOKIE_SEC, str);
            edit.apply();
        } catch (Exception e10) {
            ALog.e("UtilityImpl", "storeCookie fail", e10, new Object[0]);
        }
    }

    public static void c(String str, Context context) {
        try {
            synchronized (f9316a) {
                SharedPreferences.Editor edit = context.getSharedPreferences(str, 0).edit();
                edit.putString("utdid", j.b(context));
                edit.apply();
            }
        } catch (Throwable th) {
            ALog.e("UtilityImpl", "saveUtdid", th, new Object[0]);
        }
    }

    public static boolean a(Context context, String str) {
        try {
            context.getPackageManager().getPackageInfo(str, 0);
            return true;
        } catch (Throwable unused) {
            ALog.e("UtilityImpl", "package not exist", "pkg", str);
            return false;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static boolean a(String str, Context context) {
        boolean z10;
        try {
            try {
            } catch (Throwable th) {
                th = th;
            }
        } catch (Throwable th2) {
            th = th2;
            str = null;
        }
        synchronized (f9316a) {
            try {
                z10 = !context.getSharedPreferences(str, 0).getString("utdid", "").equals(j.b(context));
                return z10;
            } catch (Throwable th3) {
                th = th3;
                str = null;
                try {
                    throw th;
                } catch (Throwable th4) {
                    th = th4;
                    ALog.e("UtilityImpl", "utdidChanged", th, new Object[0]);
                    z10 = str;
                    return z10;
                }
            }
        }
    }

    public static String b(String str) {
        try {
            return URLEncoder.encode(str, XML.CHARSET_UTF8);
        } catch (UnsupportedEncodingException unused) {
            return str;
        }
    }

    public static void a(Context context, String str, long j10) {
        try {
            SharedPreferences.Editor edit = context.getSharedPreferences(Constants.SP_CHANNEL_FILE_NAME, 0).edit();
            edit.putLong(str, j10);
            edit.apply();
            ALog.d("UtilityImpl", "setServiceTime:" + j10, new Object[0]);
        } catch (Throwable th) {
            ALog.e("UtilityImpl", "setServiceTime:", th, new Object[0]);
        }
    }

    public static void a(Context context, String str, String str2) {
        try {
            SharedPreferences.Editor edit = context.getSharedPreferences(str, 4).edit();
            edit.putString(Constants.SP_KEY_NOTIFICATION_STATE, str2);
            edit.apply();
        } catch (Exception e10) {
            ALog.e("UtilityImpl", "saveNotificationState fail", e10, new Object[0]);
        }
    }

    public static int a(String str) {
        if (str == null) {
            return 0;
        }
        try {
            return str.getBytes(XML.CHARSET_UTF8).length;
        } catch (UnsupportedEncodingException e10) {
            e10.printStackTrace();
            return 0;
        }
    }

    public static String a(Throwable th) {
        return j.a(th);
    }

    public static String a(int i10) {
        try {
            return String.valueOf(i10);
        } catch (Exception e10) {
            ALog.e("UtilityImpl", "int2String", e10, new Object[0]);
            return null;
        }
    }

    public static final Map<String, String> a(Map<String, List<String>> map) {
        HashMap hashMap = new HashMap();
        try {
            for (Map.Entry<String, List<String>> entry : map.entrySet()) {
                String key = entry.getKey();
                if (!TextUtils.isEmpty(key)) {
                    String a10 = a(entry.getValue());
                    if (!TextUtils.isEmpty(a10)) {
                        if (!key.startsWith(SOAP.DELIM)) {
                            key = key.toLowerCase(Locale.US);
                        }
                        hashMap.put(key, a10);
                    }
                }
            }
        } catch (Throwable unused) {
        }
        return hashMap;
    }

    public static final String a(List<String> list) {
        StringBuffer stringBuffer = new StringBuffer();
        int size = list.size();
        for (int i10 = 0; i10 < size; i10++) {
            stringBuffer.append(list.get(i10));
            if (i10 < size - 1) {
                stringBuffer.append(",");
            }
        }
        return stringBuffer.toString();
    }

    public static boolean a(long j10, long j11) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date(j10));
        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTime(new Date(j11));
        return calendar.get(1) == calendar2.get(1) && calendar.get(2) == calendar2.get(2) && calendar.get(5) == calendar2.get(5);
    }
}
