package androidx.transition;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.transition.n;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class e extends androidx.fragment.app.g0 {

    public class a extends n.f {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Rect f3459a;

        public a(Rect rect) {
            this.f3459a = rect;
        }

        @Override // androidx.transition.n.f
        public Rect a(n nVar) {
            return this.f3459a;
        }
    }

    public class b implements n.g {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f3461a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ArrayList f3462b;

        public b(View view, ArrayList arrayList) {
            this.f3461a = view;
            this.f3462b = arrayList;
        }

        @Override // androidx.transition.n.g
        public void a(n nVar) {
        }

        @Override // androidx.transition.n.g
        public void b(n nVar) {
        }

        @Override // androidx.transition.n.g
        public void c(n nVar) {
        }

        @Override // androidx.transition.n.g
        public void d(n nVar) {
            nVar.removeListener(this);
            this.f3461a.setVisibility(8);
            int size = this.f3462b.size();
            for (int i10 = 0; i10 < size; i10++) {
                ((View) this.f3462b.get(i10)).setVisibility(0);
            }
        }

        @Override // androidx.transition.n.g
        public void e(n nVar) {
        }
    }

    public class c extends o {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Object f3464a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ArrayList f3465b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Object f3466c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ ArrayList f3467d;

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ Object f3468e;

        /* renamed from: f, reason: collision with root package name */
        public final /* synthetic */ ArrayList f3469f;

        public c(Object obj, ArrayList arrayList, Object obj2, ArrayList arrayList2, Object obj3, ArrayList arrayList3) {
            this.f3464a = obj;
            this.f3465b = arrayList;
            this.f3466c = obj2;
            this.f3467d = arrayList2;
            this.f3468e = obj3;
            this.f3469f = arrayList3;
        }

        @Override // androidx.transition.o, androidx.transition.n.g
        public void b(n nVar) {
            Object obj = this.f3464a;
            if (obj != null) {
                e.this.q(obj, this.f3465b, null);
            }
            Object obj2 = this.f3466c;
            if (obj2 != null) {
                e.this.q(obj2, this.f3467d, null);
            }
            Object obj3 = this.f3468e;
            if (obj3 != null) {
                e.this.q(obj3, this.f3469f, null);
            }
        }

        @Override // androidx.transition.n.g
        public void d(n nVar) {
            nVar.removeListener(this);
        }
    }

    public class d extends n.f {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Rect f3471a;

        public d(Rect rect) {
            this.f3471a = rect;
        }

        @Override // androidx.transition.n.f
        public Rect a(n nVar) {
            Rect rect = this.f3471a;
            if (rect == null || rect.isEmpty()) {
                return null;
            }
            return this.f3471a;
        }
    }

    public static boolean C(n nVar) {
        return (androidx.fragment.app.g0.l(nVar.getTargetIds()) && androidx.fragment.app.g0.l(nVar.getTargetNames()) && androidx.fragment.app.g0.l(nVar.getTargetTypes())) ? false : true;
    }

    @Override // androidx.fragment.app.g0
    public void A(Object obj, ArrayList arrayList, ArrayList arrayList2) {
        r rVar = (r) obj;
        if (rVar != null) {
            rVar.getTargets().clear();
            rVar.getTargets().addAll(arrayList2);
            q(rVar, arrayList, arrayList2);
        }
    }

    @Override // androidx.fragment.app.g0
    public Object B(Object obj) {
        if (obj == null) {
            return null;
        }
        r rVar = new r();
        rVar.w((n) obj);
        return rVar;
    }

    @Override // androidx.fragment.app.g0
    public void a(Object obj, View view) {
        if (obj != null) {
            ((n) obj).addTarget(view);
        }
    }

    @Override // androidx.fragment.app.g0
    public void b(Object obj, ArrayList arrayList) {
        n nVar = (n) obj;
        if (nVar == null) {
            return;
        }
        int i10 = 0;
        if (nVar instanceof r) {
            r rVar = (r) nVar;
            int z10 = rVar.z();
            while (i10 < z10) {
                b(rVar.y(i10), arrayList);
                i10++;
            }
            return;
        }
        if (C(nVar) || !androidx.fragment.app.g0.l(nVar.getTargets())) {
            return;
        }
        int size = arrayList.size();
        while (i10 < size) {
            nVar.addTarget((View) arrayList.get(i10));
            i10++;
        }
    }

    @Override // androidx.fragment.app.g0
    public void c(ViewGroup viewGroup, Object obj) {
        p.a(viewGroup, (n) obj);
    }

    @Override // androidx.fragment.app.g0
    public boolean e(Object obj) {
        return obj instanceof n;
    }

    @Override // androidx.fragment.app.g0
    public Object g(Object obj) {
        if (obj != null) {
            return ((n) obj).mo0clone();
        }
        return null;
    }

    @Override // androidx.fragment.app.g0
    public Object m(Object obj, Object obj2, Object obj3) {
        n nVar = (n) obj;
        n nVar2 = (n) obj2;
        n nVar3 = (n) obj3;
        if (nVar != null && nVar2 != null) {
            nVar = new r().w(nVar).w(nVar2).H(1);
        } else if (nVar == null) {
            nVar = nVar2 != null ? nVar2 : null;
        }
        if (nVar3 == null) {
            return nVar;
        }
        r rVar = new r();
        if (nVar != null) {
            rVar.w(nVar);
        }
        rVar.w(nVar3);
        return rVar;
    }

    @Override // androidx.fragment.app.g0
    public Object n(Object obj, Object obj2, Object obj3) {
        r rVar = new r();
        if (obj != null) {
            rVar.w((n) obj);
        }
        if (obj2 != null) {
            rVar.w((n) obj2);
        }
        if (obj3 != null) {
            rVar.w((n) obj3);
        }
        return rVar;
    }

    @Override // androidx.fragment.app.g0
    public void p(Object obj, View view) {
        if (obj != null) {
            ((n) obj).removeTarget(view);
        }
    }

    @Override // androidx.fragment.app.g0
    public void q(Object obj, ArrayList arrayList, ArrayList arrayList2) {
        n nVar = (n) obj;
        int i10 = 0;
        if (nVar instanceof r) {
            r rVar = (r) nVar;
            int z10 = rVar.z();
            while (i10 < z10) {
                q(rVar.y(i10), arrayList, arrayList2);
                i10++;
            }
            return;
        }
        if (C(nVar)) {
            return;
        }
        List<View> targets = nVar.getTargets();
        if (targets.size() == arrayList.size() && targets.containsAll(arrayList)) {
            int size = arrayList2 == null ? 0 : arrayList2.size();
            while (i10 < size) {
                nVar.addTarget((View) arrayList2.get(i10));
                i10++;
            }
            for (int size2 = arrayList.size() - 1; size2 >= 0; size2--) {
                nVar.removeTarget((View) arrayList.get(size2));
            }
        }
    }

    @Override // androidx.fragment.app.g0
    public void r(Object obj, View view, ArrayList arrayList) {
        ((n) obj).addListener(new b(view, arrayList));
    }

    @Override // androidx.fragment.app.g0
    public void t(Object obj, Object obj2, ArrayList arrayList, Object obj3, ArrayList arrayList2, Object obj4, ArrayList arrayList3) {
        ((n) obj).addListener(new c(obj2, arrayList, obj3, arrayList2, obj4, arrayList3));
    }

    @Override // androidx.fragment.app.g0
    public void u(Object obj, Rect rect) {
        if (obj != null) {
            ((n) obj).setEpicenterCallback(new d(rect));
        }
    }

    @Override // androidx.fragment.app.g0
    public void v(Object obj, View view) {
        if (view != null) {
            Rect rect = new Rect();
            k(view, rect);
            ((n) obj).setEpicenterCallback(new a(rect));
        }
    }

    @Override // androidx.fragment.app.g0
    public void z(Object obj, View view, ArrayList arrayList) {
        r rVar = (r) obj;
        List<View> targets = rVar.getTargets();
        targets.clear();
        int size = arrayList.size();
        for (int i10 = 0; i10 < size; i10++) {
            androidx.fragment.app.g0.d(targets, (View) arrayList.get(i10));
        }
        targets.add(view);
        arrayList.add(view);
        b(rVar, arrayList);
    }
}
