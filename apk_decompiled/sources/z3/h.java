package z3;

import c3.k;
import java.math.BigDecimal;
import java.math.BigInteger;
import k3.c0;

/* loaded from: classes.dex */
public class h extends q {

    /* renamed from: a, reason: collision with root package name */
    public final double f20178a;

    public h(double d10) {
        this.f20178a = d10;
    }

    public static h A(double d10) {
        return new h(d10);
    }

    @Override // z3.b, c3.v
    public k.b a() {
        return k.b.DOUBLE;
    }

    @Override // z3.v, c3.v
    public c3.n b() {
        return c3.n.VALUE_NUMBER_FLOAT;
    }

    @Override // z3.b, k3.n
    public final void d(c3.h hVar, c0 c0Var) {
        hVar.b0(this.f20178a);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj != null && (obj instanceof h)) {
            return Double.compare(this.f20178a, ((h) obj).f20178a) == 0;
        }
        return false;
    }

    @Override // k3.m
    public String g() {
        return f3.g.u(this.f20178a);
    }

    @Override // k3.m
    public BigInteger h() {
        return j().toBigInteger();
    }

    public int hashCode() {
        long doubleToLongBits = Double.doubleToLongBits(this.f20178a);
        return ((int) doubleToLongBits) ^ ((int) (doubleToLongBits >> 32));
    }

    @Override // k3.m
    public BigDecimal j() {
        return BigDecimal.valueOf(this.f20178a);
    }

    @Override // k3.m
    public double k() {
        return this.f20178a;
    }

    @Override // k3.m
    public Number t() {
        return Double.valueOf(this.f20178a);
    }

    @Override // z3.q
    public boolean v() {
        double d10 = this.f20178a;
        return d10 >= -2.147483648E9d && d10 <= 2.147483647E9d;
    }

    @Override // z3.q
    public boolean w() {
        double d10 = this.f20178a;
        return d10 >= -9.223372036854776E18d && d10 <= 9.223372036854776E18d;
    }

    @Override // z3.q
    public int x() {
        return (int) this.f20178a;
    }

    @Override // z3.q
    public boolean y() {
        return Double.isNaN(this.f20178a) || Double.isInfinite(this.f20178a);
    }

    @Override // z3.q
    public long z() {
        return (long) this.f20178a;
    }
}
