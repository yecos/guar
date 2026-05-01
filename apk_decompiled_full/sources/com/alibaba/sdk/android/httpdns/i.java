package com.alibaba.sdk.android.httpdns;

import android.util.Log;
import com.hpplay.cybergarage.soap.SOAP;

/* loaded from: classes.dex */
public class i {

    /* renamed from: a, reason: collision with root package name */
    private static ILogger f5908a = null;

    /* renamed from: c, reason: collision with root package name */
    private static int f5909c = -1;

    /* renamed from: c, reason: collision with other field name */
    private static boolean f21c = false;

    public static void a(Throwable th) {
        if (!f21c || th == null) {
            return;
        }
        th.printStackTrace();
    }

    private static String c() {
        try {
            if (f5909c == -1) {
                StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
                int length = stackTrace.length;
                int i10 = 0;
                int i11 = 0;
                while (true) {
                    if (i10 >= length) {
                        break;
                    }
                    if (stackTrace[i10].getMethodName().equals("getTraceInfo")) {
                        f5909c = i11 + 1;
                        break;
                    }
                    i11++;
                    i10++;
                }
            }
            StackTraceElement stackTraceElement = Thread.currentThread().getStackTrace()[f5909c + 1];
            return stackTraceElement.getFileName() + SOAP.DELIM + stackTraceElement.getLineNumber() + " - [" + stackTraceElement.getMethodName() + "]";
        } catch (Exception e10) {
            e10.printStackTrace();
            return "";
        }
    }

    public static void d(String str) {
        if (f21c && str != null) {
            StringBuilder sb = new StringBuilder();
            sb.append(Thread.currentThread().getId());
            sb.append(" - ");
            sb.append(c());
            sb.append(" - ");
            sb.append(str);
        }
        ILogger iLogger = f5908a;
        if (iLogger != null) {
            iLogger.log(str);
        }
    }

    public static void e(String str) {
        if (f21c && str != null) {
            StringBuilder sb = new StringBuilder();
            sb.append(Thread.currentThread().getId());
            sb.append(" - ");
            sb.append(c());
            sb.append(" - ");
            sb.append(str);
        }
        ILogger iLogger = f5908a;
        if (iLogger != null) {
            iLogger.log(str);
        }
    }

    public static void f(String str) {
        if (f21c && str != null) {
            Log.e("HttpDnsSDK", Thread.currentThread().getId() + " - " + c() + " - " + str);
        }
        ILogger iLogger = f5908a;
        if (iLogger != null) {
            iLogger.log(str);
        }
    }

    public static synchronized void setLogEnabled(boolean z10) {
        synchronized (i.class) {
            f21c = z10;
        }
    }

    public static void setLogger(ILogger iLogger) {
        f5908a = iLogger;
    }
}
