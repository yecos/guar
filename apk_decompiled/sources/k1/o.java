package k1;

import android.content.Context;
import androidx.work.ListenableWorker;
import com.google.common.util.concurrent.ListenableFuture;

/* loaded from: classes.dex */
public class o implements Runnable {

    /* renamed from: g, reason: collision with root package name */
    public static final String f14767g = a1.k.f("WorkForegroundRunnable");

    /* renamed from: a, reason: collision with root package name */
    public final l1.c f14768a = l1.c.s();

    /* renamed from: b, reason: collision with root package name */
    public final Context f14769b;

    /* renamed from: c, reason: collision with root package name */
    public final j1.p f14770c;

    /* renamed from: d, reason: collision with root package name */
    public final ListenableWorker f14771d;

    /* renamed from: e, reason: collision with root package name */
    public final a1.f f14772e;

    /* renamed from: f, reason: collision with root package name */
    public final m1.a f14773f;

    public class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ l1.c f14774a;

        public a(l1.c cVar) {
            this.f14774a = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f14774a.q(o.this.f14771d.e());
        }
    }

    public class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ l1.c f14776a;

        public b(l1.c cVar) {
            this.f14776a = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                a1.e eVar = (a1.e) this.f14776a.get();
                if (eVar == null) {
                    throw new IllegalStateException(String.format("Worker was marked important (%s) but did not provide ForegroundInfo", o.this.f14770c.f14585c));
                }
                a1.k.c().a(o.f14767g, String.format("Updating notification for %s", o.this.f14770c.f14585c), new Throwable[0]);
                o.this.f14771d.n(true);
                o oVar = o.this;
                oVar.f14768a.q(oVar.f14772e.a(oVar.f14769b, oVar.f14771d.f(), eVar));
            } catch (Throwable th) {
                o.this.f14768a.p(th);
            }
        }
    }

    public o(Context context, j1.p pVar, ListenableWorker listenableWorker, a1.f fVar, m1.a aVar) {
        this.f14769b = context;
        this.f14770c = pVar;
        this.f14771d = listenableWorker;
        this.f14772e = fVar;
        this.f14773f = aVar;
    }

    public ListenableFuture a() {
        return this.f14768a;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (!this.f14770c.f14599q || x.a.c()) {
            this.f14768a.o(null);
            return;
        }
        l1.c s10 = l1.c.s();
        this.f14773f.a().execute(new a(s10));
        s10.addListener(new b(s10), this.f14773f.a());
    }
}
