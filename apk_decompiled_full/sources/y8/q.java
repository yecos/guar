package y8;

import com.google.common.base.Preconditions;

/* loaded from: classes3.dex */
public final class q {

    /* renamed from: a, reason: collision with root package name */
    public final p f19994a;

    /* renamed from: b, reason: collision with root package name */
    public final k1 f19995b;

    public q(p pVar, k1 k1Var) {
        this.f19994a = (p) Preconditions.checkNotNull(pVar, "state is null");
        this.f19995b = (k1) Preconditions.checkNotNull(k1Var, "status is null");
    }

    public static q a(p pVar) {
        Preconditions.checkArgument(pVar != p.TRANSIENT_FAILURE, "state is TRANSIENT_ERROR. Use forError() instead");
        return new q(pVar, k1.f19889f);
    }

    public static q b(k1 k1Var) {
        Preconditions.checkArgument(!k1Var.p(), "The error status must not be OK");
        return new q(p.TRANSIENT_FAILURE, k1Var);
    }

    public p c() {
        return this.f19994a;
    }

    public k1 d() {
        return this.f19995b;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof q)) {
            return false;
        }
        q qVar = (q) obj;
        return this.f19994a.equals(qVar.f19994a) && this.f19995b.equals(qVar.f19995b);
    }

    public int hashCode() {
        return this.f19994a.hashCode() ^ this.f19995b.hashCode();
    }

    public String toString() {
        if (this.f19995b.p()) {
            return this.f19994a.toString();
        }
        return this.f19994a + "(" + this.f19995b + ")";
    }
}
