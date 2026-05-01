package y;

import android.os.Handler;
import android.os.Process;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* loaded from: classes.dex */
public abstract class g {

    public static class a implements ThreadFactory {

        /* renamed from: a, reason: collision with root package name */
        public String f19700a;

        /* renamed from: b, reason: collision with root package name */
        public int f19701b;

        /* renamed from: y.g$a$a, reason: collision with other inner class name */
        public static class C0340a extends Thread {

            /* renamed from: a, reason: collision with root package name */
            public final int f19702a;

            public C0340a(Runnable runnable, String str, int i10) {
                super(runnable, str);
                this.f19702a = i10;
            }

            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                Process.setThreadPriority(this.f19702a);
                super.run();
            }
        }

        public a(String str, int i10) {
            this.f19700a = str;
            this.f19701b = i10;
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new C0340a(runnable, this.f19700a, this.f19701b);
        }
    }

    public static class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public Callable f19703a;

        /* renamed from: b, reason: collision with root package name */
        public a0.a f19704b;

        /* renamed from: c, reason: collision with root package name */
        public Handler f19705c;

        public class a implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ a0.a f19706a;

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ Object f19707b;

            public a(a0.a aVar, Object obj) {
                this.f19706a = aVar;
                this.f19707b = obj;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.f19706a.accept(this.f19707b);
            }
        }

        public b(Handler handler, Callable callable, a0.a aVar) {
            this.f19703a = callable;
            this.f19704b = aVar;
            this.f19705c = handler;
        }

        @Override // java.lang.Runnable
        public void run() {
            Object obj;
            try {
                obj = this.f19703a.call();
            } catch (Exception unused) {
                obj = null;
            }
            this.f19705c.post(new a(this.f19704b, obj));
        }
    }

    public static ThreadPoolExecutor a(String str, int i10, int i11) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0, 1, i11, TimeUnit.MILLISECONDS, new LinkedBlockingDeque(), new a(str, i10));
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        return threadPoolExecutor;
    }

    public static void b(Executor executor, Callable callable, a0.a aVar) {
        executor.execute(new b(y.b.a(), callable, aVar));
    }

    public static Object c(ExecutorService executorService, Callable callable, int i10) {
        try {
            return executorService.submit(callable).get(i10, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e10) {
            throw e10;
        } catch (ExecutionException e11) {
            throw new RuntimeException(e11);
        } catch (TimeoutException unused) {
            throw new InterruptedException("timeout");
        }
    }
}
