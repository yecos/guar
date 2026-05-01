package xa;

/* loaded from: classes.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name */
    public h f19635a;

    /* renamed from: b, reason: collision with root package name */
    public h f19636b;

    public synchronized void a(h hVar) {
        try {
            if (hVar == null) {
                throw new NullPointerException("null cannot be enqueued");
            }
            h hVar2 = this.f19636b;
            if (hVar2 != null) {
                hVar2.f19634c = hVar;
                this.f19636b = hVar;
            } else {
                if (this.f19635a != null) {
                    throw new IllegalStateException("Head present, but no tail");
                }
                this.f19636b = hVar;
                this.f19635a = hVar;
            }
            notifyAll();
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized h b() {
        h hVar;
        hVar = this.f19635a;
        if (hVar != null) {
            h hVar2 = hVar.f19634c;
            this.f19635a = hVar2;
            if (hVar2 == null) {
                this.f19636b = null;
            }
        }
        return hVar;
    }

    public synchronized h c(int i10) {
        if (this.f19635a == null) {
            wait(i10);
        }
        return b();
    }
}
