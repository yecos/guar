package io.jsonwebtoken.io;

import io.jsonwebtoken.lang.Assert;

/* loaded from: classes3.dex */
class Base64Decoder extends Base64Support implements Decoder<CharSequence, byte[]> {
    public Base64Decoder() {
        super(Base64.DEFAULT);
    }

    public Base64Decoder(Base64 base64) {
        super(base64);
    }

    @Override // io.jsonwebtoken.io.Decoder
    public byte[] decode(CharSequence charSequence) {
        Assert.notNull(charSequence, "String argument cannot be null");
        return this.base64.decodeFast(charSequence);
    }
}
