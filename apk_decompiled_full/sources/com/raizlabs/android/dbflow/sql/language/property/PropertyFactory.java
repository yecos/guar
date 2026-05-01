package com.raizlabs.android.dbflow.sql.language.property;

import com.raizlabs.android.dbflow.sql.language.NameAlias;
import com.raizlabs.android.dbflow.sql.language.Operator;
import com.raizlabs.android.dbflow.sql.queriable.ModelQueriable;

/* loaded from: classes3.dex */
public class PropertyFactory {
    public static Property<Character> from(char c10) {
        return new Property<>((Class<?>) null, NameAlias.rawBuilder("'" + c10 + "'").build());
    }

    public static Property<Integer> from(int i10) {
        return new Property<>((Class<?>) null, NameAlias.rawBuilder(i10 + "").build());
    }

    public static Property<Double> from(double d10) {
        return new Property<>((Class<?>) null, NameAlias.rawBuilder(d10 + "").build());
    }

    public static Property<Long> from(long j10) {
        return new Property<>((Class<?>) null, NameAlias.rawBuilder(j10 + "").build());
    }

    public static Property<Float> from(float f10) {
        return new Property<>((Class<?>) null, NameAlias.rawBuilder(f10 + "").build());
    }

    public static Property<Short> from(short s10) {
        return new Property<>((Class<?>) null, NameAlias.rawBuilder(((int) s10) + "").build());
    }

    public static Property<Byte> from(byte b10) {
        return new Property<>((Class<?>) null, NameAlias.rawBuilder(((int) b10) + "").build());
    }

    public static <T> Property<T> from(T t10) {
        return new Property<>((Class<?>) null, NameAlias.rawBuilder(Operator.convertValueToString(t10)).build());
    }

    public static <TModel> Property<TModel> from(ModelQueriable<TModel> modelQueriable) {
        return from(modelQueriable.getTable(), "(" + String.valueOf(modelQueriable.getQuery()).trim() + ")");
    }

    public static <T> Property<T> from(Class<T> cls, String str) {
        return new Property<>((Class<?>) null, NameAlias.rawBuilder(str).build());
    }
}
