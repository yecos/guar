package com.mobile.brasiltv.utils;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Process;
import java.util.List;

/* loaded from: classes.dex */
public abstract class e {
    public static String a(Context context) {
        try {
            return ("" + context.getPackageManager().getPackageInfo(context.getPackageName(), 64).versionCode).trim();
        } catch (PackageManager.NameNotFoundException e10) {
            throw new RuntimeException("System fault!!!", e10);
        }
    }

    public static String b(Context context) {
        try {
            return ("" + context.getPackageManager().getPackageInfo(context.getPackageName(), 64).versionName).trim();
        } catch (PackageManager.NameNotFoundException e10) {
            throw new RuntimeException("System fault!!!", e10);
        }
    }

    public static String c(Context context, String str) {
        try {
            return context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData.getString(str);
        } catch (Exception e10) {
            e10.printStackTrace();
            return "";
        }
    }

    public static boolean d(Context context) {
        int myPid = Process.myPid();
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        String packageName = context.getPackageName();
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = activityManager.getRunningAppProcesses();
        if (runningAppProcesses == null) {
            return false;
        }
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
            if (runningAppProcessInfo.pid == myPid && runningAppProcessInfo.processName.equals(packageName)) {
                return true;
            }
        }
        return false;
    }
}
