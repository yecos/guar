package androidx.fragment.app;

import android.content.Context;
import android.graphics.Rect;
import android.os.Build;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.y;
import b0.c1;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* loaded from: classes.dex */
public abstract class z {

    /* renamed from: a, reason: collision with root package name */
    public static final int[] f2461a = {0, 3, 0, 1, 5, 4, 7, 6, 9, 8, 10};

    /* renamed from: b, reason: collision with root package name */
    public static final g0 f2462b;

    /* renamed from: c, reason: collision with root package name */
    public static final g0 f2463c;

    public class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ g f2464a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Fragment f2465b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ x.b f2466c;

        public a(g gVar, Fragment fragment, x.b bVar) {
            this.f2464a = gVar;
            this.f2465b = fragment;
            this.f2466c = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f2464a.b(this.f2465b, this.f2466c);
        }
    }

    public class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ArrayList f2467a;

        public b(ArrayList arrayList) {
            this.f2467a = arrayList;
        }

        @Override // java.lang.Runnable
        public void run() {
            z.A(this.f2467a, 4);
        }
    }

    public class c implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ g f2468a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Fragment f2469b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ x.b f2470c;

        public c(g gVar, Fragment fragment, x.b bVar) {
            this.f2468a = gVar;
            this.f2469b = fragment;
            this.f2470c = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f2468a.b(this.f2469b, this.f2470c);
        }
    }

    public class d implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Object f2471a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ g0 f2472b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ View f2473c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ Fragment f2474d;

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ ArrayList f2475e;

        /* renamed from: f, reason: collision with root package name */
        public final /* synthetic */ ArrayList f2476f;

        /* renamed from: g, reason: collision with root package name */
        public final /* synthetic */ ArrayList f2477g;

        /* renamed from: h, reason: collision with root package name */
        public final /* synthetic */ Object f2478h;

        public d(Object obj, g0 g0Var, View view, Fragment fragment, ArrayList arrayList, ArrayList arrayList2, ArrayList arrayList3, Object obj2) {
            this.f2471a = obj;
            this.f2472b = g0Var;
            this.f2473c = view;
            this.f2474d = fragment;
            this.f2475e = arrayList;
            this.f2476f = arrayList2;
            this.f2477g = arrayList3;
            this.f2478h = obj2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Object obj = this.f2471a;
            if (obj != null) {
                this.f2472b.p(obj, this.f2473c);
                this.f2476f.addAll(z.k(this.f2472b, this.f2471a, this.f2474d, this.f2475e, this.f2473c));
            }
            if (this.f2477g != null) {
                if (this.f2478h != null) {
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(this.f2473c);
                    this.f2472b.q(this.f2478h, this.f2477g, arrayList);
                }
                this.f2477g.clear();
                this.f2477g.add(this.f2473c);
            }
        }
    }

    public class e implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Fragment f2479a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Fragment f2480b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ boolean f2481c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ androidx.collection.a f2482d;

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ View f2483e;

        /* renamed from: f, reason: collision with root package name */
        public final /* synthetic */ g0 f2484f;

        /* renamed from: g, reason: collision with root package name */
        public final /* synthetic */ Rect f2485g;

        public e(Fragment fragment, Fragment fragment2, boolean z10, androidx.collection.a aVar, View view, g0 g0Var, Rect rect) {
            this.f2479a = fragment;
            this.f2480b = fragment2;
            this.f2481c = z10;
            this.f2482d = aVar;
            this.f2483e = view;
            this.f2484f = g0Var;
            this.f2485g = rect;
        }

        @Override // java.lang.Runnable
        public void run() {
            z.f(this.f2479a, this.f2480b, this.f2481c, this.f2482d, false);
            View view = this.f2483e;
            if (view != null) {
                this.f2484f.k(view, this.f2485g);
            }
        }
    }

    public class f implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ g0 f2486a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ androidx.collection.a f2487b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Object f2488c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ h f2489d;

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ ArrayList f2490e;

        /* renamed from: f, reason: collision with root package name */
        public final /* synthetic */ View f2491f;

        /* renamed from: g, reason: collision with root package name */
        public final /* synthetic */ Fragment f2492g;

        /* renamed from: h, reason: collision with root package name */
        public final /* synthetic */ Fragment f2493h;

        /* renamed from: i, reason: collision with root package name */
        public final /* synthetic */ boolean f2494i;

        /* renamed from: j, reason: collision with root package name */
        public final /* synthetic */ ArrayList f2495j;

        /* renamed from: k, reason: collision with root package name */
        public final /* synthetic */ Object f2496k;

        /* renamed from: l, reason: collision with root package name */
        public final /* synthetic */ Rect f2497l;

        public f(g0 g0Var, androidx.collection.a aVar, Object obj, h hVar, ArrayList arrayList, View view, Fragment fragment, Fragment fragment2, boolean z10, ArrayList arrayList2, Object obj2, Rect rect) {
            this.f2486a = g0Var;
            this.f2487b = aVar;
            this.f2488c = obj;
            this.f2489d = hVar;
            this.f2490e = arrayList;
            this.f2491f = view;
            this.f2492g = fragment;
            this.f2493h = fragment2;
            this.f2494i = z10;
            this.f2495j = arrayList2;
            this.f2496k = obj2;
            this.f2497l = rect;
        }

        @Override // java.lang.Runnable
        public void run() {
            androidx.collection.a h10 = z.h(this.f2486a, this.f2487b, this.f2488c, this.f2489d);
            if (h10 != null) {
                this.f2490e.addAll(h10.values());
                this.f2490e.add(this.f2491f);
            }
            z.f(this.f2492g, this.f2493h, this.f2494i, h10, false);
            Object obj = this.f2488c;
            if (obj != null) {
                this.f2486a.A(obj, this.f2495j, this.f2490e);
                View s10 = z.s(h10, this.f2489d, this.f2496k, this.f2494i);
                if (s10 != null) {
                    this.f2486a.k(s10, this.f2497l);
                }
            }
        }
    }

    public interface g {
        void a(Fragment fragment, x.b bVar);

        void b(Fragment fragment, x.b bVar);
    }

    public static class h {

        /* renamed from: a, reason: collision with root package name */
        public Fragment f2498a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f2499b;

        /* renamed from: c, reason: collision with root package name */
        public androidx.fragment.app.a f2500c;

        /* renamed from: d, reason: collision with root package name */
        public Fragment f2501d;

        /* renamed from: e, reason: collision with root package name */
        public boolean f2502e;

        /* renamed from: f, reason: collision with root package name */
        public androidx.fragment.app.a f2503f;
    }

    static {
        f2462b = Build.VERSION.SDK_INT >= 21 ? new f0() : null;
        f2463c = w();
    }

    public static void A(ArrayList arrayList, int i10) {
        if (arrayList == null) {
            return;
        }
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            ((View) arrayList.get(size)).setVisibility(i10);
        }
    }

    public static void B(Context context, androidx.fragment.app.g gVar, ArrayList arrayList, ArrayList arrayList2, int i10, int i11, boolean z10, g gVar2) {
        ViewGroup viewGroup;
        SparseArray sparseArray = new SparseArray();
        for (int i12 = i10; i12 < i11; i12++) {
            androidx.fragment.app.a aVar = (androidx.fragment.app.a) arrayList.get(i12);
            if (((Boolean) arrayList2.get(i12)).booleanValue()) {
                e(aVar, sparseArray, z10);
            } else {
                c(aVar, sparseArray, z10);
            }
        }
        if (sparseArray.size() != 0) {
            View view = new View(context);
            int size = sparseArray.size();
            for (int i13 = 0; i13 < size; i13++) {
                int keyAt = sparseArray.keyAt(i13);
                androidx.collection.a d10 = d(keyAt, arrayList, arrayList2, i10, i11);
                h hVar = (h) sparseArray.valueAt(i13);
                if (gVar.d() && (viewGroup = (ViewGroup) gVar.c(keyAt)) != null) {
                    if (z10) {
                        o(viewGroup, hVar, view, d10, gVar2);
                    } else {
                        n(viewGroup, hVar, view, d10, gVar2);
                    }
                }
            }
        }
    }

    public static void a(ArrayList arrayList, androidx.collection.a aVar, Collection collection) {
        for (int size = aVar.size() - 1; size >= 0; size--) {
            View view = (View) aVar.valueAt(size);
            if (collection.contains(c1.I(view))) {
                arrayList.add(view);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:59:0x0039, code lost:
    
        if (r0.mAdded != false) goto L70;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x008c, code lost:
    
        r9 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x006e, code lost:
    
        r9 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x008a, code lost:
    
        if (r0.mHidden == false) goto L70;
     */
    /* JADX WARN: Removed duplicated region for block: B:26:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00a7 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00c7 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00d9 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:52:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void b(androidx.fragment.app.a aVar, y.a aVar2, SparseArray sparseArray, boolean z10, boolean z11) {
        int i10;
        boolean z12;
        boolean z13;
        boolean z14;
        h hVar;
        Fragment fragment = aVar2.f2454b;
        if (fragment == null || (i10 = fragment.mContainerId) == 0) {
            return;
        }
        int i11 = z10 ? f2461a[aVar2.f2453a] : aVar2.f2453a;
        boolean z15 = false;
        boolean z16 = true;
        if (i11 != 1) {
            if (i11 != 3) {
                if (i11 == 4) {
                    boolean z17 = !z11 ? false : false;
                    z14 = z17;
                    z13 = true;
                    z16 = false;
                    hVar = (h) sparseArray.get(i10);
                    if (z15) {
                    }
                    if (!z11) {
                    }
                    if (z14) {
                    }
                    if (z11) {
                    }
                } else if (i11 != 5) {
                    if (i11 != 6) {
                        if (i11 != 7) {
                            z13 = false;
                            z16 = false;
                            z14 = false;
                            hVar = (h) sparseArray.get(i10);
                            if (z15) {
                                hVar = p(hVar, sparseArray, i10);
                                hVar.f2498a = fragment;
                                hVar.f2499b = z10;
                                hVar.f2500c = aVar;
                            }
                            if (!z11 && z16) {
                                if (hVar != null && hVar.f2501d == fragment) {
                                    hVar.f2501d = null;
                                }
                                if (!aVar.f2451r) {
                                    o oVar = aVar.f2173t;
                                    oVar.r0().p(oVar.v(fragment));
                                    oVar.R0(fragment);
                                }
                            }
                            if (z14 && (hVar == null || hVar.f2501d == null)) {
                                hVar = p(hVar, sparseArray, i10);
                                hVar.f2501d = fragment;
                                hVar.f2502e = z10;
                                hVar.f2503f = aVar;
                            }
                            if (z11 || !z13 || hVar == null || hVar.f2498a != fragment) {
                                return;
                            }
                            hVar.f2498a = null;
                            return;
                        }
                    }
                } else {
                    if (z11) {
                        if (fragment.mHiddenChanged) {
                            if (!fragment.mHidden) {
                            }
                        }
                        z12 = false;
                        z15 = z12;
                        z13 = false;
                        z14 = false;
                        hVar = (h) sparseArray.get(i10);
                        if (z15) {
                        }
                        if (!z11) {
                            if (hVar != null) {
                                hVar.f2501d = null;
                            }
                            if (!aVar.f2451r) {
                            }
                        }
                        if (z14) {
                            hVar = p(hVar, sparseArray, i10);
                            hVar.f2501d = fragment;
                            hVar.f2502e = z10;
                            hVar.f2503f = aVar;
                        }
                        if (z11) {
                            return;
                        } else {
                            return;
                        }
                    }
                    z12 = fragment.mHidden;
                    z15 = z12;
                    z13 = false;
                    z14 = false;
                    hVar = (h) sparseArray.get(i10);
                    if (z15) {
                    }
                    if (!z11) {
                    }
                    if (z14) {
                    }
                    if (z11) {
                    }
                }
            }
            if (!z11) {
            }
            z14 = z17;
            z13 = true;
            z16 = false;
            hVar = (h) sparseArray.get(i10);
            if (z15) {
            }
            if (!z11) {
            }
            if (z14) {
            }
            if (z11) {
            }
        }
        if (z11) {
            z12 = fragment.mIsNewlyAdded;
            z15 = z12;
            z13 = false;
            z14 = false;
            hVar = (h) sparseArray.get(i10);
            if (z15) {
            }
            if (!z11) {
            }
            if (z14) {
            }
            if (z11) {
            }
        } else {
            if (!fragment.mAdded) {
            }
            z12 = false;
            z15 = z12;
            z13 = false;
            z14 = false;
            hVar = (h) sparseArray.get(i10);
            if (z15) {
            }
            if (!z11) {
            }
            if (z14) {
            }
            if (z11) {
            }
        }
    }

    public static void c(androidx.fragment.app.a aVar, SparseArray sparseArray, boolean z10) {
        int size = aVar.f2436c.size();
        for (int i10 = 0; i10 < size; i10++) {
            b(aVar, (y.a) aVar.f2436c.get(i10), sparseArray, false, z10);
        }
    }

    public static androidx.collection.a d(int i10, ArrayList arrayList, ArrayList arrayList2, int i11, int i12) {
        ArrayList arrayList3;
        ArrayList arrayList4;
        androidx.collection.a aVar = new androidx.collection.a();
        for (int i13 = i12 - 1; i13 >= i11; i13--) {
            androidx.fragment.app.a aVar2 = (androidx.fragment.app.a) arrayList.get(i13);
            if (aVar2.D(i10)) {
                boolean booleanValue = ((Boolean) arrayList2.get(i13)).booleanValue();
                ArrayList arrayList5 = aVar2.f2449p;
                if (arrayList5 != null) {
                    int size = arrayList5.size();
                    if (booleanValue) {
                        arrayList3 = aVar2.f2449p;
                        arrayList4 = aVar2.f2450q;
                    } else {
                        ArrayList arrayList6 = aVar2.f2449p;
                        arrayList3 = aVar2.f2450q;
                        arrayList4 = arrayList6;
                    }
                    for (int i14 = 0; i14 < size; i14++) {
                        String str = (String) arrayList4.get(i14);
                        String str2 = (String) arrayList3.get(i14);
                        String str3 = (String) aVar.remove(str2);
                        if (str3 != null) {
                            aVar.put(str, str3);
                        } else {
                            aVar.put(str, str2);
                        }
                    }
                }
            }
        }
        return aVar;
    }

    public static void e(androidx.fragment.app.a aVar, SparseArray sparseArray, boolean z10) {
        if (aVar.f2173t.n0().d()) {
            for (int size = aVar.f2436c.size() - 1; size >= 0; size--) {
                b(aVar, (y.a) aVar.f2436c.get(size), sparseArray, true, z10);
            }
        }
    }

    public static void f(Fragment fragment, Fragment fragment2, boolean z10, androidx.collection.a aVar, boolean z11) {
        if (z10) {
            fragment2.getEnterTransitionCallback();
        } else {
            fragment.getEnterTransitionCallback();
        }
    }

    public static boolean g(g0 g0Var, List list) {
        int size = list.size();
        for (int i10 = 0; i10 < size; i10++) {
            if (!g0Var.e(list.get(i10))) {
                return false;
            }
        }
        return true;
    }

    public static androidx.collection.a h(g0 g0Var, androidx.collection.a aVar, Object obj, h hVar) {
        ArrayList arrayList;
        Fragment fragment = hVar.f2498a;
        View view = fragment.getView();
        if (aVar.isEmpty() || obj == null || view == null) {
            aVar.clear();
            return null;
        }
        androidx.collection.a aVar2 = new androidx.collection.a();
        g0Var.j(aVar2, view);
        androidx.fragment.app.a aVar3 = hVar.f2500c;
        if (hVar.f2499b) {
            fragment.getExitTransitionCallback();
            arrayList = aVar3.f2449p;
        } else {
            fragment.getEnterTransitionCallback();
            arrayList = aVar3.f2450q;
        }
        if (arrayList != null) {
            aVar2.retainAll(arrayList);
            aVar2.retainAll(aVar.values());
        }
        x(aVar, aVar2);
        return aVar2;
    }

    public static androidx.collection.a i(g0 g0Var, androidx.collection.a aVar, Object obj, h hVar) {
        ArrayList arrayList;
        if (aVar.isEmpty() || obj == null) {
            aVar.clear();
            return null;
        }
        Fragment fragment = hVar.f2501d;
        androidx.collection.a aVar2 = new androidx.collection.a();
        g0Var.j(aVar2, fragment.requireView());
        androidx.fragment.app.a aVar3 = hVar.f2503f;
        if (hVar.f2502e) {
            fragment.getEnterTransitionCallback();
            arrayList = aVar3.f2450q;
        } else {
            fragment.getExitTransitionCallback();
            arrayList = aVar3.f2449p;
        }
        if (arrayList != null) {
            aVar2.retainAll(arrayList);
        }
        aVar.retainAll(aVar2.keySet());
        return aVar2;
    }

    public static g0 j(Fragment fragment, Fragment fragment2) {
        ArrayList arrayList = new ArrayList();
        if (fragment != null) {
            Object exitTransition = fragment.getExitTransition();
            if (exitTransition != null) {
                arrayList.add(exitTransition);
            }
            Object returnTransition = fragment.getReturnTransition();
            if (returnTransition != null) {
                arrayList.add(returnTransition);
            }
            Object sharedElementReturnTransition = fragment.getSharedElementReturnTransition();
            if (sharedElementReturnTransition != null) {
                arrayList.add(sharedElementReturnTransition);
            }
        }
        if (fragment2 != null) {
            Object enterTransition = fragment2.getEnterTransition();
            if (enterTransition != null) {
                arrayList.add(enterTransition);
            }
            Object reenterTransition = fragment2.getReenterTransition();
            if (reenterTransition != null) {
                arrayList.add(reenterTransition);
            }
            Object sharedElementEnterTransition = fragment2.getSharedElementEnterTransition();
            if (sharedElementEnterTransition != null) {
                arrayList.add(sharedElementEnterTransition);
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        g0 g0Var = f2462b;
        if (g0Var != null && g(g0Var, arrayList)) {
            return g0Var;
        }
        g0 g0Var2 = f2463c;
        if (g0Var2 != null && g(g0Var2, arrayList)) {
            return g0Var2;
        }
        if (g0Var == null && g0Var2 == null) {
            return null;
        }
        throw new IllegalArgumentException("Invalid Transition types");
    }

    public static ArrayList k(g0 g0Var, Object obj, Fragment fragment, ArrayList arrayList, View view) {
        if (obj == null) {
            return null;
        }
        ArrayList arrayList2 = new ArrayList();
        View view2 = fragment.getView();
        if (view2 != null) {
            g0Var.f(arrayList2, view2);
        }
        if (arrayList != null) {
            arrayList2.removeAll(arrayList);
        }
        if (arrayList2.isEmpty()) {
            return arrayList2;
        }
        arrayList2.add(view);
        g0Var.b(obj, arrayList2);
        return arrayList2;
    }

    public static Object l(g0 g0Var, ViewGroup viewGroup, View view, androidx.collection.a aVar, h hVar, ArrayList arrayList, ArrayList arrayList2, Object obj, Object obj2) {
        Object t10;
        androidx.collection.a aVar2;
        Object obj3;
        Rect rect;
        Fragment fragment = hVar.f2498a;
        Fragment fragment2 = hVar.f2501d;
        if (fragment == null || fragment2 == null) {
            return null;
        }
        boolean z10 = hVar.f2499b;
        if (aVar.isEmpty()) {
            aVar2 = aVar;
            t10 = null;
        } else {
            t10 = t(g0Var, fragment, fragment2, z10);
            aVar2 = aVar;
        }
        androidx.collection.a i10 = i(g0Var, aVar2, t10, hVar);
        if (aVar.isEmpty()) {
            obj3 = null;
        } else {
            arrayList.addAll(i10.values());
            obj3 = t10;
        }
        if (obj == null && obj2 == null && obj3 == null) {
            return null;
        }
        f(fragment, fragment2, z10, i10, true);
        if (obj3 != null) {
            rect = new Rect();
            g0Var.z(obj3, view, arrayList);
            z(g0Var, obj3, obj2, i10, hVar.f2502e, hVar.f2503f);
            if (obj != null) {
                g0Var.u(obj, rect);
            }
        } else {
            rect = null;
        }
        b0.d0.a(viewGroup, new f(g0Var, aVar, obj3, hVar, arrayList2, view, fragment, fragment2, z10, arrayList, obj, rect));
        return obj3;
    }

    public static Object m(g0 g0Var, ViewGroup viewGroup, View view, androidx.collection.a aVar, h hVar, ArrayList arrayList, ArrayList arrayList2, Object obj, Object obj2) {
        Object obj3;
        View view2;
        Rect rect;
        Fragment fragment = hVar.f2498a;
        Fragment fragment2 = hVar.f2501d;
        if (fragment != null) {
            fragment.requireView().setVisibility(0);
        }
        if (fragment == null || fragment2 == null) {
            return null;
        }
        boolean z10 = hVar.f2499b;
        Object t10 = aVar.isEmpty() ? null : t(g0Var, fragment, fragment2, z10);
        androidx.collection.a i10 = i(g0Var, aVar, t10, hVar);
        androidx.collection.a h10 = h(g0Var, aVar, t10, hVar);
        if (aVar.isEmpty()) {
            if (i10 != null) {
                i10.clear();
            }
            if (h10 != null) {
                h10.clear();
            }
            obj3 = null;
        } else {
            a(arrayList, i10, aVar.keySet());
            a(arrayList2, h10, aVar.values());
            obj3 = t10;
        }
        if (obj == null && obj2 == null && obj3 == null) {
            return null;
        }
        f(fragment, fragment2, z10, i10, true);
        if (obj3 != null) {
            arrayList2.add(view);
            g0Var.z(obj3, view, arrayList);
            z(g0Var, obj3, obj2, i10, hVar.f2502e, hVar.f2503f);
            Rect rect2 = new Rect();
            View s10 = s(h10, hVar, obj, z10);
            if (s10 != null) {
                g0Var.u(obj, rect2);
            }
            rect = rect2;
            view2 = s10;
        } else {
            view2 = null;
            rect = null;
        }
        b0.d0.a(viewGroup, new e(fragment, fragment2, z10, h10, view2, g0Var, rect));
        return obj3;
    }

    public static void n(ViewGroup viewGroup, h hVar, View view, androidx.collection.a aVar, g gVar) {
        Object obj;
        Fragment fragment = hVar.f2498a;
        Fragment fragment2 = hVar.f2501d;
        g0 j10 = j(fragment2, fragment);
        if (j10 == null) {
            return;
        }
        boolean z10 = hVar.f2499b;
        boolean z11 = hVar.f2502e;
        Object q10 = q(j10, fragment, z10);
        Object r10 = r(j10, fragment2, z11);
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        Object l10 = l(j10, viewGroup, view, aVar, hVar, arrayList, arrayList2, q10, r10);
        if (q10 == null && l10 == null) {
            obj = r10;
            if (obj == null) {
                return;
            }
        } else {
            obj = r10;
        }
        ArrayList k10 = k(j10, obj, fragment2, arrayList, view);
        if (k10 == null || k10.isEmpty()) {
            obj = null;
        }
        Object obj2 = obj;
        j10.a(q10, view);
        Object u10 = u(j10, q10, obj2, l10, fragment, hVar.f2499b);
        if (fragment2 != null && k10 != null && (k10.size() > 0 || arrayList.size() > 0)) {
            x.b bVar = new x.b();
            gVar.a(fragment2, bVar);
            j10.w(fragment2, u10, bVar, new c(gVar, fragment2, bVar));
        }
        if (u10 != null) {
            ArrayList arrayList3 = new ArrayList();
            j10.t(u10, q10, arrayList3, obj2, k10, l10, arrayList2);
            y(j10, viewGroup, fragment, view, arrayList2, q10, arrayList3, obj2, k10);
            j10.x(viewGroup, arrayList2, aVar);
            j10.c(viewGroup, u10);
            j10.s(viewGroup, arrayList2, aVar);
        }
    }

    public static void o(ViewGroup viewGroup, h hVar, View view, androidx.collection.a aVar, g gVar) {
        Object obj;
        Fragment fragment = hVar.f2498a;
        Fragment fragment2 = hVar.f2501d;
        g0 j10 = j(fragment2, fragment);
        if (j10 == null) {
            return;
        }
        boolean z10 = hVar.f2499b;
        boolean z11 = hVar.f2502e;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        Object q10 = q(j10, fragment, z10);
        Object r10 = r(j10, fragment2, z11);
        Object m10 = m(j10, viewGroup, view, aVar, hVar, arrayList2, arrayList, q10, r10);
        if (q10 == null && m10 == null) {
            obj = r10;
            if (obj == null) {
                return;
            }
        } else {
            obj = r10;
        }
        ArrayList k10 = k(j10, obj, fragment2, arrayList2, view);
        ArrayList k11 = k(j10, q10, fragment, arrayList, view);
        A(k11, 4);
        Object u10 = u(j10, q10, obj, m10, fragment, z10);
        if (fragment2 != null && k10 != null && (k10.size() > 0 || arrayList2.size() > 0)) {
            x.b bVar = new x.b();
            gVar.a(fragment2, bVar);
            j10.w(fragment2, u10, bVar, new a(gVar, fragment2, bVar));
        }
        if (u10 != null) {
            v(j10, obj, fragment2, k10);
            ArrayList o10 = j10.o(arrayList);
            j10.t(u10, q10, k11, obj, k10, m10, arrayList);
            j10.c(viewGroup, u10);
            j10.y(viewGroup, arrayList2, arrayList, o10, aVar);
            A(k11, 0);
            j10.A(m10, arrayList2, arrayList);
        }
    }

    public static h p(h hVar, SparseArray sparseArray, int i10) {
        if (hVar != null) {
            return hVar;
        }
        h hVar2 = new h();
        sparseArray.put(i10, hVar2);
        return hVar2;
    }

    public static Object q(g0 g0Var, Fragment fragment, boolean z10) {
        if (fragment == null) {
            return null;
        }
        return g0Var.g(z10 ? fragment.getReenterTransition() : fragment.getEnterTransition());
    }

    public static Object r(g0 g0Var, Fragment fragment, boolean z10) {
        if (fragment == null) {
            return null;
        }
        return g0Var.g(z10 ? fragment.getReturnTransition() : fragment.getExitTransition());
    }

    public static View s(androidx.collection.a aVar, h hVar, Object obj, boolean z10) {
        ArrayList arrayList;
        androidx.fragment.app.a aVar2 = hVar.f2500c;
        if (obj == null || aVar == null || (arrayList = aVar2.f2449p) == null || arrayList.isEmpty()) {
            return null;
        }
        return (View) aVar.get(z10 ? (String) aVar2.f2449p.get(0) : (String) aVar2.f2450q.get(0));
    }

    public static Object t(g0 g0Var, Fragment fragment, Fragment fragment2, boolean z10) {
        if (fragment == null || fragment2 == null) {
            return null;
        }
        return g0Var.B(g0Var.g(z10 ? fragment2.getSharedElementReturnTransition() : fragment.getSharedElementEnterTransition()));
    }

    public static Object u(g0 g0Var, Object obj, Object obj2, Object obj3, Fragment fragment, boolean z10) {
        return (obj == null || obj2 == null || fragment == null) ? true : z10 ? fragment.getAllowReturnTransitionOverlap() : fragment.getAllowEnterTransitionOverlap() ? g0Var.n(obj2, obj, obj3) : g0Var.m(obj2, obj, obj3);
    }

    public static void v(g0 g0Var, Object obj, Fragment fragment, ArrayList arrayList) {
        if (fragment != null && obj != null && fragment.mAdded && fragment.mHidden && fragment.mHiddenChanged) {
            fragment.setHideReplaced(true);
            g0Var.r(obj, fragment.getView(), arrayList);
            b0.d0.a(fragment.mContainer, new b(arrayList));
        }
    }

    public static g0 w() {
        try {
            return (g0) androidx.transition.e.class.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }

    public static void x(androidx.collection.a aVar, androidx.collection.a aVar2) {
        for (int size = aVar.size() - 1; size >= 0; size--) {
            if (!aVar2.containsKey((String) aVar.valueAt(size))) {
                aVar.removeAt(size);
            }
        }
    }

    public static void y(g0 g0Var, ViewGroup viewGroup, Fragment fragment, View view, ArrayList arrayList, Object obj, ArrayList arrayList2, Object obj2, ArrayList arrayList3) {
        b0.d0.a(viewGroup, new d(obj, g0Var, view, fragment, arrayList, arrayList2, arrayList3, obj2));
    }

    public static void z(g0 g0Var, Object obj, Object obj2, androidx.collection.a aVar, boolean z10, androidx.fragment.app.a aVar2) {
        ArrayList arrayList = aVar2.f2449p;
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        View view = (View) aVar.get(z10 ? (String) aVar2.f2450q.get(0) : (String) aVar2.f2449p.get(0));
        g0Var.v(obj, view);
        if (obj2 != null) {
            g0Var.v(obj2, view);
        }
    }
}
