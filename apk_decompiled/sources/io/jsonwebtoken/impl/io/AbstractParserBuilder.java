package io.jsonwebtoken.impl.io;

import io.jsonwebtoken.impl.lang.Services;
import io.jsonwebtoken.io.Deserializer;
import io.jsonwebtoken.io.Parser;
import io.jsonwebtoken.io.ParserBuilder;
import java.security.Provider;
import java.util.Map;

/* loaded from: classes3.dex */
public abstract class AbstractParserBuilder<T, B extends ParserBuilder<T, B>> implements ParserBuilder<T, B> {
    protected Deserializer<Map<String, ?>> deserializer;
    protected Provider provider;

    public abstract Parser<T> doBuild();

    @Override // io.jsonwebtoken.io.ParserBuilder
    public B json(Deserializer<Map<String, ?>> deserializer) {
        this.deserializer = deserializer;
        return self();
    }

    @Override // io.jsonwebtoken.io.ParserBuilder
    public B provider(Provider provider) {
        this.provider = provider;
        return self();
    }

    public final B self() {
        return this;
    }

    @Override // io.jsonwebtoken.lang.Builder
    public final Parser<T> build() {
        if (this.deserializer == null) {
            this.deserializer = (Deserializer) Services.get(Deserializer.class);
        }
        return doBuild();
    }
}
