package z8;

import com.google.common.base.Preconditions;
import com.google.common.base.Stopwatch;
import com.google.common.util.concurrent.MoreExecutors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import z8.s;

/* loaded from: classes3.dex */
public class b1 {

    /* renamed from: l, reason: collision with root package name */
    public static final long f20341l = TimeUnit.SECONDS.toNanos(10);

    /* renamed from: m, reason: collision with root package name */
    public static final long f20342m = TimeUnit.MILLISECONDS.toNanos(10);

    /* renamed from: a, reason: collision with root package name */
    public final ScheduledExecutorService f20343a;

    /* renamed from: b, reason: collision with root package name */
    public final Stopwatch f20344b;

    /* renamed from: c, reason: collision with root package name */
    public final d f20345c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f20346d;

    /* renamed from: e, reason: collision with root package name */
    public e f20347e;

    /* renamed from: f, reason: collision with root package name */
    public ScheduledFuture f20348f;

    /* renamed from: g, reason: collision with root package name */
    public ScheduledFuture f20349g;

    /* renamed from: h, reason: collision with root package name */
    public final Runnable f20350h;

    /* renamed from: i, reason: collision with root package name */
    public final Runnable f20351i;

    /* renamed from: j, reason: collision with root package name */
    public final long f20352j;

    /* renamed from: k, reason: collision with root package name */
    public final long f20353k;

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean z10;
            synchronized (b1.this) {
                e eVar = b1.this.f20347e;
                e eVar2 = e.DISCONNECTED;
                if (eVar != eVar2) {
                    b1.this.f20347e = eVar2;
                    z10 = true;
                } else {
                    z10 = false;
                }
            }
            if (z10) {
                b1.this.f20345c.a();
            }
        }
    }

    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean z10;
            synchronized (b1.this) {
                b1.this.f20349g = null;
                e eVar = b1.this.f20347e;
                e eVar2 = e.PING_SCHEDULED;
                if (eVar == eVar2) {
                    b1.this.f20347e = e.PING_SENT;
                    b1 b1Var = b1.this;
                    b1Var.f20348f = b1Var.f20343a.schedule(b1.this.f20350h, b1.this.f20353k, TimeUnit.NANOSECONDS);
                    z10 = true;
                } else {
                    if (b1.this.f20347e == e.PING_DELAYED) {
                        b1 b1Var2 = b1.this;
                        ScheduledExecutorService scheduledExecutorService = b1Var2.f20343a;
                        Runnable runnable = b1.this.f20351i;
                        long j10 = b1.this.f20352j;
                        Stopwatch stopwatch = b1.this.f20344b;
                        TimeUnit timeUnit = TimeUnit.NANOSECONDS;
                        b1Var2.f20349g = scheduledExecutorService.schedule(runnable, j10 - stopwatch.elapsed(timeUnit), timeUnit);
                        b1.this.f20347e = eVar2;
                    }
                    z10 = false;
                }
            }
            if (z10) {
                b1.this.f20345c.ping();
            }
        }
    }

    public static final class c implements d {

        /* renamed from: a, reason: collision with root package name */
        public final v f20356a;

        public class a implements s.a {
            public a() {
            }

            @Override // z8.s.a
            public void a(long j10) {
            }

            @Override // z8.s.a
            public void onFailure(Throwable th) {
                c.this.f20356a.g(y8.k1.f19904u.r("Keepalive failed. The connection is likely gone"));
            }
        }

        public c(v vVar) {
            this.f20356a = vVar;
        }

        @Override // z8.b1.d
        public void a() {
            this.f20356a.g(y8.k1.f19904u.r("Keepalive failed. The connection is likely gone"));
        }

        @Override // z8.b1.d
        public void ping() {
            this.f20356a.f(new a(), MoreExecutors.directExecutor());
        }
    }

    public interface d {
        void a();

        void ping();
    }

    public enum e {
        IDLE,
        PING_SCHEDULED,
        PING_DELAYED,
        PING_SENT,
        IDLE_AND_PING_SENT,
        DISCONNECTED
    }

    public b1(d dVar, ScheduledExecutorService scheduledExecutorService, long j10, long j11, boolean z10) {
        this(dVar, scheduledExecutorService, Stopwatch.createUnstarted(), j10, j11, z10);
    }

    public synchronized void l() {
        this.f20344b.reset().start();
        e eVar = this.f20347e;
        e eVar2 = e.PING_SCHEDULED;
        if (eVar == eVar2) {
            this.f20347e = e.PING_DELAYED;
        } else if (eVar == e.PING_SENT || eVar == e.IDLE_AND_PING_SENT) {
            ScheduledFuture scheduledFuture = this.f20348f;
            if (scheduledFuture != null) {
                scheduledFuture.cancel(false);
            }
            if (this.f20347e == e.IDLE_AND_PING_SENT) {
                this.f20347e = e.IDLE;
            } else {
                this.f20347e = eVar2;
                Preconditions.checkState(this.f20349g == null, "There should be no outstanding pingFuture");
                this.f20349g = this.f20343a.schedule(this.f20351i, this.f20352j, TimeUnit.NANOSECONDS);
            }
        }
    }

    public synchronized void m() {
        e eVar = this.f20347e;
        if (eVar == e.IDLE) {
            this.f20347e = e.PING_SCHEDULED;
            if (this.f20349g == null) {
                ScheduledExecutorService scheduledExecutorService = this.f20343a;
                Runnable runnable = this.f20351i;
                long j10 = this.f20352j;
                Stopwatch stopwatch = this.f20344b;
                TimeUnit timeUnit = TimeUnit.NANOSECONDS;
                this.f20349g = scheduledExecutorService.schedule(runnable, j10 - stopwatch.elapsed(timeUnit), timeUnit);
            }
        } else if (eVar == e.IDLE_AND_PING_SENT) {
            this.f20347e = e.PING_SENT;
        }
    }

    public synchronized void n() {
        if (this.f20346d) {
            return;
        }
        e eVar = this.f20347e;
        if (eVar == e.PING_SCHEDULED || eVar == e.PING_DELAYED) {
            this.f20347e = e.IDLE;
        }
        if (this.f20347e == e.PING_SENT) {
            this.f20347e = e.IDLE_AND_PING_SENT;
        }
    }

    public synchronized void o() {
        if (this.f20346d) {
            m();
        }
    }

    public synchronized void p() {
        e eVar = this.f20347e;
        e eVar2 = e.DISCONNECTED;
        if (eVar != eVar2) {
            this.f20347e = eVar2;
            ScheduledFuture scheduledFuture = this.f20348f;
            if (scheduledFuture != null) {
                scheduledFuture.cancel(false);
            }
            ScheduledFuture scheduledFuture2 = this.f20349g;
            if (scheduledFuture2 != null) {
                scheduledFuture2.cancel(false);
                this.f20349g = null;
            }
        }
    }

    public b1(d dVar, ScheduledExecutorService scheduledExecutorService, Stopwatch stopwatch, long j10, long j11, boolean z10) {
        this.f20347e = e.IDLE;
        this.f20350h = new c1(new a());
        this.f20351i = new c1(new b());
        this.f20345c = (d) Preconditions.checkNotNull(dVar, "keepAlivePinger");
        this.f20343a = (ScheduledExecutorService) Preconditions.checkNotNull(scheduledExecutorService, "scheduler");
        this.f20344b = (Stopwatch) Preconditions.checkNotNull(stopwatch, "stopwatch");
        this.f20352j = j10;
        this.f20353k = j11;
        this.f20346d = z10;
        stopwatch.reset().start();
    }
}
