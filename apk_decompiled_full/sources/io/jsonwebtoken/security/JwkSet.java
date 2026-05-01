package io.jsonwebtoken.security;

import java.util.Map;
import java.util.Set;

/* loaded from: classes3.dex */
public interface JwkSet extends Map<String, Object>, Iterable<Jwk<?>> {
    Set<Jwk<?>> getKeys();
}
