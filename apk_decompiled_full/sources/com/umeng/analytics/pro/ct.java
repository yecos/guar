package com.umeng.analytics.pro;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes3.dex */
public class ct implements Serializable {

    /* renamed from: d, reason: collision with root package name */
    private static Map<Class<? extends ch>, Map<? extends co, ct>> f10195d = new HashMap();

    /* renamed from: a, reason: collision with root package name */
    public final String f10196a;

    /* renamed from: b, reason: collision with root package name */
    public final byte f10197b;

    /* renamed from: c, reason: collision with root package name */
    public final cu f10198c;

    public ct(String str, byte b10, cu cuVar) {
        this.f10196a = str;
        this.f10197b = b10;
        this.f10198c = cuVar;
    }

    public static void a(Class<? extends ch> cls, Map<? extends co, ct> map) {
        f10195d.put(cls, map);
    }

    public static Map<? extends co, ct> a(Class<? extends ch> cls) {
        if (!f10195d.containsKey(cls)) {
            try {
                cls.newInstance();
            } catch (IllegalAccessException e10) {
                throw new RuntimeException("IllegalAccessException for TBase class: " + cls.getName() + ", message: " + e10.getMessage());
            } catch (InstantiationException e11) {
                throw new RuntimeException("InstantiationException for TBase class: " + cls.getName() + ", message: " + e11.getMessage());
            }
        }
        return f10195d.get(cls);
    }
}
