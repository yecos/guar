package c4;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import k3.c0;

/* loaded from: classes.dex */
public abstract class m extends k3.j implements k3.n {

    /* renamed from: j, reason: collision with root package name */
    public static final n f5556j = n.i();

    /* renamed from: k, reason: collision with root package name */
    public static final k3.j[] f5557k = new k3.j[0];

    /* renamed from: f, reason: collision with root package name */
    public final k3.j f5558f;

    /* renamed from: g, reason: collision with root package name */
    public final k3.j[] f5559g;

    /* renamed from: h, reason: collision with root package name */
    public final n f5560h;

    /* renamed from: i, reason: collision with root package name */
    public volatile transient String f5561i;

    public m(Class cls, n nVar, k3.j jVar, k3.j[] jVarArr, int i10, Object obj, Object obj2, boolean z10) {
        super(cls, i10, obj, obj2, z10);
        this.f5560h = nVar == null ? f5556j : nVar;
        this.f5558f = jVar;
        this.f5559g = jVarArr;
    }

    public static StringBuilder Y(Class cls, StringBuilder sb, boolean z10) {
        if (!cls.isPrimitive()) {
            sb.append('L');
            String name = cls.getName();
            int length = name.length();
            for (int i10 = 0; i10 < length; i10++) {
                char charAt = name.charAt(i10);
                if (charAt == '.') {
                    charAt = '/';
                }
                sb.append(charAt);
            }
            if (z10) {
                sb.append(ASCIIPropertyListParser.DICTIONARY_ITEM_DELIMITER_TOKEN);
            }
        } else if (cls == Boolean.TYPE) {
            sb.append(ASCIIPropertyListParser.DATE_APPLE_END_TOKEN);
        } else if (cls == Byte.TYPE) {
            sb.append(ASCIIPropertyListParser.DATA_GSBOOL_BEGIN_TOKEN);
        } else if (cls == Short.TYPE) {
            sb.append('S');
        } else if (cls == Character.TYPE) {
            sb.append('C');
        } else if (cls == Integer.TYPE) {
            sb.append(ASCIIPropertyListParser.DATA_GSINT_BEGIN_TOKEN);
        } else if (cls == Long.TYPE) {
            sb.append('J');
        } else if (cls == Float.TYPE) {
            sb.append('F');
        } else if (cls == Double.TYPE) {
            sb.append(ASCIIPropertyListParser.DATA_GSDATE_BEGIN_TOKEN);
        } else {
            if (cls != Void.TYPE) {
                throw new IllegalStateException("Unrecognized primitive type: " + cls.getName());
            }
            sb.append('V');
        }
        return sb;
    }

    public boolean Z(int i10) {
        return this.f14918a.getTypeParameters().length == i10;
    }

    public String a0() {
        return this.f14918a.getName();
    }

    @Override // i3.a
    public String c() {
        String str = this.f5561i;
        return str == null ? a0() : str;
    }

    @Override // k3.n
    public void d(c3.h hVar, c0 c0Var) {
        hVar.z0(c());
    }

    @Override // k3.n
    public void e(c3.h hVar, c0 c0Var, w3.h hVar2) {
        i3.b bVar = new i3.b(this, c3.n.VALUE_STRING);
        hVar2.g(hVar, bVar);
        d(hVar, c0Var);
        hVar2.h(hVar, bVar);
    }

    @Override // k3.j
    public k3.j f(int i10) {
        return this.f5560h.k(i10);
    }

    @Override // k3.j
    public int g() {
        return this.f5560h.o();
    }

    @Override // k3.j
    public final k3.j i(Class cls) {
        k3.j i10;
        k3.j[] jVarArr;
        if (cls == this.f14918a) {
            return this;
        }
        if (cls.isInterface() && (jVarArr = this.f5559g) != null) {
            int length = jVarArr.length;
            for (int i11 = 0; i11 < length; i11++) {
                k3.j i12 = this.f5559g[i11].i(cls);
                if (i12 != null) {
                    return i12;
                }
            }
        }
        k3.j jVar = this.f5558f;
        if (jVar == null || (i10 = jVar.i(cls)) == null) {
            return null;
        }
        return i10;
    }

    @Override // k3.j
    public n j() {
        return this.f5560h;
    }

    @Override // k3.j
    public List o() {
        k3.j[] jVarArr = this.f5559g;
        if (jVarArr == null) {
            return Collections.emptyList();
        }
        int length = jVarArr.length;
        return length != 0 ? length != 1 ? Arrays.asList(jVarArr) : Collections.singletonList(jVarArr[0]) : Collections.emptyList();
    }

    @Override // k3.j
    public k3.j s() {
        return this.f5558f;
    }
}
