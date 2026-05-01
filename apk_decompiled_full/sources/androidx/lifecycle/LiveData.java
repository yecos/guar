package androidx.lifecycle;

import androidx.lifecycle.d;
import i.b;
import java.util.Map;

/* loaded from: classes.dex */
public abstract class LiveData {

    /* renamed from: k, reason: collision with root package name */
    public static final Object f2527k = new Object();

    /* renamed from: a, reason: collision with root package name */
    public final Object f2528a = new Object();

    /* renamed from: b, reason: collision with root package name */
    public i.b f2529b = new i.b();

    /* renamed from: c, reason: collision with root package name */
    public int f2530c = 0;

    /* renamed from: d, reason: collision with root package name */
    public boolean f2531d;

    /* renamed from: e, reason: collision with root package name */
    public volatile Object f2532e;

    /* renamed from: f, reason: collision with root package name */
    public volatile Object f2533f;

    /* renamed from: g, reason: collision with root package name */
    public int f2534g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f2535h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f2536i;

    /* renamed from: j, reason: collision with root package name */
    public final Runnable f2537j;

    public class LifecycleBoundObserver extends androidx.lifecycle.LiveData.c implements e {

        /* renamed from: e, reason: collision with root package name */
        public final g f2538e;

        public LifecycleBoundObserver(g gVar, m mVar) {
            super(mVar);
            this.f2538e = gVar;
        }

        @Override // androidx.lifecycle.e
        public void a(g gVar, d.b bVar) {
            d.c b10 = this.f2538e.getLifecycle().b();
            if (b10 == d.c.DESTROYED) {
                LiveData.this.m(this.f2542a);
                return;
            }
            d.c cVar = null;
            while (cVar != b10) {
                b(e());
                cVar = b10;
                b10 = this.f2538e.getLifecycle().b();
            }
        }

        public void c() {
            this.f2538e.getLifecycle().c(this);
        }

        public boolean d(g gVar) {
            return this.f2538e == gVar;
        }

        public boolean e() {
            return this.f2538e.getLifecycle().b().a(d.c.STARTED);
        }
    }

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Object obj;
            synchronized (LiveData.this.f2528a) {
                obj = LiveData.this.f2533f;
                LiveData.this.f2533f = LiveData.f2527k;
            }
            LiveData.this.n(obj);
        }
    }

    public class b extends c {
        public b(m mVar) {
            super(mVar);
        }

        @Override // androidx.lifecycle.LiveData.c
        public boolean e() {
            return true;
        }
    }

    public abstract class c {

        /* renamed from: a, reason: collision with root package name */
        public final m f2542a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f2543b;

        /* renamed from: c, reason: collision with root package name */
        public int f2544c = -1;

        public c(m mVar) {
            this.f2542a = mVar;
        }

        public void b(boolean z10) {
            if (z10 == this.f2543b) {
                return;
            }
            this.f2543b = z10;
            LiveData.this.c(z10 ? 1 : -1);
            if (this.f2543b) {
                LiveData.this.e(this);
            }
        }

        public void c() {
        }

        public boolean d(g gVar) {
            return false;
        }

        public abstract boolean e();
    }

    public LiveData() {
        Object obj = f2527k;
        this.f2533f = obj;
        this.f2537j = new a();
        this.f2532e = obj;
        this.f2534g = -1;
    }

    public static void b(String str) {
        if (h.a.e().b()) {
            return;
        }
        throw new IllegalStateException("Cannot invoke " + str + " on a background thread");
    }

    public void c(int i10) {
        int i11 = this.f2530c;
        this.f2530c = i10 + i11;
        if (this.f2531d) {
            return;
        }
        this.f2531d = true;
        while (true) {
            try {
                int i12 = this.f2530c;
                if (i11 == i12) {
                    return;
                }
                boolean z10 = i11 == 0 && i12 > 0;
                boolean z11 = i11 > 0 && i12 == 0;
                if (z10) {
                    j();
                } else if (z11) {
                    k();
                }
                i11 = i12;
            } finally {
                this.f2531d = false;
            }
        }
    }

    public final void d(c cVar) {
        if (cVar.f2543b) {
            if (!cVar.e()) {
                cVar.b(false);
                return;
            }
            int i10 = cVar.f2544c;
            int i11 = this.f2534g;
            if (i10 >= i11) {
                return;
            }
            cVar.f2544c = i11;
            cVar.f2542a.a(this.f2532e);
        }
    }

    public void e(c cVar) {
        if (this.f2535h) {
            this.f2536i = true;
            return;
        }
        this.f2535h = true;
        do {
            this.f2536i = false;
            if (cVar != null) {
                d(cVar);
                cVar = null;
            } else {
                b.d c10 = this.f2529b.c();
                while (c10.hasNext()) {
                    d((c) ((Map.Entry) c10.next()).getValue());
                    if (this.f2536i) {
                        break;
                    }
                }
            }
        } while (this.f2536i);
        this.f2535h = false;
    }

    public Object f() {
        Object obj = this.f2532e;
        if (obj != f2527k) {
            return obj;
        }
        return null;
    }

    public boolean g() {
        return this.f2530c > 0;
    }

    public void h(g gVar, m mVar) {
        b("observe");
        if (gVar.getLifecycle().b() == d.c.DESTROYED) {
            return;
        }
        LifecycleBoundObserver lifecycleBoundObserver = new LifecycleBoundObserver(gVar, mVar);
        c cVar = (c) this.f2529b.f(mVar, lifecycleBoundObserver);
        if (cVar != null && !cVar.d(gVar)) {
            throw new IllegalArgumentException("Cannot add the same observer with different lifecycles");
        }
        if (cVar != null) {
            return;
        }
        gVar.getLifecycle().a(lifecycleBoundObserver);
    }

    public void i(m mVar) {
        b("observeForever");
        b bVar = new b(mVar);
        c cVar = (c) this.f2529b.f(mVar, bVar);
        if (cVar instanceof LifecycleBoundObserver) {
            throw new IllegalArgumentException("Cannot add the same observer with different lifecycles");
        }
        if (cVar != null) {
            return;
        }
        bVar.b(true);
    }

    public void j() {
    }

    public void k() {
    }

    public void l(Object obj) {
        boolean z10;
        synchronized (this.f2528a) {
            z10 = this.f2533f == f2527k;
            this.f2533f = obj;
        }
        if (z10) {
            h.a.e().c(this.f2537j);
        }
    }

    public void m(m mVar) {
        b("removeObserver");
        c cVar = (c) this.f2529b.g(mVar);
        if (cVar == null) {
            return;
        }
        cVar.c();
        cVar.b(false);
    }

    public void n(Object obj) {
        b("setValue");
        this.f2534g++;
        this.f2532e = obj;
        e(null);
    }
}
