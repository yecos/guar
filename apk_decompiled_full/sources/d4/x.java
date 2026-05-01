package d4;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import com.taobao.accs.flowcontrol.FlowControl;
import java.text.DateFormat;
import java.text.FieldPosition;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes.dex */
public class x extends DateFormat {

    /* renamed from: g, reason: collision with root package name */
    public static final Pattern f12584g = Pattern.compile("\\d\\d\\d\\d[-]\\d\\d[-]\\d\\d");

    /* renamed from: h, reason: collision with root package name */
    public static final Pattern f12585h;

    /* renamed from: i, reason: collision with root package name */
    public static final String[] f12586i;

    /* renamed from: j, reason: collision with root package name */
    public static final TimeZone f12587j;

    /* renamed from: k, reason: collision with root package name */
    public static final Locale f12588k;

    /* renamed from: l, reason: collision with root package name */
    public static final DateFormat f12589l;

    /* renamed from: m, reason: collision with root package name */
    public static final x f12590m;

    /* renamed from: n, reason: collision with root package name */
    public static final Calendar f12591n;

    /* renamed from: a, reason: collision with root package name */
    public transient TimeZone f12592a;

    /* renamed from: b, reason: collision with root package name */
    public final Locale f12593b;

    /* renamed from: c, reason: collision with root package name */
    public Boolean f12594c;

    /* renamed from: d, reason: collision with root package name */
    public transient Calendar f12595d;

    /* renamed from: e, reason: collision with root package name */
    public transient DateFormat f12596e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f12597f;

    static {
        try {
            f12585h = Pattern.compile("\\d\\d\\d\\d[-]\\d\\d[-]\\d\\d[T]\\d\\d[:]\\d\\d(?:[:]\\d\\d)?(\\.\\d+)?(Z|[+-]\\d\\d(?:[:]?\\d\\d)?)?");
            f12586i = new String[]{"yyyy-MM-dd'T'HH:mm:ss.SSSX", "yyyy-MM-dd'T'HH:mm:ss.SSS", "EEE, dd MMM yyyy HH:mm:ss zzz", "yyyy-MM-dd"};
            TimeZone timeZone = TimeZone.getTimeZone("UTC");
            f12587j = timeZone;
            Locale locale = Locale.US;
            f12588k = locale;
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss zzz", locale);
            f12589l = simpleDateFormat;
            simpleDateFormat.setTimeZone(timeZone);
            f12590m = new x();
            f12591n = new GregorianCalendar(timeZone, locale);
        } catch (Throwable th) {
            throw new RuntimeException(th);
        }
    }

    public x() {
        this.f12597f = true;
        this.f12593b = f12588k;
    }

    public static final DateFormat b(DateFormat dateFormat, String str, TimeZone timeZone, Locale locale, Boolean bool) {
        DateFormat dateFormat2;
        if (locale.equals(f12588k)) {
            dateFormat2 = (DateFormat) dateFormat.clone();
            if (timeZone != null) {
                dateFormat2.setTimeZone(timeZone);
            }
        } else {
            dateFormat2 = new SimpleDateFormat(str, locale);
            if (timeZone == null) {
                timeZone = f12587j;
            }
            dateFormat2.setTimeZone(timeZone);
        }
        if (bool != null) {
            dateFormat2.setLenient(bool.booleanValue());
        }
        return dateFormat2;
    }

    public static boolean c(Object obj, Object obj2) {
        if (obj == obj2) {
            return true;
        }
        return obj != null && obj.equals(obj2);
    }

    public static int g(String str, int i10) {
        return ((str.charAt(i10) - '0') * 10) + (str.charAt(i10 + 1) - '0');
    }

    public static int h(String str, int i10) {
        return ((str.charAt(i10) - '0') * 1000) + ((str.charAt(i10 + 1) - '0') * 100) + ((str.charAt(i10 + 2) - '0') * 10) + (str.charAt(i10 + 3) - '0');
    }

    public static void n(StringBuffer stringBuffer, int i10) {
        int i11 = i10 / 10;
        if (i11 == 0) {
            stringBuffer.append('0');
        } else {
            stringBuffer.append((char) (i11 + 48));
            i10 -= i11 * 10;
        }
        stringBuffer.append((char) (i10 + 48));
    }

    public static void o(StringBuffer stringBuffer, int i10) {
        int i11 = i10 / 100;
        if (i11 == 0) {
            stringBuffer.append('0');
        } else {
            stringBuffer.append((char) (i11 + 48));
            i10 -= i11 * 100;
        }
        n(stringBuffer, i10);
    }

    public static void p(StringBuffer stringBuffer, int i10) {
        int i11 = i10 / 100;
        if (i11 == 0) {
            stringBuffer.append('0');
            stringBuffer.append('0');
        } else {
            if (i11 > 99) {
                stringBuffer.append(i11);
            } else {
                n(stringBuffer, i11);
            }
            i10 -= i11 * 100;
        }
        n(stringBuffer, i10);
    }

    public void a() {
        this.f12596e = null;
    }

    public void d(TimeZone timeZone, Locale locale, Date date, StringBuffer stringBuffer) {
        Calendar f10 = f(timeZone);
        f10.setTime(date);
        int i10 = f10.get(1);
        if (f10.get(0) == 0) {
            e(stringBuffer, i10);
        } else {
            if (i10 > 9999) {
                stringBuffer.append('+');
            }
            p(stringBuffer, i10);
        }
        stringBuffer.append(ASCIIPropertyListParser.DATE_DATE_FIELD_DELIMITER);
        n(stringBuffer, f10.get(2) + 1);
        stringBuffer.append(ASCIIPropertyListParser.DATE_DATE_FIELD_DELIMITER);
        n(stringBuffer, f10.get(5));
        stringBuffer.append(ASCIIPropertyListParser.DATE_APPLE_DATE_TIME_DELIMITER);
        n(stringBuffer, f10.get(11));
        stringBuffer.append(ASCIIPropertyListParser.DATE_TIME_FIELD_DELIMITER);
        n(stringBuffer, f10.get(12));
        stringBuffer.append(ASCIIPropertyListParser.DATE_TIME_FIELD_DELIMITER);
        n(stringBuffer, f10.get(13));
        stringBuffer.append('.');
        o(stringBuffer, f10.get(14));
        int offset = timeZone.getOffset(f10.getTimeInMillis());
        if (offset == 0) {
            if (this.f12597f) {
                stringBuffer.append("+00:00");
                return;
            } else {
                stringBuffer.append("+0000");
                return;
            }
        }
        int i11 = offset / 60000;
        int abs = Math.abs(i11 / 60);
        int abs2 = Math.abs(i11 % 60);
        stringBuffer.append(offset < 0 ? ASCIIPropertyListParser.DATE_DATE_FIELD_DELIMITER : '+');
        n(stringBuffer, abs);
        if (this.f12597f) {
            stringBuffer.append(ASCIIPropertyListParser.DATE_TIME_FIELD_DELIMITER);
        }
        n(stringBuffer, abs2);
    }

    public void e(StringBuffer stringBuffer, int i10) {
        if (i10 == 1) {
            stringBuffer.append("+0000");
        } else {
            stringBuffer.append(ASCIIPropertyListParser.DATE_DATE_FIELD_DELIMITER);
            p(stringBuffer, i10 - 1);
        }
    }

    @Override // java.text.DateFormat
    public boolean equals(Object obj) {
        return obj == this;
    }

    public Calendar f(TimeZone timeZone) {
        Calendar calendar = this.f12595d;
        if (calendar == null) {
            calendar = (Calendar) f12591n.clone();
            this.f12595d = calendar;
        }
        if (!calendar.getTimeZone().equals(timeZone)) {
            calendar.setTimeZone(timeZone);
        }
        calendar.setLenient(isLenient());
        return calendar;
    }

    @Override // java.text.DateFormat
    public StringBuffer format(Date date, StringBuffer stringBuffer, FieldPosition fieldPosition) {
        TimeZone timeZone = this.f12592a;
        if (timeZone == null) {
            timeZone = f12587j;
        }
        d(timeZone, this.f12593b, date, stringBuffer);
        return stringBuffer;
    }

    @Override // java.text.DateFormat
    public TimeZone getTimeZone() {
        return this.f12592a;
    }

    @Override // java.text.DateFormat
    public int hashCode() {
        return System.identityHashCode(this);
    }

    public Date i(String str, ParsePosition parsePosition) {
        char c10;
        String str2;
        int length = str.length();
        TimeZone timeZone = f12587j;
        if (this.f12592a != null && 'Z' != str.charAt(length - 1)) {
            timeZone = this.f12592a;
        }
        Calendar f10 = f(timeZone);
        f10.clear();
        int i10 = 0;
        if (length > 10) {
            Matcher matcher = f12585h.matcher(str);
            if (matcher.matches()) {
                int start = matcher.start(2);
                int end = matcher.end(2);
                int i11 = end - start;
                if (i11 > 1) {
                    int g10 = g(str, start + 1) * 3600;
                    if (i11 >= 5) {
                        g10 += g(str, end - 2) * 60;
                    }
                    f10.set(15, str.charAt(start) == '-' ? g10 * FlowControl.DELAY_MAX_BRUSH : g10 * 1000);
                    f10.set(16, 0);
                }
                f10.set(h(str, 0), g(str, 5) - 1, g(str, 8), g(str, 11), g(str, 14), (length <= 16 || str.charAt(16) != ':') ? 0 : g(str, 17));
                int start2 = matcher.start(1) + 1;
                int end2 = matcher.end(1);
                if (start2 >= end2) {
                    f10.set(14, 0);
                } else {
                    int i12 = end2 - start2;
                    if (i12 != 0) {
                        if (i12 != 1) {
                            if (i12 != 2) {
                                if (i12 != 3 && i12 > 9) {
                                    throw new ParseException(String.format("Cannot parse date \"%s\": invalid fractional seconds '%s'; can use at most 9 digits", str, matcher.group(1).substring(1)), start2);
                                }
                                i10 = 0 + (str.charAt(start2 + 2) - '0');
                            }
                            i10 += (str.charAt(start2 + 1) - '0') * 10;
                        }
                        i10 += (str.charAt(start2) - '0') * 100;
                    }
                    f10.set(14, i10);
                }
                return f10.getTime();
            }
            c10 = 1;
            str2 = "yyyy-MM-dd'T'HH:mm:ss.SSSX";
        } else {
            if (f12584g.matcher(str).matches()) {
                f10.set(h(str, 0), g(str, 5) - 1, g(str, 8), 0, 0, 0);
                f10.set(14, 0);
                return f10.getTime();
            }
            str2 = "yyyy-MM-dd";
            c10 = 1;
        }
        Object[] objArr = new Object[3];
        objArr[0] = str;
        objArr[c10] = str2;
        objArr[2] = this.f12594c;
        throw new ParseException(String.format("Cannot parse date \"%s\": while it seems to fit format '%s', parsing fails (leniency? %s)", objArr), 0);
    }

    @Override // java.text.DateFormat
    public boolean isLenient() {
        Boolean bool = this.f12594c;
        return bool == null || bool.booleanValue();
    }

    public Date j(String str, ParsePosition parsePosition) {
        if (m(str)) {
            return q(str, parsePosition);
        }
        int length = str.length();
        while (true) {
            length--;
            if (length < 0) {
                break;
            }
            char charAt = str.charAt(length);
            if (charAt < '0' || charAt > '9') {
                if (length > 0 || charAt != '-') {
                    break;
                }
            }
        }
        return (length >= 0 || !(str.charAt(0) == '-' || f3.f.b(str, false))) ? r(str, parsePosition) : k(str, parsePosition);
    }

    public final Date k(String str, ParsePosition parsePosition) {
        try {
            return new Date(f3.f.l(str));
        } catch (NumberFormatException unused) {
            throw new ParseException(String.format("Timestamp value %s out of 64-bit value range", str), parsePosition.getErrorIndex());
        }
    }

    @Override // java.text.DateFormat, java.text.Format
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public x clone() {
        return new x(this.f12592a, this.f12593b, this.f12594c, this.f12597f);
    }

    public boolean m(String str) {
        return str.length() >= 7 && Character.isDigit(str.charAt(0)) && Character.isDigit(str.charAt(3)) && str.charAt(4) == '-' && Character.isDigit(str.charAt(5));
    }

    @Override // java.text.DateFormat
    public Date parse(String str) {
        String trim = str.trim();
        ParsePosition parsePosition = new ParsePosition(0);
        Date j10 = j(trim, parsePosition);
        if (j10 != null) {
            return j10;
        }
        StringBuilder sb = new StringBuilder();
        for (String str2 : f12586i) {
            if (sb.length() > 0) {
                sb.append("\", \"");
            } else {
                sb.append('\"');
            }
            sb.append(str2);
        }
        sb.append('\"');
        throw new ParseException(String.format("Cannot parse date \"%s\": not compatible with any of standard forms (%s)", trim, sb.toString()), parsePosition.getErrorIndex());
    }

    public Date q(String str, ParsePosition parsePosition) {
        try {
            return i(str, parsePosition);
        } catch (IllegalArgumentException e10) {
            throw new ParseException(String.format("Cannot parse date \"%s\", problem: %s", str, e10.getMessage()), parsePosition.getErrorIndex());
        }
    }

    public Date r(String str, ParsePosition parsePosition) {
        if (this.f12596e == null) {
            this.f12596e = b(f12589l, "EEE, dd MMM yyyy HH:mm:ss zzz", this.f12592a, this.f12593b, this.f12594c);
        }
        return this.f12596e.parse(str, parsePosition);
    }

    public String s() {
        StringBuilder sb = new StringBuilder(100);
        sb.append("[one of: '");
        sb.append("yyyy-MM-dd'T'HH:mm:ss.SSSX");
        sb.append("', '");
        sb.append("EEE, dd MMM yyyy HH:mm:ss zzz");
        sb.append("' (");
        sb.append(Boolean.FALSE.equals(this.f12594c) ? "strict" : "lenient");
        sb.append(")]");
        return sb.toString();
    }

    @Override // java.text.DateFormat
    public void setLenient(boolean z10) {
        Boolean valueOf = Boolean.valueOf(z10);
        if (c(valueOf, this.f12594c)) {
            return;
        }
        this.f12594c = valueOf;
        a();
    }

    @Override // java.text.DateFormat
    public void setTimeZone(TimeZone timeZone) {
        if (timeZone.equals(this.f12592a)) {
            return;
        }
        a();
        this.f12592a = timeZone;
    }

    public x t(Boolean bool) {
        return c(bool, this.f12594c) ? this : new x(this.f12592a, this.f12593b, bool, this.f12597f);
    }

    public String toString() {
        return String.format("DateFormat %s: (timezone: %s, locale: %s, lenient: %s)", getClass().getName(), this.f12592a, this.f12593b, this.f12594c);
    }

    public x u(Locale locale) {
        return locale.equals(this.f12593b) ? this : new x(this.f12592a, locale, this.f12594c, this.f12597f);
    }

    public x v(TimeZone timeZone) {
        if (timeZone == null) {
            timeZone = f12587j;
        }
        TimeZone timeZone2 = this.f12592a;
        return (timeZone == timeZone2 || timeZone.equals(timeZone2)) ? this : new x(timeZone, this.f12593b, this.f12594c, this.f12597f);
    }

    public x(TimeZone timeZone, Locale locale, Boolean bool, boolean z10) {
        this.f12592a = timeZone;
        this.f12593b = locale;
        this.f12594c = bool;
        this.f12597f = z10;
    }

    @Override // java.text.DateFormat
    public Date parse(String str, ParsePosition parsePosition) {
        try {
            return j(str, parsePosition);
        } catch (ParseException unused) {
            return null;
        }
    }
}
