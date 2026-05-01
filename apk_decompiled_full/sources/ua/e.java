package ua;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Date;

/* loaded from: classes3.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    public String f19077a;

    /* renamed from: b, reason: collision with root package name */
    public String f19078b;

    /* renamed from: c, reason: collision with root package name */
    public String f19079c;

    /* renamed from: d, reason: collision with root package name */
    public Class f19080d;

    /* renamed from: e, reason: collision with root package name */
    public Field f19081e;

    /* renamed from: f, reason: collision with root package name */
    public Method f19082f;

    /* renamed from: g, reason: collision with root package name */
    public Method f19083g;

    public String a() {
        return this.f19078b;
    }

    public Class b() {
        return this.f19080d;
    }

    public String c() {
        return this.f19079c;
    }

    public Object d(Object obj) {
        Method method;
        if (obj == null || (method = this.f19082f) == null) {
            return null;
        }
        try {
            return method.invoke(obj, new Object[0]);
        } catch (Exception e10) {
            e10.printStackTrace();
            return null;
        }
    }

    public void e(String str) {
        this.f19078b = str;
    }

    public void f(Class cls) {
        this.f19080d = cls;
    }

    public void g(String str) {
        this.f19079c = str;
    }

    public void h(Field field) {
        this.f19081e = field;
    }

    public void i(String str) {
        this.f19077a = str;
    }

    public void j(Method method) {
        this.f19082f = method;
    }

    public void k(Method method) {
        this.f19083g = method;
    }

    public void l(Object obj, Object obj2) {
        Method method = this.f19083g;
        if (method == null || obj2 == null) {
            try {
                this.f19081e.setAccessible(true);
                this.f19081e.set(obj, obj2);
                return;
            } catch (Exception e10) {
                e10.printStackTrace();
                return;
            }
        }
        try {
            Class cls = this.f19080d;
            if (cls == String.class) {
                method.invoke(obj, obj2.toString());
            } else {
                if (cls != Integer.TYPE && cls != Integer.class) {
                    if (cls != Float.TYPE && cls != Float.class) {
                        if (cls != Double.TYPE && cls != Double.class) {
                            if (cls != Long.TYPE && cls != Long.class) {
                                if (cls != Date.class && cls != java.sql.Date.class) {
                                    if (cls != Boolean.TYPE && cls != Boolean.class) {
                                        method.invoke(obj, obj2);
                                    }
                                    method.invoke(obj, Boolean.valueOf("1".equals(obj2.toString())));
                                }
                                method.invoke(obj, wa.b.m(obj2.toString()));
                            }
                            method.invoke(obj, Long.valueOf(Long.parseLong(obj2.toString())));
                        }
                        method.invoke(obj, Double.valueOf(Double.parseDouble(obj2.toString())));
                    }
                    method.invoke(obj, Float.valueOf(Float.parseFloat(obj2.toString())));
                }
                method.invoke(obj, Integer.valueOf(Integer.parseInt(obj2.toString())));
            }
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }
}
