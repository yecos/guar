package z8;

import z8.i2;
import z8.k1;

/* loaded from: classes3.dex */
public abstract class k0 implements k1.b {
    @Override // z8.k1.b
    public void a(i2.a aVar) {
        b().a(aVar);
    }

    public abstract k1.b b();

    @Override // z8.k1.b
    public void c(int i10) {
        b().c(i10);
    }

    @Override // z8.k1.b
    public void d(Throwable th) {
        b().d(th);
    }

    @Override // z8.k1.b
    public void e(boolean z10) {
        b().e(z10);
    }
}
