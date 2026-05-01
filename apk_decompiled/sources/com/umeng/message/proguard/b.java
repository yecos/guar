package com.umeng.message.proguard;

import com.hpplay.sdk.source.common.global.Constant;
import com.umeng.message.common.UPLog;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes3.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private static volatile ScheduledThreadPoolExecutor f11614a;

    /* renamed from: b, reason: collision with root package name */
    private static volatile ScheduledThreadPoolExecutor f11615b;

    /* renamed from: c, reason: collision with root package name */
    private static volatile ScheduledExecutorService f11616c;

    public static final class a implements ThreadFactory {

        /* renamed from: a, reason: collision with root package name */
        private final AtomicInteger f11617a = new AtomicInteger();

        /* renamed from: b, reason: collision with root package name */
        private final String f11618b;

        public a(String str) {
            this.f11618b = str;
        }

        @Override // java.util.concurrent.ThreadFactory
        public final Thread newThread(Runnable runnable) {
            return new Thread(runnable, this.f11618b + " " + this.f11617a.incrementAndGet());
        }
    }

    /* renamed from: com.umeng.message.proguard.b$b, reason: collision with other inner class name */
    public static class RunnableC0188b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        private final Runnable f11619a;

        public RunnableC0188b(Runnable runnable) {
            this.f11619a = runnable;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                Runnable runnable = this.f11619a;
                if (runnable != null) {
                    runnable.run();
                }
            } catch (Throwable th) {
                UPLog.e("Executors", th);
            }
        }
    }

    private static ScheduledThreadPoolExecutor a() {
        if (f11614a == null) {
            synchronized (b.class) {
                if (f11614a == null) {
                    ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(2, new a("pool"));
                    f11614a = scheduledThreadPoolExecutor;
                    scheduledThreadPoolExecutor.setKeepAliveTime(60L, TimeUnit.SECONDS);
                    f11614a.allowCoreThreadTimeOut(true);
                }
            }
        }
        return f11614a;
    }

    private static ScheduledExecutorService b() {
        if (f11616c == null) {
            synchronized (b.class) {
                if (f11616c == null) {
                    f11616c = Executors.newSingleThreadScheduledExecutor(new a("single"));
                }
            }
        }
        return f11616c;
    }

    private static ExecutorService c() {
        if (f11615b == null) {
            synchronized (b.class) {
                if (f11615b == null) {
                    ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(1, new a(Constant.KEY_MSG));
                    f11615b = scheduledThreadPoolExecutor;
                    scheduledThreadPoolExecutor.setKeepAliveTime(30L, TimeUnit.SECONDS);
                    f11615b.allowCoreThreadTimeOut(true);
                }
            }
        }
        return f11615b;
    }

    private static Runnable d(Runnable runnable) {
        return new RunnableC0188b(runnable);
    }

    public static Future<?> b(Runnable runnable) {
        try {
            return b().submit(d(runnable));
        } catch (Throwable th) {
            UPLog.e("Executors", th);
            return null;
        }
    }

    public static ScheduledFuture<?> a(Runnable runnable, long j10, TimeUnit timeUnit) {
        try {
            return b().schedule(d(runnable), j10, timeUnit);
        } catch (Throwable th) {
            UPLog.e("Executors", th);
            return null;
        }
    }

    public static ScheduledFuture<?> b(Runnable runnable, long j10, TimeUnit timeUnit) {
        try {
            return a().schedule(d(runnable), j10, timeUnit);
        } catch (Throwable th) {
            UPLog.e("Executors", th);
            return null;
        }
    }

    public static void c(Runnable runnable) {
        try {
            a().execute(d(runnable));
        } catch (Throwable th) {
            UPLog.e("Executors", th);
        }
    }

    public static void a(Runnable runnable) {
        if (runnable == null) {
            return;
        }
        try {
            c().execute(d(runnable));
        } catch (Throwable th) {
            UPLog.e("Executors", th);
        }
    }
}
