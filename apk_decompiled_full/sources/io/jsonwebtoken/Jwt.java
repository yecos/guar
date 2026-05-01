package io.jsonwebtoken;

import io.jsonwebtoken.Header;

/* loaded from: classes3.dex */
public interface Jwt<H extends Header, P> {
    public static final JwtVisitor<Jwt<Header, byte[]>> UNSECURED_CONTENT = new SupportedJwtVisitor<Jwt<Header, byte[]>>() { // from class: io.jsonwebtoken.Jwt.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // io.jsonwebtoken.SupportedJwtVisitor
        public Jwt<Header, byte[]> onUnsecuredContent(Jwt<Header, byte[]> jwt) {
            return jwt;
        }

        @Override // io.jsonwebtoken.SupportedJwtVisitor
        public /* bridge */ /* synthetic */ Jwt<Header, byte[]> onUnsecuredContent(Jwt jwt) {
            return onUnsecuredContent((Jwt<Header, byte[]>) jwt);
        }
    };
    public static final JwtVisitor<Jwt<Header, Claims>> UNSECURED_CLAIMS = new SupportedJwtVisitor<Jwt<Header, Claims>>() { // from class: io.jsonwebtoken.Jwt.2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // io.jsonwebtoken.SupportedJwtVisitor
        public Jwt<Header, Claims> onUnsecuredClaims(Jwt<Header, Claims> jwt) {
            return jwt;
        }

        @Override // io.jsonwebtoken.SupportedJwtVisitor
        public /* bridge */ /* synthetic */ Jwt<Header, Claims> onUnsecuredClaims(Jwt jwt) {
            return onUnsecuredClaims((Jwt<Header, Claims>) jwt);
        }
    };

    <T> T accept(JwtVisitor<T> jwtVisitor);

    @Deprecated
    P getBody();

    H getHeader();

    P getPayload();
}
