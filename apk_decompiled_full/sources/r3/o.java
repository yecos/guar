package r3;

import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes.dex */
public abstract class o {

    /* renamed from: b, reason: collision with root package name */
    public static final d4.b f18453b = new c();

    /* renamed from: a, reason: collision with root package name */
    public final Object f18454a;

    public static class a extends o {

        /* renamed from: c, reason: collision with root package name */
        public static final a f18455c = new a(null);

        public a(Object obj) {
            super(obj);
        }

        @Override // r3.o
        public o a(Annotation annotation) {
            return new e(this.f18454a, annotation.annotationType(), annotation);
        }

        @Override // r3.o
        public p b() {
            return new p();
        }

        @Override // r3.o
        public d4.b c() {
            return o.f18453b;
        }

        @Override // r3.o
        public boolean f(Annotation annotation) {
            return false;
        }
    }

    public static class b extends o {

        /* renamed from: c, reason: collision with root package name */
        public final HashMap f18456c;

        public b(Object obj, Class cls, Annotation annotation, Class cls2, Annotation annotation2) {
            super(obj);
            HashMap hashMap = new HashMap();
            this.f18456c = hashMap;
            hashMap.put(cls, annotation);
            hashMap.put(cls2, annotation2);
        }

        @Override // r3.o
        public o a(Annotation annotation) {
            this.f18456c.put(annotation.annotationType(), annotation);
            return this;
        }

        @Override // r3.o
        public p b() {
            p pVar = new p();
            Iterator it = this.f18456c.values().iterator();
            while (it.hasNext()) {
                pVar.d((Annotation) it.next());
            }
            return pVar;
        }

        @Override // r3.o
        public d4.b c() {
            if (this.f18456c.size() != 2) {
                return new p(this.f18456c);
            }
            Iterator it = this.f18456c.entrySet().iterator();
            Map.Entry entry = (Map.Entry) it.next();
            Map.Entry entry2 = (Map.Entry) it.next();
            return new f((Class) entry.getKey(), (Annotation) entry.getValue(), (Class) entry2.getKey(), (Annotation) entry2.getValue());
        }

        @Override // r3.o
        public boolean f(Annotation annotation) {
            return this.f18456c.containsKey(annotation.annotationType());
        }
    }

    public static class c implements d4.b, Serializable {
        @Override // d4.b
        public boolean a(Class cls) {
            return false;
        }

        @Override // d4.b
        public boolean b(Class[] clsArr) {
            return false;
        }

        @Override // d4.b
        public Annotation get(Class cls) {
            return null;
        }

        @Override // d4.b
        public int size() {
            return 0;
        }
    }

    public static class d implements d4.b, Serializable {

        /* renamed from: a, reason: collision with root package name */
        public final Class f18457a;

        /* renamed from: b, reason: collision with root package name */
        public final Annotation f18458b;

        public d(Class cls, Annotation annotation) {
            this.f18457a = cls;
            this.f18458b = annotation;
        }

        @Override // d4.b
        public boolean a(Class cls) {
            return this.f18457a == cls;
        }

        @Override // d4.b
        public boolean b(Class[] clsArr) {
            for (Class cls : clsArr) {
                if (cls == this.f18457a) {
                    return true;
                }
            }
            return false;
        }

        @Override // d4.b
        public Annotation get(Class cls) {
            if (this.f18457a == cls) {
                return this.f18458b;
            }
            return null;
        }

        @Override // d4.b
        public int size() {
            return 1;
        }
    }

    public static class e extends o {

        /* renamed from: c, reason: collision with root package name */
        public Class f18459c;

        /* renamed from: d, reason: collision with root package name */
        public Annotation f18460d;

        public e(Object obj, Class cls, Annotation annotation) {
            super(obj);
            this.f18459c = cls;
            this.f18460d = annotation;
        }

        @Override // r3.o
        public o a(Annotation annotation) {
            Class<? extends Annotation> annotationType = annotation.annotationType();
            Class<? extends Annotation> cls = this.f18459c;
            if (cls != annotationType) {
                return new b(this.f18454a, cls, this.f18460d, annotationType, annotation);
            }
            this.f18460d = annotation;
            return this;
        }

        @Override // r3.o
        public p b() {
            return p.f(this.f18459c, this.f18460d);
        }

        @Override // r3.o
        public d4.b c() {
            return new d(this.f18459c, this.f18460d);
        }

        @Override // r3.o
        public boolean f(Annotation annotation) {
            return annotation.annotationType() == this.f18459c;
        }
    }

    public static class f implements d4.b, Serializable {

        /* renamed from: a, reason: collision with root package name */
        public final Class f18461a;

        /* renamed from: b, reason: collision with root package name */
        public final Class f18462b;

        /* renamed from: c, reason: collision with root package name */
        public final Annotation f18463c;

        /* renamed from: d, reason: collision with root package name */
        public final Annotation f18464d;

        public f(Class cls, Annotation annotation, Class cls2, Annotation annotation2) {
            this.f18461a = cls;
            this.f18463c = annotation;
            this.f18462b = cls2;
            this.f18464d = annotation2;
        }

        @Override // d4.b
        public boolean a(Class cls) {
            return this.f18461a == cls || this.f18462b == cls;
        }

        @Override // d4.b
        public boolean b(Class[] clsArr) {
            for (Class cls : clsArr) {
                if (cls == this.f18461a || cls == this.f18462b) {
                    return true;
                }
            }
            return false;
        }

        @Override // d4.b
        public Annotation get(Class cls) {
            if (this.f18461a == cls) {
                return this.f18463c;
            }
            if (this.f18462b == cls) {
                return this.f18464d;
            }
            return null;
        }

        @Override // d4.b
        public int size() {
            return 2;
        }
    }

    public o(Object obj) {
        this.f18454a = obj;
    }

    public static d4.b d() {
        return f18453b;
    }

    public static o e() {
        return a.f18455c;
    }

    public abstract o a(Annotation annotation);

    public abstract p b();

    public abstract d4.b c();

    public abstract boolean f(Annotation annotation);
}
