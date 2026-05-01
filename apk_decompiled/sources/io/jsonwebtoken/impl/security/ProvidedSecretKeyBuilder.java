package io.jsonwebtoken.impl.security;

import io.jsonwebtoken.security.Password;
import io.jsonwebtoken.security.SecretKeyBuilder;
import java.security.Provider;
import javax.crypto.SecretKey;

/* loaded from: classes3.dex */
class ProvidedSecretKeyBuilder extends ProvidedKeyBuilder<SecretKey, SecretKeyBuilder> implements SecretKeyBuilder {
    public ProvidedSecretKeyBuilder(SecretKey secretKey) {
        super(secretKey);
    }

    @Override // io.jsonwebtoken.impl.security.ProvidedKeyBuilder
    public SecretKey doBuild() {
        K k10 = this.key;
        if (k10 instanceof Password) {
            return (SecretKey) k10;
        }
        Provider provider = this.provider;
        return provider != null ? new ProviderSecretKey(provider, (SecretKey) k10) : (SecretKey) k10;
    }
}
