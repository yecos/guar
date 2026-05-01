package com.umeng.message.proguard;

import android.app.AppOpsManager;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.res.Configuration;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.hpplay.sdk.source.common.store.Session;
import com.raizlabs.android.dbflow.sql.language.Operator;
import com.taobao.accs.common.Constants;
import com.umeng.commonsdk.statistics.common.DeviceConfig;
import com.umeng.commonsdk.utils.UMUtils;
import com.umeng.message.PushAgent;
import com.umeng.message.api.UPushThirdTokenCallback;
import com.umeng.message.common.UPLog;
import com.umeng.ut.device.UTDevice;
import java.lang.reflect.Field;
import java.util.Calendar;
import java.util.Locale;

/* loaded from: classes3.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public static String f11853a;

    /* renamed from: b, reason: collision with root package name */
    public static String f11854b;

    /* renamed from: c, reason: collision with root package name */
    public static String f11855c;

    /* renamed from: d, reason: collision with root package name */
    private static String f11856d;

    /* renamed from: e, reason: collision with root package name */
    private static Boolean f11857e;

    /* renamed from: f, reason: collision with root package name */
    private static Boolean f11858f;

    /* renamed from: g, reason: collision with root package name */
    private static String f11859g;

    /* renamed from: h, reason: collision with root package name */
    private static Boolean f11860h;

    public static String a(Context context) {
        return UMUtils.getAppVersionCode(context);
    }

    public static String b(Context context) {
        return UMUtils.getAppVersionName(context);
    }

    public static String c() {
        return Session.DEFAULT_M;
    }

    public static String d(Context context) {
        String s10;
        String str = "";
        try {
            s10 = s(context);
        } catch (Exception e10) {
            e = e10;
        }
        try {
            if (TextUtils.isEmpty(s10)) {
                return "";
            }
            String messageAppkey = PushAgent.getInstance(context).getMessageAppkey();
            if (messageAppkey == null || messageAppkey.length() < 16) {
                return s10;
            }
            return bk.a(s10, messageAppkey.substring(0, 16), bf.a("bm1ldWcuZjkvT20rTDgyMw=="));
        } catch (Exception e11) {
            e = e11;
            str = s10;
            UPLog.e("DeviceConfig", e);
            return str;
        }
    }

    public static String e(Context context) {
        return DeviceConfig.getAndroidId(context);
    }

    public static String f(Context context) {
        return UMUtils.MD5(s(context));
    }

    public static String[] g(Context context) {
        return UMUtils.getNetworkAccessMode(context);
    }

    public static boolean h(Context context) {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo != null) {
                return activeNetworkInfo.isConnectedOrConnecting();
            }
            return true;
        } catch (Throwable th) {
            UPLog.e("DeviceConfig", th);
            return true;
        }
    }

    public static int i(Context context) {
        try {
            return Calendar.getInstance(t(context)).getTimeZone().getRawOffset() / 3600000;
        } catch (Exception e10) {
            UPLog.e("DeviceConfig", e10);
            return 8;
        }
    }

    public static String[] j(Context context) {
        String[] strArr = new String[2];
        try {
            Locale t10 = t(context);
            strArr[0] = t10.getCountry();
            strArr[1] = t10.getLanguage();
            if (TextUtils.isEmpty(strArr[0])) {
                strArr[0] = "Unknown";
            }
            if (TextUtils.isEmpty(strArr[1])) {
                strArr[1] = "Unknown";
            }
            return strArr;
        } catch (Exception e10) {
            UPLog.e("DeviceConfig", e10);
            return strArr;
        }
    }

    public static String k(Context context) {
        String uMId = UMUtils.getUMId(context);
        return uMId == null ? "" : uMId;
    }

    public static String l(Context context) {
        int i10;
        int i11;
        try {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
            if ((context.getApplicationInfo().flags & 8192) == 0) {
                i11 = a(displayMetrics, "noncompatWidthPixels");
                i10 = a(displayMetrics, "noncompatHeightPixels");
            } else {
                i10 = 0;
                i11 = -1;
            }
            if (i11 == -1 || i10 == -1) {
                i11 = displayMetrics.widthPixels;
                i10 = displayMetrics.heightPixels;
            }
            return i11 + Operator.Operation.MULTIPLY + i10;
        } catch (Exception e10) {
            UPLog.e("DeviceConfig", e10);
            return "Unknown";
        }
    }

    public static String m(Context context) {
        try {
            return UMUtils.getOperator(context);
        } catch (Throwable unused) {
            return "Unknown";
        }
    }

    public static String n(Context context) {
        String channelByXML = UMUtils.getChannelByXML(context);
        return !TextUtils.isEmpty(channelByXML) ? channelByXML : "Unknown";
    }

    public static String o(Context context) {
        try {
            return UTDevice.getUtdid(context);
        } catch (Throwable th) {
            UPLog.e("DeviceConfig", "utdid failed! " + th.getMessage());
            return "";
        }
    }

    public static String p(Context context) {
        int q10 = q(context);
        return q10 == 0 ? Boolean.toString(false) : q10 == 1 ? Boolean.toString(true) : "unknown";
    }

    public static int q(Context context) {
        boolean areNotificationsEnabled;
        if (f.b()) {
            UPLog.i("DeviceConfig", "silent mode disabled");
            return -1;
        }
        if (Build.VERSION.SDK_INT >= 24) {
            try {
                areNotificationsEnabled = ((NotificationManager) context.getSystemService("notification")).areNotificationsEnabled();
                return areNotificationsEnabled ? 1 : 0;
            } catch (Throwable th) {
                UPLog.e("DeviceConfig", th);
                return -1;
            }
        }
        try {
            AppOpsManager appOpsManager = (AppOpsManager) context.getSystemService("appops");
            ApplicationInfo applicationInfo = context.getApplicationInfo();
            String packageName = context.getApplicationContext().getPackageName();
            int i10 = applicationInfo.uid;
            Class<?> cls = Class.forName(AppOpsManager.class.getName());
            Class<?> cls2 = Integer.TYPE;
            return ((Integer) cls.getMethod("checkOpNoThrow", cls2, cls2, String.class).invoke(appOpsManager, Integer.valueOf(((Integer) cls.getDeclaredField("OP_POST_NOTIFICATION").get(appOpsManager)).intValue()), Integer.valueOf(i10), packageName)).intValue() == 0 ? 1 : 0;
        } catch (Exception e10) {
            UPLog.e("DeviceConfig", e10);
            return -1;
        }
    }

    public static boolean r(Context context) {
        if (f.b()) {
            UPLog.i("DeviceConfig", "silent mode disabled");
            return false;
        }
        try {
            Intent intent = new Intent("android.settings.APP_NOTIFICATION_SETTINGS");
            int i10 = Build.VERSION.SDK_INT;
            if (i10 >= 26) {
                intent.putExtra("android.provider.extra.APP_PACKAGE", context.getPackageName());
                intent.putExtra("android.provider.extra.CHANNEL_ID", context.getApplicationInfo().uid);
            } else if (i10 >= 21) {
                intent.putExtra("app_package", context.getPackageName());
                intent.putExtra("app_uid", context.getApplicationInfo().uid);
            }
            intent.setFlags(268435456);
            context.startActivity(intent);
            return true;
        } catch (Throwable th) {
            UPLog.e("DeviceConfig", th);
            try {
                Intent intent2 = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
                intent2.setData(Uri.fromParts(Constants.KEY_PACKAGE, context.getPackageName(), null));
                intent2.setFlags(268435456);
                context.startActivity(intent2);
                return true;
            } catch (Throwable th2) {
                UPLog.e("DeviceConfig", th2);
                return false;
            }
        }
    }

    private static String s(Context context) {
        if (!TextUtils.isEmpty(f11856d)) {
            return f11856d;
        }
        String imeiNew = DeviceConfig.getImeiNew(context);
        f11856d = imeiNew;
        if (!TextUtils.isEmpty(imeiNew)) {
            return f11856d;
        }
        String androidId = DeviceConfig.getAndroidId(context);
        f11856d = androidId;
        if (!TextUtils.isEmpty(androidId)) {
            return f11856d;
        }
        String serial = DeviceConfig.getSerial();
        f11856d = serial;
        if (TextUtils.isEmpty(serial)) {
            f11856d = "";
        }
        return f11856d;
    }

    private static Locale t(Context context) {
        Locale locale;
        try {
            Configuration configuration = new Configuration();
            Settings.System.getConfiguration(context.getContentResolver(), configuration);
            locale = configuration.locale;
        } catch (Exception e10) {
            UPLog.e("DeviceConfig", e10);
            locale = null;
        }
        return locale == null ? Locale.getDefault() : locale;
    }

    public static String a() {
        return UMUtils.getCPU();
    }

    public static String b() {
        return DeviceConfig.getSerial();
    }

    public static String c(Context context) {
        String imeiNew;
        String str = "";
        try {
            imeiNew = DeviceConfig.getImeiNew(context);
        } catch (Exception e10) {
            e = e10;
        }
        try {
            if (TextUtils.isEmpty(imeiNew)) {
                return "";
            }
            String messageAppkey = PushAgent.getInstance(context).getMessageAppkey();
            if (messageAppkey == null || messageAppkey.length() < 16) {
                return imeiNew;
            }
            return bk.a(imeiNew, messageAppkey.substring(0, 16), bf.a("bm1ldWcuZjkvT20rTDgyMw=="));
        } catch (Exception e11) {
            e = e11;
            str = imeiNew;
            UPLog.e("DeviceConfig", e);
            return str;
        }
    }

    public static String e() {
        if (TextUtils.isEmpty(f11855c)) {
            f11855c = Build.BOARD;
        }
        return f11855c;
    }

    public static String f() {
        if (TextUtils.isEmpty(f11854b)) {
            String str = Build.BRAND;
            f11854b = str;
            if (TextUtils.isEmpty(str)) {
                f11854b = Build.MANUFACTURER;
            }
        }
        return f11854b;
    }

    public static boolean g() {
        String f10;
        Boolean bool = f11857e;
        if (bool != null) {
            return bool.booleanValue();
        }
        try {
            f10 = f();
        } catch (Throwable unused) {
        }
        if ("huawei".equalsIgnoreCase(f10)) {
            f11857e = Boolean.TRUE;
            return true;
        }
        if (UPushThirdTokenCallback.TYPE_HONOR.equalsIgnoreCase(f10)) {
            f11857e = Boolean.TRUE;
            return true;
        }
        f11857e = Boolean.FALSE;
        return false;
    }

    public static String k() {
        return a("debug.umeng.push");
    }

    public static String a(Context context, String str) {
        try {
            String string = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData.getString(str);
            if (string != null) {
                return string.trim();
            }
        } catch (Exception e10) {
            UPLog.e("DeviceConfig", e10);
        }
        UPLog.w("DeviceConfig", String.format("Could not read meta-data %s from AndroidManifest.xml.", str));
        return null;
    }

    public static boolean h() {
        Boolean bool = f11858f;
        if (bool != null) {
            return bool.booleanValue();
        }
        if ("vivo".equalsIgnoreCase(f())) {
            f11858f = Boolean.TRUE;
            return true;
        }
        String l10 = l();
        if (TextUtils.isEmpty(l10)) {
            f11858f = Boolean.FALSE;
            return false;
        }
        if (l10.startsWith("OriginOS") || l10.startsWith("Funtouch")) {
            f11858f = Boolean.TRUE;
            return true;
        }
        f11858f = Boolean.FALSE;
        return false;
    }

    public static boolean i() {
        Boolean bool = f11860h;
        if (bool != null) {
            return bool.booleanValue();
        }
        try {
            Class<?> cls = Class.forName("com.huawei.system.BuildEx");
            Boolean valueOf = Boolean.valueOf("harmony".equalsIgnoreCase((String) cls.getMethod("getOsBrand", new Class[0]).invoke(cls, new Object[0])));
            f11860h = valueOf;
            return valueOf.booleanValue();
        } catch (Throwable unused) {
            f11860h = Boolean.FALSE;
            return false;
        }
    }

    public static String j() {
        return a("hw_sc.build.platform.version");
    }

    private static int a(Object obj, String str) {
        try {
            Field declaredField = DisplayMetrics.class.getDeclaredField(str);
            declaredField.setAccessible(true);
            return declaredField.getInt(obj);
        } catch (Exception e10) {
            UPLog.e("DeviceConfig", e10);
            return -1;
        }
    }

    public static String d() {
        if (TextUtils.isEmpty(f11853a)) {
            f11853a = Build.MODEL;
        }
        return f11853a;
    }

    private static String l() {
        String str = f11859g;
        if (str != null) {
            return str;
        }
        if (!"vivo".equalsIgnoreCase(f())) {
            f11859g = "";
            return "";
        }
        String a10 = a("ro.vivo.os.build.display.id");
        f11859g = a10;
        if (!TextUtils.isEmpty(a10)) {
            return f11859g;
        }
        String a11 = a("ro.iqoo.os.build.display.id");
        f11859g = a11;
        if (!TextUtils.isEmpty(a11)) {
            return f11859g;
        }
        f11859g = "";
        return "";
    }

    private static String a(String str) {
        try {
            return (String) bn.a("android.os.SystemProperties", "get", new Class[]{String.class}, null, new Object[]{str});
        } catch (Throwable unused) {
            return "";
        }
    }
}
