package kotlinx.coroutines.internal;

import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* loaded from: classes3.dex */
public final class p {
    private volatile /* synthetic */ Object _next = null;
    private volatile /* synthetic */ long _state = 0;

    /* renamed from: a, reason: collision with root package name */
    public final int f15767a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f15768b;

    /* renamed from: c, reason: collision with root package name */
    public final int f15769c;

    /* renamed from: d, reason: collision with root package name */
    public /* synthetic */ AtomicReferenceArray f15770d;

    /* renamed from: e, reason: collision with root package name */
    public static final a f15763e = new a(null);

    /* renamed from: h, reason: collision with root package name */
    public static final y f15766h = new y("REMOVE_FROZEN");

    /* renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f15764f = AtomicReferenceFieldUpdater.newUpdater(p.class, Object.class, "_next");

    /* renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ AtomicLongFieldUpdater f15765g = AtomicLongFieldUpdater.newUpdater(p.class, "_state");

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(t9.g gVar) {
            this();
        }

        public final int a(long j10) {
            return (j10 & 2305843009213693952L) != 0 ? 2 : 1;
        }

        public final long b(long j10, int i10) {
            return d(j10, 1073741823L) | (i10 << 0);
        }

        public final long c(long j10, int i10) {
            return d(j10, 1152921503533105152L) | (i10 << 30);
        }

        public final long d(long j10, long j11) {
            return j10 & (j11 ^ (-1));
        }
    }

    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public final int f15771a;

        public b(int i10) {
            this.f15771a = i10;
        }
    }

    public p(int i10, boolean z10) {
        this.f15767a = i10;
        this.f15768b = z10;
        int i11 = i10 - 1;
        this.f15769c = i11;
        this.f15770d = new AtomicReferenceArray(i10);
        if (!(i11 <= 1073741823)) {
            throw new IllegalStateException("Check failed.".toString());
        }
        if (!((i10 & i11) == 0)) {
            throw new IllegalStateException("Check failed.".toString());
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x004c, code lost:
    
        return 1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final int a(Object obj) {
        while (true) {
            long j10 = this._state;
            if ((3458764513820540928L & j10) != 0) {
                return f15763e.a(j10);
            }
            int i10 = (int) ((1073741823 & j10) >> 0);
            int i11 = (int) ((1152921503533105152L & j10) >> 30);
            int i12 = this.f15769c;
            if (((i11 + 2) & i12) == (i10 & i12)) {
                return 1;
            }
            if (!this.f15768b && this.f15770d.get(i11 & i12) != null) {
                int i13 = this.f15767a;
                if (i13 < 1024 || ((i11 - i10) & 1073741823) > (i13 >> 1)) {
                    break;
                }
            } else if (f15765g.compareAndSet(this, j10, f15763e.c(j10, (i11 + 1) & 1073741823))) {
                this.f15770d.set(i11 & i12, obj);
                p pVar = this;
                while ((pVar._state & 1152921504606846976L) != 0 && (pVar = pVar.i().e(i11, obj)) != null) {
                }
                return 0;
            }
        }
    }

    public final p b(long j10) {
        p pVar = new p(this.f15767a * 2, this.f15768b);
        int i10 = (int) ((1073741823 & j10) >> 0);
        int i11 = (int) ((1152921503533105152L & j10) >> 30);
        while (true) {
            int i12 = this.f15769c;
            if ((i10 & i12) == (i11 & i12)) {
                pVar._state = f15763e.d(j10, 1152921504606846976L);
                return pVar;
            }
            Object obj = this.f15770d.get(i12 & i10);
            if (obj == null) {
                obj = new b(i10);
            }
            pVar.f15770d.set(pVar.f15769c & i10, obj);
            i10++;
        }
    }

    public final p c(long j10) {
        while (true) {
            p pVar = (p) this._next;
            if (pVar != null) {
                return pVar;
            }
            androidx.concurrent.futures.b.a(f15764f, this, null, b(j10));
        }
    }

    public final boolean d() {
        long j10;
        do {
            j10 = this._state;
            if ((j10 & 2305843009213693952L) != 0) {
                return true;
            }
            if ((1152921504606846976L & j10) != 0) {
                return false;
            }
        } while (!f15765g.compareAndSet(this, j10, j10 | 2305843009213693952L));
        return true;
    }

    public final p e(int i10, Object obj) {
        Object obj2 = this.f15770d.get(this.f15769c & i10);
        if (!(obj2 instanceof b) || ((b) obj2).f15771a != i10) {
            return null;
        }
        this.f15770d.set(i10 & this.f15769c, obj);
        return this;
    }

    public final int f() {
        long j10 = this._state;
        return 1073741823 & (((int) ((j10 & 1152921503533105152L) >> 30)) - ((int) ((1073741823 & j10) >> 0)));
    }

    public final boolean g() {
        long j10 = this._state;
        return ((int) ((1073741823 & j10) >> 0)) == ((int) ((j10 & 1152921503533105152L) >> 30));
    }

    public final long h() {
        long j10;
        long j11;
        do {
            j10 = this._state;
            if ((j10 & 1152921504606846976L) != 0) {
                return j10;
            }
            j11 = j10 | 1152921504606846976L;
        } while (!f15765g.compareAndSet(this, j10, j11));
        return j11;
    }

    public final p i() {
        return c(h());
    }

    public final Object j() {
        while (true) {
            long j10 = this._state;
            if ((1152921504606846976L & j10) != 0) {
                return f15766h;
            }
            int i10 = (int) ((1073741823 & j10) >> 0);
            int i11 = (int) ((1152921503533105152L & j10) >> 30);
            int i12 = this.f15769c;
            if ((i11 & i12) == (i10 & i12)) {
                return null;
            }
            Object obj = this.f15770d.get(i12 & i10);
            if (obj == null) {
                if (this.f15768b) {
                    return null;
                }
            } else {
                if (obj instanceof b) {
                    return null;
                }
                int i13 = (i10 + 1) & 1073741823;
                if (f15765g.compareAndSet(this, j10, f15763e.b(j10, i13))) {
                    this.f15770d.set(this.f15769c & i10, null);
                    return obj;
                }
                if (this.f15768b) {
                    p pVar = this;
                    do {
                        pVar = pVar.k(i10, i13);
                    } while (pVar != null);
                    return obj;
                }
            }
        }
    }

    public final p k(int i10, int i11) {
        long j10;
        int i12;
        do {
            j10 = this._state;
            i12 = (int) ((1073741823 & j10) >> 0);
            if ((1152921504606846976L & j10) != 0) {
                return i();
            }
        } while (!f15765g.compareAndSet(this, j10, f15763e.b(j10, i11)));
        this.f15770d.set(i12 & this.f15769c, null);
        return null;
    }
}
