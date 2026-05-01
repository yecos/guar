package androidx.fragment.app;

import android.os.Bundle;
import androidx.lifecycle.d;
import androidx.savedstate.SavedStateRegistry;

/* loaded from: classes.dex */
public class h0 implements androidx.savedstate.b, androidx.lifecycle.y {

    /* renamed from: a, reason: collision with root package name */
    public final Fragment f2287a;

    /* renamed from: b, reason: collision with root package name */
    public final androidx.lifecycle.x f2288b;

    /* renamed from: c, reason: collision with root package name */
    public androidx.lifecycle.h f2289c = null;

    /* renamed from: d, reason: collision with root package name */
    public androidx.savedstate.a f2290d = null;

    public h0(Fragment fragment, androidx.lifecycle.x xVar) {
        this.f2287a = fragment;
        this.f2288b = xVar;
    }

    public void a(d.b bVar) {
        this.f2289c.h(bVar);
    }

    public void b() {
        if (this.f2289c == null) {
            this.f2289c = new androidx.lifecycle.h(this);
            this.f2290d = androidx.savedstate.a.a(this);
        }
    }

    public boolean c() {
        return this.f2289c != null;
    }

    public void d(Bundle bundle) {
        this.f2290d.c(bundle);
    }

    public void e(Bundle bundle) {
        this.f2290d.d(bundle);
    }

    public void f(d.c cVar) {
        this.f2289c.o(cVar);
    }

    @Override // androidx.lifecycle.g
    public androidx.lifecycle.d getLifecycle() {
        b();
        return this.f2289c;
    }

    @Override // androidx.savedstate.b
    public SavedStateRegistry getSavedStateRegistry() {
        b();
        return this.f2290d.b();
    }

    @Override // androidx.lifecycle.y
    public androidx.lifecycle.x getViewModelStore() {
        b();
        return this.f2288b;
    }
}
