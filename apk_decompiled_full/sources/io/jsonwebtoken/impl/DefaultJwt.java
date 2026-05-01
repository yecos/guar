package io.jsonwebtoken.impl;

import io.jsonwebtoken.Header;
import io.jsonwebtoken.Jwt;
import io.jsonwebtoken.JwtVisitor;
import io.jsonwebtoken.io.Encoders;
import io.jsonwebtoken.lang.Assert;
import io.jsonwebtoken.lang.Objects;

/* loaded from: classes3.dex */
public class DefaultJwt<H extends Header, P> implements Jwt<H, P> {
    private final H header;
    private final P payload;

    public DefaultJwt(H h10, P p10) {
        this.header = (H) Assert.notNull(h10, "header cannot be null.");
        this.payload = (P) Assert.notNull(p10, "payload cannot be null.");
    }

    @Override // io.jsonwebtoken.Jwt
    public <T> T accept(JwtVisitor<T> jwtVisitor) {
        return jwtVisitor.visit(this);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Jwt)) {
            return false;
        }
        Jwt jwt = (Jwt) obj;
        return Objects.nullSafeEquals(this.header, jwt.getHeader()) && Objects.nullSafeEquals(this.payload, jwt.getPayload());
    }

    @Override // io.jsonwebtoken.Jwt
    public P getBody() {
        return getPayload();
    }

    @Override // io.jsonwebtoken.Jwt
    public H getHeader() {
        return this.header;
    }

    @Override // io.jsonwebtoken.Jwt
    public P getPayload() {
        return this.payload;
    }

    public int hashCode() {
        return Objects.nullSafeHashCode(this.header, this.payload);
    }

    public final String toString() {
        return toStringBuilder().toString();
    }

    public StringBuilder toStringBuilder() {
        StringBuilder sb = new StringBuilder(100);
        sb.append("header=");
        sb.append(this.header);
        sb.append(",payload=");
        Object obj = this.payload;
        if (obj instanceof byte[]) {
            sb.append(Encoders.BASE64URL.encode((byte[]) obj));
        } else {
            sb.append(obj);
        }
        return sb;
    }
}
