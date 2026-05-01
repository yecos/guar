package a0;

/* loaded from: classes.dex */
public class g extends f {

    /* renamed from: c, reason: collision with root package name */
    public final Object f76c;

    public g(int i10) {
        super(i10);
        this.f76c = new Object();
    }

    @Override // a0.f, a0.e
    public Object acquire() {
        Object acquire;
        synchronized (this.f76c) {
            acquire = super.acquire();
        }
        return acquire;
    }

    @Override // a0.f, a0.e
    public boolean release(Object obj) {
        boolean release;
        synchronized (this.f76c) {
            release = super.release(obj);
        }
        return release;
    }
}
