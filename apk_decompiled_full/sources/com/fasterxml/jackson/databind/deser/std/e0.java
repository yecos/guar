package com.fasterxml.jackson.databind.deser.std;

/* loaded from: classes.dex */
public abstract class e0 extends b0 {
    public e0(Class cls) {
        super(cls);
    }

    @Override // k3.k
    public Object deserialize(c3.k kVar, k3.g gVar, Object obj) {
        gVar.U(this);
        return deserialize(kVar, gVar);
    }

    @Override // com.fasterxml.jackson.databind.deser.std.b0, k3.k
    public Object deserializeWithType(c3.k kVar, k3.g gVar, w3.e eVar) {
        return eVar.f(kVar, gVar);
    }

    @Override // k3.k
    public d4.a getEmptyAccessPattern() {
        return d4.a.CONSTANT;
    }

    @Override // k3.k
    public d4.a getNullAccessPattern() {
        return d4.a.ALWAYS_NULL;
    }

    @Override // k3.k
    public c4.f logicalType() {
        return c4.f.OtherScalar;
    }

    @Override // k3.k
    public Boolean supportsUpdate(k3.f fVar) {
        return Boolean.FALSE;
    }

    public e0(e0 e0Var) {
        super(e0Var);
    }
}
