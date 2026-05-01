package io.jsonwebtoken.security;

import javax.crypto.SecretKey;

/* loaded from: classes3.dex */
public interface SecretKeyAlgorithm extends KeyAlgorithm<SecretKey, SecretKey>, KeyBuilderSupplier<SecretKey, SecretKeyBuilder>, KeyLengthSupplier {
}
