package androidx.activity;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes.dex */
public abstract class b {

    /* renamed from: a, reason: collision with root package name */
    public boolean f767a;

    /* renamed from: b, reason: collision with root package name */
    public CopyOnWriteArrayList f768b = new CopyOnWriteArrayList();

    public b(boolean z10) {
        this.f767a = z10;
    }

    public void a(a aVar) {
        this.f768b.add(aVar);
    }

    public abstract void b();

    public final boolean c() {
        return this.f767a;
    }

    public final void d() {
        Iterator it = this.f768b.iterator();
        while (it.hasNext()) {
            ((a) it.next()).cancel();
        }
    }

    public void e(a aVar) {
        this.f768b.remove(aVar);
    }

    public final void f(boolean z10) {
        this.f767a = z10;
    }
}
