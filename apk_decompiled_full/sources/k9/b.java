package k9;

import k9.f;
import s9.l;
import t9.i;

/* loaded from: classes3.dex */
public abstract class b implements f.c {

    /* renamed from: a, reason: collision with root package name */
    public final l f15700a;

    /* renamed from: b, reason: collision with root package name */
    public final f.c f15701b;

    public b(f.c cVar, l lVar) {
        i.g(cVar, "baseKey");
        i.g(lVar, "safeCast");
        this.f15700a = lVar;
        this.f15701b = cVar instanceof b ? ((b) cVar).f15701b : cVar;
    }

    public final boolean a(f.c cVar) {
        i.g(cVar, "key");
        return cVar == this || this.f15701b == cVar;
    }

    public final f.b b(f.b bVar) {
        i.g(bVar, "element");
        return (f.b) this.f15700a.invoke(bVar);
    }
}
