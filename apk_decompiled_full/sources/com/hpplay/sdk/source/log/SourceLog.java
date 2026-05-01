package com.hpplay.sdk.source.log;

import android.content.Context;

/* loaded from: classes3.dex */
public class SourceLog {
    public static final int LOG_ALL = 100;
    public static final int LOG_LELOG = 1;
    public static final int LOG_LOGCAT = 2;
    private static SourceLogWriter sSourceLog = new SourceLogWriter();

    public static void D(String str, String str2) {
        sSourceLog.D(str, str2);
    }

    public static void E(String str, String str2) {
        sSourceLog.E(str, str2);
    }

    public static void I(String str, String str2) {
        sSourceLog.I(str, str2);
    }

    public static void V(String str, String str2) {
        sSourceLog.V(str, str2);
    }

    public static void W(String str, String str2) {
        sSourceLog.W(str, str2);
    }

    public static void d(String str, String str2) {
        sSourceLog.d(str, str2);
    }

    public static void debug(String str, String str2) {
    }

    public static void disableLog(Context context, int i10) {
        sSourceLog.disableLogButWriter(context, i10);
    }

    public static void disableLogWriter() {
        sSourceLog.disableLogAndWriter();
    }

    public static void e(String str, String str2) {
        sSourceLog.e(str, str2);
    }

    public static void enableLog() {
        sSourceLog.enableLogNotWriter();
    }

    public static void enableLogWriter(Context context, int i10) {
        sSourceLog.enableLogAndWriter(context, i10);
    }

    public static void flushLogWriter() {
        sSourceLog.flushLogWriter();
    }

    public static String getLogDir() {
        return sSourceLog.getLogDir();
    }

    public static void i(String str, String str2) {
        sSourceLog.i(str, str2);
    }

    public static void v(String str, String str2) {
        sSourceLog.v(str, str2);
    }

    public static void w(String str, String str2) {
        sSourceLog.w(str, str2);
    }

    public static void writeLog(String str) {
        sSourceLog.writeLog(str);
    }

    public static void D(String str, String str2, Throwable th) {
        sSourceLog.D(str, str2, th);
    }

    public static void E(String str, String str2, Throwable th) {
        sSourceLog.E(str, str2, th);
    }

    public static void I(String str, String str2, Throwable th) {
        sSourceLog.I(str, str2, th);
    }

    public static void V(String str, String str2, Throwable th) {
        sSourceLog.V(str, str2, th);
    }

    public static void W(String str, String str2, Throwable th) {
        sSourceLog.W(str, str2, th);
    }

    public static void d(String str, String str2, Throwable th) {
        sSourceLog.d(str, str2, th);
    }

    public static void e(String str, String str2, Throwable th) {
        sSourceLog.e(str, str2, th);
    }

    public static void i(String str, String str2, Throwable th) {
        sSourceLog.i(str, str2, th);
    }

    public static void v(String str, String str2, Throwable th) {
        sSourceLog.v(str, str2, th);
    }

    public static void w(String str, String str2, Throwable th) {
        sSourceLog.w(str, str2, th);
    }

    public static void W(String str, Throwable th) {
        sSourceLog.W(str, th);
    }

    public static void w(String str, Throwable th) {
        sSourceLog.w(str, th);
    }
}
