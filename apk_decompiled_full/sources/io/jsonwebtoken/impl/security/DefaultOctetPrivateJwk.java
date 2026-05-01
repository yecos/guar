package io.jsonwebtoken.impl.security;

import io.jsonwebtoken.impl.lang.Parameter;
import io.jsonwebtoken.impl.lang.ParameterReadable;
import io.jsonwebtoken.impl.lang.Parameters;
import io.jsonwebtoken.lang.Collections;
import io.jsonwebtoken.security.KeyPair;
import io.jsonwebtoken.security.OctetPrivateJwk;
import io.jsonwebtoken.security.OctetPublicJwk;
import io.jsonwebtoken.security.PrivateJwk;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Set;

/* loaded from: classes3.dex */
public class DefaultOctetPrivateJwk<T extends PrivateKey, P extends PublicKey> extends AbstractPrivateJwk<T, P, OctetPublicJwk<P>> implements OctetPrivateJwk<T, P> {
    static final Parameter<byte[]> D;
    static final Set<Parameter<?>> PARAMS;

    /* JADX WARN: Multi-variable type inference failed */
    static {
        Parameter<byte[]> parameter = (Parameter) Parameters.bytes("d", "The private key").setSecret(true).build();
        D = parameter;
        PARAMS = Collections.concat(DefaultOctetPublicJwk.PARAMS, parameter);
    }

    public DefaultOctetPrivateJwk(JwkContext<T> jwkContext, OctetPublicJwk<P> octetPublicJwk) {
        super(jwkContext, DefaultOctetPublicJwk.THUMBPRINT_PARAMS, octetPublicJwk);
    }

    @Override // io.jsonwebtoken.impl.security.AbstractPrivateJwk
    public boolean equals(PrivateJwk<?, ?, ?> privateJwk) {
        return (privateJwk instanceof OctetPrivateJwk) && DefaultOctetPublicJwk.equalsPublic(this, privateJwk) && Parameters.equals((ParameterReadable) this, (Object) privateJwk, (Parameter) D);
    }

    @Override // io.jsonwebtoken.impl.security.AbstractPrivateJwk, io.jsonwebtoken.security.PrivateJwk
    public /* bridge */ /* synthetic */ KeyPair toKeyPair() {
        return super.toKeyPair();
    }
}
