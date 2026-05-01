package k6;

import android.content.Context;
import android.text.TextUtils;
import com.mobile.brasiltv.activity.MainAty;
import com.mobile.brasiltv.bean.event.CloseForcePageEvent;
import com.mobile.brasiltv.db.MobileDao;
import com.mobile.brasiltv.db.SwitchAccountBean;
import com.mobile.brasiltv.mine.activity.ForceChangePwdAty;
import com.mobile.brasiltv.view.dialog.NumberLimitDialog;
import com.msandroid.mobile.R;
import com.titans.entity.CdnType;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import mobile.com.requestframe.utils.bean.LoginThirdPartBean;
import mobile.com.requestframe.utils.response.BaseResult;
import mobile.com.requestframe.utils.response.LoginResult;
import mobile.com.requestframe.utils.response.UserData;

/* loaded from: classes3.dex */
public final class o implements i6.f {

    /* renamed from: a, reason: collision with root package name */
    public final f5.c f15439a;

    /* renamed from: b, reason: collision with root package name */
    public final i6.g f15440b;

    /* renamed from: c, reason: collision with root package name */
    public final h9.g f15441c;

    /* renamed from: d, reason: collision with root package name */
    public final ArrayList f15442d;

    public static final class a implements Observer {
        public a() {
        }

        @Override // io.reactivex.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onNext(ArrayList arrayList) {
            t9.i.g(arrayList, "list");
            o.this.f15442d.clear();
            o.this.f15442d.addAll(arrayList);
            o.this.u().B1();
            if (!o.this.f15442d.isEmpty()) {
                o.this.u().Z1(o.this.f15442d);
            } else {
                k7.f.c("无账号记录", new Object[0]);
                o.this.u().Z1(o.this.f15442d);
            }
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            t9.i.g(th, "e");
            k7.f.d("查询账号记录失败!", new Object[0]);
            o.this.u().B1();
            th.printStackTrace();
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            t9.i.g(disposable, "d");
            o.this.u().h();
        }
    }

    public static final class b extends ha.a {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ SwitchAccountBean f15445b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ t9.w f15446c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ t9.w f15447d;

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ String f15448e;

        public static final class a extends t9.j implements s9.l {

            /* renamed from: a, reason: collision with root package name */
            public static final a f15449a = new a();

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

        public b(SwitchAccountBean switchAccountBean, t9.w wVar, t9.w wVar2, String str) {
            this.f15445b = switchAccountBean;
            this.f15446c = wVar;
            this.f15447d = wVar2;
            this.f15448e = str;
        }

        @Override // ha.a, io.reactivex.Observer
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void onNext(LoginResult loginResult) {
            t9.i.g(loginResult, "t");
            o.this.B();
            o.this.u().B1();
            o.this.f15442d.add(0, this.f15445b);
            Iterator it = o.this.f15442d.iterator();
            while (it.hasNext()) {
                ((SwitchAccountBean) it.next()).setLogged(false);
            }
            this.f15445b.setLogged(true);
            o.this.u().V1();
            UserData data = loginResult.getData();
            if (!com.mobile.brasiltv.utils.b0.I(data != null ? data.getPortalCodeList() : null)) {
                com.mobile.brasiltv.utils.x.f8754a.w(o.this.s(), a.f15449a);
                return;
            }
            d6.b bVar = d6.b.f12660a;
            UserData data2 = loginResult.getData();
            t9.i.d(data2);
            bVar.H(data2);
            bVar.E(o.this.s(), (String) this.f15446c.f18961a);
            f5.c s10 = o.this.s();
            UserData data3 = loginResult.getData();
            t9.i.d(data3);
            bVar.F(s10, data3, (String) this.f15447d.f18961a, this.f15448e, (r21 & 16) != 0 ? "" : null, (r21 & 32) != 0 ? "" : null, (r21 & 64) != 0 ? "" : null, (r21 & 128) != 0);
            if (!TextUtils.isEmpty((CharSequence) this.f15446c.f18961a)) {
                UserData data4 = loginResult.getData();
                if (t9.i.b(data4 != null ? data4.getPwdTip() : null, "yes")) {
                    UserData data5 = loginResult.getData();
                    if (t9.i.b(data5 != null ? data5.getHasPwd() : null, "1")) {
                        com.mobile.brasiltv.utils.b0.c0(o.this.s(), ForceChangePwdAty.class);
                        s5.e.f18766a.n(s5.c.QUICK_LOGIN, this.f15445b, null);
                        return;
                    }
                }
            }
            bVar.C(loginResult.getData());
            o.this.G(this.f15445b);
            xa.c.c().j(new CloseForcePageEvent());
            com.mobile.brasiltv.utils.b0.c0(o.this.s(), MainAty.class);
        }

        @Override // ha.a, io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            t9.i.g(disposable, "d");
            super.onSubscribe(disposable);
            o.this.u().h();
        }

        @Override // ha.a
        public void showErrorHint(String str) {
            t9.i.g(str, "returnCode");
            o.this.u().B1();
            if (t9.i.b("aaa100094", str)) {
                new NumberLimitDialog(o.this.s()).show();
            } else {
                o.this.u().o(str);
            }
        }
    }

    public static final class c extends ha.a {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ SwitchAccountBean f15451b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f15452c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ String f15453d;

        public static final class a extends t9.j implements s9.l {

            /* renamed from: a, reason: collision with root package name */
            public static final a f15454a = new a();

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

        public static final class b extends t9.j implements s9.l {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ String f15455a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public b(String str) {
                super(1);
                this.f15455a = str;
            }

            @Override // s9.l
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((String) obj);
                return h9.t.f14242a;
            }

            public final void invoke(String str) {
                com.mobile.brasiltv.utils.f1.f8649a.x(com.mobile.brasiltv.utils.y.p(com.mobile.brasiltv.utils.y.f8771a, this.f15455a, null, null, 6, null));
            }
        }

        public c(SwitchAccountBean switchAccountBean, String str, String str2) {
            this.f15451b = switchAccountBean;
            this.f15452c = str;
            this.f15453d = str2;
        }

        @Override // ha.a, io.reactivex.Observer
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void onNext(LoginResult loginResult) {
            String str;
            String googleNickName;
            t9.i.g(loginResult, "t");
            o.this.B();
            o.this.u().B1();
            o.this.f15442d.add(0, this.f15451b);
            Iterator it = o.this.f15442d.iterator();
            while (it.hasNext()) {
                ((SwitchAccountBean) it.next()).setLogged(false);
            }
            this.f15451b.setLogged(true);
            o.this.u().V1();
            UserData data = loginResult.getData();
            if (!com.mobile.brasiltv.utils.b0.I(data != null ? data.getPortalCodeList() : null)) {
                com.mobile.brasiltv.utils.x.f8754a.w(o.this.s(), a.f15454a);
                return;
            }
            d6.b bVar = d6.b.f12660a;
            UserData data2 = loginResult.getData();
            t9.i.d(data2);
            bVar.H(data2);
            bVar.E(o.this.s(), this.f15452c);
            f5.c s10 = o.this.s();
            UserData data3 = loginResult.getData();
            t9.i.d(data3);
            bVar.F(s10, data3, "", "", (r21 & 16) != 0 ? "" : this.f15452c, (r21 & 32) != 0 ? "" : this.f15453d, (r21 & 64) != 0 ? "" : null, (r21 & 128) != 0);
            if (!TextUtils.isEmpty(this.f15452c)) {
                UserData data4 = loginResult.getData();
                if (t9.i.b(data4 != null ? data4.getPwdTip() : null, "yes")) {
                    UserData data5 = loginResult.getData();
                    if (t9.i.b(data5 != null ? data5.getHasPwd() : null, "1")) {
                        com.mobile.brasiltv.utils.b0.c0(o.this.s(), ForceChangePwdAty.class);
                        x7.a aVar = new x7.a();
                        aVar.b(this.f15453d);
                        s5.e.f18766a.o(s5.c.THIRD_PART_LOGIN, this.f15452c, aVar, "0", "1", null);
                        return;
                    }
                }
            }
            bVar.C(loginResult.getData());
            SwitchAccountBean switchAccountBean = this.f15451b;
            UserData data6 = loginResult.getData();
            String str2 = "";
            if (data6 == null || (str = data6.getGoogleEmail()) == null) {
                str = "";
            }
            switchAccountBean.setUserName(str);
            SwitchAccountBean switchAccountBean2 = this.f15451b;
            UserData data7 = loginResult.getData();
            if (data7 != null && (googleNickName = data7.getGoogleNickName()) != null) {
                str2 = googleNickName;
            }
            switchAccountBean2.setNickName(str2);
            o.this.G(this.f15451b);
            xa.c.c().j(new CloseForcePageEvent());
            com.mobile.brasiltv.utils.b0.c0(o.this.s(), MainAty.class);
        }

        @Override // ha.a, io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            t9.i.g(disposable, "d");
            super.onSubscribe(disposable);
            o.this.u().h();
        }

        @Override // ha.a
        public void showErrorHint(String str) {
            t9.i.g(str, "returnCode");
            o.this.u().B1();
            if (t9.i.b("aaa100094", str)) {
                com.mobile.brasiltv.utils.f1.f8649a.w(R.string.number_limit_tips);
            } else {
                o.this.u().o(str);
                com.mobile.brasiltv.utils.x.f8754a.w(o.this.s(), new b(str));
            }
        }
    }

    public static final class d extends ha.a {
        @Override // ha.a, io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            t9.i.g(disposable, "d");
            super.onSubscribe(disposable);
        }

        @Override // ha.a
        public void showErrorHint(String str) {
            t9.i.g(str, "returnCode");
        }

        @Override // ha.a, io.reactivex.Observer
        public void onNext(BaseResult baseResult) {
            t9.i.g(baseResult, "t");
            k7.f.e("登出成功", new Object[0]);
        }
    }

    public static final class e extends t9.j implements s9.a {
        public e() {
            super(0);
        }

        @Override // s9.a
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final MobileDao invoke() {
            Context applicationContext = o.this.s().getApplicationContext();
            t9.i.f(applicationContext, "context.applicationContext");
            return new MobileDao(applicationContext);
        }
    }

    public static final class f extends t9.j implements s9.l {
        public f() {
            super(1);
        }

        public final void b(SwitchAccountBean switchAccountBean) {
            o.this.f15442d.remove(switchAccountBean);
            o.this.u().Z1(o.this.f15442d);
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

        @Override // s9.l
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((Throwable) obj);
            return h9.t.f14242a;
        }

        public final void invoke(Throwable th) {
            k7.f.d("删除账号失败!", new Object[0]);
            o.this.u().B1();
            th.printStackTrace();
        }
    }

    public static final class h extends t9.j implements s9.l {
        public h() {
            super(1);
        }

        public final void b(SwitchAccountBean switchAccountBean) {
            com.mobile.brasiltv.utils.b0.U(o.this, "增加账号记录成功！");
        }

        @Override // s9.l
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            b((SwitchAccountBean) obj);
            return h9.t.f14242a;
        }
    }

    public static final class i extends t9.j implements s9.l {
        public i() {
            super(1);
        }

        @Override // s9.l
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((Throwable) obj);
            return h9.t.f14242a;
        }

        public final void invoke(Throwable th) {
            com.mobile.brasiltv.utils.b0.U(o.this, "增加账号记录失败！");
        }
    }

    public o(f5.c cVar, i6.g gVar) {
        t9.i.g(cVar, com.umeng.analytics.pro.f.X);
        t9.i.g(gVar, "view");
        this.f15439a = cVar;
        this.f15440b = gVar;
        gVar.Y0(this);
        this.f15441c = h9.h.b(new e());
        this.f15442d = new ArrayList();
    }

    public static final void D(o oVar, SwitchAccountBean switchAccountBean, ObservableEmitter observableEmitter) {
        t9.i.g(oVar, "this$0");
        t9.i.g(switchAccountBean, "$bean");
        t9.i.g(observableEmitter, "it");
        oVar.t().deleteAccount(switchAccountBean);
        observableEmitter.onNext(switchAccountBean);
        observableEmitter.onComplete();
    }

    public static final void E(s9.l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    public static final void F(s9.l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    public static final void H(o oVar, SwitchAccountBean switchAccountBean, ObservableEmitter observableEmitter) {
        t9.i.g(oVar, "this$0");
        t9.i.g(switchAccountBean, "$account");
        t9.i.g(observableEmitter, "it");
        Context applicationContext = oVar.f15439a.getApplicationContext();
        t9.i.f(applicationContext, "context.applicationContext");
        new MobileDao(applicationContext).addAccount(switchAccountBean);
        observableEmitter.onNext(switchAccountBean);
        observableEmitter.onComplete();
    }

    public static final void I(s9.l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    public static final void J(s9.l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    public static final void w(o oVar, ObservableEmitter observableEmitter) {
        t9.i.g(oVar, "this$0");
        t9.i.g(observableEmitter, "it");
        List<SwitchAccountBean> queryAllAccount = oVar.t().queryAllAccount();
        t9.i.e(queryAllAccount, "null cannot be cast to non-null type java.util.ArrayList<com.mobile.brasiltv.db.SwitchAccountBean>{ kotlin.collections.TypeAliasesKt.ArrayList<com.mobile.brasiltv.db.SwitchAccountBean> }");
        ArrayList<SwitchAccountBean> arrayList = (ArrayList) queryAllAccount;
        if (!arrayList.isEmpty()) {
            for (SwitchAccountBean switchAccountBean : arrayList) {
                switchAccountBean.setLogged(t9.i.b(switchAccountBean.getUserId(), w6.i.f19214g.H()));
            }
            i9.n.m(arrayList, new Comparator() { // from class: k6.h
                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    int x10;
                    x10 = o.x((SwitchAccountBean) obj, (SwitchAccountBean) obj2);
                    return x10;
                }
            });
        }
        observableEmitter.onNext(arrayList);
        observableEmitter.onComplete();
    }

    public static final int x(SwitchAccountBean switchAccountBean, SwitchAccountBean switchAccountBean2) {
        if (switchAccountBean.isLogged()) {
            return -1;
        }
        return switchAccountBean2.getId() - switchAccountBean.getId();
    }

    public final void A(SwitchAccountBean switchAccountBean) {
        String accountType = switchAccountBean.getAccountType();
        String authCode = switchAccountBean.getAuthCode();
        w6.i.f19214g.b().Z1(new LoginThirdPartBean(accountType, authCode, "0", "1", null, 16, null)).compose(this.f15439a.O1()).subscribe(new c(switchAccountBean, accountType, authCode));
    }

    public final void B() {
        com.mobile.brasiltv.utils.b0.U(this, "tp type logout");
        w6.i.f19214g.b().b2().compose(this.f15439a.O1()).subscribe(new d());
    }

    public void C(final SwitchAccountBean switchAccountBean) {
        t9.i.g(switchAccountBean, "bean");
        Observable observeOn = Observable.create(new ObservableOnSubscribe() { // from class: k6.l
            @Override // io.reactivex.ObservableOnSubscribe
            public final void subscribe(ObservableEmitter observableEmitter) {
                o.D(o.this, switchAccountBean, observableEmitter);
            }
        }).compose(this.f15439a.O1()).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        final f fVar = new f();
        Consumer consumer = new Consumer() { // from class: k6.m
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                o.E(s9.l.this, obj);
            }
        };
        final g gVar = new g();
        observeOn.subscribe(consumer, new Consumer() { // from class: k6.n
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                o.F(s9.l.this, obj);
            }
        });
    }

    public final void G(final SwitchAccountBean switchAccountBean) {
        Observable compose = Observable.create(new ObservableOnSubscribe() { // from class: k6.i
            @Override // io.reactivex.ObservableOnSubscribe
            public final void subscribe(ObservableEmitter observableEmitter) {
                o.H(o.this, switchAccountBean, observableEmitter);
            }
        }).compose(ma.q.b());
        final h hVar = new h();
        Consumer consumer = new Consumer() { // from class: k6.j
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                o.I(s9.l.this, obj);
            }
        };
        final i iVar = new i();
        compose.subscribe(consumer, new Consumer() { // from class: k6.k
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                o.J(s9.l.this, obj);
            }
        });
    }

    @Override // l5.a
    public void e() {
    }

    @Override // l5.a
    public void g() {
    }

    public final f5.c s() {
        return this.f15439a;
    }

    public final MobileDao t() {
        return (MobileDao) this.f15441c.getValue();
    }

    public final i6.g u() {
        return this.f15440b;
    }

    public void v() {
        Observable.create(new ObservableOnSubscribe() { // from class: k6.g
            @Override // io.reactivex.ObservableOnSubscribe
            public final void subscribe(ObservableEmitter observableEmitter) {
                o.w(o.this, observableEmitter);
            }
        }).compose(this.f15439a.O1()).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new a());
    }

    public final void y(SwitchAccountBean switchAccountBean) {
        t9.w wVar = new t9.w();
        wVar.f18961a = switchAccountBean.getAccountType();
        k7.f.e("loginType:" + ((String) wVar.f18961a), new Object[0]);
        t9.w wVar2 = new t9.w();
        wVar2.f18961a = switchAccountBean.getUserName();
        String password = switchAccountBean.getPassword();
        String areaCode = switchAccountBean.getAreaCode();
        String qrAuthCode = switchAccountBean.getQrAuthCode();
        String verificationToken = switchAccountBean.getVerificationToken();
        if (TextUtils.equals((CharSequence) wVar.f18961a, "4")) {
            wVar.f18961a = CdnType.DIGITAL_TYPE_PCDN;
        }
        if (t9.i.b(wVar.f18961a, "7")) {
            if (qrAuthCode.length() > 0) {
                wVar2.f18961a = qrAuthCode;
            }
        }
        w6.i.f19214g.b().W1((String) wVar.f18961a, areaCode, (String) wVar2.f18961a, password, null, null, verificationToken).compose(this.f15439a.O1()).subscribe(new b(switchAccountBean, wVar, wVar2, password));
    }

    public void z(SwitchAccountBean switchAccountBean) {
        t9.i.g(switchAccountBean, "bean");
        if (t9.i.b(switchAccountBean.getAccountType(), "google") || t9.i.b(switchAccountBean.getAccountType(), "facebook")) {
            A(switchAccountBean);
        } else {
            y(switchAccountBean);
        }
    }
}
