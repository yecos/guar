package y8;

import java.util.logging.Level;
import java.util.logging.Logger;
import y8.r;

/* loaded from: classes3.dex */
public final class p1 extends r.c {

    /* renamed from: a, reason: collision with root package name */
    public static final Logger f19992a = Logger.getLogger(p1.class.getName());

    /* renamed from: b, reason: collision with root package name */
    public static final ThreadLocal f19993b = new ThreadLocal();

    @Override // y8.r.c
    public r a() {
        r rVar = (r) f19993b.get();
        return rVar == null ? r.f20006c : rVar;
    }

    @Override // y8.r.c
    public void b(r rVar, r rVar2) {
        if (a() != rVar) {
            f19992a.log(Level.SEVERE, "Context was not attached when detaching", new Throwable().fillInStackTrace());
        }
        if (rVar2 != r.f20006c) {
            f19993b.set(rVar2);
        } else {
            f19993b.set(null);
        }
    }

    @Override // y8.r.c
    public r c(r rVar) {
        r a10 = a();
        f19993b.set(rVar);
        return a10;
    }
}
