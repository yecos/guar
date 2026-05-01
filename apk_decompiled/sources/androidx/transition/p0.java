package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewGroup;
import androidx.transition.n;

/* loaded from: classes.dex */
public abstract class p0 extends n {

    /* renamed from: b, reason: collision with root package name */
    public static final String[] f3504b = {"android:visibility:visibility", "android:visibility:parent"};

    /* renamed from: a, reason: collision with root package name */
    public int f3505a = 3;

    public class a extends o {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ViewGroup f3506a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ View f3507b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ View f3508c;

        public a(ViewGroup viewGroup, View view, View view2) {
            this.f3506a = viewGroup;
            this.f3507b = view;
            this.f3508c = view2;
        }

        @Override // androidx.transition.o, androidx.transition.n.g
        public void a(n nVar) {
            if (this.f3507b.getParent() == null) {
                z.a(this.f3506a).c(this.f3507b);
            } else {
                p0.this.cancel();
            }
        }

        @Override // androidx.transition.o, androidx.transition.n.g
        public void c(n nVar) {
            z.a(this.f3506a).d(this.f3507b);
        }

        @Override // androidx.transition.n.g
        public void d(n nVar) {
            this.f3508c.setTag(R$id.save_overlay_view, null);
            z.a(this.f3506a).d(this.f3507b);
            nVar.removeListener(this);
        }
    }

    public static class b extends AnimatorListenerAdapter implements n.g {

        /* renamed from: a, reason: collision with root package name */
        public final View f3510a;

        /* renamed from: b, reason: collision with root package name */
        public final int f3511b;

        /* renamed from: c, reason: collision with root package name */
        public final ViewGroup f3512c;

        /* renamed from: d, reason: collision with root package name */
        public final boolean f3513d;

        /* renamed from: e, reason: collision with root package name */
        public boolean f3514e;

        /* renamed from: f, reason: collision with root package name */
        public boolean f3515f = false;

        public b(View view, int i10, boolean z10) {
            this.f3510a = view;
            this.f3511b = i10;
            this.f3512c = (ViewGroup) view.getParent();
            this.f3513d = z10;
            g(true);
        }

        @Override // androidx.transition.n.g
        public void a(n nVar) {
            g(true);
        }

        @Override // androidx.transition.n.g
        public void b(n nVar) {
        }

        @Override // androidx.transition.n.g
        public void c(n nVar) {
            g(false);
        }

        @Override // androidx.transition.n.g
        public void d(n nVar) {
            f();
            nVar.removeListener(this);
        }

        @Override // androidx.transition.n.g
        public void e(n nVar) {
        }

        public final void f() {
            if (!this.f3515f) {
                c0.h(this.f3510a, this.f3511b);
                ViewGroup viewGroup = this.f3512c;
                if (viewGroup != null) {
                    viewGroup.invalidate();
                }
            }
            g(false);
        }

        public final void g(boolean z10) {
            ViewGroup viewGroup;
            if (!this.f3513d || this.f3514e == z10 || (viewGroup = this.f3512c) == null) {
                return;
            }
            this.f3514e = z10;
            z.c(viewGroup, z10);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.f3515f = true;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            f();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorPauseListener
        public void onAnimationPause(Animator animator) {
            if (this.f3515f) {
                return;
            }
            c0.h(this.f3510a, this.f3511b);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorPauseListener
        public void onAnimationResume(Animator animator) {
            if (this.f3515f) {
                return;
            }
            c0.h(this.f3510a, 0);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }

    public static class c {

        /* renamed from: a, reason: collision with root package name */
        public boolean f3516a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f3517b;

        /* renamed from: c, reason: collision with root package name */
        public int f3518c;

        /* renamed from: d, reason: collision with root package name */
        public int f3519d;

        /* renamed from: e, reason: collision with root package name */
        public ViewGroup f3520e;

        /* renamed from: f, reason: collision with root package name */
        public ViewGroup f3521f;
    }

    @Override // androidx.transition.n
    public void captureEndValues(u uVar) {
        captureValues(uVar);
    }

    @Override // androidx.transition.n
    public void captureStartValues(u uVar) {
        captureValues(uVar);
    }

    public final void captureValues(u uVar) {
        uVar.f3534a.put("android:visibility:visibility", Integer.valueOf(uVar.f3535b.getVisibility()));
        uVar.f3534a.put("android:visibility:parent", uVar.f3535b.getParent());
        int[] iArr = new int[2];
        uVar.f3535b.getLocationOnScreen(iArr);
        uVar.f3534a.put("android:visibility:screenLocation", iArr);
    }

    @Override // androidx.transition.n
    public Animator createAnimator(ViewGroup viewGroup, u uVar, u uVar2) {
        c r10 = r(uVar, uVar2);
        if (!r10.f3516a) {
            return null;
        }
        if (r10.f3520e == null && r10.f3521f == null) {
            return null;
        }
        return r10.f3517b ? t(viewGroup, uVar, r10.f3518c, uVar2, r10.f3519d) : v(viewGroup, uVar, r10.f3518c, uVar2, r10.f3519d);
    }

    @Override // androidx.transition.n
    public String[] getTransitionProperties() {
        return f3504b;
    }

    @Override // androidx.transition.n
    public boolean isTransitionRequired(u uVar, u uVar2) {
        if (uVar == null && uVar2 == null) {
            return false;
        }
        if (uVar != null && uVar2 != null && uVar2.f3534a.containsKey("android:visibility:visibility") != uVar.f3534a.containsKey("android:visibility:visibility")) {
            return false;
        }
        c r10 = r(uVar, uVar2);
        if (r10.f3516a) {
            return r10.f3518c == 0 || r10.f3519d == 0;
        }
        return false;
    }

    public final c r(u uVar, u uVar2) {
        c cVar = new c();
        cVar.f3516a = false;
        cVar.f3517b = false;
        if (uVar == null || !uVar.f3534a.containsKey("android:visibility:visibility")) {
            cVar.f3518c = -1;
            cVar.f3520e = null;
        } else {
            cVar.f3518c = ((Integer) uVar.f3534a.get("android:visibility:visibility")).intValue();
            cVar.f3520e = (ViewGroup) uVar.f3534a.get("android:visibility:parent");
        }
        if (uVar2 == null || !uVar2.f3534a.containsKey("android:visibility:visibility")) {
            cVar.f3519d = -1;
            cVar.f3521f = null;
        } else {
            cVar.f3519d = ((Integer) uVar2.f3534a.get("android:visibility:visibility")).intValue();
            cVar.f3521f = (ViewGroup) uVar2.f3534a.get("android:visibility:parent");
        }
        if (uVar != null && uVar2 != null) {
            int i10 = cVar.f3518c;
            int i11 = cVar.f3519d;
            if (i10 == i11 && cVar.f3520e == cVar.f3521f) {
                return cVar;
            }
            if (i10 != i11) {
                if (i10 == 0) {
                    cVar.f3517b = false;
                    cVar.f3516a = true;
                } else if (i11 == 0) {
                    cVar.f3517b = true;
                    cVar.f3516a = true;
                }
            } else if (cVar.f3521f == null) {
                cVar.f3517b = false;
                cVar.f3516a = true;
            } else if (cVar.f3520e == null) {
                cVar.f3517b = true;
                cVar.f3516a = true;
            }
        } else if (uVar == null && cVar.f3519d == 0) {
            cVar.f3517b = true;
            cVar.f3516a = true;
        } else if (uVar2 == null && cVar.f3518c == 0) {
            cVar.f3517b = false;
            cVar.f3516a = true;
        }
        return cVar;
    }

    public abstract Animator s(ViewGroup viewGroup, View view, u uVar, u uVar2);

    public Animator t(ViewGroup viewGroup, u uVar, int i10, u uVar2, int i11) {
        if ((this.f3505a & 1) != 1 || uVar2 == null) {
            return null;
        }
        if (uVar == null) {
            View view = (View) uVar2.f3535b.getParent();
            if (r(getMatchedTransitionValues(view, false), getTransitionValues(view, false)).f3516a) {
                return null;
            }
        }
        return s(viewGroup, uVar2.f3535b, uVar, uVar2);
    }

    public abstract Animator u(ViewGroup viewGroup, View view, u uVar, u uVar2);

    /* JADX WARN: Code restructure failed: missing block: B:51:0x0089, code lost:
    
        if (r17.mCanRemoveViews != false) goto L43;
     */
    /* JADX WARN: Removed duplicated region for block: B:37:0x004a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public android.animation.Animator v(android.view.ViewGroup r18, androidx.transition.u r19, int r20, androidx.transition.u r21, int r22) {
        /*
            Method dump skipped, instructions count: 264
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.transition.p0.v(android.view.ViewGroup, androidx.transition.u, int, androidx.transition.u, int):android.animation.Animator");
    }

    public void w(int i10) {
        if ((i10 & (-4)) != 0) {
            throw new IllegalArgumentException("Only MODE_IN and MODE_OUT flags are allowed");
        }
        this.f3505a = i10;
    }
}
