package m3;

import b3.b0;
import b3.f;
import b3.k;
import b3.p;
import b3.r;
import b3.s;
import d4.v;
import k3.q;
import k3.x;
import r3.e0;
import r3.h0;

/* loaded from: classes.dex */
public abstract class n extends m {

    /* renamed from: l, reason: collision with root package name */
    public static final g f16698l = g.a();

    /* renamed from: m, reason: collision with root package name */
    public static final int f16699m = m.c(q.class);

    /* renamed from: n, reason: collision with root package name */
    public static final int f16700n = (((q.AUTO_DETECT_FIELDS.b() | q.AUTO_DETECT_GETTERS.b()) | q.AUTO_DETECT_IS_GETTERS.b()) | q.AUTO_DETECT_SETTERS.b()) | q.AUTO_DETECT_CREATORS.b();

    /* renamed from: e, reason: collision with root package name */
    public final e0 f16701e;

    /* renamed from: f, reason: collision with root package name */
    public final w3.d f16702f;

    /* renamed from: g, reason: collision with root package name */
    public final x f16703g;

    /* renamed from: h, reason: collision with root package name */
    public final Class f16704h;

    /* renamed from: i, reason: collision with root package name */
    public final j f16705i;

    /* renamed from: j, reason: collision with root package name */
    public final v f16706j;

    /* renamed from: k, reason: collision with root package name */
    public final h f16707k;

    public n(a aVar, w3.d dVar, e0 e0Var, v vVar, h hVar) {
        super(aVar, f16699m);
        this.f16701e = e0Var;
        this.f16702f = dVar;
        this.f16706j = vVar;
        this.f16703g = null;
        this.f16704h = null;
        this.f16705i = j.b();
        this.f16707k = hVar;
    }

    public abstract n H(int i10);

    public x I(Class cls) {
        x xVar = this.f16703g;
        return xVar != null ? xVar : this.f16706j.a(cls, this);
    }

    public x J(k3.j jVar) {
        x xVar = this.f16703g;
        return xVar != null ? xVar : this.f16706j.b(jVar, this);
    }

    public final Class K() {
        return this.f16704h;
    }

    public final j L() {
        return this.f16705i;
    }

    public Boolean M(Class cls) {
        Boolean g10;
        g b10 = this.f16707k.b(cls);
        return (b10 == null || (g10 = b10.g()) == null) ? this.f16707k.d() : g10;
    }

    public final p.a N(Class cls) {
        p.a c10;
        g b10 = this.f16707k.b(cls);
        if (b10 == null || (c10 = b10.c()) == null) {
            return null;
        }
        return c10;
    }

    public final p.a O(Class cls, r3.c cVar) {
        k3.b g10 = g();
        return p.a.k(g10 == null ? null : g10.K(this, cVar), N(cls));
    }

    public final r.b P() {
        return this.f16707k.c();
    }

    public final s.a Q(Class cls, r3.c cVar) {
        k3.b g10 = g();
        if (g10 == null) {
            return null;
        }
        return g10.N(this, cVar);
    }

    public final h0 R() {
        h0 f10 = this.f16707k.f();
        int i10 = this.f16696a;
        int i11 = f16700n;
        if ((i10 & i11) == i11) {
            return f10;
        }
        if (!D(q.AUTO_DETECT_FIELDS)) {
            f10 = f10.c(f.c.NONE);
        }
        if (!D(q.AUTO_DETECT_GETTERS)) {
            f10 = f10.b(f.c.NONE);
        }
        if (!D(q.AUTO_DETECT_IS_GETTERS)) {
            f10 = f10.k(f.c.NONE);
        }
        if (!D(q.AUTO_DETECT_SETTERS)) {
            f10 = f10.h(f.c.NONE);
        }
        return !D(q.AUTO_DETECT_CREATORS) ? f10.l(f.c.NONE) : f10;
    }

    public final x S() {
        return this.f16703g;
    }

    public final w3.d T() {
        return this.f16702f;
    }

    public final n U(q... qVarArr) {
        int i10 = this.f16696a;
        for (q qVar : qVarArr) {
            i10 |= qVar.b();
        }
        return i10 == this.f16696a ? this : H(i10);
    }

    public final n V(q... qVarArr) {
        int i10 = this.f16696a;
        for (q qVar : qVarArr) {
            i10 &= qVar.b() ^ (-1);
        }
        return i10 == this.f16696a ? this : H(i10);
    }

    @Override // r3.t.a
    public final Class a(Class cls) {
        return this.f16701e.a(cls);
    }

    @Override // m3.m
    public final g j(Class cls) {
        g b10 = this.f16707k.b(cls);
        return b10 == null ? f16698l : b10;
    }

    @Override // m3.m
    public final r.b l(Class cls, Class cls2) {
        r.b e10 = j(cls2).e();
        r.b p10 = p(cls);
        return p10 == null ? e10 : p10.m(e10);
    }

    @Override // m3.m
    public Boolean n() {
        return this.f16707k.d();
    }

    @Override // m3.m
    public final k.d o(Class cls) {
        return this.f16707k.a(cls);
    }

    @Override // m3.m
    public final r.b p(Class cls) {
        r.b d10 = j(cls).d();
        r.b P = P();
        return P == null ? d10 : P.m(d10);
    }

    @Override // m3.m
    public final b0.a r() {
        return this.f16707k.e();
    }

    @Override // m3.m
    public final h0 t(Class cls, r3.c cVar) {
        h0 R = R();
        k3.b g10 = g();
        if (g10 != null) {
            R = g10.e(cVar, R);
        }
        g b10 = this.f16707k.b(cls);
        if (b10 == null) {
            return R;
        }
        b10.i();
        return R.i(null);
    }

    public n(n nVar, int i10) {
        super(nVar, i10);
        this.f16701e = nVar.f16701e;
        this.f16702f = nVar.f16702f;
        this.f16706j = nVar.f16706j;
        this.f16703g = nVar.f16703g;
        this.f16704h = nVar.f16704h;
        this.f16705i = nVar.f16705i;
        this.f16707k = nVar.f16707k;
    }
}
