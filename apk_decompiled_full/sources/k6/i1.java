package k6;

import com.google.android.gms.common.Scopes;
import com.msandroid.mobile.R;
import io.reactivex.disposables.Disposable;
import mobile.com.requestframe.utils.bean.BindEmailV2Bean;
import mobile.com.requestframe.utils.bean.CheckVerifyCodeBean;
import mobile.com.requestframe.utils.bean.EmailVerifyCodeBean;
import mobile.com.requestframe.utils.response.AreaCodeData;
import mobile.com.requestframe.utils.response.AreaCodeResult;
import mobile.com.requestframe.utils.response.BaseResult;
import mobile.com.requestframe.utils.response.GetEmailSuffix;
import mobile.com.requestframe.utils.response.GetEmailSuffixResult;
import w6.i;

/* loaded from: classes3.dex */
public final class i1 implements l5.a {

    /* renamed from: a, reason: collision with root package name */
    public final f5.c f15289a;

    /* renamed from: b, reason: collision with root package name */
    public i6.c0 f15290b;

    public static final class a extends ha.a {

        /* renamed from: k6.i1$a$a, reason: collision with other inner class name */
        public static final class C0253a extends t9.j implements s9.l {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ String f15292a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0253a(String str) {
                super(1);
                this.f15292a = str;
            }

            @Override // s9.l
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((String) obj);
                return h9.t.f14242a;
            }

            public final void invoke(String str) {
                com.mobile.brasiltv.utils.f1.f8649a.x(com.mobile.brasiltv.utils.y.p(com.mobile.brasiltv.utils.y.f8771a, this.f15292a, null, null, 6, null));
            }
        }

        public a() {
        }

        @Override // ha.a, io.reactivex.Observer
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void onNext(AreaCodeResult areaCodeResult) {
            String str;
            t9.i.g(areaCodeResult, "t");
            AreaCodeData data = areaCodeResult.getData();
            if (data == null || (str = data.getAreaCode()) == null) {
                str = "";
            }
            i6.c0 n10 = i1.this.n();
            String a10 = com.mobile.brasiltv.utils.h0.a(i1.this.l(), str);
            t9.i.f(a10, "getCountryByCode(context, areaCode)");
            n10.v(str, a10);
        }

        @Override // ha.a
        public void showErrorHint(String str) {
            t9.i.g(str, "returnCode");
            com.mobile.brasiltv.utils.x.f8754a.w(i1.this.l(), new C0253a(str));
        }
    }

    public static final class b extends ha.a {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f15294b;

        public static final class a extends t9.j implements s9.l {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ String f15295a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(String str) {
                super(1);
                this.f15295a = str;
            }

            @Override // s9.l
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((String) obj);
                return h9.t.f14242a;
            }

            public final void invoke(String str) {
                com.mobile.brasiltv.utils.f1.f8649a.x(com.mobile.brasiltv.utils.y.f8771a.d(this.f15295a));
            }
        }

        public b(String str) {
            this.f15294b = str;
        }

        @Override // ha.a
        public void showErrorHint(String str) {
            t9.i.g(str, "returnCode");
            i1.this.n().showLoading(false);
            if (com.mobile.brasiltv.utils.b0.T(str, "portal100072") || com.mobile.brasiltv.utils.b0.T(str, "portal100073")) {
                i1.this.n().d(R.string.verification_invalid);
            } else {
                com.mobile.brasiltv.utils.x.f8754a.w(i1.this.l(), new a(com.mobile.brasiltv.utils.y.f8771a.c(str)));
            }
        }

        @Override // ha.a, io.reactivex.Observer
        public void onNext(BaseResult baseResult) {
            t9.i.g(baseResult, "t");
            i1.this.n().showLoading(false);
            i.c cVar = w6.i.f19214g;
            cVar.T("1");
            cVar.b0(this.f15294b);
            i1.this.n().B();
            if (d6.b.f12660a.r()) {
                com.mobile.brasiltv.utils.n0.f8733a.j(i1.this.l(), "first_bind_email", this.f15294b);
            }
        }
    }

    public static final class c extends ha.a {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f15297b;

        public static final class a extends t9.j implements s9.l {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ String f15298a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(String str) {
                super(1);
                this.f15298a = str;
            }

            @Override // s9.l
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((String) obj);
                return h9.t.f14242a;
            }

            public final void invoke(String str) {
                com.mobile.brasiltv.utils.f1.f8649a.x(com.mobile.brasiltv.utils.y.f8771a.d(this.f15298a));
            }
        }

        public c(String str) {
            this.f15297b = str;
        }

        @Override // ha.a, io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            t9.i.g(disposable, "d");
            super.onSubscribe(disposable);
            i1.this.n().showLoading(true);
        }

        @Override // ha.a
        public void showErrorHint(String str) {
            t9.i.g(str, "returnCode");
            i1.this.n().showLoading(false);
            if (com.mobile.brasiltv.utils.b0.T(str, "portal100072") || com.mobile.brasiltv.utils.b0.T(str, "portal100073")) {
                i1.this.n().d(R.string.verification_invalid);
            } else {
                com.mobile.brasiltv.utils.x.f8754a.w(i1.this.l(), new a(com.mobile.brasiltv.utils.y.f8771a.c(str)));
            }
        }

        @Override // ha.a, io.reactivex.Observer
        public void onNext(BaseResult baseResult) {
            t9.i.g(baseResult, "t");
            if (d6.b.f12660a.a()) {
                i1.this.j(this.f15297b);
            } else {
                i1.this.n().showLoading(false);
                i1.this.n().K();
            }
        }
    }

    public static final class d extends ha.a {
        public d() {
        }

        @Override // ha.a
        public void showErrorHint(String str) {
            t9.i.g(str, "returnCode");
        }

        @Override // ha.a, io.reactivex.Observer
        public void onNext(GetEmailSuffixResult getEmailSuffixResult) {
            t9.i.g(getEmailSuffixResult, "t");
            super.onNext((Object) getEmailSuffixResult);
            GetEmailSuffix data = getEmailSuffixResult.getData();
            if (com.mobile.brasiltv.utils.b0.K(data != null ? data.getEmailSuffixStr() : null)) {
                GetEmailSuffix data2 = getEmailSuffixResult.getData();
                t9.i.d(data2);
                String emailSuffixStr = data2.getEmailSuffixStr();
                t9.i.d(emailSuffixStr);
                i1.this.n().e(ba.t.M(emailSuffixStr, new String[]{","}, false, 0, 6, null));
            }
        }
    }

    public static final class e extends ha.a {

        public static final class a extends t9.j implements s9.l {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ String f15301a;

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ String f15302b;

            /* renamed from: c, reason: collision with root package name */
            public final /* synthetic */ i1 f15303c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(String str, String str2, i1 i1Var) {
                super(1);
                this.f15301a = str;
                this.f15302b = str2;
                this.f15303c = i1Var;
            }

            @Override // s9.l
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((String) obj);
                return h9.t.f14242a;
            }

            public final void invoke(String str) {
                String d10 = com.mobile.brasiltv.utils.y.f8771a.d(this.f15301a);
                if (t9.i.b(this.f15301a, "no_report_type")) {
                    if (t9.i.b(this.f15302b, "portal100060")) {
                        d10 = this.f15303c.l().getResources().getString(R.string.frequent_operation);
                        t9.i.f(d10, "context.resources.getStr…tring.frequent_operation)");
                    } else if (t9.i.b(this.f15302b, "portal400001")) {
                        d10 = this.f15303c.l().getResources().getString(R.string.account_not_suport_email);
                        t9.i.f(d10, "context.resources.getStr…account_not_suport_email)");
                    }
                }
                com.mobile.brasiltv.utils.f1.f8649a.x(d10);
            }
        }

        public e() {
        }

        @Override // ha.a, io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            t9.i.g(disposable, "d");
            super.onSubscribe(disposable);
            i1.this.n().showLoading(true);
        }

        @Override // ha.a
        public void showErrorHint(String str) {
            t9.i.g(str, "returnCode");
            i1.this.n().showLoading(false);
            com.mobile.brasiltv.utils.x.f8754a.w(i1.this.l(), new a(com.mobile.brasiltv.utils.y.f8771a.c(str), str, i1.this));
        }

        @Override // ha.a, io.reactivex.Observer
        public void onNext(BaseResult baseResult) {
            t9.i.g(baseResult, "t");
            i1.this.n().showLoading(false);
            i1.this.n().i();
        }
    }

    public i1(f5.c cVar, i6.c0 c0Var) {
        t9.i.g(cVar, com.umeng.analytics.pro.f.X);
        t9.i.g(c0Var, "view");
        this.f15289a = cVar;
        this.f15290b = c0Var;
    }

    @Override // l5.a
    public void e() {
        m();
    }

    @Override // l5.a
    public void g() {
    }

    public void i() {
        w6.i.f19214g.b().O0().compose(this.f15289a.O1()).subscribe(new a());
    }

    public final void j(String str) {
        i.c cVar = w6.i.f19214g;
        cVar.b().Q0(new BindEmailV2Bean(str, "1", "", cVar.J(), cVar.H())).compose(this.f15289a.O1()).subscribe(new b(str));
    }

    public void k(String str, String str2) {
        t9.i.g(str, Scopes.EMAIL);
        t9.i.g(str2, "verifyCode");
        if (!com.mobile.brasiltv.utils.j1.i(str)) {
            this.f15290b.d(R.string.email_incorrect);
        } else {
            i.c cVar = w6.i.f19214g;
            cVar.b().T0(new CheckVerifyCodeBean(str, "1", str2, cVar.J(), cVar.H())).compose(this.f15289a.O1()).subscribe(new c(str));
        }
    }

    public final f5.c l() {
        return this.f15289a;
    }

    public final void m() {
        w6.i.f19214g.b().q1().compose(this.f15289a.O1()).subscribe(new d());
    }

    public final i6.c0 n() {
        return this.f15290b;
    }

    public void o(String str) {
        t9.i.g(str, Scopes.EMAIL);
        if (!com.mobile.brasiltv.utils.j1.i(str)) {
            this.f15290b.d(R.string.email_incorrect);
        } else {
            i.c cVar = w6.i.f19214g;
            cVar.b().j2(new EmailVerifyCodeBean(str, "1", cVar.J(), cVar.H())).compose(this.f15289a.O1()).subscribe(new e());
        }
    }
}
