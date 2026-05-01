package com.umeng.commonsdk.statistics.idtracking;

import android.content.Context;
import com.umeng.commonsdk.internal.crash.UMCrashManager;
import com.umeng.commonsdk.statistics.AnalyticsConstants;
import com.umeng.commonsdk.statistics.common.DeviceConfig;

/* loaded from: classes3.dex */
public class h extends a {

    /* renamed from: a, reason: collision with root package name */
    private static final String f11096a = "mac";

    /* renamed from: b, reason: collision with root package name */
    private Context f11097b;

    public h(Context context) {
        super("mac");
        this.f11097b = context;
    }

    @Override // com.umeng.commonsdk.statistics.idtracking.a
    public String f() {
        try {
            return DeviceConfig.getMac(this.f11097b);
        } catch (Exception e10) {
            if (AnalyticsConstants.UM_DEBUG) {
                e10.printStackTrace();
            }
            UMCrashManager.reportCrash(this.f11097b, e10);
            return null;
        }
    }
}
