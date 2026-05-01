package com.fasterxml.jackson.databind.deser.std;

/* loaded from: classes.dex */
public class u extends b0 {

    /* renamed from: a, reason: collision with root package name */
    public static final u f6613a = new u();

    public u() {
        super(Object.class);
    }

    @Override // k3.k
    public Object deserialize(c3.k kVar, k3.g gVar) {
        if (!kVar.j0(c3.n.FIELD_NAME)) {
            kVar.D0();
            return null;
        }
        while (true) {
            c3.n s02 = kVar.s0();
            if (s02 == null || s02 == c3.n.END_OBJECT) {
                return null;
            }
            kVar.D0();
        }
    }

    @Override // com.fasterxml.jackson.databind.deser.std.b0, k3.k
    public Object deserializeWithType(c3.k kVar, k3.g gVar, w3.e eVar) {
        int q10 = kVar.q();
        if (q10 == 1 || q10 == 3 || q10 == 5) {
            return eVar.c(kVar, gVar);
        }
        return null;
    }

    @Override // k3.k
    public Boolean supportsUpdate(k3.f fVar) {
        return Boolean.FALSE;
    }
}
