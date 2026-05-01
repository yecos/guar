package com.hpplay.a.a.a.a;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes2.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static final String f7215a = "US-ASCII";

    /* renamed from: b, reason: collision with root package name */
    private static final String f7216b = "multipart/form-data";

    /* renamed from: c, reason: collision with root package name */
    private static final String f7217c = "[ |\t]*([^/^ ^;^,]+/[^ ^;^,]+)";

    /* renamed from: d, reason: collision with root package name */
    private static final Pattern f7218d = Pattern.compile(f7217c, 2);

    /* renamed from: e, reason: collision with root package name */
    private static final String f7219e = "[ |\t]*(charset)[ |\t]*=[ |\t]*['|\"]?([^\"^'^;^,]*)['|\"]?";

    /* renamed from: f, reason: collision with root package name */
    private static final Pattern f7220f = Pattern.compile(f7219e, 2);

    /* renamed from: g, reason: collision with root package name */
    private static final String f7221g = "[ |\t]*(boundary)[ |\t]*=[ |\t]*['|\"]?([^\"^'^;^,]*)['|\"]?";

    /* renamed from: h, reason: collision with root package name */
    private static final Pattern f7222h = Pattern.compile(f7221g, 2);

    /* renamed from: i, reason: collision with root package name */
    private final String f7223i;

    /* renamed from: j, reason: collision with root package name */
    private final String f7224j;

    /* renamed from: k, reason: collision with root package name */
    private final String f7225k;

    /* renamed from: l, reason: collision with root package name */
    private final String f7226l;

    public a(String str) {
        this.f7223i = str;
        if (str != null) {
            this.f7224j = a(str, f7218d, "", 1);
            this.f7225k = a(str, f7220f, null, 2);
        } else {
            this.f7224j = "";
            this.f7225k = "UTF-8";
        }
        if (f7216b.equalsIgnoreCase(this.f7224j)) {
            this.f7226l = a(str, f7222h, null, 2);
        } else {
            this.f7226l = null;
        }
    }

    private String a(String str, Pattern pattern, String str2, int i10) {
        Matcher matcher = pattern.matcher(str);
        return matcher.find() ? matcher.group(i10) : str2;
    }

    public String b() {
        return this.f7224j;
    }

    public String c() {
        String str = this.f7225k;
        return str == null ? f7215a : str;
    }

    public String d() {
        return this.f7226l;
    }

    public boolean e() {
        return f7216b.equalsIgnoreCase(this.f7224j);
    }

    public a f() {
        if (this.f7225k != null) {
            return this;
        }
        return new a(this.f7223i + "; charset=UTF-8");
    }

    public String a() {
        return this.f7223i;
    }
}
