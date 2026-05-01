package io.jsonwebtoken.impl;

import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwsHeader;
import io.jsonwebtoken.JwtVisitor;

/* loaded from: classes3.dex */
public class DefaultJws<P> extends DefaultProtectedJwt<JwsHeader, P> implements Jws<P> {
    private static final String DIGEST_NAME = "signature";
    private final String signature;

    public DefaultJws(JwsHeader jwsHeader, P p10, byte[] bArr, String str) {
        super(jwsHeader, p10, bArr, "signature");
        this.signature = str;
    }

    @Override // io.jsonwebtoken.impl.DefaultJwt, io.jsonwebtoken.Jwt
    public <T> T accept(JwtVisitor<T> jwtVisitor) {
        return jwtVisitor.visit((Jws<?>) this);
    }

    @Override // io.jsonwebtoken.impl.DefaultProtectedJwt, io.jsonwebtoken.impl.DefaultJwt
    public /* bridge */ /* synthetic */ boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override // io.jsonwebtoken.impl.DefaultProtectedJwt, io.jsonwebtoken.security.DigestSupplier
    public /* bridge */ /* synthetic */ byte[] getDigest() {
        return super.getDigest();
    }

    @Override // io.jsonwebtoken.Jws
    public String getSignature() {
        return this.signature;
    }

    @Override // io.jsonwebtoken.impl.DefaultProtectedJwt, io.jsonwebtoken.impl.DefaultJwt
    public /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }
}
