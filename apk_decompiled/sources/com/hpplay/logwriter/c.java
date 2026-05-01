package com.hpplay.logwriter;

import android.app.ActivityManager;
import android.content.Context;
import android.net.TrafficStats;
import android.os.Build;
import android.os.Process;
import com.raizlabs.android.dbflow.sql.language.Operator;
import com.umeng.analytics.pro.bt;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.text.DecimalFormat;

/* loaded from: classes2.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private static final String f7390a = "DeviceInfoUtils";

    /* renamed from: b, reason: collision with root package name */
    private static final String f7391b = "status.txt";

    public static void a(String str, Context context) {
        File file = new File(str, f7391b);
        if (file.exists()) {
            file.delete();
            file = new File(str, f7391b);
        }
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file, true);
            StringBuilder sb = new StringBuilder();
            sb.append(a("memory_avail_mem", "" + a(context).availMem));
            sb.append(a("memory_app_use_mem", d()));
            sb.append(a("app_use_cpu", "" + a() + Operator.Operation.MOD));
            sb.append(a("net_speed", e()));
            sb.append(a("android_sdk_version", Build.VERSION.SDK));
            sb.append(a(bt.F, Build.BRAND));
            sb.append(a("device_hardware", Build.HARDWARE));
            sb.append(a("memory_total_mem", "" + a(context).totalMem));
            fileOutputStream.write(sb.toString().getBytes());
            fileOutputStream.flush();
            fileOutputStream.close();
        } catch (Exception e10) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("saveDeviceInfo,");
            sb2.append(e10);
        }
    }

    public static long b() {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream("/proc/stat")), 1000);
            String readLine = bufferedReader.readLine();
            bufferedReader.close();
            String[] split = readLine.split(" ");
            if (split != null) {
                return Long.parseLong(split[2]) + Long.parseLong(split[3]) + Long.parseLong(split[4]) + Long.parseLong(split[6]) + Long.parseLong(split[5]) + Long.parseLong(split[7]) + Long.parseLong(split[8]);
            }
            return 0L;
        } catch (Exception e10) {
            StringBuilder sb = new StringBuilder();
            sb.append("getTotalCpuTime,");
            sb.append(e10);
            return 0L;
        }
    }

    public static long c() {
        String[] strArr;
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream("/proc/" + Process.myPid() + "/stat")), 1000);
            String readLine = bufferedReader.readLine();
            bufferedReader.close();
            strArr = readLine.split(" ");
        } catch (Exception e10) {
            StringBuilder sb = new StringBuilder();
            sb.append("getAppCpuTime,");
            sb.append(e10);
            strArr = null;
        }
        return Long.parseLong(strArr[13]) + Long.parseLong(strArr[14]) + Long.parseLong(strArr[15]) + Long.parseLong(strArr[16]);
    }

    public static String d() {
        String str = null;
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream("/proc/" + Process.myPid() + "/status")), 1000);
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                }
                String[] split = readLine.replace(" ", "").split("[: k K]");
                if (split[0].equals("VmRSS")) {
                    str = split[1];
                    break;
                }
            }
            bufferedReader.close();
        } catch (Exception e10) {
            StringBuilder sb = new StringBuilder();
            sb.append("getAppMemory,");
            sb.append(e10);
        }
        return str;
    }

    public static String e() {
        long totalRxBytes = TrafficStats.getTotalRxBytes() + TrafficStats.getTotalTxBytes();
        long currentTimeMillis = System.currentTimeMillis();
        try {
            Thread.sleep(3000L);
        } catch (Exception unused) {
        }
        float totalRxBytes2 = ((TrafficStats.getTotalRxBytes() + TrafficStats.getTotalTxBytes()) - totalRxBytes) / ((System.currentTimeMillis() - currentTimeMillis) / 1000);
        DecimalFormat decimalFormat = new DecimalFormat("0.00");
        if (totalRxBytes2 >= 1048576.0f) {
            return decimalFormat.format(totalRxBytes2 / 1048576.0f) + "MB/s";
        }
        return decimalFormat.format(totalRxBytes2 / 1024.0f) + "KB/s";
    }

    public static String a(String str, String str2) {
        return str + " : " + str2 + " \n";
    }

    public static ActivityManager.MemoryInfo a(Context context) {
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        ((ActivityManager) context.getSystemService("activity")).getMemoryInfo(memoryInfo);
        return memoryInfo;
    }

    public static float a() {
        float b10 = b();
        float c10 = c();
        try {
            Thread.sleep(360L);
        } catch (Exception unused) {
        }
        return ((c() - c10) * 100.0f) / (b() - b10);
    }
}
