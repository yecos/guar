package io.jsonwebtoken.impl.security;

import io.jsonwebtoken.lang.Assert;
import io.jsonwebtoken.security.DecryptionKeyRequest;
import io.jsonwebtoken.security.KeyAlgorithm;
import io.jsonwebtoken.security.KeyRequest;
import io.jsonwebtoken.security.KeyResult;
import javax.crypto.SecretKey;

/* loaded from: classes3.dex */
public class DirectKeyAlgorithm implements KeyAlgorithm<SecretKey, SecretKey> {
    static final String ID = "dir";

    @Override // io.jsonwebtoken.security.KeyAlgorithm
    public SecretKey getDecryptionKey(DecryptionKeyRequest<SecretKey> decryptionKeyRequest) {
        Assert.notNull(decryptionKeyRequest, "request cannot be null.");
        return (SecretKey) Assert.notNull(decryptionKeyRequest.getKey(), "Decryption key cannot be null.");
    }

    @Override // io.jsonwebtoken.security.KeyAlgorithm
    public KeyResult getEncryptionKey(KeyRequest<SecretKey> keyRequest) {
        Assert.notNull(keyRequest, "request cannot be null.");
        return new DefaultKeyResult((SecretKey) Assert.notNull(keyRequest.getPayload(), "Encryption key cannot be null."));
    }

    @Override // io.jsonwebtoken.Identifiable
    public String getId() {
        return ID;
    }
}
