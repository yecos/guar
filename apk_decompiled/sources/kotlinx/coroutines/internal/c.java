package kotlinx.coroutines.internal;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* loaded from: classes3.dex */
public abstract class c extends u {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f15727a = AtomicReferenceFieldUpdater.newUpdater(c.class, Object.class, "_consensus");
    private volatile /* synthetic */ Object _consensus = b.f15725a;

    @Override // kotlinx.coroutines.internal.u
    public c a() {
        return this;
    }

    @Override // kotlinx.coroutines.internal.u
    public final Object c(Object obj) {
        Object obj2 = this._consensus;
        if (obj2 == b.f15725a) {
            obj2 = e(g(obj));
        }
        d(obj, obj2);
        return obj2;
    }

    public abstract void d(Object obj, Object obj2);

    public final Object e(Object obj) {
        Object obj2 = this._consensus;
        Object obj3 = b.f15725a;
        return obj2 != obj3 ? obj2 : androidx.concurrent.futures.b.a(f15727a, this, obj3, obj) ? obj : this._consensus;
    }

    public long f() {
        return 0L;
    }

    public abstract Object g(Object obj);
}
