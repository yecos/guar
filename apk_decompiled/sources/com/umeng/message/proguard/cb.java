package com.umeng.message.proguard;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes3.dex */
public class cb {

    /* renamed from: a, reason: collision with root package name */
    private static volatile ScheduledThreadPoolExecutor f11700a;

    /* renamed from: b, reason: collision with root package name */
    private static final Handler f11701b = new Handler(Looper.getMainLooper());

    /* renamed from: c, reason: collision with root package name */
    private static final ThreadFactory f11702c = new ThreadFactory() { // from class: com.umeng.message.proguard.cb.1

        /* renamed from: a, reason: collision with root package name */
        private final AtomicInteger f11703a = new AtomicInteger(0);

        @Override // java.util.concurrent.ThreadFactory
        public final Thread newThread(Runnable runnable) {
            return new Thread(runnable, "union-" + this.f11703a.incrementAndGet());
        }
    };

    public static class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        private final Runnable f11704a;

        public a(Runnable runnable) {
            this.f11704a = runnable;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                Runnable runnable = this.f11704a;
                if (runnable != null) {
                    runnable.run();
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    private static ScheduledThreadPoolExecutor a() {
        if (f11700a == null) {
            synchronized (cb.class) {
                if (f11700a == null) {
                    ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(Math.max(2, Math.min(Runtime.getRuntime().availableProcessors(), 4)), f11702c);
                    f11700a = scheduledThreadPoolExecutor;
                    scheduledThreadPoolExecutor.setKeepAliveTime(3L, TimeUnit.SECONDS);
                    f11700a.allowCoreThreadTimeOut(true);
                }
            }
        }
        return f11700a;
    }

    public static void b(Runnable runnable) {
        a aVar = new a(runnable);
        if (Looper.myLooper() == f11701b.getLooper()) {
            a(aVar);
        } else {
            aVar.run();
        }
    }

    public static void c(Runnable runnable) {
        a aVar = new a(runnable);
        Looper myLooper = Looper.myLooper();
        Handler handler = f11701b;
        if (myLooper == handler.getLooper()) {
            aVar.run();
        } else {
            handler.post(aVar);
        }
    }

    public static void a(Runnable runnable) {
        try {
            a().execute(runnable);
        } catch (Throwable th) {
            ce.d("Executor", "execute", th.getMessage());
        }
    }

    public static <V> Future<V> a(Callable<V> callable, long j10, TimeUnit timeUnit) {
        try {
            return a().schedule(callable, j10, timeUnit);
        } catch (Throwable unused) {
            ce.d("Executor", "schedule exception");
            return null;
        }
    }
}
