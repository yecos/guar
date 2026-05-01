package androidx.transition;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewOverlay;

/* loaded from: classes.dex */
public class a0 implements b0 {

    /* renamed from: a, reason: collision with root package name */
    public final ViewOverlay f3414a;

    public a0(View view) {
        this.f3414a = view.getOverlay();
    }

    @Override // androidx.transition.b0
    public void a(Drawable drawable) {
        this.f3414a.add(drawable);
    }

    @Override // androidx.transition.b0
    public void b(Drawable drawable) {
        this.f3414a.remove(drawable);
    }
}
