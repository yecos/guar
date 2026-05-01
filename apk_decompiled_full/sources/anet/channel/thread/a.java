package anet.channel.thread;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import java.util.concurrent.RunnableFuture;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
class a extends ThreadPoolExecutor {
    public a(int i10, int i11, long j10, TimeUnit timeUnit, BlockingQueue<Runnable> blockingQueue, ThreadFactory threadFactory) {
        super(i10, i11, j10, timeUnit, blockingQueue, threadFactory);
    }

    @Override // java.util.concurrent.AbstractExecutorService
    public <T> RunnableFuture<T> newTaskFor(Runnable runnable, T t10) {
        return new C0067a(runnable, t10);
    }

    @Override // java.util.concurrent.AbstractExecutorService
    public <T> RunnableFuture<T> newTaskFor(Callable<T> callable) {
        return new C0067a(callable);
    }

    /* renamed from: anet.channel.thread.a$a, reason: collision with other inner class name */
    public class C0067a<V> extends FutureTask<V> implements Comparable<C0067a<V>> {

        /* renamed from: b, reason: collision with root package name */
        private Object f4267b;

        public C0067a(Callable<V> callable) {
            super(callable);
            this.f4267b = callable;
        }

        @Override // java.lang.Comparable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compareTo(C0067a<V> c0067a) {
            if (this == c0067a) {
                return 0;
            }
            if (c0067a == null) {
                return -1;
            }
            Object obj = this.f4267b;
            if (obj != null && c0067a.f4267b != null && obj.getClass().equals(c0067a.f4267b.getClass())) {
                Object obj2 = this.f4267b;
                if (obj2 instanceof Comparable) {
                    return ((Comparable) obj2).compareTo(c0067a.f4267b);
                }
            }
            return 0;
        }

        public C0067a(Runnable runnable, V v10) {
            super(runnable, v10);
            this.f4267b = runnable;
        }
    }
}
