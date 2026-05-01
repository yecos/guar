package com.hpplay.common.log;

import android.util.Log;
import com.hpplay.cybergarage.soap.SOAP;

/* loaded from: classes2.dex */
class Logger implements ILog {
    private static final String LEBO_TAG = "hpplay-java";
    private static final String PERFERMANCE = "hpplay-java:perfermance";

    public static String formatMessage(String str, String str2) {
        if (str == null) {
            str = "";
        }
        if (str2 == null) {
            str2 = "";
        }
        return "[" + Thread.currentThread().getName() + "]:" + (str + SOAP.DELIM + str2);
    }

    @Override // com.hpplay.common.log.ILog
    public String D(String str, String str2) {
        return formatMessage(str, str2);
    }

    @Override // com.hpplay.common.log.ILog
    public String E(String str, String str2) {
        String formatMessage = formatMessage(str, str2);
        Log.e(PERFERMANCE, formatMessage);
        return formatMessage;
    }

    @Override // com.hpplay.common.log.ILog
    public String I(String str, String str2) {
        return formatMessage(str, str2);
    }

    @Override // com.hpplay.common.log.ILog
    public String V(String str, String str2) {
        return formatMessage(str, str2);
    }

    @Override // com.hpplay.common.log.ILog
    public String W(String str, String str2) {
        return formatMessage(str, str2);
    }

    @Override // com.hpplay.common.log.ILog
    public String d(String str, String str2) {
        return formatMessage(str, str2);
    }

    @Override // com.hpplay.common.log.ILog
    public String e(String str, String str2) {
        String formatMessage = formatMessage(str, str2);
        Log.e(LEBO_TAG, formatMessage);
        return formatMessage;
    }

    @Override // com.hpplay.common.log.ILog
    public String i(String str, String str2) {
        return formatMessage(str, str2);
    }

    @Override // com.hpplay.common.log.ILog
    public String v(String str, String str2) {
        return formatMessage(str, str2);
    }

    @Override // com.hpplay.common.log.ILog
    public String w(String str, String str2) {
        return formatMessage(str, str2);
    }

    @Override // com.hpplay.common.log.ILog
    public String D(String str, String str2, Throwable th) {
        return formatMessage(str, str2 + '\n' + Log.getStackTraceString(th));
    }

    @Override // com.hpplay.common.log.ILog
    public String I(String str, String str2, Throwable th) {
        return formatMessage(str, str2 + '\n' + Log.getStackTraceString(th));
    }

    @Override // com.hpplay.common.log.ILog
    public String V(String str, String str2, Throwable th) {
        return formatMessage(str, str2 + '\n' + Log.getStackTraceString(th));
    }

    @Override // com.hpplay.common.log.ILog
    public String W(String str, String str2, Throwable th) {
        return formatMessage(str, str2 + '\n' + Log.getStackTraceString(th));
    }

    @Override // com.hpplay.common.log.ILog
    public String d(String str, String str2, Throwable th) {
        return formatMessage(str, str2 + '\n' + Log.getStackTraceString(th));
    }

    @Override // com.hpplay.common.log.ILog
    public String i(String str, String str2, Throwable th) {
        return formatMessage(str, str2 + '\n' + Log.getStackTraceString(th));
    }

    @Override // com.hpplay.common.log.ILog
    public String v(String str, String str2, Throwable th) {
        return formatMessage(str, str2 + '\n' + Log.getStackTraceString(th));
    }

    @Override // com.hpplay.common.log.ILog
    public String w(String str, String str2, Throwable th) {
        return formatMessage(str, str2 + '\n' + Log.getStackTraceString(th));
    }

    @Override // com.hpplay.common.log.ILog
    public String E(String str, String str2, Throwable th) {
        String formatMessage = formatMessage(str, str2 + '\n' + Log.getStackTraceString(th));
        Log.e(PERFERMANCE, formatMessage, th);
        return formatMessage;
    }

    @Override // com.hpplay.common.log.ILog
    public String e(String str, String str2, Throwable th) {
        String formatMessage = formatMessage(str, str2 + '\n' + Log.getStackTraceString(th));
        Log.e(LEBO_TAG, formatMessage, th);
        return formatMessage;
    }

    @Override // com.hpplay.common.log.ILog
    public String W(String str, Throwable th) {
        return formatMessage(str, Log.getStackTraceString(th));
    }

    @Override // com.hpplay.common.log.ILog
    public String w(String str, Throwable th) {
        return formatMessage(str, Log.getStackTraceString(th));
    }
}
