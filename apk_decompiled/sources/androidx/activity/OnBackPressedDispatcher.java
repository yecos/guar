package androidx.activity;

import androidx.lifecycle.d;
import androidx.lifecycle.e;
import androidx.lifecycle.g;
import java.util.ArrayDeque;
import java.util.Iterator;

/* loaded from: classes.dex */
public final class OnBackPressedDispatcher {

    /* renamed from: a, reason: collision with root package name */
    public final Runnable f754a;

    /* renamed from: b, reason: collision with root package name */
    public final ArrayDeque f755b = new ArrayDeque();

    public class LifecycleOnBackPressedCancellable implements e, androidx.activity.a {

        /* renamed from: a, reason: collision with root package name */
        public final d f756a;

        /* renamed from: b, reason: collision with root package name */
        public final b f757b;

        /* renamed from: c, reason: collision with root package name */
        public androidx.activity.a f758c;

        public LifecycleOnBackPressedCancellable(d dVar, b bVar) {
            this.f756a = dVar;
            this.f757b = bVar;
            dVar.a(this);
        }

        @Override // androidx.lifecycle.e
        public void a(g gVar, d.b bVar) {
            if (bVar == d.b.ON_START) {
                this.f758c = OnBackPressedDispatcher.this.b(this.f757b);
                return;
            }
            if (bVar != d.b.ON_STOP) {
                if (bVar == d.b.ON_DESTROY) {
                    cancel();
                }
            } else {
                androidx.activity.a aVar = this.f758c;
                if (aVar != null) {
                    aVar.cancel();
                }
            }
        }

        @Override // androidx.activity.a
        public void cancel() {
            this.f756a.c(this);
            this.f757b.e(this);
            androidx.activity.a aVar = this.f758c;
            if (aVar != null) {
                aVar.cancel();
                this.f758c = null;
            }
        }
    }

    public class a implements androidx.activity.a {

        /* renamed from: a, reason: collision with root package name */
        public final b f760a;

        public a(b bVar) {
            this.f760a = bVar;
        }

        @Override // androidx.activity.a
        public void cancel() {
            OnBackPressedDispatcher.this.f755b.remove(this.f760a);
            this.f760a.e(this);
        }
    }

    public OnBackPressedDispatcher(Runnable runnable) {
        this.f754a = runnable;
    }

    public void a(g gVar, b bVar) {
        d lifecycle = gVar.getLifecycle();
        if (lifecycle.b() == d.c.DESTROYED) {
            return;
        }
        bVar.a(new LifecycleOnBackPressedCancellable(lifecycle, bVar));
    }

    public androidx.activity.a b(b bVar) {
        this.f755b.add(bVar);
        a aVar = new a(bVar);
        bVar.a(aVar);
        return aVar;
    }

    public void c() {
        Iterator descendingIterator = this.f755b.descendingIterator();
        while (descendingIterator.hasNext()) {
            b bVar = (b) descendingIterator.next();
            if (bVar.c()) {
                bVar.b();
                return;
            }
        }
        Runnable runnable = this.f754a;
        if (runnable != null) {
            runnable.run();
        }
    }
}
