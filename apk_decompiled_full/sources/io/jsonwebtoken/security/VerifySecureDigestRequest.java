package io.jsonwebtoken.security;

import java.io.InputStream;
import java.security.Key;

/* loaded from: classes3.dex */
public interface VerifySecureDigestRequest<K extends Key> extends SecureRequest<InputStream, K>, VerifyDigestRequest {
}
