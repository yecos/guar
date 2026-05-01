package io.jsonwebtoken.impl.security;

import io.jsonwebtoken.impl.lang.Parameter;
import io.jsonwebtoken.security.Jwk;
import io.jsonwebtoken.security.PublicJwk;
import java.security.PublicKey;
import java.util.List;

/* loaded from: classes3.dex */
abstract class AbstractPublicJwk<K extends PublicKey> extends AbstractAsymmetricJwk<K> implements PublicJwk<K> {
    public AbstractPublicJwk(JwkContext<K> jwkContext, List<Parameter<?>> list) {
        super(jwkContext, list);
    }

    @Override // io.jsonwebtoken.impl.security.AbstractJwk
    public final boolean equals(Jwk<?> jwk) {
        return (jwk instanceof PublicJwk) && equals((PublicJwk<?>) jwk);
    }

    public abstract boolean equals(PublicJwk<?> publicJwk);
}
