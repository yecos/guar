package d4;

/* loaded from: classes.dex */
public final class o {

    /* renamed from: a, reason: collision with root package name */
    public final Object f12557a;

    /* renamed from: b, reason: collision with root package name */
    public o f12558b;

    public o(Object obj, o oVar) {
        this.f12557a = obj;
        this.f12558b = oVar;
    }

    public void a(o oVar) {
        if (this.f12558b != null) {
            throw new IllegalStateException();
        }
        this.f12558b = oVar;
    }

    public o b() {
        return this.f12558b;
    }

    public Object c() {
        return this.f12557a;
    }
}
