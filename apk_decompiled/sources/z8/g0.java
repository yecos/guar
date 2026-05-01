package z8;

import com.google.common.base.Preconditions;
import z8.r;

/* loaded from: classes3.dex */
public class g0 implements s {

    /* renamed from: a, reason: collision with root package name */
    public final y8.k1 f20597a;

    /* renamed from: b, reason: collision with root package name */
    public final r.a f20598b;

    public g0(y8.k1 k1Var, r.a aVar) {
        Preconditions.checkArgument(!k1Var.p(), "error must not be OK");
        this.f20597a = k1Var;
        this.f20598b = aVar;
    }

    @Override // z8.s
    public q b(y8.w0 w0Var, y8.v0 v0Var, y8.c cVar, y8.k[] kVarArr) {
        return new f0(this.f20597a, this.f20598b, kVarArr);
    }

    @Override // y8.m0
    public y8.i0 d() {
        throw new UnsupportedOperationException("Not a real transport");
    }
}
