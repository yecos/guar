package com.fasterxml.jackson.databind.ser.std;

import java.lang.reflect.Type;

/* loaded from: classes.dex */
public abstract class m0 extends i0 {
    public m0(Class cls) {
        super(cls, false);
    }

    @Override // com.fasterxml.jackson.databind.ser.std.i0, k3.o
    public void acceptJsonFormatVisitor(u3.f fVar, k3.j jVar) {
        visitStringFormat(fVar, jVar);
    }

    public abstract String c(Object obj);

    @Override // com.fasterxml.jackson.databind.ser.std.i0, v3.c
    public k3.m getSchema(k3.c0 c0Var, Type type) {
        return createSchemaNode("string", true);
    }

    @Override // k3.o
    public boolean isEmpty(k3.c0 c0Var, Object obj) {
        return c(obj).isEmpty();
    }

    @Override // com.fasterxml.jackson.databind.ser.std.i0, k3.o
    public void serialize(Object obj, c3.h hVar, k3.c0 c0Var) {
        hVar.z0(c(obj));
    }

    @Override // k3.o
    public void serializeWithType(Object obj, c3.h hVar, k3.c0 c0Var, w3.h hVar2) {
        i3.b g10 = hVar2.g(hVar, hVar2.d(obj, c3.n.VALUE_STRING));
        serialize(obj, hVar, c0Var);
        hVar2.h(hVar, g10);
    }
}
