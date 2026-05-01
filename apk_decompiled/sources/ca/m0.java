package ca;

import h9.l;
import kotlin.coroutines.Continuation;

/* loaded from: classes3.dex */
public abstract class m0 {
    public static final void a(l0 l0Var, int i10) {
        Continuation b10 = l0Var.b();
        boolean z10 = i10 == 4;
        if (z10 || !(b10 instanceof kotlinx.coroutines.internal.f) || b(i10) != b(l0Var.f5765c)) {
            d(l0Var, b10, z10);
            return;
        }
        y yVar = ((kotlinx.coroutines.internal.f) b10).f15738d;
        k9.f context = b10.getContext();
        if (yVar.M(context)) {
            yVar.L(context, l0Var);
        } else {
            e(l0Var);
        }
    }

    public static final boolean b(int i10) {
        return i10 == 1 || i10 == 2;
    }

    public static final boolean c(int i10) {
        return i10 == 2;
    }

    public static final void d(l0 l0Var, Continuation continuation, boolean z10) {
        Object d10;
        Object f10 = l0Var.f();
        Throwable c10 = l0Var.c(f10);
        if (c10 != null) {
            l.a aVar = h9.l.f14231a;
            d10 = h9.m.a(c10);
        } else {
            l.a aVar2 = h9.l.f14231a;
            d10 = l0Var.d(f10);
        }
        Object a10 = h9.l.a(d10);
        if (!z10) {
            continuation.resumeWith(a10);
            return;
        }
        kotlinx.coroutines.internal.f fVar = (kotlinx.coroutines.internal.f) continuation;
        Continuation continuation2 = fVar.f15739e;
        Object obj = fVar.f15741g;
        k9.f context = continuation2.getContext();
        Object c11 = kotlinx.coroutines.internal.c0.c(context, obj);
        if (c11 != kotlinx.coroutines.internal.c0.f15728a) {
            x.f(continuation2, context, c11);
        }
        try {
            fVar.f15739e.resumeWith(a10);
            h9.t tVar = h9.t.f14242a;
        } finally {
            kotlinx.coroutines.internal.c0.a(context, c11);
        }
    }

    public static final void e(l0 l0Var) {
        q0 a10 = w1.f5809a.a();
        if (a10.U()) {
            a10.Q(l0Var);
            return;
        }
        a10.S(true);
        try {
            d(l0Var, l0Var.b(), true);
            do {
            } while (a10.W());
        } finally {
            try {
            } finally {
            }
        }
    }
}
