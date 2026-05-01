package com.hpplay.a.a.a.a;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;

/* loaded from: classes2.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private final String f7227a;

    /* renamed from: b, reason: collision with root package name */
    private final String f7228b;

    /* renamed from: c, reason: collision with root package name */
    private final String f7229c;

    public b(String str, String str2) {
        this(str, str2, 30);
    }

    public static String a(int i10) {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss z", Locale.US);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
        calendar.add(5, i10);
        return simpleDateFormat.format(calendar.getTime());
    }

    public b(String str, String str2, int i10) {
        this.f7227a = str;
        this.f7228b = str2;
        this.f7229c = a(i10);
    }

    public b(String str, String str2, String str3) {
        this.f7227a = str;
        this.f7228b = str2;
        this.f7229c = str3;
    }

    public String a() {
        return String.format("%s=%s; expires=%s", this.f7227a, this.f7228b, this.f7229c);
    }
}
