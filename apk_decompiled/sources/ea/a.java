package ea;

import h9.l;
import h9.m;
import h9.t;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.internal.g;
import s9.p;

/* loaded from: classes3.dex */
public abstract class a {
    public static final void a(Continuation continuation, Throwable th) {
        l.a aVar = l.f14231a;
        continuation.resumeWith(l.a(m.a(th)));
        throw th;
    }

    public static final void b(Continuation continuation, Continuation continuation2) {
        try {
            Continuation b10 = l9.b.b(continuation);
            l.a aVar = l.f14231a;
            g.c(b10, l.a(t.f14242a), null, 2, null);
        } catch (Throwable th) {
            a(continuation2, th);
        }
    }

    public static final void c(p pVar, Object obj, Continuation continuation, s9.l lVar) {
        try {
            Continuation b10 = l9.b.b(l9.b.a(pVar, obj, continuation));
            l.a aVar = l.f14231a;
            g.b(b10, l.a(t.f14242a), lVar);
        } catch (Throwable th) {
            a(continuation, th);
        }
    }

    public static /* synthetic */ void d(p pVar, Object obj, Continuation continuation, s9.l lVar, int i10, Object obj2) {
        if ((i10 & 4) != 0) {
            lVar = null;
        }
        c(pVar, obj, continuation, lVar);
    }
}
