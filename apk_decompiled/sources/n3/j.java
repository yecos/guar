package n3;

import b3.b;

/* loaded from: classes.dex */
public class j extends t {

    /* renamed from: o, reason: collision with root package name */
    public final r3.m f17229o;

    /* renamed from: p, reason: collision with root package name */
    public final b.a f17230p;

    /* renamed from: q, reason: collision with root package name */
    public t f17231q;

    /* renamed from: r, reason: collision with root package name */
    public final int f17232r;

    /* renamed from: s, reason: collision with root package name */
    public boolean f17233s;

    public j(k3.x xVar, k3.j jVar, k3.x xVar2, w3.e eVar, d4.b bVar, r3.m mVar, int i10, b.a aVar, k3.w wVar) {
        super(xVar, jVar, xVar2, eVar, bVar, wVar);
        this.f17229o = mVar;
        this.f17232r = i10;
        this.f17230p = aVar;
        this.f17231q = null;
    }

    public static j O(k3.x xVar, k3.j jVar, k3.x xVar2, w3.e eVar, d4.b bVar, r3.m mVar, int i10, b.a aVar, k3.w wVar) {
        return new j(xVar, jVar, xVar2, eVar, bVar, mVar, i10, aVar, wVar);
    }

    @Override // n3.t
    public boolean A() {
        b.a aVar = this.f17230p;
        return (aVar == null || aVar.g(true)) ? false : true;
    }

    @Override // n3.t
    public void B() {
        this.f17233s = true;
    }

    @Override // n3.t
    public void C(Object obj, Object obj2) {
        N();
        this.f17231q.C(obj, obj2);
    }

    @Override // n3.t
    public Object D(Object obj, Object obj2) {
        N();
        return this.f17231q.D(obj, obj2);
    }

    @Override // n3.t
    public t I(k3.x xVar) {
        return new j(this, xVar);
    }

    @Override // n3.t
    public t J(q qVar) {
        return new j(this, this.f17254g, qVar);
    }

    @Override // n3.t
    public t L(k3.k kVar) {
        k3.k kVar2 = this.f17254g;
        if (kVar2 == kVar) {
            return this;
        }
        q qVar = this.f17256i;
        if (kVar2 == qVar) {
            qVar = kVar;
        }
        return new j(this, kVar, qVar);
    }

    public final void M(c3.k kVar, k3.g gVar) {
        String str = "No fallback setter/field defined for creator property " + d4.h.U(getName());
        if (gVar == null) {
            throw p3.b.v(kVar, str, getType());
        }
        gVar.q(getType(), str);
    }

    public final void N() {
        if (this.f17231q == null) {
            M(null, null);
        }
    }

    public void P(t tVar) {
        this.f17231q = tVar;
    }

    @Override // n3.t, k3.d
    public r3.i d() {
        return this.f17229o;
    }

    @Override // r3.v, k3.d
    public k3.w getMetadata() {
        k3.w metadata = super.getMetadata();
        t tVar = this.f17231q;
        return tVar != null ? metadata.i(tVar.getMetadata().d()) : metadata;
    }

    @Override // n3.t
    public void l(c3.k kVar, k3.g gVar, Object obj) {
        N();
        this.f17231q.C(obj, k(kVar, gVar));
    }

    @Override // n3.t
    public Object m(c3.k kVar, k3.g gVar, Object obj) {
        N();
        return this.f17231q.D(obj, k(kVar, gVar));
    }

    @Override // n3.t
    public void o(k3.f fVar) {
        t tVar = this.f17231q;
        if (tVar != null) {
            tVar.o(fVar);
        }
    }

    @Override // n3.t
    public int p() {
        return this.f17232r;
    }

    @Override // n3.t
    public Object q() {
        b.a aVar = this.f17230p;
        if (aVar == null) {
            return null;
        }
        return aVar.e();
    }

    @Override // n3.t
    public String toString() {
        return "[creator property, name " + d4.h.U(getName()) + "; inject id '" + q() + "']";
    }

    @Override // n3.t
    public boolean z() {
        return this.f17233s;
    }

    public j(j jVar, k3.x xVar) {
        super(jVar, xVar);
        this.f17229o = jVar.f17229o;
        this.f17230p = jVar.f17230p;
        this.f17231q = jVar.f17231q;
        this.f17232r = jVar.f17232r;
        this.f17233s = jVar.f17233s;
    }

    public j(j jVar, k3.k kVar, q qVar) {
        super(jVar, kVar, qVar);
        this.f17229o = jVar.f17229o;
        this.f17230p = jVar.f17230p;
        this.f17231q = jVar.f17231q;
        this.f17232r = jVar.f17232r;
        this.f17233s = jVar.f17233s;
    }
}
