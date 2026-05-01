package r3;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import r3.f0;
import r3.t;

/* loaded from: classes.dex */
public class k extends u {

    /* renamed from: d, reason: collision with root package name */
    public final t.a f18443d;

    /* renamed from: e, reason: collision with root package name */
    public final boolean f18444e;

    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public f0 f18445a;

        /* renamed from: b, reason: collision with root package name */
        public Method f18446b;

        /* renamed from: c, reason: collision with root package name */
        public o f18447c;

        public a(f0 f0Var, Method method, o oVar) {
            this.f18445a = f0Var;
            this.f18446b = method;
            this.f18447c = oVar;
        }

        public j a() {
            Method method = this.f18446b;
            if (method == null) {
                return null;
            }
            return new j(this.f18445a, method, this.f18447c.b(), null);
        }
    }

    public k(k3.b bVar, t.a aVar, boolean z10) {
        super(bVar);
        this.f18443d = bVar == null ? null : aVar;
        this.f18444e = z10;
    }

    public static boolean k(Method method) {
        return (Modifier.isStatic(method.getModifiers()) || method.isSynthetic() || method.isBridge() || method.getParameterTypes().length > 2) ? false : true;
    }

    public static l m(k3.b bVar, f0 f0Var, t.a aVar, c4.o oVar, k3.j jVar, List list, Class cls, boolean z10) {
        return new k(bVar, aVar, z10).l(oVar, f0Var, jVar, list, cls);
    }

    public final void i(f0 f0Var, Class cls, Map map, Class cls2) {
        if (cls2 != null) {
            j(f0Var, cls, map, cls2);
        }
        if (cls == null) {
            return;
        }
        for (Method method : d4.h.z(cls)) {
            if (k(method)) {
                y yVar = new y(method);
                a aVar = (a) map.get(yVar);
                if (aVar == null) {
                    map.put(yVar, new a(f0Var, method, this.f18486a == null ? o.e() : e(method.getDeclaredAnnotations())));
                } else {
                    if (this.f18444e) {
                        aVar.f18447c = f(aVar.f18447c, method.getDeclaredAnnotations());
                    }
                    Method method2 = aVar.f18446b;
                    if (method2 == null) {
                        aVar.f18446b = method;
                    } else if (Modifier.isAbstract(method2.getModifiers()) && !Modifier.isAbstract(method.getModifiers())) {
                        aVar.f18446b = method;
                        aVar.f18445a = f0Var;
                    }
                }
            }
        }
    }

    public void j(f0 f0Var, Class cls, Map map, Class cls2) {
        if (this.f18486a == null) {
            return;
        }
        Iterator it = d4.h.w(cls2, cls, true).iterator();
        while (it.hasNext()) {
            for (Method method : ((Class) it.next()).getDeclaredMethods()) {
                if (k(method)) {
                    y yVar = new y(method);
                    a aVar = (a) map.get(yVar);
                    Annotation[] declaredAnnotations = method.getDeclaredAnnotations();
                    if (aVar == null) {
                        map.put(yVar, new a(f0Var, null, e(declaredAnnotations)));
                    } else {
                        aVar.f18447c = f(aVar.f18447c, declaredAnnotations);
                    }
                }
            }
        }
    }

    public l l(c4.o oVar, f0 f0Var, k3.j jVar, List list, Class cls) {
        boolean z10;
        Class a10;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        i(f0Var, jVar.q(), linkedHashMap, cls);
        Iterator it = list.iterator();
        while (it.hasNext()) {
            k3.j jVar2 = (k3.j) it.next();
            t.a aVar = this.f18443d;
            i(new f0.a(oVar, jVar2.j()), jVar2.q(), linkedHashMap, aVar == null ? null : aVar.a(jVar2.q()));
        }
        t.a aVar2 = this.f18443d;
        if (aVar2 == null || (a10 = aVar2.a(Object.class)) == null) {
            z10 = false;
        } else {
            j(f0Var, jVar.q(), linkedHashMap, a10);
            z10 = true;
        }
        if (z10 && this.f18486a != null && !linkedHashMap.isEmpty()) {
            for (Map.Entry entry : linkedHashMap.entrySet()) {
                y yVar = (y) entry.getKey();
                if ("hashCode".equals(yVar.b()) && yVar.a() == 0) {
                    try {
                        Method declaredMethod = Object.class.getDeclaredMethod(yVar.b(), new Class[0]);
                        if (declaredMethod != null) {
                            a aVar3 = (a) entry.getValue();
                            aVar3.f18447c = f(aVar3.f18447c, declaredMethod.getDeclaredAnnotations());
                            aVar3.f18446b = declaredMethod;
                        }
                    } catch (Exception unused) {
                    }
                }
            }
        }
        if (linkedHashMap.isEmpty()) {
            return new l();
        }
        LinkedHashMap linkedHashMap2 = new LinkedHashMap(linkedHashMap.size());
        for (Map.Entry entry2 : linkedHashMap.entrySet()) {
            j a11 = ((a) entry2.getValue()).a();
            if (a11 != null) {
                linkedHashMap2.put(entry2.getKey(), a11);
            }
        }
        return new l(linkedHashMap2);
    }
}
