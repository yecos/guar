package io.jsonwebtoken.impl.security;

import io.jsonwebtoken.lang.Assert;
import io.jsonwebtoken.security.Jwk;
import java.security.Key;

/* loaded from: classes3.dex */
class AsymmetricJwkFactory implements FamilyJwkFactory<Key, Jwk<Key>> {
    private final String id;
    private final FamilyJwkFactory<Key, Jwk<Key>> privateFactory;
    private final FamilyJwkFactory<Key, Jwk<Key>> publicFactory;

    public AsymmetricJwkFactory(FamilyJwkFactory familyJwkFactory, FamilyJwkFactory familyJwkFactory2) {
        this.publicFactory = (FamilyJwkFactory) Assert.notNull(familyJwkFactory, "publicFactory cannot be null.");
        this.privateFactory = (FamilyJwkFactory) Assert.notNull(familyJwkFactory2, "privateFactory cannot be null.");
        String str = (String) Assert.notNull(familyJwkFactory.getId(), "publicFactory id cannot be null or empty.");
        this.id = str;
        Assert.isTrue(str.equals(familyJwkFactory2.getId()), "privateFactory id must equal publicFactory id");
    }

    @Override // io.jsonwebtoken.impl.security.JwkFactory
    public Jwk<Key> createJwk(JwkContext<Key> jwkContext) {
        return this.privateFactory.supports(jwkContext) ? this.privateFactory.createJwk(jwkContext) : this.publicFactory.createJwk(jwkContext);
    }

    @Override // io.jsonwebtoken.Identifiable
    public String getId() {
        return this.id;
    }

    @Override // io.jsonwebtoken.impl.security.JwkFactory
    public JwkContext<Key> newContext(JwkContext<?> jwkContext, Key key) {
        return ((this.privateFactory.supports(key) || this.privateFactory.supports(jwkContext)) ? this.privateFactory : this.publicFactory).newContext(jwkContext, key);
    }

    @Override // io.jsonwebtoken.impl.security.FamilyJwkFactory
    public boolean supports(JwkContext<?> jwkContext) {
        return jwkContext != null && (this.id.equals(jwkContext.getType()) || this.privateFactory.supports(jwkContext) || this.publicFactory.supports(jwkContext));
    }

    @Override // io.jsonwebtoken.impl.security.FamilyJwkFactory
    public boolean supports(Key key) {
        return key != null && (this.privateFactory.supports(key) || this.publicFactory.supports(key));
    }
}
