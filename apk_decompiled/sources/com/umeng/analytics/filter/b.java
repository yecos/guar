package com.umeng.analytics.filter;

import android.text.TextUtils;
import com.umeng.analytics.AnalyticsConfig;

/* loaded from: classes3.dex */
public class b extends EventList {

    /* renamed from: a, reason: collision with root package name */
    private d f9817a;

    /* renamed from: b, reason: collision with root package name */
    private Object f9818b;

    public b(String str, String str2) {
        super(str, str2);
        this.f9818b = new Object();
    }

    @Override // com.umeng.analytics.filter.EventList
    public void eventListChange() {
        if (TextUtils.isEmpty(this.mEventList)) {
            return;
        }
        synchronized (this.f9818b) {
            this.f9817a = null;
            this.f9817a = new d(true, this.mEventList);
        }
    }

    @Override // com.umeng.analytics.filter.EventList
    public boolean matchHit(String str) {
        boolean a10;
        if (TextUtils.isEmpty(this.mEventList)) {
            return true;
        }
        synchronized (this.f9818b) {
            if (this.f9817a == null) {
                this.f9817a = new d(true, this.mEventList);
            }
            a10 = this.f9817a.a(str);
        }
        return a10;
    }

    @Override // com.umeng.analytics.filter.EventList
    public void setMD5ClearFlag(boolean z10) {
        AnalyticsConfig.CLEAR_EKV_WL = z10;
    }
}
