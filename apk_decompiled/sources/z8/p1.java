package z8;

import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import y8.o0;

/* loaded from: classes3.dex */
public final class p1 extends y8.o0 {

    /* renamed from: c, reason: collision with root package name */
    public final o0.d f20823c;

    /* renamed from: d, reason: collision with root package name */
    public o0.h f20824d;

    public class a implements o0.j {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ o0.h f20825a;

        public a(o0.h hVar) {
            this.f20825a = hVar;
        }

        @Override // y8.o0.j
        public void a(y8.q qVar) {
            p1.this.h(this.f20825a, qVar);
        }
    }

    public static /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f20827a;

        static {
            int[] iArr = new int[y8.p.values().length];
            f20827a = iArr;
            try {
                iArr[y8.p.IDLE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f20827a[y8.p.CONNECTING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f20827a[y8.p.READY.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f20827a[y8.p.TRANSIENT_FAILURE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public static final class c extends o0.i {

        /* renamed from: a, reason: collision with root package name */
        public final o0.e f20828a;

        public c(o0.e eVar) {
            this.f20828a = (o0.e) Preconditions.checkNotNull(eVar, "result");
        }

        @Override // y8.o0.i
        public o0.e a(o0.f fVar) {
            return this.f20828a;
        }

        public String toString() {
            return MoreObjects.toStringHelper((Class<?>) c.class).add("result", this.f20828a).toString();
        }
    }

    public final class d extends o0.i {

        /* renamed from: a, reason: collision with root package name */
        public final o0.h f20829a;

        /* renamed from: b, reason: collision with root package name */
        public final AtomicBoolean f20830b = new AtomicBoolean(false);

        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                d.this.f20829a.e();
            }
        }

        public d(o0.h hVar) {
            this.f20829a = (o0.h) Preconditions.checkNotNull(hVar, "subchannel");
        }

        @Override // y8.o0.i
        public o0.e a(o0.f fVar) {
            if (this.f20830b.compareAndSet(false, true)) {
                p1.this.f20823c.d().execute(new a());
            }
            return o0.e.g();
        }
    }

    public p1(o0.d dVar) {
        this.f20823c = (o0.d) Preconditions.checkNotNull(dVar, "helper");
    }

    @Override // y8.o0
    public boolean a(o0.g gVar) {
        List a10 = gVar.a();
        if (a10.isEmpty()) {
            c(y8.k1.f19904u.r("NameResolver returned no usable address. addrs=" + gVar.a() + ", attrs=" + gVar.b()));
            return false;
        }
        o0.h hVar = this.f20824d;
        if (hVar != null) {
            hVar.h(a10);
            return true;
        }
        o0.h a11 = this.f20823c.a(o0.b.c().d(a10).b());
        a11.g(new a(a11));
        this.f20824d = a11;
        this.f20823c.f(y8.p.CONNECTING, new c(o0.e.h(a11)));
        a11.e();
        return true;
    }

    @Override // y8.o0
    public void c(y8.k1 k1Var) {
        o0.h hVar = this.f20824d;
        if (hVar != null) {
            hVar.f();
            this.f20824d = null;
        }
        this.f20823c.f(y8.p.TRANSIENT_FAILURE, new c(o0.e.f(k1Var)));
    }

    @Override // y8.o0
    public void e() {
        o0.h hVar = this.f20824d;
        if (hVar != null) {
            hVar.f();
        }
    }

    public final void h(o0.h hVar, y8.q qVar) {
        o0.i dVar;
        o0.i iVar;
        y8.p c10 = qVar.c();
        if (c10 == y8.p.SHUTDOWN) {
            return;
        }
        if (qVar.c() == y8.p.TRANSIENT_FAILURE || qVar.c() == y8.p.IDLE) {
            this.f20823c.e();
        }
        int i10 = b.f20827a[c10.ordinal()];
        if (i10 != 1) {
            if (i10 == 2) {
                iVar = new c(o0.e.g());
            } else if (i10 == 3) {
                dVar = new c(o0.e.h(hVar));
            } else {
                if (i10 != 4) {
                    throw new IllegalArgumentException("Unsupported state:" + c10);
                }
                iVar = new c(o0.e.f(qVar.d()));
            }
            this.f20823c.f(c10, iVar);
        }
        dVar = new d(hVar);
        iVar = dVar;
        this.f20823c.f(c10, iVar);
    }
}
