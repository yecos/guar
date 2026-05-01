package z8;

import com.google.common.base.MoreObjects;

/* loaded from: classes3.dex */
public abstract class l0 extends y8.r0 {

    /* renamed from: a, reason: collision with root package name */
    public final y8.r0 f20713a;

    public l0(y8.r0 r0Var) {
        this.f20713a = r0Var;
    }

    @Override // y8.d
    public String a() {
        return this.f20713a.a();
    }

    @Override // y8.d
    public y8.g h(y8.w0 w0Var, y8.c cVar) {
        return this.f20713a.h(w0Var, cVar);
    }

    public String toString() {
        return MoreObjects.toStringHelper(this).add("delegate", this.f20713a).toString();
    }
}
