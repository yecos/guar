package io.jsonwebtoken;

/* loaded from: classes3.dex */
public interface Jws<P> extends ProtectedJwt<JwsHeader, P> {
    public static final JwtVisitor<Jws<byte[]>> CONTENT = new SupportedJwtVisitor<Jws<byte[]>>() { // from class: io.jsonwebtoken.Jws.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // io.jsonwebtoken.SupportedJwtVisitor
        public Jws<byte[]> onVerifiedContent(Jws<byte[]> jws) {
            return jws;
        }

        @Override // io.jsonwebtoken.SupportedJwtVisitor
        public /* bridge */ /* synthetic */ Jws<byte[]> onVerifiedContent(Jws jws) {
            return onVerifiedContent((Jws<byte[]>) jws);
        }
    };
    public static final JwtVisitor<Jws<Claims>> CLAIMS = new SupportedJwtVisitor<Jws<Claims>>() { // from class: io.jsonwebtoken.Jws.2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // io.jsonwebtoken.SupportedJwtVisitor
        public Jws<Claims> onVerifiedClaims(Jws<Claims> jws) {
            return jws;
        }

        @Override // io.jsonwebtoken.SupportedJwtVisitor
        public /* bridge */ /* synthetic */ Jws<Claims> onVerifiedClaims(Jws jws) {
            return onVerifiedClaims((Jws<Claims>) jws);
        }
    };

    @Deprecated
    String getSignature();
}
