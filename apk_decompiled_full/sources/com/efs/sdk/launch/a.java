package com.efs.sdk.launch;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static final String f6283a = "com.efs.sdk.launch.a";

    /* renamed from: b, reason: collision with root package name */
    private static volatile ScheduledThreadPoolExecutor f6284b;

    /* renamed from: c, reason: collision with root package name */
    private static ThreadFactory f6285c = new ThreadFactory() { // from class: com.efs.sdk.launch.a.1

        /* renamed from: a, reason: collision with root package name */
        private AtomicInteger f6286a = new AtomicInteger(0);

        @Override // java.util.concurrent.ThreadFactory
        public final Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable);
            thread.setName("LaunchThreadPoolExecutor" + this.f6286a.addAndGet(1));
            return thread;
        }
    };

    private static ScheduledThreadPoolExecutor a() {
        if (f6284b == null) {
            synchronized (a.class) {
                if (f6284b == null) {
                    f6284b = new ScheduledThreadPoolExecutor(4, f6285c);
                }
            }
        }
        return f6284b;
    }

    public static void a(Runnable runnable) {
        try {
            a().execute(runnable);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
