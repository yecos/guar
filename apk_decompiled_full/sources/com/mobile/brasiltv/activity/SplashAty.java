package com.mobile.brasiltv.activity;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.net.Uri;
import android.os.Build;
import android.os.Process;
import android.util.Pair;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import c2.i;
import com.advertlib.bean.AdInfo;
import com.dcs.bean.DomainInfo;
import com.mobile.brasiltv.R$id;
import com.mobile.brasiltv.activity.SplashAty;
import com.mobile.brasiltv.app.App;
import com.mobile.brasiltv.utils.b0;
import com.mobile.brasiltv.utils.f1;
import com.mobile.brasiltv.utils.g1;
import com.mobile.brasiltv.utils.i1;
import com.mobile.brasiltv.utils.n0;
import com.mobile.brasiltv.utils.o;
import com.mobile.brasiltv.utils.x;
import com.mobile.brasiltv.view.OpenNotifyDialog;
import com.mobile.brasiltv.view.dialog.StandardDialog;
import com.msandroid.mobile.R;
import com.titans.entity.CdnType;
import com.zhy.autolayout.AutoRelativeLayout;
import h9.t;
import i6.x0;
import i6.y0;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import k6.k4;
import s1.m;
import s1.q;
import s9.l;
import t9.i;
import t9.j;
import w6.l;

/* loaded from: classes3.dex */
public final class SplashAty extends f5.d implements y0, OpenNotifyDialog.NotificationListener {

    /* renamed from: t, reason: collision with root package name */
    public static boolean f8184t;

    /* renamed from: u, reason: collision with root package name */
    public static boolean f8185u;

    /* renamed from: l, reason: collision with root package name */
    public StandardDialog f8187l;

    /* renamed from: m, reason: collision with root package name */
    public k4 f8188m;

    /* renamed from: o, reason: collision with root package name */
    public Disposable f8190o;

    /* renamed from: p, reason: collision with root package name */
    public Disposable f8191p;

    /* renamed from: s, reason: collision with root package name */
    public static final a f8183s = new a(null);

    /* renamed from: v, reason: collision with root package name */
    public static String f8186v = "";

    /* renamed from: r, reason: collision with root package name */
    public Map f8193r = new LinkedHashMap();

    /* renamed from: n, reason: collision with root package name */
    public final long f8189n = 5;

    /* renamed from: q, reason: collision with root package name */
    public String f8192q = "";

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(t9.g gVar) {
            this();
        }

        public final boolean a() {
            return SplashAty.f8184t;
        }

        public final void b(boolean z10) {
            SplashAty.f8184t = z10;
        }
    }

    public static final class b extends j implements l {

        public static final class a extends j implements l {

            /* renamed from: a, reason: collision with root package name */
            public static final a f8195a = new a();

            public a() {
                super(1);
            }

            @Override // s9.l
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Long) obj);
                return t.f14242a;
            }

            public final void invoke(Long l10) {
                ma.l.a("check");
                ma.h hVar = ma.h.f16853a;
                App.a aVar = App.f8263e;
                App a10 = aVar.a();
                String packageName = aVar.a().getPackageName();
                i.f(packageName, "App.instance.getPackageName()");
                hVar.d(a10, packageName);
            }
        }

        /* renamed from: com.mobile.brasiltv.activity.SplashAty$b$b, reason: collision with other inner class name */
        public static final class C0164b extends j implements l {

            /* renamed from: a, reason: collision with root package name */
            public static final C0164b f8196a = new C0164b();

            public C0164b() {
                super(1);
            }

            @Override // s9.l
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Long) obj);
                return t.f14242a;
            }

            public final void invoke(Long l10) {
                ma.l.a("check");
                ma.h hVar = ma.h.f16853a;
                App.a aVar = App.f8263e;
                App a10 = aVar.a();
                String packageName = aVar.a().getPackageName();
                i.f(packageName, "App.instance.getPackageName()");
                hVar.d(a10, packageName);
            }
        }

        public b() {
            super(1);
        }

        public static final void f(SplashAty splashAty) {
            i.g(splashAty, "this$0");
            f1.a.p(f1.f8649a, splashAty, "EA18, " + x.f8754a.y(splashAty.Q1(), R.string.contact_seller), 0, 4, null);
        }

        public static final void g(l lVar, Object obj) {
            i.g(lVar, "$tmp0");
            lVar.invoke(obj);
        }

        public static final void h(SplashAty splashAty) {
            i.g(splashAty, "this$0");
            f1.a.p(f1.f8649a, splashAty, "EA31 " + x.f8754a.y(splashAty.Q1(), R.string.contact_seller), 0, 4, null);
        }

        public static final void i(l lVar, Object obj) {
            i.g(lVar, "$tmp0");
            lVar.invoke(obj);
        }

        @Override // s9.l
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((String) obj);
            return t.f14242a;
        }

        /* JADX WARN: Code restructure failed: missing block: B:36:0x0029, code lost:
        
            if (t9.i.b("", "") != false) goto L12;
         */
        /* JADX WARN: Code restructure failed: missing block: B:4:0x0019, code lost:
        
            if (t9.i.b("", "") != false) goto L12;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final void invoke(String str) {
            String str2;
            String str3;
            String str4;
            Object obj;
            Object obj2;
            ma.h hVar = ma.h.f16853a;
            boolean f10 = hVar.f();
            boolean b10 = hVar.b();
            if (f10) {
                str2 = "4";
                SplashAty.this.f8192q = "4";
            } else {
                if (b10) {
                    SplashAty splashAty = SplashAty.this;
                    str2 = CdnType.DIGITAL_TYPE_PEERSTAR;
                    splashAty.f8192q = CdnType.DIGITAL_TYPE_PEERSTAR;
                }
                str2 = "";
            }
            if (f10 || b10) {
                na.f.l(SplashAty.this, "deviceTag", str2);
                na.c.d();
                Pair b11 = m7.c.b();
                if (b11 == null || (obj2 = b11.first) == null || (str3 = obj2.toString()) == null) {
                    str3 = b2.a.f4468g;
                }
                if (b11 == null || (obj = b11.second) == null || (str4 = obj.toString()) == null) {
                    str4 = b2.a.f4468g;
                }
                t2.a aVar = t2.a.f18798a;
                i.f(str3, "bbMainDomain");
                i.f(str4, "bbSecondDomain");
                DomainInfo b12 = aVar.b(str3, str4, "key_tdc");
                i.b bVar = c2.i.f5350q;
                bVar.a().B(b12);
                c2.l lVar = c2.l.f5383a;
                String g10 = na.a.g();
                t9.i.f(g10, "getPackageName()");
                String valueOf = String.valueOf(na.a.b());
                String str5 = Build.VERSION.RELEASE;
                t9.i.f(str5, "RELEASE");
                String str6 = Build.MODEL;
                t9.i.f(str6, "MODEL");
                String y10 = com.mobile.brasiltv.utils.y0.f8789a.y(SplashAty.this.Q1());
                String str7 = na.c.f17339a;
                t9.i.f(str7, "reserve1");
                lVar.d(g10, valueOf, str5, str6, y10, str7, "", "", "");
                bVar.a().i("");
                c2.d dVar = c2.d.f5311a;
                dVar.p(SplashAty.this.f8192q);
                dVar.i();
                bVar.a().t();
                i1.u(App.f8263e.a(), SplashAty.this.f8192q);
                final SplashAty splashAty2 = SplashAty.this;
                splashAty2.runOnUiThread(new Runnable() { // from class: f5.l5
                    @Override // java.lang.Runnable
                    public final void run() {
                        SplashAty.b.f(SplashAty.this);
                    }
                });
                Observable<Long> timer = Observable.timer(3L, TimeUnit.SECONDS);
                final a aVar2 = a.f8195a;
                timer.subscribe(new Consumer() { // from class: f5.m5
                    @Override // io.reactivex.functions.Consumer
                    public final void accept(Object obj3) {
                        SplashAty.b.g(s9.l.this, obj3);
                    }
                });
            } else if (hVar.a()) {
                SplashAty.this.f8192q = "2";
                i1.u(App.f8263e.a(), SplashAty.this.f8192q);
            }
            App.a aVar3 = App.f8263e;
            if (!o.c(aVar3.a()) || g1.f8693a.d(aVar3.a())) {
                return;
            }
            i1.M(SplashAty.this.Q1(), "1");
            final SplashAty splashAty3 = SplashAty.this;
            splashAty3.runOnUiThread(new Runnable() { // from class: f5.n5
                @Override // java.lang.Runnable
                public final void run() {
                    SplashAty.b.h(SplashAty.this);
                }
            });
            Observable<Long> timer2 = Observable.timer(2L, TimeUnit.SECONDS);
            final C0164b c0164b = C0164b.f8196a;
            timer2.subscribe(new Consumer() { // from class: f5.o5
                @Override // io.reactivex.functions.Consumer
                public final void accept(Object obj3) {
                    SplashAty.b.i(s9.l.this, obj3);
                }
            });
        }
    }

    public static final class c extends j implements l {

        /* renamed from: a, reason: collision with root package name */
        public static final c f8197a = new c();

        public c() {
            super(1);
        }

        public final void invoke(Throwable th) {
        }

        @Override // s9.l
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((Throwable) obj);
            return t.f14242a;
        }
    }

    public static final class d extends j implements l {
        public d() {
            super(1);
        }

        @Override // s9.l
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Long invoke(Long l10) {
            t9.i.g(l10, "it");
            return Long.valueOf(SplashAty.this.f8189n - l10.longValue());
        }
    }

    public static final class e implements Observer {
        public e() {
        }

        public void a(long j10) {
            b0.U(this, String.valueOf(j10));
            ((Button) SplashAty.this.d3(R$id.skipBtn)).setText(j10 + "s skip");
            if (0 == j10) {
                SplashAty.this.S2().O();
            }
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            t9.i.g(th, "e");
            th.printStackTrace();
        }

        @Override // io.reactivex.Observer
        public /* bridge */ /* synthetic */ void onNext(Object obj) {
            a(((Number) obj).longValue());
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            t9.i.g(disposable, "d");
            SplashAty.this.r3(disposable);
        }
    }

    public static final class f extends j implements l {
        public f() {
            super(1);
        }

        @Override // s9.l
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((Long) obj);
            return t.f14242a;
        }

        public final void invoke(Long l10) {
            SplashAty.this.S2().O();
        }
    }

    public static final class g extends j implements l {
        public g() {
            super(1);
        }

        @Override // s9.l
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((String) obj);
            return t.f14242a;
        }

        public final void invoke(String str) {
            n0 n0Var = n0.f8733a;
            if (n0Var.b(SplashAty.this, "clear", false)) {
                return;
            }
            n0Var.a(SplashAty.this);
            n0Var.g(SplashAty.this, "clear", true);
            na.f.n(SplashAty.this, new String[]{"home_data", "4596", "4608", "4599", "4601", "4607", "4600", "4603", "4597", "6357", "6358", "6360", "6361", "6362"});
        }
    }

    public static final class h extends j implements l {

        /* renamed from: a, reason: collision with root package name */
        public static final h f8202a = new h();

        public h() {
            super(1);
        }

        public final void invoke(Throwable th) {
        }

        @Override // s9.l
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((Throwable) obj);
            return t.f14242a;
        }
    }

    public static final void k3(l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    public static final void l3(l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    public static final void m3(SplashAty splashAty, View view) {
        Disposable disposable;
        t9.i.g(splashAty, "this$0");
        Disposable disposable2 = splashAty.f8190o;
        if (disposable2 != null) {
            t9.i.d(disposable2);
            if (disposable2.isDisposed()) {
                Disposable disposable3 = splashAty.f8190o;
                t9.i.d(disposable3);
                disposable3.dispose();
            }
        }
        Disposable disposable4 = splashAty.f8191p;
        if (!(disposable4 != null ? disposable4.isDisposed() : true) && (disposable = splashAty.f8191p) != null) {
            disposable.dispose();
        }
        splashAty.S2().O();
    }

    public static final void s3(SplashAty splashAty, AdInfo adInfo, View view) {
        t9.i.g(splashAty, "this$0");
        t9.i.g(adInfo, "$adInfo");
        splashAty.S2().B(adInfo);
    }

    public static final Long t3(l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        return (Long) lVar.invoke(obj);
    }

    public static final void u3(SplashAty splashAty, View view) {
        t9.i.g(splashAty, "this$0");
        splashAty.startActivity(new Intent("android.settings.APPLICATION_DETAILS_SETTINGS", Uri.parse("package:" + splashAty.Q1().getPackageName())));
    }

    public static final void v3(l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    public static final void x3(l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    public static final void y3(l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    @Override // i6.y0
    public void A1() {
        ((Button) d3(R$id.skipBtn)).setVisibility(8);
        ((AutoRelativeLayout) d3(R$id.mLayoutSplash)).setVisibility(0);
        Observable<R> compose = Observable.timer(3L, TimeUnit.SECONDS, AndroidSchedulers.mainThread()).compose(P1(t8.a.DESTROY));
        final f fVar = new f();
        compose.subscribe((Consumer<? super R>) new Consumer() { // from class: f5.k5
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                SplashAty.v3(s9.l.this, obj);
            }
        });
    }

    @Override // i6.y0
    public void B0() {
        StandardDialog standardDialog = this.f8187l;
        if (standardDialog != null) {
            standardDialog.dismiss();
        }
    }

    @Override // f5.d
    public void R2() {
        p3(new k4(this, this));
        q.f18727a.g(this);
        ma.l.c();
        n3(getIntent());
        x.f8754a.t(this);
        l.a aVar = w6.l.f19260a;
        aVar.e(aVar.d() | aVar.c());
        if (xa.c.c().h(this)) {
            xa.c.c().r(this);
        }
        f8184t = true;
        ((TextView) d3(R$id.mTextVersion)).setText('V' + com.mobile.brasiltv.utils.e.b(this));
        ((Button) d3(R$id.skipBtn)).setOnClickListener(new View.OnClickListener() { // from class: f5.c5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SplashAty.m3(SplashAty.this, view);
            }
        });
        j3();
        w3();
    }

    @Override // f5.d
    public int T2() {
        return R.layout.aty_splash;
    }

    @Override // i6.y0
    public void V(String[] strArr) {
        String str;
        t9.i.g(strArr, "permissions");
        StandardDialog standardDialog = this.f8187l;
        if (standardDialog != null) {
            t9.i.d(standardDialog);
            if (standardDialog.isShowing()) {
                return;
            }
        }
        if (i9.g.e(strArr, "android.permission.READ_MEDIA_IMAGES")) {
            str = getResources().getString(R.string.need_storage_permission) + getResources().getString(R.string.way_to_image_permission);
        } else if (i9.g.e(strArr, "android.permission.READ_MEDIA_AUDIO")) {
            str = getResources().getString(R.string.need_storage_permission) + getResources().getString(R.string.way_to_audio_permission);
        } else {
            str = getResources().getString(R.string.need_storage_permission) + getResources().getString(R.string.way_to_storage_permission);
        }
        String str2 = str;
        StandardDialog standardDialog2 = new StandardDialog(this);
        this.f8187l = standardDialog2;
        t9.i.d(standardDialog2);
        String string = getResources().getString(R.string.grant_permission);
        t9.i.f(string, "resources.getString(R.string.grant_permission)");
        String string2 = getResources().getString(R.string.go_to_setting);
        t9.i.f(string2, "resources.getString(R.string.go_to_setting)");
        standardDialog2.setDialogConfig(string, str2, null, string2, null, new View.OnClickListener() { // from class: f5.h5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SplashAty.u3(SplashAty.this, view);
            }
        });
        StandardDialog standardDialog3 = this.f8187l;
        t9.i.d(standardDialog3);
        standardDialog3.show();
    }

    public View d3(int i10) {
        Map map = this.f8193r;
        View view = (View) map.get(Integer.valueOf(i10));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i10);
        if (findViewById == null) {
            return null;
        }
        map.put(Integer.valueOf(i10), findViewById);
        return findViewById;
    }

    @Override // i6.y0
    public void f2(final AdInfo adInfo) {
        t9.i.g(adInfo, "adInfo");
        m mVar = m.f18686a;
        Context Q1 = Q1();
        int i10 = R$id.mImageAdvert;
        ImageView imageView = (ImageView) d3(i10);
        t9.i.f(imageView, "mImageAdvert");
        a6.a aVar = a6.a.f228a;
        mVar.g0(Q1, imageView, aVar.b(), adInfo, (r23 & 16) != 0 ? null : null, (r23 & 32) != 0 ? null : null, (r23 & 64) != 0 ? null : null, (r23 & 128) != 0 ? false : false, (r23 & 256) != 0 ? -1 : 0);
        q.f18727a.j(Q1(), d6.b.f12660a.m(Q1()), aVar.b(), adInfo);
        ((ImageView) d3(i10)).setOnClickListener(new View.OnClickListener() { // from class: f5.i5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SplashAty.s3(SplashAty.this, adInfo, view);
            }
        });
        ((ImageView) d3(i10)).setVisibility(0);
        int i11 = R$id.btnVersion;
        ((Button) d3(i11)).setVisibility(0);
        ((Button) d3(i11)).setText("v: " + com.mobile.brasiltv.utils.e.b(Q1()));
        i1.e(this, "EVENT_AD_SHOW_SPLASH");
        this.f8191p = i1.p(this, "EVENT_AD_LONG_SHOW_SPLASH");
        ((Button) d3(R$id.skipBtn)).setVisibility(0);
        Observable<Long> take = Observable.interval(0L, 1L, TimeUnit.SECONDS).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).take(this.f8189n + 1);
        final d dVar = new d();
        take.map(new Function() { // from class: f5.j5
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                Long t32;
                t32 = SplashAty.t3(s9.l.this, obj);
                return t32;
            }
        }).compose(O1()).subscribe(new e());
    }

    public final void j3() {
        Observable observeOn = Observable.just("").observeOn(Schedulers.io());
        final b bVar = new b();
        Consumer consumer = new Consumer() { // from class: f5.d5
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                SplashAty.k3(s9.l.this, obj);
            }
        };
        final c cVar = c.f8197a;
        observeOn.subscribe(consumer, new Consumer() { // from class: f5.e5
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                SplashAty.l3(s9.l.this, obj);
            }
        });
    }

    @Override // i5.a
    public void k2() {
        n2();
    }

    public final void n3(Intent intent) {
        Uri data = intent != null ? intent.getData() : null;
        if (data != null) {
            String scheme = data.getScheme();
            String host = data.getHost();
            if (t9.i.b(scheme, "sxl") && t9.i.b(host, s6.a.f18777a.a().h())) {
                String queryParameter = data.getQueryParameter("inviteCode");
                if (queryParameter == null) {
                    queryParameter = "";
                } else {
                    t9.i.f(queryParameter, "data.getQueryParameter(\"inviteCode\") ?: \"\"");
                }
                f8186v = queryParameter;
                b0.U(this, ">>>>浏览器启动应用>>>>  " + f8186v);
                f8185u = true;
            }
        }
    }

    @Override // f5.d
    /* renamed from: o3, reason: merged with bridge method [inline-methods] */
    public k4 S2() {
        k4 k4Var = this.f8188m;
        if (k4Var != null) {
            return k4Var;
        }
        t9.i.w("mPresenter");
        return null;
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        super.onBackPressed();
        ma.l.a("Splash");
        Process.killProcess(Process.myPid());
    }

    @Override // androidx.fragment.app.e, android.app.Activity
    public void onNewIntent(Intent intent) {
        n3(intent);
        super.onNewIntent(intent);
    }

    @Override // com.mobile.brasiltv.view.OpenNotifyDialog.NotificationListener
    public void onOpen(Dialog dialog) {
        t9.i.g(dialog, "dialog");
        S2().J();
    }

    @Override // android.app.Activity
    public void onRestart() {
        super.onRestart();
        if (!t9.i.b(S2().y(), Boolean.FALSE)) {
            S2().e();
        } else if (p.a.checkSelfPermission(Q1(), "android.permission.READ_MEDIA_IMAGES") == 0) {
            S2().J();
        }
    }

    public void p3(k4 k4Var) {
        t9.i.g(k4Var, "<set-?>");
        this.f8188m = k4Var;
    }

    @Override // m5.a
    /* renamed from: q3, reason: merged with bridge method [inline-methods] */
    public void Y0(x0 x0Var) {
        t9.i.g(x0Var, "presenter");
    }

    public final void r3(Disposable disposable) {
        this.f8190o = disposable;
    }

    @Override // f5.c, android.content.ContextWrapper, android.content.Context
    public void unbindService(ServiceConnection serviceConnection) {
        t9.i.g(serviceConnection, "conn");
        try {
            super.unbindService(serviceConnection);
        } catch (IllegalArgumentException e10) {
            e10.printStackTrace();
        }
    }

    public final void w3() {
        Observable observeOn = Observable.just("").observeOn(Schedulers.io());
        final g gVar = new g();
        Consumer consumer = new Consumer() { // from class: f5.f5
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                SplashAty.x3(s9.l.this, obj);
            }
        };
        final h hVar = h.f8202a;
        observeOn.subscribe(consumer, new Consumer() { // from class: f5.g5
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                SplashAty.y3(s9.l.this, obj);
            }
        });
    }
}
