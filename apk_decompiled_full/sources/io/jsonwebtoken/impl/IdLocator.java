package io.jsonwebtoken.impl;

import io.jsonwebtoken.Header;
import io.jsonwebtoken.Identifiable;
import io.jsonwebtoken.JweHeader;
import io.jsonwebtoken.JwsHeader;
import io.jsonwebtoken.Locator;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.UnsupportedJwtException;
import io.jsonwebtoken.impl.lang.Function;
import io.jsonwebtoken.impl.lang.Parameter;
import io.jsonwebtoken.lang.Assert;
import io.jsonwebtoken.lang.Registry;
import io.jsonwebtoken.lang.Strings;

/* loaded from: classes3.dex */
public class IdLocator<H extends Header, R extends Identifiable> implements Locator<R>, Function<H, R> {
    private final Parameter<String> param;
    private final Registry<String, R> registry;
    private final String requiredMsg;
    private final boolean valueRequired;

    public IdLocator(Parameter<String> parameter, Registry<String, R> registry, String str) {
        this.param = (Parameter) Assert.notNull(parameter, "Header param cannot be null.");
        String clean = Strings.clean(str);
        this.requiredMsg = clean;
        this.valueRequired = Strings.hasText(clean);
        Assert.notEmpty(registry, "Registry cannot be null or empty.");
        this.registry = registry;
    }

    private static String type(Header header) {
        return header instanceof JweHeader ? "JWE" : header instanceof JwsHeader ? "JWS" : Header.JWT_TYPE;
    }

    @Override // io.jsonwebtoken.impl.lang.Function
    public R apply(H h10) {
        return locate((Header) h10);
    }

    @Override // io.jsonwebtoken.Locator
    public R locate(Header header) {
        Assert.notNull(header, "Header argument cannot be null.");
        Object obj = header.get(this.param.getId());
        String obj2 = obj != null ? obj.toString() : null;
        if (!Strings.hasText(obj2)) {
            if (this.valueRequired) {
                throw new MalformedJwtException(this.requiredMsg);
            }
            return null;
        }
        try {
            return this.registry.forKey(obj2);
        } catch (Exception e10) {
            throw new UnsupportedJwtException("Unrecognized " + type(header) + " " + this.param + " header value: " + obj2, e10);
        }
    }
}
