package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import b0.c1;

/* loaded from: classes.dex */
public class d extends p0 {

    public class a extends o {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f3455a;

        public a(View view) {
            this.f3455a = view;
        }

        @Override // androidx.transition.n.g
        public void d(n nVar) {
            c0.g(this.f3455a, 1.0f);
            c0.a(this.f3455a);
            nVar.removeListener(this);
        }
    }

    public static class b extends AnimatorListenerAdapter {

        /* renamed from: a, reason: collision with root package name */
        public final View f3457a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f3458b = false;

        public b(View view) {
            this.f3457a = view;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            c0.g(this.f3457a, 1.0f);
            if (this.f3458b) {
                this.f3457a.setLayerType(0, null);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            if (c1.M(this.f3457a) && this.f3457a.getLayerType() == 0) {
                this.f3458b = true;
                this.f3457a.setLayerType(2, null);
            }
        }
    }

    public d(int i10) {
        w(i10);
    }

    public static float y(u uVar, float f10) {
        Float f11;
        return (uVar == null || (f11 = (Float) uVar.f3534a.get("android:fade:transitionAlpha")) == null) ? f10 : f11.floatValue();
    }

    @Override // androidx.transition.p0, androidx.transition.n
    public void captureStartValues(u uVar) {
        super.captureStartValues(uVar);
        uVar.f3534a.put("android:fade:transitionAlpha", Float.valueOf(c0.c(uVar.f3535b)));
    }

    @Override // androidx.transition.p0
    public Animator s(ViewGroup viewGroup, View view, u uVar, u uVar2) {
        float y10 = y(uVar, 0.0f);
        return x(view, y10 != 1.0f ? y10 : 0.0f, 1.0f);
    }

    @Override // androidx.transition.p0
    public Animator u(ViewGroup viewGroup, View view, u uVar, u uVar2) {
        c0.e(view);
        return x(view, y(uVar, 1.0f), 0.0f);
    }

    public final Animator x(View view, float f10, float f11) {
        if (f10 == f11) {
            return null;
        }
        c0.g(view, f10);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, (Property<View, Float>) c0.f3453b, f11);
        ofFloat.addListener(new b(view));
        addListener(new a(view));
        return ofFloat;
    }
}
