package z8;

import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import y8.y0;

/* loaded from: classes3.dex */
public abstract class m0 extends y8.y0 {

    /* renamed from: a, reason: collision with root package name */
    public final y8.y0 f20737a;

    public m0(y8.y0 y0Var) {
        Preconditions.checkNotNull(y0Var, "delegate can not be null");
        this.f20737a = y0Var;
    }

    @Override // y8.y0
    public void b() {
        this.f20737a.b();
    }

    @Override // y8.y0
    public void c() {
        this.f20737a.c();
    }

    @Override // y8.y0
    public void d(y0.d dVar) {
        this.f20737a.d(dVar);
    }

    public String toString() {
        return MoreObjects.toStringHelper(this).add("delegate", this.f20737a).toString();
    }
}
