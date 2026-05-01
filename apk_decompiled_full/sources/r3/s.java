package r3;

import b3.r;
import java.util.Iterator;
import k3.b;

/* loaded from: classes.dex */
public abstract class s implements d4.r {

    /* renamed from: a, reason: collision with root package name */
    public static final r.b f18483a = r.b.c();

    public abstract boolean A();

    public abstract boolean B();

    public abstract boolean C();

    public boolean D() {
        return false;
    }

    public abstract k3.x c();

    public boolean e() {
        return q() != null;
    }

    public boolean f() {
        return l() != null;
    }

    public abstract r.b g();

    public abstract k3.w getMetadata();

    @Override // d4.r
    public abstract String getName();

    public b0 h() {
        return null;
    }

    public String i() {
        b.a j10 = j();
        if (j10 == null) {
            return null;
        }
        return j10.b();
    }

    public b.a j() {
        return null;
    }

    public Class[] k() {
        return null;
    }

    public i l() {
        j p10 = p();
        return p10 == null ? o() : p10;
    }

    public abstract m m();

    public abstract Iterator n();

    public abstract g o();

    public abstract j p();

    public i q() {
        m m10 = m();
        if (m10 != null) {
            return m10;
        }
        j v10 = v();
        return v10 == null ? o() : v10;
    }

    public i r() {
        j v10 = v();
        return v10 == null ? o() : v10;
    }

    public abstract i s();

    public abstract k3.j t();

    public abstract Class u();

    public abstract j v();

    public abstract k3.x w();

    public abstract boolean x();

    public abstract boolean y();

    public abstract boolean z(k3.x xVar);
}
