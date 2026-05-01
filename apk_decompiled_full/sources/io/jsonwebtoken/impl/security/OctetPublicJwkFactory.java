package io.jsonwebtoken.impl.security;

import io.jsonwebtoken.impl.lang.RequiredParameterReader;
import io.jsonwebtoken.lang.Assert;
import io.jsonwebtoken.security.Jwk;
import io.jsonwebtoken.security.OctetPublicJwk;
import java.security.PublicKey;

/* loaded from: classes3.dex */
public class OctetPublicJwkFactory extends OctetJwkFactory<PublicKey, OctetPublicJwk<PublicKey>> {
    static final OctetPublicJwkFactory INSTANCE = new OctetPublicJwkFactory();

    public OctetPublicJwkFactory() {
        super(PublicKey.class, DefaultOctetPublicJwk.PARAMS);
    }

    @Override // io.jsonwebtoken.impl.security.AbstractFamilyJwkFactory
    public /* bridge */ /* synthetic */ Jwk createJwkFromKey(JwkContext jwkContext) {
        return createJwkFromKey((JwkContext<PublicKey>) jwkContext);
    }

    @Override // io.jsonwebtoken.impl.security.AbstractFamilyJwkFactory
    public /* bridge */ /* synthetic */ Jwk createJwkFromValues(JwkContext jwkContext) {
        return createJwkFromValues((JwkContext<PublicKey>) jwkContext);
    }

    @Override // io.jsonwebtoken.impl.security.AbstractFamilyJwkFactory
    public OctetPublicJwk<PublicKey> createJwkFromKey(JwkContext<PublicKey> jwkContext) {
        PublicKey publicKey = (PublicKey) Assert.notNull(jwkContext.getKey(), "PublicKey cannot be null.");
        EdwardsCurve forKey = EdwardsCurve.forKey(publicKey);
        byte[] keyMaterial = forKey.getKeyMaterial(publicKey);
        Assert.notEmpty(keyMaterial, "Edwards PublicKey 'x' value cannot be null or empty.");
        AbstractFamilyJwkFactory.put(jwkContext, DefaultOctetPublicJwk.CRV, forKey.getId());
        AbstractFamilyJwkFactory.put(jwkContext, DefaultOctetPublicJwk.X, keyMaterial);
        return new DefaultOctetPublicJwk(jwkContext);
    }

    @Override // io.jsonwebtoken.impl.security.AbstractFamilyJwkFactory
    public OctetPublicJwk<PublicKey> createJwkFromValues(JwkContext<PublicKey> jwkContext) {
        RequiredParameterReader requiredParameterReader = new RequiredParameterReader(jwkContext);
        jwkContext.setKey(OctetJwkFactory.getCurve(requiredParameterReader).toPublicKey((byte[]) requiredParameterReader.get(DefaultOctetPublicJwk.X), jwkContext.getProvider()));
        return new DefaultOctetPublicJwk(jwkContext);
    }
}
