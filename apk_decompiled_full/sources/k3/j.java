package k3;

import java.io.Serializable;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.List;

/* loaded from: classes.dex */
public abstract class j extends i3.a implements Serializable, Type {

    /* renamed from: a, reason: collision with root package name */
    public final Class f14918a;

    /* renamed from: b, reason: collision with root package name */
    public final int f14919b;

    /* renamed from: c, reason: collision with root package name */
    public final Object f14920c;

    /* renamed from: d, reason: collision with root package name */
    public final Object f14921d;

    /* renamed from: e, reason: collision with root package name */
    public final boolean f14922e;

    public j(Class cls, int i10, Object obj, Object obj2, boolean z10) {
        this.f14918a = cls;
        this.f14919b = cls.getName().hashCode() + i10;
        this.f14920c = obj;
        this.f14921d = obj2;
        this.f14922e = z10;
    }

    public boolean A() {
        return false;
    }

    public boolean B() {
        return false;
    }

    public boolean C() {
        if ((this.f14918a.getModifiers() & 1536) == 0) {
            return true;
        }
        return this.f14918a.isPrimitive();
    }

    public abstract boolean D();

    public final boolean E() {
        return d4.h.L(this.f14918a) && this.f14918a != Enum.class;
    }

    public final boolean F() {
        return d4.h.L(this.f14918a);
    }

    public final boolean G() {
        return Modifier.isFinal(this.f14918a.getModifiers());
    }

    public final boolean H() {
        return this.f14918a.isInterface();
    }

    public final boolean I() {
        return this.f14918a == Object.class;
    }

    public boolean J() {
        return false;
    }

    public final boolean K() {
        return this.f14918a.isPrimitive();
    }

    public final boolean L() {
        return d4.h.T(this.f14918a);
    }

    public boolean M() {
        return Throwable.class.isAssignableFrom(this.f14918a);
    }

    public final boolean N(Class cls) {
        Class cls2 = this.f14918a;
        return cls2 == cls || cls.isAssignableFrom(cls2);
    }

    public final boolean O(Class cls) {
        Class cls2 = this.f14918a;
        return cls2 == cls || cls2.isAssignableFrom(cls);
    }

    public abstract j P(Class cls, c4.n nVar, j jVar, j[] jVarArr);

    public final boolean Q() {
        return this.f14922e;
    }

    public abstract j R(j jVar);

    public abstract j S(Object obj);

    public abstract j T(Object obj);

    public j U(j jVar) {
        Object t10 = jVar.t();
        j W = t10 != this.f14921d ? W(t10) : this;
        Object u10 = jVar.u();
        return u10 != this.f14920c ? W.X(u10) : W;
    }

    public abstract j V();

    public abstract j W(Object obj);

    public abstract j X(Object obj);

    public abstract boolean equals(Object obj);

    public abstract j f(int i10);

    public abstract int g();

    public j h(int i10) {
        j f10 = f(i10);
        return f10 == null ? c4.o.O() : f10;
    }

    public final int hashCode() {
        return this.f14919b;
    }

    public abstract j i(Class cls);

    public abstract c4.n j();

    public j k() {
        return null;
    }

    public abstract StringBuilder l(StringBuilder sb);

    public String m() {
        StringBuilder sb = new StringBuilder(40);
        n(sb);
        return sb.toString();
    }

    public abstract StringBuilder n(StringBuilder sb);

    public abstract List o();

    public j p() {
        return null;
    }

    public final Class q() {
        return this.f14918a;
    }

    @Override // i3.a
    /* renamed from: r, reason: merged with bridge method [inline-methods] */
    public j a() {
        return null;
    }

    public abstract j s();

    public Object t() {
        return this.f14921d;
    }

    public abstract String toString();

    public Object u() {
        return this.f14920c;
    }

    public boolean v() {
        return true;
    }

    public boolean w() {
        return g() > 0;
    }

    public boolean x() {
        return (this.f14921d == null && this.f14920c == null) ? false : true;
    }

    public final boolean y(Class cls) {
        return this.f14918a == cls;
    }

    public boolean z() {
        return Modifier.isAbstract(this.f14918a.getModifiers());
    }
}
