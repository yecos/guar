package io.jsonwebtoken;

import io.jsonwebtoken.lang.Assert;

/* loaded from: classes3.dex */
public class SupportedJwtVisitor<T> implements JwtVisitor<T> {
    public T onDecryptedClaims(Jwe<Claims> jwe) {
        throw new UnsupportedJwtException("Unexpected Claims JWE.");
    }

    public T onDecryptedContent(Jwe<byte[]> jwe) {
        throw new UnsupportedJwtException("Unexpected content JWE.");
    }

    public T onUnsecuredClaims(Jwt<Header, Claims> jwt) {
        throw new UnsupportedJwtException("Unexpected unsecured Claims JWT.");
    }

    public T onUnsecuredContent(Jwt<Header, byte[]> jwt) {
        throw new UnsupportedJwtException("Unexpected unsecured content JWT.");
    }

    public T onVerifiedClaims(Jws<Claims> jws) {
        throw new UnsupportedJwtException("Unexpected Claims JWS.");
    }

    public T onVerifiedContent(Jws<byte[]> jws) {
        throw new UnsupportedJwtException("Unexpected content JWS.");
    }

    @Override // io.jsonwebtoken.JwtVisitor
    public T visit(Jwt<?, ?> jwt) {
        Assert.notNull(jwt, "JWT cannot be null.");
        Object payload = jwt.getPayload();
        if (payload instanceof byte[]) {
            return onUnsecuredContent(jwt);
        }
        Assert.stateIsInstance(Claims.class, payload, "Unexpected payload data type: ");
        return onUnsecuredClaims(jwt);
    }

    @Override // io.jsonwebtoken.JwtVisitor
    public T visit(Jws<?> jws) {
        Assert.notNull(jws, "JWS cannot be null.");
        Object payload = jws.getPayload();
        if (payload instanceof byte[]) {
            return onVerifiedContent(jws);
        }
        Assert.stateIsInstance(Claims.class, payload, "Unexpected payload data type: ");
        return onVerifiedClaims(jws);
    }

    @Override // io.jsonwebtoken.JwtVisitor
    public T visit(Jwe<?> jwe) {
        Assert.notNull(jwe, "JWE cannot be null.");
        Object payload = jwe.getPayload();
        if (payload instanceof byte[]) {
            return onDecryptedContent(jwe);
        }
        Assert.stateIsInstance(Claims.class, payload, "Unexpected payload data type: ");
        return onDecryptedClaims(jwe);
    }
}
