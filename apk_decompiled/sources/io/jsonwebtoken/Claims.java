package io.jsonwebtoken;

import java.util.Date;
import java.util.Map;
import java.util.Set;

/* loaded from: classes3.dex */
public interface Claims extends Map<String, Object>, Identifiable {
    public static final String AUDIENCE = "aud";
    public static final String EXPIRATION = "exp";
    public static final String ID = "jti";
    public static final String ISSUED_AT = "iat";
    public static final String ISSUER = "iss";
    public static final String NOT_BEFORE = "nbf";
    public static final String SUBJECT = "sub";

    <T> T get(String str, Class<T> cls);

    Set<String> getAudience();

    Date getExpiration();

    @Override // io.jsonwebtoken.Identifiable
    String getId();

    Date getIssuedAt();

    String getIssuer();

    Date getNotBefore();

    String getSubject();
}
