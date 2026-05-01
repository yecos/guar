package com.mobile.brasiltv.utils;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.text.TextUtils;
import com.hpplay.cybergarage.xml.XML;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;

/* loaded from: classes3.dex */
public abstract class b {

    /* renamed from: a, reason: collision with root package name */
    public static HashMap f8617a = new a(7);

    public class a extends HashMap {
        public a(int i10) {
            super(i10);
            put(XML.DEFAULT_CONTENT_LANGUAGE, Locale.ENGLISH);
            put("zh", Locale.SIMPLIFIED_CHINESE);
            put("zh-hant", Locale.TRADITIONAL_CHINESE);
            put("pt", new Locale("pt"));
            put("es", new Locale("es"));
        }
    }

    public static void a(Context context, String str) {
        Resources resources = context.getResources();
        Configuration configuration = resources.getConfiguration();
        Locale a10 = c1.a(str);
        if (Build.VERSION.SDK_INT >= 24) {
            configuration.setLocale(a10);
        } else {
            configuration.locale = a10;
            resources.updateConfiguration(configuration, resources.getDisplayMetrics());
        }
    }

    public static Context b(Context context, String str) {
        if (Build.VERSION.SDK_INT >= 24) {
            return d(context, str);
        }
        a(context, str);
        return context;
    }

    public static void c(Context context, String str) {
        Resources resources = context.getResources();
        Configuration configuration = resources.getConfiguration();
        configuration.setLocale(e(str));
        resources.updateConfiguration(configuration, resources.getDisplayMetrics());
    }

    public static Context d(Context context, String str) {
        Configuration configuration = context.getResources().getConfiguration();
        configuration.setLocale(TextUtils.isEmpty(str) ? c1.b() : c1.a(str));
        return context.createConfigurationContext(configuration);
    }

    public static Locale e(String str) {
        if (f(str)) {
            return (Locale) f8617a.get(str);
        }
        Locale locale = Locale.getDefault();
        Iterator it = f8617a.keySet().iterator();
        while (it.hasNext()) {
            if (TextUtils.equals(((Locale) f8617a.get((String) it.next())).getLanguage(), locale.getLanguage())) {
                return locale;
            }
        }
        return Locale.SIMPLIFIED_CHINESE;
    }

    public static boolean f(String str) {
        return f8617a.containsKey(str);
    }
}
