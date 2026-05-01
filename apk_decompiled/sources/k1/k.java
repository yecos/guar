package k1;

import java.util.ArrayDeque;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public class k implements Executor {

    /* renamed from: b, reason: collision with root package name */
    public final Executor f14753b;

    /* renamed from: d, reason: collision with root package name */
    public volatile Runnable f14755d;

    /* renamed from: a, reason: collision with root package name */
    public final ArrayDeque f14752a = new ArrayDeque();

    /* renamed from: c, reason: collision with root package name */
    public final Object f14754c = new Object();

    public static class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final k f14756a;

        /* renamed from: b, reason: collision with root package name */
        public final Runnable f14757b;

        public a(k kVar, Runnable runnable) {
            this.f14756a = kVar;
            this.f14757b = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.f14757b.run();
            } finally {
                this.f14756a.b();
            }
        }
    }

    public k(Executor executor) {
        this.f14753b = executor;
    }

    public boolean a() {
        boolean z10;
        synchronized (this.f14754c) {
            z10 = !this.f14752a.isEmpty();
        }
        return z10;
    }

    public void b() {
        synchronized (this.f14754c) {
            Runnable runnable = (Runnable) this.f14752a.poll();
            this.f14755d = runnable;
            if (runnable != null) {
                this.f14753b.execute(this.f14755d);
            }
        }
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        synchronized (this.f14754c) {
            this.f14752a.add(new a(this, runnable));
            if (this.f14755d == null) {
                b();
            }
        }
    }
}
