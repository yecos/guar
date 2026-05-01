package com.umeng.innner.umcrash;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes3.dex */
public class UMCrashThreadPoolExecutorFactory {
    private static final String TAG = "com.umeng.innner.umcrash.UMCrashThreadPoolExecutorFactory";
    private static ThreadFactory threadFactory = new ThreadFactory() { // from class: com.umeng.innner.umcrash.UMCrashThreadPoolExecutorFactory.1
        private AtomicInteger count = new AtomicInteger(0);

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable);
            thread.setName("UMCrashThreadPoolExecutor" + this.count.addAndGet(1));
            return thread;
        }
    };
    private static volatile ScheduledThreadPoolExecutor threadPoolExecutor;

    public static void execute(Runnable runnable) {
        try {
            getScheduledExecutor().execute(runnable);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private static ScheduledThreadPoolExecutor getScheduledExecutor() {
        if (threadPoolExecutor == null) {
            synchronized (UMCrashThreadPoolExecutorFactory.class) {
                if (threadPoolExecutor == null) {
                    threadPoolExecutor = new ScheduledThreadPoolExecutor(2, threadFactory);
                }
            }
        }
        return threadPoolExecutor;
    }

    public static void schedule(Runnable runnable, long j10, TimeUnit timeUnit) {
        try {
            getScheduledExecutor().schedule(runnable, j10, timeUnit);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
