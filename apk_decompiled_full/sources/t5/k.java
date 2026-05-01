package t5;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.mobile.brasiltv.bean.event.LoginSuccessEvent;
import com.mobile.brasiltv.bean.event.RequestAuthAndSlbEvent;
import com.mobile.brasiltv.bean.event.UpdateMineViewEvent;
import com.mobile.brasiltv.bean.event.UpdateRestrictEvent;
import com.mobile.brasiltv.bean.event.UserIdentityChangeEvent;
import com.mobile.brasiltv.db.MobileDao;
import com.mobile.brasiltv.db.SwitchAccountBean;
import com.mobile.brasiltv.mine.activity.ForceChangePwdAty;
import com.mobile.brasiltv.utils.b0;
import com.mobile.brasiltv.utils.f1;
import com.mobile.brasiltv.utils.x;
import com.mobile.brasiltv.utils.y;
import com.taobao.accs.common.Constants;
import h9.t;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.ObservableSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import java.util.List;
import java.util.concurrent.TimeUnit;
import ma.q;
import mobile.com.requestframe.utils.response.GetQrData;
import mobile.com.requestframe.utils.response.GetQrResult;
import mobile.com.requestframe.utils.response.PortalCodeList;
import mobile.com.requestframe.utils.response.UserData;
import w6.i;

/* loaded from: classes3.dex */
public final class k implements t5.a {

    /* renamed from: a, reason: collision with root package name */
    public Disposable f18883a;

    /* renamed from: b, reason: collision with root package name */
    public s5.b f18884b;

    /* renamed from: c, reason: collision with root package name */
    public t5.a f18885c;

    public static final class a extends t9.j implements s9.l {
        public a() {
            super(1);
        }

        public final void b(SwitchAccountBean switchAccountBean) {
            b0.U(k.this, "增加账号记录成功！");
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
            b0.U(k.this, "增加账号记录失败！");
        }
    }

    public static final class c extends t9.j implements s9.l {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ s5.e f18888a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(s5.e eVar) {
            super(1);
            this.f18888a = eVar;
        }

        @Override // s9.l
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final ObservableSource invoke(Long l10) {
            t9.i.g(l10, "it");
            return w6.i.f19214g.b().e2(this.f18888a.e());
        }
    }

    public static final class d extends ha.a {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ u8.a f18890b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ s5.e f18891c;

        public static final class a extends t9.j implements s9.l {

            /* renamed from: a, reason: collision with root package name */
            public static final a f18892a = new a();

            public a() {
                super(1);
            }

            @Override // s9.l
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((String) obj);
                return t.f14242a;
            }

            public final void invoke(String str) {
                f1.f8649a.u(y.p(y.f8771a, "CUSTOM_NO_ASSOCIATED_PORTAL", null, null, 6, null));
            }
        }

        public static final class b extends t9.j implements s9.l {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ String f18893a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public b(String str) {
                super(1);
                this.f18893a = str;
            }

            @Override // s9.l
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((String) obj);
                return t.f14242a;
            }

            public final void invoke(String str) {
                y yVar = y.f8771a;
                String p10 = y.p(yVar, this.f18893a, null, null, 6, null);
                yVar.c(this.f18893a);
                f1.f8649a.x(p10);
            }
        }

        public d(u8.a aVar, s5.e eVar) {
            this.f18890b = aVar;
            this.f18891c = eVar;
        }

        /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
        @Override // ha.a, io.reactivex.Observer
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void onNext(GetQrResult getQrResult) {
            t9.i.g(getQrResult, "t");
            GetQrData data = getQrResult.getData();
            String status = data != null ? data.getStatus() : null;
            if (status != null) {
                switch (status.hashCode()) {
                    case 49:
                        if (status.equals("1")) {
                            return;
                        }
                        break;
                    case 50:
                        if (status.equals("2")) {
                            k.this.q(this.f18890b, this.f18891c);
                            return;
                        }
                        break;
                    case 51:
                        if (status.equals("3")) {
                            GetQrData data2 = getQrResult.getData();
                            t9.i.d(data2);
                            if (data2.getUserInfo() != null) {
                                GetQrData data3 = getQrResult.getData();
                                t9.i.d(data3);
                                UserData userInfo = data3.getUserInfo();
                                t9.i.d(userInfo);
                                List<PortalCodeList> portalCodeList = userInfo.getPortalCodeList();
                                if (!(portalCodeList == null || portalCodeList.isEmpty())) {
                                    k.this.c(this.f18890b, this.f18891c);
                                    k kVar = k.this;
                                    u8.a aVar = this.f18890b;
                                    GetQrData data4 = getQrResult.getData();
                                    t9.i.d(data4);
                                    UserData userInfo2 = data4.getUserInfo();
                                    t9.i.d(userInfo2);
                                    GetQrData data5 = getQrResult.getData();
                                    t9.i.d(data5);
                                    String qrAuthCodeToken = data5.getQrAuthCodeToken();
                                    if (qrAuthCodeToken == null) {
                                        qrAuthCodeToken = "";
                                    }
                                    kVar.l(aVar, userInfo2, qrAuthCodeToken);
                                    xa.c.c().j(new UserIdentityChangeEvent());
                                    s5.b bVar = k.this.f18884b;
                                    if (bVar != null) {
                                        bVar.q0("0");
                                        return;
                                    }
                                    return;
                                }
                            }
                            x.f8754a.w(this.f18890b, a.f18892a);
                            return;
                        }
                        break;
                }
            }
            s5.b bVar2 = k.this.f18884b;
            if (bVar2 != null) {
                bVar2.q0("1");
            }
        }

        @Override // ha.a, io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            t9.i.g(disposable, "d");
            super.onSubscribe(disposable);
            k.this.f18883a = disposable;
        }

        @Override // ha.a
        public void showErrorHint(String str) {
            t9.i.g(str, "returnCode");
            if (t9.i.b("aaa100094", str)) {
                s5.b bVar = k.this.f18884b;
                if (bVar != null) {
                    bVar.q0("2");
                    return;
                }
                return;
            }
            if (t9.i.b("aaa100028", str) || t9.i.b("aaa100027", str)) {
                s5.b bVar2 = k.this.f18884b;
                if (bVar2 != null) {
                    bVar2.q0("3");
                    return;
                }
                return;
            }
            x.f8754a.w(this.f18890b, new b(str));
            s5.b bVar3 = k.this.f18884b;
            if (bVar3 != null) {
                bVar3.q0("1");
            }
        }
    }

    public static final void n(u8.a aVar, SwitchAccountBean switchAccountBean, ObservableEmitter observableEmitter) {
        t9.i.g(aVar, "$activity");
        t9.i.g(switchAccountBean, "$account");
        t9.i.g(observableEmitter, "it");
        Context applicationContext = aVar.getApplicationContext();
        t9.i.f(applicationContext, "activity.applicationContext");
        new MobileDao(applicationContext).addAccount(switchAccountBean);
        observableEmitter.onNext(switchAccountBean);
        observableEmitter.onComplete();
    }

    public static final void o(s9.l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    public static final void p(s9.l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    public static final ObservableSource r(s9.l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        return (ObservableSource) lVar.invoke(obj);
    }

    @Override // t5.a
    public void a(u8.a aVar, s5.e eVar) {
        t9.i.g(aVar, "activity");
        t9.i.g(eVar, "tmpLoginInfo");
        s5.b bVar = this.f18884b;
        if (bVar != null) {
            bVar.f1();
        }
        q(aVar, eVar);
    }

    @Override // t5.a
    public void b(t5.a aVar) {
        t9.i.g(aVar, "logOutMethod");
        this.f18885c = aVar;
    }

    @Override // t5.a
    public void c(u8.a aVar, s5.e eVar) {
        t5.a aVar2;
        t9.i.g(aVar, "activity");
        t9.i.g(eVar, "tmpLoginInfo");
        if (!eVar.d() || (aVar2 = this.f18885c) == null) {
            return;
        }
        aVar2.c(aVar, eVar);
    }

    @Override // t5.a
    public void d(s5.b bVar) {
        t9.i.g(bVar, "callback");
        this.f18884b = bVar;
    }

    public final void l(u8.a aVar, UserData userData, String str) {
        t9.i.g(aVar, "activity");
        t9.i.g(userData, Constants.KEY_USER_ID);
        t9.i.g(str, "qrAuthCode");
        d6.b bVar = d6.b.f12660a;
        bVar.E(aVar, "7");
        i.c cVar = w6.i.f19214g;
        if (!t9.i.b(cVar.A(), "") && !t9.i.b(userData.getRestrictedStatus(), cVar.A())) {
            xa.c.c().m(new UpdateRestrictEvent(userData.getRestrictedStatus(), false, 2, null));
        }
        bVar.F(aVar, userData, "", "", (r21 & 16) != 0 ? "" : null, (r21 & 32) != 0 ? "" : null, (r21 & 64) != 0 ? "" : str, (r21 & 128) != 0);
        if (!TextUtils.isEmpty("7") && t9.i.b(userData.getPwdTip(), "yes") && t9.i.b(userData.getHasPwd(), "1")) {
            aVar.startActivity(new Intent(aVar, (Class<?>) ForceChangePwdAty.class));
            s5.b bVar2 = this.f18884b;
            if (bVar2 != null) {
                bVar2.q0("4");
                return;
            }
            return;
        }
        xa.c.c().j(new LoginSuccessEvent(null, 1, null));
        xa.c.c().m(new UpdateMineViewEvent());
        xa.c.c().m(new RequestAuthAndSlbEvent(false, null, 3, null));
        SwitchAccountBean switchAccountBean = new SwitchAccountBean();
        switchAccountBean.setUserName(userData.getUserId());
        switchAccountBean.setUserId(userData.getUserId());
        switchAccountBean.setQrAuthCode(str);
        switchAccountBean.setAccountType("7");
        String areaCode = userData.getAreaCode();
        if (areaCode == null) {
            areaCode = "";
        }
        switchAccountBean.setAreaCode(areaCode);
        String email = userData.getEmail();
        if (email == null) {
            email = "";
        }
        switchAccountBean.setEmail(email);
        String mobile2 = userData.getMobile();
        if (mobile2 == null) {
            mobile2 = "";
        }
        switchAccountBean.setPhone(mobile2);
        switchAccountBean.setLogged(true);
        m(aVar, switchAccountBean);
    }

    public final void m(final u8.a aVar, final SwitchAccountBean switchAccountBean) {
        Observable compose = Observable.create(new ObservableOnSubscribe() { // from class: t5.h
            @Override // io.reactivex.ObservableOnSubscribe
            public final void subscribe(ObservableEmitter observableEmitter) {
                k.n(u8.a.this, switchAccountBean, observableEmitter);
            }
        }).compose(q.b());
        final a aVar2 = new a();
        Consumer consumer = new Consumer() { // from class: t5.i
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                k.o(s9.l.this, obj);
            }
        };
        final b bVar = new b();
        compose.subscribe(consumer, new Consumer() { // from class: t5.j
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                k.p(s9.l.this, obj);
            }
        });
    }

    public final void q(u8.a aVar, s5.e eVar) {
        Disposable disposable = this.f18883a;
        if (disposable != null) {
            disposable.dispose();
        }
        Observable<Long> timer = Observable.timer(1L, TimeUnit.SECONDS);
        final c cVar = new c(eVar);
        timer.flatMap(new Function() { // from class: t5.g
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                ObservableSource r10;
                r10 = k.r(s9.l.this, obj);
                return r10;
            }
        }).compose(aVar.O1()).subscribe(new d(aVar, eVar));
    }
}
