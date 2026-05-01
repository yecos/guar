package ca;

import h9.l;
import java.util.concurrent.CancellationException;
import kotlin.coroutines.Continuation;

/* loaded from: classes3.dex */
public abstract class l0 extends kotlinx.coroutines.scheduling.h {

    /* renamed from: c, reason: collision with root package name */
    public int f5765c;

    public l0(int i10) {
        this.f5765c = i10;
    }

    public abstract void a(Object obj, Throwable th);

    public abstract Continuation b();

    public Throwable c(Object obj) {
        s sVar = obj instanceof s ? (s) obj : null;
        if (sVar != null) {
            return sVar.f5802a;
        }
        return null;
    }

    public Object d(Object obj) {
        return obj;
    }

    public final void e(Throwable th, Throwable th2) {
        if (th == null && th2 == null) {
            return;
        }
        if (th != null && th2 != null) {
            h9.a.a(th, th2);
        }
        if (th == null) {
            th = th2;
        }
        t9.i.d(th);
        b0.a(b().getContext(), new f0("Fatal exception in coroutines machinery for " + this + ". Please read KDoc to 'handleFatalException' method and report this incident to maintainers", th));
    }

    public abstract Object f();

    @Override // java.lang.Runnable
    public final void run() {
        Object a10;
        Object a11;
        kotlinx.coroutines.scheduling.i iVar = this.f15817b;
        try {
            kotlinx.coroutines.internal.f fVar = (kotlinx.coroutines.internal.f) b();
            Continuation continuation = fVar.f15739e;
            Object obj = fVar.f15741g;
            k9.f context = continuation.getContext();
            Object c10 = kotlinx.coroutines.internal.c0.c(context, obj);
            if (c10 != kotlinx.coroutines.internal.c0.f15728a) {
                x.f(continuation, context, c10);
            }
            try {
                k9.f context2 = continuation.getContext();
                Object f10 = f();
                Throwable c11 = c(f10);
                f1 f1Var = (c11 == null && m0.b(this.f5765c)) ? (f1) context2.a(f1.f5750a0) : null;
                if (f1Var != null && !f1Var.isActive()) {
                    CancellationException f11 = f1Var.f();
                    a(f10, f11);
                    l.a aVar = h9.l.f14231a;
                    continuation.resumeWith(h9.l.a(h9.m.a(f11)));
                } else if (c11 != null) {
                    l.a aVar2 = h9.l.f14231a;
                    continuation.resumeWith(h9.l.a(h9.m.a(c11)));
                } else {
                    l.a aVar3 = h9.l.f14231a;
                    continuation.resumeWith(h9.l.a(d(f10)));
                }
                h9.t tVar = h9.t.f14242a;
                try {
                    iVar.a();
                    a11 = h9.l.a(h9.t.f14242a);
                } catch (Throwable th) {
                    l.a aVar4 = h9.l.f14231a;
                    a11 = h9.l.a(h9.m.a(th));
                }
                e(null, h9.l.b(a11));
            } finally {
                kotlinx.coroutines.internal.c0.a(context, c10);
            }
        } catch (Throwable th2) {
            try {
                l.a aVar5 = h9.l.f14231a;
                iVar.a();
                a10 = h9.l.a(h9.t.f14242a);
            } catch (Throwable th3) {
                l.a aVar6 = h9.l.f14231a;
                a10 = h9.l.a(h9.m.a(th3));
            }
            e(th2, h9.l.b(a10));
        }
    }
}
