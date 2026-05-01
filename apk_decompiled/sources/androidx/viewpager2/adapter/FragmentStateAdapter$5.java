package androidx.viewpager2.adapter;

import android.os.Handler;
import androidx.lifecycle.d;
import androidx.lifecycle.e;
import androidx.lifecycle.g;

/* loaded from: classes.dex */
class FragmentStateAdapter$5 implements e {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Handler f3585a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Runnable f3586b;

    @Override // androidx.lifecycle.e
    public void a(g gVar, d.b bVar) {
        if (bVar == d.b.ON_DESTROY) {
            this.f3585a.removeCallbacks(this.f3586b);
            gVar.getLifecycle().c(this);
        }
    }
}
