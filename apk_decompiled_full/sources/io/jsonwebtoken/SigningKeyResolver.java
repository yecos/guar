package io.jsonwebtoken;

import java.security.Key;

@Deprecated
/* loaded from: classes3.dex */
public interface SigningKeyResolver {
    Key resolveSigningKey(JwsHeader jwsHeader, Claims claims);

    Key resolveSigningKey(JwsHeader jwsHeader, byte[] bArr);
}
