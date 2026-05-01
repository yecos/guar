package com.raizlabs.android.dbflow.converter;

import java.util.Calendar;
import java.util.GregorianCalendar;

@com.raizlabs.android.dbflow.annotation.TypeConverter(allowedSubtypes = {GregorianCalendar.class})
/* loaded from: classes3.dex */
public class CalendarConverter extends TypeConverter<Long, Calendar> {
    @Override // com.raizlabs.android.dbflow.converter.TypeConverter
    public Long getDBValue(Calendar calendar) {
        if (calendar == null) {
            return null;
        }
        return Long.valueOf(calendar.getTimeInMillis());
    }

    @Override // com.raizlabs.android.dbflow.converter.TypeConverter
    public Calendar getModelValue(Long l10) {
        if (l10 == null) {
            return null;
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(l10.longValue());
        return calendar;
    }
}
