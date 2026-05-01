package io.jsonwebtoken.impl.io;

import java.io.InputStream;

/* loaded from: classes3.dex */
public class Base64InputStream extends BaseNCodecInputStream {
    public Base64InputStream(InputStream inputStream) {
        this(inputStream, false);
    }

    @Override // io.jsonwebtoken.impl.io.BaseNCodecInputStream, java.io.FilterInputStream, java.io.InputStream
    public /* bridge */ /* synthetic */ int available() {
        return super.available();
    }

    @Override // io.jsonwebtoken.impl.io.BaseNCodecInputStream
    public /* bridge */ /* synthetic */ boolean isStrictDecoding() {
        return super.isStrictDecoding();
    }

    @Override // io.jsonwebtoken.impl.io.BaseNCodecInputStream, java.io.FilterInputStream, java.io.InputStream
    public /* bridge */ /* synthetic */ void mark(int i10) {
        super.mark(i10);
    }

    @Override // io.jsonwebtoken.impl.io.BaseNCodecInputStream, java.io.FilterInputStream, java.io.InputStream
    public /* bridge */ /* synthetic */ boolean markSupported() {
        return super.markSupported();
    }

    @Override // io.jsonwebtoken.impl.io.BaseNCodecInputStream, java.io.FilterInputStream, java.io.InputStream
    public /* bridge */ /* synthetic */ int read() {
        return super.read();
    }

    @Override // io.jsonwebtoken.impl.io.BaseNCodecInputStream, java.io.FilterInputStream, java.io.InputStream
    public /* bridge */ /* synthetic */ void reset() {
        super.reset();
    }

    @Override // io.jsonwebtoken.impl.io.BaseNCodecInputStream, java.io.FilterInputStream, java.io.InputStream
    public /* bridge */ /* synthetic */ long skip(long j10) {
        return super.skip(j10);
    }

    public Base64InputStream(InputStream inputStream, boolean z10) {
        super(inputStream, new Base64Codec(0, BaseNCodec.CHUNK_SEPARATOR, false, CodecPolicy.STRICT), z10);
    }

    @Override // io.jsonwebtoken.impl.io.BaseNCodecInputStream, java.io.FilterInputStream, java.io.InputStream
    public /* bridge */ /* synthetic */ int read(byte[] bArr, int i10, int i11) {
        return super.read(bArr, i10, i11);
    }
}
