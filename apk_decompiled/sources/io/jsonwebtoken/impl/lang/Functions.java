package io.jsonwebtoken.impl.lang;

import io.jsonwebtoken.lang.Assert;

/* loaded from: classes3.dex */
public final class Functions {
    private Functions() {
    }

    public static <T, V, R> Function<T, R> andThen(final Function<T, ? extends V> function, final Function<V, R> function2) {
        Assert.notNull(function, "Before function cannot be null.");
        Assert.notNull(function2, "After function cannot be null.");
        return new Function<T, R>() { // from class: io.jsonwebtoken.impl.lang.Functions.2
            /* JADX WARN: Multi-variable type inference failed */
            @Override // io.jsonwebtoken.impl.lang.Function
            public R apply(T t10) {
                return (R) function2.apply(Function.this.apply(t10));
            }
        };
    }

    @SafeVarargs
    public static <T, R> Function<T, R> firstResult(final Function<T, R>... functionArr) {
        Assert.notEmpty(functionArr, "Function list cannot be null or empty.");
        return new Function<T, R>() { // from class: io.jsonwebtoken.impl.lang.Functions.3
            @Override // io.jsonwebtoken.impl.lang.Function
            public R apply(T t10) {
                for (Function function : functionArr) {
                    Assert.notNull(function, "Function cannot be null.");
                    R r10 = (R) function.apply(t10);
                    if (r10 != null) {
                        return r10;
                    }
                }
                return null;
            }
        };
    }

    public static <T> Function<T, T> identity() {
        return new Function<T, T>() { // from class: io.jsonwebtoken.impl.lang.Functions.1
            @Override // io.jsonwebtoken.impl.lang.Function
            public T apply(T t10) {
                return t10;
            }
        };
    }

    public static <T, R, E extends RuntimeException> Function<T, R> wrap(Function<T, R> function, Class<E> cls, String str, Object... objArr) {
        return new PropagatingExceptionFunction(new DelegatingCheckedFunction(function), cls, new FormattedStringSupplier(str, objArr));
    }

    public static <T, R, E extends RuntimeException> Function<T, R> wrapFmt(CheckedFunction<T, R> checkedFunction, Class<E> cls, String str) {
        return new PropagatingExceptionFunction(checkedFunction, cls, new FormattedStringFunction(str));
    }
}
