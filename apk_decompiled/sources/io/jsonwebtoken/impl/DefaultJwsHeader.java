package io.jsonwebtoken.impl;

import io.jsonwebtoken.JwsHeader;
import io.jsonwebtoken.impl.lang.Parameter;
import io.jsonwebtoken.impl.lang.Parameters;
import io.jsonwebtoken.lang.Collections;
import io.jsonwebtoken.lang.Registry;
import java.util.Map;
import java.util.Set;

/* loaded from: classes3.dex */
public class DefaultJwsHeader extends DefaultProtectedHeader implements JwsHeader {
    static final Parameter<Boolean> B64;
    static final Registry<String, Parameter<?>> PARAMS;

    static {
        Parameter<Boolean> parameter = (Parameter) Parameters.builder(Boolean.class).setId("b64").setName("Base64url-Encode Payload").build();
        B64 = parameter;
        PARAMS = Parameters.registry(DefaultProtectedHeader.PARAMS, parameter);
    }

    public DefaultJwsHeader(Map<String, ?> map) {
        super(PARAMS, map);
    }

    @Override // io.jsonwebtoken.impl.DefaultHeader, io.jsonwebtoken.impl.ParameterMap, io.jsonwebtoken.impl.lang.Nameable
    public String getName() {
        return "JWS header";
    }

    @Override // io.jsonwebtoken.JwsHeader
    public boolean isPayloadEncoded() {
        Set nullSafe = Collections.nullSafe((Set) getCritical());
        Parameter<Boolean> parameter = B64;
        Boolean bool = (Boolean) get((Parameter) parameter);
        return bool == null || bool.booleanValue() || !nullSafe.contains(parameter.getId());
    }
}
