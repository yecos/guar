package androidx.fragment.app;

import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.R$id;
import b0.c1;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import x.b;

/* loaded from: classes.dex */
public abstract class j0 {

    /* renamed from: a, reason: collision with root package name */
    public final ViewGroup f2298a;

    /* renamed from: b, reason: collision with root package name */
    public final ArrayList f2299b = new ArrayList();

    /* renamed from: c, reason: collision with root package name */
    public final ArrayList f2300c = new ArrayList();

    /* renamed from: d, reason: collision with root package name */
    public boolean f2301d = false;

    /* renamed from: e, reason: collision with root package name */
    public boolean f2302e = false;

    public class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d f2303a;

        public a(d dVar) {
            this.f2303a = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (j0.this.f2299b.contains(this.f2303a)) {
                this.f2303a.e().a(this.f2303a.f().mView);
            }
        }
    }

    public class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d f2305a;

        public b(d dVar) {
            this.f2305a = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            j0.this.f2299b.remove(this.f2305a);
            j0.this.f2300c.remove(this.f2305a);
        }
    }

    public static /* synthetic */ class c {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f2307a;

        /* renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f2308b;

        static {
            int[] iArr = new int[e.b.values().length];
            f2308b = iArr;
            try {
                iArr[e.b.ADDING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f2308b[e.b.REMOVING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f2308b[e.b.NONE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            int[] iArr2 = new int[e.c.values().length];
            f2307a = iArr2;
            try {
                iArr2[e.c.REMOVED.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f2307a[e.c.VISIBLE.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f2307a[e.c.GONE.ordinal()] = 3;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f2307a[e.c.INVISIBLE.ordinal()] = 4;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    public static class d extends e {

        /* renamed from: h, reason: collision with root package name */
        public final v f2309h;

        public d(e.c cVar, e.b bVar, v vVar, x.b bVar2) {
            super(cVar, bVar, vVar.k(), bVar2);
            this.f2309h = vVar;
        }

        @Override // androidx.fragment.app.j0.e
        public void c() {
            super.c();
            this.f2309h.m();
        }

        @Override // androidx.fragment.app.j0.e
        public void l() {
            if (g() == e.b.ADDING) {
                Fragment k10 = this.f2309h.k();
                View findFocus = k10.mView.findFocus();
                if (findFocus != null) {
                    k10.setFocusedView(findFocus);
                    if (o.F0(2)) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("requestFocus: Saved focused view ");
                        sb.append(findFocus);
                        sb.append(" for Fragment ");
                        sb.append(k10);
                    }
                }
                View requireView = f().requireView();
                if (requireView.getParent() == null) {
                    this.f2309h.b();
                    requireView.setAlpha(0.0f);
                }
                if (requireView.getAlpha() == 0.0f && requireView.getVisibility() == 0) {
                    requireView.setVisibility(4);
                }
                requireView.setAlpha(k10.getPostOnViewCreatedAlpha());
            }
        }
    }

    public static class e {

        /* renamed from: a, reason: collision with root package name */
        public c f2310a;

        /* renamed from: b, reason: collision with root package name */
        public b f2311b;

        /* renamed from: c, reason: collision with root package name */
        public final Fragment f2312c;

        /* renamed from: d, reason: collision with root package name */
        public final List f2313d = new ArrayList();

        /* renamed from: e, reason: collision with root package name */
        public final HashSet f2314e = new HashSet();

        /* renamed from: f, reason: collision with root package name */
        public boolean f2315f = false;

        /* renamed from: g, reason: collision with root package name */
        public boolean f2316g = false;

        public class a implements b.a {
            public a() {
            }

            @Override // x.b.a
            public void a() {
                e.this.b();
            }
        }

        public enum b {
            NONE,
            ADDING,
            REMOVING
        }

        public enum c {
            REMOVED,
            VISIBLE,
            GONE,
            INVISIBLE;

            public static c b(int i10) {
                if (i10 == 0) {
                    return VISIBLE;
                }
                if (i10 == 4) {
                    return INVISIBLE;
                }
                if (i10 == 8) {
                    return GONE;
                }
                throw new IllegalArgumentException("Unknown visibility " + i10);
            }

            public static c c(View view) {
                return (view.getAlpha() == 0.0f && view.getVisibility() == 0) ? INVISIBLE : b(view.getVisibility());
            }

            public void a(View view) {
                int i10 = c.f2307a[ordinal()];
                if (i10 == 1) {
                    ViewGroup viewGroup = (ViewGroup) view.getParent();
                    if (viewGroup != null) {
                        if (o.F0(2)) {
                            StringBuilder sb = new StringBuilder();
                            sb.append("SpecialEffectsController: Removing view ");
                            sb.append(view);
                            sb.append(" from container ");
                            sb.append(viewGroup);
                        }
                        viewGroup.removeView(view);
                        return;
                    }
                    return;
                }
                if (i10 == 2) {
                    if (o.F0(2)) {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("SpecialEffectsController: Setting view ");
                        sb2.append(view);
                        sb2.append(" to VISIBLE");
                    }
                    view.setVisibility(0);
                    return;
                }
                if (i10 == 3) {
                    if (o.F0(2)) {
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append("SpecialEffectsController: Setting view ");
                        sb3.append(view);
                        sb3.append(" to GONE");
                    }
                    view.setVisibility(8);
                    return;
                }
                if (i10 != 4) {
                    return;
                }
                if (o.F0(2)) {
                    StringBuilder sb4 = new StringBuilder();
                    sb4.append("SpecialEffectsController: Setting view ");
                    sb4.append(view);
                    sb4.append(" to INVISIBLE");
                }
                view.setVisibility(4);
            }
        }

        public e(c cVar, b bVar, Fragment fragment, x.b bVar2) {
            this.f2310a = cVar;
            this.f2311b = bVar;
            this.f2312c = fragment;
            bVar2.c(new a());
        }

        public final void a(Runnable runnable) {
            this.f2313d.add(runnable);
        }

        public final void b() {
            if (h()) {
                return;
            }
            this.f2315f = true;
            if (this.f2314e.isEmpty()) {
                c();
                return;
            }
            Iterator it = new ArrayList(this.f2314e).iterator();
            while (it.hasNext()) {
                ((x.b) it.next()).a();
            }
        }

        public void c() {
            if (this.f2316g) {
                return;
            }
            if (o.F0(2)) {
                StringBuilder sb = new StringBuilder();
                sb.append("SpecialEffectsController: ");
                sb.append(this);
                sb.append(" has called complete.");
            }
            this.f2316g = true;
            Iterator it = this.f2313d.iterator();
            while (it.hasNext()) {
                ((Runnable) it.next()).run();
            }
        }

        public final void d(x.b bVar) {
            if (this.f2314e.remove(bVar) && this.f2314e.isEmpty()) {
                c();
            }
        }

        public c e() {
            return this.f2310a;
        }

        public final Fragment f() {
            return this.f2312c;
        }

        public b g() {
            return this.f2311b;
        }

        public final boolean h() {
            return this.f2315f;
        }

        public final boolean i() {
            return this.f2316g;
        }

        public final void j(x.b bVar) {
            l();
            this.f2314e.add(bVar);
        }

        public final void k(c cVar, b bVar) {
            int i10 = c.f2308b[bVar.ordinal()];
            if (i10 == 1) {
                if (this.f2310a == c.REMOVED) {
                    if (o.F0(2)) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("SpecialEffectsController: For fragment ");
                        sb.append(this.f2312c);
                        sb.append(" mFinalState = REMOVED -> VISIBLE. mLifecycleImpact = ");
                        sb.append(this.f2311b);
                        sb.append(" to ADDING.");
                    }
                    this.f2310a = c.VISIBLE;
                    this.f2311b = b.ADDING;
                    return;
                }
                return;
            }
            if (i10 == 2) {
                if (o.F0(2)) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("SpecialEffectsController: For fragment ");
                    sb2.append(this.f2312c);
                    sb2.append(" mFinalState = ");
                    sb2.append(this.f2310a);
                    sb2.append(" -> REMOVED. mLifecycleImpact  = ");
                    sb2.append(this.f2311b);
                    sb2.append(" to REMOVING.");
                }
                this.f2310a = c.REMOVED;
                this.f2311b = b.REMOVING;
                return;
            }
            if (i10 == 3 && this.f2310a != c.REMOVED) {
                if (o.F0(2)) {
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("SpecialEffectsController: For fragment ");
                    sb3.append(this.f2312c);
                    sb3.append(" mFinalState = ");
                    sb3.append(this.f2310a);
                    sb3.append(" -> ");
                    sb3.append(cVar);
                    sb3.append(". ");
                }
                this.f2310a = cVar;
            }
        }

        public abstract void l();

        public String toString() {
            return "Operation {" + Integer.toHexString(System.identityHashCode(this)) + "} {mFinalState = " + this.f2310a + "} {mLifecycleImpact = " + this.f2311b + "} {mFragment = " + this.f2312c + "}";
        }
    }

    public j0(ViewGroup viewGroup) {
        this.f2298a = viewGroup;
    }

    public static j0 n(ViewGroup viewGroup, o oVar) {
        return o(viewGroup, oVar.y0());
    }

    public static j0 o(ViewGroup viewGroup, k0 k0Var) {
        int i10 = R$id.special_effects_controller_view_tag;
        Object tag = viewGroup.getTag(i10);
        if (tag instanceof j0) {
            return (j0) tag;
        }
        j0 a10 = k0Var.a(viewGroup);
        viewGroup.setTag(i10, a10);
        return a10;
    }

    public final void a(e.c cVar, e.b bVar, v vVar) {
        synchronized (this.f2299b) {
            x.b bVar2 = new x.b();
            e h10 = h(vVar.k());
            if (h10 != null) {
                h10.k(cVar, bVar);
                return;
            }
            d dVar = new d(cVar, bVar, vVar, bVar2);
            this.f2299b.add(dVar);
            dVar.a(new a(dVar));
            dVar.a(new b(dVar));
        }
    }

    public void b(e.c cVar, v vVar) {
        if (o.F0(2)) {
            StringBuilder sb = new StringBuilder();
            sb.append("SpecialEffectsController: Enqueuing add operation for fragment ");
            sb.append(vVar.k());
        }
        a(cVar, e.b.ADDING, vVar);
    }

    public void c(v vVar) {
        if (o.F0(2)) {
            StringBuilder sb = new StringBuilder();
            sb.append("SpecialEffectsController: Enqueuing hide operation for fragment ");
            sb.append(vVar.k());
        }
        a(e.c.GONE, e.b.NONE, vVar);
    }

    public void d(v vVar) {
        if (o.F0(2)) {
            StringBuilder sb = new StringBuilder();
            sb.append("SpecialEffectsController: Enqueuing remove operation for fragment ");
            sb.append(vVar.k());
        }
        a(e.c.REMOVED, e.b.REMOVING, vVar);
    }

    public void e(v vVar) {
        if (o.F0(2)) {
            StringBuilder sb = new StringBuilder();
            sb.append("SpecialEffectsController: Enqueuing show operation for fragment ");
            sb.append(vVar.k());
        }
        a(e.c.VISIBLE, e.b.NONE, vVar);
    }

    public abstract void f(List list, boolean z10);

    public void g() {
        if (this.f2302e) {
            return;
        }
        if (!c1.P(this.f2298a)) {
            j();
            this.f2301d = false;
            return;
        }
        synchronized (this.f2299b) {
            if (!this.f2299b.isEmpty()) {
                ArrayList arrayList = new ArrayList(this.f2300c);
                this.f2300c.clear();
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    e eVar = (e) it.next();
                    if (o.F0(2)) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("SpecialEffectsController: Cancelling operation ");
                        sb.append(eVar);
                    }
                    eVar.b();
                    if (!eVar.i()) {
                        this.f2300c.add(eVar);
                    }
                }
                q();
                ArrayList arrayList2 = new ArrayList(this.f2299b);
                this.f2299b.clear();
                this.f2300c.addAll(arrayList2);
                Iterator it2 = arrayList2.iterator();
                while (it2.hasNext()) {
                    ((e) it2.next()).l();
                }
                f(arrayList2, this.f2301d);
                this.f2301d = false;
            }
        }
    }

    public final e h(Fragment fragment) {
        Iterator it = this.f2299b.iterator();
        while (it.hasNext()) {
            e eVar = (e) it.next();
            if (eVar.f().equals(fragment) && !eVar.h()) {
                return eVar;
            }
        }
        return null;
    }

    public final e i(Fragment fragment) {
        Iterator it = this.f2300c.iterator();
        while (it.hasNext()) {
            e eVar = (e) it.next();
            if (eVar.f().equals(fragment) && !eVar.h()) {
                return eVar;
            }
        }
        return null;
    }

    public void j() {
        String str;
        String str2;
        boolean P = c1.P(this.f2298a);
        synchronized (this.f2299b) {
            q();
            Iterator it = this.f2299b.iterator();
            while (it.hasNext()) {
                ((e) it.next()).l();
            }
            Iterator it2 = new ArrayList(this.f2300c).iterator();
            while (it2.hasNext()) {
                e eVar = (e) it2.next();
                if (o.F0(2)) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("SpecialEffectsController: ");
                    if (P) {
                        str2 = "";
                    } else {
                        str2 = "Container " + this.f2298a + " is not attached to window. ";
                    }
                    sb.append(str2);
                    sb.append("Cancelling running operation ");
                    sb.append(eVar);
                }
                eVar.b();
            }
            Iterator it3 = new ArrayList(this.f2299b).iterator();
            while (it3.hasNext()) {
                e eVar2 = (e) it3.next();
                if (o.F0(2)) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("SpecialEffectsController: ");
                    if (P) {
                        str = "";
                    } else {
                        str = "Container " + this.f2298a + " is not attached to window. ";
                    }
                    sb2.append(str);
                    sb2.append("Cancelling pending operation ");
                    sb2.append(eVar2);
                }
                eVar2.b();
            }
        }
    }

    public void k() {
        if (this.f2302e) {
            this.f2302e = false;
            g();
        }
    }

    public e.b l(v vVar) {
        e h10 = h(vVar.k());
        e.b g10 = h10 != null ? h10.g() : null;
        e i10 = i(vVar.k());
        return (i10 == null || !(g10 == null || g10 == e.b.NONE)) ? g10 : i10.g();
    }

    public ViewGroup m() {
        return this.f2298a;
    }

    public void p() {
        synchronized (this.f2299b) {
            q();
            this.f2302e = false;
            int size = this.f2299b.size() - 1;
            while (true) {
                if (size < 0) {
                    break;
                }
                e eVar = (e) this.f2299b.get(size);
                e.c c10 = e.c.c(eVar.f().mView);
                e.c e10 = eVar.e();
                e.c cVar = e.c.VISIBLE;
                if (e10 == cVar && c10 != cVar) {
                    this.f2302e = eVar.f().isPostponed();
                    break;
                }
                size--;
            }
        }
    }

    public final void q() {
        Iterator it = this.f2299b.iterator();
        while (it.hasNext()) {
            e eVar = (e) it.next();
            if (eVar.g() == e.b.ADDING) {
                eVar.k(e.c.b(eVar.f().requireView().getVisibility()), e.b.NONE);
            }
        }
    }

    public void r(boolean z10) {
        this.f2301d = z10;
    }
}
