package com.fasterxml.jackson.databind.ser.std;

import b4.k;
import java.util.Objects;

/* loaded from: classes.dex */
public class x extends a {

    /* renamed from: c, reason: collision with root package name */
    public final boolean f6742c;

    /* renamed from: d, reason: collision with root package name */
    public final k3.j f6743d;

    /* renamed from: e, reason: collision with root package name */
    public final w3.h f6744e;

    /* renamed from: f, reason: collision with root package name */
    public k3.o f6745f;

    /* renamed from: g, reason: collision with root package name */
    public b4.k f6746g;

    public x(k3.j jVar, boolean z10, w3.h hVar, k3.o oVar) {
        super(Object[].class);
        this.f6743d = jVar;
        this.f6742c = z10;
        this.f6744e = hVar;
        this.f6746g = b4.k.c();
        this.f6745f = oVar;
    }

    @Override // com.fasterxml.jackson.databind.ser.std.i0, k3.o
    public void acceptJsonFormatVisitor(u3.f fVar, k3.j jVar) {
        fVar.g(jVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x002b  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0033  */
    @Override // com.fasterxml.jackson.databind.ser.std.a, a4.i
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public k3.o b(k3.c0 r6, k3.d r7) {
        /*
            r5 = this;
            w3.h r0 = r5.f6744e
            if (r0 == 0) goto L8
            w3.h r0 = r0.a(r7)
        L8:
            r1 = 0
            if (r7 == 0) goto L20
            r3.i r2 = r7.d()
            k3.b r3 = r6.W()
            if (r2 == 0) goto L20
            java.lang.Object r3 = r3.g(r2)
            if (r3 == 0) goto L20
            k3.o r2 = r6.t0(r2, r3)
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
            k3.o r2 = r5.f6745f
        L35:
            k3.o r2 = r5.findContextualConvertingSerializer(r6, r7, r2)
            if (r2 != 0) goto L4f
            k3.j r3 = r5.f6743d
            if (r3 == 0) goto L4f
            boolean r4 = r5.f6742c
            if (r4 == 0) goto L4f
            boolean r3 = r3.I()
            if (r3 != 0) goto L4f
            k3.j r2 = r5.f6743d
            k3.o r2 = r6.H(r2, r7)
        L4f:
            com.fasterxml.jackson.databind.ser.std.x r6 = r5.o(r7, r0, r2, r1)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.databind.ser.std.x.b(k3.c0, k3.d):k3.o");
    }

    @Override // a4.h
    public a4.h c(w3.h hVar) {
        return new x(this.f6743d, this.f6742c, hVar, this.f6745f);
    }

    @Override // com.fasterxml.jackson.databind.ser.std.a
    public k3.o f(k3.d dVar, Boolean bool) {
        return new x(this, dVar, this.f6744e, this.f6745f, bool);
    }

    public final k3.o h(b4.k kVar, Class cls, k3.c0 c0Var) {
        k.d g10 = kVar.g(cls, c0Var, this.f6653a);
        b4.k kVar2 = g10.f4620b;
        if (kVar != kVar2) {
            this.f6746g = kVar2;
        }
        return g10.f4619a;
    }

    public final k3.o i(b4.k kVar, k3.j jVar, k3.c0 c0Var) {
        k.d h10 = kVar.h(jVar, c0Var, this.f6653a);
        b4.k kVar2 = h10.f4620b;
        if (kVar != kVar2) {
            this.f6746g = kVar2;
        }
        return h10.f4619a;
    }

    @Override // k3.o
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public boolean isEmpty(k3.c0 c0Var, Object[] objArr) {
        return objArr.length == 0;
    }

    @Override // com.fasterxml.jackson.databind.ser.std.i0, k3.o
    /* renamed from: k, reason: merged with bridge method [inline-methods] */
    public final void serialize(Object[] objArr, c3.h hVar, k3.c0 c0Var) {
        int length = objArr.length;
        if (length == 1 && ((this.f6654b == null && c0Var.m0(k3.b0.WRITE_SINGLE_ELEM_ARRAYS_UNWRAPPED)) || this.f6654b == Boolean.TRUE)) {
            g(objArr, hVar, c0Var);
            return;
        }
        hVar.u0(objArr, length);
        g(objArr, hVar, c0Var);
        hVar.V();
    }

    @Override // com.fasterxml.jackson.databind.ser.std.a
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public void g(Object[] objArr, c3.h hVar, k3.c0 c0Var) {
        int length = objArr.length;
        if (length == 0) {
            return;
        }
        k3.o oVar = this.f6745f;
        if (oVar != null) {
            m(objArr, hVar, c0Var, oVar);
            return;
        }
        if (this.f6744e != null) {
            n(objArr, hVar, c0Var);
            return;
        }
        int i10 = 0;
        Object obj = null;
        try {
            b4.k kVar = this.f6746g;
            while (i10 < length) {
                obj = objArr[i10];
                if (obj == null) {
                    c0Var.E(hVar);
                } else {
                    Class<?> cls = obj.getClass();
                    k3.o j10 = kVar.j(cls);
                    if (j10 == null) {
                        j10 = this.f6743d.w() ? i(kVar, c0Var.A(this.f6743d, cls), c0Var) : h(kVar, cls, c0Var);
                    }
                    j10.serialize(obj, hVar, c0Var);
                }
                i10++;
            }
        } catch (Exception e10) {
            wrapAndThrow(c0Var, e10, obj, i10);
        }
    }

    public void m(Object[] objArr, c3.h hVar, k3.c0 c0Var, k3.o oVar) {
        int length = objArr.length;
        w3.h hVar2 = this.f6744e;
        Object obj = null;
        for (int i10 = 0; i10 < length; i10++) {
            try {
                obj = objArr[i10];
                if (obj == null) {
                    c0Var.E(hVar);
                } else if (hVar2 == null) {
                    oVar.serialize(obj, hVar, c0Var);
                } else {
                    oVar.serializeWithType(obj, hVar, c0Var, hVar2);
                }
            } catch (Exception e10) {
                wrapAndThrow(c0Var, e10, obj, i10);
                return;
            }
        }
    }

    public void n(Object[] objArr, c3.h hVar, k3.c0 c0Var) {
        int length = objArr.length;
        w3.h hVar2 = this.f6744e;
        int i10 = 0;
        Object obj = null;
        try {
            b4.k kVar = this.f6746g;
            while (i10 < length) {
                obj = objArr[i10];
                if (obj == null) {
                    c0Var.E(hVar);
                } else {
                    Class<?> cls = obj.getClass();
                    k3.o j10 = kVar.j(cls);
                    if (j10 == null) {
                        j10 = h(kVar, cls, c0Var);
                    }
                    j10.serializeWithType(obj, hVar, c0Var, hVar2);
                }
                i10++;
            }
        } catch (Exception e10) {
            wrapAndThrow(c0Var, e10, obj, i10);
        }
    }

    public x o(k3.d dVar, w3.h hVar, k3.o oVar, Boolean bool) {
        return (this.f6653a == dVar && oVar == this.f6745f && this.f6744e == hVar && Objects.equals(this.f6654b, bool)) ? this : new x(this, dVar, hVar, oVar, bool);
    }

    public x(x xVar, k3.d dVar, w3.h hVar, k3.o oVar, Boolean bool) {
        super(xVar, dVar, bool);
        this.f6743d = xVar.f6743d;
        this.f6744e = hVar;
        this.f6742c = xVar.f6742c;
        this.f6746g = b4.k.c();
        this.f6745f = oVar;
    }
}
