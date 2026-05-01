package com.fasterxml.jackson.databind.ser.std;

import b3.k;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.Objects;

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
    */
    public k3.o b(k3.c0 c0Var, k3.d dVar) {
        k3.o oVar;
        k3.o findContextualConvertingSerializer;
        Object g10;
        if (dVar != null) {
            k3.b W = c0Var.W();
            r3.i d10 = dVar.d();
            if (d10 != null && (g10 = W.g(d10)) != null) {
                oVar = c0Var.t0(d10, g10);
                k.d findFormatOverrides = findFormatOverrides(c0Var, dVar, handledType());
                Boolean e10 = findFormatOverrides == null ? findFormatOverrides.e(k.a.WRITE_SINGLE_ELEM_ARRAYS_UNWRAPPED) : null;
                findContextualConvertingSerializer = findContextualConvertingSerializer(c0Var, dVar, oVar);
                if (findContextualConvertingSerializer == null) {
                    findContextualConvertingSerializer = c0Var.G(String.class, dVar);
                }
                return !isDefaultSerializer(findContextualConvertingSerializer) ? Objects.equals(e10, this.f6663a) ? this : c(dVar, e10) : new j(c0Var.i(String.class), true, null, findContextualConvertingSerializer);
            }
        }
        oVar = null;
        k.d findFormatOverrides2 = findFormatOverrides(c0Var, dVar, handledType());
        if (findFormatOverrides2 == null) {
        }
        findContextualConvertingSerializer = findContextualConvertingSerializer(c0Var, dVar, oVar);
        if (findContextualConvertingSerializer == null) {
        }
        if (!isDefaultSerializer(findContextualConvertingSerializer)) {
        }
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
