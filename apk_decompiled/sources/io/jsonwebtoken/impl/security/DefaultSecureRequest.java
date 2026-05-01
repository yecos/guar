package io.jsonwebtoken.impl.security;

import io.jsonwebtoken.lang.Assert;
import io.jsonwebtoken.security.SecureRequest;
import java.security.Key;
import java.security.Provider;
import java.security.SecureRandom;

/* loaded from: classes3.dex */
public class DefaultSecureRequest<T, K extends Key> extends DefaultRequest<T> implements SecureRequest<T, K> {
    private final K KEY;

    public DefaultSecureRequest(T t10, Provider provider, SecureRandom secureRandom, K k10) {
        super(t10, provider, secureRandom);
        this.KEY = (K) Assert.notNull(k10, "key cannot be null.");
    }

    @Override // io.jsonwebtoken.security.KeySupplier
    public K getKey() {
        return this.KEY;
    }
}
