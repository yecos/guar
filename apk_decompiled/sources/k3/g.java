package k3;

import b3.k;
import b3.k0;
import b3.o0;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

/* loaded from: classes.dex */
public abstract class g extends e implements Serializable {

    /* renamed from: a, reason: collision with root package name */
    public final n3.m f14879a;

    /* renamed from: b, reason: collision with root package name */
    public final n3.n f14880b;

    /* renamed from: c, reason: collision with root package name */
    public final f f14881c;

    /* renamed from: d, reason: collision with root package name */
    public final int f14882d;

    /* renamed from: e, reason: collision with root package name */
    public final j3.i f14883e;

    /* renamed from: f, reason: collision with root package name */
    public final Class f14884f;

    /* renamed from: g, reason: collision with root package name */
    public transient c3.k f14885g;

    /* renamed from: h, reason: collision with root package name */
    public transient d4.c f14886h;

    /* renamed from: i, reason: collision with root package name */
    public transient d4.s f14887i;

    /* renamed from: j, reason: collision with root package name */
    public transient DateFormat f14888j;

    /* renamed from: k, reason: collision with root package name */
    public transient m3.j f14889k;

    /* renamed from: l, reason: collision with root package name */
    public d4.o f14890l;

    public static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f14891a;

        static {
            int[] iArr = new int[c3.n.values().length];
            f14891a = iArr;
            try {
                iArr[c3.n.START_OBJECT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f14891a[c3.n.END_OBJECT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f14891a[c3.n.FIELD_NAME.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f14891a[c3.n.START_ARRAY.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f14891a[c3.n.END_ARRAY.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f14891a[c3.n.VALUE_FALSE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f14891a[c3.n.VALUE_TRUE.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f14891a[c3.n.VALUE_EMBEDDED_OBJECT.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f14891a[c3.n.VALUE_NUMBER_FLOAT.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f14891a[c3.n.VALUE_NUMBER_INT.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f14891a[c3.n.VALUE_STRING.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f14891a[c3.n.VALUE_NULL.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                f14891a[c3.n.NOT_AVAILABLE.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
        }
    }

    public g(n3.n nVar, n3.m mVar) {
        if (nVar == null) {
            throw new NullPointerException("Cannot pass null DeserializerFactory");
        }
        this.f14880b = nVar;
        this.f14879a = mVar == null ? new n3.m() : mVar;
        this.f14882d = 0;
        this.f14883e = null;
        this.f14881c = null;
        this.f14884f = null;
        this.f14889k = null;
    }

    public Class A(String str) {
        return l().J(str);
    }

    public Object A0(Class cls, String str, String str2, Object... objArr) {
        p3.f s10 = p3.f.s(S(), cls, b(str2, objArr));
        if (str == null) {
            throw s10;
        }
        s10.n(cls, str);
        throw s10;
    }

    public m3.b B(c4.f fVar, Class cls, m3.e eVar) {
        return this.f14881c.X(fVar, cls, eVar);
    }

    public Object B0(j jVar, String str, String str2, Object... objArr) {
        return A0(jVar.q(), str, str2, objArr);
    }

    public m3.b C(c4.f fVar, Class cls, m3.b bVar) {
        return this.f14881c.Y(fVar, cls, bVar);
    }

    public Object C0(Class cls, c3.k kVar, c3.n nVar) {
        throw p3.f.s(kVar, cls, String.format("Trailing token (of type %s) found after value (bound as %s): not allowed as per `DeserializationFeature.FAIL_ON_TRAILING_TOKENS`", nVar, d4.h.X(cls)));
    }

    public final k D(j jVar, d dVar) {
        k n10 = this.f14879a.n(this, this.f14880b, jVar);
        return n10 != null ? Z(n10, dVar, jVar) : n10;
    }

    public Object D0(o3.s sVar, Object obj) {
        return x0(sVar.f17566e, String.format("No Object Id found for an instance of %s, to assign to property '%s'", d4.h.h(obj), sVar.f17563b), new Object[0]);
    }

    public final Object E(Object obj, d dVar, Object obj2) {
        p(d4.h.i(obj), String.format("No 'injectableValues' configured, cannot inject value with id [%s]", obj));
        throw null;
    }

    public void E0(Class cls, c3.n nVar, String str, Object... objArr) {
        throw M0(S(), cls, nVar, b(str, objArr));
    }

    public final p F(j jVar, d dVar) {
        return this.f14879a.m(this, this.f14880b, jVar);
    }

    public void F0(j jVar, c3.n nVar, String str, Object... objArr) {
        throw N0(S(), jVar, nVar, b(str, objArr));
    }

    public final k G(j jVar) {
        return this.f14879a.n(this, this.f14880b, jVar);
    }

    public void G0(k kVar, c3.n nVar, String str, Object... objArr) {
        throw M0(S(), kVar.handledType(), nVar, b(str, objArr));
    }

    public abstract o3.z H(Object obj, k0 k0Var, o0 o0Var);

    public final void H0(d4.s sVar) {
        if (this.f14887i == null || sVar.h() >= this.f14887i.h()) {
            this.f14887i = sVar;
        }
    }

    public final k I(j jVar) {
        k n10 = this.f14879a.n(this, this.f14880b, jVar);
        if (n10 == null) {
            return null;
        }
        k Z = Z(n10, null, jVar);
        w3.e l10 = this.f14880b.l(this.f14881c, jVar);
        return l10 != null ? new o3.b0(l10.g(null), Z) : Z;
    }

    public l I0(Class cls, String str, String str2) {
        return p3.c.v(this.f14885g, String.format("Cannot deserialize Map key of type %s from String %s: %s", d4.h.X(cls), c(str), str2), str, cls);
    }

    public final Class J() {
        return this.f14884f;
    }

    public l J0(Object obj, Class cls) {
        return p3.c.v(this.f14885g, String.format("Cannot deserialize value of type %s from native value (`JsonToken.VALUE_EMBEDDED_OBJECT`) of type %s: incompatible types", d4.h.X(cls), d4.h.h(obj)), obj, cls);
    }

    public final b K() {
        return this.f14881c.g();
    }

    public l K0(Number number, Class cls, String str) {
        return p3.c.v(this.f14885g, String.format("Cannot deserialize value of type %s from number %s: %s", d4.h.X(cls), String.valueOf(number), str), number, cls);
    }

    public final d4.c L() {
        if (this.f14886h == null) {
            this.f14886h = new d4.c();
        }
        return this.f14886h;
    }

    public l L0(String str, Class cls, String str2) {
        return p3.c.v(this.f14885g, String.format("Cannot deserialize value of type %s from String %s: %s", d4.h.X(cls), c(str), str2), str, cls);
    }

    public final c3.a M() {
        return this.f14881c.h();
    }

    public l M0(c3.k kVar, Class cls, c3.n nVar, String str) {
        return p3.f.s(kVar, cls, a(String.format("Unexpected token (%s), expected %s", kVar.n(), nVar), str));
    }

    @Override // k3.e
    /* renamed from: N, reason: merged with bridge method [inline-methods] */
    public f k() {
        return this.f14881c;
    }

    public l N0(c3.k kVar, j jVar, c3.n nVar, String str) {
        return p3.f.t(kVar, jVar, a(String.format("Unexpected token (%s), expected %s", kVar.n(), nVar), str));
    }

    public final k.d O(Class cls) {
        return this.f14881c.o(cls);
    }

    public final int P() {
        return this.f14882d;
    }

    public Locale Q() {
        return this.f14881c.v();
    }

    public final z3.l R() {
        return this.f14881c.c0();
    }

    public final c3.k S() {
        return this.f14885g;
    }

    public TimeZone T() {
        return this.f14881c.y();
    }

    public void U(k kVar) {
        if (o0(q.IGNORE_MERGE_FOR_UNMERGEABLE)) {
            return;
        }
        j x10 = x(kVar.handledType());
        throw p3.b.v(S(), String.format("Invalid configuration: values of type %s cannot be merged", d4.h.G(x10)), x10);
    }

    public Object V(Class cls, Object obj, Throwable th) {
        d4.o d02 = this.f14881c.d0();
        if (d02 != null) {
            androidx.appcompat.app.m.a(d02.c());
            throw null;
        }
        d4.h.i0(th);
        if (!n0(h.WRAP_EXCEPTIONS)) {
            d4.h.j0(th);
        }
        throw l0(cls, th);
    }

    public Object W(Class cls, n3.w wVar, c3.k kVar, String str, Object... objArr) {
        if (kVar == null) {
            S();
        }
        String b10 = b(str, objArr);
        d4.o d02 = this.f14881c.d0();
        if (d02 == null) {
            return wVar == null ? p(cls, String.format("Cannot construct instance of %s: %s", d4.h.X(cls), b10)) : !wVar.l() ? p(cls, String.format("Cannot construct instance of %s (no Creators, like default constructor, exist): %s", d4.h.X(cls), b10)) : w0(cls, String.format("Cannot construct instance of %s (although at least one Creator exists): %s", d4.h.X(cls), b10), new Object[0]);
        }
        androidx.appcompat.app.m.a(d02.c());
        throw null;
    }

    public j X(j jVar, w3.f fVar, String str) {
        d4.o d02 = this.f14881c.d0();
        if (d02 == null) {
            throw r0(jVar, str);
        }
        androidx.appcompat.app.m.a(d02.c());
        throw null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public k Y(k kVar, d dVar, j jVar) {
        boolean z10 = kVar instanceof n3.i;
        k kVar2 = kVar;
        if (z10) {
            this.f14890l = new d4.o(jVar, this.f14890l);
            try {
                k createContextual = ((n3.i) kVar).createContextual(this, dVar);
            } finally {
                this.f14890l = this.f14890l.b();
            }
        }
        return kVar2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public k Z(k kVar, d dVar, j jVar) {
        boolean z10 = kVar instanceof n3.i;
        k kVar2 = kVar;
        if (z10) {
            this.f14890l = new d4.o(jVar, this.f14890l);
            try {
                k createContextual = ((n3.i) kVar).createContextual(this, dVar);
            } finally {
                this.f14890l = this.f14890l.b();
            }
        }
        return kVar2;
    }

    public Object a0(Class cls, c3.k kVar) {
        return d0(x(cls), kVar.n(), kVar, null, new Object[0]);
    }

    public Object b0(Class cls, c3.n nVar, c3.k kVar, String str, Object... objArr) {
        return d0(x(cls), nVar, kVar, str, objArr);
    }

    public Object c0(j jVar, c3.k kVar) {
        return d0(jVar, kVar.n(), kVar, null, new Object[0]);
    }

    public Object d0(j jVar, c3.n nVar, c3.k kVar, String str, Object... objArr) {
        String b10 = b(str, objArr);
        d4.o d02 = this.f14881c.d0();
        if (d02 != null) {
            androidx.appcompat.app.m.a(d02.c());
            throw null;
        }
        if (b10 == null) {
            String G = d4.h.G(jVar);
            b10 = nVar == null ? String.format("Unexpected end-of-input when trying read value of type %s", G) : String.format("Cannot deserialize value of type %s from %s (token `JsonToken.%s`)", G, t(nVar), nVar);
        }
        if (nVar != null && nVar.e()) {
            kVar.Y();
        }
        y0(jVar, b10, new Object[0]);
        return null;
    }

    public boolean e0(c3.k kVar, k kVar2, Object obj, String str) {
        d4.o d02 = this.f14881c.d0();
        if (d02 != null) {
            androidx.appcompat.app.m.a(d02.c());
            throw null;
        }
        if (n0(h.FAIL_ON_UNKNOWN_PROPERTIES)) {
            throw p3.h.v(this.f14885g, obj, str, kVar2 != null ? kVar2.getKnownPropertyNames() : null);
        }
        kVar.D0();
        return true;
    }

    public j f0(j jVar, String str, w3.f fVar, String str2) {
        d4.o d02 = this.f14881c.d0();
        if (d02 != null) {
            androidx.appcompat.app.m.a(d02.c());
            throw null;
        }
        if (n0(h.FAIL_ON_INVALID_SUBTYPE)) {
            throw m(jVar, str, str2);
        }
        return null;
    }

    public Object g0(Class cls, String str, String str2, Object... objArr) {
        String b10 = b(str2, objArr);
        d4.o d02 = this.f14881c.d0();
        if (d02 == null) {
            throw I0(cls, str, b10);
        }
        androidx.appcompat.app.m.a(d02.c());
        throw null;
    }

    public Object h0(j jVar, Object obj, c3.k kVar) {
        d4.o d02 = this.f14881c.d0();
        Class q10 = jVar.q();
        if (d02 == null) {
            throw J0(obj, q10);
        }
        androidx.appcompat.app.m.a(d02.c());
        throw null;
    }

    public Object i0(Class cls, Number number, String str, Object... objArr) {
        String b10 = b(str, objArr);
        d4.o d02 = this.f14881c.d0();
        if (d02 == null) {
            throw K0(number, cls, b10);
        }
        androidx.appcompat.app.m.a(d02.c());
        throw null;
    }

    public Object j0(Class cls, String str, String str2, Object... objArr) {
        String b10 = b(str2, objArr);
        d4.o d02 = this.f14881c.d0();
        if (d02 == null) {
            throw L0(str, cls, b10);
        }
        androidx.appcompat.app.m.a(d02.c());
        throw null;
    }

    public final boolean k0(int i10) {
        return (i10 & this.f14882d) != 0;
    }

    @Override // k3.e
    public final c4.o l() {
        return this.f14881c.z();
    }

    public l l0(Class cls, Throwable th) {
        String o10;
        if (th == null) {
            o10 = "N/A";
        } else {
            o10 = d4.h.o(th);
            if (o10 == null) {
                o10 = d4.h.X(th.getClass());
            }
        }
        return p3.i.s(this.f14885g, String.format("Cannot construct instance of %s, problem: %s", d4.h.X(cls), o10), x(cls), th);
    }

    @Override // k3.e
    public l m(j jVar, String str, String str2) {
        return p3.e.v(this.f14885g, a(String.format("Could not resolve type id '%s' as a subtype of %s", str, d4.h.G(jVar)), str2), jVar, str);
    }

    public final boolean m0(c3.r rVar) {
        return this.f14883e.b(rVar);
    }

    public final boolean n0(h hVar) {
        return (hVar.b() & this.f14882d) != 0;
    }

    public final boolean o0(q qVar) {
        return this.f14881c.D(qVar);
    }

    public abstract p p0(r3.b bVar, Object obj);

    @Override // k3.e
    public Object q(j jVar, String str) {
        throw p3.b.v(this.f14885g, str, jVar);
    }

    public final d4.s q0() {
        d4.s sVar = this.f14887i;
        if (sVar == null) {
            return new d4.s();
        }
        this.f14887i = null;
        return sVar;
    }

    public l r0(j jVar, String str) {
        return p3.e.v(this.f14885g, a(String.format("Could not resolve subtype of %s", jVar), str), jVar, null);
    }

    public DateFormat s() {
        DateFormat dateFormat = this.f14888j;
        if (dateFormat != null) {
            return dateFormat;
        }
        DateFormat dateFormat2 = (DateFormat) this.f14881c.k().clone();
        this.f14888j = dateFormat2;
        return dateFormat2;
    }

    public Date s0(String str) {
        try {
            return s().parse(str);
        } catch (ParseException e10) {
            throw new IllegalArgumentException(String.format("Failed to parse Date value '%s': %s", str, d4.h.o(e10)));
        }
    }

    public String t(c3.n nVar) {
        if (nVar == null) {
            return "<end of input>";
        }
        switch (a.f14891a[nVar.ordinal()]) {
            case 1:
            case 2:
            case 3:
                return "Object value";
            case 4:
            case 5:
                return "Array value";
            case 6:
            case 7:
                return "Boolean value";
            case 8:
                return "Embedded Object";
            case 9:
                return "Floating-point value";
            case 10:
                return "Integer value";
            case 11:
                return "String value";
            case 12:
                return "Null value";
            default:
                return "[Unavailable value]";
        }
    }

    public Object t0(k kVar, Class cls, Object obj, String str, Object... objArr) {
        throw p3.c.v(S(), b(str, objArr), obj, cls);
    }

    public final boolean u() {
        return this.f14881c.b();
    }

    public Object u0(c cVar, r3.s sVar, String str, Object... objArr) {
        throw p3.b.u(this.f14885g, String.format("Invalid definition for property %s (of type %s): %s", d4.h.W(sVar), d4.h.X(cVar.s()), b(str, objArr)), cVar, sVar);
    }

    public Calendar v(Date date) {
        Calendar calendar = Calendar.getInstance(T());
        calendar.setTime(date);
        return calendar;
    }

    public Object v0(c cVar, String str, Object... objArr) {
        throw p3.b.u(this.f14885g, String.format("Invalid type definition for type %s: %s", d4.h.X(cVar.s()), b(str, objArr)), cVar, null);
    }

    public j w(j jVar, Class cls) {
        return jVar.y(cls) ? jVar : k().z().G(jVar, cls, false);
    }

    public Object w0(Class cls, String str, Object... objArr) {
        throw p3.f.s(S(), cls, b(str, objArr));
    }

    public final j x(Class cls) {
        if (cls == null) {
            return null;
        }
        return this.f14881c.e(cls);
    }

    public Object x0(d dVar, String str, Object... objArr) {
        p3.f t10 = p3.f.t(S(), dVar == null ? null : dVar.getType(), b(str, objArr));
        if (dVar == null) {
            throw t10;
        }
        r3.i d10 = dVar.d();
        if (d10 == null) {
            throw t10;
        }
        t10.n(d10.k(), dVar.getName());
        throw t10;
    }

    public abstract k y(r3.b bVar, Object obj);

    public Object y0(j jVar, String str, Object... objArr) {
        throw p3.f.t(S(), jVar, b(str, objArr));
    }

    public String z(c3.k kVar, k kVar2, Class cls) {
        return (String) a0(cls, kVar);
    }

    public Object z0(k kVar, String str, Object... objArr) {
        throw p3.f.s(S(), kVar.handledType(), b(str, objArr));
    }

    public g(g gVar, n3.n nVar) {
        this.f14879a = gVar.f14879a;
        this.f14880b = nVar;
        this.f14881c = gVar.f14881c;
        this.f14882d = gVar.f14882d;
        this.f14883e = gVar.f14883e;
        this.f14884f = gVar.f14884f;
        this.f14885g = gVar.f14885g;
        this.f14889k = gVar.f14889k;
    }

    public g(g gVar, f fVar, c3.k kVar, i iVar) {
        this.f14879a = gVar.f14879a;
        this.f14880b = gVar.f14880b;
        this.f14883e = kVar == null ? null : kVar.W();
        this.f14881c = fVar;
        this.f14882d = fVar.b0();
        this.f14884f = fVar.K();
        this.f14885g = kVar;
        this.f14889k = fVar.L();
    }

    public g(g gVar, f fVar) {
        this.f14879a = gVar.f14879a;
        this.f14880b = gVar.f14880b;
        this.f14883e = null;
        this.f14881c = fVar;
        this.f14882d = fVar.b0();
        this.f14884f = null;
        this.f14885g = null;
        this.f14889k = null;
    }
}
