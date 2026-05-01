package com.raizlabs.android.dbflow.converter;

/* loaded from: classes3.dex */
public class BooleanConverter extends TypeConverter<Integer, Boolean> {
    @Override // com.raizlabs.android.dbflow.converter.TypeConverter
    public Integer getDBValue(Boolean bool) {
        if (bool == null) {
            return null;
        }
        return Integer.valueOf(bool.booleanValue() ? 1 : 0);
    }

    @Override // com.raizlabs.android.dbflow.converter.TypeConverter
    public Boolean getModelValue(Integer num) {
        if (num == null) {
            return null;
        }
        return Boolean.valueOf(num.intValue() == 1);
    }
}
