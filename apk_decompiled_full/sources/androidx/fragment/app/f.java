package androidx.fragment.app;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.Transformation;
import androidx.fragment.R$animator;
import androidx.fragment.R$id;
import androidx.fragment.app.z;
import x.b;

/* loaded from: classes.dex */
public abstract class f {

    public class a implements b.a {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Fragment f2241a;

        public a(Fragment fragment) {
            this.f2241a = fragment;
        }

        @Override // x.b.a
        public void a() {
            if (this.f2241a.getAnimatingAway() != null) {
                View animatingAway = this.f2241a.getAnimatingAway();
                this.f2241a.setAnimatingAway(null);
                animatingAway.clearAnimation();
            }
            this.f2241a.setAnimator(null);
        }
    }

    public class b implements Animation.AnimationListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ViewGroup f2242a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Fragment f2243b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ z.g f2244c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ x.b f2245d;

        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (b.this.f2243b.getAnimatingAway() != null) {
                    b.this.f2243b.setAnimatingAway(null);
                    b bVar = b.this;
                    bVar.f2244c.b(bVar.f2243b, bVar.f2245d);
                }
            }
        }

        public b(ViewGroup viewGroup, Fragment fragment, z.g gVar, x.b bVar) {
            this.f2242a = viewGroup;
            this.f2243b = fragment;
            this.f2244c = gVar;
            this.f2245d = bVar;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            this.f2242a.post(new a());
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    public class c extends AnimatorListenerAdapter {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ViewGroup f2247a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ View f2248b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Fragment f2249c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ z.g f2250d;

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ x.b f2251e;

        public c(ViewGroup viewGroup, View view, Fragment fragment, z.g gVar, x.b bVar) {
            this.f2247a = viewGroup;
            this.f2248b = view;
            this.f2249c = fragment;
            this.f2250d = gVar;
            this.f2251e = bVar;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f2247a.endViewTransition(this.f2248b);
            Animator animator2 = this.f2249c.getAnimator();
            this.f2249c.setAnimator(null);
            if (animator2 == null || this.f2247a.indexOfChild(this.f2248b) >= 0) {
                return;
            }
            this.f2250d.b(this.f2249c, this.f2251e);
        }
    }

    public static void a(Fragment fragment, d dVar, z.g gVar) {
        View view = fragment.mView;
        ViewGroup viewGroup = fragment.mContainer;
        viewGroup.startViewTransition(view);
        x.b bVar = new x.b();
        bVar.c(new a(fragment));
        gVar.a(fragment, bVar);
        if (dVar.f2252a != null) {
            e eVar = new e(dVar.f2252a, viewGroup, view);
            fragment.setAnimatingAway(fragment.mView);
            eVar.setAnimationListener(new b(viewGroup, fragment, gVar, bVar));
            fragment.mView.startAnimation(eVar);
            return;
        }
        Animator animator = dVar.f2253b;
        fragment.setAnimator(animator);
        animator.addListener(new c(viewGroup, view, fragment, gVar, bVar));
        animator.setTarget(fragment.mView);
        animator.start();
    }

    public static int b(Fragment fragment, boolean z10, boolean z11) {
        return z11 ? z10 ? fragment.getPopEnterAnim() : fragment.getPopExitAnim() : z10 ? fragment.getEnterAnim() : fragment.getExitAnim();
    }

    public static d c(Context context, Fragment fragment, boolean z10, boolean z11) {
        int nextTransition = fragment.getNextTransition();
        int b10 = b(fragment, z10, z11);
        boolean z12 = false;
        fragment.setAnimations(0, 0, 0, 0);
        ViewGroup viewGroup = fragment.mContainer;
        if (viewGroup != null) {
            int i10 = R$id.visible_removing_fragment_view_tag;
            if (viewGroup.getTag(i10) != null) {
                fragment.mContainer.setTag(i10, null);
            }
        }
        ViewGroup viewGroup2 = fragment.mContainer;
        if (viewGroup2 != null && viewGroup2.getLayoutTransition() != null) {
            return null;
        }
        Animation onCreateAnimation = fragment.onCreateAnimation(nextTransition, z10, b10);
        if (onCreateAnimation != null) {
            return new d(onCreateAnimation);
        }
        Animator onCreateAnimator = fragment.onCreateAnimator(nextTransition, z10, b10);
        if (onCreateAnimator != null) {
            return new d(onCreateAnimator);
        }
        if (b10 == 0 && nextTransition != 0) {
            b10 = d(nextTransition, z10);
        }
        if (b10 != 0) {
            boolean equals = "anim".equals(context.getResources().getResourceTypeName(b10));
            if (equals) {
                try {
                    Animation loadAnimation = AnimationUtils.loadAnimation(context, b10);
                    if (loadAnimation != null) {
                        return new d(loadAnimation);
                    }
                    z12 = true;
                } catch (Resources.NotFoundException e10) {
                    throw e10;
                } catch (RuntimeException unused) {
                }
            }
            if (!z12) {
                try {
                    Animator loadAnimator = AnimatorInflater.loadAnimator(context, b10);
                    if (loadAnimator != null) {
                        return new d(loadAnimator);
                    }
                } catch (RuntimeException e11) {
                    if (equals) {
                        throw e11;
                    }
                    Animation loadAnimation2 = AnimationUtils.loadAnimation(context, b10);
                    if (loadAnimation2 != null) {
                        return new d(loadAnimation2);
                    }
                }
            }
        }
        return null;
    }

    public static int d(int i10, boolean z10) {
        if (i10 == 4097) {
            return z10 ? R$animator.fragment_open_enter : R$animator.fragment_open_exit;
        }
        if (i10 == 4099) {
            return z10 ? R$animator.fragment_fade_enter : R$animator.fragment_fade_exit;
        }
        if (i10 != 8194) {
            return -1;
        }
        return z10 ? R$animator.fragment_close_enter : R$animator.fragment_close_exit;
    }

    public static class d {

        /* renamed from: a, reason: collision with root package name */
        public final Animation f2252a;

        /* renamed from: b, reason: collision with root package name */
        public final Animator f2253b;

        public d(Animation animation) {
            this.f2252a = animation;
            this.f2253b = null;
            if (animation == null) {
                throw new IllegalStateException("Animation cannot be null");
            }
        }

        public d(Animator animator) {
            this.f2252a = null;
            this.f2253b = animator;
            if (animator == null) {
                throw new IllegalStateException("Animator cannot be null");
            }
        }
    }

    public static class e extends AnimationSet implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final ViewGroup f2254a;

        /* renamed from: b, reason: collision with root package name */
        public final View f2255b;

        /* renamed from: c, reason: collision with root package name */
        public boolean f2256c;

        /* renamed from: d, reason: collision with root package name */
        public boolean f2257d;

        /* renamed from: e, reason: collision with root package name */
        public boolean f2258e;

        public e(Animation animation, ViewGroup viewGroup, View view) {
            super(false);
            this.f2258e = true;
            this.f2254a = viewGroup;
            this.f2255b = view;
            addAnimation(animation);
            viewGroup.post(this);
        }

        @Override // android.view.animation.AnimationSet, android.view.animation.Animation
        public boolean getTransformation(long j10, Transformation transformation) {
            this.f2258e = true;
            if (this.f2256c) {
                return !this.f2257d;
            }
            if (!super.getTransformation(j10, transformation)) {
                this.f2256c = true;
                b0.d0.a(this.f2254a, this);
            }
            return true;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f2256c || !this.f2258e) {
                this.f2254a.endViewTransition(this.f2255b);
                this.f2257d = true;
            } else {
                this.f2258e = false;
                this.f2254a.post(this);
            }
        }

        @Override // android.view.animation.Animation
        public boolean getTransformation(long j10, Transformation transformation, float f10) {
            this.f2258e = true;
            if (this.f2256c) {
                return !this.f2257d;
            }
            if (!super.getTransformation(j10, transformation, f10)) {
                this.f2256c = true;
                b0.d0.a(this.f2254a, this);
            }
            return true;
        }
    }
}
