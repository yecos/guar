package z8;

import java.io.Closeable;
import z8.i2;
import z8.k1;

/* loaded from: classes3.dex */
public final class f2 extends k0 {

    /* renamed from: a, reason: collision with root package name */
    public final k1.b f20586a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f20587b;

    public f2(k1.b bVar) {
        this.f20586a = bVar;
    }

    @Override // z8.k0, z8.k1.b
    public void a(i2.a aVar) {
        if (!this.f20587b) {
            super.a(aVar);
        } else if (aVar instanceof Closeable) {
            q0.d((Closeable) aVar);
        }
    }

    @Override // z8.k0
    public k1.b b() {
        return this.f20586a;
    }

    @Override // z8.k0, z8.k1.b
    public void d(Throwable th) {
        this.f20587b = true;
        super.d(th);
    }

    @Override // z8.k0, z8.k1.b
    public void e(boolean z10) {
        this.f20587b = true;
        super.e(z10);
    }
}
