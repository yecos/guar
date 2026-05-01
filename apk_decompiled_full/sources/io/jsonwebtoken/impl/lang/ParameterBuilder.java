package io.jsonwebtoken.impl.lang;

import io.jsonwebtoken.lang.Builder;
import java.util.List;
import java.util.Set;

/* loaded from: classes3.dex */
public interface ParameterBuilder<T> extends Builder<Parameter<T>> {
    ParameterBuilder<List<T>> list();

    ParameterBuilder<Set<T>> set();

    ParameterBuilder<T> setConverter(Converter<T, ?> converter);

    ParameterBuilder<T> setId(String str);

    ParameterBuilder<T> setName(String str);

    ParameterBuilder<T> setSecret(boolean z10);
}
