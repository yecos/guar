package z8;

import z8.d2;

/* loaded from: classes3.dex */
public final class e2 implements o1 {

    /* renamed from: a, reason: collision with root package name */
    public final d2.d f20441a;

    public e2(d2.d dVar) {
        this.f20441a = dVar;
    }

    public static e2 c(d2.d dVar) {
        return new e2(dVar);
    }

    @Override // z8.o1
    public Object a() {
        return d2.d(this.f20441a);
    }

    @Override // z8.o1
    public Object b(Object obj) {
        d2.f(this.f20441a, obj);
        return null;
    }
}
