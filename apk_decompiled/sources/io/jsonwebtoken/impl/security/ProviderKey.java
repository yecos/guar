package io.jsonwebtoken.impl.security;

import io.jsonwebtoken.lang.Assert;
import io.jsonwebtoken.security.KeySupplier;
import java.security.Key;
import java.security.Provider;

/* loaded from: classes3.dex */
public class ProviderKey<T extends Key> implements Key, KeySupplier<T> {
    private final T key;
    private final Provider provider;

    public ProviderKey(Provider provider, T t10) {
        this.provider = (Provider) Assert.notNull(provider, "Provider cannot be null.");
        this.key = (T) Assert.notNull(t10, "Key argument cannot be null.");
        if (t10 instanceof ProviderKey) {
            throw new IllegalArgumentException("Nesting not permitted.");
        }
    }

    public static <K extends Key> K getKey(K k10) {
        return k10 instanceof ProviderKey ? (K) ((ProviderKey) k10).getKey() : k10;
    }

    public static Provider getProvider(Key key, Provider provider) {
        return key instanceof ProviderKey ? (Provider) Assert.stateNotNull(((ProviderKey) key).getProvider(), "ProviderKey provider can never be null.") : provider;
    }

    @Override // java.security.Key
    public String getAlgorithm() {
        return this.key.getAlgorithm();
    }

    @Override // java.security.Key
    public byte[] getEncoded() {
        return this.key.getEncoded();
    }

    @Override // java.security.Key
    public String getFormat() {
        return this.key.getFormat();
    }

    @Override // io.jsonwebtoken.security.KeySupplier
    public T getKey() {
        return this.key;
    }

    public final Provider getProvider() {
        return this.provider;
    }
}
