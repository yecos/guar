package io.jsonwebtoken.security;

import java.security.Key;

/* loaded from: classes3.dex */
public interface AsymmetricJwk<K extends Key> extends Jwk<K>, X509Accessor {
    String getPublicKeyUse();
}
