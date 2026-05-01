package n3;

import java.io.IOException;
import r3.b0;

/* loaded from: classes.dex */
public abstract class t extends r3.v {

    /* renamed from: n, reason: collision with root package name */
    public static final k3.k f17249n = new o3.h("No _valueDeserializer assigned");

    /* renamed from: c, reason: collision with root package name */
    public final k3.x f17250c;

    /* renamed from: d, reason: collision with root package name */
    public final k3.j f17251d;

    /* renamed from: e, reason: collision with root package name */
    public final k3.x f17252e;

    /* renamed from: f, reason: collision with root package name */
    public final transient d4.b f17253f;

    /* renamed from: g, reason: collision with root package name */
    public final k3.k f17254g;

    /* renamed from: h, reason: collision with root package name */
    public final w3.e f17255h;

    /* renamed from: i, reason: collision with root package name */
    public final q f17256i;

    /* renamed from: j, reason: collision with root package name */
    public String f17257j;

    /* renamed from: k, reason: collision with root package name */
    public b0 f17258k;

    /* renamed from: l, reason: collision with root package name */
    public d4.b0 f17259l;

    /* renamed from: m, reason: collision with root package name */
    public int f17260m;

    public static abstract class a extends t {

        /* renamed from: o, reason: collision with root package name */
        public final t f17261o;

        public a(t tVar) {
            super(tVar);
            this.f17261o = tVar;
        }

        @Override // n3.t
        public boolean A() {
            return this.f17261o.A();
        }

        @Override // n3.t
        public void C(Object obj, Object obj2) {
            this.f17261o.C(obj, obj2);
        }

        @Override // n3.t
        public Object D(Object obj, Object obj2) {
            return this.f17261o.D(obj, obj2);
        }

        @Override // n3.t
        public boolean H(Class cls) {
            return this.f17261o.H(cls);
        }

        @Override // n3.t
        public t I(k3.x xVar) {
            return M(this.f17261o.I(xVar));
        }

        @Override // n3.t
        public t J(q qVar) {
            return M(this.f17261o.J(qVar));
        }

        @Override // n3.t
        public t L(k3.k kVar) {
            return M(this.f17261o.L(kVar));
        }

        public t M(t tVar) {
            return tVar == this.f17261o ? this : N(tVar);
        }

        public abstract t N(t tVar);

        @Override // n3.t, k3.d
        public r3.i d() {
            return this.f17261o.d();
        }

        @Override // n3.t
        public void j(int i10) {
            this.f17261o.j(i10);
        }

        @Override // n3.t
        public void o(k3.f fVar) {
            this.f17261o.o(fVar);
        }

        @Override // n3.t
        public int p() {
            return this.f17261o.p();
        }

        @Override // n3.t
        public Object q() {
            return this.f17261o.q();
        }

        @Override // n3.t
        public String r() {
            return this.f17261o.r();
        }

        @Override // n3.t
        public b0 t() {
            return this.f17261o.t();
        }

        @Override // n3.t
        public k3.k u() {
            return this.f17261o.u();
        }

        @Override // n3.t
        public w3.e v() {
            return this.f17261o.v();
        }

        @Override // n3.t
        public boolean w() {
            return this.f17261o.w();
        }

        @Override // n3.t
        public boolean x() {
            return this.f17261o.x();
        }

        @Override // n3.t
        public boolean y() {
            return this.f17261o.y();
        }
    }

    public t(r3.s sVar, k3.j jVar, w3.e eVar, d4.b bVar) {
        this(sVar.c(), jVar, sVar.w(), eVar, bVar, sVar.getMetadata());
    }

    public boolean A() {
        return false;
    }

    public void B() {
    }

    public abstract void C(Object obj, Object obj2);

    public abstract Object D(Object obj, Object obj2);

    public void E(String str) {
        this.f17257j = str;
    }

    public void F(b0 b0Var) {
        this.f17258k = b0Var;
    }

    public void G(Class[] clsArr) {
        if (clsArr == null) {
            this.f17259l = null;
        } else {
            this.f17259l = d4.b0.a(clsArr);
        }
    }

    public boolean H(Class cls) {
        d4.b0 b0Var = this.f17259l;
        return b0Var == null || b0Var.b(cls);
    }

    public abstract t I(k3.x xVar);

    public abstract t J(q qVar);

    public t K(String str) {
        k3.x xVar = this.f17250c;
        k3.x xVar2 = xVar == null ? new k3.x(str) : xVar.j(str);
        return xVar2 == this.f17250c ? this : I(xVar2);
    }

    public abstract t L(k3.k kVar);

    @Override // k3.d
    public k3.x c() {
        return this.f17250c;
    }

    @Override // k3.d
    public abstract r3.i d();

    public IOException g(c3.k kVar, Exception exc) {
        d4.h.i0(exc);
        d4.h.j0(exc);
        Throwable F = d4.h.F(exc);
        throw k3.l.i(kVar, d4.h.o(F), F);
    }

    @Override // k3.d, d4.r
    public final String getName() {
        return this.f17250c.c();
    }

    @Override // k3.d
    public k3.j getType() {
        return this.f17251d;
    }

    public void h(c3.k kVar, Exception exc, Object obj) {
        if (!(exc instanceof IllegalArgumentException)) {
            g(kVar, exc);
            return;
        }
        String h10 = d4.h.h(obj);
        StringBuilder sb = new StringBuilder("Problem deserializing property '");
        sb.append(getName());
        sb.append("' (expected type: ");
        sb.append(getType());
        sb.append("; actual type: ");
        sb.append(h10);
        sb.append(")");
        String o10 = d4.h.o(exc);
        if (o10 != null) {
            sb.append(", problem: ");
            sb.append(o10);
        } else {
            sb.append(" (no error message provided)");
        }
        throw k3.l.i(kVar, sb.toString(), exc);
    }

    public void i(Exception exc, Object obj) {
        h(null, exc, obj);
    }

    public void j(int i10) {
        if (this.f17260m == -1) {
            this.f17260m = i10;
            return;
        }
        throw new IllegalStateException("Property '" + getName() + "' already had index (" + this.f17260m + "), trying to assign " + i10);
    }

    public final Object k(c3.k kVar, k3.g gVar) {
        if (kVar.j0(c3.n.VALUE_NULL)) {
            return this.f17256i.getNullValue(gVar);
        }
        w3.e eVar = this.f17255h;
        if (eVar != null) {
            return this.f17254g.deserializeWithType(kVar, gVar, eVar);
        }
        Object deserialize = this.f17254g.deserialize(kVar, gVar);
        return deserialize == null ? this.f17256i.getNullValue(gVar) : deserialize;
    }

    public abstract void l(c3.k kVar, k3.g gVar, Object obj);

    public abstract Object m(c3.k kVar, k3.g gVar, Object obj);

    public final Object n(c3.k kVar, k3.g gVar, Object obj) {
        if (kVar.j0(c3.n.VALUE_NULL)) {
            return o3.q.b(this.f17256i) ? obj : this.f17256i.getNullValue(gVar);
        }
        if (this.f17255h != null) {
            gVar.q(getType(), String.format("Cannot merge polymorphic property '%s'", getName()));
        }
        Object deserialize = this.f17254g.deserialize(kVar, gVar, obj);
        return deserialize == null ? o3.q.b(this.f17256i) ? obj : this.f17256i.getNullValue(gVar) : deserialize;
    }

    public void o(k3.f fVar) {
    }

    public int p() {
        throw new IllegalStateException(String.format("Internal error: no creator index for property '%s' (of type %s)", getName(), getClass().getName()));
    }

    public Object q() {
        return null;
    }

    public String r() {
        return this.f17257j;
    }

    public q s() {
        return this.f17256i;
    }

    public b0 t() {
        return this.f17258k;
    }

    public String toString() {
        return "[property '" + getName() + "']";
    }

    public k3.k u() {
        k3.k kVar = this.f17254g;
        if (kVar == f17249n) {
            return null;
        }
        return kVar;
    }

    public w3.e v() {
        return this.f17255h;
    }

    public boolean w() {
        k3.k kVar = this.f17254g;
        return (kVar == null || kVar == f17249n) ? false : true;
    }

    public boolean x() {
        return this.f17255h != null;
    }

    public boolean y() {
        return this.f17259l != null;
    }

    public boolean z() {
        return false;
    }

    public t(k3.x xVar, k3.j jVar, k3.x xVar2, w3.e eVar, d4.b bVar, k3.w wVar) {
        super(wVar);
        this.f17260m = -1;
        if (xVar == null) {
            this.f17250c = k3.x.f15007e;
        } else {
            this.f17250c = xVar.g();
        }
        this.f17251d = jVar;
        this.f17252e = xVar2;
        this.f17253f = bVar;
        this.f17259l = null;
        this.f17255h = eVar != null ? eVar.g(this) : eVar;
        k3.k kVar = f17249n;
        this.f17254g = kVar;
        this.f17256i = kVar;
    }

    public t(k3.x xVar, k3.j jVar, k3.w wVar, k3.k kVar) {
        super(wVar);
        this.f17260m = -1;
        if (xVar == null) {
            this.f17250c = k3.x.f15007e;
        } else {
            this.f17250c = xVar.g();
        }
        this.f17251d = jVar;
        this.f17252e = null;
        this.f17253f = null;
        this.f17259l = null;
        this.f17255h = null;
        this.f17254g = kVar;
        this.f17256i = kVar;
    }

    public t(t tVar) {
        super(tVar);
        this.f17260m = -1;
        this.f17250c = tVar.f17250c;
        this.f17251d = tVar.f17251d;
        this.f17252e = tVar.f17252e;
        this.f17253f = tVar.f17253f;
        this.f17254g = tVar.f17254g;
        this.f17255h = tVar.f17255h;
        this.f17257j = tVar.f17257j;
        this.f17260m = tVar.f17260m;
        this.f17259l = tVar.f17259l;
        this.f17256i = tVar.f17256i;
    }

    public t(t tVar, k3.k kVar, q qVar) {
        super(tVar);
        this.f17260m = -1;
        this.f17250c = tVar.f17250c;
        this.f17251d = tVar.f17251d;
        this.f17252e = tVar.f17252e;
        this.f17253f = tVar.f17253f;
        this.f17255h = tVar.f17255h;
        this.f17257j = tVar.f17257j;
        this.f17260m = tVar.f17260m;
        if (kVar == null) {
            this.f17254g = f17249n;
        } else {
            this.f17254g = kVar;
        }
        this.f17259l = tVar.f17259l;
        this.f17256i = qVar == f17249n ? this.f17254g : qVar;
    }

    public t(t tVar, k3.x xVar) {
        super(tVar);
        this.f17260m = -1;
        this.f17250c = xVar;
        this.f17251d = tVar.f17251d;
        this.f17252e = tVar.f17252e;
        this.f17253f = tVar.f17253f;
        this.f17254g = tVar.f17254g;
        this.f17255h = tVar.f17255h;
        this.f17257j = tVar.f17257j;
        this.f17260m = tVar.f17260m;
        this.f17259l = tVar.f17259l;
        this.f17256i = tVar.f17256i;
    }
}
