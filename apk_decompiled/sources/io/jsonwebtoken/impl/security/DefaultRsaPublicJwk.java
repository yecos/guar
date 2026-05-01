package io.jsonwebtoken.impl.security;

import io.jsonwebtoken.impl.lang.Parameter;
import io.jsonwebtoken.impl.lang.ParameterReadable;
import io.jsonwebtoken.impl.lang.Parameters;
import io.jsonwebtoken.lang.Collections;
import io.jsonwebtoken.security.PublicJwk;
import io.jsonwebtoken.security.RsaPublicJwk;
import java.math.BigInteger;
import java.security.interfaces.RSAPublicKey;
import java.util.List;
import java.util.Set;

/* loaded from: classes3.dex */
class DefaultRsaPublicJwk extends AbstractPublicJwk<RSAPublicKey> implements RsaPublicJwk {
    static final Parameter<BigInteger> MODULUS;
    static final Set<Parameter<?>> PARAMS;
    static final Parameter<BigInteger> PUBLIC_EXPONENT;
    static final List<Parameter<?>> THUMBPRINT_PARAMS;
    static final String TYPE_VALUE = "RSA";

    static {
        Parameter<BigInteger> parameter = (Parameter) Parameters.bigInt("n", "Modulus").build();
        MODULUS = parameter;
        Parameter<BigInteger> parameter2 = (Parameter) Parameters.bigInt("e", "Public Exponent").build();
        PUBLIC_EXPONENT = parameter2;
        PARAMS = Collections.concat(AbstractAsymmetricJwk.PARAMS, parameter, parameter2);
        THUMBPRINT_PARAMS = Collections.of(parameter2, AbstractJwk.KTY, parameter);
    }

    public DefaultRsaPublicJwk(JwkContext<RSAPublicKey> jwkContext) {
        super(jwkContext, THUMBPRINT_PARAMS);
    }

    public static boolean equalsPublic(ParameterReadable parameterReadable, Object obj) {
        return Parameters.equals(parameterReadable, obj, (Parameter) MODULUS) && Parameters.equals(parameterReadable, obj, (Parameter) PUBLIC_EXPONENT);
    }

    @Override // io.jsonwebtoken.impl.security.AbstractPublicJwk
    public boolean equals(PublicJwk<?> publicJwk) {
        return (publicJwk instanceof RsaPublicJwk) && equalsPublic(this, publicJwk);
    }
}
