package kotlinx.coroutines.internal;

import ca.g0;

/* loaded from: classes3.dex */
public abstract class u {
    public abstract c a();

    public final boolean b(u uVar) {
        c a10;
        c a11 = a();
        return (a11 == null || (a10 = uVar.a()) == null || a11.f() >= a10.f()) ? false : true;
    }

    public abstract Object c(Object obj);

    public String toString() {
        return g0.a(this) + '@' + g0.b(this);
    }
}
