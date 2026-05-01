package io.jsonwebtoken;

import io.jsonwebtoken.ClaimsMutator;
import io.jsonwebtoken.lang.NestedCollection;
import java.util.Date;

/* loaded from: classes3.dex */
public interface ClaimsMutator<T extends ClaimsMutator<T>> {

    public interface AudienceCollection<P> extends NestedCollection<String, P> {
        @Deprecated
        P single(String str);
    }

    AudienceCollection<T> audience();

    T expiration(Date date);

    T id(String str);

    T issuedAt(Date date);

    T issuer(String str);

    T notBefore(Date date);

    @Deprecated
    T setAudience(String str);

    @Deprecated
    T setExpiration(Date date);

    @Deprecated
    T setId(String str);

    @Deprecated
    T setIssuedAt(Date date);

    @Deprecated
    T setIssuer(String str);

    @Deprecated
    T setNotBefore(Date date);

    @Deprecated
    T setSubject(String str);

    T subject(String str);
}
