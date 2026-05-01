package io.jsonwebtoken.impl.security;

import io.jsonwebtoken.impl.lang.Bytes;
import io.jsonwebtoken.lang.Assert;
import io.jsonwebtoken.security.KeyResult;
import javax.crypto.SecretKey;

/* loaded from: classes3.dex */
public class DefaultKeyResult extends DefaultMessage<byte[]> implements KeyResult {
    private final SecretKey key;

    public DefaultKeyResult(SecretKey secretKey) {
        this(secretKey, Bytes.EMPTY);
    }

    @Override // io.jsonwebtoken.impl.security.DefaultMessage
    public void assertBytePayload(byte[] bArr) {
        Assert.notNull(bArr, "encrypted key bytes cannot be null (but may be empty.");
    }

    public DefaultKeyResult(SecretKey secretKey, byte[] bArr) {
        super(bArr);
        this.key = (SecretKey) Assert.notNull(secretKey, "Content Encryption Key cannot be null.");
    }

    @Override // io.jsonwebtoken.security.KeySupplier
    public SecretKey getKey() {
        return this.key;
    }
}
