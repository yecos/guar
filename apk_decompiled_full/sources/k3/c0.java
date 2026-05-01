package k3;

import b3.k;
import b3.k0;
import b3.r;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

/* loaded from: classes.dex */
public abstract class c0 extends e {

    /* renamed from: m, reason: collision with root package name */
    public static final o f14848m = new b4.c("Null key for a Map not allowed in JSON (use a converting NullKeySerializer?)");

    /* renamed from: n, reason: collision with root package name */
    public static final o f14849n = new b4.p();

    /* renamed from: a, reason: collision with root package name */
    public final a0 f14850a;

    /* renamed from: b, reason: collision with root package name */
    public final Class f14851b;

    /* renamed from: c, reason: collision with root package name */
    public final a4.q f14852c;

    /* renamed from: d, reason: collision with root package name */
    public final a4.p f14853d;

    /* renamed from: e, reason: collision with root package name */
    public transient m3.j f14854e;

    /* renamed from: f, reason: collision with root package name */
    public o f14855f;

    /* renamed from: g, reason: collision with root package name */
    public o f14856g;

    /* renamed from: h, reason: collision with root package name */
    public o f14857h;

    /* renamed from: i, reason: collision with root package name */
    public o f14858i;

    /* renamed from: j, reason: collision with root package name */
    public final b4.l f14859j;

    /* renamed from: k, reason: collision with root package name */
    public DateFormat f14860k;

    /* renamed from: l, reason: collision with root package name */
    public final boolean f14861l;

    public c0() {
        this.f14855f = f14849n;
        this.f14857h = com.fasterxml.jackson.databind.ser.std.u.f6730a;
        this.f14858i = f14848m;
        this.f14850a = null;
        this.f14852c = null;
        this.f14853d = new a4.p();
        this.f14859j = null;
        this.f14851b = null;
        this.f14854e = null;
        this.f14861l = true;
    }

    public j A(j jVar, Class cls) {
        return jVar.y(cls) ? jVar : k().z().G(jVar, cls, true);
    }

    public void B(long j10, c3.h hVar) {
        if (m0(b0.WRITE_DATE_KEYS_AS_TIMESTAMPS)) {
            hVar.Z(String.valueOf(j10));
        } else {
            hVar.Z(v().format(new Date(j10)));
        }
    }

    public void C(Date date, c3.h hVar) {
        if (m0(b0.WRITE_DATE_KEYS_AS_TIMESTAMPS)) {
            hVar.Z(String.valueOf(date.getTime()));
        } else {
            hVar.Z(v().format(date));
        }
    }

    public final void D(Date date, c3.h hVar) {
        if (m0(b0.WRITE_DATES_AS_TIMESTAMPS)) {
            hVar.e0(date.getTime());
        } else {
            hVar.z0(v().format(date));
        }
    }

    public final void E(c3.h hVar) {
        if (this.f14861l) {
            hVar.a0();
        } else {
            this.f14857h.serialize(null, hVar, this);
        }
    }

    public final void F(Object obj, c3.h hVar) {
        if (obj != null) {
            P(obj.getClass(), true, null).serialize(obj, hVar, this);
        } else if (this.f14861l) {
            hVar.a0();
        } else {
            this.f14857h.serialize(null, hVar, this);
        }
    }

    public o G(Class cls, d dVar) {
        o e10 = this.f14859j.e(cls);
        return (e10 == null && (e10 = this.f14853d.i(cls)) == null && (e10 = this.f14853d.j(this.f14850a.e(cls))) == null && (e10 = s(cls)) == null) ? g0(cls) : i0(e10, dVar);
    }

    public o H(j jVar, d dVar) {
        o f10 = this.f14859j.f(jVar);
        return (f10 == null && (f10 = this.f14853d.j(jVar)) == null && (f10 = t(jVar)) == null) ? g0(jVar.q()) : i0(f10, dVar);
    }

    public o I(Class cls, d dVar) {
        return J(this.f14850a.e(cls), dVar);
    }

    public o J(j jVar, d dVar) {
        return w(this.f14852c.a(this, jVar, this.f14856g), dVar);
    }

    public o K(j jVar, d dVar) {
        return this.f14858i;
    }

    public o L(d dVar) {
        return this.f14857h;
    }

    public abstract b4.t M(Object obj, k0 k0Var);

    public o N(Class cls, d dVar) {
        o e10 = this.f14859j.e(cls);
        return (e10 == null && (e10 = this.f14853d.i(cls)) == null && (e10 = this.f14853d.j(this.f14850a.e(cls))) == null && (e10 = s(cls)) == null) ? g0(cls) : h0(e10, dVar);
    }

    public o O(j jVar, d dVar) {
        o f10 = this.f14859j.f(jVar);
        return (f10 == null && (f10 = this.f14853d.j(jVar)) == null && (f10 = t(jVar)) == null) ? g0(jVar.q()) : h0(f10, dVar);
    }

    public o P(Class cls, boolean z10, d dVar) {
        o c10 = this.f14859j.c(cls);
        if (c10 != null) {
            return c10;
        }
        o g10 = this.f14853d.g(cls);
        if (g10 != null) {
            return g10;
        }
        o S = S(cls, dVar);
        a4.q qVar = this.f14852c;
        a0 a0Var = this.f14850a;
        w3.h c11 = qVar.c(a0Var, a0Var.e(cls));
        if (c11 != null) {
            S = new b4.o(c11.a(dVar), S);
        }
        if (z10) {
            this.f14853d.d(cls, S);
        }
        return S;
    }

    public o Q(j jVar, boolean z10, d dVar) {
        o d10 = this.f14859j.d(jVar);
        if (d10 != null) {
            return d10;
        }
        o h10 = this.f14853d.h(jVar);
        if (h10 != null) {
            return h10;
        }
        o U = U(jVar, dVar);
        w3.h c10 = this.f14852c.c(this.f14850a, jVar);
        if (c10 != null) {
            U = new b4.o(c10.a(dVar), U);
        }
        if (z10) {
            this.f14853d.e(jVar, U);
        }
        return U;
    }

    public o R(Class cls) {
        o e10 = this.f14859j.e(cls);
        if (e10 != null) {
            return e10;
        }
        o i10 = this.f14853d.i(cls);
        if (i10 != null) {
            return i10;
        }
        o j10 = this.f14853d.j(this.f14850a.e(cls));
        if (j10 != null) {
            return j10;
        }
        o s10 = s(cls);
        return s10 == null ? g0(cls) : s10;
    }

    public o S(Class cls, d dVar) {
        o e10 = this.f14859j.e(cls);
        return (e10 == null && (e10 = this.f14853d.i(cls)) == null && (e10 = this.f14853d.j(this.f14850a.e(cls))) == null && (e10 = s(cls)) == null) ? g0(cls) : i0(e10, dVar);
    }

    public o T(j jVar) {
        o f10 = this.f14859j.f(jVar);
        if (f10 != null) {
            return f10;
        }
        o j10 = this.f14853d.j(jVar);
        if (j10 != null) {
            return j10;
        }
        o t10 = t(jVar);
        return t10 == null ? g0(jVar.q()) : t10;
    }

    public o U(j jVar, d dVar) {
        if (jVar == null) {
            r0("Null passed for `valueType` of `findValueSerializer()`", new Object[0]);
        }
        o f10 = this.f14859j.f(jVar);
        return (f10 == null && (f10 = this.f14853d.j(jVar)) == null && (f10 = t(jVar)) == null) ? g0(jVar.q()) : i0(f10, dVar);
    }

    public final Class V() {
        return this.f14851b;
    }

    public final b W() {
        return this.f14850a.g();
    }

    public Object X(Object obj) {
        return this.f14854e.a(obj);
    }

    @Override // k3.e
    /* renamed from: Y, reason: merged with bridge method [inline-methods] */
    public final a0 k() {
        return this.f14850a;
    }

    public o Z() {
        return this.f14857h;
    }

    public final k.d a0(Class cls) {
        return this.f14850a.o(cls);
    }

    public final r.b b0(Class cls) {
        return this.f14850a.p(cls);
    }

    public final a4.k c0() {
        this.f14850a.Z();
        return null;
    }

    public abstract c3.h d0();

    public Locale e0() {
        return this.f14850a.v();
    }

    public TimeZone f0() {
        return this.f14850a.y();
    }

    public o g0(Class cls) {
        return cls == Object.class ? this.f14855f : new b4.p(cls);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public o h0(o oVar, d dVar) {
        return (oVar == 0 || !(oVar instanceof a4.i)) ? oVar : ((a4.i) oVar).b(this, dVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public o i0(o oVar, d dVar) {
        return (oVar == 0 || !(oVar instanceof a4.i)) ? oVar : ((a4.i) oVar).b(this, dVar);
    }

    public abstract Object j0(r3.s sVar, Class cls);

    public abstract boolean k0(Object obj);

    @Override // k3.e
    public final c4.o l() {
        return this.f14850a.z();
    }

    public final boolean l0(q qVar) {
        return this.f14850a.D(qVar);
    }

    @Override // k3.e
    public l m(j jVar, String str, String str2) {
        return p3.e.v(null, a(String.format("Could not resolve type id '%s' as a subtype of %s", str, d4.h.G(jVar)), str2), jVar, str);
    }

    public final boolean m0(b0 b0Var) {
        return this.f14850a.c0(b0Var);
    }

    public l n0(String str, Object... objArr) {
        return l.g(d0(), b(str, objArr));
    }

    public Object o0(Class cls, String str, Throwable th) {
        p3.b t10 = p3.b.t(d0(), str, i(cls));
        t10.initCause(th);
        throw t10;
    }

    public Object p0(c cVar, r3.s sVar, String str, Object... objArr) {
        throw p3.b.s(d0(), String.format("Invalid definition for property %s (of type %s): %s", sVar != null ? c(sVar.getName()) : "N/A", cVar != null ? d4.h.X(cVar.s()) : "N/A", b(str, objArr)), cVar, sVar);
    }

    @Override // k3.e
    public Object q(j jVar, String str) {
        throw p3.b.t(d0(), str, jVar);
    }

    public Object q0(c cVar, String str, Object... objArr) {
        throw p3.b.s(d0(), String.format("Invalid type definition for type %s: %s", cVar != null ? d4.h.X(cVar.s()) : "N/A", b(str, objArr)), cVar, null);
    }

    public void r0(String str, Object... objArr) {
        throw n0(str, objArr);
    }

    public o s(Class cls) {
        o oVar;
        j e10 = this.f14850a.e(cls);
        try {
            oVar = u(e10);
        } catch (IllegalArgumentException e11) {
            s0(e11, d4.h.o(e11), new Object[0]);
            oVar = null;
        }
        if (oVar != null) {
            this.f14853d.b(cls, e10, oVar, this);
        }
        return oVar;
    }

    public void s0(Throwable th, String str, Object... objArr) {
        throw l.h(d0(), b(str, objArr), th);
    }

    public o t(j jVar) {
        o oVar;
        try {
            oVar = u(jVar);
        } catch (IllegalArgumentException e10) {
            s0(e10, d4.h.o(e10), new Object[0]);
            oVar = null;
        }
        if (oVar != null) {
            this.f14853d.c(jVar, oVar, this);
        }
        return oVar;
    }

    public abstract o t0(r3.b bVar, Object obj);

    public o u(j jVar) {
        return this.f14852c.b(this, jVar);
    }

    public c0 u0(Object obj, Object obj2) {
        this.f14854e = this.f14854e.c(obj, obj2);
        return this;
    }

    public final DateFormat v() {
        DateFormat dateFormat = this.f14860k;
        if (dateFormat != null) {
            return dateFormat;
        }
        DateFormat dateFormat2 = (DateFormat) this.f14850a.k().clone();
        this.f14860k = dateFormat2;
        return dateFormat2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public o w(o oVar, d dVar) {
        if (oVar instanceof a4.o) {
            ((a4.o) oVar).a(this);
        }
        return i0(oVar, dVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public o x(o oVar) {
        if (oVar instanceof a4.o) {
            ((a4.o) oVar).a(this);
        }
        return oVar;
    }

    public void y(Object obj, j jVar) {
        if (jVar.K() && d4.h.o0(jVar.q()).isAssignableFrom(obj.getClass())) {
            return;
        }
        q(jVar, String.format("Incompatible types: declared root type (%s) vs %s", jVar, d4.h.h(obj)));
    }

    public final boolean z() {
        return this.f14850a.b();
    }

    public c0(c0 c0Var, a0 a0Var, a4.q qVar) {
        this.f14855f = f14849n;
        this.f14857h = com.fasterxml.jackson.databind.ser.std.u.f6730a;
        o oVar = f14848m;
        this.f14858i = oVar;
        this.f14852c = qVar;
        this.f14850a = a0Var;
        a4.p pVar = c0Var.f14853d;
        this.f14853d = pVar;
        this.f14855f = c0Var.f14855f;
        this.f14856g = c0Var.f14856g;
        o oVar2 = c0Var.f14857h;
        this.f14857h = oVar2;
        this.f14858i = c0Var.f14858i;
        this.f14861l = oVar2 == oVar;
        this.f14851b = a0Var.K();
        this.f14854e = a0Var.L();
        this.f14859j = pVar.f();
    }
}
