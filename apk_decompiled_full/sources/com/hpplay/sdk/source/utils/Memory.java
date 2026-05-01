package com.hpplay.sdk.source.utils;

import android.app.ActivityManager;
import android.content.Context;

/* loaded from: classes3.dex */
public class Memory {
    public static long RAM;
    public static long freeRAM;
    public static long processAllocMemory;
    public static long processFreeMemory;
    public static long processMaxMemory;

    public static long getProcessAllocMemory(ActivityManager activityManager) {
        return Runtime.getRuntime().totalMemory();
    }

    public static long getProcessFreeMemory(ActivityManager activityManager) {
        return Runtime.getRuntime().freeMemory();
    }

    public static ActivityManager.MemoryInfo getRAM(ActivityManager activityManager) {
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        activityManager.getMemoryInfo(memoryInfo);
        return memoryInfo;
    }

    public static void update(Context context) {
        try {
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            processAllocMemory = getProcessAllocMemory(activityManager);
            processFreeMemory = getProcessFreeMemory(activityManager);
            ActivityManager.MemoryInfo ram = getRAM(activityManager);
            RAM = ram.totalMem;
            freeRAM = ram.availMem;
        } catch (Error unused) {
        }
    }
}
