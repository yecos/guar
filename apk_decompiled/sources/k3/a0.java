package k3;

import c3.h;
import r3.e0;

/* loaded from: classes.dex */
public final class a0 extends m3.n {

    /* renamed from: u, reason: collision with root package name */
    public static final c3.p f14808u = new j3.e();

    /* renamed from: v, reason: collision with root package name */
    public static final int f14809v = m3.m.c(b0.class);

    /* renamed from: o, reason: collision with root package name */
    public final c3.p f14810o;

    /* renamed from: p, reason: collision with root package name */
    public final int f14811p;

    /* renamed from: q, reason: collision with root package name */
    public final int f14812q;

    /* renamed from: r, reason: collision with root package name */
    public final int f14813r;

    /* renamed from: s, reason: collision with root package name */
    public final int f14814s;

    /* renamed from: t, reason: collision with root package name */
    public final int f14815t;

    public a0(m3.a aVar, w3.d dVar, e0 e0Var, d4.v vVar, m3.h hVar) {
        super(aVar, dVar, e0Var, vVar, hVar);
        this.f14811p = f14809v;
        this.f14810o = f14808u;
        this.f14812q = 0;
        this.f14813r = 0;
        this.f14814s = 0;
        this.f14815t = 0;
    }

    @Override // m3.n
    /* renamed from: W, reason: merged with bridge method [inline-methods] */
    public final a0 H(int i10) {
        return new a0(this, i10, this.f14811p, this.f14812q, this.f14813r, this.f14814s, this.f14815t);
    }

    public c3.p X() {
        c3.p pVar = this.f14810o;
        return pVar instanceof j3.f ? (c3.p) ((j3.f) pVar).f() : pVar;
    }

    public c3.p Y() {
        return this.f14810o;
    }

    public a4.k Z() {
        return null;
    }

    public void a0(c3.h hVar) {
        c3.p X;
        if (b0.INDENT_OUTPUT.c(this.f14811p) && hVar.u() == null && (X = X()) != null) {
            hVar.I(X);
        }
        boolean c10 = b0.WRITE_BIGDECIMAL_AS_PLAIN.c(this.f14811p);
        int i10 = this.f14813r;
        if (i10 != 0 || c10) {
            int i11 = this.f14812q;
            if (c10) {
                int d10 = h.b.WRITE_BIGDECIMAL_AS_PLAIN.d();
                i11 |= d10;
                i10 |= d10;
            }
            hVar.y(i11, i10);
        }
        int i12 = this.f14815t;
        if (i12 != 0) {
            hVar.x(this.f14814s, i12);
        }
    }

    public c b0(j jVar) {
        return i().e(this, jVar, this);
    }

    public final boolean c0(b0 b0Var) {
        return (b0Var.b() & this.f14811p) != 0;
    }

    public a0 d0(h.b bVar) {
        int d10 = this.f14812q & (bVar.d() ^ (-1));
        int d11 = this.f14813r | bVar.d();
        return (this.f14812q == d10 && this.f14813r == d11) ? this : new a0(this, this.f16696a, this.f14811p, d10, d11, this.f14814s, this.f14815t);
    }

    public a0(a0 a0Var, int i10, int i11, int i12, int i13, int i14, int i15) {
        super(a0Var, i10);
        this.f14811p = i11;
        a0Var.getClass();
        this.f14810o = a0Var.f14810o;
        this.f14812q = i12;
        this.f14813r = i13;
        this.f14814s = i14;
        this.f14815t = i15;
    }
}
