package com.umeng.analytics.filter;

import android.text.TextUtils;
import com.umeng.analytics.AnalyticsConfig;

/* loaded from: classes3.dex */
public class a extends EventList {

    /* renamed from: a, reason: collision with root package name */
    private d f9815a;

    /* renamed from: b, reason: collision with root package name */
    private Object f9816b;

    public a(String str, String str2) {
        super(str, str2);
        this.f9816b = new Object();
    }

    @Override // com.umeng.analytics.filter.EventList
    public void eventListChange() {
        if (TextUtils.isEmpty(this.mEventList)) {
            return;
        }
        synchronized (this.f9816b) {
            this.f9815a = null;
            this.f9815a = new d(false, this.mEventList);
        }
    }

    @Override // com.umeng.analytics.filter.EventList
    public boolean matchHit(String str) {
        boolean a10;
        if (TextUtils.isEmpty(this.mEventList)) {
            return false;
        }
        synchronized (this.f9816b) {
            if (this.f9815a == null) {
                this.f9815a = new d(false, this.mEventList);
            }
            a10 = this.f9815a.a(str);
        }
        return a10;
    }

    @Override // com.umeng.analytics.filter.EventList
    public void setMD5ClearFlag(boolean z10) {
        AnalyticsConfig.CLEAR_EKV_BL = z10;
    }
}
