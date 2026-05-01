package io.jsonwebtoken.security;

import java.net.URI;

/* loaded from: classes3.dex */
public interface JwkThumbprint {
    HashAlgorithm getHashAlgorithm();

    byte[] toByteArray();

    String toString();

    URI toURI();
}
