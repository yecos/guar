package io.jsonwebtoken.impl;

import io.jsonwebtoken.impl.lang.Parameter;
import io.jsonwebtoken.impl.security.AbstractAsymmetricJwk;
import io.jsonwebtoken.security.X509Mutator;
import java.net.URI;
import java.security.cert.X509Certificate;
import java.util.List;
import java.util.Set;

/* loaded from: classes3.dex */
public class AbstractX509Context<T extends X509Mutator<T>> extends ParameterMap implements X509Context<T> {
    public AbstractX509Context(Set<Parameter<?>> set) {
        super(set);
    }

    @Override // io.jsonwebtoken.security.X509Accessor
    public List<X509Certificate> getX509Chain() {
        return (List) get(AbstractAsymmetricJwk.X5C);
    }

    @Override // io.jsonwebtoken.security.X509Accessor
    public byte[] getX509Sha1Thumbprint() {
        return (byte[]) get(AbstractAsymmetricJwk.X5T);
    }

    @Override // io.jsonwebtoken.security.X509Accessor
    public byte[] getX509Sha256Thumbprint() {
        return (byte[]) get(AbstractAsymmetricJwk.X5T_S256);
    }

    @Override // io.jsonwebtoken.security.X509Accessor
    public URI getX509Url() {
        return (URI) get(AbstractAsymmetricJwk.X5U);
    }

    public T self() {
        return this;
    }

    @Override // io.jsonwebtoken.security.X509Mutator
    public T x509Chain(List<X509Certificate> list) {
        put(AbstractAsymmetricJwk.X5C, (Object) list);
        return self();
    }

    @Override // io.jsonwebtoken.security.X509Mutator
    public T x509Sha1Thumbprint(byte[] bArr) {
        put(AbstractAsymmetricJwk.X5T, (Object) bArr);
        return self();
    }

    @Override // io.jsonwebtoken.security.X509Mutator
    public T x509Sha256Thumbprint(byte[] bArr) {
        put(AbstractAsymmetricJwk.X5T_S256, (Object) bArr);
        return self();
    }

    @Override // io.jsonwebtoken.security.X509Mutator
    public T x509Url(URI uri) {
        put(AbstractAsymmetricJwk.X5U, (Object) uri);
        return self();
    }
}
