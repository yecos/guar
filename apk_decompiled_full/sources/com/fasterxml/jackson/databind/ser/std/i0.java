package com.fasterxml.jackson.databind.ser.std;

import b3.k;
import b3.r;
import c3.k;
import java.io.IOException;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.IdentityHashMap;
import java.util.Map;

/* loaded from: classes.dex */
public abstract class i0 extends k3.o implements v3.c, Serializable {
    private static final Object KEY_CONTENT_CONVERTER_LOCK = new Object();
    private static final long serialVersionUID = 1;
    protected final Class<Object> _handledType;

    public i0(Class cls) {
        this._handledType = cls;
    }

    public static final boolean _neitherNull(Object obj, Object obj2) {
        return (obj == null || obj2 == null) ? false : true;
    }

    public static final boolean _nonEmpty(Collection<?> collection) {
        return (collection == null || collection.isEmpty()) ? false : true;
    }

    @Override // k3.o
    public void acceptJsonFormatVisitor(u3.f fVar, k3.j jVar) {
        fVar.c(jVar);
    }

    public z3.r createSchemaNode(String str) {
        z3.r k10 = z3.l.f20188d.k();
        k10.C("type", str);
        return k10;
    }

    public k3.o findAnnotatedContentSerializer(k3.c0 c0Var, k3.d dVar) {
        Object g10;
        if (dVar == null) {
            return null;
        }
        r3.i d10 = dVar.d();
        k3.b W = c0Var.W();
        if (d10 == null || (g10 = W.g(d10)) == null) {
            return null;
        }
        return c0Var.t0(d10, g10);
    }

    public k3.o findContextualConvertingSerializer(k3.c0 c0Var, k3.d dVar, k3.o oVar) {
        Object obj = KEY_CONTENT_CONVERTER_LOCK;
        Map map = (Map) c0Var.X(obj);
        if (map == null) {
            map = new IdentityHashMap();
            c0Var.u0(obj, map);
        } else if (map.get(dVar) != null) {
            return oVar;
        }
        map.put(dVar, Boolean.TRUE);
        try {
            k3.o findConvertingContentSerializer = findConvertingContentSerializer(c0Var, dVar, oVar);
            return findConvertingContentSerializer != null ? c0Var.i0(findConvertingContentSerializer, dVar) : oVar;
        } finally {
            map.remove(dVar);
        }
    }

    @Deprecated
    public k3.o findConvertingContentSerializer(k3.c0 c0Var, k3.d dVar, k3.o oVar) {
        r3.i d10;
        Object T;
        k3.b W = c0Var.W();
        if (!_neitherNull(W, dVar) || (d10 = dVar.d()) == null || (T = W.T(d10)) == null) {
            return oVar;
        }
        d4.j j10 = c0Var.j(dVar.d(), T);
        k3.j a10 = j10.a(c0Var.l());
        if (oVar == null && !a10.I()) {
            oVar = c0Var.T(a10);
        }
        return new d0(j10, a10, oVar);
    }

    public Boolean findFormatFeature(k3.c0 c0Var, k3.d dVar, Class<?> cls, k.a aVar) {
        k.d findFormatOverrides = findFormatOverrides(c0Var, dVar, cls);
        if (findFormatOverrides != null) {
            return findFormatOverrides.e(aVar);
        }
        return null;
    }

    public k.d findFormatOverrides(k3.c0 c0Var, k3.d dVar, Class<?> cls) {
        return dVar != null ? dVar.a(c0Var.k(), cls) : c0Var.a0(cls);
    }

    public r.b findIncludeOverrides(k3.c0 c0Var, k3.d dVar, Class<?> cls) {
        return dVar != null ? dVar.b(c0Var.k(), cls) : c0Var.b0(cls);
    }

    public a4.m findPropertyFilter(k3.c0 c0Var, Object obj, Object obj2) {
        c0Var.c0();
        c0Var.p(handledType(), "Cannot resolve PropertyFilter with id '" + obj + "'; no FilterProvider configured");
        throw null;
    }

    public k3.m getSchema(k3.c0 c0Var, Type type) {
        return createSchemaNode("string");
    }

    @Override // k3.o
    public Class<Object> handledType() {
        return this._handledType;
    }

    public boolean isDefaultSerializer(k3.o oVar) {
        return d4.h.O(oVar);
    }

    @Override // k3.o
    public abstract void serialize(Object obj, c3.h hVar, k3.c0 c0Var);

    public void visitArrayFormat(u3.f fVar, k3.j jVar, k3.o oVar, k3.j jVar2) {
        fVar.g(jVar);
        if (_neitherNull(null, oVar)) {
            throw null;
        }
    }

    public void visitFloatFormat(u3.f fVar, k3.j jVar, k.b bVar) {
        fVar.h(jVar);
    }

    public void visitIntFormat(u3.f fVar, k3.j jVar, k.b bVar) {
        fVar.e(jVar);
        if (_neitherNull(null, bVar)) {
            throw null;
        }
    }

    public void visitStringFormat(u3.f fVar, k3.j jVar) {
        fVar.a(jVar);
    }

    public void wrapAndThrow(k3.c0 c0Var, Throwable th, Object obj, String str) {
        while ((th instanceof InvocationTargetException) && th.getCause() != null) {
            th = th.getCause();
        }
        d4.h.h0(th);
        boolean z10 = c0Var == null || c0Var.m0(k3.b0.WRAP_EXCEPTIONS);
        if (th instanceof IOException) {
            if (!z10 || !(th instanceof k3.l)) {
                throw ((IOException) th);
            }
        } else if (!z10) {
            d4.h.j0(th);
        }
        throw k3.l.q(th, obj, str);
    }

    public k3.m getSchema(k3.c0 c0Var, Type type, boolean z10) {
        z3.r rVar = (z3.r) getSchema(c0Var, type);
        if (!z10) {
            rVar.D("required", !z10);
        }
        return rVar;
    }

    public void visitStringFormat(u3.f fVar, k3.j jVar, u3.m mVar) {
        fVar.a(jVar);
    }

    public i0(k3.j jVar) {
        this._handledType = jVar.q();
    }

    public z3.r createSchemaNode(String str, boolean z10) {
        z3.r createSchemaNode = createSchemaNode(str);
        if (!z10) {
            createSchemaNode.D("required", !z10);
        }
        return createSchemaNode;
    }

    public void visitArrayFormat(u3.f fVar, k3.j jVar, u3.d dVar) {
        fVar.g(jVar);
    }

    public void visitIntFormat(u3.f fVar, k3.j jVar, k.b bVar, u3.m mVar) {
        fVar.e(jVar);
    }

    public i0(Class cls, boolean z10) {
        this._handledType = cls;
    }

    public i0(i0 i0Var) {
        this._handledType = i0Var._handledType;
    }

    public void wrapAndThrow(k3.c0 c0Var, Throwable th, Object obj, int i10) {
        while ((th instanceof InvocationTargetException) && th.getCause() != null) {
            th = th.getCause();
        }
        d4.h.h0(th);
        boolean z10 = c0Var == null || c0Var.m0(k3.b0.WRAP_EXCEPTIONS);
        if (th instanceof IOException) {
            if (!z10 || !(th instanceof k3.l)) {
                throw ((IOException) th);
            }
        } else if (!z10) {
            d4.h.j0(th);
        }
        throw k3.l.p(th, obj, i10);
    }
}
