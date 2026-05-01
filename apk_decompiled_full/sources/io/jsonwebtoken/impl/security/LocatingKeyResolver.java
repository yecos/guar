package io.jsonwebtoken.impl.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwsHeader;
import io.jsonwebtoken.Locator;
import io.jsonwebtoken.SigningKeyResolver;
import io.jsonwebtoken.lang.Assert;
import java.security.Key;

/* loaded from: classes3.dex */
public class LocatingKeyResolver implements SigningKeyResolver {
    private final Locator<? extends Key> locator;

    public LocatingKeyResolver(Locator<? extends Key> locator) {
        this.locator = (Locator) Assert.notNull(locator, "Locator cannot be null.");
    }

    @Override // io.jsonwebtoken.SigningKeyResolver
    public Key resolveSigningKey(JwsHeader jwsHeader, Claims claims) {
        return this.locator.locate(jwsHeader);
    }

    @Override // io.jsonwebtoken.SigningKeyResolver
    public Key resolveSigningKey(JwsHeader jwsHeader, byte[] bArr) {
        return this.locator.locate(jwsHeader);
    }
}
