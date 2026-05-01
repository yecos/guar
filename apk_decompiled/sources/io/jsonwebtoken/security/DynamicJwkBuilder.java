package io.jsonwebtoken.security;

import io.jsonwebtoken.security.Jwk;
import java.security.Key;
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
public interface DynamicJwkBuilder<K extends Key, J extends Jwk<K>> extends JwkBuilder<K, J, DynamicJwkBuilder<K, J>> {
    <A extends PublicKey, B extends PrivateKey> PublicJwkBuilder<A, B, ?, ?, ?, ?> chain(List<X509Certificate> list);

    EcPublicJwkBuilder ecChain(List<X509Certificate> list);

    EcPrivateJwkBuilder ecKeyPair(java.security.KeyPair keyPair);

    EcPrivateJwkBuilder key(ECPrivateKey eCPrivateKey);

    EcPublicJwkBuilder key(ECPublicKey eCPublicKey);

    <A extends PublicKey, B extends PrivateKey> PrivateJwkBuilder<B, A, ?, ?, ?> key(B b10);

    <A extends PublicKey, B extends PrivateKey> PublicJwkBuilder<A, B, ?, ?, ?, ?> key(A a10);

    RsaPrivateJwkBuilder key(RSAPrivateKey rSAPrivateKey);

    RsaPublicJwkBuilder key(RSAPublicKey rSAPublicKey);

    SecretJwkBuilder key(SecretKey secretKey);

    <A extends PublicKey, B extends PrivateKey> PrivateJwkBuilder<B, A, ?, ?, ?> keyPair(java.security.KeyPair keyPair);

    <A extends PublicKey, B extends PrivateKey> OctetPublicJwkBuilder<A, B> octetChain(List<X509Certificate> list);

    <A extends PrivateKey, B extends PublicKey> OctetPrivateJwkBuilder<A, B> octetKey(A a10);

    <A extends PublicKey, B extends PrivateKey> OctetPublicJwkBuilder<A, B> octetKey(A a10);

    <A extends PrivateKey, B extends PublicKey> OctetPrivateJwkBuilder<A, B> octetKeyPair(java.security.KeyPair keyPair);

    RsaPublicJwkBuilder rsaChain(List<X509Certificate> list);

    RsaPrivateJwkBuilder rsaKeyPair(java.security.KeyPair keyPair);
}
