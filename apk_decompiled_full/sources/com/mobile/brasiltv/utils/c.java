package com.mobile.brasiltv.utils;

import android.content.Context;
import android.content.SharedPreferences;
import com.hpplay.cybergarage.xml.XML;
import com.mobile.brasiltv.bean.MemberInfo;

/* loaded from: classes.dex */
public final class c {

    /* renamed from: s, reason: collision with root package name */
    public static final /* synthetic */ z9.g[] f8621s = {t9.x.c(new t9.l(c.class, "isFirstInstall", "isFirstInstall()Z", 0)), t9.x.c(new t9.l(c.class, "currentVerCode", "getCurrentVerCode()Ljava/lang/String;", 0)), t9.x.c(new t9.l(c.class, "upgradeVerCode", "getUpgradeVerCode()Ljava/lang/String;", 0)), t9.x.c(new t9.l(c.class, "userInfoUserName", "getUserInfoUserName()Ljava/lang/String;", 0)), t9.x.c(new t9.l(c.class, "userInfoPwd", "getUserInfoPwd()Ljava/lang/String;", 0)), t9.x.c(new t9.l(c.class, "portalCode", "getPortalCode()Ljava/lang/String;", 0)), t9.x.c(new t9.l(c.class, "appLang", "getAppLang()Ljava/lang/String;", 0)), t9.x.c(new t9.l(c.class, "lastAppModel", "getLastAppModel()Ljava/lang/String;", 0)), t9.x.c(new t9.l(c.class, "lastUserIdentity", "getLastUserIdentity()Ljava/lang/String;", 0)), t9.x.c(new t9.l(c.class, "lastNotNeedCalendar", "getLastNotNeedCalendar()J", 0)), t9.x.c(new t9.l(c.class, "appImportantAd", "getAppImportantAd()Ljava/lang/String;", 0)), t9.x.c(new t9.l(c.class, "appImportantAdLastTime", "getAppImportantAdLastTime()J", 0)), t9.x.c(new t9.l(c.class, "appScreenAdv", "getAppScreenAdv()Ljava/lang/String;", 0)), t9.x.c(new t9.l(c.class, "protalAUrl", "getProtalAUrl()Ljava/lang/String;", 0)), t9.x.c(new t9.l(c.class, "protalBUrl", "getProtalBUrl()Ljava/lang/String;", 0))};

    /* renamed from: a, reason: collision with root package name */
    public final Context f8622a;

    /* renamed from: b, reason: collision with root package name */
    public final String f8623b;

    /* renamed from: c, reason: collision with root package name */
    public final h9.g f8624c;

    /* renamed from: d, reason: collision with root package name */
    public final v9.a f8625d;

    /* renamed from: e, reason: collision with root package name */
    public final v9.a f8626e;

    /* renamed from: f, reason: collision with root package name */
    public final v9.a f8627f;

    /* renamed from: g, reason: collision with root package name */
    public final v9.a f8628g;

    /* renamed from: h, reason: collision with root package name */
    public final v9.a f8629h;

    /* renamed from: i, reason: collision with root package name */
    public final v9.a f8630i;

    /* renamed from: j, reason: collision with root package name */
    public final v9.a f8631j;

    /* renamed from: k, reason: collision with root package name */
    public final v9.a f8632k;

    /* renamed from: l, reason: collision with root package name */
    public final v9.a f8633l;

    /* renamed from: m, reason: collision with root package name */
    public final v9.a f8634m;

    /* renamed from: n, reason: collision with root package name */
    public final v9.a f8635n;

    /* renamed from: o, reason: collision with root package name */
    public final v9.a f8636o;

    /* renamed from: p, reason: collision with root package name */
    public final v9.a f8637p;

    /* renamed from: q, reason: collision with root package name */
    public final v9.a f8638q;

    /* renamed from: r, reason: collision with root package name */
    public final v9.a f8639r;

    /* loaded from: classes3.dex */
    public static final class a extends t9.j implements s9.a {
        public a() {
            super(0);
        }

        @Override // s9.a
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final SharedPreferences invoke() {
            return c.this.f8622a.getSharedPreferences(c.this.f8623b, 0);
        }
    }

    public c(Context context) {
        t9.i.g(context, com.umeng.analytics.pro.f.X);
        this.f8622a = context;
        this.f8623b = "share_data";
        this.f8624c = h9.h.b(new a());
        m0 m0Var = m0.f8732a;
        this.f8625d = m0Var.a("first_install", true);
        this.f8626e = m0Var.d("current_version_code", "0");
        this.f8627f = m0Var.d("upgrade_version_code", "0");
        MemberInfo.Config config = MemberInfo.Config.INSTANCE;
        this.f8628g = m0.e(m0Var, config.getSHARED_USERNAME(), null, 2, null);
        this.f8629h = m0.e(m0Var, config.getSHARED_PWD(), null, 2, null);
        this.f8630i = m0Var.d("portalCode", "koocanmobile2");
        this.f8631j = m0Var.d("appLang", XML.DEFAULT_CONTENT_LANGUAGE);
        this.f8632k = m0Var.d("app_model", "");
        this.f8633l = m0Var.d("userIdentity", "");
        this.f8634m = m0Var.b("not_need_calendar", System.currentTimeMillis() - 604800000);
        this.f8635n = m0.e(m0Var, "appImportantAd", null, 2, null);
        this.f8636o = m0.c(m0Var, "appImportantAdLastTime", 0L, 2, null);
        this.f8637p = m0.e(m0Var, "appScreenAdv", null, 2, null);
        this.f8638q = m0.e(m0Var, "protalAUrl", null, 2, null);
        this.f8639r = m0.e(m0Var, "protalBUrl", null, 2, null);
    }

    public final String c() {
        return (String) this.f8631j.b(this, f8621s[6]);
    }

    public final String d() {
        return (String) this.f8626e.b(this, f8621s[1]);
    }

    public final SharedPreferences e() {
        Object value = this.f8624c.getValue();
        t9.i.f(value, "<get-preferences>(...)");
        return (SharedPreferences) value;
    }

    public final String f() {
        return (String) this.f8629h.b(this, f8621s[4]);
    }

    public final String g() {
        return (String) this.f8628g.b(this, f8621s[3]);
    }

    public final boolean h() {
        return ((Boolean) this.f8625d.b(this, f8621s[0])).booleanValue();
    }

    public final void i(String str) {
        t9.i.g(str, "<set-?>");
        this.f8635n.a(this, f8621s[10], str);
    }

    public final void j(long j10) {
        this.f8636o.a(this, f8621s[11], Long.valueOf(j10));
    }

    public final void k(String str) {
        t9.i.g(str, "<set-?>");
        this.f8631j.a(this, f8621s[6], str);
    }

    public final void l(String str) {
        t9.i.g(str, "<set-?>");
        this.f8637p.a(this, f8621s[12], str);
    }

    public final void m(String str) {
        t9.i.g(str, "<set-?>");
        this.f8626e.a(this, f8621s[1], str);
    }

    public final void n(boolean z10) {
        this.f8625d.a(this, f8621s[0], Boolean.valueOf(z10));
    }

    public final void o(long j10) {
        this.f8634m.a(this, f8621s[9], Long.valueOf(j10));
    }

    public final void p(String str) {
        t9.i.g(str, "<set-?>");
        this.f8627f.a(this, f8621s[2], str);
    }

    public final void q(String str) {
        t9.i.g(str, "<set-?>");
        this.f8629h.a(this, f8621s[4], str);
    }

    public final void r(String str) {
        t9.i.g(str, "<set-?>");
        this.f8628g.a(this, f8621s[3], str);
    }
}
