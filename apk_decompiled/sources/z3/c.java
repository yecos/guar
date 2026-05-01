package z3;

import c3.k;
import com.hpplay.sdk.source.mdns.xbill.dns.TTL;
import java.math.BigDecimal;
import java.math.BigInteger;
import k3.c0;

/* loaded from: classes.dex */
public class c extends q {

    /* renamed from: b, reason: collision with root package name */
    public static final BigInteger f20161b = BigInteger.valueOf(-2147483648L);

    /* renamed from: c, reason: collision with root package name */
    public static final BigInteger f20162c = BigInteger.valueOf(TTL.MAX_VALUE);

    /* renamed from: d, reason: collision with root package name */
    public static final BigInteger f20163d = BigInteger.valueOf(Long.MIN_VALUE);

    /* renamed from: e, reason: collision with root package name */
    public static final BigInteger f20164e = BigInteger.valueOf(Long.MAX_VALUE);

    /* renamed from: a, reason: collision with root package name */
    public final BigInteger f20165a;

    public c(BigInteger bigInteger) {
        this.f20165a = bigInteger;
    }

    public static c A(BigInteger bigInteger) {
        return new c(bigInteger);
    }

    @Override // z3.b, c3.v
    public k.b a() {
        return k.b.BIG_INTEGER;
    }

    @Override // z3.v, c3.v
    public c3.n b() {
        return c3.n.VALUE_NUMBER_INT;
    }

    @Override // z3.b, k3.n
    public final void d(c3.h hVar, c0 c0Var) {
        hVar.h0(this.f20165a);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj != null && (obj instanceof c)) {
            return ((c) obj).f20165a.equals(this.f20165a);
        }
        return false;
    }

    @Override // k3.m
    public String g() {
        return this.f20165a.toString();
    }

    @Override // k3.m
    public BigInteger h() {
        return this.f20165a;
    }

    public int hashCode() {
        return this.f20165a.hashCode();
    }

    @Override // k3.m
    public BigDecimal j() {
        return new BigDecimal(this.f20165a);
    }

    @Override // k3.m
    public double k() {
        return this.f20165a.doubleValue();
    }

    @Override // k3.m
    public Number t() {
        return this.f20165a;
    }

    @Override // z3.q
    public boolean v() {
        return this.f20165a.compareTo(f20161b) >= 0 && this.f20165a.compareTo(f20162c) <= 0;
    }

    @Override // z3.q
    public boolean w() {
        return this.f20165a.compareTo(f20163d) >= 0 && this.f20165a.compareTo(f20164e) <= 0;
    }

    @Override // z3.q
    public int x() {
        return this.f20165a.intValue();
    }

    @Override // z3.q
    public long z() {
        return this.f20165a.longValue();
    }
}
