package ca;

import kotlin.coroutines.Continuation;

/* loaded from: classes3.dex */
public abstract class a extends m1 implements Continuation, c0 {

    /* renamed from: b, reason: collision with root package name */
    public final k9.f f5734b;

    public a(k9.f fVar, boolean z10, boolean z11) {
        super(z11);
        if (z10) {
            R((f1) fVar.a(f1.f5750a0));
        }
        this.f5734b = fVar.s(this);
    }

    @Override // ca.m1
    public final void Q(Throwable th) {
        b0.a(this.f5734b, th);
    }

    @Override // ca.m1
    public String X() {
        String b10 = x.b(this.f5734b);
        if (b10 == null) {
            return super.X();
        }
        return '\"' + b10 + "\":" + super.X();
    }

    @Override // ca.m1
    public final void c0(Object obj) {
        if (!(obj instanceof s)) {
            u0(obj);
        } else {
            s sVar = (s) obj;
            t0(sVar.f5802a, sVar.a());
        }
    }

    @Override // ca.c0
    public k9.f d() {
        return this.f5734b;
    }

    @Override // kotlin.coroutines.Continuation
    public final k9.f getContext() {
        return this.f5734b;
    }

    @Override // ca.m1, ca.f1
    public boolean isActive() {
        return super.isActive();
    }

    @Override // kotlin.coroutines.Continuation
    public final void resumeWith(Object obj) {
        Object V = V(w.c(obj, null, 1, null));
        if (V == n1.f5781b) {
            return;
        }
        s0(V);
    }

    public void s0(Object obj) {
        l(obj);
    }

    public void t0(Throwable th, boolean z10) {
    }

    public void u0(Object obj) {
    }

    public final void v0(e0 e0Var, Object obj, s9.p pVar) {
        e0Var.b(pVar, obj, this);
    }

    @Override // ca.m1
    public String w() {
        return g0.a(this) + " was cancelled";
    }
}
