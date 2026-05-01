package b1;

import android.content.Context;
import android.os.PowerManager;
import androidx.work.WorkerParameters;
import androidx.work.impl.WorkDatabase;
import b1.k;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import k1.n;

/* loaded from: classes.dex */
public class d implements b, i1.a {

    /* renamed from: l, reason: collision with root package name */
    public static final String f4386l = a1.k.f("Processor");

    /* renamed from: b, reason: collision with root package name */
    public Context f4388b;

    /* renamed from: c, reason: collision with root package name */
    public androidx.work.a f4389c;

    /* renamed from: d, reason: collision with root package name */
    public m1.a f4390d;

    /* renamed from: e, reason: collision with root package name */
    public WorkDatabase f4391e;

    /* renamed from: h, reason: collision with root package name */
    public List f4394h;

    /* renamed from: g, reason: collision with root package name */
    public Map f4393g = new HashMap();

    /* renamed from: f, reason: collision with root package name */
    public Map f4392f = new HashMap();

    /* renamed from: i, reason: collision with root package name */
    public Set f4395i = new HashSet();

    /* renamed from: j, reason: collision with root package name */
    public final List f4396j = new ArrayList();

    /* renamed from: a, reason: collision with root package name */
    public PowerManager.WakeLock f4387a = null;

    /* renamed from: k, reason: collision with root package name */
    public final Object f4397k = new Object();

    public static class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public b f4398a;

        /* renamed from: b, reason: collision with root package name */
        public String f4399b;

        /* renamed from: c, reason: collision with root package name */
        public ListenableFuture f4400c;

        public a(b bVar, String str, ListenableFuture listenableFuture) {
            this.f4398a = bVar;
            this.f4399b = str;
            this.f4400c = listenableFuture;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Runnable
        public void run() {
            boolean z10;
            try {
                z10 = ((Boolean) this.f4400c.get()).booleanValue();
            } catch (InterruptedException | ExecutionException unused) {
                z10 = true;
            }
            this.f4398a.c(this.f4399b, z10);
        }
    }

    public d(Context context, androidx.work.a aVar, m1.a aVar2, WorkDatabase workDatabase, List list) {
        this.f4388b = context;
        this.f4389c = aVar;
        this.f4390d = aVar2;
        this.f4391e = workDatabase;
        this.f4394h = list;
    }

    public static boolean e(String str, k kVar) {
        if (kVar == null) {
            a1.k.c().a(f4386l, String.format("WorkerWrapper could not be found for %s", str), new Throwable[0]);
            return false;
        }
        kVar.d();
        a1.k.c().a(f4386l, String.format("WorkerWrapper interrupted for %s", str), new Throwable[0]);
        return true;
    }

    @Override // i1.a
    public void a(String str) {
        synchronized (this.f4397k) {
            this.f4392f.remove(str);
            m();
        }
    }

    @Override // i1.a
    public void b(String str, a1.e eVar) {
        synchronized (this.f4397k) {
            a1.k.c().d(f4386l, String.format("Moving WorkSpec (%s) to the foreground", str), new Throwable[0]);
            k kVar = (k) this.f4393g.remove(str);
            if (kVar != null) {
                if (this.f4387a == null) {
                    PowerManager.WakeLock b10 = n.b(this.f4388b, "ProcessorForegroundLck");
                    this.f4387a = b10;
                    b10.acquire();
                }
                this.f4392f.put(str, kVar);
                p.a.startForegroundService(this.f4388b, androidx.work.impl.foreground.a.e(this.f4388b, str, eVar));
            }
        }
    }

    @Override // b1.b
    public void c(String str, boolean z10) {
        synchronized (this.f4397k) {
            this.f4393g.remove(str);
            a1.k.c().a(f4386l, String.format("%s %s executed; reschedule = %s", getClass().getSimpleName(), str, Boolean.valueOf(z10)), new Throwable[0]);
            Iterator it = this.f4396j.iterator();
            while (it.hasNext()) {
                ((b) it.next()).c(str, z10);
            }
        }
    }

    public void d(b bVar) {
        synchronized (this.f4397k) {
            this.f4396j.add(bVar);
        }
    }

    public boolean f(String str) {
        boolean contains;
        synchronized (this.f4397k) {
            contains = this.f4395i.contains(str);
        }
        return contains;
    }

    public boolean g(String str) {
        boolean z10;
        synchronized (this.f4397k) {
            z10 = this.f4393g.containsKey(str) || this.f4392f.containsKey(str);
        }
        return z10;
    }

    public boolean h(String str) {
        boolean containsKey;
        synchronized (this.f4397k) {
            containsKey = this.f4392f.containsKey(str);
        }
        return containsKey;
    }

    public void i(b bVar) {
        synchronized (this.f4397k) {
            this.f4396j.remove(bVar);
        }
    }

    public boolean j(String str) {
        return k(str, null);
    }

    public boolean k(String str, WorkerParameters.a aVar) {
        synchronized (this.f4397k) {
            if (g(str)) {
                a1.k.c().a(f4386l, String.format("Work %s is already enqueued for processing", str), new Throwable[0]);
                return false;
            }
            k a10 = new k.c(this.f4388b, this.f4389c, this.f4390d, this, this.f4391e, str).c(this.f4394h).b(aVar).a();
            ListenableFuture b10 = a10.b();
            b10.addListener(new a(this, str, b10), this.f4390d.a());
            this.f4393g.put(str, a10);
            this.f4390d.c().execute(a10);
            a1.k.c().a(f4386l, String.format("%s: processing %s", getClass().getSimpleName(), str), new Throwable[0]);
            return true;
        }
    }

    public boolean l(String str) {
        boolean e10;
        synchronized (this.f4397k) {
            boolean z10 = true;
            a1.k.c().a(f4386l, String.format("Processor cancelling %s", str), new Throwable[0]);
            this.f4395i.add(str);
            k kVar = (k) this.f4392f.remove(str);
            if (kVar == null) {
                z10 = false;
            }
            if (kVar == null) {
                kVar = (k) this.f4393g.remove(str);
            }
            e10 = e(str, kVar);
            if (z10) {
                m();
            }
        }
        return e10;
    }

    public final void m() {
        synchronized (this.f4397k) {
            if (!(!this.f4392f.isEmpty())) {
                try {
                    this.f4388b.startService(androidx.work.impl.foreground.a.f(this.f4388b));
                } catch (Throwable th) {
                    a1.k.c().b(f4386l, "Unable to stop foreground service", th);
                }
                PowerManager.WakeLock wakeLock = this.f4387a;
                if (wakeLock != null) {
                    wakeLock.release();
                    this.f4387a = null;
                }
            }
        }
    }

    public boolean n(String str) {
        boolean e10;
        synchronized (this.f4397k) {
            a1.k.c().a(f4386l, String.format("Processor stopping foreground work %s", str), new Throwable[0]);
            e10 = e(str, (k) this.f4392f.remove(str));
        }
        return e10;
    }

    public boolean o(String str) {
        boolean e10;
        synchronized (this.f4397k) {
            a1.k.c().a(f4386l, String.format("Processor stopping background work %s", str), new Throwable[0]);
            e10 = e(str, (k) this.f4393g.remove(str));
        }
        return e10;
    }
}
