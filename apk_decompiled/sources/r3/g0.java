package r3;

import java.lang.reflect.Field;
import java.lang.reflect.Member;

/* loaded from: classes.dex */
public class g0 extends i {

    /* renamed from: c, reason: collision with root package name */
    public final Class f18424c;

    /* renamed from: d, reason: collision with root package name */
    public final k3.j f18425d;

    /* renamed from: e, reason: collision with root package name */
    public final String f18426e;

    public g0(f0 f0Var, Class cls, String str, k3.j jVar) {
        super(f0Var, null);
        this.f18424c = cls;
        this.f18425d = jVar;
        this.f18426e = str;
    }

    @Override // r3.b
    public String d() {
        return this.f18426e;
    }

    @Override // r3.b
    public Class e() {
        return this.f18425d.q();
    }

    @Override // r3.b
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!d4.h.H(obj, getClass())) {
            return false;
        }
        g0 g0Var = (g0) obj;
        return g0Var.f18424c == this.f18424c && g0Var.f18426e.equals(this.f18426e);
    }

    @Override // r3.b
    public k3.j f() {
        return this.f18425d;
    }

    @Override // r3.b
    public int hashCode() {
        return this.f18426e.hashCode();
    }

    @Override // r3.i
    public Class k() {
        return this.f18424c;
    }

    @Override // r3.i
    public Member m() {
        return null;
    }

    @Override // r3.i
    public Object n(Object obj) {
        throw new IllegalArgumentException("Cannot get virtual property '" + this.f18426e + "'");
    }

    @Override // r3.i
    public void o(Object obj, Object obj2) {
        throw new IllegalArgumentException("Cannot set virtual property '" + this.f18426e + "'");
    }

    @Override // r3.i
    public b p(p pVar) {
        return this;
    }

    @Override // r3.b
    /* renamed from: q, reason: merged with bridge method [inline-methods] */
    public Field b() {
        return null;
    }

    @Override // r3.b
    public String toString() {
        return "[virtual " + l() + "]";
    }
}
