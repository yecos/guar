package io.jsonwebtoken;

/* loaded from: classes3.dex */
public class MissingClaimException extends InvalidClaimException {
    public MissingClaimException(Header header, Claims claims, String str, Object obj, String str2) {
        super(header, claims, str, obj, str2);
    }

    @Deprecated
    public MissingClaimException(Header header, Claims claims, String str, Object obj, String str2, Throwable th) {
        super(header, claims, str, obj, str2, th);
    }
}
