package com.taobao.accs.internal;

import android.app.job.JobParameters;
import android.app.job.JobService;
import android.content.Context;
import android.content.Intent;
import com.taobao.accs.common.Constants;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.j;

/* loaded from: classes3.dex */
public class AccsJobService extends JobService {
    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i10, int i11) {
        return 2;
    }

    @Override // android.app.job.JobService
    public boolean onStartJob(JobParameters jobParameters) {
        String packageName;
        Context applicationContext;
        ALog.d("AccsJobService", "onStartJob", new Object[0]);
        try {
            packageName = getPackageName();
            Intent intent = new Intent();
            intent.setPackage(packageName);
            intent.setAction(Constants.ACTION_COMMAND);
            intent.putExtra("command", 201);
            intent.setClassName(packageName, j.channelService);
            applicationContext = getApplicationContext();
            com.taobao.accs.a.a.a(applicationContext, intent);
        } catch (Throwable th) {
            ALog.e("AccsJobService", "onStartJob", th, new Object[0]);
        }
        return false;
    }

    @Override // android.app.job.JobService
    public boolean onStopJob(JobParameters jobParameters) {
        String packageName;
        String packageName2;
        Context applicationContext;
        try {
            Intent intent = new Intent();
            packageName = getPackageName();
            intent.setPackage(packageName);
            intent.setAction(Constants.ACTION_COMMAND);
            intent.putExtra("command", 201);
            packageName2 = getPackageName();
            intent.setClassName(packageName2, j.channelService);
            applicationContext = getApplicationContext();
            com.taobao.accs.a.a.a(applicationContext, intent);
        } catch (Throwable th) {
            ALog.e("AccsJobService", "onStopJob", th, new Object[0]);
        }
        return false;
    }
}
