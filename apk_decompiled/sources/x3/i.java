package x3;

import b3.e0;
import d4.y;

/* loaded from: classes.dex */
public class i extends q {
    public i(k3.j jVar, w3.f fVar, String str, boolean z10, k3.j jVar2) {
        super(jVar, fVar, str, z10, jVar2);
    }

    @Override // w3.e
    public Object c(c3.k kVar, k3.g gVar) {
        return t(kVar, gVar);
    }

    @Override // w3.e
    public Object d(c3.k kVar, k3.g gVar) {
        return t(kVar, gVar);
    }

    @Override // w3.e
    public Object e(c3.k kVar, k3.g gVar) {
        return t(kVar, gVar);
    }

    @Override // w3.e
    public Object f(c3.k kVar, k3.g gVar) {
        return t(kVar, gVar);
    }

    @Override // w3.e
    public w3.e g(k3.d dVar) {
        return dVar == this.f19442c ? this : new i(this, dVar);
    }

    @Override // w3.e
    public e0.a k() {
        return e0.a.WRAPPER_OBJECT;
    }

    public Object t(c3.k kVar, k3.g gVar) {
        Object d02;
        if (kVar.e() && (d02 = kVar.d0()) != null) {
            return m(kVar, gVar, d02);
        }
        c3.n n10 = kVar.n();
        c3.n nVar = c3.n.START_OBJECT;
        if (n10 == nVar) {
            c3.n s02 = kVar.s0();
            c3.n nVar2 = c3.n.FIELD_NAME;
            if (s02 != nVar2) {
                gVar.F0(r(), nVar2, "need JSON String that contains type id (for subtype of " + s() + ")", new Object[0]);
            }
        } else if (n10 != c3.n.FIELD_NAME) {
            gVar.F0(r(), nVar, "need JSON Object to contain As.WRAPPER_OBJECT type information for class " + s(), new Object[0]);
        }
        String Y = kVar.Y();
        k3.k o10 = o(gVar, Y);
        kVar.s0();
        if (this.f19445f && kVar.j0(nVar)) {
            y yVar = new y((c3.o) null, false);
            yVar.v0();
            yVar.Z(this.f19444e);
            yVar.z0(Y);
            kVar.f();
            kVar = j3.k.F0(false, yVar.S0(kVar), kVar);
            kVar.s0();
        }
        Object deserialize = o10.deserialize(kVar, gVar);
        c3.n s03 = kVar.s0();
        c3.n nVar3 = c3.n.END_OBJECT;
        if (s03 != nVar3) {
            gVar.F0(r(), nVar3, "expected closing END_OBJECT after type information and deserialized value", new Object[0]);
        }
        return deserialize;
    }

    public i(i iVar, k3.d dVar) {
        super(iVar, dVar);
    }
}
