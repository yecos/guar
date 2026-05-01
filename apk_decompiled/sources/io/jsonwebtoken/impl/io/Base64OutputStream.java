package io.jsonwebtoken.impl.io;

import java.io.OutputStream;

/* loaded from: classes3.dex */
class Base64OutputStream extends BaseNCodecOutputStream {
    public Base64OutputStream(OutputStream outputStream) {
        this(outputStream, true, true);
    }

    public Base64OutputStream(OutputStream outputStream, boolean z10, boolean z11) {
        super(outputStream, new Base64Codec(0, BaseNCodec.CHUNK_SEPARATOR, z11), z10);
    }

    public Base64OutputStream(OutputStream outputStream, boolean z10, int i10, byte[] bArr) {
        super(outputStream, new Base64Codec(i10, bArr), z10);
    }

    public Base64OutputStream(OutputStream outputStream, boolean z10, int i10, byte[] bArr, CodecPolicy codecPolicy) {
        super(outputStream, new Base64Codec(i10, bArr, false, codecPolicy), z10);
    }
}
