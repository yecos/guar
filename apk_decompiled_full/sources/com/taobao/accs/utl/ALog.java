package com.taobao.accs.utl;

import android.util.Log;
import com.hpplay.cybergarage.soap.SOAP;

/* loaded from: classes3.dex */
public class ALog {
    public static volatile boolean isPrintLog = true;
    private static final String preTag = "NAccs.";
    private static volatile ILog sLog;

    public interface ILog {
        void d(String str, String str2);

        void e(String str, String str2);

        void e(String str, String str2, Throwable th);

        void i(String str, String str2);

        boolean isPrintLog(int i10);

        boolean isValid();

        void setLogLevel(int i10);

        void w(String str, String str2);

        void w(String str, String str2, Throwable th);
    }

    public enum Level {
        V,
        D,
        I,
        W,
        E,
        L
    }

    private static String buildLogMsg(String str, Object... objArr) {
        if (str == null && objArr == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        if (str != null) {
            sb.append(str);
        }
        if (objArr != null) {
            int i10 = 0;
            while (true) {
                int i11 = i10 + 1;
                if (i11 >= objArr.length) {
                    break;
                }
                sb.append(" ");
                sb.append(formatKv(objArr[i10], objArr[i11]));
                i10 = i11 + 1;
            }
            if (i10 == objArr.length - 1) {
                sb.append(" ");
                sb.append(objArr[i10]);
            }
        }
        return sb.toString();
    }

    private static String buildLogTag(String str) {
        return preTag + str;
    }

    public static void d(String str, String str2, Object... objArr) {
        if (isPrintLog()) {
            String buildLogTag = buildLogTag(str);
            String buildLogMsg = buildLogMsg(str2, objArr);
            ILog iLog = sLog;
            if (iLog != null) {
                iLog.d(buildLogTag, buildLogMsg);
            }
        }
    }

    public static void e(String str, String str2, Object... objArr) {
        if (isPrintLog()) {
            String buildLogTag = buildLogTag(str);
            String buildLogMsg = buildLogMsg(str2, objArr);
            ILog iLog = sLog;
            if (iLog != null) {
                iLog.e(buildLogTag, buildLogMsg);
            } else {
                Log.e(buildLogTag, buildLogMsg);
            }
        }
    }

    private static String formatKv(Object obj, Object obj2) {
        StringBuilder sb = new StringBuilder();
        if (obj == null) {
            obj = "";
        }
        sb.append(obj);
        sb.append(SOAP.DELIM);
        if (obj2 == null) {
            obj2 = "";
        }
        sb.append(obj2);
        return sb.toString();
    }

    public static void i(String str, String str2, Object... objArr) {
        if (isPrintLog()) {
            String buildLogTag = buildLogTag(str);
            String buildLogMsg = buildLogMsg(str2, objArr);
            ILog iLog = sLog;
            if (iLog != null) {
                iLog.i(buildLogTag, buildLogMsg);
            }
        }
    }

    public static boolean isPrintLog() {
        ILog iLog = sLog;
        return iLog != null ? iLog.isPrintLog(4) : isPrintLog;
    }

    public static void setLog(ILog iLog) {
        if (iLog == null || !iLog.isValid()) {
            return;
        }
        sLog = iLog;
    }

    public static void setPrintLog(boolean z10) {
        isPrintLog = z10;
    }

    public static void v(String str, String str2, Object... objArr) {
        if (isPrintLog()) {
            buildLogTag(str);
            buildLogMsg(str2, objArr);
        }
    }

    public static void w(String str, String str2, Object... objArr) {
        if (isPrintLog()) {
            String buildLogTag = buildLogTag(str);
            String buildLogMsg = buildLogMsg(str2, objArr);
            ILog iLog = sLog;
            if (iLog != null) {
                iLog.w(buildLogTag, buildLogMsg);
            }
        }
    }

    public static boolean isPrintLog(Level level) {
        ILog iLog = sLog;
        if (iLog != null) {
            return iLog.isPrintLog(4);
        }
        return isPrintLog;
    }

    public static void w(String str, String str2, Throwable th, Object... objArr) {
        if (isPrintLog()) {
            String buildLogTag = buildLogTag(str);
            String buildLogMsg = buildLogMsg(str2, objArr);
            ILog iLog = sLog;
            if (iLog != null) {
                iLog.w(buildLogTag, buildLogMsg, th);
            }
        }
    }

    public static void e(String str, String str2, Throwable th, Object... objArr) {
        if (isPrintLog()) {
            String buildLogTag = buildLogTag(str);
            String buildLogMsg = buildLogMsg(str2, objArr);
            ILog iLog = sLog;
            if (iLog != null) {
                iLog.e(buildLogTag, buildLogMsg, th);
            } else {
                Log.e(buildLogTag, buildLogMsg, th);
            }
        }
    }
}
