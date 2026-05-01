package io.jsonwebtoken.impl.security;

import io.jsonwebtoken.JweHeader;
import io.jsonwebtoken.lang.Assert;
import io.jsonwebtoken.security.AeadAlgorithm;
import io.jsonwebtoken.security.KeyRequest;
import java.security.Provider;
import java.security.SecureRandom;

/* loaded from: classes3.dex */
public class DefaultKeyRequest<T> extends DefaultRequest<T> implements KeyRequest<T> {
    private final AeadAlgorithm encryptionAlgorithm;
    private final JweHeader header;

    public DefaultKeyRequest(T t10, Provider provider, SecureRandom secureRandom, JweHeader jweHeader, AeadAlgorithm aeadAlgorithm) {
        super(t10, provider, secureRandom);
        this.header = (JweHeader) Assert.notNull(jweHeader, "JweHeader/Builder cannot be null.");
        this.encryptionAlgorithm = (AeadAlgorithm) Assert.notNull(aeadAlgorithm, "AeadAlgorithm argument cannot be null.");
    }

    @Override // io.jsonwebtoken.security.KeyRequest
    public AeadAlgorithm getEncryptionAlgorithm() {
        return this.encryptionAlgorithm;
    }

    @Override // io.jsonwebtoken.security.KeyRequest
    public JweHeader getHeader() {
        return this.header;
    }
}
