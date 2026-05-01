package xa;

/* loaded from: classes.dex */
public final class n {

    /* renamed from: a, reason: collision with root package name */
    public final Object f19659a;

    /* renamed from: b, reason: collision with root package name */
    public final l f19660b;

    /* renamed from: c, reason: collision with root package name */
    public volatile boolean f19661c = true;

    public n(Object obj, l lVar) {
        this.f19659a = obj;
        this.f19660b = lVar;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof n)) {
            return false;
        }
        n nVar = (n) obj;
        return this.f19659a == nVar.f19659a && this.f19660b.equals(nVar.f19660b);
    }

    public int hashCode() {
        return this.f19659a.hashCode() + this.f19660b.f19646f.hashCode();
    }
}
