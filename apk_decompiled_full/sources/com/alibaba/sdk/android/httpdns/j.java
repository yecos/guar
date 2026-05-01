package com.alibaba.sdk.android.httpdns;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;

/* loaded from: classes.dex */
public class j {

    /* renamed from: a, reason: collision with root package name */
    private static ScheduledExecutorService f5910a;

    /* renamed from: a, reason: collision with other field name */
    private static final ThreadFactory f22a = new ThreadFactory() { // from class: com.alibaba.sdk.android.httpdns.j.1
        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable);
            thread.setName("httpdns worker");
            thread.setDaemon(false);
            thread.setUncaughtExceptionHandler(new k());
            return thread;
        }
    };

    public static synchronized ScheduledExecutorService a() {
        ScheduledExecutorService scheduledExecutorService;
        synchronized (j.class) {
            if (f5910a == null) {
                f5910a = new ScheduledThreadPoolExecutor(1, f22a);
            }
            scheduledExecutorService = f5910a;
        }
        return scheduledExecutorService;
    }
}
