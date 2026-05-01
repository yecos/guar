package io.jsonwebtoken.impl;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ClaimsBuilder;

/* loaded from: classes3.dex */
public final class DefaultClaimsBuilder extends DelegatingClaimsMutator<ClaimsBuilder> implements ClaimsBuilder {
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // io.jsonwebtoken.lang.Builder
    public Claims build() {
        return new DefaultClaims((ParameterMap) this.DELEGATE);
    }
}
