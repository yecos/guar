package com.google.android.material.datepicker;

import android.os.Build;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/* loaded from: classes2.dex */
class DateStrings {
    private DateStrings() {
    }

    public static a0.d getDateRangeString(Long l10, Long l11) {
        return getDateRangeString(l10, l11, null);
    }

    public static String getDateString(long j10) {
        return getDateString(j10, null);
    }

    public static String getMonthDay(long j10) {
        return getMonthDay(j10, Locale.getDefault());
    }

    public static String getMonthDayOfWeekDay(long j10) {
        return getMonthDayOfWeekDay(j10, Locale.getDefault());
    }

    public static String getYearMonthDay(long j10) {
        return getYearMonthDay(j10, Locale.getDefault());
    }

    public static String getYearMonthDayOfWeekDay(long j10) {
        return getYearMonthDayOfWeekDay(j10, Locale.getDefault());
    }

    public static a0.d getDateRangeString(Long l10, Long l11, SimpleDateFormat simpleDateFormat) {
        if (l10 == null && l11 == null) {
            return a0.d.create(null, null);
        }
        if (l10 == null) {
            return a0.d.create(null, getDateString(l11.longValue(), simpleDateFormat));
        }
        if (l11 == null) {
            return a0.d.create(getDateString(l10.longValue(), simpleDateFormat), null);
        }
        Calendar todayCalendar = UtcDates.getTodayCalendar();
        Calendar utcCalendar = UtcDates.getUtcCalendar();
        utcCalendar.setTimeInMillis(l10.longValue());
        Calendar utcCalendar2 = UtcDates.getUtcCalendar();
        utcCalendar2.setTimeInMillis(l11.longValue());
        if (simpleDateFormat != null) {
            return a0.d.create(simpleDateFormat.format(new Date(l10.longValue())), simpleDateFormat.format(new Date(l11.longValue())));
        }
        return utcCalendar.get(1) == utcCalendar2.get(1) ? utcCalendar.get(1) == todayCalendar.get(1) ? a0.d.create(getMonthDay(l10.longValue(), Locale.getDefault()), getMonthDay(l11.longValue(), Locale.getDefault())) : a0.d.create(getMonthDay(l10.longValue(), Locale.getDefault()), getYearMonthDay(l11.longValue(), Locale.getDefault())) : a0.d.create(getYearMonthDay(l10.longValue(), Locale.getDefault()), getYearMonthDay(l11.longValue(), Locale.getDefault()));
    }

    public static String getDateString(long j10, SimpleDateFormat simpleDateFormat) {
        Calendar todayCalendar = UtcDates.getTodayCalendar();
        Calendar utcCalendar = UtcDates.getUtcCalendar();
        utcCalendar.setTimeInMillis(j10);
        return simpleDateFormat != null ? simpleDateFormat.format(new Date(j10)) : todayCalendar.get(1) == utcCalendar.get(1) ? getMonthDay(j10) : getYearMonthDay(j10);
    }

    public static String getMonthDay(long j10, Locale locale) {
        String format;
        if (Build.VERSION.SDK_INT < 24) {
            return UtcDates.getMediumNoYear(locale).format(new Date(j10));
        }
        format = UtcDates.getAbbrMonthDayFormat(locale).format(new Date(j10));
        return format;
    }

    public static String getMonthDayOfWeekDay(long j10, Locale locale) {
        String format;
        if (Build.VERSION.SDK_INT < 24) {
            return UtcDates.getFullFormat(locale).format(new Date(j10));
        }
        format = UtcDates.getAbbrMonthWeekdayDayFormat(locale).format(new Date(j10));
        return format;
    }

    public static String getYearMonthDay(long j10, Locale locale) {
        String format;
        if (Build.VERSION.SDK_INT < 24) {
            return UtcDates.getMediumFormat(locale).format(new Date(j10));
        }
        format = UtcDates.getYearAbbrMonthDayFormat(locale).format(new Date(j10));
        return format;
    }

    public static String getYearMonthDayOfWeekDay(long j10, Locale locale) {
        String format;
        if (Build.VERSION.SDK_INT < 24) {
            return UtcDates.getFullFormat(locale).format(new Date(j10));
        }
        format = UtcDates.getYearAbbrMonthWeekdayDayFormat(locale).format(new Date(j10));
        return format;
    }
}
