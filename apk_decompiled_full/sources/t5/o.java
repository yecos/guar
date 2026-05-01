package t5;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.mobile.brasiltv.db.MobileDao;
import com.mobile.brasiltv.db.SwitchAccountBean;
import com.mobile.brasiltv.mine.activity.ForceChangePwdAty;
import com.mobile.brasiltv.utils.b0;
import com.mobile.brasiltv.utils.f1;
import com.mobile.brasiltv.utils.x;
import com.mobile.brasiltv.utils.y;
import h9.t;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.functions.Consumer;
import ma.q;
import mobile.com.requestframe.utils.bean.LoginThirdPartBean;
import mobile.com.requestframe.utils.response.LoginResult;
import mobile.com.requestframe.utils.response.UserData;

/* loaded from: classes3.dex */
public final class o implements t5.a {

    /* renamed from: a, reason: collision with root package name */
    public s5.b f18898a;

    /* renamed from: b, reason: collision with root package name */
    public t5.a f18899b;

    public static final class a extends t9.j implements s9.l {
        public a() {
            super(1);
        }

        public final void b(SwitchAccountBean switchAccountBean) {
            b0.U(o.this, "增加账号记录成功！");
        }

        @Override // s9.l
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            b((SwitchAccountBean) obj);
            return t.f14242a;
        }
    }

    public static final class b extends t9.j implements s9.l {
        public b() {
            super(1);
        }

        @Override // s9.l
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((Throwable) obj);
            return t.f14242a;
        }

        public final void invoke(Throwable th) {
            b0.U(o.this, "增加账号记录失败！");
        }
    }

    public static final class c extends ha.a {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ u8.a f18903b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ s5.e f18904c;

        public static final class a extends t9.j implements s9.l {

            /* renamed from: a, reason: collision with root package name */
            public static final a f18905a = new a();

            public a() {
                super(1);
            }

            @Override // s9.l
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((String) obj);
                return t.f14242a;
            }

            public final void invoke(String str) {
                f1.f8649a.x(y.p(y.f8771a, "CUSTOM_NO_ASSOCIATED_PORTAL", null, null, 6, null));
            }
        }

        public static final class b extends t9.j implements s9.l {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ String f18906a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public b(String str) {
                super(1);
                this.f18906a = str;
            }

            @Override // s9.l
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((String) obj);
                return t.f14242a;
            }

            public final void invoke(String str) {
                f1.f8649a.x(y.p(y.f8771a, this.f18906a, null, null, 6, null));
            }
        }

        public c(u8.a aVar, s5.e eVar) {
            this.f18903b = aVar;
            this.f18904c = eVar;
        }

        @Override // ha.a, io.reactivex.Observer
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void onNext(LoginResult loginResult) {
            String str;
            String str2;
            String str3;
            String str4;
            String str5;
            String str6;
            String str7;
            String a10;
            t9.i.g(loginResult, "t");
            o.this.c(this.f18903b, this.f18904c);
            UserData data = loginResult.getData();
            if (!b0.I(data != null ? data.getPortalCodeList() : null)) {
                x.f8754a.w(this.f18903b, a.f18905a);
                s5.b bVar = o.this.f18898a;
                if (bVar != null) {
                    bVar.q0("1");
                    return;
                }
                return;
            }
            d6.b bVar2 = d6.b.f12660a;
            UserData data2 = loginResult.getData();
            t9.i.d(data2);
            bVar2.H(data2);
            bVar2.E(this.f18903b, this.f18904c.h());
            u8.a aVar = this.f18903b;
            UserData data3 = loginResult.getData();
            t9.i.d(data3);
            String h10 = this.f18904c.h();
            x7.a f10 = this.f18904c.f();
            bVar2.F(aVar, data3, "", "", (r21 & 16) != 0 ? "" : h10, (r21 & 32) != 0 ? "" : (f10 == null || (a10 = f10.a()) == null) ? "" : a10, (r21 & 64) != 0 ? "" : null, (r21 & 128) != 0);
            if (!TextUtils.isEmpty(this.f18904c.h())) {
                UserData data4 = loginResult.getData();
                if (t9.i.b(data4 != null ? data4.getPwdTip() : null, "yes")) {
                    UserData data5 = loginResult.getData();
                    if (t9.i.b(data5 != null ? data5.getHasPwd() : null, "1")) {
                        this.f18903b.startActivity(new Intent(this.f18903b, (Class<?>) ForceChangePwdAty.class));
                        s5.b bVar3 = o.this.f18898a;
                        if (bVar3 != null) {
                            bVar3.q0("4");
                            return;
                        }
                        return;
                    }
                }
            }
            bVar2.C(loginResult.getData());
            SwitchAccountBean switchAccountBean = new SwitchAccountBean();
            switchAccountBean.setAccountType("google");
            UserData data6 = loginResult.getData();
            if (data6 == null || (str = data6.getGoogleEmail()) == null) {
                str = "";
            }
            switchAccountBean.setUserName(str);
            UserData data7 = loginResult.getData();
            if (data7 == null || (str2 = data7.getEmail()) == null) {
                str2 = "";
            }
            switchAccountBean.setEmail(str2);
            UserData data8 = loginResult.getData();
            if (data8 == null || (str3 = data8.getMobile()) == null) {
                str3 = "";
            }
            switchAccountBean.setPhone(str3);
            UserData data9 = loginResult.getData();
            if (data9 == null || (str4 = data9.getUserId()) == null) {
                str4 = "";
            }
            switchAccountBean.setUserId(str4);
            UserData data10 = loginResult.getData();
            if (data10 == null || (str5 = data10.getGoogleNickName()) == null) {
                str5 = "";
            }
            switchAccountBean.setNickName(str5);
            x7.a f11 = this.f18904c.f();
            if (f11 == null || (str6 = f11.a()) == null) {
                str6 = "";
            }
            switchAccountBean.setAuthCode(str6);
            UserData data11 = loginResult.getData();
            if (data11 == null || (str7 = data11.getAreaCode()) == null) {
                str7 = "";
            }
            switchAccountBean.setAreaCode(str7);
            switchAccountBean.setLogged(true);
            o.this.j(this.f18903b, switchAccountBean);
            s5.b bVar4 = o.this.f18898a;
            if (bVar4 != null) {
                bVar4.q0("0");
            }
        }

        @Override // ha.a
        public void showErrorHint(String str) {
            t9.i.g(str, "returnCode");
            if (t9.i.b("aaa100094", str)) {
                s5.b bVar = o.this.f18898a;
                if (bVar != null) {
                    bVar.q0("2");
                    return;
                }
                return;
            }
            if (t9.i.b("aaa100028", str) || t9.i.b("aaa100027", str)) {
                s5.b bVar2 = o.this.f18898a;
                if (bVar2 != null) {
                    bVar2.q0("3");
                    return;
                }
                return;
            }
            y.f8771a.c(str);
            x.f8754a.w(this.f18903b, new b(str));
            s5.b bVar3 = o.this.f18898a;
            if (bVar3 != null) {
                bVar3.q0("1");
            }
        }
    }

    public static final void k(u8.a aVar, SwitchAccountBean switchAccountBean, ObservableEmitter observableEmitter) {
        t9.i.g(aVar, "$activity");
        t9.i.g(switchAccountBean, "$account");
        t9.i.g(observableEmitter, "it");
        Context applicationContext = aVar.getApplicationContext();
        t9.i.f(applicationContext, "activity.applicationContext");
        new MobileDao(applicationContext).addAccount(switchAccountBean);
        observableEmitter.onNext(switchAccountBean);
        observableEmitter.onComplete();
    }

    public static final void l(s9.l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    public static final void m(s9.l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    @Override // t5.a
    public void a(u8.a aVar, s5.e eVar) {
        t9.i.g(aVar, "activity");
        t9.i.g(eVar, "tmpLoginInfo");
        s5.b bVar = this.f18898a;
        if (bVar != null) {
            bVar.f1();
        }
        n(aVar, eVar);
    }

    @Override // t5.a
    public void b(t5.a aVar) {
        t9.i.g(aVar, "logOutMethod");
        this.f18899b = aVar;
    }

    @Override // t5.a
    public void c(u8.a aVar, s5.e eVar) {
        t5.a aVar2;
        t9.i.g(aVar, "activity");
        t9.i.g(eVar, "tmpLoginInfo");
        if (!eVar.d() || (aVar2 = this.f18899b) == null) {
            return;
        }
        aVar2.c(aVar, eVar);
    }

    @Override // t5.a
    public void d(s5.b bVar) {
        t9.i.g(bVar, "callback");
        this.f18898a = bVar;
    }

    public final void j(final u8.a aVar, final SwitchAccountBean switchAccountBean) {
        Observable compose = Observable.create(new ObservableOnSubscribe() { // from class: t5.l
            @Override // io.reactivex.ObservableOnSubscribe
            public final void subscribe(ObservableEmitter observableEmitter) {
                o.k(u8.a.this, switchAccountBean, observableEmitter);
            }
        }).compose(q.b());
        final a aVar2 = new a();
        Consumer consumer = new Consumer() { // from class: t5.m
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                o.l(s9.l.this, obj);
            }
        };
        final b bVar = new b();
        compose.subscribe(consumer, new Consumer() { // from class: t5.n
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                o.m(s9.l.this, obj);
            }
        });
    }

    public final void n(u8.a aVar, s5.e eVar) {
        String str;
        w6.i b10 = w6.i.f19214g.b();
        String h10 = eVar.h();
        x7.a f10 = eVar.f();
        if (f10 == null || (str = f10.a()) == null) {
            str = "";
        }
        b10.Z1(new LoginThirdPartBean(h10, str, eVar.b(), eVar.j(), eVar.i())).compose(aVar.O1()).subscribe(new c(aVar, eVar));
    }
}
