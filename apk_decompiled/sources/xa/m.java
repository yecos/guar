package xa;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes.dex */
public class m {

    /* renamed from: d, reason: collision with root package name */
    public static final Map f19647d = new ConcurrentHashMap();

    /* renamed from: e, reason: collision with root package name */
    public static final a[] f19648e = new a[4];

    /* renamed from: a, reason: collision with root package name */
    public List f19649a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f19650b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f19651c;

    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public final List f19652a = new ArrayList();

        /* renamed from: b, reason: collision with root package name */
        public final Map f19653b = new HashMap();

        /* renamed from: c, reason: collision with root package name */
        public final Map f19654c = new HashMap();

        /* renamed from: d, reason: collision with root package name */
        public final StringBuilder f19655d = new StringBuilder(128);

        /* renamed from: e, reason: collision with root package name */
        public Class f19656e;

        /* renamed from: f, reason: collision with root package name */
        public Class f19657f;

        /* renamed from: g, reason: collision with root package name */
        public boolean f19658g;

        public boolean a(Method method, Class cls) {
            Object put = this.f19653b.put(cls, method);
            if (put == null) {
                return true;
            }
            if (put instanceof Method) {
                if (!b((Method) put, cls)) {
                    throw new IllegalStateException();
                }
                this.f19653b.put(cls, this);
            }
            return b(method, cls);
        }

        public final boolean b(Method method, Class cls) {
            this.f19655d.setLength(0);
            this.f19655d.append(method.getName());
            StringBuilder sb = this.f19655d;
            sb.append(ASCIIPropertyListParser.DATA_END_TOKEN);
            sb.append(cls.getName());
            String sb2 = this.f19655d.toString();
            Class<?> declaringClass = method.getDeclaringClass();
            Class cls2 = (Class) this.f19654c.put(sb2, declaringClass);
            if (cls2 == null || cls2.isAssignableFrom(declaringClass)) {
                return true;
            }
            this.f19654c.put(sb2, cls2);
            return false;
        }

        public void c(Class cls) {
            this.f19657f = cls;
            this.f19656e = cls;
            this.f19658g = false;
        }

        public void d() {
            if (this.f19658g) {
                this.f19657f = null;
                return;
            }
            Class superclass = this.f19657f.getSuperclass();
            this.f19657f = superclass;
            String name = superclass.getName();
            if (name.startsWith("java.") || name.startsWith("javax.") || name.startsWith("android.")) {
                this.f19657f = null;
            }
        }

        public void e() {
            this.f19652a.clear();
            this.f19653b.clear();
            this.f19654c.clear();
            this.f19655d.setLength(0);
            this.f19656e = null;
            this.f19657f = null;
            this.f19658g = false;
        }
    }

    public m(List list, boolean z10, boolean z11) {
        this.f19649a = list;
        this.f19650b = z10;
        this.f19651c = z11;
    }

    public List a(Class cls) {
        Map map = f19647d;
        List list = (List) map.get(cls);
        if (list != null) {
            return list;
        }
        List c10 = this.f19651c ? c(cls) : b(cls);
        if (!c10.isEmpty()) {
            map.put(cls, c10);
            return c10;
        }
        throw new e("Subscriber " + cls + " and its super classes have no public methods with the @Subscribe annotation");
    }

    public final List b(Class cls) {
        a g10 = g();
        g10.c(cls);
        while (g10.f19657f != null) {
            f(g10);
            d(g10);
            g10.d();
        }
        return e(g10);
    }

    public final List c(Class cls) {
        a g10 = g();
        g10.c(cls);
        while (g10.f19657f != null) {
            d(g10);
            g10.d();
        }
        return e(g10);
    }

    public final void d(a aVar) {
        Method[] methods;
        try {
            methods = aVar.f19657f.getDeclaredMethods();
        } catch (Throwable unused) {
            methods = aVar.f19657f.getMethods();
            aVar.f19658g = true;
        }
        for (Method method : methods) {
            int modifiers = method.getModifiers();
            if ((modifiers & 1) != 0 && (modifiers & 5192) == 0) {
                Class<?>[] parameterTypes = method.getParameterTypes();
                if (parameterTypes.length == 1) {
                    j jVar = (j) method.getAnnotation(j.class);
                    if (jVar != null) {
                        Class<?> cls = parameterTypes[0];
                        if (aVar.a(method, cls)) {
                            aVar.f19652a.add(new l(method, cls, jVar.threadMode(), jVar.priority(), jVar.sticky()));
                        }
                    }
                } else if (this.f19650b && method.isAnnotationPresent(j.class)) {
                    throw new e("@Subscribe method " + (method.getDeclaringClass().getName() + "." + method.getName()) + "must have exactly 1 parameter but has " + parameterTypes.length);
                }
            } else if (this.f19650b && method.isAnnotationPresent(j.class)) {
                throw new e((method.getDeclaringClass().getName() + "." + method.getName()) + " is a illegal @Subscribe method: must be public, non-static, and non-abstract");
            }
        }
    }

    public final List e(a aVar) {
        ArrayList arrayList = new ArrayList(aVar.f19652a);
        aVar.e();
        synchronized (f19648e) {
            int i10 = 0;
            while (true) {
                if (i10 >= 4) {
                    break;
                }
                a[] aVarArr = f19648e;
                if (aVarArr[i10] == null) {
                    aVarArr[i10] = aVar;
                    break;
                }
                i10++;
            }
        }
        return arrayList;
    }

    public final ya.a f(a aVar) {
        aVar.getClass();
        List list = this.f19649a;
        if (list != null) {
            Iterator it = list.iterator();
            if (it.hasNext()) {
                androidx.appcompat.app.m.a(it.next());
                throw null;
            }
        }
        return null;
    }

    public final a g() {
        synchronized (f19648e) {
            for (int i10 = 0; i10 < 4; i10++) {
                a[] aVarArr = f19648e;
                a aVar = aVarArr[i10];
                if (aVar != null) {
                    aVarArr[i10] = null;
                    return aVar;
                }
            }
            return new a();
        }
    }
}
