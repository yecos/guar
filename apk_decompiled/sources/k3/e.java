package k3;

import b3.k0;
import b3.o0;
import d4.j;
import java.lang.reflect.Type;
import w3.c;

/* loaded from: classes.dex */
public abstract class e {
    public String a(String str, String str2) {
        if (str2 == null) {
            return str;
        }
        return str + ": " + str2;
    }

    public final String b(String str, Object... objArr) {
        return objArr.length > 0 ? String.format(str, objArr) : str;
    }

    public String c(String str) {
        return str == null ? "[N/A]" : String.format("\"%s\"", h(str));
    }

    public final j d(j jVar, String str, w3.c cVar, int i10) {
        m3.m k10 = k();
        c.b b10 = cVar.b(k10, jVar, str.substring(0, i10));
        if (b10 == c.b.DENIED) {
            return (j) g(jVar, str, cVar);
        }
        j A = l().A(str);
        if (!A.N(jVar.q())) {
            return (j) e(jVar, str);
        }
        c.b bVar = c.b.ALLOWED;
        return (b10 == bVar || cVar.c(k10, jVar, A) == bVar) ? A : (j) f(jVar, str, cVar);
    }

    public Object e(j jVar, String str) {
        throw m(jVar, str, "Not a subtype");
    }

    public Object f(j jVar, String str, w3.c cVar) {
        throw m(jVar, str, "Configured `PolymorphicTypeValidator` (of type " + d4.h.h(cVar) + ") denied resolution");
    }

    public Object g(j jVar, String str, w3.c cVar) {
        throw m(jVar, str, "Configured `PolymorphicTypeValidator` (of type " + d4.h.h(cVar) + ") denied resolution");
    }

    public final String h(String str) {
        if (str == null) {
            return "";
        }
        if (str.length() <= 500) {
            return str;
        }
        return str.substring(0, 500) + "]...[" + str.substring(str.length() - 500);
    }

    public j i(Type type) {
        if (type == null) {
            return null;
        }
        return l().H(type);
    }

    public d4.j j(r3.b bVar, Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof d4.j) {
            return (d4.j) obj;
        }
        if (!(obj instanceof Class)) {
            throw new IllegalStateException("AnnotationIntrospector returned Converter definition of type " + obj.getClass().getName() + "; expected type Converter or Class<Converter> instead");
        }
        Class cls = (Class) obj;
        if (cls == j.a.class || d4.h.J(cls)) {
            return null;
        }
        if (d4.j.class.isAssignableFrom(cls)) {
            m3.m k10 = k();
            k10.u();
            return (d4.j) d4.h.l(cls, k10.b());
        }
        throw new IllegalStateException("AnnotationIntrospector returned Class " + cls.getName() + "; expected Class<Converter>");
    }

    public abstract m3.m k();

    public abstract c4.o l();

    public abstract l m(j jVar, String str, String str2);

    public k0 n(r3.b bVar, r3.b0 b0Var) {
        Class c10 = b0Var.c();
        m3.m k10 = k();
        k10.u();
        return ((k0) d4.h.l(c10, k10.b())).b(b0Var.f());
    }

    public o0 o(r3.b bVar, r3.b0 b0Var) {
        Class e10 = b0Var.e();
        m3.m k10 = k();
        k10.u();
        androidx.appcompat.app.m.a(d4.h.l(e10, k10.b()));
        return null;
    }

    public Object p(Class cls, String str) {
        return q(i(cls), str);
    }

    public abstract Object q(j jVar, String str);

    public j r(j jVar, String str, w3.c cVar) {
        int indexOf = str.indexOf(60);
        if (indexOf > 0) {
            return d(jVar, str, cVar, indexOf);
        }
        m3.m k10 = k();
        c.b b10 = cVar.b(k10, jVar, str);
        if (b10 == c.b.DENIED) {
            return (j) g(jVar, str, cVar);
        }
        try {
            Class J = l().J(str);
            if (!jVar.O(J)) {
                return (j) e(jVar, str);
            }
            j F = k10.z().F(jVar, J);
            return (b10 != c.b.INDETERMINATE || cVar.c(k10, jVar, F) == c.b.ALLOWED) ? F : (j) f(jVar, str, cVar);
        } catch (ClassNotFoundException unused) {
            return null;
        } catch (Exception e10) {
            throw m(jVar, str, String.format("problem: (%s) %s", e10.getClass().getName(), d4.h.o(e10)));
        }
    }
}
