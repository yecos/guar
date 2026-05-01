package z8;

import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.common.base.Preconditions;
import java.io.InputStream;
import java.util.ArrayDeque;
import java.util.Queue;
import z8.i2;
import z8.k1;

/* loaded from: classes3.dex */
public final class g implements k1.b {

    /* renamed from: a, reason: collision with root package name */
    public final d f20588a;

    /* renamed from: b, reason: collision with root package name */
    public final k1.b f20589b;

    /* renamed from: c, reason: collision with root package name */
    public final Queue f20590c = new ArrayDeque();

    public class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f20591a;

        public a(int i10) {
            this.f20591a = i10;
        }

        @Override // java.lang.Runnable
        public void run() {
            g.this.f20589b.c(this.f20591a);
        }
    }

    public class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f20593a;

        public b(boolean z10) {
            this.f20593a = z10;
        }

        @Override // java.lang.Runnable
        public void run() {
            g.this.f20589b.e(this.f20593a);
        }
    }

    public class c implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Throwable f20595a;

        public c(Throwable th) {
            this.f20595a = th;
        }

        @Override // java.lang.Runnable
        public void run() {
            g.this.f20589b.d(this.f20595a);
        }
    }

    public interface d {
        void f(Runnable runnable);
    }

    public g(k1.b bVar, d dVar) {
        this.f20589b = (k1.b) Preconditions.checkNotNull(bVar, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.f20588a = (d) Preconditions.checkNotNull(dVar, "transportExecutor");
    }

    @Override // z8.k1.b
    public void a(i2.a aVar) {
        while (true) {
            InputStream next = aVar.next();
            if (next == null) {
                return;
            } else {
                this.f20590c.add(next);
            }
        }
    }

    @Override // z8.k1.b
    public void c(int i10) {
        this.f20588a.f(new a(i10));
    }

    @Override // z8.k1.b
    public void d(Throwable th) {
        this.f20588a.f(new c(th));
    }

    @Override // z8.k1.b
    public void e(boolean z10) {
        this.f20588a.f(new b(z10));
    }

    public InputStream f() {
        return (InputStream) this.f20590c.poll();
    }
}
