package x6;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.view.View;
import android.view.animation.DecelerateInterpolator;

/* loaded from: classes3.dex */
public abstract class a {

    /* renamed from: x6.a$a, reason: collision with other inner class name */
    public class C0334a extends AnimatorListenerAdapter {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f19471a;

        public C0334a(View view) {
            this.f19471a = view;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f19471a.setVisibility(8);
            this.f19471a.setTag(Boolean.FALSE);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            this.f19471a.setTag(Boolean.TRUE);
        }
    }

    public static void a(View view, int i10) {
        view.setVisibility(0);
        ObjectAnimator duration = ObjectAnimator.ofFloat(view, "translationX", -i10, 0.0f).setDuration(500L);
        duration.setInterpolator(new DecelerateInterpolator());
        duration.start();
    }

    public static void b(View view, int i10) {
        Object tag = view.getTag();
        if (tag == null || !((Boolean) tag).booleanValue()) {
            ObjectAnimator duration = ObjectAnimator.ofFloat(view, "translationX", 0.0f, -i10).setDuration(500L);
            duration.setInterpolator(new DecelerateInterpolator());
            duration.addListener(new C0334a(view));
            duration.start();
        }
    }
}
