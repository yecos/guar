package kotlinx.coroutines.internal;

import ca.p1;
import java.util.Iterator;
import java.util.List;
import java.util.ServiceLoader;

/* loaded from: classes3.dex */
public final class r {

    /* renamed from: a, reason: collision with root package name */
    public static final r f15772a;

    /* renamed from: b, reason: collision with root package name */
    public static final boolean f15773b = false;

    /* renamed from: c, reason: collision with root package name */
    public static final p1 f15774c;

    static {
        r rVar = new r();
        f15772a = rVar;
        z.e("kotlinx.coroutines.fast.service.loader", true);
        f15774c = rVar.a();
    }

    public final p1 a() {
        Object next;
        p1 e10;
        try {
            List c10 = f15773b ? h.f15748a.c() : aa.g.f(aa.e.a(ServiceLoader.load(q.class, q.class.getClassLoader()).iterator()));
            Iterator it = c10.iterator();
            if (it.hasNext()) {
                next = it.next();
                if (it.hasNext()) {
                    int c11 = ((q) next).c();
                    do {
                        Object next2 = it.next();
                        int c12 = ((q) next2).c();
                        if (c11 < c12) {
                            next = next2;
                            c11 = c12;
                        }
                    } while (it.hasNext());
                }
            } else {
                next = null;
            }
            q qVar = (q) next;
            return (qVar == null || (e10 = s.e(qVar, c10)) == null) ? s.b(null, null, 3, null) : e10;
        } catch (Throwable th) {
            return s.b(th, null, 2, null);
        }
    }
}
