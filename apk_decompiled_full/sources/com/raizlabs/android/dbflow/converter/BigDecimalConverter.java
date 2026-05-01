package com.raizlabs.android.dbflow.converter;

import java.math.BigDecimal;

/* loaded from: classes3.dex */
public class BigDecimalConverter extends TypeConverter<String, BigDecimal> {
    @Override // com.raizlabs.android.dbflow.converter.TypeConverter
    public String getDBValue(BigDecimal bigDecimal) {
        if (bigDecimal == null) {
            return null;
        }
        return bigDecimal.toString();
    }

    @Override // com.raizlabs.android.dbflow.converter.TypeConverter
    public BigDecimal getModelValue(String str) {
        if (str == null) {
            return null;
        }
        return new BigDecimal(str);
    }
}
