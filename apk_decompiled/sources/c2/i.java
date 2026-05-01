package c2;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Parcelable;
import android.os.SystemClock;
import android.text.TextUtils;
import c2.i;
import com.bigbee.db.EventDbModel;
import com.dcs.bean.DomainInfo;
import com.google.android.gms.cast.MediaTrack;
import com.raizlabs.android.dbflow.config.FlowLog;
import com.raizlabs.android.dbflow.config.FlowManager;
import com.taobao.accs.utl.BaseMonitor;
import h9.t;
import i2.d;
import i2.j;
import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import okhttp3.Dns;
import okhttp3.Interceptor;

/* loaded from: classes.dex */
public final class i {

    /* renamed from: q, reason: collision with root package name */
    public static final b f5350q = new b(null);

    /* renamed from: r, reason: collision with root package name */
    public static final h9.g f5351r = h9.h.a(h9.i.SYNCHRONIZED, a.f5368a);

    /* renamed from: a, reason: collision with root package name */
    public String f5352a;

    /* renamed from: b, reason: collision with root package name */
    public Context f5353b;

    /* renamed from: c, reason: collision with root package name */
    public a2.b f5354c;

    /* renamed from: d, reason: collision with root package name */
    public d2.c f5355d;

    /* renamed from: e, reason: collision with root package name */
    public h2.a f5356e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f5357f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f5358g;

    /* renamed from: h, reason: collision with root package name */
    public Activity f5359h;

    /* renamed from: i, reason: collision with root package name */
    public long f5360i;

    /* renamed from: j, reason: collision with root package name */
    public long f5361j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f5362k;

    /* renamed from: l, reason: collision with root package name */
    public Dns f5363l;

    /* renamed from: m, reason: collision with root package name */
    public Interceptor f5364m;

    /* renamed from: n, reason: collision with root package name */
    public boolean f5365n;

    /* renamed from: o, reason: collision with root package name */
    public final d f5366o;

    /* renamed from: p, reason: collision with root package name */
    public c f5367p;

    public static final class a extends t9.j implements s9.a {

        /* renamed from: a, reason: collision with root package name */
        public static final a f5368a = new a();

        public a() {
            super(0);
        }

        @Override // s9.a
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final i invoke() {
            return new i(null);
        }
    }

    public static final class b {
        public b() {
        }

        public /* synthetic */ b(t9.g gVar) {
            this();
        }

        public final i a() {
            return (i) i.f5351r.getValue();
        }
    }

    public final class c extends BroadcastReceiver {

        /* renamed from: a, reason: collision with root package name */
        public String f5369a;

        public static final class a extends t9.j implements s9.l {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ i f5371a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(i iVar) {
                super(1);
                this.f5371a = iVar;
            }

            @Override // s9.l
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((String) obj);
                return t.f14242a;
            }

            public final void invoke(String str) {
                long elapsedRealtime = SystemClock.elapsedRealtime();
                if ((elapsedRealtime - this.f5371a.f5361j) / 1000 >= i2.a.f14261a.d()) {
                    this.f5371a.f5361j = elapsedRealtime;
                    c2.d dVar = c2.d.f5311a;
                    dVar.i();
                    c2.d.l(dVar, 0L, 1, null);
                }
            }
        }

        public static final class b extends t9.j implements s9.l {

            /* renamed from: a, reason: collision with root package name */
            public static final b f5372a = new b();

            public b() {
                super(1);
            }

            @Override // s9.l
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Throwable) obj);
                return t.f14242a;
            }

            public final void invoke(Throwable th) {
                th.printStackTrace();
            }
        }

        public c() {
        }

        public static final void c(s9.l lVar, Object obj) {
            t9.i.g(lVar, "$tmp0");
            lVar.invoke(obj);
        }

        public static final void d(s9.l lVar, Object obj) {
            t9.i.g(lVar, "$tmp0");
            lVar.invoke(obj);
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            t9.i.g(context, com.umeng.analytics.pro.f.X);
            t9.i.g(intent, "intent");
            String action = intent.getAction();
            this.f5369a = action;
            if (action != null) {
                int hashCode = action.hashCode();
                if (hashCode == -2128145023) {
                    if (action.equals("android.intent.action.SCREEN_OFF")) {
                        i.this.f5361j = SystemClock.elapsedRealtime();
                        return;
                    }
                    return;
                }
                if (hashCode == -1454123155) {
                    action.equals("android.intent.action.SCREEN_ON");
                    return;
                }
                if (hashCode == 823795052 && action.equals("android.intent.action.USER_PRESENT")) {
                    Observable compose = Observable.just("ioSchedulers").compose(s2.c.b());
                    final a aVar = new a(i.this);
                    Consumer consumer = new Consumer() { // from class: c2.j
                        @Override // io.reactivex.functions.Consumer
                        public final void accept(Object obj) {
                            i.c.c(s9.l.this, obj);
                        }
                    };
                    final b bVar = b.f5372a;
                    compose.subscribe(consumer, new Consumer() { // from class: c2.k
                        @Override // io.reactivex.functions.Consumer
                        public final void accept(Object obj) {
                            i.c.d(s9.l.this, obj);
                        }
                    });
                }
            }
        }
    }

    public static final class d extends BroadcastReceiver {
        public d() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            h2.a aVar;
            t9.i.g(context, com.umeng.analytics.pro.f.X);
            t9.i.g(intent, "intent");
            intent.getAction();
            if (t9.i.b(intent.getAction(), "android.net.conn.CONNECTIVITY_CHANGE")) {
                Parcelable parcelableExtra = intent.getParcelableExtra("networkInfo");
                t9.i.e(parcelableExtra, "null cannot be cast to non-null type android.net.NetworkInfo");
                NetworkInfo networkInfo = (NetworkInfo) parcelableExtra;
                if (NetworkInfo.State.CONNECTED == networkInfo.getState() && networkInfo.isAvailable() && (aVar = i.this.f5356e) != null) {
                    aVar.a();
                }
            }
        }
    }

    public static final class e extends t9.j implements s9.l {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Activity f5375b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(Activity activity) {
            super(1);
            this.f5375b = activity;
        }

        @Override // s9.l
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((String) obj);
            return t.f14242a;
        }

        public final void invoke(String str) {
            i.this.v(this.f5375b);
        }
    }

    public static final class f extends t9.j implements s9.l {

        /* renamed from: a, reason: collision with root package name */
        public static final f f5376a = new f();

        public f() {
            super(1);
        }

        @Override // s9.l
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((Throwable) obj);
            return t.f14242a;
        }

        public final void invoke(Throwable th) {
            th.printStackTrace();
        }
    }

    public static final class g implements j.c {
        public g() {
        }

        @Override // i2.j.c
        public void a() {
            i.y(i.this, true, false, 2, null);
        }
    }

    public static final class h implements d.c {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f5379b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f5380c;

        public h(String str, String str2) {
            this.f5379b = str;
            this.f5380c = str2;
        }

        @Override // i2.d.c
        public void a() {
            i.y(i.this, false, false, 2, null);
            i.this.t();
            l.f5383a.f(this.f5379b, this.f5380c);
            c2.d.l(c2.d.f5311a, 0L, 1, null);
        }
    }

    public /* synthetic */ i(t9.g gVar) {
        this();
    }

    public static final void q(s9.l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    public static final void r(s9.l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    public static /* synthetic */ void y(i iVar, boolean z10, boolean z11, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            z11 = true;
        }
        iVar.x(z10, z11);
    }

    public final void B(DomainInfo domainInfo) {
        t9.i.g(domainInfo, "domainInfo");
        b2.a.f4465d = domainInfo;
        b2.a.f4466e = domainInfo.getFirst();
        b2.a.f4467f = domainInfo.getSecond();
    }

    public final void C() {
        if (!this.f5365n || this.f5362k) {
            return;
        }
        this.f5367p = new c();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.SCREEN_ON");
        intentFilter.addAction("android.intent.action.SCREEN_OFF");
        intentFilter.addAction("android.intent.action.USER_PRESENT");
        Context context = this.f5353b;
        if (context != null) {
            context.registerReceiver(this.f5367p, intentFilter);
        }
        this.f5358g = true;
    }

    public final void D() {
        Context context;
        if (this.f5365n && this.f5358g && !this.f5362k && (context = this.f5353b) != null) {
            context.unregisterReceiver(this.f5367p);
        }
        this.f5358g = false;
    }

    public final void E(String str, String str2) {
        t9.i.g(str, "uName");
        i2.d.f14275c.a().f(new h(str, str2));
    }

    public final void F() {
        Context context;
        if (this.f5365n && this.f5357f && (context = this.f5353b) != null) {
            context.unregisterReceiver(this.f5366o);
        }
        this.f5357f = false;
    }

    public final void G(EventDbModel eventDbModel) {
        t9.i.g(eventDbModel, "dbModel");
        d2.c cVar = this.f5355d;
        if (cVar != null) {
            cVar.b(eventDbModel);
        }
    }

    public final void h() {
        i2.j.f14291c.a().c();
        i2.d.f14275c.a().e();
        y(this, false, false, 2, null);
        F();
        D();
    }

    public final void i(String str) {
        i2.a aVar = i2.a.f14261a;
        aVar.k(false);
        aVar.m(SystemClock.elapsedRealtime());
        if (!TextUtils.isEmpty(str) && TextUtils.isDigitsOnly(str)) {
            i2.h.f14287a.b(str != null ? Long.parseLong(str) : 0L);
        }
        if (this.f5365n) {
            c2.d.f5311a.m(i2.h.f14287a.a() - (aVar.g() - aVar.f()));
        }
    }

    public final Context j() {
        return this.f5353b;
    }

    public final void k(Context context, boolean z10, h2.a aVar, d2.c cVar, Dns dns, Interceptor interceptor) {
        t9.i.g(context, "ctx");
        t9.i.g(dns, BaseMonitor.COUNT_POINT_DNS);
        this.f5362k = z10;
        m(context, cVar, dns, interceptor);
        if (aVar == null) {
            d2.c cVar2 = this.f5355d;
            t9.i.d(cVar2);
            aVar = new h2.d(cVar2, 0L, 2, null);
        }
        this.f5356e = aVar;
    }

    public final void m(Context context, d2.c cVar, Dns dns, Interceptor interceptor) {
        t9.i.g(context, "ctx");
        t9.i.g(dns, BaseMonitor.COUNT_POINT_DNS);
        this.f5353b = context;
        i2.a aVar = i2.a.f14261a;
        aVar.l(SystemClock.elapsedRealtime());
        aVar.m(aVar.f());
        this.f5361j = aVar.f();
        FlowManager.init(context);
        FlowLog.setMinimumLoggingLevel(FlowLog.Level.E);
        this.f5363l = dns;
        this.f5364m = interceptor;
        a2.a aVar2 = new a2.a();
        this.f5354c = aVar2;
        if (cVar == null) {
            t9.i.d(aVar2);
            cVar = new d2.a(aVar2, dns, interceptor);
        }
        this.f5355d = cVar;
    }

    public final void n() {
        this.f5359h = null;
    }

    public final void o(Activity activity) {
        t9.i.g(activity, "aty");
        this.f5360i = SystemClock.elapsedRealtime();
        Activity activity2 = this.f5359h;
        if (activity2 != null && t9.i.b(activity2, activity)) {
            c2.d.f5311a.f();
            i2.j.f14291c.a().c();
        }
        this.f5359h = activity;
    }

    public final void p(Activity activity) {
        t9.i.g(activity, "aty");
        if (this.f5360i != 0) {
            if (t9.i.b(Thread.currentThread().getName(), MediaTrack.ROLE_MAIN)) {
                Observable compose = Observable.just("ioSchedulers").compose(s2.c.b());
                final e eVar = new e(activity);
                Consumer consumer = new Consumer() { // from class: c2.g
                    @Override // io.reactivex.functions.Consumer
                    public final void accept(Object obj) {
                        i.q(s9.l.this, obj);
                    }
                };
                final f fVar = f.f5376a;
                compose.subscribe(consumer, new Consumer() { // from class: c2.h
                    @Override // io.reactivex.functions.Consumer
                    public final void accept(Object obj) {
                        i.r(s9.l.this, obj);
                    }
                });
            } else {
                v(activity);
            }
        }
        j.b bVar = i2.j.f14291c;
        bVar.a().c();
        i2.j a10 = bVar.a();
        i2.a aVar = i2.a.f14261a;
        a10.d(aVar.e(), aVar.e(), new g());
    }

    public final void s() {
        if (this.f5365n) {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.DATE_CHANGED");
            Context context = this.f5353b;
            if (context != null) {
                context.registerReceiver(this.f5366o, intentFilter);
            }
            this.f5357f = true;
        }
    }

    public final void t() {
        h2.a aVar = this.f5356e;
        if (aVar != null) {
            aVar.b();
        }
    }

    public final void u() {
        i2.e.f14282b.a().c("server_time", 0L);
    }

    public final void v(Activity activity) {
        if (t9.i.b(activity, this.f5359h)) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            this.f5361j = elapsedRealtime;
            if ((elapsedRealtime - this.f5360i) / 1000 >= i2.a.f14261a.d()) {
                c2.d dVar = c2.d.f5311a;
                dVar.i();
                c2.d.l(dVar, 0L, 1, null);
                this.f5360i = 0L;
            }
        }
    }

    public final void w(EventDbModel eventDbModel) {
        t9.i.g(eventDbModel, "dbModel");
        d2.c cVar = this.f5355d;
        if (cVar != null) {
            cVar.a(eventDbModel);
        }
    }

    public final void x(boolean z10, boolean z11) {
        if (this.f5365n && z11) {
            c2.d.r(c2.d.f5311a, z10, false, 2, null);
        }
    }

    public final void z(boolean z10, DomainInfo domainInfo, String str, int i10, String str2, String str3, String str4, String str5, String str6, String str7, boolean z11) {
        t9.i.g(domainInfo, "domainInfo");
        t9.i.g(str, "appId");
        t9.i.g(str2, "sysVer");
        t9.i.g(str3, "macAddr");
        t9.i.g(str4, "reserve1");
        t9.i.g(str5, "sn");
        t9.i.g(str6, "userId");
        t9.i.g(str7, "userName");
        B(domainInfo);
        if (z10) {
            i2.b.f14273a = 6;
        }
        l lVar = l.f5383a;
        String valueOf = String.valueOf(i10);
        String str8 = Build.MODEL;
        t9.i.f(str8, "MODEL");
        lVar.d(str, valueOf, str2, str8, str3, str4, str5, str6, str7);
        i2.f fVar = i2.f.f14286a;
        Context context = this.f5353b;
        t9.i.d(context);
        if (fVar.c(context)) {
            if (z11) {
                new z1.a().a(this.f5363l, this.f5364m);
            }
            h2.a aVar = this.f5356e;
            if (aVar != null) {
                aVar.a();
            }
        } else {
            s();
        }
        C();
    }

    public i() {
        this.f5352a = i.class.getSimpleName();
        this.f5362k = true;
        Dns dns = Dns.SYSTEM;
        t9.i.f(dns, "SYSTEM");
        this.f5363l = dns;
        this.f5365n = true;
        this.f5366o = new d();
    }
}
