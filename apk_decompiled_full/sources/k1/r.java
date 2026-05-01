package k1;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public class r {

    /* renamed from: f, reason: collision with root package name */
    public static final String f14790f = a1.k.f("WorkTimer");

    /* renamed from: a, reason: collision with root package name */
    public final ThreadFactory f14791a;

    /* renamed from: b, reason: collision with root package name */
    public final ScheduledExecutorService f14792b;

    /* renamed from: c, reason: collision with root package name */
    public final Map f14793c;

    /* renamed from: d, reason: collision with root package name */
    public final Map f14794d;

    /* renamed from: e, reason: collision with root package name */
    public final Object f14795e;

    public class a implements ThreadFactory {

        /* renamed from: a, reason: collision with root package name */
        public int f14796a = 0;

        public a() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread newThread = Executors.defaultThreadFactory().newThread(runnable);
            newThread.setName("WorkManager-WorkTimer-thread-" + this.f14796a);
            this.f14796a = this.f14796a + 1;
            return newThread;
        }
    }

    public interface b {
        void a(String str);
    }

    public static class c implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final r f14798a;

        /* renamed from: b, reason: collision with root package name */
        public final String f14799b;

        public c(r rVar, String str) {
            this.f14798a = rVar;
            this.f14799b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (this.f14798a.f14795e) {
                if (((c) this.f14798a.f14793c.remove(this.f14799b)) != null) {
                    b bVar = (b) this.f14798a.f14794d.remove(this.f14799b);
                    if (bVar != null) {
                        bVar.a(this.f14799b);
                    }
                } else {
                    a1.k.c().a("WrkTimerRunnable", String.format("Timer with %s is already marked as complete.", this.f14799b), new Throwable[0]);
                }
            }
        }
    }

    public r() {
        a aVar = new a();
        this.f14791a = aVar;
        this.f14793c = new HashMap();
        this.f14794d = new HashMap();
        this.f14795e = new Object();
        this.f14792b = Executors.newSingleThreadScheduledExecutor(aVar);
    }

    public void a() {
        if (this.f14792b.isShutdown()) {
            return;
        }
        this.f14792b.shutdownNow();
    }

    public void b(String str, long j10, b bVar) {
        synchronized (this.f14795e) {
            a1.k.c().a(f14790f, String.format("Starting timer for %s", str), new Throwable[0]);
            c(str);
            c cVar = new c(this, str);
            this.f14793c.put(str, cVar);
            this.f14794d.put(str, bVar);
            this.f14792b.schedule(cVar, j10, TimeUnit.MILLISECONDS);
        }
    }

    public void c(String str) {
        synchronized (this.f14795e) {
            if (((c) this.f14793c.remove(str)) != null) {
                a1.k.c().a(f14790f, String.format("Stopping timer for %s", str), new Throwable[0]);
                this.f14794d.remove(str);
            }
        }
    }
}
