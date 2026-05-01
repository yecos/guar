package x;

import android.os.Handler;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;

/* loaded from: classes.dex */
public abstract class e {

    public static class a implements Executor {

        /* renamed from: a, reason: collision with root package name */
        public final Handler f19274a;

        public a(Handler handler) {
            this.f19274a = (Handler) a0.h.d(handler);
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            if (this.f19274a.post((Runnable) a0.h.d(runnable))) {
                return;
            }
            throw new RejectedExecutionException(this.f19274a + " is shutting down");
        }
    }

    public static Executor a(Handler handler) {
        return new a(handler);
    }
}
