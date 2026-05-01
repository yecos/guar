package kotlinx.coroutines.internal;

import ca.g0;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* loaded from: classes3.dex */
public class n {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f15757a = AtomicReferenceFieldUpdater.newUpdater(n.class, Object.class, "_next");

    /* renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f15758b = AtomicReferenceFieldUpdater.newUpdater(n.class, Object.class, "_prev");

    /* renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f15759c = AtomicReferenceFieldUpdater.newUpdater(n.class, Object.class, "_removedRef");
    volatile /* synthetic */ Object _next = this;
    volatile /* synthetic */ Object _prev = this;
    private volatile /* synthetic */ Object _removedRef = null;

    public static abstract class a extends c {

        /* renamed from: b, reason: collision with root package name */
        public final n f15760b;

        /* renamed from: c, reason: collision with root package name */
        public n f15761c;

        public a(n nVar) {
            this.f15760b = nVar;
        }

        @Override // kotlinx.coroutines.internal.c
        /* renamed from: h, reason: merged with bridge method [inline-methods] */
        public void d(n nVar, Object obj) {
            boolean z10 = obj == null;
            n nVar2 = z10 ? this.f15760b : this.f15761c;
            if (nVar2 != null && androidx.concurrent.futures.b.a(n.f15757a, nVar, this, nVar2) && z10) {
                n nVar3 = this.f15760b;
                n nVar4 = this.f15761c;
                t9.i.d(nVar4);
                nVar3.h(nVar4);
            }
        }
    }

    public final boolean e(n nVar) {
        f15758b.lazySet(nVar, this);
        f15757a.lazySet(nVar, this);
        while (i() == this) {
            if (androidx.concurrent.futures.b.a(f15757a, this, this, nVar)) {
                nVar.h(this);
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x0048, code lost:
    
        if (androidx.concurrent.futures.b.a(kotlinx.coroutines.internal.n.f15757a, r3, r2, ((kotlinx.coroutines.internal.v) r4).f15778a) != false) goto L30;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final kotlinx.coroutines.internal.n f(kotlinx.coroutines.internal.u r8) {
        /*
            r7 = this;
        L0:
            java.lang.Object r0 = r7._prev
            kotlinx.coroutines.internal.n r0 = (kotlinx.coroutines.internal.n) r0
            r1 = 0
            r2 = r0
        L6:
            r3 = r1
        L7:
            java.lang.Object r4 = r2._next
            if (r4 != r7) goto L18
            if (r0 != r2) goto Le
            return r2
        Le:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r1 = kotlinx.coroutines.internal.n.f15758b
            boolean r0 = androidx.concurrent.futures.b.a(r1, r7, r0, r2)
            if (r0 != 0) goto L17
            goto L0
        L17:
            return r2
        L18:
            boolean r5 = r7.l()
            if (r5 == 0) goto L1f
            return r1
        L1f:
            if (r4 != r8) goto L22
            return r2
        L22:
            boolean r5 = r4 instanceof kotlinx.coroutines.internal.u
            if (r5 == 0) goto L38
            if (r8 == 0) goto L32
            r0 = r4
            kotlinx.coroutines.internal.u r0 = (kotlinx.coroutines.internal.u) r0
            boolean r0 = r8.b(r0)
            if (r0 == 0) goto L32
            return r1
        L32:
            kotlinx.coroutines.internal.u r4 = (kotlinx.coroutines.internal.u) r4
            r4.c(r2)
            goto L0
        L38:
            boolean r5 = r4 instanceof kotlinx.coroutines.internal.v
            if (r5 == 0) goto L52
            if (r3 == 0) goto L4d
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r5 = kotlinx.coroutines.internal.n.f15757a
            kotlinx.coroutines.internal.v r4 = (kotlinx.coroutines.internal.v) r4
            kotlinx.coroutines.internal.n r4 = r4.f15778a
            boolean r2 = androidx.concurrent.futures.b.a(r5, r3, r2, r4)
            if (r2 != 0) goto L4b
            goto L0
        L4b:
            r2 = r3
            goto L6
        L4d:
            java.lang.Object r2 = r2._prev
            kotlinx.coroutines.internal.n r2 = (kotlinx.coroutines.internal.n) r2
            goto L7
        L52:
            r3 = r4
            kotlinx.coroutines.internal.n r3 = (kotlinx.coroutines.internal.n) r3
            r6 = r3
            r3 = r2
            r2 = r6
            goto L7
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.internal.n.f(kotlinx.coroutines.internal.u):kotlinx.coroutines.internal.n");
    }

    public final n g(n nVar) {
        while (nVar.l()) {
            nVar = (n) nVar._prev;
        }
        return nVar;
    }

    public final void h(n nVar) {
        n nVar2;
        do {
            nVar2 = (n) nVar._prev;
            if (i() != nVar) {
                return;
            }
        } while (!androidx.concurrent.futures.b.a(f15758b, nVar, nVar2, this));
        if (l()) {
            nVar.f(null);
        }
    }

    public final Object i() {
        while (true) {
            Object obj = this._next;
            if (!(obj instanceof u)) {
                return obj;
            }
            ((u) obj).c(this);
        }
    }

    public final n j() {
        return m.b(i());
    }

    public final n k() {
        n f10 = f(null);
        return f10 == null ? g((n) this._prev) : f10;
    }

    public boolean l() {
        return i() instanceof v;
    }

    public boolean m() {
        return n() == null;
    }

    public final n n() {
        Object i10;
        n nVar;
        do {
            i10 = i();
            if (i10 instanceof v) {
                return ((v) i10).f15778a;
            }
            if (i10 == this) {
                return (n) i10;
            }
            nVar = (n) i10;
        } while (!androidx.concurrent.futures.b.a(f15757a, this, i10, nVar.o()));
        nVar.f(null);
        return null;
    }

    public final v o() {
        v vVar = (v) this._removedRef;
        if (vVar != null) {
            return vVar;
        }
        v vVar2 = new v(this);
        f15759c.lazySet(this, vVar2);
        return vVar2;
    }

    public final int p(n nVar, n nVar2, a aVar) {
        f15758b.lazySet(nVar, this);
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f15757a;
        atomicReferenceFieldUpdater.lazySet(nVar, nVar2);
        aVar.f15761c = nVar2;
        if (androidx.concurrent.futures.b.a(atomicReferenceFieldUpdater, this, nVar2, aVar)) {
            return aVar.c(this) == null ? 1 : 2;
        }
        return 0;
    }

    public String toString() {
        return new t9.p(this) { // from class: kotlinx.coroutines.internal.n.b
            @Override // z9.e
            public Object get() {
                return g0.a(this.f18942b);
            }
        } + '@' + g0.b(this);
    }
}
