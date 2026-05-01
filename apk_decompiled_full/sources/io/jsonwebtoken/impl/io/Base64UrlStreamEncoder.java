package io.jsonwebtoken.impl.io;

import io.jsonwebtoken.io.Encoder;
import java.io.OutputStream;

/* loaded from: classes3.dex */
public final class Base64UrlStreamEncoder implements Encoder<OutputStream, OutputStream> {
    public static final Base64UrlStreamEncoder INSTANCE = new Base64UrlStreamEncoder();

    private Base64UrlStreamEncoder() {
    }

    @Override // io.jsonwebtoken.io.Encoder
    public OutputStream encode(OutputStream outputStream) {
        return new Base64OutputStream(outputStream);
    }
}
