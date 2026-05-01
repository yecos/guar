package com.umeng.analytics;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.hpplay.component.common.ParamsMap;
import com.umeng.analytics.MobclickAgent;
import com.umeng.analytics.pro.aa;
import com.umeng.analytics.pro.f;
import com.umeng.analytics.pro.k;
import com.umeng.analytics.pro.l;
import com.umeng.analytics.pro.m;
import com.umeng.analytics.pro.n;
import com.umeng.analytics.pro.o;
import com.umeng.analytics.pro.p;
import com.umeng.analytics.pro.q;
import com.umeng.analytics.pro.r;
import com.umeng.analytics.pro.u;
import com.umeng.analytics.pro.v;
import com.umeng.analytics.pro.w;
import com.umeng.analytics.pro.x;
import com.umeng.common.ISysListener;
import com.umeng.commonsdk.UMConfigure;
import com.umeng.commonsdk.config.FieldManager;
import com.umeng.commonsdk.debug.UMLog;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.framework.UMWorkDispatch;
import com.umeng.commonsdk.service.UMGlobalContext;
import com.umeng.commonsdk.statistics.common.DataHelper;
import com.umeng.commonsdk.statistics.common.HelperUtils;
import com.umeng.commonsdk.statistics.common.MLog;
import com.umeng.commonsdk.statistics.internal.PreferenceWrapper;
import com.umeng.commonsdk.utils.UMUtils;
import com.umeng.commonsdk.utils.d;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.microedition.khronos.opengles.GL10;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class b implements p, v {
    private static final String A = "umsp_2";
    private static final String B = "umsp_3";
    private static final String C = "umsp_4";
    private static final String D = "umsp_5";

    /* renamed from: a, reason: collision with root package name */
    private static Context f9778a = null;

    /* renamed from: h, reason: collision with root package name */
    private static final String f9779h = "sp_uapp";

    /* renamed from: i, reason: collision with root package name */
    private static final String f9780i = "prepp_uapp";

    /* renamed from: o, reason: collision with root package name */
    private static final int f9781o = 128;

    /* renamed from: p, reason: collision with root package name */
    private static final int f9782p = 256;

    /* renamed from: q, reason: collision with root package name */
    private static String f9783q = "";

    /* renamed from: r, reason: collision with root package name */
    private static String f9784r = "";

    /* renamed from: t, reason: collision with root package name */
    private static final String f9786t = "ekv_bl_ver";

    /* renamed from: w, reason: collision with root package name */
    private static final String f9788w = "ekv_wl_ver";

    /* renamed from: z, reason: collision with root package name */
    private static final String f9789z = "umsp_1";

    /* renamed from: b, reason: collision with root package name */
    private ISysListener f9790b;

    /* renamed from: c, reason: collision with root package name */
    private r f9791c;

    /* renamed from: d, reason: collision with root package name */
    private x f9792d;

    /* renamed from: e, reason: collision with root package name */
    private m f9793e;

    /* renamed from: f, reason: collision with root package name */
    private w f9794f;

    /* renamed from: g, reason: collision with root package name */
    private n f9795g;

    /* renamed from: j, reason: collision with root package name */
    private boolean f9796j;

    /* renamed from: k, reason: collision with root package name */
    private volatile JSONObject f9797k;

    /* renamed from: l, reason: collision with root package name */
    private volatile JSONObject f9798l;

    /* renamed from: m, reason: collision with root package name */
    private volatile JSONObject f9799m;

    /* renamed from: n, reason: collision with root package name */
    private boolean f9800n;

    /* renamed from: u, reason: collision with root package name */
    private com.umeng.analytics.filter.a f9801u;

    /* renamed from: x, reason: collision with root package name */
    private com.umeng.analytics.filter.b f9802x;

    /* renamed from: y, reason: collision with root package name */
    private o f9803y;

    /* renamed from: s, reason: collision with root package name */
    private static final String f9785s = f.ar;

    /* renamed from: v, reason: collision with root package name */
    private static final String f9787v = f.as;

    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private static final b f9804a = new b();

        private a() {
        }
    }

    static {
        Context appContext = UMGlobalContext.getAppContext();
        if (appContext != null) {
            f9778a = appContext.getApplicationContext();
        }
    }

    public static b a() {
        return a.f9804a;
    }

    private void i(Context context) {
        try {
            if (context == null) {
                MLog.e("unexpected null context in getNativeSuperProperties");
                return;
            }
            if (f9778a == null) {
                f9778a = context.getApplicationContext();
            }
            SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(context);
            if (this.f9797k == null) {
                this.f9797k = new JSONObject();
            }
            if (this.f9798l == null) {
                this.f9798l = new JSONObject();
            }
            String string = sharedPreferences.getString(f9780i, null);
            if (!TextUtils.isEmpty(string)) {
                try {
                    this.f9799m = new JSONObject(string);
                } catch (JSONException unused) {
                }
            }
            if (this.f9799m == null) {
                this.f9799m = new JSONObject();
            }
        } catch (Throwable unused2) {
        }
    }

    public JSONObject b() {
        return this.f9797k;
    }

    public JSONObject c() {
        return this.f9799m;
    }

    public JSONObject d() {
        return this.f9798l;
    }

    public void e() {
        this.f9798l = null;
    }

    public String f() {
        if (UMUtils.isMainProgress(f9778a)) {
            return f9783q;
        }
        MLog.e("getOnResumedActivityName can not be called in child process");
        return null;
    }

    public String g() {
        if (UMUtils.isMainProgress(f9778a)) {
            return f9784r;
        }
        MLog.e("getOnPausedActivityName can not be called in child process");
        return null;
    }

    public void h() {
        try {
            Context context = f9778a;
            if (context != null) {
                if (!UMUtils.isMainProgress(context)) {
                    MLog.e("onStartSessionInternal can not be called in child process");
                    return;
                }
                long currentTimeMillis = System.currentTimeMillis();
                Context context2 = f9778a;
                UMWorkDispatch.sendEvent(context2, 4352, CoreProtocol.getInstance(context2), Long.valueOf(currentTimeMillis));
                Context context3 = f9778a;
                UMWorkDispatch.sendEvent(context3, q.a.f10527g, CoreProtocol.getInstance(context3), Long.valueOf(currentTimeMillis));
            }
            ISysListener iSysListener = this.f9790b;
            if (iSysListener != null) {
                iSysListener.onAppResume();
            }
        } catch (Throwable unused) {
        }
    }

    public void j() {
        try {
            Context context = f9778a;
            if (context == null) {
                return;
            }
            if (!UMUtils.isMainProgress(context)) {
                MLog.e("onProfileSignOff can not be called in child process");
                return;
            }
            long currentTimeMillis = System.currentTimeMillis();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("ts", currentTimeMillis);
            Context context2 = f9778a;
            UMWorkDispatch.sendEvent(context2, q.a.f10526f, CoreProtocol.getInstance(context2), jSONObject);
            Context context3 = f9778a;
            UMWorkDispatch.sendEvent(context3, q.a.f10535o, CoreProtocol.getInstance(context3), jSONObject);
        } catch (Throwable th) {
            if (MLog.DEBUG) {
                MLog.e(" Excepthon  in  onProfileSignOff", th);
            }
        }
    }

    public synchronized void k() {
        Context context;
        try {
            context = f9778a;
        } catch (Throwable unused) {
        }
        if (context == null) {
            return;
        }
        if (!UMUtils.isMainProgress(context)) {
            MLog.e("unregisterSuperPropertyByCoreProtocol can not be called in child process");
            return;
        }
        if (this.f9797k != null) {
            SharedPreferences.Editor edit = PreferenceWrapper.getDefault(f9778a).edit();
            edit.putString(f9779h, this.f9797k.toString());
            edit.commit();
        } else {
            this.f9797k = new JSONObject();
        }
    }

    public synchronized JSONObject l() {
        Context context;
        try {
            context = f9778a;
        } catch (Throwable unused) {
        }
        if (context == null) {
            return null;
        }
        if (!UMUtils.isMainProgress(context)) {
            MLog.e("getSuperPropertiesJSONObject can not be called in child process");
            return null;
        }
        if (this.f9797k == null) {
            this.f9797k = new JSONObject();
        }
        return this.f9797k;
    }

    public synchronized void m() {
        try {
            Context context = f9778a;
            if (context != null) {
                if (!UMUtils.isMainProgress(context)) {
                    MLog.e("clearSuperPropertiesByCoreProtocol can not be called in child process");
                } else {
                    SharedPreferences.Editor edit = PreferenceWrapper.getDefault(f9778a).edit();
                    edit.remove(f9779h);
                    edit.commit();
                }
            }
        } catch (Throwable unused) {
        }
    }

    @Override // com.umeng.analytics.pro.p
    public void n() {
        UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> onIntoBackground triggered.");
        if (AnalyticsConfig.enable && FieldManager.b()) {
            if (!FieldManager.allow(d.D)) {
                UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> 退出发送策略: 云控控制字关闭。功能不生效");
            } else {
                if (UMWorkDispatch.eventHasExist(q.a.B)) {
                    return;
                }
                UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> 退出时发送策略 被触发！");
                Context context = f9778a;
                UMWorkDispatch.sendEvent(context, q.a.B, CoreProtocol.getInstance(context), null);
            }
        }
    }

    private b() {
        this.f9791c = new r();
        this.f9792d = new x();
        this.f9793e = new m();
        this.f9794f = w.a();
        this.f9795g = null;
        this.f9796j = false;
        this.f9797k = null;
        this.f9798l = null;
        this.f9799m = null;
        this.f9800n = false;
        this.f9801u = null;
        this.f9802x = null;
        this.f9803y = null;
        this.f9791c.a(this);
    }

    private boolean e(String str) {
        if (this.f9801u.enabled() && this.f9801u.matchHit(str)) {
            return true;
        }
        if (!this.f9802x.enabled()) {
            return false;
        }
        if (!this.f9802x.matchHit(str)) {
            return true;
        }
        UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> white list match! id = " + str);
        return false;
    }

    public void a(Context context) {
        if (context == null) {
            return;
        }
        try {
            if (f9778a == null) {
                f9778a = context.getApplicationContext();
            }
            if (this.f9801u == null) {
                com.umeng.analytics.filter.a aVar = new com.umeng.analytics.filter.a(f9785s, "ekv_bl_ver");
                this.f9801u = aVar;
                aVar.register(f9778a);
            }
            if (this.f9802x == null) {
                com.umeng.analytics.filter.b bVar = new com.umeng.analytics.filter.b(f9787v, "ekv_wl_ver");
                this.f9802x = bVar;
                bVar.register(f9778a);
            }
            if (UMUtils.isMainProgress(f9778a)) {
                if (!this.f9796j) {
                    this.f9796j = true;
                    i(f9778a);
                }
                synchronized (this) {
                    if (!this.f9800n) {
                        n a10 = n.a(context);
                        this.f9795g = a10;
                        if (a10.a()) {
                            this.f9800n = true;
                        }
                        this.f9803y = o.a();
                        try {
                            o.a(context);
                            this.f9803y.a(this);
                        } catch (Throwable unused) {
                        }
                    }
                }
                if (UMConfigure.isDebugLog()) {
                    UMLog.mutlInfo(l.B, 3, "", null, null);
                }
                UMWorkDispatch.registerConnStateObserver(CoreProtocol.getInstance(f9778a));
            }
        } catch (Throwable unused2) {
        }
    }

    public void b(String str) {
        if (!UMUtils.isMainProgress(f9778a)) {
            MLog.e("onPageEnd can not be called in child process");
            return;
        }
        try {
            if (UMConfigure.AUTO_ACTIVITY_PAGE_COLLECTION != MobclickAgent.PageMode.LEGACY_AUTO) {
                this.f9792d.b(str);
            }
        } catch (Throwable unused) {
        }
    }

    public void c(Context context) {
        if (context == null) {
            UMLog.aq(l.f10457p, 0, "\\|");
            return;
        }
        if (UMConfigure.AUTO_ACTIVITY_PAGE_COLLECTION == MobclickAgent.PageMode.AUTO) {
            return;
        }
        if (f9778a == null) {
            f9778a = context.getApplicationContext();
        }
        if (!UMUtils.isMainProgress(f9778a)) {
            MLog.e("onPause can not be called in child process");
            return;
        }
        if (UMConfigure.isDebugLog() && !(context instanceof Activity)) {
            UMLog.aq(l.f10458q, 2, "\\|");
        }
        try {
            if (!this.f9796j || !this.f9800n) {
                a(context);
            }
            if (UMConfigure.AUTO_ACTIVITY_PAGE_COLLECTION != MobclickAgent.PageMode.LEGACY_MANUAL) {
                this.f9793e.b(context.getClass().getName());
            }
            i();
        } catch (Throwable th) {
            if (MLog.DEBUG) {
                MLog.e("Exception occurred in Mobclick.onRause(). ", th);
            }
        }
        if (UMConfigure.isDebugLog() && (context instanceof Activity)) {
            f9784r = context.getClass().getName();
        }
    }

    public void d(Context context) {
        if (context == null) {
            return;
        }
        try {
            if (f9778a == null) {
                f9778a = context.getApplicationContext();
            }
            if (!UMUtils.isMainProgress(f9778a)) {
                MLog.e("onKillProcess can not be called in child process");
                return;
            }
            n nVar = this.f9795g;
            if (nVar != null) {
                nVar.c();
            }
            n.a(context, "onKillProcess");
            m mVar = this.f9793e;
            if (mVar != null) {
                mVar.b();
            }
            x xVar = this.f9792d;
            if (xVar != null) {
                xVar.b();
            }
            Context context2 = f9778a;
            if (context2 != null) {
                w wVar = this.f9794f;
                if (wVar != null) {
                    wVar.c(context2, Long.valueOf(System.currentTimeMillis()));
                }
                q.a(f9778a).d();
                x.a(f9778a);
                if (UMConfigure.AUTO_ACTIVITY_PAGE_COLLECTION == MobclickAgent.PageMode.AUTO) {
                    n.c(f9778a);
                }
                PreferenceWrapper.getDefault(f9778a).edit().commit();
            }
        } catch (Throwable unused) {
        }
    }

    public synchronized void f(Context context) {
        if (context == null) {
            UMLog.aq(l.ah, 0, "\\|");
            return;
        }
        if (f9778a == null) {
            f9778a = context.getApplicationContext();
        }
        if (!UMUtils.isMainProgress(f9778a)) {
            MLog.e("clearSuperProperties can not be called in child process");
            return;
        }
        if (!this.f9796j || !this.f9800n) {
            a(f9778a);
        }
        this.f9797k = new JSONObject();
        Context context2 = f9778a;
        UMWorkDispatch.sendEvent(context2, q.a.f10541u, CoreProtocol.getInstance(context2), null);
    }

    public synchronized void g(Context context) {
        if (context == null) {
            UMLog.aq(l.ap, 0, "\\|");
            return;
        }
        if (f9778a == null) {
            f9778a = context.getApplicationContext();
        }
        if (!UMUtils.isMainProgress(f9778a)) {
            MLog.e("clearPreProperties can not be called in child process");
            return;
        }
        if (!this.f9796j || !this.f9800n) {
            a(f9778a);
        }
        if (this.f9799m.length() > 0) {
            Context context2 = f9778a;
            UMWorkDispatch.sendEvent(context2, q.a.f10545y, CoreProtocol.getInstance(context2), null);
        }
        this.f9799m = new JSONObject();
    }

    public void b(Context context) {
        if (context == null) {
            MLog.e("unexpected null context in onResume");
            return;
        }
        if (UMConfigure.AUTO_ACTIVITY_PAGE_COLLECTION == MobclickAgent.PageMode.AUTO) {
            return;
        }
        if (f9778a == null) {
            f9778a = context.getApplicationContext();
        }
        if (!UMUtils.isMainProgress(f9778a)) {
            MLog.e("onResume can not be called in child process");
            return;
        }
        if (UMConfigure.isDebugLog() && !(context instanceof Activity)) {
            UMLog.aq(l.f10456o, 2, "\\|");
        }
        try {
            if (!this.f9796j || !this.f9800n) {
                a(context);
            }
            if (UMConfigure.AUTO_ACTIVITY_PAGE_COLLECTION != MobclickAgent.PageMode.LEGACY_MANUAL) {
                this.f9793e.a(context.getClass().getName());
            }
            h();
            if (UMConfigure.isDebugLog() && (context instanceof Activity)) {
                f9783q = context.getClass().getName();
            }
        } catch (Throwable th) {
            MLog.e("Exception occurred in Mobclick.onResume(). ", th);
        }
    }

    public synchronized Object e(Context context, String str) {
        if (context == null) {
            UMLog.aq(l.ai, 0, "\\|");
            return null;
        }
        if (f9778a == null) {
            f9778a = context.getApplicationContext();
        }
        if (!UMUtils.isMainProgress(f9778a)) {
            MLog.e("getSuperProperty can not be called in child process");
            return null;
        }
        if (TextUtils.isEmpty(str)) {
            UMLog.aq(l.ag, 0, "\\|");
            return null;
        }
        if (!str.equals(f9789z) && !str.equals(A) && !str.equals(B) && !str.equals(C) && !str.equals(D)) {
            MLog.e("please check key or value, must be correct!");
            return null;
        }
        if (this.f9797k != null) {
            if (this.f9797k.has(str)) {
                return this.f9797k.opt(str);
            }
        } else {
            this.f9797k = new JSONObject();
        }
        return null;
    }

    public synchronized JSONObject h(Context context) {
        if (context == null) {
            UMLog.aq(l.aq, 0, "\\|");
            return null;
        }
        if (f9778a == null) {
            f9778a = context.getApplicationContext();
        }
        if (!UMUtils.isMainProgress(f9778a)) {
            MLog.e("getPreProperties can not be called in child process");
            return null;
        }
        if (!this.f9796j || !this.f9800n) {
            a(f9778a);
        }
        if (this.f9799m == null) {
            this.f9799m = new JSONObject();
        }
        JSONObject jSONObject = new JSONObject();
        if (this.f9799m.length() > 0) {
            try {
                jSONObject = new JSONObject(this.f9799m.toString());
            } catch (JSONException unused) {
            }
        }
        return jSONObject;
    }

    public void i() {
        try {
            Context context = f9778a;
            if (context != null) {
                if (!UMUtils.isMainProgress(context)) {
                    MLog.e("onEndSessionInternal can not be called in child process");
                    return;
                }
                Context context2 = f9778a;
                UMWorkDispatch.sendEvent(context2, q.a.f10528h, CoreProtocol.getInstance(context2), Long.valueOf(System.currentTimeMillis()));
                Context context3 = f9778a;
                UMWorkDispatch.sendEvent(context3, q.a.f10524d, CoreProtocol.getInstance(context3), null);
                Context context4 = f9778a;
                UMWorkDispatch.sendEvent(context4, q.a.f10523c, CoreProtocol.getInstance(context4), null);
                Context context5 = f9778a;
                UMWorkDispatch.sendEvent(context5, q.a.f10529i, CoreProtocol.getInstance(context5), null);
            }
        } catch (Throwable unused) {
        }
        ISysListener iSysListener = this.f9790b;
        if (iSysListener != null) {
            iSysListener.onAppPause();
        }
    }

    public synchronized void f(Context context, String str) {
        if (context == null) {
            UMLog.aq(l.an, 0, "\\|");
            return;
        }
        if (f9778a == null) {
            f9778a = context.getApplicationContext();
        }
        if (!UMUtils.isMainProgress(f9778a)) {
            MLog.e("unregisterPreProperty can not be called in child process");
            return;
        }
        if (!this.f9796j || !this.f9800n) {
            a(f9778a);
        }
        if (this.f9799m == null) {
            this.f9799m = new JSONObject();
        }
        if (str != null && str.length() > 0) {
            if (this.f9799m.has(str)) {
                this.f9799m.remove(str);
                Context context2 = f9778a;
                UMWorkDispatch.sendEvent(context2, q.a.f10544x, CoreProtocol.getInstance(context2), this.f9799m.toString());
            } else if (UMConfigure.isDebugLog()) {
                UMLog.aq(l.ao, 0, "\\|");
            }
            return;
        }
        MLog.e("please check propertics, property is null!");
    }

    private boolean g(String str) {
        if (str != null) {
            try {
                int length = str.trim().getBytes().length;
                if (length >= 0 && length < 256) {
                    return true;
                }
            } catch (Throwable unused) {
            }
        }
        MLog.e("The length of profile value must be less than 256 bytes.");
        return false;
    }

    public void c(Context context, String str) {
        if (context == null) {
            UMLog.aq(l.f10467z, 0, "\\|");
            return;
        }
        if (f9778a == null) {
            f9778a = context.getApplicationContext();
        }
        if (!UMUtils.isMainProgress(f9778a)) {
            MLog.e("setSecret can not be called in child process");
            return;
        }
        if (!this.f9796j || !this.f9800n) {
            a(f9778a);
        }
        AnalyticsConfig.a(f9778a, str);
    }

    public synchronized void d(Context context, String str) {
        try {
        } catch (Throwable th) {
            th.printStackTrace();
        }
        if (context == null) {
            UMLog.aq(l.ah, 0, "\\|");
            return;
        }
        if (f9778a == null) {
            f9778a = context.getApplicationContext();
        }
        if (!UMUtils.isMainProgress(f9778a)) {
            MLog.e("unregisterSuperProperty can not be called in child process");
            return;
        }
        if (!this.f9796j || !this.f9800n) {
            a(f9778a);
        }
        if (TextUtils.isEmpty(str)) {
            UMLog.aq(l.ag, 0, "\\|");
            return;
        }
        if (!str.equals(f9789z) && !str.equals(A) && !str.equals(B) && !str.equals(C) && !str.equals(D)) {
            MLog.e("please check key or value, must be correct!");
            return;
        }
        if (this.f9797k == null) {
            this.f9797k = new JSONObject();
        }
        if (this.f9797k.has(str)) {
            this.f9797k.remove(str);
            Context context2 = f9778a;
            UMWorkDispatch.sendEvent(context2, q.a.f10542v, CoreProtocol.getInstance(context2), str);
        }
    }

    public void b(Context context, String str) {
        try {
            if (context == null) {
                UMLog.aq(l.N, 0, "\\|");
                return;
            }
            if (f9778a == null) {
                f9778a = context.getApplicationContext();
            }
            if (!UMUtils.isMainProgress(f9778a)) {
                MLog.e("onDeepLinkReceived can not be called in child process");
                return;
            }
            if (!this.f9796j || !this.f9800n) {
                a(f9778a);
            }
            if (!TextUtils.isEmpty(str)) {
                HashMap hashMap = new HashMap();
                hashMap.put(f.aK, str);
                a(f9778a, f.aJ, (Map<String, Object>) hashMap, -1L, false);
                return;
            }
            UMLog.aq(l.O, 0, "\\|");
        } catch (Throwable th) {
            if (MLog.DEBUG) {
                MLog.e(th);
            }
        }
    }

    public void a(String str) {
        if (!UMUtils.isMainProgress(f9778a)) {
            MLog.e("onPageStart can not be called in child process");
            return;
        }
        try {
            if (UMConfigure.AUTO_ACTIVITY_PAGE_COLLECTION != MobclickAgent.PageMode.LEGACY_AUTO) {
                this.f9792d.a(str);
            }
        } catch (Throwable unused) {
        }
    }

    private boolean c(String str, Object obj) {
        int i10;
        if (TextUtils.isEmpty(str)) {
            MLog.e("key is " + str + ", please check key, illegal");
            return false;
        }
        try {
            i10 = str.getBytes("UTF-8").length;
        } catch (UnsupportedEncodingException unused) {
            i10 = 0;
        }
        if (i10 > 128) {
            MLog.e("key length is " + i10 + ", please check key, illegal");
            return false;
        }
        if (obj instanceof String) {
            if (((String) obj).getBytes("UTF-8").length <= 256) {
                return true;
            }
            MLog.e("value length is " + ((String) obj).getBytes("UTF-8").length + ", please check value, illegal");
            return false;
        }
        if ((obj instanceof Integer) || (obj instanceof Long) || (obj instanceof Double) || (obj instanceof Float)) {
            return true;
        }
        MLog.e("value is " + obj + ", please check value, type illegal");
        return false;
    }

    public synchronized String e(Context context) {
        if (context == null) {
            UMLog.aq(l.ai, 0, "\\|");
            return null;
        }
        if (f9778a == null) {
            f9778a = context.getApplicationContext();
        }
        if (!UMUtils.isMainProgress(f9778a)) {
            MLog.e("getSuperProperties can not be called in child process");
            return null;
        }
        if (this.f9797k != null) {
            return this.f9797k.toString();
        }
        this.f9797k = new JSONObject();
        return null;
    }

    public void a(ISysListener iSysListener) {
        if (!UMUtils.isMainProgress(f9778a)) {
            MLog.e("setSysListener can not be called in child process");
        } else {
            this.f9790b = iSysListener;
        }
    }

    public void a(Context context, int i10) {
        if (context == null) {
            MLog.e("unexpected null context in setVerticalType");
            return;
        }
        if (f9778a == null) {
            f9778a = context.getApplicationContext();
        }
        if (!UMUtils.isMainProgress(f9778a)) {
            MLog.e("setVerticalType can not be called in child process");
            return;
        }
        if (!this.f9796j || !this.f9800n) {
            a(f9778a);
        }
        AnalyticsConfig.a(f9778a, i10);
    }

    private void b(String str, Object obj) {
        try {
            if (this.f9797k == null) {
                this.f9797k = new JSONObject();
            }
            int i10 = 0;
            if (obj.getClass().isArray()) {
                if (obj instanceof String[]) {
                    String[] strArr = (String[]) obj;
                    if (strArr.length > 10) {
                        return;
                    }
                    JSONArray jSONArray = new JSONArray();
                    while (i10 < strArr.length) {
                        String str2 = strArr[i10];
                        if (str2 != null && !HelperUtils.checkStrLen(str2, 256)) {
                            jSONArray.put(strArr[i10]);
                        }
                        i10++;
                    }
                    this.f9797k.put(str, jSONArray);
                    return;
                }
                if (obj instanceof long[]) {
                    long[] jArr = (long[]) obj;
                    JSONArray jSONArray2 = new JSONArray();
                    while (i10 < jArr.length) {
                        jSONArray2.put(jArr[i10]);
                        i10++;
                    }
                    this.f9797k.put(str, jSONArray2);
                    return;
                }
                if (obj instanceof int[]) {
                    int[] iArr = (int[]) obj;
                    JSONArray jSONArray3 = new JSONArray();
                    while (i10 < iArr.length) {
                        jSONArray3.put(iArr[i10]);
                        i10++;
                    }
                    this.f9797k.put(str, jSONArray3);
                    return;
                }
                if (obj instanceof float[]) {
                    float[] fArr = (float[]) obj;
                    JSONArray jSONArray4 = new JSONArray();
                    while (i10 < fArr.length) {
                        jSONArray4.put(fArr[i10]);
                        i10++;
                    }
                    this.f9797k.put(str, jSONArray4);
                    return;
                }
                if (obj instanceof double[]) {
                    double[] dArr = (double[]) obj;
                    JSONArray jSONArray5 = new JSONArray();
                    while (i10 < dArr.length) {
                        jSONArray5.put(dArr[i10]);
                        i10++;
                    }
                    this.f9797k.put(str, jSONArray5);
                    return;
                }
                if (obj instanceof short[]) {
                    short[] sArr = (short[]) obj;
                    JSONArray jSONArray6 = new JSONArray();
                    while (i10 < sArr.length) {
                        jSONArray6.put((int) sArr[i10]);
                        i10++;
                    }
                    this.f9797k.put(str, jSONArray6);
                    return;
                }
                return;
            }
            if (obj instanceof List) {
                List list = (List) obj;
                JSONArray jSONArray7 = new JSONArray();
                while (i10 < list.size()) {
                    Object obj2 = list.get(i10);
                    if ((obj2 instanceof String) || (obj2 instanceof Long) || (obj2 instanceof Integer) || (obj2 instanceof Float) || (obj2 instanceof Double) || (obj2 instanceof Short)) {
                        jSONArray7.put(list.get(i10));
                    }
                    i10++;
                }
                this.f9797k.put(str, jSONArray7);
                return;
            }
            if ((obj instanceof String) || (obj instanceof Long) || (obj instanceof Integer) || (obj instanceof Float) || (obj instanceof Double) || (obj instanceof Short)) {
                this.f9797k.put(str, obj);
            }
        } catch (Throwable unused) {
        }
    }

    private boolean f(String str) {
        if (str != null) {
            try {
                int length = str.trim().getBytes().length;
                if (length > 0 && length < 128) {
                    return true;
                }
            } catch (Throwable unused) {
            }
        }
        MLog.e("The length of profile key must be less than 128 bytes.");
        return false;
    }

    public void c(String str) {
        if (g(str)) {
            a(f.O, (Object) str);
        }
    }

    public void a(Context context, String str, HashMap<String, Object> hashMap) {
        if (context == null) {
            return;
        }
        try {
            if (f9778a == null) {
                f9778a = context.getApplicationContext();
            }
            if (!UMUtils.isMainProgress(f9778a)) {
                MLog.e("onGKVEvent can not be called in child process");
                return;
            }
            if (!this.f9796j || !this.f9800n) {
                a(f9778a);
            }
            String str2 = "";
            if (this.f9797k == null) {
                this.f9797k = new JSONObject();
            } else {
                str2 = this.f9797k.toString();
            }
            u.a(f9778a).a(str, hashMap, str2);
        } catch (Throwable th) {
            if (MLog.DEBUG) {
                MLog.e(th);
            }
        }
    }

    public void d(String str) {
        if (g(str)) {
            a(f.P, (Object) str);
        }
    }

    public void a(Context context, String str) {
        if (context == null) {
            UMLog.aq(l.f10464w, 0, "\\|");
            return;
        }
        if (f9778a == null) {
            f9778a = context.getApplicationContext();
        }
        if (!UMUtils.isMainProgress(f9778a)) {
            MLog.e("reportError can not be called in child process");
            return;
        }
        if (TextUtils.isEmpty(str)) {
            if (UMConfigure.isDebugLog()) {
                UMLog.aq(l.f10465x, 0, "\\|");
                return;
            }
            return;
        }
        try {
            if (!this.f9796j || !this.f9800n) {
                a(f9778a);
            }
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("ts", System.currentTimeMillis());
            jSONObject.put(f.W, 2);
            jSONObject.put(f.X, str);
            jSONObject.put("__ii", this.f9794f.c());
            Context context2 = f9778a;
            UMWorkDispatch.sendEvent(context2, q.a.f10530j, CoreProtocol.getInstance(context2), jSONObject);
        } catch (Throwable th) {
            if (MLog.DEBUG) {
                MLog.e(th);
            }
        }
    }

    public void a(Context context, Throwable th) {
        if (context != null && th != null) {
            if (f9778a == null) {
                f9778a = context.getApplicationContext();
            }
            if (!UMUtils.isMainProgress(f9778a)) {
                MLog.e("reportError can not be called in child process");
                return;
            }
            try {
                if (!this.f9796j || !this.f9800n) {
                    a(f9778a);
                }
                a(f9778a, DataHelper.convertExceptionToString(th));
                return;
            } catch (Exception e10) {
                if (MLog.DEBUG) {
                    MLog.e(e10);
                    return;
                }
                return;
            }
        }
        UMLog.aq(l.f10466y, 0, "\\|");
    }

    public void a(Context context, String str, String str2, long j10, int i10) {
        if (context == null) {
            return;
        }
        try {
            if (f9778a == null) {
                f9778a = context.getApplicationContext();
            }
            if (!this.f9796j || !this.f9800n) {
                a(f9778a);
            }
            if (e(str)) {
                UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> filter ekv [" + str + "].");
                return;
            }
            String str3 = "";
            if (this.f9797k == null) {
                this.f9797k = new JSONObject();
            } else {
                str3 = this.f9797k.toString();
            }
            u.a(f9778a).a(str, str2, j10, i10, str3);
        } catch (Throwable th) {
            if (MLog.DEBUG) {
                MLog.e(th);
            }
        }
    }

    public synchronized void b(Object obj) {
        Context context;
        try {
            context = f9778a;
        } catch (Throwable unused) {
        }
        if (context == null) {
            return;
        }
        if (!UMUtils.isMainProgress(context)) {
            MLog.e("updateNativePrePropertiesByCoreProtocol can not be called in child process");
            return;
        }
        SharedPreferences.Editor edit = PreferenceWrapper.getDefault(f9778a).edit();
        if (obj != null) {
            String str = (String) obj;
            if (edit != null && !TextUtils.isEmpty(str)) {
                edit.putString(f9780i, str).commit();
            }
        } else if (edit != null) {
            edit.remove(f9780i).commit();
        }
    }

    public void a(Context context, String str, Map<String, Object> map, long j10) {
        try {
        } catch (Throwable th) {
            if (MLog.DEBUG) {
                MLog.e(th);
            }
        }
        if (!TextUtils.isEmpty(str)) {
            if (Arrays.asList(f.aL).contains(str)) {
                UMLog.aq(l.f10443b, 0, "\\|");
                return;
            }
            if (map.isEmpty()) {
                UMLog.aq(l.f10445d, 0, "\\|");
                return;
            }
            Iterator<Map.Entry<String, Object>> it = map.entrySet().iterator();
            while (it.hasNext()) {
                if (Arrays.asList(f.aL).contains(it.next().getKey())) {
                    UMLog.aq(l.f10446e, 0, "\\|");
                    return;
                }
            }
            a(context, str, map, j10, false);
            return;
        }
        UMLog.aq(l.f10444c, 0, "\\|");
    }

    public void a(Context context, String str, Map<String, Object> map) {
        a(context, str, map, -1L, true);
    }

    private void a(Context context, String str, Map<String, Object> map, long j10, boolean z10) {
        try {
            if (context == null) {
                MLog.e("context is null in onEventNoCheck, please check!");
                return;
            }
            if (f9778a == null) {
                f9778a = context.getApplicationContext();
            }
            if (!this.f9796j || !this.f9800n) {
                a(f9778a);
            }
            if (e(str)) {
                UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> filter ekv [" + str + "].");
                return;
            }
            String str2 = "";
            if (this.f9797k == null) {
                this.f9797k = new JSONObject();
            } else {
                str2 = this.f9797k.toString();
            }
            u.a(f9778a).a(str, map, j10, str2, z10);
        } catch (Throwable th) {
            if (MLog.DEBUG) {
                MLog.e(th);
            }
        }
    }

    @Override // com.umeng.analytics.pro.v
    public void a(Throwable th) {
        try {
            Context context = f9778a;
            if (context == null) {
                return;
            }
            if (!UMUtils.isMainProgress(context)) {
                MLog.e("onAppCrash can not be called in child process");
                return;
            }
            if (AnalyticsConfig.enable) {
                x xVar = this.f9792d;
                if (xVar != null) {
                    xVar.b();
                }
                n.a(f9778a, "onAppCrash");
                m mVar = this.f9793e;
                if (mVar != null) {
                    mVar.b();
                }
                n nVar = this.f9795g;
                if (nVar != null) {
                    nVar.c();
                }
                w wVar = this.f9794f;
                if (wVar != null) {
                    wVar.c(f9778a, Long.valueOf(System.currentTimeMillis()));
                }
                if (th != null) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("ts", System.currentTimeMillis());
                    jSONObject.put(f.W, 1);
                    jSONObject.put(f.X, DataHelper.convertExceptionToString(th));
                    k.a(f9778a).a(this.f9794f.c(), jSONObject.toString(), 1);
                }
                q.a(f9778a).d();
                x.a(f9778a);
                if (UMConfigure.AUTO_ACTIVITY_PAGE_COLLECTION == MobclickAgent.PageMode.AUTO) {
                    n.c(f9778a);
                }
                PreferenceWrapper.getDefault(f9778a).edit().commit();
            }
        } catch (Exception e10) {
            if (MLog.DEBUG) {
                MLog.e("Exception in onAppCrash", e10);
            }
        }
    }

    public void a(String str, String str2) {
        try {
            Context context = f9778a;
            if (context == null) {
                return;
            }
            if (!UMUtils.isMainProgress(context)) {
                MLog.e("onProfileSignIn can not be called in child process");
                return;
            }
            long currentTimeMillis = System.currentTimeMillis();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(f.M, str);
            jSONObject.put(ParamsMap.DeviceParams.KEY_UID, str2);
            jSONObject.put("ts", currentTimeMillis);
            Context context2 = f9778a;
            UMWorkDispatch.sendEvent(context2, q.a.f10525e, CoreProtocol.getInstance(context2), jSONObject);
            Context context3 = f9778a;
            UMWorkDispatch.sendEvent(context3, q.a.f10535o, CoreProtocol.getInstance(context3), jSONObject);
        } catch (Throwable th) {
            if (MLog.DEBUG) {
                MLog.e(" Excepthon  in  onProfileSignIn", th);
            }
        }
    }

    public void a(boolean z10) {
        Context context = f9778a;
        if (context == null) {
            return;
        }
        if (!UMUtils.isMainProgress(context)) {
            MLog.e("setCatchUncaughtExceptions can not be called in child process");
        } else {
            if (AnalyticsConfig.CHANGE_CATCH_EXCEPTION_NOTALLOW) {
                return;
            }
            AnalyticsConfig.CATCH_EXCEPTION = z10;
        }
    }

    public void a(GL10 gl10) {
        String[] gpu = UMUtils.getGPU(gl10);
        if (gpu.length == 2) {
            AnalyticsConfig.GPU_VENDER = gpu[0];
            AnalyticsConfig.GPU_RENDERER = gpu[1];
        }
    }

    public void a(double d10, double d11) {
        Context context = f9778a;
        if (context == null) {
            return;
        }
        if (!UMUtils.isMainProgress(context)) {
            MLog.e("setLocation can not be called in child process");
            return;
        }
        if (AnalyticsConfig.f9755a == null) {
            AnalyticsConfig.f9755a = new double[2];
        }
        double[] dArr = AnalyticsConfig.f9755a;
        dArr[0] = d10;
        dArr[1] = d11;
    }

    public void a(Context context, MobclickAgent.EScenarioType eScenarioType) {
        if (context == null) {
            MLog.e("unexpected null context in setScenarioType");
            return;
        }
        if (f9778a == null) {
            f9778a = context.getApplicationContext();
        }
        if (!UMUtils.isMainProgress(f9778a)) {
            MLog.e("setScenarioType can not be called in child process");
            return;
        }
        if (eScenarioType != null) {
            a(f9778a, eScenarioType.toValue());
        }
        if (this.f9796j && this.f9800n) {
            return;
        }
        a(f9778a);
    }

    public void a(long j10) {
        Context context = f9778a;
        if (context == null) {
            return;
        }
        if (!UMUtils.isMainProgress(context)) {
            MLog.e("setSessionContinueMillis can not be called in child process");
        } else {
            AnalyticsConfig.kContinueSessionMillis = j10;
            aa.a().a(AnalyticsConfig.kContinueSessionMillis);
        }
    }

    public synchronized void a(Context context, String str, Object obj) {
        int i10 = 0;
        if (context == null) {
            UMLog.aq(l.af, 0, "\\|");
            return;
        }
        if (f9778a == null) {
            f9778a = context.getApplicationContext();
        }
        if (!UMUtils.isMainProgress(f9778a)) {
            MLog.e("registerSuperProperty can not be called in child process");
            return;
        }
        if (!this.f9796j || !this.f9800n) {
            a(f9778a);
        }
        if (!TextUtils.isEmpty(str) && obj != null) {
            if (!str.equals(f9789z) && !str.equals(A) && !str.equals(B) && !str.equals(C) && !str.equals(D)) {
                MLog.e("property name is " + str + ", please check key, must be correct!");
                return;
            }
            if ((obj instanceof String) && !HelperUtils.checkStrLen(obj.toString(), 256)) {
                MLog.e("property value is " + obj + ", please check value, lawless!");
                return;
            }
            try {
                if (this.f9797k == null) {
                    this.f9797k = new JSONObject();
                }
                if (obj.getClass().isArray()) {
                    if (obj instanceof String[]) {
                        String[] strArr = (String[]) obj;
                        if (strArr.length > 10) {
                            MLog.e("please check value, size is " + strArr.length + ", overstep 10!");
                            return;
                        }
                        JSONArray jSONArray = new JSONArray();
                        while (i10 < strArr.length) {
                            String str2 = strArr[i10];
                            if (str2 != null && HelperUtils.checkStrLen(str2, 256)) {
                                jSONArray.put(strArr[i10]);
                                i10++;
                            }
                            MLog.e("please check value, length is " + strArr[i10].length() + ", overlength 256!");
                            return;
                        }
                        this.f9797k.put(str, jSONArray);
                    } else if (obj instanceof long[]) {
                        long[] jArr = (long[]) obj;
                        if (jArr.length > 10) {
                            MLog.e("please check value, size is " + jArr.length + ", overstep 10!");
                            return;
                        }
                        JSONArray jSONArray2 = new JSONArray();
                        while (i10 < jArr.length) {
                            jSONArray2.put(jArr[i10]);
                            i10++;
                        }
                        this.f9797k.put(str, jSONArray2);
                    } else if (obj instanceof int[]) {
                        int[] iArr = (int[]) obj;
                        if (iArr.length > 10) {
                            MLog.e("please check value, size is " + iArr.length + ", overstep 10!");
                            return;
                        }
                        JSONArray jSONArray3 = new JSONArray();
                        while (i10 < iArr.length) {
                            jSONArray3.put(iArr[i10]);
                            i10++;
                        }
                        this.f9797k.put(str, jSONArray3);
                    } else if (obj instanceof float[]) {
                        float[] fArr = (float[]) obj;
                        if (fArr.length > 10) {
                            MLog.e("please check value, size is " + fArr.length + ", overstep 10!");
                            return;
                        }
                        JSONArray jSONArray4 = new JSONArray();
                        while (i10 < fArr.length) {
                            jSONArray4.put(fArr[i10]);
                            i10++;
                        }
                        this.f9797k.put(str, jSONArray4);
                    } else if (obj instanceof double[]) {
                        double[] dArr = (double[]) obj;
                        if (dArr.length > 10) {
                            MLog.e("please check value, size is " + dArr.length + ", overstep 10!");
                            return;
                        }
                        JSONArray jSONArray5 = new JSONArray();
                        while (i10 < dArr.length) {
                            jSONArray5.put(dArr[i10]);
                            i10++;
                        }
                        this.f9797k.put(str, jSONArray5);
                    } else if (obj instanceof short[]) {
                        short[] sArr = (short[]) obj;
                        if (sArr.length > 10) {
                            MLog.e("please check value, size is " + sArr.length + ", overstep 10!");
                            return;
                        }
                        JSONArray jSONArray6 = new JSONArray();
                        while (i10 < sArr.length) {
                            jSONArray6.put((int) sArr[i10]);
                            i10++;
                        }
                        this.f9797k.put(str, jSONArray6);
                    } else {
                        MLog.e("please check value, illegal type!");
                        return;
                    }
                } else {
                    if (!(obj instanceof String) && !(obj instanceof Long) && !(obj instanceof Integer) && !(obj instanceof Float) && !(obj instanceof Double) && !(obj instanceof Short)) {
                        MLog.e("please check value, illegal type!");
                        return;
                    }
                    this.f9797k.put(str, obj);
                }
            } catch (Throwable unused) {
            }
            Context context2 = f9778a;
            UMWorkDispatch.sendEvent(context2, q.a.f10540t, CoreProtocol.getInstance(context2), this.f9797k.toString());
            return;
        }
        UMLog.aq(l.ag, 0, "\\|");
    }

    public synchronized void a(Object obj) {
        Context context;
        try {
            context = f9778a;
        } catch (Throwable unused) {
        }
        if (context == null) {
            return;
        }
        if (!UMUtils.isMainProgress(context)) {
            MLog.e("registerSuperPropertyByCoreProtocol can not be called in child process");
            return;
        }
        if (obj != null) {
            String str = (String) obj;
            SharedPreferences.Editor edit = PreferenceWrapper.getDefault(f9778a).edit();
            if (edit != null && !TextUtils.isEmpty(str)) {
                edit.putString(f9779h, this.f9797k.toString()).commit();
            }
        }
    }

    public synchronized void a(Context context, List<String> list) {
        try {
        } catch (Throwable th) {
            MLog.e(th);
        }
        if (context == null) {
            UMLog.aq(l.aj, 0, "\\|");
            return;
        }
        if (f9778a == null) {
            f9778a = context.getApplicationContext();
        }
        if (!UMUtils.isMainProgress(f9778a)) {
            MLog.e("setFirstLaunchEvent can not be called in child process");
            return;
        }
        if (!this.f9796j || !this.f9800n) {
            a(f9778a);
        }
        u.a(f9778a).a(list);
    }

    public synchronized void a(Context context, JSONObject jSONObject) {
        JSONObject jSONObject2;
        String obj;
        Object obj2;
        if (context == null) {
            UMLog.aq(l.al, 0, "\\|");
            return;
        }
        if (f9778a == null) {
            f9778a = context.getApplicationContext();
        }
        if (!UMUtils.isMainProgress(f9778a)) {
            MLog.e("registerPreProperties can not be called in child process");
            return;
        }
        if (!this.f9796j || !this.f9800n) {
            a(f9778a);
        }
        if (this.f9799m == null) {
            this.f9799m = new JSONObject();
        }
        if (jSONObject != null && jSONObject.length() > 0) {
            try {
                jSONObject2 = new JSONObject(this.f9799m.toString());
            } catch (Exception unused) {
                jSONObject2 = null;
            }
            if (jSONObject2 == null) {
                jSONObject2 = new JSONObject();
            }
            Iterator<String> keys = jSONObject.keys();
            if (keys != null) {
                while (keys.hasNext()) {
                    try {
                        obj = keys.next().toString();
                        obj2 = jSONObject.get(obj);
                    } catch (Exception unused2) {
                    }
                    if (c(obj, obj2)) {
                        jSONObject2.put(obj, obj2);
                        if (jSONObject2.length() > 10) {
                            MLog.e("please check propertics, size overlength!");
                            return;
                        }
                        continue;
                    } else {
                        return;
                    }
                }
            }
            this.f9799m = jSONObject2;
            if (this.f9799m.length() > 0) {
                Context context2 = f9778a;
                UMWorkDispatch.sendEvent(context2, q.a.f10543w, CoreProtocol.getInstance(context2), this.f9799m.toString());
            }
            return;
        }
        UMLog.aq(l.am, 0, "\\|");
    }

    public void a(String str, Object obj) {
        if (f(str)) {
            if (!(obj instanceof String) && !(obj instanceof Integer) && !(obj instanceof Long) && !(obj instanceof Short) && !(obj instanceof Float) && !(obj instanceof Double)) {
                MLog.e("userProfile: Invalid value type, please check!");
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(f.S, str);
                if (obj instanceof String) {
                    String str2 = (String) obj;
                    if (str2.length() > 0) {
                        str2 = str2.trim();
                    }
                    if (!g(str2)) {
                        return;
                    } else {
                        jSONObject.put(f.T, str2);
                    }
                } else {
                    jSONObject.put(f.T, obj);
                }
                Context context = f9778a;
                UMWorkDispatch.sendEvent(context, q.a.f10537q, CoreProtocol.getInstance(context), jSONObject);
            } catch (Throwable unused) {
            }
        }
    }
}
