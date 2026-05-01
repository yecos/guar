package z8;

import com.google.common.base.MoreObjects;
import z8.i2;
import z8.r;

/* loaded from: classes3.dex */
public abstract class i0 implements r {
    @Override // z8.i2
    public void a(i2.a aVar) {
        e().a(aVar);
    }

    @Override // z8.r
    public void b(y8.v0 v0Var) {
        e().b(v0Var);
    }

    @Override // z8.r
    public void c(y8.k1 k1Var, r.a aVar, y8.v0 v0Var) {
        e().c(k1Var, aVar, v0Var);
    }

    @Override // z8.i2
    public void d() {
        e().d();
    }

    public abstract r e();

    public String toString() {
        return MoreObjects.toStringHelper(this).add("delegate", e()).toString();
    }
}
