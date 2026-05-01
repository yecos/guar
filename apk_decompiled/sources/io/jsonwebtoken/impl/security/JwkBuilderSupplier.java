package io.jsonwebtoken.impl.security;

import io.jsonwebtoken.lang.Supplier;
import io.jsonwebtoken.security.DynamicJwkBuilder;
import io.jsonwebtoken.security.Jwks;
import io.jsonwebtoken.security.KeyOperationPolicy;
import java.security.Provider;

/* loaded from: classes3.dex */
public class JwkBuilderSupplier implements Supplier<DynamicJwkBuilder<?, ?>> {
    public static final JwkBuilderSupplier DEFAULT = new JwkBuilderSupplier(null, null);
    private final KeyOperationPolicy operationPolicy;
    private final Provider provider;

    public JwkBuilderSupplier(Provider provider, KeyOperationPolicy keyOperationPolicy) {
        this.provider = provider;
        this.operationPolicy = keyOperationPolicy;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // io.jsonwebtoken.lang.Supplier
    public DynamicJwkBuilder<?, ?> get() {
        DynamicJwkBuilder<?, ?> dynamicJwkBuilder = (DynamicJwkBuilder) Jwks.builder().provider(this.provider);
        KeyOperationPolicy keyOperationPolicy = this.operationPolicy;
        if (keyOperationPolicy != null) {
            dynamicJwkBuilder.mo91operationPolicy(keyOperationPolicy);
        }
        return dynamicJwkBuilder;
    }
}
