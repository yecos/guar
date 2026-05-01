package z8;

import com.google.common.base.Preconditions;
import com.umeng.analytics.pro.bt;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.logging.Level;
import java.util.logging.Logger;

/* loaded from: classes3.dex */
public final class b2 implements Executor, Runnable {

    /* renamed from: d, reason: collision with root package name */
    public static final Logger f20365d = Logger.getLogger(b2.class.getName());

    /* renamed from: e, reason: collision with root package name */
    public static final b f20366e = c();

    /* renamed from: a, reason: collision with root package name */
    public Executor f20367a;

    /* renamed from: b, reason: collision with root package name */
    public final Queue f20368b = new ConcurrentLinkedQueue();

    /* renamed from: c, reason: collision with root package name */
    public volatile int f20369c = 0;

    public static abstract class b {
        public b() {
        }

        public abstract boolean a(b2 b2Var, int i10, int i11);

        public abstract void b(b2 b2Var, int i10);
    }

    public static final class c extends b {

        /* renamed from: a, reason: collision with root package name */
        public final AtomicIntegerFieldUpdater f20370a;

        @Override // z8.b2.b
        public boolean a(b2 b2Var, int i10, int i11) {
            return this.f20370a.compareAndSet(b2Var, i10, i11);
        }

        @Override // z8.b2.b
        public void b(b2 b2Var, int i10) {
            this.f20370a.set(b2Var, i10);
        }

        public c(AtomicIntegerFieldUpdater atomicIntegerFieldUpdater) {
            super();
            this.f20370a = atomicIntegerFieldUpdater;
        }
    }

    public static final class d extends b {
        public d() {
            super();
        }

        @Override // z8.b2.b
        public boolean a(b2 b2Var, int i10, int i11) {
            synchronized (b2Var) {
                if (b2Var.f20369c != i10) {
                    return false;
                }
                b2Var.f20369c = i11;
                return true;
            }
        }

        @Override // z8.b2.b
        public void b(b2 b2Var, int i10) {
            synchronized (b2Var) {
                b2Var.f20369c = i10;
            }
        }
    }

    public b2(Executor executor) {
        Preconditions.checkNotNull(executor, "'executor' must not be null.");
        this.f20367a = executor;
    }

    public static b c() {
        try {
            return new c(AtomicIntegerFieldUpdater.newUpdater(b2.class, bt.aL));
        } catch (Throwable th) {
            f20365d.log(Level.SEVERE, "FieldUpdaterAtomicHelper failed", th);
            return new d();
        }
    }

    public final void d(Runnable runnable) {
        if (f20366e.a(this, 0, -1)) {
            try {
                this.f20367a.execute(this);
            } catch (Throwable th) {
                if (runnable != null) {
                    this.f20368b.remove(runnable);
                }
                f20366e.b(this, 0);
                throw th;
            }
        }
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        this.f20368b.add((Runnable) Preconditions.checkNotNull(runnable, "'r' must not be null."));
        d(runnable);
    }

    @Override // java.lang.Runnable
    public void run() {
        Runnable runnable;
        try {
            Executor executor = this.f20367a;
            while (executor == this.f20367a && (runnable = (Runnable) this.f20368b.poll()) != null) {
                try {
                    runnable.run();
                } catch (RuntimeException e10) {
                    f20365d.log(Level.SEVERE, "Exception while executing runnable " + runnable, (Throwable) e10);
                }
            }
            f20366e.b(this, 0);
            if (this.f20368b.isEmpty()) {
                return;
            }
            d(null);
        } catch (Throwable th) {
            f20366e.b(this, 0);
            throw th;
        }
    }
}
