package com.umeng.analytics.pro;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.hpplay.component.common.ParamsMap;
import com.umeng.analytics.AnalyticsConfig;
import com.umeng.analytics.CoreProtocol;
import com.umeng.analytics.process.UMProcessDBHelper;
import com.umeng.commonsdk.UMConfigure;
import com.umeng.commonsdk.config.FieldManager;
import com.umeng.commonsdk.debug.UMLog;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.framework.UMEnvelopeBuild;
import com.umeng.commonsdk.framework.UMFrUtils;
import com.umeng.commonsdk.framework.UMLogDataProtocol;
import com.umeng.commonsdk.framework.UMWorkDispatch;
import com.umeng.commonsdk.service.UMGlobalContext;
import com.umeng.commonsdk.statistics.common.DeviceConfig;
import com.umeng.commonsdk.statistics.common.HelperUtils;
import com.umeng.commonsdk.statistics.common.MLog;
import com.umeng.commonsdk.statistics.common.ReportPolicy;
import com.umeng.commonsdk.statistics.internal.PreferenceWrapper;
import com.umeng.commonsdk.statistics.internal.StatTracer;
import com.umeng.commonsdk.statistics.noise.ABTest;
import com.umeng.commonsdk.statistics.noise.Defcon;
import com.umeng.commonsdk.utils.JSONArraySortUtil;
import com.umeng.commonsdk.utils.UMUtils;
import com.umeng.umcrash.UMCrashUtils;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class q {

    /* renamed from: a, reason: collision with root package name */
    private static Context f10495a = null;

    /* renamed from: l, reason: collision with root package name */
    private static final String f10496l = "first_activate_time";

    /* renamed from: m, reason: collision with root package name */
    private static final String f10497m = "ana_is_f";

    /* renamed from: n, reason: collision with root package name */
    private static final String f10498n = "thtstart";

    /* renamed from: o, reason: collision with root package name */
    private static final String f10499o = "dstk_last_time";

    /* renamed from: p, reason: collision with root package name */
    private static final String f10500p = "dstk_cnt";

    /* renamed from: q, reason: collision with root package name */
    private static final String f10501q = "gkvc";

    /* renamed from: r, reason: collision with root package name */
    private static final String f10502r = "ekvc";

    /* renamed from: t, reason: collision with root package name */
    private static final String f10503t = "-1";

    /* renamed from: x, reason: collision with root package name */
    private static final String f10504x = "com.umeng.umcrash.UMCrashUtils";

    /* renamed from: y, reason: collision with root package name */
    private static Class<?> f10505y;

    /* renamed from: z, reason: collision with root package name */
    private static Method f10506z;

    /* renamed from: b, reason: collision with root package name */
    private c f10507b;

    /* renamed from: c, reason: collision with root package name */
    private SharedPreferences f10508c;

    /* renamed from: d, reason: collision with root package name */
    private String f10509d;

    /* renamed from: e, reason: collision with root package name */
    private String f10510e;

    /* renamed from: f, reason: collision with root package name */
    private int f10511f;

    /* renamed from: g, reason: collision with root package name */
    private JSONArray f10512g;

    /* renamed from: h, reason: collision with root package name */
    private final int f10513h;

    /* renamed from: i, reason: collision with root package name */
    private int f10514i;

    /* renamed from: j, reason: collision with root package name */
    private int f10515j;

    /* renamed from: k, reason: collision with root package name */
    private long f10516k;

    /* renamed from: s, reason: collision with root package name */
    private final long f10517s;

    /* renamed from: u, reason: collision with root package name */
    private boolean f10518u;

    /* renamed from: v, reason: collision with root package name */
    private boolean f10519v;

    /* renamed from: w, reason: collision with root package name */
    private Object f10520w;

    public static class a {
        public static final int A = 8209;
        public static final int B = 8210;
        public static final int C = 8211;
        public static final int D = 8212;
        public static final int E = 8213;
        public static final int F = 8214;
        public static final int G = 8215;

        /* renamed from: a, reason: collision with root package name */
        public static final int f10521a = 4097;

        /* renamed from: b, reason: collision with root package name */
        public static final int f10522b = 4098;

        /* renamed from: c, reason: collision with root package name */
        public static final int f10523c = 4099;

        /* renamed from: d, reason: collision with root package name */
        public static final int f10524d = 4100;

        /* renamed from: e, reason: collision with root package name */
        public static final int f10525e = 4101;

        /* renamed from: f, reason: collision with root package name */
        public static final int f10526f = 4102;

        /* renamed from: g, reason: collision with root package name */
        public static final int f10527g = 4103;

        /* renamed from: h, reason: collision with root package name */
        public static final int f10528h = 4104;

        /* renamed from: i, reason: collision with root package name */
        public static final int f10529i = 4105;

        /* renamed from: j, reason: collision with root package name */
        public static final int f10530j = 4106;

        /* renamed from: k, reason: collision with root package name */
        public static final int f10531k = 4352;

        /* renamed from: l, reason: collision with root package name */
        public static final int f10532l = 4353;

        /* renamed from: m, reason: collision with root package name */
        public static final int f10533m = 4354;

        /* renamed from: n, reason: collision with root package name */
        public static final int f10534n = 4355;

        /* renamed from: o, reason: collision with root package name */
        public static final int f10535o = 4356;

        /* renamed from: p, reason: collision with root package name */
        public static final int f10536p = 4357;

        /* renamed from: q, reason: collision with root package name */
        public static final int f10537q = 4358;

        /* renamed from: r, reason: collision with root package name */
        public static final int f10538r = 8193;

        /* renamed from: s, reason: collision with root package name */
        public static final int f10539s = 8194;

        /* renamed from: t, reason: collision with root package name */
        public static final int f10540t = 8195;

        /* renamed from: u, reason: collision with root package name */
        public static final int f10541u = 8196;

        /* renamed from: v, reason: collision with root package name */
        public static final int f10542v = 8197;

        /* renamed from: w, reason: collision with root package name */
        public static final int f10543w = 8199;

        /* renamed from: x, reason: collision with root package name */
        public static final int f10544x = 8200;

        /* renamed from: y, reason: collision with root package name */
        public static final int f10545y = 8201;

        /* renamed from: z, reason: collision with root package name */
        public static final int f10546z = 8208;
    }

    public static class b {

        /* renamed from: a, reason: collision with root package name */
        private static final q f10547a = new q();

        private b() {
        }
    }

    static {
        h();
    }

    public static q a(Context context) {
        if (f10495a == null && context != null) {
            f10495a = context.getApplicationContext();
        }
        return b.f10547a;
    }

    private void e(Object obj) {
        try {
            JSONObject jSONObject = (JSONObject) obj;
            if (2050 == jSONObject.getInt("__t")) {
                if (!a(this.f10516k, this.f10514i)) {
                    return;
                } else {
                    this.f10514i++;
                }
            } else if (2049 == jSONObject.getInt("__t")) {
                if (!a(this.f10516k, this.f10515j)) {
                    return;
                } else {
                    this.f10515j++;
                }
            }
            if (AnalyticsConfig.isRealTimeDebugMode()) {
                if (this.f10512g == null) {
                    this.f10512g = new JSONArray();
                }
                this.f10512g.put(jSONObject);
                k.a(f10495a).a(this.f10512g);
                this.f10512g = new JSONArray();
                return;
            }
            if (this.f10512g.length() >= this.f10511f) {
                UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>>*** 超过10个事件，事件落库。");
                k.a(f10495a).a(this.f10512g);
                this.f10512g = new JSONArray();
            }
            if (this.f10516k == 0) {
                this.f10516k = System.currentTimeMillis();
            }
            this.f10512g.put(jSONObject);
        } catch (Throwable th) {
            MLog.e(th);
        }
    }

    private void f(JSONObject jSONObject) {
        JSONObject optJSONObject;
        JSONObject optJSONObject2;
        try {
            if (!jSONObject.getJSONObject(com.umeng.commonsdk.statistics.b.a("header")).has(f.aH)) {
                if (jSONObject.has("content")) {
                    jSONObject = jSONObject.getJSONObject("content");
                }
                if (jSONObject.has(com.umeng.commonsdk.statistics.b.a("analytics")) && (optJSONObject = jSONObject.optJSONObject(com.umeng.commonsdk.statistics.b.a("analytics"))) != null && optJSONObject.length() > 0 && optJSONObject.has(f.f10332n)) {
                    k.a(f10495a).a(true, false);
                }
                k.a(f10495a).b();
                return;
            }
            if (jSONObject.has("content")) {
                jSONObject = jSONObject.getJSONObject("content");
            }
            if (jSONObject.has(com.umeng.commonsdk.statistics.b.a("analytics"))) {
                JSONObject jSONObject2 = jSONObject.getJSONObject(com.umeng.commonsdk.statistics.b.a("analytics"));
                if (jSONObject2.has(f.f10332n) && (optJSONObject2 = jSONObject2.getJSONArray(f.f10332n).optJSONObject(0)) != null) {
                    String optString = optJSONObject2.optString("id");
                    if (!TextUtils.isEmpty(optString)) {
                        UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> removeAllInstantData: really delete instant session data");
                        k.a(f10495a).b(optString);
                    }
                }
            }
            k.a(f10495a).b();
            UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> removeAllInstantData: send INSTANT_SESSION_START_CONTINUE event because OVERSIZE.");
            Context context = f10495a;
            UMWorkDispatch.sendEvent(context, a.f10532l, CoreProtocol.getInstance(context), null);
        } catch (Exception unused) {
        }
    }

    private static void h() {
        try {
            f10505y = UMCrashUtils.class;
            Method declaredMethod = UMCrashUtils.class.getDeclaredMethod("setPuidAndProvider", String.class, String.class);
            if (declaredMethod != null) {
                f10506z = declaredMethod;
            }
        } catch (Throwable unused) {
        }
    }

    private void i() {
        JSONObject b10 = b(UMEnvelopeBuild.maxDataSpace(f10495a));
        if (b10 == null || b10.length() < 1) {
            return;
        }
        JSONObject jSONObject = (JSONObject) b10.opt("header");
        JSONObject jSONObject2 = (JSONObject) b10.opt("content");
        if (f10495a == null || jSONObject == null || jSONObject2 == null) {
            return;
        }
        UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> constructInstantMessage: request build envelope.");
        JSONObject buildEnvelopeWithExtHeader = UMEnvelopeBuild.buildEnvelopeWithExtHeader(f10495a, jSONObject, jSONObject2);
        if (buildEnvelopeWithExtHeader != null) {
            try {
                if (buildEnvelopeWithExtHeader.has("exception")) {
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "Build envelope error code: " + buildEnvelopeWithExtHeader.getInt("exception"));
                }
            } catch (Throwable unused) {
            }
            if (UMConfigure.isDebugLog()) {
                e(buildEnvelopeWithExtHeader);
            }
            b((Object) buildEnvelopeWithExtHeader);
        }
    }

    private void j() {
        JSONObject buildEnvelopeWithExtHeader;
        JSONObject a10 = a(UMEnvelopeBuild.maxDataSpace(f10495a));
        if (a10 == null || a10.length() < 1) {
            return;
        }
        JSONObject jSONObject = (JSONObject) a10.opt("header");
        JSONObject jSONObject2 = (JSONObject) a10.opt("content");
        Context context = f10495a;
        if (context == null || jSONObject == null || jSONObject2 == null || (buildEnvelopeWithExtHeader = UMEnvelopeBuild.buildEnvelopeWithExtHeader(context, jSONObject, jSONObject2)) == null) {
            return;
        }
        try {
            if (buildEnvelopeWithExtHeader.has("exception")) {
                UMRTLog.i(UMRTLog.RTLOG_TAG, "Build envelope error code: " + buildEnvelopeWithExtHeader.getInt("exception"));
            }
        } catch (Throwable unused) {
        }
        if (UMConfigure.isDebugLog()) {
            d(buildEnvelopeWithExtHeader);
        }
        a((Object) buildEnvelopeWithExtHeader);
    }

    private JSONObject k() {
        JSONObject l10 = l();
        if (l10 != null) {
            try {
                l10.put("st", "1");
            } catch (Throwable unused) {
            }
        }
        return l10;
    }

    private JSONObject l() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (AnalyticsConfig.mWrapperType != null && AnalyticsConfig.mWrapperVersion != null) {
                jSONObject.put(com.umeng.commonsdk.statistics.b.a("wrapper_version"), AnalyticsConfig.mWrapperVersion);
                jSONObject.put(com.umeng.commonsdk.statistics.b.a("wrapper_type"), AnalyticsConfig.mWrapperType);
            }
            int verticalType = AnalyticsConfig.getVerticalType(f10495a);
            jSONObject.put(com.umeng.commonsdk.statistics.b.a(f.f10327i), verticalType);
            String str = "9.7.9";
            if (verticalType == 1) {
                String gameSdkVersion = AnalyticsConfig.getGameSdkVersion(f10495a);
                if (!TextUtils.isEmpty(gameSdkVersion)) {
                    str = gameSdkVersion;
                }
                jSONObject.put(com.umeng.commonsdk.statistics.b.a("sdk_version"), str);
            } else {
                jSONObject.put(com.umeng.commonsdk.statistics.b.a("sdk_version"), "9.7.9");
            }
            String MD5 = HelperUtils.MD5(AnalyticsConfig.getSecretKey(f10495a));
            if (!TextUtils.isEmpty(MD5)) {
                jSONObject.put(com.umeng.commonsdk.statistics.b.a("secret"), MD5);
            }
            String imprintProperty = UMEnvelopeBuild.imprintProperty(f10495a, "pr_ve", null);
            SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(f10495a);
            String imprintProperty2 = UMEnvelopeBuild.imprintProperty(f10495a, f.at, "");
            if (!TextUtils.isEmpty(imprintProperty2)) {
                if (AnalyticsConfig.CLEAR_EKV_BL) {
                    jSONObject.put(com.umeng.commonsdk.statistics.b.a(f.av), "");
                } else {
                    jSONObject.put(com.umeng.commonsdk.statistics.b.a(f.av), imprintProperty2);
                }
            }
            String imprintProperty3 = UMEnvelopeBuild.imprintProperty(f10495a, f.au, "");
            if (!TextUtils.isEmpty(imprintProperty3)) {
                if (AnalyticsConfig.CLEAR_EKV_WL) {
                    jSONObject.put(com.umeng.commonsdk.statistics.b.a(f.aw), "");
                } else {
                    jSONObject.put(com.umeng.commonsdk.statistics.b.a(f.aw), imprintProperty3);
                }
            }
            jSONObject.put(com.umeng.commonsdk.statistics.b.a(f.an), "1.0.0");
            if (s()) {
                jSONObject.put(com.umeng.commonsdk.statistics.b.a(f.ap), "1");
                if (sharedPreferences != null) {
                    sharedPreferences.edit().putLong(f10497m, 0L).commit();
                }
            }
            jSONObject.put(com.umeng.commonsdk.statistics.b.a(f.f10330l), m());
            jSONObject.put(com.umeng.commonsdk.statistics.b.a(f.f10331m), n());
            if (sharedPreferences != null) {
                String string = sharedPreferences.getString("vers_name", "");
                if (!TextUtils.isEmpty(string)) {
                    String format = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date(System.currentTimeMillis()));
                    if (TextUtils.isEmpty(imprintProperty)) {
                        jSONObject.put(com.umeng.commonsdk.statistics.b.a(f.f10330l), sharedPreferences.getString("vers_pre_version", "0"));
                        jSONObject.put(com.umeng.commonsdk.statistics.b.a(f.f10331m), sharedPreferences.getString("vers_date", format));
                    }
                    sharedPreferences.edit().putString("pre_version", string).putString("cur_version", DeviceConfig.getAppVersionName(f10495a)).putString("pre_date", format).remove("vers_name").remove("vers_code").remove("vers_date").remove("vers_pre_version").commit();
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return jSONObject;
    }

    private String m() {
        String str = "0";
        String str2 = null;
        try {
            str2 = UMEnvelopeBuild.imprintProperty(f10495a, "pr_ve", null);
        } catch (Throwable unused) {
        }
        if (TextUtils.isEmpty(str2)) {
            if (!TextUtils.isEmpty(this.f10509d)) {
                return this.f10509d;
            }
            if (this.f10508c == null) {
                this.f10508c = PreferenceWrapper.getDefault(f10495a);
            }
            String string = this.f10508c.getString("pre_version", "");
            String appVersionName = DeviceConfig.getAppVersionName(f10495a);
            if (TextUtils.isEmpty(string)) {
                this.f10508c.edit().putString("pre_version", "0").putString("cur_version", appVersionName).commit();
            } else {
                str = this.f10508c.getString("cur_version", "");
                if (appVersionName.equals(str)) {
                    str = string;
                } else {
                    this.f10508c.edit().putString("pre_version", str).putString("cur_version", appVersionName).commit();
                }
            }
            this.f10509d = str;
            return str;
        }
        str = str2;
        this.f10509d = str;
        return str;
    }

    private String n() {
        String str = null;
        try {
            str = UMEnvelopeBuild.imprintProperty(f10495a, "ud_da", null);
            if (TextUtils.isEmpty(str)) {
                if (!TextUtils.isEmpty(this.f10510e)) {
                    return this.f10510e;
                }
                if (this.f10508c == null) {
                    this.f10508c = PreferenceWrapper.getDefault(f10495a);
                }
                String string = this.f10508c.getString("pre_date", "");
                if (TextUtils.isEmpty(string)) {
                    string = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date(System.currentTimeMillis()));
                    this.f10508c.edit().putString("pre_date", string).commit();
                } else {
                    String format = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date(System.currentTimeMillis()));
                    if (!string.equals(format)) {
                        this.f10508c.edit().putString("pre_date", format).commit();
                        str = format;
                    }
                }
                str = string;
            }
        } catch (Throwable unused) {
        }
        this.f10510e = str;
        return str;
    }

    private void o() {
        try {
            this.f10514i = 0;
            this.f10515j = 0;
            this.f10516k = System.currentTimeMillis();
            PreferenceWrapper.getDefault(f10495a).edit().putLong(f10499o, System.currentTimeMillis()).putInt(f10500p, 0).commit();
        } catch (Throwable unused) {
        }
    }

    private boolean p() {
        try {
            if (!TextUtils.isEmpty(w.a().b())) {
                b(f10495a);
            }
            if (this.f10512g.length() <= 0) {
                return false;
            }
            for (int i10 = 0; i10 < this.f10512g.length(); i10++) {
                JSONObject optJSONObject = this.f10512g.optJSONObject(i10);
                if (optJSONObject != null && optJSONObject.length() > 0) {
                    String optString = optJSONObject.optString("__i");
                    if (TextUtils.isEmpty(optString) || f10503t.equals(optString)) {
                        return false;
                    }
                }
            }
            return true;
        } catch (Throwable unused) {
            return true;
        }
    }

    private void q() {
        if (this.f10512g.length() > 0) {
            JSONArray jSONArray = new JSONArray();
            for (int i10 = 0; i10 < this.f10512g.length(); i10++) {
                try {
                    JSONObject jSONObject = this.f10512g.getJSONObject(i10);
                    if (jSONObject == null || jSONObject.length() <= 0) {
                        jSONArray.put(jSONObject);
                    } else {
                        String optString = jSONObject.optString("__i");
                        boolean isEmpty = TextUtils.isEmpty(optString);
                        String str = f10503t;
                        if (isEmpty || f10503t.equals(optString)) {
                            String b10 = w.a().b();
                            if (!TextUtils.isEmpty(b10)) {
                                str = b10;
                            }
                            jSONObject.put("__i", str);
                        }
                        jSONArray.put(jSONObject);
                    }
                } catch (Throwable unused) {
                }
            }
            this.f10512g = jSONArray;
        }
    }

    private void r() {
        Context context;
        SharedPreferences sharedPreferences;
        try {
            if (!s() || (context = f10495a) == null || (sharedPreferences = PreferenceWrapper.getDefault(context)) == null || sharedPreferences.getLong(f10496l, 0L) != 0) {
                return;
            }
            sharedPreferences.edit().putLong(f10496l, System.currentTimeMillis()).commit();
        } catch (Throwable unused) {
        }
    }

    private boolean s() {
        SharedPreferences sharedPreferences;
        try {
            Context context = f10495a;
            if (context == null || (sharedPreferences = PreferenceWrapper.getDefault(context)) == null) {
                return false;
            }
            return sharedPreferences.getLong(f10497m, -1L) != 0;
        } catch (Throwable unused) {
            return false;
        }
    }

    public void b() {
    }

    public void c() {
        b(f10495a);
        d();
        a(true);
    }

    public void d() {
        try {
            if (this.f10512g.length() > 0) {
                UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>>*** flushMemoryData: 事件落库。");
                k.a(f10495a).a(this.f10512g);
                this.f10512g = new JSONArray();
            }
            PreferenceWrapper.getDefault(f10495a).edit().putLong(f10498n, this.f10516k).putInt(f10501q, this.f10514i).putInt(f10502r, this.f10515j).commit();
        } catch (Throwable unused) {
        }
    }

    private q() {
        this.f10507b = null;
        this.f10508c = null;
        this.f10509d = null;
        this.f10510e = null;
        this.f10511f = 10;
        this.f10512g = new JSONArray();
        this.f10513h = com.hpplay.a.a.a.d.SOCKET_READ_TIMEOUT;
        this.f10514i = 0;
        this.f10515j = 0;
        this.f10516k = 0L;
        this.f10517s = 28800000L;
        this.f10518u = false;
        this.f10519v = false;
        this.f10520w = new Object();
        try {
            SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(f10495a);
            this.f10516k = sharedPreferences.getLong(f10498n, 0L);
            this.f10514i = sharedPreferences.getInt(f10501q, 0);
            this.f10515j = sharedPreferences.getInt(f10502r, 0);
            this.f10507b = new c();
        } catch (Throwable unused) {
        }
    }

    private void b(JSONObject jSONObject) {
        JSONObject f10;
        if (k.a(UMGlobalContext.getAppContext(f10495a)).c() || (f10 = k.a(UMGlobalContext.getAppContext(f10495a)).f()) == null) {
            return;
        }
        String optString = f10.optString("__av");
        String optString2 = f10.optString("__vc");
        try {
            if (TextUtils.isEmpty(optString)) {
                jSONObject.put(com.umeng.commonsdk.statistics.b.a("app_version"), UMUtils.getAppVersionName(f10495a));
            } else {
                jSONObject.put(com.umeng.commonsdk.statistics.b.a("app_version"), optString);
            }
            if (TextUtils.isEmpty(optString2)) {
                jSONObject.put(com.umeng.commonsdk.statistics.b.a("version_code"), UMUtils.getAppVersionCode(f10495a));
            } else {
                jSONObject.put(com.umeng.commonsdk.statistics.b.a("version_code"), optString2);
            }
        } catch (Throwable unused) {
        }
    }

    private void g(JSONObject jSONObject) {
        JSONObject optJSONObject;
        try {
            if (jSONObject.getJSONObject(com.umeng.commonsdk.statistics.b.a("header")).has(f.aH)) {
                if (jSONObject.has("content")) {
                    jSONObject = jSONObject.getJSONObject("content");
                }
                if (jSONObject.has(com.umeng.commonsdk.statistics.b.a("analytics"))) {
                    if (!jSONObject.getJSONObject(com.umeng.commonsdk.statistics.b.a("analytics")).has(f.f10332n)) {
                        UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> Error, Should not go to this branch.");
                        return;
                    }
                    k.a(f10495a).i();
                    k.a(f10495a).h();
                    k.a(f10495a).b(true, false);
                    k.a(f10495a).a();
                    return;
                }
                return;
            }
            if (jSONObject.has("content")) {
                jSONObject = jSONObject.getJSONObject("content");
            }
            if (jSONObject.has(com.umeng.commonsdk.statistics.b.a("analytics")) && (optJSONObject = jSONObject.optJSONObject(com.umeng.commonsdk.statistics.b.a("analytics"))) != null && optJSONObject.length() > 0) {
                if (optJSONObject.has(f.f10332n)) {
                    k.a(f10495a).b(true, false);
                }
                if (optJSONObject.has("ekv") || optJSONObject.has(f.Z)) {
                    k.a(f10495a).h();
                }
                if (optJSONObject.has("error")) {
                    k.a(f10495a).i();
                }
            }
            k.a(f10495a).a();
        } catch (Exception unused) {
        }
    }

    public static class c {

        /* renamed from: a, reason: collision with root package name */
        private ReportPolicy.ReportStrategy f10548a = null;

        /* renamed from: b, reason: collision with root package name */
        private int f10549b = -1;

        /* renamed from: c, reason: collision with root package name */
        private int f10550c = -1;

        /* renamed from: d, reason: collision with root package name */
        private int f10551d = -1;

        /* renamed from: e, reason: collision with root package name */
        private int f10552e = -1;

        /* renamed from: f, reason: collision with root package name */
        private ABTest f10553f;

        public c() {
            this.f10553f = null;
            this.f10553f = ABTest.getService(q.f10495a);
        }

        public void a() {
            try {
                int[] a10 = a(-1, -1);
                this.f10549b = a10[0];
                this.f10550c = a10[1];
            } catch (Throwable unused) {
            }
        }

        public void b() {
            int i10;
            Defcon service = Defcon.getService(q.f10495a);
            if (service.isOpen()) {
                ReportPolicy.ReportStrategy reportStrategy = this.f10548a;
                this.f10548a = (reportStrategy instanceof ReportPolicy.DefconPolicy) && reportStrategy.isValid() ? this.f10548a : new ReportPolicy.DefconPolicy(StatTracer.getInstance(q.f10495a), service);
            } else {
                boolean z10 = Integer.valueOf(UMEnvelopeBuild.imprintProperty(q.f10495a, "integrated_test", q.f10503t)).intValue() == 1;
                if (UMConfigure.isDebugLog() && z10 && !MLog.DEBUG) {
                    UMLog.mutlInfo(l.K, 3, "\\|", null, null);
                }
                if (MLog.DEBUG && z10) {
                    this.f10548a = new ReportPolicy.DebugPolicy(StatTracer.getInstance(q.f10495a));
                } else if (this.f10553f.isInTest() && "RPT".equals(this.f10553f.getTestName())) {
                    if (this.f10553f.getTestPolicy() == 6) {
                        if (Integer.valueOf(UMEnvelopeBuild.imprintProperty(q.f10495a, "test_report_interval", q.f10503t)).intValue() != -1) {
                            i10 = a(90000);
                        } else {
                            i10 = this.f10550c;
                            if (i10 <= 0) {
                                i10 = this.f10552e;
                            }
                        }
                    } else {
                        i10 = 0;
                    }
                    this.f10548a = b(this.f10553f.getTestPolicy(), i10);
                } else {
                    int i11 = this.f10551d;
                    int i12 = this.f10552e;
                    int i13 = this.f10549b;
                    if (i13 != -1) {
                        i12 = this.f10550c;
                        i11 = i13;
                    }
                    this.f10548a = b(i11, i12);
                }
            }
            if (UMConfigure.isDebugLog()) {
                try {
                    ReportPolicy.ReportStrategy reportStrategy2 = this.f10548a;
                    if (reportStrategy2 instanceof ReportPolicy.ReportAtLaunch) {
                        UMLog.mutlInfo(l.I, 3, "", null, null);
                    } else if (reportStrategy2 instanceof ReportPolicy.ReportByInterval) {
                        UMLog.mutlInfo(l.J, 3, "", new String[]{"@"}, new String[]{String.valueOf(((ReportPolicy.ReportByInterval) reportStrategy2).getReportInterval() / 1000)});
                    } else if (reportStrategy2 instanceof ReportPolicy.DebugPolicy) {
                        UMLog.mutlInfo(l.L, 3, "", null, null);
                    } else if (reportStrategy2 instanceof ReportPolicy.ReportQuasiRealtime) {
                        UMLog.mutlInfo(l.M, 3, "", new String[]{"@"}, new String[]{String.valueOf(((ReportPolicy.ReportQuasiRealtime) reportStrategy2).getReportInterval() / 1000)});
                    } else {
                        boolean z11 = reportStrategy2 instanceof ReportPolicy.DefconPolicy;
                    }
                } catch (Throwable unused) {
                }
            }
        }

        public ReportPolicy.ReportStrategy c() {
            b();
            return this.f10548a;
        }

        public int[] a(int i10, int i11) {
            int intValue = Integer.valueOf(UMEnvelopeBuild.imprintProperty(q.f10495a, "report_policy", q.f10503t)).intValue();
            int intValue2 = Integer.valueOf(UMEnvelopeBuild.imprintProperty(q.f10495a, "report_interval", q.f10503t)).intValue();
            if (intValue == -1 || !ReportPolicy.isValid(intValue)) {
                return new int[]{i10, i11};
            }
            if (6 == intValue) {
                if (intValue2 == -1 || intValue2 < 90 || intValue2 > 86400) {
                    intValue2 = 90;
                }
                return new int[]{intValue, intValue2 * 1000};
            }
            if (11 == intValue) {
                if (intValue2 == -1 || intValue2 < 15 || intValue2 > 3600) {
                    intValue2 = 15;
                }
                return new int[]{intValue, intValue2 * 1000};
            }
            return new int[]{i10, i11};
        }

        public int a(int i10) {
            int intValue = Integer.valueOf(UMEnvelopeBuild.imprintProperty(q.f10495a, "test_report_interval", q.f10503t)).intValue();
            return (intValue == -1 || intValue < 90 || intValue > 86400) ? i10 : intValue * 1000;
        }

        private ReportPolicy.ReportStrategy b(int i10, int i11) {
            if (i10 == 0) {
                ReportPolicy.ReportStrategy reportStrategy = this.f10548a;
                return reportStrategy instanceof ReportPolicy.ReportRealtime ? reportStrategy : new ReportPolicy.ReportRealtime();
            }
            if (i10 == 1) {
                ReportPolicy.ReportStrategy reportStrategy2 = this.f10548a;
                return reportStrategy2 instanceof ReportPolicy.ReportAtLaunch ? reportStrategy2 : new ReportPolicy.ReportAtLaunch();
            }
            if (i10 == 4) {
                ReportPolicy.ReportStrategy reportStrategy3 = this.f10548a;
                return reportStrategy3 instanceof ReportPolicy.ReportDaily ? reportStrategy3 : new ReportPolicy.ReportDaily(StatTracer.getInstance(q.f10495a));
            }
            if (i10 == 5) {
                ReportPolicy.ReportStrategy reportStrategy4 = this.f10548a;
                return reportStrategy4 instanceof ReportPolicy.ReportWifiOnly ? reportStrategy4 : new ReportPolicy.ReportWifiOnly(q.f10495a);
            }
            if (i10 == 6) {
                ReportPolicy.ReportStrategy reportStrategy5 = this.f10548a;
                if (reportStrategy5 instanceof ReportPolicy.ReportByInterval) {
                    ((ReportPolicy.ReportByInterval) reportStrategy5).setReportInterval(i11);
                    return reportStrategy5;
                }
                return new ReportPolicy.ReportByInterval(StatTracer.getInstance(q.f10495a), i11);
            }
            if (i10 == 8) {
                ReportPolicy.ReportStrategy reportStrategy6 = this.f10548a;
                return reportStrategy6 instanceof ReportPolicy.SmartPolicy ? reportStrategy6 : new ReportPolicy.SmartPolicy(StatTracer.getInstance(q.f10495a));
            }
            if (i10 != 11) {
                ReportPolicy.ReportStrategy reportStrategy7 = this.f10548a;
                return reportStrategy7 instanceof ReportPolicy.ReportAtLaunch ? reportStrategy7 : new ReportPolicy.ReportAtLaunch();
            }
            ReportPolicy.ReportStrategy reportStrategy8 = this.f10548a;
            if (reportStrategy8 instanceof ReportPolicy.ReportQuasiRealtime) {
                ((ReportPolicy.ReportQuasiRealtime) reportStrategy8).setReportInterval(i11);
                return reportStrategy8;
            }
            ReportPolicy.ReportQuasiRealtime reportQuasiRealtime = new ReportPolicy.ReportQuasiRealtime();
            reportQuasiRealtime.setReportInterval(i11);
            return reportQuasiRealtime;
        }
    }

    private void c(JSONObject jSONObject) {
        try {
            if (!k.a(f10495a).e()) {
                JSONObject g10 = k.a(f10495a).g();
                if (g10 != null) {
                    String optString = g10.optString("__av");
                    String optString2 = g10.optString("__vc");
                    if (TextUtils.isEmpty(optString)) {
                        jSONObject.put(com.umeng.commonsdk.statistics.b.a("app_version"), UMUtils.getAppVersionName(f10495a));
                    } else {
                        jSONObject.put(com.umeng.commonsdk.statistics.b.a("app_version"), optString);
                    }
                    if (TextUtils.isEmpty(optString2)) {
                        jSONObject.put(com.umeng.commonsdk.statistics.b.a("version_code"), UMUtils.getAppVersionCode(f10495a));
                        return;
                    } else {
                        jSONObject.put(com.umeng.commonsdk.statistics.b.a("version_code"), optString2);
                        return;
                    }
                }
                return;
            }
            jSONObject.put(com.umeng.commonsdk.statistics.b.a("app_version"), UMUtils.getAppVersionName(f10495a));
            jSONObject.put(com.umeng.commonsdk.statistics.b.a("version_code"), UMUtils.getAppVersionCode(f10495a));
        } catch (Throwable unused) {
        }
    }

    public void a() {
        if (f10495a != null) {
            synchronized (this.f10520w) {
                if (this.f10518u) {
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> network is now available, rebuild instant session data packet.");
                    Context context = f10495a;
                    UMWorkDispatch.sendEvent(context, a.f10532l, CoreProtocol.getInstance(context), null);
                }
            }
            synchronized (this.f10520w) {
                if (this.f10519v) {
                    Context context2 = f10495a;
                    UMWorkDispatch.sendEvent(context2, a.f10533m, CoreProtocol.getInstance(context2), null);
                }
            }
        }
    }

    public static class d {

        /* renamed from: a, reason: collision with root package name */
        private Map<String, Object> f10554a;

        /* renamed from: b, reason: collision with root package name */
        private String f10555b;

        /* renamed from: c, reason: collision with root package name */
        private String f10556c;

        /* renamed from: d, reason: collision with root package name */
        private long f10557d;

        private d() {
            this.f10554a = null;
            this.f10555b = null;
            this.f10556c = null;
            this.f10557d = 0L;
        }

        public Map<String, Object> a() {
            return this.f10554a;
        }

        public String b() {
            return this.f10556c;
        }

        public String c() {
            return this.f10555b;
        }

        public long d() {
            return this.f10557d;
        }

        public d(String str, Map<String, Object> map, String str2, long j10) {
            this.f10554a = map;
            this.f10555b = str;
            this.f10557d = j10;
            this.f10556c = str2;
        }
    }

    private void h(Object obj) {
        try {
            JSONObject jSONObject = (JSONObject) obj;
            if (jSONObject == null || jSONObject.length() <= 0 || !jSONObject.has("__ii")) {
                return;
            }
            String optString = jSONObject.optString("__ii");
            jSONObject.remove("__ii");
            if (TextUtils.isEmpty(optString)) {
                return;
            }
            k.a(f10495a).a(optString, obj.toString(), 2);
        } catch (Throwable unused) {
        }
    }

    private void d(JSONObject jSONObject) {
        JSONObject jSONObject2;
        if (jSONObject == null) {
            return;
        }
        try {
            if (jSONObject.length() <= 0) {
                return;
            }
            JSONObject jSONObject3 = new JSONObject();
            if (jSONObject.has(com.umeng.commonsdk.statistics.b.a("analytics"))) {
                JSONObject jSONObject4 = jSONObject.getJSONObject(com.umeng.commonsdk.statistics.b.a("analytics"));
                if (jSONObject4.has("ekv")) {
                    jSONObject3.put("ekv", jSONObject4.getJSONArray("ekv"));
                    if (jSONObject3.length() > 0) {
                        if (AnalyticsConfig.isRealTimeDebugMode()) {
                            MLog.d("[埋点验证模式]事件:" + jSONObject3.toString());
                        } else {
                            MLog.d("事件:" + jSONObject3.toString());
                        }
                        jSONObject3 = new JSONObject();
                    }
                }
                if (jSONObject4.has(f.Z)) {
                    jSONObject3.put(f.Z, jSONObject4.getJSONArray(f.Z));
                    if (jSONObject3.length() > 0) {
                        if (AnalyticsConfig.isRealTimeDebugMode()) {
                            MLog.d("[埋点验证模式]游戏事件:" + jSONObject3.toString());
                        } else {
                            MLog.d("游戏事件:" + jSONObject3.toString());
                        }
                        jSONObject3 = new JSONObject();
                    }
                }
                if (jSONObject4.has("error")) {
                    jSONObject3.put("error", jSONObject4.getJSONArray("error"));
                    if (jSONObject3.length() > 0) {
                        if (AnalyticsConfig.isRealTimeDebugMode()) {
                            MLog.d("[埋点验证模式]错误:" + jSONObject3.toString());
                        } else {
                            MLog.d("错误:" + jSONObject3.toString());
                        }
                        jSONObject3 = new JSONObject();
                    }
                }
                if (jSONObject4.has(f.f10332n)) {
                    JSONArray jSONArray = jSONObject4.getJSONArray(f.f10332n);
                    JSONArray jSONArray2 = new JSONArray();
                    for (int i10 = 0; i10 < jSONArray.length(); i10++) {
                        JSONObject jSONObject5 = jSONArray.getJSONObject(i10);
                        if (jSONObject5 != null && jSONObject5.length() > 0) {
                            if (jSONObject5.has(f.f10339u)) {
                                jSONObject5.remove(f.f10339u);
                            }
                            jSONArray2.put(jSONObject5);
                        }
                    }
                    jSONObject3.put(f.f10332n, jSONArray2);
                    if (jSONObject3.length() > 0) {
                        if (AnalyticsConfig.isRealTimeDebugMode()) {
                            MLog.d("[埋点验证模式]会话:" + jSONObject3.toString());
                        } else {
                            MLog.d("会话:" + jSONObject3.toString());
                        }
                        jSONObject3 = new JSONObject();
                    }
                }
                if (jSONObject4.has(f.I)) {
                    jSONObject3.put(f.I, jSONObject4.getJSONObject(f.I));
                }
                if (jSONObject4.has(f.L)) {
                    jSONObject3.put(f.L, jSONObject4.getJSONObject(f.L));
                    if (jSONObject3.length() > 0) {
                        if (AnalyticsConfig.isRealTimeDebugMode()) {
                            MLog.d("[埋点验证模式]账号:" + jSONObject3.toString());
                        } else {
                            MLog.d("账号:" + jSONObject3.toString());
                        }
                        jSONObject3 = new JSONObject();
                    }
                }
            }
            if (jSONObject.has("dplus")) {
                jSONObject3.put("dplus", jSONObject.getJSONObject("dplus"));
            }
            if (jSONObject.has(com.umeng.commonsdk.statistics.b.a("header")) && (jSONObject2 = jSONObject.getJSONObject(com.umeng.commonsdk.statistics.b.a("header"))) != null && jSONObject2.length() > 0) {
                if (jSONObject2.has(com.umeng.commonsdk.statistics.b.a("sdk_version"))) {
                    jSONObject3.put("sdk_version", jSONObject2.getString(com.umeng.commonsdk.statistics.b.a("sdk_version")));
                }
                if (jSONObject2.has(com.umeng.commonsdk.statistics.b.a("device_id"))) {
                    jSONObject3.put("device_id", jSONObject2.getString(com.umeng.commonsdk.statistics.b.a("device_id")));
                }
                if (jSONObject2.has(com.umeng.commonsdk.statistics.b.a("device_model"))) {
                    jSONObject3.put("device_model", jSONObject2.getString(com.umeng.commonsdk.statistics.b.a("device_model")));
                }
                if (jSONObject2.has(com.umeng.commonsdk.statistics.b.a("version_code"))) {
                    jSONObject3.put("version", jSONObject2.getInt(com.umeng.commonsdk.statistics.b.a("version_code")));
                }
                if (jSONObject2.has(com.umeng.commonsdk.statistics.b.a("appkey"))) {
                    jSONObject3.put("appkey", jSONObject2.getString(com.umeng.commonsdk.statistics.b.a("appkey")));
                }
                if (jSONObject2.has(com.umeng.commonsdk.statistics.b.a("channel"))) {
                    jSONObject3.put("channel", jSONObject2.getString(com.umeng.commonsdk.statistics.b.a("channel")));
                }
                if (jSONObject3.length() > 0) {
                    MLog.d("基础信息:" + jSONObject3.toString());
                    jSONObject3 = new JSONObject();
                }
            }
            jSONObject3.length();
        } catch (Throwable th) {
            MLog.e(th);
        }
    }

    public JSONObject b(long j10) {
        if (TextUtils.isEmpty(aa.a().d(UMGlobalContext.getAppContext(f10495a)))) {
            return null;
        }
        JSONObject b10 = k.a(UMGlobalContext.getAppContext(f10495a)).b(false);
        String[] a10 = com.umeng.analytics.c.a(f10495a);
        if (a10 != null && !TextUtils.isEmpty(a10[0]) && !TextUtils.isEmpty(a10[1])) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(f.M, a10[0]);
                jSONObject.put(f.N, a10[1]);
                if (jSONObject.length() > 0) {
                    b10.put(f.L, jSONObject);
                }
            } catch (Throwable unused) {
            }
        }
        int a11 = t.a().a(f10495a);
        if (b10.length() == 1 && b10.optJSONObject(f.L) != null && a11 != 3) {
            return null;
        }
        t.a().b(b10, f10495a);
        if (b10.length() <= 0 && a11 != 3) {
            return null;
        }
        JSONObject k10 = k();
        if (k10 != null) {
            b(k10);
        }
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = new JSONObject();
        try {
            if (a11 == 3) {
                jSONObject3.put("analytics", new JSONObject());
            } else if (b10.length() > 0) {
                jSONObject3.put("analytics", b10);
            }
            if (k10 != null && k10.length() > 0) {
                jSONObject2.put("header", k10);
            }
            if (jSONObject3.length() > 0) {
                jSONObject2.put("content", jSONObject3);
            }
            return b(jSONObject2, j10);
        } catch (Throwable unused2) {
            return jSONObject2;
        }
    }

    private boolean c(boolean z10) {
        if (s() || AnalyticsConfig.isRealTimeDebugMode()) {
            return true;
        }
        if (this.f10507b == null) {
            this.f10507b = new c();
        }
        this.f10507b.a();
        ReportPolicy.ReportStrategy c10 = this.f10507b.c();
        boolean shouldSendMessage = c10.shouldSendMessage(z10);
        if (shouldSendMessage) {
            if (((c10 instanceof ReportPolicy.ReportByInterval) || (c10 instanceof ReportPolicy.DebugPolicy) || (c10 instanceof ReportPolicy.ReportQuasiRealtime)) && p()) {
                d();
            }
            if ((c10 instanceof ReportPolicy.DefconPolicy) && p()) {
                d();
            }
            if (UMConfigure.isDebugLog()) {
                MLog.d("数据发送策略 : " + c10.getClass().getSimpleName());
            }
        }
        return shouldSendMessage;
    }

    private void a(String str, String str2) {
        Method method;
        Class<?> cls = f10505y;
        if (cls == null || (method = f10506z) == null) {
            return;
        }
        try {
            method.invoke(cls, str, str2);
        } catch (Throwable unused) {
            UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> reflect call setPuidAndProvider method of crash lib failed.");
        }
    }

    private void e(JSONObject jSONObject) {
        JSONObject jSONObject2;
        if (jSONObject == null) {
            return;
        }
        try {
            if (jSONObject.length() <= 0) {
                return;
            }
            JSONObject jSONObject3 = new JSONObject();
            if (jSONObject.has(com.umeng.commonsdk.statistics.b.a("analytics"))) {
                JSONObject jSONObject4 = jSONObject.getJSONObject(com.umeng.commonsdk.statistics.b.a("analytics"));
                if (jSONObject4.has(f.f10332n)) {
                    JSONArray jSONArray = jSONObject4.getJSONArray(f.f10332n);
                    JSONArray jSONArray2 = new JSONArray();
                    for (int i10 = 0; i10 < jSONArray.length(); i10++) {
                        JSONObject jSONObject5 = jSONArray.getJSONObject(i10);
                        if (jSONObject5 != null && jSONObject5.length() > 0) {
                            jSONArray2.put(jSONObject5);
                        }
                    }
                    jSONObject3.put(f.f10332n, jSONArray2);
                    if (jSONObject3.length() > 0) {
                        MLog.d("本次启动会话:" + jSONObject3.toString());
                        jSONObject3 = new JSONObject();
                    }
                }
                if (jSONObject4.has(f.L)) {
                    jSONObject3.put(f.L, jSONObject4.getJSONObject(f.L));
                    if (jSONObject3.length() > 0) {
                        MLog.d("本次启动账号:" + jSONObject3.toString());
                        jSONObject3 = new JSONObject();
                    }
                }
            }
            if (jSONObject.has(com.umeng.commonsdk.statistics.b.a("header")) && jSONObject.has(com.umeng.commonsdk.statistics.b.a("header")) && (jSONObject2 = jSONObject.getJSONObject(com.umeng.commonsdk.statistics.b.a("header"))) != null && jSONObject2.length() > 0) {
                if (jSONObject2.has(com.umeng.commonsdk.statistics.b.a("sdk_version"))) {
                    jSONObject3.put("sdk_version", jSONObject2.getString(com.umeng.commonsdk.statistics.b.a("sdk_version")));
                }
                if (jSONObject2.has(com.umeng.commonsdk.statistics.b.a("device_id"))) {
                    jSONObject3.put("device_id", jSONObject2.getString(com.umeng.commonsdk.statistics.b.a("device_id")));
                }
                if (jSONObject2.has(com.umeng.commonsdk.statistics.b.a("device_model"))) {
                    jSONObject3.put("device_model", jSONObject2.getString(com.umeng.commonsdk.statistics.b.a("device_model")));
                }
                if (jSONObject2.has(com.umeng.commonsdk.statistics.b.a("version_code"))) {
                    jSONObject3.put("version", jSONObject2.getInt(com.umeng.commonsdk.statistics.b.a("version_code")));
                }
                if (jSONObject2.has(com.umeng.commonsdk.statistics.b.a("appkey"))) {
                    jSONObject3.put("appkey", jSONObject2.getString(com.umeng.commonsdk.statistics.b.a("appkey")));
                }
                if (jSONObject2.has(com.umeng.commonsdk.statistics.b.a("channel"))) {
                    jSONObject3.put("channel", jSONObject2.getString(com.umeng.commonsdk.statistics.b.a("channel")));
                }
                if (jSONObject3.length() > 0) {
                    MLog.d("本次启动基础信息:" + jSONObject3.toString());
                    jSONObject3 = new JSONObject();
                }
            }
            jSONObject3.length();
        } catch (Throwable th) {
            MLog.e(th);
        }
    }

    public void a(Object obj, int i10) {
        if (com.umeng.commonsdk.utils.c.a()) {
            if (i10 != 4357) {
                return;
            }
            try {
                UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> clean db in silent mode.");
                j.a(f10495a);
                com.umeng.commonsdk.utils.c.c(f10495a);
            } catch (Throwable unused) {
            }
        }
        if (AnalyticsConfig.enable) {
            try {
                if (i10 != 4358) {
                    switch (i10) {
                        case a.f10521a /* 4097 */:
                            if (UMUtils.isMainProgress(f10495a)) {
                                if (obj != null) {
                                    e(obj);
                                }
                                if (f10503t.equals(((JSONObject) obj).optString("__i"))) {
                                    return;
                                }
                                a(false);
                                return;
                            }
                            UMProcessDBHelper.getInstance(f10495a).insertEventsInSubProcess(UMFrUtils.getSubProcessName(f10495a), new JSONArray().put(obj));
                            return;
                        case a.f10522b /* 4098 */:
                            if (obj != null) {
                                e(obj);
                            }
                            if (f10503t.equals(((JSONObject) obj).optString("__i"))) {
                                return;
                            }
                            a(false);
                            return;
                        case a.f10523c /* 4099 */:
                            x.a(f10495a);
                            return;
                        case a.f10524d /* 4100 */:
                            n.c(f10495a);
                            return;
                        case a.f10525e /* 4101 */:
                            UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> PROFILE_SIGNIN");
                            a((Object) null, true);
                            g(obj);
                            return;
                        case a.f10526f /* 4102 */:
                            UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> PROFILE_SIGNOFF");
                            a((Object) null, true);
                            f(obj);
                            return;
                        case a.f10527g /* 4103 */:
                            UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> START_SESSION");
                            w.a().a(f10495a, obj);
                            synchronized (this.f10520w) {
                                this.f10519v = true;
                            }
                            return;
                        case a.f10528h /* 4104 */:
                            w.a().c(f10495a, obj);
                            return;
                        case a.f10529i /* 4105 */:
                            d();
                            return;
                        case a.f10530j /* 4106 */:
                            h(obj);
                            return;
                        default:
                            switch (i10) {
                                case 4352:
                                    UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> INSTANT_SESSION_START");
                                    w.a().b(f10495a, obj);
                                    synchronized (this.f10520w) {
                                        this.f10518u = true;
                                    }
                                    return;
                                case a.f10532l /* 4353 */:
                                    a(obj, true);
                                    return;
                                case a.f10533m /* 4354 */:
                                    c();
                                    return;
                                case a.f10534n /* 4355 */:
                                    if (!UMUtils.isMainProgress(f10495a)) {
                                        UMProcessDBHelper.getInstance(f10495a).insertEventsInSubProcess(UMFrUtils.getSubProcessName(f10495a), new JSONArray().put(obj));
                                        return;
                                    } else {
                                        if (obj != null) {
                                            e(obj);
                                            d();
                                            return;
                                        }
                                        return;
                                    }
                                case a.f10535o /* 4356 */:
                                    if (obj == null || f10505y == null || f10506z == null) {
                                        return;
                                    }
                                    UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> PROFILE_CHANGE_NOTIFY");
                                    String str = "";
                                    String str2 = "";
                                    if (obj instanceof JSONObject) {
                                        JSONObject jSONObject = (JSONObject) obj;
                                        if (jSONObject.has(ParamsMap.DeviceParams.KEY_UID) && jSONObject.has(f.M)) {
                                            str = jSONObject.getString(f.M);
                                            str2 = jSONObject.getString(ParamsMap.DeviceParams.KEY_UID);
                                        }
                                        a(str2, str);
                                        return;
                                    }
                                    return;
                                default:
                                    switch (i10) {
                                        case a.f10540t /* 8195 */:
                                            com.umeng.analytics.b.a().a(obj);
                                            return;
                                        case a.f10541u /* 8196 */:
                                            com.umeng.analytics.b.a().m();
                                            return;
                                        case a.f10542v /* 8197 */:
                                            com.umeng.analytics.b.a().k();
                                            return;
                                        default:
                                            switch (i10) {
                                                case a.f10543w /* 8199 */:
                                                case a.f10544x /* 8200 */:
                                                    com.umeng.analytics.b.a().b(obj);
                                                    return;
                                                case a.f10545y /* 8201 */:
                                                    com.umeng.analytics.b.a().b((Object) null);
                                                    return;
                                                default:
                                                    switch (i10) {
                                                        case a.f10546z /* 8208 */:
                                                            UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> receive DELAY_BUILD_ENVELOPE event.");
                                                            Context context = f10495a;
                                                            UMWorkDispatch.sendEvent(context, a.A, CoreProtocol.getInstance(context), null);
                                                            Context context2 = f10495a;
                                                            UMWorkDispatch.sendEvent(context2, a.f10533m, CoreProtocol.getInstance(context2), null);
                                                            return;
                                                        case a.A /* 8209 */:
                                                            a(obj, false);
                                                            return;
                                                        case a.B /* 8210 */:
                                                            UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> recv BUILD_ENVELOPE_IMMEDIATELY.");
                                                            if (!UMUtils.isMainProgress(f10495a) || (this.f10507b.c() instanceof ReportPolicy.ReportQuasiRealtime)) {
                                                                return;
                                                            }
                                                            a(true);
                                                            return;
                                                        default:
                                                            switch (i10) {
                                                                case a.E /* 8213 */:
                                                                    if (FieldManager.allow(com.umeng.commonsdk.utils.d.E)) {
                                                                        if (DeviceConfig.getGlobleActivity(f10495a) != null) {
                                                                            w.b(f10495a);
                                                                        }
                                                                        Context context3 = f10495a;
                                                                        UMWorkDispatch.sendEventEx(context3, a.E, CoreProtocol.getInstance(context3), null, 5000L);
                                                                        return;
                                                                    }
                                                                    return;
                                                                case a.F /* 8214 */:
                                                                    if (obj != null && (obj instanceof JSONObject)) {
                                                                        String optString = ((JSONObject) obj).optString(AnalyticsConfig.RTD_START_TIME);
                                                                        String optString2 = ((JSONObject) obj).optString("period");
                                                                        String optString3 = ((JSONObject) obj).optString("debugkey");
                                                                        if (TextUtils.isEmpty(optString) || TextUtils.isEmpty(optString2) || TextUtils.isEmpty(optString3)) {
                                                                            return;
                                                                        }
                                                                        Context context4 = f10495a;
                                                                        String str3 = AnalyticsConfig.RTD_SP_FILE;
                                                                        com.umeng.common.b.a(context4, str3, AnalyticsConfig.RTD_START_TIME, optString);
                                                                        com.umeng.common.b.a(f10495a, str3, "period", optString2);
                                                                        com.umeng.common.b.a(f10495a, str3, "debugkey", optString3);
                                                                        return;
                                                                    }
                                                                    return;
                                                                case a.G /* 8215 */:
                                                                    com.umeng.common.b.a(f10495a, AnalyticsConfig.RTD_SP_FILE);
                                                                    return;
                                                                default:
                                                                    return;
                                                            }
                                                    }
                                            }
                                    }
                            }
                    }
                }
                if (obj != null && (obj instanceof JSONObject)) {
                    String optString4 = ((JSONObject) obj).optString(f.S);
                    Object opt = ((JSONObject) obj).opt(f.T);
                    if (TextUtils.isEmpty(optString4)) {
                        return;
                    }
                    String[] a10 = com.umeng.analytics.c.a(f10495a);
                    if (a10 != null && !TextUtils.isEmpty(a10[0]) && !TextUtils.isEmpty(a10[1])) {
                        if (f.O.equals(optString4)) {
                            com.umeng.analytics.c.a((String) opt);
                            return;
                        } else if (f.P.equals(optString4)) {
                            com.umeng.analytics.c.b((String) opt);
                            return;
                        } else {
                            com.umeng.analytics.c.a(optString4, opt);
                            return;
                        }
                    }
                    MLog.e("Please call MobclickAgent.onProfileSignIn() function before set user profile property.");
                }
            } catch (Throwable unused2) {
            }
        }
    }

    private void g(Object obj) {
        try {
            b(f10495a);
            d();
            JSONObject jSONObject = (JSONObject) obj;
            if (jSONObject != null && jSONObject.length() > 0) {
                String string = jSONObject.getString(f.M);
                String string2 = jSONObject.getString(ParamsMap.DeviceParams.KEY_UID);
                long j10 = jSONObject.getLong("ts");
                String[] a10 = com.umeng.analytics.c.a(f10495a);
                if (a10 != null && string.equals(a10[0]) && string2.equals(a10[1])) {
                    return;
                }
                w.a().a(f10495a, j10);
                String c10 = aa.a().c(f10495a);
                boolean b10 = w.a().b(f10495a, j10, false);
                com.umeng.analytics.c.a(f10495a, string, string2);
                UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> onProfileSignIn: force generate new session: session id = " + c10);
                w.a().a(f10495a, j10, true);
                if (b10) {
                    w.a().b(f10495a, j10);
                }
            }
        } catch (Throwable unused) {
        }
    }

    public long f() {
        SharedPreferences sharedPreferences;
        long j10 = 0;
        try {
            Context context = f10495a;
            if (context == null || (sharedPreferences = PreferenceWrapper.getDefault(context)) == null) {
                return 0L;
            }
            long j11 = sharedPreferences.getLong(f10496l, 0L);
            if (j11 == 0) {
                try {
                    j10 = System.currentTimeMillis();
                    sharedPreferences.edit().putLong(f10496l, j10).commit();
                    return j10;
                } catch (Throwable unused) {
                }
            }
            return j11;
        } catch (Throwable unused2) {
            return j10;
        }
    }

    public void c(Object obj) {
        b(f10495a);
        d();
        if (d(false)) {
            j();
        }
    }

    private void f(Object obj) {
        try {
            JSONObject jSONObject = (JSONObject) obj;
            if (jSONObject != null && jSONObject.length() > 0) {
                long j10 = jSONObject.getLong("ts");
                b(f10495a);
                d();
                String[] a10 = com.umeng.analytics.c.a(f10495a);
                if (a10 == null || TextUtils.isEmpty(a10[0]) || TextUtils.isEmpty(a10[1])) {
                    return;
                }
                w.a().a(f10495a, j10);
                UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> onProfileSignIn: force generate new session: session id = " + aa.a().c(f10495a));
                boolean b10 = w.a().b(f10495a, j10, false);
                com.umeng.analytics.c.b(f10495a);
                w.a().a(f10495a, j10, true);
                if (b10) {
                    w.a().b(f10495a, j10);
                }
            }
        } catch (Throwable th) {
            if (MLog.DEBUG) {
                MLog.e(" Excepthon  in  onProfileSignOff", th);
            }
        }
    }

    private JSONObject b(JSONObject jSONObject, long j10) {
        try {
            if (s.a(jSONObject) <= j10) {
                return jSONObject;
            }
            jSONObject = null;
            k.a(f10495a).a(true, false);
            k.a(f10495a).b();
            UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> Instant session packet overload !!! ");
            return null;
        } catch (Throwable unused) {
            return jSONObject;
        }
    }

    public JSONObject b(boolean z10) {
        JSONArray jSONArray;
        JSONArray jSONArray2;
        JSONObject jSONObject = null;
        try {
            jSONObject = k.a(f10495a).a(z10);
            if (jSONObject == null) {
                jSONObject = new JSONObject();
            } else {
                try {
                    boolean has = jSONObject.has(f.f10332n);
                    jSONObject = jSONObject;
                    if (has) {
                        JSONArray jSONArray3 = jSONObject.getJSONArray(f.f10332n);
                        JSONArray jSONArray4 = new JSONArray();
                        int i10 = 0;
                        while (i10 < jSONArray3.length()) {
                            JSONObject jSONObject2 = (JSONObject) jSONArray3.get(i10);
                            JSONArray optJSONArray = jSONObject2.optJSONArray(f.f10338t);
                            JSONArray optJSONArray2 = jSONObject2.optJSONArray(f.f10339u);
                            if (optJSONArray == null && optJSONArray2 != null) {
                                jSONObject2.put(f.f10338t, optJSONArray2);
                                jSONObject2.remove(f.f10339u);
                            }
                            if (optJSONArray != null && optJSONArray2 != null) {
                                ArrayList arrayList = new ArrayList();
                                for (int i11 = 0; i11 < optJSONArray.length(); i11++) {
                                    arrayList.add((JSONObject) optJSONArray.get(i11));
                                }
                                for (int i12 = 0; i12 < optJSONArray2.length(); i12++) {
                                    arrayList.add((JSONObject) optJSONArray2.get(i12));
                                }
                                JSONArraySortUtil jSONArraySortUtil = new JSONArraySortUtil();
                                jSONArraySortUtil.setCompareKey(f.f10342x);
                                Collections.sort(arrayList, jSONArraySortUtil);
                                JSONArray jSONArray5 = new JSONArray();
                                Iterator it = arrayList.iterator();
                                while (it.hasNext()) {
                                    jSONArray5.put((JSONObject) it.next());
                                }
                                jSONObject2.put(f.f10338t, jSONArray5);
                                jSONObject2.remove(f.f10339u);
                            }
                            if (jSONObject2.has(f.f10338t)) {
                                JSONArray optJSONArray3 = jSONObject2.optJSONArray(f.f10338t);
                                int i13 = 0;
                                while (i13 < optJSONArray3.length()) {
                                    JSONObject jSONObject3 = optJSONArray3.getJSONObject(i13);
                                    if (jSONObject3.has(f.f10342x)) {
                                        jSONArray2 = jSONArray3;
                                        jSONObject3.put("ts", jSONObject3.getLong(f.f10342x));
                                        jSONObject3.remove(f.f10342x);
                                    } else {
                                        jSONArray2 = jSONArray3;
                                    }
                                    i13++;
                                    jSONArray3 = jSONArray2;
                                }
                                jSONArray = jSONArray3;
                                jSONObject2.put(f.f10338t, optJSONArray3);
                                jSONObject2.put(f.f10344z, optJSONArray3.length());
                            } else {
                                jSONArray = jSONArray3;
                                jSONObject2.put(f.f10344z, 0);
                            }
                            jSONArray4.put(jSONObject2);
                            i10++;
                            jSONArray3 = jSONArray;
                        }
                        jSONObject.put(f.f10332n, jSONArray4);
                        jSONObject = jSONObject;
                    }
                } catch (Exception e10) {
                    MLog.e("merge pages error");
                    e10.printStackTrace();
                    jSONObject = jSONObject;
                }
            }
            SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(f10495a);
            if (sharedPreferences != null) {
                String string = sharedPreferences.getString("userlevel", "");
                if (!TextUtils.isEmpty(string)) {
                    jSONObject.put("userlevel", string);
                }
            }
            String[] a10 = com.umeng.analytics.c.a(f10495a);
            if (a10 != null && !TextUtils.isEmpty(a10[0]) && !TextUtils.isEmpty(a10[1])) {
                JSONObject jSONObject4 = new JSONObject();
                jSONObject4.put(f.M, a10[0]);
                jSONObject4.put(f.N, a10[1]);
                if (jSONObject4.length() > 0) {
                    JSONObject jSONObject5 = new JSONObject();
                    String a11 = com.umeng.analytics.c.a();
                    if (a11 != null) {
                        jSONObject5.put(f.O, a11);
                    }
                    String b10 = com.umeng.analytics.c.b();
                    if (b10 != null) {
                        jSONObject5.put(f.P, b10);
                    }
                    Map<String, Object> c10 = com.umeng.analytics.c.c(f10495a);
                    if (c10 != null && c10.size() > 0) {
                        for (String str : c10.keySet()) {
                            jSONObject5.put(str, c10.get(str));
                        }
                    }
                    if (jSONObject5.length() > 0) {
                        jSONObject4.put(f.R, jSONObject5);
                    }
                    jSONObject.put(f.L, jSONObject4);
                }
            }
            if (ABTest.getService(f10495a).isInTest()) {
                JSONObject jSONObject6 = new JSONObject();
                jSONObject6.put(ABTest.getService(f10495a).getTestName(), ABTest.getService(f10495a).getGroupInfo());
                jSONObject.put(f.K, jSONObject6);
            }
            t.a().a(jSONObject, f10495a);
        } catch (Throwable unused) {
        }
        return jSONObject;
    }

    public void e() {
        if (d(false)) {
            j();
        }
    }

    public void d(Object obj) {
        r();
        m();
        n();
        a(true);
    }

    private boolean d(boolean z10) {
        if (this.f10507b == null) {
            this.f10507b = new c();
        }
        ReportPolicy.ReportStrategy c10 = this.f10507b.c();
        if (!(c10 instanceof ReportPolicy.DefconPolicy)) {
            return true;
        }
        if (z10) {
            return ((ReportPolicy.DefconPolicy) c10).shouldSendMessageByInstant();
        }
        return c10.shouldSendMessage(false);
    }

    public void b(Object obj) {
        if (obj != null) {
            try {
                JSONObject jSONObject = (JSONObject) obj;
                if (jSONObject.length() > 0) {
                    if (jSONObject.has("exception")) {
                        if (101 != jSONObject.getInt("exception")) {
                            f(jSONObject);
                        }
                    } else {
                        f(jSONObject);
                    }
                }
            } catch (Throwable unused) {
            }
        }
    }

    public void b(Context context) {
        try {
            k.a(context).d();
            q();
        } catch (Throwable unused) {
        }
    }

    public void a(boolean z10) {
        if (c(z10)) {
            if (!(this.f10507b.c() instanceof ReportPolicy.ReportQuasiRealtime)) {
                if (UMEnvelopeBuild.isReadyBuild(f10495a, UMLogDataProtocol.UMBusinessType.U_APP)) {
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> constructMessage()");
                    j();
                    return;
                }
                return;
            }
            if (z10) {
                if (UMEnvelopeBuild.isOnline(f10495a)) {
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> send session start in policy ReportQuasiRealtime.");
                    j();
                    return;
                }
                return;
            }
            if (UMEnvelopeBuild.isReadyBuild(f10495a, UMLogDataProtocol.UMBusinessType.U_APP)) {
                UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> send normal data in policy ReportQuasiRealtime.");
                j();
            }
        }
    }

    private boolean a(JSONArray jSONArray) {
        int length = jSONArray.length();
        List asList = Arrays.asList("$$_onUMengEnterForeground", "$$_onUMengEnterBackground", "$$_onUMengEnterForegroundInitError");
        int i10 = 0;
        for (int i11 = 0; i11 < length; i11++) {
            try {
                JSONObject optJSONObject = jSONArray.optJSONObject(i11);
                if (optJSONObject != null && asList.contains(optJSONObject.optString("id"))) {
                    i10++;
                }
            } catch (Throwable unused) {
            }
        }
        return i10 >= length;
    }

    private boolean a(JSONObject jSONObject) {
        JSONArray optJSONArray = jSONObject.optJSONArray("ekv");
        int length = optJSONArray.length();
        int i10 = 0;
        for (int i11 = 0; i11 < length; i11++) {
            try {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i11);
                Iterator<String> keys = optJSONObject.keys();
                while (keys.hasNext()) {
                    JSONArray optJSONArray2 = optJSONObject.optJSONArray(keys.next());
                    if (optJSONArray2 != null && a(optJSONArray2)) {
                        i10++;
                    }
                }
            } catch (Throwable unused) {
            }
        }
        return i10 >= length;
    }

    public JSONObject a(long j10) {
        if (TextUtils.isEmpty(aa.a().d(f10495a))) {
            return null;
        }
        JSONObject b10 = b(false);
        int a10 = t.a().a(f10495a);
        if (b10.length() > 0) {
            if (b10.length() == 1) {
                if (b10.optJSONObject(f.L) != null && a10 != 3) {
                    return null;
                }
                if (!TextUtils.isEmpty(b10.optString("userlevel")) && a10 != 3) {
                    return null;
                }
            } else if (b10.length() == 2 && b10.optJSONObject(f.L) != null && !TextUtils.isEmpty(b10.optString("userlevel")) && a10 != 3) {
                return null;
            }
            String optString = b10.optString(f.f10332n);
            String optString2 = b10.optString(f.Z);
            String optString3 = b10.optString("ekv");
            if (TextUtils.isEmpty(optString) && TextUtils.isEmpty(optString2) && !TextUtils.isEmpty(optString3) && a(b10)) {
                return null;
            }
        } else if (a10 != 3) {
            return null;
        }
        JSONObject l10 = l();
        if (l10 != null) {
            c(l10);
        }
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            if (a10 == 3) {
                jSONObject2.put("analytics", new JSONObject());
            } else if (b10.length() > 0) {
                jSONObject2.put("analytics", b10);
            }
            if (l10 != null && l10.length() > 0) {
                jSONObject.put("header", l10);
            }
            if (jSONObject2.length() > 0) {
                jSONObject.put("content", jSONObject2);
            }
            return a(jSONObject, j10);
        } catch (Throwable unused) {
            return jSONObject;
        }
    }

    private JSONObject a(JSONObject jSONObject, long j10) {
        try {
            if (s.a(jSONObject) <= j10) {
                return jSONObject;
            }
            JSONObject jSONObject2 = jSONObject.getJSONObject("header");
            jSONObject2.put(f.aH, s.a(jSONObject));
            jSONObject.put("header", jSONObject2);
            return s.a(f10495a, j10, jSONObject);
        } catch (Throwable unused) {
            return jSONObject;
        }
    }

    private boolean a(long j10, int i10) {
        if (j10 == 0) {
            return true;
        }
        if (System.currentTimeMillis() - j10 <= 28800000) {
            return i10 < 5000;
        }
        o();
        return true;
    }

    public void a(Object obj) {
        if (obj != null) {
            try {
                JSONObject jSONObject = (JSONObject) obj;
                if (jSONObject.length() > 0) {
                    if (jSONObject.has("exception")) {
                        if (101 != jSONObject.getInt("exception")) {
                            g(jSONObject);
                        }
                    } else {
                        g(jSONObject);
                    }
                }
            } catch (Throwable unused) {
            }
        }
    }

    public void a(Object obj, boolean z10) {
        if (z10) {
            if (d(true)) {
                i();
            }
        } else if (UMEnvelopeBuild.isOnline(f10495a) && d(true)) {
            i();
        }
    }
}
