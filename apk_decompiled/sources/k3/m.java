package k3;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Iterator;
import k3.n;

/* loaded from: classes.dex */
public abstract class m extends n.a implements c3.v, Iterable {
    public abstract String g();

    public BigInteger h() {
        return BigInteger.ZERO;
    }

    public byte[] i() {
        return null;
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        return l();
    }

    public BigDecimal j() {
        return BigDecimal.ZERO;
    }

    public double k() {
        return 0.0d;
    }

    public Iterator l() {
        return d4.h.n();
    }

    public Iterator m() {
        return d4.h.n();
    }

    public abstract m n(String str);

    public abstract z3.m o();

    public boolean p() {
        return false;
    }

    public final boolean q() {
        return o() == z3.m.BINARY;
    }

    public final boolean r() {
        return o() == z3.m.NUMBER;
    }

    public final boolean s() {
        return o() == z3.m.POJO;
    }

    public Number t() {
        return null;
    }

    public String u() {
        return null;
    }
}
