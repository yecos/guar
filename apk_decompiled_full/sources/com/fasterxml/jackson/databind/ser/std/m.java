package com.fasterxml.jackson.databind.ser.std;

import b3.k;
import c3.k;
import java.lang.reflect.Type;
import java.util.Iterator;
import java.util.Objects;
import org.simpleframework.xml.strategy.Name;

/* loaded from: classes.dex */
public class m extends h0 implements a4.i {

    /* renamed from: a, reason: collision with root package name */
    public final d4.l f6698a;

    /* renamed from: b, reason: collision with root package name */
    public final Boolean f6699b;

    public m(d4.l lVar, Boolean bool) {
        super(lVar.c(), false);
        this.f6698a = lVar;
        this.f6699b = bool;
    }

    public static Boolean c(Class cls, k.d dVar, boolean z10, Boolean bool) {
        k.c i10 = dVar == null ? null : dVar.i();
        if (i10 == null) {
            return bool;
        }
        if (i10 == k.c.ANY || i10 == k.c.SCALAR) {
            return bool;
        }
        if (i10 == k.c.STRING || i10 == k.c.NATURAL) {
            return Boolean.FALSE;
        }
        if (i10.a() || i10 == k.c.ARRAY) {
            return Boolean.TRUE;
        }
        Object[] objArr = new Object[3];
        objArr[0] = i10;
        objArr[1] = cls.getName();
        objArr[2] = z10 ? Name.LABEL : "property";
        throw new IllegalArgumentException(String.format("Unsupported serialization shape (%s) for Enum %s, not supported as %s annotation", objArr));
    }

    public static m e(Class cls, k3.a0 a0Var, k3.c cVar, k.d dVar) {
        return new m(d4.l.b(a0Var, cls), c(cls, dVar, true, null));
    }

    @Override // com.fasterxml.jackson.databind.ser.std.h0, com.fasterxml.jackson.databind.ser.std.i0, k3.o
    public void acceptJsonFormatVisitor(u3.f fVar, k3.j jVar) {
        if (d(fVar.getProvider())) {
            visitIntFormat(fVar, jVar, k.b.INT);
        } else {
            fVar.a(jVar);
        }
    }

    @Override // a4.i
    public k3.o b(k3.c0 c0Var, k3.d dVar) {
        k.d findFormatOverrides = findFormatOverrides(c0Var, dVar, handledType());
        if (findFormatOverrides != null) {
            Boolean c10 = c(handledType(), findFormatOverrides, false, this.f6699b);
            if (!Objects.equals(c10, this.f6699b)) {
                return new m(this.f6698a, c10);
            }
        }
        return this;
    }

    public final boolean d(k3.c0 c0Var) {
        Boolean bool = this.f6699b;
        return bool != null ? bool.booleanValue() : c0Var.m0(k3.b0.WRITE_ENUMS_USING_INDEX);
    }

    @Override // com.fasterxml.jackson.databind.ser.std.i0, k3.o
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public final void serialize(Enum r22, c3.h hVar, k3.c0 c0Var) {
        if (d(c0Var)) {
            hVar.d0(r22.ordinal());
        } else if (c0Var.m0(k3.b0.WRITE_ENUMS_USING_TO_STRING)) {
            hVar.z0(r22.toString());
        } else {
            hVar.y0(this.f6698a.d(r22));
        }
    }

    @Override // com.fasterxml.jackson.databind.ser.std.h0, com.fasterxml.jackson.databind.ser.std.i0, v3.c
    public k3.m getSchema(k3.c0 c0Var, Type type) {
        if (d(c0Var)) {
            return createSchemaNode("integer", true);
        }
        z3.r createSchemaNode = createSchemaNode("string", true);
        if (type != null && c0Var.i(type).F()) {
            z3.a E = createSchemaNode.E("enum");
            Iterator it = this.f6698a.e().iterator();
            while (it.hasNext()) {
                E.B(((c3.q) it.next()).getValue());
            }
        }
        return createSchemaNode;
    }
}
