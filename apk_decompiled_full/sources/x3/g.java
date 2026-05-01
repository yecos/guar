package x3;

import b3.e0;
import d4.y;

/* loaded from: classes.dex */
public class g extends a {

    /* renamed from: i, reason: collision with root package name */
    public final e0.a f19421i;

    /* renamed from: j, reason: collision with root package name */
    public final String f19422j;

    public g(k3.j jVar, w3.f fVar, String str, boolean z10, k3.j jVar2, e0.a aVar) {
        super(jVar, fVar, str, z10, jVar2);
        k3.d dVar = this.f19442c;
        this.f19422j = dVar == null ? String.format("missing type id property '%s'", this.f19444e) : String.format("missing type id property '%s' (for POJO property '%s')", this.f19444e, dVar.getName());
        this.f19421i = aVar;
    }

    @Override // x3.a, w3.e
    public Object c(c3.k kVar, k3.g gVar) {
        return kVar.j0(c3.n.START_ARRAY) ? super.d(kVar, gVar) : e(kVar, gVar);
    }

    @Override // x3.a, w3.e
    public Object e(c3.k kVar, k3.g gVar) {
        Object d02;
        if (kVar.e() && (d02 = kVar.d0()) != null) {
            return m(kVar, gVar, d02);
        }
        c3.n n10 = kVar.n();
        y yVar = null;
        if (n10 == c3.n.START_OBJECT) {
            n10 = kVar.s0();
        } else if (n10 != c3.n.FIELD_NAME) {
            return x(kVar, gVar, null, this.f19422j);
        }
        boolean o02 = gVar.o0(k3.q.ACCEPT_CASE_INSENSITIVE_PROPERTIES);
        while (n10 == c3.n.FIELD_NAME) {
            String m10 = kVar.m();
            kVar.s0();
            if (m10.equals(this.f19444e) || (o02 && m10.equalsIgnoreCase(this.f19444e))) {
                return w(kVar, gVar, yVar, kVar.Y());
            }
            if (yVar == null) {
                yVar = new y(kVar, gVar);
            }
            yVar.Z(m10);
            yVar.V0(kVar);
            n10 = kVar.s0();
        }
        return x(kVar, gVar, yVar, this.f19422j);
    }

    @Override // x3.a, w3.e
    public w3.e g(k3.d dVar) {
        return dVar == this.f19442c ? this : new g(this, dVar);
    }

    @Override // x3.a, w3.e
    public e0.a k() {
        return this.f19421i;
    }

    public Object w(c3.k kVar, k3.g gVar, y yVar, String str) {
        k3.k o10 = o(gVar, str);
        if (this.f19445f) {
            if (yVar == null) {
                yVar = new y(kVar, gVar);
            }
            yVar.Z(kVar.m());
            yVar.z0(str);
        }
        if (yVar != null) {
            kVar.f();
            kVar = j3.k.F0(false, yVar.S0(kVar), kVar);
        }
        if (kVar.n() != c3.n.END_OBJECT) {
            kVar.s0();
        }
        return o10.deserialize(kVar, gVar);
    }

    public Object x(c3.k kVar, k3.g gVar, y yVar, String str) {
        if (!l()) {
            Object b10 = w3.e.b(kVar, gVar, this.f19441b);
            if (b10 != null) {
                return b10;
            }
            if (kVar.n0()) {
                return super.c(kVar, gVar);
            }
            if (kVar.j0(c3.n.VALUE_STRING) && gVar.n0(k3.h.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT) && kVar.Y().trim().isEmpty()) {
                return null;
            }
        }
        k3.k n10 = n(gVar);
        if (n10 == null) {
            k3.j p10 = p(gVar, str);
            if (p10 == null) {
                return null;
            }
            n10 = gVar.D(p10, this.f19442c);
        }
        if (yVar != null) {
            yVar.W();
            kVar = yVar.S0(kVar);
            kVar.s0();
        }
        return n10.deserialize(kVar, gVar);
    }

    public g(g gVar, k3.d dVar) {
        super(gVar, dVar);
        k3.d dVar2 = this.f19442c;
        this.f19422j = dVar2 == null ? String.format("missing type id property '%s'", this.f19444e) : String.format("missing type id property '%s' (for POJO property '%s')", this.f19444e, dVar2.getName());
        this.f19421i = gVar.f19421i;
    }
}
