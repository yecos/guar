package com.fasterxml.jackson.databind.deser.std;

/* loaded from: classes.dex */
public class k0 extends e0 {
    public k0() {
        super(d4.y.class);
    }

    public d4.y a(c3.k kVar) {
        return new d4.y(kVar);
    }

    @Override // k3.k
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public d4.y deserialize(c3.k kVar, k3.g gVar) {
        return a(kVar).W0(kVar, gVar);
    }

    @Override // com.fasterxml.jackson.databind.deser.std.e0, k3.k
    public c4.f logicalType() {
        return c4.f.Untyped;
    }
}
