package androidx.loader.content;

import android.os.Binder;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.FutureTask;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes.dex */
public abstract class c {

    /* renamed from: f, reason: collision with root package name */
    public static final ThreadFactory f2618f;

    /* renamed from: g, reason: collision with root package name */
    public static final BlockingQueue f2619g;

    /* renamed from: h, reason: collision with root package name */
    public static final Executor f2620h;

    /* renamed from: i, reason: collision with root package name */
    public static f f2621i;

    /* renamed from: j, reason: collision with root package name */
    public static volatile Executor f2622j;

    /* renamed from: a, reason: collision with root package name */
    public final h f2623a;

    /* renamed from: b, reason: collision with root package name */
    public final FutureTask f2624b;

    /* renamed from: c, reason: collision with root package name */
    public volatile g f2625c = g.PENDING;

    /* renamed from: d, reason: collision with root package name */
    public final AtomicBoolean f2626d = new AtomicBoolean();

    /* renamed from: e, reason: collision with root package name */
    public final AtomicBoolean f2627e = new AtomicBoolean();

    public static class a implements ThreadFactory {

        /* renamed from: a, reason: collision with root package name */
        public final AtomicInteger f2628a = new AtomicInteger(1);

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, "ModernAsyncTask #" + this.f2628a.getAndIncrement());
        }
    }

    public class b extends h {
        public b() {
        }

        @Override // java.util.concurrent.Callable
        public Object call() {
            c.this.f2627e.set(true);
            Object obj = null;
            try {
                Process.setThreadPriority(10);
                obj = c.this.b(this.f2638a);
                Binder.flushPendingCommands();
                return obj;
            } finally {
            }
        }
    }

    /* renamed from: androidx.loader.content.c$c, reason: collision with other inner class name */
    public class C0037c extends FutureTask {
        public C0037c(Callable callable) {
            super(callable);
        }

        @Override // java.util.concurrent.FutureTask
        public void done() {
            try {
                c.this.l(get());
            } catch (InterruptedException unused) {
            } catch (CancellationException unused2) {
                c.this.l(null);
            } catch (ExecutionException e10) {
                throw new RuntimeException("An error occurred while executing doInBackground()", e10.getCause());
            } catch (Throwable th) {
                throw new RuntimeException("An error occurred while executing doInBackground()", th);
            }
        }
    }

    public static /* synthetic */ class d {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f2631a;

        static {
            int[] iArr = new int[g.values().length];
            f2631a = iArr;
            try {
                iArr[g.RUNNING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f2631a[g.FINISHED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public static class e {

        /* renamed from: a, reason: collision with root package name */
        public final c f2632a;

        /* renamed from: b, reason: collision with root package name */
        public final Object[] f2633b;

        public e(c cVar, Object... objArr) {
            this.f2632a = cVar;
            this.f2633b = objArr;
        }
    }

    public static class f extends Handler {
        public f() {
            super(Looper.getMainLooper());
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            e eVar = (e) message.obj;
            int i10 = message.what;
            if (i10 == 1) {
                eVar.f2632a.d(eVar.f2633b[0]);
            } else {
                if (i10 != 2) {
                    return;
                }
                eVar.f2632a.j(eVar.f2633b);
            }
        }
    }

    public enum g {
        PENDING,
        RUNNING,
        FINISHED
    }

    public static abstract class h implements Callable {

        /* renamed from: a, reason: collision with root package name */
        public Object[] f2638a;
    }

    static {
        a aVar = new a();
        f2618f = aVar;
        LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue(10);
        f2619g = linkedBlockingQueue;
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5, 128, 1L, TimeUnit.SECONDS, linkedBlockingQueue, aVar);
        f2620h = threadPoolExecutor;
        f2622j = threadPoolExecutor;
    }

    public c() {
        b bVar = new b();
        this.f2623a = bVar;
        this.f2624b = new C0037c(bVar);
    }

    public static Handler e() {
        f fVar;
        synchronized (c.class) {
            if (f2621i == null) {
                f2621i = new f();
            }
            fVar = f2621i;
        }
        return fVar;
    }

    public final boolean a(boolean z10) {
        this.f2626d.set(true);
        return this.f2624b.cancel(z10);
    }

    public abstract Object b(Object... objArr);

    public final c c(Executor executor, Object... objArr) {
        if (this.f2625c == g.PENDING) {
            this.f2625c = g.RUNNING;
            i();
            this.f2623a.f2638a = objArr;
            executor.execute(this.f2624b);
            return this;
        }
        int i10 = d.f2631a[this.f2625c.ordinal()];
        if (i10 == 1) {
            throw new IllegalStateException("Cannot execute task: the task is already running.");
        }
        if (i10 != 2) {
            throw new IllegalStateException("We should never reach this state");
        }
        throw new IllegalStateException("Cannot execute task: the task has already been executed (a task can be executed only once)");
    }

    public void d(Object obj) {
        if (f()) {
            g(obj);
        } else {
            h(obj);
        }
        this.f2625c = g.FINISHED;
    }

    public final boolean f() {
        return this.f2626d.get();
    }

    public abstract void g(Object obj);

    public abstract void h(Object obj);

    public void i() {
    }

    public void j(Object... objArr) {
    }

    public Object k(Object obj) {
        e().obtainMessage(1, new e(this, obj)).sendToTarget();
        return obj;
    }

    public void l(Object obj) {
        if (this.f2627e.get()) {
            return;
        }
        k(obj);
    }
}
