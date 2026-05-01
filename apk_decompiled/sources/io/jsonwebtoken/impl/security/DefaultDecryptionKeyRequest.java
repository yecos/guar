package io.jsonwebtoken.impl.security;

import io.jsonwebtoken.JweHeader;
import io.jsonwebtoken.lang.Assert;
import io.jsonwebtoken.security.AeadAlgorithm;
import io.jsonwebtoken.security.DecryptionKeyRequest;
import java.security.Key;
import java.security.Provider;
import java.security.SecureRandom;

/* loaded from: classes3.dex */
public class DefaultDecryptionKeyRequest<K extends Key> extends DefaultKeyRequest<byte[]> implements DecryptionKeyRequest<K> {
    private final K decryptionKey;

    public DefaultDecryptionKeyRequest(byte[] bArr, Provider provider, SecureRandom secureRandom, JweHeader jweHeader, AeadAlgorithm aeadAlgorithm, K k10) {
        super(bArr, provider, secureRandom, jweHeader, aeadAlgorithm);
        this.decryptionKey = (K) Assert.notNull(k10, "decryption key cannot be null.");
    }

    @Override // io.jsonwebtoken.impl.security.DefaultMessage
    public void assertBytePayload(byte[] bArr) {
        Assert.notNull(bArr, "encrypted key bytes cannot be null (but may be empty.");
    }

    @Override // io.jsonwebtoken.security.KeySupplier
    public K getKey() {
        return this.decryptionKey;
    }
}
