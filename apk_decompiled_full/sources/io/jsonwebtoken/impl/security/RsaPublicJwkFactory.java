package io.jsonwebtoken.impl.security;

import io.jsonwebtoken.impl.lang.CheckedFunction;
import io.jsonwebtoken.impl.lang.Parameter;
import io.jsonwebtoken.impl.lang.RequiredParameterReader;
import io.jsonwebtoken.security.RsaPublicJwk;
import java.math.BigInteger;
import java.security.KeyFactory;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.RSAPublicKeySpec;

/* loaded from: classes3.dex */
class RsaPublicJwkFactory extends AbstractFamilyJwkFactory<RSAPublicKey, RsaPublicJwk> {
    static final RsaPublicJwkFactory INSTANCE = new RsaPublicJwkFactory();

    public RsaPublicJwkFactory() {
        super("RSA", RSAPublicKey.class, DefaultRsaPublicJwk.PARAMS);
    }

    @Override // io.jsonwebtoken.impl.security.AbstractFamilyJwkFactory
    public RsaPublicJwk createJwkFromKey(JwkContext<RSAPublicKey> jwkContext) {
        RSAPublicKey key = jwkContext.getKey();
        Parameter<BigInteger> parameter = DefaultRsaPublicJwk.MODULUS;
        jwkContext.put(parameter.getId(), parameter.applyTo(key.getModulus()));
        Parameter<BigInteger> parameter2 = DefaultRsaPublicJwk.PUBLIC_EXPONENT;
        jwkContext.put(parameter2.getId(), parameter2.applyTo(key.getPublicExponent()));
        return new DefaultRsaPublicJwk(jwkContext);
    }

    @Override // io.jsonwebtoken.impl.security.AbstractFamilyJwkFactory
    public RsaPublicJwk createJwkFromValues(JwkContext<RSAPublicKey> jwkContext) {
        RequiredParameterReader requiredParameterReader = new RequiredParameterReader(jwkContext);
        final RSAPublicKeySpec rSAPublicKeySpec = new RSAPublicKeySpec((BigInteger) requiredParameterReader.get(DefaultRsaPublicJwk.MODULUS), (BigInteger) requiredParameterReader.get(DefaultRsaPublicJwk.PUBLIC_EXPONENT));
        jwkContext.setKey(generateKey(jwkContext, new CheckedFunction<KeyFactory, RSAPublicKey>() { // from class: io.jsonwebtoken.impl.security.RsaPublicJwkFactory.1
            @Override // io.jsonwebtoken.impl.lang.CheckedFunction
            public RSAPublicKey apply(KeyFactory keyFactory) {
                return (RSAPublicKey) keyFactory.generatePublic(rSAPublicKeySpec);
            }
        }));
        return new DefaultRsaPublicJwk(jwkContext);
    }
}
