package com.umeng.analytics.pro;

import android.util.Log;
import com.raizlabs.android.dbflow.sql.language.Operator;

/* loaded from: classes3.dex */
public class bs {

    /* renamed from: a, reason: collision with root package name */
    private static final String f10034a = "OpenId";

    /* renamed from: b, reason: collision with root package name */
    private static boolean f10035b = false;

    public static void a(boolean z10) {
        StringBuilder sb = new StringBuilder();
        sb.append("setDebug:");
        sb.append(z10);
        f10035b = z10;
    }

    public static void b(String str, Object... objArr) {
        if (f10035b) {
            e(str, objArr);
        }
    }

    public static void c(String str, Object... objArr) {
        if (f10035b) {
            e(str, objArr);
        }
    }

    public static void d(String str, Object... objArr) {
        if (f10035b) {
            Log.e(f10034a, e(str, objArr));
        }
    }

    private static String e(String str, Object... objArr) {
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

    public static void a(String str, Object... objArr) {
        if (f10035b) {
            e(str, objArr);
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
}
