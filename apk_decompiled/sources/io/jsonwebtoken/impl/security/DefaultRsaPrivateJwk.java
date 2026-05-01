package io.jsonwebtoken.impl.security;

import com.umeng.analytics.pro.bt;
import io.jsonwebtoken.impl.lang.Parameter;
import io.jsonwebtoken.impl.lang.ParameterReadable;
import io.jsonwebtoken.impl.lang.Parameters;
import io.jsonwebtoken.lang.Collections;
import io.jsonwebtoken.security.PrivateJwk;
import io.jsonwebtoken.security.RsaPrivateJwk;
import io.jsonwebtoken.security.RsaPublicJwk;
import java.math.BigInteger;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.RSAOtherPrimeInfo;
import java.util.List;
import java.util.Set;

/* loaded from: classes3.dex */
class DefaultRsaPrivateJwk extends AbstractPrivateJwk<RSAPrivateKey, RSAPublicKey, RsaPublicJwk> implements RsaPrivateJwk {
    static final Parameter<BigInteger> FIRST_CRT_COEFFICIENT;
    static final Parameter<BigInteger> FIRST_CRT_EXPONENT;
    static final Parameter<BigInteger> FIRST_PRIME;
    static final Parameter<List<RSAOtherPrimeInfo>> OTHER_PRIMES_INFO;
    static final Set<Parameter<?>> PARAMS;
    static final Parameter<BigInteger> PRIVATE_EXPONENT;
    static final Parameter<BigInteger> SECOND_CRT_EXPONENT;
    static final Parameter<BigInteger> SECOND_PRIME;

    static {
        Parameter<BigInteger> secretBigInt = Parameters.secretBigInt("d", "Private Exponent");
        PRIVATE_EXPONENT = secretBigInt;
        Parameter<BigInteger> secretBigInt2 = Parameters.secretBigInt(bt.aD, "First Prime Factor");
        FIRST_PRIME = secretBigInt2;
        Parameter<BigInteger> secretBigInt3 = Parameters.secretBigInt("q", "Second Prime Factor");
        SECOND_PRIME = secretBigInt3;
        Parameter<BigInteger> secretBigInt4 = Parameters.secretBigInt("dp", "First Factor CRT Exponent");
        FIRST_CRT_EXPONENT = secretBigInt4;
        Parameter<BigInteger> secretBigInt5 = Parameters.secretBigInt("dq", "Second Factor CRT Exponent");
        SECOND_CRT_EXPONENT = secretBigInt5;
        Parameter<BigInteger> secretBigInt6 = Parameters.secretBigInt("qi", "First CRT Coefficient");
        FIRST_CRT_COEFFICIENT = secretBigInt6;
        Parameter<List<RSAOtherPrimeInfo>> parameter = (Parameter) Parameters.builder(RSAOtherPrimeInfo.class).setId("oth").setName("Other Primes Info").setConverter(RSAOtherPrimeInfoConverter.INSTANCE).list().build();
        OTHER_PRIMES_INFO = parameter;
        PARAMS = Collections.concat(DefaultRsaPublicJwk.PARAMS, secretBigInt, secretBigInt2, secretBigInt3, secretBigInt4, secretBigInt5, secretBigInt6, parameter);
    }

    public DefaultRsaPrivateJwk(JwkContext<RSAPrivateKey> jwkContext, RsaPublicJwk rsaPublicJwk) {
        super(jwkContext, DefaultRsaPublicJwk.THUMBPRINT_PARAMS, rsaPublicJwk);
    }

    private static boolean equals(RSAOtherPrimeInfo rSAOtherPrimeInfo, RSAOtherPrimeInfo rSAOtherPrimeInfo2) {
        if (rSAOtherPrimeInfo == rSAOtherPrimeInfo2) {
            return true;
        }
        return rSAOtherPrimeInfo != null && rSAOtherPrimeInfo2 != null && Parameters.bytesEquals(rSAOtherPrimeInfo.getPrime(), rSAOtherPrimeInfo2.getPrime()) && Parameters.bytesEquals(rSAOtherPrimeInfo.getExponent(), rSAOtherPrimeInfo2.getExponent()) && Parameters.bytesEquals(rSAOtherPrimeInfo.getCrtCoefficient(), rSAOtherPrimeInfo2.getCrtCoefficient());
    }

    private static boolean equalsOtherPrimes(ParameterReadable parameterReadable, ParameterReadable parameterReadable2) {
        Parameter<List<RSAOtherPrimeInfo>> parameter = OTHER_PRIMES_INFO;
        List list = (List) parameterReadable.get(parameter);
        List list2 = (List) parameterReadable2.get(parameter);
        int size = Collections.size(list);
        if (size != Collections.size(list2)) {
            return false;
        }
        if (size == 0) {
            return true;
        }
        RSAOtherPrimeInfo[] rSAOtherPrimeInfoArr = (RSAOtherPrimeInfo[]) list.toArray(new RSAOtherPrimeInfo[0]);
        RSAOtherPrimeInfo[] rSAOtherPrimeInfoArr2 = (RSAOtherPrimeInfo[]) list2.toArray(new RSAOtherPrimeInfo[0]);
        for (int i10 = 0; i10 < size; i10++) {
            if (!equals(rSAOtherPrimeInfoArr[i10], rSAOtherPrimeInfoArr2[i10])) {
                return false;
            }
        }
        return true;
    }

    @Override // io.jsonwebtoken.impl.security.AbstractPrivateJwk
    public boolean equals(PrivateJwk<?, ?, ?> privateJwk) {
        return (privateJwk instanceof RsaPrivateJwk) && DefaultRsaPublicJwk.equalsPublic(this, privateJwk) && Parameters.equals((ParameterReadable) this, (Object) privateJwk, (Parameter) PRIVATE_EXPONENT) && Parameters.equals((ParameterReadable) this, (Object) privateJwk, (Parameter) FIRST_PRIME) && Parameters.equals((ParameterReadable) this, (Object) privateJwk, (Parameter) SECOND_PRIME) && Parameters.equals((ParameterReadable) this, (Object) privateJwk, (Parameter) FIRST_CRT_EXPONENT) && Parameters.equals((ParameterReadable) this, (Object) privateJwk, (Parameter) SECOND_CRT_EXPONENT) && Parameters.equals((ParameterReadable) this, (Object) privateJwk, (Parameter) FIRST_CRT_COEFFICIENT) && equalsOtherPrimes(this, (ParameterReadable) privateJwk);
    }
}
