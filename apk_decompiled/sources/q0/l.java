package q0;

import java.util.ArrayDeque;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public class l implements Executor {

    /* renamed from: a, reason: collision with root package name */
    public final Executor f18182a;

    /* renamed from: b, reason: collision with root package name */
    public final ArrayDeque f18183b = new ArrayDeque();

    /* renamed from: c, reason: collision with root package name */
    public Runnable f18184c;

    public class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Runnable f18185a;

        public a(Runnable runnable) {
            this.f18185a = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.f18185a.run();
            } finally {
                l.this.a();
            }
        }
    }

    public l(Executor executor) {
        this.f18182a = executor;
    }

    public synchronized void a() {
        Runnable runnable = (Runnable) this.f18183b.poll();
        this.f18184c = runnable;
        if (runnable != null) {
            this.f18182a.execute(runnable);
        }
    }

    @Override // java.util.concurrent.Executor
    public synchronized void execute(Runnable runnable) {
        this.f18183b.offer(new a(runnable));
        if (this.f18184c == null) {
            a();
        }
    }
}
