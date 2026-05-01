package io.jsonwebtoken.impl.security;

import io.jsonwebtoken.security.Jwk;
import java.security.Key;

/* loaded from: classes3.dex */
public interface JwkFactory<K extends Key, J extends Jwk<K>> {
    J createJwk(JwkContext<K> jwkContext);

    JwkContext<K> newContext(JwkContext<?> jwkContext, K k10);
}
