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
    */
    public void run() {
        Object obj;
        while (true) {
            int i10 = 0;
            while (true) {
                Runnable runnable = (Runnable) this.f15753f.d();
                if (runnable == null) {
                    break;
                }
                try {
                    runnable.run();
                } catch (Throwable th) {
                    ca.b0.a(k9.g.f15708a, th);
                }
                i10++;
                if (i10 >= 16 && this.f15750c.M(this)) {
                    this.f15750c.L(this, this);
                    return;
                }
            }
        }
    }
}
