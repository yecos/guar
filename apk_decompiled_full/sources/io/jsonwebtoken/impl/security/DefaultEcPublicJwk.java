package io.jsonwebtoken.impl.security;

import com.umeng.analytics.pro.bt;
import io.jsonwebtoken.impl.lang.Converter;
import io.jsonwebtoken.impl.lang.Parameter;
import io.jsonwebtoken.impl.lang.ParameterBuilder;
import io.jsonwebtoken.impl.lang.ParameterReadable;
import io.jsonwebtoken.impl.lang.Parameters;
import io.jsonwebtoken.lang.Collections;
import io.jsonwebtoken.security.EcPublicJwk;
import io.jsonwebtoken.security.PublicJwk;
import java.math.BigInteger;
import java.security.interfaces.ECPublicKey;
import java.util.List;
import java.util.Set;

/* loaded from: classes3.dex */
class DefaultEcPublicJwk extends AbstractPublicJwk<ECPublicKey> implements EcPublicJwk {
    static final Parameter<String> CRV;
    static final Set<Parameter<?>> PARAMS;
    static final List<Parameter<?>> THUMBPRINT_PARAMS;
    static final String TYPE_VALUE = "EC";
    static final Parameter<BigInteger> X;
    static final Parameter<BigInteger> Y;

    static {
        Parameter<String> string = Parameters.string(bt.bg, "Curve");
        CRV = string;
        ParameterBuilder<BigInteger> bigInt = Parameters.bigInt("x", "X Coordinate");
        Converter<BigInteger, ?> converter = FieldElementConverter.B64URL_CONVERTER;
        Parameter<BigInteger> parameter = (Parameter) bigInt.setConverter(converter).build();
        X = parameter;
        Parameter<BigInteger> parameter2 = (Parameter) Parameters.bigInt("y", "Y Coordinate").setConverter(converter).build();
        Y = parameter2;
        PARAMS = Collections.concat(AbstractAsymmetricJwk.PARAMS, string, parameter, parameter2);
        THUMBPRINT_PARAMS = Collections.of(string, AbstractJwk.KTY, parameter, parameter2);
    }

    public DefaultEcPublicJwk(JwkContext<ECPublicKey> jwkContext) {
        super(jwkContext, THUMBPRINT_PARAMS);
    }

    public static boolean equalsPublic(ParameterReadable parameterReadable, Object obj) {
        return Parameters.equals(parameterReadable, obj, (Parameter) CRV) && Parameters.equals(parameterReadable, obj, (Parameter) X) && Parameters.equals(parameterReadable, obj, (Parameter) Y);
    }

    @Override // io.jsonwebtoken.impl.security.AbstractPublicJwk
    public boolean equals(PublicJwk<?> publicJwk) {
        return (publicJwk instanceof EcPublicJwk) && equalsPublic(this, publicJwk);
    }
}
