package q0;

/* loaded from: classes.dex */
public abstract class b extends k {
    public b(e eVar) {
        super(eVar);
    }

    public abstract void g(t0.f fVar, Object obj);

    public final void h(Object obj) {
        t0.f a10 = a();
        try {
            g(a10, obj);
            a10.executeInsert();
        } finally {
            f(a10);
        }
    }
}
