package z8;

import com.google.common.base.Preconditions;
import z8.r;

/* loaded from: classes3.dex */
public final class f0 extends n1 {

    /* renamed from: b, reason: collision with root package name */
    public boolean f20458b;

    /* renamed from: c, reason: collision with root package name */
    public final y8.k1 f20459c;

    /* renamed from: d, reason: collision with root package name */
    public final r.a f20460d;

    /* renamed from: e, reason: collision with root package name */
    public final y8.k[] f20461e;

    public f0(y8.k1 k1Var, y8.k[] kVarArr) {
        this(k1Var, r.a.PROCESSED, kVarArr);
    }

    @Override // z8.n1, z8.q
    public void g(r rVar) {
        Preconditions.checkState(!this.f20458b, "already started");
        this.f20458b = true;
        for (y8.k kVar : this.f20461e) {
            kVar.i(this.f20459c);
        }
        rVar.c(this.f20459c, this.f20460d, new y8.v0());
    }

    @Override // z8.n1, z8.q
    public void p(w0 w0Var) {
        w0Var.b("error", this.f20459c).b("progress", this.f20460d);
    }

    public f0(y8.k1 k1Var, r.a aVar, y8.k[] kVarArr) {
        Preconditions.checkArgument(!k1Var.p(), "error must not be OK");
        this.f20459c = k1Var;
        this.f20460d = aVar;
        this.f20461e = kVarArr;
    }
}
