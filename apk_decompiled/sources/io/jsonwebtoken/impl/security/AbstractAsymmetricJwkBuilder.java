package io.jsonwebtoken.impl.security;

import io.jsonwebtoken.impl.ParameterMap;
import io.jsonwebtoken.lang.Assert;
import io.jsonwebtoken.security.AsymmetricJwk;
import io.jsonwebtoken.security.AsymmetricJwkBuilder;
import io.jsonwebtoken.security.EcPrivateJwk;
import io.jsonwebtoken.security.EcPrivateJwkBuilder;
import io.jsonwebtoken.security.EcPublicJwk;
import io.jsonwebtoken.security.EcPublicJwkBuilder;
import io.jsonwebtoken.security.Jwk;
import io.jsonwebtoken.security.MalformedKeyException;
import io.jsonwebtoken.security.OctetPrivateJwk;
import io.jsonwebtoken.security.OctetPrivateJwkBuilder;
import io.jsonwebtoken.security.OctetPublicJwk;
import io.jsonwebtoken.security.OctetPublicJwkBuilder;
import io.jsonwebtoken.security.PrivateJwk;
import io.jsonwebtoken.security.PrivateJwkBuilder;
import io.jsonwebtoken.security.PublicJwk;
import io.jsonwebtoken.security.PublicJwkBuilder;
import io.jsonwebtoken.security.RsaPrivateJwk;
import io.jsonwebtoken.security.RsaPrivateJwkBuilder;
import io.jsonwebtoken.security.RsaPublicJwk;
import io.jsonwebtoken.security.RsaPublicJwkBuilder;
import io.jsonwebtoken.security.X509Builder;
import io.jsonwebtoken.security.X509Mutator;
import java.net.URI;
import java.security.Key;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.cert.X509Certificate;
import java.security.interfaces.ECPrivateKey;
import java.security.interfaces.ECPublicKey;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.util.List;

/* loaded from: classes3.dex */
abstract class AbstractAsymmetricJwkBuilder<K extends Key, J extends AsymmetricJwk<K>, T extends AsymmetricJwkBuilder<K, J, T>> extends AbstractJwkBuilder<K, J, T> implements AsymmetricJwkBuilder<K, J, T> {
    protected Boolean applyX509KeyUse;
    private KeyUseStrategy keyUseStrategy;
    private final X509BuilderSupport x509;

    public static class DefaultEcPrivateJwkBuilder extends DefaultPrivateJwkBuilder<ECPrivateKey, ECPublicKey, EcPublicJwk, EcPrivateJwk, EcPrivateJwkBuilder> implements EcPrivateJwkBuilder {
        public DefaultEcPrivateJwkBuilder(JwkContext<ECPrivateKey> jwkContext) {
            super(jwkContext);
        }

        public DefaultEcPrivateJwkBuilder(DefaultEcPublicJwkBuilder defaultEcPublicJwkBuilder, JwkContext<ECPrivateKey> jwkContext) {
            super(defaultEcPublicJwkBuilder, jwkContext);
        }
    }

    public static class DefaultEcPublicJwkBuilder extends DefaultPublicJwkBuilder<ECPublicKey, ECPrivateKey, EcPublicJwk, EcPrivateJwk, EcPrivateJwkBuilder, EcPublicJwkBuilder> implements EcPublicJwkBuilder {
        public DefaultEcPublicJwkBuilder(JwkContext<ECPublicKey> jwkContext) {
            super(jwkContext);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // io.jsonwebtoken.impl.security.AbstractAsymmetricJwkBuilder.DefaultPublicJwkBuilder
        public EcPrivateJwkBuilder newPrivateBuilder(JwkContext<ECPrivateKey> jwkContext) {
            return new DefaultEcPrivateJwkBuilder(this, jwkContext);
        }
    }

    public static class DefaultOctetPublicJwkBuilder<A extends PublicKey, B extends PrivateKey> extends DefaultPublicJwkBuilder<A, B, OctetPublicJwk<A>, OctetPrivateJwk<B, A>, OctetPrivateJwkBuilder<B, A>, OctetPublicJwkBuilder<A, B>> implements OctetPublicJwkBuilder<A, B> {
        public DefaultOctetPublicJwkBuilder(JwkContext<A> jwkContext) {
            super(jwkContext);
            EdwardsCurve.assertEdwards(jwkContext.getKey());
        }

        @Override // io.jsonwebtoken.impl.security.AbstractAsymmetricJwkBuilder.DefaultPublicJwkBuilder
        public OctetPrivateJwkBuilder<B, A> newPrivateBuilder(JwkContext<B> jwkContext) {
            return new DefaultOctetPrivateJwkBuilder(this, jwkContext);
        }
    }

    public static abstract class DefaultPrivateJwkBuilder<K extends PrivateKey, L extends PublicKey, J extends PublicJwk<L>, M extends PrivateJwk<K, L, J>, T extends PrivateJwkBuilder<K, L, J, M, T>> extends AbstractAsymmetricJwkBuilder<K, M, T> implements PrivateJwkBuilder<K, L, J, M, T> {
        public DefaultPrivateJwkBuilder(JwkContext<K> jwkContext) {
            super(jwkContext);
        }

        @Override // io.jsonwebtoken.impl.security.AbstractAsymmetricJwkBuilder, io.jsonwebtoken.impl.security.AbstractJwkBuilder, io.jsonwebtoken.lang.Builder
        public /* bridge */ /* synthetic */ Jwk build() {
            return super.build();
        }

        @Override // io.jsonwebtoken.security.PrivateJwkBuilder
        public T publicKey(L l10) {
            ((JwkContext) this.DELEGATE).setPublicKey(l10);
            return (T) self();
        }

        @Override // io.jsonwebtoken.impl.security.AbstractAsymmetricJwkBuilder, io.jsonwebtoken.security.X509Mutator
        public /* bridge */ /* synthetic */ X509Mutator x509Chain(List list) {
            return super.x509Chain((List<X509Certificate>) list);
        }

        @Override // io.jsonwebtoken.impl.security.AbstractAsymmetricJwkBuilder, io.jsonwebtoken.security.X509Builder
        /* renamed from: x509Sha1Thumbprint */
        public /* bridge */ /* synthetic */ X509Builder mo76x509Sha1Thumbprint(boolean z10) {
            return super.mo76x509Sha1Thumbprint(z10);
        }

        @Override // io.jsonwebtoken.impl.security.AbstractAsymmetricJwkBuilder, io.jsonwebtoken.security.X509Builder
        /* renamed from: x509Sha256Thumbprint */
        public /* bridge */ /* synthetic */ X509Builder mo77x509Sha256Thumbprint(boolean z10) {
            return super.mo77x509Sha256Thumbprint(z10);
        }

        @Override // io.jsonwebtoken.impl.security.AbstractAsymmetricJwkBuilder, io.jsonwebtoken.security.X509Mutator
        public /* bridge */ /* synthetic */ X509Mutator x509Url(URI uri) {
            return super.x509Url(uri);
        }

        public DefaultPrivateJwkBuilder(DefaultPublicJwkBuilder<L, K, J, M, ?, ?> defaultPublicJwkBuilder, JwkContext<K> jwkContext) {
            super(defaultPublicJwkBuilder, jwkContext);
            ((JwkContext) this.DELEGATE).setPublicKey((PublicKey) ((JwkContext) defaultPublicJwkBuilder.DELEGATE).getKey());
        }

        @Override // io.jsonwebtoken.impl.security.AbstractAsymmetricJwkBuilder, io.jsonwebtoken.impl.security.AbstractJwkBuilder, io.jsonwebtoken.lang.Builder
        public /* bridge */ /* synthetic */ Object build() {
            return super.build();
        }

        @Override // io.jsonwebtoken.impl.security.AbstractAsymmetricJwkBuilder, io.jsonwebtoken.security.X509Mutator
        public /* bridge */ /* synthetic */ X509Mutator x509Sha1Thumbprint(byte[] bArr) {
            return super.x509Sha1Thumbprint(bArr);
        }

        @Override // io.jsonwebtoken.impl.security.AbstractAsymmetricJwkBuilder, io.jsonwebtoken.security.X509Mutator
        public /* bridge */ /* synthetic */ X509Mutator x509Sha256Thumbprint(byte[] bArr) {
            return super.x509Sha256Thumbprint(bArr);
        }
    }

    public static abstract class DefaultPublicJwkBuilder<K extends PublicKey, L extends PrivateKey, J extends PublicJwk<K>, M extends PrivateJwk<L, K, J>, P extends PrivateJwkBuilder<L, K, J, M, P>, T extends PublicJwkBuilder<K, L, J, M, P, T>> extends AbstractAsymmetricJwkBuilder<K, J, T> implements PublicJwkBuilder<K, L, J, M, P, T> {
        public DefaultPublicJwkBuilder(JwkContext<K> jwkContext) {
            super(jwkContext);
        }

        @Override // io.jsonwebtoken.impl.security.AbstractAsymmetricJwkBuilder, io.jsonwebtoken.impl.security.AbstractJwkBuilder, io.jsonwebtoken.lang.Builder
        public /* bridge */ /* synthetic */ Jwk build() {
            return super.build();
        }

        public abstract P newPrivateBuilder(JwkContext<L> jwkContext);

        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.jsonwebtoken.security.PublicJwkBuilder
        public P privateKey(L l10) {
            Assert.notNull(l10, "PrivateKey argument cannot be null.");
            return (P) newPrivateBuilder(newContext(l10)).publicKey((PublicKey) Assert.notNull(((JwkContext) this.DELEGATE).getKey(), "PublicKey cannot be null."));
        }

        @Override // io.jsonwebtoken.impl.security.AbstractAsymmetricJwkBuilder, io.jsonwebtoken.security.X509Mutator
        public /* bridge */ /* synthetic */ X509Mutator x509Chain(List list) {
            return super.x509Chain((List<X509Certificate>) list);
        }

        @Override // io.jsonwebtoken.impl.security.AbstractAsymmetricJwkBuilder, io.jsonwebtoken.security.X509Builder
        /* renamed from: x509Sha1Thumbprint */
        public /* bridge */ /* synthetic */ X509Builder mo76x509Sha1Thumbprint(boolean z10) {
            return super.mo76x509Sha1Thumbprint(z10);
        }

        @Override // io.jsonwebtoken.impl.security.AbstractAsymmetricJwkBuilder, io.jsonwebtoken.security.X509Builder
        /* renamed from: x509Sha256Thumbprint */
        public /* bridge */ /* synthetic */ X509Builder mo77x509Sha256Thumbprint(boolean z10) {
            return super.mo77x509Sha256Thumbprint(z10);
        }

        @Override // io.jsonwebtoken.impl.security.AbstractAsymmetricJwkBuilder, io.jsonwebtoken.security.X509Mutator
        public /* bridge */ /* synthetic */ X509Mutator x509Url(URI uri) {
            return super.x509Url(uri);
        }

        @Override // io.jsonwebtoken.impl.security.AbstractAsymmetricJwkBuilder, io.jsonwebtoken.impl.security.AbstractJwkBuilder, io.jsonwebtoken.lang.Builder
        public /* bridge */ /* synthetic */ Object build() {
            return super.build();
        }

        @Override // io.jsonwebtoken.impl.security.AbstractAsymmetricJwkBuilder, io.jsonwebtoken.security.X509Mutator
        public /* bridge */ /* synthetic */ X509Mutator x509Sha1Thumbprint(byte[] bArr) {
            return super.x509Sha1Thumbprint(bArr);
        }

        @Override // io.jsonwebtoken.impl.security.AbstractAsymmetricJwkBuilder, io.jsonwebtoken.security.X509Mutator
        public /* bridge */ /* synthetic */ X509Mutator x509Sha256Thumbprint(byte[] bArr) {
            return super.x509Sha256Thumbprint(bArr);
        }
    }

    public static class DefaultRsaPrivateJwkBuilder extends DefaultPrivateJwkBuilder<RSAPrivateKey, RSAPublicKey, RsaPublicJwk, RsaPrivateJwk, RsaPrivateJwkBuilder> implements RsaPrivateJwkBuilder {
        public DefaultRsaPrivateJwkBuilder(JwkContext<RSAPrivateKey> jwkContext) {
            super(jwkContext);
        }

        public DefaultRsaPrivateJwkBuilder(DefaultRsaPublicJwkBuilder defaultRsaPublicJwkBuilder, JwkContext<RSAPrivateKey> jwkContext) {
            super(defaultRsaPublicJwkBuilder, jwkContext);
        }
    }

    public static class DefaultRsaPublicJwkBuilder extends DefaultPublicJwkBuilder<RSAPublicKey, RSAPrivateKey, RsaPublicJwk, RsaPrivateJwk, RsaPrivateJwkBuilder, RsaPublicJwkBuilder> implements RsaPublicJwkBuilder {
        public DefaultRsaPublicJwkBuilder(JwkContext<RSAPublicKey> jwkContext) {
            super(jwkContext);
        }

        @Override // io.jsonwebtoken.impl.security.AbstractAsymmetricJwkBuilder.DefaultPublicJwkBuilder
        public RsaPrivateJwkBuilder newPrivateBuilder(JwkContext<RSAPrivateKey> jwkContext) {
            return new DefaultRsaPrivateJwkBuilder(this, jwkContext);
        }
    }

    public AbstractAsymmetricJwkBuilder(JwkContext<K> jwkContext) {
        super(jwkContext);
        this.applyX509KeyUse = null;
        this.keyUseStrategy = DefaultKeyUseStrategy.INSTANCE;
        this.x509 = new X509BuilderSupport((ParameterMap) Assert.isInstanceOf(ParameterMap.class, this.DELEGATE), MalformedKeyException.class);
    }

    @Override // io.jsonwebtoken.security.AsymmetricJwkBuilder
    public T publicKeyUse(String str) {
        Assert.hasText(str, "publicKeyUse cannot be null or empty.");
        ((JwkContext) this.DELEGATE).setPublicKeyUse(str);
        return (T) self();
    }

    @Override // io.jsonwebtoken.security.X509Mutator
    public /* bridge */ /* synthetic */ X509Mutator x509Chain(List list) {
        return x509Chain((List<X509Certificate>) list);
    }

    public static class DefaultOctetPrivateJwkBuilder<A extends PrivateKey, B extends PublicKey> extends DefaultPrivateJwkBuilder<A, B, OctetPublicJwk<B>, OctetPrivateJwk<A, B>, OctetPrivateJwkBuilder<A, B>> implements OctetPrivateJwkBuilder<A, B> {
        public DefaultOctetPrivateJwkBuilder(JwkContext<A> jwkContext) {
            super(jwkContext);
            EdwardsCurve.assertEdwards(jwkContext.getKey());
        }

        public DefaultOctetPrivateJwkBuilder(DefaultOctetPublicJwkBuilder<B, A> defaultOctetPublicJwkBuilder, JwkContext<A> jwkContext) {
            super(defaultOctetPublicJwkBuilder, jwkContext);
            EdwardsCurve.assertEdwards(jwkContext.getKey());
            EdwardsCurve.assertEdwards(jwkContext.getPublicKey());
        }
    }

    @Override // io.jsonwebtoken.security.X509Mutator
    public T x509Chain(List<X509Certificate> list) {
        Assert.notEmpty(list, "X509Certificate chain cannot be null or empty.");
        this.x509.x509Chain(list);
        return (T) self();
    }

    @Override // io.jsonwebtoken.security.X509Mutator
    public T x509Url(URI uri) {
        Assert.notNull(uri, "X509Url cannot be null.");
        this.x509.x509Url(uri);
        return (T) self();
    }

    @Override // io.jsonwebtoken.impl.security.AbstractJwkBuilder, io.jsonwebtoken.lang.Builder
    public J build() {
        this.x509.apply();
        return (J) super.build();
    }

    @Override // io.jsonwebtoken.security.X509Mutator
    public T x509Sha1Thumbprint(byte[] bArr) {
        this.x509.x509Sha1Thumbprint(bArr);
        return (T) self();
    }

    @Override // io.jsonwebtoken.security.X509Mutator
    public T x509Sha256Thumbprint(byte[] bArr) {
        this.x509.x509Sha256Thumbprint(bArr);
        return (T) self();
    }

    @Override // io.jsonwebtoken.security.X509Builder
    /* renamed from: x509Sha1Thumbprint */
    public T mo76x509Sha1Thumbprint(boolean z10) {
        this.x509.mo76x509Sha1Thumbprint(z10);
        return (T) self();
    }

    @Override // io.jsonwebtoken.security.X509Builder
    /* renamed from: x509Sha256Thumbprint */
    public T mo77x509Sha256Thumbprint(boolean z10) {
        this.x509.mo77x509Sha256Thumbprint(z10);
        return (T) self();
    }

    public AbstractAsymmetricJwkBuilder(AbstractAsymmetricJwkBuilder<?, ?, ?> abstractAsymmetricJwkBuilder, JwkContext<K> jwkContext) {
        this(jwkContext);
        this.applyX509KeyUse = abstractAsymmetricJwkBuilder.applyX509KeyUse;
        this.keyUseStrategy = abstractAsymmetricJwkBuilder.keyUseStrategy;
    }
}
