package com.fasterxml.jackson.databind.deser.std;

/* loaded from: classes.dex */
public class i0 extends e0 {

    /* renamed from: a, reason: collision with root package name */
    public static final i0 f6553a = new i0();

    public i0() {
        super(String.class);
    }

    @Override // k3.k
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public String deserialize(c3.k kVar, k3.g gVar) {
        String g02;
        if (kVar.j0(c3.n.VALUE_STRING)) {
            return kVar.Y();
        }
        c3.n n10 = kVar.n();
        if (n10 == c3.n.START_ARRAY) {
            return (String) _deserializeFromArray(kVar, gVar);
        }
        if (n10 != c3.n.VALUE_EMBEDDED_OBJECT) {
            return n10 == c3.n.START_OBJECT ? gVar.z(kVar, this, this._valueClass) : (!n10.e() || (g02 = kVar.g0()) == null) ? (String) gVar.a0(this._valueClass, kVar) : g02;
        }
        Object N = kVar.N();
        if (N == null) {
            return null;
        }
        return N instanceof byte[] ? gVar.M().i((byte[]) N, false) : N.toString();
    }

    @Override // com.fasterxml.jackson.databind.deser.std.e0, com.fasterxml.jackson.databind.deser.std.b0, k3.k
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public String deserializeWithType(c3.k kVar, k3.g gVar, w3.e eVar) {
        return deserialize(kVar, gVar);
    }

    @Override // k3.k
    public Object getEmptyValue(k3.g gVar) {
        return "";
    }

    @Override // k3.k
    public boolean isCachable() {
        return true;
    }

    @Override // com.fasterxml.jackson.databind.deser.std.e0, k3.k
    public c4.f logicalType() {
        return c4.f.Textual;
    }
}
