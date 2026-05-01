package androidx.transition;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroupOverlay;

/* loaded from: classes.dex */
public class w implements x {

    /* renamed from: a, reason: collision with root package name */
    public final ViewGroupOverlay f3541a;

    public w(ViewGroup viewGroup) {
        this.f3541a = viewGroup.getOverlay();
    }

    @Override // androidx.transition.b0
    public void a(Drawable drawable) {
        this.f3541a.add(drawable);
    }

    @Override // androidx.transition.b0
    public void b(Drawable drawable) {
        this.f3541a.remove(drawable);
    }

    @Override // androidx.transition.x
    public void c(View view) {
        this.f3541a.add(view);
    }

    @Override // androidx.transition.x
    public void d(View view) {
        this.f3541a.remove(view);
    }
}
