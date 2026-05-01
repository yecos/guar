package i2;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

/* loaded from: classes.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name */
    public static final i f14290a = new i();

    public final long a() {
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss.SSS", Locale.getDefault());
            simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
            String format = simpleDateFormat.format(new Date());
            t9.i.f(format, "dateStr");
            long b10 = b(format, "yyyy-MM-dd HH-mm-ss.SSS");
            b.a("DateUtil", "getUTCTimeMills:" + b10);
            return b10;
        } catch (Exception e10) {
            e10.printStackTrace();
            return 0L;
        }
    }

    public final long b(String str, String str2) {
        try {
            Date parse = new SimpleDateFormat(str2, Locale.getDefault()).parse(str);
            if (parse != null) {
                return parse.getTime();
            }
            return 0L;
        } catch (Exception e10) {
            e10.printStackTrace();
            return 0L;
        }
    }
}
