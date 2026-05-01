package a5;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.text.TextUtils;
import java.io.File;

/* loaded from: classes.dex */
public abstract class g {
    public static String a(Context context) {
        try {
            ApplicationInfo applicationInfo = context.getApplicationInfo();
            if (applicationInfo == null) {
                return null;
            }
            return applicationInfo.sourceDir;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String b(Context context) {
        return c(context, null);
    }

    public static String c(Context context, String str) {
        b d10 = d(context);
        return d10 == null ? str : d10.a();
    }

    public static b d(Context context) {
        String a10 = a(context);
        if (TextUtils.isEmpty(a10)) {
            return null;
        }
        return c.a(new File(a10));
    }
}
