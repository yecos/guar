package com.efs.sdk.h5pagesdk;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes.dex */
public class a {
    private static final String TAG = "com.efs.sdk.h5pagesdk.a";

    /* renamed from: i, reason: collision with root package name */
    private static volatile ScheduledThreadPoolExecutor f6266i;

    /* renamed from: j, reason: collision with root package name */
    private static ThreadFactory f6267j = new ThreadFactory() { // from class: com.efs.sdk.h5pagesdk.a.1

        /* renamed from: k, reason: collision with root package name */
        private AtomicInteger f6268k = new AtomicInteger(0);

        @Override // java.util.concurrent.ThreadFactory
        public final Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable);
            thread.setName("H5ThreadPoolExecutor" + this.f6268k.addAndGet(1));
            return thread;
        }
    };

    private static ScheduledThreadPoolExecutor a() {
        if (f6266i == null) {
            synchronized (a.class) {
                if (f6266i == null) {
                    f6266i = new ScheduledThreadPoolExecutor(4, f6267j);
                }
            }
        }
        return f6266i;
    }

    public static void execute(Runnable runnable) {
        try {
            a().execute(runnable);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
