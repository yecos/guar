package m9;

import java.lang.reflect.Method;

/* loaded from: classes3.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name */
    public static final h f16841a = new h();

    /* renamed from: b, reason: collision with root package name */
    public static final a f16842b = new a(null, null, null);

    /* renamed from: c, reason: collision with root package name */
    public static a f16843c;

    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final Method f16844a;

        /* renamed from: b, reason: collision with root package name */
        public final Method f16845b;

        /* renamed from: c, reason: collision with root package name */
        public final Method f16846c;

        public a(Method method, Method method2, Method method3) {
            this.f16844a = method;
            this.f16845b = method2;
            this.f16846c = method3;
        }
    }

    public final a a(m9.a aVar) {
        try {
            a aVar2 = new a(Class.class.getDeclaredMethod("getModule", new Class[0]), aVar.getClass().getClassLoader().loadClass("java.lang.Module").getDeclaredMethod("getDescriptor", new Class[0]), aVar.getClass().getClassLoader().loadClass("java.lang.module.ModuleDescriptor").getDeclaredMethod("name", new Class[0]));
            f16843c = aVar2;
            return aVar2;
        } catch (Exception unused) {
            a aVar3 = f16842b;
            f16843c = aVar3;
            return aVar3;
        }
    }

    public final String b(m9.a aVar) {
        t9.i.g(aVar, "continuation");
        a aVar2 = f16843c;
        if (aVar2 == null) {
            aVar2 = a(aVar);
        }
        if (aVar2 == f16842b) {
            return null;
        }
        Method method = aVar2.f16844a;
        Object invoke = method != null ? method.invoke(aVar.getClass(), new Object[0]) : null;
        if (invoke == null) {
            return null;
        }
        Method method2 = aVar2.f16845b;
        Object invoke2 = method2 != null ? method2.invoke(invoke, new Object[0]) : null;
        if (invoke2 == null) {
            return null;
        }
        Method method3 = aVar2.f16846c;
        Object invoke3 = method3 != null ? method3.invoke(invoke2, new Object[0]) : null;
        if (invoke3 instanceof String) {
            return (String) invoke3;
        }
        return null;
    }
}
