package k6;

import android.text.TextUtils;
import com.mobile.brasiltv.bean.MemberInfo;
import com.mobile.brasiltv.db.SwitchAccountBean;
import com.mobile.brasiltv.mine.activity.ForceChangePwdAty;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import mobile.com.requestframe.utils.response.BindPhoneResult;
import mobile.com.requestframe.utils.response.CheckVerificationResult;
import mobile.com.requestframe.utils.response.LoginResult;
import mobile.com.requestframe.utils.response.UserData;
import w6.i;

/* loaded from: classes3.dex */
public final class v3 implements l5.a {

    /* renamed from: a, reason: collision with root package name */
    public f5.c f15589a;

    /* renamed from: b, reason: collision with root package name */
    public i6.s0 f15590b;

    /* renamed from: c, reason: collision with root package name */
    public Disposable f15591c;

    public static final class a extends ha.a {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f15593b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f15594c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ String f15595d;

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ String f15596e;

        /* renamed from: k6.v3$a$a, reason: collision with other inner class name */
        public static final class C0260a extends t9.j implements s9.l {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ String f15597a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0260a(String str) {
                super(1);
                this.f15597a = str;
            }

            @Override // s9.l
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((String) obj);
                return h9.t.f14242a;
            }

            public final void invoke(String str) {
                com.mobile.brasiltv.utils.f1.f8649a.x(com.mobile.brasiltv.utils.y.p(com.mobile.brasiltv.utils.y.f8771a, this.f15597a, null, null, 6, null));
            }
        }

        public a(String str, String str2, String str3, String str4) {
            this.f15593b = str;
            this.f15594c = str2;
            this.f15595d = str3;
            this.f15596e = str4;
        }

        @Override // ha.a, io.reactivex.Observer
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void onNext(BindPhoneResult bindPhoneResult) {
            t9.i.g(bindPhoneResult, "t");
            v3.this.k().showLoading(false);
            i.c cVar = w6.i.f19214g;
            cVar.j0(this.f15593b);
            cVar.A0(this.f15594c);
            cVar.R(this.f15595d);
            cVar.n0(this.f15596e);
            na.f.k(v3.this.j(), "login_area_code", cVar.f());
            MemberInfo.INSTANCE.putPassword(this.f15596e, false);
            v3.this.k().H();
        }

        @Override // ha.a, io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            t9.i.g(disposable, "d");
            super.onSubscribe(disposable);
            v3.this.k().showLoading(true);
        }

        @Override // ha.a
        public void showErrorHint(String str) {
            t9.i.g(str, "returnCode");
            v3.this.k().showLoading(false);
            v3.this.k().o(str);
            com.mobile.brasiltv.utils.x.f8754a.w(v3.this.j(), new C0260a(str));
        }
    }

    public static final class b extends ha.a {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f15599b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f15600c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ String f15601d;

        public static final class a extends t9.j implements s9.l {

            /* renamed from: a, reason: collision with root package name */
            public static final a f15602a = new a();

            public a() {
                super(1);
            }

            @Override // s9.l
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((String) obj);
                return h9.t.f14242a;
            }

            public final void invoke(String str) {
                com.mobile.brasiltv.utils.f1.f8649a.x(com.mobile.brasiltv.utils.y.p(com.mobile.brasiltv.utils.y.f8771a, "CUSTOM_NO_ASSOCIATED_PORTAL", null, null, 6, null));
            }
        }

        public b(String str, String str2, String str3) {
            this.f15599b = str;
            this.f15600c = str2;
            this.f15601d = str3;
        }

        @Override // ha.a, io.reactivex.Observer
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void onNext(LoginResult loginResult) {
            t9.i.g(loginResult, "t");
            v3.this.k().showLoading(false);
            UserData data = loginResult.getData();
            if (com.mobile.brasiltv.utils.b0.I(data != null ? data.getPortalCodeList() : null)) {
                d6.b bVar = d6.b.f12660a;
                UserData data2 = loginResult.getData();
                t9.i.d(data2);
                bVar.H(data2);
                bVar.E(v3.this.j(), "3");
                f5.c j10 = v3.this.j();
                UserData data3 = loginResult.getData();
                t9.i.d(data3);
                bVar.F(j10, data3, this.f15599b, this.f15600c, (r21 & 16) != 0 ? "" : null, (r21 & 32) != 0 ? "" : null, (r21 & 64) != 0 ? "" : null, (r21 & 128) != 0);
                if (!TextUtils.isEmpty("3")) {
                    UserData data4 = loginResult.getData();
                    if (t9.i.b(data4 != null ? data4.getPwdTip() : null, "yes")) {
                        UserData data5 = loginResult.getData();
                        if (t9.i.b(data5 != null ? data5.getHasPwd() : null, "1")) {
                            com.mobile.brasiltv.utils.b0.c0(v3.this.j(), ForceChangePwdAty.class);
                            SwitchAccountBean switchAccountBean = new SwitchAccountBean();
                            switchAccountBean.setAccountType("3");
                            switchAccountBean.setUserName(this.f15599b);
                            switchAccountBean.setPassword(this.f15600c);
                            switchAccountBean.setAreaCode(this.f15601d);
                            switchAccountBean.setPhone(this.f15599b);
                            s5.e.f18766a.n(s5.c.QUICK_LOGIN, switchAccountBean, "");
                            return;
                        }
                    }
                }
                bVar.C(loginResult.getData());
            } else {
                com.mobile.brasiltv.utils.x.f8754a.w(v3.this.j(), a.f15602a);
            }
            v3.this.k().w0(true);
        }

        @Override // ha.a, io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            t9.i.g(disposable, "d");
            super.onSubscribe(disposable);
            v3.this.f15591c = disposable;
        }

        @Override // ha.a
        public void showErrorHint(String str) {
            t9.i.g(str, "returnCode");
            com.mobile.brasiltv.utils.b0.U(this, "login fail: " + str);
            v3.this.k().showLoading(false);
            if (!t9.i.b("aaa100094", str)) {
                v3.this.k().w0(false);
                return;
            }
            SwitchAccountBean switchAccountBean = new SwitchAccountBean();
            switchAccountBean.setAccountType("3");
            switchAccountBean.setUserName(this.f15599b);
            switchAccountBean.setPassword(this.f15600c);
            switchAccountBean.setAreaCode(this.f15601d);
            switchAccountBean.setPhone(this.f15599b);
            s5.e.f18766a.n(s5.c.QUICK_LOGIN, switchAccountBean, "");
            v3.this.k().x();
        }
    }

    public static final class c extends ha.a {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f15604b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f15605c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ String f15606d;

        public static final class a extends t9.j implements s9.l {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ t9.w f15607a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(t9.w wVar) {
                super(1);
                this.f15607a = wVar;
            }

            @Override // s9.l
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((String) obj);
                return h9.t.f14242a;
            }

            public final void invoke(String str) {
                com.mobile.brasiltv.utils.f1.f8649a.x(com.mobile.brasiltv.utils.y.f8771a.d((String) this.f15607a.f18961a));
            }
        }

        public c(String str, String str2, String str3) {
            this.f15604b = str;
            this.f15605c = str2;
            this.f15606d = str3;
        }

        @Override // ha.a, io.reactivex.Observer
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void onNext(CheckVerificationResult checkVerificationResult) {
            t9.i.g(checkVerificationResult, "t");
            MemberInfo memberInfo = MemberInfo.INSTANCE;
            memberInfo.putPassword(this.f15604b, false);
            v3.this.l(this.f15605c, memberInfo.getLastPassword(), this.f15606d);
        }

        @Override // ha.a, io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            t9.i.g(disposable, "d");
            super.onSubscribe(disposable);
            v3.this.k().showLoading(true);
        }

        @Override // ha.a
        public void showErrorHint(String str) {
            t9.i.g(str, "returnCode");
            v3.this.k().showLoading(false);
            v3.this.k().o(str);
            t9.w wVar = new t9.w();
            wVar.f18961a = com.mobile.brasiltv.utils.y.f8771a.c(str);
            com.mobile.brasiltv.utils.x.f8754a.w(v3.this.j(), new a(wVar));
        }
    }

    public v3(f5.c cVar, i6.s0 s0Var) {
        t9.i.g(cVar, "activity");
        t9.i.g(s0Var, "view");
        this.f15589a = cVar;
        this.f15590b = s0Var;
    }

    @Override // l5.a
    public void e() {
    }

    @Override // l5.a
    public void g() {
    }

    public void i(String str, String str2, String str3, String str4) {
        t9.i.g(str, "phone");
        t9.i.g(str2, "areaCode");
        t9.i.g(str3, "verificationCode");
        t9.i.g(str4, "pwd");
        w6.i.f19214g.b().c2(str, str2, str3, str4).compose(this.f15589a.O1()).subscribe(new a(str, str3, str2, str4));
    }

    public final f5.c j() {
        return this.f15589a;
    }

    public final i6.s0 k() {
        return this.f15590b;
    }

    public final void l(String str, String str2, String str3) {
        Observable W1;
        Disposable disposable;
        t9.i.g(str, "phone");
        t9.i.g(str2, "password");
        t9.i.g(str3, "areaCode");
        Disposable disposable2 = this.f15591c;
        boolean z10 = false;
        if (disposable2 != null && !disposable2.isDisposed()) {
            z10 = true;
        }
        if (z10 && (disposable = this.f15591c) != null) {
            disposable.dispose();
        }
        W1 = w6.i.f19214g.b().W1("3", str3, str, str2, null, "1", (r17 & 64) != 0 ? null : null);
        W1.compose(this.f15589a.O1()).subscribe(new b(str, str2, str3));
    }

    public void m(String str, String str2, String str3, String str4, String str5) {
        t9.i.g(str, "phone");
        t9.i.g(str2, "areaCode");
        t9.i.g(str3, "verificationCode");
        t9.i.g(str4, "type");
        t9.i.g(str5, "pwd");
        w6.i.f19214g.b().k2(str, str2, str3, str4, str5).compose(this.f15589a.O1()).subscribe(new c(str5, str, str2));
    }
}
