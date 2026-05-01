package com.alibaba.sdk.android.utils;

import java.util.Map;

/* loaded from: classes.dex */
public class SdkInfo {

    /* renamed from: a, reason: collision with root package name */
    String f5981a;

    /* renamed from: b, reason: collision with root package name */
    String f5982b;

    /* renamed from: c, reason: collision with root package name */
    String f5983c;

    /* renamed from: c, reason: collision with other field name */
    Map<String, String> f44c;

    public SdkInfo setAppKey(String str) {
        this.f5983c = str;
        return this;
    }

    public SdkInfo setExt(Map<String, String> map) {
        this.f44c = map;
        return this;
    }

    public SdkInfo setSdkId(String str) {
        this.f5981a = str;
        return this;
    }

    public SdkInfo setSdkVersion(String str) {
        this.f5982b = str;
        return this;
    }
}
