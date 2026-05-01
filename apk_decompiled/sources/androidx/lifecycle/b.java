package androidx.lifecycle;

import androidx.lifecycle.d;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public final class b {

    /* renamed from: c, reason: collision with root package name */
    public static b f2553c = new b();

    /* renamed from: a, reason: collision with root package name */
    public final Map f2554a = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    public final Map f2555b = new HashMap();

    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public final Map f2556a = new HashMap();

        /* renamed from: b, reason: collision with root package name */
        public final Map f2557b;

        public a(Map map) {
            this.f2557b = map;
            for (Map.Entry entry : map.entrySet()) {
                d.b bVar = (d.b) entry.getValue();
                List list = (List) this.f2556a.get(bVar);
                if (list == null) {
                    list = new ArrayList();
                    this.f2556a.put(bVar, list);
                }
                list.add(entry.getKey());
            }
        }

        public static void b(List list, g gVar, d.b bVar, Object obj) {
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    ((C0034b) list.get(size)).a(gVar, bVar, obj);
                }
            }
        }

        public void a(g gVar, d.b bVar, Object obj) {
            b((List) this.f2556a.get(bVar), gVar, bVar, obj);
            b((List) this.f2556a.get(d.b.ON_ANY), gVar, bVar, obj);
        }
    }

    /* renamed from: androidx.lifecycle.b$b, reason: collision with other inner class name */
    public static final class C0034b {

        /* renamed from: a, reason: collision with root package name */
        public final int f2558a;

        /* renamed from: b, reason: collision with root package name */
        public final Method f2559b;

        public C0034b(int i10, Method method) {
            this.f2558a = i10;
            this.f2559b = method;
            method.setAccessible(true);
        }

        public void a(g gVar, d.b bVar, Object obj) {
            try {
                int i10 = this.f2558a;
                if (i10 == 0) {
                    this.f2559b.invoke(obj, new Object[0]);
                } else if (i10 == 1) {
                    this.f2559b.invoke(obj, gVar);
                } else {
                    if (i10 != 2) {
                        return;
                    }
                    this.f2559b.invoke(obj, gVar, bVar);
                }
            } catch (IllegalAccessException e10) {
                throw new RuntimeException(e10);
            } catch (InvocationTargetException e11) {
                throw new RuntimeException("Failed to call observer method", e11.getCause());
            }
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof C0034b)) {
                return false;
            }
            C0034b c0034b = (C0034b) obj;
            return this.f2558a == c0034b.f2558a && this.f2559b.getName().equals(c0034b.f2559b.getName());
        }

        public int hashCode() {
            return (this.f2558a * 31) + this.f2559b.getName().hashCode();
        }
    }

    public final a a(Class cls, Method[] methodArr) {
        int i10;
        a c10;
        Class superclass = cls.getSuperclass();
        HashMap hashMap = new HashMap();
        if (superclass != null && (c10 = c(superclass)) != null) {
            hashMap.putAll(c10.f2557b);
        }
        for (Class<?> cls2 : cls.getInterfaces()) {
            for (Map.Entry entry : c(cls2).f2557b.entrySet()) {
                e(hashMap, (C0034b) entry.getKey(), (d.b) entry.getValue(), cls);
            }
        }
        if (methodArr == null) {
            methodArr = b(cls);
        }
        boolean z10 = false;
        for (Method method : methodArr) {
            n nVar = (n) method.getAnnotation(n.class);
            if (nVar != null) {
                Class<?>[] parameterTypes = method.getParameterTypes();
                if (parameterTypes.length <= 0) {
                    i10 = 0;
                } else {
                    if (!parameterTypes[0].isAssignableFrom(g.class)) {
                        throw new IllegalArgumentException("invalid parameter type. Must be one and instanceof LifecycleOwner");
                    }
                    i10 = 1;
                }
                d.b value = nVar.value();
                if (parameterTypes.length > 1) {
                    if (!parameterTypes[1].isAssignableFrom(d.b.class)) {
                        throw new IllegalArgumentException("invalid parameter type. second arg must be an event");
                    }
                    if (value != d.b.ON_ANY) {
                        throw new IllegalArgumentException("Second arg is supported only for ON_ANY value");
                    }
                    i10 = 2;
                }
                if (parameterTypes.length > 2) {
                    throw new IllegalArgumentException("cannot have more than 2 params");
                }
                e(hashMap, new C0034b(i10, method), value, cls);
                z10 = true;
            }
        }
        a aVar = new a(hashMap);
        this.f2554a.put(cls, aVar);
        this.f2555b.put(cls, Boolean.valueOf(z10));
        return aVar;
    }

    public final Method[] b(Class cls) {
        try {
            return cls.getDeclaredMethods();
        } catch (NoClassDefFoundError e10) {
            throw new IllegalArgumentException("The observer class has some methods that use newer APIs which are not available in the current OS version. Lifecycles cannot access even other methods so you should make sure that your observer classes only access framework classes that are available in your min API level OR use lifecycle:compiler annotation processor.", e10);
        }
    }

    public a c(Class cls) {
        a aVar = (a) this.f2554a.get(cls);
        return aVar != null ? aVar : a(cls, null);
    }

    public boolean d(Class cls) {
        Boolean bool = (Boolean) this.f2555b.get(cls);
        if (bool != null) {
            return bool.booleanValue();
        }
        Method[] b10 = b(cls);
        for (Method method : b10) {
            if (((n) method.getAnnotation(n.class)) != null) {
                a(cls, b10);
                return true;
            }
        }
        this.f2555b.put(cls, Boolean.FALSE);
        return false;
    }

    public final void e(Map map, C0034b c0034b, d.b bVar, Class cls) {
        d.b bVar2 = (d.b) map.get(c0034b);
        if (bVar2 == null || bVar == bVar2) {
            if (bVar2 == null) {
                map.put(c0034b, bVar);
                return;
            }
            return;
        }
        throw new IllegalArgumentException("Method " + c0034b.f2559b.getName() + " in " + cls.getName() + " already declared with different @OnLifecycleEvent value: previous value " + bVar2 + ", new value " + bVar);
    }
}
