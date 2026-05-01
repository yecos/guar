package com.hpplay.component.modulelinker;

import android.app.Application;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import org.simpleframework.xml.strategy.Name;

/* loaded from: classes2.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    private static final String f7358a = "ModuleLoadUtils";

    /* renamed from: b, reason: collision with root package name */
    private static ClassLoader f7359b;

    /* renamed from: c, reason: collision with root package name */
    private static ClassLoader f7360c;

    public static void a(ClassLoader classLoader) {
        f7359b = classLoader;
    }

    public static void b(ClassLoader classLoader) {
        f7360c = classLoader;
    }

    public static Application c() {
        try {
            Class<?> cls = Class.forName("android.app.ActivityThread");
            return (Application) cls.getMethod("getApplication", new Class[0]).invoke(cls.getMethod("currentActivityThread", new Class[0]).invoke(null, null), null);
        } catch (Exception unused) {
            return null;
        }
    }

    public static ClassLoader a() {
        return f7359b;
    }

    public static ClassLoader b() {
        return f7360c;
    }

    public static Object a(String str, String str2, Object... objArr) {
        Class a10 = a(str);
        if (a10 == null) {
            return null;
        }
        for (Method method : a10.getDeclaredMethods()) {
            if (method.getName().equals(str2) && method.getParameterTypes().length == objArr.length) {
                method.setAccessible(true);
                return method.invoke(a10, objArr);
            }
        }
        return null;
    }

    public static Object a(Object obj, String str, Object... objArr) {
        for (Method method : obj.getClass().getDeclaredMethods()) {
            if (method.getName().equals(str) && method.getParameterTypes().length == objArr.length) {
                method.setAccessible(true);
                return method.invoke(obj, objArr);
            }
        }
        return null;
    }

    public static Object a(Object obj, String str) {
        Class<?> cls = obj.getClass();
        Field[] declaredFields = cls.getDeclaredFields();
        if (declaredFields == null || declaredFields.length == 0) {
            declaredFields = cls.getFields();
        }
        for (Field field : declaredFields) {
            if (field.getName().equals(str)) {
                field.setAccessible(true);
                return field.get(obj);
            }
        }
        return null;
    }

    public static Object a(Object obj, Class<?> cls, String str) {
        Field declaredField = cls.getDeclaredField(str);
        declaredField.setAccessible(true);
        return declaredField.get(obj);
    }

    public static Object a(String str, String str2) {
        Field declaredField = Class.forName(str).getDeclaredField(str2);
        declaredField.setAccessible(true);
        return declaredField.get(null);
    }

    public static void a(Object obj, String str, Object obj2) {
        Field declaredField = obj.getClass().getDeclaredField(str);
        declaredField.setAccessible(true);
        declaredField.set(obj, obj2);
    }

    public static void a(String str, String str2, Object obj) {
        Class a10 = a(str);
        Field declaredField = a10.getDeclaredField(str2);
        declaredField.setAccessible(true);
        declaredField.set(a10, obj);
    }

    public static Object a(String str, Class<?>[] clsArr, Object[] objArr) {
        try {
            Class a10 = a(str);
            if (a10 == null) {
                StringBuilder sb = new StringBuilder();
                sb.append(str.substring(str.lastIndexOf("."), str.length()));
                sb.append(" not find ...");
                return null;
            }
            return a10.getConstructor(clsArr).newInstance(objArr);
        } catch (Exception unused) {
            return null;
        }
    }

    public static Object a(String str, String str2, Class<?>[] clsArr, Object[] objArr) {
        try {
            Class a10 = a(str);
            return a10.getDeclaredMethod(str2, clsArr).invoke(a10, objArr);
        } catch (Exception unused) {
            return null;
        }
    }

    private static Class a(String str) {
        try {
            return Class.forName(str);
        } catch (Exception unused) {
            if (f7360c != null) {
                try {
                    return f7360c.loadClass(str);
                } catch (Exception unused2) {
                    return null;
                }
            }
            return null;
        }
    }

    public static void a(Object obj) {
        if (obj != null) {
            for (Field field : obj.getClass().getDeclaredFields()) {
                if (field.getType().toString().startsWith(Name.LABEL)) {
                    field.setAccessible(true);
                    field.set(obj, null);
                }
            }
        }
    }
}
