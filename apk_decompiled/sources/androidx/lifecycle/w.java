package androidx.lifecycle;

import android.app.Application;
import java.lang.reflect.InvocationTargetException;

/* loaded from: classes.dex */
public class w {

    /* renamed from: a, reason: collision with root package name */
    public final b f2604a;

    /* renamed from: b, reason: collision with root package name */
    public final x f2605b;

    public static class a extends d {

        /* renamed from: c, reason: collision with root package name */
        public static a f2606c;

        /* renamed from: b, reason: collision with root package name */
        public Application f2607b;

        public a(Application application) {
            this.f2607b = application;
        }

        public static a c(Application application) {
            if (f2606c == null) {
                f2606c = new a(application);
            }
            return f2606c;
        }

        @Override // androidx.lifecycle.w.d, androidx.lifecycle.w.b
        public v a(Class cls) {
            if (!androidx.lifecycle.a.class.isAssignableFrom(cls)) {
                return super.a(cls);
            }
            try {
                return (v) cls.getConstructor(Application.class).newInstance(this.f2607b);
            } catch (IllegalAccessException e10) {
                throw new RuntimeException("Cannot create an instance of " + cls, e10);
            } catch (InstantiationException e11) {
                throw new RuntimeException("Cannot create an instance of " + cls, e11);
            } catch (NoSuchMethodException e12) {
                throw new RuntimeException("Cannot create an instance of " + cls, e12);
            } catch (InvocationTargetException e13) {
                throw new RuntimeException("Cannot create an instance of " + cls, e13);
            }
        }
    }

    public interface b {
        v a(Class cls);
    }

    public static abstract class c extends e implements b {
        public abstract v c(String str, Class cls);
    }

    public static class d implements b {

        /* renamed from: a, reason: collision with root package name */
        public static d f2608a;

        public static d b() {
            if (f2608a == null) {
                f2608a = new d();
            }
            return f2608a;
        }

        @Override // androidx.lifecycle.w.b
        public v a(Class cls) {
            try {
                return (v) cls.newInstance();
            } catch (IllegalAccessException e10) {
                throw new RuntimeException("Cannot create an instance of " + cls, e10);
            } catch (InstantiationException e11) {
                throw new RuntimeException("Cannot create an instance of " + cls, e11);
            }
        }
    }

    public static class e {
        public abstract void b(v vVar);
    }

    public w(x xVar, b bVar) {
        this.f2604a = bVar;
        this.f2605b = xVar;
    }

    public v a(Class cls) {
        String canonicalName = cls.getCanonicalName();
        if (canonicalName == null) {
            throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
        }
        return b("androidx.lifecycle.ViewModelProvider.DefaultKey:" + canonicalName, cls);
    }

    public v b(String str, Class cls) {
        v b10 = this.f2605b.b(str);
        if (cls.isInstance(b10)) {
            Object obj = this.f2604a;
            if (obj instanceof e) {
                ((e) obj).b(b10);
            }
            return b10;
        }
        b bVar = this.f2604a;
        v c10 = bVar instanceof c ? ((c) bVar).c(str, cls) : bVar.a(cls);
        this.f2605b.d(str, c10);
        return c10;
    }
}
