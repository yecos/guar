package androidx.recyclerview.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewPropertyAnimator;
import androidx.recyclerview.widget.RecyclerView;
import b0.c1;
import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public class c extends q {

    /* renamed from: s, reason: collision with root package name */
    public static TimeInterpolator f3152s;

    /* renamed from: h, reason: collision with root package name */
    public ArrayList f3153h = new ArrayList();

    /* renamed from: i, reason: collision with root package name */
    public ArrayList f3154i = new ArrayList();

    /* renamed from: j, reason: collision with root package name */
    public ArrayList f3155j = new ArrayList();

    /* renamed from: k, reason: collision with root package name */
    public ArrayList f3156k = new ArrayList();

    /* renamed from: l, reason: collision with root package name */
    public ArrayList f3157l = new ArrayList();

    /* renamed from: m, reason: collision with root package name */
    public ArrayList f3158m = new ArrayList();

    /* renamed from: n, reason: collision with root package name */
    public ArrayList f3159n = new ArrayList();

    /* renamed from: o, reason: collision with root package name */
    public ArrayList f3160o = new ArrayList();

    /* renamed from: p, reason: collision with root package name */
    public ArrayList f3161p = new ArrayList();

    /* renamed from: q, reason: collision with root package name */
    public ArrayList f3162q = new ArrayList();

    /* renamed from: r, reason: collision with root package name */
    public ArrayList f3163r = new ArrayList();

    public class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ArrayList f3164a;

        public a(ArrayList arrayList) {
            this.f3164a = arrayList;
        }

        @Override // java.lang.Runnable
        public void run() {
            Iterator it = this.f3164a.iterator();
            while (it.hasNext()) {
                j jVar = (j) it.next();
                c.this.S(jVar.f3198a, jVar.f3199b, jVar.f3200c, jVar.f3201d, jVar.f3202e);
            }
            this.f3164a.clear();
            c.this.f3158m.remove(this.f3164a);
        }
    }

    public class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ArrayList f3166a;

        public b(ArrayList arrayList) {
            this.f3166a = arrayList;
        }

        @Override // java.lang.Runnable
        public void run() {
            Iterator it = this.f3166a.iterator();
            while (it.hasNext()) {
                c.this.R((i) it.next());
            }
            this.f3166a.clear();
            c.this.f3159n.remove(this.f3166a);
        }
    }

    /* renamed from: androidx.recyclerview.widget.c$c, reason: collision with other inner class name */
    public class RunnableC0045c implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ArrayList f3168a;

        public RunnableC0045c(ArrayList arrayList) {
            this.f3168a = arrayList;
        }

        @Override // java.lang.Runnable
        public void run() {
            Iterator it = this.f3168a.iterator();
            while (it.hasNext()) {
                c.this.Q((RecyclerView.d0) it.next());
            }
            this.f3168a.clear();
            c.this.f3157l.remove(this.f3168a);
        }
    }

    public class d extends AnimatorListenerAdapter {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ RecyclerView.d0 f3170a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ViewPropertyAnimator f3171b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ View f3172c;

        public d(RecyclerView.d0 d0Var, ViewPropertyAnimator viewPropertyAnimator, View view) {
            this.f3170a = d0Var;
            this.f3171b = viewPropertyAnimator;
            this.f3172c = view;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f3171b.setListener(null);
            this.f3172c.setAlpha(1.0f);
            c.this.G(this.f3170a);
            c.this.f3162q.remove(this.f3170a);
            c.this.V();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            c.this.H(this.f3170a);
        }
    }

    public class e extends AnimatorListenerAdapter {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ RecyclerView.d0 f3174a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ View f3175b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ ViewPropertyAnimator f3176c;

        public e(RecyclerView.d0 d0Var, View view, ViewPropertyAnimator viewPropertyAnimator) {
            this.f3174a = d0Var;
            this.f3175b = view;
            this.f3176c = viewPropertyAnimator;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.f3175b.setAlpha(1.0f);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f3176c.setListener(null);
            c.this.A(this.f3174a);
            c.this.f3160o.remove(this.f3174a);
            c.this.V();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            c.this.B(this.f3174a);
        }
    }

    public class f extends AnimatorListenerAdapter {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ RecyclerView.d0 f3178a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f3179b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ View f3180c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ int f3181d;

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ ViewPropertyAnimator f3182e;

        public f(RecyclerView.d0 d0Var, int i10, View view, int i11, ViewPropertyAnimator viewPropertyAnimator) {
            this.f3178a = d0Var;
            this.f3179b = i10;
            this.f3180c = view;
            this.f3181d = i11;
            this.f3182e = viewPropertyAnimator;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            if (this.f3179b != 0) {
                this.f3180c.setTranslationX(0.0f);
            }
            if (this.f3181d != 0) {
                this.f3180c.setTranslationY(0.0f);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f3182e.setListener(null);
            c.this.E(this.f3178a);
            c.this.f3161p.remove(this.f3178a);
            c.this.V();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            c.this.F(this.f3178a);
        }
    }

    public class g extends AnimatorListenerAdapter {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ i f3184a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ViewPropertyAnimator f3185b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ View f3186c;

        public g(i iVar, ViewPropertyAnimator viewPropertyAnimator, View view) {
            this.f3184a = iVar;
            this.f3185b = viewPropertyAnimator;
            this.f3186c = view;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f3185b.setListener(null);
            this.f3186c.setAlpha(1.0f);
            this.f3186c.setTranslationX(0.0f);
            this.f3186c.setTranslationY(0.0f);
            c.this.C(this.f3184a.f3192a, true);
            c.this.f3163r.remove(this.f3184a.f3192a);
            c.this.V();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            c.this.D(this.f3184a.f3192a, true);
        }
    }

    public class h extends AnimatorListenerAdapter {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ i f3188a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ViewPropertyAnimator f3189b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ View f3190c;

        public h(i iVar, ViewPropertyAnimator viewPropertyAnimator, View view) {
            this.f3188a = iVar;
            this.f3189b = viewPropertyAnimator;
            this.f3190c = view;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f3189b.setListener(null);
            this.f3190c.setAlpha(1.0f);
            this.f3190c.setTranslationX(0.0f);
            this.f3190c.setTranslationY(0.0f);
            c.this.C(this.f3188a.f3193b, false);
            c.this.f3163r.remove(this.f3188a.f3193b);
            c.this.V();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            c.this.D(this.f3188a.f3193b, false);
        }
    }

    public static class j {

        /* renamed from: a, reason: collision with root package name */
        public RecyclerView.d0 f3198a;

        /* renamed from: b, reason: collision with root package name */
        public int f3199b;

        /* renamed from: c, reason: collision with root package name */
        public int f3200c;

        /* renamed from: d, reason: collision with root package name */
        public int f3201d;

        /* renamed from: e, reason: collision with root package name */
        public int f3202e;

        public j(RecyclerView.d0 d0Var, int i10, int i11, int i12, int i13) {
            this.f3198a = d0Var;
            this.f3199b = i10;
            this.f3200c = i11;
            this.f3201d = i12;
            this.f3202e = i13;
        }
    }

    public void Q(RecyclerView.d0 d0Var) {
        View view = d0Var.itemView;
        ViewPropertyAnimator animate = view.animate();
        this.f3160o.add(d0Var);
        animate.alpha(1.0f).setDuration(l()).setListener(new e(d0Var, view, animate)).start();
    }

    public void R(i iVar) {
        RecyclerView.d0 d0Var = iVar.f3192a;
        View view = d0Var == null ? null : d0Var.itemView;
        RecyclerView.d0 d0Var2 = iVar.f3193b;
        View view2 = d0Var2 != null ? d0Var2.itemView : null;
        if (view != null) {
            ViewPropertyAnimator duration = view.animate().setDuration(m());
            this.f3163r.add(iVar.f3192a);
            duration.translationX(iVar.f3196e - iVar.f3194c);
            duration.translationY(iVar.f3197f - iVar.f3195d);
            duration.alpha(0.0f).setListener(new g(iVar, duration, view)).start();
        }
        if (view2 != null) {
            ViewPropertyAnimator animate = view2.animate();
            this.f3163r.add(iVar.f3193b);
            animate.translationX(0.0f).translationY(0.0f).setDuration(m()).alpha(1.0f).setListener(new h(iVar, animate, view2)).start();
        }
    }

    public void S(RecyclerView.d0 d0Var, int i10, int i11, int i12, int i13) {
        View view = d0Var.itemView;
        int i14 = i12 - i10;
        int i15 = i13 - i11;
        if (i14 != 0) {
            view.animate().translationX(0.0f);
        }
        if (i15 != 0) {
            view.animate().translationY(0.0f);
        }
        ViewPropertyAnimator animate = view.animate();
        this.f3161p.add(d0Var);
        animate.setDuration(n()).setListener(new f(d0Var, i14, view, i15, animate)).start();
    }

    public final void T(RecyclerView.d0 d0Var) {
        View view = d0Var.itemView;
        ViewPropertyAnimator animate = view.animate();
        this.f3162q.add(d0Var);
        animate.setDuration(o()).alpha(0.0f).setListener(new d(d0Var, animate, view)).start();
    }

    public void U(List list) {
        for (int size = list.size() - 1; size >= 0; size--) {
            ((RecyclerView.d0) list.get(size)).itemView.animate().cancel();
        }
    }

    public void V() {
        if (p()) {
            return;
        }
        i();
    }

    public final void W(List list, RecyclerView.d0 d0Var) {
        for (int size = list.size() - 1; size >= 0; size--) {
            i iVar = (i) list.get(size);
            if (Y(iVar, d0Var) && iVar.f3192a == null && iVar.f3193b == null) {
                list.remove(iVar);
            }
        }
    }

    public final void X(i iVar) {
        RecyclerView.d0 d0Var = iVar.f3192a;
        if (d0Var != null) {
            Y(iVar, d0Var);
        }
        RecyclerView.d0 d0Var2 = iVar.f3193b;
        if (d0Var2 != null) {
            Y(iVar, d0Var2);
        }
    }

    public final boolean Y(i iVar, RecyclerView.d0 d0Var) {
        boolean z10 = false;
        if (iVar.f3193b == d0Var) {
            iVar.f3193b = null;
        } else {
            if (iVar.f3192a != d0Var) {
                return false;
            }
            iVar.f3192a = null;
            z10 = true;
        }
        d0Var.itemView.setAlpha(1.0f);
        d0Var.itemView.setTranslationX(0.0f);
        d0Var.itemView.setTranslationY(0.0f);
        C(d0Var, z10);
        return true;
    }

    public final void Z(RecyclerView.d0 d0Var) {
        if (f3152s == null) {
            f3152s = new ValueAnimator().getInterpolator();
        }
        d0Var.itemView.animate().setInterpolator(f3152s);
        j(d0Var);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public boolean g(RecyclerView.d0 d0Var, List list) {
        return !list.isEmpty() || super.g(d0Var, list);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public void j(RecyclerView.d0 d0Var) {
        View view = d0Var.itemView;
        view.animate().cancel();
        int size = this.f3155j.size();
        while (true) {
            size--;
            if (size < 0) {
                break;
            }
            if (((j) this.f3155j.get(size)).f3198a == d0Var) {
                view.setTranslationY(0.0f);
                view.setTranslationX(0.0f);
                E(d0Var);
                this.f3155j.remove(size);
            }
        }
        W(this.f3156k, d0Var);
        if (this.f3153h.remove(d0Var)) {
            view.setAlpha(1.0f);
            G(d0Var);
        }
        if (this.f3154i.remove(d0Var)) {
            view.setAlpha(1.0f);
            A(d0Var);
        }
        for (int size2 = this.f3159n.size() - 1; size2 >= 0; size2--) {
            ArrayList arrayList = (ArrayList) this.f3159n.get(size2);
            W(arrayList, d0Var);
            if (arrayList.isEmpty()) {
                this.f3159n.remove(size2);
            }
        }
        for (int size3 = this.f3158m.size() - 1; size3 >= 0; size3--) {
            ArrayList arrayList2 = (ArrayList) this.f3158m.get(size3);
            int size4 = arrayList2.size() - 1;
            while (true) {
                if (size4 < 0) {
                    break;
                }
                if (((j) arrayList2.get(size4)).f3198a == d0Var) {
                    view.setTranslationY(0.0f);
                    view.setTranslationX(0.0f);
                    E(d0Var);
                    arrayList2.remove(size4);
                    if (arrayList2.isEmpty()) {
                        this.f3158m.remove(size3);
                    }
                } else {
                    size4--;
                }
            }
        }
        for (int size5 = this.f3157l.size() - 1; size5 >= 0; size5--) {
            ArrayList arrayList3 = (ArrayList) this.f3157l.get(size5);
            if (arrayList3.remove(d0Var)) {
                view.setAlpha(1.0f);
                A(d0Var);
                if (arrayList3.isEmpty()) {
                    this.f3157l.remove(size5);
                }
            }
        }
        this.f3162q.remove(d0Var);
        this.f3160o.remove(d0Var);
        this.f3163r.remove(d0Var);
        this.f3161p.remove(d0Var);
        V();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public void k() {
        int size = this.f3155j.size();
        while (true) {
            size--;
            if (size < 0) {
                break;
            }
            j jVar = (j) this.f3155j.get(size);
            View view = jVar.f3198a.itemView;
            view.setTranslationY(0.0f);
            view.setTranslationX(0.0f);
            E(jVar.f3198a);
            this.f3155j.remove(size);
        }
        for (int size2 = this.f3153h.size() - 1; size2 >= 0; size2--) {
            G((RecyclerView.d0) this.f3153h.get(size2));
            this.f3153h.remove(size2);
        }
        int size3 = this.f3154i.size();
        while (true) {
            size3--;
            if (size3 < 0) {
                break;
            }
            RecyclerView.d0 d0Var = (RecyclerView.d0) this.f3154i.get(size3);
            d0Var.itemView.setAlpha(1.0f);
            A(d0Var);
            this.f3154i.remove(size3);
        }
        for (int size4 = this.f3156k.size() - 1; size4 >= 0; size4--) {
            X((i) this.f3156k.get(size4));
        }
        this.f3156k.clear();
        if (p()) {
            for (int size5 = this.f3158m.size() - 1; size5 >= 0; size5--) {
                ArrayList arrayList = (ArrayList) this.f3158m.get(size5);
                for (int size6 = arrayList.size() - 1; size6 >= 0; size6--) {
                    j jVar2 = (j) arrayList.get(size6);
                    View view2 = jVar2.f3198a.itemView;
                    view2.setTranslationY(0.0f);
                    view2.setTranslationX(0.0f);
                    E(jVar2.f3198a);
                    arrayList.remove(size6);
                    if (arrayList.isEmpty()) {
                        this.f3158m.remove(arrayList);
                    }
                }
            }
            for (int size7 = this.f3157l.size() - 1; size7 >= 0; size7--) {
                ArrayList arrayList2 = (ArrayList) this.f3157l.get(size7);
                for (int size8 = arrayList2.size() - 1; size8 >= 0; size8--) {
                    RecyclerView.d0 d0Var2 = (RecyclerView.d0) arrayList2.get(size8);
                    d0Var2.itemView.setAlpha(1.0f);
                    A(d0Var2);
                    arrayList2.remove(size8);
                    if (arrayList2.isEmpty()) {
                        this.f3157l.remove(arrayList2);
                    }
                }
            }
            for (int size9 = this.f3159n.size() - 1; size9 >= 0; size9--) {
                ArrayList arrayList3 = (ArrayList) this.f3159n.get(size9);
                for (int size10 = arrayList3.size() - 1; size10 >= 0; size10--) {
                    X((i) arrayList3.get(size10));
                    if (arrayList3.isEmpty()) {
                        this.f3159n.remove(arrayList3);
                    }
                }
            }
            U(this.f3162q);
            U(this.f3161p);
            U(this.f3160o);
            U(this.f3163r);
            i();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public boolean p() {
        return (this.f3154i.isEmpty() && this.f3156k.isEmpty() && this.f3155j.isEmpty() && this.f3153h.isEmpty() && this.f3161p.isEmpty() && this.f3162q.isEmpty() && this.f3160o.isEmpty() && this.f3163r.isEmpty() && this.f3158m.isEmpty() && this.f3157l.isEmpty() && this.f3159n.isEmpty()) ? false : true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public void u() {
        boolean z10 = !this.f3153h.isEmpty();
        boolean z11 = !this.f3155j.isEmpty();
        boolean z12 = !this.f3156k.isEmpty();
        boolean z13 = !this.f3154i.isEmpty();
        if (z10 || z11 || z13 || z12) {
            Iterator it = this.f3153h.iterator();
            while (it.hasNext()) {
                T((RecyclerView.d0) it.next());
            }
            this.f3153h.clear();
            if (z11) {
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(this.f3155j);
                this.f3158m.add(arrayList);
                this.f3155j.clear();
                a aVar = new a(arrayList);
                if (z10) {
                    c1.d0(((j) arrayList.get(0)).f3198a.itemView, aVar, o());
                } else {
                    aVar.run();
                }
            }
            if (z12) {
                ArrayList arrayList2 = new ArrayList();
                arrayList2.addAll(this.f3156k);
                this.f3159n.add(arrayList2);
                this.f3156k.clear();
                b bVar = new b(arrayList2);
                if (z10) {
                    c1.d0(((i) arrayList2.get(0)).f3192a.itemView, bVar, o());
                } else {
                    bVar.run();
                }
            }
            if (z13) {
                ArrayList arrayList3 = new ArrayList();
                arrayList3.addAll(this.f3154i);
                this.f3157l.add(arrayList3);
                this.f3154i.clear();
                RunnableC0045c runnableC0045c = new RunnableC0045c(arrayList3);
                if (z10 || z11 || z12) {
                    c1.d0(((RecyclerView.d0) arrayList3.get(0)).itemView, runnableC0045c, (z10 ? o() : 0L) + Math.max(z11 ? n() : 0L, z12 ? m() : 0L));
                } else {
                    runnableC0045c.run();
                }
            }
        }
    }

    @Override // androidx.recyclerview.widget.q
    public boolean w(RecyclerView.d0 d0Var) {
        Z(d0Var);
        d0Var.itemView.setAlpha(0.0f);
        this.f3154i.add(d0Var);
        return true;
    }

    @Override // androidx.recyclerview.widget.q
    public boolean x(RecyclerView.d0 d0Var, RecyclerView.d0 d0Var2, int i10, int i11, int i12, int i13) {
        if (d0Var == d0Var2) {
            return y(d0Var, i10, i11, i12, i13);
        }
        float translationX = d0Var.itemView.getTranslationX();
        float translationY = d0Var.itemView.getTranslationY();
        float alpha = d0Var.itemView.getAlpha();
        Z(d0Var);
        int i14 = (int) ((i12 - i10) - translationX);
        int i15 = (int) ((i13 - i11) - translationY);
        d0Var.itemView.setTranslationX(translationX);
        d0Var.itemView.setTranslationY(translationY);
        d0Var.itemView.setAlpha(alpha);
        if (d0Var2 != null) {
            Z(d0Var2);
            d0Var2.itemView.setTranslationX(-i14);
            d0Var2.itemView.setTranslationY(-i15);
            d0Var2.itemView.setAlpha(0.0f);
        }
        this.f3156k.add(new i(d0Var, d0Var2, i10, i11, i12, i13));
        return true;
    }

    @Override // androidx.recyclerview.widget.q
    public boolean y(RecyclerView.d0 d0Var, int i10, int i11, int i12, int i13) {
        View view = d0Var.itemView;
        int translationX = i10 + ((int) view.getTranslationX());
        int translationY = i11 + ((int) d0Var.itemView.getTranslationY());
        Z(d0Var);
        int i14 = i12 - translationX;
        int i15 = i13 - translationY;
        if (i14 == 0 && i15 == 0) {
            E(d0Var);
            return false;
        }
        if (i14 != 0) {
            view.setTranslationX(-i14);
        }
        if (i15 != 0) {
            view.setTranslationY(-i15);
        }
        this.f3155j.add(new j(d0Var, translationX, translationY, i12, i13));
        return true;
    }

    @Override // androidx.recyclerview.widget.q
    public boolean z(RecyclerView.d0 d0Var) {
        Z(d0Var);
        this.f3153h.add(d0Var);
        return true;
    }

    public static class i {

        /* renamed from: a, reason: collision with root package name */
        public RecyclerView.d0 f3192a;

        /* renamed from: b, reason: collision with root package name */
        public RecyclerView.d0 f3193b;

        /* renamed from: c, reason: collision with root package name */
        public int f3194c;

        /* renamed from: d, reason: collision with root package name */
        public int f3195d;

        /* renamed from: e, reason: collision with root package name */
        public int f3196e;

        /* renamed from: f, reason: collision with root package name */
        public int f3197f;

        public i(RecyclerView.d0 d0Var, RecyclerView.d0 d0Var2) {
            this.f3192a = d0Var;
            this.f3193b = d0Var2;
        }

        public String toString() {
            return "ChangeInfo{oldHolder=" + this.f3192a + ", newHolder=" + this.f3193b + ", fromX=" + this.f3194c + ", fromY=" + this.f3195d + ", toX=" + this.f3196e + ", toY=" + this.f3197f + ASCIIPropertyListParser.DICTIONARY_END_TOKEN;
        }

        public i(RecyclerView.d0 d0Var, RecyclerView.d0 d0Var2, int i10, int i11, int i12, int i13) {
            this(d0Var, d0Var2);
            this.f3194c = i10;
            this.f3195d = i11;
            this.f3196e = i12;
            this.f3197f = i13;
        }
    }
}
