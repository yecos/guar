package com.efs.sdk.memoryinfo;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Debug;
import android.os.Process;

/* loaded from: classes.dex */
final class c {
    final String activity;
    final String bg;

    /* renamed from: n, reason: collision with root package name */
    final long f6317n;

    /* renamed from: o, reason: collision with root package name */
    final long f6318o;

    /* renamed from: p, reason: collision with root package name */
    final long f6319p;

    /* renamed from: q, reason: collision with root package name */
    final long f6320q;

    /* renamed from: r, reason: collision with root package name */
    final float f6321r;

    /* renamed from: s, reason: collision with root package name */
    final long f6322s;

    /* renamed from: t, reason: collision with root package name */
    final long f6323t;

    public c(Context context) {
        Debug.MemoryInfo[] processMemoryInfo;
        Debug.MemoryInfo memoryInfo = null;
        try {
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            if (activityManager != null && (processMemoryInfo = activityManager.getProcessMemoryInfo(new int[]{Process.myPid()})) != null && processMemoryInfo.length > 0) {
                memoryInfo = processMemoryInfo[0];
            }
        } catch (Throwable unused) {
        }
        if (memoryInfo == null) {
            memoryInfo = new Debug.MemoryInfo();
            Debug.getMemoryInfo(memoryInfo);
        }
        this.bg = UMMemoryMonitor.get().isForeground() ? "fg" : "bg";
        this.f6317n = memoryInfo.getTotalPss() * 1024;
        this.f6318o = memoryInfo.dalvikPss * 1024;
        this.f6319p = memoryInfo.nativePss * 1024;
        this.f6322s = f.a(memoryInfo) * 1024;
        long freeMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        this.f6320q = freeMemory;
        long maxMemory = Runtime.getRuntime().maxMemory();
        if (maxMemory != 0) {
            this.f6321r = (freeMemory * 1.0f) / maxMemory;
        } else {
            this.f6321r = 1.0f;
        }
        this.f6323t = f.a() * 1024;
        this.activity = UMMemoryMonitor.get().getCurrentActivity();
    }
}
