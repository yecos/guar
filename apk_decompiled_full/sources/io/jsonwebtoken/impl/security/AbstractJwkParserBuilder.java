package io.jsonwebtoken.impl.security;

import io.jsonwebtoken.impl.io.AbstractParserBuilder;
import io.jsonwebtoken.io.ParserBuilder;
import io.jsonwebtoken.security.KeyOperationPolicied;
import io.jsonwebtoken.security.KeyOperationPolicy;

/* loaded from: classes3.dex */
abstract class AbstractJwkParserBuilder<T, B extends ParserBuilder<T, B> & KeyOperationPolicied<B>> extends AbstractParserBuilder<T, B> implements KeyOperationPolicied<B> {
    protected KeyOperationPolicy operationPolicy = AbstractJwkBuilder.DEFAULT_OPERATION_POLICY;

    @Override // io.jsonwebtoken.security.KeyOperationPolicied
    /* renamed from: operationPolicy, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ KeyOperationPolicied mo91operationPolicy(KeyOperationPolicy keyOperationPolicy) {
        return (KeyOperationPolicied) operationPolicy(keyOperationPolicy);
    }

    /* JADX WARN: Incorrect return type in method signature: (Lio/jsonwebtoken/security/KeyOperationPolicy;)TB; */
    /* JADX WARN: Type inference failed for: r1v1, types: [io.jsonwebtoken.io.ParserBuilder] */
    public ParserBuilder operationPolicy(KeyOperationPolicy keyOperationPolicy) {
        this.operationPolicy = keyOperationPolicy;
        return self();
    }
}
