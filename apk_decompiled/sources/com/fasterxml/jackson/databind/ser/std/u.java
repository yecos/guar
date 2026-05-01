package com.fasterxml.jackson.databind.ser.std;

import java.lang.reflect.Type;

/* loaded from: classes.dex */
public class u extends i0 {

    /* renamed from: a, reason: collision with root package name */
    public static final u f6730a = new u();

    public u() {
        super(Object.class);
    }

    @Override // com.fasterxml.jackson.databind.ser.std.i0, k3.o
    public void acceptJsonFormatVisitor(u3.f fVar, k3.j jVar) {
        fVar.f(jVar);
    }

    @Override // com.fasterxml.jackson.databind.ser.std.i0, v3.c
    public k3.m getSchema(k3.c0 c0Var, Type type) {
        return createSchemaNode("null");
    }

    @Override // com.fasterxml.jackson.databind.ser.std.i0, k3.o
    public void serialize(Object obj, c3.h hVar, k3.c0 c0Var) {
        hVar.a0();
    }

    @Override // k3.o
    public void serializeWithType(Object obj, c3.h hVar, k3.c0 c0Var, w3.h hVar2) {
        hVar.a0();
    }
}
