package c4;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;

/* loaded from: classes.dex */
public class j extends l {

    /* renamed from: l, reason: collision with root package name */
    public final k3.j f5553l;

    /* renamed from: m, reason: collision with root package name */
    public final k3.j f5554m;

    public j(Class cls, n nVar, k3.j jVar, k3.j[] jVarArr, k3.j jVar2, k3.j jVar3, Object obj, Object obj2, boolean z10) {
        super(cls, nVar, jVar, jVarArr, jVar2.hashCode(), obj, obj2, z10);
        this.f5553l = jVar2;
        this.f5554m = jVar3 == null ? this : jVar3;
    }

    public static j g0(Class cls, n nVar, k3.j jVar, k3.j[] jVarArr, k3.j jVar2) {
        return new j(cls, nVar, jVar, jVarArr, jVar2, null, null, null, false);
    }

    @Override // c4.l, k3.j
    public k3.j P(Class cls, n nVar, k3.j jVar, k3.j[] jVarArr) {
        return new j(cls, this.f5560h, jVar, jVarArr, this.f5553l, this.f5554m, this.f14920c, this.f14921d, this.f14922e);
    }

    @Override // c4.l, k3.j
    public k3.j R(k3.j jVar) {
        return this.f5553l == jVar ? this : new j(this.f14918a, this.f5560h, this.f5558f, this.f5559g, jVar, this.f5554m, this.f14920c, this.f14921d, this.f14922e);
    }

    @Override // c4.l, c4.m
    public String a0() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f14918a.getName());
        if (this.f5553l != null && Z(1)) {
            sb.append(ASCIIPropertyListParser.DATA_BEGIN_TOKEN);
            sb.append(this.f5553l.c());
            sb.append(ASCIIPropertyListParser.DATA_END_TOKEN);
        }
        return sb.toString();
    }

    @Override // i3.a
    public boolean b() {
        return true;
    }

    @Override // c4.l, k3.j
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != getClass()) {
            return false;
        }
        j jVar = (j) obj;
        if (jVar.f14918a != this.f14918a) {
            return false;
        }
        return this.f5553l.equals(jVar.f5553l);
    }

    @Override // c4.l, k3.j
    /* renamed from: h0, reason: merged with bridge method [inline-methods] */
    public j S(Object obj) {
        return obj == this.f5553l.t() ? this : new j(this.f14918a, this.f5560h, this.f5558f, this.f5559g, this.f5553l.e0(obj), this.f5554m, this.f14920c, this.f14921d, this.f14922e);
    }

    @Override // c4.l
    /* renamed from: i0, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public j c0(Object obj) {
        if (obj == this.f5553l.u()) {
            return this;
        }
        return new j(this.f14918a, this.f5560h, this.f5558f, this.f5559g, this.f5553l.f0(obj), this.f5554m, this.f14920c, this.f14921d, this.f14922e);
    }

    @Override // c4.l
    /* renamed from: j0, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public j d0() {
        return this.f14922e ? this : new j(this.f14918a, this.f5560h, this.f5558f, this.f5559g, this.f5553l.d0(), this.f5554m, this.f14920c, this.f14921d, true);
    }

    @Override // k3.j
    public k3.j k() {
        return this.f5553l;
    }

    @Override // c4.l
    /* renamed from: k0, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public j e0(Object obj) {
        return obj == this.f14921d ? this : new j(this.f14918a, this.f5560h, this.f5558f, this.f5559g, this.f5553l, this.f5554m, this.f14920c, obj, this.f14922e);
    }

    @Override // c4.l, k3.j
    public StringBuilder l(StringBuilder sb) {
        return m.Y(this.f14918a, sb, true);
    }

    @Override // c4.l
    /* renamed from: l0, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public j f0(Object obj) {
        return obj == this.f14920c ? this : new j(this.f14918a, this.f5560h, this.f5558f, this.f5559g, this.f5553l, this.f5554m, obj, this.f14921d, this.f14922e);
    }

    @Override // c4.l, k3.j
    public StringBuilder n(StringBuilder sb) {
        m.Y(this.f14918a, sb, false);
        sb.append(ASCIIPropertyListParser.DATA_BEGIN_TOKEN);
        StringBuilder n10 = this.f5553l.n(sb);
        n10.append(">;");
        return n10;
    }

    @Override // k3.j, i3.a
    /* renamed from: r */
    public k3.j a() {
        return this.f5553l;
    }

    @Override // c4.l, k3.j
    public String toString() {
        StringBuilder sb = new StringBuilder(40);
        sb.append("[reference type, class ");
        sb.append(a0());
        sb.append(ASCIIPropertyListParser.DATA_BEGIN_TOKEN);
        sb.append(this.f5553l);
        sb.append(ASCIIPropertyListParser.DATA_END_TOKEN);
        sb.append(']');
        return sb.toString();
    }

    @Override // c4.l, k3.j
    public boolean v() {
        return true;
    }
}
