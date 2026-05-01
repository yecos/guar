package io.jsonwebtoken;

/* loaded from: classes3.dex */
public abstract class JwtHandlerAdapter<T> extends SupportedJwtVisitor<T> implements JwtHandler<T> {
    @Override // io.jsonwebtoken.JwtHandler
    public T onClaimsJwe(Jwe<Claims> jwe) {
        return (T) super.onDecryptedClaims(jwe);
    }

    @Override // io.jsonwebtoken.JwtHandler
    public T onClaimsJws(Jws<Claims> jws) {
        return (T) super.onVerifiedClaims(jws);
    }

    @Override // io.jsonwebtoken.JwtHandler
    public T onClaimsJwt(Jwt<Header, Claims> jwt) {
        return (T) super.onUnsecuredClaims(jwt);
    }

    @Override // io.jsonwebtoken.JwtHandler
    public T onContentJwe(Jwe<byte[]> jwe) {
        return (T) super.onDecryptedContent(jwe);
    }

    @Override // io.jsonwebtoken.JwtHandler
    public T onContentJws(Jws<byte[]> jws) {
        return (T) super.onVerifiedContent(jws);
    }

    @Override // io.jsonwebtoken.JwtHandler
    public T onContentJwt(Jwt<Header, byte[]> jwt) {
        return (T) super.onUnsecuredContent(jwt);
    }

    @Override // io.jsonwebtoken.SupportedJwtVisitor
    public T onDecryptedClaims(Jwe<Claims> jwe) {
        return onClaimsJwe(jwe);
    }

    @Override // io.jsonwebtoken.SupportedJwtVisitor
    public T onDecryptedContent(Jwe<byte[]> jwe) {
        return onContentJwe(jwe);
    }

    @Override // io.jsonwebtoken.SupportedJwtVisitor
    public T onUnsecuredClaims(Jwt<Header, Claims> jwt) {
        return onClaimsJwt(jwt);
    }

    @Override // io.jsonwebtoken.SupportedJwtVisitor
    public T onUnsecuredContent(Jwt<Header, byte[]> jwt) {
        return onContentJwt(jwt);
    }

    @Override // io.jsonwebtoken.SupportedJwtVisitor
    public T onVerifiedClaims(Jws<Claims> jws) {
        return onClaimsJws(jws);
    }

    @Override // io.jsonwebtoken.SupportedJwtVisitor
    public T onVerifiedContent(Jws<byte[]> jws) {
        return onContentJws(jws);
    }
}
