package z3;

import c3.k;
import java.math.BigDecimal;
import java.math.BigInteger;
import k3.c0;

/* loaded from: classes.dex */
public class j extends q {

    /* renamed from: b, reason: collision with root package name */
    public static final j[] f20180b = new j[12];

    /* renamed from: a, reason: collision with root package name */
    public final int f20181a;

    static {
        for (int i10 = 0; i10 < 12; i10++) {
            f20180b[i10] = new j(i10 - 1);
        }
    }

    public j(int i10) {
        this.f20181a = i10;
    }

    public static j A(int i10) {
        return (i10 > 10 || i10 < -1) ? new j(i10) : f20180b[i10 - (-1)];
    }

    @Override // z3.b, c3.v
    public k.b a() {
        return k.b.INT;
    }

    @Override // z3.v, c3.v
    public c3.n b() {
        return c3.n.VALUE_NUMBER_INT;
    }

    @Override // z3.b, k3.n
    public final void d(c3.h hVar, c0 c0Var) {
        hVar.d0(this.f20181a);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        return obj != null && (obj instanceof j) && ((j) obj).f20181a == this.f20181a;
    }

    @Override // k3.m
    public String g() {
        return f3.g.w(this.f20181a);
    }

    @Override // k3.m
    public BigInteger h() {
        return BigInteger.valueOf(this.f20181a);
    }

    public int hashCode() {
        return this.f20181a;
    }

    @Override // k3.m
    public BigDecimal j() {
        return BigDecimal.valueOf(this.f20181a);
    }

    @Override // k3.m
    public double k() {
        return this.f20181a;
    }

    @Override // k3.m
    public Number t() {
        return Integer.valueOf(this.f20181a);
    }

    @Override // z3.q
    public boolean v() {
        return true;
    }

    @Override // z3.q
    public boolean w() {
        return true;
    }

    @Override // z3.q
    public int x() {
        return this.f20181a;
    }

    @Override // z3.q
    public long z() {
        return this.f20181a;
    }
}
