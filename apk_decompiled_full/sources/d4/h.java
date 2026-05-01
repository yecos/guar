package d4;

import c3.h;
import java.io.Closeable;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public abstract class h {

    /* renamed from: a, reason: collision with root package name */
    public static final Class f12530a = Object.class;

    /* renamed from: b, reason: collision with root package name */
    public static final Annotation[] f12531b = new Annotation[0];

    /* renamed from: c, reason: collision with root package name */
    public static final a[] f12532c = new a[0];

    /* renamed from: d, reason: collision with root package name */
    public static final Iterator f12533d = Collections.emptyIterator();

    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final Constructor f12534a;

        /* renamed from: b, reason: collision with root package name */
        public transient Annotation[] f12535b;

        /* renamed from: c, reason: collision with root package name */
        public transient Annotation[][] f12536c;

        /* renamed from: d, reason: collision with root package name */
        public int f12537d = -1;

        public a(Constructor constructor) {
            this.f12534a = constructor;
        }

        public Constructor a() {
            return this.f12534a;
        }

        public Annotation[] b() {
            Annotation[] annotationArr = this.f12535b;
            if (annotationArr != null) {
                return annotationArr;
            }
            Annotation[] declaredAnnotations = this.f12534a.getDeclaredAnnotations();
            this.f12535b = declaredAnnotations;
            return declaredAnnotations;
        }

        public Class c() {
            return this.f12534a.getDeclaringClass();
        }

        public int d() {
            int i10 = this.f12537d;
            if (i10 >= 0) {
                return i10;
            }
            int length = this.f12534a.getParameterTypes().length;
            this.f12537d = length;
            return length;
        }

        public Annotation[][] e() {
            Annotation[][] annotationArr = this.f12536c;
            if (annotationArr != null) {
                return annotationArr;
            }
            Annotation[][] parameterAnnotations = this.f12534a.getParameterAnnotations();
            this.f12536c = parameterAnnotations;
            return parameterAnnotations;
        }
    }

    public static class b {

        /* renamed from: c, reason: collision with root package name */
        public static final b f12538c = new b();

        /* renamed from: a, reason: collision with root package name */
        public final Field f12539a = d(EnumSet.class, "elementType", Class.class);

        /* renamed from: b, reason: collision with root package name */
        public final Field f12540b = d(EnumMap.class, "elementType", Class.class);

        public static Field d(Class cls, String str, Class cls2) {
            Field field;
            Field[] declaredFields = cls.getDeclaredFields();
            int length = declaredFields.length;
            int i10 = 0;
            while (true) {
                if (i10 >= length) {
                    field = null;
                    break;
                }
                field = declaredFields[i10];
                if (str.equals(field.getName()) && field.getType() == cls2) {
                    break;
                }
                i10++;
            }
            if (field == null) {
                for (Field field2 : declaredFields) {
                    if (field2.getType() == cls2) {
                        if (field != null) {
                            return null;
                        }
                        field = field2;
                    }
                }
            }
            if (field != null) {
                try {
                    field.setAccessible(true);
                } catch (Throwable unused) {
                }
            }
            return field;
        }

        public Class a(EnumMap enumMap) {
            Field field = this.f12540b;
            if (field != null) {
                return (Class) c(enumMap, field);
            }
            throw new IllegalStateException("Cannot figure out type for EnumMap (odd JDK platform?)");
        }

        public Class b(EnumSet enumSet) {
            Field field = this.f12539a;
            if (field != null) {
                return (Class) c(enumSet, field);
            }
            throw new IllegalStateException("Cannot figure out type for EnumSet (odd JDK platform?)");
        }

        public final Object c(Object obj, Field field) {
            try {
                return field.get(obj);
            } catch (Exception e10) {
                throw new IllegalArgumentException(e10);
            }
        }
    }

    public static a[] A(Class cls) {
        if (cls.isInterface() || R(cls)) {
            return f12532c;
        }
        Constructor<?>[] declaredConstructors = cls.getDeclaredConstructors();
        int length = declaredConstructors.length;
        a[] aVarArr = new a[length];
        for (int i10 = 0; i10 < length; i10++) {
            aVarArr[i10] = new a(declaredConstructors[i10]);
        }
        return aVarArr;
    }

    public static Class B(Class cls) {
        if (R(cls)) {
            return null;
        }
        return cls.getEnclosingClass();
    }

    public static Type[] C(Class cls) {
        return cls.getGenericInterfaces();
    }

    public static Type D(Class cls) {
        return cls.getGenericSuperclass();
    }

    public static Class E(Class cls) {
        if (!Modifier.isStatic(cls.getModifiers())) {
            try {
                if (I(cls)) {
                    return null;
                }
                return B(cls);
            } catch (SecurityException unused) {
            }
        }
        return null;
    }

    public static Throwable F(Throwable th) {
        while (th.getCause() != null) {
            th = th.getCause();
        }
        return th;
    }

    public static String G(k3.j jVar) {
        if (jVar == null) {
            return "[null]";
        }
        StringBuilder sb = new StringBuilder(80);
        sb.append('`');
        sb.append(jVar.c());
        sb.append('`');
        return sb.toString();
    }

    public static boolean H(Object obj, Class cls) {
        return obj != null && obj.getClass() == cls;
    }

    public static boolean I(Class cls) {
        return (R(cls) || cls.getEnclosingMethod() == null) ? false : true;
    }

    public static boolean J(Class cls) {
        return cls == Void.class || cls == Void.TYPE || cls == l3.j.class;
    }

    public static boolean K(Class cls) {
        return (cls.getModifiers() & 1536) == 0;
    }

    public static boolean L(Class cls) {
        return Enum.class.isAssignableFrom(cls);
    }

    public static boolean M(Class cls) {
        String name = cls.getName();
        return name.startsWith("java.") || name.startsWith("javax.");
    }

    public static boolean N(Class cls) {
        return cls.getAnnotation(l3.a.class) != null;
    }

    public static boolean O(Object obj) {
        return obj == null || N(obj.getClass());
    }

    public static String P(Class cls, boolean z10) {
        try {
            boolean isStatic = Modifier.isStatic(cls.getModifiers());
            if (!isStatic && I(cls)) {
                return "local/anonymous";
            }
            if (z10 || isStatic) {
                return null;
            }
            if (B(cls) != null) {
                return "non-static member class";
            }
            return null;
        } catch (NullPointerException | SecurityException unused) {
            return null;
        }
    }

    public static boolean Q(Class cls) {
        return (Modifier.isStatic(cls.getModifiers()) || B(cls) == null) ? false : true;
    }

    public static boolean R(Class cls) {
        return cls == f12530a || cls.isPrimitive();
    }

    public static boolean S(Class cls) {
        String name = cls.getName();
        return name.startsWith("net.sf.cglib.proxy.") || name.startsWith("org.hibernate.proxy.");
    }

    public static boolean T(Class cls) {
        Class superclass = cls.getSuperclass();
        return superclass != null && "java.lang.Record".equals(superclass.getName());
    }

    public static String U(String str) {
        return str == null ? "[null]" : d(str);
    }

    public static String V(k3.x xVar) {
        return xVar == null ? "[null]" : d(xVar.c());
    }

    public static String W(r rVar) {
        return rVar == null ? "[null]" : d(rVar.getName());
    }

    public static String X(Class cls) {
        if (cls == null) {
            return "[null]";
        }
        int i10 = 0;
        while (cls.isArray()) {
            i10++;
            cls = cls.getComponentType();
        }
        String simpleName = cls.isPrimitive() ? cls.getSimpleName() : cls.getName();
        if (i10 > 0) {
            StringBuilder sb = new StringBuilder(simpleName);
            do {
                sb.append("[]");
                i10--;
            } while (i10 > 0);
            simpleName = sb.toString();
        }
        return e(simpleName);
    }

    public static Object Y(Object obj, Object obj2) {
        return obj == null ? obj2 : obj;
    }

    public static String Z(String str) {
        return str == null ? "" : str;
    }

    public static void a(Class cls, Class cls2, Collection collection, boolean z10) {
        if (cls == cls2 || cls == null || cls == Object.class) {
            return;
        }
        if (z10) {
            if (collection.contains(cls)) {
                return;
            } else {
                collection.add(cls);
            }
        }
        for (Class cls3 : c(cls)) {
            a(cls3, cls2, collection, true);
        }
        a(cls.getSuperclass(), cls2, collection, true);
    }

    public static String a0(Object obj) {
        if (obj == null) {
            return null;
        }
        return obj.toString();
    }

    public static Method[] b(Class cls, Throwable th) {
        throw new IllegalArgumentException(String.format("Failed on call to `getDeclaredMethods()` on class `%s`, problem: (%s) %s", cls.getName(), th.getClass().getName(), th.getMessage()), th);
    }

    public static Class b0(Class cls) {
        if (cls.isPrimitive()) {
            return cls;
        }
        if (cls == Integer.class) {
            return Integer.TYPE;
        }
        if (cls == Long.class) {
            return Long.TYPE;
        }
        if (cls == Boolean.class) {
            return Boolean.TYPE;
        }
        if (cls == Double.class) {
            return Double.TYPE;
        }
        if (cls == Float.class) {
            return Float.TYPE;
        }
        if (cls == Byte.class) {
            return Byte.TYPE;
        }
        if (cls == Short.class) {
            return Short.TYPE;
        }
        if (cls == Character.class) {
            return Character.TYPE;
        }
        return null;
    }

    public static Class[] c(Class cls) {
        return cls.getInterfaces();
    }

    public static String c0(Object obj, String str) {
        return obj == null ? str : String.format("\"%s\"", obj);
    }

    public static String d(String str) {
        if (str == null) {
            return "[null]";
        }
        StringBuilder sb = new StringBuilder(str.length() + 2);
        sb.append('\'');
        sb.append(str);
        sb.append('\'');
        return sb.toString();
    }

    public static Class d0(k3.j jVar) {
        if (jVar == null) {
            return null;
        }
        return jVar.q();
    }

    public static String e(String str) {
        if (str == null) {
            return "[null]";
        }
        StringBuilder sb = new StringBuilder(str.length() + 2);
        sb.append('`');
        sb.append(str);
        sb.append('`');
        return sb.toString();
    }

    public static void e0(Throwable th) {
        f0(th, th.getMessage());
    }

    public static String f(Class cls) {
        if (cls.isAnnotation()) {
            return "annotation";
        }
        if (cls.isArray()) {
            return "array";
        }
        if (Enum.class.isAssignableFrom(cls)) {
            return "enum";
        }
        if (cls.isPrimitive()) {
            return "primitive";
        }
        return null;
    }

    public static void f0(Throwable th, String str) {
        j0(th);
        h0(th);
        throw new IllegalArgumentException(str, th);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void g(Member member, boolean z10) {
        AccessibleObject accessibleObject = (AccessibleObject) member;
        if (!z10) {
            try {
                if (Modifier.isPublic(member.getModifiers()) && Modifier.isPublic(member.getDeclaringClass().getModifiers())) {
                    return;
                }
            } catch (SecurityException e10) {
                if (accessibleObject.isAccessible()) {
                    return;
                }
                throw new IllegalArgumentException("Cannot access " + member + " (from class " + member.getDeclaringClass().getName() + "; failed to set access: " + e10.getMessage());
            }
        }
        accessibleObject.setAccessible(true);
    }

    public static Object g0(k3.g gVar, IOException iOException) {
        if (iOException instanceof k3.l) {
            throw ((k3.l) iOException);
        }
        k3.l j10 = k3.l.j(gVar, iOException.getMessage());
        j10.initCause(iOException);
        throw j10;
    }

    public static String h(Object obj) {
        if (obj == null) {
            return "[null]";
        }
        return X(obj instanceof Class ? (Class) obj : obj.getClass());
    }

    public static Throwable h0(Throwable th) {
        if (th instanceof Error) {
            throw ((Error) th);
        }
        return th;
    }

    public static Class i(Object obj) {
        if (obj == null) {
            return null;
        }
        return obj.getClass();
    }

    public static Throwable i0(Throwable th) {
        if (th instanceof IOException) {
            throw ((IOException) th);
        }
        return th;
    }

    public static void j(c3.h hVar, Closeable closeable, Exception exc) {
        if (hVar != null) {
            hVar.q(h.b.AUTO_CLOSE_JSON_CONTENT);
            try {
                hVar.close();
            } catch (Exception e10) {
                exc.addSuppressed(e10);
            }
        }
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Exception e11) {
                exc.addSuppressed(e11);
            }
        }
        i0(exc);
        j0(exc);
        throw new RuntimeException(exc);
    }

    public static Throwable j0(Throwable th) {
        if (th instanceof RuntimeException) {
            throw ((RuntimeException) th);
        }
        return th;
    }

    public static void k(c3.h hVar, Exception exc) {
        hVar.q(h.b.AUTO_CLOSE_JSON_CONTENT);
        try {
            hVar.close();
        } catch (Exception e10) {
            exc.addSuppressed(e10);
        }
        i0(exc);
        j0(exc);
        throw new RuntimeException(exc);
    }

    public static Throwable k0(Throwable th) {
        return i0(F(th));
    }

    public static Object l(Class cls, boolean z10) {
        Constructor q10 = q(cls, z10);
        if (q10 == null) {
            throw new IllegalArgumentException("Class " + cls.getName() + " has no default (no arg) constructor");
        }
        try {
            return q10.newInstance(new Object[0]);
        } catch (Exception e10) {
            m0(e10, "Failed to instantiate class " + cls.getName() + ", problem: " + e10.getMessage());
            return null;
        }
    }

    public static void l0(Throwable th) {
        e0(F(th));
    }

    public static Object m(Class cls) {
        if (cls == Integer.TYPE) {
            return 0;
        }
        if (cls == Long.TYPE) {
            return 0L;
        }
        if (cls == Boolean.TYPE) {
            return Boolean.FALSE;
        }
        if (cls == Double.TYPE) {
            return Double.valueOf(0.0d);
        }
        if (cls == Float.TYPE) {
            return Float.valueOf(0.0f);
        }
        if (cls == Byte.TYPE) {
            return (byte) 0;
        }
        if (cls == Short.TYPE) {
            return (short) 0;
        }
        if (cls == Character.TYPE) {
            return (char) 0;
        }
        throw new IllegalArgumentException("Class " + cls.getName() + " is not a primitive type");
    }

    public static void m0(Throwable th, String str) {
        f0(F(th), str);
    }

    public static Iterator n() {
        return f12533d;
    }

    public static void n0(Class cls, Object obj, String str) {
        if (obj.getClass() != cls) {
            throw new IllegalStateException(String.format("Sub-class %s (of class %s) must override method '%s'", obj.getClass().getName(), cls.getName(), str));
        }
    }

    public static String o(Throwable th) {
        return th instanceof c3.l ? ((c3.l) th).c() : th.getMessage();
    }

    public static Class o0(Class cls) {
        if (cls == Integer.TYPE) {
            return Integer.class;
        }
        if (cls == Long.TYPE) {
            return Long.class;
        }
        if (cls == Boolean.TYPE) {
            return Boolean.class;
        }
        if (cls == Double.TYPE) {
            return Double.class;
        }
        if (cls == Float.TYPE) {
            return Float.class;
        }
        if (cls == Byte.TYPE) {
            return Byte.class;
        }
        if (cls == Short.TYPE) {
            return Short.class;
        }
        if (cls == Character.TYPE) {
            return Character.class;
        }
        throw new IllegalArgumentException("Class " + cls.getName() + " is not a primitive type");
    }

    public static Annotation[] p(Class cls) {
        return R(cls) ? f12531b : cls.getDeclaredAnnotations();
    }

    public static Constructor q(Class cls, boolean z10) {
        try {
            Constructor declaredConstructor = cls.getDeclaredConstructor(new Class[0]);
            if (z10) {
                g(declaredConstructor, z10);
            } else if (!Modifier.isPublic(declaredConstructor.getModifiers())) {
                throw new IllegalArgumentException("Default constructor for " + cls.getName() + " is not accessible (non-public?): not allowed to try modify access via Reflection: cannot instantiate type");
            }
            return declaredConstructor;
        } catch (NoSuchMethodException unused) {
            return null;
        } catch (Exception e10) {
            m0(e10, "Failed to find default constructor of class " + cls.getName() + ", problem: " + e10.getMessage());
            return null;
        }
    }

    public static Class r(Class cls) {
        return cls.getSuperclass() != Enum.class ? cls.getSuperclass() : cls;
    }

    public static Class s(Enum r02) {
        return r02.getDeclaringClass();
    }

    public static Class t(EnumMap enumMap) {
        return !enumMap.isEmpty() ? s((Enum) enumMap.keySet().iterator().next()) : b.f12538c.a(enumMap);
    }

    public static Class u(EnumSet enumSet) {
        return !enumSet.isEmpty() ? s((Enum) enumSet.iterator().next()) : b.f12538c.b(enumSet);
    }

    public static Enum v(Class cls, Class cls2) {
        for (Field field : cls.getDeclaredFields()) {
            if (field.isEnumConstant() && field.getAnnotation(cls2) != null) {
                String name = field.getName();
                for (Enum r82 : (Enum[]) cls.getEnumConstants()) {
                    if (name.equals(r82.name())) {
                        return r82;
                    }
                }
            }
        }
        return null;
    }

    public static List w(Class cls, Class cls2, boolean z10) {
        if (cls == null || cls == cls2 || cls == Object.class) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList(8);
        a(cls, cls2, arrayList, z10);
        return arrayList;
    }

    public static List x(Class cls, Class cls2, boolean z10) {
        ArrayList arrayList = new ArrayList(8);
        if (cls != null && cls != cls2) {
            if (z10) {
                arrayList.add(cls);
            }
            while (true) {
                cls = cls.getSuperclass();
                if (cls == null || cls == cls2) {
                    break;
                }
                arrayList.add(cls);
            }
        }
        return arrayList;
    }

    public static String y(Object obj) {
        if (obj == null) {
            return "unknown";
        }
        return X(obj instanceof Class ? (Class) obj : obj.getClass());
    }

    public static Method[] z(Class cls) {
        try {
            return cls.getDeclaredMethods();
        } catch (NoClassDefFoundError e10) {
            ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
            if (contextClassLoader == null) {
                return b(cls, e10);
            }
            try {
                try {
                    return contextClassLoader.loadClass(cls.getName()).getDeclaredMethods();
                } catch (Throwable th) {
                    return b(cls, th);
                }
            } catch (ClassNotFoundException e11) {
                e10.addSuppressed(e11);
                return b(cls, e10);
            }
        } catch (Throwable th2) {
            return b(cls, th2);
        }
    }
}
