package io.jsonwebtoken.impl.security;

import io.jsonwebtoken.impl.lang.Parameter;
import io.jsonwebtoken.impl.lang.ParameterReadable;
import io.jsonwebtoken.impl.lang.Parameters;
import io.jsonwebtoken.lang.Collections;
import io.jsonwebtoken.security.Jwk;
import io.jsonwebtoken.security.SecretJwk;
import java.util.List;
import java.util.Set;
import javax.crypto.SecretKey;

/* loaded from: classes3.dex */
class DefaultSecretJwk extends AbstractJwk<SecretKey> implements SecretJwk {
    static final Parameter<byte[]> K;
    static final Set<Parameter<?>> PARAMS;
    static final List<Parameter<?>> THUMBPRINT_PARAMS;
    static final String TYPE_VALUE = "oct";

    /* JADX WARN: Multi-variable type inference failed */
    static {
        Parameter<byte[]> parameter = (Parameter) Parameters.bytes("k", "Key Value").setSecret(true).build();
        K = parameter;
        PARAMS = Collections.concat(AbstractJwk.PARAMS, parameter);
        THUMBPRINT_PARAMS = Collections.of(parameter, AbstractJwk.KTY);
    }

    public DefaultSecretJwk(JwkContext<SecretKey> jwkContext) {
        super(jwkContext, THUMBPRINT_PARAMS);
    }

    @Override // io.jsonwebtoken.impl.security.AbstractJwk
    public boolean equals(Jwk<?> jwk) {
        return (jwk instanceof SecretJwk) && Parameters.equals((ParameterReadable) this, (Object) jwk, (Parameter) K);
    }
}
