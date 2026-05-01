package k6;

import android.content.Context;
import android.text.TextUtils;
import com.mobile.brasiltv.activity.MainAty;
import com.mobile.brasiltv.bean.event.CloseForceBindEvent;
import com.mobile.brasiltv.bean.event.CloseForcePageEvent;
import com.mobile.brasiltv.bean.event.GotoHomeTabEvent;
import com.mobile.brasiltv.bean.event.RefreshAccountEvent;
import com.mobile.brasiltv.db.MobileDao;
import com.mobile.brasiltv.db.SwitchAccountBean;
import com.mobile.brasiltv.mine.activity.ForceChangePwdAty;
import com.mobile.brasiltv.view.dialog.NumberLimitDialog;
import com.msandroid.mobile.R;
import com.titans.entity.CdnType;
import i6.s;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import mobile.com.requestframe.util.RemoteLoginAndMsgEvent;
import mobile.com.requestframe.utils.bean.LoginThirdPartBean;
import mobile.com.requestframe.utils.response.AreaCodeData;
import mobile.com.requestframe.utils.response.AreaCodeResult;
import mobile.com.requestframe.utils.response.BaseResult;
import mobile.com.requestframe.utils.response.CheckVerificationResult;
import mobile.com.requestframe.utils.response.GetEmailSuffix;
import mobile.com.requestframe.utils.response.GetEmailSuffixResult;
import mobile.com.requestframe.utils.response.LoginResult;
import mobile.com.requestframe.utils.response.UserData;
import mobile.com.requestframe.utils.response.VerificationResult;

/* loaded from: classes3.dex */
public final class j0 implements i6.s {

    /* renamed from: a, reason: collision with root package name */
    public final f5.c f15307a;

    /* renamed from: b, reason: collision with root package name */
    public final i6.t f15308b;

    /* renamed from: c, reason: collision with root package name */
    public Disposable f15309c;

    /* renamed from: d, reason: collision with root package name */
    public Disposable f15310d;

    /* renamed from: e, reason: collision with root package name */
    public Disposable f15311e;

    /* renamed from: f, reason: collision with root package name */
    public Disposable f15312f;

    /* renamed from: g, reason: collision with root package name */
    public final h9.g f15313g;

    /* renamed from: h, reason: collision with root package name */
    public final ArrayList f15314h;

    public static final class a extends ha.a {

        /* renamed from: k6.j0$a$a, reason: collision with other inner class name */
        public static final class C0254a extends t9.j implements s9.l {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ String f15316a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0254a(String str) {
                super(1);
                this.f15316a = str;
            }

            @Override // s9.l
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((String) obj);
                return h9.t.f14242a;
            }

            public final void invoke(String str) {
                com.mobile.brasiltv.utils.f1.f8649a.x(com.mobile.brasiltv.utils.y.p(com.mobile.brasiltv.utils.y.f8771a, this.f15316a, null, null, 6, null));
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
            i6.t H = j0.this.H();
            String a10 = com.mobile.brasiltv.utils.h0.a(j0.this.D(), str);
            t9.i.f(a10, "getCountryByCode(context, areaCode)");
            H.h1(str, a10);
        }

        @Override // ha.a
        public void sendRemoteLoginEvent(RemoteLoginAndMsgEvent remoteLoginAndMsgEvent) {
        }

        @Override // ha.a
        public void showErrorHint(String str) {
            t9.i.g(str, "returnCode");
            com.mobile.brasiltv.utils.y.f8771a.c(str);
            com.mobile.brasiltv.utils.x.f8754a.w(j0.this.D(), new C0254a(str));
        }
    }

    public static final class b extends ha.a {

        public static final class a extends t9.j implements s9.l {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ String f15318a;

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ String f15319b;

            /* renamed from: c, reason: collision with root package name */
            public final /* synthetic */ j0 f15320c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(String str, String str2, j0 j0Var) {
                super(1);
                this.f15318a = str;
                this.f15319b = str2;
                this.f15320c = j0Var;
            }

            @Override // s9.l
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((String) obj);
                return h9.t.f14242a;
            }

            public final void invoke(String str) {
                String d10 = com.mobile.brasiltv.utils.y.f8771a.d(this.f15318a);
                if (t9.i.b(this.f15318a, "no_report_type") && t9.i.b(this.f15319b, "portal100060")) {
                    d10 = this.f15320c.D().getResources().getString(R.string.frequent_operation);
                    t9.i.f(d10, "context.resources.getStr…tring.frequent_operation)");
                }
                com.mobile.brasiltv.utils.f1.f8649a.x(d10);
            }
        }

        public b() {
        }

        @Override // ha.a, io.reactivex.Observer
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void onNext(VerificationResult verificationResult) {
            t9.i.g(verificationResult, "t");
            j0.this.H().showLoading(false);
            j0.this.H().i();
        }

        @Override // ha.a, io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            t9.i.g(disposable, "d");
            super.onSubscribe(disposable);
            j0.this.f15310d = disposable;
            j0.this.H().showLoading(true);
        }

        @Override // ha.a
        public void showErrorHint(String str) {
            t9.i.g(str, "returnCode");
            j0.this.H().showLoading(false);
            j0.this.H().Q();
            com.mobile.brasiltv.utils.x.f8754a.w(j0.this.D(), new a(com.mobile.brasiltv.utils.y.f8771a.c(str), str, j0.this));
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
                j0.this.H().e(ba.t.M(emailSuffixStr, new String[]{","}, false, 0, 6, null));
            }
        }
    }

    public static final class d implements Observer {
        public d() {
        }

        @Override // io.reactivex.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onNext(ArrayList arrayList) {
            t9.i.g(arrayList, "list");
            j0.this.G().clear();
            j0.this.G().addAll(arrayList);
            if (!j0.this.G().isEmpty()) {
                j0.this.H().v0(j0.this.G());
            } else {
                k7.f.c("无账号记录", new Object[0]);
                j0.this.H().v0(j0.this.G());
            }
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            t9.i.g(th, "e");
            k7.f.d("查询账号记录失败!", new Object[0]);
            th.printStackTrace();
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            t9.i.g(disposable, "d");
        }
    }

    public static final class e extends ha.a {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f15324b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f15325c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ String f15326d;

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ String f15327e;

        /* renamed from: f, reason: collision with root package name */
        public final /* synthetic */ String f15328f;

        /* renamed from: g, reason: collision with root package name */
        public final /* synthetic */ boolean f15329g;

        public static final class a extends t9.j implements s9.l {

            /* renamed from: a, reason: collision with root package name */
            public static final a f15330a = new a();

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
            public final /* synthetic */ String f15331a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public b(String str) {
                super(1);
                this.f15331a = str;
            }

            @Override // s9.l
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((String) obj);
                return h9.t.f14242a;
            }

            public final void invoke(String str) {
                com.mobile.brasiltv.utils.y yVar = com.mobile.brasiltv.utils.y.f8771a;
                com.mobile.brasiltv.utils.f1.f8649a.x(com.mobile.brasiltv.utils.y.p(yVar, this.f15331a, yVar.i(), null, 4, null));
            }
        }

        public e(String str, String str2, String str3, String str4, String str5, boolean z10) {
            this.f15324b = str;
            this.f15325c = str2;
            this.f15326d = str3;
            this.f15327e = str4;
            this.f15328f = str5;
            this.f15329g = z10;
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
            j0.this.H().r0();
            j0.this.H().showLoading(false);
            UserData data = loginResult.getData();
            if (!com.mobile.brasiltv.utils.b0.I(data != null ? data.getPortalCodeList() : null)) {
                com.mobile.brasiltv.utils.x.f8754a.w(j0.this.D(), a.f15330a);
                return;
            }
            d6.b bVar = d6.b.f12660a;
            UserData data2 = loginResult.getData();
            t9.i.d(data2);
            bVar.H(data2);
            bVar.E(j0.this.D(), this.f15324b);
            f5.c D = j0.this.D();
            UserData data3 = loginResult.getData();
            t9.i.d(data3);
            bVar.F(D, data3, this.f15325c, this.f15326d, (r21 & 16) != 0 ? "" : null, (r21 & 32) != 0 ? "" : null, (r21 & 64) != 0 ? "" : null, (r21 & 128) != 0);
            str = "";
            if (!TextUtils.isEmpty(this.f15324b)) {
                UserData data4 = loginResult.getData();
                if (t9.i.b(data4 != null ? data4.getPwdTip() : null, "yes")) {
                    UserData data5 = loginResult.getData();
                    if (t9.i.b(data5 != null ? data5.getHasPwd() : null, "1")) {
                        com.mobile.brasiltv.utils.b0.c0(j0.this.D(), ForceChangePwdAty.class);
                        SwitchAccountBean switchAccountBean = new SwitchAccountBean();
                        switchAccountBean.setAccountType(this.f15324b);
                        String str6 = this.f15327e;
                        switchAccountBean.setAreaCode(str6 != null ? str6 : "");
                        switchAccountBean.setUserName(this.f15325c);
                        switchAccountBean.setPassword(this.f15326d);
                        s5.e.f18766a.n(s5.c.QUICK_LOGIN, switchAccountBean, this.f15328f);
                        return;
                    }
                }
            }
            bVar.C(loginResult.getData());
            SwitchAccountBean switchAccountBean2 = new SwitchAccountBean();
            switchAccountBean2.setUserName(this.f15325c);
            switchAccountBean2.setPassword(this.f15326d);
            UserData data6 = loginResult.getData();
            if (data6 == null || (str2 = data6.getUserId()) == null) {
                str2 = "";
            }
            switchAccountBean2.setUserId(str2);
            switchAccountBean2.setAccountType(this.f15324b);
            String str7 = this.f15327e;
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
            j0.this.X(switchAccountBean2);
            xa.c.c().j(new CloseForceBindEvent());
            xa.c.c().j(new CloseForcePageEvent());
            if (this.f15329g) {
                com.mobile.brasiltv.utils.b0.c0(j0.this.D(), MainAty.class);
            } else {
                xa.c.c().j(new RefreshAccountEvent());
                j0.this.D().finish();
            }
        }

        @Override // ha.a, io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            t9.i.g(disposable, "d");
            super.onSubscribe(disposable);
            j0.this.f15309c = disposable;
            j0.this.H().showLoading(true);
        }

        @Override // ha.a
        public void showErrorHint(String str) {
            t9.i.g(str, "returnCode");
            com.mobile.brasiltv.utils.b0.U(this, "login fail: " + str);
            j0.this.H().showLoading(false);
            if (t9.i.b("aaa100094", str)) {
                new NumberLimitDialog(j0.this.D()).show();
            } else {
                com.mobile.brasiltv.utils.x.f8754a.w(j0.this.D(), new b(str));
            }
        }
    }

    public static final class f extends ha.a {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ SwitchAccountBean f15333b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ t9.w f15334c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ t9.w f15335d;

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ String f15336e;

        public static final class a extends t9.j implements s9.l {

            /* renamed from: a, reason: collision with root package name */
            public static final a f15337a = new a();

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

        public f(SwitchAccountBean switchAccountBean, t9.w wVar, t9.w wVar2, String str) {
            this.f15333b = switchAccountBean;
            this.f15334c = wVar;
            this.f15335d = wVar2;
            this.f15336e = str;
        }

        @Override // ha.a, io.reactivex.Observer
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void onNext(LoginResult loginResult) {
            t9.i.g(loginResult, "t");
            j0.this.H().r0();
            j0.this.H().showLoading(false);
            j0.this.G().add(0, this.f15333b);
            Iterator it = j0.this.G().iterator();
            while (it.hasNext()) {
                ((SwitchAccountBean) it.next()).setLogged(false);
            }
            this.f15333b.setLogged(true);
            UserData data = loginResult.getData();
            if (!com.mobile.brasiltv.utils.b0.I(data != null ? data.getPortalCodeList() : null)) {
                com.mobile.brasiltv.utils.x.f8754a.w(j0.this.D(), a.f15337a);
                return;
            }
            d6.b bVar = d6.b.f12660a;
            UserData data2 = loginResult.getData();
            t9.i.d(data2);
            bVar.H(data2);
            bVar.E(j0.this.D(), (String) this.f15334c.f18961a);
            f5.c D = j0.this.D();
            UserData data3 = loginResult.getData();
            t9.i.d(data3);
            bVar.F(D, data3, (String) this.f15335d.f18961a, this.f15336e, (r21 & 16) != 0 ? "" : null, (r21 & 32) != 0 ? "" : null, (r21 & 64) != 0 ? "" : null, (r21 & 128) != 0);
            if (!TextUtils.isEmpty((CharSequence) this.f15334c.f18961a)) {
                UserData data4 = loginResult.getData();
                if (t9.i.b(data4 != null ? data4.getPwdTip() : null, "yes")) {
                    UserData data5 = loginResult.getData();
                    if (t9.i.b(data5 != null ? data5.getHasPwd() : null, "1")) {
                        com.mobile.brasiltv.utils.b0.c0(j0.this.D(), ForceChangePwdAty.class);
                        s5.e.f18766a.n(s5.c.QUICK_LOGIN, this.f15333b, null);
                        return;
                    }
                }
            }
            bVar.C(loginResult.getData());
            j0.this.X(this.f15333b);
            xa.c.c().j(new CloseForcePageEvent());
            com.mobile.brasiltv.utils.b0.c0(j0.this.D(), MainAty.class);
        }

        @Override // ha.a, io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            t9.i.g(disposable, "d");
            super.onSubscribe(disposable);
            j0.this.f15309c = disposable;
            j0.this.H().showLoading(true);
        }

        @Override // ha.a
        public void showErrorHint(String str) {
            t9.i.g(str, "returnCode");
            com.mobile.brasiltv.utils.b0.U(this, "login fail: " + str);
            j0.this.H().showLoading(false);
            j0.this.H().c0(str);
            com.mobile.brasiltv.utils.y yVar = com.mobile.brasiltv.utils.y.f8771a;
            com.mobile.brasiltv.utils.y.p(yVar, str, yVar.i(), null, 4, null);
        }
    }

    public static final class g extends ha.a {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f15339b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f15340c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ String f15341d;

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ x7.a f15342e;

        /* renamed from: f, reason: collision with root package name */
        public final /* synthetic */ t9.w f15343f;

        /* renamed from: g, reason: collision with root package name */
        public final /* synthetic */ boolean f15344g;

        public static final class a extends t9.j implements s9.l {

            /* renamed from: a, reason: collision with root package name */
            public static final a f15345a = new a();

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
            public final /* synthetic */ String f15346a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public b(String str) {
                super(1);
                this.f15346a = str;
            }

            @Override // s9.l
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((String) obj);
                return h9.t.f14242a;
            }

            public final void invoke(String str) {
                com.mobile.brasiltv.utils.y yVar = com.mobile.brasiltv.utils.y.f8771a;
                com.mobile.brasiltv.utils.f1.f8649a.x(com.mobile.brasiltv.utils.y.p(yVar, this.f15346a, yVar.j(), null, 4, null));
            }
        }

        public g(String str, String str2, String str3, x7.a aVar, t9.w wVar, boolean z10) {
            this.f15339b = str;
            this.f15340c = str2;
            this.f15341d = str3;
            this.f15342e = aVar;
            this.f15343f = wVar;
            this.f15344g = z10;
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
            j0.this.H().r0();
            j0.this.H().showLoading(false);
            if (t9.i.b(this.f15341d, "2")) {
                j0.this.H().q();
            }
            UserData data = loginResult.getData();
            if (!com.mobile.brasiltv.utils.b0.I(data != null ? data.getPortalCodeList() : null)) {
                com.mobile.brasiltv.utils.x.f8754a.w(j0.this.D(), a.f15345a);
                return;
            }
            d6.b bVar = d6.b.f12660a;
            UserData data2 = loginResult.getData();
            t9.i.d(data2);
            bVar.H(data2);
            bVar.E(j0.this.D(), this.f15340c);
            f5.c D = j0.this.D();
            UserData data3 = loginResult.getData();
            t9.i.d(data3);
            bVar.F(D, data3, "", "", (r21 & 16) != 0 ? "" : this.f15340c, (r21 & 32) != 0 ? "" : this.f15342e.a(), (r21 & 64) != 0 ? "" : null, (r21 & 128) != 0);
            String str6 = "";
            if (!TextUtils.isEmpty(this.f15340c)) {
                UserData data4 = loginResult.getData();
                if (t9.i.b(data4 != null ? data4.getPwdTip() : null, "yes")) {
                    UserData data5 = loginResult.getData();
                    if (t9.i.b(data5 != null ? data5.getHasPwd() : null, "1")) {
                        com.mobile.brasiltv.utils.b0.c0(j0.this.D(), ForceChangePwdAty.class);
                        s5.e eVar = s5.e.f18766a;
                        s5.c cVar = s5.c.THIRD_PART_LOGIN;
                        String str7 = this.f15340c;
                        x7.a aVar = this.f15342e;
                        String str8 = this.f15339b;
                        String str9 = this.f15341d;
                        String str10 = (String) this.f15343f.f18961a;
                        eVar.o(cVar, str7, aVar, str8, str9, str10 == null ? "" : str10);
                        return;
                    }
                }
            }
            bVar.C(loginResult.getData());
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
            switchAccountBean.setAuthCode(this.f15342e.a());
            UserData data11 = loginResult.getData();
            if (data11 != null && (areaCode = data11.getAreaCode()) != null) {
                str6 = areaCode;
            }
            switchAccountBean.setAreaCode(str6);
            j0.this.X(switchAccountBean);
            xa.c.c().j(new CloseForcePageEvent());
            if (!t9.i.b(this.f15339b, "0")) {
                xa.c.c().j(new GotoHomeTabEvent(0));
                com.mobile.brasiltv.utils.b0.c0(j0.this.D(), MainAty.class);
            } else if (this.f15344g) {
                com.mobile.brasiltv.utils.b0.c0(j0.this.D(), MainAty.class);
            } else {
                xa.c.c().j(new RefreshAccountEvent());
                j0.this.D().finish();
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:15:0x0050  */
        /* JADX WARN: Removed duplicated region for block: B:17:0x005a  */
        @Override // ha.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void handleGoogleAccountNotBind(java.lang.String r5, java.lang.String r6) {
            /*
                r4 = this;
                java.lang.String r5 = ""
                java.lang.String r0 = r4.f15339b
                java.lang.String r1 = "0"
                boolean r0 = com.mobile.brasiltv.utils.b0.T(r0, r1)
                if (r0 != 0) goto Ld
                return
            Ld:
                org.json.JSONObject r0 = new org.json.JSONObject     // Catch: java.lang.Exception -> L44
                r0.<init>(r6)     // Catch: java.lang.Exception -> L44
                java.lang.String r2 = "localUserIdentity"
                java.lang.String r0 = r0.getString(r2)     // Catch: java.lang.Exception -> L44
                java.lang.String r2 = "JSONObject(errorData).ge…ring(\"localUserIdentity\")"
                t9.i.f(r0, r2)     // Catch: java.lang.Exception -> L44
                org.json.JSONObject r2 = new org.json.JSONObject     // Catch: java.lang.Exception -> L41
                r2.<init>(r6)     // Catch: java.lang.Exception -> L41
                java.lang.String r3 = "bindGoogleEmail"
                java.lang.String r2 = r2.getString(r3)     // Catch: java.lang.Exception -> L41
                java.lang.String r3 = "JSONObject(errorData).getString(\"bindGoogleEmail\")"
                t9.i.f(r2, r3)     // Catch: java.lang.Exception -> L41
                org.json.JSONObject r3 = new org.json.JSONObject     // Catch: java.lang.Exception -> L3f
                r3.<init>(r6)     // Catch: java.lang.Exception -> L3f
                java.lang.String r6 = "googleEmail"
                java.lang.String r6 = r3.getString(r6)     // Catch: java.lang.Exception -> L3f
                java.lang.String r3 = "JSONObject(errorData).getString(\"googleEmail\")"
                t9.i.f(r6, r3)     // Catch: java.lang.Exception -> L3f
                r5 = r6
                goto L4a
            L3f:
                r6 = move-exception
                goto L47
            L41:
                r6 = move-exception
                r2 = r5
                goto L47
            L44:
                r6 = move-exception
                r0 = r5
                r2 = r0
            L47:
                r6.printStackTrace()
            L4a:
                boolean r6 = com.mobile.brasiltv.utils.b0.J(r0)
                if (r6 == 0) goto L5a
                k6.j0 r5 = k6.j0.this
                i6.t r5 = r5.H()
                r5.q()
                return
            L5a:
                java.lang.String r6 = "1"
                boolean r0 = com.mobile.brasiltv.utils.b0.T(r0, r6)
                if (r0 != 0) goto L7e
                d6.b r0 = d6.b.f12660a
                boolean r0 = r0.t()
                if (r0 == 0) goto L6b
                goto L7e
            L6b:
                k6.j0 r5 = k6.j0.this
                i6.t r5 = r5.H()
                r5.q()
                k6.j0 r5 = k6.j0.this
                i6.t r5 = r5.H()
                r5.U1()
                goto La5
            L7e:
                boolean r0 = com.mobile.brasiltv.utils.b0.T(r2, r1)
                if (r0 == 0) goto L92
                k6.j0 r5 = k6.j0.this
                i6.t r5 = r5.H()
                java.lang.String r0 = r4.f15340c
                x7.a r1 = r4.f15342e
                r5.S(r0, r6, r1)
                goto La5
            L92:
                boolean r0 = com.mobile.brasiltv.utils.b0.T(r2, r6)
                if (r0 == 0) goto La5
                k6.j0 r0 = k6.j0.this
                i6.t r0 = r0.H()
                java.lang.String r1 = r4.f15340c
                x7.a r2 = r4.f15342e
                r0.F2(r5, r1, r6, r2)
            La5:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: k6.j0.g.handleGoogleAccountNotBind(java.lang.String, java.lang.String):void");
        }

        @Override // ha.a, io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            t9.i.g(disposable, "d");
            super.onSubscribe(disposable);
            j0.this.f15312f = disposable;
            j0.this.H().showLoading(true);
        }

        @Override // ha.a
        public void showErrorHint(String str) {
            t9.i.g(str, "returnCode");
            j0.this.H().showLoading(false);
            if (com.mobile.brasiltv.utils.b0.T(this.f15339b, "0")) {
                if (com.mobile.brasiltv.utils.b0.T(str, "portal100071")) {
                    return;
                }
                if (com.mobile.brasiltv.utils.b0.T(str, "portal100075")) {
                    d6.b.f12660a.I(j0.this.D(), "", "");
                    j0.this.H().M1(this.f15340c);
                    return;
                }
            }
            if (t9.i.b(this.f15341d, "2")) {
                j0.this.H().q();
            }
            if (t9.i.b("aaa100094", str)) {
                new NumberLimitDialog(j0.this.D()).show();
            } else {
                com.mobile.brasiltv.utils.x.f8754a.w(j0.this.D(), new b(str));
            }
        }
    }

    public static final class h extends ha.a {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ SwitchAccountBean f15348b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f15349c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ String f15350d;

        public static final class a extends t9.j implements s9.l {

            /* renamed from: a, reason: collision with root package name */
            public static final a f15351a = new a();

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

        public h(SwitchAccountBean switchAccountBean, String str, String str2) {
            this.f15348b = switchAccountBean;
            this.f15349c = str;
            this.f15350d = str2;
        }

        @Override // ha.a, io.reactivex.Observer
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void onNext(LoginResult loginResult) {
            String str;
            String googleNickName;
            t9.i.g(loginResult, "t");
            j0.this.H().r0();
            j0.this.H().showLoading(false);
            j0.this.G().add(0, this.f15348b);
            Iterator it = j0.this.G().iterator();
            while (it.hasNext()) {
                ((SwitchAccountBean) it.next()).setLogged(false);
            }
            this.f15348b.setLogged(true);
            UserData data = loginResult.getData();
            if (!com.mobile.brasiltv.utils.b0.I(data != null ? data.getPortalCodeList() : null)) {
                com.mobile.brasiltv.utils.x.f8754a.w(j0.this.D(), a.f15351a);
                return;
            }
            d6.b bVar = d6.b.f12660a;
            UserData data2 = loginResult.getData();
            t9.i.d(data2);
            bVar.H(data2);
            bVar.E(j0.this.D(), this.f15349c);
            f5.c D = j0.this.D();
            UserData data3 = loginResult.getData();
            t9.i.d(data3);
            bVar.F(D, data3, "", "", (r21 & 16) != 0 ? "" : this.f15349c, (r21 & 32) != 0 ? "" : this.f15350d, (r21 & 64) != 0 ? "" : null, (r21 & 128) != 0);
            if (!TextUtils.isEmpty(this.f15349c)) {
                UserData data4 = loginResult.getData();
                if (t9.i.b(data4 != null ? data4.getPwdTip() : null, "yes")) {
                    UserData data5 = loginResult.getData();
                    if (t9.i.b(data5 != null ? data5.getHasPwd() : null, "1")) {
                        com.mobile.brasiltv.utils.b0.c0(j0.this.D(), ForceChangePwdAty.class);
                        x7.a aVar = new x7.a();
                        aVar.b(this.f15350d);
                        s5.e.f18766a.o(s5.c.THIRD_PART_LOGIN, this.f15349c, aVar, "0", "1", null);
                        return;
                    }
                }
            }
            bVar.C(loginResult.getData());
            SwitchAccountBean switchAccountBean = this.f15348b;
            UserData data6 = loginResult.getData();
            String str2 = "";
            if (data6 == null || (str = data6.getGoogleEmail()) == null) {
                str = "";
            }
            switchAccountBean.setUserName(str);
            SwitchAccountBean switchAccountBean2 = this.f15348b;
            UserData data7 = loginResult.getData();
            if (data7 != null && (googleNickName = data7.getGoogleNickName()) != null) {
                str2 = googleNickName;
            }
            switchAccountBean2.setNickName(str2);
            j0.this.X(this.f15348b);
            xa.c.c().j(new CloseForcePageEvent());
            com.mobile.brasiltv.utils.b0.c0(j0.this.D(), MainAty.class);
        }

        @Override // ha.a, io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            t9.i.g(disposable, "d");
            super.onSubscribe(disposable);
            j0.this.f15312f = disposable;
            j0.this.H().showLoading(true);
        }

        @Override // ha.a
        public void showErrorHint(String str) {
            t9.i.g(str, "returnCode");
            j0.this.H().showLoading(false);
            j0.this.H().c0(str);
            com.mobile.brasiltv.utils.y yVar = com.mobile.brasiltv.utils.y.f8771a;
            com.mobile.brasiltv.utils.y.p(yVar, str, yVar.j(), null, 4, null);
        }
    }

    public static final class i extends ha.a {
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

    public static final class j extends t9.j implements s9.a {
        public j() {
            super(0);
        }

        @Override // s9.a
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final MobileDao invoke() {
            Context applicationContext = j0.this.D().getApplicationContext();
            t9.i.f(applicationContext, "context.applicationContext");
            return new MobileDao(applicationContext);
        }
    }

    public static final class k extends t9.j implements s9.l {
        public k() {
            super(1);
        }

        public final void b(SwitchAccountBean switchAccountBean) {
            j0.this.G().remove(switchAccountBean);
            j0.this.H().v0(j0.this.G());
        }

        @Override // s9.l
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            b((SwitchAccountBean) obj);
            return h9.t.f14242a;
        }
    }

    public static final class l extends t9.j implements s9.l {

        /* renamed from: a, reason: collision with root package name */
        public static final l f15354a = new l();

        public l() {
            super(1);
        }

        @Override // s9.l
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((Throwable) obj);
            return h9.t.f14242a;
        }

        public final void invoke(Throwable th) {
            k7.f.d("删除账号失败!", new Object[0]);
            th.printStackTrace();
        }
    }

    public static final class m extends t9.j implements s9.l {
        public m() {
            super(1);
        }

        public final void b(SwitchAccountBean switchAccountBean) {
            com.mobile.brasiltv.utils.b0.U(j0.this, "增加账号记录成功！");
        }

        @Override // s9.l
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            b((SwitchAccountBean) obj);
            return h9.t.f14242a;
        }
    }

    public static final class n extends t9.j implements s9.l {
        public n() {
            super(1);
        }

        @Override // s9.l
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((Throwable) obj);
            return h9.t.f14242a;
        }

        public final void invoke(Throwable th) {
            com.mobile.brasiltv.utils.b0.U(j0.this, "增加账号记录失败！");
        }
    }

    public static final class o extends ha.a {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f15358b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f15359c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ String f15360d;

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ boolean f15361e;

        public static final class a extends t9.j implements s9.l {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ String f15362a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(String str) {
                super(1);
                this.f15362a = str;
            }

            @Override // s9.l
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((String) obj);
                return h9.t.f14242a;
            }

            public final void invoke(String str) {
                com.mobile.brasiltv.utils.f1.f8649a.x(com.mobile.brasiltv.utils.y.f8771a.d(this.f15362a));
            }
        }

        public o(String str, String str2, String str3, boolean z10) {
            this.f15358b = str;
            this.f15359c = str2;
            this.f15360d = str3;
            this.f15361e = z10;
        }

        @Override // ha.a, io.reactivex.Observer
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void onNext(CheckVerificationResult checkVerificationResult) {
            t9.i.g(checkVerificationResult, "t");
            j0.this.M(this.f15358b, "", "4", this.f15359c, this.f15360d, this.f15361e);
        }

        @Override // ha.a, io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            t9.i.g(disposable, "d");
            super.onSubscribe(disposable);
            j0.this.f15311e = disposable;
            j0.this.H().showLoading(true);
        }

        @Override // ha.a
        public void showErrorHint(String str) {
            t9.i.g(str, "returnCode");
            com.mobile.brasiltv.utils.b0.U(this, "verify code fail: " + str);
            j0.this.H().showLoading(false);
            com.mobile.brasiltv.utils.x.f8754a.w(j0.this.D(), new a(com.mobile.brasiltv.utils.y.f8771a.c(str)));
        }
    }

    public j0(f5.c cVar, i6.t tVar) {
        t9.i.g(cVar, com.umeng.analytics.pro.f.X);
        t9.i.g(tVar, "view");
        this.f15307a = cVar;
        this.f15308b = tVar;
        this.f15313g = h9.h.b(new j());
        this.f15314h = new ArrayList();
    }

    public static final void J(j0 j0Var, ObservableEmitter observableEmitter) {
        t9.i.g(j0Var, "this$0");
        t9.i.g(observableEmitter, "it");
        List<SwitchAccountBean> queryAllAccount = j0Var.F().queryAllAccount();
        t9.i.e(queryAllAccount, "null cannot be cast to non-null type java.util.ArrayList<com.mobile.brasiltv.db.SwitchAccountBean>{ kotlin.collections.TypeAliasesKt.ArrayList<com.mobile.brasiltv.db.SwitchAccountBean> }");
        ArrayList<SwitchAccountBean> arrayList = (ArrayList) queryAllAccount;
        if (!arrayList.isEmpty()) {
            for (SwitchAccountBean switchAccountBean : arrayList) {
                switchAccountBean.setLogged(t9.i.b(switchAccountBean.getUserId(), w6.i.f19214g.H()));
            }
            i9.n.m(arrayList, new Comparator() { // from class: k6.i0
                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    int K;
                    K = j0.K((SwitchAccountBean) obj, (SwitchAccountBean) obj2);
                    return K;
                }
            });
        }
        observableEmitter.onNext(arrayList);
        observableEmitter.onComplete();
    }

    public static final int K(SwitchAccountBean switchAccountBean, SwitchAccountBean switchAccountBean2) {
        if (switchAccountBean.isLogged()) {
            return -1;
        }
        return switchAccountBean2.getId() - switchAccountBean.getId();
    }

    public static final void N(j0 j0Var) {
        t9.i.g(j0Var, "this$0");
        j0Var.f15308b.q();
    }

    public static final void U(j0 j0Var, SwitchAccountBean switchAccountBean, ObservableEmitter observableEmitter) {
        t9.i.g(j0Var, "this$0");
        t9.i.g(switchAccountBean, "$bean");
        t9.i.g(observableEmitter, "it");
        j0Var.F().deleteAccount(switchAccountBean);
        observableEmitter.onNext(switchAccountBean);
        observableEmitter.onComplete();
    }

    public static final void V(s9.l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    public static final void W(s9.l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    public static final void Y(j0 j0Var, SwitchAccountBean switchAccountBean, ObservableEmitter observableEmitter) {
        t9.i.g(j0Var, "this$0");
        t9.i.g(switchAccountBean, "$account");
        t9.i.g(observableEmitter, "it");
        Context applicationContext = j0Var.f15307a.getApplicationContext();
        t9.i.f(applicationContext, "context.applicationContext");
        new MobileDao(applicationContext).addAccount(switchAccountBean);
        observableEmitter.onNext(switchAccountBean);
        observableEmitter.onComplete();
    }

    public static final void Z(s9.l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    public static final void a0(s9.l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    public final void A() {
        Disposable disposable = this.f15312f;
        boolean z10 = false;
        if (disposable != null && !disposable.isDisposed()) {
            z10 = true;
        }
        if (z10) {
            Disposable disposable2 = this.f15312f;
            if (disposable2 != null) {
                disposable2.dispose();
            }
            this.f15312f = null;
        }
    }

    public final void B() {
        w6.i.f19214g.b().O0().compose(this.f15307a.O1()).subscribe(new a());
    }

    public void C(String str, String str2, String str3) {
        t9.i.g(str, "mobile");
        t9.i.g(str2, "area");
        t9.i.g(str3, "areaCode");
        if (com.mobile.brasiltv.utils.b0.J(str)) {
            this.f15308b.d(R.string.empty_phone);
        } else {
            if (!com.mobile.brasiltv.utils.z0.a(str, str2)) {
                this.f15308b.d(R.string.invalid_phone_number);
                return;
            }
            this.f15308b.hideErrorHint(0L);
            y();
            w6.i.f19214g.b().U1(str, str3, "4").compose(this.f15307a.O1()).subscribe(new b());
        }
    }

    public final f5.c D() {
        return this.f15307a;
    }

    public final void E() {
        w6.i.f19214g.b().q1().compose(this.f15307a.O1()).subscribe(new c());
    }

    public final MobileDao F() {
        return (MobileDao) this.f15313g.getValue();
    }

    public final ArrayList G() {
        return this.f15314h;
    }

    public final i6.t H() {
        return this.f15308b;
    }

    public final void I() {
        Observable.create(new ObservableOnSubscribe() { // from class: k6.h0
            @Override // io.reactivex.ObservableOnSubscribe
            public final void subscribe(ObservableEmitter observableEmitter) {
                j0.J(j0.this, observableEmitter);
            }
        }).compose(this.f15307a.O1()).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new d());
    }

    public final void L(SwitchAccountBean switchAccountBean) {
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
        w6.i.f19214g.b().W1((String) wVar.f18961a, areaCode, (String) wVar2.f18961a, password, null, null, verificationToken).compose(this.f15307a.O1()).subscribe(new f(switchAccountBean, wVar, wVar2, password));
    }

    public void M(String str, String str2, String str3, String str4, String str5, boolean z10) {
        Observable W1;
        t9.i.g(str, "userName");
        t9.i.g(str2, "password");
        t9.i.g(str3, "accountTypes");
        z();
        W1 = w6.i.f19214g.b().W1(str3, str4, str, str2, str5, null, (r17 & 64) != 0 ? null : null);
        W1.compose(this.f15307a.O1()).subscribe(new e(str3, str, str2, str4, str5, z10));
    }

    public boolean O(String str, boolean z10) {
        t9.i.g(str, "thirdPartType");
        String e10 = na.f.e(this.f15307a, "tp_google_auth_code");
        if (com.mobile.brasiltv.utils.b0.J(e10)) {
            return false;
        }
        x7.a aVar = new x7.a();
        t9.i.f(e10, "authCode");
        aVar.b(e10);
        s.a.a(this, str, aVar, "0", "1", z10, null, 32, null);
        return true;
    }

    public final void P(SwitchAccountBean switchAccountBean) {
        String accountType = switchAccountBean.getAccountType();
        String authCode = switchAccountBean.getAuthCode();
        w6.i.f19214g.b().Z1(new LoginThirdPartBean(accountType, authCode, "0", "1", null, 16, null)).compose(this.f15307a.O1()).subscribe(new h(switchAccountBean, accountType, authCode));
    }

    public final void Q() {
        com.mobile.brasiltv.utils.b0.U(this, "tp type logout");
        w6.i.f19214g.b().b2().compose(this.f15307a.O1()).subscribe(new i());
    }

    public void R(String str, String str2, String str3, String str4, boolean z10) {
        t9.i.g(str, "mobile");
        t9.i.g(str2, "password");
        t9.i.g(str3, "area");
        t9.i.g(str4, "areaCode");
        if (com.mobile.brasiltv.utils.b0.J(str)) {
            this.f15308b.n(R.string.empty_phone);
            return;
        }
        if (com.mobile.brasiltv.utils.b0.J(str2)) {
            this.f15308b.n(R.string.wrong_pohone_number_or_pwd);
            return;
        }
        if (!com.mobile.brasiltv.utils.z0.a(str, str3)) {
            this.f15308b.d(R.string.invalid_phone_number);
            return;
        }
        this.f15308b.hideErrorHint(0L);
        String e10 = ma.m.e(str2);
        t9.i.f(e10, "md5(password)");
        M(str, e10, "3", str4, "", z10);
    }

    public final void S(SwitchAccountBean switchAccountBean) {
        t9.i.g(switchAccountBean, "account");
        if (t9.i.b(switchAccountBean.getAccountType(), "google") || t9.i.b(switchAccountBean.getAccountType(), "facebook")) {
            P(switchAccountBean);
        } else {
            L(switchAccountBean);
        }
    }

    public final void T(final SwitchAccountBean switchAccountBean) {
        t9.i.g(switchAccountBean, "bean");
        Observable observeOn = Observable.create(new ObservableOnSubscribe() { // from class: k6.d0
            @Override // io.reactivex.ObservableOnSubscribe
            public final void subscribe(ObservableEmitter observableEmitter) {
                j0.U(j0.this, switchAccountBean, observableEmitter);
            }
        }).compose(this.f15307a.O1()).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        final k kVar = new k();
        Consumer consumer = new Consumer() { // from class: k6.e0
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                j0.V(s9.l.this, obj);
            }
        };
        final l lVar = l.f15354a;
        observeOn.subscribe(consumer, new Consumer() { // from class: k6.f0
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                j0.W(s9.l.this, obj);
            }
        });
    }

    public final void X(final SwitchAccountBean switchAccountBean) {
        Observable compose = Observable.create(new ObservableOnSubscribe() { // from class: k6.a0
            @Override // io.reactivex.ObservableOnSubscribe
            public final void subscribe(ObservableEmitter observableEmitter) {
                j0.Y(j0.this, switchAccountBean, observableEmitter);
            }
        }).compose(ma.q.b());
        final m mVar = new m();
        Consumer consumer = new Consumer() { // from class: k6.b0
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                j0.Z(s9.l.this, obj);
            }
        };
        final n nVar = new n();
        compose.subscribe(consumer, new Consumer() { // from class: k6.c0
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                j0.a0(s9.l.this, obj);
            }
        });
    }

    public void b0(String str, String str2, String str3, String str4, boolean z10) {
        t9.i.g(str, "mobile");
        t9.i.g(str2, "verifyCode");
        t9.i.g(str3, "area");
        t9.i.g(str4, "areaCode");
        if (com.mobile.brasiltv.utils.b0.J(str)) {
            this.f15308b.d(R.string.empty_phone);
            return;
        }
        if (com.mobile.brasiltv.utils.b0.J(str2)) {
            this.f15308b.d(R.string.empty_verification_code);
            return;
        }
        if (!com.mobile.brasiltv.utils.z0.a(str, str3)) {
            this.f15308b.d(R.string.invalid_phone_number);
        } else {
            if (str2.length() != 6) {
                this.f15308b.d(R.string.verification_invalid);
                return;
            }
            this.f15308b.hideErrorHint(0L);
            w();
            w6.i.f19214g.b().W0(str, str4, str2, "4").compose(this.f15307a.O1()).subscribe(new o(str, str4, str2, z10));
        }
    }

    @Override // i6.s
    public void c(String str, x7.a aVar, String str2, String str3, boolean z10, String str4) {
        t9.i.g(str, "thirdPartType");
        t9.i.g(aVar, "socialInfo");
        t9.i.g(str2, "createType");
        t9.i.g(str3, "tpSource");
        A();
        t9.w wVar = new t9.w();
        wVar.f18961a = str4;
        if (str4 != null) {
            wVar.f18961a = ma.m.e(str4);
        }
        w6.i.f19214g.b().Z1(new LoginThirdPartBean(str, aVar.a(), str2, str3, (String) wVar.f18961a)).compose(this.f15307a.O1()).doOnDispose(new Action() { // from class: k6.g0
            @Override // io.reactivex.functions.Action
            public final void run() {
                j0.N(j0.this);
            }
        }).subscribe(new g(str2, str, str3, aVar, wVar, z10));
    }

    @Override // l5.a
    public void e() {
        B();
        I();
        E();
    }

    @Override // l5.a
    public void g() {
    }

    public void v(String str, String str2, boolean z10) {
        t9.i.g(str, "account");
        t9.i.g(str2, "password");
        if (com.mobile.brasiltv.utils.b0.J(str)) {
            this.f15308b.n(R.string.enter_account_hint);
            return;
        }
        if (com.mobile.brasiltv.utils.b0.J(str2)) {
            this.f15308b.n(R.string.enter_password_hint);
            return;
        }
        if (!com.mobile.brasiltv.utils.j1.f(str2)) {
            this.f15308b.n(R.string.password_format_incorrect);
            return;
        }
        String str3 = com.mobile.brasiltv.utils.j1.e(str) ? "1" : ba.t.o(str, "@", false, 2, null) ? "2" : CdnType.DIGITAL_TYPE_PEERSTAR;
        String e10 = ma.m.e(str2);
        t9.i.f(e10, "md5(password)");
        M(str, e10, str3, "", "", z10);
    }

    public final void w() {
        Disposable disposable = this.f15311e;
        boolean z10 = false;
        if (disposable != null && !disposable.isDisposed()) {
            z10 = true;
        }
        if (z10) {
            Disposable disposable2 = this.f15311e;
            if (disposable2 != null) {
                disposable2.dispose();
            }
            this.f15311e = null;
        }
    }

    public void x() {
        z();
        y();
        w();
        A();
    }

    public final void y() {
        Disposable disposable = this.f15310d;
        boolean z10 = false;
        if (disposable != null && !disposable.isDisposed()) {
            z10 = true;
        }
        if (z10) {
            Disposable disposable2 = this.f15310d;
            if (disposable2 != null) {
                disposable2.dispose();
            }
            this.f15310d = null;
        }
    }

    public final void z() {
        Disposable disposable = this.f15309c;
        boolean z10 = false;
        if (disposable != null && !disposable.isDisposed()) {
            z10 = true;
        }
        if (z10) {
            Disposable disposable2 = this.f15309c;
            if (disposable2 != null) {
                disposable2.dispose();
            }
            this.f15309c = null;
        }
    }
}
