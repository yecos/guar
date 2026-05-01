package io.jsonwebtoken.impl.security;

import io.jsonwebtoken.impl.lang.Converter;
import io.jsonwebtoken.impl.lang.Parameter;
import io.jsonwebtoken.impl.lang.Parameters;
import io.jsonwebtoken.impl.lang.RequiredParameterReader;
import io.jsonwebtoken.lang.Collections;
import io.jsonwebtoken.security.MalformedKeyException;
import java.math.BigInteger;
import java.security.spec.RSAOtherPrimeInfo;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/* loaded from: classes3.dex */
class RSAOtherPrimeInfoConverter implements Converter<RSAOtherPrimeInfo, Object> {
    static final Parameter<BigInteger> FACTOR_CRT_COEFFICIENT;
    static final Parameter<BigInteger> FACTOR_CRT_EXPONENT;
    static final RSAOtherPrimeInfoConverter INSTANCE = new RSAOtherPrimeInfoConverter();
    static final Set<Parameter<?>> PARAMS;
    static final Parameter<BigInteger> PRIME_FACTOR;

    static {
        Parameter<BigInteger> secretBigInt = Parameters.secretBigInt("r", "Prime Factor");
        PRIME_FACTOR = secretBigInt;
        Parameter<BigInteger> secretBigInt2 = Parameters.secretBigInt("d", "Factor CRT Exponent");
        FACTOR_CRT_EXPONENT = secretBigInt2;
        Parameter<BigInteger> secretBigInt3 = Parameters.secretBigInt("t", "Factor CRT Coefficient");
        FACTOR_CRT_COEFFICIENT = secretBigInt3;
        PARAMS = Collections.setOf(secretBigInt, secretBigInt2, secretBigInt3);
    }

    @Override // io.jsonwebtoken.impl.lang.Converter
    public RSAOtherPrimeInfo applyFrom(Object obj) {
        if (obj == null) {
            throw new MalformedKeyException("RSA JWK 'oth' (Other Prime Info) element cannot be null.");
        }
        if (!(obj instanceof Map)) {
            throw new MalformedKeyException("RSA JWK 'oth' (Other Prime Info) must contain map elements of name/value pairs. Element type found: " + obj.getClass().getName());
        }
        Map map = (Map) obj;
        if (Collections.isEmpty((Map<?, ?>) map)) {
            throw new MalformedKeyException("RSA JWK 'oth' (Other Prime Info) element map cannot be empty.");
        }
        DefaultJwkContext defaultJwkContext = new DefaultJwkContext(PARAMS);
        try {
            for (Map.Entry entry : map.entrySet()) {
                defaultJwkContext.put((DefaultJwkContext) String.valueOf(entry.getKey()), (String) entry.getValue());
            }
            RequiredParameterReader requiredParameterReader = new RequiredParameterReader(defaultJwkContext);
            return new RSAOtherPrimeInfo((BigInteger) requiredParameterReader.get(PRIME_FACTOR), (BigInteger) requiredParameterReader.get(FACTOR_CRT_EXPONENT), (BigInteger) requiredParameterReader.get(FACTOR_CRT_COEFFICIENT));
        } catch (Exception e10) {
            throw new MalformedKeyException(e10.getMessage(), e10);
        }
    }

    @Override // io.jsonwebtoken.impl.lang.Converter
    public Object applyTo(RSAOtherPrimeInfo rSAOtherPrimeInfo) {
        LinkedHashMap linkedHashMap = new LinkedHashMap(3);
        Parameter<BigInteger> parameter = PRIME_FACTOR;
        linkedHashMap.put(parameter.getId(), parameter.applyTo(rSAOtherPrimeInfo.getPrime()));
        Parameter<BigInteger> parameter2 = FACTOR_CRT_EXPONENT;
        linkedHashMap.put(parameter2.getId(), parameter2.applyTo(rSAOtherPrimeInfo.getExponent()));
        Parameter<BigInteger> parameter3 = FACTOR_CRT_COEFFICIENT;
        linkedHashMap.put(parameter3.getId(), parameter3.applyTo(rSAOtherPrimeInfo.getCrtCoefficient()));
        return linkedHashMap;
    }
}
