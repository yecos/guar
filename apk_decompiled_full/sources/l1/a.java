package l1;

import com.google.common.util.concurrent.ListenableFuture;
import com.umeng.analytics.pro.bt;
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

    /* renamed from: d, reason: collision with root package name */
    public static final boolean f15892d = Boolean.parseBoolean(System.getProperty("guava.concurrent.generate_cancellation_cause", "false"));

    /* renamed from: e, reason: collision with root package name */
    public static final Logger f15893e = Logger.getLogger(a.class.getName());

    /* renamed from: f, reason: collision with root package name */
    public static final b f15894f;

    /* renamed from: g, reason: collision with root package name */
    public static final Object f15895g;

    /* renamed from: a, reason: collision with root package name */
    public volatile Object f15896a;

    /* renamed from: b, reason: collision with root package name */
    public volatile e f15897b;

    /* renamed from: c, reason: collision with root package name */
    public volatile i f15898c;

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
        public static final c f15899c;

        /* renamed from: d, reason: collision with root package name */
        public static final c f15900d;

        /* renamed from: a, reason: collision with root package name */
        public final boolean f15901a;

        /* renamed from: b, reason: collision with root package name */
        public final Throwable f15902b;

        static {
            if (a.f15892d) {
                f15900d = null;
                f15899c = null;
            } else {
                f15900d = new c(false, null);
                f15899c = new c(true, null);
            }
        }

        public c(boolean z10, Throwable th) {
            this.f15901a = z10;
            this.f15902b = th;
        }
    }

    public static final class d {

        /* renamed from: b, reason: collision with root package name */
        public static final d f15903b = new d(new C0269a("Failure occurred while trying to finish a future."));

        /* renamed from: a, reason: collision with root package name */
        public final Throwable f15904a;

        /* renamed from: l1.a$d$a, reason: collision with other inner class name */
        public class C0269a extends Throwable {
            public C0269a(String str) {
                super(str);
            }

            @Override // java.lang.Throwable
            public synchronized Throwable fillInStackTrace() {
                return this;
            }
        }

        public d(Throwable th) {
            this.f15904a = (Throwable) a.d(th);
        }
    }

    public static final class e {

        /* renamed from: d, reason: collision with root package name */
        public static final e f15905d = new e(null, null);

        /* renamed from: a, reason: collision with root package name */
        public final Runnable f15906a;

        /* renamed from: b, reason: collision with root package name */
        public final Executor f15907b;

        /* renamed from: c, reason: collision with root package name */
        public e f15908c;

        public e(Runnable runnable, Executor executor) {
            this.f15906a = runnable;
            this.f15907b = executor;
        }
    }

    public static final class f extends b {

        /* renamed from: a, reason: collision with root package name */
        public final AtomicReferenceFieldUpdater f15909a;

        /* renamed from: b, reason: collision with root package name */
        public final AtomicReferenceFieldUpdater f15910b;

        /* renamed from: c, reason: collision with root package name */
        public final AtomicReferenceFieldUpdater f15911c;

        /* renamed from: d, reason: collision with root package name */
        public final AtomicReferenceFieldUpdater f15912d;

        /* renamed from: e, reason: collision with root package name */
        public final AtomicReferenceFieldUpdater f15913e;

        public f(AtomicReferenceFieldUpdater atomicReferenceFieldUpdater, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater3, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater4, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater5) {
            super();
            this.f15909a = atomicReferenceFieldUpdater;
            this.f15910b = atomicReferenceFieldUpdater2;
            this.f15911c = atomicReferenceFieldUpdater3;
            this.f15912d = atomicReferenceFieldUpdater4;
            this.f15913e = atomicReferenceFieldUpdater5;
        }

        @Override // l1.a.b
        public boolean a(a aVar, e eVar, e eVar2) {
            return androidx.concurrent.futures.b.a(this.f15912d, aVar, eVar, eVar2);
        }

        @Override // l1.a.b
        public boolean b(a aVar, Object obj, Object obj2) {
            return androidx.concurrent.futures.b.a(this.f15913e, aVar, obj, obj2);
        }

        @Override // l1.a.b
        public boolean c(a aVar, i iVar, i iVar2) {
            return androidx.concurrent.futures.b.a(this.f15911c, aVar, iVar, iVar2);
        }

        @Override // l1.a.b
        public void d(i iVar, i iVar2) {
            this.f15910b.lazySet(iVar, iVar2);
        }

        @Override // l1.a.b
        public void e(i iVar, Thread thread) {
            this.f15909a.lazySet(iVar, thread);
        }
    }

    public static final class g implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final a f15914a;

        /* renamed from: b, reason: collision with root package name */
        public final ListenableFuture f15915b;

        public g(a aVar, ListenableFuture listenableFuture) {
            this.f15914a = aVar;
            this.f15915b = listenableFuture;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f15914a.f15896a != this) {
                return;
            }
            if (a.f15894f.b(this.f15914a, this, a.i(this.f15915b))) {
                a.f(this.f15914a);
            }
        }
    }

    public static final class h extends b {
        public h() {
            super();
        }

        @Override // l1.a.b
        public boolean a(a aVar, e eVar, e eVar2) {
            synchronized (aVar) {
                if (aVar.f15897b != eVar) {
                    return false;
                }
                aVar.f15897b = eVar2;
                return true;
            }
        }

        @Override // l1.a.b
        public boolean b(a aVar, Object obj, Object obj2) {
            synchronized (aVar) {
                if (aVar.f15896a != obj) {
                    return false;
                }
                aVar.f15896a = obj2;
                return true;
            }
        }

        @Override // l1.a.b
        public boolean c(a aVar, i iVar, i iVar2) {
            synchronized (aVar) {
                if (aVar.f15898c != iVar) {
                    return false;
                }
                aVar.f15898c = iVar2;
                return true;
            }
        }

        @Override // l1.a.b
        public void d(i iVar, i iVar2) {
            iVar.f15918b = iVar2;
        }

        @Override // l1.a.b
        public void e(i iVar, Thread thread) {
            iVar.f15917a = thread;
        }
    }

    public static final class i {

        /* renamed from: c, reason: collision with root package name */
        public static final i f15916c = new i(false);

        /* renamed from: a, reason: collision with root package name */
        public volatile Thread f15917a;

        /* renamed from: b, reason: collision with root package name */
        public volatile i f15918b;

        public i(boolean z10) {
        }

        public void a(i iVar) {
            a.f15894f.d(this, iVar);
        }

        public void b() {
            Thread thread = this.f15917a;
            if (thread != null) {
                this.f15917a = null;
                LockSupport.unpark(thread);
            }
        }

        public i() {
            a.f15894f.e(this, Thread.currentThread());
        }
    }

    static {
        b hVar;
        try {
            hVar = new f(AtomicReferenceFieldUpdater.newUpdater(i.class, Thread.class, "a"), AtomicReferenceFieldUpdater.newUpdater(i.class, i.class, c8.b.f5629b), AtomicReferenceFieldUpdater.newUpdater(a.class, i.class, bt.aL), AtomicReferenceFieldUpdater.newUpdater(a.class, e.class, c8.b.f5629b), AtomicReferenceFieldUpdater.newUpdater(a.class, Object.class, "a"));
            th = null;
        } catch (Throwable th) {
            th = th;
            hVar = new h();
        }
        f15894f = hVar;
        if (th != null) {
            f15893e.log(Level.SEVERE, "SafeAtomicHelper is broken!", th);
        }
        f15895g = new Object();
    }

    public static CancellationException c(String str, Throwable th) {
        CancellationException cancellationException = new CancellationException(str);
        cancellationException.initCause(th);
        return cancellationException;
    }

    public static Object d(Object obj) {
        obj.getClass();
        return obj;
    }

    public static void f(a aVar) {
        e eVar = null;
        while (true) {
            aVar.m();
            aVar.b();
            e e10 = aVar.e(eVar);
            while (e10 != null) {
                eVar = e10.f15908c;
                Runnable runnable = e10.f15906a;
                if (runnable instanceof g) {
                    g gVar = (g) runnable;
                    aVar = gVar.f15914a;
                    if (aVar.f15896a == gVar) {
                        if (f15894f.b(aVar, gVar, i(gVar.f15915b))) {
                            break;
                        }
                    } else {
                        continue;
                    }
                } else {
                    g(runnable, e10.f15907b);
                }
                e10 = eVar;
            }
            return;
        }
    }

    public static void g(Runnable runnable, Executor executor) {
        try {
            executor.execute(runnable);
        } catch (RuntimeException e10) {
            f15893e.log(Level.SEVERE, "RuntimeException while executing runnable " + runnable + " with executor " + executor, (Throwable) e10);
        }
    }

    public static Object i(ListenableFuture listenableFuture) {
        if (listenableFuture instanceof a) {
            Object obj = ((a) listenableFuture).f15896a;
            if (!(obj instanceof c)) {
                return obj;
            }
            c cVar = (c) obj;
            return cVar.f15901a ? cVar.f15902b != null ? new c(false, cVar.f15902b) : c.f15900d : obj;
        }
        boolean isCancelled = listenableFuture.isCancelled();
        if ((!f15892d) && isCancelled) {
            return c.f15900d;
        }
        try {
            Object j10 = j(listenableFuture);
            return j10 == null ? f15895g : j10;
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

    public static Object j(Future future) {
        Object obj;
        boolean z10 = false;
        while (true) {
            try {
                obj = future.get();
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
        return obj;
    }

    public final void a(StringBuilder sb) {
        try {
            Object j10 = j(this);
            sb.append("SUCCESS, result=[");
            sb.append(r(j10));
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
        d(runnable);
        d(executor);
        e eVar = this.f15897b;
        if (eVar != e.f15905d) {
            e eVar2 = new e(runnable, executor);
            do {
                eVar2.f15908c = eVar;
                if (f15894f.a(this, eVar, eVar2)) {
                    return;
                } else {
                    eVar = this.f15897b;
                }
            } while (eVar != e.f15905d);
        }
        g(runnable, executor);
    }

    public void b() {
    }

    @Override // java.util.concurrent.Future
    public final boolean cancel(boolean z10) {
        Object obj = this.f15896a;
        if (!(obj == null) && !(obj instanceof g)) {
            return false;
        }
        c cVar = f15892d ? new c(z10, new CancellationException("Future.cancel() was called.")) : z10 ? c.f15899c : c.f15900d;
        boolean z11 = false;
        a aVar = this;
        while (true) {
            if (f15894f.b(aVar, obj, cVar)) {
                if (z10) {
                    aVar.k();
                }
                f(aVar);
                if (!(obj instanceof g)) {
                    return true;
                }
                ListenableFuture listenableFuture = ((g) obj).f15915b;
                if (!(listenableFuture instanceof a)) {
                    listenableFuture.cancel(z10);
                    return true;
                }
                aVar = (a) listenableFuture;
                obj = aVar.f15896a;
                if (!(obj == null) && !(obj instanceof g)) {
                    return true;
                }
                z11 = true;
            } else {
                obj = aVar.f15896a;
                if (!(obj instanceof g)) {
                    return z11;
                }
            }
        }
    }

    public final e e(e eVar) {
        e eVar2;
        do {
            eVar2 = this.f15897b;
        } while (!f15894f.a(this, eVar2, e.f15905d));
        e eVar3 = eVar;
        e eVar4 = eVar2;
        while (eVar4 != null) {
            e eVar5 = eVar4.f15908c;
            eVar4.f15908c = eVar3;
            eVar3 = eVar4;
            eVar4 = eVar5;
        }
        return eVar3;
    }

    @Override // java.util.concurrent.Future
    public final Object get(long j10, TimeUnit timeUnit) {
        long nanos = timeUnit.toNanos(j10);
        if (Thread.interrupted()) {
            throw new InterruptedException();
        }
        Object obj = this.f15896a;
        if ((obj != null) && (!(obj instanceof g))) {
            return h(obj);
        }
        long nanoTime = nanos > 0 ? System.nanoTime() + nanos : 0L;
        if (nanos >= 1000) {
            i iVar = this.f15898c;
            if (iVar != i.f15916c) {
                i iVar2 = new i();
                do {
                    iVar2.a(iVar);
                    if (f15894f.c(this, iVar, iVar2)) {
                        do {
                            LockSupport.parkNanos(this, nanos);
                            if (Thread.interrupted()) {
                                n(iVar2);
                                throw new InterruptedException();
                            }
                            Object obj2 = this.f15896a;
                            if ((obj2 != null) && (!(obj2 instanceof g))) {
                                return h(obj2);
                            }
                            nanos = nanoTime - System.nanoTime();
                        } while (nanos >= 1000);
                        n(iVar2);
                    } else {
                        iVar = this.f15898c;
                    }
                } while (iVar != i.f15916c);
            }
            return h(this.f15896a);
        }
        while (nanos > 0) {
            Object obj3 = this.f15896a;
            if ((obj3 != null) && (!(obj3 instanceof g))) {
                return h(obj3);
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

    public final Object h(Object obj) {
        if (obj instanceof c) {
            throw c("Task was cancelled.", ((c) obj).f15902b);
        }
        if (obj instanceof d) {
            throw new ExecutionException(((d) obj).f15904a);
        }
        if (obj == f15895g) {
            return null;
        }
        return obj;
    }

    @Override // java.util.concurrent.Future
    public final boolean isCancelled() {
        return this.f15896a instanceof c;
    }

    @Override // java.util.concurrent.Future
    public final boolean isDone() {
        return (!(r0 instanceof g)) & (this.f15896a != null);
    }

    public void k() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public String l() {
        Object obj = this.f15896a;
        if (obj instanceof g) {
            return "setFuture=[" + r(((g) obj).f15915b) + "]";
        }
        if (!(this instanceof ScheduledFuture)) {
            return null;
        }
        return "remaining delay=[" + ((ScheduledFuture) this).getDelay(TimeUnit.MILLISECONDS) + " ms]";
    }

    public final void m() {
        i iVar;
        do {
            iVar = this.f15898c;
        } while (!f15894f.c(this, iVar, i.f15916c));
        while (iVar != null) {
            iVar.b();
            iVar = iVar.f15918b;
        }
    }

    public final void n(i iVar) {
        iVar.f15917a = null;
        while (true) {
            i iVar2 = this.f15898c;
            if (iVar2 == i.f15916c) {
                return;
            }
            i iVar3 = null;
            while (iVar2 != null) {
                i iVar4 = iVar2.f15918b;
                if (iVar2.f15917a != null) {
                    iVar3 = iVar2;
                } else if (iVar3 != null) {
                    iVar3.f15918b = iVar4;
                    if (iVar3.f15917a == null) {
                        break;
                    }
                } else if (!f15894f.c(this, iVar2, iVar4)) {
                    break;
                }
                iVar2 = iVar4;
            }
            return;
        }
    }

    public boolean o(Object obj) {
        if (obj == null) {
            obj = f15895g;
        }
        if (!f15894f.b(this, null, obj)) {
            return false;
        }
        f(this);
        return true;
    }

    public boolean p(Throwable th) {
        if (!f15894f.b(this, null, new d((Throwable) d(th)))) {
            return false;
        }
        f(this);
        return true;
    }

    public boolean q(ListenableFuture listenableFuture) {
        d dVar;
        d(listenableFuture);
        Object obj = this.f15896a;
        if (obj == null) {
            if (listenableFuture.isDone()) {
                if (!f15894f.b(this, null, i(listenableFuture))) {
                    return false;
                }
                f(this);
                return true;
            }
            g gVar = new g(this, listenableFuture);
            if (f15894f.b(this, null, gVar)) {
                try {
                    listenableFuture.addListener(gVar, l1.b.INSTANCE);
                } catch (Throwable th) {
                    try {
                        dVar = new d(th);
                    } catch (Throwable unused) {
                        dVar = d.f15903b;
                    }
                    f15894f.b(this, gVar, dVar);
                }
                return true;
            }
            obj = this.f15896a;
        }
        if (obj instanceof c) {
            listenableFuture.cancel(((c) obj).f15901a);
        }
        return false;
    }

    public final String r(Object obj) {
        return obj == this ? "this future" : String.valueOf(obj);
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
                str = l();
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

    @Override // java.util.concurrent.Future
    public final Object get() {
        Object obj;
        if (!Thread.interrupted()) {
            Object obj2 = this.f15896a;
            if ((obj2 != null) & (!(obj2 instanceof g))) {
                return h(obj2);
            }
            i iVar = this.f15898c;
            if (iVar != i.f15916c) {
                i iVar2 = new i();
                do {
                    iVar2.a(iVar);
                    if (f15894f.c(this, iVar, iVar2)) {
                        do {
                            LockSupport.park(this);
                            if (!Thread.interrupted()) {
                                obj = this.f15896a;
                            } else {
                                n(iVar2);
                                throw new InterruptedException();
                            }
                        } while (!((obj != null) & (!(obj instanceof g))));
                        return h(obj);
                    }
                    iVar = this.f15898c;
                } while (iVar != i.f15916c);
            }
            return h(this.f15896a);
        }
        throw new InterruptedException();
    }
}
