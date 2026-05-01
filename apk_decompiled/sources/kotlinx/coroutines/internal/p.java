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
        To view partially-correct add '--show-bad-code' argument
    */
    public final int a(java.lang.Object r13) {
        /*
            r12 = this;
        L0:
            long r2 = r12._state
            r0 = 3458764513820540928(0x3000000000000000, double:1.727233711018889E-77)
            long r0 = r0 & r2
            r6 = 0
            int r4 = (r0 > r6 ? 1 : (r0 == r6 ? 0 : -1))
            if (r4 == 0) goto L12
            kotlinx.coroutines.internal.p$a r13 = kotlinx.coroutines.internal.p.f15763e
            int r13 = r13.a(r2)
            return r13
        L12:
            r0 = 1073741823(0x3fffffff, double:5.304989472E-315)
            long r0 = r0 & r2
            r8 = 0
            long r0 = r0 >> r8
            int r1 = (int) r0
            r4 = 1152921503533105152(0xfffffffc0000000, double:1.2882296003504729E-231)
            long r4 = r4 & r2
            r0 = 30
            long r4 = r4 >> r0
            int r9 = (int) r4
            int r10 = r12.f15769c
            int r0 = r9 + 2
            r0 = r0 & r10
            r4 = r1 & r10
            r5 = 1
            if (r0 != r4) goto L2e
            return r5
        L2e:
            boolean r0 = r12.f15768b
            r4 = 1073741823(0x3fffffff, float:1.9999999)
            if (r0 != 0) goto L4d
            java.util.concurrent.atomic.AtomicReferenceArray r0 = r12.f15770d
            r11 = r9 & r10
            java.lang.Object r0 = r0.get(r11)
            if (r0 == 0) goto L4d
            int r0 = r12.f15767a
            r2 = 1024(0x400, float:1.435E-42)
            if (r0 < r2) goto L4c
            int r9 = r9 - r1
            r1 = r9 & r4
            int r0 = r0 >> 1
            if (r1 <= r0) goto L0
        L4c:
            return r5
        L4d:
            int r0 = r9 + 1
            r0 = r0 & r4
            java.util.concurrent.atomic.AtomicLongFieldUpdater r1 = kotlinx.coroutines.internal.p.f15765g
            kotlinx.coroutines.internal.p$a r4 = kotlinx.coroutines.internal.p.f15763e
            long r4 = r4.c(r2, r0)
            r0 = r1
            r1 = r12
            boolean r0 = r0.compareAndSet(r1, r2, r4)
            if (r0 == 0) goto L0
            java.util.concurrent.atomic.AtomicReferenceArray r0 = r12.f15770d
            r1 = r9 & r10
            r0.set(r1, r13)
            r0 = r12
        L68:
            long r1 = r0._state
            r3 = 1152921504606846976(0x1000000000000000, double:1.2882297539194267E-231)
            long r1 = r1 & r3
            int r3 = (r1 > r6 ? 1 : (r1 == r6 ? 0 : -1))
            if (r3 == 0) goto L7b
            kotlinx.coroutines.internal.p r0 = r0.i()
            kotlinx.coroutines.internal.p r0 = r0.e(r9, r13)
            if (r0 != 0) goto L68
        L7b:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.internal.p.a(java.lang.Object):int");
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
