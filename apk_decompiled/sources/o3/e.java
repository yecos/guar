package o3;

import com.fasterxml.jackson.databind.deser.std.f0;
import com.taobao.accs.AccsClientConfig;
import java.lang.reflect.Member;
import java.util.HashMap;

/* loaded from: classes.dex */
public class e {

    /* renamed from: j, reason: collision with root package name */
    public static final String[] f17505j = {AccsClientConfig.DEFAULT_CONFIGTAG, "from-String", "from-int", "from-long", "from-big-integer", "from-double", "from-big-decimal", "from-boolean", "delegate", "property-based", "array-delegate"};

    /* renamed from: a, reason: collision with root package name */
    public final k3.c f17506a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f17507b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f17508c;

    /* renamed from: d, reason: collision with root package name */
    public final r3.n[] f17509d = new r3.n[11];

    /* renamed from: e, reason: collision with root package name */
    public int f17510e = 0;

    /* renamed from: f, reason: collision with root package name */
    public boolean f17511f = false;

    /* renamed from: g, reason: collision with root package name */
    public n3.t[] f17512g;

    /* renamed from: h, reason: collision with root package name */
    public n3.t[] f17513h;

    /* renamed from: i, reason: collision with root package name */
    public n3.t[] f17514i;

    public e(k3.c cVar, m3.m mVar) {
        this.f17506a = cVar;
        this.f17507b = mVar.b();
        this.f17508c = mVar.D(k3.q.OVERRIDE_PUBLIC_ACCESS_MODIFIERS);
    }

    public final k3.j a(k3.g gVar, r3.n nVar, n3.t[] tVarArr) {
        if (!this.f17511f || nVar == null) {
            return null;
        }
        int i10 = 0;
        if (tVarArr != null) {
            int length = tVarArr.length;
            int i11 = 0;
            while (true) {
                if (i11 >= length) {
                    break;
                }
                if (tVarArr[i11] == null) {
                    i10 = i11;
                    break;
                }
                i11++;
            }
        }
        k3.f k10 = gVar.k();
        k3.j w10 = nVar.w(i10);
        k3.b g10 = k10.g();
        if (g10 == null) {
            return w10;
        }
        r3.m t10 = nVar.t(i10);
        Object m10 = g10.m(t10);
        return m10 != null ? w10.f0(gVar.y(t10, m10)) : g10.u0(k10, t10, w10);
    }

    public final r3.i b(r3.i iVar) {
        if (iVar != null && this.f17507b) {
            d4.h.g((Member) iVar.b(), this.f17508c);
        }
        return iVar;
    }

    public boolean c(r3.n nVar) {
        return d4.h.L(nVar.k()) && "valueOf".equals(nVar.d());
    }

    public void d(int i10, boolean z10, r3.n nVar, r3.n nVar2) {
        Object[] objArr = new Object[4];
        objArr[0] = f17505j[i10];
        objArr[1] = z10 ? "explicitly marked" : "implicitly discovered";
        objArr[2] = nVar;
        objArr[3] = nVar2;
        throw new IllegalArgumentException(String.format("Conflicting %s creators: already had %s creator %s, encountered another: %s", objArr));
    }

    public void e(r3.n nVar, boolean z10) {
        s(nVar, 6, z10);
    }

    public void f(r3.n nVar, boolean z10) {
        s(nVar, 4, z10);
    }

    public void g(r3.n nVar, boolean z10) {
        s(nVar, 7, z10);
    }

    public void h(r3.n nVar, boolean z10, n3.t[] tVarArr, int i10) {
        if (nVar.w(i10).B()) {
            if (s(nVar, 10, z10)) {
                this.f17513h = tVarArr;
            }
        } else if (s(nVar, 8, z10)) {
            this.f17512g = tVarArr;
        }
    }

    public void i(r3.n nVar, boolean z10) {
        s(nVar, 5, z10);
    }

    public void j(r3.n nVar, boolean z10) {
        s(nVar, 2, z10);
    }

    public void k(r3.n nVar, boolean z10) {
        s(nVar, 3, z10);
    }

    public void l(r3.n nVar, boolean z10, n3.t[] tVarArr) {
        Integer num;
        if (s(nVar, 9, z10)) {
            if (tVarArr.length > 1) {
                HashMap hashMap = new HashMap();
                int length = tVarArr.length;
                for (int i10 = 0; i10 < length; i10++) {
                    String name = tVarArr[i10].getName();
                    if ((!name.isEmpty() || tVarArr[i10].q() == null) && (num = (Integer) hashMap.put(name, Integer.valueOf(i10))) != null) {
                        throw new IllegalArgumentException(String.format("Duplicate creator property \"%s\" (index %s vs %d) for type %s ", name, num, Integer.valueOf(i10), d4.h.X(this.f17506a.s())));
                    }
                }
            }
            this.f17514i = tVarArr;
        }
    }

    public void m(r3.n nVar, boolean z10) {
        s(nVar, 1, z10);
    }

    public n3.w n(k3.g gVar) {
        k3.f k10 = gVar.k();
        k3.j a10 = a(gVar, this.f17509d[8], this.f17512g);
        k3.j a11 = a(gVar, this.f17509d[10], this.f17513h);
        f0 f0Var = new f0(k10, this.f17506a.z());
        r3.n[] nVarArr = this.f17509d;
        f0Var.O(nVarArr[0], nVarArr[8], a10, this.f17512g, nVarArr[9], this.f17514i);
        f0Var.H(this.f17509d[10], a11, this.f17513h);
        f0Var.P(this.f17509d[1]);
        f0Var.M(this.f17509d[2]);
        f0Var.N(this.f17509d[3]);
        f0Var.J(this.f17509d[4]);
        f0Var.L(this.f17509d[5]);
        f0Var.I(this.f17509d[6]);
        f0Var.K(this.f17509d[7]);
        return f0Var;
    }

    public boolean o() {
        return this.f17509d[0] != null;
    }

    public boolean p() {
        return this.f17509d[8] != null;
    }

    public boolean q() {
        return this.f17509d[9] != null;
    }

    public void r(r3.n nVar) {
        this.f17509d[0] = (r3.n) b(nVar);
    }

    public boolean s(r3.n nVar, int i10, boolean z10) {
        boolean z11;
        int i11 = 1 << i10;
        this.f17511f = true;
        r3.n nVar2 = this.f17509d[i10];
        if (nVar2 != null) {
            if ((this.f17510e & i11) == 0) {
                z11 = !z10;
            } else {
                if (!z10) {
                    return false;
                }
                z11 = true;
            }
            if (z11 && nVar2.getClass() == nVar.getClass()) {
                Class x10 = nVar2.x(0);
                Class<?> x11 = nVar.x(0);
                if (x10 == x11) {
                    if (c(nVar)) {
                        return false;
                    }
                    if (!c(nVar2)) {
                        d(i10, z10, nVar2, nVar);
                    }
                } else {
                    if (x11.isAssignableFrom(x10)) {
                        return false;
                    }
                    if (!x10.isAssignableFrom(x11)) {
                        if (x10.isPrimitive() == x11.isPrimitive()) {
                            d(i10, z10, nVar2, nVar);
                        } else if (x10.isPrimitive()) {
                            return false;
                        }
                    }
                }
            }
        }
        if (z10) {
            this.f17510e |= i11;
        }
        this.f17509d[i10] = (r3.n) b(nVar);
        return true;
    }
}
