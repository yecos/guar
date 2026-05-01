package com.alibaba.sdk.android.httpdns;

/* loaded from: classes.dex */
public class h extends Exception {

    /* renamed from: b, reason: collision with root package name */
    private int f5907b;

    public h(int i10, String str) {
        super(str);
        this.f5907b = i10;
    }

    public int getErrorCode() {
        return this.f5907b;
    }
}
