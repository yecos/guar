package io.jsonwebtoken.security;

import io.jsonwebtoken.lang.MapMutator;
import java.util.Collection;

/* loaded from: classes3.dex */
public interface JwkSetBuilder extends MapMutator<String, Object, JwkSetBuilder>, SecurityBuilder<JwkSet, JwkSetBuilder>, KeyOperationPolicied<JwkSetBuilder> {
    JwkSetBuilder add(Jwk<?> jwk);

    JwkSetBuilder add(Collection<Jwk<?>> collection);

    JwkSetBuilder keys(Collection<Jwk<?>> collection);
}
