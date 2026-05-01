package io.jsonwebtoken;

/* loaded from: classes3.dex */
public interface Jwe<B> extends ProtectedJwt<JweHeader, B> {
    public static final JwtVisitor<Jwe<byte[]>> CONTENT = new SupportedJwtVisitor<Jwe<byte[]>>() { // from class: io.jsonwebtoken.Jwe.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // io.jsonwebtoken.SupportedJwtVisitor
        public Jwe<byte[]> onDecryptedContent(Jwe<byte[]> jwe) {
            return jwe;
        }

        @Override // io.jsonwebtoken.SupportedJwtVisitor
        public /* bridge */ /* synthetic */ Jwe<byte[]> onDecryptedContent(Jwe jwe) {
            return onDecryptedContent((Jwe<byte[]>) jwe);
        }
    };
    public static final JwtVisitor<Jwe<Claims>> CLAIMS = new SupportedJwtVisitor<Jwe<Claims>>() { // from class: io.jsonwebtoken.Jwe.2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // io.jsonwebtoken.SupportedJwtVisitor
        public Jwe<Claims> onDecryptedClaims(Jwe<Claims> jwe) {
            return jwe;
        }

        @Override // io.jsonwebtoken.SupportedJwtVisitor
        public /* bridge */ /* synthetic */ Jwe<Claims> onDecryptedClaims(Jwe jwe) {
            return onDecryptedClaims((Jwe<Claims>) jwe);
        }
    };

    byte[] getInitializationVector();
}
