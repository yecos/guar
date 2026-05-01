package z8;

import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.common.base.Preconditions;
import java.io.Closeable;
import java.io.InputStream;
import z8.g;
import z8.i2;
import z8.k1;

/* loaded from: classes3.dex */
public class f implements y {

    /* renamed from: a, reason: collision with root package name */
    public final k1.b f20442a;

    /* renamed from: b, reason: collision with root package name */
    public final z8.g f20443b;

    /* renamed from: c, reason: collision with root package name */
    public final k1 f20444c;

    public class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f20445a;

        public a(int i10) {
            this.f20445a = i10;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (f.this.f20444c.isClosed()) {
                return;
            }
            try {
                f.this.f20444c.b(this.f20445a);
            } catch (Throwable th) {
                f.this.f20443b.d(th);
                f.this.f20444c.close();
            }
        }
    }

    public class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ t1 f20447a;

        public b(t1 t1Var) {
            this.f20447a = t1Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                f.this.f20444c.f(this.f20447a);
            } catch (Throwable th) {
                f.this.f20443b.d(th);
                f.this.f20444c.close();
            }
        }
    }

    public class c implements Closeable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ t1 f20449a;

        public c(t1 t1Var) {
            this.f20449a = t1Var;
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            this.f20449a.close();
        }
    }

    public class d implements Runnable {
        public d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            f.this.f20444c.m();
        }
    }

    public class e implements Runnable {
        public e() {
        }

        @Override // java.lang.Runnable
        public void run() {
            f.this.f20444c.close();
        }
    }

    /* renamed from: z8.f$f, reason: collision with other inner class name */
    public class C0357f extends g implements Closeable {

        /* renamed from: d, reason: collision with root package name */
        public final Closeable f20453d;

        public C0357f(Runnable runnable, Closeable closeable) {
            super(f.this, runnable, null);
            this.f20453d = closeable;
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            this.f20453d.close();
        }
    }

    public class g implements i2.a {

        /* renamed from: a, reason: collision with root package name */
        public final Runnable f20455a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f20456b;

        public /* synthetic */ g(f fVar, Runnable runnable, a aVar) {
            this(runnable);
        }

        private void a() {
            if (this.f20456b) {
                return;
            }
            this.f20455a.run();
            this.f20456b = true;
        }

        @Override // z8.i2.a
        public InputStream next() {
            a();
            return f.this.f20443b.f();
        }

        public g(Runnable runnable) {
            this.f20456b = false;
            this.f20455a = runnable;
        }
    }

    public interface h extends g.d {
    }

    public f(k1.b bVar, h hVar, k1 k1Var) {
        f2 f2Var = new f2((k1.b) Preconditions.checkNotNull(bVar, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER));
        this.f20442a = f2Var;
        z8.g gVar = new z8.g(f2Var, hVar);
        this.f20443b = gVar;
        k1Var.E(gVar);
        this.f20444c = k1Var;
    }

    @Override // z8.y
    public void b(int i10) {
        this.f20442a.a(new g(this, new a(i10), null));
    }

    @Override // z8.y
    public void c(int i10) {
        this.f20444c.c(i10);
    }

    @Override // z8.y
    public void close() {
        this.f20444c.I();
        this.f20442a.a(new g(this, new e(), null));
    }

    @Override // z8.y
    public void e(y8.u uVar) {
        this.f20444c.e(uVar);
    }

    @Override // z8.y
    public void f(t1 t1Var) {
        this.f20442a.a(new C0357f(new b(t1Var), new c(t1Var)));
    }

    @Override // z8.y
    public void m() {
        this.f20442a.a(new g(this, new d(), null));
    }
}
