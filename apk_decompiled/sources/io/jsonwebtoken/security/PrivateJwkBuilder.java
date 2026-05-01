package io.jsonwebtoken.security;

import io.jsonwebtoken.security.PrivateJwk;
import io.jsonwebtoken.security.PrivateJwkBuilder;
import io.jsonwebtoken.security.PublicJwk;
import java.security.PrivateKey;
import java.security.PublicKey;

/* loaded from: classes3.dex */
public interface PrivateJwkBuilder<K extends PrivateKey, L extends PublicKey, J extends PublicJwk<L>, M extends PrivateJwk<K, L, J>, T extends PrivateJwkBuilder<K, L, J, M, T>> extends AsymmetricJwkBuilder<K, M, T> {
    T publicKey(L l10);
}
