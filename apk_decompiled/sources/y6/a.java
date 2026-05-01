package y6;

import com.hpplay.cybergarage.soap.SOAP;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

/* loaded from: classes3.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    public static final ThreadLocal f19768a = new ThreadLocal();

    public static String a(Date date) {
        return new SimpleDateFormat("yyyy-MM-dd").format(date);
    }

    public static boolean b(String str, String str2) {
        return str.length() == str2.length() && str.compareTo(str2) > 0;
    }

    public static String c() {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm").format(new Date());
    }

    public static String d(String str) {
        return new SimpleDateFormat(str, Locale.getDefault()).format(new Date());
    }

    public static String e() {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
    }

    public static String f(int i10) {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(g(new Date(), i10));
    }

    public static Date g(Date date, int i10) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(5, calendar.get(5) - i10);
        return calendar.getTime();
    }

    public static SimpleDateFormat h(String str) {
        ThreadLocal threadLocal = f19768a;
        SimpleDateFormat simpleDateFormat = (SimpleDateFormat) threadLocal.get();
        if (simpleDateFormat != null) {
            simpleDateFormat.applyPattern(str);
            return simpleDateFormat;
        }
        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat(str, Locale.getDefault());
        threadLocal.set(simpleDateFormat2);
        return simpleDateFormat2;
    }

    public static String i(long j10, String str) {
        return new SimpleDateFormat(str, Locale.getDefault()).format(new Date(j10));
    }

    public static long j() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeZone(TimeZone.getTimeZone("GMT"));
        return calendar.getTimeInMillis();
    }

    public static String k(long j10) {
        String str;
        if (j10 < 0) {
            return "00:00";
        }
        int i10 = (int) (j10 / 1000);
        int i11 = i10 / 60;
        int i12 = i11 / 60;
        int i13 = i10 % 60;
        int i14 = i11 % 60;
        StringBuilder sb = new StringBuilder();
        if (i12 == 0) {
            str = "";
        } else {
            str = i12 + SOAP.DELIM;
        }
        sb.append(str);
        sb.append(String.format(Locale.US, "%02d:%02d", Integer.valueOf(i14), Integer.valueOf(i13)));
        return sb.toString();
    }

    public static String l(long j10) {
        String str;
        if (j10 < 0) {
            return "00:00";
        }
        int i10 = (int) j10;
        int i11 = i10 / 60;
        int i12 = i11 / 60;
        long j11 = i10 % 60;
        int i13 = i11 % 60;
        StringBuilder sb = new StringBuilder();
        if (i12 == 0) {
            str = "";
        } else {
            str = i12 + SOAP.DELIM;
        }
        sb.append(str);
        sb.append(String.format(Locale.US, "%02d:%02d", Integer.valueOf(i13), Long.valueOf(j11)));
        return sb.toString();
    }

    public static long m(String str, String str2) {
        try {
            return h(str2).parse(str).getTime();
        } catch (ParseException e10) {
            e10.printStackTrace();
            return System.currentTimeMillis();
        }
    }
}
