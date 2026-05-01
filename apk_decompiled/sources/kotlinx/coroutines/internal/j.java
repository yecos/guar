package kotlinx.coroutines.internal;

import ca.i0;
import ca.j0;

/* loaded from: classes3.dex */
public final class j extends ca.y implements Runnable, j0 {

    /* renamed from: c, reason: collision with root package name */
    public final ca.y f15750c;

    /* renamed from: d, reason: collision with root package name */
    public final int f15751d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ j0 f15752e;

    /* renamed from: f, reason: collision with root package name */
    public final o f15753f;

    /* renamed from: g, reason: collision with root package name */
    public final Object f15754g;
    private volatile int runningWorkers;

    /* JADX WARN: Multi-variable type inference failed */
    public j(ca.y yVar, int i10) {
        this.f15750c = yVar;
        this.f15751d = i10;
        j0 j0Var = yVar instanceof j0 ? (j0) yVar : null;
        this.f15752e = j0Var == null ? i0.a() : j0Var;
        this.f15753f = new o(false);
        this.f15754g = new Object();
    }

    @Override // ca.y
    public void L(k9.f fVar, Runnable runnable) {
        if (O(runnable) || !P()) {
            return;
        }
        this.f15750c.L(this, this);
    }

    public final boolean O(Runnable runnable) {
        this.f15753f.a(runnable);
        return this.runningWorkers >= this.f15751d;
    }

    public final boolean P() {
        synchronized (this.f15754g) {
            if (this.runningWorkers >= this.f15751d) {
                return false;
            }
            this.runningWorkers++;
            return true;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x002a, code lost:
    
        r1 = r4.f15754g;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x002c, code lost:
    
        monitor-enter(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x002d, code lost:
    
        r4.runningWorkers--;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0039, code lost:
    
        if (r4.f15753f.c() != 0) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x003d, code lost:
    
        r4.runningWorkers++;
        r2 = h9.t.f14242a;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x003b, code lost:
    
        monitor-exit(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x003c, code lost:
    
        return;
     */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void run() {
        /*
            r4 = this;
            r0 = 0
        L1:
            r1 = 0
        L2:
            kotlinx.coroutines.internal.o r2 = r4.f15753f
            java.lang.Object r2 = r2.d()
            java.lang.Runnable r2 = (java.lang.Runnable) r2
            if (r2 == 0) goto L2a
            r2.run()     // Catch: java.lang.Throwable -> L10
            goto L16
        L10:
            r2 = move-exception
            k9.g r3 = k9.g.f15708a
            ca.b0.a(r3, r2)
        L16:
            int r1 = r1 + 1
            r2 = 16
            if (r1 < r2) goto L2
            ca.y r2 = r4.f15750c
            boolean r2 = r2.M(r4)
            if (r2 == 0) goto L2
            ca.y r0 = r4.f15750c
            r0.L(r4, r4)
            return
        L2a:
            java.lang.Object r1 = r4.f15754g
            monitor-enter(r1)
            int r2 = r4.runningWorkers     // Catch: java.lang.Throwable -> L47
            int r2 = r2 + (-1)
            r4.runningWorkers = r2     // Catch: java.lang.Throwable -> L47
            kotlinx.coroutines.internal.o r2 = r4.f15753f     // Catch: java.lang.Throwable -> L47
            int r2 = r2.c()     // Catch: java.lang.Throwable -> L47
            if (r2 != 0) goto L3d
            monitor-exit(r1)
            return
        L3d:
            int r2 = r4.runningWorkers     // Catch: java.lang.Throwable -> L47
            int r2 = r2 + 1
            r4.runningWorkers = r2     // Catch: java.lang.Throwable -> L47
            h9.t r2 = h9.t.f14242a     // Catch: java.lang.Throwable -> L47
            monitor-exit(r1)
            goto L1
        L47:
            r0 = move-exception
            monitor-exit(r1)
            goto L4b
        L4a:
            throw r0
        L4b:
            goto L4a
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.internal.j.run():void");
    }
}
