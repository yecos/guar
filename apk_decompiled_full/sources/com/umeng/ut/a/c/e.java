package com.umeng.ut.a.c;

import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import com.raizlabs.android.dbflow.sql.language.Operator;

/* loaded from: classes3.dex */
public class e {

    /* renamed from: b, reason: collision with root package name */
    private static boolean f12364b = false;

    /* renamed from: c, reason: collision with root package name */
    private static boolean f12365c = false;

    /* renamed from: a, reason: collision with other method in class */
    public static boolean m73a() {
        return f12364b;
    }

    public static void b(String str, Object... objArr) {
        if (f12365c) {
            d();
            a(str, objArr);
        }
    }

    public static void c() {
        if (f12364b) {
            d();
            a((String) null, new Object[0]);
        }
    }

    private static String d() {
        String str;
        String str2;
        StackTraceElement a10 = a();
        if (a10 != null) {
            String className = a10.getClassName();
            str2 = !TextUtils.isEmpty(className) ? className.substring(className.lastIndexOf(46) + 1) : "";
            str = a10.getMethodName();
        } else {
            str = "";
            str2 = str;
        }
        return "Utdid." + str2 + "." + str + "." + String.valueOf(Process.myPid()) + "." + (Thread.currentThread().getId() + "");
    }

    /* renamed from: a, reason: collision with other method in class */
    public static void m72a(String str, Object... objArr) {
        if (f12364b) {
            d();
            a(str, objArr);
        }
    }

    public static void b(String str, Throwable th, Object... objArr) {
        if (f12365c) {
            Log.e(d(), a(str, objArr), th);
        }
    }

    public static void a(String str, Throwable th, Object... objArr) {
        if (f12364b) {
            Log.e(d(), a(str, objArr), th);
        }
    }

    private static String a(Object obj, Object obj2) {
        Object[] objArr = new Object[2];
        if (obj == null) {
            obj = "";
        }
        objArr[0] = obj;
        if (obj2 == null) {
            obj2 = "";
        }
        objArr[1] = obj2;
        return String.format("%s:%s", objArr);
    }

    private static String a(String str, Object... objArr) {
        if (str == null && objArr == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        Object[] objArr2 = new Object[1];
        if (str == null) {
            str = Operator.Operation.MINUS;
        }
        int i10 = 0;
        objArr2[0] = str;
        sb.append(String.format("[%s] ", objArr2));
        if (objArr != null) {
            int length = objArr.length;
            while (true) {
                int i11 = i10 + 1;
                if (i11 >= objArr.length) {
                    break;
                }
                sb.append(a(objArr[i10], objArr[i11]));
                if (i11 < length - 1) {
                    sb.append(",");
                }
                i10 = i11 + 1;
            }
            if (i10 == objArr.length - 1) {
                sb.append(objArr[i10]);
            }
        }
        return sb.toString();
    }

    private static StackTraceElement a() {
        try {
            for (StackTraceElement stackTraceElement : Thread.currentThread().getStackTrace()) {
                if (!stackTraceElement.isNativeMethod() && !stackTraceElement.getClassName().equals(Thread.class.getName()) && !stackTraceElement.getClassName().equals(e.class.getName())) {
                    return stackTraceElement;
                }
            }
        } catch (Throwable unused) {
        }
        return null;
    }
}
