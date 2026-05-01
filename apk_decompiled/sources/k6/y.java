package k6;

import com.google.android.gms.common.Scopes;
import com.msandroid.mobile.R;
import io.reactivex.disposables.Disposable;
import mobile.com.requestframe.utils.bean.BindEmailV2Bean;
import mobile.com.requestframe.utils.bean.CheckVerifyCodeBean;
import mobile.com.requestframe.utils.bean.EmailVerifyCodeBean;
import mobile.com.requestframe.utils.response.BaseResult;
import mobile.com.requestframe.utils.response.GetEmailSuffix;
import mobile.com.requestframe.utils.response.GetEmailSuffixResult;
import w6.i;

/* loaded from: classes3.dex */
public final class y implements l5.a {

    /* renamed from: a, reason: collision with root package name */
    public final f5.c f15652a;

    /* renamed from: b, reason: collision with root package name */
    public final i6.n f15653b;

    public static final class a extends ha.a {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f15655b;

        /* renamed from: k6.y$a$a, reason: collision with other inner class name */
        public static final class C0264a extends t9.j implements s9.l {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ String f15656a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0264a(String str) {
                super(1);
                this.f15656a = str;
            }

            @Override // s9.l
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((String) obj);
                return h9.t.f14242a;
            }

            public final void invoke(String str) {
                com.mobile.brasiltv.utils.f1.f8649a.x(com.mobile.brasiltv.utils.y.f8771a.d(this.f15656a));
            }
        }

        public a(String str) {
            this.f15655b = str;
        }

        @Override // ha.a
        public void showErrorHint(String str) {
            t9.i.g(str, "returnCode");
            y.this.n().showLoading(false);
            if (com.mobile.brasiltv.utils.b0.T(str, "portal100072") || com.mobile.brasiltv.utils.b0.T(str, "portal100073")) {
                y.this.n().d(R.string.verification_invalid);
            } else {
                com.mobile.brasiltv.utils.x.f8754a.w(y.this.k(), new C0264a(com.mobile.brasiltv.utils.y.f8771a.c(str)));
            }
        }

        @Override // ha.a, io.reactivex.Observer
        public void onNext(BaseResult baseResult) {
            t9.i.g(baseResult, "t");
            y.this.n().showLoading(false);
            i.c cVar = w6.i.f19214g;
            cVar.T("1");
            cVar.b0(this.f15655b);
            y.this.n().B();
            if (d6.b.f12660a.r()) {
                com.mobile.brasiltv.utils.n0.f8733a.j(y.this.k(), "first_bind_email", this.f15655b);
            }
        }
    }

    public static final class b extends ha.a {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f15658b;

        public static final class a extends t9.j implements s9.l {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ String f15659a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(String str) {
                super(1);
                this.f15659a = str;
            }

            @Override // s9.l
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((String) obj);
                return h9.t.f14242a;
            }

            public final void invoke(String str) {
                com.mobile.brasiltv.utils.f1.f8649a.x(com.mobile.brasiltv.utils.y.f8771a.d(this.f15659a));
            }
        }

        public b(String str) {
            this.f15658b = str;
        }

        @Override // ha.a, io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            t9.i.g(disposable, "d");
            super.onSubscribe(disposable);
            y.this.n().showLoading(true);
        }

        @Override // ha.a
        public void showErrorHint(String str) {
            t9.i.g(str, "returnCode");
            y.this.n().showLoading(false);
            if (com.mobile.brasiltv.utils.b0.T(str, "portal100072") || com.mobile.brasiltv.utils.b0.T(str, "portal100073")) {
                y.this.n().d(R.string.verification_invalid);
            } else if (t9.i.b(str, "aaa100077")) {
                y.this.n().j();
            } else {
                com.mobile.brasiltv.utils.x.f8754a.w(y.this.k(), new a(com.mobile.brasiltv.utils.y.f8771a.c(str)));
            }
        }

        @Override // ha.a, io.reactivex.Observer
        public void onNext(BaseResult baseResult) {
            t9.i.g(baseResult, "t");
            if (d6.b.f12660a.a()) {
                y.this.i(this.f15658b);
            } else {
                y.this.n().showLoading(false);
                y.this.n().K();
            }
        }
    }

    public static final class c extends ha.a {
        public c() {
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
                y.this.n().e(ba.t.M(emailSuffixStr, new String[]{","}, false, 0, 6, null));
            }
        }
    }

    public static final class d extends ha.a {

        public static final class a extends t9.j implements s9.l {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ String f15662a;

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ String f15663b;

            /* renamed from: c, reason: collision with root package name */
            public final /* synthetic */ y f15664c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(String str, String str2, y yVar) {
                super(1);
                this.f15662a = str;
                this.f15663b = str2;
                this.f15664c = yVar;
            }

            @Override // s9.l
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((String) obj);
                return h9.t.f14242a;
            }

            public final void invoke(String str) {
                String d10 = com.mobile.brasiltv.utils.y.f8771a.d(this.f15662a);
                if (t9.i.b(this.f15662a, "no_report_type")) {
                    if (t9.i.b(this.f15663b, "portal100060")) {
                        d10 = this.f15664c.k().getResources().getString(R.string.frequent_operation);
                        t9.i.f(d10, "context.resources.getStr…tring.frequent_operation)");
                    } else if (t9.i.b(this.f15663b, "portal400001")) {
                        d10 = this.f15664c.k().getResources().getString(R.string.account_not_suport_email);
                        t9.i.f(d10, "context.resources.getStr…account_not_suport_email)");
                    }
                } else if (t9.i.b(this.f15663b, "aaa100077")) {
                    this.f15664c.n().j();
                    return;
                }
                com.mobile.brasiltv.utils.f1.f8649a.x(d10);
            }
        }

        public d() {
        }

        @Override // ha.a, io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            t9.i.g(disposable, "d");
            super.onSubscribe(disposable);
            y.this.n().showLoading(true);
        }

        @Override // ha.a
        public void showErrorHint(String str) {
            t9.i.g(str, "returnCode");
            y.this.n().showLoading(false);
            com.mobile.brasiltv.utils.x.f8754a.w(y.this.k(), new a(com.mobile.brasiltv.utils.y.f8771a.c(str), str, y.this));
        }

        @Override // ha.a, io.reactivex.Observer
        public void onNext(BaseResult baseResult) {
            t9.i.g(baseResult, "t");
            y.this.n().showLoading(false);
            y.this.n().i();
        }
    }

    public y(f5.c cVar, i6.n nVar) {
        t9.i.g(cVar, com.umeng.analytics.pro.f.X);
        t9.i.g(nVar, "view");
        this.f15652a = cVar;
        this.f15653b = nVar;
    }

    @Override // l5.a
    public void e() {
        l();
    }

    @Override // l5.a
    public void g() {
    }

    public final void i(String str) {
        i.c cVar = w6.i.f19214g;
        cVar.b().Q0(new BindEmailV2Bean(str, "1", "", cVar.J(), cVar.H())).compose(this.f15652a.O1()).subscribe(new a(str));
    }

    public void j(String str, String str2) {
        t9.i.g(str, Scopes.EMAIL);
        t9.i.g(str2, "verifyCode");
        if (!com.mobile.brasiltv.utils.j1.i(str)) {
            this.f15653b.d(R.string.email_incorrect);
        } else {
            i.c cVar = w6.i.f19214g;
            cVar.b().T0(new CheckVerifyCodeBean(str, "1", str2, cVar.J(), cVar.H())).compose(this.f15652a.O1()).subscribe(new b(str));
        }
    }

    public final f5.c k() {
        return this.f15652a;
    }

    public final void l() {
        w6.i.f19214g.b().q1().compose(this.f15652a.O1()).subscribe(new c());
    }

    public String m() {
        String e10 = na.f.e(this.f15652a, "lastest_input_bind_email");
        t9.i.f(e10, "getStrings(context, Cons…LASTEST_INPUT_BIND_EMAIL)");
        return e10;
    }

    public final i6.n n() {
        return this.f15653b;
    }

    public void o(String str) {
        t9.i.g(str, Scopes.EMAIL);
        na.f.k(this.f15652a, "lastest_input_bind_email", str);
    }

    public void p(String str) {
        t9.i.g(str, Scopes.EMAIL);
        if (!com.mobile.brasiltv.utils.j1.i(str)) {
            this.f15653b.d(R.string.email_incorrect);
        } else {
            i.c cVar = w6.i.f19214g;
            cVar.b().j2(new EmailVerifyCodeBean(str, "1", cVar.J(), cVar.H())).compose(this.f15652a.O1()).subscribe(new d());
        }
    }
}
