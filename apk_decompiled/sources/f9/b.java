package f9;

import com.google.common.base.MoreObjects;
import java.util.concurrent.ScheduledExecutorService;
import y8.o0;
import y8.o1;

/* loaded from: classes3.dex */
public abstract class b extends o0.d {
    @Override // y8.o0.d
    public o0.h a(o0.b bVar) {
        return g().a(bVar);
    }

    @Override // y8.o0.d
    public y8.f b() {
        return g().b();
    }

    @Override // y8.o0.d
    public ScheduledExecutorService c() {
        return g().c();
    }

    @Override // y8.o0.d
    public o1 d() {
        return g().d();
    }

    @Override // y8.o0.d
    public void e() {
        g().e();
    }

    public abstract o0.d g();

    public String toString() {
        return MoreObjects.toStringHelper(this).add("delegate", g()).toString();
    }
}
