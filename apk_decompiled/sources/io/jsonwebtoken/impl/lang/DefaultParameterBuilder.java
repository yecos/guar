package io.jsonwebtoken.impl.lang;

import io.jsonwebtoken.lang.Assert;
import java.util.Collection;
import java.util.List;
import java.util.Set;

/* loaded from: classes3.dex */
public class DefaultParameterBuilder<T> implements ParameterBuilder<T> {
    private Class<? extends Collection<T>> collectionType;
    private Converter<T, ?> converter;
    private String id;
    private String name;
    private boolean secret;
    private final Class<T> type;

    public DefaultParameterBuilder(Class<T> cls) {
        this.type = (Class) Assert.notNull(cls, "Type cannot be null.");
    }

    @Override // io.jsonwebtoken.impl.lang.ParameterBuilder
    public ParameterBuilder<List<T>> list() {
        this.collectionType = List.class;
        return this;
    }

    @Override // io.jsonwebtoken.impl.lang.ParameterBuilder
    public ParameterBuilder<Set<T>> set() {
        this.collectionType = Set.class;
        return this;
    }

    @Override // io.jsonwebtoken.impl.lang.ParameterBuilder
    public ParameterBuilder<T> setConverter(Converter<T, ?> converter) {
        this.converter = converter;
        return this;
    }

    @Override // io.jsonwebtoken.impl.lang.ParameterBuilder
    public ParameterBuilder<T> setId(String str) {
        this.id = str;
        return this;
    }

    @Override // io.jsonwebtoken.impl.lang.ParameterBuilder
    public ParameterBuilder<T> setName(String str) {
        this.name = str;
        return this;
    }

    @Override // io.jsonwebtoken.impl.lang.ParameterBuilder
    public ParameterBuilder<T> setSecret(boolean z10) {
        this.secret = z10;
        return this;
    }

    @Override // io.jsonwebtoken.lang.Builder
    public Parameter<T> build() {
        Assert.notNull(this.type, "Type must be set.");
        Converter<T, ?> converter = this.converter;
        if (converter == null) {
            converter = Converters.forType(this.type);
        }
        Class<? extends Collection<T>> cls = this.collectionType;
        if (cls != null) {
            converter = List.class.isAssignableFrom(cls) ? Converters.forList(converter) : Converters.forSet(converter);
        }
        return new DefaultParameter(this.id, this.name, this.secret, this.type, this.collectionType, this.secret ? new RedactedValueConverter(converter) : converter);
    }
}
