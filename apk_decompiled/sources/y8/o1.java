package y8;

import com.google.common.base.Preconditions;
import java.lang.Thread;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes3.dex */
public final class o1 implements Executor {

    /* renamed from: a, reason: collision with root package name */
    public final Thread.UncaughtExceptionHandler f19970a;

    /* renamed from: b, reason: collision with root package name */
    public final Queue f19971b = new ConcurrentLinkedQueue();

    /* renamed from: c, reason: collision with root package name */
    public final AtomicReference f19972c = new AtomicReference();

    public class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f19973a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Runnable f19974b;

        public a(c cVar, Runnable runnable) {
            this.f19973a = cVar;
            this.f19974b = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            o1.this.execute(this.f19973a);
        }

        public String toString() {
            return this.f19974b.toString() + "(scheduled in SynchronizationContext)";
        }
    }

    public class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f19976a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Runnable f19977b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ long f19978c;

        public b(c cVar, Runnable runnable, long j10) {
            this.f19976a = cVar;
            this.f19977b = runnable;
            this.f19978c = j10;
        }

        @Override // java.lang.Runnable
        public void run() {
            o1.this.execute(this.f19976a);
        }

        public String toString() {
            return this.f19977b.toString() + "(scheduled in SynchronizationContext with delay of " + this.f19978c + ")";
        }
    }

    public static class c implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final Runnable f19980a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f19981b;

        /* renamed from: c, reason: collision with root package name */
        public boolean f19982c;

        public c(Runnable runnable) {
            this.f19980a = (Runnable) Preconditions.checkNotNull(runnable, "task");
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f19981b) {
                return;
            }
            this.f19982c = true;
            this.f19980a.run();
        }
    }

    public static final class d {

        /* renamed from: a, reason: collision with root package name */
        public final c f19983a;

        /* renamed from: b, reason: collision with root package name */
        public final ScheduledFuture f19984b;

        public /* synthetic */ d(c cVar, ScheduledFuture scheduledFuture, a aVar) {
            this(cVar, scheduledFuture);
        }

        public void a() {
            this.f19983a.f19981b = true;
            this.f19984b.cancel(false);
        }

        public boolean b() {
            c cVar = this.f19983a;
            return (cVar.f19982c || cVar.f19981b) ? false : true;
        }

        public d(c cVar, ScheduledFuture scheduledFuture) {
            this.f19983a = (c) Preconditions.checkNotNull(cVar, "runnable");
            this.f19984b = (ScheduledFuture) Preconditions.checkNotNull(scheduledFuture, "future");
        }
    }

    public o1(Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
        this.f19970a = (Thread.UncaughtExceptionHandler) Preconditions.checkNotNull(uncaughtExceptionHandler, "uncaughtExceptionHandler");
    }

    public final void a() {
        while (h3.b.a(this.f19972c, null, Thread.currentThread())) {
            while (true) {
                try {
                    Runnable runnable = (Runnable) this.f19971b.poll();
                    if (runnable == null) {
                        break;
                    }
                    try {
                        runnable.run();
                    } catch (Throwable th) {
                        this.f19970a.uncaughtException(Thread.currentThread(), th);
                    }
                } catch (Throwable th2) {
                    this.f19972c.set(null);
                    throw th2;
                }
            }
            this.f19972c.set(null);
            if (this.f19971b.isEmpty()) {
                return;
            }
        }
    }

    public final void b(Runnable runnable) {
        this.f19971b.add((Runnable) Preconditions.checkNotNull(runnable, "runnable is null"));
    }

    public final d c(Runnable runnable, long j10, TimeUnit timeUnit, ScheduledExecutorService scheduledExecutorService) {
        c cVar = new c(runnable);
        return new d(cVar, scheduledExecutorService.schedule(new a(cVar, runnable), j10, timeUnit), null);
    }

    public final d d(Runnable runnable, long j10, long j11, TimeUnit timeUnit, ScheduledExecutorService scheduledExecutorService) {
        c cVar = new c(runnable);
        return new d(cVar, scheduledExecutorService.scheduleWithFixedDelay(new b(cVar, runnable, j11), j10, j11, timeUnit), null);
    }

    public void e() {
        Preconditions.checkState(Thread.currentThread() == this.f19972c.get(), "Not called from the SynchronizationContext");
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        b(runnable);
        a();
    }
}
