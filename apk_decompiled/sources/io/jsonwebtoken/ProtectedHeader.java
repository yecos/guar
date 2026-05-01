package io.jsonwebtoken;

import io.jsonwebtoken.security.PublicJwk;
import io.jsonwebtoken.security.X509Accessor;
import java.net.URI;
import java.util.Set;

/* loaded from: classes3.dex */
public interface ProtectedHeader extends Header, X509Accessor {
    Set<String> getCritical();

    PublicJwk<?> getJwk();

    URI getJwkSetUrl();

    String getKeyId();
}
