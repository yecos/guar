package io.jsonwebtoken.impl.security;

import io.jsonwebtoken.security.Request;
import java.security.Provider;
import java.security.SecureRandom;

/* loaded from: classes3.dex */
public class DefaultRequest<T> extends DefaultMessage<T> implements Request<T> {
    private final Provider provider;
    private final SecureRandom secureRandom;

    public DefaultRequest(T t10, Provider provider, SecureRandom secureRandom) {
        super(t10);
        this.provider = provider;
        this.secureRandom = secureRandom;
    }

    @Override // io.jsonwebtoken.impl.security.DefaultMessage, io.jsonwebtoken.security.Message
    public /* bridge */ /* synthetic */ Object getPayload() {
        return super.getPayload();
    }

    @Override // io.jsonwebtoken.security.Request
    public Provider getProvider() {
        return this.provider;
    }

    @Override // io.jsonwebtoken.security.Request
    public SecureRandom getSecureRandom() {
        return this.secureRandom;
    }
}
