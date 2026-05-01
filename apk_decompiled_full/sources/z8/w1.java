package z8;

import com.google.common.base.Stopwatch;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* loaded from: classes3.dex */
public final class w1 {

    /* renamed from: a, reason: collision with root package name */
    public final ScheduledExecutorService f20969a;

    /* renamed from: b, reason: collision with root package name */
    public final Executor f20970b;

    /* renamed from: c, reason: collision with root package name */
    public final Runnable f20971c;

    /* renamed from: d, reason: collision with root package name */
    public final Stopwatch f20972d;

    /* renamed from: e, reason: collision with root package name */
    public long f20973e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f20974f;

    /* renamed from: g, reason: collision with root package name */
    public ScheduledFuture f20975g;

    public final class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!w1.this.f20974f) {
                w1.this.f20975g = null;
                return;
            }
            long j10 = w1.this.j();
            if (w1.this.f20973e - j10 > 0) {
                w1 w1Var = w1.this;
                w1Var.f20975g = w1Var.f20969a.schedule(new c(), w1.this.f20973e - j10, TimeUnit.NANOSECONDS);
            } else {
                w1.this.f20974f = false;
                w1.this.f20975g = null;
                w1.this.f20971c.run();
            }
        }
    }

    public final class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            w1.this.f20970b.execute(new b());
        }
    }

    public w1(Runnable runnable, Executor executor, ScheduledExecutorService scheduledExecutorService, Stopwatch stopwatch) {
        this.f20971c = runnable;
        this.f20970b = executor;
        this.f20969a = scheduledExecutorService;
        this.f20972d = stopwatch;
        stopwatch.start();
    }

    public void i(boolean z10) {
        ScheduledFuture scheduledFuture;
        this.f20974f = false;
        if (!z10 || (scheduledFuture = this.f20975g) == null) {
            return;
        }
        scheduledFuture.cancel(false);
        this.f20975g = null;
    }

    public final long j() {
        return this.f20972d.elapsed(TimeUnit.NANOSECONDS);
    }

    public void k(long j10, TimeUnit timeUnit) {
        long nanos = timeUnit.toNanos(j10);
        long j11 = j() + nanos;
        this.f20974f = true;
        if (j11 - this.f20973e < 0 || this.f20975g == null) {
            ScheduledFuture scheduledFuture = this.f20975g;
            if (scheduledFuture != null) {
                scheduledFuture.cancel(false);
            }
            this.f20975g = this.f20969a.schedule(new c(), nanos, TimeUnit.NANOSECONDS);
        }
        this.f20973e = j11;
    }
}
