package io.jsonwebtoken.impl.lang;

import io.jsonwebtoken.lang.Assert;
import io.jsonwebtoken.lang.Objects;
import io.jsonwebtoken.lang.Supplier;

/* loaded from: classes3.dex */
public class RedactedSupplier<T> implements Supplier<T> {
    public static final String REDACTED_VALUE = "<redacted>";
    private final T value;

    public RedactedSupplier(T t10) {
        this.value = (T) Assert.notNull(t10, "value cannot be null.");
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof RedactedSupplier) {
            obj = ((RedactedSupplier) obj).value;
        }
        return Objects.nullSafeEquals(this.value, obj);
    }

    @Override // io.jsonwebtoken.lang.Supplier
    public T get() {
        return this.value;
    }

    public int hashCode() {
        return Objects.nullSafeHashCode(this.value);
    }

    public String toString() {
        return REDACTED_VALUE;
    }
}
