package z3;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;

/* loaded from: classes.dex */
public class l implements Serializable {

    /* renamed from: b, reason: collision with root package name */
    public static final l f20186b;

    /* renamed from: c, reason: collision with root package name */
    public static final l f20187c;

    /* renamed from: d, reason: collision with root package name */
    public static final l f20188d;

    /* renamed from: a, reason: collision with root package name */
    public final boolean f20189a;

    static {
        l lVar = new l(false);
        f20186b = lVar;
        f20187c = new l(true);
        f20188d = lVar;
    }

    public l(boolean z10) {
        this.f20189a = z10;
    }

    public a a() {
        return new a(this);
    }

    public d b(byte[] bArr) {
        return d.v(bArr);
    }

    public e c(boolean z10) {
        return z10 ? e.w() : e.v();
    }

    public p d() {
        return p.v();
    }

    public q e(double d10) {
        return h.A(d10);
    }

    public q f(float f10) {
        return i.A(f10);
    }

    public q g(int i10) {
        return j.A(i10);
    }

    public q h(long j10) {
        return n.A(j10);
    }

    public v i(BigDecimal bigDecimal) {
        return bigDecimal == null ? d() : this.f20189a ? g.A(bigDecimal) : bigDecimal.compareTo(BigDecimal.ZERO) == 0 ? g.f20172b : g.A(bigDecimal.stripTrailingZeros());
    }

    public v j(BigInteger bigInteger) {
        return bigInteger == null ? d() : c.A(bigInteger);
    }

    public r k() {
        return new r(this);
    }

    public v l(Object obj) {
        return new s(obj);
    }

    public v m(d4.u uVar) {
        return new s(uVar);
    }

    public t n(String str) {
        return t.w(str);
    }
}
