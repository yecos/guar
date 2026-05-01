package com.fasterxml.jackson.databind.ser.std;

import java.lang.reflect.Type;

/* loaded from: classes.dex */
public class f extends i0 {
    public f() {
        super(byte[].class);
    }

    @Override // com.fasterxml.jackson.databind.ser.std.i0, k3.o
    public void acceptJsonFormatVisitor(u3.f fVar, k3.j jVar) {
        fVar.g(jVar);
    }

    @Override // k3.o
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public boolean isEmpty(k3.c0 c0Var, byte[] bArr) {
        return bArr.length == 0;
    }

    @Override // com.fasterxml.jackson.databind.ser.std.i0, k3.o
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public void serialize(byte[] bArr, c3.h hVar, k3.c0 c0Var) {
        hVar.R(c0Var.k().h(), bArr, 0, bArr.length);
    }

    @Override // k3.o
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public void serializeWithType(byte[] bArr, c3.h hVar, k3.c0 c0Var, w3.h hVar2) {
        i3.b g10 = hVar2.g(hVar, hVar2.d(bArr, c3.n.VALUE_EMBEDDED_OBJECT));
        hVar.R(c0Var.k().h(), bArr, 0, bArr.length);
        hVar2.h(hVar, g10);
    }

    @Override // com.fasterxml.jackson.databind.ser.std.i0, v3.c
    public k3.m getSchema(k3.c0 c0Var, Type type) {
        return createSchemaNode("array", true).G("items", createSchemaNode("byte"));
    }
}
