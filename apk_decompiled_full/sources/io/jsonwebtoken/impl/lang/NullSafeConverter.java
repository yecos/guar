package io.jsonwebtoken.impl.lang;

import io.jsonwebtoken.lang.Assert;

/* loaded from: classes3.dex */
public class NullSafeConverter<A, B> implements Converter<A, B> {
    private final Converter<A, B> converter;

    public NullSafeConverter(Converter<A, B> converter) {
        this.converter = (Converter) Assert.notNull(converter, "Delegate converter cannot be null.");
    }

    @Override // io.jsonwebtoken.impl.lang.Converter
    public A applyFrom(B b10) {
        if (b10 == null) {
            return null;
        }
        return this.converter.applyFrom(b10);
    }

    @Override // io.jsonwebtoken.impl.lang.Converter
    public B applyTo(A a10) {
        if (a10 == null) {
            return null;
        }
        return this.converter.applyTo(a10);
    }
}
