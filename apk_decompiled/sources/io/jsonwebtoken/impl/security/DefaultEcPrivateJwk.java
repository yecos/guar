package io.jsonwebtoken.impl.security;

import io.jsonwebtoken.impl.lang.Parameter;
import io.jsonwebtoken.impl.lang.ParameterReadable;
import io.jsonwebtoken.impl.lang.Parameters;
import io.jsonwebtoken.lang.Collections;
import io.jsonwebtoken.security.EcPrivateJwk;
import io.jsonwebtoken.security.EcPublicJwk;
import io.jsonwebtoken.security.PrivateJwk;
import java.math.BigInteger;
import java.security.interfaces.ECPrivateKey;
import java.security.interfaces.ECPublicKey;
import java.util.Set;

/* loaded from: classes3.dex */
class DefaultEcPrivateJwk extends AbstractPrivateJwk<ECPrivateKey, ECPublicKey, EcPublicJwk> implements EcPrivateJwk {
    static final Parameter<BigInteger> D;
    static final Set<Parameter<?>> PARAMS;

    static {
        Parameter<BigInteger> parameter = (Parameter) Parameters.bigInt("d", "ECC Private Key").setConverter(FieldElementConverter.B64URL_CONVERTER).setSecret(true).build();
        D = parameter;
        PARAMS = Collections.concat(DefaultEcPublicJwk.PARAMS, parameter);
    }

    public DefaultEcPrivateJwk(JwkContext<ECPrivateKey> jwkContext, EcPublicJwk ecPublicJwk) {
        super(jwkContext, DefaultEcPublicJwk.THUMBPRINT_PARAMS, ecPublicJwk);
    }

    @Override // io.jsonwebtoken.impl.security.AbstractPrivateJwk
    public boolean equals(PrivateJwk<?, ?, ?> privateJwk) {
        return (privateJwk instanceof EcPrivateJwk) && DefaultEcPublicJwk.equalsPublic(this, privateJwk) && Parameters.equals((ParameterReadable) this, (Object) privateJwk, (Parameter) D);
    }
}
