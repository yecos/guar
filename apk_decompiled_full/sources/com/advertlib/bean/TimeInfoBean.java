package com.advertlib.bean;

import android.os.SystemClock;

/* loaded from: classes.dex */
public final class TimeInfoBean {
    private final long localTime;
    private final long sysTime;

    public TimeInfoBean(long j10, long j11) {
        this.sysTime = j10;
        this.localTime = j11;
    }

    public static /* synthetic */ long getCurrTime$default(TimeInfoBean timeInfoBean, long j10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            j10 = SystemClock.elapsedRealtime();
        }
        return timeInfoBean.getCurrTime(j10);
    }

    public final long getCurrTime(long j10) {
        return this.sysTime + (j10 - this.localTime);
    }

    public final long getSysTime() {
        return this.sysTime;
    }
}
