package io.jsonwebtoken.impl.security;

import io.jsonwebtoken.impl.lang.Parameter;
import io.jsonwebtoken.impl.lang.ParameterReadable;
import io.jsonwebtoken.impl.lang.Parameters;
import io.jsonwebtoken.lang.Collections;
import io.jsonwebtoken.security.OctetPublicJwk;
import io.jsonwebtoken.security.PublicJwk;
import java.security.PublicKey;
import java.util.List;
import java.util.Set;

/* loaded from: classes3.dex */
public class DefaultOctetPublicJwk<T extends PublicKey> extends AbstractPublicJwk<T> implements OctetPublicJwk<T> {
    static final Parameter<String> CRV;
    static final Set<Parameter<?>> PARAMS;
    static final List<Parameter<?>> THUMBPRINT_PARAMS;
    static final String TYPE_VALUE = "OKP";
    static final Parameter<byte[]> X;

    /* JADX WARN: Multi-variable type inference failed */
    static {
        Parameter<String> parameter = DefaultEcPublicJwk.CRV;
        CRV = parameter;
        Parameter<byte[]> parameter2 = (Parameter) Parameters.bytes("x", "The public key").build();
        X = parameter2;
        PARAMS = Collections.concat(AbstractAsymmetricJwk.PARAMS, parameter, parameter2);
        THUMBPRINT_PARAMS = Collections.of(parameter, AbstractJwk.KTY, parameter2);
    }

    public DefaultOctetPublicJwk(JwkContext<T> jwkContext) {
        super(jwkContext, THUMBPRINT_PARAMS);
    }

    public static boolean equalsPublic(ParameterReadable parameterReadable, Object obj) {
        return Parameters.equals(parameterReadable, obj, (Parameter) CRV) && Parameters.equals(parameterReadable, obj, (Parameter) X);
    }

    @Override // io.jsonwebtoken.impl.security.AbstractPublicJwk
    public boolean equals(PublicJwk<?> publicJwk) {
        return (publicJwk instanceof OctetPublicJwk) && equalsPublic(this, publicJwk);
    }
}
