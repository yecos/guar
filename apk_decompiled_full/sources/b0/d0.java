package b0;

import android.view.View;
import android.view.ViewTreeObserver;

/* loaded from: classes.dex */
public final class d0 implements ViewTreeObserver.OnPreDrawListener, View.OnAttachStateChangeListener {

    /* renamed from: a, reason: collision with root package name */
    public final View f4330a;

    /* renamed from: b, reason: collision with root package name */
    public ViewTreeObserver f4331b;

    /* renamed from: c, reason: collision with root package name */
    public final Runnable f4332c;

    public d0(View view, Runnable runnable) {
        this.f4330a = view;
        this.f4331b = view.getViewTreeObserver();
        this.f4332c = runnable;
    }

    public static d0 a(View view, Runnable runnable) {
        if (view == null) {
            throw new NullPointerException("view == null");
        }
        if (runnable == null) {
            throw new NullPointerException("runnable == null");
        }
        d0 d0Var = new d0(view, runnable);
        view.getViewTreeObserver().addOnPreDrawListener(d0Var);
        view.addOnAttachStateChangeListener(d0Var);
        return d0Var;
    }

    public void b() {
        if (this.f4331b.isAlive()) {
            this.f4331b.removeOnPreDrawListener(this);
        } else {
            this.f4330a.getViewTreeObserver().removeOnPreDrawListener(this);
        }
        this.f4330a.removeOnAttachStateChangeListener(this);
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public boolean onPreDraw() {
        b();
        this.f4332c.run();
        return true;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(View view) {
        this.f4331b = view.getViewTreeObserver();
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(View view) {
        b();
    }
}
