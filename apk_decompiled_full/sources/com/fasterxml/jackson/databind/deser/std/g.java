package com.fasterxml.jackson.databind.deser.std;

import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public class g extends e0 {
    public g() {
        super(ByteBuffer.class);
    }

    @Override // k3.k
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public ByteBuffer deserialize(c3.k kVar, k3.g gVar) {
        return ByteBuffer.wrap(kVar.u());
    }

    @Override // com.fasterxml.jackson.databind.deser.std.e0, k3.k
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public ByteBuffer deserialize(c3.k kVar, k3.g gVar, ByteBuffer byteBuffer) {
        d4.g gVar2 = new d4.g(byteBuffer);
        kVar.w0(gVar.M(), gVar2);
        gVar2.close();
        return byteBuffer;
    }

    @Override // com.fasterxml.jackson.databind.deser.std.e0, k3.k
    public c4.f logicalType() {
        return c4.f.Binary;
    }
}
