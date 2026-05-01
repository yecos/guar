package ca;

/* loaded from: classes3.dex */
public abstract class l1 extends u implements o0, a1 {

    /* renamed from: d, reason: collision with root package name */
    public m1 f5766d;

    @Override // ca.a1
    public q1 c() {
        return null;
    }

    @Override // ca.o0
    public void dispose() {
        r().g0(this);
    }

    @Override // ca.a1
    public boolean isActive() {
        return true;
    }

    public final m1 r() {
        m1 m1Var = this.f5766d;
        if (m1Var != null) {
            return m1Var;
        }
        t9.i.w("job");
        return null;
    }

    public final void s(m1 m1Var) {
        this.f5766d = m1Var;
    }

    @Override // kotlinx.coroutines.internal.n
    public String toString() {
        return g0.a(this) + '@' + g0.b(this) + "[job@" + g0.b(r()) + ']';
    }
}
