package com.google.android.gms.internal.measurement;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.Context;
import android.os.Build;
import android.os.UserHandle;
import android.util.Log;
import e1.v;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import p.e;

/* loaded from: classes.dex */
public final class zzbt {
    private static final Method zza;
    private static final Method zzb;

    /* JADX WARN: Removed duplicated region for block: B:11:0x003f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    static {
        Method method;
        Method method2 = null;
        if (Build.VERSION.SDK_INT >= 24) {
            try {
                method = e.a().getDeclaredMethod("scheduleAsPackage", a.a(), String.class, Integer.TYPE, String.class);
            } catch (NoSuchMethodException unused) {
                if (Log.isLoggable("JobSchedulerCompat", 6)) {
                    Log.e("JobSchedulerCompat", "No scheduleAsPackage method available, falling back to schedule");
                }
            }
            zza = method;
            if (Build.VERSION.SDK_INT >= 24) {
                try {
                    method2 = UserHandle.class.getDeclaredMethod("myUserId", new Class[0]);
                } catch (NoSuchMethodException unused2) {
                    if (Log.isLoggable("JobSchedulerCompat", 6)) {
                        Log.e("JobSchedulerCompat", "No myUserId method available");
                    }
                }
            }
            zzb = method2;
        }
        method = null;
        zza = method;
        if (Build.VERSION.SDK_INT >= 24) {
        }
        zzb = method2;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x004a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int zza(Context context, JobInfo jobInfo, String str, String str2) {
        int schedule;
        int checkSelfPermission;
        Integer num;
        int intValue;
        Method method;
        int schedule2;
        JobScheduler a10 = v.a(context.getSystemService("jobscheduler"));
        a10.getClass();
        if (zza != null) {
            checkSelfPermission = context.checkSelfPermission("android.permission.UPDATE_DEVICE_STATS");
            if (checkSelfPermission == 0) {
                Method method2 = zzb;
                if (method2 != null) {
                    try {
                        num = (Integer) method2.invoke(UserHandle.class, new Object[0]);
                    } catch (IllegalAccessException | InvocationTargetException e10) {
                        if (Log.isLoggable("JobSchedulerCompat", 6)) {
                            Log.e("JobSchedulerCompat", "myUserId invocation illegal", e10);
                        }
                    }
                    if (num != null) {
                        intValue = num.intValue();
                        method = zza;
                        if (method != null) {
                            try {
                                Integer num2 = (Integer) method.invoke(a10, jobInfo, "com.google.android.gms", Integer.valueOf(intValue), "UploadAlarm");
                                if (num2 != null) {
                                    return num2.intValue();
                                }
                                return 0;
                            } catch (IllegalAccessException | InvocationTargetException e11) {
                                Log.e("UploadAlarm", "error calling scheduleAsPackage", e11);
                            }
                        }
                        schedule2 = a10.schedule(jobInfo);
                        return schedule2;
                    }
                }
                intValue = 0;
                method = zza;
                if (method != null) {
                }
                schedule2 = a10.schedule(jobInfo);
                return schedule2;
            }
        }
        schedule = a10.schedule(jobInfo);
        return schedule;
    }
}
