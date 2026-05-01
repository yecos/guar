package com.hpplay.component.common.utils;

import android.util.Log;
import com.hpplay.cybergarage.soap.SOAP;
import java.io.PrintWriter;
import java.io.StringWriter;

/* loaded from: classes2.dex */
public class CLog {
    private static final String LEBO_TAG = "hpplay-component";
    private static final int LOGD = 20;
    private static final int LOGE = 50;
    private static final int LOGI = 30;
    private static final int LOGV = 10;
    private static final int LOGW = 40;
    private static final int LOG_DISABLE = 100;
    private static final int LOG_ENABLE = 0;
    private static final String PERFERMANCE = "hpplay-component:perfermance";
    private static IComponentLogCallback mComponentLogCallback = null;
    private static int sLevel = 30;

    public interface IComponentLogCallback {
        void onCastLog(int i10, String str);
    }

    public static String D(String str, String str2) {
        if (sLevel > 20) {
            return "";
        }
        String formatMessage = formatMessage(str, str2);
        componentLogCallback(sLevel, formatMessage);
        return formatMessage;
    }

    public static String E(String str, String str2) {
        if (sLevel > 50) {
            return "";
        }
        String formatMessage = formatMessage(str, str2);
        Log.e(PERFERMANCE, formatMessage);
        componentLogCallback(sLevel, formatMessage);
        return formatMessage;
    }

    public static String I(String str, String str2) {
        if (sLevel > 30) {
            return "";
        }
        String formatMessage = formatMessage(str, str2);
        componentLogCallback(sLevel, formatMessage);
        return formatMessage;
    }

    public static String V(String str, String str2) {
        if (sLevel > 10) {
            return "";
        }
        String formatMessage = formatMessage(str, str2);
        componentLogCallback(sLevel, formatMessage);
        return formatMessage;
    }

    public static String W(String str, String str2) {
        if (sLevel > 40) {
            return "";
        }
        String formatMessage = formatMessage(str, str2);
        componentLogCallback(sLevel, formatMessage);
        return formatMessage;
    }

    private static void componentLogCallback(int i10, String str) {
        IComponentLogCallback iComponentLogCallback = mComponentLogCallback;
        if (iComponentLogCallback != null) {
            iComponentLogCallback.onCastLog(i10, str);
        }
    }

    public static String d(String str, String str2) {
        if (sLevel > 20) {
            return "";
        }
        String formatMessage = formatMessage(str, str2);
        componentLogCallback(sLevel, formatMessage);
        return formatMessage;
    }

    public static String e(String str, String str2) {
        if (sLevel > 50) {
            return "";
        }
        String formatMessage = formatMessage(str, str2);
        Log.e(LEBO_TAG, formatMessage);
        componentLogCallback(sLevel, formatMessage);
        return formatMessage;
    }

    public static void enableAllTrace() {
        sLevel = 0;
    }

    public static void enableTrace(boolean z10) {
        if (z10) {
            sLevel = 30;
        } else {
            sLevel = 100;
        }
    }

    private static String formatMessage(String str, String str2) {
        if (str == null) {
            str = "";
        }
        if (str2 == null) {
            str2 = "";
        }
        return "[" + Thread.currentThread().getName() + "]:" + (str + SOAP.DELIM + str2);
    }

    public static String getExceptionStr(Exception exc) {
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        exc.printStackTrace(printWriter);
        printWriter.flush();
        return stringWriter.toString();
    }

    public static String i(String str, String str2) {
        if (sLevel > 30) {
            return "";
        }
        String formatMessage = formatMessage(str, str2);
        componentLogCallback(sLevel, formatMessage);
        return formatMessage;
    }

    public static void setLogCallback(IComponentLogCallback iComponentLogCallback) {
        mComponentLogCallback = iComponentLogCallback;
    }

    public static String v(String str, String str2) {
        if (sLevel > 10) {
            return "";
        }
        String formatMessage = formatMessage(str, str2);
        componentLogCallback(sLevel, formatMessage);
        return formatMessage;
    }

    public static String w(String str, String str2) {
        if (sLevel > 40) {
            return "";
        }
        String formatMessage = formatMessage(str, str2);
        componentLogCallback(sLevel, formatMessage);
        return formatMessage;
    }

    public static String D(String str, String str2, Throwable th) {
        if (sLevel > 20) {
            return "";
        }
        String formatMessage = formatMessage(str, str2);
        componentLogCallback(sLevel, formatMessage);
        return formatMessage;
    }

    public static String I(String str, String str2, Throwable th) {
        if (sLevel > 30) {
            return "";
        }
        String formatMessage = formatMessage(str, str2);
        componentLogCallback(sLevel, formatMessage);
        return formatMessage;
    }

    public static String V(String str, String str2, Throwable th) {
        if (sLevel > 10) {
            return "";
        }
        String formatMessage = formatMessage(str, str2);
        componentLogCallback(sLevel, formatMessage);
        return formatMessage;
    }

    public static String W(String str, String str2, Throwable th) {
        if (sLevel > 40) {
            return "";
        }
        String formatMessage = formatMessage(str, str2);
        componentLogCallback(sLevel, formatMessage);
        return formatMessage;
    }

    public static String d(String str, String str2, Throwable th) {
        if (sLevel > 20) {
            return "";
        }
        String formatMessage = formatMessage(str, str2);
        componentLogCallback(sLevel, formatMessage);
        return formatMessage;
    }

    public static String i(String str, String str2, Throwable th) {
        if (sLevel > 30) {
            return "";
        }
        String formatMessage = formatMessage(str, str2);
        componentLogCallback(sLevel, formatMessage);
        return formatMessage;
    }

    public static String v(String str, String str2, Throwable th) {
        if (sLevel > 10) {
            return "";
        }
        String formatMessage = formatMessage(str, str2);
        componentLogCallback(sLevel, formatMessage);
        return formatMessage;
    }

    public static String w(String str, String str2, Throwable th) {
        if (sLevel > 40) {
            return "";
        }
        String formatMessage = formatMessage(str, str2);
        componentLogCallback(sLevel, formatMessage);
        return formatMessage;
    }

    public static String E(String str, String str2, Throwable th) {
        if (sLevel > 50) {
            return "";
        }
        String formatMessage = formatMessage(str, str2);
        Log.e(PERFERMANCE, formatMessage, th);
        return formatMessage;
    }

    public static String e(String str, String str2, Throwable th) {
        if (sLevel > 50) {
            return "";
        }
        String formatMessage = formatMessage(str, str2);
        Log.e(LEBO_TAG, formatMessage, th);
        componentLogCallback(sLevel, formatMessage);
        return formatMessage;
    }

    public static String W(String str, Throwable th) {
        if (sLevel > 40) {
            return "";
        }
        String formatMessage = formatMessage(str, null);
        componentLogCallback(sLevel, formatMessage);
        return formatMessage;
    }

    public static String w(String str, Throwable th) {
        if (sLevel > 40) {
            return "";
        }
        String formatMessage = formatMessage(str, null);
        componentLogCallback(sLevel, formatMessage);
        return formatMessage;
    }
}
