package io.jsonwebtoken.security;

import java.security.PrivateKey;
import java.security.PublicKey;

/* loaded from: classes3.dex */
public interface OctetPrivateJwkBuilder<K extends PrivateKey, L extends PublicKey> extends PrivateJwkBuilder<K, L, OctetPublicJwk<L>, OctetPrivateJwk<K, L>, OctetPrivateJwkBuilder<K, L>> {
}
