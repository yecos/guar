package com.hpplay.common.log;

/* loaded from: classes2.dex */
interface ILog {
    String D(String str, String str2);

    String D(String str, String str2, Throwable th);

    String E(String str, String str2);

    String E(String str, String str2, Throwable th);

    String I(String str, String str2);

    String I(String str, String str2, Throwable th);

    String V(String str, String str2);

    String V(String str, String str2, Throwable th);

    String W(String str, String str2);

    String W(String str, String str2, Throwable th);

    String W(String str, Throwable th);

    String d(String str, String str2);

    String d(String str, String str2, Throwable th);

    String e(String str, String str2);

    String e(String str, String str2, Throwable th);

    String i(String str, String str2);

    String i(String str, String str2, Throwable th);

    String v(String str, String str2);

    String v(String str, String str2, Throwable th);

    String w(String str, String str2);

    String w(String str, String str2, Throwable th);

    String w(String str, Throwable th);
}
