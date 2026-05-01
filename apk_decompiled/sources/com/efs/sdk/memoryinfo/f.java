package com.efs.sdk.memoryinfo;

import android.os.Build;
import android.os.Debug;
import android.text.TextUtils;
import android.util.Log;

/* loaded from: classes.dex */
final class f {
    public static long a(Debug.MemoryInfo memoryInfo) {
        String memoryStat;
        if (Build.VERSION.SDK_INT < 23) {
            return 0L;
        }
        memoryStat = memoryInfo.getMemoryStat("summary.graphics");
        try {
            if (TextUtils.isEmpty(memoryStat)) {
                return 0L;
            }
            return Long.parseLong(memoryStat);
        } catch (Exception unused) {
            return 0L;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0069, code lost:
    
        r5 = java.lang.Long.parseLong(r8.group());
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static long a() {
        /*
            r0 = -1
            java.io.BufferedReader r2 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> La0
            java.io.FileReader r3 = new java.io.FileReader     // Catch: java.lang.Throwable -> La0
            java.io.File r4 = new java.io.File     // Catch: java.lang.Throwable -> La0
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> La0
            java.lang.String r6 = "/proc/"
            r5.<init>(r6)     // Catch: java.lang.Throwable -> La0
            int r6 = android.os.Process.myPid()     // Catch: java.lang.Throwable -> La0
            r5.append(r6)     // Catch: java.lang.Throwable -> La0
            java.lang.String r6 = "/status"
            r5.append(r6)     // Catch: java.lang.Throwable -> La0
            java.lang.String r5 = r5.toString()     // Catch: java.lang.Throwable -> La0
            r4.<init>(r5)     // Catch: java.lang.Throwable -> La0
            r3.<init>(r4)     // Catch: java.lang.Throwable -> La0
            r2.<init>(r3)     // Catch: java.lang.Throwable -> La0
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L9e
            r3.<init>()     // Catch: java.lang.Throwable -> L9e
        L2d:
            java.lang.String r4 = r2.readLine()     // Catch: java.lang.Throwable -> L9e
            if (r4 == 0) goto L3c
            r3.append(r4)     // Catch: java.lang.Throwable -> L9e
            r4 = 10
            r3.append(r4)     // Catch: java.lang.Throwable -> L9e
            goto L2d
        L3c:
            java.lang.String r3 = r3.toString()     // Catch: java.lang.Throwable -> L9e
            java.lang.String r3 = r3.trim()     // Catch: java.lang.Throwable -> L9e
            java.lang.String r4 = "\n"
            java.lang.String[] r3 = r3.split(r4)     // Catch: java.lang.Throwable -> L9e
            int r4 = r3.length     // Catch: java.lang.Throwable -> L9e
            int r5 = r3.length     // Catch: java.lang.Throwable -> L9e
            r6 = 0
        L4d:
            java.lang.String r7 = "\\d+"
            if (r6 >= r5) goto L75
            r8 = r3[r6]     // Catch: java.lang.Throwable -> L9e
            java.lang.String r9 = "VmSize"
            boolean r9 = r8.startsWith(r9)     // Catch: java.lang.Throwable -> L9e
            if (r9 == 0) goto L72
            java.util.regex.Pattern r9 = java.util.regex.Pattern.compile(r7)     // Catch: java.lang.Throwable -> L9e
            java.util.regex.Matcher r8 = r9.matcher(r8)     // Catch: java.lang.Throwable -> L9e
            boolean r9 = r8.find()     // Catch: java.lang.Throwable -> L9e
            if (r9 == 0) goto L72
            java.lang.String r5 = r8.group()     // Catch: java.lang.Throwable -> L9e
            long r5 = java.lang.Long.parseLong(r5)     // Catch: java.lang.Throwable -> L9e
            goto L76
        L72:
            int r6 = r6 + 1
            goto L4d
        L75:
            r5 = r0
        L76:
            int r8 = (r5 > r0 ? 1 : (r5 == r0 ? 0 : -1))
            if (r8 != 0) goto L9a
            r0 = 12
            if (r4 <= r0) goto L9a
            java.util.regex.Pattern r1 = java.util.regex.Pattern.compile(r7)     // Catch: java.lang.Throwable -> L97
            r0 = r3[r0]     // Catch: java.lang.Throwable -> L97
            java.util.regex.Matcher r0 = r1.matcher(r0)     // Catch: java.lang.Throwable -> L97
            boolean r1 = r0.find()     // Catch: java.lang.Throwable -> L97
            if (r1 == 0) goto L9a
            java.lang.String r0 = r0.group()     // Catch: java.lang.Throwable -> L97
            long r5 = java.lang.Long.parseLong(r0)     // Catch: java.lang.Throwable -> L97
            goto L9a
        L97:
            r0 = r5
            goto La1
        L9a:
            r2.close()     // Catch: java.lang.Throwable -> La7
            goto La7
        L9e:
            goto La1
        La0:
            r2 = 0
        La1:
            if (r2 == 0) goto La6
            r2.close()     // Catch: java.lang.Throwable -> La6
        La6:
            r5 = r0
        La7:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.efs.sdk.memoryinfo.f.a():long");
    }

    public static void a(String str, Throwable th) {
        if (a.DEBUG) {
            Log.e("MemoryCollect", str, th);
        }
    }
}
