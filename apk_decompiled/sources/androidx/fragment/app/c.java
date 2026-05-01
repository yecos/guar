package androidx.fragment.app;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import androidx.fragment.app.f;
import androidx.fragment.app.j0;
import b0.c1;
import b0.r1;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import x.b;

/* loaded from: classes.dex */
public class c extends j0 {

    public static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f2190a;

        static {
            int[] iArr = new int[j0.e.c.values().length];
            f2190a = iArr;
            try {
                iArr[j0.e.c.GONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f2190a[j0.e.c.INVISIBLE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f2190a[j0.e.c.REMOVED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f2190a[j0.e.c.VISIBLE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ List f2191a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ j0.e f2192b;

        public b(List list, j0.e eVar) {
            this.f2191a = list;
            this.f2192b = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f2191a.contains(this.f2192b)) {
                this.f2191a.remove(this.f2192b);
                c.this.s(this.f2192b);
            }
        }
    }

    /* renamed from: androidx.fragment.app.c$c, reason: collision with other inner class name */
    public class C0031c extends AnimatorListenerAdapter {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ViewGroup f2194a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ View f2195b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ boolean f2196c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ j0.e f2197d;

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ k f2198e;

        public C0031c(ViewGroup viewGroup, View view, boolean z10, j0.e eVar, k kVar) {
            this.f2194a = viewGroup;
            this.f2195b = view;
            this.f2196c = z10;
            this.f2197d = eVar;
            this.f2198e = kVar;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f2194a.endViewTransition(this.f2195b);
            if (this.f2196c) {
                this.f2197d.e().a(this.f2195b);
            }
            this.f2198e.a();
        }
    }

    public class d implements b.a {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Animator f2200a;

        public d(Animator animator) {
            this.f2200a = animator;
        }

        @Override // x.b.a
        public void a() {
            this.f2200a.end();
        }
    }

    public class e implements Animation.AnimationListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ViewGroup f2202a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ View f2203b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ k f2204c;

        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                e eVar = e.this;
                eVar.f2202a.endViewTransition(eVar.f2203b);
                e.this.f2204c.a();
            }
        }

        public e(ViewGroup viewGroup, View view, k kVar) {
            this.f2202a = viewGroup;
            this.f2203b = view;
            this.f2204c = kVar;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            this.f2202a.post(new a());
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    public class f implements b.a {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f2207a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ViewGroup f2208b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ k f2209c;

        public f(View view, ViewGroup viewGroup, k kVar) {
            this.f2207a = view;
            this.f2208b = viewGroup;
            this.f2209c = kVar;
        }

        @Override // x.b.a
        public void a() {
            this.f2207a.clearAnimation();
            this.f2208b.endViewTransition(this.f2207a);
            this.f2209c.a();
        }
    }

    public class g implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ j0.e f2211a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ j0.e f2212b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ boolean f2213c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ androidx.collection.a f2214d;

        public g(j0.e eVar, j0.e eVar2, boolean z10, androidx.collection.a aVar) {
            this.f2211a = eVar;
            this.f2212b = eVar2;
            this.f2213c = z10;
            this.f2214d = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            z.f(this.f2211a.f(), this.f2212b.f(), this.f2213c, this.f2214d, false);
        }
    }

    public class h implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ g0 f2216a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ View f2217b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Rect f2218c;

        public h(g0 g0Var, View view, Rect rect) {
            this.f2216a = g0Var;
            this.f2217b = view;
            this.f2218c = rect;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f2216a.k(this.f2217b, this.f2218c);
        }
    }

    public class i implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ArrayList f2220a;

        public i(ArrayList arrayList) {
            this.f2220a = arrayList;
        }

        @Override // java.lang.Runnable
        public void run() {
            z.A(this.f2220a, 4);
        }
    }

    public class j implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ m f2222a;

        public j(m mVar) {
            this.f2222a = mVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f2222a.a();
        }
    }

    public static class k extends l {

        /* renamed from: c, reason: collision with root package name */
        public boolean f2224c;

        /* renamed from: d, reason: collision with root package name */
        public boolean f2225d;

        /* renamed from: e, reason: collision with root package name */
        public f.d f2226e;

        public k(j0.e eVar, x.b bVar, boolean z10) {
            super(eVar, bVar);
            this.f2225d = false;
            this.f2224c = z10;
        }

        public f.d e(Context context) {
            if (this.f2225d) {
                return this.f2226e;
            }
            f.d c10 = androidx.fragment.app.f.c(context, b().f(), b().e() == j0.e.c.VISIBLE, this.f2224c);
            this.f2226e = c10;
            this.f2225d = true;
            return c10;
        }
    }

    public static class l {

        /* renamed from: a, reason: collision with root package name */
        public final j0.e f2227a;

        /* renamed from: b, reason: collision with root package name */
        public final x.b f2228b;

        public l(j0.e eVar, x.b bVar) {
            this.f2227a = eVar;
            this.f2228b = bVar;
        }

        public void a() {
            this.f2227a.d(this.f2228b);
        }

        public j0.e b() {
            return this.f2227a;
        }

        public x.b c() {
            return this.f2228b;
        }

        public boolean d() {
            j0.e.c cVar;
            j0.e.c c10 = j0.e.c.c(this.f2227a.f().mView);
            j0.e.c e10 = this.f2227a.e();
            return c10 == e10 || !(c10 == (cVar = j0.e.c.VISIBLE) || e10 == cVar);
        }
    }

    public static class m extends l {

        /* renamed from: c, reason: collision with root package name */
        public final Object f2229c;

        /* renamed from: d, reason: collision with root package name */
        public final boolean f2230d;

        /* renamed from: e, reason: collision with root package name */
        public final Object f2231e;

        public m(j0.e eVar, x.b bVar, boolean z10, boolean z11) {
            super(eVar, bVar);
            if (eVar.e() == j0.e.c.VISIBLE) {
                this.f2229c = z10 ? eVar.f().getReenterTransition() : eVar.f().getEnterTransition();
                this.f2230d = z10 ? eVar.f().getAllowReturnTransitionOverlap() : eVar.f().getAllowEnterTransitionOverlap();
            } else {
                this.f2229c = z10 ? eVar.f().getReturnTransition() : eVar.f().getExitTransition();
                this.f2230d = true;
            }
            if (!z11) {
                this.f2231e = null;
            } else if (z10) {
                this.f2231e = eVar.f().getSharedElementReturnTransition();
            } else {
                this.f2231e = eVar.f().getSharedElementEnterTransition();
            }
        }

        public g0 e() {
            g0 f10 = f(this.f2229c);
            g0 f11 = f(this.f2231e);
            if (f10 == null || f11 == null || f10 == f11) {
                return f10 != null ? f10 : f11;
            }
            throw new IllegalArgumentException("Mixing framework transitions and AndroidX transitions is not allowed. Fragment " + b().f() + " returned Transition " + this.f2229c + " which uses a different Transition  type than its shared element transition " + this.f2231e);
        }

        public final g0 f(Object obj) {
            if (obj == null) {
                return null;
            }
            g0 g0Var = z.f2462b;
            if (g0Var != null && g0Var.e(obj)) {
                return g0Var;
            }
            g0 g0Var2 = z.f2463c;
            if (g0Var2 != null && g0Var2.e(obj)) {
                return g0Var2;
            }
            throw new IllegalArgumentException("Transition " + obj + " for fragment " + b().f() + " is not a valid framework Transition or AndroidX Transition");
        }

        public Object g() {
            return this.f2231e;
        }

        public Object h() {
            return this.f2229c;
        }

        public boolean i() {
            return this.f2231e != null;
        }

        public boolean j() {
            return this.f2230d;
        }
    }

    public c(ViewGroup viewGroup) {
        super(viewGroup);
    }

    @Override // androidx.fragment.app.j0
    public void f(List list, boolean z10) {
        Iterator it = list.iterator();
        j0.e eVar = null;
        j0.e eVar2 = null;
        while (it.hasNext()) {
            j0.e eVar3 = (j0.e) it.next();
            j0.e.c c10 = j0.e.c.c(eVar3.f().mView);
            int i10 = a.f2190a[eVar3.e().ordinal()];
            if (i10 == 1 || i10 == 2 || i10 == 3) {
                if (c10 == j0.e.c.VISIBLE && eVar == null) {
                    eVar = eVar3;
                }
            } else if (i10 == 4 && c10 != j0.e.c.VISIBLE) {
                eVar2 = eVar3;
            }
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList(list);
        Iterator it2 = list.iterator();
        while (it2.hasNext()) {
            j0.e eVar4 = (j0.e) it2.next();
            x.b bVar = new x.b();
            eVar4.j(bVar);
            arrayList.add(new k(eVar4, bVar, z10));
            x.b bVar2 = new x.b();
            eVar4.j(bVar2);
            boolean z11 = false;
            if (z10) {
                if (eVar4 != eVar) {
                    arrayList2.add(new m(eVar4, bVar2, z10, z11));
                    eVar4.a(new b(arrayList3, eVar4));
                }
                z11 = true;
                arrayList2.add(new m(eVar4, bVar2, z10, z11));
                eVar4.a(new b(arrayList3, eVar4));
            } else {
                if (eVar4 != eVar2) {
                    arrayList2.add(new m(eVar4, bVar2, z10, z11));
                    eVar4.a(new b(arrayList3, eVar4));
                }
                z11 = true;
                arrayList2.add(new m(eVar4, bVar2, z10, z11));
                eVar4.a(new b(arrayList3, eVar4));
            }
        }
        Map x10 = x(arrayList2, arrayList3, z10, eVar, eVar2);
        w(arrayList, arrayList3, x10.containsValue(Boolean.TRUE), x10);
        Iterator it3 = arrayList3.iterator();
        while (it3.hasNext()) {
            s((j0.e) it3.next());
        }
        arrayList3.clear();
    }

    public void s(j0.e eVar) {
        eVar.e().a(eVar.f().mView);
    }

    public void t(ArrayList arrayList, View view) {
        if (!(view instanceof ViewGroup)) {
            if (arrayList.contains(view)) {
                return;
            }
            arrayList.add(view);
            return;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        if (r1.a(viewGroup)) {
            if (arrayList.contains(view)) {
                return;
            }
            arrayList.add(viewGroup);
            return;
        }
        int childCount = viewGroup.getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = viewGroup.getChildAt(i10);
            if (childAt.getVisibility() == 0) {
                t(arrayList, childAt);
            }
        }
    }

    public void u(Map map, View view) {
        String I = c1.I(view);
        if (I != null) {
            map.put(I, view);
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i10 = 0; i10 < childCount; i10++) {
                View childAt = viewGroup.getChildAt(i10);
                if (childAt.getVisibility() == 0) {
                    u(map, childAt);
                }
            }
        }
    }

    public void v(androidx.collection.a aVar, Collection collection) {
        Iterator<Map.Entry<Object, Object>> it = aVar.entrySet().iterator();
        while (it.hasNext()) {
            if (!collection.contains(c1.I((View) it.next().getValue()))) {
                it.remove();
            }
        }
    }

    public final void w(List list, List list2, boolean z10, Map map) {
        ViewGroup m10 = m();
        Context context = m10.getContext();
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        boolean z11 = false;
        while (it.hasNext()) {
            k kVar = (k) it.next();
            if (kVar.d()) {
                kVar.a();
            } else {
                f.d e10 = kVar.e(context);
                if (e10 == null) {
                    kVar.a();
                } else {
                    Animator animator = e10.f2253b;
                    if (animator == null) {
                        arrayList.add(kVar);
                    } else {
                        j0.e b10 = kVar.b();
                        Fragment f10 = b10.f();
                        if (Boolean.TRUE.equals(map.get(b10))) {
                            if (o.F0(2)) {
                                StringBuilder sb = new StringBuilder();
                                sb.append("Ignoring Animator set on ");
                                sb.append(f10);
                                sb.append(" as this Fragment was involved in a Transition.");
                            }
                            kVar.a();
                        } else {
                            boolean z12 = b10.e() == j0.e.c.GONE;
                            if (z12) {
                                list2.remove(b10);
                            }
                            View view = f10.mView;
                            m10.startViewTransition(view);
                            animator.addListener(new C0031c(m10, view, z12, b10, kVar));
                            animator.setTarget(view);
                            animator.start();
                            kVar.c().c(new d(animator));
                            z11 = true;
                        }
                    }
                }
            }
        }
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            k kVar2 = (k) it2.next();
            j0.e b11 = kVar2.b();
            Fragment f11 = b11.f();
            if (z10) {
                if (o.F0(2)) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("Ignoring Animation set on ");
                    sb2.append(f11);
                    sb2.append(" as Animations cannot run alongside Transitions.");
                }
                kVar2.a();
            } else if (z11) {
                if (o.F0(2)) {
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("Ignoring Animation set on ");
                    sb3.append(f11);
                    sb3.append(" as Animations cannot run alongside Animators.");
                }
                kVar2.a();
            } else {
                View view2 = f11.mView;
                Animation animation = (Animation) a0.h.d(((f.d) a0.h.d(kVar2.e(context))).f2252a);
                if (b11.e() != j0.e.c.REMOVED) {
                    view2.startAnimation(animation);
                    kVar2.a();
                } else {
                    m10.startViewTransition(view2);
                    f.e eVar = new f.e(animation, m10, view2);
                    eVar.setAnimationListener(new e(m10, view2, kVar2));
                    view2.startAnimation(eVar);
                }
                kVar2.c().c(new f(view2, m10, kVar2));
            }
        }
    }

    public final Map x(List list, List list2, boolean z10, j0.e eVar, j0.e eVar2) {
        View view;
        Object obj;
        ArrayList arrayList;
        Object obj2;
        ArrayList arrayList2;
        j0.e eVar3;
        j0.e eVar4;
        View view2;
        Object n10;
        androidx.collection.a aVar;
        ArrayList arrayList3;
        j0.e eVar5;
        ArrayList arrayList4;
        Rect rect;
        View view3;
        g0 g0Var;
        j0.e eVar6;
        View view4;
        boolean z11 = z10;
        j0.e eVar7 = eVar;
        j0.e eVar8 = eVar2;
        HashMap hashMap = new HashMap();
        Iterator it = list.iterator();
        g0 g0Var2 = null;
        while (it.hasNext()) {
            m mVar = (m) it.next();
            if (!mVar.d()) {
                g0 e10 = mVar.e();
                if (g0Var2 == null) {
                    g0Var2 = e10;
                } else if (e10 != null && g0Var2 != e10) {
                    throw new IllegalArgumentException("Mixing framework transitions and AndroidX transitions is not allowed. Fragment " + mVar.b().f() + " returned Transition " + mVar.h() + " which uses a different Transition  type than other Fragments.");
                }
            }
        }
        if (g0Var2 == null) {
            Iterator it2 = list.iterator();
            while (it2.hasNext()) {
                m mVar2 = (m) it2.next();
                hashMap.put(mVar2.b(), Boolean.FALSE);
                mVar2.a();
            }
            return hashMap;
        }
        View view5 = new View(m().getContext());
        Rect rect2 = new Rect();
        ArrayList arrayList5 = new ArrayList();
        ArrayList arrayList6 = new ArrayList();
        androidx.collection.a aVar2 = new androidx.collection.a();
        Iterator it3 = list.iterator();
        Object obj3 = null;
        View view6 = null;
        boolean z12 = false;
        while (it3.hasNext()) {
            m mVar3 = (m) it3.next();
            if (!mVar3.i() || eVar7 == null || eVar8 == null) {
                aVar = aVar2;
                arrayList3 = arrayList6;
                eVar5 = eVar7;
                arrayList4 = arrayList5;
                rect = rect2;
                view3 = view5;
                g0Var = g0Var2;
                eVar6 = eVar8;
                view6 = view6;
            } else {
                Object B = g0Var2.B(g0Var2.g(mVar3.g()));
                ArrayList<String> sharedElementSourceNames = eVar2.f().getSharedElementSourceNames();
                ArrayList<String> sharedElementSourceNames2 = eVar.f().getSharedElementSourceNames();
                ArrayList<String> sharedElementTargetNames = eVar.f().getSharedElementTargetNames();
                View view7 = view6;
                int i10 = 0;
                while (i10 < sharedElementTargetNames.size()) {
                    int indexOf = sharedElementSourceNames.indexOf(sharedElementTargetNames.get(i10));
                    ArrayList<String> arrayList7 = sharedElementTargetNames;
                    if (indexOf != -1) {
                        sharedElementSourceNames.set(indexOf, sharedElementSourceNames2.get(i10));
                    }
                    i10++;
                    sharedElementTargetNames = arrayList7;
                }
                ArrayList<String> sharedElementTargetNames2 = eVar2.f().getSharedElementTargetNames();
                if (z11) {
                    eVar.f().getEnterTransitionCallback();
                    eVar2.f().getExitTransitionCallback();
                } else {
                    eVar.f().getExitTransitionCallback();
                    eVar2.f().getEnterTransitionCallback();
                }
                int i11 = 0;
                for (int size = sharedElementSourceNames.size(); i11 < size; size = size) {
                    aVar2.put(sharedElementSourceNames.get(i11), sharedElementTargetNames2.get(i11));
                    i11++;
                }
                androidx.collection.a aVar3 = new androidx.collection.a();
                u(aVar3, eVar.f().mView);
                aVar3.retainAll(sharedElementSourceNames);
                aVar2.retainAll(aVar3.keySet());
                androidx.collection.a aVar4 = new androidx.collection.a();
                u(aVar4, eVar2.f().mView);
                aVar4.retainAll(sharedElementTargetNames2);
                aVar4.retainAll(aVar2.values());
                z.x(aVar2, aVar4);
                v(aVar3, aVar2.keySet());
                v(aVar4, aVar2.values());
                if (aVar2.isEmpty()) {
                    arrayList5.clear();
                    arrayList6.clear();
                    aVar = aVar2;
                    arrayList3 = arrayList6;
                    eVar5 = eVar7;
                    arrayList4 = arrayList5;
                    rect = rect2;
                    view3 = view5;
                    g0Var = g0Var2;
                    view6 = view7;
                    obj3 = null;
                    eVar6 = eVar8;
                } else {
                    z.f(eVar2.f(), eVar.f(), z11, aVar3, true);
                    aVar = aVar2;
                    ArrayList arrayList8 = arrayList6;
                    b0.d0.a(m(), new g(eVar2, eVar, z10, aVar4));
                    arrayList5.addAll(aVar3.values());
                    if (sharedElementSourceNames.isEmpty()) {
                        view6 = view7;
                    } else {
                        View view8 = (View) aVar3.get((String) sharedElementSourceNames.get(0));
                        g0Var2.v(B, view8);
                        view6 = view8;
                    }
                    arrayList3 = arrayList8;
                    arrayList3.addAll(aVar4.values());
                    if (!sharedElementTargetNames2.isEmpty() && (view4 = (View) aVar4.get((String) sharedElementTargetNames2.get(0))) != null) {
                        b0.d0.a(m(), new h(g0Var2, view4, rect2));
                        z12 = true;
                    }
                    g0Var2.z(B, view5, arrayList5);
                    arrayList4 = arrayList5;
                    rect = rect2;
                    view3 = view5;
                    g0Var = g0Var2;
                    g0Var2.t(B, null, null, null, null, B, arrayList3);
                    Boolean bool = Boolean.TRUE;
                    eVar5 = eVar;
                    hashMap.put(eVar5, bool);
                    eVar6 = eVar2;
                    hashMap.put(eVar6, bool);
                    obj3 = B;
                }
            }
            eVar7 = eVar5;
            arrayList5 = arrayList4;
            rect2 = rect;
            view5 = view3;
            eVar8 = eVar6;
            aVar2 = aVar;
            z11 = z10;
            arrayList6 = arrayList3;
            g0Var2 = g0Var;
        }
        View view9 = view6;
        androidx.collection.a aVar5 = aVar2;
        ArrayList arrayList9 = arrayList6;
        j0.e eVar9 = eVar7;
        ArrayList arrayList10 = arrayList5;
        Rect rect3 = rect2;
        View view10 = view5;
        g0 g0Var3 = g0Var2;
        j0.e eVar10 = eVar8;
        ArrayList arrayList11 = new ArrayList();
        Iterator it4 = list.iterator();
        Object obj4 = null;
        Object obj5 = null;
        while (it4.hasNext()) {
            m mVar4 = (m) it4.next();
            if (mVar4.d()) {
                hashMap.put(mVar4.b(), Boolean.FALSE);
                mVar4.a();
            } else {
                Object g10 = g0Var3.g(mVar4.h());
                j0.e b10 = mVar4.b();
                boolean z13 = obj3 != null && (b10 == eVar9 || b10 == eVar10);
                if (g10 == null) {
                    if (!z13) {
                        hashMap.put(b10, Boolean.FALSE);
                        mVar4.a();
                    }
                    arrayList2 = arrayList9;
                    arrayList = arrayList10;
                    view = view10;
                    n10 = obj4;
                    eVar3 = eVar10;
                    view2 = view9;
                } else {
                    ArrayList arrayList12 = new ArrayList();
                    Object obj6 = obj4;
                    t(arrayList12, b10.f().mView);
                    if (z13) {
                        if (b10 == eVar9) {
                            arrayList12.removeAll(arrayList10);
                        } else {
                            arrayList12.removeAll(arrayList9);
                        }
                    }
                    if (arrayList12.isEmpty()) {
                        g0Var3.a(g10, view10);
                        arrayList2 = arrayList9;
                        arrayList = arrayList10;
                        view = view10;
                        eVar4 = b10;
                        obj2 = obj5;
                        eVar3 = eVar10;
                        obj = obj6;
                    } else {
                        g0Var3.b(g10, arrayList12);
                        view = view10;
                        obj = obj6;
                        arrayList = arrayList10;
                        obj2 = obj5;
                        arrayList2 = arrayList9;
                        eVar3 = eVar10;
                        g0Var3.t(g10, g10, arrayList12, null, null, null, null);
                        if (b10.e() == j0.e.c.GONE) {
                            eVar4 = b10;
                            list2.remove(eVar4);
                            ArrayList arrayList13 = new ArrayList(arrayList12);
                            arrayList13.remove(eVar4.f().mView);
                            g0Var3.r(g10, eVar4.f().mView, arrayList13);
                            b0.d0.a(m(), new i(arrayList12));
                        } else {
                            eVar4 = b10;
                        }
                    }
                    if (eVar4.e() == j0.e.c.VISIBLE) {
                        arrayList11.addAll(arrayList12);
                        if (z12) {
                            g0Var3.u(g10, rect3);
                        }
                        view2 = view9;
                    } else {
                        view2 = view9;
                        g0Var3.v(g10, view2);
                    }
                    hashMap.put(eVar4, Boolean.TRUE);
                    if (mVar4.j()) {
                        obj5 = g0Var3.n(obj2, g10, null);
                        n10 = obj;
                    } else {
                        n10 = g0Var3.n(obj, g10, null);
                        obj5 = obj2;
                    }
                }
                eVar10 = eVar3;
                obj4 = n10;
                view9 = view2;
                view10 = view;
                arrayList10 = arrayList;
                arrayList9 = arrayList2;
            }
        }
        ArrayList arrayList14 = arrayList9;
        ArrayList arrayList15 = arrayList10;
        j0.e eVar11 = eVar10;
        Object m10 = g0Var3.m(obj5, obj4, obj3);
        Iterator it5 = list.iterator();
        while (it5.hasNext()) {
            m mVar5 = (m) it5.next();
            if (!mVar5.d()) {
                Object h10 = mVar5.h();
                j0.e b11 = mVar5.b();
                boolean z14 = obj3 != null && (b11 == eVar9 || b11 == eVar11);
                if (h10 != null || z14) {
                    if (c1.Q(m())) {
                        g0Var3.w(mVar5.b().f(), m10, mVar5.c(), new j(mVar5));
                    } else {
                        if (o.F0(2)) {
                            StringBuilder sb = new StringBuilder();
                            sb.append("SpecialEffectsController: Container ");
                            sb.append(m());
                            sb.append(" has not been laid out. Completing operation ");
                            sb.append(b11);
                        }
                        mVar5.a();
                    }
                }
            }
        }
        if (!c1.Q(m())) {
            return hashMap;
        }
        z.A(arrayList11, 4);
        ArrayList o10 = g0Var3.o(arrayList14);
        g0Var3.c(m(), m10);
        g0Var3.y(m(), arrayList15, arrayList14, o10, aVar5);
        z.A(arrayList11, 0);
        g0Var3.A(obj3, arrayList15, arrayList14);
        return hashMap;
    }
}
