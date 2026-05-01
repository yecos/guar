package com.fasterxml.jackson.databind.ser.std;

import b3.k;
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
    */
    public k3.o b(k3.c0 c0Var, k3.d dVar) {
        k3.o oVar;
        k3.o findContextualConvertingSerializer;
        k3.j jVar;
        Object g10;
        w3.h hVar = this.f6744e;
        if (hVar != null) {
            hVar = hVar.a(dVar);
        }
        if (dVar != null) {
            r3.i d10 = dVar.d();
            k3.b W = c0Var.W();
            if (d10 != null && (g10 = W.g(d10)) != null) {
                oVar = c0Var.t0(d10, g10);
                k.d findFormatOverrides = findFormatOverrides(c0Var, dVar, handledType());
                Boolean e10 = findFormatOverrides != null ? findFormatOverrides.e(k.a.WRITE_SINGLE_ELEM_ARRAYS_UNWRAPPED) : null;
                if (oVar == null) {
                    oVar = this.f6745f;
                }
                findContextualConvertingSerializer = findContextualConvertingSerializer(c0Var, dVar, oVar);
                if (findContextualConvertingSerializer == null && (jVar = this.f6743d) != null && this.f6742c && !jVar.I()) {
                    findContextualConvertingSerializer = c0Var.H(this.f6743d, dVar);
                }
                return o(dVar, hVar, findContextualConvertingSerializer, e10);
            }
        }
        oVar = null;
        k.d findFormatOverrides2 = findFormatOverrides(c0Var, dVar, handledType());
        if (findFormatOverrides2 != null) {
        }
        if (oVar == null) {
        }
        findContextualConvertingSerializer = findContextualConvertingSerializer(c0Var, dVar, oVar);
        if (findContextualConvertingSerializer == null) {
            findContextualConvertingSerializer = c0Var.H(this.f6743d, dVar);
        }
        return o(dVar, hVar, findContextualConvertingSerializer, e10);
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
