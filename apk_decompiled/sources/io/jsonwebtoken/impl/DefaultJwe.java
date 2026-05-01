package io.jsonwebtoken.impl;

import io.jsonwebtoken.Jwe;
import io.jsonwebtoken.JweHeader;
import io.jsonwebtoken.JwtVisitor;
import io.jsonwebtoken.io.Encoders;
import io.jsonwebtoken.lang.Assert;
import io.jsonwebtoken.lang.Objects;
import java.security.MessageDigest;

/* loaded from: classes3.dex */
public class DefaultJwe<P> extends DefaultProtectedJwt<JweHeader, P> implements Jwe<P> {
    private static final String DIGEST_NAME = "tag";
    private final byte[] iv;

    public DefaultJwe(JweHeader jweHeader, P p10, byte[] bArr, byte[] bArr2) {
        super(jweHeader, p10, bArr2, DIGEST_NAME);
        this.iv = Assert.notEmpty(bArr, "Initialization vector cannot be null or empty.");
    }

    @Override // io.jsonwebtoken.impl.DefaultJwt, io.jsonwebtoken.Jwt
    public <T> T accept(JwtVisitor<T> jwtVisitor) {
        return jwtVisitor.visit((Jwe<?>) this);
    }

    @Override // io.jsonwebtoken.impl.DefaultProtectedJwt, io.jsonwebtoken.impl.DefaultJwt
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Jwe)) {
            return false;
        }
        Jwe jwe = (Jwe) obj;
        return super.equals(jwe) && MessageDigest.isEqual(this.iv, jwe.getInitializationVector());
    }

    @Override // io.jsonwebtoken.impl.DefaultProtectedJwt, io.jsonwebtoken.security.DigestSupplier
    public /* bridge */ /* synthetic */ byte[] getDigest() {
        return super.getDigest();
    }

    @Override // io.jsonwebtoken.Jwe
    public byte[] getInitializationVector() {
        return (byte[]) this.iv.clone();
    }

    @Override // io.jsonwebtoken.impl.DefaultProtectedJwt, io.jsonwebtoken.impl.DefaultJwt
    public int hashCode() {
        return Objects.nullSafeHashCode(getHeader(), getPayload(), this.iv, this.digest);
    }

    @Override // io.jsonwebtoken.impl.DefaultProtectedJwt, io.jsonwebtoken.impl.DefaultJwt
    public StringBuilder toStringBuilder() {
        StringBuilder stringBuilder = super.toStringBuilder();
        stringBuilder.append(",iv=");
        stringBuilder.append(Encoders.BASE64URL.encode(this.iv));
        return stringBuilder;
    }
}
