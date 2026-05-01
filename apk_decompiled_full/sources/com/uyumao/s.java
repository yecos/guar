package com.uyumao;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes3.dex */
public class s {

    /* renamed from: a, reason: collision with root package name */
    public static volatile ScheduledThreadPoolExecutor f12451a;

    /* renamed from: b, reason: collision with root package name */
    public static volatile ExecutorService f12452b;

    /* renamed from: c, reason: collision with root package name */
    public static final ThreadFactory f12453c = new a();

    public static class a implements ThreadFactory {

        /* renamed from: a, reason: collision with root package name */
        public final AtomicInteger f12454a = new AtomicInteger(0);

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, "Azx-" + this.f12454a.incrementAndGet());
        }
    }

    public static class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final Runnable f12455a;

        public b(Runnable runnable) {
            this.f12455a = runnable;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                Runnable runnable = this.f12455a;
                if (runnable != null) {
                    runnable.run();
                }
            } catch (Throwable th) {
                th.getMessage();
            }
        }
    }

    public static ScheduledThreadPoolExecutor a() {
        if (f12451a == null) {
            synchronized (s.class) {
                if (f12451a == null) {
                    f12451a = new ScheduledThreadPoolExecutor(Math.max(2, Math.min(Runtime.getRuntime().availableProcessors(), 4)), f12453c);
                    f12451a.setKeepAliveTime(3L, TimeUnit.SECONDS);
                    f12451a.allowCoreThreadTimeOut(true);
                }
            }
        }
        return f12451a;
    }

    public static Future<?> a(Runnable runnable) {
        try {
            if (f12452b == null) {
                synchronized (s.class) {
                    if (f12452b == null) {
                        f12452b = Executors.newSingleThreadExecutor(f12453c);
                    }
                }
            }
            return f12452b.submit(new b(runnable));
        } catch (Throwable th) {
            th.getMessage();
            return null;
        }
    }

    public static void a(Runnable runnable, long j10, TimeUnit timeUnit) {
        try {
            a().schedule(runnable, j10, timeUnit);
        } catch (Throwable th) {
            th.getMessage();
        }
    }
}
