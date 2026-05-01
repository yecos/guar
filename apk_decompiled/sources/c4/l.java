package c4;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;

/* loaded from: classes.dex */
public class l extends m {
    public l(Class cls) {
        this(cls, n.i(), null, null);
    }

    public static l b0(Class cls) {
        return new l(cls, null, null, null, null, null, false);
    }

    @Override // k3.j
    public boolean D() {
        return false;
    }

    @Override // k3.j
    public k3.j P(Class cls, n nVar, k3.j jVar, k3.j[] jVarArr) {
        return null;
    }

    @Override // k3.j
    public k3.j R(k3.j jVar) {
        throw new IllegalArgumentException("Simple types have no content types; cannot call withContentType()");
    }

    @Override // k3.j
    public k3.j S(Object obj) {
        throw new IllegalArgumentException("Simple types have no content types; cannot call withContenTypeHandler()");
    }

    @Override // c4.m
    public String a0() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f14918a.getName());
        int o10 = this.f5560h.o();
        if (o10 > 0 && Z(o10)) {
            sb.append(ASCIIPropertyListParser.DATA_BEGIN_TOKEN);
            for (int i10 = 0; i10 < o10; i10++) {
                k3.j f10 = f(i10);
                if (i10 > 0) {
                    sb.append(ASCIIPropertyListParser.ARRAY_ITEM_DELIMITER_TOKEN);
                }
                sb.append(f10.c());
            }
            sb.append(ASCIIPropertyListParser.DATA_END_TOKEN);
        }
        return sb.toString();
    }

    @Override // k3.j
    public l c0(Object obj) {
        throw new IllegalArgumentException("Simple types have no content types; cannot call withContenValueHandler()");
    }

    @Override // k3.j
    public l d0() {
        return this.f14922e ? this : new l(this.f14918a, this.f5560h, this.f5558f, this.f5559g, this.f14920c, this.f14921d, true);
    }

    @Override // k3.j
    public l e0(Object obj) {
        return this.f14921d == obj ? this : new l(this.f14918a, this.f5560h, this.f5558f, this.f5559g, this.f14920c, obj, this.f14922e);
    }

    @Override // k3.j
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != getClass()) {
            return false;
        }
        l lVar = (l) obj;
        if (lVar.f14918a != this.f14918a) {
            return false;
        }
        return this.f5560h.equals(lVar.f5560h);
    }

    @Override // k3.j
    public l f0(Object obj) {
        return obj == this.f14920c ? this : new l(this.f14918a, this.f5560h, this.f5558f, this.f5559g, obj, this.f14921d, this.f14922e);
    }

    @Override // k3.j
    public StringBuilder l(StringBuilder sb) {
        return m.Y(this.f14918a, sb, true);
    }

    @Override // k3.j
    public StringBuilder n(StringBuilder sb) {
        m.Y(this.f14918a, sb, false);
        int o10 = this.f5560h.o();
        if (o10 > 0) {
            sb.append(ASCIIPropertyListParser.DATA_BEGIN_TOKEN);
            for (int i10 = 0; i10 < o10; i10++) {
                sb = f(i10).n(sb);
            }
            sb.append(ASCIIPropertyListParser.DATA_END_TOKEN);
        }
        sb.append(ASCIIPropertyListParser.DICTIONARY_ITEM_DELIMITER_TOKEN);
        return sb;
    }

    @Override // k3.j
    public String toString() {
        StringBuilder sb = new StringBuilder(40);
        sb.append("[simple type, class ");
        sb.append(a0());
        sb.append(']');
        return sb.toString();
    }

    @Override // k3.j
    public boolean v() {
        return false;
    }

    public l(Class cls, n nVar, k3.j jVar, k3.j[] jVarArr) {
        this(cls, nVar, jVar, jVarArr, null, null, false);
    }

    public l(Class cls, n nVar, k3.j jVar, k3.j[] jVarArr, Object obj, Object obj2, boolean z10) {
        super(cls, nVar, jVar, jVarArr, 0, obj, obj2, z10);
    }

    public l(Class cls, n nVar, k3.j jVar, k3.j[] jVarArr, int i10, Object obj, Object obj2, boolean z10) {
        super(cls, nVar, jVar, jVarArr, i10, obj, obj2, z10);
    }
}
