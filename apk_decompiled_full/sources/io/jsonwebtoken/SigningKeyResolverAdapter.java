package io.jsonwebtoken;

import io.jsonwebtoken.lang.Assert;
import java.security.Key;
import javax.crypto.spec.SecretKeySpec;

@Deprecated
/* loaded from: classes3.dex */
public class SigningKeyResolverAdapter implements SigningKeyResolver {
    @Override // io.jsonwebtoken.SigningKeyResolver
    public Key resolveSigningKey(JwsHeader jwsHeader, Claims claims) {
        SignatureAlgorithm forName = SignatureAlgorithm.forName(jwsHeader.getAlgorithm());
        Assert.isTrue(forName.isHmac(), "The default resolveSigningKey(JwsHeader, Claims) implementation cannot be used for asymmetric key algorithms (RSA, Elliptic Curve).  Override the resolveSigningKey(JwsHeader, Claims) method instead and return a Key instance appropriate for the " + forName.name() + " algorithm.");
        return new SecretKeySpec(resolveSigningKeyBytes(jwsHeader, claims), forName.getJcaName());
    }

    public byte[] resolveSigningKeyBytes(JwsHeader jwsHeader, Claims claims) {
        throw new UnsupportedJwtException("The specified SigningKeyResolver implementation does not support Claims JWS signing key resolution.  Consider overriding either the resolveSigningKey(JwsHeader, Claims) method or, for HMAC algorithms, the resolveSigningKeyBytes(JwsHeader, Claims) method.");
    }

    public byte[] resolveSigningKeyBytes(JwsHeader jwsHeader, byte[] bArr) {
        throw new UnsupportedJwtException("The specified SigningKeyResolver implementation does not support content JWS signing key resolution.  Consider overriding either the resolveSigningKey(JwsHeader, byte[]) method or, for HMAC algorithms, the resolveSigningKeyBytes(JwsHeader, byte[]) method.");
    }

    @Override // io.jsonwebtoken.SigningKeyResolver
    public Key resolveSigningKey(JwsHeader jwsHeader, byte[] bArr) {
        SignatureAlgorithm forName = SignatureAlgorithm.forName(jwsHeader.getAlgorithm());
        Assert.isTrue(forName.isHmac(), "The default resolveSigningKey(JwsHeader, byte[]) implementation cannot be used for asymmetric key algorithms (RSA, Elliptic Curve).  Override the resolveSigningKey(JwsHeader, byte[]) method instead and return a Key instance appropriate for the " + forName.name() + " algorithm.");
        return new SecretKeySpec(resolveSigningKeyBytes(jwsHeader, bArr), forName.getJcaName());
    }
}
