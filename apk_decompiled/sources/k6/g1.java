package k6;

import com.mobile.brasiltv.bean.MemberInfo;
import com.msandroid.mobile.R;
import i6.y;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import java.util.List;
import mobile.com.requestframe.utils.response.Favorite;
import mobile.com.requestframe.utils.response.GetFavoriteDate;
import mobile.com.requestframe.utils.response.GetFavoriteResult;
import mobile.com.requestframe.utils.response.PwdCheckResult;

/* loaded from: classes3.dex */
public final class g1 implements i6.y {

    /* renamed from: a, reason: collision with root package name */
    public final f5.c f15177a;

    /* renamed from: b, reason: collision with root package name */
    public final i6.z f15178b;

    /* renamed from: c, reason: collision with root package name */
    public Disposable f15179c;

    /* renamed from: d, reason: collision with root package name */
    public Disposable f15180d;

    /* renamed from: e, reason: collision with root package name */
    public List f15181e;

    /* renamed from: f, reason: collision with root package name */
    public List f15182f;

    public static final class a extends ha.a {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f15184b;

        /* renamed from: k6.g1$a$a, reason: collision with other inner class name */
        public static final class C0252a extends t9.j implements s9.l {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ String f15185a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0252a(String str) {
                super(1);
                this.f15185a = str;
            }

            @Override // s9.l
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((String) obj);
                return h9.t.f14242a;
            }

            public final void invoke(String str) {
                com.mobile.brasiltv.utils.f1.f8649a.x(com.mobile.brasiltv.utils.y.p(com.mobile.brasiltv.utils.y.f8771a, this.f15185a, null, null, 6, null));
            }
        }

        public a(String str) {
            this.f15184b = str;
        }

        @Override // ha.a, io.reactivex.Observer
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void onNext(PwdCheckResult pwdCheckResult) {
            t9.i.g(pwdCheckResult, "t");
            MemberInfo memberInfo = MemberInfo.INSTANCE;
            String e10 = ma.m.e(this.f15184b);
            t9.i.f(e10, "md5(password)");
            memberInfo.putPassword(e10, false);
            g1.this.o().y(false);
            g1.this.o().I();
        }

        @Override // ha.a, io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            t9.i.g(disposable, "d");
            super.onSubscribe(disposable);
            g1.this.o().y(true);
        }

        @Override // ha.a
        public void showErrorHint(String str) {
            t9.i.g(str, "returnCode");
            g1.this.o().y(false);
            if (com.mobile.brasiltv.utils.b0.T(str, "aaa100012")) {
                com.mobile.brasiltv.utils.f1.f8649a.w(R.string.pwd_wrong);
                return;
            }
            if (com.mobile.brasiltv.utils.b0.T(str, "50010") || com.mobile.brasiltv.utils.b0.T(str, "50011") || com.mobile.brasiltv.utils.b0.T(str, "50012") || com.mobile.brasiltv.utils.b0.T(str, "50014")) {
                com.mobile.brasiltv.utils.f1.f8649a.w(R.string.pi_connect_timeout);
            } else {
                com.mobile.brasiltv.utils.x.f8754a.w(g1.this.l(), new C0252a(str));
            }
        }
    }

    public static final class b extends t9.j implements s9.l {

        /* renamed from: a, reason: collision with root package name */
        public static final b f15186a = new b();

        public b() {
            super(1);
        }

        @Override // s9.l
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final GetFavoriteDate invoke(GetFavoriteResult getFavoriteResult) {
            t9.i.g(getFavoriteResult, "it");
            return getFavoriteResult.getData();
        }
    }

    public static final class c extends ha.a {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f15187a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ g1 f15188b;

        public static final class a extends t9.j implements s9.l {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ String f15189a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(String str) {
                super(1);
                this.f15189a = str;
            }

            @Override // s9.l
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((String) obj);
                return h9.t.f14242a;
            }

            public final void invoke(String str) {
                com.mobile.brasiltv.utils.f1.f8649a.x(com.mobile.brasiltv.utils.y.p(com.mobile.brasiltv.utils.y.f8771a, this.f15189a, null, null, 6, null));
            }
        }

        public c(boolean z10, g1 g1Var) {
            this.f15187a = z10;
            this.f15188b = g1Var;
        }

        @Override // ha.a, io.reactivex.Observer
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void onNext(GetFavoriteDate getFavoriteDate) {
            t9.i.g(getFavoriteDate, "t");
            if (this.f15187a) {
                this.f15188b.q(getFavoriteDate.getFavoriteList());
            } else {
                this.f15188b.r(getFavoriteDate.getFavoriteList());
            }
            if (!com.mobile.brasiltv.utils.b0.I(getFavoriteDate.getFavoriteList())) {
                this.f15188b.o().a0(this.f15187a);
                return;
            }
            i6.z o10 = this.f15188b.o();
            List<Favorite> favoriteList = getFavoriteDate.getFavoriteList();
            t9.i.d(favoriteList);
            o10.H0(favoriteList, this.f15187a);
        }

        @Override // ha.a, io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            t9.i.g(disposable, "d");
            if (this.f15187a) {
                this.f15188b.f15180d = disposable;
            } else {
                this.f15188b.f15179c = disposable;
            }
        }

        @Override // ha.a
        public void showErrorHint(String str) {
            t9.i.g(str, "returnCode");
            this.f15188b.o().e1(str, this.f15187a);
            com.mobile.brasiltv.utils.x.f8754a.w(this.f15188b.l(), new a(str));
        }
    }

    public g1(f5.c cVar, i6.z zVar) {
        t9.i.g(cVar, com.umeng.analytics.pro.f.X);
        t9.i.g(zVar, "view");
        this.f15177a = cVar;
        this.f15178b = zVar;
    }

    public static final GetFavoriteDate p(s9.l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        return (GetFavoriteDate) lVar.invoke(obj);
    }

    @Override // i6.y
    public void d(boolean z10) {
        Disposable disposable;
        Disposable disposable2;
        Disposable disposable3 = this.f15179c;
        if (((disposable3 == null || disposable3.isDisposed()) ? false : true) && (disposable2 = this.f15179c) != null) {
            disposable2.dispose();
        }
        Disposable disposable4 = this.f15180d;
        if (((disposable4 == null || disposable4.isDisposed()) ? false : true) && (disposable = this.f15180d) != null) {
            disposable.dispose();
        }
        Observable compose = w6.i.f19214g.b().u1("vod", z10 ? "1" : "0").compose(this.f15177a.O1());
        final b bVar = b.f15186a;
        compose.map(new Function() { // from class: k6.f1
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                GetFavoriteDate p10;
                p10 = g1.p(s9.l.this, obj);
                return p10;
            }
        }).subscribe(new c(z10, this));
    }

    @Override // l5.a
    public void e() {
        if (w6.i.f19214g.I().length() > 0) {
            y.a.a(this, false, 1, null);
        }
    }

    @Override // l5.a
    public void g() {
    }

    public void k(String str) {
        t9.i.g(str, "password");
        w6.i b10 = w6.i.f19214g.b();
        String e10 = ma.m.e(str);
        t9.i.f(e10, "md5(password)");
        b10.d2(e10).compose(this.f15177a.O1()).subscribe(new a(str));
    }

    public final f5.c l() {
        return this.f15177a;
    }

    public final List m() {
        return this.f15182f;
    }

    public final List n() {
        return this.f15181e;
    }

    public final i6.z o() {
        return this.f15178b;
    }

    public final void q(List list) {
        this.f15182f = list;
    }

    public final void r(List list) {
        this.f15181e = list;
    }
}
