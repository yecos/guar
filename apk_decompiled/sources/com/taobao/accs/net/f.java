package com.taobao.accs.net;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import com.taobao.accs.internal.AccsJobService;

/* loaded from: classes3.dex */
class f extends g {

    /* renamed from: c, reason: collision with root package name */
    private JobScheduler f9182c;

    public f(Context context) {
        super(context);
    }

    @Override // com.taobao.accs.net.g
    public void a(int i10) {
        JobInfo.Builder minimumLatency;
        JobInfo.Builder overrideDeadline;
        JobInfo.Builder requiredNetworkType;
        JobInfo build;
        if (this.f9182c == null) {
            this.f9182c = e1.v.a(this.f9185a.getSystemService("jobscheduler"));
        }
        this.f9182c.cancel(com.umeng.analytics.pro.k.f10421b);
        long j10 = i10 * 1000;
        minimumLatency = new JobInfo.Builder(com.umeng.analytics.pro.k.f10421b, new ComponentName(this.f9185a.getPackageName(), AccsJobService.class.getName())).setMinimumLatency(j10);
        overrideDeadline = minimumLatency.setOverrideDeadline(j10);
        requiredNetworkType = overrideDeadline.setRequiredNetworkType(1);
        build = requiredNetworkType.build();
        this.f9182c.schedule(build);
    }
}
