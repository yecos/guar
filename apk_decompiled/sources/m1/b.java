package m1;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executor;
import k1.k;

/* loaded from: classes.dex */
public class b implements m1.a {

    /* renamed from: a, reason: collision with root package name */
    public final k f16614a;

    /* renamed from: b, reason: collision with root package name */
    public final Handler f16615b = new Handler(Looper.getMainLooper());

    /* renamed from: c, reason: collision with root package name */
    public final Executor f16616c = new a();

    public class a implements Executor {
        public a() {
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            b.this.d(runnable);
        }
    }

    public b(Executor executor) {
        this.f16614a = new k(executor);
    }

    @Override // m1.a
    public Executor a() {
        return this.f16616c;
    }

    @Override // m1.a
    public void b(Runnable runnable) {
        this.f16614a.execute(runnable);
    }

    @Override // m1.a
    public k c() {
        return this.f16614a;
    }

    public void d(Runnable runnable) {
        this.f16615b.post(runnable);
    }
}
