package anet.channel.thread;

import anet.channel.util.ALog;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes.dex */
public class ThreadPoolExecutorFactory {

    /* renamed from: a, reason: collision with root package name */
    private static ScheduledThreadPoolExecutor f4253a = new ScheduledThreadPoolExecutor(1, new b("AWCN Scheduler"));

    /* renamed from: b, reason: collision with root package name */
    private static ThreadPoolExecutor f4254b;

    /* renamed from: c, reason: collision with root package name */
    private static ThreadPoolExecutor f4255c;

    /* renamed from: d, reason: collision with root package name */
    private static ThreadPoolExecutor f4256d;

    /* renamed from: e, reason: collision with root package name */
    private static ThreadPoolExecutor f4257e;

    /* renamed from: f, reason: collision with root package name */
    private static ThreadPoolExecutor f4258f;

    /* renamed from: g, reason: collision with root package name */
    private static ThreadPoolExecutor f4259g;

    /* renamed from: h, reason: collision with root package name */
    private static ThreadPoolExecutor f4260h;

    public static class Priority {
        public static int HIGH = 0;
        public static int LOW = 9;
        public static int NORMAL = 1;
    }

    public static class a implements Comparable<a>, Runnable {

        /* renamed from: a, reason: collision with root package name */
        Runnable f4261a;

        /* renamed from: b, reason: collision with root package name */
        int f4262b;

        /* renamed from: c, reason: collision with root package name */
        long f4263c;

        public a(Runnable runnable, int i10) {
            this.f4261a = null;
            this.f4262b = 0;
            this.f4263c = System.currentTimeMillis();
            this.f4261a = runnable;
            this.f4262b = i10;
            this.f4263c = System.currentTimeMillis();
        }

        @Override // java.lang.Comparable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compareTo(a aVar) {
            int i10 = this.f4262b;
            int i11 = aVar.f4262b;
            return i10 != i11 ? i10 - i11 : (int) (aVar.f4263c - this.f4263c);
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f4261a.run();
        }
    }

    public static class b implements ThreadFactory {

        /* renamed from: a, reason: collision with root package name */
        AtomicInteger f4264a = new AtomicInteger(0);

        /* renamed from: b, reason: collision with root package name */
        String f4265b;

        public b(String str) {
            this.f4265b = str;
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable, this.f4265b + this.f4264a.incrementAndGet());
            ALog.i("awcn.ThreadPoolExecutorFactory", "thread created!", null, "name", thread.getName());
            thread.setPriority(5);
            return thread;
        }
    }

    static {
        TimeUnit timeUnit = TimeUnit.SECONDS;
        f4254b = new ThreadPoolExecutor(2, 2, 60L, timeUnit, new LinkedBlockingDeque(), new b("AWCN Worker(H)"));
        f4255c = new anet.channel.thread.a(16, 16, 60L, timeUnit, new PriorityBlockingQueue(), new b("AWCN Worker(M)"));
        f4256d = new ThreadPoolExecutor(2, 2, 60L, timeUnit, new LinkedBlockingDeque(), new b("AWCN Worker(L)"));
        f4257e = new ThreadPoolExecutor(32, 32, 60L, timeUnit, new LinkedBlockingDeque(), new b("AWCN Worker(Backup)"));
        f4258f = new ThreadPoolExecutor(1, 1, 30L, timeUnit, new LinkedBlockingDeque(), new b("AWCN Detector"));
        f4259g = new ThreadPoolExecutor(1, 1, 30L, timeUnit, new LinkedBlockingDeque(), new b("AWCN HR"));
        f4260h = new ThreadPoolExecutor(1, 1, 30L, timeUnit, new LinkedBlockingDeque(), new b("AWCN Cookie"));
        f4254b.allowCoreThreadTimeOut(true);
        f4255c.allowCoreThreadTimeOut(true);
        f4256d.allowCoreThreadTimeOut(true);
        f4257e.allowCoreThreadTimeOut(true);
        f4258f.allowCoreThreadTimeOut(true);
        f4259g.allowCoreThreadTimeOut(true);
        f4260h.allowCoreThreadTimeOut(true);
    }

    public static void removeScheduleTask(Runnable runnable) {
        f4253a.remove(runnable);
    }

    public static synchronized void setNormalExecutorPoolSize(int i10) {
        synchronized (ThreadPoolExecutorFactory.class) {
            if (i10 < 6) {
                i10 = 6;
            }
            f4255c.setCorePoolSize(i10);
            f4255c.setMaximumPoolSize(i10);
        }
    }

    public static Future<?> submitBackupTask(Runnable runnable) {
        return f4257e.submit(runnable);
    }

    public static Future<?> submitCookieMonitor(Runnable runnable) {
        return f4260h.submit(runnable);
    }

    public static Future<?> submitDetectTask(Runnable runnable) {
        return f4258f.submit(runnable);
    }

    public static Future<?> submitHRTask(Runnable runnable) {
        return f4259g.submit(runnable);
    }

    public static Future<?> submitPriorityTask(Runnable runnable, int i10) {
        if (ALog.isPrintLog(1)) {
            ALog.d("awcn.ThreadPoolExecutorFactory", "submit priority task", null, "priority", Integer.valueOf(i10));
        }
        if (i10 < Priority.HIGH || i10 > Priority.LOW) {
            i10 = Priority.LOW;
        }
        return i10 == Priority.HIGH ? f4254b.submit(runnable) : i10 == Priority.LOW ? f4256d.submit(runnable) : f4255c.submit(new a(runnable, i10));
    }

    public static Future<?> submitScheduledTask(Runnable runnable) {
        return f4253a.submit(runnable);
    }

    public static Future<?> submitScheduledTask(Runnable runnable, long j10, TimeUnit timeUnit) {
        return f4253a.schedule(runnable, j10, timeUnit);
    }
}
