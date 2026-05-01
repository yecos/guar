package io.jsonwebtoken.impl.security;

import io.jsonwebtoken.Identifiable;
import io.jsonwebtoken.security.Jwk;
import java.security.Key;

/* loaded from: classes3.dex */
public interface FamilyJwkFactory<K extends Key, J extends Jwk<K>> extends JwkFactory<K, J>, Identifiable {
    boolean supports(JwkContext<?> jwkContext);

    boolean supports(Key key);
}
