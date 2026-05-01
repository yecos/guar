package io.jsonwebtoken.impl.lang;

import io.jsonwebtoken.Identifiable;

/* loaded from: classes3.dex */
public interface Parameter<T> extends Identifiable, Converter<T, Object> {
    T cast(Object obj);

    String getName();

    boolean isSecret();

    boolean supports(Object obj);
}
