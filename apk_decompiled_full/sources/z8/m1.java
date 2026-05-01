package z8;

import com.google.common.base.Preconditions;
import y8.b;

/* loaded from: classes3.dex */
public final class m1 extends b.a {

    /* renamed from: a, reason: collision with root package name */
    public final s f20738a;

    /* renamed from: b, reason: collision with root package name */
    public final y8.w0 f20739b;

    /* renamed from: c, reason: collision with root package name */
    public final y8.v0 f20740c;

    /* renamed from: d, reason: collision with root package name */
    public final y8.c f20741d;

    /* renamed from: f, reason: collision with root package name */
    public final a f20743f;

    /* renamed from: g, reason: collision with root package name */
    public final y8.k[] f20744g;

    /* renamed from: i, reason: collision with root package name */
    public q f20746i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f20747j;

    /* renamed from: k, reason: collision with root package name */
    public b0 f20748k;

    /* renamed from: h, reason: collision with root package name */
    public final Object f20745h = new Object();

    /* renamed from: e, reason: collision with root package name */
    public final y8.r f20742e = y8.r.e();

    public interface a {
        void onComplete();
    }

    public m1(s sVar, y8.w0 w0Var, y8.v0 v0Var, y8.c cVar, a aVar, y8.k[] kVarArr) {
        this.f20738a = sVar;
        this.f20739b = w0Var;
        this.f20740c = v0Var;
        this.f20741d = cVar;
        this.f20743f = aVar;
        this.f20744g = kVarArr;
    }

    public void a(y8.k1 k1Var) {
        Preconditions.checkArgument(!k1Var.p(), "Cannot fail with OK status");
        Preconditions.checkState(!this.f20747j, "apply() or fail() already called");
        b(new f0(q0.n(k1Var), this.f20744g));
    }

    public final void b(q qVar) {
        boolean z10;
        Preconditions.checkState(!this.f20747j, "already finalized");
        this.f20747j = true;
        synchronized (this.f20745h) {
            if (this.f20746i == null) {
                this.f20746i = qVar;
                z10 = true;
            } else {
                z10 = false;
            }
        }
        if (z10) {
            this.f20743f.onComplete();
            return;
        }
        Preconditions.checkState(this.f20748k != null, "delayedStream is null");
        Runnable w10 = this.f20748k.w(qVar);
        if (w10 != null) {
            w10.run();
        }
        this.f20743f.onComplete();
    }

    public q c() {
        synchronized (this.f20745h) {
            q qVar = this.f20746i;
            if (qVar != null) {
                return qVar;
            }
            b0 b0Var = new b0();
            this.f20748k = b0Var;
            this.f20746i = b0Var;
            return b0Var;
        }
    }
}
