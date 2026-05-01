package com.umeng.analytics.pro;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.umeng.analytics.AnalyticsConfig;
import com.umeng.analytics.CoreProtocol;
import com.umeng.analytics.pro.aa;
import com.umeng.analytics.pro.g;
import com.umeng.analytics.pro.k;
import com.umeng.analytics.pro.q;
import com.umeng.analytics.process.UMProcessDBDatasSender;
import com.umeng.commonsdk.config.FieldManager;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.framework.UMWorkDispatch;
import com.umeng.commonsdk.service.UMGlobalContext;
import com.umeng.commonsdk.statistics.AnalyticsConstants;
import com.umeng.commonsdk.statistics.common.MLog;
import com.umeng.commonsdk.statistics.internal.PreferenceWrapper;
import com.umeng.commonsdk.utils.UMUtils;
import java.lang.reflect.Method;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class w implements aa.a {

    /* renamed from: a, reason: collision with root package name */
    public static final String f10575a = "session_start_time";

    /* renamed from: b, reason: collision with root package name */
    public static final String f10576b = "session_end_time";

    /* renamed from: c, reason: collision with root package name */
    public static final String f10577c = "session_id";

    /* renamed from: d, reason: collision with root package name */
    public static final String f10578d = "pre_session_id";

    /* renamed from: e, reason: collision with root package name */
    public static final String f10579e = "a_start_time";

    /* renamed from: f, reason: collision with root package name */
    public static final String f10580f = "a_end_time";

    /* renamed from: g, reason: collision with root package name */
    public static final String f10581g = "fg_count";

    /* renamed from: h, reason: collision with root package name */
    private static String f10582h = null;

    /* renamed from: i, reason: collision with root package name */
    private static Context f10583i = null;

    /* renamed from: j, reason: collision with root package name */
    private static boolean f10584j = false;

    /* renamed from: k, reason: collision with root package name */
    private static long f10585k = 0;

    /* renamed from: l, reason: collision with root package name */
    private static boolean f10586l = true;

    /* renamed from: m, reason: collision with root package name */
    private static long f10587m;

    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private static final w f10588a = new w();

        private a() {
        }
    }

    public static w a() {
        return a.f10588a;
    }

    public static void b(Context context) {
        SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(f10583i);
        if (sharedPreferences != null) {
            long j10 = sharedPreferences.getLong(f10581g, 0L);
            SharedPreferences.Editor edit = sharedPreferences.edit();
            if (edit != null) {
                edit.putLong(f10581g, j10 + 1);
                edit.commit();
            }
        }
    }

    private void d(Context context) {
        try {
            SharedPreferences.Editor edit = PreferenceWrapper.getDefault(context).edit();
            edit.putLong(f10581g, 0L);
            edit.commit();
        } catch (Throwable unused) {
        }
    }

    private String e(Context context) {
        if (f10583i == null && context != null) {
            f10583i = context.getApplicationContext();
        }
        String d10 = aa.a().d(f10583i);
        try {
            f(context);
            q.a(f10583i).d((Object) null);
        } catch (Throwable unused) {
        }
        return d10;
    }

    private void f(Context context) {
        q.a(context).b(context);
        q.a(context).d();
    }

    public void c(Context context, Object obj) {
        try {
            if (f10583i == null && context != null) {
                f10583i = context.getApplicationContext();
            }
            long longValue = ((Long) obj).longValue();
            SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(context);
            if (sharedPreferences == null) {
                return;
            }
            if (sharedPreferences.getLong(f10579e, 0L) == 0) {
                MLog.e("onPause called before onResume");
                return;
            }
            SharedPreferences.Editor edit = sharedPreferences.edit();
            UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> onEndSessionInternal: write activity end time = " + longValue);
            edit.putLong(f10580f, longValue);
            edit.putLong(f10576b, longValue);
            edit.commit();
        } catch (Throwable unused) {
        }
    }

    private w() {
        aa.a().a(this);
    }

    public static long a(Context context) {
        try {
            return PreferenceWrapper.getDefault(context).getLong(f10581g, 0L);
        } catch (Throwable unused) {
            return 0L;
        }
    }

    public void a(Context context, long j10) {
        SharedPreferences.Editor edit;
        SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(f10583i);
        if (sharedPreferences == null || (edit = sharedPreferences.edit()) == null) {
            return;
        }
        edit.putLong(f10575a, j10);
        edit.commit();
    }

    public void b(Context context, Object obj) {
        long longValue;
        try {
            if (f10583i == null) {
                f10583i = UMGlobalContext.getAppContext(context);
            }
            if (obj == null) {
                longValue = System.currentTimeMillis();
            } else {
                longValue = ((Long) obj).longValue();
            }
            SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(f10583i);
            if (sharedPreferences == null) {
                return;
            }
            f10585k = sharedPreferences.getLong(f10580f, 0L);
            UMRTLog.i(UMRTLog.RTLOG_TAG, "------>>> lastActivityEndTime: " + f10585k);
            String string = sharedPreferences.getString(f.aF, "");
            String appVersionName = UMUtils.getAppVersionName(f10583i);
            SharedPreferences.Editor edit = sharedPreferences.edit();
            if (edit == null) {
                return;
            }
            if (!TextUtils.isEmpty(string) && !string.equals(appVersionName)) {
                UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> requestNewInstantSessionIf: version upgrade");
                edit.putLong(f10575a, longValue);
                edit.commit();
                q.a(f10583i).a((Object) null, true);
                UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> force generate new session: session id = " + aa.a().c(f10583i));
                f10584j = true;
                a(f10583i, longValue, true);
                return;
            }
            if (aa.a().e(f10583i)) {
                UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> More then 30 sec from last session.");
                f10584j = true;
                edit.putLong(f10575a, longValue);
                edit.commit();
                a(f10583i, longValue, false);
                return;
            }
            UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> less then 30 sec from last session, do nothing.");
            f10584j = false;
        } catch (Throwable unused) {
        }
    }

    public void a(Context context, Object obj) {
        SharedPreferences.Editor edit;
        try {
            if (f10583i == null && context != null) {
                f10583i = context.getApplicationContext();
            }
            long longValue = ((Long) obj).longValue();
            SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(f10583i);
            if (sharedPreferences == null || (edit = sharedPreferences.edit()) == null) {
                return;
            }
            String string = sharedPreferences.getString(f.aF, "");
            String appVersionName = UMUtils.getAppVersionName(f10583i);
            if (TextUtils.isEmpty(string)) {
                edit.putInt("versioncode", Integer.parseInt(UMUtils.getAppVersionCode(context)));
                edit.putString(f.aF, appVersionName);
                edit.commit();
            } else if (!string.equals(appVersionName)) {
                UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> onStartSessionInternal: upgrade version: " + string + "-> " + appVersionName);
                int i10 = sharedPreferences.getInt("versioncode", 0);
                String string2 = sharedPreferences.getString("pre_date", "");
                String string3 = sharedPreferences.getString("pre_version", "");
                String string4 = sharedPreferences.getString(f.aF, "");
                edit.putInt("versioncode", Integer.parseInt(UMUtils.getAppVersionCode(context)));
                edit.putString(f.aF, appVersionName);
                edit.putString("vers_date", string2);
                edit.putString("vers_pre_version", string3);
                edit.putString("cur_version", string4);
                edit.putInt("vers_code", i10);
                edit.putString("vers_name", string);
                edit.commit();
                if (f10586l) {
                    f10586l = false;
                }
                if (f10584j) {
                    f10584j = false;
                    b(f10583i, longValue, true);
                    b(f10583i, longValue);
                    return;
                }
                return;
            }
            if (f10584j) {
                f10584j = false;
                if (f10586l) {
                    f10586l = false;
                }
                f10582h = e(context);
                MLog.d("创建新会话: " + f10582h);
                UMRTLog.i(UMRTLog.RTLOG_TAG, "mSessionChanged flag has been set, Start new session: " + f10582h);
                return;
            }
            f10582h = sharedPreferences.getString("session_id", null);
            edit.putLong(f10579e, longValue);
            edit.putLong(f10580f, 0L);
            edit.commit();
            MLog.d("延续上一个会话: " + f10582h);
            UMRTLog.i(UMRTLog.RTLOG_TAG, "Extend current session: " + f10582h);
            if (f10586l) {
                f10586l = false;
                if (FieldManager.allow(com.umeng.commonsdk.utils.d.E)) {
                    Context context2 = f10583i;
                    UMWorkDispatch.sendEventEx(context2, q.a.E, CoreProtocol.getInstance(context2), null, 0L);
                }
            }
            f(context);
            q.a(f10583i).a(false);
        } catch (Throwable unused) {
        }
    }

    @Deprecated
    public String c(Context context) {
        try {
            if (f10582h == null) {
                return PreferenceWrapper.getDefault(context).getString("session_id", null);
            }
        } catch (Throwable unused) {
        }
        return f10582h;
    }

    @Deprecated
    public String c() {
        return c(f10583i);
    }

    public boolean b(Context context, long j10, boolean z10) {
        String a10;
        long j11;
        try {
            SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(context);
            if (sharedPreferences == null || (a10 = aa.a().a(f10583i)) == null) {
                return false;
            }
            long j12 = sharedPreferences.getLong(f10579e, 0L);
            long j13 = sharedPreferences.getLong(f10580f, 0L);
            if (j12 <= 0 || j13 != 0) {
                return false;
            }
            try {
                if (z10) {
                    j11 = f10585k;
                    if (j11 == 0) {
                        UMRTLog.i(UMRTLog.RTLOG_TAG, "------>>> lastActivityEndTime = 0, In-app upgrade, use currentTime: = " + j10);
                        j11 = j10;
                    } else {
                        UMRTLog.i(UMRTLog.RTLOG_TAG, "------>>> lastActivityEndTime != 0, app upgrade, use lastActivityEndTime: = " + f10585k);
                    }
                    c(f10583i, Long.valueOf(j11));
                } else {
                    c(f10583i, Long.valueOf(j10));
                    j11 = j10;
                }
                JSONObject jSONObject = new JSONObject();
                if (z10) {
                    jSONObject.put(g.d.a.f10394g, j11);
                } else {
                    jSONObject.put(g.d.a.f10394g, j10);
                }
                JSONObject b10 = com.umeng.analytics.b.a().b();
                if (b10 != null && b10.length() > 0) {
                    jSONObject.put("__sp", b10);
                }
                JSONObject c10 = com.umeng.analytics.b.a().c();
                if (c10 != null && c10.length() > 0) {
                    jSONObject.put("__pp", c10);
                }
                if (FieldManager.allow(com.umeng.commonsdk.utils.d.E)) {
                    UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>>*** foregroundCount = " + f10587m);
                    jSONObject.put(g.d.a.f10395h, f10587m);
                    f10587m = 0L;
                } else {
                    jSONObject.put(g.d.a.f10395h, 0L);
                }
                k.a(context).a(a10, jSONObject, k.a.END);
                q.a(f10583i).e();
            } catch (Throwable unused) {
            }
            return true;
        } catch (Throwable unused2) {
            return false;
        }
    }

    public void b(Context context, long j10) {
        if (PreferenceWrapper.getDefault(context) == null) {
            return;
        }
        try {
            q.a(f10583i).c((Object) null);
        } catch (Throwable unused) {
        }
    }

    public String a(Context context, long j10, boolean z10) {
        String b10 = aa.a().b(context);
        UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> onInstantSessionInternal: current session id = " + b10);
        if (TextUtils.isEmpty(b10)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("__e", j10);
            JSONObject b11 = com.umeng.analytics.b.a().b();
            if (b11 != null && b11.length() > 0) {
                jSONObject.put("__sp", b11);
            }
            JSONObject c10 = com.umeng.analytics.b.a().c();
            if (c10 != null && c10.length() > 0) {
                jSONObject.put("__pp", c10);
            }
            k.a(context).a(b10, jSONObject, k.a.INSTANTSESSIONBEGIN);
            q.a(context).a(jSONObject, z10);
        } catch (Throwable unused) {
        }
        return b10;
    }

    @Deprecated
    public String b() {
        return f10582h;
    }

    @Override // com.umeng.analytics.pro.aa.a
    public void a(String str, String str2, long j10, long j11, long j12) {
        a(f10583i, str2, j10, j11, j12);
        UMRTLog.i(UMRTLog.RTLOG_TAG, "saveSessionToDB: complete");
        if (AnalyticsConstants.SUB_PROCESS_EVENT) {
            Context context = f10583i;
            UMWorkDispatch.sendEvent(context, UMProcessDBDatasSender.UM_PROCESS_EVENT_KEY, UMProcessDBDatasSender.getInstance(context), Long.valueOf(System.currentTimeMillis()));
        }
    }

    @Override // com.umeng.analytics.pro.aa.a
    public void a(String str, long j10, long j11, long j12) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        a(str, j10);
    }

    private void a(Context context, String str, long j10, long j11, long j12) {
        if (TextUtils.isEmpty(f10582h)) {
            f10582h = aa.a().a(f10583i);
        }
        if (TextUtils.isEmpty(str) || str.equals(f10582h)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(g.d.a.f10394g, j11);
            jSONObject.put(g.d.a.f10395h, j12);
            JSONObject b10 = com.umeng.analytics.b.a().b();
            if (b10 != null && b10.length() > 0) {
                jSONObject.put("__sp", b10);
            }
            JSONObject c10 = com.umeng.analytics.b.a().c();
            if (c10 != null && c10.length() > 0) {
                jSONObject.put("__pp", c10);
            }
            k.a(context).a(f10582h, jSONObject, k.a.END);
        } catch (Exception unused) {
        }
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("__e", j10);
            k.a(context).a(str, jSONObject2, k.a.BEGIN);
            if (FieldManager.allow(com.umeng.commonsdk.utils.d.E)) {
                f10587m = j12;
                d(context);
                Context context2 = f10583i;
                UMWorkDispatch.sendEventEx(context2, q.a.E, CoreProtocol.getInstance(context2), null, 0L);
            }
        } catch (Exception unused2) {
        }
        f10582h = str;
    }

    private void a(String str, long j10) {
        SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(f10583i);
        if (sharedPreferences == null) {
            return;
        }
        long j11 = sharedPreferences.getLong(f10576b, 0L);
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("__ii", str);
            jSONObject.put("__e", j10);
            jSONObject.put(g.d.a.f10394g, j11);
            double[] location = AnalyticsConfig.getLocation();
            if (location != null) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("lat", location[0]);
                jSONObject2.put("lng", location[1]);
                jSONObject2.put("ts", System.currentTimeMillis());
                jSONObject.put(g.d.a.f10392e, jSONObject2);
            }
            Class<?> cls = Class.forName("android.net.TrafficStats");
            Class<?> cls2 = Integer.TYPE;
            Method method = cls.getMethod("getUidRxBytes", cls2);
            Method method2 = cls.getMethod("getUidTxBytes", cls2);
            int i10 = f10583i.getApplicationInfo().uid;
            if (i10 == -1) {
                return;
            }
            long longValue = ((Long) method.invoke(null, Integer.valueOf(i10))).longValue();
            long longValue2 = ((Long) method2.invoke(null, Integer.valueOf(i10))).longValue();
            if (longValue > 0 && longValue2 > 0) {
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put(f.H, longValue);
                jSONObject3.put(f.G, longValue2);
                jSONObject.put(g.d.a.f10391d, jSONObject3);
            }
            k.a(f10583i).a(str, jSONObject, k.a.NEWSESSION);
            x.a(f10583i);
            n.c(f10583i);
        } catch (Throwable unused) {
        }
    }
}
