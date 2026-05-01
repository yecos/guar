package com.hpplay.common.log;

/* loaded from: classes2.dex */
public class LeLog {
    private static ILog mLogger = new Logger();

    public static String D(String str, String str2) {
        return mLogger.D(str, str2);
    }

    public static String E(String str, String str2) {
        return mLogger.E(str, str2);
    }

    public static String I(String str, String str2) {
        return mLogger.I(str, str2);
    }

    public static String V(String str, String str2) {
        return mLogger.V(str, str2);
    }

    public static String W(String str, String str2) {
        return mLogger.W(str, str2);
    }

    public static String d(String str, String str2) {
        return mLogger.d(str, str2);
    }

    public static synchronized void disableTrace() {
        synchronized (LeLog.class) {
            synchronized (LeLog.class) {
                mLogger = new LoggerHolder(null);
            }
        }
    }

    public static String e(String str, String str2) {
        return mLogger.e(str, str2);
    }

    public static synchronized void enableTrace() {
        synchronized (LeLog.class) {
            enableTrace(null);
        }
    }

    public static String i(String str, String str2) {
        return mLogger.i(str, str2);
    }

    public static String v(String str, String str2) {
        return mLogger.v(str, str2);
    }

    public static String w(String str, String str2) {
        return mLogger.w(str, str2);
    }

    public static String D(String str, String str2, Throwable th) {
        return mLogger.D(str, str2, th);
    }

    public static String E(String str, String str2, Throwable th) {
        return mLogger.E(str, str2, th);
    }

    public static String I(String str, String str2, Throwable th) {
        return mLogger.I(str, str2, th);
    }

    public static String V(String str, String str2, Throwable th) {
        return mLogger.V(str, str2, th);
    }

    public static String W(String str, String str2, Throwable th) {
        return mLogger.W(str, str2, th);
    }

    public static String d(String str, String str2, Throwable th) {
        return mLogger.d(str, str2, th);
    }

    public static String e(String str, String str2, Throwable th) {
        return mLogger.e(str, str2, th);
    }

    public static String i(String str, String str2, Throwable th) {
        return mLogger.i(str, str2, th);
    }

    public static String v(String str, String str2, Throwable th) {
        return mLogger.v(str, str2, th);
    }

    public static String w(String str, String str2, Throwable th) {
        return mLogger.w(str, str2, th);
    }

    public static String W(String str, Throwable th) {
        return mLogger.W(str, th);
    }

    public static synchronized void enableTrace(ILogCallback iLogCallback) {
        synchronized (LeLog.class) {
            synchronized (LeLog.class) {
                if (iLogCallback == null) {
                    mLogger = new Logger();
                } else {
                    mLogger = new LoggerWriter(iLogCallback);
                }
            }
        }
    }

    public static String w(String str, Throwable th) {
        return mLogger.w(str, th);
    }

    public static synchronized void disableTrace(ILogCallback iLogCallback) {
        synchronized (LeLog.class) {
            synchronized (LeLog.class) {
                mLogger = new LoggerHolder(iLogCallback);
            }
        }
    }
}
