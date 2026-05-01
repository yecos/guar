package io.jsonwebtoken.impl.security;

import io.jsonwebtoken.lang.Assert;
import io.jsonwebtoken.security.VerifyDigestRequest;
import java.io.InputStream;
import java.security.Provider;
import java.security.SecureRandom;

/* loaded from: classes3.dex */
public class DefaultVerifyDigestRequest extends DefaultRequest<InputStream> implements VerifyDigestRequest {
    private final byte[] digest;

    public DefaultVerifyDigestRequest(InputStream inputStream, Provider provider, SecureRandom secureRandom, byte[] bArr) {
        super(inputStream, provider, secureRandom);
        this.digest = Assert.notEmpty(bArr, "Digest byte array cannot be null or empty.");
    }

    @Override // io.jsonwebtoken.security.DigestSupplier
    public byte[] getDigest() {
        return this.digest;
    }
}
