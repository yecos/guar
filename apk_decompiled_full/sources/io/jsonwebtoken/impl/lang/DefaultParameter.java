package io.jsonwebtoken.impl.lang;

import com.raizlabs.android.dbflow.sql.language.Operator;
import io.jsonwebtoken.lang.Assert;
import io.jsonwebtoken.lang.Strings;
import java.util.Collection;

/* loaded from: classes3.dex */
public class DefaultParameter<T> implements Parameter<T> {
    private final Class<? extends Collection<T>> COLLECTION_TYPE;
    private final Converter<T, Object> CONVERTER;
    private final String ID;
    private final Class<T> IDIOMATIC_TYPE;
    private final String NAME;
    private final boolean SECRET;

    public DefaultParameter(String str, String str2, boolean z10, Class<T> cls, Class<? extends Collection<T>> cls2, Converter<T, Object> converter) {
        this.ID = Strings.clean((String) Assert.hasText(str, "ID argument cannot be null or empty."));
        this.NAME = Strings.clean((String) Assert.hasText(str2, "Name argument cannot be null or empty."));
        this.IDIOMATIC_TYPE = (Class) Assert.notNull(cls, "idiomaticType argument cannot be null.");
        this.CONVERTER = (Converter) Assert.notNull(converter, "Converter argument cannot be null.");
        this.SECRET = z10;
        this.COLLECTION_TYPE = cls2;
    }

    @Override // io.jsonwebtoken.impl.lang.Converter
    public T applyFrom(Object obj) {
        return this.CONVERTER.applyFrom(obj);
    }

    @Override // io.jsonwebtoken.impl.lang.Converter
    public Object applyTo(T t10) {
        return this.CONVERTER.applyTo(t10);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.jsonwebtoken.impl.lang.Parameter
    public T cast(Object obj) {
        if (obj != 0) {
            Class<? extends Collection<T>> cls = this.COLLECTION_TYPE;
            if (cls != null) {
                if (!cls.isInstance(obj)) {
                    throw new ClassCastException("Cannot cast " + obj.getClass().getName() + " to " + this.COLLECTION_TYPE.getName() + Operator.Operation.LESS_THAN + this.IDIOMATIC_TYPE.getName() + Operator.Operation.GREATER_THAN);
                }
                Collection<T> cast = this.COLLECTION_TYPE.cast(obj);
                if (!cast.isEmpty()) {
                    if (!this.IDIOMATIC_TYPE.isInstance(cast.iterator().next())) {
                        throw new ClassCastException("Cannot cast " + obj.getClass().getName() + " to " + this.COLLECTION_TYPE.getName() + Operator.Operation.LESS_THAN + this.IDIOMATIC_TYPE.getName() + ">: At least one element is not an instance of " + this.IDIOMATIC_TYPE.getName());
                    }
                }
            } else if (!this.IDIOMATIC_TYPE.isInstance(obj)) {
                throw new ClassCastException("Cannot cast " + obj.getClass().getName() + " to " + this.IDIOMATIC_TYPE.getName());
            }
        }
        return obj;
    }

    public boolean equals(Object obj) {
        if (obj instanceof Parameter) {
            return this.ID.equals(((Parameter) obj).getId());
        }
        return false;
    }

    @Override // io.jsonwebtoken.Identifiable
    public String getId() {
        return this.ID;
    }

    @Override // io.jsonwebtoken.impl.lang.Parameter
    public String getName() {
        return this.NAME;
    }

    public int hashCode() {
        return this.ID.hashCode();
    }

    @Override // io.jsonwebtoken.impl.lang.Parameter
    public boolean isSecret() {
        return this.SECRET;
    }

    @Override // io.jsonwebtoken.impl.lang.Parameter
    public boolean supports(Object obj) {
        if (obj == null) {
            return true;
        }
        Class<? extends Collection<T>> cls = this.COLLECTION_TYPE;
        if (cls == null || !cls.isInstance(obj)) {
            return this.IDIOMATIC_TYPE.isInstance(obj);
        }
        Collection<T> cast = this.COLLECTION_TYPE.cast(obj);
        return cast.isEmpty() || this.IDIOMATIC_TYPE.isInstance(cast.iterator().next());
    }

    public String toString() {
        return "'" + this.ID + "' (" + this.NAME + ")";
    }
}
