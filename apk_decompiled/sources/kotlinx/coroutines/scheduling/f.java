package kotlinx.coroutines.scheduling;

import ca.w0;

/* loaded from: classes3.dex */
public abstract class f extends w0 {

    /* renamed from: d, reason: collision with root package name */
    public final int f15811d;

    /* renamed from: e, reason: collision with root package name */
    public final int f15812e;

    /* renamed from: f, reason: collision with root package name */
    public final long f15813f;

    /* renamed from: g, reason: collision with root package name */
    public final String f15814g;

    /* renamed from: h, reason: collision with root package name */
    public a f15815h = O();

    public f(int i10, int i11, long j10, String str) {
        this.f15811d = i10;
        this.f15812e = i11;
        this.f15813f = j10;
        this.f15814g = str;
    }

    @Override // ca.y
    public void L(k9.f fVar, Runnable runnable) {
        a.m(this.f15815h, runnable, null, false, 6, null);
    }

    public final a O() {
        return new a(this.f15811d, this.f15812e, this.f15813f, this.f15814g);
    }

    public final void P(Runnable runnable, i iVar, boolean z10) {
        this.f15815h.f(runnable, iVar, z10);
    }
}
