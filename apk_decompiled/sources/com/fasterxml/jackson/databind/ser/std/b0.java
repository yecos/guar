package com.fasterxml.jackson.databind.ser.std;

import java.lang.reflect.Type;
import java.util.Collection;

/* loaded from: classes.dex */
public abstract class b0 extends i0 implements a4.i {

    /* renamed from: a, reason: collision with root package name */
    public final Boolean f6663a;

    public b0(Class cls) {
        super(cls, false);
        this.f6663a = null;
    }

    @Override // com.fasterxml.jackson.databind.ser.std.i0, k3.o
    public void acceptJsonFormatVisitor(u3.f fVar, k3.j jVar) {
        fVar.g(jVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x002a  */
    @Override // a4.i
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public k3.o b(k3.c0 r6, k3.d r7) {
        /*
            r5 = this;
            r0 = 0
            if (r7 == 0) goto L18
            k3.b r1 = r6.W()
            r3.i r2 = r7.d()
            if (r2 == 0) goto L18
            java.lang.Object r1 = r1.g(r2)
            if (r1 == 0) goto L18
            k3.o r1 = r6.t0(r2, r1)
            goto L19
        L18:
            r1 = r0
        L19:
            java.lang.Class r2 = r5.handledType()
            b3.k$d r2 = r5.findFormatOverrides(r6, r7, r2)
            if (r2 == 0) goto L2a
            b3.k$a r3 = b3.k.a.WRITE_SINGLE_ELEM_ARRAYS_UNWRAPPED
            java.lang.Boolean r2 = r2.e(r3)
            goto L2b
        L2a:
            r2 = r0
        L2b:
            k3.o r1 = r5.findContextualConvertingSerializer(r6, r7, r1)
            java.lang.Class<java.lang.String> r3 = java.lang.String.class
            if (r1 != 0) goto L37
            k3.o r1 = r6.G(r3, r7)
        L37:
            boolean r4 = r5.isDefaultSerializer(r1)
            if (r4 == 0) goto L4b
            java.lang.Boolean r6 = r5.f6663a
            boolean r6 = java.util.Objects.equals(r2, r6)
            if (r6 == 0) goto L46
            return r5
        L46:
            k3.o r6 = r5.c(r7, r2)
            return r6
        L4b:
            com.fasterxml.jackson.databind.ser.std.j r7 = new com.fasterxml.jackson.databind.ser.std.j
            k3.j r6 = r6.i(r3)
            r2 = 1
            r7.<init>(r6, r2, r0, r1)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.databind.ser.std.b0.b(k3.c0, k3.d):k3.o");
    }

    public abstract k3.o c(k3.d dVar, Boolean bool);

    public abstract k3.m d();

    @Override // k3.o
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public boolean isEmpty(k3.c0 c0Var, Collection collection) {
        return collection == null || collection.size() == 0;
    }

    @Override // com.fasterxml.jackson.databind.ser.std.i0, v3.c
    public k3.m getSchema(k3.c0 c0Var, Type type) {
        return createSchemaNode("array", true).G("items", d());
    }

    public b0(b0 b0Var, Boolean bool) {
        super(b0Var);
        this.f6663a = bool;
    }
}
