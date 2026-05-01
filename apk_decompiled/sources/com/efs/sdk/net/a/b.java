package com.efs.sdk.net.a;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private static final String f6390a = "com.efs.sdk.net.a.b";

    /* renamed from: b, reason: collision with root package name */
    private static volatile ScheduledThreadPoolExecutor f6391b;

    /* renamed from: c, reason: collision with root package name */
    private static ThreadFactory f6392c = new ThreadFactory() { // from class: com.efs.sdk.net.a.b.1

        /* renamed from: a, reason: collision with root package name */
        private AtomicInteger f6393a = new AtomicInteger(0);

        @Override // java.util.concurrent.ThreadFactory
        public final Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable);
            thread.setName("NetThreadPoolExecutor" + this.f6393a.addAndGet(1));
            return thread;
        }
    };

    private static ScheduledThreadPoolExecutor a() {
        if (f6391b == null) {
            synchronized (b.class) {
                if (f6391b == null) {
                    f6391b = new ScheduledThreadPoolExecutor(4, f6392c);
                }
            }
        }
        return f6391b;
    }

    public static void a(Runnable runnable) {
        try {
            a().execute(runnable);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
