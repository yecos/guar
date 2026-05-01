package kotlinx.coroutines.internal;

import ca.p1;
import java.util.List;

/* loaded from: classes3.dex */
public abstract class s {

    /* renamed from: a, reason: collision with root package name */
    public static final boolean f15775a = false;

    public static final t a(Throwable th, String str) {
        if (f15775a) {
            return new t(th, str);
        }
        if (th != null) {
            throw th;
        }
        d();
        throw new h9.c();
    }

    public static /* synthetic */ t b(Throwable th, String str, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            th = null;
        }
        if ((i10 & 2) != 0) {
            str = null;
        }
        return a(th, str);
    }

    public static final boolean c(p1 p1Var) {
        return p1Var.O() instanceof t;
    }

    public static final Void d() {
        throw new IllegalStateException("Module with the Main dispatcher is missing. Add dependency providing the Main dispatcher, e.g. 'kotlinx-coroutines-android' and ensure it has the same version as 'kotlinx-coroutines-core'");
    }

    public static final p1 e(q qVar, List list) {
        try {
            return qVar.b(list);
        } catch (Throwable th) {
            return a(th, qVar.a());
        }
    }
}
