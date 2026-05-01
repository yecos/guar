package r3;

import java.lang.reflect.Constructor;
import java.lang.reflect.Member;
import java.lang.reflect.Type;

/* loaded from: classes.dex */
public final class e extends n {

    /* renamed from: d, reason: collision with root package name */
    public final Constructor f18415d;

    public e(f0 f0Var, Constructor constructor, p pVar, p[] pVarArr) {
        super(f0Var, pVar, pVarArr);
        if (constructor == null) {
            throw new IllegalArgumentException("Null constructor not allowed");
        }
        this.f18415d = constructor;
    }

    @Override // r3.i
    /* renamed from: A, reason: merged with bridge method [inline-methods] */
    public e p(p pVar) {
        return new e(this.f18439a, this.f18415d, pVar, this.f18452c);
    }

    @Override // r3.b
    public String d() {
        return this.f18415d.getName();
    }

    @Override // r3.b
    public Class e() {
        return this.f18415d.getDeclaringClass();
    }

    @Override // r3.b
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        return d4.h.H(obj, e.class) && ((e) obj).f18415d == this.f18415d;
    }

    @Override // r3.b
    public k3.j f() {
        return this.f18439a.a(e());
    }

    @Override // r3.b
    public int hashCode() {
        return this.f18415d.getName().hashCode();
    }

    @Override // r3.i
    public Class k() {
        return this.f18415d.getDeclaringClass();
    }

    @Override // r3.i
    public Member m() {
        return this.f18415d;
    }

    @Override // r3.i
    public Object n(Object obj) {
        throw new UnsupportedOperationException("Cannot call getValue() on constructor of " + k().getName());
    }

    @Override // r3.i
    public void o(Object obj, Object obj2) {
        throw new UnsupportedOperationException("Cannot call setValue() on constructor of " + k().getName());
    }

    @Override // r3.n
    public final Object q() {
        return this.f18415d.newInstance(new Object[0]);
    }

    @Override // r3.n
    public final Object r(Object[] objArr) {
        return this.f18415d.newInstance(objArr);
    }

    @Override // r3.n
    public final Object s(Object obj) {
        return this.f18415d.newInstance(obj);
    }

    @Override // r3.b
    public String toString() {
        int length = this.f18415d.getParameterTypes().length;
        Object[] objArr = new Object[4];
        objArr[0] = d4.h.X(this.f18415d.getDeclaringClass());
        objArr[1] = Integer.valueOf(length);
        objArr[2] = length == 1 ? "" : "s";
        objArr[3] = this.f18440b;
        return String.format("[constructor for %s (%d arg%s), annotations: %s", objArr);
    }

    @Override // r3.n
    public int v() {
        return this.f18415d.getParameterTypes().length;
    }

    @Override // r3.n
    public k3.j w(int i10) {
        Type[] genericParameterTypes = this.f18415d.getGenericParameterTypes();
        if (i10 >= genericParameterTypes.length) {
            return null;
        }
        return this.f18439a.a(genericParameterTypes[i10]);
    }

    @Override // r3.n
    public Class x(int i10) {
        Class<?>[] parameterTypes = this.f18415d.getParameterTypes();
        if (i10 >= parameterTypes.length) {
            return null;
        }
        return parameterTypes[i10];
    }

    @Override // r3.b
    /* renamed from: z, reason: merged with bridge method [inline-methods] */
    public Constructor b() {
        return this.f18415d;
    }
}
