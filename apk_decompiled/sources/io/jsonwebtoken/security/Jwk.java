package io.jsonwebtoken.security;

import io.jsonwebtoken.Identifiable;
import java.security.Key;
import java.util.Map;
import java.util.Set;

/* loaded from: classes3.dex */
public interface Jwk<K extends Key> extends Identifiable, Map<String, Object> {
    String getAlgorithm();

    Set<KeyOperation> getOperations();

    String getType();

    JwkThumbprint thumbprint();

    JwkThumbprint thumbprint(HashAlgorithm hashAlgorithm);

    K toKey();
}
