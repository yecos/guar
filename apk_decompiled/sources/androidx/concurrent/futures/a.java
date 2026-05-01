package androidx.concurrent.futures;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.Locale;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.concurrent.locks.LockSupport;
import java.util.logging.Level;
import java.util.logging.Logger;

/* loaded from: classes.dex */
public abstract class a implements ListenableFuture {
    static final b ATOMIC_HELPER;
    private static final Object NULL;
    private static final long SPIN_THRESHOLD_NANOS = 1000;
    volatile e listeners;
    volatile Object value;
    volatile i waiters;
    static final boolean GENERATE_CANCELLATION_CAUSES = Boolean.parseBoolean(System.getProperty("guava.concurrent.generate_cancellation_cause", "false"));
    private static final Logger log = Logger.getLogger(a.class.getName());

    public static abstract class b {
        public b() {
        }

        public abstract boolean a(a aVar, e eVar, e eVar2);

        public abstract boolean b(a aVar, Object obj, Object obj2);

        public abstract boolean c(a aVar, i iVar, i iVar2);

        public abstract void d(i iVar, i iVar2);

        public abstract void e(i iVar, Thread thread);
    }

    public static final class c {

        /* renamed from: c, reason: collision with root package name */
        public static final c f1832c;

        /* renamed from: d, reason: collision with root package name */
        public static final c f1833d;

        /* renamed from: a, reason: collision with root package name */
        public final boolean f1834a;

        /* renamed from: b, reason: collision with root package name */
        public final Throwable f1835b;

        static {
            if (a.GENERATE_CANCELLATION_CAUSES) {
                f1833d = null;
                f1832c = null;
            } else {
                f1833d = new c(false, null);
                f1832c = new c(true, null);
            }
        }

        public c(boolean z10, Throwable th) {
            this.f1834a = z10;
            this.f1835b = th;
        }
    }

    public static final class d {

        /* renamed from: b, reason: collision with root package name */
        public static final d f1836b = new d(new C0024a("Failure occurred while trying to finish a future."));

        /* renamed from: a, reason: collision with root package name */
        public final Throwable f1837a;

        /* renamed from: androidx.concurrent.futures.a$d$a, reason: collision with other inner class name */
        public class C0024a extends Throwable {
            public C0024a(String str) {
                super(str);
            }

            @Override // java.lang.Throwable
            public synchronized Throwable fillInStackTrace() {
                return this;
            }
        }

        public d(Throwable th) {
            this.f1837a = (Throwable) a.checkNotNull(th);
        }
    }

    public static final class e {

        /* renamed from: d, reason: collision with root package name */
        public static final e f1838d = new e(null, null);

        /* renamed from: a, reason: collision with root package name */
        public final Runnable f1839a;

        /* renamed from: b, reason: collision with root package name */
        public final Executor f1840b;

        /* renamed from: c, reason: collision with root package name */
        public e f1841c;

        public e(Runnable runnable, Executor executor) {
            this.f1839a = runnable;
            this.f1840b = executor;
        }
    }

    public static final class f extends b {

        /* renamed from: a, reason: collision with root package name */
        public final AtomicReferenceFieldUpdater f1842a;

        /* renamed from: b, reason: collision with root package name */
        public final AtomicReferenceFieldUpdater f1843b;

        /* renamed from: c, reason: collision with root package name */
        public final AtomicReferenceFieldUpdater f1844c;

        /* renamed from: d, reason: collision with root package name */
        public final AtomicReferenceFieldUpdater f1845d;

        /* renamed from: e, reason: collision with root package name */
        public final AtomicReferenceFieldUpdater f1846e;

        public f(AtomicReferenceFieldUpdater atomicReferenceFieldUpdater, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater3, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater4, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater5) {
            super();
            this.f1842a = atomicReferenceFieldUpdater;
            this.f1843b = atomicReferenceFieldUpdater2;
            this.f1844c = atomicReferenceFieldUpdater3;
            this.f1845d = atomicReferenceFieldUpdater4;
            this.f1846e = atomicReferenceFieldUpdater5;
        }

        @Override // androidx.concurrent.futures.a.b
        public boolean a(a aVar, e eVar, e eVar2) {
            return androidx.concurrent.futures.b.a(this.f1845d, aVar, eVar, eVar2);
        }

        @Override // androidx.concurrent.futures.a.b
        public boolean b(a aVar, Object obj, Object obj2) {
            return androidx.concurrent.futures.b.a(this.f1846e, aVar, obj, obj2);
        }

        @Override // androidx.concurrent.futures.a.b
        public boolean c(a aVar, i iVar, i iVar2) {
            return androidx.concurrent.futures.b.a(this.f1844c, aVar, iVar, iVar2);
        }

        @Override // androidx.concurrent.futures.a.b
        public void d(i iVar, i iVar2) {
            this.f1843b.lazySet(iVar, iVar2);
        }

        @Override // androidx.concurrent.futures.a.b
        public void e(i iVar, Thread thread) {
            this.f1842a.lazySet(iVar, thread);
        }
    }

    public static final class g implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final a f1847a;

        /* renamed from: b, reason: collision with root package name */
        public final ListenableFuture f1848b;

        public g(a aVar, ListenableFuture listenableFuture) {
            this.f1847a = aVar;
            this.f1848b = listenableFuture;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f1847a.value != this) {
                return;
            }
            if (a.ATOMIC_HELPER.b(this.f1847a, this, a.getFutureValue(this.f1848b))) {
                a.complete(this.f1847a);
            }
        }
    }

    public static final class h extends b {
        public h() {
            super();
        }

        @Override // androidx.concurrent.futures.a.b
        public boolean a(a aVar, e eVar, e eVar2) {
            synchronized (aVar) {
                if (aVar.listeners != eVar) {
                    return false;
                }
                aVar.listeners = eVar2;
                return true;
            }
        }

        @Override // androidx.concurrent.futures.a.b
        public boolean b(a aVar, Object obj, Object obj2) {
            synchronized (aVar) {
                if (aVar.value != obj) {
                    return false;
                }
                aVar.value = obj2;
                return true;
            }
        }

        @Override // androidx.concurrent.futures.a.b
        public boolean c(a aVar, i iVar, i iVar2) {
            synchronized (aVar) {
                if (aVar.waiters != iVar) {
                    return false;
                }
                aVar.waiters = iVar2;
                return true;
            }
        }

        @Override // androidx.concurrent.futures.a.b
        public void d(i iVar, i iVar2) {
            iVar.f1851b = iVar2;
        }

        @Override // androidx.concurrent.futures.a.b
        public void e(i iVar, Thread thread) {
            iVar.f1850a = thread;
        }
    }

    public static final class i {

        /* renamed from: c, reason: collision with root package name */
        public static final i f1849c = new i(false);

        /* renamed from: a, reason: collision with root package name */
        public volatile Thread f1850a;

        /* renamed from: b, reason: collision with root package name */
        public volatile i f1851b;

        public i(boolean z10) {
        }

        public void a(i iVar) {
            a.ATOMIC_HELPER.d(this, iVar);
        }

        public void b() {
            Thread thread = this.f1850a;
            if (thread != null) {
                this.f1850a = null;
                LockSupport.unpark(thread);
            }
        }

        public i() {
            a.ATOMIC_HELPER.e(this, Thread.currentThread());
        }
    }

    static {
        b hVar;
        try {
            hVar = new f(AtomicReferenceFieldUpdater.newUpdater(i.class, Thread.class, "a"), AtomicReferenceFieldUpdater.newUpdater(i.class, i.class, c8.b.f5629b), AtomicReferenceFieldUpdater.newUpdater(a.class, i.class, "waiters"), AtomicReferenceFieldUpdater.newUpdater(a.class, e.class, "listeners"), AtomicReferenceFieldUpdater.newUpdater(a.class, Object.class, "value"));
            th = null;
        } catch (Throwable th) {
            th = th;
            hVar = new h();
        }
        ATOMIC_HELPER = hVar;
        if (th != null) {
            log.log(Level.SEVERE, "SafeAtomicHelper is broken!", th);
        }
        NULL = new Object();
    }

    public static CancellationException b(String str, Throwable th) {
        CancellationException cancellationException = new CancellationException(str);
        cancellationException.initCause(th);
        return cancellationException;
    }

    static <T> T checkNotNull(T t10) {
        t10.getClass();
        return t10;
    }

    public static void complete(a aVar) {
        e eVar = null;
        while (true) {
            aVar.f();
            aVar.afterDone();
            e c10 = aVar.c(eVar);
            while (c10 != null) {
                eVar = c10.f1841c;
                Runnable runnable = c10.f1839a;
                if (runnable instanceof g) {
                    g gVar = (g) runnable;
                    aVar = gVar.f1847a;
                    if (aVar.value == gVar) {
                        if (ATOMIC_HELPER.b(aVar, gVar, getFutureValue(gVar.f1848b))) {
                            break;
                        }
                    } else {
                        continue;
                    }
                } else {
                    d(runnable, c10.f1840b);
                }
                c10 = eVar;
            }
            return;
        }
    }

    public static void d(Runnable runnable, Executor executor) {
        try {
            executor.execute(runnable);
        } catch (RuntimeException e10) {
            log.log(Level.SEVERE, "RuntimeException while executing runnable " + runnable + " with executor " + executor, (Throwable) e10);
        }
    }

    static Object getFutureValue(ListenableFuture<?> listenableFuture) {
        if (listenableFuture instanceof a) {
            Object obj = ((a) listenableFuture).value;
            if (!(obj instanceof c)) {
                return obj;
            }
            c cVar = (c) obj;
            return cVar.f1834a ? cVar.f1835b != null ? new c(false, cVar.f1835b) : c.f1833d : obj;
        }
        boolean isCancelled = listenableFuture.isCancelled();
        if ((!GENERATE_CANCELLATION_CAUSES) && isCancelled) {
            return c.f1833d;
        }
        try {
            Object uninterruptibly = getUninterruptibly(listenableFuture);
            return uninterruptibly == null ? NULL : uninterruptibly;
        } catch (CancellationException e10) {
            if (isCancelled) {
                return new c(false, e10);
            }
            return new d(new IllegalArgumentException("get() threw CancellationException, despite reporting isCancelled() == false: " + listenableFuture, e10));
        } catch (ExecutionException e11) {
            return new d(e11.getCause());
        } catch (Throwable th) {
            return new d(th);
        }
    }

    static <V> V getUninterruptibly(Future<V> future) {
        V v10;
        boolean z10 = false;
        while (true) {
            try {
                v10 = future.get();
                break;
            } catch (InterruptedException unused) {
                z10 = true;
            } catch (Throwable th) {
                if (z10) {
                    Thread.currentThread().interrupt();
                }
                throw th;
            }
        }
        if (z10) {
            Thread.currentThread().interrupt();
        }
        return v10;
    }

    public final void a(StringBuilder sb) {
        try {
            Object uninterruptibly = getUninterruptibly(this);
            sb.append("SUCCESS, result=[");
            sb.append(h(uninterruptibly));
            sb.append("]");
        } catch (CancellationException unused) {
            sb.append("CANCELLED");
        } catch (RuntimeException e10) {
            sb.append("UNKNOWN, cause=[");
            sb.append(e10.getClass());
            sb.append(" thrown from get()]");
        } catch (ExecutionException e11) {
            sb.append("FAILURE, cause=[");
            sb.append(e11.getCause());
            sb.append("]");
        }
    }

    @Override // com.google.common.util.concurrent.ListenableFuture
    public final void addListener(Runnable runnable, Executor executor) {
        checkNotNull(runnable);
        checkNotNull(executor);
        e eVar = this.listeners;
        if (eVar != e.f1838d) {
            e eVar2 = new e(runnable, executor);
            do {
                eVar2.f1841c = eVar;
                if (ATOMIC_HELPER.a(this, eVar, eVar2)) {
                    return;
                } else {
                    eVar = this.listeners;
                }
            } while (eVar != e.f1838d);
        }
        d(runnable, executor);
    }

    public void afterDone() {
    }

    public final e c(e eVar) {
        e eVar2;
        do {
            eVar2 = this.listeners;
        } while (!ATOMIC_HELPER.a(this, eVar2, e.f1838d));
        e eVar3 = eVar;
        e eVar4 = eVar2;
        while (eVar4 != null) {
            e eVar5 = eVar4.f1841c;
            eVar4.f1841c = eVar3;
            eVar3 = eVar4;
            eVar4 = eVar5;
        }
        return eVar3;
    }

    @Override // java.util.concurrent.Future
    public final boolean cancel(boolean z10) {
        Object obj = this.value;
        if (!(obj == null) && !(obj instanceof g)) {
            return false;
        }
        c cVar = GENERATE_CANCELLATION_CAUSES ? new c(z10, new CancellationException("Future.cancel() was called.")) : z10 ? c.f1832c : c.f1833d;
        boolean z11 = false;
        a aVar = this;
        while (true) {
            if (ATOMIC_HELPER.b(aVar, obj, cVar)) {
                if (z10) {
                    aVar.interruptTask();
                }
                complete(aVar);
                if (!(obj instanceof g)) {
                    return true;
                }
                ListenableFuture listenableFuture = ((g) obj).f1848b;
                if (!(listenableFuture instanceof a)) {
                    listenableFuture.cancel(z10);
                    return true;
                }
                aVar = (a) listenableFuture;
                obj = aVar.value;
                if (!(obj == null) && !(obj instanceof g)) {
                    return true;
                }
                z11 = true;
            } else {
                obj = aVar.value;
                if (!(obj instanceof g)) {
                    return z11;
                }
            }
        }
    }

    public final Object e(Object obj) {
        if (obj instanceof c) {
            throw b("Task was cancelled.", ((c) obj).f1835b);
        }
        if (obj instanceof d) {
            throw new ExecutionException(((d) obj).f1837a);
        }
        if (obj == NULL) {
            return null;
        }
        return obj;
    }

    public final void f() {
        i iVar;
        do {
            iVar = this.waiters;
        } while (!ATOMIC_HELPER.c(this, iVar, i.f1849c));
        while (iVar != null) {
            iVar.b();
            iVar = iVar.f1851b;
        }
    }

    public final void g(i iVar) {
        iVar.f1850a = null;
        while (true) {
            i iVar2 = this.waiters;
            if (iVar2 == i.f1849c) {
                return;
            }
            i iVar3 = null;
            while (iVar2 != null) {
                i iVar4 = iVar2.f1851b;
                if (iVar2.f1850a != null) {
                    iVar3 = iVar2;
                } else if (iVar3 != null) {
                    iVar3.f1851b = iVar4;
                    if (iVar3.f1850a == null) {
                        break;
                    }
                } else if (!ATOMIC_HELPER.c(this, iVar2, iVar4)) {
                    break;
                }
                iVar2 = iVar4;
            }
            return;
        }
    }

    @Override // java.util.concurrent.Future
    public final Object get(long j10, TimeUnit timeUnit) {
        long nanos = timeUnit.toNanos(j10);
        if (Thread.interrupted()) {
            throw new InterruptedException();
        }
        Object obj = this.value;
        if ((obj != null) && (!(obj instanceof g))) {
            return e(obj);
        }
        long nanoTime = nanos > 0 ? System.nanoTime() + nanos : 0L;
        if (nanos >= 1000) {
            i iVar = this.waiters;
            if (iVar != i.f1849c) {
                i iVar2 = new i();
                do {
                    iVar2.a(iVar);
                    if (ATOMIC_HELPER.c(this, iVar, iVar2)) {
                        do {
                            LockSupport.parkNanos(this, nanos);
                            if (Thread.interrupted()) {
                                g(iVar2);
                                throw new InterruptedException();
                            }
                            Object obj2 = this.value;
                            if ((obj2 != null) && (!(obj2 instanceof g))) {
                                return e(obj2);
                            }
                            nanos = nanoTime - System.nanoTime();
                        } while (nanos >= 1000);
                        g(iVar2);
                    } else {
                        iVar = this.waiters;
                    }
                } while (iVar != i.f1849c);
            }
            return e(this.value);
        }
        while (nanos > 0) {
            Object obj3 = this.value;
            if ((obj3 != null) && (!(obj3 instanceof g))) {
                return e(obj3);
            }
            if (Thread.interrupted()) {
                throw new InterruptedException();
            }
            nanos = nanoTime - System.nanoTime();
        }
        String aVar = toString();
        String obj4 = timeUnit.toString();
        Locale locale = Locale.ROOT;
        String lowerCase = obj4.toLowerCase(locale);
        String str = "Waited " + j10 + " " + timeUnit.toString().toLowerCase(locale);
        if (nanos + 1000 < 0) {
            String str2 = str + " (plus ";
            long j11 = -nanos;
            long convert = timeUnit.convert(j11, TimeUnit.NANOSECONDS);
            long nanos2 = j11 - timeUnit.toNanos(convert);
            boolean z10 = convert == 0 || nanos2 > 1000;
            if (convert > 0) {
                String str3 = str2 + convert + " " + lowerCase;
                if (z10) {
                    str3 = str3 + ",";
                }
                str2 = str3 + " ";
            }
            if (z10) {
                str2 = str2 + nanos2 + " nanoseconds ";
            }
            str = str2 + "delay)";
        }
        if (isDone()) {
            throw new TimeoutException(str + " but future completed as timeout expired");
        }
        throw new TimeoutException(str + " for " + aVar);
    }

    public final String h(Object obj) {
        return obj == this ? "this future" : String.valueOf(obj);
    }

    public void interruptTask() {
    }

    @Override // java.util.concurrent.Future
    public final boolean isCancelled() {
        return this.value instanceof c;
    }

    @Override // java.util.concurrent.Future
    public final boolean isDone() {
        return (!(r0 instanceof g)) & (this.value != null);
    }

    final void maybePropagateCancellationTo(Future<?> future) {
        if ((future != null) && isCancelled()) {
            future.cancel(wasInterrupted());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public String pendingToString() {
        Object obj = this.value;
        if (obj instanceof g) {
            return "setFuture=[" + h(((g) obj).f1848b) + "]";
        }
        if (!(this instanceof ScheduledFuture)) {
            return null;
        }
        return "remaining delay=[" + ((ScheduledFuture) this).getDelay(TimeUnit.MILLISECONDS) + " ms]";
    }

    public boolean set(Object obj) {
        if (obj == null) {
            obj = NULL;
        }
        if (!ATOMIC_HELPER.b(this, null, obj)) {
            return false;
        }
        complete(this);
        return true;
    }

    public boolean setException(Throwable th) {
        if (!ATOMIC_HELPER.b(this, null, new d((Throwable) checkNotNull(th)))) {
            return false;
        }
        complete(this);
        return true;
    }

    public boolean setFuture(ListenableFuture<Object> listenableFuture) {
        d dVar;
        checkNotNull(listenableFuture);
        Object obj = this.value;
        if (obj == null) {
            if (listenableFuture.isDone()) {
                if (!ATOMIC_HELPER.b(this, null, getFutureValue(listenableFuture))) {
                    return false;
                }
                complete(this);
                return true;
            }
            g gVar = new g(this, listenableFuture);
            if (ATOMIC_HELPER.b(this, null, gVar)) {
                try {
                    listenableFuture.addListener(gVar, androidx.concurrent.futures.c.INSTANCE);
                } catch (Throwable th) {
                    try {
                        dVar = new d(th);
                    } catch (Throwable unused) {
                        dVar = d.f1836b;
                    }
                    ATOMIC_HELPER.b(this, gVar, dVar);
                }
                return true;
            }
            obj = this.value;
        }
        if (obj instanceof c) {
            listenableFuture.cancel(((c) obj).f1834a);
        }
        return false;
    }

    public String toString() {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("[status=");
        if (isCancelled()) {
            sb.append("CANCELLED");
        } else if (isDone()) {
            a(sb);
        } else {
            try {
                str = pendingToString();
            } catch (RuntimeException e10) {
                str = "Exception thrown from implementation: " + e10.getClass();
            }
            if (str != null && !str.isEmpty()) {
                sb.append("PENDING, info=[");
                sb.append(str);
                sb.append("]");
            } else if (isDone()) {
                a(sb);
            } else {
                sb.append("PENDING");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    public final boolean wasInterrupted() {
        Object obj = this.value;
        return (obj instanceof c) && ((c) obj).f1834a;
    }

    @Override // java.util.concurrent.Future
    public final Object get() {
        Object obj;
        if (!Thread.interrupted()) {
            Object obj2 = this.value;
            if ((obj2 != null) & (!(obj2 instanceof g))) {
                return e(obj2);
            }
            i iVar = this.waiters;
            if (iVar != i.f1849c) {
                i iVar2 = new i();
                do {
                    iVar2.a(iVar);
                    if (ATOMIC_HELPER.c(this, iVar, iVar2)) {
                        do {
                            LockSupport.park(this);
                            if (!Thread.interrupted()) {
                                obj = this.value;
                            } else {
                                g(iVar2);
                                throw new InterruptedException();
                            }
                        } while (!((obj != null) & (!(obj instanceof g))));
                        return e(obj);
                    }
                    iVar = this.waiters;
                } while (iVar != i.f1849c);
            }
            return e(this.value);
        }
        throw new InterruptedException();
    }
}
