package com.umeng.commonsdk.statistics.idtracking;

import android.content.Context;
import com.umeng.commonsdk.statistics.common.DeviceConfig;

/* loaded from: classes3.dex */
public class g extends a {

    /* renamed from: a, reason: collision with root package name */
    private static final String f11094a = "imei";

    /* renamed from: b, reason: collision with root package name */
    private Context f11095b;

    public g(Context context) {
        super("imei");
        this.f11095b = context;
    }

    @Override // com.umeng.commonsdk.statistics.idtracking.a
    public String f() {
        return DeviceConfig.getImeiNew(this.f11095b);
    }
}
