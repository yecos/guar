package io.jsonwebtoken.impl.lang;

import io.jsonwebtoken.Header;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.impl.security.JwkContext;
import io.jsonwebtoken.lang.Assert;
import io.jsonwebtoken.security.Jwk;
import io.jsonwebtoken.security.MalformedKeyException;

/* loaded from: classes3.dex */
public class RequiredParameterReader implements ParameterReadable {
    private final ParameterReadable src;

    public RequiredParameterReader(Header header) {
        this((ParameterReadable) Assert.isInstanceOf(ParameterReadable.class, header, "Header implementations must implement ParameterReadable: "));
    }

    private JwtException malformed(String str) {
        ParameterReadable parameterReadable = this.src;
        return ((parameterReadable instanceof JwkContext) || (parameterReadable instanceof Jwk)) ? new MalformedKeyException(str) : new MalformedJwtException(str);
    }

    private String name() {
        return ((Nameable) this.src).getName();
    }

    @Override // io.jsonwebtoken.impl.lang.ParameterReadable
    public <T> T get(Parameter<T> parameter) {
        T t10 = (T) this.src.get(parameter);
        if (t10 != null) {
            return t10;
        }
        throw malformed(name() + " is missing required " + parameter + " value.");
    }

    public RequiredParameterReader(ParameterReadable parameterReadable) {
        this.src = (ParameterReadable) Assert.notNull(parameterReadable, "Source ParameterReadable cannot be null.");
        Assert.isInstanceOf(Nameable.class, parameterReadable, "ParameterReadable implementations must implement Nameable.");
    }
}
