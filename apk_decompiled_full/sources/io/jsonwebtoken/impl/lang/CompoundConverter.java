package io.jsonwebtoken.impl.lang;

import io.jsonwebtoken.lang.Assert;

/* loaded from: classes3.dex */
public class CompoundConverter<A, B, C> implements Converter<A, C> {
    private final Converter<A, B> first;
    private final Converter<B, C> second;

    public CompoundConverter(Converter<A, B> converter, Converter<B, C> converter2) {
        this.first = (Converter) Assert.notNull(converter, "First converter cannot be null.");
        this.second = (Converter) Assert.notNull(converter2, "Second converter cannot be null.");
    }

    @Override // io.jsonwebtoken.impl.lang.Converter
    public A applyFrom(C c10) {
        return this.first.applyFrom(this.second.applyFrom(c10));
    }

    @Override // io.jsonwebtoken.impl.lang.Converter
    public C applyTo(A a10) {
        return this.second.applyTo(this.first.applyTo(a10));
    }
}
