package aa;

import java.util.Iterator;
import java.util.concurrent.atomic.AtomicReference;
import t9.i;

/* loaded from: classes3.dex */
public final class a implements b {

    /* renamed from: a, reason: collision with root package name */
    public final AtomicReference f481a;

    public a(b bVar) {
        i.g(bVar, "sequence");
        this.f481a = new AtomicReference(bVar);
    }

    @Override // aa.b
    public Iterator iterator() {
        b bVar = (b) this.f481a.getAndSet(null);
        if (bVar != null) {
            return bVar.iterator();
        }
        throw new IllegalStateException("This sequence can be consumed only once.");
    }
}
