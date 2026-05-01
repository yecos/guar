package com.raizlabs.android.dbflow.sql.language.property;

import com.raizlabs.android.dbflow.converter.TypeConverter;
import com.raizlabs.android.dbflow.sql.language.NameAlias;
import com.raizlabs.android.dbflow.sql.language.Operator;

/* loaded from: classes3.dex */
public class TypeConvertedProperty<T, V> extends Property<V> {
    private boolean convertToDB;
    private TypeConvertedProperty<V, T> databaseProperty;
    private final TypeConverterGetter getter;

    public interface TypeConverterGetter {
        TypeConverter getTypeConverter(Class<?> cls);
    }

    public TypeConvertedProperty(Class<?> cls, NameAlias nameAlias, boolean z10, TypeConverterGetter typeConverterGetter) {
        super(cls, nameAlias);
        this.convertToDB = z10;
        this.getter = typeConverterGetter;
    }

    @Override // com.raizlabs.android.dbflow.sql.language.property.Property
    public Operator<V> getCondition() {
        return Operator.op(getNameAlias(), this.getter.getTypeConverter(this.table), this.convertToDB);
    }

    public Property<T> invertProperty() {
        if (this.databaseProperty == null) {
            this.databaseProperty = new TypeConvertedProperty<>(this.table, this.nameAlias, !this.convertToDB, new TypeConverterGetter() { // from class: com.raizlabs.android.dbflow.sql.language.property.TypeConvertedProperty.1
                @Override // com.raizlabs.android.dbflow.sql.language.property.TypeConvertedProperty.TypeConverterGetter
                public TypeConverter getTypeConverter(Class<?> cls) {
                    return TypeConvertedProperty.this.getter.getTypeConverter(cls);
                }
            });
        }
        return this.databaseProperty;
    }

    @Override // com.raizlabs.android.dbflow.sql.language.property.Property, com.raizlabs.android.dbflow.sql.language.property.IProperty
    public Property<V> withTable(NameAlias nameAlias) {
        return new TypeConvertedProperty(getTable(), getNameAlias().newBuilder().withTable(nameAlias.getQuery()).build(), this.convertToDB, this.getter);
    }

    public TypeConvertedProperty(Class<?> cls, String str, boolean z10, TypeConverterGetter typeConverterGetter) {
        super(cls, str);
        this.convertToDB = z10;
        this.getter = typeConverterGetter;
    }
}
