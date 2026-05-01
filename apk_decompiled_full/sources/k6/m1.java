package k6;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.mobile.brasiltv.activity.MainAty;
import com.mobile.brasiltv.bean.event.CloseForcePageEvent;
import com.mobile.brasiltv.db.MobileDao;
import com.mobile.brasiltv.db.SwitchAccountBean;
import com.mobile.brasiltv.mine.activity.ForceChangePwdAty;
import com.mobile.brasiltv.mine.activity.LoginAty;
import com.mobile.brasiltv.view.dialog.NumberLimitDialog;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.functions.Consumer;
import mobile.com.requestframe.utils.response.LoginResult;
import mobile.com.requestframe.utils.response.UserData;

/* loaded from: classes3.dex */
public final class m1 implements l5.a {

    /* renamed from: a, reason: collision with root package name */
    public final f5.c f15400a;

    /* renamed from: b, reason: collision with root package name */
    public final i6.d0 f15401b;

    public static final class a extends ha.a {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f15403b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f15404c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ String f15405d;

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ String f15406e;

        /* renamed from: f, reason: collision with root package name */
        public final /* synthetic */ String f15407f;

        /* renamed from: k6.m1$a$a, reason: collision with other inner class name */
        public static final class C0255a extends t9.j implements s9.l {

            /* renamed from: a, reason: collision with root package name */
            public static final C0255a f15408a = new C0255a();

            public C0255a() {
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
            public final /* synthetic */ String f15409a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public b(String str) {
                super(1);
                this.f15409a = str;
            }

            @Override // s9.l
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((String) obj);
                return h9.t.f14242a;
            }

            public final void invoke(String str) {
                com.mobile.brasiltv.utils.f1.f8649a.x(com.mobile.brasiltv.utils.y.p(com.mobile.brasiltv.utils.y.f8771a, this.f15409a, null, null, 6, null));
            }
        }

        public static final class c extends t9.j implements s9.l {

            /* renamed from: a, reason: collision with root package name */
            public static final c f15410a = new c();

            public c() {
                super(1);
            }

            @Override // s9.l
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Intent invoke(Intent intent) {
                t9.i.g(intent, "it");
                intent.putExtra("can_back", false);
                Intent putExtra = intent.putExtra("success_to_main", true);
                t9.i.f(putExtra, "it.putExtra(LoginAty.SUCCESS_TO_MAIN, true)");
                return putExtra;
            }
        }

        public a(String str, String str2, String str3, String str4, String str5) {
            this.f15403b = str;
            this.f15404c = str2;
            this.f15405d = str3;
            this.f15406e = str4;
            this.f15407f = str5;
        }

        @Override // ha.a, io.reactivex.Observer
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void onNext(LoginResult loginResult) {
            String str;
            String str2;
            String str3;
            String str4;
            String str5;
            String areaCode;
            t9.i.g(loginResult, "t");
            UserData data = loginResult.getData();
            if (!com.mobile.brasiltv.utils.b0.I(data != null ? data.getPortalCodeList() : null)) {
                com.mobile.brasiltv.utils.x.f8754a.w(m1.this.l(), C0255a.f15408a);
                return;
            }
            k7.f.e("登录成功 " + loginResult, new Object[0]);
            d6.b bVar = d6.b.f12660a;
            UserData data2 = loginResult.getData();
            t9.i.d(data2);
            bVar.H(data2);
            bVar.E(m1.this.l(), this.f15403b);
            f5.c l10 = m1.this.l();
            UserData data3 = loginResult.getData();
            t9.i.d(data3);
            bVar.F(l10, data3, this.f15404c, this.f15405d, (r21 & 16) != 0 ? "" : null, (r21 & 32) != 0 ? "" : null, (r21 & 64) != 0 ? "" : null, (r21 & 128) != 0);
            str = "";
            if (!TextUtils.isEmpty(this.f15403b)) {
                UserData data4 = loginResult.getData();
                if (t9.i.b(data4 != null ? data4.getPwdTip() : null, "yes")) {
                    UserData data5 = loginResult.getData();
                    if (t9.i.b(data5 != null ? data5.getHasPwd() : null, "1")) {
                        com.mobile.brasiltv.utils.b0.c0(m1.this.l(), ForceChangePwdAty.class);
                        SwitchAccountBean switchAccountBean = new SwitchAccountBean();
                        switchAccountBean.setAccountType(this.f15403b);
                        String str6 = this.f15406e;
                        switchAccountBean.setAreaCode(str6 != null ? str6 : "");
                        switchAccountBean.setUserName(this.f15404c);
                        switchAccountBean.setPassword(this.f15405d);
                        s5.e.f18766a.n(s5.c.QUICK_LOGIN, switchAccountBean, this.f15407f);
                        return;
                    }
                }
            }
            bVar.C(loginResult.getData());
            SwitchAccountBean switchAccountBean2 = new SwitchAccountBean();
            switchAccountBean2.setUserName(this.f15404c);
            switchAccountBean2.setPassword(this.f15405d);
            UserData data6 = loginResult.getData();
            if (data6 == null || (str2 = data6.getUserId()) == null) {
                str2 = "";
            }
            switchAccountBean2.setUserId(str2);
            switchAccountBean2.setAccountType(this.f15403b);
            String str7 = this.f15406e;
            if (str7 == null) {
                str7 = "";
            }
            switchAccountBean2.setAreaCode(str7);
            UserData data7 = loginResult.getData();
            if (data7 == null || (str3 = data7.getVerificationToken()) == null) {
                str3 = "";
            }
            switchAccountBean2.setVerificationToken(str3);
            UserData data8 = loginResult.getData();
            if (data8 == null || (str4 = data8.getEmail()) == null) {
                str4 = "";
            }
            switchAccountBean2.setEmail(str4);
            UserData data9 = loginResult.getData();
            if (data9 == null || (str5 = data9.getMobile()) == null) {
                str5 = "";
            }
            switchAccountBean2.setPhone(str5);
            UserData data10 = loginResult.getData();
            if (data10 != null && (areaCode = data10.getAreaCode()) != null) {
                str = areaCode;
            }
            switchAccountBean2.setAreaCode(str);
            m1.this.n(switchAccountBean2);
            xa.c.c().j(new CloseForcePageEvent());
            com.mobile.brasiltv.utils.b0.c0(m1.this.l(), MainAty.class);
        }

        @Override // ha.a
        public void showErrorHint(String str) {
            t9.i.g(str, "returnCode");
            if (t9.i.b("aaa100094", str)) {
                new NumberLimitDialog(m1.this.l().Q1()).show();
            } else {
                com.mobile.brasiltv.utils.x.f8754a.w(m1.this.l(), new b(str));
                com.mobile.brasiltv.utils.b0.d0(m1.this.l(), LoginAty.class, c.f15410a);
            }
        }
    }

    public static final class b extends t9.j implements s9.l {
        public b() {
            super(1);
        }

        public final void b(SwitchAccountBean switchAccountBean) {
        }

        @Override // s9.l
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            b((SwitchAccountBean) obj);
            return h9.t.f14242a;
        }
    }

    public static final class c extends t9.j implements s9.l {
        public c() {
            super(1);
        }

        public final void invoke(Throwable th) {
        }

        @Override // s9.l
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((Throwable) obj);
            return h9.t.f14242a;
        }
    }

    public m1(f5.c cVar, i6.d0 d0Var) {
        t9.i.g(cVar, "activity");
        t9.i.g(d0Var, "view");
        this.f15400a = cVar;
        this.f15401b = d0Var;
    }

    public static final void o(m1 m1Var, SwitchAccountBean switchAccountBean, ObservableEmitter observableEmitter) {
        t9.i.g(m1Var, "this$0");
        t9.i.g(switchAccountBean, "$account");
        t9.i.g(observableEmitter, "it");
        Context applicationContext = m1Var.f15400a.getApplicationContext();
        t9.i.f(applicationContext, "activity.applicationContext");
        new MobileDao(applicationContext).addAccount(switchAccountBean);
        observableEmitter.onNext(switchAccountBean);
        observableEmitter.onComplete();
    }

    public static final void p(s9.l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    public static final void q(s9.l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    @Override // l5.a
    public void e() {
    }

    @Override // l5.a
    public void g() {
    }

    public final f5.c l() {
        return this.f15400a;
    }

    public void m(String str, String str2, String str3, String str4, String str5, boolean z10) {
        Observable W1;
        t9.i.g(str, "userName");
        t9.i.g(str2, "password");
        t9.i.g(str3, "accountTypes");
        W1 = w6.i.f19214g.b().W1(str3, str4, str, str2, str5, null, (r17 & 64) != 0 ? null : null);
        W1.compose(this.f15400a.O1()).subscribe(new a(str3, str, str2, str4, str5));
    }

    public final void n(final SwitchAccountBean switchAccountBean) {
        Observable compose = Observable.create(new ObservableOnSubscribe() { // from class: k6.j1
            @Override // io.reactivex.ObservableOnSubscribe
            public final void subscribe(ObservableEmitter observableEmitter) {
                m1.o(m1.this, switchAccountBean, observableEmitter);
            }
        }).compose(ma.q.b());
        final b bVar = new b();
        Consumer consumer = new Consumer() { // from class: k6.k1
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                m1.p(s9.l.this, obj);
            }
        };
        final c cVar = new c();
        compose.subscribe(consumer, new Consumer() { // from class: k6.l1
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                m1.q(s9.l.this, obj);
            }
        });
    }
}
