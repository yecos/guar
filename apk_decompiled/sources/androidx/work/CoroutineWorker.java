package androidx.work;

import android.content.Context;
import androidx.work.ListenableWorker;
import ca.c0;
import ca.d0;
import ca.f1;
import ca.g;
import ca.k1;
import ca.n0;
import ca.q;
import ca.y;
import com.google.common.util.concurrent.ListenableFuture;
import h9.m;
import h9.t;
import kotlin.coroutines.Continuation;
import m9.j;
import s9.p;
import t9.i;

/* loaded from: classes.dex */
public abstract class CoroutineWorker extends ListenableWorker {

    /* renamed from: f, reason: collision with root package name */
    public final q f3587f;

    /* renamed from: g, reason: collision with root package name */
    public final l1.c f3588g;

    /* renamed from: h, reason: collision with root package name */
    public final y f3589h;

    public static final class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (CoroutineWorker.this.v().isCancelled()) {
                f1.a.a(CoroutineWorker.this.w(), null, 1, null);
            }
        }
    }

    public static final class b extends j implements p {

        /* renamed from: b, reason: collision with root package name */
        public Object f3591b;

        /* renamed from: c, reason: collision with root package name */
        public int f3592c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ a1.j f3593d;

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ CoroutineWorker f3594e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(a1.j jVar, CoroutineWorker coroutineWorker, Continuation continuation) {
            super(2, continuation);
            this.f3593d = jVar;
            this.f3594e = coroutineWorker;
        }

        @Override // s9.p
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Object invoke(c0 c0Var, Continuation continuation) {
            return ((b) create(c0Var, continuation)).invokeSuspend(t.f14242a);
        }

        @Override // m9.a
        public final Continuation create(Object obj, Continuation continuation) {
            return new b(this.f3593d, this.f3594e, continuation);
        }

        @Override // m9.a
        public final Object invokeSuspend(Object obj) {
            a1.j jVar;
            Object c10 = l9.c.c();
            int i10 = this.f3592c;
            if (i10 == 0) {
                m.b(obj);
                a1.j jVar2 = this.f3593d;
                CoroutineWorker coroutineWorker = this.f3594e;
                this.f3591b = jVar2;
                this.f3592c = 1;
                Object t10 = coroutineWorker.t(this);
                if (t10 == c10) {
                    return c10;
                }
                jVar = jVar2;
                obj = t10;
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                jVar = (a1.j) this.f3591b;
                m.b(obj);
            }
            jVar.b(obj);
            return t.f14242a;
        }
    }

    public static final class c extends j implements p {

        /* renamed from: b, reason: collision with root package name */
        public int f3595b;

        public c(Continuation continuation) {
            super(2, continuation);
        }

        @Override // s9.p
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Object invoke(c0 c0Var, Continuation continuation) {
            return ((c) create(c0Var, continuation)).invokeSuspend(t.f14242a);
        }

        @Override // m9.a
        public final Continuation create(Object obj, Continuation continuation) {
            return CoroutineWorker.this.new c(continuation);
        }

        @Override // m9.a
        public final Object invokeSuspend(Object obj) {
            Object c10 = l9.c.c();
            int i10 = this.f3595b;
            try {
                if (i10 == 0) {
                    m.b(obj);
                    CoroutineWorker coroutineWorker = CoroutineWorker.this;
                    this.f3595b = 1;
                    obj = coroutineWorker.r(this);
                    if (obj == c10) {
                        return c10;
                    }
                } else {
                    if (i10 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    m.b(obj);
                }
                CoroutineWorker.this.v().o((ListenableWorker.a) obj);
            } catch (Throwable th) {
                CoroutineWorker.this.v().p(th);
            }
            return t.f14242a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CoroutineWorker(Context context, WorkerParameters workerParameters) {
        super(context, workerParameters);
        q b10;
        i.g(context, "appContext");
        i.g(workerParameters, "params");
        b10 = k1.b(null, 1, null);
        this.f3587f = b10;
        l1.c s10 = l1.c.s();
        i.f(s10, "create()");
        this.f3588g = s10;
        s10.addListener(new a(), h().c());
        this.f3589h = n0.a();
    }

    public static /* synthetic */ Object u(CoroutineWorker coroutineWorker, Continuation continuation) {
        throw new IllegalStateException("Not implemented");
    }

    @Override // androidx.work.ListenableWorker
    public final ListenableFuture e() {
        q b10;
        b10 = k1.b(null, 1, null);
        c0 a10 = d0.a(s().s(b10));
        a1.j jVar = new a1.j(b10, null, 2, null);
        g.b(a10, null, null, new b(jVar, this, null), 3, null);
        return jVar;
    }

    @Override // androidx.work.ListenableWorker
    public final void m() {
        super.m();
        this.f3588g.cancel(false);
    }

    @Override // androidx.work.ListenableWorker
    public final ListenableFuture p() {
        g.b(d0.a(s().s(this.f3587f)), null, null, new c(null), 3, null);
        return this.f3588g;
    }

    public abstract Object r(Continuation continuation);

    public y s() {
        return this.f3589h;
    }

    public Object t(Continuation continuation) {
        return u(this, continuation);
    }

    public final l1.c v() {
        return this.f3588g;
    }

    public final q w() {
        return this.f3587f;
    }
}
