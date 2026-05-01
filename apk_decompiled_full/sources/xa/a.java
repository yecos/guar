package xa;

/* loaded from: classes.dex */
public class a implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final i f19581a = new i();

    /* renamed from: b, reason: collision with root package name */
    public final c f19582b;

    public a(c cVar) {
        this.f19582b = cVar;
    }

    public void a(n nVar, Object obj) {
        this.f19581a.a(h.a(nVar, obj));
        this.f19582b.d().execute(this);
    }

    @Override // java.lang.Runnable
    public void run() {
        h b10 = this.f19581a.b();
        if (b10 == null) {
            throw new IllegalStateException("No pending post available");
        }
        this.f19582b.f(b10);
    }
}
