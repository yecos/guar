package com.umeng.commonsdk.statistics.idtracking;

import android.content.Context;
import com.umeng.commonsdk.statistics.common.DeviceConfig;

/* loaded from: classes3.dex */
public class b extends a {

    /* renamed from: a, reason: collision with root package name */
    private static final String f11072a = "android_id";

    /* renamed from: b, reason: collision with root package name */
    private Context f11073b;

    public b(Context context) {
        super(f11072a);
        this.f11073b = context;
    }

    @Override // com.umeng.commonsdk.statistics.idtracking.a
    public String f() {
        return DeviceConfig.getAndroidId(this.f11073b);
    }
}
