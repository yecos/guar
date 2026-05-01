package io.jsonwebtoken.impl.security;

import io.jsonwebtoken.impl.lang.RequiredParameterReader;
import io.jsonwebtoken.lang.Assert;
import io.jsonwebtoken.lang.Strings;
import io.jsonwebtoken.security.InvalidKeyException;
import io.jsonwebtoken.security.Jwk;
import io.jsonwebtoken.security.OctetPrivateJwk;
import io.jsonwebtoken.security.OctetPublicJwk;
import java.security.PrivateKey;
import java.security.PublicKey;

/* loaded from: classes3.dex */
public class OctetPrivateJwkFactory extends OctetJwkFactory<PrivateKey, OctetPrivateJwk<PrivateKey, PublicKey>> {
    public OctetPrivateJwkFactory() {
        super(PrivateKey.class, DefaultOctetPrivateJwk.PARAMS);
    }

    @Override // io.jsonwebtoken.impl.security.AbstractFamilyJwkFactory
    public /* bridge */ /* synthetic */ Jwk createJwkFromKey(JwkContext jwkContext) {
        return createJwkFromKey((JwkContext<PrivateKey>) jwkContext);
    }

    @Override // io.jsonwebtoken.impl.security.AbstractFamilyJwkFactory
    public /* bridge */ /* synthetic */ Jwk createJwkFromValues(JwkContext jwkContext) {
        return createJwkFromValues((JwkContext<PrivateKey>) jwkContext);
    }

    @Override // io.jsonwebtoken.impl.security.AbstractFamilyJwkFactory
    public boolean supportsKeyValues(JwkContext<?> jwkContext) {
        return super.supportsKeyValues(jwkContext) && jwkContext.containsKey(DefaultOctetPrivateJwk.D.getId());
    }

    @Override // io.jsonwebtoken.impl.security.AbstractFamilyJwkFactory
    public OctetPrivateJwk<PrivateKey, PublicKey> createJwkFromKey(JwkContext<PrivateKey> jwkContext) {
        PrivateKey privateKey = (PrivateKey) Assert.notNull(jwkContext.getKey(), "PrivateKey cannot be null.");
        EdwardsCurve forKey = EdwardsCurve.forKey(privateKey);
        PublicKey publicKey = jwkContext.getPublicKey();
        if (publicKey == null) {
            publicKey = EdwardsCurve.derivePublic(privateKey);
        } else if (!forKey.equals(EdwardsCurve.forKey(publicKey))) {
            throw new InvalidKeyException("Specified Edwards Curve PublicKey does not match the specified PrivateKey's curve.");
        }
        boolean z10 = (Strings.hasText(jwkContext.getId()) || jwkContext.getIdThumbprintAlgorithm() == null) ? false : true;
        OctetPublicJwkFactory octetPublicJwkFactory = OctetPublicJwkFactory.INSTANCE;
        OctetPublicJwk octetPublicJwk = (OctetPublicJwk) octetPublicJwkFactory.createJwk(octetPublicJwkFactory.newContext(jwkContext, publicKey));
        jwkContext.putAll(octetPublicJwk);
        if (z10) {
            jwkContext.setId(octetPublicJwk.getId());
        }
        byte[] keyMaterial = forKey.getKeyMaterial(privateKey);
        Assert.notEmpty(keyMaterial, "Edwards PrivateKey 'd' value cannot be null or empty.");
        AbstractFamilyJwkFactory.put(jwkContext, DefaultOctetPrivateJwk.D, keyMaterial);
        return new DefaultOctetPrivateJwk(jwkContext, octetPublicJwk);
    }

    @Override // io.jsonwebtoken.impl.security.AbstractFamilyJwkFactory
    public OctetPrivateJwk<PrivateKey, PublicKey> createJwkFromValues(JwkContext<PrivateKey> jwkContext) {
        RequiredParameterReader requiredParameterReader = new RequiredParameterReader(jwkContext);
        EdwardsCurve curve = OctetJwkFactory.getCurve(requiredParameterReader);
        OctetPublicJwk<PublicKey> createJwkFromValues = OctetPublicJwkFactory.INSTANCE.createJwkFromValues((JwkContext<PublicKey>) new DefaultJwkContext(DefaultOctetPublicJwk.PARAMS, jwkContext));
        jwkContext.setKey(curve.toPrivateKey((byte[]) requiredParameterReader.get(DefaultOctetPrivateJwk.D), jwkContext.getProvider()));
        return new DefaultOctetPrivateJwk(jwkContext, createJwkFromValues);
    }
}
