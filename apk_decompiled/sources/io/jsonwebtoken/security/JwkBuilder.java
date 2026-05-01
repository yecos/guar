package io.jsonwebtoken.security;

import io.jsonwebtoken.lang.MapMutator;
import io.jsonwebtoken.lang.NestedCollection;
import io.jsonwebtoken.security.Jwk;
import io.jsonwebtoken.security.JwkBuilder;
import java.security.Key;

/* loaded from: classes3.dex */
public interface JwkBuilder<K extends Key, J extends Jwk<K>, T extends JwkBuilder<K, J, T>> extends MapMutator<String, Object, T>, SecurityBuilder<J, T>, KeyOperationPolicied<T> {
    T algorithm(String str);

    T id(String str);

    T idFromThumbprint();

    T idFromThumbprint(HashAlgorithm hashAlgorithm);

    NestedCollection<KeyOperation, T> operations();
}
