package com.uyumao;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import com.umeng.commonsdk.utils.UMUtils;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.FileReader;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes3.dex */
public class n {

    /* renamed from: a, reason: collision with root package name */
    public static String f12426a = null;

    /* renamed from: b, reason: collision with root package name */
    public static String f12427b = null;

    /* renamed from: c, reason: collision with root package name */
    public static String f12428c = null;

    /* renamed from: d, reason: collision with root package name */
    public static String f12429d = "";

    public static String a() {
        if (TextUtils.isEmpty(f12428c)) {
            f12428c = Build.BOARD;
        }
        return f12428c;
    }

    public static String b() {
        if (TextUtils.isEmpty(f12426a)) {
            String str = Build.BRAND;
            f12426a = str;
            if (TextUtils.isEmpty(str)) {
                f12426a = Build.MANUFACTURER;
            }
        }
        return f12426a;
    }

    public static String c() {
        if (TextUtils.isEmpty(f12427b)) {
            f12427b = Build.MODEL;
        }
        return f12427b;
    }

    public static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Throwable unused) {
            }
        }
    }

    public static boolean c(Context context) {
        try {
            String b10 = b(context);
            String packageName = context.getApplicationContext().getPackageName();
            if (!TextUtils.isEmpty(b10) && !TextUtils.isEmpty(packageName)) {
                if (b10.equals(packageName)) {
                    return true;
                }
            }
        } catch (Exception unused) {
        }
        return false;
    }

    public static Object a(Object obj, String str, int i10) {
        try {
            return ((PackageManager) obj).getPackageInfo(str, i10);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String b(Context context) {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        if (TextUtils.isEmpty(f12429d)) {
            try {
                String processName = Build.VERSION.SDK_INT >= 28 ? Application.getProcessName() : "";
                if (TextUtils.isEmpty(processName)) {
                    int myPid = Process.myPid();
                    String a10 = a(myPid);
                    if (!TextUtils.isEmpty(a10)) {
                        f12429d = a10;
                    } else {
                        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
                        if (activityManager != null && (runningAppProcesses = activityManager.getRunningAppProcesses()) != null && runningAppProcesses.size() > 0) {
                            Iterator<ActivityManager.RunningAppProcessInfo> it = runningAppProcesses.iterator();
                            while (true) {
                                if (!it.hasNext()) {
                                    break;
                                }
                                ActivityManager.RunningAppProcessInfo next = it.next();
                                if (next.pid == myPid) {
                                    f12429d = next.processName;
                                    break;
                                }
                            }
                        }
                    }
                } else {
                    f12429d = processName;
                }
            } catch (Throwable unused) {
            }
        }
        return f12429d;
    }

    public static String a(int i10) {
        BufferedReader bufferedReader;
        try {
            bufferedReader = new BufferedReader(new FileReader("/proc/" + i10 + "/cmdline"));
            try {
                String readLine = bufferedReader.readLine();
                if (!TextUtils.isEmpty(readLine)) {
                    readLine = readLine.trim();
                }
                try {
                    bufferedReader.close();
                } catch (Throwable unused) {
                }
                return readLine;
            } catch (Throwable unused2) {
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (Throwable unused3) {
                    }
                }
                return null;
            }
        } catch (Throwable unused4) {
            bufferedReader = null;
        }
    }

    public static boolean a(Context context) {
        return UMUtils.checkPermission(context, "android.permission.QUERY_ALL_PACKAGES");
    }
}
