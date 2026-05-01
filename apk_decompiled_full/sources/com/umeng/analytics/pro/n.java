package com.umeng.analytics.pro;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.os.Process;
import android.text.TextUtils;
import com.hpplay.component.protocol.push.IPushHandler;
import com.umeng.analytics.MobclickAgent;
import com.umeng.analytics.pro.g;
import com.umeng.analytics.pro.k;
import com.umeng.analytics.vshelper.PageNameMonitor;
import com.umeng.commonsdk.UMConfigure;
import com.umeng.commonsdk.config.FieldManager;
import com.umeng.commonsdk.debug.UMLog;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.statistics.common.DeviceConfig;
import com.umeng.commonsdk.utils.UMUtils;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class n {

    /* renamed from: a, reason: collision with root package name */
    public static String f10468a;

    /* renamed from: b, reason: collision with root package name */
    boolean f10477b;

    /* renamed from: c, reason: collision with root package name */
    boolean f10478c;

    /* renamed from: f, reason: collision with root package name */
    com.umeng.analytics.vshelper.a f10479f;

    /* renamed from: g, reason: collision with root package name */
    Application.ActivityLifecycleCallbacks f10480g;

    /* renamed from: h, reason: collision with root package name */
    private final Map<String, Long> f10481h;

    /* renamed from: l, reason: collision with root package name */
    private boolean f10482l;

    /* renamed from: m, reason: collision with root package name */
    private int f10483m;

    /* renamed from: n, reason: collision with root package name */
    private int f10484n;

    /* renamed from: i, reason: collision with root package name */
    private static JSONArray f10471i = new JSONArray();

    /* renamed from: j, reason: collision with root package name */
    private static Object f10472j = new Object();

    /* renamed from: k, reason: collision with root package name */
    private static Application f10473k = null;

    /* renamed from: d, reason: collision with root package name */
    static String f10469d = null;

    /* renamed from: e, reason: collision with root package name */
    static int f10470e = -1;

    /* renamed from: o, reason: collision with root package name */
    private static boolean f10474o = true;

    /* renamed from: p, reason: collision with root package name */
    private static Object f10475p = new Object();

    /* renamed from: q, reason: collision with root package name */
    private static cd f10476q = new com.umeng.analytics.vshelper.b();

    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private static final n f10486a = new n();

        private a() {
        }
    }

    public static /* synthetic */ int a(n nVar) {
        int i10 = nVar.f10484n;
        nVar.f10484n = i10 - 1;
        return i10;
    }

    public static /* synthetic */ int b(n nVar) {
        int i10 = nVar.f10483m;
        nVar.f10483m = i10 - 1;
        return i10;
    }

    public static /* synthetic */ int e(n nVar) {
        int i10 = nVar.f10484n;
        nVar.f10484n = i10 + 1;
        return i10;
    }

    public static /* synthetic */ int f(n nVar) {
        int i10 = nVar.f10483m;
        nVar.f10483m = i10 + 1;
        return i10;
    }

    private void g() {
        if (this.f10482l) {
            return;
        }
        this.f10482l = true;
        if (f10473k != null) {
            f10473k.registerActivityLifecycleCallbacks(this.f10480g);
        }
    }

    private n() {
        this.f10481h = new HashMap();
        this.f10482l = false;
        this.f10477b = false;
        this.f10478c = false;
        this.f10483m = 0;
        this.f10484n = 0;
        this.f10479f = PageNameMonitor.getInstance();
        this.f10480g = new Application.ActivityLifecycleCallbacks() { // from class: com.umeng.analytics.pro.n.1
            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityCreated(Activity activity, Bundle bundle) {
                n.f10476q.a(activity, bundle);
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityDestroyed(Activity activity) {
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityPaused(Activity activity) {
                if (FieldManager.allow(com.umeng.commonsdk.utils.d.F)) {
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> onActivityPaused: FirstResumeTrigger enabled.");
                    synchronized (n.f10475p) {
                        if (n.f10474o) {
                            return;
                        }
                    }
                } else {
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> onActivityPaused: FirstResumeTrigger disabled.");
                }
                if (UMConfigure.AUTO_ACTIVITY_PAGE_COLLECTION != MobclickAgent.PageMode.AUTO) {
                    if (UMConfigure.AUTO_ACTIVITY_PAGE_COLLECTION == MobclickAgent.PageMode.MANUAL) {
                        com.umeng.analytics.b.a().i();
                    }
                } else {
                    n.this.c(activity);
                    com.umeng.analytics.b.a().i();
                    n.this.f10477b = false;
                    n.f10476q.d(activity);
                }
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityResumed(Activity activity) {
                if (FieldManager.allow(com.umeng.commonsdk.utils.d.F)) {
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> onActivityResumed: FirstResumeTrigger enabled.");
                    synchronized (n.f10475p) {
                        if (n.f10474o) {
                            boolean unused = n.f10474o = false;
                        }
                    }
                    n.this.a(activity);
                } else {
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> onActivityResumed: FirstResumeTrigger disabled.");
                    n.this.a(activity);
                }
                n.f10476q.c(activity);
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityStarted(Activity activity) {
                if (activity != null) {
                    if (n.this.f10483m <= 0) {
                        if (n.f10469d == null) {
                            n.f10469d = UUID.randomUUID().toString();
                        }
                        if (n.f10470e == -1) {
                            n.f10470e = activity.isTaskRoot() ? 1 : 0;
                        }
                        if (n.f10470e == 0 && UMUtils.isMainProgress(activity)) {
                            HashMap hashMap = new HashMap();
                            hashMap.put("activityName", activity.toString());
                            hashMap.put("pid", Integer.valueOf(Process.myPid()));
                            hashMap.put("isMainProcess", Integer.valueOf(UMUtils.isMainProgress(activity) ? 1 : 0));
                            com.umeng.analytics.b a10 = com.umeng.analytics.b.a();
                            if (a10 != null) {
                                a10.a((Context) activity, "$$_onUMengEnterForegroundInitError", (Map<String, Object>) hashMap);
                            }
                            n.f10470e = -2;
                            if (UMConfigure.isDebugLog()) {
                                UMLog.mutlInfo(2, l.ar);
                            }
                        } else if (n.f10470e == 1 || !UMUtils.isMainProgress(activity)) {
                            HashMap hashMap2 = new HashMap();
                            hashMap2.put("pairUUID", n.f10469d);
                            hashMap2.put("pid", Integer.valueOf(Process.myPid()));
                            hashMap2.put("isMainProcess", Integer.valueOf(UMUtils.isMainProgress(activity) ? 1 : 0));
                            hashMap2.put("activityName", activity.toString());
                            if (com.umeng.analytics.b.a() != null) {
                                com.umeng.analytics.b.a().a((Context) activity, "$$_onUMengEnterForeground", (Map<String, Object>) hashMap2);
                            }
                        }
                    }
                    if (n.this.f10484n < 0) {
                        n.e(n.this);
                    } else {
                        n.f(n.this);
                    }
                }
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityStopped(Activity activity) {
                UMLog uMLog = UMConfigure.umDebugLog;
                MobclickAgent.PageMode pageMode = MobclickAgent.PageMode.AUTO;
                if (activity != null) {
                    if (activity.isChangingConfigurations()) {
                        n.a(n.this);
                        return;
                    }
                    n.b(n.this);
                    if (n.this.f10483m <= 0) {
                        if (n.f10470e == 0 && UMUtils.isMainProgress(activity)) {
                            return;
                        }
                        int i10 = n.f10470e;
                        if (i10 == 1 || (i10 == 0 && !UMUtils.isMainProgress(activity))) {
                            HashMap hashMap = new HashMap();
                            hashMap.put("pairUUID", n.f10469d);
                            hashMap.put(IPushHandler.REASON, "Normal");
                            hashMap.put("pid", Integer.valueOf(Process.myPid()));
                            hashMap.put("isMainProcess", Integer.valueOf(UMUtils.isMainProgress(activity) ? 1 : 0));
                            hashMap.put("activityName", activity.toString());
                            com.umeng.analytics.b a10 = com.umeng.analytics.b.a();
                            if (a10 != null) {
                                a10.a((Context) activity, "$$_onUMengEnterBackground", (Map<String, Object>) hashMap);
                            }
                            if (n.f10469d != null) {
                                n.f10469d = null;
                            }
                        }
                    }
                }
            }
        };
        synchronized (this) {
            if (f10473k != null) {
                g();
            }
        }
    }

    public void c() {
        c((Activity) null);
        b();
    }

    public void b(Context context) {
        synchronized (f10475p) {
            if (f10474o) {
                f10474o = false;
                Activity globleActivity = DeviceConfig.getGlobleActivity(context);
                if (globleActivity == null) {
                    UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> init触发onResume: 无前台Activity，直接退出。");
                    return;
                }
                UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> init触发onResume: 补救成功，前台Activity名：" + globleActivity.getLocalClassName());
                a(globleActivity);
                return;
            }
            UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> init触发onResume: firstResumeCall = false，直接返回。");
        }
    }

    public static void c(Context context) {
        String jSONArray;
        if (context != null) {
            try {
                JSONObject jSONObject = new JSONObject();
                synchronized (f10472j) {
                    jSONArray = f10471i.toString();
                    f10471i = new JSONArray();
                }
                if (jSONArray.length() > 0) {
                    jSONObject.put(g.d.a.f10390c, new JSONArray(jSONArray));
                    k.a(context).a(w.a().c(), jSONObject, k.a.AUTOPAGE);
                }
            } catch (Throwable unused) {
            }
        }
    }

    public boolean a() {
        return this.f10482l;
    }

    public static synchronized n a(Context context) {
        n nVar;
        synchronized (n.class) {
            if (f10473k == null && context != null) {
                if (context instanceof Activity) {
                    f10473k = ((Activity) context).getApplication();
                } else if (context instanceof Application) {
                    f10473k = (Application) context;
                }
            }
            nVar = a.f10486a;
        }
        return nVar;
    }

    public static void a(Context context, String str) {
        if (f10470e == 1 && UMUtils.isMainProgress(context)) {
            HashMap hashMap = new HashMap();
            hashMap.put("pairUUID", f10469d);
            hashMap.put(IPushHandler.REASON, str);
            if (f10469d != null) {
                f10469d = null;
            }
            if (context != null) {
                hashMap.put("pid", Integer.valueOf(Process.myPid()));
                hashMap.put("isMainProcess", Integer.valueOf(UMUtils.isMainProgress(context) ? 1 : 0));
                hashMap.put("Context", context.toString());
                com.umeng.analytics.b.a().a(context, "$$_onUMengEnterBackground", (Map<String, Object>) hashMap);
            }
        }
    }

    public void b() {
        this.f10482l = false;
        if (f10473k != null) {
            f10473k.unregisterActivityLifecycleCallbacks(this.f10480g);
            f10473k = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(Activity activity) {
        long j10;
        long j11;
        try {
            synchronized (this.f10481h) {
                if (f10468a == null && activity != null) {
                    f10468a = activity.getPackageName() + "." + activity.getLocalClassName();
                }
                if (TextUtils.isEmpty(f10468a) || !this.f10481h.containsKey(f10468a)) {
                    j10 = 0;
                    j11 = 0;
                } else {
                    j10 = this.f10481h.get(f10468a).longValue();
                    j11 = System.currentTimeMillis() - j10;
                    this.f10481h.remove(f10468a);
                }
            }
            synchronized (f10472j) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put(f.f10340v, f10468a);
                    jSONObject.put("duration", j11);
                    jSONObject.put(f.f10342x, j10);
                    jSONObject.put("type", 0);
                    f10471i.put(jSONObject);
                } catch (Throwable unused) {
                }
            }
        } catch (Throwable unused2) {
        }
    }

    private void b(Activity activity) {
        f10468a = activity.getPackageName() + "." + activity.getLocalClassName();
        synchronized (this.f10481h) {
            this.f10481h.put(f10468a, Long.valueOf(System.currentTimeMillis()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Activity activity) {
        if (UMConfigure.AUTO_ACTIVITY_PAGE_COLLECTION != MobclickAgent.PageMode.AUTO) {
            if (UMConfigure.AUTO_ACTIVITY_PAGE_COLLECTION == MobclickAgent.PageMode.MANUAL) {
                synchronized (f10475p) {
                    com.umeng.analytics.b.a().h();
                }
                return;
            }
            return;
        }
        if (activity != null) {
            String str = activity.getPackageName() + "." + activity.getLocalClassName();
            this.f10479f.activityResume(str);
            if (this.f10477b) {
                this.f10477b = false;
                if (!TextUtils.isEmpty(f10468a)) {
                    if (f10468a.equals(str)) {
                        return;
                    }
                    b(activity);
                    synchronized (f10475p) {
                        com.umeng.analytics.b.a().h();
                    }
                    return;
                }
                f10468a = str;
                return;
            }
            b(activity);
            synchronized (f10475p) {
                com.umeng.analytics.b.a().h();
            }
        }
    }
}
