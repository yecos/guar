package com.umeng.analytics.pro;

import java.lang.reflect.InvocationTargetException;

/* loaded from: classes3.dex */
public class cm {
    public static cl a(Class<? extends cl> cls, int i10) {
        try {
            return (cl) cls.getMethod("findByValue", Integer.TYPE).invoke(null, Integer.valueOf(i10));
        } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
            return null;
        }
    }
}
