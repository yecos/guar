package io.jsonwebtoken.security;

import javax.crypto.SecretKey;

/* loaded from: classes3.dex */
public interface MacAlgorithm extends SecureDigestAlgorithm<SecretKey, SecretKey>, KeyBuilderSupplier<SecretKey, SecretKeyBuilder>, KeyLengthSupplier {
}
