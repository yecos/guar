package ca;

import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* loaded from: classes3.dex */
public abstract class q0 extends y {

    /* renamed from: c, reason: collision with root package name */
    public long f5790c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f5791d;

    /* renamed from: e, reason: collision with root package name */
    public kotlinx.coroutines.internal.a f5792e;

    public static /* synthetic */ void T(q0 q0Var, boolean z10, int i10, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: incrementUseCount");
        }
        if ((i10 & 1) != 0) {
            z10 = false;
        }
        q0Var.S(z10);
    }

    public final void O(boolean z10) {
        long P = this.f5790c - P(z10);
        this.f5790c = P;
        if (P <= 0 && this.f5791d) {
            shutdown();
        }
    }

    public final long P(boolean z10) {
        if (z10) {
            return IjkMediaMeta.AV_CH_WIDE_RIGHT;
        }
        return 1L;
    }

    public final void Q(l0 l0Var) {
        kotlinx.coroutines.internal.a aVar = this.f5792e;
        if (aVar == null) {
            aVar = new kotlinx.coroutines.internal.a();
            this.f5792e = aVar;
        }
        aVar.a(l0Var);
    }

    public long R() {
        kotlinx.coroutines.internal.a aVar = this.f5792e;
        return (aVar == null || aVar.c()) ? Long.MAX_VALUE : 0L;
    }

    public final void S(boolean z10) {
        this.f5790c += P(z10);
        if (z10) {
            return;
        }
        this.f5791d = true;
    }

    public final boolean U() {
        return this.f5790c >= P(true);
    }

    public final boolean V() {
        kotlinx.coroutines.internal.a aVar = this.f5792e;
        if (aVar != null) {
            return aVar.c();
        }
        return true;
    }

    public final boolean W() {
        l0 l0Var;
        kotlinx.coroutines.internal.a aVar = this.f5792e;
        if (aVar == null || (l0Var = (l0) aVar.d()) == null) {
            return false;
        }
        l0Var.run();
        return true;
    }

    public abstract void shutdown();
}
