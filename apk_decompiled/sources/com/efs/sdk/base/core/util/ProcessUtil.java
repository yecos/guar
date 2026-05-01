package com.efs.sdk.base.core.util;

import android.os.Process;
import android.text.TextUtils;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.List;

/* loaded from: classes.dex */
public class ProcessUtil {

    /* renamed from: a, reason: collision with root package name */
    private static String f6221a = null;

    /* renamed from: b, reason: collision with root package name */
    private static List<Integer> f6222b = null;

    /* renamed from: c, reason: collision with root package name */
    private static long f6223c = -1;

    public static String getCurrentProcessName() {
        String str = f6221a;
        if (!TextUtils.isEmpty(str)) {
            return str;
        }
        String processName = getProcessName(Process.myPid());
        f6221a = processName;
        return processName;
    }

    public static String getProcessName(int i10) {
        BufferedReader bufferedReader = null;
        try {
            BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(new FileInputStream("/proc/" + i10 + "/cmdline")));
            try {
                StringBuilder sb = new StringBuilder();
                while (true) {
                    int read = bufferedReader2.read();
                    if (read <= 0) {
                        sb.trimToSize();
                        String sb2 = sb.toString();
                        try {
                            bufferedReader2.close();
                            return sb2;
                        } catch (Throwable th) {
                            th.printStackTrace();
                            return sb2;
                        }
                    }
                    sb.append((char) read);
                }
            } catch (Throwable th2) {
                th = th2;
                bufferedReader = bufferedReader2;
                try {
                    Log.e("efs.base", "get process name error", th);
                    return "";
                } finally {
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (Throwable th3) {
                            th3.printStackTrace();
                        }
                    }
                }
            }
        } catch (Throwable th4) {
            th = th4;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x002b, code lost:
    
        r0 = com.efs.sdk.base.core.util.ProcessUtil.f6222b;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x002d, code lost:
    
        if (r0 == null) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x002f, code lost:
    
        r0.clear();
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0046, code lost:
    
        if (android.text.TextUtils.isEmpty(getProcessName(android.os.Process.myPid())) != false) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0048, code lost:
    
        com.efs.sdk.base.core.util.ProcessUtil.f6222b.add(java.lang.Integer.valueOf(android.os.Process.myPid()));
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x005d, code lost:
    
        if (android.text.TextUtils.isEmpty(getProcessName(r7)) != false) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x005f, code lost:
    
        com.efs.sdk.base.core.util.ProcessUtil.f6222b.add(java.lang.Integer.valueOf(r7));
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0068, code lost:
    
        com.efs.sdk.base.core.util.ProcessUtil.f6223c = java.lang.System.currentTimeMillis();
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0033, code lost:
    
        com.efs.sdk.base.core.util.ProcessUtil.f6222b = new java.util.ArrayList();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean isProcessExist(android.content.Context r6, java.lang.String r7) {
        /*
            r6 = 1
            int r7 = java.lang.Integer.parseInt(r7)     // Catch: java.lang.Throwable -> L79
            java.util.List<java.lang.Integer> r0 = com.efs.sdk.base.core.util.ProcessUtil.f6222b     // Catch: java.lang.Throwable -> L79
            r1 = 0
            if (r0 == 0) goto L29
            boolean r0 = r0.isEmpty()     // Catch: java.lang.Throwable -> L79
            if (r0 == 0) goto L11
            goto L29
        L11:
            long r2 = com.efs.sdk.base.core.util.ProcessUtil.f6223c     // Catch: java.lang.Throwable -> L79
            r4 = 0
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 <= 0) goto L29
            long r2 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Throwable -> L79
            long r4 = com.efs.sdk.base.core.util.ProcessUtil.f6223c     // Catch: java.lang.Throwable -> L79
            long r2 = r2 - r4
            r4 = 600000(0x927c0, double:2.964394E-318)
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 <= 0) goto L28
            goto L29
        L28:
            r1 = 1
        L29:
            if (r1 != 0) goto L6e
            java.util.List<java.lang.Integer> r0 = com.efs.sdk.base.core.util.ProcessUtil.f6222b     // Catch: java.lang.Throwable -> L79
            if (r0 == 0) goto L33
            r0.clear()     // Catch: java.lang.Throwable -> L79
            goto L3a
        L33:
            java.util.ArrayList r0 = new java.util.ArrayList     // Catch: java.lang.Throwable -> L79
            r0.<init>()     // Catch: java.lang.Throwable -> L79
            com.efs.sdk.base.core.util.ProcessUtil.f6222b = r0     // Catch: java.lang.Throwable -> L79
        L3a:
            int r0 = android.os.Process.myPid()     // Catch: java.lang.Throwable -> L79
            java.lang.String r0 = getProcessName(r0)     // Catch: java.lang.Throwable -> L79
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch: java.lang.Throwable -> L79
            if (r0 != 0) goto L55
            java.util.List<java.lang.Integer> r0 = com.efs.sdk.base.core.util.ProcessUtil.f6222b     // Catch: java.lang.Throwable -> L79
            int r1 = android.os.Process.myPid()     // Catch: java.lang.Throwable -> L79
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)     // Catch: java.lang.Throwable -> L79
            r0.add(r1)     // Catch: java.lang.Throwable -> L79
        L55:
            java.lang.String r0 = getProcessName(r7)     // Catch: java.lang.Throwable -> L79
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch: java.lang.Throwable -> L79
            if (r0 != 0) goto L68
            java.util.List<java.lang.Integer> r0 = com.efs.sdk.base.core.util.ProcessUtil.f6222b     // Catch: java.lang.Throwable -> L79
            java.lang.Integer r1 = java.lang.Integer.valueOf(r7)     // Catch: java.lang.Throwable -> L79
            r0.add(r1)     // Catch: java.lang.Throwable -> L79
        L68:
            long r0 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Throwable -> L79
            com.efs.sdk.base.core.util.ProcessUtil.f6223c = r0     // Catch: java.lang.Throwable -> L79
        L6e:
            java.util.List<java.lang.Integer> r0 = com.efs.sdk.base.core.util.ProcessUtil.f6222b     // Catch: java.lang.Throwable -> L79
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)     // Catch: java.lang.Throwable -> L79
            boolean r6 = r0.contains(r7)     // Catch: java.lang.Throwable -> L79
            return r6
        L79:
            r7 = move-exception
            java.lang.String r0 = "efs.base"
            java.lang.String r1 = "Process exist judge error"
            com.efs.sdk.base.core.util.Log.e(r0, r1, r7)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.efs.sdk.base.core.util.ProcessUtil.isProcessExist(android.content.Context, java.lang.String):boolean");
    }

    public static int myPid() {
        return Process.myPid();
    }
}
