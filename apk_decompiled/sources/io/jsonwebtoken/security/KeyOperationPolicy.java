package io.jsonwebtoken.security;

import java.util.Collection;

/* loaded from: classes3.dex */
public interface KeyOperationPolicy {
    Collection<KeyOperation> getOperations();

    void validate(Collection<? extends KeyOperation> collection);
}
