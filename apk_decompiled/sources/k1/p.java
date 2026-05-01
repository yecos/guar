package k1;

import a1.s;
import android.content.Context;
import androidx.work.impl.WorkDatabase;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.UUID;

/* loaded from: classes.dex */
public class p implements a1.f {

    /* renamed from: d, reason: collision with root package name */
    public static final String f14778d = a1.k.f("WMFgUpdater");

    /* renamed from: a, reason: collision with root package name */
    public final m1.a f14779a;

    /* renamed from: b, reason: collision with root package name */
    public final i1.a f14780b;

    /* renamed from: c, reason: collision with root package name */
    public final j1.q f14781c;

    public class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ l1.c f14782a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ UUID f14783b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ a1.e f14784c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ Context f14785d;

        public a(l1.c cVar, UUID uuid, a1.e eVar, Context context) {
            this.f14782a = cVar;
            this.f14783b = uuid;
            this.f14784c = eVar;
            this.f14785d = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                if (!this.f14782a.isCancelled()) {
                    String uuid = this.f14783b.toString();
                    s g10 = p.this.f14781c.g(uuid);
                    if (g10 == null || g10.a()) {
                        throw new IllegalStateException("Calls to setForegroundAsync() must complete before a ListenableWorker signals completion of work by returning an instance of Result.");
                    }
                    p.this.f14780b.b(uuid, this.f14784c);
                    this.f14785d.startService(androidx.work.impl.foreground.a.a(this.f14785d, uuid, this.f14784c));
                }
                this.f14782a.o(null);
            } catch (Throwable th) {
                this.f14782a.p(th);
            }
        }
    }

    public p(WorkDatabase workDatabase, i1.a aVar, m1.a aVar2) {
        this.f14780b = aVar;
        this.f14779a = aVar2;
        this.f14781c = workDatabase.B();
    }

    @Override // a1.f
    public ListenableFuture a(Context context, UUID uuid, a1.e eVar) {
        l1.c s10 = l1.c.s();
        this.f14779a.b(new a(s10, uuid, eVar, context));
        return s10;
    }
}
