package io.jsonwebtoken.security;

import java.io.InputStream;
import java.security.Key;

/* loaded from: classes3.dex */
public interface SecureDigestAlgorithm<S extends Key, V extends Key> extends DigestAlgorithm<SecureRequest<InputStream, S>, VerifySecureDigestRequest<V>> {
}
