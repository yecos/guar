package com.fasterxml.jackson.databind.ser.std;

import java.lang.reflect.Type;

/* loaded from: classes.dex */
public final class j0 extends h0 {
    public j0() {
        super(String.class, false);
    }

    @Override // com.fasterxml.jackson.databind.ser.std.h0, com.fasterxml.jackson.databind.ser.std.i0, k3.o
    public void acceptJsonFormatVisitor(u3.f fVar, k3.j jVar) {
        visitStringFormat(fVar, jVar);
    }

    @Override // com.fasterxml.jackson.databind.ser.std.h0, com.fasterxml.jackson.databind.ser.std.i0, v3.c
    public k3.m getSchema(k3.c0 c0Var, Type type) {
        return createSchemaNode("string", true);
    }

    @Override // k3.o
    public boolean isEmpty(k3.c0 c0Var, Object obj) {
        return ((String) obj).isEmpty();
    }

    @Override // com.fasterxml.jackson.databind.ser.std.i0, k3.o
    public void serialize(Object obj, c3.h hVar, k3.c0 c0Var) {
        hVar.z0((String) obj);
    }

    @Override // com.fasterxml.jackson.databind.ser.std.h0, k3.o
    public final void serializeWithType(Object obj, c3.h hVar, k3.c0 c0Var, w3.h hVar2) {
        hVar.z0((String) obj);
    }
}
