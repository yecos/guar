package com.fasterxml.jackson.databind.deser.std;

import java.util.AbstractMap;
import java.util.Map;

/* loaded from: classes.dex */
public class t extends i implements n3.i {

    /* renamed from: e, reason: collision with root package name */
    public final k3.p f6610e;

    /* renamed from: f, reason: collision with root package name */
    public final k3.k f6611f;

    /* renamed from: g, reason: collision with root package name */
    public final w3.e f6612g;

    public t(k3.j jVar, k3.p pVar, k3.k kVar, w3.e eVar) {
        super(jVar);
        if (jVar.g() == 2) {
            this.f6610e = pVar;
            this.f6611f = kVar;
            this.f6612g = eVar;
        } else {
            throw new IllegalArgumentException("Missing generic type information for " + jVar);
        }
    }

    @Override // com.fasterxml.jackson.databind.deser.std.i
    public k3.k a() {
        return this.f6611f;
    }

    @Override // k3.k
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public Map.Entry deserialize(c3.k kVar, k3.g gVar) {
        Object obj;
        c3.n n10 = kVar.n();
        if (n10 == c3.n.START_OBJECT) {
            n10 = kVar.s0();
        } else if (n10 != c3.n.FIELD_NAME && n10 != c3.n.END_OBJECT) {
            return n10 == c3.n.START_ARRAY ? (Map.Entry) _deserializeFromArray(kVar, gVar) : (Map.Entry) gVar.c0(getValueType(gVar), kVar);
        }
        if (n10 != c3.n.FIELD_NAME) {
            return n10 == c3.n.END_OBJECT ? (Map.Entry) gVar.z0(this, "Cannot deserialize a Map.Entry out of empty JSON Object", new Object[0]) : (Map.Entry) gVar.a0(handledType(), kVar);
        }
        k3.p pVar = this.f6610e;
        k3.k kVar2 = this.f6611f;
        w3.e eVar = this.f6612g;
        String m10 = kVar.m();
        Object a10 = pVar.a(m10, gVar);
        try {
            obj = kVar.s0() == c3.n.VALUE_NULL ? kVar2.getNullValue(gVar) : eVar == null ? kVar2.deserialize(kVar, gVar) : kVar2.deserializeWithType(kVar, gVar, eVar);
        } catch (Exception e10) {
            b(gVar, e10, Map.Entry.class, m10);
            obj = null;
        }
        c3.n s02 = kVar.s0();
        if (s02 == c3.n.END_OBJECT) {
            return new AbstractMap.SimpleEntry(a10, obj);
        }
        if (s02 == c3.n.FIELD_NAME) {
            gVar.z0(this, "Problem binding JSON into Map.Entry: more than one entry in JSON (second field: '%s')", kVar.m());
        } else {
            gVar.z0(this, "Problem binding JSON into Map.Entry: unexpected content after JSON Object entry: " + s02, new Object[0]);
        }
        return null;
    }

    @Override // n3.i
    public k3.k createContextual(k3.g gVar, k3.d dVar) {
        k3.p pVar = this.f6610e;
        if (pVar == null) {
            pVar = gVar.F(this.f6549a.f(0), dVar);
        }
        k3.k findConvertingContentDeserializer = findConvertingContentDeserializer(gVar, dVar, this.f6611f);
        k3.j f10 = this.f6549a.f(1);
        k3.k D = findConvertingContentDeserializer == null ? gVar.D(f10, dVar) : gVar.Z(findConvertingContentDeserializer, dVar, f10);
        w3.e eVar = this.f6612g;
        if (eVar != null) {
            eVar = eVar.g(dVar);
        }
        return e(pVar, eVar, D);
    }

    @Override // k3.k
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public Map.Entry deserialize(c3.k kVar, k3.g gVar, Map.Entry entry) {
        throw new IllegalStateException("Cannot update Map.Entry values");
    }

    @Override // com.fasterxml.jackson.databind.deser.std.b0, k3.k
    public Object deserializeWithType(c3.k kVar, k3.g gVar, w3.e eVar) {
        return eVar.e(kVar, gVar);
    }

    public t e(k3.p pVar, w3.e eVar, k3.k kVar) {
        return (this.f6610e == pVar && this.f6611f == kVar && this.f6612g == eVar) ? this : new t(this, pVar, kVar, eVar);
    }

    @Override // k3.k
    public c4.f logicalType() {
        return c4.f.Map;
    }

    public t(t tVar, k3.p pVar, k3.k kVar, w3.e eVar) {
        super(tVar);
        this.f6610e = pVar;
        this.f6611f = kVar;
        this.f6612g = eVar;
    }
}
