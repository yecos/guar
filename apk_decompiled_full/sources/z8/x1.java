package z8;

import anet.channel.entity.ConnType;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.taobao.accs.flowcontrol.FlowControl;
import java.io.InputStream;
import java.lang.Thread;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import y8.k;
import y8.v0;
import z8.i2;
import z8.r;

/* loaded from: classes3.dex */
public abstract class x1 implements z8.q {
    public static final v0.g A;
    public static final v0.g B;
    public static final y8.k1 C;
    public static Random D;

    /* renamed from: a, reason: collision with root package name */
    public final y8.w0 f21036a;

    /* renamed from: b, reason: collision with root package name */
    public final Executor f21037b;

    /* renamed from: d, reason: collision with root package name */
    public final ScheduledExecutorService f21039d;

    /* renamed from: e, reason: collision with root package name */
    public final y8.v0 f21040e;

    /* renamed from: f, reason: collision with root package name */
    public final y1 f21041f;

    /* renamed from: g, reason: collision with root package name */
    public final s0 f21042g;

    /* renamed from: h, reason: collision with root package name */
    public final boolean f21043h;

    /* renamed from: j, reason: collision with root package name */
    public final t f21045j;

    /* renamed from: k, reason: collision with root package name */
    public final long f21046k;

    /* renamed from: l, reason: collision with root package name */
    public final long f21047l;

    /* renamed from: m, reason: collision with root package name */
    public final c0 f21048m;

    /* renamed from: s, reason: collision with root package name */
    public y8.k1 f21054s;

    /* renamed from: t, reason: collision with root package name */
    public long f21055t;

    /* renamed from: u, reason: collision with root package name */
    public z8.r f21056u;

    /* renamed from: v, reason: collision with root package name */
    public u f21057v;

    /* renamed from: w, reason: collision with root package name */
    public u f21058w;

    /* renamed from: x, reason: collision with root package name */
    public long f21059x;

    /* renamed from: y, reason: collision with root package name */
    public y8.k1 f21060y;

    /* renamed from: z, reason: collision with root package name */
    public boolean f21061z;

    /* renamed from: c, reason: collision with root package name */
    public final Executor f21038c = new y8.o1(new a());

    /* renamed from: i, reason: collision with root package name */
    public final Object f21044i = new Object();

    /* renamed from: n, reason: collision with root package name */
    public final w0 f21049n = new w0();

    /* renamed from: o, reason: collision with root package name */
    public volatile z f21050o = new z(new ArrayList(8), Collections.emptyList(), null, null, false, false, false, 0);

    /* renamed from: p, reason: collision with root package name */
    public final AtomicBoolean f21051p = new AtomicBoolean();

    /* renamed from: q, reason: collision with root package name */
    public final AtomicInteger f21052q = new AtomicInteger();

    /* renamed from: r, reason: collision with root package name */
    public final AtomicInteger f21053r = new AtomicInteger();

    public class a implements Thread.UncaughtExceptionHandler {
        public a() {
        }

        @Override // java.lang.Thread.UncaughtExceptionHandler
        public void uncaughtException(Thread thread, Throwable th) {
            throw y8.k1.l(th).r("Uncaught exception in the SynchronizationContext. Re-thrown.").d();
        }
    }

    public final class a0 implements z8.r {

        /* renamed from: a, reason: collision with root package name */
        public final b0 f21063a;

        public class a implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ y8.v0 f21065a;

            public a(y8.v0 v0Var) {
                this.f21065a = v0Var;
            }

            @Override // java.lang.Runnable
            public void run() {
                x1.this.f21056u.b(this.f21065a);
            }
        }

        public class b implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ b0 f21067a;

            public class a implements Runnable {
                public a() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    b bVar = b.this;
                    x1.this.f0(bVar.f21067a);
                }
            }

            public b(b0 b0Var) {
                this.f21067a = b0Var;
            }

            @Override // java.lang.Runnable
            public void run() {
                x1.this.f21037b.execute(new a());
            }
        }

        public class c implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ b0 f21070a;

            public c(b0 b0Var) {
                this.f21070a = b0Var;
            }

            @Override // java.lang.Runnable
            public void run() {
                x1.this.f0(this.f21070a);
            }
        }

        public class d implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ i2.a f21072a;

            public d(i2.a aVar) {
                this.f21072a = aVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                x1.this.f21056u.a(this.f21072a);
            }
        }

        public class e implements Runnable {
            public e() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (x1.this.f21061z) {
                    return;
                }
                x1.this.f21056u.d();
            }
        }

        public a0(b0 b0Var) {
            this.f21063a = b0Var;
        }

        @Override // z8.i2
        public void a(i2.a aVar) {
            z zVar = x1.this.f21050o;
            Preconditions.checkState(zVar.f21137f != null, "Headers should be received prior to messages.");
            if (zVar.f21137f != this.f21063a) {
                return;
            }
            x1.this.f21038c.execute(new d(aVar));
        }

        @Override // z8.r
        public void b(y8.v0 v0Var) {
            x1.this.c0(this.f21063a);
            if (x1.this.f21050o.f21137f == this.f21063a) {
                if (x1.this.f21048m != null) {
                    x1.this.f21048m.c();
                }
                x1.this.f21038c.execute(new a(v0Var));
            }
        }

        @Override // z8.r
        public void c(y8.k1 k1Var, r.a aVar, y8.v0 v0Var) {
            u uVar;
            synchronized (x1.this.f21044i) {
                x1 x1Var = x1.this;
                x1Var.f21050o = x1Var.f21050o.g(this.f21063a);
                x1.this.f21049n.a(k1Var.n());
            }
            if (x1.this.f21053r.decrementAndGet() == Integer.MIN_VALUE) {
                x1 x1Var2 = x1.this;
                x1Var2.m0(x1Var2.f21054s, r.a.PROCESSED, new y8.v0());
                return;
            }
            b0 b0Var = this.f21063a;
            if (b0Var.f21079c) {
                x1.this.c0(b0Var);
                if (x1.this.f21050o.f21137f == this.f21063a) {
                    x1.this.m0(k1Var, aVar, v0Var);
                    return;
                }
                return;
            }
            r.a aVar2 = r.a.MISCARRIED;
            if (aVar == aVar2 && x1.this.f21052q.incrementAndGet() > 1000) {
                x1.this.c0(this.f21063a);
                if (x1.this.f21050o.f21137f == this.f21063a) {
                    x1.this.m0(y8.k1.f19903t.r("Too many transparent retries. Might be a bug in gRPC").q(k1Var.d()), aVar, v0Var);
                    return;
                }
                return;
            }
            if (x1.this.f21050o.f21137f == null) {
                boolean z10 = false;
                if (aVar == aVar2 || (aVar == r.a.REFUSED && x1.this.f21051p.compareAndSet(false, true))) {
                    b0 d02 = x1.this.d0(this.f21063a.f21080d, true);
                    if (d02 == null) {
                        return;
                    }
                    if (x1.this.f21043h) {
                        synchronized (x1.this.f21044i) {
                            x1 x1Var3 = x1.this;
                            x1Var3.f21050o = x1Var3.f21050o.f(this.f21063a, d02);
                            x1 x1Var4 = x1.this;
                            if (!x1Var4.h0(x1Var4.f21050o) && x1.this.f21050o.f21135d.size() == 1) {
                                z10 = true;
                            }
                        }
                        if (z10) {
                            x1.this.c0(d02);
                        }
                    } else if (x1.this.f21041f == null || x1.this.f21041f.f21141a == 1) {
                        x1.this.c0(d02);
                    }
                    x1.this.f21037b.execute(new c(d02));
                    return;
                }
                if (aVar != r.a.DROPPED) {
                    x1.this.f21051p.set(true);
                    if (x1.this.f21043h) {
                        v f10 = f(k1Var, v0Var);
                        if (f10.f21123a) {
                            x1.this.l0(f10.f21124b);
                        }
                        synchronized (x1.this.f21044i) {
                            x1 x1Var5 = x1.this;
                            x1Var5.f21050o = x1Var5.f21050o.e(this.f21063a);
                            if (f10.f21123a) {
                                x1 x1Var6 = x1.this;
                                if (x1Var6.h0(x1Var6.f21050o) || !x1.this.f21050o.f21135d.isEmpty()) {
                                    return;
                                }
                            }
                        }
                    } else {
                        x g10 = g(k1Var, v0Var);
                        if (g10.f21129a) {
                            b0 d03 = x1.this.d0(this.f21063a.f21080d + 1, false);
                            if (d03 == null) {
                                return;
                            }
                            synchronized (x1.this.f21044i) {
                                x1 x1Var7 = x1.this;
                                uVar = new u(x1Var7.f21044i);
                                x1Var7.f21057v = uVar;
                            }
                            uVar.c(x1.this.f21039d.schedule(new b(d03), g10.f21130b, TimeUnit.NANOSECONDS));
                            return;
                        }
                    }
                } else if (x1.this.f21043h) {
                    x1.this.g0();
                }
            }
            x1.this.c0(this.f21063a);
            if (x1.this.f21050o.f21137f == this.f21063a) {
                x1.this.m0(k1Var, aVar, v0Var);
            }
        }

        @Override // z8.i2
        public void d() {
            if (x1.this.m()) {
                x1.this.f21038c.execute(new e());
            }
        }

        public final Integer e(y8.v0 v0Var) {
            String str = (String) v0Var.g(x1.B);
            if (str == null) {
                return null;
            }
            try {
                return Integer.valueOf(str);
            } catch (NumberFormatException unused) {
                return -1;
            }
        }

        public final v f(y8.k1 k1Var, y8.v0 v0Var) {
            Integer e10 = e(v0Var);
            boolean z10 = !x1.this.f21042g.f20915c.contains(k1Var.n());
            return new v((z10 || ((x1.this.f21048m == null || (z10 && (e10 == null || e10.intValue() >= 0))) ? false : x1.this.f21048m.b() ^ true)) ? false : true, e10);
        }

        public final x g(y8.k1 k1Var, y8.v0 v0Var) {
            long j10 = 0;
            boolean z10 = false;
            if (x1.this.f21041f == null) {
                return new x(false, 0L);
            }
            boolean contains = x1.this.f21041f.f21146f.contains(k1Var.n());
            Integer e10 = e(v0Var);
            boolean z11 = (x1.this.f21048m == null || (!contains && (e10 == null || e10.intValue() >= 0))) ? false : !x1.this.f21048m.b();
            if (x1.this.f21041f.f21141a > this.f21063a.f21080d + 1 && !z11) {
                if (e10 == null) {
                    if (contains) {
                        double d10 = x1.this.f21059x;
                        double nextDouble = x1.D.nextDouble();
                        Double.isNaN(d10);
                        j10 = (long) (d10 * nextDouble);
                        x1 x1Var = x1.this;
                        double d11 = x1Var.f21059x;
                        double d12 = x1.this.f21041f.f21144d;
                        Double.isNaN(d11);
                        x1Var.f21059x = Math.min((long) (d11 * d12), x1.this.f21041f.f21143c);
                        z10 = true;
                    }
                } else if (e10.intValue() >= 0) {
                    j10 = TimeUnit.MILLISECONDS.toNanos(e10.intValue());
                    x1 x1Var2 = x1.this;
                    x1Var2.f21059x = x1Var2.f21041f.f21142b;
                    z10 = true;
                }
            }
            return new x(z10, j10);
        }
    }

    public class b implements r {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f21075a;

        public b(String str) {
            this.f21075a = str;
        }

        @Override // z8.x1.r
        public void a(b0 b0Var) {
            b0Var.f21077a.n(this.f21075a);
        }
    }

    public static final class b0 {

        /* renamed from: a, reason: collision with root package name */
        public z8.q f21077a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f21078b;

        /* renamed from: c, reason: collision with root package name */
        public boolean f21079c;

        /* renamed from: d, reason: collision with root package name */
        public final int f21080d;

        public b0(int i10) {
            this.f21080d = i10;
        }
    }

    public class c implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Collection f21081a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ b0 f21082b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Future f21083c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ Future f21084d;

        public c(Collection collection, b0 b0Var, Future future, Future future2) {
            this.f21081a = collection;
            this.f21082b = b0Var;
            this.f21083c = future;
            this.f21084d = future2;
        }

        @Override // java.lang.Runnable
        public void run() {
            for (b0 b0Var : this.f21081a) {
                if (b0Var != this.f21082b) {
                    b0Var.f21077a.e(x1.C);
                }
            }
            Future future = this.f21083c;
            if (future != null) {
                future.cancel(false);
            }
            Future future2 = this.f21084d;
            if (future2 != null) {
                future2.cancel(false);
            }
            x1.this.j0();
        }
    }

    public static final class c0 {

        /* renamed from: a, reason: collision with root package name */
        public final int f21086a;

        /* renamed from: b, reason: collision with root package name */
        public final int f21087b;

        /* renamed from: c, reason: collision with root package name */
        public final int f21088c;

        /* renamed from: d, reason: collision with root package name */
        public final AtomicInteger f21089d;

        public c0(float f10, float f11) {
            AtomicInteger atomicInteger = new AtomicInteger();
            this.f21089d = atomicInteger;
            this.f21088c = (int) (f11 * 1000.0f);
            int i10 = (int) (f10 * 1000.0f);
            this.f21086a = i10;
            this.f21087b = i10 / 2;
            atomicInteger.set(i10);
        }

        public boolean a() {
            return this.f21089d.get() > this.f21087b;
        }

        public boolean b() {
            int i10;
            int i11;
            do {
                i10 = this.f21089d.get();
                if (i10 == 0) {
                    return false;
                }
                i11 = i10 + FlowControl.DELAY_MAX_BRUSH;
            } while (!this.f21089d.compareAndSet(i10, Math.max(i11, 0)));
            return i11 > this.f21087b;
        }

        public void c() {
            int i10;
            int i11;
            do {
                i10 = this.f21089d.get();
                i11 = this.f21086a;
                if (i10 == i11) {
                    return;
                }
            } while (!this.f21089d.compareAndSet(i10, Math.min(this.f21088c + i10, i11)));
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof c0)) {
                return false;
            }
            c0 c0Var = (c0) obj;
            return this.f21086a == c0Var.f21086a && this.f21088c == c0Var.f21088c;
        }

        public int hashCode() {
            return Objects.hashCode(Integer.valueOf(this.f21086a), Integer.valueOf(this.f21088c));
        }
    }

    public class d implements r {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ y8.n f21090a;

        public d(y8.n nVar) {
            this.f21090a = nVar;
        }

        @Override // z8.x1.r
        public void a(b0 b0Var) {
            b0Var.f21077a.a(this.f21090a);
        }
    }

    public class e implements r {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ y8.t f21092a;

        public e(y8.t tVar) {
            this.f21092a = tVar;
        }

        @Override // z8.x1.r
        public void a(b0 b0Var) {
            b0Var.f21077a.k(this.f21092a);
        }
    }

    public class f implements r {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ y8.v f21094a;

        public f(y8.v vVar) {
            this.f21094a = vVar;
        }

        @Override // z8.x1.r
        public void a(b0 b0Var) {
            b0Var.f21077a.l(this.f21094a);
        }
    }

    public class g implements r {
        public g() {
        }

        @Override // z8.x1.r
        public void a(b0 b0Var) {
            b0Var.f21077a.flush();
        }
    }

    public class h implements r {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f21097a;

        public h(boolean z10) {
            this.f21097a = z10;
        }

        @Override // z8.x1.r
        public void a(b0 b0Var) {
            b0Var.f21077a.j(this.f21097a);
        }
    }

    public class i implements r {
        public i() {
        }

        @Override // z8.x1.r
        public void a(b0 b0Var) {
            b0Var.f21077a.o();
        }
    }

    public class j implements r {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f21100a;

        public j(int i10) {
            this.f21100a = i10;
        }

        @Override // z8.x1.r
        public void a(b0 b0Var) {
            b0Var.f21077a.c(this.f21100a);
        }
    }

    public class k implements r {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f21102a;

        public k(int i10) {
            this.f21102a = i10;
        }

        @Override // z8.x1.r
        public void a(b0 b0Var) {
            b0Var.f21077a.d(this.f21102a);
        }
    }

    public class l implements r {
        public l() {
        }

        @Override // z8.x1.r
        public void a(b0 b0Var) {
            b0Var.f21077a.i();
        }
    }

    public class m implements r {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f21105a;

        public m(int i10) {
            this.f21105a = i10;
        }

        @Override // z8.x1.r
        public void a(b0 b0Var) {
            b0Var.f21077a.b(this.f21105a);
        }
    }

    public class n implements r {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Object f21107a;

        public n(Object obj) {
            this.f21107a = obj;
        }

        @Override // z8.x1.r
        public void a(b0 b0Var) {
            b0Var.f21077a.h(x1.this.f21036a.j(this.f21107a));
            b0Var.f21077a.flush();
        }
    }

    public class o extends k.a {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ y8.k f21109a;

        public o(y8.k kVar) {
            this.f21109a = kVar;
        }

        @Override // y8.k.a
        public y8.k a(k.b bVar, y8.v0 v0Var) {
            return this.f21109a;
        }
    }

    public class p implements Runnable {
        public p() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (x1.this.f21061z) {
                return;
            }
            x1.this.f21056u.d();
        }
    }

    public class q implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ y8.k1 f21112a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ r.a f21113b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ y8.v0 f21114c;

        public q(y8.k1 k1Var, r.a aVar, y8.v0 v0Var) {
            this.f21112a = k1Var;
            this.f21113b = aVar;
            this.f21114c = v0Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            x1.this.f21061z = true;
            x1.this.f21056u.c(this.f21112a, this.f21113b, this.f21114c);
        }
    }

    public interface r {
        void a(b0 b0Var);
    }

    public class s extends y8.k {

        /* renamed from: a, reason: collision with root package name */
        public final b0 f21116a;

        /* renamed from: b, reason: collision with root package name */
        public long f21117b;

        public s(b0 b0Var) {
            this.f21116a = b0Var;
        }

        @Override // y8.n1
        public void h(long j10) {
            if (x1.this.f21050o.f21137f != null) {
                return;
            }
            synchronized (x1.this.f21044i) {
                if (x1.this.f21050o.f21137f == null && !this.f21116a.f21078b) {
                    long j11 = this.f21117b + j10;
                    this.f21117b = j11;
                    if (j11 <= x1.this.f21055t) {
                        return;
                    }
                    if (this.f21117b > x1.this.f21046k) {
                        this.f21116a.f21079c = true;
                    } else {
                        long a10 = x1.this.f21045j.a(this.f21117b - x1.this.f21055t);
                        x1.this.f21055t = this.f21117b;
                        if (a10 > x1.this.f21047l) {
                            this.f21116a.f21079c = true;
                        }
                    }
                    b0 b0Var = this.f21116a;
                    Runnable b02 = b0Var.f21079c ? x1.this.b0(b0Var) : null;
                    if (b02 != null) {
                        b02.run();
                    }
                }
            }
        }
    }

    public static final class t {

        /* renamed from: a, reason: collision with root package name */
        public final AtomicLong f21119a = new AtomicLong();

        public long a(long j10) {
            return this.f21119a.addAndGet(j10);
        }
    }

    public static final class u {

        /* renamed from: a, reason: collision with root package name */
        public final Object f21120a;

        /* renamed from: b, reason: collision with root package name */
        public Future f21121b;

        /* renamed from: c, reason: collision with root package name */
        public boolean f21122c;

        public u(Object obj) {
            this.f21120a = obj;
        }

        public boolean a() {
            return this.f21122c;
        }

        public Future b() {
            this.f21122c = true;
            return this.f21121b;
        }

        public void c(Future future) {
            synchronized (this.f21120a) {
                if (!this.f21122c) {
                    this.f21121b = future;
                }
            }
        }
    }

    public static final class v {

        /* renamed from: a, reason: collision with root package name */
        public final boolean f21123a;

        /* renamed from: b, reason: collision with root package name */
        public final Integer f21124b;

        public v(boolean z10, Integer num) {
            this.f21123a = z10;
            this.f21124b = num;
        }
    }

    public final class w implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final u f21125a;

        public class a implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ b0 f21127a;

            public a(b0 b0Var) {
                this.f21127a = b0Var;
            }

            @Override // java.lang.Runnable
            public void run() {
                u uVar;
                boolean z10;
                synchronized (x1.this.f21044i) {
                    uVar = null;
                    if (w.this.f21125a.a()) {
                        z10 = true;
                    } else {
                        x1 x1Var = x1.this;
                        x1Var.f21050o = x1Var.f21050o.a(this.f21127a);
                        x1 x1Var2 = x1.this;
                        if (x1Var2.h0(x1Var2.f21050o) && (x1.this.f21048m == null || x1.this.f21048m.a())) {
                            x1 x1Var3 = x1.this;
                            uVar = new u(x1Var3.f21044i);
                            x1Var3.f21058w = uVar;
                        } else {
                            x1 x1Var4 = x1.this;
                            x1Var4.f21050o = x1Var4.f21050o.d();
                            x1.this.f21058w = null;
                        }
                        z10 = false;
                    }
                }
                if (z10) {
                    this.f21127a.f21077a.e(y8.k1.f19890g.r("Unneeded hedging"));
                    return;
                }
                if (uVar != null) {
                    uVar.c(x1.this.f21039d.schedule(x1.this.new w(uVar), x1.this.f21042g.f20914b, TimeUnit.NANOSECONDS));
                }
                x1.this.f0(this.f21127a);
            }
        }

        public w(u uVar) {
            this.f21125a = uVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            x1 x1Var = x1.this;
            b0 d02 = x1Var.d0(x1Var.f21050o.f21136e, false);
            if (d02 == null) {
                return;
            }
            x1.this.f21037b.execute(new a(d02));
        }
    }

    public static final class x {

        /* renamed from: a, reason: collision with root package name */
        public final boolean f21129a;

        /* renamed from: b, reason: collision with root package name */
        public final long f21130b;

        public x(boolean z10, long j10) {
            this.f21129a = z10;
            this.f21130b = j10;
        }
    }

    public class y implements r {
        public y() {
        }

        @Override // z8.x1.r
        public void a(b0 b0Var) {
            b0Var.f21077a.g(x1.this.new a0(b0Var));
        }
    }

    public static final class z {

        /* renamed from: a, reason: collision with root package name */
        public final boolean f21132a;

        /* renamed from: b, reason: collision with root package name */
        public final List f21133b;

        /* renamed from: c, reason: collision with root package name */
        public final Collection f21134c;

        /* renamed from: d, reason: collision with root package name */
        public final Collection f21135d;

        /* renamed from: e, reason: collision with root package name */
        public final int f21136e;

        /* renamed from: f, reason: collision with root package name */
        public final b0 f21137f;

        /* renamed from: g, reason: collision with root package name */
        public final boolean f21138g;

        /* renamed from: h, reason: collision with root package name */
        public final boolean f21139h;

        public z(List list, Collection collection, Collection collection2, b0 b0Var, boolean z10, boolean z11, boolean z12, int i10) {
            this.f21133b = list;
            this.f21134c = (Collection) Preconditions.checkNotNull(collection, "drainedSubstreams");
            this.f21137f = b0Var;
            this.f21135d = collection2;
            this.f21138g = z10;
            this.f21132a = z11;
            this.f21139h = z12;
            this.f21136e = i10;
            Preconditions.checkState(!z11 || list == null, "passThrough should imply buffer is null");
            Preconditions.checkState((z11 && b0Var == null) ? false : true, "passThrough should imply winningSubstream != null");
            Preconditions.checkState(!z11 || (collection.size() == 1 && collection.contains(b0Var)) || (collection.size() == 0 && b0Var.f21078b), "passThrough should imply winningSubstream is drained");
            Preconditions.checkState((z10 && b0Var == null) ? false : true, "cancelled should imply committed");
        }

        public z a(b0 b0Var) {
            Collection unmodifiableCollection;
            Preconditions.checkState(!this.f21139h, "hedging frozen");
            Preconditions.checkState(this.f21137f == null, "already committed");
            if (this.f21135d == null) {
                unmodifiableCollection = Collections.singleton(b0Var);
            } else {
                ArrayList arrayList = new ArrayList(this.f21135d);
                arrayList.add(b0Var);
                unmodifiableCollection = Collections.unmodifiableCollection(arrayList);
            }
            return new z(this.f21133b, this.f21134c, unmodifiableCollection, this.f21137f, this.f21138g, this.f21132a, this.f21139h, this.f21136e + 1);
        }

        public z b() {
            return new z(this.f21133b, this.f21134c, this.f21135d, this.f21137f, true, this.f21132a, this.f21139h, this.f21136e);
        }

        public z c(b0 b0Var) {
            List list;
            Collection emptyList;
            boolean z10;
            Preconditions.checkState(this.f21137f == null, "Already committed");
            List list2 = this.f21133b;
            if (this.f21134c.contains(b0Var)) {
                emptyList = Collections.singleton(b0Var);
                list = null;
                z10 = true;
            } else {
                list = list2;
                emptyList = Collections.emptyList();
                z10 = false;
            }
            return new z(list, emptyList, this.f21135d, b0Var, this.f21138g, z10, this.f21139h, this.f21136e);
        }

        public z d() {
            return this.f21139h ? this : new z(this.f21133b, this.f21134c, this.f21135d, this.f21137f, this.f21138g, this.f21132a, true, this.f21136e);
        }

        public z e(b0 b0Var) {
            ArrayList arrayList = new ArrayList(this.f21135d);
            arrayList.remove(b0Var);
            return new z(this.f21133b, this.f21134c, Collections.unmodifiableCollection(arrayList), this.f21137f, this.f21138g, this.f21132a, this.f21139h, this.f21136e);
        }

        public z f(b0 b0Var, b0 b0Var2) {
            ArrayList arrayList = new ArrayList(this.f21135d);
            arrayList.remove(b0Var);
            arrayList.add(b0Var2);
            return new z(this.f21133b, this.f21134c, Collections.unmodifiableCollection(arrayList), this.f21137f, this.f21138g, this.f21132a, this.f21139h, this.f21136e);
        }

        public z g(b0 b0Var) {
            b0Var.f21078b = true;
            if (!this.f21134c.contains(b0Var)) {
                return this;
            }
            ArrayList arrayList = new ArrayList(this.f21134c);
            arrayList.remove(b0Var);
            return new z(this.f21133b, Collections.unmodifiableCollection(arrayList), this.f21135d, this.f21137f, this.f21138g, this.f21132a, this.f21139h, this.f21136e);
        }

        public z h(b0 b0Var) {
            Collection unmodifiableCollection;
            Preconditions.checkState(!this.f21132a, "Already passThrough");
            if (b0Var.f21078b) {
                unmodifiableCollection = this.f21134c;
            } else if (this.f21134c.isEmpty()) {
                unmodifiableCollection = Collections.singletonList(b0Var);
            } else {
                ArrayList arrayList = new ArrayList(this.f21134c);
                arrayList.add(b0Var);
                unmodifiableCollection = Collections.unmodifiableCollection(arrayList);
            }
            Collection collection = unmodifiableCollection;
            b0 b0Var2 = this.f21137f;
            boolean z10 = b0Var2 != null;
            List list = this.f21133b;
            if (z10) {
                Preconditions.checkState(b0Var2 == b0Var, "Another RPC attempt has already committed");
                list = null;
            }
            return new z(list, collection, this.f21135d, this.f21137f, this.f21138g, z10, this.f21139h, this.f21136e);
        }
    }

    static {
        v0.d dVar = y8.v0.f20029e;
        A = v0.g.e("grpc-previous-rpc-attempts", dVar);
        B = v0.g.e("grpc-retry-pushback-ms", dVar);
        C = y8.k1.f19890g.r("Stream thrown away because RetriableStream committed");
        D = new Random();
    }

    public x1(y8.w0 w0Var, y8.v0 v0Var, t tVar, long j10, long j11, Executor executor, ScheduledExecutorService scheduledExecutorService, y1 y1Var, s0 s0Var, c0 c0Var) {
        this.f21036a = w0Var;
        this.f21045j = tVar;
        this.f21046k = j10;
        this.f21047l = j11;
        this.f21037b = executor;
        this.f21039d = scheduledExecutorService;
        this.f21040e = v0Var;
        this.f21041f = y1Var;
        if (y1Var != null) {
            this.f21059x = y1Var.f21142b;
        }
        this.f21042g = s0Var;
        Preconditions.checkArgument(y1Var == null || s0Var == null, "Should not provide both retryPolicy and hedgingPolicy");
        this.f21043h = s0Var != null;
        this.f21048m = c0Var;
    }

    @Override // z8.h2
    public final void a(y8.n nVar) {
        e0(new d(nVar));
    }

    @Override // z8.h2
    public final void b(int i10) {
        z zVar = this.f21050o;
        if (zVar.f21132a) {
            zVar.f21137f.f21077a.b(i10);
        } else {
            e0(new m(i10));
        }
    }

    public final Runnable b0(b0 b0Var) {
        Future future;
        Future future2;
        synchronized (this.f21044i) {
            if (this.f21050o.f21137f != null) {
                return null;
            }
            Collection collection = this.f21050o.f21134c;
            this.f21050o = this.f21050o.c(b0Var);
            this.f21045j.a(-this.f21055t);
            u uVar = this.f21057v;
            if (uVar != null) {
                Future b10 = uVar.b();
                this.f21057v = null;
                future = b10;
            } else {
                future = null;
            }
            u uVar2 = this.f21058w;
            if (uVar2 != null) {
                Future b11 = uVar2.b();
                this.f21058w = null;
                future2 = b11;
            } else {
                future2 = null;
            }
            return new c(collection, b0Var, future, future2);
        }
    }

    @Override // z8.q
    public final void c(int i10) {
        e0(new j(i10));
    }

    public final void c0(b0 b0Var) {
        Runnable b02 = b0(b0Var);
        if (b02 != null) {
            b02.run();
        }
    }

    @Override // z8.q
    public final void d(int i10) {
        e0(new k(i10));
    }

    public final b0 d0(int i10, boolean z10) {
        int i11;
        do {
            i11 = this.f21053r.get();
            if (i11 < 0) {
                return null;
            }
        } while (!this.f21053r.compareAndSet(i11, i11 + 1));
        b0 b0Var = new b0(i10);
        b0Var.f21077a = i0(o0(this.f21040e, i10), new o(new s(b0Var)), i10, z10);
        return b0Var;
    }

    @Override // z8.q
    public final void e(y8.k1 k1Var) {
        b0 b0Var;
        b0 b0Var2 = new b0(0);
        b0Var2.f21077a = new n1();
        Runnable b02 = b0(b0Var2);
        if (b02 != null) {
            this.f21054s = k1Var;
            b02.run();
            if (this.f21053r.addAndGet(Integer.MIN_VALUE) == Integer.MIN_VALUE) {
                m0(k1Var, r.a.PROCESSED, new y8.v0());
                return;
            }
            return;
        }
        synchronized (this.f21044i) {
            if (this.f21050o.f21134c.contains(this.f21050o.f21137f)) {
                b0Var = this.f21050o.f21137f;
            } else {
                this.f21060y = k1Var;
                b0Var = null;
            }
            this.f21050o = this.f21050o.b();
        }
        if (b0Var != null) {
            b0Var.f21077a.e(k1Var);
        }
    }

    public final void e0(r rVar) {
        Collection collection;
        synchronized (this.f21044i) {
            if (!this.f21050o.f21132a) {
                this.f21050o.f21133b.add(rVar);
            }
            collection = this.f21050o.f21134c;
        }
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            rVar.a((b0) it.next());
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0035, code lost:
    
        if (r1 == null) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0037, code lost:
    
        r8.f21038c.execute(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x003c, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x003d, code lost:
    
        r0 = r9.f21077a;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0043, code lost:
    
        if (r8.f21050o.f21137f != r9) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0045, code lost:
    
        r9 = r8.f21060y;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x004a, code lost:
    
        r0.e(r9);
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x004d, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0048, code lost:
    
        r9 = z8.x1.C;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x007b, code lost:
    
        r2 = r3.iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0083, code lost:
    
        if (r2.hasNext() == false) goto L66;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0085, code lost:
    
        r4 = (z8.x1.r) r2.next();
        r4.a(r9);
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0090, code lost:
    
        if ((r4 instanceof z8.x1.y) == false) goto L48;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0092, code lost:
    
        r0 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0093, code lost:
    
        if (r0 == false) goto L71;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x0095, code lost:
    
        r4 = r8.f21050o;
        r5 = r4.f21137f;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x0099, code lost:
    
        if (r5 == null) goto L53;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x009b, code lost:
    
        if (r5 == r9) goto L53;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x00a0, code lost:
    
        if (r4.f21138g == false) goto L72;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void f0(b0 b0Var) {
        int min;
        boolean z10 = false;
        p pVar = null;
        ArrayList arrayList = null;
        int i10 = 0;
        while (true) {
            synchronized (this.f21044i) {
                z zVar = this.f21050o;
                if (z10) {
                    b0 b0Var2 = zVar.f21137f;
                    if (b0Var2 == null || b0Var2 == b0Var) {
                        if (zVar.f21138g) {
                        }
                    }
                }
                if (i10 == zVar.f21133b.size()) {
                    this.f21050o = zVar.h(b0Var);
                    if (!m()) {
                        return;
                    } else {
                        pVar = new p();
                    }
                } else {
                    if (b0Var.f21078b) {
                        return;
                    }
                    min = Math.min(i10 + 128, zVar.f21133b.size());
                    if (arrayList == null) {
                        arrayList = new ArrayList(zVar.f21133b.subList(i10, min));
                    } else {
                        arrayList.clear();
                        arrayList.addAll(zVar.f21133b.subList(i10, min));
                    }
                }
            }
            i10 = min;
        }
    }

    @Override // z8.h2
    public final void flush() {
        z zVar = this.f21050o;
        if (zVar.f21132a) {
            zVar.f21137f.f21077a.flush();
        } else {
            e0(new g());
        }
    }

    @Override // z8.q
    public final void g(z8.r rVar) {
        u uVar;
        c0 c0Var;
        this.f21056u = rVar;
        y8.k1 k02 = k0();
        if (k02 != null) {
            e(k02);
            return;
        }
        synchronized (this.f21044i) {
            this.f21050o.f21133b.add(new y());
        }
        b0 d02 = d0(0, false);
        if (d02 == null) {
            return;
        }
        if (this.f21043h) {
            synchronized (this.f21044i) {
                this.f21050o = this.f21050o.a(d02);
                if (h0(this.f21050o) && ((c0Var = this.f21048m) == null || c0Var.a())) {
                    uVar = new u(this.f21044i);
                    this.f21058w = uVar;
                } else {
                    uVar = null;
                }
            }
            if (uVar != null) {
                uVar.c(this.f21039d.schedule(new w(uVar), this.f21042g.f20914b, TimeUnit.NANOSECONDS));
            }
        }
        f0(d02);
    }

    public final void g0() {
        Future future;
        synchronized (this.f21044i) {
            u uVar = this.f21058w;
            future = null;
            if (uVar != null) {
                Future b10 = uVar.b();
                this.f21058w = null;
                future = b10;
            }
            this.f21050o = this.f21050o.d();
        }
        if (future != null) {
            future.cancel(false);
        }
    }

    @Override // z8.h2
    public final void h(InputStream inputStream) {
        throw new IllegalStateException("RetriableStream.writeMessage() should not be called directly");
    }

    public final boolean h0(z zVar) {
        return zVar.f21137f == null && zVar.f21136e < this.f21042g.f20913a && !zVar.f21139h;
    }

    @Override // z8.h2
    public void i() {
        e0(new l());
    }

    public abstract z8.q i0(y8.v0 v0Var, k.a aVar, int i10, boolean z10);

    @Override // z8.q
    public final void j(boolean z10) {
        e0(new h(z10));
    }

    public abstract void j0();

    @Override // z8.q
    public final void k(y8.t tVar) {
        e0(new e(tVar));
    }

    public abstract y8.k1 k0();

    @Override // z8.q
    public final void l(y8.v vVar) {
        e0(new f(vVar));
    }

    public final void l0(Integer num) {
        if (num == null) {
            return;
        }
        if (num.intValue() < 0) {
            g0();
            return;
        }
        synchronized (this.f21044i) {
            u uVar = this.f21058w;
            if (uVar == null) {
                return;
            }
            Future b10 = uVar.b();
            u uVar2 = new u(this.f21044i);
            this.f21058w = uVar2;
            if (b10 != null) {
                b10.cancel(false);
            }
            uVar2.c(this.f21039d.schedule(new w(uVar2), num.intValue(), TimeUnit.MILLISECONDS));
        }
    }

    @Override // z8.h2
    public final boolean m() {
        Iterator it = this.f21050o.f21134c.iterator();
        while (it.hasNext()) {
            if (((b0) it.next()).f21077a.m()) {
                return true;
            }
        }
        return false;
    }

    public final void m0(y8.k1 k1Var, r.a aVar, y8.v0 v0Var) {
        this.f21038c.execute(new q(k1Var, aVar, v0Var));
    }

    @Override // z8.q
    public final void n(String str) {
        e0(new b(str));
    }

    public final void n0(Object obj) {
        z zVar = this.f21050o;
        if (zVar.f21132a) {
            zVar.f21137f.f21077a.h(this.f21036a.j(obj));
        } else {
            e0(new n(obj));
        }
    }

    @Override // z8.q
    public final void o() {
        e0(new i());
    }

    public final y8.v0 o0(y8.v0 v0Var, int i10) {
        y8.v0 v0Var2 = new y8.v0();
        v0Var2.l(v0Var);
        if (i10 > 0) {
            v0Var2.o(A, String.valueOf(i10));
        }
        return v0Var2;
    }

    @Override // z8.q
    public void p(w0 w0Var) {
        z zVar;
        synchronized (this.f21044i) {
            w0Var.b("closed", this.f21049n);
            zVar = this.f21050o;
        }
        if (zVar.f21137f != null) {
            w0 w0Var2 = new w0();
            zVar.f21137f.f21077a.p(w0Var2);
            w0Var.b("committed", w0Var2);
            return;
        }
        w0 w0Var3 = new w0();
        for (b0 b0Var : zVar.f21134c) {
            w0 w0Var4 = new w0();
            b0Var.f21077a.p(w0Var4);
            w0Var3.a(w0Var4);
        }
        w0Var.b(ConnType.PK_OPEN, w0Var3);
    }
}
