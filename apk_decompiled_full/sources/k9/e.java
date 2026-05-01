package k9;

import h9.l;
import h9.t;
import kotlin.coroutines.Continuation;
import s9.p;
import t9.i;

/* loaded from: classes3.dex */
public abstract class e {
    public static final void a(p pVar, Object obj, Continuation continuation) {
        i.g(pVar, "<this>");
        i.g(continuation, "completion");
        Continuation b10 = l9.b.b(l9.b.a(pVar, obj, continuation));
        l.a aVar = l.f14231a;
        b10.resumeWith(l.a(t.f14242a));
    }
}
