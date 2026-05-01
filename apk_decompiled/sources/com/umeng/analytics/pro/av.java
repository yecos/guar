package com.umeng.analytics.pro;

import com.umeng.commonsdk.debug.UMRTLog;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes3.dex */
public class av {

    /* renamed from: a, reason: collision with root package name */
    private static final String f9922a = "UMExecutor";

    /* renamed from: b, reason: collision with root package name */
    private static volatile ScheduledThreadPoolExecutor f9923b;

    /* renamed from: c, reason: collision with root package name */
    private static final ThreadFactory f9924c = new ThreadFactory() { // from class: com.umeng.analytics.pro.av.1

        /* renamed from: a, reason: collision with root package name */
        private final AtomicInteger f9925a = new AtomicInteger(0);

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, "ccg-" + this.f9925a.incrementAndGet());
        }
    };

    private static ScheduledThreadPoolExecutor a() {
        if (f9923b == null) {
            synchronized (av.class) {
                if (f9923b == null) {
                    f9923b = new ScheduledThreadPoolExecutor(Math.max(2, Math.min(Runtime.getRuntime().availableProcessors(), 4)), f9924c);
                    f9923b.setKeepAliveTime(3L, TimeUnit.SECONDS);
                    f9923b.allowCoreThreadTimeOut(true);
                }
            }
        }
        return f9923b;
    }

    public static void a(Runnable runnable, long j10, TimeUnit timeUnit) {
        try {
            a().schedule(runnable, j10, timeUnit);
        } catch (Throwable th) {
            UMRTLog.e(UMRTLog.RTLOG_TAG, "schedule error:" + th.getMessage());
        }
    }
}
