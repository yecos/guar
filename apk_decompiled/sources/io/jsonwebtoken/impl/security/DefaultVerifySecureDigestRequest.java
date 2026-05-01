package io.jsonwebtoken.impl.security;

import io.jsonwebtoken.lang.Assert;
import io.jsonwebtoken.security.VerifySecureDigestRequest;
import java.io.InputStream;
import java.security.Key;
import java.security.Provider;
import java.security.SecureRandom;

/* loaded from: classes3.dex */
public class DefaultVerifySecureDigestRequest<K extends Key> extends DefaultSecureRequest<InputStream, K> implements VerifySecureDigestRequest<K> {
    private final byte[] digest;

    public DefaultVerifySecureDigestRequest(InputStream inputStream, Provider provider, SecureRandom secureRandom, K k10, byte[] bArr) {
        super(inputStream, provider, secureRandom, k10);
        this.digest = Assert.notEmpty(bArr, "Digest byte array cannot be null or empty.");
    }

    @Override // io.jsonwebtoken.security.DigestSupplier
    public byte[] getDigest() {
        return this.digest;
    }
}
