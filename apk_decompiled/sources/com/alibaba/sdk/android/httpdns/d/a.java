package com.alibaba.sdk.android.httpdns.d;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
final class a {

    /* renamed from: b, reason: collision with root package name */
    private ExecutorService f5863b;

    /* renamed from: b, reason: collision with other field name */
    private final ThreadFactory f14b = new ThreadFactory() { // from class: com.alibaba.sdk.android.httpdns.d.a.1
        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable, "report_thread");
            thread.setDaemon(false);
            return thread;
        }
    };

    public synchronized ExecutorService b() {
        if (this.f5863b == null) {
            this.f5863b = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 1L, TimeUnit.SECONDS, new SynchronousQueue(), this.f14b);
        }
        return this.f5863b;
    }
}
