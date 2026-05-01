package z8;

/* loaded from: classes3.dex */
public abstract class x implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final y8.r f20978a;

    public x(y8.r rVar) {
        this.f20978a = rVar;
    }

    public abstract void a();

    @Override // java.lang.Runnable
    public final void run() {
        y8.r b10 = this.f20978a.b();
        try {
            a();
        } finally {
            this.f20978a.f(b10);
        }
    }
}
