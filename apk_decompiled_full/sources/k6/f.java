package k6;

import android.content.Context;
import android.text.TextUtils;
import com.mobile.brasiltv.activity.MainAty;
import com.mobile.brasiltv.bean.event.CloseForcePageEvent;
import com.mobile.brasiltv.bean.event.GotoHomeTabEvent;
import com.mobile.brasiltv.bean.event.LoginSuccessEvent;
import com.mobile.brasiltv.bean.event.RequestActiveEvent;
import com.mobile.brasiltv.bean.event.RequestAuthAndSlbEvent;
import com.mobile.brasiltv.bean.event.UpdateMineViewEvent;
import com.mobile.brasiltv.bean.event.UpdateRestrictEvent;
import com.mobile.brasiltv.bean.event.UserIdentityChangeEvent;
import com.mobile.brasiltv.db.MobileDao;
import com.mobile.brasiltv.db.SwitchAccountBean;
import com.mobile.brasiltv.mine.activity.ForceChangePwdAty;
import com.mobile.brasiltv.mine.activity.LoginAty;
import com.mobile.brasiltv.view.dialog.NumberLimitDialog;
import com.msandroid.mobile.R;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import mobile.com.requestframe.utils.bean.BindBean;
import mobile.com.requestframe.utils.bean.LoginThirdPartBean;
import mobile.com.requestframe.utils.bean.UnbindBean;
import mobile.com.requestframe.utils.response.BaseResult;
import mobile.com.requestframe.utils.response.BindThirdPart;
import mobile.com.requestframe.utils.response.BindThirdPartResult;
import mobile.com.requestframe.utils.response.LoginResult;
import mobile.com.requestframe.utils.response.UserBindData;
import mobile.com.requestframe.utils.response.UserBindResult;
import mobile.com.requestframe.utils.response.UserData;
import w6.i;

/* loaded from: classes3.dex */
public final class f implements i6.d {

    /* renamed from: a, reason: collision with root package name */
    public final f5.c f15147a;

    /* renamed from: b, reason: collision with root package name */
    public final i6.e f15148b;

    public static final class a extends ha.a {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f15150b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ x7.a f15151c;

        /* renamed from: k6.f$a$a, reason: collision with other inner class name */
        public static final class C0250a extends t9.j implements s9.l {

            /* renamed from: a, reason: collision with root package name */
            public static final C0250a f15152a = new C0250a();

            public C0250a() {
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
            public final /* synthetic */ String f15153a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public b(String str) {
                super(1);
                this.f15153a = str;
            }

            @Override // s9.l
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((String) obj);
                return h9.t.f14242a;
            }

            public final void invoke(String str) {
                com.mobile.brasiltv.utils.f1.f8649a.x(com.mobile.brasiltv.utils.y.p(com.mobile.brasiltv.utils.y.f8771a, this.f15153a, null, null, 6, null));
            }
        }

        public a(String str, x7.a aVar) {
            this.f15150b = str;
            this.f15151c = aVar;
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
            f.this.q().showLoading(false);
            f.this.q().q();
            UserData data = loginResult.getData();
            if (!com.mobile.brasiltv.utils.b0.I(data != null ? data.getPortalCodeList() : null)) {
                com.mobile.brasiltv.utils.x.f8754a.w(f.this.p(), C0250a.f15152a);
                return;
            }
            i.c cVar = w6.i.f19214g;
            String str6 = "";
            if (!t9.i.b(cVar.A(), "")) {
                UserData data2 = loginResult.getData();
                t9.i.d(data2);
                if (!t9.i.b(data2.getRestrictedStatus(), cVar.A())) {
                    xa.c c10 = xa.c.c();
                    UserData data3 = loginResult.getData();
                    t9.i.d(data3);
                    c10.m(new UpdateRestrictEvent(data3.getRestrictedStatus(), false, 2, null));
                }
            }
            d6.b bVar = d6.b.f12660a;
            bVar.E(f.this.p(), this.f15150b);
            f5.c p10 = f.this.p();
            UserData data4 = loginResult.getData();
            t9.i.d(data4);
            bVar.F(p10, data4, "", "", (r21 & 16) != 0 ? "" : this.f15150b, (r21 & 32) != 0 ? "" : this.f15151c.a(), (r21 & 64) != 0 ? "" : null, (r21 & 128) != 0);
            if (!TextUtils.isEmpty(this.f15150b)) {
                UserData data5 = loginResult.getData();
                if (t9.i.b(data5 != null ? data5.getPwdTip() : null, "yes")) {
                    UserData data6 = loginResult.getData();
                    if (t9.i.b(data6 != null ? data6.getHasPwd() : null, "1")) {
                        com.mobile.brasiltv.utils.b0.c0(f.this.p(), ForceChangePwdAty.class);
                        s5.e.f18766a.o(s5.c.THIRD_PART_LOGIN, this.f15150b, this.f15151c, "0", "2", null);
                        return;
                    }
                }
            }
            xa.c c11 = xa.c.c();
            UserData data7 = loginResult.getData();
            c11.j(new LoginSuccessEvent(data7 != null ? data7.getHeartBeatTime() : null));
            xa.c.c().j(new UserIdentityChangeEvent());
            xa.c.c().m(new UpdateMineViewEvent());
            xa.c.c().m(new RequestAuthAndSlbEvent(false, loginResult.getData()));
            SwitchAccountBean switchAccountBean = new SwitchAccountBean();
            switchAccountBean.setAccountType("google");
            UserData data8 = loginResult.getData();
            if (data8 == null || (str = data8.getGoogleEmail()) == null) {
                str = "";
            }
            switchAccountBean.setUserName(str);
            UserData data9 = loginResult.getData();
            if (data9 == null || (str2 = data9.getEmail()) == null) {
                str2 = "";
            }
            switchAccountBean.setEmail(str2);
            UserData data10 = loginResult.getData();
            if (data10 == null || (str3 = data10.getMobile()) == null) {
                str3 = "";
            }
            switchAccountBean.setPhone(str3);
            UserData data11 = loginResult.getData();
            if (data11 == null || (str4 = data11.getUserId()) == null) {
                str4 = "";
            }
            switchAccountBean.setUserId(str4);
            UserData data12 = loginResult.getData();
            if (data12 == null || (str5 = data12.getGoogleNickName()) == null) {
                str5 = "";
            }
            switchAccountBean.setNickName(str5);
            switchAccountBean.setAuthCode(this.f15151c.a());
            UserData data13 = loginResult.getData();
            if (data13 != null && (areaCode = data13.getAreaCode()) != null) {
                str6 = areaCode;
            }
            switchAccountBean.setAreaCode(str6);
            f.this.u(switchAccountBean);
            xa.c.c().j(new CloseForcePageEvent());
            xa.c.c().j(new GotoHomeTabEvent(0));
            com.mobile.brasiltv.utils.b0.c0(f.this.p(), MainAty.class);
        }

        @Override // ha.a
        public void showErrorHint(String str) {
            t9.i.g(str, "returnCode");
            f.this.q().showLoading(false);
            f.this.q().q();
            if (t9.i.b("aaa100094", str)) {
                new NumberLimitDialog(f.this.p()).show();
            } else {
                com.mobile.brasiltv.utils.x.f8754a.w(f.this.p(), new b(str));
            }
        }
    }

    public static final class b extends ha.a {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f15155b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ x7.a f15156c;

        public static final class a extends t9.j implements s9.l {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ String f15157a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(String str) {
                super(1);
                this.f15157a = str;
            }

            @Override // s9.l
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((String) obj);
                return h9.t.f14242a;
            }

            public final void invoke(String str) {
                com.mobile.brasiltv.utils.f1.f8649a.x(com.mobile.brasiltv.utils.y.p(com.mobile.brasiltv.utils.y.f8771a, this.f15157a, null, null, 6, null));
            }
        }

        public b(String str, x7.a aVar) {
            this.f15155b = str;
            this.f15156c = aVar;
        }

        @Override // ha.a, io.reactivex.Observer
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void onNext(BindThirdPartResult bindThirdPartResult) {
            String str;
            String googlePhotoUrl;
            t9.i.g(bindThirdPartResult, "t");
            if (d6.b.f12660a.t()) {
                f.this.m(this.f15155b, this.f15156c);
                return;
            }
            f.this.q().showLoading(false);
            f.this.q().q();
            i.c cVar = w6.i.f19214g;
            cVar.U("2");
            BindThirdPart data = bindThirdPartResult.getData();
            String str2 = "";
            if (data == null || (str = data.getGoogleNickName()) == null) {
                str = "";
            }
            cVar.d0(str);
            BindThirdPart data2 = bindThirdPartResult.getData();
            if (data2 != null && (googlePhotoUrl = data2.getGooglePhotoUrl()) != null) {
                str2 = googlePhotoUrl;
            }
            cVar.e0(str2);
            xa.c.c().m(new UpdateMineViewEvent());
            f.this.q().M();
        }

        @Override // ha.a, io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            t9.i.g(disposable, "d");
            super.onSubscribe(disposable);
            f.this.q().showLoading(true);
        }

        @Override // ha.a
        public void showErrorHint(String str) {
            t9.i.g(str, "returnCode");
            f.this.q().showLoading(false);
            f.this.q().q();
            if (com.mobile.brasiltv.utils.b0.T(str, "portal100076")) {
                f.this.q().n(R.string.am_google_been_bound);
            } else {
                com.mobile.brasiltv.utils.x.f8754a.w(f.this.p(), new a(str));
            }
        }
    }

    public static final class c extends ha.a {

        public static final class a extends t9.j implements s9.l {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ String f15159a;

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ t9.w f15160b;

            /* renamed from: c, reason: collision with root package name */
            public final /* synthetic */ f f15161c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(String str, t9.w wVar, f fVar) {
                super(1);
                this.f15159a = str;
                this.f15160b = wVar;
                this.f15161c = fVar;
            }

            @Override // s9.l
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((String) obj);
                return h9.t.f14242a;
            }

            public final void invoke(String str) {
                String p10 = com.mobile.brasiltv.utils.y.p(com.mobile.brasiltv.utils.y.f8771a, this.f15159a, null, null, 6, null);
                if (t9.i.b(this.f15160b.f18961a, "no_report_type") && t9.i.b(this.f15159a, "portal100060")) {
                    p10 = this.f15161c.p().getResources().getString(R.string.frequent_operation);
                    t9.i.f(p10, "context.resources.getStr…tring.frequent_operation)");
                }
                com.mobile.brasiltv.utils.f1.f8649a.x(p10);
            }
        }

        public c() {
        }

        @Override // ha.a, io.reactivex.Observer
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void onNext(UserBindResult userBindResult) {
            t9.i.g(userBindResult, "t");
            f.this.t(userBindResult);
            f.this.q().showLoading(false);
            f.this.q().X1(userBindResult);
            f.this.q().u2();
        }

        @Override // ha.a, io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            t9.i.g(disposable, "d");
            super.onSubscribe(disposable);
            f.this.q().showLoading(true);
        }

        @Override // ha.a
        public void showErrorHint(String str) {
            t9.i.g(str, "returnCode");
            f.this.q().showLoading(false);
            t9.w wVar = new t9.w();
            wVar.f18961a = com.mobile.brasiltv.utils.y.f8771a.c(str);
            com.mobile.brasiltv.utils.x.f8754a.w(f.this.p(), new a(str, wVar, f.this));
        }
    }

    public static final class d extends ha.a {

        public static final class a extends t9.j implements s9.l {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ String f15163a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(String str) {
                super(1);
                this.f15163a = str;
            }

            @Override // s9.l
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((String) obj);
                return h9.t.f14242a;
            }

            public final void invoke(String str) {
                com.mobile.brasiltv.utils.f1.f8649a.x(com.mobile.brasiltv.utils.y.p(com.mobile.brasiltv.utils.y.f8771a, this.f15163a, null, null, 6, null));
            }
        }

        public d() {
        }

        @Override // ha.a, io.reactivex.Observer
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void onNext(LoginResult loginResult) {
            t9.i.g(loginResult, "t");
            k7.f.e("登出成功", new Object[0]);
            f.this.q().showLoading(false);
            f.this.q().t(false);
            d6.b.f12660a.e(f.this.p());
            xa.c.c().j(new UserIdentityChangeEvent());
            xa.c.c().j(new RequestActiveEvent());
            f.this.q().U0();
        }

        @Override // ha.a, io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            t9.i.g(disposable, "d");
            super.onSubscribe(disposable);
            f.this.q().showLoading(true);
            f.this.q().t(true);
        }

        @Override // ha.a
        public void showErrorHint(String str) {
            t9.i.g(str, "returnCode");
            f.this.q().showLoading(false);
            f.this.q().t(false);
            com.mobile.brasiltv.utils.x.f8754a.w(f.this.p(), new a(str));
        }
    }

    public static final class e extends ha.a {

        public static final class a extends t9.j implements s9.l {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ String f15165a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(String str) {
                super(1);
                this.f15165a = str;
            }

            @Override // s9.l
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((String) obj);
                return h9.t.f14242a;
            }

            public final void invoke(String str) {
                com.mobile.brasiltv.utils.f1.f8649a.x(com.mobile.brasiltv.utils.y.p(com.mobile.brasiltv.utils.y.f8771a, this.f15165a, null, null, 6, null));
            }
        }

        public e() {
        }

        @Override // ha.a, io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            t9.i.g(disposable, "d");
            super.onSubscribe(disposable);
            f.this.q().showLoading(true);
            f.this.q().t(true);
        }

        @Override // ha.a
        public void showErrorHint(String str) {
            t9.i.g(str, "returnCode");
            f.this.q().showLoading(false);
            f.this.q().t(false);
            com.mobile.brasiltv.utils.x.f8754a.w(f.this.p(), new a(str));
        }

        @Override // ha.a, io.reactivex.Observer
        public void onNext(BaseResult baseResult) {
            t9.i.g(baseResult, "t");
            f.this.q().showLoading(false);
            f.this.q().t(false);
            d6.b.f12660a.e(f.this.p());
            xa.c.c().j(new UserIdentityChangeEvent());
            xa.c.c().j(new RequestActiveEvent());
            f.this.q().U0();
        }
    }

    /* renamed from: k6.f$f, reason: collision with other inner class name */
    public static final class C0251f extends t9.j implements s9.l {
        public C0251f() {
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

    public static final class g extends t9.j implements s9.l {
        public g() {
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

    public static final class h extends ha.a {

        public static final class a extends t9.j implements s9.l {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ String f15169a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(String str) {
                super(1);
                this.f15169a = str;
            }

            @Override // s9.l
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((String) obj);
                return h9.t.f14242a;
            }

            public final void invoke(String str) {
                com.mobile.brasiltv.utils.f1.f8649a.x(com.mobile.brasiltv.utils.y.p(com.mobile.brasiltv.utils.y.f8771a, this.f15169a, null, null, 6, null));
            }
        }

        public h() {
        }

        @Override // ha.a, io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            t9.i.g(disposable, "d");
            super.onSubscribe(disposable);
            f.this.q().showLoading(true);
        }

        @Override // ha.a
        public void showErrorHint(String str) {
            t9.i.g(str, "returnCode");
            f.this.q().showLoading(false);
            if (com.mobile.brasiltv.utils.b0.T(str, "aaa100012")) {
                f.this.q().r2(R.string.pwd_wrong);
                return;
            }
            if (com.mobile.brasiltv.utils.b0.T(str, "50010") || com.mobile.brasiltv.utils.b0.T(str, "50011") || com.mobile.brasiltv.utils.b0.T(str, "50012") || com.mobile.brasiltv.utils.b0.T(str, "50014")) {
                f.this.q().r2(R.string.pi_connect_timeout);
            } else {
                com.mobile.brasiltv.utils.x.f8754a.w(f.this.p(), new a(str));
            }
        }

        @Override // ha.a, io.reactivex.Observer
        public void onNext(BaseResult baseResult) {
            t9.i.g(baseResult, "t");
            f.this.q().showLoading(false);
            d6.b bVar = d6.b.f12660a;
            if (bVar.s(f.this.p(), "google")) {
                bVar.E(f.this.p(), "");
                bVar.I(f.this.p(), "", "");
                LoginAty.C.a(f.this.p(), false, true);
                return;
            }
            i.c cVar = w6.i.f19214g;
            cVar.U("1");
            cVar.d0("");
            cVar.e0("");
            xa.c.c().m(new UpdateMineViewEvent());
            f.this.q().M();
            f.this.q().O();
        }
    }

    public f(f5.c cVar, i6.e eVar) {
        t9.i.g(cVar, com.umeng.analytics.pro.f.X);
        t9.i.g(eVar, "view");
        this.f15147a = cVar;
        this.f15148b = eVar;
        eVar.Y0(this);
    }

    public static final void v(f fVar, SwitchAccountBean switchAccountBean, ObservableEmitter observableEmitter) {
        t9.i.g(fVar, "this$0");
        t9.i.g(switchAccountBean, "$account");
        t9.i.g(observableEmitter, "it");
        Context applicationContext = fVar.f15147a.getApplicationContext();
        t9.i.f(applicationContext, "context.applicationContext");
        new MobileDao(applicationContext).addAccount(switchAccountBean);
        observableEmitter.onNext(switchAccountBean);
        observableEmitter.onComplete();
    }

    public static final void w(s9.l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    public static final void x(s9.l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    @Override // l5.a
    public void e() {
    }

    @Override // l5.a
    public void g() {
    }

    public final void m(String str, x7.a aVar) {
        w6.i.f19214g.b().Z1(new LoginThirdPartBean(str, aVar.a(), "0", "2", null, 16, null)).compose(this.f15147a.O1()).subscribe(new a(str, aVar));
    }

    public void n(String str, x7.a aVar) {
        t9.i.g(str, "thirdPartType");
        t9.i.g(aVar, "socialInfo");
        i.c cVar = w6.i.f19214g;
        cVar.b().R0(new BindBean(cVar.H(), cVar.J(), cVar.v(), str, aVar.a())).compose(this.f15147a.O1()).subscribe(new b(str, aVar));
    }

    public void o() {
        w6.i.f19214g.b().e1().compose(this.f15147a.O1()).subscribe(new c());
    }

    public final f5.c p() {
        return this.f15147a;
    }

    public final i6.e q() {
        return this.f15148b;
    }

    public final void r(String str, String str2) {
        Observable W1;
        W1 = w6.i.f19214g.b().W1(d6.b.f12660a.j(this.f15147a), na.f.e(this.f15147a, "login_area_code"), str, str2, null, "0", (r17 & 64) != 0 ? null : null);
        W1.compose(this.f15147a.O1()).subscribe(new d());
    }

    public final void s() {
        w6.i.f19214g.b().b2().compose(this.f15147a.O1()).subscribe(new e());
    }

    public final void t(UserBindResult userBindResult) {
        String str;
        String str2;
        String str3;
        String str4;
        UserBindData data;
        String areaCode;
        UserBindData data2;
        UserBindData data3;
        UserBindData data4;
        UserBindData data5;
        i.c cVar = w6.i.f19214g;
        String str5 = "";
        if (userBindResult == null || (data5 = userBindResult.getData()) == null || (str = data5.getBindMail()) == null) {
            str = "";
        }
        cVar.T(str);
        if (userBindResult == null || (data4 = userBindResult.getData()) == null || (str2 = data4.getEmail()) == null) {
            str2 = "";
        }
        cVar.b0(str2);
        if (userBindResult == null || (data3 = userBindResult.getData()) == null || (str3 = data3.getBindMobile()) == null) {
            str3 = "";
        }
        cVar.V(str3);
        if (userBindResult == null || (data2 = userBindResult.getData()) == null || (str4 = data2.getMobile()) == null) {
            str4 = "";
        }
        cVar.j0(str4);
        if (userBindResult != null && (data = userBindResult.getData()) != null && (areaCode = data.getAreaCode()) != null) {
            str5 = areaCode;
        }
        cVar.R(str5);
    }

    public final void u(final SwitchAccountBean switchAccountBean) {
        Observable compose = Observable.create(new ObservableOnSubscribe() { // from class: k6.c
            @Override // io.reactivex.ObservableOnSubscribe
            public final void subscribe(ObservableEmitter observableEmitter) {
                f.v(f.this, switchAccountBean, observableEmitter);
            }
        }).compose(ma.q.b());
        final C0251f c0251f = new C0251f();
        Consumer consumer = new Consumer() { // from class: k6.d
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                f.w(s9.l.this, obj);
            }
        };
        final g gVar = new g();
        compose.subscribe(consumer, new Consumer() { // from class: k6.e
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                f.x(s9.l.this, obj);
            }
        });
    }

    public void y(String str, String str2, String str3) {
        t9.i.g(str, "userName");
        t9.i.g(str2, "password");
        t9.i.g(str3, "type");
        d6.b bVar = d6.b.f12660a;
        if (bVar.u(this.f15147a)) {
            s();
        } else if (bVar.v(this.f15147a)) {
            s();
        } else {
            r(str, str2);
        }
    }

    public void z(String str) {
        t9.i.g(str, "pwd");
        i.c cVar = w6.i.f19214g;
        w6.i b10 = cVar.b();
        String e10 = ma.m.e(str);
        t9.i.f(e10, "md5(pwd)");
        b10.n2(new UnbindBean(e10, "3", "google", cVar.J(), cVar.H())).compose(this.f15147a.O1()).subscribe(new h());
    }
}
