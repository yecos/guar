package com.umeng.analytics.pro;

import java.io.Serializable;

/* loaded from: classes3.dex */
public class cu implements Serializable {

    /* renamed from: a, reason: collision with root package name */
    private final boolean f10199a;

    /* renamed from: b, reason: collision with root package name */
    public final byte f10200b;

    /* renamed from: c, reason: collision with root package name */
    private final String f10201c;

    /* renamed from: d, reason: collision with root package name */
    private final boolean f10202d;

    public cu(byte b10, boolean z10) {
        this.f10200b = b10;
        this.f10199a = false;
        this.f10201c = null;
        this.f10202d = z10;
    }

    public boolean a() {
        return this.f10199a;
    }

    public String b() {
        return this.f10201c;
    }

    public boolean c() {
        return this.f10200b == 12;
    }

    public boolean d() {
        byte b10 = this.f10200b;
        return b10 == 15 || b10 == 13 || b10 == 14;
    }

    public boolean e() {
        return this.f10202d;
    }

    public cu(byte b10) {
        this(b10, false);
    }

    public cu(byte b10, String str) {
        this.f10200b = b10;
        this.f10199a = true;
        this.f10201c = str;
        this.f10202d = false;
    }
}
