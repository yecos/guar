package kotlinx.coroutines.internal;

import h9.l;

/* loaded from: classes3.dex */
public abstract class i {

    /* renamed from: a, reason: collision with root package name */
    public static final boolean f15749a = false;

    static {
        Object a10;
        try {
            l.a aVar = h9.l.f14231a;
            a10 = h9.l.a(Class.forName("android.os.Build"));
        } catch (Throwable th) {
            l.a aVar2 = h9.l.f14231a;
            a10 = h9.l.a(h9.m.a(th));
        }
        h9.l.d(a10);
    }

    public static final boolean a() {
        return f15749a;
    }
}
