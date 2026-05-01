package com.umeng.analytics;

import android.content.Context;
import android.text.TextUtils;
import com.umeng.analytics.pro.bd;
import com.umeng.analytics.pro.l;
import com.umeng.commonsdk.debug.UMLog;
import com.umeng.commonsdk.utils.UMUtils;
import java.util.Map;

/* loaded from: classes3.dex */
public class AnalyticsConfig {
    public static boolean CATCH_EXCEPTION = false;
    public static boolean CHANGE_CATCH_EXCEPTION_NOTALLOW = true;
    public static boolean CLEAR_EKV_BL = false;
    public static boolean CLEAR_EKV_WL = false;
    public static final String DEBUG_KEY = "debugkey";
    public static final String DEBUG_MODE_PERIOD = "sendaging";
    public static String GPU_RENDERER = "";
    public static String GPU_VENDER = "";
    public static final String RTD_PERIOD = "period";
    public static final String RTD_START_TIME = "startTime";

    /* renamed from: a, reason: collision with root package name */
    static double[] f9755a = null;

    /* renamed from: b, reason: collision with root package name */
    private static String f9756b = null;

    /* renamed from: c, reason: collision with root package name */
    private static String f9757c = null;

    /* renamed from: d, reason: collision with root package name */
    private static String f9758d = null;

    /* renamed from: e, reason: collision with root package name */
    private static int f9759e = 0;
    public static boolean enable = true;
    public static long kContinueSessionMillis = 30000;
    public static String mWrapperType;
    public static String mWrapperVersion;
    public static final String RTD_SP_FILE = bd.b().b(bd.A);

    /* renamed from: f, reason: collision with root package name */
    private static Object f9760f = new Object();

    /* renamed from: g, reason: collision with root package name */
    private static boolean f9761g = false;

    /* renamed from: h, reason: collision with root package name */
    private static String f9762h = "";

    public static void a(String str) {
        f9757c = str;
    }

    public static String getAppkey(Context context) {
        return UMUtils.getAppkey(context);
    }

    public static String getChannel(Context context) {
        return UMUtils.getChannel(context);
    }

    public static String getGameSdkVersion(Context context) {
        try {
            Class<?> cls = Class.forName("com.umeng.analytics.game.GameSdkVersion");
            return (String) cls.getDeclaredField("SDK_VERSION").get(cls);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static double[] getLocation() {
        return f9755a;
    }

    public static String getRealTimeDebugKey() {
        String str;
        synchronized (f9760f) {
            str = f9762h;
        }
        return str;
    }

    public static String getSecretKey(Context context) {
        if (TextUtils.isEmpty(f9758d)) {
            f9758d = com.umeng.common.b.a(context).c();
        }
        return f9758d;
    }

    public static int getVerticalType(Context context) {
        if (f9759e == 0) {
            f9759e = com.umeng.common.b.a(context).d();
        }
        return f9759e;
    }

    public static boolean isRealTimeDebugMode() {
        boolean z10;
        synchronized (f9760f) {
            z10 = f9761g;
        }
        return z10;
    }

    public static void turnOffRealTimeDebug() {
        synchronized (f9760f) {
            f9761g = false;
            f9762h = "";
        }
    }

    public static void turnOnRealTimeDebug(Map<String, String> map) {
        synchronized (f9760f) {
            f9761g = true;
            if (map != null && map.containsKey("debugkey")) {
                f9762h = map.get("debugkey");
            }
        }
    }

    public static void a(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            UMLog.aq(l.A, 0, "\\|");
        } else {
            f9758d = str;
            com.umeng.common.b.a(context).a(f9758d);
        }
    }

    public static void a(Context context, int i10) {
        f9759e = i10;
        com.umeng.common.b.a(context).a(f9759e);
    }
}
