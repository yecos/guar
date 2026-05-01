package r3;

import b3.b0;
import b3.j0;
import b3.r;
import b3.w;
import com.umeng.analytics.pro.bt;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;
import k3.b;
import k3.w;

/* loaded from: classes.dex */
public class d0 extends s implements Comparable {

    /* renamed from: m, reason: collision with root package name */
    public static final b.a f18390m = b.a.e("");

    /* renamed from: b, reason: collision with root package name */
    public final boolean f18391b;

    /* renamed from: c, reason: collision with root package name */
    public final m3.m f18392c;

    /* renamed from: d, reason: collision with root package name */
    public final k3.b f18393d;

    /* renamed from: e, reason: collision with root package name */
    public final k3.x f18394e;

    /* renamed from: f, reason: collision with root package name */
    public final k3.x f18395f;

    /* renamed from: g, reason: collision with root package name */
    public g f18396g;

    /* renamed from: h, reason: collision with root package name */
    public g f18397h;

    /* renamed from: i, reason: collision with root package name */
    public g f18398i;

    /* renamed from: j, reason: collision with root package name */
    public g f18399j;

    /* renamed from: k, reason: collision with root package name */
    public transient k3.w f18400k;

    /* renamed from: l, reason: collision with root package name */
    public transient b.a f18401l;

    public class a implements i {
        public a() {
        }

        @Override // r3.d0.i
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public Class[] a(r3.i iVar) {
            return d0.this.f18393d.f0(iVar);
        }
    }

    public class b implements i {
        public b() {
        }

        @Override // r3.d0.i
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public b.a a(r3.i iVar) {
            return d0.this.f18393d.Q(iVar);
        }
    }

    public class c implements i {
        public c() {
        }

        @Override // r3.d0.i
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public Boolean a(r3.i iVar) {
            return d0.this.f18393d.s0(iVar);
        }
    }

    public class d implements i {
        public d() {
        }

        @Override // r3.d0.i
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public b0 a(r3.i iVar) {
            b0 B = d0.this.f18393d.B(iVar);
            return B != null ? d0.this.f18393d.C(iVar, B) : B;
        }
    }

    public class e implements i {
        public e() {
        }

        @Override // r3.d0.i
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public w.a a(r3.i iVar) {
            return d0.this.f18393d.F(iVar);
        }
    }

    public static /* synthetic */ class f {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f18407a;

        static {
            int[] iArr = new int[w.a.values().length];
            f18407a = iArr;
            try {
                iArr[w.a.READ_ONLY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f18407a[w.a.READ_WRITE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f18407a[w.a.WRITE_ONLY.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f18407a[w.a.AUTO.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public static final class g {

        /* renamed from: a, reason: collision with root package name */
        public final Object f18408a;

        /* renamed from: b, reason: collision with root package name */
        public final g f18409b;

        /* renamed from: c, reason: collision with root package name */
        public final k3.x f18410c;

        /* renamed from: d, reason: collision with root package name */
        public final boolean f18411d;

        /* renamed from: e, reason: collision with root package name */
        public final boolean f18412e;

        /* renamed from: f, reason: collision with root package name */
        public final boolean f18413f;

        public g(Object obj, g gVar, k3.x xVar, boolean z10, boolean z11, boolean z12) {
            this.f18408a = obj;
            this.f18409b = gVar;
            k3.x xVar2 = (xVar == null || xVar.h()) ? null : xVar;
            this.f18410c = xVar2;
            if (z10) {
                if (xVar2 == null) {
                    throw new IllegalArgumentException("Cannot pass true for 'explName' if name is null/empty");
                }
                if (!xVar.e()) {
                    z10 = false;
                }
            }
            this.f18411d = z10;
            this.f18412e = z11;
            this.f18413f = z12;
        }

        public g a(g gVar) {
            g gVar2 = this.f18409b;
            return gVar2 == null ? c(gVar) : c(gVar2.a(gVar));
        }

        public g b() {
            g gVar = this.f18409b;
            if (gVar == null) {
                return this;
            }
            g b10 = gVar.b();
            if (this.f18410c != null) {
                return b10.f18410c == null ? c(null) : c(b10);
            }
            if (b10.f18410c != null) {
                return b10;
            }
            boolean z10 = this.f18412e;
            return z10 == b10.f18412e ? c(b10) : z10 ? c(null) : b10;
        }

        public g c(g gVar) {
            return gVar == this.f18409b ? this : new g(this.f18408a, gVar, this.f18410c, this.f18411d, this.f18412e, this.f18413f);
        }

        public g d(Object obj) {
            return obj == this.f18408a ? this : new g(obj, this.f18409b, this.f18410c, this.f18411d, this.f18412e, this.f18413f);
        }

        public g e() {
            g e10;
            if (!this.f18413f) {
                g gVar = this.f18409b;
                return (gVar == null || (e10 = gVar.e()) == this.f18409b) ? this : c(e10);
            }
            g gVar2 = this.f18409b;
            if (gVar2 == null) {
                return null;
            }
            return gVar2.e();
        }

        public g f() {
            return this.f18409b == null ? this : new g(this.f18408a, null, this.f18410c, this.f18411d, this.f18412e, this.f18413f);
        }

        public g g() {
            g gVar = this.f18409b;
            g g10 = gVar == null ? null : gVar.g();
            return this.f18412e ? c(g10) : g10;
        }

        public String toString() {
            String format = String.format("%s[visible=%b,ignore=%b,explicitName=%b]", this.f18408a.toString(), Boolean.valueOf(this.f18412e), Boolean.valueOf(this.f18413f), Boolean.valueOf(this.f18411d));
            if (this.f18409b == null) {
                return format;
            }
            return format + ", " + this.f18409b.toString();
        }
    }

    public static class h implements Iterator {

        /* renamed from: a, reason: collision with root package name */
        public g f18414a;

        public h(g gVar) {
            this.f18414a = gVar;
        }

        @Override // java.util.Iterator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public r3.i next() {
            g gVar = this.f18414a;
            if (gVar == null) {
                throw new NoSuchElementException();
            }
            r3.i iVar = (r3.i) gVar.f18408a;
            this.f18414a = gVar.f18409b;
            return iVar;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f18414a != null;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    public interface i {
        Object a(r3.i iVar);
    }

    public d0(m3.m mVar, k3.b bVar, boolean z10, k3.x xVar) {
        this(mVar, bVar, z10, xVar, xVar);
    }

    public static g j0(g gVar, g gVar2) {
        return gVar == null ? gVar2 : gVar2 == null ? gVar : gVar.a(gVar2);
    }

    @Override // r3.s
    public boolean A() {
        return this.f18399j != null;
    }

    @Override // r3.s
    public boolean B() {
        return F(this.f18396g) || F(this.f18398i) || F(this.f18399j) || E(this.f18397h);
    }

    @Override // r3.s
    public boolean C() {
        return E(this.f18396g) || E(this.f18398i) || E(this.f18399j) || E(this.f18397h);
    }

    @Override // r3.s
    public boolean D() {
        Boolean bool = (Boolean) f0(new c());
        return bool != null && bool.booleanValue();
    }

    public final boolean E(g gVar) {
        while (gVar != null) {
            if (gVar.f18410c != null && gVar.f18411d) {
                return true;
            }
            gVar = gVar.f18409b;
        }
        return false;
    }

    public final boolean F(g gVar) {
        while (gVar != null) {
            k3.x xVar = gVar.f18410c;
            if (xVar != null && xVar.e()) {
                return true;
            }
            gVar = gVar.f18409b;
        }
        return false;
    }

    public final boolean G(g gVar) {
        while (gVar != null) {
            if (gVar.f18413f) {
                return true;
            }
            gVar = gVar.f18409b;
        }
        return false;
    }

    public final boolean H(g gVar) {
        while (gVar != null) {
            if (gVar.f18412e) {
                return true;
            }
            gVar = gVar.f18409b;
        }
        return false;
    }

    public final g I(g gVar, p pVar) {
        r3.i iVar = (r3.i) ((r3.i) gVar.f18408a).p(pVar);
        g gVar2 = gVar.f18409b;
        if (gVar2 != null) {
            gVar = gVar.c(I(gVar2, pVar));
        }
        return gVar.d(iVar);
    }

    /*  JADX ERROR: JadxRuntimeException in pass: ConstructorVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r8v0 ??, still in use, count: 1, list:
          (r8v0 ?? I:java.lang.Object) from 0x0023: INVOKE (r11v0 ?? I:java.util.Map), (r7v0 ?? I:java.lang.Object), (r8v0 ?? I:java.lang.Object) INTERFACE call: java.util.Map.put(java.lang.Object, java.lang.Object):java.lang.Object A[MD:(K, V):V (c)] (LINE:36)
        	at jadx.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:162)
        	at jadx.core.utils.InsnRemover.unbindResult(InsnRemover.java:127)
        	at jadx.core.utils.InsnRemover.lambda$unbindInsns$1(InsnRemover.java:99)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at jadx.core.utils.InsnRemover.unbindInsns(InsnRemover.java:98)
        	at jadx.core.utils.InsnRemover.perform(InsnRemover.java:73)
        	at jadx.core.dex.visitors.ConstructorVisitor.replaceInvoke(ConstructorVisitor.java:59)
        	at jadx.core.dex.visitors.ConstructorVisitor.visit(ConstructorVisitor.java:42)
        */
    public final void J(
    /*  JADX ERROR: JadxRuntimeException in pass: ConstructorVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r8v0 ??, still in use, count: 1, list:
          (r8v0 ?? I:java.lang.Object) from 0x0023: INVOKE (r11v0 ?? I:java.util.Map), (r7v0 ?? I:java.lang.Object), (r8v0 ?? I:java.lang.Object) INTERFACE call: java.util.Map.put(java.lang.Object, java.lang.Object):java.lang.Object A[MD:(K, V):V (c)] (LINE:36)
        	at jadx.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:162)
        	at jadx.core.utils.InsnRemover.unbindResult(InsnRemover.java:127)
        	at jadx.core.utils.InsnRemover.lambda$unbindInsns$1(InsnRemover.java:99)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at jadx.core.utils.InsnRemover.unbindInsns(InsnRemover.java:98)
        	at jadx.core.utils.InsnRemover.perform(InsnRemover.java:73)
        	at jadx.core.dex.visitors.ConstructorVisitor.replaceInvoke(ConstructorVisitor.java:59)
        */
    /*  JADX ERROR: Method generation error
        jadx.core.utils.exceptions.JadxRuntimeException: Code variable not set in r10v0 ??
        	at jadx.core.dex.instructions.args.SSAVar.getCodeVar(SSAVar.java:238)
        	at jadx.core.codegen.MethodGen.addMethodArguments(MethodGen.java:223)
        	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:168)
        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:401)
        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:335)
        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:301)
        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:184)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
        	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
        */

    public final Set K(g gVar, Set set) {
        while (gVar != null) {
            if (gVar.f18411d && gVar.f18410c != null) {
                if (set == null) {
                    set = new HashSet();
                }
                set.add(gVar.f18410c);
            }
            gVar = gVar.f18409b;
        }
        return set;
    }

    public final p L(g gVar) {
        p j10 = ((r3.i) gVar.f18408a).j();
        g gVar2 = gVar.f18409b;
        return gVar2 != null ? p.e(j10, L(gVar2)) : j10;
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0068  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public k3.w M(k3.w wVar, r3.i iVar) {
        j0 j0Var;
        b0.a h10;
        Boolean g10;
        Boolean w10;
        r3.i l10 = l();
        boolean z10 = true;
        j0 j0Var2 = null;
        if (iVar != null) {
            k3.b bVar = this.f18393d;
            if (bVar != null) {
                if (l10 != null && (w10 = bVar.w(iVar)) != null) {
                    if (w10.booleanValue()) {
                        wVar = wVar.i(w.a.b(l10));
                    }
                    z10 = false;
                }
                b0.a Z = this.f18393d.Z(iVar);
                if (Z != null) {
                    j0Var2 = Z.f();
                    j0Var = Z.e();
                    if (!z10 || j0Var2 == null || j0Var == null) {
                        m3.g j10 = this.f18392c.j(P(iVar));
                        h10 = j10.h();
                        if (h10 != null) {
                            if (j0Var2 == null) {
                                j0Var2 = h10.f();
                            }
                            if (j0Var == null) {
                                j0Var = h10.e();
                            }
                        }
                        if (z10 && l10 != null && (g10 = j10.g()) != null) {
                            if (g10.booleanValue()) {
                                wVar = wVar.i(w.a.c(l10));
                            }
                            z10 = false;
                        }
                    }
                }
            }
            j0Var = null;
            if (!z10) {
            }
            m3.g j102 = this.f18392c.j(P(iVar));
            h10 = j102.h();
            if (h10 != null) {
            }
            if (z10) {
                if (g10.booleanValue()) {
                }
                z10 = false;
            }
        } else {
            j0Var = null;
        }
        if (z10 || j0Var2 == null || j0Var == null) {
            b0.a r10 = this.f18392c.r();
            if (j0Var2 == null) {
                j0Var2 = r10.f();
            }
            if (j0Var == null) {
                j0Var = r10.e();
            }
            if (z10) {
                if (Boolean.TRUE.equals(this.f18392c.n()) && l10 != null) {
                    wVar = wVar.i(w.a.a(l10));
                }
            }
        }
        return (j0Var2 == null && j0Var == null) ? wVar : wVar.j(j0Var2, j0Var);
    }

    public int N(j jVar) {
        String d10 = jVar.d();
        if (!d10.startsWith("get") || d10.length() <= 3) {
            return (!d10.startsWith(bt.ae) || d10.length() <= 2) ? 3 : 2;
        }
        return 1;
    }

    public final p O(int i10, g... gVarArr) {
        p L = L(gVarArr[i10]);
        do {
            i10++;
            if (i10 >= gVarArr.length) {
                return L;
            }
        } while (gVarArr[i10] == null);
        return p.e(L, O(i10, gVarArr));
    }

    public Class P(r3.i iVar) {
        if (iVar instanceof j) {
            j jVar = (j) iVar;
            if (jVar.v() > 0) {
                return jVar.w(0).q();
            }
        }
        return iVar.f().q();
    }

    public final g Q(g gVar) {
        return gVar == null ? gVar : gVar.e();
    }

    public final g R(g gVar) {
        return gVar == null ? gVar : gVar.g();
    }

    public int S(j jVar) {
        String d10 = jVar.d();
        return (!d10.startsWith("set") || d10.length() <= 3) ? 2 : 1;
    }

    public final g T(g gVar) {
        return gVar == null ? gVar : gVar.b();
    }

    public void U(d0 d0Var) {
        this.f18396g = j0(this.f18396g, d0Var.f18396g);
        this.f18397h = j0(this.f18397h, d0Var.f18397h);
        this.f18398i = j0(this.f18398i, d0Var.f18398i);
        this.f18399j = j0(this.f18399j, d0Var.f18399j);
    }

    public void V(m mVar, k3.x xVar, boolean z10, boolean z11, boolean z12) {
        this.f18397h = new g(mVar, this.f18397h, xVar, z10, z11, z12);
    }

    public void W(r3.g gVar, k3.x xVar, boolean z10, boolean z11, boolean z12) {
        this.f18396g = new g(gVar, this.f18396g, xVar, z10, z11, z12);
    }

    public void X(j jVar, k3.x xVar, boolean z10, boolean z11, boolean z12) {
        this.f18398i = new g(jVar, this.f18398i, xVar, z10, z11, z12);
    }

    public void Y(j jVar, k3.x xVar, boolean z10, boolean z11, boolean z12) {
        this.f18399j = new g(jVar, this.f18399j, xVar, z10, z11, z12);
    }

    public boolean Z() {
        return G(this.f18396g) || G(this.f18398i) || G(this.f18399j) || G(this.f18397h);
    }

    public boolean a0() {
        return H(this.f18396g) || H(this.f18398i) || H(this.f18399j) || H(this.f18397h);
    }

    @Override // java.lang.Comparable
    /* renamed from: b0, reason: merged with bridge method [inline-methods] */
    public int compareTo(d0 d0Var) {
        if (this.f18397h != null) {
            if (d0Var.f18397h == null) {
                return -1;
            }
        } else if (d0Var.f18397h != null) {
            return 1;
        }
        return getName().compareTo(d0Var.getName());
    }

    @Override // r3.s
    public k3.x c() {
        return this.f18394e;
    }

    public Collection c0(Collection collection) {
        HashMap hashMap = new HashMap();
        J(collection, hashMap, this.f18396g);
        J(collection, hashMap, this.f18398i);
        J(collection, hashMap, this.f18399j);
        J(collection, hashMap, this.f18397h);
        return hashMap.values();
    }

    public w.a d0() {
        return (w.a) g0(new e(), w.a.AUTO);
    }

    @Override // r3.s
    public boolean e() {
        return (this.f18397h == null && this.f18399j == null && this.f18396g == null) ? false : true;
    }

    public Set e0() {
        Set K = K(this.f18397h, K(this.f18399j, K(this.f18398i, K(this.f18396g, null))));
        return K == null ? Collections.emptySet() : K;
    }

    @Override // r3.s
    public boolean f() {
        return (this.f18398i == null && this.f18396g == null) ? false : true;
    }

    public Object f0(i iVar) {
        g gVar;
        g gVar2;
        if (this.f18393d == null) {
            return null;
        }
        if (this.f18391b) {
            g gVar3 = this.f18398i;
            if (gVar3 != null) {
                r1 = iVar.a((r3.i) gVar3.f18408a);
            }
        } else {
            g gVar4 = this.f18397h;
            r1 = gVar4 != null ? iVar.a((r3.i) gVar4.f18408a) : null;
            if (r1 == null && (gVar = this.f18399j) != null) {
                r1 = iVar.a((r3.i) gVar.f18408a);
            }
        }
        return (r1 != null || (gVar2 = this.f18396g) == null) ? r1 : iVar.a((r3.i) gVar2.f18408a);
    }

    @Override // r3.s
    public r.b g() {
        r3.i l10 = l();
        k3.b bVar = this.f18393d;
        r.b M = bVar == null ? null : bVar.M(l10);
        return M == null ? r.b.c() : M;
    }

    public Object g0(i iVar, Object obj) {
        Object a10;
        Object a11;
        Object a12;
        Object a13;
        Object a14;
        Object a15;
        Object a16;
        Object a17;
        if (this.f18393d == null) {
            return null;
        }
        if (this.f18391b) {
            g gVar = this.f18398i;
            if (gVar != null && (a17 = iVar.a((r3.i) gVar.f18408a)) != null && a17 != obj) {
                return a17;
            }
            g gVar2 = this.f18396g;
            if (gVar2 != null && (a16 = iVar.a((r3.i) gVar2.f18408a)) != null && a16 != obj) {
                return a16;
            }
            g gVar3 = this.f18397h;
            if (gVar3 != null && (a15 = iVar.a((r3.i) gVar3.f18408a)) != null && a15 != obj) {
                return a15;
            }
            g gVar4 = this.f18399j;
            if (gVar4 == null || (a14 = iVar.a((r3.i) gVar4.f18408a)) == null || a14 == obj) {
                return null;
            }
            return a14;
        }
        g gVar5 = this.f18397h;
        if (gVar5 != null && (a13 = iVar.a((r3.i) gVar5.f18408a)) != null && a13 != obj) {
            return a13;
        }
        g gVar6 = this.f18399j;
        if (gVar6 != null && (a12 = iVar.a((r3.i) gVar6.f18408a)) != null && a12 != obj) {
            return a12;
        }
        g gVar7 = this.f18396g;
        if (gVar7 != null && (a11 = iVar.a((r3.i) gVar7.f18408a)) != null && a11 != obj) {
            return a11;
        }
        g gVar8 = this.f18398i;
        if (gVar8 == null || (a10 = iVar.a((r3.i) gVar8.f18408a)) == null || a10 == obj) {
            return null;
        }
        return a10;
    }

    @Override // r3.s
    public k3.w getMetadata() {
        if (this.f18400k == null) {
            r3.i i02 = i0();
            if (i02 == null) {
                this.f18400k = k3.w.f14996j;
            } else {
                Boolean p02 = this.f18393d.p0(i02);
                String J = this.f18393d.J(i02);
                Integer O = this.f18393d.O(i02);
                String I = this.f18393d.I(i02);
                if (p02 == null && O == null && I == null) {
                    this.f18400k = J == null ? k3.w.f14996j : k3.w.f14996j.h(J);
                } else {
                    this.f18400k = k3.w.a(p02, J, O, I);
                }
                if (!this.f18391b) {
                    this.f18400k = M(this.f18400k, i02);
                }
            }
        }
        return this.f18400k;
    }

    @Override // r3.s, d4.r
    public String getName() {
        k3.x xVar = this.f18394e;
        if (xVar == null) {
            return null;
        }
        return xVar.c();
    }

    @Override // r3.s
    public b0 h() {
        return (b0) f0(new d());
    }

    public String h0() {
        return this.f18395f.c();
    }

    public r3.i i0() {
        if (this.f18391b) {
            g gVar = this.f18398i;
            if (gVar != null) {
                return (r3.i) gVar.f18408a;
            }
            g gVar2 = this.f18396g;
            if (gVar2 != null) {
                return (r3.i) gVar2.f18408a;
            }
            return null;
        }
        g gVar3 = this.f18397h;
        if (gVar3 != null) {
            return (r3.i) gVar3.f18408a;
        }
        g gVar4 = this.f18399j;
        if (gVar4 != null) {
            return (r3.i) gVar4.f18408a;
        }
        g gVar5 = this.f18396g;
        if (gVar5 != null) {
            return (r3.i) gVar5.f18408a;
        }
        g gVar6 = this.f18398i;
        if (gVar6 != null) {
            return (r3.i) gVar6.f18408a;
        }
        return null;
    }

    @Override // r3.s
    public b.a j() {
        b.a aVar = this.f18401l;
        if (aVar != null) {
            if (aVar == f18390m) {
                return null;
            }
            return aVar;
        }
        b.a aVar2 = (b.a) f0(new b());
        this.f18401l = aVar2 == null ? f18390m : aVar2;
        return aVar2;
    }

    @Override // r3.s
    public Class[] k() {
        return (Class[]) f0(new a());
    }

    public void k0(boolean z10) {
        if (z10) {
            g gVar = this.f18398i;
            if (gVar != null) {
                this.f18398i = I(this.f18398i, O(0, gVar, this.f18396g, this.f18397h, this.f18399j));
                return;
            }
            g gVar2 = this.f18396g;
            if (gVar2 != null) {
                this.f18396g = I(this.f18396g, O(0, gVar2, this.f18397h, this.f18399j));
                return;
            }
            return;
        }
        g gVar3 = this.f18397h;
        if (gVar3 != null) {
            this.f18397h = I(this.f18397h, O(0, gVar3, this.f18399j, this.f18396g, this.f18398i));
            return;
        }
        g gVar4 = this.f18399j;
        if (gVar4 != null) {
            this.f18399j = I(this.f18399j, O(0, gVar4, this.f18396g, this.f18398i));
            return;
        }
        g gVar5 = this.f18396g;
        if (gVar5 != null) {
            this.f18396g = I(this.f18396g, O(0, gVar5, this.f18398i));
        }
    }

    public void l0() {
        this.f18397h = null;
    }

    @Override // r3.s
    public m m() {
        g gVar = this.f18397h;
        if (gVar == null) {
            return null;
        }
        while (!(((m) gVar.f18408a).r() instanceof r3.e)) {
            gVar = gVar.f18409b;
            if (gVar == null) {
                return (m) this.f18397h.f18408a;
            }
        }
        return (m) gVar.f18408a;
    }

    public void m0() {
        this.f18396g = Q(this.f18396g);
        this.f18398i = Q(this.f18398i);
        this.f18399j = Q(this.f18399j);
        this.f18397h = Q(this.f18397h);
    }

    @Override // r3.s
    public Iterator n() {
        g gVar = this.f18397h;
        return gVar == null ? d4.h.n() : new h(gVar);
    }

    public w.a n0(boolean z10, c0 c0Var) {
        w.a d02 = d0();
        if (d02 == null) {
            d02 = w.a.AUTO;
        }
        int i10 = f.f18407a[d02.ordinal()];
        if (i10 == 1) {
            if (c0Var != null) {
                c0Var.j(getName());
                Iterator it = e0().iterator();
                while (it.hasNext()) {
                    c0Var.j(((k3.x) it.next()).c());
                }
            }
            this.f18399j = null;
            this.f18397h = null;
            if (!this.f18391b) {
                this.f18396g = null;
            }
        } else if (i10 != 2) {
            if (i10 != 3) {
                this.f18398i = R(this.f18398i);
                this.f18397h = R(this.f18397h);
                if (!z10 || this.f18398i == null) {
                    this.f18396g = R(this.f18396g);
                    this.f18399j = R(this.f18399j);
                }
            } else {
                this.f18398i = null;
                if (this.f18391b) {
                    this.f18396g = null;
                }
            }
        }
        return d02;
    }

    @Override // r3.s
    public r3.g o() {
        g gVar = this.f18396g;
        if (gVar == null) {
            return null;
        }
        r3.g gVar2 = (r3.g) gVar.f18408a;
        for (g gVar3 = gVar.f18409b; gVar3 != null; gVar3 = gVar3.f18409b) {
            r3.g gVar4 = (r3.g) gVar3.f18408a;
            Class<?> k10 = gVar2.k();
            Class k11 = gVar4.k();
            if (k10 != k11) {
                if (k10.isAssignableFrom(k11)) {
                    gVar2 = gVar4;
                } else if (k11.isAssignableFrom(k10)) {
                }
            }
            throw new IllegalArgumentException("Multiple fields representing property \"" + getName() + "\": " + gVar2.l() + " vs " + gVar4.l());
        }
        return gVar2;
    }

    public void o0() {
        this.f18396g = T(this.f18396g);
        this.f18398i = T(this.f18398i);
        this.f18399j = T(this.f18399j);
        this.f18397h = T(this.f18397h);
    }

    @Override // r3.s
    public j p() {
        g gVar = this.f18398i;
        if (gVar == null) {
            return null;
        }
        g gVar2 = gVar.f18409b;
        if (gVar2 == null) {
            return (j) gVar.f18408a;
        }
        while (gVar2 != null) {
            Class<?> k10 = ((j) gVar.f18408a).k();
            Class k11 = ((j) gVar2.f18408a).k();
            if (k10 != k11) {
                if (!k10.isAssignableFrom(k11)) {
                    if (k11.isAssignableFrom(k10)) {
                        continue;
                        gVar2 = gVar2.f18409b;
                    }
                }
                gVar = gVar2;
                gVar2 = gVar2.f18409b;
            }
            int N = N((j) gVar2.f18408a);
            int N2 = N((j) gVar.f18408a);
            if (N == N2) {
                throw new IllegalArgumentException("Conflicting getter definitions for property \"" + getName() + "\": " + ((j) gVar.f18408a).l() + " vs " + ((j) gVar2.f18408a).l());
            }
            if (N >= N2) {
                gVar2 = gVar2.f18409b;
            }
            gVar = gVar2;
            gVar2 = gVar2.f18409b;
        }
        this.f18398i = gVar.f();
        return (j) gVar.f18408a;
    }

    public d0 p0(k3.x xVar) {
        return new d0(this, xVar);
    }

    @Override // r3.s
    public r3.i s() {
        if (this.f18391b) {
            return l();
        }
        r3.i q10 = q();
        return q10 == null ? l() : q10;
    }

    @Override // r3.s
    public k3.j t() {
        if (this.f18391b) {
            r3.b p10 = p();
            return (p10 == null && (p10 = o()) == null) ? c4.o.O() : p10.f();
        }
        r3.b m10 = m();
        if (m10 == null) {
            j v10 = v();
            if (v10 != null) {
                return v10.w(0);
            }
            m10 = o();
        }
        return (m10 == null && (m10 = p()) == null) ? c4.o.O() : m10.f();
    }

    public String toString() {
        return "[Property '" + this.f18394e + "'; ctors: " + this.f18397h + ", field(s): " + this.f18396g + ", getter(s): " + this.f18398i + ", setter(s): " + this.f18399j + "]";
    }

    @Override // r3.s
    public Class u() {
        return t().q();
    }

    @Override // r3.s
    public j v() {
        g gVar = this.f18399j;
        if (gVar == null) {
            return null;
        }
        g gVar2 = gVar.f18409b;
        if (gVar2 == null) {
            return (j) gVar.f18408a;
        }
        while (gVar2 != null) {
            Class<?> k10 = ((j) gVar.f18408a).k();
            Class k11 = ((j) gVar2.f18408a).k();
            if (k10 != k11) {
                if (!k10.isAssignableFrom(k11)) {
                    if (k11.isAssignableFrom(k10)) {
                        continue;
                        gVar2 = gVar2.f18409b;
                    }
                }
                gVar = gVar2;
                gVar2 = gVar2.f18409b;
            }
            j jVar = (j) gVar2.f18408a;
            j jVar2 = (j) gVar.f18408a;
            int S = S(jVar);
            int S2 = S(jVar2);
            if (S == S2) {
                k3.b bVar = this.f18393d;
                if (bVar != null) {
                    j w02 = bVar.w0(this.f18392c, jVar2, jVar);
                    if (w02 != jVar2) {
                        if (w02 != jVar) {
                        }
                        gVar = gVar2;
                    } else {
                        continue;
                    }
                }
                throw new IllegalArgumentException(String.format("Conflicting setter definitions for property \"%s\": %s vs %s", getName(), ((j) gVar.f18408a).l(), ((j) gVar2.f18408a).l()));
            }
            if (S >= S2) {
            }
            gVar = gVar2;
            gVar2 = gVar2.f18409b;
        }
        this.f18399j = gVar.f();
        return (j) gVar.f18408a;
    }

    @Override // r3.s
    public k3.x w() {
        k3.b bVar;
        r3.i s10 = s();
        if (s10 == null || (bVar = this.f18393d) == null) {
            return null;
        }
        return bVar.g0(s10);
    }

    @Override // r3.s
    public boolean x() {
        return this.f18397h != null;
    }

    @Override // r3.s
    public boolean y() {
        return this.f18396g != null;
    }

    @Override // r3.s
    public boolean z(k3.x xVar) {
        return this.f18394e.equals(xVar);
    }

    public d0(m3.m mVar, k3.b bVar, boolean z10, k3.x xVar, k3.x xVar2) {
        this.f18392c = mVar;
        this.f18393d = bVar;
        this.f18395f = xVar;
        this.f18394e = xVar2;
        this.f18391b = z10;
    }

    public d0(d0 d0Var, k3.x xVar) {
        this.f18392c = d0Var.f18392c;
        this.f18393d = d0Var.f18393d;
        this.f18395f = d0Var.f18395f;
        this.f18394e = xVar;
        this.f18396g = d0Var.f18396g;
        this.f18397h = d0Var.f18397h;
        this.f18398i = d0Var.f18398i;
        this.f18399j = d0Var.f18399j;
        this.f18391b = d0Var.f18391b;
    }
}
