package k6;

import com.google.android.gms.common.Scopes;
import com.msandroid.mobile.R;
import io.reactivex.disposables.Disposable;
import mobile.com.requestframe.utils.bean.CheckVerifyCodeBean;
import mobile.com.requestframe.utils.bean.EmailVerifyCodeBean;
import mobile.com.requestframe.utils.response.AreaCodeData;
import mobile.com.requestframe.utils.response.AreaCodeResult;
import mobile.com.requestframe.utils.response.BaseResult;
import mobile.com.requestframe.utils.response.GetEmailSuffix;
import mobile.com.requestframe.utils.response.GetEmailSuffixResult;

/* loaded from: classes3.dex */
public final class r2 implements l5.a {

    /* renamed from: a, reason: collision with root package name */
    public final f5.c f15500a;

    /* renamed from: b, reason: collision with root package name */
    public i6.k0 f15501b;

    public static final class a extends ha.a {

        /* renamed from: k6.r2$a$a, reason: collision with other inner class name */
        public static final class C0257a extends t9.j implements s9.l {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ String f15503a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0257a(String str) {
                super(1);
                this.f15503a = str;
            }

            @Override // s9.l
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((String) obj);
                return h9.t.f14242a;
            }

            public final void invoke(String str) {
                com.mobile.brasiltv.utils.f1.f8649a.x(com.mobile.brasiltv.utils.y.p(com.mobile.brasiltv.utils.y.f8771a, this.f15503a, null, null, 6, null));
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
            i6.k0 m10 = r2.this.m();
            String a10 = com.mobile.brasiltv.utils.h0.a(r2.this.j(), str);
            t9.i.f(a10, "getCountryByCode(context, areaCode)");
            m10.L(str, a10);
        }

        @Override // ha.a, io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            t9.i.g(disposable, "d");
            super.onSubscribe(disposable);
        }

        @Override // ha.a
        public void showErrorHint(String str) {
            t9.i.g(str, "returnCode");
            com.mobile.brasiltv.utils.x.f8754a.w(r2.this.j(), new C0257a(str));
        }
    }

    public static final class b extends ha.a {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f15505b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f15506c;

        public static final class a extends t9.j implements s9.l {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ String f15507a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(String str) {
                super(1);
                this.f15507a = str;
            }

            @Override // s9.l
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((String) obj);
                return h9.t.f14242a;
            }

            public final void invoke(String str) {
                com.mobile.brasiltv.utils.f1.f8649a.x(com.mobile.brasiltv.utils.y.f8771a.d(this.f15507a));
            }
        }

        public b(String str, String str2) {
            this.f15505b = str;
            this.f15506c = str2;
        }

        @Override // ha.a, io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            t9.i.g(disposable, "d");
            super.onSubscribe(disposable);
            r2.this.m().showLoading(true);
        }

        @Override // ha.a
        public void showErrorHint(String str) {
            t9.i.g(str, "returnCode");
            r2.this.m().showLoading(false);
            if (com.mobile.brasiltv.utils.b0.T(str, "portal100072") || com.mobile.brasiltv.utils.b0.T(str, "portal100073")) {
                r2.this.m().u(R.string.verification_invalid);
            } else {
                com.mobile.brasiltv.utils.x.f8754a.w(r2.this.j(), new a(com.mobile.brasiltv.utils.y.f8771a.c(str)));
            }
        }

        @Override // ha.a, io.reactivex.Observer
        public void onNext(BaseResult baseResult) {
            t9.i.g(baseResult, "t");
            r2.this.m().showLoading(false);
            r2.this.m().W1(this.f15505b, this.f15506c);
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
                r2.this.m().e(ba.t.M(emailSuffixStr, new String[]{","}, false, 0, 6, null));
            }
        }
    }

    public static final class d extends ha.a {

        public static final class a extends t9.j implements s9.l {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ String f15510a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(String str) {
                super(1);
                this.f15510a = str;
            }

            @Override // s9.l
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((String) obj);
                return h9.t.f14242a;
            }

            public final void invoke(String str) {
                com.mobile.brasiltv.utils.f1.f8649a.x(com.mobile.brasiltv.utils.y.f8771a.d(this.f15510a));
            }
        }

        public d() {
        }

        @Override // ha.a, io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            t9.i.g(disposable, "d");
            super.onSubscribe(disposable);
            r2.this.m().showLoading(true);
        }

        @Override // ha.a
        public void showErrorHint(String str) {
            t9.i.g(str, "returnCode");
            r2.this.m().showLoading(false);
            String c10 = com.mobile.brasiltv.utils.y.f8771a.c(str);
            r2.this.m().j2();
            if (t9.i.b(c10, "no_report_type")) {
                if (t9.i.b(str, "portal100060")) {
                    r2.this.m().u(R.string.frequent_operation);
                    return;
                } else if (t9.i.b(str, "portal400001")) {
                    i6.k0 m10 = r2.this.m();
                    String string = r2.this.j().getResources().getString(R.string.account_not_suport_email);
                    t9.i.f(string, "context.resources.getStr…account_not_suport_email)");
                    m10.o(string);
                    return;
                }
            }
            com.mobile.brasiltv.utils.x.f8754a.w(r2.this.j(), new a(c10));
        }

        @Override // ha.a, io.reactivex.Observer
        public void onNext(BaseResult baseResult) {
            t9.i.g(baseResult, "t");
            r2.this.m().showLoading(false);
            r2.this.m().A0();
        }
    }

    public r2(f5.c cVar, i6.k0 k0Var) {
        t9.i.g(cVar, com.umeng.analytics.pro.f.X);
        t9.i.g(k0Var, "view");
        this.f15500a = cVar;
        this.f15501b = k0Var;
    }

    @Override // l5.a
    public void e() {
        k();
    }

    @Override // l5.a
    public void g() {
    }

    public void h() {
        w6.i.f19214g.b().O0().compose(this.f15500a.O1()).subscribe(new a());
    }

    public void i(String str, String str2) {
        t9.i.g(str, Scopes.EMAIL);
        t9.i.g(str2, "verificationCode");
        w6.i.f19214g.b().T0(new CheckVerifyCodeBean(str, "3", str2, null, null)).compose(this.f15500a.O1()).subscribe(new b(str, str2));
    }

    public final f5.c j() {
        return this.f15500a;
    }

    public final void k() {
        w6.i.f19214g.b().q1().compose(this.f15500a.O1()).subscribe(new c());
    }

    public void l(String str) {
        t9.i.g(str, Scopes.EMAIL);
        w6.i.f19214g.b().j2(new EmailVerifyCodeBean(str, "3", null, null)).compose(this.f15500a.O1()).subscribe(new d());
    }

    public final i6.k0 m() {
        return this.f15501b;
    }
}
