package r3;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Type;

/* loaded from: classes.dex */
public final class j extends n {

    /* renamed from: d, reason: collision with root package name */
    public final transient Method f18441d;

    /* renamed from: e, reason: collision with root package name */
    public Class[] f18442e;

    public j(f0 f0Var, Method method, p pVar, p[] pVarArr) {
        super(f0Var, pVar, pVarArr);
        if (method == null) {
            throw new IllegalArgumentException("Cannot construct AnnotatedMethod with null Method");
        }
        this.f18441d = method;
    }

    @Override // r3.b
    /* renamed from: A, reason: merged with bridge method [inline-methods] */
    public Method b() {
        return this.f18441d;
    }

    @Override // r3.i
    /* renamed from: B, reason: merged with bridge method [inline-methods] */
    public Method m() {
        return this.f18441d;
    }

    public Class[] C() {
        if (this.f18442e == null) {
            this.f18442e = this.f18441d.getParameterTypes();
        }
        return this.f18442e;
    }

    public Class D() {
        return this.f18441d.getReturnType();
    }

    @Override // r3.i
    /* renamed from: E, reason: merged with bridge method [inline-methods] */
    public j p(p pVar) {
        return new j(this.f18439a, this.f18441d, pVar, this.f18452c);
    }

    @Override // r3.b
    public String d() {
        return this.f18441d.getName();
    }

    @Override // r3.b
    public Class e() {
        return this.f18441d.getReturnType();
    }

    @Override // r3.b
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        return d4.h.H(obj, j.class) && ((j) obj).f18441d == this.f18441d;
    }

    @Override // r3.b
    public k3.j f() {
        return this.f18439a.a(this.f18441d.getGenericReturnType());
    }

    @Override // r3.b
    public int hashCode() {
        return this.f18441d.getName().hashCode();
    }

    @Override // r3.i
    public Class k() {
        return this.f18441d.getDeclaringClass();
    }

    @Override // r3.i
    public String l() {
        String l10 = super.l();
        int v10 = v();
        if (v10 == 0) {
            return l10 + "()";
        }
        if (v10 != 1) {
            return String.format("%s(%d params)", super.l(), Integer.valueOf(v()));
        }
        return l10 + "(" + x(0).getName() + ")";
    }

    @Override // r3.i
    public Object n(Object obj) {
        try {
            return this.f18441d.invoke(obj, null);
        } catch (IllegalAccessException | InvocationTargetException e10) {
            throw new IllegalArgumentException("Failed to getValue() with method " + l() + ": " + e10.getMessage(), e10);
        }
    }

    @Override // r3.i
    public void o(Object obj, Object obj2) {
        try {
            this.f18441d.invoke(obj, obj2);
        } catch (IllegalAccessException | InvocationTargetException e10) {
            throw new IllegalArgumentException("Failed to setValue() with method " + l() + ": " + e10.getMessage(), e10);
        }
    }

    @Override // r3.n
    public final Object q() {
        return this.f18441d.invoke(null, new Object[0]);
    }

    @Override // r3.n
    public final Object r(Object[] objArr) {
        return this.f18441d.invoke(null, objArr);
    }

    @Override // r3.n
    public final Object s(Object obj) {
        return this.f18441d.invoke(null, obj);
    }

    @Override // r3.b
    public String toString() {
        return "[method " + l() + "]";
    }

    @Override // r3.n
    public int v() {
        return C().length;
    }

    @Override // r3.n
    public k3.j w(int i10) {
        Type[] genericParameterTypes = this.f18441d.getGenericParameterTypes();
        if (i10 >= genericParameterTypes.length) {
            return null;
        }
        return this.f18439a.a(genericParameterTypes[i10]);
    }

    @Override // r3.n
    public Class x(int i10) {
        Class[] C = C();
        if (i10 >= C.length) {
            return null;
        }
        return C[i10];
    }

    public final Object z(Object obj, Object... objArr) {
        return this.f18441d.invoke(obj, objArr);
    }
}
