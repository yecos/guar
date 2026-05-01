package com.fasterxml.jackson.databind.deser.std;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.math.BigInteger;

/* loaded from: classes.dex */
public class f0 extends n3.w implements Serializable {

    /* renamed from: a, reason: collision with root package name */
    public final String f6513a;

    /* renamed from: b, reason: collision with root package name */
    public final Class f6514b;

    /* renamed from: c, reason: collision with root package name */
    public r3.n f6515c;

    /* renamed from: d, reason: collision with root package name */
    public r3.n f6516d;

    /* renamed from: e, reason: collision with root package name */
    public n3.t[] f6517e;

    /* renamed from: f, reason: collision with root package name */
    public k3.j f6518f;

    /* renamed from: g, reason: collision with root package name */
    public r3.n f6519g;

    /* renamed from: h, reason: collision with root package name */
    public n3.t[] f6520h;

    /* renamed from: i, reason: collision with root package name */
    public k3.j f6521i;

    /* renamed from: j, reason: collision with root package name */
    public r3.n f6522j;

    /* renamed from: k, reason: collision with root package name */
    public n3.t[] f6523k;

    /* renamed from: l, reason: collision with root package name */
    public r3.n f6524l;

    /* renamed from: m, reason: collision with root package name */
    public r3.n f6525m;

    /* renamed from: n, reason: collision with root package name */
    public r3.n f6526n;

    /* renamed from: o, reason: collision with root package name */
    public r3.n f6527o;

    /* renamed from: p, reason: collision with root package name */
    public r3.n f6528p;

    /* renamed from: q, reason: collision with root package name */
    public r3.n f6529q;

    /* renamed from: r, reason: collision with root package name */
    public r3.n f6530r;

    public f0(k3.f fVar, k3.j jVar) {
        this.f6513a = jVar == null ? "UNKNOWN TYPE" : jVar.toString();
        this.f6514b = jVar == null ? Object.class : jVar.q();
    }

    public static Double S(BigDecimal bigDecimal) {
        double doubleValue = bigDecimal.doubleValue();
        if (Double.isInfinite(doubleValue)) {
            return null;
        }
        return Double.valueOf(doubleValue);
    }

    @Override // n3.w
    public k3.j A(k3.f fVar) {
        return this.f6521i;
    }

    @Override // n3.w
    public r3.n B() {
        return this.f6515c;
    }

    @Override // n3.w
    public r3.n C() {
        return this.f6519g;
    }

    @Override // n3.w
    public k3.j D(k3.f fVar) {
        return this.f6518f;
    }

    @Override // n3.w
    public n3.t[] E(k3.f fVar) {
        return this.f6517e;
    }

    @Override // n3.w
    public Class F() {
        return this.f6514b;
    }

    public final Object G(r3.n nVar, n3.t[] tVarArr, k3.g gVar, Object obj) {
        if (nVar == null) {
            throw new IllegalStateException("No delegate constructor for " + Q());
        }
        try {
            if (tVarArr == null) {
                return nVar.s(obj);
            }
            int length = tVarArr.length;
            Object[] objArr = new Object[length];
            for (int i10 = 0; i10 < length; i10++) {
                n3.t tVar = tVarArr[i10];
                if (tVar == null) {
                    objArr[i10] = obj;
                } else {
                    objArr[i10] = gVar.E(tVar.q(), tVar, null);
                }
            }
            return nVar.r(objArr);
        } catch (Throwable th) {
            throw R(gVar, th);
        }
    }

    public void H(r3.n nVar, k3.j jVar, n3.t[] tVarArr) {
        this.f6522j = nVar;
        this.f6521i = jVar;
        this.f6523k = tVarArr;
    }

    public void I(r3.n nVar) {
        this.f6529q = nVar;
    }

    public void J(r3.n nVar) {
        this.f6527o = nVar;
    }

    public void K(r3.n nVar) {
        this.f6530r = nVar;
    }

    public void L(r3.n nVar) {
        this.f6528p = nVar;
    }

    public void M(r3.n nVar) {
        this.f6525m = nVar;
    }

    public void N(r3.n nVar) {
        this.f6526n = nVar;
    }

    public void O(r3.n nVar, r3.n nVar2, k3.j jVar, n3.t[] tVarArr, r3.n nVar3, n3.t[] tVarArr2) {
        this.f6515c = nVar;
        this.f6519g = nVar2;
        this.f6518f = jVar;
        this.f6520h = tVarArr;
        this.f6516d = nVar3;
        this.f6517e = tVarArr2;
    }

    public void P(r3.n nVar) {
        this.f6524l = nVar;
    }

    public String Q() {
        return this.f6513a;
    }

    public k3.l R(k3.g gVar, Throwable th) {
        Throwable cause;
        if (((th instanceof ExceptionInInitializerError) || (th instanceof InvocationTargetException)) && (cause = th.getCause()) != null) {
            th = cause;
        }
        return T(gVar, th);
    }

    public k3.l T(k3.g gVar, Throwable th) {
        return th instanceof k3.l ? (k3.l) th : gVar.l0(F(), th);
    }

    @Override // n3.w
    public boolean a() {
        return this.f6529q != null;
    }

    @Override // n3.w
    public boolean b() {
        return this.f6527o != null;
    }

    @Override // n3.w
    public boolean c() {
        return this.f6530r != null;
    }

    @Override // n3.w
    public boolean d() {
        return this.f6528p != null;
    }

    @Override // n3.w
    public boolean e() {
        return this.f6525m != null;
    }

    @Override // n3.w
    public boolean f() {
        return this.f6526n != null;
    }

    @Override // n3.w
    public boolean g() {
        return this.f6516d != null;
    }

    @Override // n3.w
    public boolean h() {
        return this.f6524l != null;
    }

    @Override // n3.w
    public boolean i() {
        return this.f6521i != null;
    }

    @Override // n3.w
    public boolean j() {
        return this.f6515c != null;
    }

    @Override // n3.w
    public boolean k() {
        return this.f6518f != null;
    }

    @Override // n3.w
    public boolean l() {
        return j() || k() || i() || g() || h() || e() || f() || d() || c();
    }

    @Override // n3.w
    public Object n(k3.g gVar, BigDecimal bigDecimal) {
        Double S;
        r3.n nVar = this.f6529q;
        if (nVar != null) {
            try {
                return nVar.s(bigDecimal);
            } catch (Throwable th) {
                return gVar.V(this.f6529q.k(), bigDecimal, R(gVar, th));
            }
        }
        if (this.f6528p == null || (S = S(bigDecimal)) == null) {
            return super.n(gVar, bigDecimal);
        }
        try {
            return this.f6528p.s(S);
        } catch (Throwable th2) {
            return gVar.V(this.f6528p.k(), S, R(gVar, th2));
        }
    }

    @Override // n3.w
    public Object o(k3.g gVar, BigInteger bigInteger) {
        r3.n nVar = this.f6527o;
        if (nVar == null) {
            return super.o(gVar, bigInteger);
        }
        try {
            return nVar.s(bigInteger);
        } catch (Throwable th) {
            return gVar.V(this.f6527o.k(), bigInteger, R(gVar, th));
        }
    }

    @Override // n3.w
    public Object p(k3.g gVar, boolean z10) {
        if (this.f6530r == null) {
            return super.p(gVar, z10);
        }
        Boolean valueOf = Boolean.valueOf(z10);
        try {
            return this.f6530r.s(valueOf);
        } catch (Throwable th) {
            return gVar.V(this.f6530r.k(), valueOf, R(gVar, th));
        }
    }

    @Override // n3.w
    public Object q(k3.g gVar, double d10) {
        if (this.f6528p != null) {
            Double valueOf = Double.valueOf(d10);
            try {
                return this.f6528p.s(valueOf);
            } catch (Throwable th) {
                return gVar.V(this.f6528p.k(), valueOf, R(gVar, th));
            }
        }
        if (this.f6529q == null) {
            return super.q(gVar, d10);
        }
        BigDecimal valueOf2 = BigDecimal.valueOf(d10);
        try {
            return this.f6529q.s(valueOf2);
        } catch (Throwable th2) {
            return gVar.V(this.f6529q.k(), valueOf2, R(gVar, th2));
        }
    }

    @Override // n3.w
    public Object r(k3.g gVar, int i10) {
        if (this.f6525m != null) {
            Integer valueOf = Integer.valueOf(i10);
            try {
                return this.f6525m.s(valueOf);
            } catch (Throwable th) {
                return gVar.V(this.f6525m.k(), valueOf, R(gVar, th));
            }
        }
        if (this.f6526n != null) {
            Long valueOf2 = Long.valueOf(i10);
            try {
                return this.f6526n.s(valueOf2);
            } catch (Throwable th2) {
                return gVar.V(this.f6526n.k(), valueOf2, R(gVar, th2));
            }
        }
        if (this.f6527o == null) {
            return super.r(gVar, i10);
        }
        BigInteger valueOf3 = BigInteger.valueOf(i10);
        try {
            return this.f6527o.s(valueOf3);
        } catch (Throwable th3) {
            return gVar.V(this.f6527o.k(), valueOf3, R(gVar, th3));
        }
    }

    @Override // n3.w
    public Object s(k3.g gVar, long j10) {
        if (this.f6526n != null) {
            Long valueOf = Long.valueOf(j10);
            try {
                return this.f6526n.s(valueOf);
            } catch (Throwable th) {
                return gVar.V(this.f6526n.k(), valueOf, R(gVar, th));
            }
        }
        if (this.f6527o == null) {
            return super.s(gVar, j10);
        }
        BigInteger valueOf2 = BigInteger.valueOf(j10);
        try {
            return this.f6527o.s(valueOf2);
        } catch (Throwable th2) {
            return gVar.V(this.f6527o.k(), valueOf2, R(gVar, th2));
        }
    }

    @Override // n3.w
    public Object t(k3.g gVar, Object[] objArr) {
        r3.n nVar = this.f6516d;
        if (nVar == null) {
            return super.t(gVar, objArr);
        }
        try {
            return nVar.r(objArr);
        } catch (Exception e10) {
            return gVar.V(this.f6514b, objArr, R(gVar, e10));
        }
    }

    @Override // n3.w
    public Object v(k3.g gVar, String str) {
        r3.n nVar = this.f6524l;
        if (nVar == null) {
            return super.v(gVar, str);
        }
        try {
            return nVar.s(str);
        } catch (Throwable th) {
            return gVar.V(this.f6524l.k(), str, R(gVar, th));
        }
    }

    @Override // n3.w
    public Object w(k3.g gVar, Object obj) {
        r3.n nVar = this.f6522j;
        return (nVar != null || this.f6519g == null) ? G(nVar, this.f6523k, gVar, obj) : y(gVar, obj);
    }

    @Override // n3.w
    public Object x(k3.g gVar) {
        r3.n nVar = this.f6515c;
        if (nVar == null) {
            return super.x(gVar);
        }
        try {
            return nVar.q();
        } catch (Exception e10) {
            return gVar.V(this.f6514b, null, R(gVar, e10));
        }
    }

    @Override // n3.w
    public Object y(k3.g gVar, Object obj) {
        r3.n nVar;
        r3.n nVar2 = this.f6519g;
        return (nVar2 != null || (nVar = this.f6522j) == null) ? G(nVar2, this.f6520h, gVar, obj) : G(nVar, this.f6523k, gVar, obj);
    }

    @Override // n3.w
    public r3.n z() {
        return this.f6522j;
    }
}
