package n0;

import android.os.Bundle;

/* loaded from: classes.dex */
public final class o0 {

    /* renamed from: a, reason: collision with root package name */
    public final Bundle f16917a;

    /* renamed from: b, reason: collision with root package name */
    public s0 f16918b;

    public o0(s0 s0Var, boolean z10) {
        if (s0Var == null) {
            throw new IllegalArgumentException("selector must not be null");
        }
        Bundle bundle = new Bundle();
        this.f16917a = bundle;
        this.f16918b = s0Var;
        bundle.putBundle("selector", s0Var.a());
        bundle.putBoolean("activeScan", z10);
    }

    public Bundle a() {
        return this.f16917a;
    }

    public final void b() {
        if (this.f16918b == null) {
            s0 d10 = s0.d(this.f16917a.getBundle("selector"));
            this.f16918b = d10;
            if (d10 == null) {
                this.f16918b = s0.f17005c;
            }
        }
    }

    public s0 c() {
        b();
        return this.f16918b;
    }

    public boolean d() {
        return this.f16917a.getBoolean("activeScan");
    }

    public boolean e() {
        b();
        return this.f16918b.g();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof o0)) {
            return false;
        }
        o0 o0Var = (o0) obj;
        return c().equals(o0Var.c()) && d() == o0Var.d();
    }

    public int hashCode() {
        return c().hashCode() ^ d();
    }

    public String toString() {
        return "DiscoveryRequest{ selector=" + c() + ", activeScan=" + d() + ", isValid=" + e() + " }";
    }
}
