package ca;

import ca.f1;
import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import java.util.ArrayList;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import k9.f;
import kotlinx.coroutines.internal.n;

/* loaded from: classes3.dex */
public class m1 implements f1, p, t1 {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f5768a = AtomicReferenceFieldUpdater.newUpdater(m1.class, Object.class, "_state");
    private volatile /* synthetic */ Object _parentHandle;
    private volatile /* synthetic */ Object _state;

    public static final class a extends l1 {

        /* renamed from: e, reason: collision with root package name */
        public final m1 f5769e;

        /* renamed from: f, reason: collision with root package name */
        public final b f5770f;

        /* renamed from: g, reason: collision with root package name */
        public final o f5771g;

        /* renamed from: h, reason: collision with root package name */
        public final Object f5772h;

        public a(m1 m1Var, b bVar, o oVar, Object obj) {
            this.f5769e = m1Var;
            this.f5770f = bVar;
            this.f5771g = oVar;
            this.f5772h = obj;
        }

        @Override // s9.l
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            q((Throwable) obj);
            return h9.t.f14242a;
        }

        @Override // ca.u
        public void q(Throwable th) {
            this.f5769e.C(this.f5770f, this.f5771g, this.f5772h);
        }
    }

    public static final class b implements a1 {
        private volatile /* synthetic */ Object _exceptionsHolder = null;
        private volatile /* synthetic */ int _isCompleting;
        private volatile /* synthetic */ Object _rootCause;

        /* renamed from: a, reason: collision with root package name */
        public final q1 f5773a;

        public b(q1 q1Var, boolean z10, Throwable th) {
            this.f5773a = q1Var;
            this._isCompleting = z10 ? 1 : 0;
            this._rootCause = th;
        }

        public final void a(Throwable th) {
            Throwable e10 = e();
            if (e10 == null) {
                l(th);
                return;
            }
            if (th == e10) {
                return;
            }
            Object d10 = d();
            if (d10 == null) {
                k(th);
                return;
            }
            if (d10 instanceof Throwable) {
                if (th == d10) {
                    return;
                }
                ArrayList b10 = b();
                b10.add(d10);
                b10.add(th);
                k(b10);
                return;
            }
            if (d10 instanceof ArrayList) {
                ((ArrayList) d10).add(th);
                return;
            }
            throw new IllegalStateException(("State is " + d10).toString());
        }

        public final ArrayList b() {
            return new ArrayList(4);
        }

        @Override // ca.a1
        public q1 c() {
            return this.f5773a;
        }

        public final Object d() {
            return this._exceptionsHolder;
        }

        public final Throwable e() {
            return (Throwable) this._rootCause;
        }

        public final boolean f() {
            return e() != null;
        }

        /* JADX WARN: Type inference failed for: r0v0, types: [boolean, int] */
        public final boolean g() {
            return this._isCompleting;
        }

        public final boolean h() {
            kotlinx.coroutines.internal.y yVar;
            Object d10 = d();
            yVar = n1.f5784e;
            return d10 == yVar;
        }

        public final List i(Throwable th) {
            ArrayList arrayList;
            kotlinx.coroutines.internal.y yVar;
            Object d10 = d();
            if (d10 == null) {
                arrayList = b();
            } else if (d10 instanceof Throwable) {
                ArrayList b10 = b();
                b10.add(d10);
                arrayList = b10;
            } else {
                if (!(d10 instanceof ArrayList)) {
                    throw new IllegalStateException(("State is " + d10).toString());
                }
                arrayList = (ArrayList) d10;
            }
            Throwable e10 = e();
            if (e10 != null) {
                arrayList.add(0, e10);
            }
            if (th != null && !t9.i.b(th, e10)) {
                arrayList.add(th);
            }
            yVar = n1.f5784e;
            k(yVar);
            return arrayList;
        }

        @Override // ca.a1
        public boolean isActive() {
            return e() == null;
        }

        public final void j(boolean z10) {
            this._isCompleting = z10 ? 1 : 0;
        }

        public final void k(Object obj) {
            this._exceptionsHolder = obj;
        }

        public final void l(Throwable th) {
            this._rootCause = th;
        }

        public String toString() {
            return "Finishing[cancelling=" + f() + ", completing=" + g() + ", rootCause=" + e() + ", exceptions=" + d() + ", list=" + c() + ']';
        }
    }

    public static final class c extends n.a {

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ m1 f5774d;

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ Object f5775e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(kotlinx.coroutines.internal.n nVar, m1 m1Var, Object obj) {
            super(nVar);
            this.f5774d = m1Var;
            this.f5775e = obj;
        }

        @Override // kotlinx.coroutines.internal.c
        /* renamed from: i, reason: merged with bridge method [inline-methods] */
        public Object g(kotlinx.coroutines.internal.n nVar) {
            if (this.f5774d.O() == this.f5775e) {
                return null;
            }
            return kotlinx.coroutines.internal.m.a();
        }
    }

    public m1(boolean z10) {
        this._state = z10 ? n1.f5786g : n1.f5785f;
        this._parentHandle = null;
    }

    public static /* synthetic */ CancellationException l0(m1 m1Var, Throwable th, String str, int i10, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: toCancellationException");
        }
        if ((i10 & 1) != 0) {
            str = null;
        }
        return m1Var.k0(th, str);
    }

    public boolean A(Throwable th) {
        if (th instanceof CancellationException) {
            return true;
        }
        return o(th) && K();
    }

    public final void B(a1 a1Var, Object obj) {
        n N = N();
        if (N != null) {
            N.dispose();
            h0(r1.f5800a);
        }
        s sVar = obj instanceof s ? (s) obj : null;
        Throwable th = sVar != null ? sVar.f5802a : null;
        if (!(a1Var instanceof l1)) {
            q1 c10 = a1Var.c();
            if (c10 != null) {
                a0(c10, th);
                return;
            }
            return;
        }
        try {
            ((l1) a1Var).q(th);
        } catch (Throwable th2) {
            Q(new v("Exception in completion handler " + a1Var + " for " + this, th2));
        }
    }

    public final void C(b bVar, o oVar, Object obj) {
        o Y = Y(oVar);
        if (Y == null || !r0(bVar, Y, obj)) {
            l(F(bVar, obj));
        }
    }

    public final Throwable D(Object obj) {
        if (obj == null ? true : obj instanceof Throwable) {
            Throwable th = (Throwable) obj;
            return th == null ? new g1(w(), null, this) : th;
        }
        if (obj != null) {
            return ((t1) obj).n();
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.ParentJob");
    }

    @Override // k9.f
    public k9.f E(f.c cVar) {
        return f1.a.e(this, cVar);
    }

    public final Object F(b bVar, Object obj) {
        boolean f10;
        Throwable J;
        s sVar = obj instanceof s ? (s) obj : null;
        Throwable th = sVar != null ? sVar.f5802a : null;
        synchronized (bVar) {
            f10 = bVar.f();
            List i10 = bVar.i(th);
            J = J(bVar, i10);
            if (J != null) {
                k(J, i10);
            }
        }
        if (J != null && J != th) {
            obj = new s(J, false, 2, null);
        }
        if (J != null) {
            if (t(J) || P(J)) {
                if (obj == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.CompletedExceptionally");
                }
                ((s) obj).b();
            }
        }
        if (!f10) {
            b0(J);
        }
        c0(obj);
        androidx.concurrent.futures.b.a(f5768a, this, bVar, n1.g(obj));
        B(bVar, obj);
        return obj;
    }

    public final o G(a1 a1Var) {
        o oVar = a1Var instanceof o ? (o) a1Var : null;
        if (oVar != null) {
            return oVar;
        }
        q1 c10 = a1Var.c();
        if (c10 != null) {
            return Y(c10);
        }
        return null;
    }

    public final Throwable H(Object obj) {
        s sVar = obj instanceof s ? (s) obj : null;
        if (sVar != null) {
            return sVar.f5802a;
        }
        return null;
    }

    public final Throwable J(b bVar, List list) {
        Object obj = null;
        if (list.isEmpty()) {
            if (bVar.f()) {
                return new g1(w(), null, this);
            }
            return null;
        }
        Iterator it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            if (!(((Throwable) next) instanceof CancellationException)) {
                obj = next;
                break;
            }
        }
        Throwable th = (Throwable) obj;
        return th != null ? th : (Throwable) list.get(0);
    }

    public boolean K() {
        return true;
    }

    public boolean L() {
        return false;
    }

    public final q1 M(a1 a1Var) {
        q1 c10 = a1Var.c();
        if (c10 != null) {
            return c10;
        }
        if (a1Var instanceof p0) {
            return new q1();
        }
        if (a1Var instanceof l1) {
            f0((l1) a1Var);
            return null;
        }
        throw new IllegalStateException(("State should have list: " + a1Var).toString());
    }

    public final n N() {
        return (n) this._parentHandle;
    }

    public final Object O() {
        while (true) {
            Object obj = this._state;
            if (!(obj instanceof kotlinx.coroutines.internal.u)) {
                return obj;
            }
            ((kotlinx.coroutines.internal.u) obj).c(this);
        }
    }

    public boolean P(Throwable th) {
        return false;
    }

    public final void R(f1 f1Var) {
        if (f1Var == null) {
            h0(r1.f5800a);
            return;
        }
        f1Var.start();
        n x10 = f1Var.x(this);
        h0(x10);
        if (S()) {
            x10.dispose();
            h0(r1.f5800a);
        }
    }

    public final boolean S() {
        return !(O() instanceof a1);
    }

    public boolean T() {
        return false;
    }

    public final Object U(Object obj) {
        kotlinx.coroutines.internal.y yVar;
        kotlinx.coroutines.internal.y yVar2;
        kotlinx.coroutines.internal.y yVar3;
        kotlinx.coroutines.internal.y yVar4;
        kotlinx.coroutines.internal.y yVar5;
        kotlinx.coroutines.internal.y yVar6;
        Throwable th = null;
        while (true) {
            Object O = O();
            if (O instanceof b) {
                synchronized (O) {
                    if (((b) O).h()) {
                        yVar2 = n1.f5783d;
                        return yVar2;
                    }
                    boolean f10 = ((b) O).f();
                    if (obj != null || !f10) {
                        if (th == null) {
                            th = D(obj);
                        }
                        ((b) O).a(th);
                    }
                    Throwable e10 = f10 ^ true ? ((b) O).e() : null;
                    if (e10 != null) {
                        Z(((b) O).c(), e10);
                    }
                    yVar = n1.f5780a;
                    return yVar;
                }
            }
            if (!(O instanceof a1)) {
                yVar3 = n1.f5783d;
                return yVar3;
            }
            if (th == null) {
                th = D(obj);
            }
            a1 a1Var = (a1) O;
            if (!a1Var.isActive()) {
                Object p02 = p0(O, new s(th, false, 2, null));
                yVar5 = n1.f5780a;
                if (p02 == yVar5) {
                    throw new IllegalStateException(("Cannot happen in " + O).toString());
                }
                yVar6 = n1.f5782c;
                if (p02 != yVar6) {
                    return p02;
                }
            } else if (o0(a1Var, th)) {
                yVar4 = n1.f5780a;
                return yVar4;
            }
        }
    }

    public final Object V(Object obj) {
        Object p02;
        kotlinx.coroutines.internal.y yVar;
        kotlinx.coroutines.internal.y yVar2;
        do {
            p02 = p0(O(), obj);
            yVar = n1.f5780a;
            if (p02 == yVar) {
                throw new IllegalStateException("Job " + this + " is already complete or completing, but is being completed with " + obj, H(obj));
            }
            yVar2 = n1.f5782c;
        } while (p02 == yVar2);
        return p02;
    }

    public final l1 W(s9.l lVar, boolean z10) {
        l1 l1Var;
        if (z10) {
            l1Var = lVar instanceof h1 ? (h1) lVar : null;
            if (l1Var == null) {
                l1Var = new d1(lVar);
            }
        } else {
            l1Var = lVar instanceof l1 ? (l1) lVar : null;
            if (l1Var == null) {
                l1Var = new e1(lVar);
            }
        }
        l1Var.s(this);
        return l1Var;
    }

    public String X() {
        return g0.a(this);
    }

    public final o Y(kotlinx.coroutines.internal.n nVar) {
        while (nVar.l()) {
            nVar = nVar.k();
        }
        while (true) {
            nVar = nVar.j();
            if (!nVar.l()) {
                if (nVar instanceof o) {
                    return (o) nVar;
                }
                if (nVar instanceof q1) {
                    return null;
                }
            }
        }
    }

    public final void Z(q1 q1Var, Throwable th) {
        b0(th);
        v vVar = null;
        for (kotlinx.coroutines.internal.n nVar = (kotlinx.coroutines.internal.n) q1Var.i(); !t9.i.b(nVar, q1Var); nVar = nVar.j()) {
            if (nVar instanceof h1) {
                l1 l1Var = (l1) nVar;
                try {
                    l1Var.q(th);
                } catch (Throwable th2) {
                    if (vVar != null) {
                        h9.a.a(vVar, th2);
                    } else {
                        vVar = new v("Exception in completion handler " + l1Var + " for " + this, th2);
                        h9.t tVar = h9.t.f14242a;
                    }
                }
            }
        }
        if (vVar != null) {
            Q(vVar);
        }
        t(th);
    }

    @Override // k9.f.b, k9.f
    public f.b a(f.c cVar) {
        return f1.a.c(this, cVar);
    }

    public final void a0(q1 q1Var, Throwable th) {
        v vVar = null;
        for (kotlinx.coroutines.internal.n nVar = (kotlinx.coroutines.internal.n) q1Var.i(); !t9.i.b(nVar, q1Var); nVar = nVar.j()) {
            if (nVar instanceof l1) {
                l1 l1Var = (l1) nVar;
                try {
                    l1Var.q(th);
                } catch (Throwable th2) {
                    if (vVar != null) {
                        h9.a.a(vVar, th2);
                    } else {
                        vVar = new v("Exception in completion handler " + l1Var + " for " + this, th2);
                        h9.t tVar = h9.t.f14242a;
                    }
                }
            }
        }
        if (vVar != null) {
            Q(vVar);
        }
    }

    public void b0(Throwable th) {
    }

    public void c0(Object obj) {
    }

    public void d0() {
    }

    @Override // ca.f1
    public final o0 e(s9.l lVar) {
        return u(false, true, lVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v2, types: [ca.z0] */
    public final void e0(p0 p0Var) {
        q1 q1Var = new q1();
        if (!p0Var.isActive()) {
            q1Var = new z0(q1Var);
        }
        androidx.concurrent.futures.b.a(f5768a, this, p0Var, q1Var);
    }

    @Override // ca.f1
    public final CancellationException f() {
        Object O = O();
        if (!(O instanceof b)) {
            if (O instanceof a1) {
                throw new IllegalStateException(("Job is still new or active: " + this).toString());
            }
            if (O instanceof s) {
                return l0(this, ((s) O).f5802a, null, 1, null);
            }
            return new g1(g0.a(this) + " has completed normally", null, this);
        }
        Throwable e10 = ((b) O).e();
        if (e10 != null) {
            CancellationException k02 = k0(e10, g0.a(this) + " is cancelling");
            if (k02 != null) {
                return k02;
            }
        }
        throw new IllegalStateException(("Job is still new or active: " + this).toString());
    }

    public final void f0(l1 l1Var) {
        l1Var.e(new q1());
        androidx.concurrent.futures.b.a(f5768a, this, l1Var, l1Var.j());
    }

    public final void g0(l1 l1Var) {
        Object O;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        p0 p0Var;
        do {
            O = O();
            if (!(O instanceof l1)) {
                if (!(O instanceof a1) || ((a1) O).c() == null) {
                    return;
                }
                l1Var.m();
                return;
            }
            if (O != l1Var) {
                return;
            }
            atomicReferenceFieldUpdater = f5768a;
            p0Var = n1.f5786g;
        } while (!androidx.concurrent.futures.b.a(atomicReferenceFieldUpdater, this, O, p0Var));
    }

    @Override // k9.f.b
    public final f.c getKey() {
        return f1.f5750a0;
    }

    public final void h0(n nVar) {
        this._parentHandle = nVar;
    }

    public final int i0(Object obj) {
        p0 p0Var;
        if (!(obj instanceof p0)) {
            if (!(obj instanceof z0)) {
                return 0;
            }
            if (!androidx.concurrent.futures.b.a(f5768a, this, obj, ((z0) obj).c())) {
                return -1;
            }
            d0();
            return 1;
        }
        if (((p0) obj).isActive()) {
            return 0;
        }
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f5768a;
        p0Var = n1.f5786g;
        if (!androidx.concurrent.futures.b.a(atomicReferenceFieldUpdater, this, obj, p0Var)) {
            return -1;
        }
        d0();
        return 1;
    }

    @Override // ca.f1
    public boolean isActive() {
        Object O = O();
        return (O instanceof a1) && ((a1) O).isActive();
    }

    public final boolean j(Object obj, q1 q1Var, l1 l1Var) {
        int p10;
        c cVar = new c(l1Var, this, obj);
        do {
            p10 = q1Var.k().p(l1Var, q1Var, cVar);
            if (p10 == 1) {
                return true;
            }
        } while (p10 != 2);
        return false;
    }

    public final String j0(Object obj) {
        if (!(obj instanceof b)) {
            return obj instanceof a1 ? ((a1) obj).isActive() ? "Active" : "New" : obj instanceof s ? "Cancelled" : "Completed";
        }
        b bVar = (b) obj;
        return bVar.f() ? "Cancelling" : bVar.g() ? "Completing" : "Active";
    }

    public final void k(Throwable th, List list) {
        if (list.size() <= 1) {
            return;
        }
        Set newSetFromMap = Collections.newSetFromMap(new IdentityHashMap(list.size()));
        Iterator it = list.iterator();
        while (it.hasNext()) {
            Throwable th2 = (Throwable) it.next();
            if (th2 != th && th2 != th && !(th2 instanceof CancellationException) && newSetFromMap.add(th2)) {
                h9.a.a(th, th2);
            }
        }
    }

    public final CancellationException k0(Throwable th, String str) {
        CancellationException cancellationException = th instanceof CancellationException ? (CancellationException) th : null;
        if (cancellationException == null) {
            if (str == null) {
                str = w();
            }
            cancellationException = new g1(str, th, this);
        }
        return cancellationException;
    }

    public void l(Object obj) {
    }

    @Override // k9.f
    public Object m(Object obj, s9.p pVar) {
        return f1.a.b(this, obj, pVar);
    }

    public final String m0() {
        return X() + ASCIIPropertyListParser.DICTIONARY_BEGIN_TOKEN + j0(O()) + ASCIIPropertyListParser.DICTIONARY_END_TOKEN;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v11, types: [java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r1v7, types: [java.lang.Throwable] */
    @Override // ca.t1
    public CancellationException n() {
        CancellationException cancellationException;
        Object O = O();
        if (O instanceof b) {
            cancellationException = ((b) O).e();
        } else if (O instanceof s) {
            cancellationException = ((s) O).f5802a;
        } else {
            if (O instanceof a1) {
                throw new IllegalStateException(("Cannot be cancelling child in this state: " + O).toString());
            }
            cancellationException = null;
        }
        CancellationException cancellationException2 = cancellationException instanceof CancellationException ? cancellationException : null;
        if (cancellationException2 != null) {
            return cancellationException2;
        }
        return new g1("Parent job is " + j0(O), cancellationException, this);
    }

    public final boolean n0(a1 a1Var, Object obj) {
        if (!androidx.concurrent.futures.b.a(f5768a, this, a1Var, n1.g(obj))) {
            return false;
        }
        b0(null);
        c0(obj);
        B(a1Var, obj);
        return true;
    }

    public final boolean o(Object obj) {
        Object obj2;
        kotlinx.coroutines.internal.y yVar;
        kotlinx.coroutines.internal.y yVar2;
        kotlinx.coroutines.internal.y yVar3;
        obj2 = n1.f5780a;
        if (L() && (obj2 = r(obj)) == n1.f5781b) {
            return true;
        }
        yVar = n1.f5780a;
        if (obj2 == yVar) {
            obj2 = U(obj);
        }
        yVar2 = n1.f5780a;
        if (obj2 == yVar2 || obj2 == n1.f5781b) {
            return true;
        }
        yVar3 = n1.f5783d;
        if (obj2 == yVar3) {
            return false;
        }
        l(obj2);
        return true;
    }

    public final boolean o0(a1 a1Var, Throwable th) {
        q1 M = M(a1Var);
        if (M == null) {
            return false;
        }
        if (!androidx.concurrent.futures.b.a(f5768a, this, a1Var, new b(M, false, th))) {
            return false;
        }
        Z(M, th);
        return true;
    }

    public void p(Throwable th) {
        o(th);
    }

    public final Object p0(Object obj, Object obj2) {
        kotlinx.coroutines.internal.y yVar;
        kotlinx.coroutines.internal.y yVar2;
        if (!(obj instanceof a1)) {
            yVar2 = n1.f5780a;
            return yVar2;
        }
        if ((!(obj instanceof p0) && !(obj instanceof l1)) || (obj instanceof o) || (obj2 instanceof s)) {
            return q0((a1) obj, obj2);
        }
        if (n0((a1) obj, obj2)) {
            return obj2;
        }
        yVar = n1.f5782c;
        return yVar;
    }

    @Override // ca.f1
    public void q(CancellationException cancellationException) {
        if (cancellationException == null) {
            cancellationException = new g1(w(), null, this);
        }
        p(cancellationException);
    }

    public final Object q0(a1 a1Var, Object obj) {
        kotlinx.coroutines.internal.y yVar;
        kotlinx.coroutines.internal.y yVar2;
        kotlinx.coroutines.internal.y yVar3;
        q1 M = M(a1Var);
        if (M == null) {
            yVar3 = n1.f5782c;
            return yVar3;
        }
        b bVar = a1Var instanceof b ? (b) a1Var : null;
        if (bVar == null) {
            bVar = new b(M, false, null);
        }
        t9.w wVar = new t9.w();
        synchronized (bVar) {
            if (bVar.g()) {
                yVar2 = n1.f5780a;
                return yVar2;
            }
            bVar.j(true);
            if (bVar != a1Var && !androidx.concurrent.futures.b.a(f5768a, this, a1Var, bVar)) {
                yVar = n1.f5782c;
                return yVar;
            }
            boolean f10 = bVar.f();
            s sVar = obj instanceof s ? (s) obj : null;
            if (sVar != null) {
                bVar.a(sVar.f5802a);
            }
            Throwable e10 = Boolean.valueOf(f10 ? false : true).booleanValue() ? bVar.e() : null;
            wVar.f18961a = e10;
            h9.t tVar = h9.t.f14242a;
            if (e10 != null) {
                Z(M, e10);
            }
            o G = G(a1Var);
            return (G == null || !r0(bVar, G, obj)) ? F(bVar, obj) : n1.f5781b;
        }
    }

    public final Object r(Object obj) {
        kotlinx.coroutines.internal.y yVar;
        Object p02;
        kotlinx.coroutines.internal.y yVar2;
        do {
            Object O = O();
            if (!(O instanceof a1) || ((O instanceof b) && ((b) O).g())) {
                yVar = n1.f5780a;
                return yVar;
            }
            p02 = p0(O, new s(D(obj), false, 2, null));
            yVar2 = n1.f5782c;
        } while (p02 == yVar2);
        return p02;
    }

    public final boolean r0(b bVar, o oVar, Object obj) {
        while (f1.a.d(oVar.f5787e, false, false, new a(this, bVar, oVar, obj), 1, null) == r1.f5800a) {
            oVar = Y(oVar);
            if (oVar == null) {
                return false;
            }
        }
        return true;
    }

    @Override // k9.f
    public k9.f s(k9.f fVar) {
        return f1.a.f(this, fVar);
    }

    @Override // ca.f1
    public final boolean start() {
        int i02;
        do {
            i02 = i0(O());
            if (i02 == 0) {
                return false;
            }
        } while (i02 != 1);
        return true;
    }

    public final boolean t(Throwable th) {
        if (T()) {
            return true;
        }
        boolean z10 = th instanceof CancellationException;
        n N = N();
        return (N == null || N == r1.f5800a) ? z10 : N.b(th) || z10;
    }

    public String toString() {
        return m0() + '@' + g0.b(this);
    }

    @Override // ca.f1
    public final o0 u(boolean z10, boolean z11, s9.l lVar) {
        l1 W = W(lVar, z10);
        while (true) {
            Object O = O();
            if (O instanceof p0) {
                p0 p0Var = (p0) O;
                if (!p0Var.isActive()) {
                    e0(p0Var);
                } else if (androidx.concurrent.futures.b.a(f5768a, this, O, W)) {
                    return W;
                }
            } else {
                if (!(O instanceof a1)) {
                    if (z11) {
                        s sVar = O instanceof s ? (s) O : null;
                        lVar.invoke(sVar != null ? sVar.f5802a : null);
                    }
                    return r1.f5800a;
                }
                q1 c10 = ((a1) O).c();
                if (c10 != null) {
                    o0 o0Var = r1.f5800a;
                    if (z10 && (O instanceof b)) {
                        synchronized (O) {
                            r3 = ((b) O).e();
                            if (r3 == null || ((lVar instanceof o) && !((b) O).g())) {
                                if (j(O, c10, W)) {
                                    if (r3 == null) {
                                        return W;
                                    }
                                    o0Var = W;
                                }
                            }
                            h9.t tVar = h9.t.f14242a;
                        }
                    }
                    if (r3 != null) {
                        if (z11) {
                            lVar.invoke(r3);
                        }
                        return o0Var;
                    }
                    if (j(O, c10, W)) {
                        return W;
                    }
                } else {
                    if (O == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.JobNode");
                    }
                    f0((l1) O);
                }
            }
        }
    }

    @Override // ca.p
    public final void v(t1 t1Var) {
        o(t1Var);
    }

    public String w() {
        return "Job was cancelled";
    }

    @Override // ca.f1
    public final n x(p pVar) {
        return (n) f1.a.d(this, true, false, new o(pVar), 2, null);
    }

    public void Q(Throwable th) {
        throw th;
    }
}
