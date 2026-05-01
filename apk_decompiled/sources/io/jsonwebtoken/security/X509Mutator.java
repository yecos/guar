package io.jsonwebtoken.security;

import io.jsonwebtoken.security.X509Mutator;
import java.net.URI;
import java.security.cert.X509Certificate;
import java.util.List;

/* loaded from: classes3.dex */
public interface X509Mutator<T extends X509Mutator<T>> {
    T x509Chain(List<X509Certificate> list);

    T x509Sha1Thumbprint(byte[] bArr);

    T x509Sha256Thumbprint(byte[] bArr);

    T x509Url(URI uri);
}
