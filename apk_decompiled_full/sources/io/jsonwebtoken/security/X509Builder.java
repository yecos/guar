package io.jsonwebtoken.security;

import io.jsonwebtoken.security.X509Builder;

/* loaded from: classes3.dex */
public interface X509Builder<T extends X509Builder<T>> extends X509Mutator<T> {
    /* renamed from: x509Sha1Thumbprint */
    T mo76x509Sha1Thumbprint(boolean z10);

    /* renamed from: x509Sha256Thumbprint */
    T mo77x509Sha256Thumbprint(boolean z10);
}
