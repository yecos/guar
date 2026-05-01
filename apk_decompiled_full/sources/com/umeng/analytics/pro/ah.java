package com.umeng.analytics.pro;

import android.content.SharedPreferences;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.service.UMGlobalContext;

/* loaded from: classes3.dex */
public class ah implements ac {

    /* renamed from: a, reason: collision with root package name */
    private String f9853a;

    /* renamed from: b, reason: collision with root package name */
    private long f9854b;

    public ah(String str, long j10) {
        this.f9853a = str;
        this.f9854b = j10;
    }

    @Override // com.umeng.analytics.pro.ac
    public boolean a() {
        try {
            String str = au.f9914b + this.f9853a;
            SharedPreferences a10 = au.a(UMGlobalContext.getAppContext());
            if (a10 == null) {
                return false;
            }
            long currentTimeMillis = System.currentTimeMillis() - a10.getLong(str, 0L);
            if (currentTimeMillis > this.f9854b * 1000) {
                return true;
            }
            UMRTLog.i(UMRTLog.RTLOG_TAG, "internal period skipped. elapse: " + currentTimeMillis + "; config: " + (this.f9854b * 1000));
            return false;
        } catch (Throwable unused) {
            return false;
        }
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
