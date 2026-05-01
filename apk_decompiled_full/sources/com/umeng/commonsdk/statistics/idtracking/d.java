package com.umeng.commonsdk.statistics.idtracking;

import android.content.Context;
import com.umeng.commonsdk.statistics.common.DeviceConfig;

/* loaded from: classes3.dex */
public class d extends a {

    /* renamed from: a, reason: collision with root package name */
    private static final String f11078a = "idfa";

    /* renamed from: b, reason: collision with root package name */
    private Context f11079b;

    public d(Context context) {
        super(f11078a);
        this.f11079b = context;
    }

    @Override // com.umeng.commonsdk.statistics.idtracking.a
    public String f() {
        return DeviceConfig.getIdfa(this.f11079b);
    }
}
