package c4;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;

/* loaded from: classes.dex */
public abstract class d extends m {

    /* renamed from: l, reason: collision with root package name */
    public final k3.j f5534l;

    public d(Class cls, n nVar, k3.j jVar, k3.j[] jVarArr, k3.j jVar2, Object obj, Object obj2, boolean z10) {
        super(cls, nVar, jVar, jVarArr, jVar2.hashCode(), obj, obj2, z10);
        this.f5534l = jVar2;
    }

    @Override // k3.j
    public boolean B() {
        return true;
    }

    @Override // k3.j
    public boolean D() {
        return true;
    }

    @Override // k3.j
    public k3.j U(k3.j jVar) {
        k3.j U;
        k3.j U2 = super.U(jVar);
        k3.j k10 = jVar.k();
        return (k10 == null || (U = this.f5534l.U(k10)) == this.f5534l) ? U2 : U2.R(U);
    }

    @Override // c4.m
    public String a0() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f14918a.getName());
        if (this.f5534l != null && Z(1)) {
            sb.append(ASCIIPropertyListParser.DATA_BEGIN_TOKEN);
            sb.append(this.f5534l.c());
            sb.append(ASCIIPropertyListParser.DATA_END_TOKEN);
        }
        return sb.toString();
    }

    @Override // k3.j
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != getClass()) {
            return false;
        }
        d dVar = (d) obj;
        return this.f14918a == dVar.f14918a && this.f5534l.equals(dVar.f5534l);
    }

    @Override // k3.j
    public k3.j k() {
        return this.f5534l;
    }

    @Override // k3.j
    public StringBuilder l(StringBuilder sb) {
        return m.Y(this.f14918a, sb, true);
    }

    @Override // k3.j
    public StringBuilder n(StringBuilder sb) {
        m.Y(this.f14918a, sb, false);
        sb.append(ASCIIPropertyListParser.DATA_BEGIN_TOKEN);
        this.f5534l.n(sb);
        sb.append(">;");
        return sb;
    }

    @Override // k3.j
    public boolean x() {
        return super.x() || this.f5534l.x();
    }
}
