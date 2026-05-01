package io.jsonwebtoken.impl.lang;

import io.jsonwebtoken.lang.Assert;
import io.jsonwebtoken.lang.Classes;
import io.jsonwebtoken.lang.Supplier;
import java.lang.RuntimeException;

/* loaded from: classes3.dex */
public class PropagatingExceptionFunction<T, R, E extends RuntimeException> implements Function<T, R> {
    private final Class<E> clazz;
    private final CheckedFunction<T, R> function;
    private final Function<T, String> msgFunction;

    public PropagatingExceptionFunction(Function<T, R> function, Class<E> cls, String str) {
        this(new DelegatingCheckedFunction(function), cls, new ConstantFunction(str));
    }

    @Override // io.jsonwebtoken.impl.lang.Function
    public R apply(T t10) {
        try {
            return this.function.apply(t10);
        } catch (Exception e10) {
            if (this.clazz.isAssignableFrom(e10.getClass())) {
                throw this.clazz.cast(e10);
            }
            String apply = this.msgFunction.apply(t10);
            if (!apply.endsWith(".")) {
                apply = apply + ".";
            }
            throw ((RuntimeException) Classes.instantiate(Classes.getConstructor(this.clazz, String.class, Throwable.class), apply + " Cause: " + e10.getMessage(), e10));
        }
    }

    public PropagatingExceptionFunction(CheckedFunction<T, R> checkedFunction, Class<E> cls, String str) {
        this(checkedFunction, cls, new ConstantFunction(str));
    }

    public PropagatingExceptionFunction(CheckedFunction<T, R> checkedFunction, Class<E> cls, final Supplier<String> supplier) {
        this(checkedFunction, cls, new Function<T, String>() { // from class: io.jsonwebtoken.impl.lang.PropagatingExceptionFunction.1
            @Override // io.jsonwebtoken.impl.lang.Function
            public /* bridge */ /* synthetic */ String apply(Object obj) {
                return apply2((AnonymousClass1) obj);
            }

            @Override // io.jsonwebtoken.impl.lang.Function
            /* renamed from: apply, reason: avoid collision after fix types in other method */
            public String apply2(T t10) {
                return (String) Supplier.this.get();
            }
        });
    }

    public PropagatingExceptionFunction(CheckedFunction<T, R> checkedFunction, Class<E> cls, Function<T, String> function) {
        this.clazz = (Class) Assert.notNull(cls, "Exception class cannot be null.");
        this.msgFunction = (Function) Assert.notNull(function, "msgFunction cannot be null.");
        this.function = (CheckedFunction) Assert.notNull(checkedFunction, "Function cannot be null");
    }
}
