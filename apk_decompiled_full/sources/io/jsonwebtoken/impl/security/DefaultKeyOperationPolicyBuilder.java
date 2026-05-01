package io.jsonwebtoken.impl.security;

import io.jsonwebtoken.impl.lang.DefaultCollectionMutator;
import io.jsonwebtoken.lang.Collections;
import io.jsonwebtoken.security.Jwks;
import io.jsonwebtoken.security.KeyOperation;
import io.jsonwebtoken.security.KeyOperationPolicy;
import io.jsonwebtoken.security.KeyOperationPolicyBuilder;
import java.util.Collection;

/* loaded from: classes3.dex */
public class DefaultKeyOperationPolicyBuilder extends DefaultCollectionMutator<KeyOperation, KeyOperationPolicyBuilder> implements KeyOperationPolicyBuilder {
    private boolean unrelated;

    public DefaultKeyOperationPolicyBuilder() {
        super(Jwks.OP.get().values());
        this.unrelated = false;
    }

    @Override // io.jsonwebtoken.security.KeyOperationPolicyBuilder
    public /* bridge */ /* synthetic */ KeyOperationPolicyBuilder add(KeyOperation keyOperation) {
        return (KeyOperationPolicyBuilder) super.add((DefaultKeyOperationPolicyBuilder) keyOperation);
    }

    @Override // io.jsonwebtoken.security.KeyOperationPolicyBuilder
    public KeyOperationPolicyBuilder unrelated() {
        this.unrelated = true;
        return this;
    }

    @Override // io.jsonwebtoken.impl.lang.DefaultCollectionMutator, io.jsonwebtoken.lang.CollectionMutator
    public /* bridge */ /* synthetic */ KeyOperationPolicyBuilder add(Collection<? extends KeyOperation> collection) {
        return (KeyOperationPolicyBuilder) super.add((Collection) collection);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // io.jsonwebtoken.lang.Builder
    public KeyOperationPolicy build() {
        return new DefaultKeyOperationPolicy(Collections.immutable(getCollection()), this.unrelated);
    }
}
