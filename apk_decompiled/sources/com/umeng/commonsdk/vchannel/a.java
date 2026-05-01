package com.umeng.commonsdk.vchannel;

/* loaded from: classes3.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public static String f11279a = "https://pslog.umeng.com";

    /* renamed from: b, reason: collision with root package name */
    public static String f11280b = "https://pslog.umeng.com/";

    /* renamed from: c, reason: collision with root package name */
    public static String f11281c = "explog";

    /* renamed from: d, reason: collision with root package name */
    public static final String f11282d = "analytics";

    /* renamed from: e, reason: collision with root package name */
    public static final String f11283e = "ekv";

    /* renamed from: f, reason: collision with root package name */
    public static final String f11284f = "id";

    /* renamed from: g, reason: collision with root package name */
    public static final String f11285g = "ts";

    /* renamed from: h, reason: collision with root package name */
    public static final String f11286h = "ds";

    /* renamed from: i, reason: collision with root package name */
    public static final String f11287i = "pn";

    /* renamed from: j, reason: collision with root package name */
    public static String f11288j = "";

    static {
        String str = "SUB" + System.currentTimeMillis();
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(String.format("%0" + (32 - str.length()) + "d", 0));
        f11288j = sb.toString();
    }
}
