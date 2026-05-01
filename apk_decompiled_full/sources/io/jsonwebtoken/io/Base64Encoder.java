package io.jsonwebtoken.io;

import io.jsonwebtoken.lang.Assert;

/* loaded from: classes3.dex */
class Base64Encoder extends Base64Support implements Encoder<byte[], String> {
    public Base64Encoder() {
        this(Base64.DEFAULT);
    }

    public Base64Encoder(Base64 base64) {
        super(base64);
    }

    @Override // io.jsonwebtoken.io.Encoder
    public String encode(byte[] bArr) {
        Assert.notNull(bArr, "byte array argument cannot be null");
        return this.base64.encodeToString(bArr, false);
    }
}
