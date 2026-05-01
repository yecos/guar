package kotlinx.coroutines.internal;

import ca.f1;
import ca.q0;
import ca.w1;
import h9.l;
import java.util.concurrent.CancellationException;
import kotlin.coroutines.Continuation;

/* loaded from: classes3.dex */
public abstract class g {

    /* renamed from: a, reason: collision with root package name */
    public static final y f15746a = new y("UNDEFINED");

    /* renamed from: b, reason: collision with root package name */
    public static final y f15747b = new y("REUSABLE_CLAIMED");

    public static final void b(Continuation continuation, Object obj, s9.l lVar) {
        boolean z10;
        if (!(continuation instanceof f)) {
            continuation.resumeWith(obj);
            return;
        }
        f fVar = (f) continuation;
        Object b10 = ca.w.b(obj, lVar);
        if (fVar.f15738d.M(fVar.getContext())) {
            fVar.f15740f = b10;
            fVar.f5765c = 1;
            fVar.f15738d.L(fVar.getContext(), fVar);
            return;
        }
        q0 a10 = w1.f5809a.a();
        if (a10.U()) {
            fVar.f15740f = b10;
            fVar.f5765c = 1;
            a10.Q(fVar);
            return;
        }
        a10.S(true);
        try {
            f1 f1Var = (f1) fVar.getContext().a(f1.f5750a0);
            if (f1Var == null || f1Var.isActive()) {
                z10 = false;
            } else {
                CancellationException f10 = f1Var.f();
                fVar.a(b10, f10);
                l.a aVar = h9.l.f14231a;
                fVar.resumeWith(h9.l.a(h9.m.a(f10)));
                z10 = true;
            }
            if (!z10) {
                Continuation continuation2 = fVar.f15739e;
                Object obj2 = fVar.f15741g;
                k9.f context = continuation2.getContext();
                Object c10 = c0.c(context, obj2);
                if (c10 != c0.f15728a) {
                    ca.x.f(continuation2, context, c10);
                }
                try {
                    fVar.f15739e.resumeWith(obj);
                    h9.t tVar = h9.t.f14242a;
                    c0.a(context, c10);
                } catch (Throwable th) {
                    c0.a(context, c10);
                    throw th;
                }
            }
            while (a10.W()) {
            }
        } finally {
            try {
            } finally {
            }
        }
    }

    public static /* synthetic */ void c(Continuation continuation, Object obj, s9.l lVar, int i10, Object obj2) {
        if ((i10 & 2) != 0) {
            lVar = null;
        }
        b(continuation, obj, lVar);
    }
}
