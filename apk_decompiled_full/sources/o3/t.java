package o3;

import o3.z;

/* loaded from: classes.dex */
public class t extends n3.t {

    /* renamed from: o, reason: collision with root package name */
    public final n3.t f17567o;

    public static final class a extends z.a {

        /* renamed from: c, reason: collision with root package name */
        public final t f17568c;

        /* renamed from: d, reason: collision with root package name */
        public final Object f17569d;

        public a(t tVar, n3.u uVar, Class cls, Object obj) {
            super(uVar, cls);
            this.f17568c = tVar;
            this.f17569d = obj;
        }
    }

    public t(n3.t tVar, r3.b0 b0Var) {
        super(tVar);
        this.f17567o = tVar;
        this.f17258k = b0Var;
    }

    @Override // n3.t
    public void C(Object obj, Object obj2) {
        this.f17567o.C(obj, obj2);
    }

    @Override // n3.t
    public Object D(Object obj, Object obj2) {
        return this.f17567o.D(obj, obj2);
    }

    @Override // n3.t
    public n3.t I(k3.x xVar) {
        return new t(this, xVar);
    }

    @Override // n3.t
    public n3.t J(n3.q qVar) {
        return new t(this, this.f17254g, qVar);
    }

    @Override // n3.t
    public n3.t L(k3.k kVar) {
        k3.k kVar2 = this.f17254g;
        if (kVar2 == kVar) {
            return this;
        }
        n3.q qVar = this.f17256i;
        if (kVar2 == qVar) {
            qVar = kVar;
        }
        return new t(this, kVar, qVar);
    }

    @Override // n3.t, k3.d
    public r3.i d() {
        return this.f17567o.d();
    }

    @Override // n3.t
    public void l(c3.k kVar, k3.g gVar, Object obj) {
        m(kVar, gVar, obj);
    }

    @Override // n3.t
    public Object m(c3.k kVar, k3.g gVar, Object obj) {
        try {
            return D(obj, k(kVar, gVar));
        } catch (n3.u e10) {
            if (!((this.f17258k == null && this.f17254g.getObjectIdReader() == null) ? false : true)) {
                throw k3.l.i(kVar, "Unresolved forward reference but no identity info", e10);
            }
            e10.t().a(new a(this, e10, this.f17251d.q(), obj));
            return null;
        }
    }

    @Override // n3.t
    public void o(k3.f fVar) {
        n3.t tVar = this.f17567o;
        if (tVar != null) {
            tVar.o(fVar);
        }
    }

    @Override // n3.t
    public int p() {
        return this.f17567o.p();
    }

    public t(t tVar, k3.k kVar, n3.q qVar) {
        super(tVar, kVar, qVar);
        this.f17567o = tVar.f17567o;
        this.f17258k = tVar.f17258k;
    }

    public t(t tVar, k3.x xVar) {
        super(tVar, xVar);
        this.f17567o = tVar.f17567o;
        this.f17258k = tVar.f17258k;
    }
}
