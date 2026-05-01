package io.jsonwebtoken.security;

import java.security.PrivateKey;
import java.security.PublicKey;

/* loaded from: classes3.dex */
public interface PrivateKeyBuilder extends KeyBuilder<PrivateKey, PrivateKeyBuilder> {
    PrivateKeyBuilder publicKey(PublicKey publicKey);
}
