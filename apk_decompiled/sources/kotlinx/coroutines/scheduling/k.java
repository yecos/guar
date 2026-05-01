package kotlinx.coroutines.scheduling;

import ca.g0;

/* loaded from: classes3.dex */
public final class k extends h {

    /* renamed from: c, reason: collision with root package name */
    public final Runnable f15819c;

    public k(Runnable runnable, long j10, i iVar) {
        super(j10, iVar);
        this.f15819c = runnable;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            this.f15819c.run();
        } finally {
            this.f15817b.a();
        }
    }

    public String toString() {
        return "Task[" + g0.a(this.f15819c) + '@' + g0.b(this.f15819c) + ", " + this.f15816a + ", " + this.f15817b + ']';
    }
}
