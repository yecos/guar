package k3;

import java.util.Collection;
import r3.e0;

/* loaded from: classes.dex */
public final class f extends m3.n {

    /* renamed from: x, reason: collision with root package name */
    public static final int f14869x = m3.m.c(h.class);

    /* renamed from: o, reason: collision with root package name */
    public final d4.o f14870o;

    /* renamed from: p, reason: collision with root package name */
    public final z3.l f14871p;

    /* renamed from: q, reason: collision with root package name */
    public final m3.d f14872q;

    /* renamed from: r, reason: collision with root package name */
    public final m3.i f14873r;

    /* renamed from: s, reason: collision with root package name */
    public final int f14874s;

    /* renamed from: t, reason: collision with root package name */
    public final int f14875t;

    /* renamed from: u, reason: collision with root package name */
    public final int f14876u;

    /* renamed from: v, reason: collision with root package name */
    public final int f14877v;

    /* renamed from: w, reason: collision with root package name */
    public final int f14878w;

    public f(m3.a aVar, w3.d dVar, e0 e0Var, d4.v vVar, m3.h hVar, m3.d dVar2) {
        super(aVar, dVar, e0Var, vVar, hVar);
        this.f14874s = f14869x;
        this.f14870o = null;
        this.f14871p = z3.l.f20188d;
        this.f14873r = null;
        this.f14872q = dVar2;
        this.f14875t = 0;
        this.f14876u = 0;
        this.f14877v = 0;
        this.f14878w = 0;
    }

    @Override // m3.n
    /* renamed from: W, reason: merged with bridge method [inline-methods] */
    public final f H(int i10) {
        return new f(this, i10, this.f14874s, this.f14875t, this.f14876u, this.f14877v, this.f14878w);
    }

    public m3.b X(c4.f fVar, Class cls, m3.e eVar) {
        return this.f14872q.a(this, fVar, cls, eVar);
    }

    public m3.b Y(c4.f fVar, Class cls, m3.b bVar) {
        return this.f14872q.b(this, fVar, cls, bVar);
    }

    public w3.e Z(j jVar) {
        Collection c10;
        r3.c u10 = A(jVar.q()).u();
        w3.g c02 = g().c0(this, u10, jVar);
        if (c02 == null) {
            c02 = s(jVar);
            c10 = null;
            if (c02 == null) {
                return null;
            }
        } else {
            c10 = T().c(this, u10);
        }
        return c02.e(this, jVar, c10);
    }

    public m3.i a0() {
        m3.i iVar = this.f14873r;
        return iVar == null ? m3.i.f16668d : iVar;
    }

    public final int b0() {
        return this.f14874s;
    }

    public final z3.l c0() {
        return this.f14871p;
    }

    public d4.o d0() {
        return this.f14870o;
    }

    public c3.k e0(c3.k kVar) {
        int i10 = this.f14876u;
        if (i10 != 0) {
            kVar.v0(this.f14875t, i10);
        }
        int i11 = this.f14878w;
        if (i11 != 0) {
            kVar.u0(this.f14877v, i11);
        }
        return kVar;
    }

    public c3.k f0(c3.k kVar, c3.c cVar) {
        int i10 = this.f14876u;
        if (i10 != 0) {
            kVar.v0(this.f14875t, i10);
        }
        int i11 = this.f14878w;
        if (i11 != 0) {
            kVar.u0(this.f14877v, i11);
        }
        if (cVar != null) {
            kVar.C0(cVar);
        }
        return kVar;
    }

    public c g0(j jVar) {
        return i().c(this, jVar, this);
    }

    public c h0(j jVar, c cVar) {
        return i().d(this, jVar, this, cVar);
    }

    public c i0(j jVar) {
        return i().b(this, jVar, this);
    }

    public final boolean j0(h hVar) {
        return (hVar.b() & this.f14874s) != 0;
    }

    public boolean k0() {
        return this.f16703g != null ? !r0.h() : j0(h.UNWRAP_ROOT_VALUE);
    }

    public f l0(h hVar) {
        int b10 = this.f14874s | hVar.b();
        return b10 == this.f14874s ? this : new f(this, this.f16696a, b10, this.f14875t, this.f14876u, this.f14877v, this.f14878w);
    }

    public f m0(h hVar) {
        int b10 = this.f14874s & (hVar.b() ^ (-1));
        return b10 == this.f14874s ? this : new f(this, this.f16696a, b10, this.f14875t, this.f14876u, this.f14877v, this.f14878w);
    }

    public f(f fVar, int i10, int i11, int i12, int i13, int i14, int i15) {
        super(fVar, i10);
        this.f14874s = i11;
        this.f14870o = fVar.f14870o;
        this.f14871p = fVar.f14871p;
        this.f14872q = fVar.f14872q;
        this.f14873r = fVar.f14873r;
        this.f14875t = i12;
        this.f14876u = i13;
        this.f14877v = i14;
        this.f14878w = i15;
    }
}
