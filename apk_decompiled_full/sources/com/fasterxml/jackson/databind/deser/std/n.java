package com.fasterxml.jackson.databind.deser.std;

import java.io.IOException;

/* loaded from: classes.dex */
public class n extends b0 implements n3.i {

    /* renamed from: a, reason: collision with root package name */
    public final k3.j f6581a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f6582b;

    /* renamed from: c, reason: collision with root package name */
    public final r3.j f6583c;

    /* renamed from: d, reason: collision with root package name */
    public final k3.k f6584d;

    /* renamed from: e, reason: collision with root package name */
    public final n3.w f6585e;

    /* renamed from: f, reason: collision with root package name */
    public final n3.t[] f6586f;

    /* renamed from: g, reason: collision with root package name */
    public transient o3.v f6587g;

    public n(Class cls, r3.j jVar, k3.j jVar2, n3.w wVar, n3.t[] tVarArr) {
        super(cls);
        this.f6583c = jVar;
        this.f6582b = true;
        this.f6581a = jVar2.y(String.class) ? null : jVar2;
        this.f6584d = null;
        this.f6585e = wVar;
        this.f6586f = tVarArr;
    }

    public final Object a(c3.k kVar, k3.g gVar, n3.t tVar) {
        try {
            return tVar.k(kVar, gVar);
        } catch (Exception e10) {
            return d(e10, handledType(), tVar.getName(), gVar);
        }
    }

    public Object b(c3.k kVar, k3.g gVar, o3.v vVar) {
        o3.y e10 = vVar.e(kVar, gVar, null);
        c3.n n10 = kVar.n();
        while (n10 == c3.n.FIELD_NAME) {
            String m10 = kVar.m();
            kVar.s0();
            n3.t d10 = vVar.d(m10);
            if (!e10.i(m10) || d10 != null) {
                if (d10 != null) {
                    e10.b(d10, a(kVar, gVar, d10));
                } else {
                    kVar.D0();
                }
            }
            n10 = kVar.s0();
        }
        return vVar.a(gVar, e10);
    }

    public final Throwable c(Throwable th, k3.g gVar) {
        Throwable F = d4.h.F(th);
        d4.h.h0(F);
        boolean z10 = gVar == null || gVar.n0(k3.h.WRAP_EXCEPTIONS);
        if (F instanceof IOException) {
            if (!z10 || !(F instanceof c3.l)) {
                throw ((IOException) F);
            }
        } else if (!z10) {
            d4.h.j0(F);
        }
        return F;
    }

    @Override // n3.i
    public k3.k createContextual(k3.g gVar, k3.d dVar) {
        k3.j jVar;
        return (this.f6584d == null && (jVar = this.f6581a) != null && this.f6586f == null) ? new n(this, gVar.D(jVar, dVar)) : this;
    }

    public Object d(Throwable th, Object obj, String str, k3.g gVar) {
        throw k3.l.q(c(th, gVar), obj, str);
    }

    @Override // k3.k
    public Object deserialize(c3.k kVar, k3.g gVar) {
        Object Y;
        k3.k kVar2 = this.f6584d;
        if (kVar2 != null) {
            Y = kVar2.deserialize(kVar, gVar);
        } else {
            if (!this.f6582b) {
                kVar.D0();
                try {
                    return this.f6583c.q();
                } catch (Exception e10) {
                    return gVar.V(this._valueClass, null, d4.h.k0(e10));
                }
            }
            c3.n n10 = kVar.n();
            if (this.f6586f != null) {
                if (!kVar.o0()) {
                    k3.j valueType = getValueType(gVar);
                    gVar.y0(valueType, "Input mismatch reading Enum %s: properties-based `@JsonCreator` (%s) expects JSON Object (JsonToken.START_OBJECT), got JsonToken.%s", d4.h.G(valueType), this.f6583c, kVar.n());
                }
                if (this.f6587g == null) {
                    this.f6587g = o3.v.c(gVar, this.f6585e, this.f6586f, gVar.o0(k3.q.ACCEPT_CASE_INSENSITIVE_PROPERTIES));
                }
                kVar.s0();
                return b(kVar, gVar, this.f6587g);
            }
            Y = (n10 == c3.n.VALUE_STRING || n10 == c3.n.FIELD_NAME) ? kVar.Y() : n10 == c3.n.VALUE_NUMBER_INT ? kVar.S() : kVar.g0();
        }
        try {
            return this.f6583c.z(this._valueClass, Y);
        } catch (Exception e11) {
            Throwable k02 = d4.h.k0(e11);
            if (gVar.n0(k3.h.READ_UNKNOWN_ENUM_VALUES_AS_NULL) && (k02 instanceof IllegalArgumentException)) {
                return null;
            }
            return gVar.V(this._valueClass, Y, k02);
        }
    }

    @Override // com.fasterxml.jackson.databind.deser.std.b0, k3.k
    public Object deserializeWithType(c3.k kVar, k3.g gVar, w3.e eVar) {
        return this.f6584d == null ? deserialize(kVar, gVar) : eVar.c(kVar, gVar);
    }

    @Override // com.fasterxml.jackson.databind.deser.std.b0
    public n3.w getValueInstantiator() {
        return this.f6585e;
    }

    @Override // k3.k
    public boolean isCachable() {
        return true;
    }

    @Override // k3.k
    public c4.f logicalType() {
        return c4.f.Enum;
    }

    @Override // k3.k
    public Boolean supportsUpdate(k3.f fVar) {
        return Boolean.FALSE;
    }

    public n(Class cls, r3.j jVar) {
        super(cls);
        this.f6583c = jVar;
        this.f6582b = false;
        this.f6581a = null;
        this.f6584d = null;
        this.f6585e = null;
        this.f6586f = null;
    }

    public n(n nVar, k3.k kVar) {
        super(nVar._valueClass);
        this.f6581a = nVar.f6581a;
        this.f6583c = nVar.f6583c;
        this.f6582b = nVar.f6582b;
        this.f6585e = nVar.f6585e;
        this.f6586f = nVar.f6586f;
        this.f6584d = kVar;
    }
}
