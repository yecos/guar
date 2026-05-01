package k9;

import k9.d;
import s9.p;
import t9.i;
import t9.j;

/* loaded from: classes3.dex */
public interface f {

    public static final class a {

        /* renamed from: k9.f$a$a, reason: collision with other inner class name */
        public static final class C0265a extends j implements p {

            /* renamed from: a, reason: collision with root package name */
            public static final C0265a f15707a = new C0265a();

            public C0265a() {
                super(2);
            }

            @Override // s9.p
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public final f invoke(f fVar, b bVar) {
                k9.c cVar;
                i.g(fVar, "acc");
                i.g(bVar, "element");
                f E = fVar.E(bVar.getKey());
                g gVar = g.f15708a;
                if (E == gVar) {
                    return bVar;
                }
                d.b bVar2 = d.f15705e0;
                d dVar = (d) E.a(bVar2);
                if (dVar == null) {
                    cVar = new k9.c(E, bVar);
                } else {
                    f E2 = E.E(bVar2);
                    if (E2 == gVar) {
                        return new k9.c(bVar, dVar);
                    }
                    cVar = new k9.c(new k9.c(E2, bVar), dVar);
                }
                return cVar;
            }
        }

        public static f a(f fVar, f fVar2) {
            i.g(fVar2, com.umeng.analytics.pro.f.X);
            return fVar2 == g.f15708a ? fVar : (f) fVar2.m(fVar, C0265a.f15707a);
        }
    }

    public interface b extends f {

        public static final class a {
            public static Object a(b bVar, Object obj, p pVar) {
                i.g(pVar, "operation");
                return pVar.invoke(obj, bVar);
            }

            public static b b(b bVar, c cVar) {
                i.g(cVar, "key");
                if (!i.b(bVar.getKey(), cVar)) {
                    return null;
                }
                i.e(bVar, "null cannot be cast to non-null type E of kotlin.coroutines.CoroutineContext.Element.get");
                return bVar;
            }

            public static f c(b bVar, c cVar) {
                i.g(cVar, "key");
                return i.b(bVar.getKey(), cVar) ? g.f15708a : bVar;
            }

            public static f d(b bVar, f fVar) {
                i.g(fVar, com.umeng.analytics.pro.f.X);
                return a.a(bVar, fVar);
            }
        }

        @Override // k9.f
        b a(c cVar);

        c getKey();
    }

    public interface c {
    }

    f E(c cVar);

    b a(c cVar);

    Object m(Object obj, p pVar);

    f s(f fVar);
}
