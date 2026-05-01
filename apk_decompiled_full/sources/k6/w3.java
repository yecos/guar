package k6;

import android.text.TextUtils;
import com.google.android.gms.common.Scopes;
import com.mobile.brasiltv.bean.MemberInfo;
import com.mobile.brasiltv.bean.event.CloseForceBindEvent;
import com.mobile.brasiltv.bean.event.CloseForcePageEvent;
import com.mobile.brasiltv.bean.event.UpdateRestrictEvent;
import com.mobile.brasiltv.db.SwitchAccountBean;
import com.mobile.brasiltv.mine.activity.ForceChangePwdAty;
import com.mobile.brasiltv.view.dialog.NumberLimitDialog;
import com.msandroid.mobile.R;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import mobile.com.requestframe.utils.bean.BindEmailV2Bean;
import mobile.com.requestframe.utils.response.BaseResult;
import mobile.com.requestframe.utils.response.LoginResult;
import mobile.com.requestframe.utils.response.UserData;
import w6.i;

/* loaded from: classes3.dex */
public final class w3 implements l5.a {

    /* renamed from: a, reason: collision with root package name */
    public final f5.c f15617a;

    /* renamed from: b, reason: collision with root package name */
    public final i6.t0 f15618b;

    public static final class a extends ha.a {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f15620b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f15621c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ String f15622d;

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ boolean f15623e;

        /* renamed from: k6.w3$a$a, reason: collision with other inner class name */
        public static final class C0261a extends t9.j implements s9.l {

            /* renamed from: a, reason: collision with root package name */
            public static final C0261a f15624a = new C0261a();

            public C0261a() {
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

        public static final class b extends t9.j implements s9.l {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ String f15625a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public b(String str) {
                super(1);
                this.f15625a = str;
            }

            @Override // s9.l
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((String) obj);
                return h9.t.f14242a;
            }

            public final void invoke(String str) {
                com.mobile.brasiltv.utils.f1.f8649a.x(com.mobile.brasiltv.utils.y.p(com.mobile.brasiltv.utils.y.f8771a, this.f15625a, null, null, 6, null));
            }
        }

        public a(String str, String str2, String str3, boolean z10) {
            this.f15620b = str;
            this.f15621c = str2;
            this.f15622d = str3;
            this.f15623e = z10;
        }

        @Override // ha.a, io.reactivex.Observer
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void onNext(LoginResult loginResult) {
            t9.i.g(loginResult, "t");
            w3.this.k().showLoading(false);
            UserData data = loginResult.getData();
            if (!com.mobile.brasiltv.utils.b0.I(data != null ? data.getPortalCodeList() : null)) {
                com.mobile.brasiltv.utils.x.f8754a.w(w3.this.j(), C0261a.f15624a);
                return;
            }
            d6.b bVar = d6.b.f12660a;
            bVar.E(w3.this.j(), this.f15620b);
            f5.c j10 = w3.this.j();
            UserData data2 = loginResult.getData();
            t9.i.d(data2);
            bVar.F(j10, data2, this.f15621c, this.f15622d, (r21 & 16) != 0 ? "" : "", (r21 & 32) != 0 ? "" : "", (r21 & 64) != 0 ? "" : null, (r21 & 128) != 0);
            xa.c.c().j(new CloseForcePageEvent());
            if (!TextUtils.isEmpty(this.f15620b)) {
                UserData data3 = loginResult.getData();
                if (t9.i.b(data3 != null ? data3.getPwdTip() : null, "yes")) {
                    UserData data4 = loginResult.getData();
                    if (t9.i.b(data4 != null ? data4.getHasPwd() : null, "1")) {
                        com.mobile.brasiltv.utils.b0.c0(w3.this.j(), ForceChangePwdAty.class);
                        SwitchAccountBean switchAccountBean = new SwitchAccountBean();
                        switchAccountBean.setAccountType(this.f15620b);
                        switchAccountBean.setUserName(this.f15621c);
                        switchAccountBean.setPassword(this.f15622d);
                        s5.e.f18766a.n(s5.c.QUICK_LOGIN, switchAccountBean, "");
                        return;
                    }
                }
            }
            bVar.C(loginResult.getData());
            w3.this.k().E1(this.f15623e);
        }

        @Override // ha.a
        public void showErrorHint(String str) {
            t9.i.g(str, "returnCode");
            w3.this.k().showLoading(false);
            if (t9.i.b("aaa100094", str)) {
                new NumberLimitDialog(w3.this.j()).show();
            } else {
                com.mobile.brasiltv.utils.x.f8754a.w(w3.this.j(), new b(str));
            }
        }
    }

    public static final class b extends ha.a {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f15627b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f15628c;

        public static final class a extends t9.j implements s9.l {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ String f15629a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(String str) {
                super(1);
                this.f15629a = str;
            }

            @Override // s9.l
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((String) obj);
                return h9.t.f14242a;
            }

            public final void invoke(String str) {
                com.mobile.brasiltv.utils.f1.f8649a.x(com.mobile.brasiltv.utils.y.f8771a.d(this.f15629a));
            }
        }

        public b(String str, String str2) {
            this.f15627b = str;
            this.f15628c = str2;
        }

        @Override // ha.a, io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            t9.i.g(disposable, "d");
            super.onSubscribe(disposable);
            w3.this.k().showLoading(true);
        }

        @Override // ha.a
        public void showErrorHint(String str) {
            t9.i.g(str, "returnCode");
            w3.this.k().showLoading(false);
            if (!com.mobile.brasiltv.utils.b0.T(str, "portal100072") && !com.mobile.brasiltv.utils.b0.T(str, "portal100073")) {
                com.mobile.brasiltv.utils.x.f8754a.w(w3.this.j(), new a(com.mobile.brasiltv.utils.y.f8771a.c(str)));
            } else {
                String string = w3.this.j().getResources().getString(R.string.verification_invalid);
                t9.i.f(string, "context.resources.getStr…ing.verification_invalid)");
                com.mobile.brasiltv.utils.f1.f8649a.x(string);
            }
        }

        @Override // ha.a, io.reactivex.Observer
        public void onNext(BaseResult baseResult) {
            t9.i.g(baseResult, "t");
            MemberInfo memberInfo = MemberInfo.INSTANCE;
            String str = this.f15627b;
            t9.i.f(str, "password");
            memberInfo.putPassword(str, false);
            i.c cVar = w6.i.f19214g;
            cVar.h0("1");
            cVar.T("1");
            cVar.b0(this.f15628c);
            cVar.q0("1");
            xa.c.c().m(new UpdateRestrictEvent("1", false, 2, null));
            xa.c.c().j(new CloseForceBindEvent());
            w3 w3Var = w3.this;
            String str2 = this.f15628c;
            String lastPassword = memberInfo.getLastPassword();
            d6.b bVar = d6.b.f12660a;
            w3Var.i(str2, lastPassword, !bVar.y());
            if (bVar.r()) {
                com.mobile.brasiltv.utils.n0.f8733a.j(w3.this.j(), "first_bind_email", this.f15628c);
            }
        }
    }

    public w3(f5.c cVar, i6.t0 t0Var) {
        t9.i.g(cVar, com.umeng.analytics.pro.f.X);
        t9.i.g(t0Var, "view");
        this.f15617a = cVar;
        this.f15618b = t0Var;
    }

    @Override // l5.a
    public void e() {
    }

    @Override // l5.a
    public void g() {
    }

    public final void i(String str, String str2, boolean z10) {
        Observable W1;
        W1 = w6.i.f19214g.b().W1("2", "", str, str2, "", null, (r17 & 64) != 0 ? null : null);
        W1.compose(this.f15617a.O1()).subscribe(new a("2", str, str2, z10));
    }

    public final f5.c j() {
        return this.f15617a;
    }

    public final i6.t0 k() {
        return this.f15618b;
    }

    public void l(String str, String str2, String str3) {
        t9.i.g(str, Scopes.EMAIL);
        t9.i.g(str2, "pwd");
        t9.i.g(str3, "repeatPwd");
        if (!com.mobile.brasiltv.utils.j1.g(str2)) {
            this.f15618b.d(R.string.password_format_error_tips);
            return;
        }
        if (!com.mobile.brasiltv.utils.j1.g(str3)) {
            this.f15618b.d(R.string.password_error_tips);
            return;
        }
        if (!com.mobile.brasiltv.utils.b0.T(str2, str3)) {
            this.f15618b.d(R.string.not_match_password);
            return;
        }
        String e10 = ma.m.e(str2);
        i.c cVar = w6.i.f19214g;
        w6.i b10 = cVar.b();
        t9.i.f(e10, "password");
        b10.Q0(new BindEmailV2Bean(str, "1", e10, cVar.J(), cVar.H())).compose(this.f15617a.O1()).subscribe(new b(e10, str));
    }
}
