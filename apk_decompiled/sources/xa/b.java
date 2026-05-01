package xa;

/* loaded from: classes.dex */
public final class b implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final i f19583a = new i();

    /* renamed from: b, reason: collision with root package name */
    public final c f19584b;

    /* renamed from: c, reason: collision with root package name */
    public volatile boolean f19585c;

    public b(c cVar) {
        this.f19584b = cVar;
    }

    public void a(n nVar, Object obj) {
        h a10 = h.a(nVar, obj);
        synchronized (this) {
            this.f19583a.a(a10);
            if (!this.f19585c) {
                this.f19585c = true;
                this.f19584b.d().execute(this);
            }
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        while (true) {
            try {
                h c10 = this.f19583a.c(1000);
                if (c10 == null) {
                    synchronized (this) {
                        c10 = this.f19583a.b();
                        if (c10 == null) {
                            return;
                        }
                    }
                }
                this.f19584b.f(c10);
            } catch (InterruptedException unused) {
                StringBuilder sb = new StringBuilder();
                sb.append(Thread.currentThread().getName());
                sb.append(" was interruppted");
                return;
            } finally {
                this.f19585c = false;
            }
        }
    }
}
