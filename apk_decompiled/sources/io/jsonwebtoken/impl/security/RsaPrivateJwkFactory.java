package io.jsonwebtoken.impl.security;

import io.jsonwebtoken.impl.lang.CheckedFunction;
import io.jsonwebtoken.impl.lang.Parameter;
import io.jsonwebtoken.impl.lang.RequiredParameterReader;
import io.jsonwebtoken.lang.Arrays;
import io.jsonwebtoken.lang.Assert;
import io.jsonwebtoken.lang.Collections;
import io.jsonwebtoken.lang.Strings;
import io.jsonwebtoken.security.InvalidKeyException;
import io.jsonwebtoken.security.RsaPrivateJwk;
import io.jsonwebtoken.security.RsaPublicJwk;
import io.jsonwebtoken.security.UnsupportedKeyException;
import java.math.BigInteger;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.interfaces.RSAMultiPrimePrivateCrtKey;
import java.security.interfaces.RSAPrivateCrtKey;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.KeySpec;
import java.security.spec.RSAMultiPrimePrivateCrtKeySpec;
import java.security.spec.RSAOtherPrimeInfo;
import java.security.spec.RSAPrivateCrtKeySpec;
import java.security.spec.RSAPrivateKeySpec;
import java.security.spec.RSAPublicKeySpec;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* loaded from: classes3.dex */
class RsaPrivateJwkFactory extends AbstractFamilyJwkFactory<RSAPrivateKey, RsaPrivateJwk> {
    private static final Set<Parameter<BigInteger>> OPTIONAL_PRIVATE_PARAMS = Collections.setOf(DefaultRsaPrivateJwk.FIRST_PRIME, DefaultRsaPrivateJwk.SECOND_PRIME, DefaultRsaPrivateJwk.FIRST_CRT_EXPONENT, DefaultRsaPrivateJwk.SECOND_CRT_EXPONENT, DefaultRsaPrivateJwk.FIRST_CRT_COEFFICIENT);
    private static final String PUBKEY_ERR_MSG = "JwkContext publicKey must be an " + RSAPublicKey.class.getName() + " instance.";
    private static final String PUB_EXPONENT_EX_MSG = "Unable to derive RSAPublicKey from RSAPrivateKey [%s]. Supported keys implement the " + RSAPrivateCrtKey.class.getName() + " or " + RSAMultiPrimePrivateCrtKey.class.getName() + " interfaces.  If the specified RSAPrivateKey cannot be one of these two, you must explicitly provide an RSAPublicKey in addition to the RSAPrivateKey, as the [JWA RFC, Section 6.3.2](https://www.rfc-editor.org/rfc/rfc7518.html#section-6.3.2) requires public values to be present in private RSA JWKs.";

    public RsaPrivateJwkFactory() {
        super("RSA", RSAPrivateKey.class, DefaultRsaPrivateJwk.PARAMS);
    }

    private RSAPublicKey derivePublic(final JwkContext<RSAPrivateKey> jwkContext) {
        RSAPrivateKey key = jwkContext.getKey();
        final RSAPublicKeySpec rSAPublicKeySpec = new RSAPublicKeySpec(key.getModulus(), getPublicExponent(key));
        return (RSAPublicKey) generateKey(jwkContext, RSAPublicKey.class, new CheckedFunction<KeyFactory, RSAPublicKey>() { // from class: io.jsonwebtoken.impl.security.RsaPrivateJwkFactory.1
            @Override // io.jsonwebtoken.impl.lang.CheckedFunction
            public RSAPublicKey apply(KeyFactory keyFactory) {
                try {
                    return (RSAPublicKey) keyFactory.generatePublic(rSAPublicKeySpec);
                } catch (Exception e10) {
                    throw new InvalidKeyException("Unable to derive RSAPublicKey from RSAPrivateKey " + jwkContext + ". Cause: " + e10.getMessage());
                }
            }
        });
    }

    private static BigInteger getPublicExponent(RSAPrivateKey rSAPrivateKey) {
        if (rSAPrivateKey instanceof RSAPrivateCrtKey) {
            return ((RSAPrivateCrtKey) rSAPrivateKey).getPublicExponent();
        }
        if (rSAPrivateKey instanceof RSAMultiPrimePrivateCrtKey) {
            return ((RSAMultiPrimePrivateCrtKey) rSAPrivateKey).getPublicExponent();
        }
        throw new UnsupportedKeyException(String.format(PUB_EXPONENT_EX_MSG, KeysBridge.toString(rSAPrivateKey)));
    }

    public RSAPrivateKey generateFromSpec(JwkContext<RSAPrivateKey> jwkContext, final KeySpec keySpec) {
        return generateKey(jwkContext, new CheckedFunction<KeyFactory, RSAPrivateKey>() { // from class: io.jsonwebtoken.impl.security.RsaPrivateJwkFactory.2
            @Override // io.jsonwebtoken.impl.lang.CheckedFunction
            public RSAPrivateKey apply(KeyFactory keyFactory) {
                return (RSAPrivateKey) keyFactory.generatePrivate(keySpec);
            }
        });
    }

    @Override // io.jsonwebtoken.impl.security.AbstractFamilyJwkFactory
    public boolean supportsKeyValues(JwkContext<?> jwkContext) {
        return super.supportsKeyValues(jwkContext) && jwkContext.containsKey(DefaultRsaPrivateJwk.PRIVATE_EXPONENT.getId());
    }

    @Override // io.jsonwebtoken.impl.security.AbstractFamilyJwkFactory
    public RsaPrivateJwk createJwkFromKey(JwkContext<RSAPrivateKey> jwkContext) {
        RSAPrivateKey key = jwkContext.getKey();
        PublicKey publicKey = jwkContext.getPublicKey();
        RSAPublicKey derivePublic = publicKey != null ? (RSAPublicKey) Assert.isInstanceOf(RSAPublicKey.class, publicKey, PUBKEY_ERR_MSG) : derivePublic(jwkContext);
        boolean z10 = (Strings.hasText(jwkContext.getId()) || jwkContext.getIdThumbprintAlgorithm() == null) ? false : true;
        RsaPublicJwkFactory rsaPublicJwkFactory = RsaPublicJwkFactory.INSTANCE;
        RsaPublicJwk createJwk = rsaPublicJwkFactory.createJwk(rsaPublicJwkFactory.newContext(jwkContext, derivePublic));
        jwkContext.putAll(createJwk);
        if (z10) {
            jwkContext.setId(createJwk.getId());
        }
        AbstractFamilyJwkFactory.put(jwkContext, DefaultRsaPrivateJwk.PRIVATE_EXPONENT, key.getPrivateExponent());
        if (key instanceof RSAPrivateCrtKey) {
            RSAPrivateCrtKey rSAPrivateCrtKey = (RSAPrivateCrtKey) key;
            AbstractFamilyJwkFactory.put(jwkContext, DefaultRsaPrivateJwk.FIRST_PRIME, rSAPrivateCrtKey.getPrimeP());
            AbstractFamilyJwkFactory.put(jwkContext, DefaultRsaPrivateJwk.SECOND_PRIME, rSAPrivateCrtKey.getPrimeQ());
            AbstractFamilyJwkFactory.put(jwkContext, DefaultRsaPrivateJwk.FIRST_CRT_EXPONENT, rSAPrivateCrtKey.getPrimeExponentP());
            AbstractFamilyJwkFactory.put(jwkContext, DefaultRsaPrivateJwk.SECOND_CRT_EXPONENT, rSAPrivateCrtKey.getPrimeExponentQ());
            AbstractFamilyJwkFactory.put(jwkContext, DefaultRsaPrivateJwk.FIRST_CRT_COEFFICIENT, rSAPrivateCrtKey.getCrtCoefficient());
        } else if (key instanceof RSAMultiPrimePrivateCrtKey) {
            RSAMultiPrimePrivateCrtKey rSAMultiPrimePrivateCrtKey = (RSAMultiPrimePrivateCrtKey) key;
            AbstractFamilyJwkFactory.put(jwkContext, DefaultRsaPrivateJwk.FIRST_PRIME, rSAMultiPrimePrivateCrtKey.getPrimeP());
            AbstractFamilyJwkFactory.put(jwkContext, DefaultRsaPrivateJwk.SECOND_PRIME, rSAMultiPrimePrivateCrtKey.getPrimeQ());
            AbstractFamilyJwkFactory.put(jwkContext, DefaultRsaPrivateJwk.FIRST_CRT_EXPONENT, rSAMultiPrimePrivateCrtKey.getPrimeExponentP());
            AbstractFamilyJwkFactory.put(jwkContext, DefaultRsaPrivateJwk.SECOND_CRT_EXPONENT, rSAMultiPrimePrivateCrtKey.getPrimeExponentQ());
            AbstractFamilyJwkFactory.put(jwkContext, DefaultRsaPrivateJwk.FIRST_CRT_COEFFICIENT, rSAMultiPrimePrivateCrtKey.getCrtCoefficient());
            List asList = Arrays.asList(rSAMultiPrimePrivateCrtKey.getOtherPrimeInfo());
            if (!Collections.isEmpty(asList)) {
                AbstractFamilyJwkFactory.put(jwkContext, DefaultRsaPrivateJwk.OTHER_PRIMES_INFO, asList);
            }
        }
        return new DefaultRsaPrivateJwk(jwkContext, createJwk);
    }

    @Override // io.jsonwebtoken.impl.security.AbstractFamilyJwkFactory
    public RsaPrivateJwk createJwkFromValues(JwkContext<RSAPrivateKey> jwkContext) {
        boolean z10;
        KeySpec rSAPrivateKeySpec;
        RequiredParameterReader requiredParameterReader = new RequiredParameterReader(jwkContext);
        BigInteger bigInteger = (BigInteger) requiredParameterReader.get(DefaultRsaPrivateJwk.PRIVATE_EXPONENT);
        RsaPublicJwk createJwkFromValues = RsaPublicJwkFactory.INSTANCE.createJwkFromValues((JwkContext<RSAPublicKey>) new DefaultJwkContext(DefaultRsaPublicJwk.PARAMS, jwkContext));
        RSAPublicKey rSAPublicKey = (RSAPublicKey) createJwkFromValues.toKey();
        BigInteger modulus = rSAPublicKey.getModulus();
        BigInteger publicExponent = rSAPublicKey.getPublicExponent();
        Iterator<Parameter<BigInteger>> it = OPTIONAL_PRIVATE_PARAMS.iterator();
        while (true) {
            if (!it.hasNext()) {
                z10 = false;
                break;
            }
            if (jwkContext.containsKey(it.next().getId())) {
                z10 = true;
                break;
            }
        }
        if (z10) {
            BigInteger bigInteger2 = (BigInteger) requiredParameterReader.get(DefaultRsaPrivateJwk.FIRST_PRIME);
            BigInteger bigInteger3 = (BigInteger) requiredParameterReader.get(DefaultRsaPrivateJwk.SECOND_PRIME);
            BigInteger bigInteger4 = (BigInteger) requiredParameterReader.get(DefaultRsaPrivateJwk.FIRST_CRT_EXPONENT);
            BigInteger bigInteger5 = (BigInteger) requiredParameterReader.get(DefaultRsaPrivateJwk.SECOND_CRT_EXPONENT);
            BigInteger bigInteger6 = (BigInteger) requiredParameterReader.get(DefaultRsaPrivateJwk.FIRST_CRT_COEFFICIENT);
            Parameter<List<RSAOtherPrimeInfo>> parameter = DefaultRsaPrivateJwk.OTHER_PRIMES_INFO;
            if (jwkContext.containsKey(parameter.getId())) {
                List list = (List) requiredParameterReader.get(parameter);
                rSAPrivateKeySpec = new RSAMultiPrimePrivateCrtKeySpec(modulus, publicExponent, bigInteger, bigInteger2, bigInteger3, bigInteger4, bigInteger5, bigInteger6, (RSAOtherPrimeInfo[]) list.toArray(new RSAOtherPrimeInfo[Collections.size(list)]));
            } else {
                rSAPrivateKeySpec = new RSAPrivateCrtKeySpec(modulus, publicExponent, bigInteger, bigInteger2, bigInteger3, bigInteger4, bigInteger5, bigInteger6);
            }
        } else {
            rSAPrivateKeySpec = new RSAPrivateKeySpec(modulus, bigInteger);
        }
        jwkContext.setKey(generateFromSpec(jwkContext, rSAPrivateKeySpec));
        return new DefaultRsaPrivateJwk(jwkContext, createJwkFromValues);
    }
}
