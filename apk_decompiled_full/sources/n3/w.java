package n3;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import o3.y;

/* loaded from: classes.dex */
public abstract class w {
    public k3.j A(k3.f fVar) {
        return null;
    }

    public r3.n B() {
        return null;
    }

    public r3.n C() {
        return null;
    }

    public k3.j D(k3.f fVar) {
        return null;
    }

    public t[] E(k3.f fVar) {
        return null;
    }

    public abstract Class F();

    public boolean a() {
        return false;
    }

    public boolean b() {
        return false;
    }

    public boolean c() {
        return false;
    }

    public boolean d() {
        return false;
    }

    public boolean e() {
        return false;
    }

    public boolean f() {
        return false;
    }

    public boolean g() {
        return false;
    }

    public boolean h() {
        return false;
    }

    public boolean i() {
        return false;
    }

    public boolean j() {
        return B() != null;
    }

    public boolean k() {
        return false;
    }

    public boolean l() {
        return j() || k() || i() || g() || h() || e() || f() || d() || c();
    }

    public w m(k3.g gVar, k3.c cVar) {
        return this;
    }

    public Object n(k3.g gVar, BigDecimal bigDecimal) {
        return gVar.W(F(), this, null, "no BigDecimal/double/Double-argument constructor/factory method to deserialize from Number value (%s)", bigDecimal);
    }

    public Object o(k3.g gVar, BigInteger bigInteger) {
        return gVar.W(F(), this, null, "no BigInteger-argument constructor/factory method to deserialize from Number value (%s)", bigInteger);
    }

    public Object p(k3.g gVar, boolean z10) {
        return gVar.W(F(), this, null, "no boolean/Boolean-argument constructor/factory method to deserialize from boolean value (%s)", Boolean.valueOf(z10));
    }

    public Object q(k3.g gVar, double d10) {
        return gVar.W(F(), this, null, "no double/Double-argument constructor/factory method to deserialize from Number value (%s)", Double.valueOf(d10));
    }

    public Object r(k3.g gVar, int i10) {
        return gVar.W(F(), this, null, "no int/Int-argument constructor/factory method to deserialize from Number value (%s)", Integer.valueOf(i10));
    }

    public Object s(k3.g gVar, long j10) {
        return gVar.W(F(), this, null, "no long/Long-argument constructor/factory method to deserialize from Number value (%s)", Long.valueOf(j10));
    }

    public Object t(k3.g gVar, Object[] objArr) {
        return gVar.W(F(), this, null, "no creator with arguments specified", new Object[0]);
    }

    public Object u(k3.g gVar, t[] tVarArr, y yVar) {
        return t(gVar, yVar.g(tVarArr));
    }

    public Object v(k3.g gVar, String str) {
        return gVar.W(F(), this, gVar.S(), "no String-argument constructor/factory method to deserialize from String value ('%s')", str);
    }

    public Object w(k3.g gVar, Object obj) {
        return gVar.W(F(), this, null, "no array delegate creator specified", new Object[0]);
    }

    public Object x(k3.g gVar) {
        return gVar.W(F(), this, null, "no default no-arguments constructor found", new Object[0]);
    }

    public Object y(k3.g gVar, Object obj) {
        return gVar.W(F(), this, null, "no delegate creator specified", new Object[0]);
    }

    public r3.n z() {
        return null;
    }

    public static class a extends w implements Serializable {

        /* renamed from: a, reason: collision with root package name */
        public final Class f17267a;

        public a(Class cls) {
            this.f17267a = cls;
        }

        @Override // n3.w
        public Class F() {
            return this.f17267a;
        }

        public a(k3.j jVar) {
            this.f17267a = jVar.q();
        }
    }
}
