package io.jsonwebtoken;

@Deprecated
/* loaded from: classes3.dex */
public interface JwtHandler<T> extends JwtVisitor<T> {
    T onClaimsJwe(Jwe<Claims> jwe);

    T onClaimsJws(Jws<Claims> jws);

    T onClaimsJwt(Jwt<Header, Claims> jwt);

    T onContentJwe(Jwe<byte[]> jwe);

    T onContentJws(Jws<byte[]> jws);

    T onContentJwt(Jwt<Header, byte[]> jwt);
}
