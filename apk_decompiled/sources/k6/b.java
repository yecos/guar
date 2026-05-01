package k6;

import android.text.TextUtils;
import com.mobile.brasiltv.activity.MainAty;
import com.mobile.brasiltv.bean.event.CloseForcePageEvent;
import com.mobile.brasiltv.bean.event.GotoHomeTabEvent;
import com.mobile.brasiltv.bean.event.UpdateMineViewEvent;
import com.mobile.brasiltv.mine.activity.ForceChangePwdAty;
import com.mobile.brasiltv.view.dialog.NumberLimitDialog;
import com.msandroid.mobile.R;
import io.reactivex.disposables.Disposable;
import mobile.com.requestframe.utils.bean.BindBean;
import mobile.com.requestframe.utils.bean.LoginThirdPartBean;
import mobile.com.requestframe.utils.response.BindThirdPart;
import mobile.com.requestframe.utils.response.BindThirdPartResult;
import mobile.com.requestframe.utils.response.LoginResult;
import mobile.com.requestframe.utils.response.UserData;
import w6.i;

/* loaded from: classes3.dex */
public final class b implements l5.a {

    /* renamed from: a, reason: collision with root package name */
    public final f5.c f15021a;

    /* renamed from: b, reason: collision with root package name */
    public final i6.c f15022b;

    public static final class a extends ha.a {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f15024b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ x7.a f15025c;

        /* renamed from: k6.b$a$a, reason: collision with other inner class name */
        public static final class C0245a extends t9.j implements s9.l {

            /* renamed from: a, reason: collision with root package name */
            public static final C0245a f15026a = new C0245a();

            public C0245a() {
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

        /* renamed from: k6.b$a$b, reason: collision with other inner class name */
        public static final class C0246b extends t9.j implements s9.l {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ String f15027a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0246b(String str) {
                super(1);
                this.f15027a = str;
            }

            @Override // s9.l
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((String) obj);
                return h9.t.f14242a;
            }

            public final void invoke(String str) {
                com.mobile.brasiltv.utils.f1.f8649a.x(com.mobile.brasiltv.utils.y.p(com.mobile.brasiltv.utils.y.f8771a, this.f15027a, null, null, 6, null));
            }
        }

        public a(String str, x7.a aVar) {
            this.f15024b = str;
            this.f15025c = aVar;
        }

        @Override // ha.a, io.reactivex.Observer
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void onNext(LoginResult loginResult) {
            t9.i.g(loginResult, "t");
            b.this.l().showLoading(false);
            b.this.l().q();
            b.this.l().t(false);
            UserData data = loginResult.getData();
            if (!com.mobile.brasiltv.utils.b0.I(data != null ? data.getPortalCodeList() : null)) {
                com.mobile.brasiltv.utils.x.f8754a.w(b.this.k(), C0245a.f15026a);
                return;
            }
            d6.b bVar = d6.b.f12660a;
            UserData data2 = loginResult.getData();
            t9.i.d(data2);
            bVar.H(data2);
            bVar.E(b.this.k(), this.f15024b);
            f5.c k10 = b.this.k();
            UserData data3 = loginResult.getData();
            t9.i.d(data3);
            bVar.F(k10, data3, "", "", (r21 & 16) != 0 ? "" : this.f15024b, (r21 & 32) != 0 ? "" : this.f15025c.a(), (r21 & 64) != 0 ? "" : null, (r21 & 128) != 0);
            if (!TextUtils.isEmpty(this.f15024b)) {
                UserData data4 = loginResult.getData();
                if (t9.i.b(data4 != null ? data4.getPwdTip() : null, "yes")) {
                    UserData data5 = loginResult.getData();
                    if (t9.i.b(data5 != null ? data5.getHasPwd() : null, "1")) {
                        com.mobile.brasiltv.utils.b0.c0(b.this.k(), ForceChangePwdAty.class);
                        s5.e.f18766a.o(s5.c.THIRD_PART_LOGIN, this.f15024b, this.f15025c, "0", "2", null);
                        return;
                    }
                }
            }
            bVar.C(loginResult.getData());
            xa.c.c().j(new CloseForcePageEvent());
            xa.c.c().j(new GotoHomeTabEvent(0));
            com.mobile.brasiltv.utils.b0.c0(b.this.k(), MainAty.class);
        }

        @Override // ha.a
        public void showErrorHint(String str) {
            t9.i.g(str, "returnCode");
            b.this.l().showLoading(false);
            b.this.l().q();
            b.this.l().t(false);
            if (t9.i.b("aaa100094", str)) {
                new NumberLimitDialog(b.this.k()).show();
            } else {
                com.mobile.brasiltv.utils.x.f8754a.w(b.this.k(), new C0246b(str));
            }
        }
    }

    /* renamed from: k6.b$b, reason: collision with other inner class name */
    public static final class C0247b extends ha.a {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f15029b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ x7.a f15030c;

        /* renamed from: k6.b$b$a */
        public static final class a extends t9.j implements s9.l {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ String f15031a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(String str) {
                super(1);
                this.f15031a = str;
            }

            @Override // s9.l
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((String) obj);
                return h9.t.f14242a;
            }

            public final void invoke(String str) {
                com.mobile.brasiltv.utils.f1.f8649a.x(com.mobile.brasiltv.utils.y.p(com.mobile.brasiltv.utils.y.f8771a, this.f15031a, null, null, 6, null));
            }
        }

        public C0247b(String str, x7.a aVar) {
            this.f15029b = str;
            this.f15030c = aVar;
        }

        @Override // ha.a, io.reactivex.Observer
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void onNext(BindThirdPartResult bindThirdPartResult) {
            String str;
            String googlePhotoUrl;
            t9.i.g(bindThirdPartResult, "t");
            if (d6.b.f12660a.t()) {
                b.this.i(this.f15029b, this.f15030c);
                return;
            }
            b.this.l().showLoading(false);
            b.this.l().q();
            b.this.l().t(false);
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
        }

        @Override // ha.a, io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            t9.i.g(disposable, "d");
            super.onSubscribe(disposable);
            b.this.l().showLoading(true);
            b.this.l().t(true);
        }

        @Override // ha.a
        public void showErrorHint(String str) {
            t9.i.g(str, "returnCode");
            b.this.l().showLoading(false);
            b.this.l().q();
            b.this.l().t(false);
            if (com.mobile.brasiltv.utils.b0.T(str, "portal100076")) {
                b.this.l().n(R.string.am_google_been_bound);
            } else {
                com.mobile.brasiltv.utils.x.f8754a.w(b.this.k(), new a(str));
            }
        }
    }

    public b(f5.c cVar, i6.c cVar2) {
        t9.i.g(cVar, com.umeng.analytics.pro.f.X);
        t9.i.g(cVar2, "view");
        this.f15021a = cVar;
        this.f15022b = cVar2;
    }

    @Override // l5.a
    public void e() {
    }

    @Override // l5.a
    public void g() {
    }

    public final void i(String str, x7.a aVar) {
        w6.i.f19214g.b().Z1(new LoginThirdPartBean(str, aVar.a(), "0", "2", null, 16, null)).compose(this.f15021a.O1()).subscribe(new a(str, aVar));
    }

    public void j(String str, x7.a aVar) {
        t9.i.g(str, "thirdPartType");
        t9.i.g(aVar, "socialInfo");
        i.c cVar = w6.i.f19214g;
        cVar.b().R0(new BindBean(cVar.H(), cVar.J(), cVar.v(), str, aVar.a())).compose(this.f15021a.O1()).subscribe(new C0247b(str, aVar));
    }

    public final f5.c k() {
        return this.f15021a;
    }

    public final i6.c l() {
        return this.f15022b;
    }
}
