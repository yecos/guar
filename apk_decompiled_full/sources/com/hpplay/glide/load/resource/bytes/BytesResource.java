package com.hpplay.glide.load.resource.bytes;

import com.hpplay.glide.load.engine.Resource;

/* loaded from: classes2.dex */
public class BytesResource implements Resource<byte[]> {
    private final byte[] bytes;

    public BytesResource(byte[] bArr) {
        if (bArr == null) {
            throw new NullPointerException("Bytes must not be null");
        }
        this.bytes = bArr;
    }

    @Override // com.hpplay.glide.load.engine.Resource
    public int getSize() {
        return this.bytes.length;
    }

    @Override // com.hpplay.glide.load.engine.Resource
    public void recycle() {
    }

    @Override // com.hpplay.glide.load.engine.Resource
    public byte[] get() {
        return this.bytes;
    }
}
