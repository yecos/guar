package com.fasterxml.jackson.databind.ser.std;

import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public class g extends h0 {
    public g() {
        super(ByteBuffer.class);
    }

    @Override // com.fasterxml.jackson.databind.ser.std.h0, com.fasterxml.jackson.databind.ser.std.i0, k3.o
    public void acceptJsonFormatVisitor(u3.f fVar, k3.j jVar) {
        fVar.g(jVar);
    }

    @Override // com.fasterxml.jackson.databind.ser.std.i0, k3.o
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public void serialize(ByteBuffer byteBuffer, c3.h hVar, k3.c0 c0Var) {
        if (byteBuffer.hasArray()) {
            int position = byteBuffer.position();
            hVar.T(byteBuffer.array(), byteBuffer.arrayOffset() + position, byteBuffer.limit() - position);
            return;
        }
        ByteBuffer asReadOnlyBuffer = byteBuffer.asReadOnlyBuffer();
        if (asReadOnlyBuffer.position() > 0) {
        }
        d4.f fVar = new d4.f(asReadOnlyBuffer);
        hVar.Q(fVar, asReadOnlyBuffer.remaining());
        fVar.close();
    }
}
