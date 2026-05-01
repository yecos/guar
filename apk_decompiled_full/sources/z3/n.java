package z3;

import c3.k;
import com.hpplay.sdk.source.mdns.xbill.dns.TTL;
import java.math.BigDecimal;
import java.math.BigInteger;
import k3.c0;

/* loaded from: classes.dex */
public class n extends q {

    /* renamed from: a, reason: collision with root package name */
    public final long f20200a;

    public n(long j10) {
        this.f20200a = j10;
    }

    public static n A(long j10) {
        return new n(j10);
    }

    @Override // z3.b, c3.v
    public k.b a() {
        return k.b.LONG;
    }

    @Override // z3.v, c3.v
    public c3.n b() {
        return c3.n.VALUE_NUMBER_INT;
    }

    @Override // z3.b, k3.n
    public final void d(c3.h hVar, c0 c0Var) {
        hVar.e0(this.f20200a);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        return obj != null && (obj instanceof n) && ((n) obj).f20200a == this.f20200a;
    }

    @Override // k3.m
    public String g() {
        return f3.g.x(this.f20200a);
    }

    @Override // k3.m
    public BigInteger h() {
        return BigInteger.valueOf(this.f20200a);
    }

    public int hashCode() {
        long j10 = this.f20200a;
        return ((int) j10) ^ ((int) (j10 >> 32));
    }

    @Override // k3.m
    public BigDecimal j() {
        return BigDecimal.valueOf(this.f20200a);
    }

    @Override // k3.m
    public double k() {
        return this.f20200a;
    }

    @Override // k3.m
    public Number t() {
        return Long.valueOf(this.f20200a);
    }

    @Override // z3.q
    public boolean v() {
        long j10 = this.f20200a;
        return j10 >= -2147483648L && j10 <= TTL.MAX_VALUE;
    }

    @Override // z3.q
    public boolean w() {
        return true;
    }

    @Override // z3.q
    public int x() {
        return (int) this.f20200a;
    }

    @Override // z3.q
    public long z() {
        return this.f20200a;
    }
}
