package k9;

import k9.f;
import kotlin.coroutines.Continuation;
import t9.i;

/* loaded from: classes3.dex */
public interface d extends f.b {

    /* renamed from: e0, reason: collision with root package name */
    public static final b f15705e0 = b.f15706a;

    public static final class a {
        public static f.b a(d dVar, f.c cVar) {
            i.g(cVar, "key");
            if (!(cVar instanceof k9.b)) {
                if (d.f15705e0 != cVar) {
                    return null;
                }
                i.e(dVar, "null cannot be cast to non-null type E of kotlin.coroutines.ContinuationInterceptor.get");
                return dVar;
            }
            k9.b bVar = (k9.b) cVar;
            if (!bVar.a(dVar.getKey())) {
                return null;
            }
            f.b b10 = bVar.b(dVar);
            if (b10 instanceof f.b) {
                return b10;
            }
            return null;
        }

        public static f b(d dVar, f.c cVar) {
            i.g(cVar, "key");
            if (!(cVar instanceof k9.b)) {
                return d.f15705e0 == cVar ? g.f15708a : dVar;
            }
            k9.b bVar = (k9.b) cVar;
            return (!bVar.a(dVar.getKey()) || bVar.b(dVar) == null) ? dVar : g.f15708a;
        }
    }

    public static final class b implements f.c {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ b f15706a = new b();
    }

    void b(Continuation continuation);

    Continuation c(Continuation continuation);
}
