package com.fasterxml.jackson.databind.ser.std;

import b3.k;
import c3.k;
import java.lang.reflect.Type;

/* loaded from: classes.dex */
public final class e extends h0 implements a4.i {

    /* renamed from: a, reason: collision with root package name */
    public final boolean f6685a;

    public static final class a extends h0 implements a4.i {

        /* renamed from: a, reason: collision with root package name */
        public final boolean f6686a;

        public a(boolean z10) {
            super(z10 ? Boolean.TYPE : Boolean.class, false);
            this.f6686a = z10;
        }

        @Override // com.fasterxml.jackson.databind.ser.std.h0, com.fasterxml.jackson.databind.ser.std.i0, k3.o
        public void acceptJsonFormatVisitor(u3.f fVar, k3.j jVar) {
            visitIntFormat(fVar, jVar, k.b.INT);
        }

        @Override // a4.i
        public k3.o b(k3.c0 c0Var, k3.d dVar) {
            k.d findFormatOverrides = findFormatOverrides(c0Var, dVar, Boolean.class);
            return (findFormatOverrides == null || findFormatOverrides.i().a()) ? this : new e(this.f6686a);
        }

        @Override // com.fasterxml.jackson.databind.ser.std.i0, k3.o
        public void serialize(Object obj, c3.h hVar, k3.c0 c0Var) {
            hVar.d0(!Boolean.FALSE.equals(obj) ? 1 : 0);
        }

        @Override // com.fasterxml.jackson.databind.ser.std.h0, k3.o
        public final void serializeWithType(Object obj, c3.h hVar, k3.c0 c0Var, w3.h hVar2) {
            hVar.U(Boolean.TRUE.equals(obj));
        }
    }

    public e(boolean z10) {
        super(z10 ? Boolean.TYPE : Boolean.class, false);
        this.f6685a = z10;
    }

    @Override // com.fasterxml.jackson.databind.ser.std.h0, com.fasterxml.jackson.databind.ser.std.i0, k3.o
    public void acceptJsonFormatVisitor(u3.f fVar, k3.j jVar) {
        fVar.d(jVar);
    }

    @Override // a4.i
    public k3.o b(k3.c0 c0Var, k3.d dVar) {
        k.d findFormatOverrides = findFormatOverrides(c0Var, dVar, Boolean.class);
        return (findFormatOverrides == null || !findFormatOverrides.i().a()) ? this : new a(this.f6685a);
    }

    @Override // com.fasterxml.jackson.databind.ser.std.h0, com.fasterxml.jackson.databind.ser.std.i0, v3.c
    public k3.m getSchema(k3.c0 c0Var, Type type) {
        return createSchemaNode("boolean", !this.f6685a);
    }

    @Override // com.fasterxml.jackson.databind.ser.std.i0, k3.o
    public void serialize(Object obj, c3.h hVar, k3.c0 c0Var) {
        hVar.U(Boolean.TRUE.equals(obj));
    }

    @Override // com.fasterxml.jackson.databind.ser.std.h0, k3.o
    public final void serializeWithType(Object obj, c3.h hVar, k3.c0 c0Var, w3.h hVar2) {
        hVar.U(Boolean.TRUE.equals(obj));
    }
}
