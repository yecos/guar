package c1;

import a1.k;
import a1.q;
import j1.p;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class a {

    /* renamed from: d, reason: collision with root package name */
    public static final String f5292d = k.f("DelayedWorkTracker");

    /* renamed from: a, reason: collision with root package name */
    public final b f5293a;

    /* renamed from: b, reason: collision with root package name */
    public final q f5294b;

    /* renamed from: c, reason: collision with root package name */
    public final Map f5295c = new HashMap();

    /* renamed from: c1.a$a, reason: collision with other inner class name */
    public class RunnableC0078a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ p f5296a;

        public RunnableC0078a(p pVar) {
            this.f5296a = pVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            k.c().a(a.f5292d, String.format("Scheduling work %s", this.f5296a.f14583a), new Throwable[0]);
            a.this.f5293a.e(this.f5296a);
        }
    }

    public a(b bVar, q qVar) {
        this.f5293a = bVar;
        this.f5294b = qVar;
    }

    public void a(p pVar) {
        Runnable runnable = (Runnable) this.f5295c.remove(pVar.f14583a);
        if (runnable != null) {
            this.f5294b.a(runnable);
        }
        RunnableC0078a runnableC0078a = new RunnableC0078a(pVar);
        this.f5295c.put(pVar.f14583a, runnableC0078a);
        this.f5294b.b(pVar.a() - System.currentTimeMillis(), runnableC0078a);
    }

    public void b(String str) {
        Runnable runnable = (Runnable) this.f5295c.remove(str);
        if (runnable != null) {
            this.f5294b.a(runnable);
        }
    }
}
