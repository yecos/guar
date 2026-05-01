package z8;

import com.google.common.base.Charsets;
import com.google.common.base.Preconditions;
import java.nio.charset.Charset;
import y8.j0;
import y8.v0;
import z8.a;

/* loaded from: classes3.dex */
public abstract class t0 extends a.c {

    /* renamed from: w, reason: collision with root package name */
    public static final j0.a f20926w;

    /* renamed from: x, reason: collision with root package name */
    public static final v0.g f20927x;

    /* renamed from: s, reason: collision with root package name */
    public y8.k1 f20928s;

    /* renamed from: t, reason: collision with root package name */
    public y8.v0 f20929t;

    /* renamed from: u, reason: collision with root package name */
    public Charset f20930u;

    /* renamed from: v, reason: collision with root package name */
    public boolean f20931v;

    public class a implements j0.a {
        @Override // y8.v0.j
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public Integer b(byte[] bArr) {
            if (bArr.length >= 3) {
                return Integer.valueOf(((bArr[0] - 48) * 100) + ((bArr[1] - 48) * 10) + (bArr[2] - 48));
            }
            throw new NumberFormatException("Malformed status code " + new String(bArr, y8.j0.f19878a));
        }

        @Override // y8.v0.j
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public byte[] a(Integer num) {
            throw new UnsupportedOperationException();
        }
    }

    static {
        a aVar = new a();
        f20926w = aVar;
        f20927x = y8.j0.b(":status", aVar);
    }

    public t0(int i10, g2 g2Var, m2 m2Var) {
        super(i10, g2Var, m2Var);
        this.f20930u = Charsets.UTF_8;
    }

    public static Charset O(y8.v0 v0Var) {
        String str = (String) v0Var.g(q0.f20842j);
        if (str != null) {
            try {
                return Charset.forName(str.split("charset=", 2)[r2.length - 1].trim());
            } catch (Exception unused) {
            }
        }
        return Charsets.UTF_8;
    }

    public static void R(y8.v0 v0Var) {
        v0Var.e(f20927x);
        v0Var.e(y8.l0.f19935b);
        v0Var.e(y8.l0.f19934a);
    }

    public abstract void P(y8.k1 k1Var, boolean z10, y8.v0 v0Var);

    public final y8.k1 Q(y8.v0 v0Var) {
        y8.k1 k1Var = (y8.k1) v0Var.g(y8.l0.f19935b);
        if (k1Var != null) {
            return k1Var.r((String) v0Var.g(y8.l0.f19934a));
        }
        if (this.f20931v) {
            return y8.k1.f19891h.r("missing GRPC status in response");
        }
        Integer num = (Integer) v0Var.g(f20927x);
        return (num != null ? q0.l(num.intValue()) : y8.k1.f19903t.r("missing HTTP status code")).f("missing GRPC status, inferred error from HTTP status code");
    }

    public void S(t1 t1Var, boolean z10) {
        y8.k1 k1Var = this.f20928s;
        if (k1Var != null) {
            this.f20928s = k1Var.f("DATA-----------------------------\n" + u1.e(t1Var, this.f20930u));
            t1Var.close();
            if (this.f20928s.o().length() > 1000 || z10) {
                P(this.f20928s, false, this.f20929t);
                return;
            }
            return;
        }
        if (!this.f20931v) {
            P(y8.k1.f19903t.r("headers not received before payload"), false, new y8.v0());
            return;
        }
        int h10 = t1Var.h();
        D(t1Var);
        if (z10) {
            if (h10 > 0) {
                this.f20928s = y8.k1.f19903t.r("Received unexpected EOS on non-empty DATA frame from server");
            } else {
                this.f20928s = y8.k1.f19903t.r("Received unexpected EOS on empty DATA frame from server");
            }
            y8.v0 v0Var = new y8.v0();
            this.f20929t = v0Var;
            N(this.f20928s, false, v0Var);
        }
    }

    /* JADX WARN: Finally extract failed */
    public void T(y8.v0 v0Var) {
        Preconditions.checkNotNull(v0Var, "headers");
        y8.k1 k1Var = this.f20928s;
        if (k1Var != null) {
            this.f20928s = k1Var.f("headers: " + v0Var);
            return;
        }
        try {
            if (this.f20931v) {
                y8.k1 r10 = y8.k1.f19903t.r("Received headers twice");
                this.f20928s = r10;
                if (r10 != null) {
                    this.f20928s = r10.f("headers: " + v0Var);
                    this.f20929t = v0Var;
                    this.f20930u = O(v0Var);
                    return;
                }
                return;
            }
            Integer num = (Integer) v0Var.g(f20927x);
            if (num != null && num.intValue() >= 100 && num.intValue() < 200) {
                y8.k1 k1Var2 = this.f20928s;
                if (k1Var2 != null) {
                    this.f20928s = k1Var2.f("headers: " + v0Var);
                    this.f20929t = v0Var;
                    this.f20930u = O(v0Var);
                    return;
                }
                return;
            }
            this.f20931v = true;
            y8.k1 V = V(v0Var);
            this.f20928s = V;
            if (V != null) {
                if (V != null) {
                    this.f20928s = V.f("headers: " + v0Var);
                    this.f20929t = v0Var;
                    this.f20930u = O(v0Var);
                    return;
                }
                return;
            }
            R(v0Var);
            E(v0Var);
            y8.k1 k1Var3 = this.f20928s;
            if (k1Var3 != null) {
                this.f20928s = k1Var3.f("headers: " + v0Var);
                this.f20929t = v0Var;
                this.f20930u = O(v0Var);
            }
        } catch (Throwable th) {
            y8.k1 k1Var4 = this.f20928s;
            if (k1Var4 != null) {
                this.f20928s = k1Var4.f("headers: " + v0Var);
                this.f20929t = v0Var;
                this.f20930u = O(v0Var);
            }
            throw th;
        }
    }

    public void U(y8.v0 v0Var) {
        Preconditions.checkNotNull(v0Var, "trailers");
        if (this.f20928s == null && !this.f20931v) {
            y8.k1 V = V(v0Var);
            this.f20928s = V;
            if (V != null) {
                this.f20929t = v0Var;
            }
        }
        y8.k1 k1Var = this.f20928s;
        if (k1Var == null) {
            y8.k1 Q = Q(v0Var);
            R(v0Var);
            F(v0Var, Q);
        } else {
            y8.k1 f10 = k1Var.f("trailers: " + v0Var);
            this.f20928s = f10;
            P(f10, false, this.f20929t);
        }
    }

    public final y8.k1 V(y8.v0 v0Var) {
        Integer num = (Integer) v0Var.g(f20927x);
        if (num == null) {
            return y8.k1.f19903t.r("Missing HTTP status code");
        }
        String str = (String) v0Var.g(q0.f20842j);
        if (q0.m(str)) {
            return null;
        }
        return q0.l(num.intValue()).f("invalid content-type: " + str);
    }

    @Override // z8.a.c, z8.k1.b
    public /* bridge */ /* synthetic */ void e(boolean z10) {
        super.e(z10);
    }
}
