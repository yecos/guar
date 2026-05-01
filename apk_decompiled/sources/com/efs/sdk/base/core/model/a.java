package com.efs.sdk.base.core.model;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    String f6206a;

    /* renamed from: b, reason: collision with root package name */
    byte f6207b;

    /* renamed from: c, reason: collision with root package name */
    int f6208c = 0;

    /* renamed from: d, reason: collision with root package name */
    String f6209d = "none";

    /* renamed from: e, reason: collision with root package name */
    int f6210e = 1;

    /* renamed from: f, reason: collision with root package name */
    long f6211f = 0;

    /* renamed from: g, reason: collision with root package name */
    int f6212g = 1;

    /* renamed from: h, reason: collision with root package name */
    String f6213h = "";

    /* renamed from: i, reason: collision with root package name */
    String f6214i = "";

    /* renamed from: j, reason: collision with root package name */
    long f6215j = 0;

    /* renamed from: k, reason: collision with root package name */
    long f6216k = 0;

    public a(String str, byte b10) {
        this.f6207b = (byte) 2;
        this.f6206a = str;
        if (b10 <= 0 || 3 < b10) {
            throw new IllegalArgumentException("log protocol flag invalid : ".concat(String.valueOf((int) b10)));
        }
        this.f6207b = b10;
    }
}
