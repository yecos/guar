package kotlinx.coroutines.scheduling;

import com.google.common.util.concurrent.r;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* loaded from: classes3.dex */
public final class n {

    /* renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f15828b = AtomicReferenceFieldUpdater.newUpdater(n.class, Object.class, "lastScheduledTask");

    /* renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f15829c = AtomicIntegerFieldUpdater.newUpdater(n.class, "producerIndex");

    /* renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f15830d = AtomicIntegerFieldUpdater.newUpdater(n.class, "consumerIndex");

    /* renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f15831e = AtomicIntegerFieldUpdater.newUpdater(n.class, "blockingTasksInBuffer");

    /* renamed from: a, reason: collision with root package name */
    public final AtomicReferenceArray f15832a = new AtomicReferenceArray(128);
    private volatile /* synthetic */ Object lastScheduledTask = null;
    private volatile /* synthetic */ int producerIndex = 0;
    private volatile /* synthetic */ int consumerIndex = 0;
    private volatile /* synthetic */ int blockingTasksInBuffer = 0;

    public static /* synthetic */ h b(n nVar, h hVar, boolean z10, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            z10 = false;
        }
        return nVar.a(hVar, z10);
    }

    public final h a(h hVar, boolean z10) {
        if (z10) {
            return c(hVar);
        }
        h hVar2 = (h) f15828b.getAndSet(this, hVar);
        if (hVar2 == null) {
            return null;
        }
        return c(hVar2);
    }

    public final h c(h hVar) {
        if (hVar.f15817b.b() == 1) {
            f15831e.incrementAndGet(this);
        }
        if (e() == 127) {
            return hVar;
        }
        int i10 = this.producerIndex & 127;
        while (this.f15832a.get(i10) != null) {
            Thread.yield();
        }
        this.f15832a.lazySet(i10, hVar);
        f15829c.incrementAndGet(this);
        return null;
    }

    public final void d(h hVar) {
        if (hVar != null) {
            if (hVar.f15817b.b() == 1) {
                f15831e.decrementAndGet(this);
            }
        }
    }

    public final int e() {
        return this.producerIndex - this.consumerIndex;
    }

    public final int f() {
        return this.lastScheduledTask != null ? e() + 1 : e();
    }

    public final void g(d dVar) {
        h hVar = (h) f15828b.getAndSet(this, null);
        if (hVar != null) {
            dVar.a(hVar);
        }
        while (j(dVar)) {
        }
    }

    public final h h() {
        h hVar = (h) f15828b.getAndSet(this, null);
        return hVar == null ? i() : hVar;
    }

    public final h i() {
        h hVar;
        while (true) {
            int i10 = this.consumerIndex;
            if (i10 - this.producerIndex == 0) {
                return null;
            }
            int i11 = i10 & 127;
            if (f15830d.compareAndSet(this, i10, i10 + 1) && (hVar = (h) this.f15832a.getAndSet(i11, null)) != null) {
                d(hVar);
                return hVar;
            }
        }
    }

    public final boolean j(d dVar) {
        h i10 = i();
        if (i10 == null) {
            return false;
        }
        dVar.a(i10);
        return true;
    }

    public final long k(n nVar) {
        int i10 = nVar.consumerIndex;
        int i11 = nVar.producerIndex;
        AtomicReferenceArray atomicReferenceArray = nVar.f15832a;
        while (true) {
            if (i10 == i11) {
                break;
            }
            int i12 = i10 & 127;
            if (nVar.blockingTasksInBuffer == 0) {
                break;
            }
            h hVar = (h) atomicReferenceArray.get(i12);
            if (hVar != null) {
                if ((hVar.f15817b.b() == 1) && r.a(atomicReferenceArray, i12, hVar, null)) {
                    f15831e.decrementAndGet(nVar);
                    b(this, hVar, false, 2, null);
                    return -1L;
                }
            }
            i10++;
        }
        return m(nVar, true);
    }

    public final long l(n nVar) {
        h i10 = nVar.i();
        if (i10 == null) {
            return m(nVar, false);
        }
        b(this, i10, false, 2, null);
        return -1L;
    }

    public final long m(n nVar, boolean z10) {
        h hVar;
        do {
            hVar = (h) nVar.lastScheduledTask;
            if (hVar == null) {
                return -2L;
            }
            if (z10) {
                if (!(hVar.f15817b.b() == 1)) {
                    return -2L;
                }
            }
            long a10 = l.f15824e.a() - hVar.f15816a;
            long j10 = l.f15820a;
            if (a10 < j10) {
                return j10 - a10;
            }
        } while (!androidx.concurrent.futures.b.a(f15828b, nVar, hVar, null));
        b(this, hVar, false, 2, null);
        return -1L;
    }
}
