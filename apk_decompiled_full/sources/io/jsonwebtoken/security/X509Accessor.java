package io.jsonwebtoken.security;

import java.net.URI;
import java.security.cert.X509Certificate;
import java.util.List;

/* loaded from: classes3.dex */
public interface X509Accessor {
    List<X509Certificate> getX509Chain();

    byte[] getX509Sha1Thumbprint();

    byte[] getX509Sha256Thumbprint();

    URI getX509Url();
}
