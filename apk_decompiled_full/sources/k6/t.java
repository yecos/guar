package k6;

import com.google.android.gms.common.Scopes;
import com.mobile.brasiltv.app.App;
import com.msandroid.mobile.R;
import com.umeng.message.common.inter.ITagManager;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import mobile.com.requestframe.utils.bean.ChangeBindEmailBean;
import mobile.com.requestframe.utils.bean.CheckVerifyCodeBean;
import mobile.com.requestframe.utils.bean.EmailVerifyCodeBean;
import mobile.com.requestframe.utils.response.BaseResult;
import mobile.com.requestframe.utils.response.GetEmailSuffix;
import mobile.com.requestframe.utils.response.GetEmailSuffixResult;
import w6.i;

/* loaded from: classes3.dex */
public final class t implements l5.a {

    /* renamed from: a, reason: collision with root package name */
    public final f5.c f15547a;

    /* renamed from: b, reason: collision with root package name */
    public final i6.k f15548b;

    public static final class a extends ha.a {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f15550b;

        /* renamed from: k6.t$a$a, reason: collision with other inner class name */
        public static final class C0258a extends t9.j implements s9.l {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ String f15551a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0258a(String str) {
                super(1);
                this.f15551a = str;
            }

            @Override // s9.l
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((String) obj);
                return h9.t.f14242a;
            }

            public final void invoke(String str) {
                com.mobile.brasiltv.utils.f1.f8649a.x(com.mobile.brasiltv.utils.y.f8771a.d(this.f15551a));
            }
        }

        public a(String str) {
            this.f15550b = str;
        }

        @Override // ha.a
        public void showErrorHint(String str) {
            t9.i.g(str, "returnCode");
            t.this.q().showLoading(false);
            com.mobile.brasiltv.utils.x.f8754a.w(t.this.o(), new C0258a(com.mobile.brasiltv.utils.y.f8771a.c(str)));
        }

        @Override // ha.a, io.reactivex.Observer
        public void onNext(BaseResult baseResult) {
            t9.i.g(baseResult, "t");
            t.this.q().showLoading(false);
            i.c cVar = w6.i.f19214g;
            String m10 = cVar.m();
            cVar.b0(this.f15550b);
            t.this.s(m10, this.f15550b);
            if (d6.b.f12660a.r()) {
                com.mobile.brasiltv.utils.n0.f8733a.j(t.this.o(), "first_bind_email", this.f15550b);
            }
            t.this.q().b2();
        }
    }

    public static final class b extends ha.a {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f15553b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f15554c;

        public static final class a extends t9.j implements s9.l {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ String f15555a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(String str) {
                super(1);
                this.f15555a = str;
            }

            @Override // s9.l
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((String) obj);
                return h9.t.f14242a;
            }

            public final void invoke(String str) {
                com.mobile.brasiltv.utils.f1.f8649a.x(com.mobile.brasiltv.utils.y.f8771a.d(this.f15555a));
            }
        }

        public b(String str, String str2) {
            this.f15553b = str;
            this.f15554c = str2;
        }

        @Override // ha.a, io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            t9.i.g(disposable, "d");
            super.onSubscribe(disposable);
            t.this.q().showLoading(true);
        }

        @Override // ha.a
        public void showErrorHint(String str) {
            t9.i.g(str, "returnCode");
            t.this.q().showLoading(false);
            if (com.mobile.brasiltv.utils.b0.T(str, "portal100072") || com.mobile.brasiltv.utils.b0.T(str, "portal100073")) {
                t.this.q().d(R.string.verification_invalid);
            } else if (t9.i.b(str, "aaa100077")) {
                t.this.q().j();
            } else {
                com.mobile.brasiltv.utils.x.f8754a.w(t.this.o(), new a(com.mobile.brasiltv.utils.y.f8771a.c(str)));
            }
        }

        @Override // ha.a, io.reactivex.Observer
        public void onNext(BaseResult baseResult) {
            t9.i.g(baseResult, "t");
            t.this.m(this.f15553b, this.f15554c);
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
                t.this.q().e(ba.t.M(emailSuffixStr, new String[]{","}, false, 0, 6, null));
            }
        }
    }

    public static final class d extends ha.a {

        public static final class a extends t9.j implements s9.l {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ String f15558a;

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ String f15559b;

            /* renamed from: c, reason: collision with root package name */
            public final /* synthetic */ t f15560c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(String str, String str2, t tVar) {
                super(1);
                this.f15558a = str;
                this.f15559b = str2;
                this.f15560c = tVar;
            }

            @Override // s9.l
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((String) obj);
                return h9.t.f14242a;
            }

            public final void invoke(String str) {
                String d10 = com.mobile.brasiltv.utils.y.f8771a.d(this.f15558a);
                if (t9.i.b(this.f15558a, "no_report_type")) {
                    if (t9.i.b(this.f15559b, "portal100060")) {
                        d10 = this.f15560c.o().getResources().getString(R.string.frequent_operation);
                        t9.i.f(d10, "context.resources.getStr…tring.frequent_operation)");
                    } else if (t9.i.b(this.f15559b, "portal400001")) {
                        d10 = this.f15560c.o().getResources().getString(R.string.account_not_suport_email);
                        t9.i.f(d10, "context.resources.getStr…account_not_suport_email)");
                    }
                } else if (t9.i.b(this.f15559b, "aaa100077")) {
                    this.f15560c.q().j();
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
            t.this.q().showLoading(true);
        }

        @Override // ha.a
        public void showErrorHint(String str) {
            t9.i.g(str, "returnCode");
            t.this.q().showLoading(false);
            com.mobile.brasiltv.utils.x.f8754a.w(t.this.o(), new a(com.mobile.brasiltv.utils.y.f8771a.c(str), str, t.this));
        }

        @Override // ha.a, io.reactivex.Observer
        public void onNext(BaseResult baseResult) {
            t9.i.g(baseResult, "t");
            t.this.q().showLoading(false);
            t.this.q().i();
        }
    }

    public static final class e extends t9.j implements s9.l {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f15561a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(String str) {
            super(1);
            this.f15561a = str;
        }

        @Override // s9.l
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke(String str) {
            t9.i.g(str, "it");
            return Boolean.valueOf(App.f8263e.a().i().updateAccountEmail(w6.i.f19214g.H(), str, this.f15561a));
        }
    }

    public static final class f extends t9.j implements s9.l {

        /* renamed from: a, reason: collision with root package name */
        public static final f f15562a = new f();

        public f() {
            super(1);
        }

        @Override // s9.l
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((Boolean) obj);
            return h9.t.f14242a;
        }

        public final void invoke(Boolean bool) {
            StringBuilder sb = new StringBuilder();
            sb.append("update switch account ");
            t9.i.f(bool, "success");
            sb.append(bool.booleanValue() ? "success" : ITagManager.FAIL);
        }
    }

    public static final class g extends t9.j implements s9.l {

        /* renamed from: a, reason: collision with root package name */
        public static final g f15563a = new g();

        public g() {
            super(1);
        }

        @Override // s9.l
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((Throwable) obj);
            return h9.t.f14242a;
        }

        public final void invoke(Throwable th) {
            th.printStackTrace();
        }
    }

    public t(f5.c cVar, i6.k kVar) {
        t9.i.g(cVar, com.umeng.analytics.pro.f.X);
        t9.i.g(kVar, "view");
        this.f15547a = cVar;
        this.f15548b = kVar;
    }

    public static final Boolean t(s9.l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        return (Boolean) lVar.invoke(obj);
    }

    public static final void u(s9.l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    public static final void v(s9.l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    @Override // l5.a
    public void e() {
        p();
    }

    @Override // l5.a
    public void g() {
    }

    public final void m(String str, String str2) {
        i.c cVar = w6.i.f19214g;
        cVar.b().S0(new ChangeBindEmailBean(str, "2", str2, cVar.J(), cVar.H())).compose(this.f15547a.O1()).subscribe(new a(str));
    }

    public void n(String str, String str2) {
        t9.i.g(str, Scopes.EMAIL);
        t9.i.g(str2, "verifyCode");
        if (!com.mobile.brasiltv.utils.j1.i(str)) {
            this.f15548b.d(R.string.email_incorrect);
        } else {
            i.c cVar = w6.i.f19214g;
            cVar.b().T0(new CheckVerifyCodeBean(str, "2", str2, cVar.J(), cVar.H())).compose(this.f15547a.O1()).subscribe(new b(str, str2));
        }
    }

    public final f5.c o() {
        return this.f15547a;
    }

    public final void p() {
        w6.i.f19214g.b().q1().compose(this.f15547a.O1()).subscribe(new c());
    }

    public final i6.k q() {
        return this.f15548b;
    }

    public void r(String str) {
        t9.i.g(str, Scopes.EMAIL);
        if (!com.mobile.brasiltv.utils.j1.i(str)) {
            this.f15548b.d(R.string.email_incorrect);
        } else {
            i.c cVar = w6.i.f19214g;
            cVar.b().j2(new EmailVerifyCodeBean(str, "2", cVar.J(), cVar.H())).compose(this.f15547a.O1()).subscribe(new d());
        }
    }

    public final void s(String str, String str2) {
        Observable just = Observable.just(str);
        final e eVar = new e(str2);
        Observable subscribeOn = just.map(new Function() { // from class: k6.q
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                Boolean t10;
                t10 = t.t(s9.l.this, obj);
                return t10;
            }
        }).subscribeOn(Schedulers.io());
        final f fVar = f.f15562a;
        Consumer consumer = new Consumer() { // from class: k6.r
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                t.u(s9.l.this, obj);
            }
        };
        final g gVar = g.f15563a;
        subscribeOn.subscribe(consumer, new Consumer() { // from class: k6.s
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                t.v(s9.l.this, obj);
            }
        });
    }
}
