package io.jsonwebtoken.impl;

import io.jsonwebtoken.JweHeaderMutator;
import io.jsonwebtoken.security.X509Builder;

/* loaded from: classes3.dex */
public class DefaultJweHeaderBuilder<T extends JweHeaderMutator<T> & X509Builder<T>> extends DefaultJweHeaderMutator<T> implements X509Builder<T> {
    public DefaultJweHeaderBuilder() {
    }

    @Override // io.jsonwebtoken.security.X509Builder
    /* renamed from: x509Sha1Thumbprint, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ X509Builder mo76x509Sha1Thumbprint(boolean z10) {
        return (X509Builder) x509Sha1Thumbprint(z10);
    }

    @Override // io.jsonwebtoken.security.X509Builder
    /* renamed from: x509Sha256Thumbprint, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ X509Builder mo77x509Sha256Thumbprint(boolean z10) {
        return (X509Builder) x509Sha256Thumbprint(z10);
    }

    public DefaultJweHeaderBuilder(DefaultJweHeaderMutator<?> defaultJweHeaderMutator) {
        super(defaultJweHeaderMutator);
    }

    /* JADX WARN: Incorrect return type in method signature: (Z)TT; */
    public JweHeaderMutator x509Sha1Thumbprint(boolean z10) {
        this.x509.mo76x509Sha1Thumbprint(z10);
        return (JweHeaderMutator) self();
    }

    /* JADX WARN: Incorrect return type in method signature: (Z)TT; */
    public JweHeaderMutator x509Sha256Thumbprint(boolean z10) {
        this.x509.mo77x509Sha256Thumbprint(z10);
        return (JweHeaderMutator) self();
    }
}
