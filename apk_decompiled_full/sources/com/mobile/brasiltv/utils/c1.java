package com.mobile.brasiltv.utils;

import android.os.Build;
import android.os.LocaleList;
import com.hpplay.cybergarage.xml.XML;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/* loaded from: classes3.dex */
public abstract class c1 {

    /* renamed from: a, reason: collision with root package name */
    public static Map f8643a = new a(3);

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

    public static Locale a(String str) {
        return c(str) ? (Locale) f8643a.get(str) : b();
    }

    public static Locale b() {
        LocaleList localeList;
        Locale locale;
        if (Build.VERSION.SDK_INT < 24) {
            return Locale.getDefault();
        }
        localeList = LocaleList.getDefault();
        locale = localeList.get(0);
        return locale;
    }

    public static boolean c(String str) {
        return f8643a.containsKey(str);
    }
}
