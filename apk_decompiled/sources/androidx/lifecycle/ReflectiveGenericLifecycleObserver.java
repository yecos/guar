package androidx.lifecycle;

import androidx.lifecycle.b;
import androidx.lifecycle.d;

/* loaded from: classes.dex */
class ReflectiveGenericLifecycleObserver implements e {

    /* renamed from: a, reason: collision with root package name */
    public final Object f2546a;

    /* renamed from: b, reason: collision with root package name */
    public final b.a f2547b;

    public ReflectiveGenericLifecycleObserver(Object obj) {
        this.f2546a = obj;
        this.f2547b = b.f2553c.c(obj.getClass());
    }

    @Override // androidx.lifecycle.e
    public void a(g gVar, d.b bVar) {
        this.f2547b.a(gVar, bVar, this.f2546a);
    }
}
