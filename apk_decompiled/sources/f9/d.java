package f9;

import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import y8.k1;
import y8.o0;
import y8.p;

/* loaded from: classes3.dex */
public final class d extends f9.a {

    /* renamed from: l, reason: collision with root package name */
    public static final o0.i f13320l = new c();

    /* renamed from: c, reason: collision with root package name */
    public final o0 f13321c;

    /* renamed from: d, reason: collision with root package name */
    public final o0.d f13322d;

    /* renamed from: e, reason: collision with root package name */
    public o0.c f13323e;

    /* renamed from: f, reason: collision with root package name */
    public o0 f13324f;

    /* renamed from: g, reason: collision with root package name */
    public o0.c f13325g;

    /* renamed from: h, reason: collision with root package name */
    public o0 f13326h;

    /* renamed from: i, reason: collision with root package name */
    public p f13327i;

    /* renamed from: j, reason: collision with root package name */
    public o0.i f13328j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f13329k;

    public class a extends o0 {

        /* renamed from: f9.d$a$a, reason: collision with other inner class name */
        public class C0218a extends o0.i {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ k1 f13331a;

            public C0218a(k1 k1Var) {
                this.f13331a = k1Var;
            }

            @Override // y8.o0.i
            public o0.e a(o0.f fVar) {
                return o0.e.f(this.f13331a);
            }

            public String toString() {
                return MoreObjects.toStringHelper((Class<?>) C0218a.class).add("error", this.f13331a).toString();
            }
        }

        public a() {
        }

        @Override // y8.o0
        public void c(k1 k1Var) {
            d.this.f13322d.f(p.TRANSIENT_FAILURE, new C0218a(k1Var));
        }

        @Override // y8.o0
        public void d(o0.g gVar) {
            throw new IllegalStateException("GracefulSwitchLoadBalancer must switch to a load balancing policy before handling ResolvedAddresses");
        }

        @Override // y8.o0
        public void e() {
        }
    }

    public class b extends f9.b {

        /* renamed from: a, reason: collision with root package name */
        public o0 f13333a;

        public b() {
        }

        @Override // y8.o0.d
        public void f(p pVar, o0.i iVar) {
            if (this.f13333a == d.this.f13326h) {
                Preconditions.checkState(d.this.f13329k, "there's pending lb while current lb has been out of READY");
                d.this.f13327i = pVar;
                d.this.f13328j = iVar;
                if (pVar == p.READY) {
                    d.this.p();
                    return;
                }
                return;
            }
            if (this.f13333a == d.this.f13324f) {
                d.this.f13329k = pVar == p.READY;
                if (d.this.f13329k || d.this.f13326h == d.this.f13321c) {
                    d.this.f13322d.f(pVar, iVar);
                } else {
                    d.this.p();
                }
            }
        }

        @Override // f9.b
        public o0.d g() {
            return d.this.f13322d;
        }
    }

    public class c extends o0.i {
        @Override // y8.o0.i
        public o0.e a(o0.f fVar) {
            return o0.e.g();
        }

        public String toString() {
            return "BUFFER_PICKER";
        }
    }

    public d(o0.d dVar) {
        a aVar = new a();
        this.f13321c = aVar;
        this.f13324f = aVar;
        this.f13326h = aVar;
        this.f13322d = (o0.d) Preconditions.checkNotNull(dVar, "helper");
    }

    @Override // y8.o0
    public void e() {
        this.f13326h.e();
        this.f13324f.e();
    }

    @Override // f9.a
    public o0 f() {
        o0 o0Var = this.f13326h;
        return o0Var == this.f13321c ? this.f13324f : o0Var;
    }

    public final void p() {
        this.f13322d.f(this.f13327i, this.f13328j);
        this.f13324f.e();
        this.f13324f = this.f13326h;
        this.f13323e = this.f13325g;
        this.f13326h = this.f13321c;
        this.f13325g = null;
    }

    public void q(o0.c cVar) {
        Preconditions.checkNotNull(cVar, "newBalancerFactory");
        if (cVar.equals(this.f13325g)) {
            return;
        }
        this.f13326h.e();
        this.f13326h = this.f13321c;
        this.f13325g = null;
        this.f13327i = p.CONNECTING;
        this.f13328j = f13320l;
        if (cVar.equals(this.f13323e)) {
            return;
        }
        b bVar = new b();
        o0 a10 = cVar.a(bVar);
        bVar.f13333a = a10;
        this.f13326h = a10;
        this.f13325g = cVar;
        if (this.f13329k) {
            return;
        }
        p();
    }
}
