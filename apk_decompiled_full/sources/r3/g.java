package r3;

import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.lang.reflect.Modifier;

/* loaded from: classes.dex */
public final class g extends i {

    /* renamed from: c, reason: collision with root package name */
    public final transient Field f18423c;

    public g(f0 f0Var, Field field, p pVar) {
        super(f0Var, pVar);
        this.f18423c = field;
    }

    @Override // r3.b
    public String d() {
        return this.f18423c.getName();
    }

    @Override // r3.b
    public Class e() {
        return this.f18423c.getType();
    }

    @Override // r3.b
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        return d4.h.H(obj, g.class) && ((g) obj).f18423c == this.f18423c;
    }

    @Override // r3.b
    public k3.j f() {
        return this.f18439a.a(this.f18423c.getGenericType());
    }

    @Override // r3.b
    public int hashCode() {
        return this.f18423c.getName().hashCode();
    }

    @Override // r3.i
    public Class k() {
        return this.f18423c.getDeclaringClass();
    }

    @Override // r3.i
    public Member m() {
        return this.f18423c;
    }

    @Override // r3.i
    public Object n(Object obj) {
        try {
            return this.f18423c.get(obj);
        } catch (IllegalAccessException e10) {
            throw new IllegalArgumentException("Failed to getValue() for field " + l() + ": " + e10.getMessage(), e10);
        }
    }

    @Override // r3.i
    public void o(Object obj, Object obj2) {
        try {
            this.f18423c.set(obj, obj2);
        } catch (IllegalAccessException e10) {
            throw new IllegalArgumentException("Failed to setValue() for field " + l() + ": " + e10.getMessage(), e10);
        }
    }

    @Override // r3.b
    /* renamed from: q, reason: merged with bridge method [inline-methods] */
    public Field b() {
        return this.f18423c;
    }

    public int r() {
        return this.f18423c.getModifiers();
    }

    public boolean s() {
        return Modifier.isTransient(r());
    }

    @Override // r3.i
    /* renamed from: t, reason: merged with bridge method [inline-methods] */
    public g p(p pVar) {
        return new g(this.f18439a, this.f18423c, pVar);
    }

    @Override // r3.b
    public String toString() {
        return "[field " + l() + "]";
    }
}
