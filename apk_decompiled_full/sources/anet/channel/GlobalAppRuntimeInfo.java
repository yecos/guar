package anet.channel;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Process;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import anet.channel.entity.ENV;
import anet.channel.strategy.StrategyCenter;
import anet.channel.strategy.dispatch.AmdcRuntimeInfo;
import anet.channel.strategy.dispatch.DispatchConstants;
import anet.channel.util.ALog;
import anet.channel.util.Utils;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes.dex */
public class GlobalAppRuntimeInfo {

    /* renamed from: a, reason: collision with root package name */
    private static Context f3799a;

    /* renamed from: e, reason: collision with root package name */
    private static String f3803e;

    /* renamed from: f, reason: collision with root package name */
    private static String f3804f;

    /* renamed from: g, reason: collision with root package name */
    private static String f3805g;

    /* renamed from: k, reason: collision with root package name */
    private static volatile long f3809k;

    /* renamed from: l, reason: collision with root package name */
    private static String f3810l;

    /* renamed from: b, reason: collision with root package name */
    private static ENV f3800b = ENV.ONLINE;

    /* renamed from: c, reason: collision with root package name */
    private static String f3801c = "";

    /* renamed from: d, reason: collision with root package name */
    private static String f3802d = "";

    /* renamed from: h, reason: collision with root package name */
    private static volatile boolean f3806h = true;

    /* renamed from: i, reason: collision with root package name */
    private static SharedPreferences f3807i = null;

    /* renamed from: j, reason: collision with root package name */
    private static volatile CopyOnWriteArrayList<String> f3808j = null;

    public static void addBucketInfo(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || str.length() > 32 || str2.length() > 32) {
            return;
        }
        synchronized (GlobalAppRuntimeInfo.class) {
            if (f3808j == null) {
                f3808j = new CopyOnWriteArrayList<>();
            }
            f3808j.add(str);
            f3808j.add(str2);
        }
    }

    public static CopyOnWriteArrayList<String> getBucketInfo() {
        return f3808j;
    }

    public static Context getContext() {
        return f3799a;
    }

    public static String getCurrentProcess() {
        return f3802d;
    }

    public static ENV getEnv() {
        return f3800b;
    }

    @Deprecated
    public static long getInitTime() {
        return f3809k;
    }

    @Deprecated
    public static int getStartType() {
        anet.channel.fulltrace.b sceneInfo = anet.channel.fulltrace.a.a().getSceneInfo();
        if (sceneInfo != null) {
            return sceneInfo.f3981a;
        }
        return -1;
    }

    public static String getTtid() {
        return f3803e;
    }

    public static String getUserId() {
        return f3804f;
    }

    public static String getUtdid() {
        Context context;
        if (f3805g == null && (context = f3799a) != null) {
            f3805g = Utils.getDeviceId(context);
        }
        return f3805g;
    }

    public static boolean isAppBackground() {
        if (f3799a == null) {
            return true;
        }
        return f3806h;
    }

    public static boolean isTargetProcess() {
        if (TextUtils.isEmpty(f3801c) || TextUtils.isEmpty(f3802d)) {
            return true;
        }
        return f3801c.equalsIgnoreCase(f3802d);
    }

    public static void setBackground(boolean z10) {
        f3806h = z10;
    }

    public static void setContext(Context context) {
        f3799a = context;
        if (context != null) {
            if (TextUtils.isEmpty(f3802d)) {
                f3802d = Utils.getProcessName(context, Process.myPid());
            }
            if (TextUtils.isEmpty(f3801c)) {
                f3801c = Utils.getMainProcessName(context);
            }
            if (f3807i == null) {
                SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
                f3807i = defaultSharedPreferences;
                f3804f = defaultSharedPreferences.getString("UserId", null);
            }
            ALog.e("awcn.GlobalAppRuntimeInfo", "", null, "CurrentProcess", f3802d, "TargetProcess", f3801c);
        }
    }

    public static void setCurrentProcess(String str) {
        f3802d = str;
    }

    public static void setEnv(ENV env) {
        f3800b = env;
    }

    @Deprecated
    public static void setInitTime(long j10) {
        f3809k = j10;
    }

    public static void setTargetProcess(String str) {
        f3801c = str;
    }

    public static void setTtid(String str) {
        f3803e = str;
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            int indexOf = str.indexOf("@");
            String str2 = null;
            String substring = indexOf != -1 ? str.substring(0, indexOf) : null;
            String substring2 = str.substring(indexOf + 1);
            int lastIndexOf = substring2.lastIndexOf("_");
            if (lastIndexOf != -1) {
                String substring3 = substring2.substring(0, lastIndexOf);
                str2 = substring2.substring(lastIndexOf + 1);
                substring2 = substring3;
            }
            f3810l = str2;
            AmdcRuntimeInfo.setAppInfo(substring2, str2, substring);
        } catch (Exception unused) {
        }
    }

    public static void setUserId(String str) {
        String str2 = f3804f;
        if (str2 == null || !str2.equals(str)) {
            f3804f = str;
            StrategyCenter.getInstance().forceRefreshStrategy(DispatchConstants.getAmdcServerDomain());
            SharedPreferences sharedPreferences = f3807i;
            if (sharedPreferences != null) {
                sharedPreferences.edit().putString("UserId", str).apply();
            }
        }
    }

    public static void setUtdid(String str) {
        String str2 = f3805g;
        if (str2 == null || !str2.equals(str)) {
            f3805g = str;
        }
    }

    public static boolean isTargetProcess(String str) {
        if (TextUtils.isEmpty(f3801c) || TextUtils.isEmpty(str)) {
            return true;
        }
        return f3801c.equalsIgnoreCase(str);
    }
}
