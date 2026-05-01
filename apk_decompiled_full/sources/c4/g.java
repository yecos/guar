package c4;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;

/* loaded from: classes.dex */
public abstract class g extends m {

    /* renamed from: l, reason: collision with root package name */
    public final k3.j f5549l;

    /* renamed from: m, reason: collision with root package name */
    public final k3.j f5550m;

    public g(Class cls, n nVar, k3.j jVar, k3.j[] jVarArr, k3.j jVar2, k3.j jVar3, Object obj, Object obj2, boolean z10) {
        super(cls, nVar, jVar, jVarArr, jVar2.hashCode() ^ jVar3.hashCode(), obj, obj2, z10);
        this.f5549l = jVar2;
        this.f5550m = jVar3;
    }

    @Override // k3.j
    public boolean D() {
        return true;
    }

    @Override // k3.j
    public boolean J() {
        return true;
    }

    @Override // k3.j
    public k3.j U(k3.j jVar) {
        k3.j U;
        k3.j U2;
        k3.j U3 = super.U(jVar);
        k3.j p10 = jVar.p();
        if ((U3 instanceof g) && p10 != null && (U2 = this.f5549l.U(p10)) != this.f5549l) {
            U3 = ((g) U3).b0(U2);
        }
        k3.j k10 = jVar.k();
        return (k10 == null || (U = this.f5550m.U(k10)) == this.f5550m) ? U3 : U3.R(U);
    }

    @Override // c4.m
    public String a0() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f14918a.getName());
        if (this.f5549l != null && Z(2)) {
            sb.append(ASCIIPropertyListParser.DATA_BEGIN_TOKEN);
            sb.append(this.f5549l.c());
            sb.append(ASCIIPropertyListParser.ARRAY_ITEM_DELIMITER_TOKEN);
            sb.append(this.f5550m.c());
            sb.append(ASCIIPropertyListParser.DATA_END_TOKEN);
        }
        return sb.toString();
    }

    public abstract g b0(k3.j jVar);

    public abstract g c0(Object obj);

    @Override // k3.j
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != getClass()) {
            return false;
        }
        g gVar = (g) obj;
        return this.f14918a == gVar.f14918a && this.f5549l.equals(gVar.f5549l) && this.f5550m.equals(gVar.f5550m);
    }

    @Override // k3.j
    public k3.j k() {
        return this.f5550m;
    }

    @Override // k3.j
    public StringBuilder l(StringBuilder sb) {
        return m.Y(this.f14918a, sb, true);
    }

    @Override // k3.j
    public StringBuilder n(StringBuilder sb) {
        m.Y(this.f14918a, sb, false);
        sb.append(ASCIIPropertyListParser.DATA_BEGIN_TOKEN);
        this.f5549l.n(sb);
        this.f5550m.n(sb);
        sb.append(">;");
        return sb;
    }

    @Override // k3.j
    public k3.j p() {
        return this.f5549l;
    }

    @Override // k3.j
    public boolean x() {
        return super.x() || this.f5550m.x() || this.f5549l.x();
    }
}
