package z8;

import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import java.util.List;
import java.util.Map;
import y8.f;
import y8.o0;
import y8.y0;
import z8.c2;

/* loaded from: classes3.dex */
public final class j {

    /* renamed from: a, reason: collision with root package name */
    public final y8.q0 f20659a;

    /* renamed from: b, reason: collision with root package name */
    public final String f20660b;

    public final class b {

        /* renamed from: a, reason: collision with root package name */
        public final o0.d f20661a;

        /* renamed from: b, reason: collision with root package name */
        public y8.o0 f20662b;

        /* renamed from: c, reason: collision with root package name */
        public y8.p0 f20663c;

        public b(o0.d dVar) {
            this.f20661a = dVar;
            y8.p0 d10 = j.this.f20659a.d(j.this.f20660b);
            this.f20663c = d10;
            if (d10 != null) {
                this.f20662b = d10.a(dVar);
                return;
            }
            throw new IllegalStateException("Could not find policy '" + j.this.f20660b + "'. Make sure its implementation is either registered to LoadBalancerRegistry or included in META-INF/services/io.grpc.LoadBalancerProvider from your jar files.");
        }

        public y8.o0 a() {
            return this.f20662b;
        }

        public void b(y8.k1 k1Var) {
            a().c(k1Var);
        }

        public void c() {
            this.f20662b.e();
            this.f20662b = null;
        }

        public boolean d(o0.g gVar) {
            c2.b bVar = (c2.b) gVar.c();
            if (bVar == null) {
                try {
                    j jVar = j.this;
                    bVar = new c2.b(jVar.d(jVar.f20660b, "using default policy"), null);
                } catch (f e10) {
                    this.f20661a.f(y8.p.TRANSIENT_FAILURE, new d(y8.k1.f19903t.r(e10.getMessage())));
                    this.f20662b.e();
                    this.f20663c = null;
                    this.f20662b = new e();
                    return true;
                }
            }
            if (this.f20663c == null || !bVar.f20411a.b().equals(this.f20663c.b())) {
                this.f20661a.f(y8.p.CONNECTING, new c());
                this.f20662b.e();
                y8.p0 p0Var = bVar.f20411a;
                this.f20663c = p0Var;
                y8.o0 o0Var = this.f20662b;
                this.f20662b = p0Var.a(this.f20661a);
                this.f20661a.b().b(f.a.INFO, "Load balancer changed from {0} to {1}", o0Var.getClass().getSimpleName(), this.f20662b.getClass().getSimpleName());
            }
            Object obj = bVar.f20412b;
            if (obj != null) {
                this.f20661a.b().b(f.a.DEBUG, "Load-balancing config: {0}", bVar.f20412b);
            }
            return a().a(o0.g.d().b(gVar.a()).c(gVar.b()).d(obj).a());
        }
    }

    public static final class c extends o0.i {
        public c() {
        }

        @Override // y8.o0.i
        public o0.e a(o0.f fVar) {
            return o0.e.g();
        }

        public String toString() {
            return MoreObjects.toStringHelper((Class<?>) c.class).toString();
        }
    }

    public static final class d extends o0.i {

        /* renamed from: a, reason: collision with root package name */
        public final y8.k1 f20665a;

        public d(y8.k1 k1Var) {
            this.f20665a = k1Var;
        }

        @Override // y8.o0.i
        public o0.e a(o0.f fVar) {
            return o0.e.f(this.f20665a);
        }
    }

    public static final class e extends y8.o0 {
        public e() {
        }

        @Override // y8.o0
        public boolean a(o0.g gVar) {
            return true;
        }

        @Override // y8.o0
        public void c(y8.k1 k1Var) {
        }

        @Override // y8.o0
        public void d(o0.g gVar) {
        }

        @Override // y8.o0
        public void e() {
        }
    }

    public static final class f extends Exception {
        public f(String str) {
            super(str);
        }
    }

    public j(String str) {
        this(y8.q0.b(), str);
    }

    public final y8.p0 d(String str, String str2) {
        y8.p0 d10 = this.f20659a.d(str);
        if (d10 != null) {
            return d10;
        }
        throw new f("Trying to load '" + str + "' because " + str2 + ", but it's unavailable");
    }

    public b e(o0.d dVar) {
        return new b(dVar);
    }

    public y0.b f(Map map) {
        List A;
        if (map != null) {
            try {
                A = c2.A(c2.g(map));
            } catch (RuntimeException e10) {
                return y0.b.b(y8.k1.f19891h.r("can't parse load balancer configuration").q(e10));
            }
        } else {
            A = null;
        }
        if (A == null || A.isEmpty()) {
            return null;
        }
        return c2.y(A, this.f20659a);
    }

    public j(y8.q0 q0Var, String str) {
        this.f20659a = (y8.q0) Preconditions.checkNotNull(q0Var, "registry");
        this.f20660b = (String) Preconditions.checkNotNull(str, "defaultPolicy");
    }
}
