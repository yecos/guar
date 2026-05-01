package ca;

/* loaded from: classes3.dex */
public final class c1 extends h {

    /* renamed from: a, reason: collision with root package name */
    public final s9.l f5738a;

    public c1(s9.l lVar) {
        this.f5738a = lVar;
    }

    @Override // ca.i
    public void b(Throwable th) {
        this.f5738a.invoke(th);
    }

    @Override // s9.l
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        b((Throwable) obj);
        return h9.t.f14242a;
    }

    public String toString() {
        return "InvokeOnCancel[" + g0.a(this.f5738a) + '@' + g0.b(this) + ']';
    }
}
