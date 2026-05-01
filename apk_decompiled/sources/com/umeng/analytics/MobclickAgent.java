package com.umeng.analytics;

import android.content.Context;
import android.text.TextUtils;
import com.efs.sdk.base.EfsReporter;
import com.google.android.gms.cast.framework.media.NotificationOptions;
import com.umeng.analytics.pro.az;
import com.umeng.analytics.pro.ba;
import com.umeng.analytics.pro.bb;
import com.umeng.analytics.pro.l;
import com.umeng.common.ISysListener;
import com.umeng.commonsdk.UMConfigure;
import com.umeng.commonsdk.debug.UMLog;
import com.umeng.commonsdk.statistics.common.MLog;
import com.umeng.umcrash.UMCrash;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.microedition.khronos.opengles.GL10;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class MobclickAgent {

    /* loaded from: classes3.dex */
    public enum EScenarioType {
        E_UM_NORMAL(0),
        E_UM_GAME(1);


        /* renamed from: a, reason: collision with root package name */
        private int f9768a;

        EScenarioType(int i10) {
            this.f9768a = i10;
        }

        public int toValue() {
            return this.f9768a;
        }
    }

    public enum PageMode {
        AUTO,
        MANUAL,
        LEGACY_AUTO,
        LEGACY_MANUAL
    }

    public static void clearPreProperties(Context context) {
        getAgent().g(context);
    }

    public static void disable() {
        AnalyticsConfig.enable = false;
    }

    private static void disableExceptionCatch() {
        b.a().a(false);
        AnalyticsConfig.CHANGE_CATCH_EXCEPTION_NOTALLOW = true;
    }

    @Deprecated
    public static void enableEncrypt(boolean z10) {
    }

    public static b getAgent() {
        return b.a();
    }

    public static JSONObject getPreProperties(Context context) {
        return getAgent().h(context);
    }

    private static void init(Context context) {
        b.a().a(context);
    }

    public static void onEvent(Context context, String str) {
        try {
            bb bbVar = new bb();
            bbVar.a(bb.a.ID).a(str);
            az.a(context, 101, ba.a(), bbVar);
        } catch (Throwable unused) {
        }
        b.a().a(context, str, (String) null, -1L, 1);
    }

    public static void onEventObject(Context context, String str, Map<String, Object> map) {
        HashMap hashMap;
        try {
            bb bbVar = new bb();
            if (map != null) {
                hashMap = new HashMap();
                for (String str2 : map.keySet()) {
                    hashMap.put(str2, map.get(str2));
                }
            } else {
                hashMap = null;
            }
            bbVar.a(bb.a.OBJECT_MAP).a(str).b(hashMap);
            az.a(context, 101, ba.a(), bbVar);
        } catch (Throwable unused) {
        }
        if (map == null) {
            UMLog.aq(l.f10440a, 0, "\\|");
        } else {
            b.a().a(context, str, map, -1L);
        }
    }

    public static void onEventValue(Context context, String str, Map<String, String> map, int i10) {
        HashMap hashMap;
        try {
            bb bbVar = new bb();
            if (map != null) {
                hashMap = new HashMap();
                for (String str2 : map.keySet()) {
                    hashMap.put(str2, map.get(str2));
                }
            } else {
                hashMap = null;
            }
            bbVar.a(bb.a.STRING_MAP).a(str).a(hashMap).a(true);
            az.a(context, 101, ba.a(), bbVar);
        } catch (Throwable unused) {
        }
        HashMap hashMap2 = map == null ? new HashMap() : new HashMap(map);
        hashMap2.put("__ct__", Integer.valueOf(i10));
        b.a().a(context, str, hashMap2, -1L);
    }

    private static void onGKVEvent(Context context, String str, HashMap<String, Object> hashMap) {
        b.a().a(context, str, hashMap);
    }

    public static void onKillProcess(Context context) {
        b.a().d(context);
    }

    public static void onPageEnd(String str) {
        if (TextUtils.isEmpty(str)) {
            UMLog.aq(l.D, 0, "\\|");
        } else {
            b.a().b(str);
        }
    }

    public static void onPageStart(String str) {
        if (TextUtils.isEmpty(str)) {
            UMLog.aq(l.C, 0, "\\|");
        } else {
            b.a().a(str);
        }
    }

    public static void onPause(Context context) {
        b.a().c(context);
    }

    public static void onProfileSignIn(String str) {
        onProfileSignIn("_adhoc", str);
    }

    public static void onProfileSignOff() {
        b.a().j();
    }

    public static void onResume(Context context) {
        if (context == null) {
            UMLog.aq(l.f10455n, 0, "\\|");
        } else {
            b.a().b(context);
        }
    }

    public static void registerPreProperties(Context context, JSONObject jSONObject) {
        getAgent().a(context, jSONObject);
    }

    public static void reportError(Context context, String str) {
        try {
            EfsReporter efsReporter = UMCrash.sReporter;
            Method declaredMethod = UMCrash.class.getDeclaredMethod("generateCustomLog", String.class, String.class);
            if (declaredMethod != null) {
                declaredMethod.setAccessible(true);
                declaredMethod.invoke(UMCrash.class, str, "DEFAULT");
            }
        } catch (Throwable unused) {
        }
    }

    public static void setCatchUncaughtExceptions(boolean z10) {
        b.a().a(z10);
    }

    @Deprecated
    public static void setCheckDevice(boolean z10) {
    }

    @Deprecated
    public static void setDebugMode(boolean z10) {
    }

    public static void setFirstLaunchEvent(Context context, List<String> list) {
        getAgent().a(context, list);
    }

    private static void setGameScenarioType(Context context) {
        b.a().a(context, EScenarioType.E_UM_GAME);
    }

    @Deprecated
    public static void setLatencyWindow(long j10) {
    }

    public static void setLocation(double d10, double d11) {
        b.a().a(d10, d11);
    }

    public static void setOpenGLContext(GL10 gl10) {
        b.a().a(gl10);
    }

    public static void setPageCollectionMode(PageMode pageMode) {
        UMConfigure.AUTO_ACTIVITY_PAGE_COLLECTION = pageMode;
    }

    @Deprecated
    public static void setScenarioType(Context context, EScenarioType eScenarioType) {
    }

    public static void setSecret(Context context, String str) {
        b.a().c(context, str);
    }

    public static void setSessionContinueMillis(long j10) {
        if (j10 <= NotificationOptions.SKIP_STEP_THIRTY_SECONDS_IN_MS) {
            j10 = 30000;
        }
        b.a().a(j10);
    }

    private static void setSysListener(ISysListener iSysListener) {
        b.a().a(iSysListener);
    }

    public static void unregisterPreProperty(Context context, String str) {
        getAgent().f(context, str);
    }

    public static void userProfile(String str, Object obj) {
        if (TextUtils.isEmpty(str)) {
            MLog.e("userProfile: key is null or empty, please check!");
            return;
        }
        if (str.startsWith("_")) {
            MLog.e("userProfile: The user-defined key cannot start with an underscore, please check!");
            return;
        }
        boolean z10 = false;
        if (Character.isDigit(str.charAt(0))) {
            MLog.e("userProfile: The user-defined key cannot start with an number, please check!");
            return;
        }
        char[] charArray = str.toCharArray();
        int length = charArray.length;
        int i10 = 0;
        while (true) {
            if (i10 >= length) {
                break;
            }
            char c10 = charArray[i10];
            if ((c10 < 'a' || c10 > 'z') && !((c10 >= 'A' && c10 <= 'Z') || Character.isDigit(c10) || c10 == '_')) {
                z10 = true;
                break;
            }
            i10++;
        }
        if (z10) {
            MLog.e("userProfile: The user-defined key contains invalid characters, please check!");
        } else if (obj == null) {
            MLog.e("userProfile: value is null, please check!");
        } else {
            b.a().a(str, obj);
        }
    }

    public static void userProfileEMail(String str) {
        if (str == null) {
            MLog.e("userProfileEMail: email value is null, please check!");
        } else {
            b.a().d(str);
        }
    }

    public static void userProfileMobile(String str) {
        if (str == null) {
            MLog.e("userProfileMobile: mobile value is null, please check!");
        } else {
            b.a().c(str);
        }
    }

    public static void onProfileSignIn(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            UMLog.aq(l.f10461t, 0, "\\|");
            return;
        }
        if (str2.length() > 64) {
            UMLog.aq(l.f10462u, 0, "\\|");
            return;
        }
        if (TextUtils.isEmpty(str)) {
            b.a().a("_adhoc", str2);
        } else if (str.length() > 32) {
            UMLog.aq(l.f10463v, 0, "\\|");
        } else {
            b.a().a(str, str2);
        }
    }

    public static void reportError(Context context, Throwable th) {
        try {
            EfsReporter efsReporter = UMCrash.sReporter;
            Method declaredMethod = UMCrash.class.getDeclaredMethod("generateCustomLog", Throwable.class, String.class);
            if (declaredMethod != null) {
                declaredMethod.setAccessible(true);
                declaredMethod.invoke(UMCrash.class, th, "DEFAULT");
            }
        } catch (Throwable unused) {
        }
    }

    public static void onEvent(Context context, String str, String str2) {
        try {
            bb bbVar = new bb();
            bbVar.a(bb.a.LABEL).a(str).b(str2);
            az.a(context, 101, ba.a(), bbVar);
        } catch (Throwable unused) {
        }
        if (TextUtils.isEmpty(str2)) {
            UMLog.aq(l.f10452k, 0, "\\|");
        } else {
            b.a().a(context, str, str2, -1L, 1);
        }
    }

    public static void onEvent(Context context, String str, Map<String, String> map) {
        HashMap hashMap;
        try {
            bb bbVar = new bb();
            if (map != null) {
                hashMap = new HashMap();
                for (String str2 : map.keySet()) {
                    hashMap.put(str2, map.get(str2));
                }
            } else {
                hashMap = null;
            }
            bbVar.a(bb.a.STRING_MAP).a(str).a(hashMap);
            az.a(context, 101, ba.a(), bbVar);
        } catch (Throwable unused) {
        }
        if (map == null) {
            UMLog.aq(l.f10440a, 0, "\\|");
        } else {
            b.a().a(context, str, new HashMap(map), -1L);
        }
    }
}
