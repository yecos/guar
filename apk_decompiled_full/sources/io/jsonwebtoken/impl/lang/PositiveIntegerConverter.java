package io.jsonwebtoken.impl.lang;

import io.jsonwebtoken.lang.Assert;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes3.dex */
public class PositiveIntegerConverter implements Converter<Integer, Object> {
    public static final PositiveIntegerConverter INSTANCE = new PositiveIntegerConverter();

    @Override // io.jsonwebtoken.impl.lang.Converter
    public Object applyTo(Integer num) {
        return num;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // io.jsonwebtoken.impl.lang.Converter
    public Integer applyFrom(Object obj) {
        int intValue;
        Assert.notNull(obj, "Argument cannot be null.");
        if ((obj instanceof Byte) || (obj instanceof Short) || (obj instanceof Integer) || (obj instanceof AtomicInteger)) {
            intValue = ((Number) obj).intValue();
        } else {
            try {
                intValue = Integer.parseInt(String.valueOf(obj));
            } catch (NumberFormatException e10) {
                throw new IllegalArgumentException("Value cannot be represented as a java.lang.Integer.", e10);
            }
        }
        if (intValue > 0) {
            return Integer.valueOf(intValue);
        }
        throw new IllegalArgumentException("Value must be a positive integer.");
    }
}
