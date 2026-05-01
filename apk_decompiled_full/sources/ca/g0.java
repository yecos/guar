package ca;

import h9.l;
import kotlin.coroutines.Continuation;

/* loaded from: classes3.dex */
public abstract class g0 {
    public static final String a(Object obj) {
        return obj.getClass().getSimpleName();
    }

    public static final String b(Object obj) {
        return Integer.toHexString(System.identityHashCode(obj));
    }

    public static final String c(Continuation continuation) {
        Object a10;
        if (continuation instanceof kotlinx.coroutines.internal.f) {
            return continuation.toString();
        }
        try {
            l.a aVar = h9.l.f14231a;
            a10 = h9.l.a(continuation + '@' + b(continuation));
        } catch (Throwable th) {
            l.a aVar2 = h9.l.f14231a;
            a10 = h9.l.a(h9.m.a(th));
        }
        if (h9.l.b(a10) != null) {
            a10 = continuation.getClass().getName() + '@' + b(continuation);
        }
        return (String) a10;
    }
}
