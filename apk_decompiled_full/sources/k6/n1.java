package k6;

import com.msandroid.mobile.R;
import io.reactivex.disposables.Disposable;
import mobile.com.requestframe.util.RemoteLoginAndMsgEvent;
import mobile.com.requestframe.utils.response.AreaCodeData;
import mobile.com.requestframe.utils.response.AreaCodeResult;
import mobile.com.requestframe.utils.response.BindPhoneResult;
import mobile.com.requestframe.utils.response.CheckVerificationResult;
import mobile.com.requestframe.utils.response.VerificationResult;
import w6.i;

/* loaded from: classes3.dex */
public final class n1 implements l5.a {

    /* renamed from: a, reason: collision with root package name */
    public final f5.c f15418a;

    /* renamed from: b, reason: collision with root package name */
    public final i6.e0 f15419b;

    public static final class a extends ha.a {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f15421b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f15422c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ String f15423d;

        /* renamed from: k6.n1$a$a, reason: collision with other inner class name */
        public static final class C0256a extends t9.j implements s9.l {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ t9.w f15424a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0256a(t9.w wVar) {
                super(1);
                this.f15424a = wVar;
            }

            @Override // s9.l
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((String) obj);
                return h9.t.f14242a;
            }

            public final void invoke(String str) {
                com.mobile.brasiltv.utils.f1.f8649a.x(com.mobile.brasiltv.utils.y.f8771a.d((String) this.f15424a.f18961a));
            }
        }

        public a(String str, String str2, String str3) {
            this.f15421b = str;
            this.f15422c = str2;
            this.f15423d = str3;
        }

        @Override // ha.a, io.reactivex.Observer
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void onNext(BindPhoneResult bindPhoneResult) {
            t9.i.g(bindPhoneResult, "t");
            n1.this.m().showLoading(false);
            i.c cVar = w6.i.f19214g;
            cVar.j0(this.f15421b);
            cVar.A0(this.f15422c);
            cVar.R(this.f15423d);
            na.f.k(n1.this.k(), "login_area_code", this.f15423d);
            n1.this.m().H();
            if (d6.b.f12660a.r()) {
                com.mobile.brasiltv.utils.n0.f8733a.l(n1.this.k(), new String[]{"first_bind_mobile", "first_bind_area_code"}, new String[]{this.f15421b, this.f15423d});
            }
        }

        @Override // ha.a, io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            t9.i.g(disposable, "d");
            super.onSubscribe(disposable);
            n1.this.m().showLoading(true);
        }

        @Override // ha.a
        public void showErrorHint(String str) {
            t9.i.g(str, "returnCode");
            n1.this.m().showLoading(false);
            t9.w wVar = new t9.w();
            wVar.f18961a = com.mobile.brasiltv.utils.y.f8771a.c(str);
            com.mobile.brasiltv.utils.x.f8754a.w(n1.this.k(), new C0256a(wVar));
        }
    }

    public static final class b extends ha.a {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f15426b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f15427c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ String f15428d;

        public static final class a extends t9.j implements s9.l {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ t9.w f15429a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(t9.w wVar) {
                super(1);
                this.f15429a = wVar;
            }

            @Override // s9.l
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((String) obj);
                return h9.t.f14242a;
            }

            public final void invoke(String str) {
                com.mobile.brasiltv.utils.f1.f8649a.x(com.mobile.brasiltv.utils.y.f8771a.d((String) this.f15429a.f18961a));
            }
        }

        public b(String str, String str2, String str3) {
            this.f15426b = str;
            this.f15427c = str2;
            this.f15428d = str3;
        }

        @Override // ha.a, io.reactivex.Observer
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void onNext(CheckVerificationResult checkVerificationResult) {
            t9.i.g(checkVerificationResult, "t");
            i.c cVar = w6.i.f19214g;
            cVar.A0(this.f15426b);
            cVar.R(this.f15427c);
            cVar.j0(this.f15428d);
            n1.this.m().showLoading(false);
            n1.this.m().X0();
        }

        @Override // ha.a, io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            t9.i.g(disposable, "d");
            super.onSubscribe(disposable);
            n1.this.m().showLoading(true);
        }

        @Override // ha.a
        public void showErrorHint(String str) {
            t9.i.g(str, "returnCode");
            n1.this.m().showLoading(false);
            t9.w wVar = new t9.w();
            wVar.f18961a = com.mobile.brasiltv.utils.y.f8771a.c(str);
            com.mobile.brasiltv.utils.x.f8754a.w(n1.this.k(), new a(wVar));
        }
    }

    public static final class c extends ha.a {

        public static final class a extends t9.j implements s9.l {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ String f15431a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(String str) {
                super(1);
                this.f15431a = str;
            }

            @Override // s9.l
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((String) obj);
                return h9.t.f14242a;
            }

            public final void invoke(String str) {
                com.mobile.brasiltv.utils.f1.f8649a.x(com.mobile.brasiltv.utils.y.p(com.mobile.brasiltv.utils.y.f8771a, this.f15431a, null, null, 6, null));
            }
        }

        public c() {
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
            i6.e0 m10 = n1.this.m();
            String a10 = com.mobile.brasiltv.utils.h0.a(n1.this.k(), str);
            t9.i.f(a10, "getCountryByCode(context, areaCode)");
            m10.v(str, a10);
        }

        @Override // ha.a
        public void sendRemoteLoginEvent(RemoteLoginAndMsgEvent remoteLoginAndMsgEvent) {
        }

        @Override // ha.a
        public void showErrorHint(String str) {
            t9.i.g(str, "returnCode");
            com.mobile.brasiltv.utils.b0.U(this, "fetch area code fail: " + str);
            com.mobile.brasiltv.utils.y.f8771a.c(str);
            com.mobile.brasiltv.utils.x.f8754a.w(n1.this.k(), new a(str));
        }
    }

    public static final class d extends ha.a {

        public static final class a extends t9.j implements s9.l {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ t9.w f15433a;

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ String f15434b;

            /* renamed from: c, reason: collision with root package name */
            public final /* synthetic */ n1 f15435c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(t9.w wVar, String str, n1 n1Var) {
                super(1);
                this.f15433a = wVar;
                this.f15434b = str;
                this.f15435c = n1Var;
            }

            @Override // s9.l
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((String) obj);
                return h9.t.f14242a;
            }

            public final void invoke(String str) {
                String d10 = com.mobile.brasiltv.utils.y.f8771a.d((String) this.f15433a.f18961a);
                if (t9.i.b(this.f15433a.f18961a, "no_report_type") && t9.i.b(this.f15434b, "portal100060")) {
                    d10 = this.f15435c.k().getResources().getString(R.string.frequent_operation);
                    t9.i.f(d10, "context.resources.getStr…tring.frequent_operation)");
                }
                com.mobile.brasiltv.utils.f1.f8649a.x(d10);
            }
        }

        public d() {
        }

        @Override // ha.a, io.reactivex.Observer
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void onNext(VerificationResult verificationResult) {
            t9.i.g(verificationResult, "t");
            n1.this.m().showLoading(false);
            n1.this.m().P();
        }

        @Override // ha.a, io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            t9.i.g(disposable, "d");
            super.onSubscribe(disposable);
            n1.this.m().showLoading(true);
        }

        @Override // ha.a
        public void showErrorHint(String str) {
            t9.i.g(str, "returnCode");
            n1.this.m().showLoading(false);
            n1.this.m().i2();
            t9.w wVar = new t9.w();
            wVar.f18961a = com.mobile.brasiltv.utils.y.f8771a.c(str);
            com.mobile.brasiltv.utils.x.f8754a.w(n1.this.k(), new a(wVar, str, n1.this));
        }
    }

    public n1(f5.c cVar, i6.e0 e0Var) {
        t9.i.g(cVar, com.umeng.analytics.pro.f.X);
        t9.i.g(e0Var, "view");
        this.f15418a = cVar;
        this.f15419b = e0Var;
    }

    @Override // l5.a
    public void e() {
        j();
    }

    @Override // l5.a
    public void g() {
    }

    public void h(String str, String str2, String str3, String str4) {
        t9.i.g(str, "phone");
        t9.i.g(str2, "areaCode");
        t9.i.g(str3, "verificationCode");
        w6.i.f19214g.b().c2(str, str2, str3, str4).compose(this.f15418a.O1()).subscribe(new a(str, str3, str2));
    }

    public void i(String str, String str2, String str3, String str4) {
        t9.i.g(str, "phone");
        t9.i.g(str2, "areaCode");
        t9.i.g(str3, "verificationCode");
        t9.i.g(str4, "type");
        w6.i.f19214g.b().W0(str, str2, str3, str4).compose(this.f15418a.O1()).subscribe(new b(str3, str2, str));
    }

    public final void j() {
        w6.i.f19214g.b().O0().compose(this.f15418a.O1()).subscribe(new c());
    }

    public final f5.c k() {
        return this.f15418a;
    }

    public void l(String str, String str2, String str3) {
        t9.i.g(str, "phone");
        t9.i.g(str2, "areaCode");
        t9.i.g(str3, "type");
        w6.i.f19214g.b().U1(str, str2, str3).compose(this.f15418a.O1()).subscribe(new d());
    }

    public final i6.e0 m() {
        return this.f15419b;
    }
}
