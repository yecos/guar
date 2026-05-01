package io.jsonwebtoken.impl.security;

import io.jsonwebtoken.lang.Assert;
import io.jsonwebtoken.security.AeadResult;
import io.jsonwebtoken.security.DigestSupplier;
import io.jsonwebtoken.security.IvSupplier;
import java.io.OutputStream;

/* loaded from: classes3.dex */
public class DefaultAeadResult implements AeadResult, DigestSupplier, IvSupplier {
    private byte[] iv;
    private final OutputStream out;
    private byte[] tag;

    public DefaultAeadResult(OutputStream outputStream) {
        this.out = (OutputStream) Assert.notNull(outputStream, "OutputStream cannot be null.");
    }

    @Override // io.jsonwebtoken.security.DigestSupplier
    public byte[] getDigest() {
        return this.tag;
    }

    @Override // io.jsonwebtoken.security.IvSupplier
    public byte[] getIv() {
        return this.iv;
    }

    @Override // io.jsonwebtoken.security.AeadResult
    public OutputStream getOutputStream() {
        return this.out;
    }

    @Override // io.jsonwebtoken.security.AeadResult
    public AeadResult setIv(byte[] bArr) {
        this.iv = Assert.notEmpty(bArr, "Initialization Vector cannot be null or empty.");
        return this;
    }

    @Override // io.jsonwebtoken.security.AeadResult
    public AeadResult setTag(byte[] bArr) {
        this.tag = Assert.notEmpty(bArr, "Authentication Tag cannot be null or empty.");
        return this;
    }
}
