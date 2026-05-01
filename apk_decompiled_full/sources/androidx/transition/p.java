package androidx.transition;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import b0.c1;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
public abstract class p {

    /* renamed from: a, reason: collision with root package name */
    public static n f3497a = new b();

    /* renamed from: b, reason: collision with root package name */
    public static ThreadLocal f3498b = new ThreadLocal();

    /* renamed from: c, reason: collision with root package name */
    public static ArrayList f3499c = new ArrayList();

    public static class a implements ViewTreeObserver.OnPreDrawListener, View.OnAttachStateChangeListener {

        /* renamed from: a, reason: collision with root package name */
        public n f3500a;

        /* renamed from: b, reason: collision with root package name */
        public ViewGroup f3501b;

        /* renamed from: androidx.transition.p$a$a, reason: collision with other inner class name */
        public class C0057a extends o {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ androidx.collection.a f3502a;

            public C0057a(androidx.collection.a aVar) {
                this.f3502a = aVar;
            }

            @Override // androidx.transition.n.g
            public void d(n nVar) {
                ((ArrayList) this.f3502a.get(a.this.f3501b)).remove(nVar);
                nVar.removeListener(this);
            }
        }

        public a(n nVar, ViewGroup viewGroup) {
            this.f3500a = nVar;
            this.f3501b = viewGroup;
        }

        public final void a() {
            this.f3501b.getViewTreeObserver().removeOnPreDrawListener(this);
            this.f3501b.removeOnAttachStateChangeListener(this);
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            a();
            if (!p.f3499c.remove(this.f3501b)) {
                return true;
            }
            androidx.collection.a b10 = p.b();
            ArrayList arrayList = (ArrayList) b10.get(this.f3501b);
            ArrayList arrayList2 = null;
            if (arrayList == null) {
                arrayList = new ArrayList();
                b10.put(this.f3501b, arrayList);
            } else if (arrayList.size() > 0) {
                arrayList2 = new ArrayList(arrayList);
            }
            arrayList.add(this.f3500a);
            this.f3500a.addListener(new C0057a(b10));
            this.f3500a.captureValues(this.f3501b, false);
            if (arrayList2 != null) {
                Iterator it = arrayList2.iterator();
                while (it.hasNext()) {
                    ((n) it.next()).resume(this.f3501b);
                }
            }
            this.f3500a.playTransition(this.f3501b);
            return true;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            a();
            p.f3499c.remove(this.f3501b);
            ArrayList arrayList = (ArrayList) p.b().get(this.f3501b);
            if (arrayList != null && arrayList.size() > 0) {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    ((n) it.next()).resume(this.f3501b);
                }
            }
            this.f3500a.clearValues(true);
        }
    }

    public static void a(ViewGroup viewGroup, n nVar) {
        if (f3499c.contains(viewGroup) || !c1.Q(viewGroup)) {
            return;
        }
        f3499c.add(viewGroup);
        if (nVar == null) {
            nVar = f3497a;
        }
        n mo0clone = nVar.mo0clone();
        d(viewGroup, mo0clone);
        m.b(viewGroup, null);
        c(viewGroup, mo0clone);
    }

    public static androidx.collection.a b() {
        androidx.collection.a aVar;
        WeakReference weakReference = (WeakReference) f3498b.get();
        if (weakReference != null && (aVar = (androidx.collection.a) weakReference.get()) != null) {
            return aVar;
        }
        androidx.collection.a aVar2 = new androidx.collection.a();
        f3498b.set(new WeakReference(aVar2));
        return aVar2;
    }

    public static void c(ViewGroup viewGroup, n nVar) {
        if (nVar == null || viewGroup == null) {
            return;
        }
        a aVar = new a(nVar, viewGroup);
        viewGroup.addOnAttachStateChangeListener(aVar);
        viewGroup.getViewTreeObserver().addOnPreDrawListener(aVar);
    }

    public static void d(ViewGroup viewGroup, n nVar) {
        ArrayList arrayList = (ArrayList) b().get(viewGroup);
        if (arrayList != null && arrayList.size() > 0) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ((n) it.next()).pause(viewGroup);
            }
        }
        if (nVar != null) {
            nVar.captureValues(viewGroup, true);
        }
        m.a(viewGroup);
    }
}
