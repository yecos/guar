package x3;

import b3.e0;
import d4.y;

/* loaded from: classes.dex */
public class a extends q {
    public a(k3.j jVar, w3.f fVar, String str, boolean z10, k3.j jVar2) {
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
        return dVar == this.f19442c ? this : new a(this, dVar);
    }

    @Override // w3.e
    public e0.a k() {
        return e0.a.WRAPPER_ARRAY;
    }

    public Object t(c3.k kVar, k3.g gVar) {
        Object d02;
        if (kVar.e() && (d02 = kVar.d0()) != null) {
            return m(kVar, gVar, d02);
        }
        boolean n02 = kVar.n0();
        String u10 = u(kVar, gVar);
        k3.k o10 = o(gVar, u10);
        if (this.f19445f && !v() && kVar.j0(c3.n.START_OBJECT)) {
            y yVar = new y((c3.o) null, false);
            yVar.v0();
            yVar.Z(this.f19444e);
            yVar.z0(u10);
            kVar.f();
            kVar = j3.k.F0(false, yVar.S0(kVar), kVar);
            kVar.s0();
        }
        if (n02 && kVar.n() == c3.n.END_ARRAY) {
            return o10.getNullValue(gVar);
        }
        Object deserialize = o10.deserialize(kVar, gVar);
        if (n02) {
            c3.n s02 = kVar.s0();
            c3.n nVar = c3.n.END_ARRAY;
            if (s02 != nVar) {
                gVar.F0(r(), nVar, "expected closing END_ARRAY after type information and deserialized value", new Object[0]);
            }
        }
        return deserialize;
    }

    public String u(c3.k kVar, k3.g gVar) {
        if (kVar.n0()) {
            c3.n s02 = kVar.s0();
            c3.n nVar = c3.n.VALUE_STRING;
            if (s02 != nVar) {
                gVar.F0(r(), nVar, "need JSON String that contains type id (for subtype of %s)", s());
                return null;
            }
            String Y = kVar.Y();
            kVar.s0();
            return Y;
        }
        if (this.f19443d != null) {
            return this.f19440a.e();
        }
        gVar.F0(r(), c3.n.START_ARRAY, "need JSON Array to contain As.WRAPPER_ARRAY type information for class " + s(), new Object[0]);
        return null;
    }

    public boolean v() {
        return false;
    }

    public a(a aVar, k3.d dVar) {
        super(aVar, dVar);
    }
}
