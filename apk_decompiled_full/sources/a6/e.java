package a6;

import android.content.Context;
import java.util.Arrays;
import java.util.Locale;
import t9.i;
import t9.z;

/* loaded from: classes3.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    public static final e f267a = new e();

    public static final String a(Context context, String str, String str2, String str3) {
        i.g(context, com.umeng.analytics.pro.f.X);
        i.g(str, "contentId");
        i.g(str2, "url");
        i.g(str3, "lang");
        z zVar = z.f18964a;
        String format = String.format(Locale.US, s6.a.f18777a.a().f(context), Arrays.copyOf(new Object[]{str, str2, str3}, 3));
        i.f(format, "format(locale, format, *args)");
        return format;
    }
}
