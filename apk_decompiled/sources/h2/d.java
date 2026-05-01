package h2;

import d2.c;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import s2.d;
import t9.g;
import t9.i;

/* loaded from: classes.dex */
public final class d implements h2.a {

    /* renamed from: a, reason: collision with root package name */
    public d2.c f14118a;

    /* renamed from: b, reason: collision with root package name */
    public long f14119b;

    /* renamed from: c, reason: collision with root package name */
    public final ScheduledThreadPoolExecutor f14120c;

    /* renamed from: d, reason: collision with root package name */
    public Future f14121d;

    /* renamed from: e, reason: collision with root package name */
    public String f14122e;

    /* renamed from: f, reason: collision with root package name */
    public long f14123f;

    public static final class a implements d2.b {
        public a() {
        }

        @Override // d2.b
        public void a(long j10) {
            if (j10 != d.this.f14119b) {
                d.this.f14119b = j10;
                d.this.f14123f = j10;
                Future future = d.this.f14121d;
                if (future != null) {
                    future.cancel(true);
                }
                d.this.f14121d = null;
                d.this.l();
            }
        }
    }

    public d(d2.c cVar, long j10) {
        i.g(cVar, "mReporter");
        this.f14118a = cVar;
        this.f14119b = j10;
        this.f14120c = s2.d.c();
        this.f14122e = d.class.getSimpleName();
    }

    public static final void m(d dVar) {
        i.g(dVar, "this$0");
        try {
            dVar.f14118a.c(dVar.new a());
        } catch (InterruptedException e10) {
            e10.printStackTrace();
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    public static final void n(d dVar) {
        i.g(dVar, "this$0");
        try {
            c.a.a(dVar.f14118a, null, 1, null);
        } catch (InterruptedException e10) {
            e10.printStackTrace();
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    @Override // h2.a
    public void a() {
        i2.a.f14261a.j(this.f14119b);
        k();
        l();
    }

    @Override // h2.a
    public void b() {
        this.f14120c.submit(new d.e("interval report trigger", new Runnable() { // from class: h2.b
            @Override // java.lang.Runnable
            public final void run() {
                d.n(d.this);
            }
        }, false));
    }

    public final void k() {
        Future future = this.f14121d;
        if (future != null) {
            future.cancel(true);
        }
        this.f14121d = null;
    }

    public final void l() {
        this.f14121d = this.f14120c.scheduleAtFixedRate(new d.e("interval report", new Runnable() { // from class: h2.c
            @Override // java.lang.Runnable
            public final void run() {
                d.m(d.this);
            }
        }, false), this.f14123f, this.f14119b, TimeUnit.MINUTES);
    }

    public /* synthetic */ d(d2.c cVar, long j10, int i10, g gVar) {
        this(cVar, (i10 & 2) != 0 ? 10L : j10);
    }
}
