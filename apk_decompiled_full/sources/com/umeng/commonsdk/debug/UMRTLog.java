package com.umeng.commonsdk.debug;

import android.util.Log;
import com.hpplay.cybergarage.soap.SOAP;
import com.raizlabs.android.dbflow.sql.language.Operator;
import com.umeng.commonsdk.UMConfigure;

/* loaded from: classes3.dex */
public class UMRTLog {
    private static final String RTLOG_ENABLE = "1";
    private static final String RTLOG_PROP = "debug.umeng.rtlog";
    public static final String RTLOG_TAG = "MobclickRT";

    private UMRTLog() {
    }

    public static void d(String str, String str2) {
        if (UMConfigure.shouldOutput()) {
            warpperMsg(str2, false);
        }
    }

    public static void e(String str, String str2) {
        if (UMConfigure.shouldOutput()) {
            Log.e(str, warpperMsg(str2, false));
        }
    }

    public static void i(String str, String str2) {
        if (UMConfigure.shouldOutput()) {
            warpperMsg(str2, false);
        }
    }

    public static void sd(String str, String str2) {
        if (UMConfigure.shouldOutput()) {
            warpperMsg(str2, true);
        }
    }

    public static void se(String str, String str2) {
        if (UMConfigure.shouldOutput()) {
            Log.e(str, warpperMsg(str2, true));
        }
    }

    public static void si(String str, String str2) {
        if (UMConfigure.shouldOutput()) {
            warpperMsg(str2, true);
        }
    }

    public static void sv(String str, String str2) {
        if (UMConfigure.shouldOutput()) {
            warpperMsg(str2, true);
        }
    }

    public static void sw(String str, String str2) {
        if (UMConfigure.shouldOutput()) {
            warpperMsg(str2, true);
        }
    }

    public static void v(String str, String str2) {
        if (UMConfigure.shouldOutput()) {
            warpperMsg(str2, false);
        }
    }

    public static void w(String str, String str2) {
        if (UMConfigure.shouldOutput()) {
            warpperMsg(str2, false);
        }
    }

    private static String warpperMsg(String str, boolean z10) {
        StringBuffer stringBuffer;
        if (!z10) {
            return str;
        }
        try {
            StackTraceElement[] stackTrace = new Throwable().getStackTrace();
            if (stackTrace.length >= 3) {
                String fileName = stackTrace[2].getFileName();
                String methodName = stackTrace[2].getMethodName();
                int lineNumber = stackTrace[2].getLineNumber();
                stringBuffer = new StringBuffer();
                stringBuffer.append(Operator.Operation.LESS_THAN);
                stringBuffer.append(fileName);
                stringBuffer.append(SOAP.DELIM);
                stringBuffer.append(methodName);
                stringBuffer.append(SOAP.DELIM);
                stringBuffer.append(lineNumber);
                stringBuffer.append("> ");
                stringBuffer.append(str);
            } else {
                stringBuffer = null;
            }
            return stringBuffer.toString();
        } catch (Throwable unused) {
            return str;
        }
    }
}
