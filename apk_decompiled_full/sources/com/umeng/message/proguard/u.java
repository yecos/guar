package com.umeng.message.proguard;

import android.app.Activity;
import android.app.Application;
import android.content.ComponentCallbacks2;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import com.hpplay.sdk.source.common.global.Constant;
import com.taobao.accs.common.Constants;
import com.umeng.commonsdk.framework.UMWorkDispatch;
import com.umeng.commonsdk.utils.UMUtils;
import com.umeng.message.MsgConstant;
import com.umeng.message.PushAgent;
import com.umeng.message.api.UPushMessageNotifyApi;
import com.umeng.message.common.UPLog;
import com.umeng.message.common.inter.ITagManager;
import java.lang.ref.WeakReference;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class u {

    /* renamed from: a, reason: collision with root package name */
    private static final u f12174a = new u();

    /* renamed from: b, reason: collision with root package name */
    private WeakReference<Activity> f12175b;

    /* renamed from: h, reason: collision with root package name */
    private volatile t f12181h;

    /* renamed from: c, reason: collision with root package name */
    private volatile boolean f12176c = false;

    /* renamed from: d, reason: collision with root package name */
    private volatile boolean f12177d = false;

    /* renamed from: e, reason: collision with root package name */
    private boolean f12178e = false;

    /* renamed from: f, reason: collision with root package name */
    private volatile long f12179f = 0;

    /* renamed from: g, reason: collision with root package name */
    private volatile long f12180g = 0;

    /* renamed from: i, reason: collision with root package name */
    private final Application.ActivityLifecycleCallbacks f12182i = new Application.ActivityLifecycleCallbacks() { // from class: com.umeng.message.proguard.u.1
        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityCreated(Activity activity, Bundle bundle) {
            if (u.this.f12176c) {
                return;
            }
            u.b(u.this);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityDestroyed(Activity activity) {
            if (u.this.f12181h != null) {
                System.currentTimeMillis();
                try {
                    ak.a().a(activity);
                } catch (Throwable unused) {
                }
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityPaused(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityResumed(Activity activity) {
            u.this.f12175b = new WeakReference(activity);
            u.d(u.this);
            if (u.this.f12181h != null) {
                System.currentTimeMillis();
                try {
                    ak.a().b();
                } catch (Throwable unused) {
                }
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityStarted(Activity activity) {
            if (!u.this.f12176c) {
                u.b(u.this);
            }
            if (u.this.f12181h != null) {
                try {
                    aw a10 = aw.a();
                    final String name = activity.getClass().getName();
                    if (a10.f11600c && a10.f11599b) {
                        final ax axVar = a10.f11598a;
                        b.c(new Runnable() { // from class: com.umeng.message.proguard.ax.2

                            /* renamed from: a */
                            final /* synthetic */ String f11605a;

                            public AnonymousClass2(final String name2) {
                                r2 = name2;
                            }

                            /* JADX WARN: Not initialized variable reg: 18, insn: 0x0349: MOVE (r1 I:??[OBJECT, ARRAY]) = (r18 I:??[OBJECT, ARRAY]) (LINE:842), block:B:136:0x0349 */
                            @Override // java.lang.Runnable
                            public final void run() {
                                String str;
                                JSONObject jSONObject;
                                String str2;
                                int length;
                                String str3;
                                String str4;
                                String str5;
                                ax axVar2;
                                String str6;
                                String str7;
                                String str8 = "trace_id";
                                String str9 = "ts";
                                String str10 = "appkey";
                                String str11 = "Notify";
                                try {
                                    if (ax.this.f11602b.a()) {
                                        if (!ax.this.f11602b.f11613a.b("e_s", true)) {
                                            if (!(Math.abs(System.currentTimeMillis() - ax.this.f11602b.b()) > 86400000)) {
                                                return;
                                            }
                                        }
                                        ay ayVar = ax.this.f11602b;
                                        if (Math.abs(System.currentTimeMillis() - ayVar.b()) > Math.max(600L, Math.min(ayVar.f11613a.b("req_interval", 1800L), 86400L)) * 1000) {
                                            ax.this.f11602b.f11613a.a("req_ts", System.currentTimeMillis());
                                            if (d.h(y.a())) {
                                                ax axVar3 = ax.this;
                                                String str12 = r2;
                                                Application a11 = y.a();
                                                String zid = UMUtils.getZid(a11);
                                                if (TextUtils.isEmpty(zid)) {
                                                    UPLog.i("Notify", "zid skip.");
                                                    return;
                                                }
                                                String registrationId = PushAgent.getInstance(a11).getRegistrationId();
                                                if (TextUtils.isEmpty(registrationId)) {
                                                    UPLog.i("Notify", "deviceToken skip.");
                                                    return;
                                                }
                                                String messageAppkey = PushAgent.getInstance(a11).getMessageAppkey();
                                                if (TextUtils.isEmpty(messageAppkey)) {
                                                    UPLog.i("Notify", "appkey skip.");
                                                    return;
                                                }
                                                String packageName = a11.getPackageName();
                                                if (TextUtils.isEmpty(packageName)) {
                                                    UPLog.i("Notify", "pkgName skip.");
                                                    return;
                                                }
                                                JSONObject jSONObject2 = new JSONObject();
                                                jSONObject2.put(com.umeng.analytics.pro.bt.al, zid);
                                                jSONObject2.put("appkey", messageAppkey);
                                                jSONObject2.put(com.umeng.analytics.pro.bt.f10054o, packageName);
                                                jSONObject2.put(com.umeng.analytics.pro.bt.F, d.f());
                                                jSONObject2.put("device_model", d.d());
                                                jSONObject2.put(com.umeng.analytics.pro.bt.f10036a, registrationId);
                                                jSONObject2.put(com.umeng.analytics.pro.bt.f10064y, Build.VERSION.RELEASE);
                                                jSONObject2.put("sdk_version", MsgConstant.SDK_VERSION);
                                                jSONObject2.put("app_version", d.b(a11));
                                                jSONObject2.put("version_code", d.a(a11));
                                                jSONObject2.put("ts", System.currentTimeMillis());
                                                if (d.i()) {
                                                    jSONObject2.put("harmony_ver", d.j());
                                                }
                                                try {
                                                    jSONObject = g.a(jSONObject2, "https://offmsg.umeng.com/v2/offmsg/req", messageAppkey, false);
                                                } catch (Exception e10) {
                                                    UPLog.i("Notify", "request fail:", e10.getMessage());
                                                    jSONObject = null;
                                                }
                                                if (jSONObject == null || jSONObject.optInt(Constants.KEY_HTTP_CODE) == 13043) {
                                                    return;
                                                }
                                                JSONObject optJSONObject = jSONObject.optJSONObject("data");
                                                if (optJSONObject == null) {
                                                    axVar3.f11602b.a(false);
                                                    return;
                                                }
                                                JSONObject optJSONObject2 = optJSONObject.optJSONObject("config");
                                                try {
                                                    if (optJSONObject2 == null) {
                                                        axVar3.f11602b.a(false);
                                                        return;
                                                    }
                                                    int optInt = optJSONObject2.optInt("ipad");
                                                    boolean z10 = optJSONObject2.optInt("aps") == 1;
                                                    String str13 = packageName;
                                                    axVar3.f11602b.f11613a.a("req_interval", optInt);
                                                    axVar3.f11602b.a(z10);
                                                    String optString = optJSONObject.optString("trace_id");
                                                    JSONArray optJSONArray = optJSONObject.optJSONArray("action");
                                                    if (optJSONArray == null || (length = optJSONArray.length()) == 0) {
                                                        return;
                                                    }
                                                    int i10 = 5;
                                                    if (length > 5) {
                                                        int i11 = 5;
                                                        while (i11 < length) {
                                                            JSONObject optJSONObject3 = optJSONArray.optJSONObject(i11);
                                                            if (optJSONObject3 != null) {
                                                                optJSONObject3.put(ITagManager.SUCCESS, 0);
                                                            }
                                                            i11++;
                                                            i10 = 5;
                                                        }
                                                    }
                                                    int min = Math.min(i10, length);
                                                    int i12 = 0;
                                                    boolean z11 = false;
                                                    while (i12 < min) {
                                                        String str14 = str11;
                                                        JSONObject optJSONObject4 = optJSONArray.optJSONObject(i12);
                                                        if (optJSONObject4 != null) {
                                                            axVar2 = axVar3;
                                                            String optString2 = optJSONObject4.optString("pkg");
                                                            String optString3 = optJSONObject4.optString("activity");
                                                            String optString4 = optJSONObject4.optString(str10);
                                                            if (TextUtils.isEmpty(optString2)) {
                                                                optJSONObject4.put(ITagManager.SUCCESS, 0);
                                                                str3 = optString;
                                                                str4 = str8;
                                                                str5 = str9;
                                                            } else {
                                                                str5 = str9;
                                                                String str15 = str13;
                                                                str6 = str10;
                                                                str7 = str15;
                                                                if (TextUtils.equals(optString2, str7)) {
                                                                    optJSONObject4.put(ITagManager.SUCCESS, 0);
                                                                } else if (TextUtils.isEmpty(optString3)) {
                                                                    optJSONObject4.put(ITagManager.SUCCESS, 0);
                                                                } else if (TextUtils.isEmpty(optString4)) {
                                                                    optJSONObject4.put(ITagManager.SUCCESS, 0);
                                                                } else {
                                                                    boolean a12 = ax.a(a11, str12, optString, optString2, optString3);
                                                                    if (a12) {
                                                                        str3 = optString;
                                                                        str4 = str8;
                                                                    } else {
                                                                        str3 = optString;
                                                                        str4 = str8;
                                                                        optJSONObject4.put(Constant.KEY_MSG, "cur:" + str7 + " start failed:" + optString2);
                                                                    }
                                                                    boolean z12 = z11 | a12;
                                                                    optJSONObject4.put(ITagManager.SUCCESS, a12 ? 1 : 0);
                                                                    if (i12 < min - 1) {
                                                                        try {
                                                                            Thread.sleep(500L);
                                                                        } catch (InterruptedException unused) {
                                                                        }
                                                                    }
                                                                    z11 = z12;
                                                                    i12++;
                                                                    str11 = str14;
                                                                    axVar3 = axVar2;
                                                                    optString = str3;
                                                                    str9 = str5;
                                                                    str8 = str4;
                                                                    String str16 = str6;
                                                                    str13 = str7;
                                                                    str10 = str16;
                                                                }
                                                                str3 = optString;
                                                                str4 = str8;
                                                                i12++;
                                                                str11 = str14;
                                                                axVar3 = axVar2;
                                                                optString = str3;
                                                                str9 = str5;
                                                                str8 = str4;
                                                                String str162 = str6;
                                                                str13 = str7;
                                                                str10 = str162;
                                                            }
                                                        } else {
                                                            str3 = optString;
                                                            str4 = str8;
                                                            str5 = str9;
                                                            axVar2 = axVar3;
                                                        }
                                                        String str17 = str13;
                                                        str6 = str10;
                                                        str7 = str17;
                                                        i12++;
                                                        str11 = str14;
                                                        axVar3 = axVar2;
                                                        optString = str3;
                                                        str9 = str5;
                                                        str8 = str4;
                                                        String str1622 = str6;
                                                        str13 = str7;
                                                        str10 = str1622;
                                                    }
                                                    String str18 = optString;
                                                    String str19 = str8;
                                                    String str20 = str9;
                                                    ax axVar4 = axVar3;
                                                    JSONObject jSONObject3 = new JSONObject();
                                                    JSONObject jSONObject4 = new JSONObject();
                                                    jSONObject4.put("din", d.c(a11));
                                                    jSONObject4.put(com.umeng.analytics.pro.bt.aR, MsgConstant.SDK_VERSION);
                                                    jSONObject4.put("push_switch", d.p(a11));
                                                    jSONObject3.put("header", jSONObject4);
                                                    JSONObject jSONObject5 = new JSONObject();
                                                    jSONObject5.put("pa", "");
                                                    jSONObject5.put("action_type", 70);
                                                    jSONObject5.put("device_token", PushAgent.getInstance(a11).getRegistrationId());
                                                    jSONObject5.put("msg_id", "");
                                                    jSONObject5.put("activity", str12);
                                                    jSONObject5.put("putar", optJSONArray);
                                                    jSONObject5.put(str19, str18);
                                                    jSONObject5.put(str20, System.currentTimeMillis());
                                                    JSONArray jSONArray = new JSONArray();
                                                    jSONArray.put(jSONObject5);
                                                    JSONObject jSONObject6 = new JSONObject();
                                                    jSONObject6.put("push", jSONArray);
                                                    jSONObject3.put("content", jSONObject6);
                                                    UMWorkDispatch.sendEvent(a11, 16385, w.a(), jSONObject3.toString());
                                                    if (z11) {
                                                        try {
                                                            UPushMessageNotifyApi.Callback callback = axVar4.f11601a;
                                                            if (callback != null) {
                                                                callback.onNotifying();
                                                            }
                                                        } catch (Throwable unused2) {
                                                        }
                                                    }
                                                } catch (Throwable th) {
                                                    th = th;
                                                    str = str2;
                                                    UPLog.e(str, th);
                                                }
                                            }
                                        }
                                    }
                                } catch (Throwable th2) {
                                    th = th2;
                                    str = "Notify";
                                }
                            }
                        });
                    }
                } catch (Throwable unused) {
                }
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityStopped(Activity activity) {
        }
    };

    /* renamed from: j, reason: collision with root package name */
    private final ComponentCallbacks2 f12183j = new ComponentCallbacks2() { // from class: com.umeng.message.proguard.u.2
        @Override // android.content.ComponentCallbacks
        public final void onConfigurationChanged(Configuration configuration) {
        }

        @Override // android.content.ComponentCallbacks
        public final void onLowMemory() {
        }

        @Override // android.content.ComponentCallbacks2
        public final void onTrimMemory(int i10) {
            if (i10 == 20) {
                u.e(u.this);
            }
        }
    };

    private u() {
    }

    public static /* synthetic */ boolean b(u uVar) {
        uVar.f12177d = true;
        return true;
    }

    public static Activity d() {
        WeakReference<Activity> weakReference = f12174a.f12175b;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    public static long e() {
        u uVar = f12174a;
        if (uVar.f12176c) {
            return SystemClock.elapsedRealtime() - uVar.f12179f;
        }
        return 0L;
    }

    public static void b() {
        u uVar = f12174a;
        if (uVar.f12181h == null) {
            uVar.f12181h = new t();
        }
    }

    public static boolean c() {
        return f12174a.f12176c;
    }

    public static void a() {
        u uVar = f12174a;
        if (uVar.f12178e) {
            return;
        }
        try {
            Application a10 = y.a();
            if (a10 != null) {
                a10.registerActivityLifecycleCallbacks(uVar.f12182i);
                a10.registerComponentCallbacks(uVar.f12183j);
                uVar.f12178e = true;
            }
        } catch (Throwable unused) {
        }
    }

    public static /* synthetic */ void d(u uVar) {
        if (uVar.f12176c) {
            return;
        }
        uVar.f12176c = true;
        uVar.f12177d = false;
        uVar.f12179f = SystemClock.elapsedRealtime();
    }

    public static /* synthetic */ void e(u uVar) {
        if (uVar.f12176c) {
            uVar.f12176c = false;
            uVar.f12179f = 0L;
            uVar.f12180g = System.currentTimeMillis();
        }
    }
}
