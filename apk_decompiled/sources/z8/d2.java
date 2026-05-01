package z8;

import com.google.common.base.Preconditions;
import java.util.IdentityHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* loaded from: classes3.dex */
public final class d2 {

    /* renamed from: d, reason: collision with root package name */
    public static final d2 f20424d = new d2(new a());

    /* renamed from: a, reason: collision with root package name */
    public final IdentityHashMap f20425a = new IdentityHashMap();

    /* renamed from: b, reason: collision with root package name */
    public final e f20426b;

    /* renamed from: c, reason: collision with root package name */
    public ScheduledExecutorService f20427c;

    public class a implements e {
        @Override // z8.d2.e
        public ScheduledExecutorService a() {
            return Executors.newSingleThreadScheduledExecutor(q0.i("grpc-shared-destroyer-%d", true));
        }
    }

    public class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f20428a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ d f20429b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Object f20430c;

        public b(c cVar, d dVar, Object obj) {
            this.f20428a = cVar;
            this.f20429b = dVar;
            this.f20430c = obj;
        }

        /* JADX WARN: Finally extract failed */
        @Override // java.lang.Runnable
        public void run() {
            synchronized (d2.this) {
                if (this.f20428a.f20433b == 0) {
                    try {
                        this.f20429b.close(this.f20430c);
                        d2.this.f20425a.remove(this.f20429b);
                        if (d2.this.f20425a.isEmpty()) {
                            d2.this.f20427c.shutdown();
                            d2.this.f20427c = null;
                        }
                    } catch (Throwable th) {
                        d2.this.f20425a.remove(this.f20429b);
                        if (d2.this.f20425a.isEmpty()) {
                            d2.this.f20427c.shutdown();
                            d2.this.f20427c = null;
                        }
                        throw th;
                    }
                }
            }
        }
    }

    public static class c {

        /* renamed from: a, reason: collision with root package name */
        public final Object f20432a;

        /* renamed from: b, reason: collision with root package name */
        public int f20433b;

        /* renamed from: c, reason: collision with root package name */
        public ScheduledFuture f20434c;

        public c(Object obj) {
            this.f20432a = obj;
        }
    }

    public interface d {
        void close(Object obj);

        Object create();
    }

    public interface e {
        ScheduledExecutorService a();
    }

    public d2(e eVar) {
        this.f20426b = eVar;
    }

    public static Object d(d dVar) {
        return f20424d.e(dVar);
    }

    public static Object f(d dVar, Object obj) {
        return f20424d.g(dVar, obj);
    }

    public synchronized Object e(d dVar) {
        c cVar;
        cVar = (c) this.f20425a.get(dVar);
        if (cVar == null) {
            cVar = new c(dVar.create());
            this.f20425a.put(dVar, cVar);
        }
        ScheduledFuture scheduledFuture = cVar.f20434c;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(false);
            cVar.f20434c = null;
        }
        cVar.f20433b++;
        return cVar.f20432a;
    }

    public synchronized Object g(d dVar, Object obj) {
        c cVar = (c) this.f20425a.get(dVar);
        if (cVar == null) {
            throw new IllegalArgumentException("No cached instance found for " + dVar);
        }
        Preconditions.checkArgument(obj == cVar.f20432a, "Releasing the wrong instance");
        Preconditions.checkState(cVar.f20433b > 0, "Refcount has already reached zero");
        int i10 = cVar.f20433b - 1;
        cVar.f20433b = i10;
        if (i10 == 0) {
            Preconditions.checkState(cVar.f20434c == null, "Destroy task already scheduled");
            if (this.f20427c == null) {
                this.f20427c = this.f20426b.a();
            }
            cVar.f20434c = this.f20427c.schedule(new c1(new b(cVar, dVar, obj)), 1L, TimeUnit.SECONDS);
        }
        return null;
    }
}
