package io.jsonwebtoken.impl.lang;

/* loaded from: classes3.dex */
public final class ConstantFunction<T, R> implements Function<T, R> {
    private final R value;

    public ConstantFunction(R r10) {
        this.value = r10;
    }

    @Override // io.jsonwebtoken.impl.lang.Function
    public R apply(T t10) {
        return this.value;
    }
}
