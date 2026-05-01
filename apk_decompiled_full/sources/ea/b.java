package ea;

import h9.l;
import h9.m;
import k9.f;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.internal.c0;
import l9.c;
import m9.g;
import s9.p;
import t9.a0;

/* loaded from: classes3.dex */
public abstract class b {
    public static final void a(p pVar, Object obj, Continuation continuation) {
        Continuation a10 = g.a(continuation);
        try {
            f context = continuation.getContext();
            Object c10 = c0.c(context, null);
            try {
                Object invoke = ((p) a0.c(pVar, 2)).invoke(obj, a10);
                if (invoke != c.c()) {
                    a10.resumeWith(l.a(invoke));
                }
            } finally {
                c0.a(context, c10);
            }
        } catch (Throwable th) {
            l.a aVar = l.f14231a;
            a10.resumeWith(l.a(m.a(th)));
        }
    }
}
