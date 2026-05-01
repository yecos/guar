package com.raizlabs.android.dbflow.converter;

import java.util.Date;

/* loaded from: classes3.dex */
public class DateConverter extends TypeConverter<Long, Date> {
    @Override // com.raizlabs.android.dbflow.converter.TypeConverter
    public Long getDBValue(Date date) {
        if (date == null) {
            return null;
        }
        return Long.valueOf(date.getTime());
    }

    @Override // com.raizlabs.android.dbflow.converter.TypeConverter
    public Date getModelValue(Long l10) {
        if (l10 == null) {
            return null;
        }
        return new Date(l10.longValue());
    }
}
