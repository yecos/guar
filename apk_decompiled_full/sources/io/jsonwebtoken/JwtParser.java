package io.jsonwebtoken;

import io.jsonwebtoken.io.Parser;
import java.io.InputStream;

/* loaded from: classes3.dex */
public interface JwtParser extends Parser<Jwt<?, ?>> {
    boolean isSigned(CharSequence charSequence);

    @Override // io.jsonwebtoken.io.Parser
    Jwt<?, ?> parse(CharSequence charSequence);

    @Deprecated
    <T> T parse(CharSequence charSequence, JwtHandler<T> jwtHandler);

    @Deprecated
    Jws<Claims> parseClaimsJws(CharSequence charSequence);

    @Deprecated
    Jwt<Header, Claims> parseClaimsJwt(CharSequence charSequence);

    @Deprecated
    Jws<byte[]> parseContentJws(CharSequence charSequence);

    @Deprecated
    Jwt<Header, byte[]> parseContentJwt(CharSequence charSequence);

    Jwe<Claims> parseEncryptedClaims(CharSequence charSequence);

    Jwe<byte[]> parseEncryptedContent(CharSequence charSequence);

    Jws<Claims> parseSignedClaims(CharSequence charSequence);

    Jws<Claims> parseSignedClaims(CharSequence charSequence, InputStream inputStream);

    Jws<Claims> parseSignedClaims(CharSequence charSequence, byte[] bArr);

    Jws<byte[]> parseSignedContent(CharSequence charSequence);

    Jws<byte[]> parseSignedContent(CharSequence charSequence, InputStream inputStream);

    Jws<byte[]> parseSignedContent(CharSequence charSequence, byte[] bArr);

    Jwt<Header, Claims> parseUnsecuredClaims(CharSequence charSequence);

    Jwt<Header, byte[]> parseUnsecuredContent(CharSequence charSequence);
}
