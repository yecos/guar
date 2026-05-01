package b4;

import java.lang.reflect.Type;
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
        To view partially-correct add '--show-bad-code' argument
    */
    public k3.o b(k3.c0 r5, k3.d r6) {
        /*
            r4 = this;
            r0 = 0
            if (r6 == 0) goto L18
            k3.b r1 = r5.W()
            r3.i r2 = r6.d()
            if (r2 == 0) goto L18
            java.lang.Object r1 = r1.g(r2)
            if (r1 == 0) goto L18
            k3.o r1 = r5.t0(r2, r1)
            goto L19
        L18:
            r1 = r0
        L19:
            java.lang.Class<java.lang.String[]> r2 = java.lang.String[].class
            b3.k$a r3 = b3.k.a.WRITE_SINGLE_ELEM_ARRAYS_UNWRAPPED
            java.lang.Boolean r2 = r4.findFormatFeature(r5, r6, r2, r3)
            if (r1 != 0) goto L25
            k3.o r1 = r4.f4635c
        L25:
            k3.o r1 = r4.findContextualConvertingSerializer(r5, r6, r1)
            if (r1 != 0) goto L31
            java.lang.Class<java.lang.String> r1 = java.lang.String.class
            k3.o r1 = r5.G(r1, r6)
        L31:
            boolean r5 = r4.isDefaultSerializer(r1)
            if (r5 == 0) goto L38
            goto L39
        L38:
            r0 = r1
        L39:
            k3.o r5 = r4.f4635c
            if (r0 != r5) goto L46
            java.lang.Boolean r5 = r4.f6654b
            boolean r5 = java.util.Objects.equals(r2, r5)
            if (r5 == 0) goto L46
            return r4
        L46:
            b4.m r5 = new b4.m
            r5.<init>(r4, r6, r0, r2)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: b4.m.b(k3.c0, k3.d):k3.o");
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
