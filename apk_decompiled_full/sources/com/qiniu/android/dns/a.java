package com.qiniu.android.dns;

/* loaded from: classes3.dex */
public final class a {

    /* renamed from: c, reason: collision with root package name */
    public static final a f9005c = new a(EnumC0167a.NO_NETWORK, 0);

    /* renamed from: d, reason: collision with root package name */
    public static final a f9006d = new a(EnumC0167a.WIFI, 0);

    /* renamed from: a, reason: collision with root package name */
    public final int f9007a;

    /* renamed from: b, reason: collision with root package name */
    public final EnumC0167a f9008b;

    /* renamed from: com.qiniu.android.dns.a$a, reason: collision with other inner class name */
    public enum EnumC0167a {
        NO_NETWORK,
        WIFI,
        MOBILE
    }

    public a(EnumC0167a enumC0167a, int i10) {
        this.f9008b = enumC0167a;
        this.f9007a = i10;
    }
}
