package io.jsonwebtoken.impl.security;

import io.jsonwebtoken.impl.io.ConvertingParser;
import io.jsonwebtoken.io.Parser;
import io.jsonwebtoken.security.JwkSet;
import io.jsonwebtoken.security.JwkSetParserBuilder;

/* loaded from: classes3.dex */
public class DefaultJwkSetParserBuilder extends AbstractJwkParserBuilder<JwkSet, JwkSetParserBuilder> implements JwkSetParserBuilder {
    private boolean ignoreUnsupported = true;

    @Override // io.jsonwebtoken.impl.io.AbstractParserBuilder
    public Parser<JwkSet> doBuild() {
        return new ConvertingParser(new JwkSetDeserializer(this.deserializer), new JwkSetConverter(new JwkBuilderSupplier(this.provider, this.operationPolicy), this.ignoreUnsupported));
    }

    @Override // io.jsonwebtoken.security.JwkSetParserBuilder
    public JwkSetParserBuilder ignoreUnsupported(boolean z10) {
        this.ignoreUnsupported = z10;
        return this;
    }
}
