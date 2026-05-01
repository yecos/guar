package com.fasterxml.jackson.databind.ser.std;

import b4.k;
import java.lang.reflect.Type;

/* loaded from: classes.dex */
public abstract class b extends a4.h implements a4.i {

    /* renamed from: a, reason: collision with root package name */
    public final k3.j f6656a;

    /* renamed from: b, reason: collision with root package name */
    public final k3.d f6657b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f6658c;

    /* renamed from: d, reason: collision with root package name */
    public final Boolean f6659d;

    /* renamed from: e, reason: collision with root package name */
    public final w3.h f6660e;

    /* renamed from: f, reason: collision with root package name */
    public final k3.o f6661f;

    /* renamed from: g, reason: collision with root package name */
    public b4.k f6662g;

    public b(Class cls, k3.j jVar, boolean z10, w3.h hVar, k3.o oVar) {
        this(cls, jVar, z10, hVar, null, oVar, null);
    }

    @Override // com.fasterxml.jackson.databind.ser.std.i0, k3.o
    public void acceptJsonFormatVisitor(u3.f fVar, k3.j jVar) {
        k3.o oVar = this.f6661f;
        if (oVar == null && this.f6656a != null) {
            oVar = fVar.getProvider().H(this.f6656a, this.f6657b);
        }
        visitArrayFormat(fVar, jVar, oVar, this.f6656a);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x002b  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0033  */
    @Override // a4.i
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public k3.o b(k3.c0 r6, k3.d r7) {
        /*
            r5 = this;
            w3.h r0 = r5.f6660e
            if (r0 == 0) goto L8
            w3.h r0 = r0.a(r7)
        L8:
            r1 = 0
            if (r7 == 0) goto L20
            k3.b r2 = r6.W()
            r3.i r3 = r7.d()
            if (r3 == 0) goto L20
            java.lang.Object r2 = r2.g(r3)
            if (r2 == 0) goto L20
            k3.o r2 = r6.t0(r3, r2)
            goto L21
        L20:
            r2 = r1
        L21:
            java.lang.Class r3 = r5.handledType()
            b3.k$d r3 = r5.findFormatOverrides(r6, r7, r3)
            if (r3 == 0) goto L31
            b3.k$a r1 = b3.k.a.WRITE_SINGLE_ELEM_ARRAYS_UNWRAPPED
            java.lang.Boolean r1 = r3.e(r1)
        L31:
            if (r2 != 0) goto L35
            k3.o r2 = r5.f6661f
        L35:
            k3.o r2 = r5.findContextualConvertingSerializer(r6, r7, r2)
            if (r2 != 0) goto L4f
            k3.j r3 = r5.f6656a
            if (r3 == 0) goto L4f
            boolean r4 = r5.f6658c
            if (r4 == 0) goto L4f
            boolean r3 = r3.I()
            if (r3 != 0) goto L4f
            k3.j r2 = r5.f6656a
            k3.o r2 = r6.H(r2, r7)
        L4f:
            k3.o r6 = r5.f6661f
            if (r2 != r6) goto L65
            k3.d r6 = r5.f6657b
            if (r7 != r6) goto L65
            w3.h r6 = r5.f6660e
            if (r6 != r0) goto L65
            java.lang.Boolean r6 = r5.f6659d
            boolean r6 = java.util.Objects.equals(r6, r1)
            if (r6 != 0) goto L64
            goto L65
        L64:
            return r5
        L65:
            com.fasterxml.jackson.databind.ser.std.b r6 = r5.h(r7, r0, r2, r1)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.databind.ser.std.b.b(k3.c0, k3.d):k3.o");
    }

    public final k3.o e(b4.k kVar, Class cls, k3.c0 c0Var) {
        k.d g10 = kVar.g(cls, c0Var, this.f6657b);
        b4.k kVar2 = g10.f4620b;
        if (kVar != kVar2) {
            this.f6662g = kVar2;
        }
        return g10.f4619a;
    }

    public final k3.o f(b4.k kVar, k3.j jVar, k3.c0 c0Var) {
        k.d h10 = kVar.h(jVar, c0Var, this.f6657b);
        b4.k kVar2 = h10.f4620b;
        if (kVar != kVar2) {
            this.f6662g = kVar2;
        }
        return h10.f4619a;
    }

    public abstract void g(Object obj, c3.h hVar, k3.c0 c0Var);

    @Override // com.fasterxml.jackson.databind.ser.std.i0, v3.c
    public k3.m getSchema(k3.c0 c0Var, Type type) {
        z3.r createSchemaNode = createSchemaNode("array", true);
        Object obj = this.f6661f;
        if (obj != null) {
            k3.m schema = obj instanceof v3.c ? ((v3.c) obj).getSchema(c0Var, null) : null;
            if (schema == null) {
                schema = v3.a.a();
            }
            createSchemaNode.G("items", schema);
        }
        return createSchemaNode;
    }

    public abstract b h(k3.d dVar, w3.h hVar, k3.o oVar, Boolean bool);

    @Override // k3.o
    public void serializeWithType(Object obj, c3.h hVar, k3.c0 c0Var, w3.h hVar2) {
        i3.b g10 = hVar2.g(hVar, hVar2.d(obj, c3.n.START_ARRAY));
        hVar.z(obj);
        g(obj, hVar, c0Var);
        hVar2.h(hVar, g10);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(Class cls, k3.j jVar, boolean z10, w3.h hVar, k3.d dVar, k3.o oVar, Boolean bool) {
        super(cls, false);
        boolean z11 = false;
        this.f6656a = jVar;
        if (z10 || (jVar != null && jVar.G())) {
            z11 = true;
        }
        this.f6658c = z11;
        this.f6660e = hVar;
        this.f6657b = dVar;
        this.f6661f = oVar;
        this.f6662g = b4.k.c();
        this.f6659d = bool;
    }

    public b(b bVar, k3.d dVar, w3.h hVar, k3.o oVar, Boolean bool) {
        super(bVar);
        this.f6656a = bVar.f6656a;
        this.f6658c = bVar.f6658c;
        this.f6660e = hVar;
        this.f6657b = dVar;
        this.f6661f = oVar;
        this.f6662g = b4.k.c();
        this.f6659d = bool;
    }
}
