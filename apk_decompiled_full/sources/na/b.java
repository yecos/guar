package na;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* loaded from: classes3.dex */
public abstract class b {

    /* renamed from: a, reason: collision with root package name */
    public static SimpleDateFormat f17338a = new SimpleDateFormat("yyyy-MM-dd", Locale.US);

    public static String a(String str) {
        return new SimpleDateFormat(str).format(new Date());
    }

    public static String b(String str, Long l10) {
        return new SimpleDateFormat(str).format(new Date(System.currentTimeMillis() + l10.longValue()));
    }

    public static String c(String str) {
        return new SimpleDateFormat(str, Locale.getDefault()).format(new Date());
    }
}
