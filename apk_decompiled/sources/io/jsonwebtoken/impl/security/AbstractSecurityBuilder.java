package io.jsonwebtoken.impl.security;

import io.jsonwebtoken.security.SecurityBuilder;
import java.security.Provider;
import java.security.SecureRandom;

/* loaded from: classes3.dex */
abstract class AbstractSecurityBuilder<T, B extends SecurityBuilder<T, B>> implements SecurityBuilder<T, B> {
    protected Provider provider;
    protected SecureRandom random;

    @Override // io.jsonwebtoken.security.SecurityBuilder
    public B provider(Provider provider) {
        this.provider = provider;
        return self();
    }

    @Override // io.jsonwebtoken.security.SecurityBuilder
    public B random(SecureRandom secureRandom) {
        if (secureRandom == null) {
            secureRandom = Randoms.secureRandom();
        }
        this.random = secureRandom;
        return self();
    }

    public final B self() {
        return this;
    }
}
