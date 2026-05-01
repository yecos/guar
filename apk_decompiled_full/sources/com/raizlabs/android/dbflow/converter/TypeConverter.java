package com.raizlabs.android.dbflow.converter;

@com.raizlabs.android.dbflow.annotation.TypeConverter
/* loaded from: classes3.dex */
public abstract class TypeConverter<DataClass, ModelClass> {
    public abstract DataClass getDBValue(ModelClass modelclass);

    public abstract ModelClass getModelValue(DataClass dataclass);
}
