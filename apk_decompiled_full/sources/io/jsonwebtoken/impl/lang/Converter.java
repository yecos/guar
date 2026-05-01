package io.jsonwebtoken.impl.lang;

/* loaded from: classes3.dex */
public interface Converter<A, B> {
    A applyFrom(B b10);

    B applyTo(A a10);
}
