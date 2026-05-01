package io.jsonwebtoken.impl.io;

import io.jsonwebtoken.impl.lang.Converter;
import io.jsonwebtoken.impl.lang.Function;
import io.jsonwebtoken.lang.Assert;
import java.io.Reader;
import java.util.Map;

/* loaded from: classes3.dex */
public class ConvertingParser<T> extends AbstractParser<T> {
    private final Converter<T, Object> converter;
    private final Function<Reader, Map<String, ?>> deserializer;

    public ConvertingParser(Function<Reader, Map<String, ?>> function, Converter<T, Object> converter) {
        this.deserializer = (Function) Assert.notNull(function, "Deserializer function cannot be null.");
        this.converter = (Converter) Assert.notNull(converter, "Converter cannot be null.");
    }

    @Override // io.jsonwebtoken.io.Parser
    public final T parse(Reader reader) {
        Assert.notNull(reader, "Reader cannot be null.");
        return this.converter.applyFrom(this.deserializer.apply(reader));
    }
}
