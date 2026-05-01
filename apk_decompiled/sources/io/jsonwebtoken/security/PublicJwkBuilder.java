package io.jsonwebtoken.security;

import io.jsonwebtoken.security.PrivateJwk;
import io.jsonwebtoken.security.PrivateJwkBuilder;
import io.jsonwebtoken.security.PublicJwk;
import io.jsonwebtoken.security.PublicJwkBuilder;
import java.security.PrivateKey;
import java.security.PublicKey;

/* loaded from: classes3.dex */
public interface PublicJwkBuilder<K extends PublicKey, L extends PrivateKey, J extends PublicJwk<K>, M extends PrivateJwk<L, K, J>, P extends PrivateJwkBuilder<L, K, J, M, P>, T extends PublicJwkBuilder<K, L, J, M, P, T>> extends AsymmetricJwkBuilder<K, J, T> {
    P privateKey(L l10);
}
