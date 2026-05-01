package z8;

import com.google.common.base.Preconditions;
import com.hpplay.component.common.ParamsMap;
import com.hpplay.sdk.source.common.global.Constant;
import java.net.SocketAddress;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.atomic.AtomicInteger;
import y8.b;
import z8.m1;
import z8.t;

/* loaded from: classes3.dex */
public final class l implements t {

    /* renamed from: a, reason: collision with root package name */
    public final t f20698a;

    /* renamed from: b, reason: collision with root package name */
    public final y8.b f20699b;

    /* renamed from: c, reason: collision with root package name */
    public final Executor f20700c;

    public class a extends j0 {

        /* renamed from: a, reason: collision with root package name */
        public final v f20701a;

        /* renamed from: b, reason: collision with root package name */
        public final String f20702b;

        /* renamed from: d, reason: collision with root package name */
        public volatile y8.k1 f20704d;

        /* renamed from: e, reason: collision with root package name */
        public y8.k1 f20705e;

        /* renamed from: f, reason: collision with root package name */
        public y8.k1 f20706f;

        /* renamed from: c, reason: collision with root package name */
        public final AtomicInteger f20703c = new AtomicInteger(ParamsMap.MirrorParams.CAPTRUESOURCE_FLAG_MIUI);

        /* renamed from: g, reason: collision with root package name */
        public final m1.a f20707g = new C0358a();

        /* renamed from: z8.l$a$a, reason: collision with other inner class name */
        public class C0358a implements m1.a {
            public C0358a() {
            }

            @Override // z8.m1.a
            public void onComplete() {
                if (a.this.f20703c.decrementAndGet() == 0) {
                    a.this.j();
                }
            }
        }

        public class b extends b.AbstractC0344b {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ y8.w0 f20710a;

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ y8.c f20711b;

            public b(y8.w0 w0Var, y8.c cVar) {
                this.f20710a = w0Var;
                this.f20711b = cVar;
            }
        }

        public a(v vVar, String str) {
            this.f20701a = (v) Preconditions.checkNotNull(vVar, "delegate");
            this.f20702b = (String) Preconditions.checkNotNull(str, "authority");
        }

        @Override // z8.j0
        public v a() {
            return this.f20701a;
        }

        @Override // z8.j0, z8.s
        public q b(y8.w0 w0Var, y8.v0 v0Var, y8.c cVar, y8.k[] kVarArr) {
            y8.b c10 = cVar.c();
            if (c10 == null) {
                c10 = l.this.f20699b;
            } else if (l.this.f20699b != null) {
                c10 = new y8.m(l.this.f20699b, c10);
            }
            if (c10 == null) {
                return this.f20703c.get() >= 0 ? new f0(this.f20704d, kVarArr) : this.f20701a.b(w0Var, v0Var, cVar, kVarArr);
            }
            m1 m1Var = new m1(this.f20701a, w0Var, v0Var, cVar, this.f20707g, kVarArr);
            if (this.f20703c.incrementAndGet() > 0) {
                this.f20707g.onComplete();
                return new f0(this.f20704d, kVarArr);
            }
            try {
                c10.a(new b(w0Var, cVar), l.this.f20700c, m1Var);
            } catch (Throwable th) {
                m1Var.a(y8.k1.f19897n.r("Credentials should use fail() instead of throwing exceptions").q(th));
            }
            return m1Var.c();
        }

        @Override // z8.j0, z8.j1
        public void c(y8.k1 k1Var) {
            Preconditions.checkNotNull(k1Var, Constant.KEY_STATUS);
            synchronized (this) {
                if (this.f20703c.get() < 0) {
                    this.f20704d = k1Var;
                    this.f20703c.addAndGet(Integer.MAX_VALUE);
                    if (this.f20703c.get() != 0) {
                        this.f20705e = k1Var;
                    } else {
                        super.c(k1Var);
                    }
                }
            }
        }

        @Override // z8.j0, z8.j1
        public void g(y8.k1 k1Var) {
            Preconditions.checkNotNull(k1Var, Constant.KEY_STATUS);
            synchronized (this) {
                if (this.f20703c.get() < 0) {
                    this.f20704d = k1Var;
                    this.f20703c.addAndGet(Integer.MAX_VALUE);
                } else if (this.f20706f != null) {
                    return;
                }
                if (this.f20703c.get() != 0) {
                    this.f20706f = k1Var;
                } else {
                    super.g(k1Var);
                }
            }
        }

        public final void j() {
            synchronized (this) {
                if (this.f20703c.get() != 0) {
                    return;
                }
                y8.k1 k1Var = this.f20705e;
                y8.k1 k1Var2 = this.f20706f;
                this.f20705e = null;
                this.f20706f = null;
                if (k1Var != null) {
                    super.c(k1Var);
                }
                if (k1Var2 != null) {
                    super.g(k1Var2);
                }
            }
        }
    }

    public l(t tVar, y8.b bVar, Executor executor) {
        this.f20698a = (t) Preconditions.checkNotNull(tVar, "delegate");
        this.f20699b = bVar;
        this.f20700c = (Executor) Preconditions.checkNotNull(executor, "appExecutor");
    }

    @Override // z8.t
    public v J(SocketAddress socketAddress, t.a aVar, y8.f fVar) {
        return new a(this.f20698a.J(socketAddress, aVar, fVar), aVar.a());
    }

    @Override // z8.t, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f20698a.close();
    }

    @Override // z8.t
    public ScheduledExecutorService p() {
        return this.f20698a.p();
    }
}
