package e7;

import android.app.Activity;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

/* loaded from: classes3.dex */
public final class g {

    /* renamed from: b, reason: collision with root package name */
    public final Activity f12955b;

    /* renamed from: a, reason: collision with root package name */
    public final ScheduledExecutorService f12954a = Executors.newSingleThreadScheduledExecutor(new a());

    /* renamed from: c, reason: collision with root package name */
    public ScheduledFuture f12956c = null;

    public static final class a implements ThreadFactory {
        public a() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable);
            thread.setDaemon(true);
            return thread;
        }
    }

    public g(Activity activity) {
        this.f12955b = activity;
        b();
    }

    public final void a() {
        ScheduledFuture scheduledFuture = this.f12956c;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(true);
            this.f12956c = null;
        }
    }

    public void b() {
        a();
        this.f12956c = this.f12954a.schedule(new e(this.f12955b), 300L, TimeUnit.SECONDS);
    }

    public void c() {
        a();
        this.f12954a.shutdown();
    }
}
