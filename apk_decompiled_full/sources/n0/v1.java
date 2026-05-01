package n0;

import android.content.ComponentName;
import android.content.Context;
import android.content.IntentFilter;
import android.os.Build;
import android.view.Display;
import androidx.mediarouter.R$string;
import com.hpplay.component.protocol.mirror.AutoStrategy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import n0.l1;
import n0.m1;
import n0.n0;
import n0.n1;
import n0.p0;
import n0.q0;
import n0.t0;

/* loaded from: classes.dex */
public abstract class v1 extends p0 {

    public static class a extends d {
        public a(Context context, e eVar) {
            super(context, eVar);
        }

        @Override // n0.v1.d, n0.v1.c, n0.v1.b
        public void O(b.C0294b c0294b, n0.a aVar) {
            super.O(c0294b, aVar);
            aVar.i(k1.a(c0294b.f17140a));
        }
    }

    public static class b extends v1 implements l1.a, l1.e {

        /* renamed from: s, reason: collision with root package name */
        public static final ArrayList f17127s;

        /* renamed from: t, reason: collision with root package name */
        public static final ArrayList f17128t;

        /* renamed from: i, reason: collision with root package name */
        public final e f17129i;

        /* renamed from: j, reason: collision with root package name */
        public final Object f17130j;

        /* renamed from: k, reason: collision with root package name */
        public final Object f17131k;

        /* renamed from: l, reason: collision with root package name */
        public final Object f17132l;

        /* renamed from: m, reason: collision with root package name */
        public final Object f17133m;

        /* renamed from: n, reason: collision with root package name */
        public int f17134n;

        /* renamed from: o, reason: collision with root package name */
        public boolean f17135o;

        /* renamed from: p, reason: collision with root package name */
        public boolean f17136p;

        /* renamed from: q, reason: collision with root package name */
        public final ArrayList f17137q;

        /* renamed from: r, reason: collision with root package name */
        public final ArrayList f17138r;

        public static final class a extends p0.e {

            /* renamed from: a, reason: collision with root package name */
            public final Object f17139a;

            public a(Object obj) {
                this.f17139a = obj;
            }

            @Override // n0.p0.e
            public void f(int i10) {
                l1.c.i(this.f17139a, i10);
            }

            @Override // n0.p0.e
            public void i(int i10) {
                l1.c.j(this.f17139a, i10);
            }
        }

        /* renamed from: n0.v1$b$b, reason: collision with other inner class name */
        public static final class C0294b {

            /* renamed from: a, reason: collision with root package name */
            public final Object f17140a;

            /* renamed from: b, reason: collision with root package name */
            public final String f17141b;

            /* renamed from: c, reason: collision with root package name */
            public n0 f17142c;

            public C0294b(Object obj, String str) {
                this.f17140a = obj;
                this.f17141b = str;
            }
        }

        public static final class c {

            /* renamed from: a, reason: collision with root package name */
            public final t0.i f17143a;

            /* renamed from: b, reason: collision with root package name */
            public final Object f17144b;

            public c(t0.i iVar, Object obj) {
                this.f17143a = iVar;
                this.f17144b = obj;
            }
        }

        static {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addCategory("android.media.intent.category.LIVE_AUDIO");
            ArrayList arrayList = new ArrayList();
            f17127s = arrayList;
            arrayList.add(intentFilter);
            IntentFilter intentFilter2 = new IntentFilter();
            intentFilter2.addCategory("android.media.intent.category.LIVE_VIDEO");
            ArrayList arrayList2 = new ArrayList();
            f17128t = arrayList2;
            arrayList2.add(intentFilter2);
        }

        public b(Context context, e eVar) {
            super(context);
            this.f17137q = new ArrayList();
            this.f17138r = new ArrayList();
            this.f17129i = eVar;
            Object e10 = l1.e(context);
            this.f17130j = e10;
            this.f17131k = G();
            this.f17132l = H();
            this.f17133m = l1.b(e10, context.getResources().getString(R$string.mr_user_route_category_name), false);
            T();
        }

        @Override // n0.v1
        public void A(t0.i iVar) {
            if (iVar.r() == this) {
                int I = I(l1.g(this.f17130j, 8388611));
                if (I < 0 || !((C0294b) this.f17137q.get(I)).f17141b.equals(iVar.e())) {
                    return;
                }
                iVar.I();
                return;
            }
            Object c10 = l1.c(this.f17130j, this.f17133m);
            c cVar = new c(iVar, c10);
            l1.c.k(c10, cVar);
            l1.d.f(c10, this.f17132l);
            U(cVar);
            this.f17138r.add(cVar);
            l1.a(this.f17130j, c10);
        }

        @Override // n0.v1
        public void B(t0.i iVar) {
            int K;
            if (iVar.r() == this || (K = K(iVar)) < 0) {
                return;
            }
            U((c) this.f17138r.get(K));
        }

        @Override // n0.v1
        public void C(t0.i iVar) {
            int K;
            if (iVar.r() == this || (K = K(iVar)) < 0) {
                return;
            }
            c cVar = (c) this.f17138r.remove(K);
            l1.c.k(cVar.f17144b, null);
            l1.d.f(cVar.f17144b, null);
            l1.i(this.f17130j, cVar.f17144b);
        }

        @Override // n0.v1
        public void D(t0.i iVar) {
            if (iVar.C()) {
                if (iVar.r() != this) {
                    int K = K(iVar);
                    if (K >= 0) {
                        Q(((c) this.f17138r.get(K)).f17144b);
                        return;
                    }
                    return;
                }
                int J = J(iVar.e());
                if (J >= 0) {
                    Q(((C0294b) this.f17137q.get(J)).f17140a);
                }
            }
        }

        public final boolean E(Object obj) {
            if (N(obj) != null || I(obj) >= 0) {
                return false;
            }
            C0294b c0294b = new C0294b(obj, F(obj));
            S(c0294b);
            this.f17137q.add(c0294b);
            return true;
        }

        public final String F(Object obj) {
            String format = L() == obj ? "DEFAULT_ROUTE" : String.format(Locale.US, "ROUTE_%08x", Integer.valueOf(M(obj).hashCode()));
            if (J(format) < 0) {
                return format;
            }
            int i10 = 2;
            while (true) {
                String format2 = String.format(Locale.US, "%s_%d", format, Integer.valueOf(i10));
                if (J(format2) < 0) {
                    return format2;
                }
                i10++;
            }
        }

        public abstract Object G();

        public Object H() {
            return l1.d(this);
        }

        public int I(Object obj) {
            int size = this.f17137q.size();
            for (int i10 = 0; i10 < size; i10++) {
                if (((C0294b) this.f17137q.get(i10)).f17140a == obj) {
                    return i10;
                }
            }
            return -1;
        }

        public int J(String str) {
            int size = this.f17137q.size();
            for (int i10 = 0; i10 < size; i10++) {
                if (((C0294b) this.f17137q.get(i10)).f17141b.equals(str)) {
                    return i10;
                }
            }
            return -1;
        }

        public int K(t0.i iVar) {
            int size = this.f17138r.size();
            for (int i10 = 0; i10 < size; i10++) {
                if (((c) this.f17138r.get(i10)).f17143a == iVar) {
                    return i10;
                }
            }
            return -1;
        }

        public abstract Object L();

        public String M(Object obj) {
            CharSequence a10 = l1.c.a(obj, n());
            return a10 != null ? a10.toString() : "";
        }

        public c N(Object obj) {
            Object e10 = l1.c.e(obj);
            if (e10 instanceof c) {
                return (c) e10;
            }
            return null;
        }

        public void O(C0294b c0294b, n0.a aVar) {
            int d10 = l1.c.d(c0294b.f17140a);
            if ((d10 & 1) != 0) {
                aVar.b(f17127s);
            }
            if ((d10 & 2) != 0) {
                aVar.b(f17128t);
            }
            aVar.p(l1.c.c(c0294b.f17140a));
            aVar.o(l1.c.b(c0294b.f17140a));
            aVar.r(l1.c.f(c0294b.f17140a));
            aVar.t(l1.c.h(c0294b.f17140a));
            aVar.s(l1.c.g(c0294b.f17140a));
        }

        public void P() {
            q0.a aVar = new q0.a();
            int size = this.f17137q.size();
            for (int i10 = 0; i10 < size; i10++) {
                aVar.a(((C0294b) this.f17137q.get(i10)).f17142c);
            }
            w(aVar.c());
        }

        public abstract void Q(Object obj);

        public abstract void R();

        public void S(C0294b c0294b) {
            n0.a aVar = new n0.a(c0294b.f17141b, M(c0294b.f17140a));
            O(c0294b, aVar);
            c0294b.f17142c = aVar.e();
        }

        public final void T() {
            R();
            Iterator it = l1.f(this.f17130j).iterator();
            boolean z10 = false;
            while (it.hasNext()) {
                z10 |= E(it.next());
            }
            if (z10) {
                P();
            }
        }

        public void U(c cVar) {
            l1.d.a(cVar.f17144b, cVar.f17143a.m());
            l1.d.c(cVar.f17144b, cVar.f17143a.o());
            l1.d.b(cVar.f17144b, cVar.f17143a.n());
            l1.d.e(cVar.f17144b, cVar.f17143a.s());
            l1.d.h(cVar.f17144b, cVar.f17143a.u());
            l1.d.g(cVar.f17144b, cVar.f17143a.t());
        }

        @Override // n0.l1.e
        public void a(Object obj, int i10) {
            c N = N(obj);
            if (N != null) {
                N.f17143a.H(i10);
            }
        }

        @Override // n0.l1.a
        public void b(Object obj, Object obj2) {
        }

        @Override // n0.l1.a
        public void c(Object obj, Object obj2, int i10) {
        }

        @Override // n0.l1.e
        public void d(Object obj, int i10) {
            c N = N(obj);
            if (N != null) {
                N.f17143a.G(i10);
            }
        }

        @Override // n0.l1.a
        public void e(Object obj) {
            int I;
            if (N(obj) != null || (I = I(obj)) < 0) {
                return;
            }
            S((C0294b) this.f17137q.get(I));
            P();
        }

        @Override // n0.l1.a
        public void f(int i10, Object obj) {
        }

        @Override // n0.l1.a
        public void g(Object obj) {
            int I;
            if (N(obj) != null || (I = I(obj)) < 0) {
                return;
            }
            this.f17137q.remove(I);
            P();
        }

        @Override // n0.l1.a
        public void h(int i10, Object obj) {
            if (obj != l1.g(this.f17130j, 8388611)) {
                return;
            }
            c N = N(obj);
            if (N != null) {
                N.f17143a.I();
                return;
            }
            int I = I(obj);
            if (I >= 0) {
                this.f17129i.c(((C0294b) this.f17137q.get(I)).f17141b);
            }
        }

        @Override // n0.l1.a
        public void j(Object obj) {
            if (E(obj)) {
                P();
            }
        }

        @Override // n0.l1.a
        public void k(Object obj) {
            int I;
            if (N(obj) != null || (I = I(obj)) < 0) {
                return;
            }
            C0294b c0294b = (C0294b) this.f17137q.get(I);
            int f10 = l1.c.f(obj);
            if (f10 != c0294b.f17142c.t()) {
                c0294b.f17142c = new n0.a(c0294b.f17142c).r(f10).e();
                P();
            }
        }

        @Override // n0.p0
        public p0.e s(String str) {
            int J = J(str);
            if (J >= 0) {
                return new a(((C0294b) this.f17137q.get(J)).f17140a);
            }
            return null;
        }

        @Override // n0.p0
        public void u(o0 o0Var) {
            boolean z10;
            int i10 = 0;
            if (o0Var != null) {
                List e10 = o0Var.c().e();
                int size = e10.size();
                int i11 = 0;
                while (i10 < size) {
                    String str = (String) e10.get(i10);
                    i11 = str.equals("android.media.intent.category.LIVE_AUDIO") ? i11 | 1 : str.equals("android.media.intent.category.LIVE_VIDEO") ? i11 | 2 : i11 | AutoStrategy.BITRATE_HIGH;
                    i10++;
                }
                z10 = o0Var.d();
                i10 = i11;
            } else {
                z10 = false;
            }
            if (this.f17134n == i10 && this.f17135o == z10) {
                return;
            }
            this.f17134n = i10;
            this.f17135o = z10;
            T();
        }
    }

    public static class c extends b implements m1.a {
        public c(Context context, e eVar) {
            super(context, eVar);
        }

        @Override // n0.v1.b
        public Object G() {
            return m1.a(this);
        }

        @Override // n0.v1.b
        public void O(b.C0294b c0294b, n0.a aVar) {
            super.O(c0294b, aVar);
            if (!m1.c.b(c0294b.f17140a)) {
                aVar.j(false);
            }
            if (V(c0294b)) {
                aVar.g(1);
            }
            Display a10 = m1.c.a(c0294b.f17140a);
            if (a10 != null) {
                aVar.q(a10.getDisplayId());
            }
        }

        public abstract boolean V(b.C0294b c0294b);

        @Override // n0.m1.a
        public void i(Object obj) {
            int I = I(obj);
            if (I >= 0) {
                b.C0294b c0294b = (b.C0294b) this.f17137q.get(I);
                Display a10 = m1.c.a(obj);
                int displayId = a10 != null ? a10.getDisplayId() : -1;
                if (displayId != c0294b.f17142c.r()) {
                    c0294b.f17142c = new n0.a(c0294b.f17142c).q(displayId).e();
                    P();
                }
            }
        }
    }

    public static class d extends c {
        public d(Context context, e eVar) {
            super(context, eVar);
        }

        @Override // n0.v1.b
        public Object L() {
            return n1.b(this.f17130j);
        }

        @Override // n0.v1.c, n0.v1.b
        public void O(b.C0294b c0294b, n0.a aVar) {
            super.O(c0294b, aVar);
            CharSequence a10 = n1.a.a(c0294b.f17140a);
            if (a10 != null) {
                aVar.h(a10.toString());
            }
        }

        @Override // n0.v1.b
        public void Q(Object obj) {
            l1.j(this.f17130j, 8388611, obj);
        }

        @Override // n0.v1.b
        public void R() {
            if (this.f17136p) {
                l1.h(this.f17130j, this.f17131k);
            }
            this.f17136p = true;
            n1.a(this.f17130j, this.f17134n, this.f17131k, (this.f17135o ? 1 : 0) | 2);
        }

        @Override // n0.v1.b
        public void U(b.c cVar) {
            super.U(cVar);
            n1.b.a(cVar.f17144b, cVar.f17143a.d());
        }

        @Override // n0.v1.c
        public boolean V(b.C0294b c0294b) {
            return n1.a.b(c0294b.f17140a);
        }
    }

    public interface e {
        void c(String str);
    }

    public v1(Context context) {
        super(context, new p0.d(new ComponentName("android", v1.class.getName())));
    }

    public static v1 z(Context context, e eVar) {
        return Build.VERSION.SDK_INT >= 24 ? new a(context, eVar) : new d(context, eVar);
    }

    public abstract void A(t0.i iVar);

    public abstract void B(t0.i iVar);

    public abstract void C(t0.i iVar);

    public abstract void D(t0.i iVar);
}
