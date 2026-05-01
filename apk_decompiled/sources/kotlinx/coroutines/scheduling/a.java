package kotlinx.coroutines.scheduling;

import ca.g0;
import com.google.android.gms.cast.framework.media.NotificationOptions;
import h9.t;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.locks.LockSupport;
import kotlinx.coroutines.internal.w;
import kotlinx.coroutines.internal.y;

/* loaded from: classes3.dex */
public final class a implements Executor, Closeable {
    private volatile /* synthetic */ int _isTerminated;

    /* renamed from: a, reason: collision with root package name */
    public final int f15785a;

    /* renamed from: b, reason: collision with root package name */
    public final int f15786b;

    /* renamed from: c, reason: collision with root package name */
    public final long f15787c;
    volatile /* synthetic */ long controlState;

    /* renamed from: d, reason: collision with root package name */
    public final String f15788d;

    /* renamed from: e, reason: collision with root package name */
    public final kotlinx.coroutines.scheduling.d f15789e;

    /* renamed from: f, reason: collision with root package name */
    public final kotlinx.coroutines.scheduling.d f15790f;

    /* renamed from: g, reason: collision with root package name */
    public final w f15791g;
    private volatile /* synthetic */ long parkedWorkersStack;

    /* renamed from: h, reason: collision with root package name */
    public static final C0267a f15780h = new C0267a(null);

    /* renamed from: l, reason: collision with root package name */
    public static final y f15784l = new y("NOT_IN_STACK");

    /* renamed from: i, reason: collision with root package name */
    public static final /* synthetic */ AtomicLongFieldUpdater f15781i = AtomicLongFieldUpdater.newUpdater(a.class, "parkedWorkersStack");

    /* renamed from: j, reason: collision with root package name */
    public static final /* synthetic */ AtomicLongFieldUpdater f15782j = AtomicLongFieldUpdater.newUpdater(a.class, "controlState");

    /* renamed from: k, reason: collision with root package name */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f15783k = AtomicIntegerFieldUpdater.newUpdater(a.class, "_isTerminated");

    /* renamed from: kotlinx.coroutines.scheduling.a$a, reason: collision with other inner class name */
    public static final class C0267a {
        public C0267a() {
        }

        public /* synthetic */ C0267a(t9.g gVar) {
            this();
        }
    }

    public /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f15792a;

        static {
            int[] iArr = new int[d.values().length];
            iArr[d.PARKING.ordinal()] = 1;
            iArr[d.BLOCKING.ordinal()] = 2;
            iArr[d.CPU_ACQUIRED.ordinal()] = 3;
            iArr[d.DORMANT.ordinal()] = 4;
            iArr[d.TERMINATED.ordinal()] = 5;
            f15792a = iArr;
        }
    }

    public enum d {
        CPU_ACQUIRED,
        BLOCKING,
        PARKING,
        DORMANT,
        TERMINATED
    }

    public a(int i10, int i11, long j10, String str) {
        this.f15785a = i10;
        this.f15786b = i11;
        this.f15787c = j10;
        this.f15788d = str;
        if (!(i10 >= 1)) {
            throw new IllegalArgumentException(("Core pool size " + i10 + " should be at least 1").toString());
        }
        if (!(i11 >= i10)) {
            throw new IllegalArgumentException(("Max pool size " + i11 + " should be greater than or equals to core pool size " + i10).toString());
        }
        if (!(i11 <= 2097150)) {
            throw new IllegalArgumentException(("Max pool size " + i11 + " should not exceed maximal supported number of threads 2097150").toString());
        }
        if (!(j10 > 0)) {
            throw new IllegalArgumentException(("Idle worker keep alive time " + j10 + " must be positive").toString());
        }
        this.f15789e = new kotlinx.coroutines.scheduling.d();
        this.f15790f = new kotlinx.coroutines.scheduling.d();
        this.parkedWorkersStack = 0L;
        this.f15791g = new w(i10 + 1);
        this.controlState = i10 << 42;
        this._isTerminated = 0;
    }

    public static /* synthetic */ boolean L(a aVar, long j10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            j10 = aVar.controlState;
        }
        return aVar.I(j10);
    }

    public static /* synthetic */ void m(a aVar, Runnable runnable, i iVar, boolean z10, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            iVar = l.f15825f;
        }
        if ((i10 & 4) != 0) {
            z10 = false;
        }
        aVar.f(runnable, iVar, z10);
    }

    public final h E(c cVar, h hVar, boolean z10) {
        if (cVar == null) {
            return hVar;
        }
        if (cVar.f15795b == d.TERMINATED) {
            return hVar;
        }
        if (hVar.f15817b.b() == 0 && cVar.f15795b == d.BLOCKING) {
            return hVar;
        }
        cVar.f15799f = true;
        return cVar.f15794a.a(hVar, z10);
    }

    public final boolean I(long j10) {
        if (y9.e.a(((int) (2097151 & j10)) - ((int) ((j10 & 4398044413952L) >> 21)), 0) < this.f15785a) {
            int b10 = b();
            if (b10 == 1 && this.f15785a > 1) {
                b();
            }
            if (b10 > 0) {
                return true;
            }
        }
        return false;
    }

    public final boolean M() {
        c q10;
        do {
            q10 = q();
            if (q10 == null) {
                return false;
            }
        } while (!c.f15793h.compareAndSet(q10, -1, 0));
        LockSupport.unpark(q10);
        return true;
    }

    public final boolean a(h hVar) {
        return hVar.f15817b.b() == 1 ? this.f15790f.a(hVar) : this.f15789e.a(hVar);
    }

    public final int b() {
        synchronized (this.f15791g) {
            if (isTerminated()) {
                return -1;
            }
            long j10 = this.controlState;
            int i10 = (int) (j10 & 2097151);
            int a10 = y9.e.a(i10 - ((int) ((j10 & 4398044413952L) >> 21)), 0);
            if (a10 >= this.f15785a) {
                return 0;
            }
            if (i10 >= this.f15786b) {
                return 0;
            }
            int i11 = ((int) (this.controlState & 2097151)) + 1;
            if (!(i11 > 0 && this.f15791g.b(i11) == null)) {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            c cVar = new c(this, i11);
            this.f15791g.c(i11, cVar);
            if (!(i11 == ((int) (2097151 & f15782j.incrementAndGet(this))))) {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            cVar.start();
            return a10 + 1;
        }
    }

    public final h c(Runnable runnable, i iVar) {
        long a10 = l.f15824e.a();
        if (!(runnable instanceof h)) {
            return new k(runnable, a10, iVar);
        }
        h hVar = (h) runnable;
        hVar.f15816a = a10;
        hVar.f15817b = iVar;
        return hVar;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        x(NotificationOptions.SKIP_STEP_TEN_SECONDS_IN_MS);
    }

    public final c e() {
        Thread currentThread = Thread.currentThread();
        c cVar = currentThread instanceof c ? (c) currentThread : null;
        if (cVar == null || !t9.i.b(a.this, this)) {
            return null;
        }
        return cVar;
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        m(this, runnable, null, false, 6, null);
    }

    public final void f(Runnable runnable, i iVar, boolean z10) {
        ca.c.a();
        h c10 = c(runnable, iVar);
        c e10 = e();
        h E = E(e10, c10, z10);
        if (E != null && !a(E)) {
            throw new RejectedExecutionException(this.f15788d + " was terminated");
        }
        boolean z11 = z10 && e10 != null;
        if (c10.f15817b.b() != 0) {
            y(z11);
        } else {
            if (z11) {
                return;
            }
            z();
        }
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [boolean, int] */
    public final boolean isTerminated() {
        return this._isTerminated;
    }

    public final int n(c cVar) {
        Object h10 = cVar.h();
        while (h10 != f15784l) {
            if (h10 == null) {
                return 0;
            }
            c cVar2 = (c) h10;
            int g10 = cVar2.g();
            if (g10 != 0) {
                return g10;
            }
            h10 = cVar2.h();
        }
        return -1;
    }

    public final c q() {
        while (true) {
            long j10 = this.parkedWorkersStack;
            c cVar = (c) this.f15791g.b((int) (2097151 & j10));
            if (cVar == null) {
                return null;
            }
            long j11 = (2097152 + j10) & (-2097152);
            int n10 = n(cVar);
            if (n10 >= 0 && f15781i.compareAndSet(this, j10, n10 | j11)) {
                cVar.p(f15784l);
                return cVar;
            }
        }
    }

    public final boolean s(c cVar) {
        long j10;
        int g10;
        if (cVar.h() != f15784l) {
            return false;
        }
        do {
            j10 = this.parkedWorkersStack;
            g10 = cVar.g();
            cVar.p(this.f15791g.b((int) (2097151 & j10)));
        } while (!f15781i.compareAndSet(this, j10, ((2097152 + j10) & (-2097152)) | g10));
        return true;
    }

    public String toString() {
        ArrayList arrayList = new ArrayList();
        int a10 = this.f15791g.a();
        int i10 = 0;
        int i11 = 0;
        int i12 = 0;
        int i13 = 0;
        int i14 = 0;
        for (int i15 = 1; i15 < a10; i15++) {
            c cVar = (c) this.f15791g.b(i15);
            if (cVar != null) {
                int f10 = cVar.f15794a.f();
                int i16 = b.f15792a[cVar.f15795b.ordinal()];
                if (i16 == 1) {
                    i12++;
                } else if (i16 == 2) {
                    i11++;
                    StringBuilder sb = new StringBuilder();
                    sb.append(f10);
                    sb.append('b');
                    arrayList.add(sb.toString());
                } else if (i16 == 3) {
                    i10++;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(f10);
                    sb2.append('c');
                    arrayList.add(sb2.toString());
                } else if (i16 == 4) {
                    i13++;
                    if (f10 > 0) {
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append(f10);
                        sb3.append('d');
                        arrayList.add(sb3.toString());
                    }
                } else if (i16 == 5) {
                    i14++;
                }
            }
        }
        long j10 = this.controlState;
        return this.f15788d + '@' + g0.b(this) + "[Pool Size {core = " + this.f15785a + ", max = " + this.f15786b + "}, Worker States {CPU = " + i10 + ", blocking = " + i11 + ", parked = " + i12 + ", dormant = " + i13 + ", terminated = " + i14 + "}, running workers queues = " + arrayList + ", global CPU queue size = " + this.f15789e.c() + ", global blocking queue size = " + this.f15790f.c() + ", Control State {created workers= " + ((int) (2097151 & j10)) + ", blocking tasks = " + ((int) ((4398044413952L & j10) >> 21)) + ", CPUs acquired = " + (this.f15785a - ((int) ((9223367638808264704L & j10) >> 42))) + "}]";
    }

    public final void u(c cVar, int i10, int i11) {
        while (true) {
            long j10 = this.parkedWorkersStack;
            int i12 = (int) (2097151 & j10);
            long j11 = (2097152 + j10) & (-2097152);
            if (i12 == i10) {
                i12 = i11 == 0 ? n(cVar) : i11;
            }
            if (i12 >= 0 && f15781i.compareAndSet(this, j10, j11 | i12)) {
                return;
            }
        }
    }

    public final void v(h hVar) {
        try {
            hVar.run();
        } finally {
            try {
            } finally {
            }
        }
    }

    public final void x(long j10) {
        int i10;
        h hVar;
        if (f15783k.compareAndSet(this, 0, 1)) {
            c e10 = e();
            synchronized (this.f15791g) {
                i10 = (int) (this.controlState & 2097151);
            }
            if (1 <= i10) {
                int i11 = 1;
                while (true) {
                    Object b10 = this.f15791g.b(i11);
                    t9.i.d(b10);
                    c cVar = (c) b10;
                    if (cVar != e10) {
                        while (cVar.isAlive()) {
                            LockSupport.unpark(cVar);
                            cVar.join(j10);
                        }
                        cVar.f15794a.g(this.f15790f);
                    }
                    if (i11 == i10) {
                        break;
                    } else {
                        i11++;
                    }
                }
            }
            this.f15790f.b();
            this.f15789e.b();
            while (true) {
                if (e10 != null) {
                    hVar = e10.f(true);
                    if (hVar != null) {
                        continue;
                        v(hVar);
                    }
                }
                hVar = (h) this.f15789e.d();
                if (hVar == null && (hVar = (h) this.f15790f.d()) == null) {
                    break;
                }
                v(hVar);
            }
            if (e10 != null) {
                e10.s(d.TERMINATED);
            }
            this.parkedWorkersStack = 0L;
            this.controlState = 0L;
        }
    }

    public final void y(boolean z10) {
        long addAndGet = f15782j.addAndGet(this, 2097152L);
        if (z10 || M() || I(addAndGet)) {
            return;
        }
        M();
    }

    public final void z() {
        if (M() || L(this, 0L, 1, null)) {
            return;
        }
        M();
    }

    public final class c extends Thread {

        /* renamed from: h, reason: collision with root package name */
        public static final /* synthetic */ AtomicIntegerFieldUpdater f15793h = AtomicIntegerFieldUpdater.newUpdater(c.class, "workerCtl");

        /* renamed from: a, reason: collision with root package name */
        public final n f15794a;

        /* renamed from: b, reason: collision with root package name */
        public d f15795b;

        /* renamed from: c, reason: collision with root package name */
        public long f15796c;

        /* renamed from: d, reason: collision with root package name */
        public long f15797d;

        /* renamed from: e, reason: collision with root package name */
        public int f15798e;

        /* renamed from: f, reason: collision with root package name */
        public boolean f15799f;
        private volatile int indexInArray;
        private volatile Object nextParkedWorker;
        volatile /* synthetic */ int workerCtl;

        public c() {
            setDaemon(true);
            this.f15794a = new n();
            this.f15795b = d.DORMANT;
            this.workerCtl = 0;
            this.nextParkedWorker = a.f15784l;
            this.f15798e = w9.c.f19267a.b();
        }

        public final void b(int i10) {
            if (i10 == 0) {
                return;
            }
            a.f15782j.addAndGet(a.this, -2097152L);
            if (this.f15795b != d.TERMINATED) {
                this.f15795b = d.DORMANT;
            }
        }

        public final void c(int i10) {
            if (i10 != 0 && s(d.BLOCKING)) {
                a.this.z();
            }
        }

        public final void d(h hVar) {
            int b10 = hVar.f15817b.b();
            i(b10);
            c(b10);
            a.this.v(hVar);
            b(b10);
        }

        public final h e(boolean z10) {
            h m10;
            h m11;
            if (z10) {
                boolean z11 = k(a.this.f15785a * 2) == 0;
                if (z11 && (m11 = m()) != null) {
                    return m11;
                }
                h h10 = this.f15794a.h();
                if (h10 != null) {
                    return h10;
                }
                if (!z11 && (m10 = m()) != null) {
                    return m10;
                }
            } else {
                h m12 = m();
                if (m12 != null) {
                    return m12;
                }
            }
            return t(false);
        }

        public final h f(boolean z10) {
            h hVar;
            if (q()) {
                return e(z10);
            }
            if (z10) {
                hVar = this.f15794a.h();
                if (hVar == null) {
                    hVar = (h) a.this.f15790f.d();
                }
            } else {
                hVar = (h) a.this.f15790f.d();
            }
            return hVar == null ? t(true) : hVar;
        }

        public final int g() {
            return this.indexInArray;
        }

        public final Object h() {
            return this.nextParkedWorker;
        }

        public final void i(int i10) {
            this.f15796c = 0L;
            if (this.f15795b == d.PARKING) {
                this.f15795b = d.BLOCKING;
            }
        }

        public final boolean j() {
            return this.nextParkedWorker != a.f15784l;
        }

        public final int k(int i10) {
            int i11 = this.f15798e;
            int i12 = i11 ^ (i11 << 13);
            int i13 = i12 ^ (i12 >> 17);
            int i14 = i13 ^ (i13 << 5);
            this.f15798e = i14;
            int i15 = i10 - 1;
            return (i15 & i10) == 0 ? i14 & i15 : (i14 & Integer.MAX_VALUE) % i10;
        }

        public final void l() {
            if (this.f15796c == 0) {
                this.f15796c = System.nanoTime() + a.this.f15787c;
            }
            LockSupport.parkNanos(a.this.f15787c);
            if (System.nanoTime() - this.f15796c >= 0) {
                this.f15796c = 0L;
                u();
            }
        }

        public final h m() {
            if (k(2) == 0) {
                h hVar = (h) a.this.f15789e.d();
                return hVar != null ? hVar : (h) a.this.f15790f.d();
            }
            h hVar2 = (h) a.this.f15790f.d();
            return hVar2 != null ? hVar2 : (h) a.this.f15789e.d();
        }

        public final void n() {
            loop0: while (true) {
                boolean z10 = false;
                while (!a.this.isTerminated() && this.f15795b != d.TERMINATED) {
                    h f10 = f(this.f15799f);
                    if (f10 != null) {
                        this.f15797d = 0L;
                        d(f10);
                    } else {
                        this.f15799f = false;
                        if (this.f15797d == 0) {
                            r();
                        } else if (z10) {
                            s(d.PARKING);
                            Thread.interrupted();
                            LockSupport.parkNanos(this.f15797d);
                            this.f15797d = 0L;
                        } else {
                            z10 = true;
                        }
                    }
                }
            }
            s(d.TERMINATED);
        }

        public final void o(int i10) {
            StringBuilder sb = new StringBuilder();
            sb.append(a.this.f15788d);
            sb.append("-worker-");
            sb.append(i10 == 0 ? "TERMINATED" : String.valueOf(i10));
            setName(sb.toString());
            this.indexInArray = i10;
        }

        public final void p(Object obj) {
            this.nextParkedWorker = obj;
        }

        public final boolean q() {
            boolean z10;
            if (this.f15795b == d.CPU_ACQUIRED) {
                return true;
            }
            a aVar = a.this;
            while (true) {
                long j10 = aVar.controlState;
                if (((int) ((9223367638808264704L & j10) >> 42)) == 0) {
                    z10 = false;
                    break;
                }
                if (a.f15782j.compareAndSet(aVar, j10, j10 - 4398046511104L)) {
                    z10 = true;
                    break;
                }
            }
            if (!z10) {
                return false;
            }
            this.f15795b = d.CPU_ACQUIRED;
            return true;
        }

        public final void r() {
            if (!j()) {
                a.this.s(this);
                return;
            }
            this.workerCtl = -1;
            while (j() && this.workerCtl == -1 && !a.this.isTerminated() && this.f15795b != d.TERMINATED) {
                s(d.PARKING);
                Thread.interrupted();
                l();
            }
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            n();
        }

        public final boolean s(d dVar) {
            d dVar2 = this.f15795b;
            boolean z10 = dVar2 == d.CPU_ACQUIRED;
            if (z10) {
                a.f15782j.addAndGet(a.this, 4398046511104L);
            }
            if (dVar2 != dVar) {
                this.f15795b = dVar;
            }
            return z10;
        }

        public final h t(boolean z10) {
            int i10 = (int) (a.this.controlState & 2097151);
            if (i10 < 2) {
                return null;
            }
            int k10 = k(i10);
            a aVar = a.this;
            long j10 = Long.MAX_VALUE;
            for (int i11 = 0; i11 < i10; i11++) {
                k10++;
                if (k10 > i10) {
                    k10 = 1;
                }
                c cVar = (c) aVar.f15791g.b(k10);
                if (cVar != null && cVar != this) {
                    long k11 = z10 ? this.f15794a.k(cVar.f15794a) : this.f15794a.l(cVar.f15794a);
                    if (k11 == -1) {
                        return this.f15794a.h();
                    }
                    if (k11 > 0) {
                        j10 = Math.min(j10, k11);
                    }
                }
            }
            if (j10 == Long.MAX_VALUE) {
                j10 = 0;
            }
            this.f15797d = j10;
            return null;
        }

        public final void u() {
            a aVar = a.this;
            synchronized (aVar.f15791g) {
                if (aVar.isTerminated()) {
                    return;
                }
                if (((int) (aVar.controlState & 2097151)) <= aVar.f15785a) {
                    return;
                }
                if (f15793h.compareAndSet(this, -1, 1)) {
                    int i10 = this.indexInArray;
                    o(0);
                    aVar.u(this, i10, 0);
                    int andDecrement = (int) (2097151 & a.f15782j.getAndDecrement(aVar));
                    if (andDecrement != i10) {
                        Object b10 = aVar.f15791g.b(andDecrement);
                        t9.i.d(b10);
                        c cVar = (c) b10;
                        aVar.f15791g.c(i10, cVar);
                        cVar.o(i10);
                        aVar.u(cVar, andDecrement, i10);
                    }
                    aVar.f15791g.c(andDecrement, null);
                    t tVar = t.f14242a;
                    this.f15795b = d.TERMINATED;
                }
            }
        }

        public c(a aVar, int i10) {
            this();
            o(i10);
        }
    }
}
