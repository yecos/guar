package io.jsonwebtoken.impl.lang;

import io.jsonwebtoken.lang.Assert;

/* loaded from: classes3.dex */
public class RequiredTypeConverter<T> implements Converter<T, Object> {
    private final Class<T> type;

    public RequiredTypeConverter(Class<T> cls) {
        this.type = (Class) Assert.notNull(cls, "type argument cannot be null.");
    }

    @Override // io.jsonwebtoken.impl.lang.Converter
    public T applyFrom(Object obj) {
        if (obj == null) {
            return null;
        }
        Class<?> cls = obj.getClass();
        if (this.type.isAssignableFrom(cls)) {
            return this.type.cast(obj);
        }
        throw new IllegalArgumentException("Unsupported value type. Expected: " + this.type.getName() + ", found: " + cls.getName());
    }

    @Override // io.jsonwebtoken.impl.lang.Converter
    public Object applyTo(T t10) {
        return t10;
    }
}
