package io.jsonwebtoken;

/* loaded from: classes3.dex */
public class InvalidClaimException extends ClaimJwtException {
    private final String claimName;
    private final Object claimValue;

    public InvalidClaimException(Header header, Claims claims, String str, Object obj, String str2) {
        super(header, claims, str2);
        this.claimName = str;
        this.claimValue = obj;
    }

    public String getClaimName() {
        return this.claimName;
    }

    public Object getClaimValue() {
        return this.claimValue;
    }

    public InvalidClaimException(Header header, Claims claims, String str, Object obj, String str2, Throwable th) {
        super(header, claims, str2, th);
        this.claimName = str;
        this.claimValue = obj;
    }
}
