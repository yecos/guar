package io.jsonwebtoken.impl.security;

import io.jsonwebtoken.impl.io.ConvertingParser;
import io.jsonwebtoken.io.Parser;
import io.jsonwebtoken.security.Jwk;
import io.jsonwebtoken.security.JwkParserBuilder;

/* loaded from: classes3.dex */
public class DefaultJwkParserBuilder extends AbstractJwkParserBuilder<Jwk<?>, JwkParserBuilder> implements JwkParserBuilder {
    @Override // io.jsonwebtoken.impl.io.AbstractParserBuilder
    public Parser<Jwk<?>> doBuild() {
        return new ConvertingParser(new JwkDeserializer(this.deserializer), new JwkConverter(new JwkBuilderSupplier(this.provider, this.operationPolicy)));
    }
}
