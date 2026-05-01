package x;

import android.content.res.Configuration;
import android.os.Build;
import android.os.LocaleList;

/* loaded from: classes.dex */
public abstract class d {
    public static g a(Configuration configuration) {
        LocaleList locales;
        if (Build.VERSION.SDK_INT < 24) {
            return g.a(configuration.locale);
        }
        locales = configuration.getLocales();
        return g.d(locales);
    }
}
