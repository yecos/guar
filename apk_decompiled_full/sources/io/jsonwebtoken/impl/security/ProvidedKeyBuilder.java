package io.jsonwebtoken.impl.security;

import io.jsonwebtoken.lang.Assert;
import io.jsonwebtoken.security.KeyBuilder;
import java.security.Key;

/* loaded from: classes3.dex */
abstract class ProvidedKeyBuilder<K extends Key, B extends KeyBuilder<K, B>> extends AbstractSecurityBuilder<K, B> implements KeyBuilder<K, B> {
    protected final K key;

    public ProvidedKeyBuilder(K k10) {
        this.key = (K) Assert.notNull(k10, "Key cannot be null.");
    }

    public abstract K doBuild();

    @Override // io.jsonwebtoken.lang.Builder
    public final K build() {
        K k10 = this.key;
        return k10 instanceof ProviderKey ? k10 : doBuild();
    }
}
