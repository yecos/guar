package b4;

import b3.k0;
import k3.x;

/* loaded from: classes.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name */
    public final k3.j f4605a;

    /* renamed from: b, reason: collision with root package name */
    public final c3.q f4606b;

    /* renamed from: c, reason: collision with root package name */
    public final k0 f4607c;

    /* renamed from: d, reason: collision with root package name */
    public final k3.o f4608d;

    /* renamed from: e, reason: collision with root package name */
    public final boolean f4609e;

    public i(k3.j jVar, c3.q qVar, k0 k0Var, k3.o oVar, boolean z10) {
        this.f4605a = jVar;
        this.f4606b = qVar;
        this.f4607c = k0Var;
        this.f4608d = oVar;
        this.f4609e = z10;
    }

    public static i a(k3.j jVar, x xVar, k0 k0Var, boolean z10) {
        String c10 = xVar == null ? null : xVar.c();
        return new i(jVar, c10 != null ? new f3.i(c10) : null, k0Var, null, z10);
    }

    public i b(boolean z10) {
        return z10 == this.f4609e ? this : new i(this.f4605a, this.f4606b, this.f4607c, this.f4608d, z10);
    }

    public i c(k3.o oVar) {
        return new i(this.f4605a, this.f4606b, this.f4607c, oVar, this.f4609e);
    }
}
