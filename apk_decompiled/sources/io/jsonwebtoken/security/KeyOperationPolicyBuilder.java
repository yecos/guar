package io.jsonwebtoken.security;

import io.jsonwebtoken.lang.Builder;
import io.jsonwebtoken.lang.CollectionMutator;
import java.util.Collection;

/* loaded from: classes3.dex */
public interface KeyOperationPolicyBuilder extends CollectionMutator<KeyOperation, KeyOperationPolicyBuilder>, Builder<KeyOperationPolicy> {
    KeyOperationPolicyBuilder add(KeyOperation keyOperation);

    @Override // io.jsonwebtoken.lang.CollectionMutator
    KeyOperationPolicyBuilder add(Collection<? extends KeyOperation> collection);

    KeyOperationPolicyBuilder unrelated();
}
