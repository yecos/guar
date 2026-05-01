package z8;

import com.google.common.base.Stopwatch;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import z8.s;

/* loaded from: classes3.dex */
public class u0 {

    /* renamed from: g, reason: collision with root package name */
    public static final Logger f20941g = Logger.getLogger(u0.class.getName());

    /* renamed from: a, reason: collision with root package name */
    public final long f20942a;

    /* renamed from: b, reason: collision with root package name */
    public final Stopwatch f20943b;

    /* renamed from: c, reason: collision with root package name */
    public Map f20944c = new LinkedHashMap();

    /* renamed from: d, reason: collision with root package name */
    public boolean f20945d;

    /* renamed from: e, reason: collision with root package name */
    public Throwable f20946e;

    /* renamed from: f, reason: collision with root package name */
    public long f20947f;

    public class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ s.a f20948a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ long f20949b;

        public a(s.a aVar, long j10) {
            this.f20948a = aVar;
            this.f20949b = j10;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f20948a.a(this.f20949b);
        }
    }

    public class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ s.a f20950a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Throwable f20951b;

        public b(s.a aVar, Throwable th) {
            this.f20950a = aVar;
            this.f20951b = th;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f20950a.onFailure(this.f20951b);
        }
    }

    public u0(long j10, Stopwatch stopwatch) {
        this.f20942a = j10;
        this.f20943b = stopwatch;
    }

    public static Runnable b(s.a aVar, long j10) {
        return new a(aVar, j10);
    }

    public static Runnable c(s.a aVar, Throwable th) {
        return new b(aVar, th);
    }

    public static void e(Executor executor, Runnable runnable) {
        try {
            executor.execute(runnable);
        } catch (Throwable th) {
            f20941g.log(Level.SEVERE, "Failed to execute PingCallback", th);
        }
    }

    public static void g(s.a aVar, Executor executor, Throwable th) {
        e(executor, c(aVar, th));
    }

    public void a(s.a aVar, Executor executor) {
        synchronized (this) {
            if (!this.f20945d) {
                this.f20944c.put(aVar, executor);
            } else {
                Throwable th = this.f20946e;
                e(executor, th != null ? c(aVar, th) : b(aVar, this.f20947f));
            }
        }
    }

    public boolean d() {
        synchronized (this) {
            if (this.f20945d) {
                return false;
            }
            this.f20945d = true;
            long elapsed = this.f20943b.elapsed(TimeUnit.NANOSECONDS);
            this.f20947f = elapsed;
            Map map = this.f20944c;
            this.f20944c = null;
            for (Map.Entry entry : map.entrySet()) {
                e((Executor) entry.getValue(), b((s.a) entry.getKey(), elapsed));
            }
            return true;
        }
    }

    public void f(Throwable th) {
        synchronized (this) {
            if (this.f20945d) {
                return;
            }
            this.f20945d = true;
            this.f20946e = th;
            Map map = this.f20944c;
            this.f20944c = null;
            for (Map.Entry entry : map.entrySet()) {
                g((s.a) entry.getKey(), (Executor) entry.getValue(), th);
            }
        }
    }

    public long h() {
        return this.f20942a;
    }
}
