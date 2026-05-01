package k6;

import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import com.advertlib.bean.AdInfo;
import com.mobile.brasiltv.activity.MainAty;
import com.mobile.brasiltv.app.App;
import com.msandroid.mobile.R;
import com.titans.entity.CdnType;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.io.File;
import java.util.Arrays;
import java.util.Map;
import k6.k4;

/* loaded from: classes3.dex */
public final class k4 implements i6.x0 {

    /* renamed from: a, reason: collision with root package name */
    public final f5.c f15374a;

    /* renamed from: b, reason: collision with root package name */
    public final i6.y0 f15375b;

    /* renamed from: c, reason: collision with root package name */
    public final String f15376c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f15377d;

    /* renamed from: e, reason: collision with root package name */
    public String f15378e;

    /* renamed from: f, reason: collision with root package name */
    public String f15379f;

    /* renamed from: g, reason: collision with root package name */
    public Disposable f15380g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f15381h;

    /* renamed from: i, reason: collision with root package name */
    public Boolean f15382i;

    public static final class a extends t9.j implements s9.l {
        public a() {
            super(1);
        }

        public final void b(Void r12) {
        }

        @Override // s9.l
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            b((Void) obj);
            return h9.t.f14242a;
        }
    }

    public static final class b extends t9.j implements s9.l {

        /* renamed from: a, reason: collision with root package name */
        public static final b f15384a = new b();

        public b() {
            super(1);
        }

        @Override // s9.l
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((Throwable) obj);
            return h9.t.f14242a;
        }

        public final void invoke(Throwable th) {
            th.printStackTrace();
        }
    }

    public static final class c extends t9.j implements s9.l {

        public static final class a extends t9.j implements s9.l {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ k4 f15386a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(k4 k4Var) {
                super(1);
                this.f15386a = k4Var;
            }

            @Override // s9.l
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Boolean) obj);
                return h9.t.f14242a;
            }

            public final void invoke(Boolean bool) {
                t9.i.f(bool, "granted");
                if (!bool.booleanValue()) {
                    this.f15386a.z().V(new String[]{"android.permission.READ_MEDIA_IMAGES"});
                } else {
                    this.f15386a.z().B0();
                    this.f15386a.F();
                }
            }
        }

        public c() {
            super(1);
        }

        public static final void c(s9.l lVar, Object obj) {
            t9.i.g(lVar, "$tmp0");
            lVar.invoke(obj);
        }

        @Override // s9.l
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((Boolean) obj);
            return h9.t.f14242a;
        }

        public final void invoke(Boolean bool) {
            k4.this.M(bool);
            k4.this.N(false);
            t9.i.f(bool, "readFinished");
            if (bool.booleanValue()) {
                k4.this.z().B0();
                k4.this.A();
            } else {
                Observable o10 = new c8.b(k4.this.x()).o("android.permission.READ_MEDIA_IMAGES");
                final a aVar = new a(k4.this);
                o10.subscribe(new Consumer() { // from class: k6.l4
                    @Override // io.reactivex.functions.Consumer
                    public final void accept(Object obj) {
                        k4.c.c(s9.l.this, obj);
                    }
                });
            }
        }
    }

    public static final class d extends t9.j implements s9.l {

        /* renamed from: a, reason: collision with root package name */
        public static final d f15387a = new d();

        public d() {
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

    public static final class e extends t9.j implements s9.l {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String[] f15389b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(String[] strArr) {
            super(1);
            this.f15389b = strArr;
        }

        @Override // s9.l
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((Boolean) obj);
            return h9.t.f14242a;
        }

        public final void invoke(Boolean bool) {
            t9.i.f(bool, "granted");
            if (!bool.booleanValue()) {
                k4.this.z().V(this.f15389b);
            } else {
                k4.this.z().B0();
                k4.this.F();
            }
        }
    }

    public k4(f5.c cVar, i6.y0 y0Var) {
        t9.i.g(cVar, com.umeng.analytics.pro.f.X);
        t9.i.g(y0Var, "view");
        this.f15374a = cVar;
        this.f15375b = y0Var;
        y0Var.Y0(this);
        this.f15376c = "SplashPresenter";
        this.f15377d = true;
        this.f15378e = "";
        this.f15379f = "";
    }

    public static final void G(k4 k4Var, ObservableEmitter observableEmitter) {
        t9.i.g(k4Var, "this$0");
        t9.i.g(observableEmitter, "it");
        if (t9.i.b(k4Var.f15382i, Boolean.FALSE)) {
            com.mobile.brasiltv.utils.y0 y0Var = com.mobile.brasiltv.utils.y0.f8789a;
            f5.c cVar = k4Var.f15374a;
            t9.i.d(cVar);
            observableEmitter.onNext(Boolean.valueOf(y0Var.F(cVar)));
        } else {
            com.mobile.brasiltv.utils.y0 y0Var2 = com.mobile.brasiltv.utils.y0.f8789a;
            f5.c cVar2 = k4Var.f15374a;
            t9.i.d(cVar2);
            observableEmitter.onNext(Boolean.valueOf(y0Var2.G(cVar2)));
        }
        observableEmitter.onComplete();
    }

    public static final void H(s9.l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    public static final void I(s9.l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    public static final void K(s9.l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    public static final void s(k4 k4Var, ObservableEmitter observableEmitter) {
        t9.i.g(k4Var, "this$0");
        t9.i.g(observableEmitter, "it");
        com.mobile.brasiltv.utils.i iVar = com.mobile.brasiltv.utils.i.f8717a;
        if (iVar.a(k4Var.f15374a, "key_copy_ca_version", 0) == 60201) {
            return;
        }
        String str = k4Var.f15374a.getFilesDir().getAbsolutePath() + File.separator + "cacert.pem";
        boolean a10 = z6.a.a(k4Var.f15374a, "cacert.pem", str);
        new File(str).setExecutable(true, true);
        if (a10) {
            iVar.b(k4Var.f15374a, "key_copy_ca_version", 60201);
        }
    }

    public static final void t(s9.l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    public static final void u(s9.l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    public static final void w(k4 k4Var) {
        t9.i.g(k4Var, "this$0");
        k4Var.r();
    }

    public final void A() {
        AdInfo K = s1.m.f18686a.K(this.f15374a, "picture");
        if (K != null) {
            this.f15375b.f2(K);
        } else {
            this.f15375b.A1();
        }
    }

    public void B(AdInfo adInfo) {
        t9.i.g(adInfo, "adInfo");
        String action = adInfo.getAction();
        if (t9.i.b(adInfo.getAction_type(), "1")) {
            boolean z10 = false;
            if (action != null && action.length() > 0) {
                z10 = true;
            }
            if (z10) {
                Disposable disposable = this.f15380g;
                if (disposable != null) {
                    disposable.dispose();
                }
                com.mobile.brasiltv.utils.i1.e(this.f15374a, "EVENT_AD_CLICK_SPLASH");
                s1.q qVar = s1.q.f18727a;
                f5.c cVar = this.f15374a;
                qVar.h(cVar, d6.b.f12660a.m(cVar), a6.a.f228a.b(), adInfo);
                com.mobile.brasiltv.utils.b0.j0(this.f15374a, action, true, true, false, false, 24, null);
                this.f15374a.finish();
                return;
            }
        }
        if (t9.i.b(adInfo.getAction_type(), CdnType.DIGITAL_TYPE_PCDN)) {
            com.mobile.brasiltv.utils.b0.m(this.f15374a);
        }
    }

    public final void C() {
        int i10 = 0;
        SharedPreferences sharedPreferences = this.f15374a.getSharedPreferences("show_introduce", 0);
        if (sharedPreferences.getAll().isEmpty()) {
            return;
        }
        App.a aVar = App.f8263e;
        if (aVar.a().j().h()) {
            aVar.a().j().n(false);
            Map<String, ?> all = sharedPreferences.getAll();
            t9.i.f(all, "oldIntroSp.all");
            for (Map.Entry<String, ?> entry : all.entrySet()) {
                if (entry.getValue() instanceof Boolean) {
                    try {
                        String key = entry.getKey();
                        t9.i.e(key, "null cannot be cast to non-null type kotlin.String");
                        i10 = Integer.parseInt(key);
                    } catch (NumberFormatException e10) {
                        e10.printStackTrace();
                    }
                }
            }
            App.f8263e.a().j().m(String.valueOf(i10));
        }
    }

    public final void D() {
        if (this.f15377d || TextUtils.equals(this.f15378e, this.f15379f)) {
            return;
        }
        App.f8263e.a().j().p(this.f15379f);
    }

    public final void E() {
        C();
        L();
        D();
    }

    public final void F() {
        if (t9.i.b(this.f15382i, Boolean.TRUE) || this.f15381h) {
            return;
        }
        this.f15381h = true;
        Observable compose = Observable.create(new ObservableOnSubscribe() { // from class: k6.h4
            @Override // io.reactivex.ObservableOnSubscribe
            public final void subscribe(ObservableEmitter observableEmitter) {
                k4.G(k4.this, observableEmitter);
            }
        }).compose(com.mobile.brasiltv.utils.p0.b());
        final c cVar = new c();
        Consumer consumer = new Consumer() { // from class: k6.i4
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                k4.H(s9.l.this, obj);
            }
        };
        final d dVar = d.f15387a;
        compose.subscribe(consumer, new Consumer() { // from class: k6.j4
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                k4.I(s9.l.this, obj);
            }
        });
    }

    public void J() {
        String[] strArr = Build.VERSION.SDK_INT >= 33 ? new String[]{"android.permission.READ_MEDIA_AUDIO"} : new String[]{"android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.READ_EXTERNAL_STORAGE"};
        f5.c cVar = this.f15374a;
        t9.i.d(cVar);
        Observable o10 = new c8.b(cVar).o((String[]) Arrays.copyOf(strArr, strArr.length));
        final e eVar = new e(strArr);
        o10.subscribe(new Consumer() { // from class: k6.d4
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                k4.K(s9.l.this, obj);
            }
        });
    }

    public final void L() {
        String a10 = com.mobile.brasiltv.utils.e.a(this.f15374a);
        t9.i.f(a10, "getAppVersionCode(context)");
        this.f15379f = a10;
        App.a aVar = App.f8263e;
        this.f15377d = aVar.a().j().h();
        this.f15378e = aVar.a().j().d();
    }

    public final void M(Boolean bool) {
        this.f15382i = bool;
    }

    public final void N(boolean z10) {
        this.f15381h = z10;
    }

    public final void O() {
        this.f15374a.overridePendingTransition(R.anim.alpha_in, R.anim.alpha_out);
        P();
        com.mobile.brasiltv.utils.b0.c0(this.f15374a, MainAty.class);
        this.f15374a.finish();
    }

    public final void P() {
        App.f8263e.a().j().m(this.f15379f);
    }

    @Override // l5.a
    public void e() {
        v();
    }

    @Override // l5.a
    public void g() {
    }

    public final void r() {
        Observable create = Observable.create(new ObservableOnSubscribe() { // from class: k6.e4
            @Override // io.reactivex.ObservableOnSubscribe
            public final void subscribe(ObservableEmitter observableEmitter) {
                k4.s(k4.this, observableEmitter);
            }
        });
        final a aVar = new a();
        Consumer consumer = new Consumer() { // from class: k6.f4
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                k4.t(s9.l.this, obj);
            }
        };
        final b bVar = b.f15384a;
        create.subscribe(consumer, new Consumer() { // from class: k6.g4
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                k4.u(s9.l.this, obj);
            }
        });
    }

    public final void v() {
        Uri data = this.f15374a.getIntent().getData();
        if (data != null && TextUtils.equals("sxl", data.getScheme()) && TextUtils.equals(s6.a.f18777a.a().h(), data.getHost()) && MainAty.A.h()) {
            com.mobile.brasiltv.utils.b0.c0(this.f15374a, MainAty.class);
            this.f15374a.finish();
            return;
        }
        E();
        if ((this.f15377d || !TextUtils.equals(this.f15378e, this.f15379f)) && !q5.i.f18197a.j(this.f15374a)) {
            MainAty.A.q(true);
        }
        J();
        new Thread(new Runnable() { // from class: k6.c4
            @Override // java.lang.Runnable
            public final void run() {
                k4.w(k4.this);
            }
        }).start();
    }

    public final f5.c x() {
        return this.f15374a;
    }

    public final Boolean y() {
        return this.f15382i;
    }

    public final i6.y0 z() {
        return this.f15375b;
    }
}
