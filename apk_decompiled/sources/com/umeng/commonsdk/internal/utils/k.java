package com.umeng.commonsdk.internal.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.text.TextUtils;
import com.umeng.analytics.pro.bd;
import com.umeng.commonsdk.internal.crash.UMCrashManager;
import com.umeng.commonsdk.statistics.common.ULog;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class k {

    /* renamed from: b, reason: collision with root package name */
    public static final String f10968b = "_dsk_s";

    /* renamed from: c, reason: collision with root package name */
    public static final String f10969c = "_thm_z";

    /* renamed from: d, reason: collision with root package name */
    public static final String f10970d = "_gdf_r";

    /* renamed from: a, reason: collision with root package name */
    public static final String f10967a = bd.b().b(bd.f9992s);

    /* renamed from: e, reason: collision with root package name */
    private static Object f10971e = new Object();

    public static void b(final Context context) {
        if (c(context)) {
            return;
        }
        final String[] strArr = {"unknown", "unknown", "unknown"};
        new Thread() { // from class: com.umeng.commonsdk.internal.utils.k.1
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                super.run();
                try {
                    strArr[0] = k.c();
                    strArr[1] = k.a();
                    strArr[2] = k.b();
                    ULog.i("diskType = " + strArr[0] + "; ThremalZone = " + strArr[1] + "; GoldFishRc = " + strArr[2]);
                    k.b(context, strArr);
                } catch (Throwable th) {
                    UMCrashManager.reportCrash(context, th);
                }
            }
        }.start();
    }

    public static boolean c(Context context) {
        SharedPreferences sharedPreferences;
        return (context == null || (sharedPreferences = context.getApplicationContext().getSharedPreferences(f10967a, 0)) == null || TextUtils.isEmpty(sharedPreferences.getString(f10968b, ""))) ? false : true;
    }

    public static String a(Context context) {
        try {
            SharedPreferences sharedPreferences = context.getApplicationContext().getSharedPreferences(f10967a, 0);
            if (sharedPreferences == null) {
                return null;
            }
            JSONObject jSONObject = new JSONObject();
            synchronized (f10971e) {
                jSONObject.put(f10968b, sharedPreferences.getString(f10968b, ""));
                jSONObject.put(f10969c, sharedPreferences.getString(f10969c, ""));
                jSONObject.put(f10970d, sharedPreferences.getString(f10970d, ""));
            }
            return jSONObject.toString();
        } catch (Exception e10) {
            UMCrashManager.reportCrash(context, e10);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(Context context, String[] strArr) {
        SharedPreferences sharedPreferences;
        if (context == null || (sharedPreferences = context.getApplicationContext().getSharedPreferences(f10967a, 0)) == null) {
            return;
        }
        synchronized (f10971e) {
            sharedPreferences.edit().putString(f10968b, strArr[0]).putString(f10969c, strArr[1]).putString(f10970d, strArr[2]).commit();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0039 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String c() {
        /*
            java.lang.String r0 = "mtd"
            java.lang.String r1 = "sda"
            java.lang.String r2 = "mmcblk"
            r3 = 0
            java.io.BufferedReader r4 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L34
            java.io.FileReader r5 = new java.io.FileReader     // Catch: java.lang.Throwable -> L34
            java.lang.String r6 = "/proc/diskstats"
            r5.<init>(r6)     // Catch: java.lang.Throwable -> L34
            r4.<init>(r5)     // Catch: java.lang.Throwable -> L34
        L13:
            java.lang.String r3 = r4.readLine()     // Catch: java.lang.Throwable -> L33
            if (r3 == 0) goto L30
            boolean r5 = r3.contains(r2)     // Catch: java.lang.Throwable -> L33
            if (r5 == 0) goto L21
            r0 = r2
            goto L37
        L21:
            boolean r5 = r3.contains(r1)     // Catch: java.lang.Throwable -> L33
            if (r5 == 0) goto L29
            r0 = r1
            goto L37
        L29:
            boolean r3 = r3.contains(r0)     // Catch: java.lang.Throwable -> L33
            if (r3 == 0) goto L13
            goto L37
        L30:
            java.lang.String r0 = "unknown"
            goto L37
        L33:
            r3 = r4
        L34:
            java.lang.String r0 = "noper"
            r4 = r3
        L37:
            if (r4 == 0) goto L3c
            r4.close()     // Catch: java.lang.Throwable -> L3c
        L3c:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.commonsdk.internal.utils.k.c():java.lang.String");
    }

    public static String b() {
        int i10;
        try {
            i10 = a("ls /", "goldfish");
        } catch (Throwable unused) {
            i10 = -1;
        }
        return i10 > 0 ? "goldfish" : i10 < 0 ? "noper" : "unknown";
    }

    public static int a(String str, String str2) {
        int i10;
        if (Build.VERSION.SDK_INT > 28) {
            return -1;
        }
        Process exec = Runtime.getRuntime().exec(str);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(exec.getInputStream()));
        while (true) {
            String readLine = bufferedReader.readLine();
            if (readLine == null) {
                i10 = -1;
                break;
            }
            if (readLine.contains(str2)) {
                i10 = 1;
                break;
            }
        }
        try {
            if (exec.waitFor() != 0) {
                return -1;
            }
            return i10;
        } catch (InterruptedException unused) {
            return -1;
        }
    }

    public static String a() {
        int i10;
        try {
            i10 = a("ls /sys/class/thermal", "thermal_zone");
        } catch (Throwable unused) {
            i10 = -1;
        }
        return i10 > 0 ? "thermal_zone" : i10 < 0 ? "noper" : "unknown";
    }
}
