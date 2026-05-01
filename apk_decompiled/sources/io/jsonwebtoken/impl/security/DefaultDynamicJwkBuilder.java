package io.jsonwebtoken.impl.security;

import io.jsonwebtoken.impl.lang.Parameter;
import io.jsonwebtoken.impl.security.AbstractAsymmetricJwkBuilder;
import io.jsonwebtoken.impl.security.AbstractJwkBuilder;
import io.jsonwebtoken.lang.Assert;
import io.jsonwebtoken.lang.NestedCollection;
import io.jsonwebtoken.lang.Strings;
import io.jsonwebtoken.security.DynamicJwkBuilder;
import io.jsonwebtoken.security.EcPrivateJwkBuilder;
import io.jsonwebtoken.security.EcPublicJwkBuilder;
import io.jsonwebtoken.security.Jwk;
import io.jsonwebtoken.security.OctetPrivateJwkBuilder;
import io.jsonwebtoken.security.OctetPublicJwkBuilder;
import io.jsonwebtoken.security.PrivateJwkBuilder;
import io.jsonwebtoken.security.PublicJwkBuilder;
import io.jsonwebtoken.security.RsaPrivateJwkBuilder;
import io.jsonwebtoken.security.RsaPublicJwkBuilder;
import io.jsonwebtoken.security.SecretJwkBuilder;
import io.jsonwebtoken.security.UnsupportedKeyException;
import java.security.Key;
import java.security.KeyPair;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.cert.X509Certificate;
import java.security.interfaces.ECPrivateKey;
import java.security.interfaces.ECPublicKey;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.util.List;
import javax.crypto.SecretKey;

/* loaded from: classes3.dex */
public class DefaultDynamicJwkBuilder<K extends Key, J extends Jwk<K>> extends AbstractJwkBuilder<K, J, DynamicJwkBuilder<K, J>> implements DynamicJwkBuilder<K, J> {
    public DefaultDynamicJwkBuilder() {
        this(new DefaultJwkContext());
    }

    private static UnsupportedKeyException unsupportedKey(Key key, Exception exc) {
        return new UnsupportedKeyException("There is no builder that supports specified key [" + KeysBridge.toString(key) + "].", exc);
    }

    @Override // io.jsonwebtoken.security.DynamicJwkBuilder
    public <A extends PublicKey, B extends PrivateKey> PublicJwkBuilder<A, B, ?, ?, ?, ?> chain(List<X509Certificate> list) {
        Assert.notEmpty(list, "chain cannot be null or empty.");
        return (PublicJwkBuilder) key((DefaultDynamicJwkBuilder<K, J>) Assert.notNull(((X509Certificate) Assert.notNull(list.get(0), "The first X509Certificate cannot be null.")).getPublicKey(), "The first X509Certificate's PublicKey cannot be null.")).x509Chain(list);
    }

    @Override // io.jsonwebtoken.security.DynamicJwkBuilder
    public EcPublicJwkBuilder ecChain(List<X509Certificate> list) {
        Assert.notEmpty(list, "X509Certificate chain cannot be empty.");
        return (EcPublicJwkBuilder) key((ECPublicKey) KeyPairs.assertKey(list.get(0).getPublicKey(), ECPublicKey.class, "The first X509Certificate's ")).x509Chain(list);
    }

    @Override // io.jsonwebtoken.security.DynamicJwkBuilder
    public EcPrivateJwkBuilder ecKeyPair(KeyPair keyPair) {
        return key((ECPrivateKey) KeyPairs.getKey(keyPair, ECPrivateKey.class)).publicKey((ECPublicKey) KeyPairs.getKey(keyPair, ECPublicKey.class));
    }

    @Override // io.jsonwebtoken.security.DynamicJwkBuilder
    public SecretJwkBuilder key(SecretKey secretKey) {
        return new AbstractJwkBuilder.DefaultSecretJwkBuilder(newContext(secretKey));
    }

    @Override // io.jsonwebtoken.security.DynamicJwkBuilder
    public <A extends PublicKey, B extends PrivateKey> PrivateJwkBuilder<B, A, ?, ?, ?> keyPair(KeyPair keyPair) {
        return key((DefaultDynamicJwkBuilder<K, J>) KeyPairs.getKey(keyPair, PrivateKey.class)).publicKey((PublicKey) KeyPairs.getKey(keyPair, PublicKey.class));
    }

    @Override // io.jsonwebtoken.security.DynamicJwkBuilder
    public <A extends PublicKey, B extends PrivateKey> OctetPublicJwkBuilder<A, B> octetChain(List<X509Certificate> list) {
        Assert.notEmpty(list, "X509Certificate chain cannot be empty.");
        PublicKey publicKey = list.get(0).getPublicKey();
        Assert.notNull(publicKey, "The first X509Certificate's PublicKey cannot be null.");
        EdwardsCurve.assertEdwards(publicKey);
        return (OctetPublicJwkBuilder) octetKey((DefaultDynamicJwkBuilder<K, J>) publicKey).x509Chain(list);
    }

    @Override // io.jsonwebtoken.security.DynamicJwkBuilder
    public <A extends PublicKey, B extends PrivateKey> OctetPublicJwkBuilder<A, B> octetKey(A a10) {
        return new AbstractAsymmetricJwkBuilder.DefaultOctetPublicJwkBuilder(newContext(a10));
    }

    @Override // io.jsonwebtoken.security.DynamicJwkBuilder
    public <A extends PrivateKey, B extends PublicKey> OctetPrivateJwkBuilder<A, B> octetKeyPair(KeyPair keyPair) {
        PublicKey publicKey = (PublicKey) KeyPairs.getKey(keyPair, PublicKey.class);
        PrivateKey privateKey = (PrivateKey) KeyPairs.getKey(keyPair, PrivateKey.class);
        EdwardsCurve.assertEdwards(publicKey);
        EdwardsCurve.assertEdwards(privateKey);
        return (OctetPrivateJwkBuilder) octetKey((DefaultDynamicJwkBuilder<K, J>) privateKey).publicKey(publicKey);
    }

    @Override // io.jsonwebtoken.impl.security.AbstractJwkBuilder, io.jsonwebtoken.security.JwkBuilder
    public /* bridge */ /* synthetic */ NestedCollection operations() {
        return super.operations();
    }

    @Override // io.jsonwebtoken.security.DynamicJwkBuilder
    public RsaPublicJwkBuilder rsaChain(List<X509Certificate> list) {
        Assert.notEmpty(list, "X509Certificate chain cannot be empty.");
        return (RsaPublicJwkBuilder) key((RSAPublicKey) KeyPairs.assertKey(list.get(0).getPublicKey(), RSAPublicKey.class, "The first X509Certificate's ")).x509Chain(list);
    }

    @Override // io.jsonwebtoken.security.DynamicJwkBuilder
    public RsaPrivateJwkBuilder rsaKeyPair(KeyPair keyPair) {
        return key((RSAPrivateKey) KeyPairs.getKey(keyPair, RSAPrivateKey.class)).publicKey((RSAPublicKey) KeyPairs.getKey(keyPair, RSAPublicKey.class));
    }

    public DefaultDynamicJwkBuilder(JwkContext<K> jwkContext) {
        super(jwkContext);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.jsonwebtoken.impl.security.AbstractJwkBuilder, io.jsonwebtoken.lang.Builder
    public J build() {
        if (Strings.hasText((String) ((JwkContext) this.DELEGATE).get((Parameter) AbstractJwk.KTY))) {
            JwkFactory<K, J> jwkFactory = this.jwkFactory;
            T t10 = this.DELEGATE;
            setDelegate(jwkFactory.newContext((JwkContext) t10, ((JwkContext) t10).getKey()));
        }
        return (J) super.build();
    }

    @Override // io.jsonwebtoken.security.DynamicJwkBuilder
    public RsaPublicJwkBuilder key(RSAPublicKey rSAPublicKey) {
        return new AbstractAsymmetricJwkBuilder.DefaultRsaPublicJwkBuilder(newContext(rSAPublicKey));
    }

    @Override // io.jsonwebtoken.security.DynamicJwkBuilder
    public <A extends PrivateKey, B extends PublicKey> OctetPrivateJwkBuilder<A, B> octetKey(A a10) {
        return new AbstractAsymmetricJwkBuilder.DefaultOctetPrivateJwkBuilder(newContext(a10));
    }

    @Override // io.jsonwebtoken.security.DynamicJwkBuilder
    public RsaPrivateJwkBuilder key(RSAPrivateKey rSAPrivateKey) {
        return new AbstractAsymmetricJwkBuilder.DefaultRsaPrivateJwkBuilder(newContext(rSAPrivateKey));
    }

    @Override // io.jsonwebtoken.security.DynamicJwkBuilder
    public EcPublicJwkBuilder key(ECPublicKey eCPublicKey) {
        return new AbstractAsymmetricJwkBuilder.DefaultEcPublicJwkBuilder(newContext(eCPublicKey));
    }

    @Override // io.jsonwebtoken.security.DynamicJwkBuilder
    public EcPrivateJwkBuilder key(ECPrivateKey eCPrivateKey) {
        return new AbstractAsymmetricJwkBuilder.DefaultEcPrivateJwkBuilder(newContext(eCPrivateKey));
    }

    @Override // io.jsonwebtoken.security.DynamicJwkBuilder
    public <A extends PublicKey, B extends PrivateKey> PublicJwkBuilder<A, B, ?, ?, ?, ?> key(A a10) {
        if (a10 instanceof RSAPublicKey) {
            return key((RSAPublicKey) a10);
        }
        if (a10 instanceof ECPublicKey) {
            return key((ECPublicKey) a10);
        }
        try {
            return octetKey((DefaultDynamicJwkBuilder<K, J>) a10);
        } catch (Exception e10) {
            throw unsupportedKey(a10, e10);
        }
    }

    @Override // io.jsonwebtoken.security.DynamicJwkBuilder
    public <A extends PublicKey, B extends PrivateKey> PrivateJwkBuilder<B, A, ?, ?, ?> key(B b10) {
        Assert.notNull(b10, "Key cannot be null.");
        if (b10 instanceof RSAPrivateKey) {
            return key((RSAPrivateKey) b10);
        }
        if (b10 instanceof ECPrivateKey) {
            return key((ECPrivateKey) b10);
        }
        try {
            return octetKey((DefaultDynamicJwkBuilder<K, J>) b10);
        } catch (Exception e10) {
            throw unsupportedKey(b10, e10);
        }
    }
}
