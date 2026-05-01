package com.umeng.message.proguard;

import android.text.TextUtils;
import java.lang.reflect.Method;

/* loaded from: classes3.dex */
public class ec {
    private static Method a(String str, String str2, Class<?>... clsArr) {
        Class<?> a10;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || (a10 = a(str)) == null) {
            return null;
        }
        try {
            return a10.getDeclaredMethod(str2, clsArr);
        } catch (Throwable th) {
            ce.c("Reflect", "getMethod failed, cls:", str, " method:", str2, " msg:", th.getMessage());
            return null;
        }
    }

    private static Object a(Method method, Object[] objArr) {
        if (method == null) {
            return null;
        }
        try {
            if (!method.isAccessible()) {
                method.setAccessible(true);
            }
            return method.invoke(null, objArr);
        } catch (Throwable th) {
            ce.c("Reflect", "invoke failed:", th.getMessage());
            return null;
        }
    }

    public static Object a(String str, String str2, Class<?>[] clsArr, Object[] objArr) {
        Method a10 = a(str, str2, clsArr);
        if (a10 != null) {
            return a(a10, objArr);
        }
        return null;
    }

    private static Class<?> a(String str) {
        ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
        if (contextClassLoader == null) {
            contextClassLoader = ec.class.getClassLoader();
        }
        try {
            try {
                return Class.forName(str, true, contextClassLoader);
            } catch (Throwable unused) {
                return Class.forName(str, true, ec.class.getClassLoader());
            }
        } catch (Throwable unused2) {
            return null;
        }
    }
}
