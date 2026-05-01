package io.jsonwebtoken.impl.lang;

import io.jsonwebtoken.lang.DateFormats;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;

/* loaded from: classes3.dex */
public class JwtDateConverter implements Converter<Date, Object> {
    public static final JwtDateConverter INSTANCE = new JwtDateConverter();

    private static Date parseIso8601Date(String str) {
        try {
            return DateFormats.parseIso8601Date(str);
        } catch (ParseException e10) {
            throw new IllegalArgumentException("String value is not a JWT NumericDate, nor is it ISO-8601-formatted. All heuristics exhausted. Cause: " + e10.getMessage(), e10);
        }
    }

    public static Date toDate(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof Date) {
            return (Date) obj;
        }
        if (obj instanceof Calendar) {
            return ((Calendar) obj).getTime();
        }
        if (obj instanceof Number) {
            return new Date(((Number) obj).longValue());
        }
        if (obj instanceof String) {
            return parseIso8601Date((String) obj);
        }
        throw new IllegalArgumentException("Cannot create Date from object of type " + obj.getClass().getName() + ".");
    }

    public static Date toSpecDate(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof String) {
            try {
                obj = Long.valueOf(Long.parseLong((String) obj));
            } catch (NumberFormatException unused) {
            }
        }
        if (obj instanceof Number) {
            obj = Long.valueOf(((Number) obj).longValue() * 1000);
        }
        return toDate(obj);
    }

    @Override // io.jsonwebtoken.impl.lang.Converter
    public Date applyFrom(Object obj) {
        return toSpecDate(obj);
    }

    @Override // io.jsonwebtoken.impl.lang.Converter
    public Object applyTo(Date date) {
        if (date == null) {
            return null;
        }
        return Long.valueOf(date.getTime() / 1000);
    }
}
