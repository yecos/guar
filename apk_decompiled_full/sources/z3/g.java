package z3;

import c3.k;
import com.hpplay.sdk.source.mdns.xbill.dns.TTL;
import java.math.BigDecimal;
import java.math.BigInteger;
import k3.c0;

/* loaded from: classes.dex */
public class g extends q {

    /* renamed from: b, reason: collision with root package name */
    public static final g f20172b = new g(BigDecimal.ZERO);

    /* renamed from: c, reason: collision with root package name */
    public static final BigDecimal f20173c = BigDecimal.valueOf(-2147483648L);

    /* renamed from: d, reason: collision with root package name */
    public static final BigDecimal f20174d = BigDecimal.valueOf(TTL.MAX_VALUE);

    /* renamed from: e, reason: collision with root package name */
    public static final BigDecimal f20175e = BigDecimal.valueOf(Long.MIN_VALUE);

    /* renamed from: f, reason: collision with root package name */
    public static final BigDecimal f20176f = BigDecimal.valueOf(Long.MAX_VALUE);

    /* renamed from: a, reason: collision with root package name */
    public final BigDecimal f20177a;

    public g(BigDecimal bigDecimal) {
        this.f20177a = bigDecimal;
    }

    public static g A(BigDecimal bigDecimal) {
        return new g(bigDecimal);
    }

    @Override // z3.b, c3.v
    public k.b a() {
        return k.b.BIG_DECIMAL;
    }

    @Override // z3.v, c3.v
    public c3.n b() {
        return c3.n.VALUE_NUMBER_FLOAT;
    }

    @Override // z3.b, k3.n
    public final void d(c3.h hVar, c0 c0Var) {
        hVar.g0(this.f20177a);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        return obj != null && (obj instanceof g) && ((g) obj).f20177a.compareTo(this.f20177a) == 0;
    }

    @Override // k3.m
    public String g() {
        return this.f20177a.toString();
    }

    @Override // k3.m
    public BigInteger h() {
        return this.f20177a.toBigInteger();
    }

    public int hashCode() {
        return Double.valueOf(k()).hashCode();
    }

    @Override // k3.m
    public BigDecimal j() {
        return this.f20177a;
    }

    @Override // k3.m
    public double k() {
        return this.f20177a.doubleValue();
    }

    @Override // k3.m
    public Number t() {
        return this.f20177a;
    }

    @Override // z3.q
    public boolean v() {
        return this.f20177a.compareTo(f20173c) >= 0 && this.f20177a.compareTo(f20174d) <= 0;
    }

    @Override // z3.q
    public boolean w() {
        return this.f20177a.compareTo(f20175e) >= 0 && this.f20177a.compareTo(f20176f) <= 0;
    }

    @Override // z3.q
    public int x() {
        return this.f20177a.intValue();
    }

    @Override // z3.q
    public long z() {
        return this.f20177a.longValue();
    }
}
