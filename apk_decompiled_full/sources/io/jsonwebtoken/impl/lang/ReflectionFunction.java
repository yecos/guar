package io.jsonwebtoken.impl.lang;

/* loaded from: classes3.dex */
abstract class ReflectionFunction<T, R> implements Function<T, R> {
    public static final String ERR_MSG = "Reflection operation failed. This is likely due to an internal implementation programming error.  Please report this to the JJWT development team.  Cause: ";

    @Override // io.jsonwebtoken.impl.lang.Function
    public final R apply(T t10) {
        if (!supports(t10)) {
            return null;
        }
        try {
            return invoke(t10);
        } catch (Throwable th) {
            throw new IllegalStateException(ERR_MSG + th.getMessage(), th);
        }
    }

    public abstract R invoke(T t10);

    public abstract boolean supports(T t10);
}
