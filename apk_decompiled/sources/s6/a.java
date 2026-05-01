package s6;

import t9.i;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f18777a = new a();

    /* renamed from: b, reason: collision with root package name */
    public static b f18778b;

    public final b a() {
        b bVar = f18778b;
        if (bVar == null) {
            throw new NullPointerException("请设置： ProductAdapter");
        }
        i.d(bVar);
        return bVar;
    }

    public final void b(b bVar) {
        i.g(bVar, "adapter");
        f18778b = bVar;
    }
}
