package b4;

import b3.k;
import java.lang.reflect.Type;
import java.util.Objects;
import k3.b0;
import k3.c0;

/* loaded from: classes.dex */
public class m extends com.fasterxml.jackson.databind.ser.std.a {

    /* renamed from: d, reason: collision with root package name */
    public static final k3.j f4633d = c4.o.I().N(String.class);

    /* renamed from: e, reason: collision with root package name */
    public static final m f4634e = new m();

    /* renamed from: c, reason: collision with root package name */
    public final k3.o f4635c;

    public m() {
        super(String[].class);
        this.f4635c = null;
    }

    @Override // com.fasterxml.jackson.databind.ser.std.i0, k3.o
    public void acceptJsonFormatVisitor(u3.f fVar, k3.j jVar) {
        visitArrayFormat(fVar, jVar, u3.d.STRING);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x002b  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0038  */
    @Override // com.fasterxml.jackson.databind.ser.std.a, a4.i
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public k3.o b(c0 c0Var, k3.d dVar) {
        k3.o oVar;
        k3.o findContextualConvertingSerializer;
        Object g10;
        if (dVar != null) {
            k3.b W = c0Var.W();
            r3.i d10 = dVar.d();
            if (d10 != null && (g10 = W.g(d10)) != null) {
                oVar = c0Var.t0(d10, g10);
                Boolean findFormatFeature = findFormatFeature(c0Var, dVar, String[].class, k.a.WRITE_SINGLE_ELEM_ARRAYS_UNWRAPPED);
                if (oVar == null) {
                    oVar = this.f4635c;
                }
                findContextualConvertingSerializer = findContextualConvertingSerializer(c0Var, dVar, oVar);
                if (findContextualConvertingSerializer == null) {
                    findContextualConvertingSerializer = c0Var.G(String.class, dVar);
                }
                k3.o oVar2 = isDefaultSerializer(findContextualConvertingSerializer) ? null : findContextualConvertingSerializer;
                return (oVar2 == this.f4635c || !Objects.equals(findFormatFeature, this.f6654b)) ? new m(this, dVar, oVar2, findFormatFeature) : this;
            }
        }
        oVar = null;
        Boolean findFormatFeature2 = findFormatFeature(c0Var, dVar, String[].class, k.a.WRITE_SINGLE_ELEM_ARRAYS_UNWRAPPED);
        if (oVar == null) {
        }
        findContextualConvertingSerializer = findContextualConvertingSerializer(c0Var, dVar, oVar);
        if (findContextualConvertingSerializer == null) {
        }
        if (isDefaultSerializer(findContextualConvertingSerializer)) {
        }
        if (oVar2 == this.f4635c) {
        }
    }

    @Override // a4.h
    public a4.h c(w3.h hVar) {
        return this;
    }

    @Override // com.fasterxml.jackson.databind.ser.std.a
    public k3.o f(k3.d dVar, Boolean bool) {
        return new m(this, dVar, this.f4635c, bool);
    }

    @Override // com.fasterxml.jackson.databind.ser.std.i0, v3.c
    public k3.m getSchema(c0 c0Var, Type type) {
        return createSchemaNode("array", true).G("items", createSchemaNode("string"));
    }

    @Override // k3.o
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public boolean isEmpty(c0 c0Var, String[] strArr) {
        return strArr.length == 0;
    }

    @Override // com.fasterxml.jackson.databind.ser.std.i0, k3.o
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public final void serialize(String[] strArr, c3.h hVar, c0 c0Var) {
        int length = strArr.length;
        if (length == 1 && ((this.f6654b == null && c0Var.m0(b0.WRITE_SINGLE_ELEM_ARRAYS_UNWRAPPED)) || this.f6654b == Boolean.TRUE)) {
            g(strArr, hVar, c0Var);
            return;
        }
        hVar.u0(strArr, length);
        g(strArr, hVar, c0Var);
        hVar.V();
    }

    @Override // com.fasterxml.jackson.databind.ser.std.a
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public void g(String[] strArr, c3.h hVar, c0 c0Var) {
        if (strArr.length == 0) {
            return;
        }
        k3.o oVar = this.f4635c;
        if (oVar != null) {
            k(strArr, hVar, c0Var, oVar);
            return;
        }
        for (String str : strArr) {
            if (str == null) {
                hVar.a0();
            } else {
                hVar.z0(str);
            }
        }
    }

    public final void k(String[] strArr, c3.h hVar, c0 c0Var, k3.o oVar) {
        for (String str : strArr) {
            if (str == null) {
                c0Var.E(hVar);
            } else {
                oVar.serialize(str, hVar, c0Var);
            }
        }
    }

    public m(m mVar, k3.d dVar, k3.o oVar, Boolean bool) {
        super(mVar, dVar, bool);
        this.f4635c = oVar;
    }
}
