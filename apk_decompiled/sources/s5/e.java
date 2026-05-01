package s5;

import com.mobile.brasiltv.db.SwitchAccountBean;
import t9.i;

/* loaded from: classes3.dex */
public final class e {

    /* renamed from: b, reason: collision with root package name */
    public static boolean f18767b;

    /* renamed from: c, reason: collision with root package name */
    public static c f18768c;

    /* renamed from: e, reason: collision with root package name */
    public static SwitchAccountBean f18770e;

    /* renamed from: f, reason: collision with root package name */
    public static String f18771f;

    /* renamed from: h, reason: collision with root package name */
    public static x7.a f18773h;

    /* renamed from: k, reason: collision with root package name */
    public static String f18776k;

    /* renamed from: a, reason: collision with root package name */
    public static final e f18766a = new e();

    /* renamed from: d, reason: collision with root package name */
    public static String f18769d = "";

    /* renamed from: g, reason: collision with root package name */
    public static String f18772g = "";

    /* renamed from: i, reason: collision with root package name */
    public static String f18774i = "";

    /* renamed from: j, reason: collision with root package name */
    public static String f18775j = "";

    public final void a() {
        f18767b = false;
        f18768c = null;
        f18769d = "";
        f18770e = null;
        f18771f = null;
        f18772g = "";
        f18773h = null;
        f18774i = "";
        f18775j = "";
        f18776k = null;
    }

    public final String b() {
        return f18774i;
    }

    public final c c() {
        return f18768c;
    }

    public final boolean d() {
        return f18767b;
    }

    public final String e() {
        return f18769d;
    }

    public final x7.a f() {
        return f18773h;
    }

    public final SwitchAccountBean g() {
        return f18770e;
    }

    public final String h() {
        return f18772g;
    }

    public final String i() {
        return f18776k;
    }

    public final String j() {
        return f18775j;
    }

    public final String k() {
        return f18771f;
    }

    public final d l() {
        return new d(f18767b, f18768c, f18769d, f18770e, f18771f, f18772g, f18773h, f18774i, f18775j, f18776k);
    }

    public final void m(d dVar) {
        i.g(dVar, "tmpLoginBean");
        f18767b = dVar.c();
        f18768c = dVar.b();
        f18769d = dVar.d();
        f18770e = dVar.f();
        f18771f = dVar.j();
        f18772g = dVar.g();
        f18773h = dVar.e();
        f18774i = dVar.a();
        f18775j = dVar.i();
        f18776k = dVar.h();
    }

    public final void n(c cVar, SwitchAccountBean switchAccountBean, String str) {
        i.g(cVar, "loginType");
        i.g(switchAccountBean, "switchAccountBean");
        f18768c = cVar;
        f18770e = switchAccountBean;
        f18771f = str;
    }

    public final void o(c cVar, String str, x7.a aVar, String str2, String str3, String str4) {
        i.g(cVar, "loginType");
        i.g(str, "thirdPartType");
        i.g(aVar, "socialInfo");
        i.g(str2, "createType");
        i.g(str3, "tpSource");
        f18768c = cVar;
        f18772g = str;
        f18773h = aVar;
        f18774i = str2;
        f18775j = str3;
        f18776k = str4;
    }
}
