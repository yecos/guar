package h9;

import h9.l;

/* loaded from: classes3.dex */
public abstract class m {
    public static final Object a(Throwable th) {
        t9.i.g(th, "exception");
        return new l.b(th);
    }

    public static final void b(Object obj) {
        if (obj instanceof l.b) {
            throw ((l.b) obj).f14232a;
        }
    }
}
