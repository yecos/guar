package com.umeng.analytics.pro;

import android.content.SharedPreferences;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.service.UMGlobalContext;

/* loaded from: classes3.dex */
public class ai implements ac {

    /* renamed from: a, reason: collision with root package name */
    private int f9855a;

    public ai(int i10) {
        this.f9855a = i10;
    }

    @Override // com.umeng.analytics.pro.ac
    public boolean a() {
        long j10 = 0;
        try {
            SharedPreferences a10 = au.a(UMGlobalContext.getAppContext());
            if (a10 != null) {
                j10 = a10.getLong(au.f9913a, 0L);
                if (j10 >= this.f9855a) {
                    return true;
                }
            }
        } catch (Throwable unused) {
        }
        UMRTLog.i(UMRTLog.RTLOG_TAG, "launch times skipped. times: " + j10 + " ; config: " + this.f9855a);
        return false;
    }

    @Override // com.umeng.analytics.pro.ac
    public boolean b() {
        return !a();
    }

    @Override // com.umeng.analytics.pro.ac
    public long c() {
        return 0L;
    }
}
