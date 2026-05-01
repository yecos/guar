package com.efs.sdk.base.core.util;

import android.content.Context;
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
    */
    public static boolean isProcessExist(Context context, String str) {
        try {
            int parseInt = Integer.parseInt(str);
            List<Integer> list = f6222b;
            boolean z10 = false;
            if (list != null && !list.isEmpty() && f6223c > 0 && System.currentTimeMillis() - f6223c <= 600000) {
                z10 = true;
            }
            return f6222b.contains(Integer.valueOf(parseInt));
        } catch (Throwable th) {
            Log.e("efs.base", "Process exist judge error", th);
            return true;
        }
    }

    public static int myPid() {
        return Process.myPid();
    }
}
