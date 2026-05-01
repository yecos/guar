package io.jsonwebtoken;

import io.jsonwebtoken.ProtectedHeaderMutator;
import io.jsonwebtoken.lang.NestedCollection;
import io.jsonwebtoken.security.PublicJwk;
import io.jsonwebtoken.security.X509Mutator;
import java.net.URI;

/* loaded from: classes3.dex */
public interface ProtectedHeaderMutator<T extends ProtectedHeaderMutator<T>> extends HeaderMutator<T>, X509Mutator<T> {
    NestedCollection<String, T> critical();

    T jwk(PublicJwk<?> publicJwk);

    T jwkSetUrl(URI uri);

    T keyId(String str);

    @Deprecated
    T setAlgorithm(String str);

    @Deprecated
    T setKeyId(String str);
}
