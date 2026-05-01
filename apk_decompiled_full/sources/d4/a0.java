package d4;

/* loaded from: classes.dex */
public class a0 {

    /* renamed from: a, reason: collision with root package name */
    public int f12509a;

    /* renamed from: b, reason: collision with root package name */
    public Class f12510b;

    /* renamed from: c, reason: collision with root package name */
    public k3.j f12511c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f12512d;

    public a0(Class cls, boolean z10) {
        this.f12510b = cls;
        this.f12511c = null;
        this.f12512d = z10;
        this.f12509a = z10 ? d(cls) : f(cls);
    }

    public static final int d(Class cls) {
        return cls.getName().hashCode() + 1;
    }

    public static final int e(k3.j jVar) {
        return jVar.hashCode() - 2;
    }

    public static final int f(Class cls) {
        return cls.getName().hashCode();
    }

    public static final int g(k3.j jVar) {
        return jVar.hashCode() - 1;
    }

    public Class a() {
        return this.f12510b;
    }

    public k3.j b() {
        return this.f12511c;
    }

    public boolean c() {
        return this.f12512d;
    }

    public final boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (obj.getClass() != getClass()) {
            return false;
        }
        a0 a0Var = (a0) obj;
        if (a0Var.f12512d != this.f12512d) {
            return false;
        }
        Class cls = this.f12510b;
        return cls != null ? a0Var.f12510b == cls : this.f12511c.equals(a0Var.f12511c);
    }

    public final int hashCode() {
        return this.f12509a;
    }

    public final String toString() {
        if (this.f12510b != null) {
            return "{class: " + this.f12510b.getName() + ", typed? " + this.f12512d + "}";
        }
        return "{type: " + this.f12511c + ", typed? " + this.f12512d + "}";
    }

    public a0(k3.j jVar, boolean z10) {
        this.f12511c = jVar;
        this.f12510b = null;
        this.f12512d = z10;
        this.f12509a = z10 ? e(jVar) : g(jVar);
    }
}
