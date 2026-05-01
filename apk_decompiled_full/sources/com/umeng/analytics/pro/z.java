package com.umeng.analytics.pro;

import android.content.Context;
import android.content.SharedPreferences;
import com.hpplay.sdk.source.common.store.Session;
import com.umeng.analytics.AnalyticsConfig;
import com.umeng.commonsdk.statistics.internal.PreferenceWrapper;
import com.umeng.commonsdk.utils.UMUtils;

/* loaded from: classes3.dex */
class z implements y {

    /* renamed from: a, reason: collision with root package name */
    private long f10595a = AnalyticsConfig.kContinueSessionMillis;

    @Override // com.umeng.analytics.pro.y
    public void a(long j10) {
        this.f10595a = j10;
    }

    @Override // com.umeng.analytics.pro.y
    public long a() {
        return this.f10595a;
    }

    @Override // com.umeng.analytics.pro.y
    public String a(Context context) {
        String appkey = UMUtils.getAppkey(context);
        long currentTimeMillis = System.currentTimeMillis();
        if (appkey != null) {
            return UMUtils.MD5(currentTimeMillis + appkey + Session.DEFAULT_M);
        }
        throw new RuntimeException("Appkey is null or empty, Please check!");
    }

    @Override // com.umeng.analytics.pro.y
    public boolean a(long j10, long j11) {
        long currentTimeMillis = System.currentTimeMillis();
        return (j10 == 0 || currentTimeMillis - j10 >= this.f10595a) && j11 > 0 && currentTimeMillis - j11 > this.f10595a;
    }

    @Override // com.umeng.analytics.pro.y
    public void a(Context context, String str) {
        long currentTimeMillis = System.currentTimeMillis();
        try {
            SharedPreferences.Editor edit = PreferenceWrapper.getDefault(context).edit();
            edit.putString("session_id", str);
            edit.putLong(w.f10576b, 0L);
            edit.putLong(w.f10579e, currentTimeMillis);
            edit.putLong(w.f10580f, 0L);
            edit.commit();
        } catch (Exception unused) {
        }
    }
}
