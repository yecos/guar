package androidx.fragment.app;

import android.graphics.Rect;
import android.graphics.RectF;
import android.view.View;
import android.view.ViewGroup;
import b0.c1;
import b0.r1;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public abstract class g0 {

    public class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f2275a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ArrayList f2276b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ ArrayList f2277c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ ArrayList f2278d;

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ ArrayList f2279e;

        public a(int i10, ArrayList arrayList, ArrayList arrayList2, ArrayList arrayList3, ArrayList arrayList4) {
            this.f2275a = i10;
            this.f2276b = arrayList;
            this.f2277c = arrayList2;
            this.f2278d = arrayList3;
            this.f2279e = arrayList4;
        }

        @Override // java.lang.Runnable
        public void run() {
            for (int i10 = 0; i10 < this.f2275a; i10++) {
                c1.J0((View) this.f2276b.get(i10), (String) this.f2277c.get(i10));
                c1.J0((View) this.f2278d.get(i10), (String) this.f2279e.get(i10));
            }
        }
    }

    public class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ArrayList f2281a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Map f2282b;

        public b(ArrayList arrayList, Map map) {
            this.f2281a = arrayList;
            this.f2282b = map;
        }

        @Override // java.lang.Runnable
        public void run() {
            int size = this.f2281a.size();
            for (int i10 = 0; i10 < size; i10++) {
                View view = (View) this.f2281a.get(i10);
                String I = c1.I(view);
                if (I != null) {
                    c1.J0(view, g0.i(this.f2282b, I));
                }
            }
        }
    }

    public class c implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ArrayList f2284a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Map f2285b;

        public c(ArrayList arrayList, Map map) {
            this.f2284a = arrayList;
            this.f2285b = map;
        }

        @Override // java.lang.Runnable
        public void run() {
            int size = this.f2284a.size();
            for (int i10 = 0; i10 < size; i10++) {
                View view = (View) this.f2284a.get(i10);
                c1.J0(view, (String) this.f2285b.get(c1.I(view)));
            }
        }
    }

    public static void d(List list, View view) {
        int size = list.size();
        if (h(list, view, size)) {
            return;
        }
        if (c1.I(view) != null) {
            list.add(view);
        }
        for (int i10 = size; i10 < list.size(); i10++) {
            View view2 = (View) list.get(i10);
            if (view2 instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view2;
                int childCount = viewGroup.getChildCount();
                for (int i11 = 0; i11 < childCount; i11++) {
                    View childAt = viewGroup.getChildAt(i11);
                    if (!h(list, childAt, size) && c1.I(childAt) != null) {
                        list.add(childAt);
                    }
                }
            }
        }
    }

    public static boolean h(List list, View view, int i10) {
        for (int i11 = 0; i11 < i10; i11++) {
            if (list.get(i11) == view) {
                return true;
            }
        }
        return false;
    }

    public static String i(Map map, String str) {
        for (Map.Entry entry : map.entrySet()) {
            if (str.equals(entry.getValue())) {
                return (String) entry.getKey();
            }
        }
        return null;
    }

    public static boolean l(List list) {
        return list == null || list.isEmpty();
    }

    public abstract void A(Object obj, ArrayList arrayList, ArrayList arrayList2);

    public abstract Object B(Object obj);

    public abstract void a(Object obj, View view);

    public abstract void b(Object obj, ArrayList arrayList);

    public abstract void c(ViewGroup viewGroup, Object obj);

    public abstract boolean e(Object obj);

    public void f(ArrayList arrayList, View view) {
        if (view.getVisibility() == 0) {
            if (!(view instanceof ViewGroup)) {
                arrayList.add(view);
                return;
            }
            ViewGroup viewGroup = (ViewGroup) view;
            if (r1.a(viewGroup)) {
                arrayList.add(viewGroup);
                return;
            }
            int childCount = viewGroup.getChildCount();
            for (int i10 = 0; i10 < childCount; i10++) {
                f(arrayList, viewGroup.getChildAt(i10));
            }
        }
    }

    public abstract Object g(Object obj);

    public void j(Map map, View view) {
        if (view.getVisibility() == 0) {
            String I = c1.I(view);
            if (I != null) {
                map.put(I, view);
            }
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                int childCount = viewGroup.getChildCount();
                for (int i10 = 0; i10 < childCount; i10++) {
                    j(map, viewGroup.getChildAt(i10));
                }
            }
        }
    }

    public void k(View view, Rect rect) {
        if (c1.P(view)) {
            RectF rectF = new RectF();
            rectF.set(0.0f, 0.0f, view.getWidth(), view.getHeight());
            view.getMatrix().mapRect(rectF);
            rectF.offset(view.getLeft(), view.getTop());
            Object parent = view.getParent();
            while (parent instanceof View) {
                View view2 = (View) parent;
                rectF.offset(-view2.getScrollX(), -view2.getScrollY());
                view2.getMatrix().mapRect(rectF);
                rectF.offset(view2.getLeft(), view2.getTop());
                parent = view2.getParent();
            }
            view.getRootView().getLocationOnScreen(new int[2]);
            rectF.offset(r1[0], r1[1]);
            rect.set(Math.round(rectF.left), Math.round(rectF.top), Math.round(rectF.right), Math.round(rectF.bottom));
        }
    }

    public abstract Object m(Object obj, Object obj2, Object obj3);

    public abstract Object n(Object obj, Object obj2, Object obj3);

    public ArrayList o(ArrayList arrayList) {
        ArrayList arrayList2 = new ArrayList();
        int size = arrayList.size();
        for (int i10 = 0; i10 < size; i10++) {
            View view = (View) arrayList.get(i10);
            arrayList2.add(c1.I(view));
            c1.J0(view, null);
        }
        return arrayList2;
    }

    public abstract void p(Object obj, View view);

    public abstract void q(Object obj, ArrayList arrayList, ArrayList arrayList2);

    public abstract void r(Object obj, View view, ArrayList arrayList);

    public void s(ViewGroup viewGroup, ArrayList arrayList, Map map) {
        b0.d0.a(viewGroup, new c(arrayList, map));
    }

    public abstract void t(Object obj, Object obj2, ArrayList arrayList, Object obj3, ArrayList arrayList2, Object obj4, ArrayList arrayList3);

    public abstract void u(Object obj, Rect rect);

    public abstract void v(Object obj, View view);

    public void w(Fragment fragment, Object obj, x.b bVar, Runnable runnable) {
        runnable.run();
    }

    public void x(View view, ArrayList arrayList, Map map) {
        b0.d0.a(view, new b(arrayList, map));
    }

    public void y(View view, ArrayList arrayList, ArrayList arrayList2, ArrayList arrayList3, Map map) {
        int size = arrayList2.size();
        ArrayList arrayList4 = new ArrayList();
        for (int i10 = 0; i10 < size; i10++) {
            View view2 = (View) arrayList.get(i10);
            String I = c1.I(view2);
            arrayList4.add(I);
            if (I != null) {
                c1.J0(view2, null);
                String str = (String) map.get(I);
                int i11 = 0;
                while (true) {
                    if (i11 >= size) {
                        break;
                    }
                    if (str.equals(arrayList3.get(i11))) {
                        c1.J0((View) arrayList2.get(i11), I);
                        break;
                    }
                    i11++;
                }
            }
        }
        b0.d0.a(view, new a(size, arrayList2, arrayList3, arrayList, arrayList4));
    }

    public abstract void z(Object obj, View view, ArrayList arrayList);
}
