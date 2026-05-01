package kotlinx.coroutines.scheduling;

import ca.w0;
import ca.y;
import java.util.concurrent.Executor;
import kotlinx.coroutines.internal.b0;
import kotlinx.coroutines.internal.z;

/* loaded from: classes3.dex */
public final class b extends w0 implements Executor {

    /* renamed from: d, reason: collision with root package name */
    public static final b f15807d = new b();

    /* renamed from: e, reason: collision with root package name */
    public static final y f15808e;

    static {
        int d10;
        m mVar = m.f15827c;
        d10 = b0.d("kotlinx.coroutines.io.parallelism", y9.e.a(64, z.a()), 0, 0, 12, null);
        f15808e = mVar.N(d10);
    }

    @Override // ca.y
    public void L(k9.f fVar, Runnable runnable) {
        f15808e.L(fVar, runnable);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        throw new IllegalStateException("Cannot be invoked on Dispatchers.IO".toString());
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        L(k9.g.f15708a, runnable);
    }

    @Override // ca.y
    public String toString() {
        return "Dispatchers.IO";
    }
}
