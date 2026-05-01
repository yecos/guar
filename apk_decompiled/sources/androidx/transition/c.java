package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import b0.c1;
import java.util.Map;

/* loaded from: classes.dex */
public class c extends n {

    /* renamed from: d, reason: collision with root package name */
    public static final String[] f3415d = {"android:changeBounds:bounds", "android:changeBounds:clip", "android:changeBounds:parent", "android:changeBounds:windowX", "android:changeBounds:windowY"};

    /* renamed from: e, reason: collision with root package name */
    public static final Property f3416e = new b(PointF.class, "boundsOrigin");

    /* renamed from: f, reason: collision with root package name */
    public static final Property f3417f = new C0056c(PointF.class, "topLeft");

    /* renamed from: g, reason: collision with root package name */
    public static final Property f3418g = new d(PointF.class, "bottomRight");

    /* renamed from: h, reason: collision with root package name */
    public static final Property f3419h = new e(PointF.class, "bottomRight");

    /* renamed from: i, reason: collision with root package name */
    public static final Property f3420i = new f(PointF.class, "topLeft");

    /* renamed from: j, reason: collision with root package name */
    public static final Property f3421j = new g(PointF.class, "position");

    /* renamed from: k, reason: collision with root package name */
    public static l f3422k = new l();

    /* renamed from: a, reason: collision with root package name */
    public int[] f3423a = new int[2];

    /* renamed from: b, reason: collision with root package name */
    public boolean f3424b = false;

    /* renamed from: c, reason: collision with root package name */
    public boolean f3425c = false;

    public class a extends AnimatorListenerAdapter {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ViewGroup f3426a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ BitmapDrawable f3427b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ View f3428c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ float f3429d;

        public a(ViewGroup viewGroup, BitmapDrawable bitmapDrawable, View view, float f10) {
            this.f3426a = viewGroup;
            this.f3427b = bitmapDrawable;
            this.f3428c = view;
            this.f3429d = f10;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            c0.b(this.f3426a).b(this.f3427b);
            c0.g(this.f3428c, this.f3429d);
        }
    }

    public static class b extends Property {

        /* renamed from: a, reason: collision with root package name */
        public Rect f3431a;

        public b(Class cls, String str) {
            super(cls, str);
            this.f3431a = new Rect();
        }

        @Override // android.util.Property
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public PointF get(Drawable drawable) {
            drawable.copyBounds(this.f3431a);
            Rect rect = this.f3431a;
            return new PointF(rect.left, rect.top);
        }

        @Override // android.util.Property
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(Drawable drawable, PointF pointF) {
            drawable.copyBounds(this.f3431a);
            this.f3431a.offsetTo(Math.round(pointF.x), Math.round(pointF.y));
            drawable.setBounds(this.f3431a);
        }
    }

    /* renamed from: androidx.transition.c$c, reason: collision with other inner class name */
    public static class C0056c extends Property {
        public C0056c(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public PointF get(k kVar) {
            return null;
        }

        @Override // android.util.Property
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(k kVar, PointF pointF) {
            kVar.c(pointF);
        }
    }

    public static class d extends Property {
        public d(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public PointF get(k kVar) {
            return null;
        }

        @Override // android.util.Property
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(k kVar, PointF pointF) {
            kVar.a(pointF);
        }
    }

    public static class e extends Property {
        public e(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public PointF get(View view) {
            return null;
        }

        @Override // android.util.Property
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(View view, PointF pointF) {
            c0.f(view, view.getLeft(), view.getTop(), Math.round(pointF.x), Math.round(pointF.y));
        }
    }

    public static class f extends Property {
        public f(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public PointF get(View view) {
            return null;
        }

        @Override // android.util.Property
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(View view, PointF pointF) {
            c0.f(view, Math.round(pointF.x), Math.round(pointF.y), view.getRight(), view.getBottom());
        }
    }

    public static class g extends Property {
        public g(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public PointF get(View view) {
            return null;
        }

        @Override // android.util.Property
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(View view, PointF pointF) {
            int round = Math.round(pointF.x);
            int round2 = Math.round(pointF.y);
            c0.f(view, round, round2, view.getWidth() + round, view.getHeight() + round2);
        }
    }

    public class h extends AnimatorListenerAdapter {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ k f3432a;
        private k mViewBounds;

        public h(k kVar) {
            this.f3432a = kVar;
            this.mViewBounds = kVar;
        }
    }

    public class i extends AnimatorListenerAdapter {

        /* renamed from: a, reason: collision with root package name */
        public boolean f3434a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ View f3435b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Rect f3436c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ int f3437d;

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ int f3438e;

        /* renamed from: f, reason: collision with root package name */
        public final /* synthetic */ int f3439f;

        /* renamed from: g, reason: collision with root package name */
        public final /* synthetic */ int f3440g;

        public i(View view, Rect rect, int i10, int i11, int i12, int i13) {
            this.f3435b = view;
            this.f3436c = rect;
            this.f3437d = i10;
            this.f3438e = i11;
            this.f3439f = i12;
            this.f3440g = i13;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.f3434a = true;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (this.f3434a) {
                return;
            }
            c1.r0(this.f3435b, this.f3436c);
            c0.f(this.f3435b, this.f3437d, this.f3438e, this.f3439f, this.f3440g);
        }
    }

    public class j extends o {

        /* renamed from: a, reason: collision with root package name */
        public boolean f3442a = false;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ViewGroup f3443b;

        public j(ViewGroup viewGroup) {
            this.f3443b = viewGroup;
        }

        @Override // androidx.transition.o, androidx.transition.n.g
        public void a(n nVar) {
            z.c(this.f3443b, true);
        }

        @Override // androidx.transition.o, androidx.transition.n.g
        public void c(n nVar) {
            z.c(this.f3443b, false);
        }

        @Override // androidx.transition.n.g
        public void d(n nVar) {
            if (!this.f3442a) {
                z.c(this.f3443b, false);
            }
            nVar.removeListener(this);
        }

        @Override // androidx.transition.o, androidx.transition.n.g
        public void e(n nVar) {
            z.c(this.f3443b, false);
            this.f3442a = true;
        }
    }

    public static class k {

        /* renamed from: a, reason: collision with root package name */
        public int f3445a;

        /* renamed from: b, reason: collision with root package name */
        public int f3446b;

        /* renamed from: c, reason: collision with root package name */
        public int f3447c;

        /* renamed from: d, reason: collision with root package name */
        public int f3448d;

        /* renamed from: e, reason: collision with root package name */
        public View f3449e;

        /* renamed from: f, reason: collision with root package name */
        public int f3450f;

        /* renamed from: g, reason: collision with root package name */
        public int f3451g;

        public k(View view) {
            this.f3449e = view;
        }

        public void a(PointF pointF) {
            this.f3447c = Math.round(pointF.x);
            this.f3448d = Math.round(pointF.y);
            int i10 = this.f3451g + 1;
            this.f3451g = i10;
            if (this.f3450f == i10) {
                b();
            }
        }

        public final void b() {
            c0.f(this.f3449e, this.f3445a, this.f3446b, this.f3447c, this.f3448d);
            this.f3450f = 0;
            this.f3451g = 0;
        }

        public void c(PointF pointF) {
            this.f3445a = Math.round(pointF.x);
            this.f3446b = Math.round(pointF.y);
            int i10 = this.f3450f + 1;
            this.f3450f = i10;
            if (i10 == this.f3451g) {
                b();
            }
        }
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
        View view = uVar.f3535b;
        if (!c1.Q(view) && view.getWidth() == 0 && view.getHeight() == 0) {
            return;
        }
        uVar.f3534a.put("android:changeBounds:bounds", new Rect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom()));
        uVar.f3534a.put("android:changeBounds:parent", uVar.f3535b.getParent());
        if (this.f3425c) {
            uVar.f3535b.getLocationInWindow(this.f3423a);
            uVar.f3534a.put("android:changeBounds:windowX", Integer.valueOf(this.f3423a[0]));
            uVar.f3534a.put("android:changeBounds:windowY", Integer.valueOf(this.f3423a[1]));
        }
        if (this.f3424b) {
            uVar.f3534a.put("android:changeBounds:clip", c1.s(view));
        }
    }

    @Override // androidx.transition.n
    public Animator createAnimator(ViewGroup viewGroup, u uVar, u uVar2) {
        int i10;
        View view;
        int i11;
        Rect rect;
        ObjectAnimator objectAnimator;
        Animator c10;
        if (uVar == null || uVar2 == null) {
            return null;
        }
        Map map = uVar.f3534a;
        Map map2 = uVar2.f3534a;
        ViewGroup viewGroup2 = (ViewGroup) map.get("android:changeBounds:parent");
        ViewGroup viewGroup3 = (ViewGroup) map2.get("android:changeBounds:parent");
        if (viewGroup2 == null || viewGroup3 == null) {
            return null;
        }
        View view2 = uVar2.f3535b;
        if (!r(viewGroup2, viewGroup3)) {
            int intValue = ((Integer) uVar.f3534a.get("android:changeBounds:windowX")).intValue();
            int intValue2 = ((Integer) uVar.f3534a.get("android:changeBounds:windowY")).intValue();
            int intValue3 = ((Integer) uVar2.f3534a.get("android:changeBounds:windowX")).intValue();
            int intValue4 = ((Integer) uVar2.f3534a.get("android:changeBounds:windowY")).intValue();
            if (intValue == intValue3 && intValue2 == intValue4) {
                return null;
            }
            viewGroup.getLocationInWindow(this.f3423a);
            Bitmap createBitmap = Bitmap.createBitmap(view2.getWidth(), view2.getHeight(), Bitmap.Config.ARGB_8888);
            view2.draw(new Canvas(createBitmap));
            BitmapDrawable bitmapDrawable = new BitmapDrawable(createBitmap);
            float c11 = c0.c(view2);
            c0.g(view2, 0.0f);
            c0.b(viewGroup).a(bitmapDrawable);
            androidx.transition.h pathMotion = getPathMotion();
            int[] iArr = this.f3423a;
            int i12 = iArr[0];
            int i13 = iArr[1];
            ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(bitmapDrawable, androidx.transition.k.a(f3416e, pathMotion.a(intValue - i12, intValue2 - i13, intValue3 - i12, intValue4 - i13)));
            ofPropertyValuesHolder.addListener(new a(viewGroup, bitmapDrawable, view2, c11));
            return ofPropertyValuesHolder;
        }
        Rect rect2 = (Rect) uVar.f3534a.get("android:changeBounds:bounds");
        Rect rect3 = (Rect) uVar2.f3534a.get("android:changeBounds:bounds");
        int i14 = rect2.left;
        int i15 = rect3.left;
        int i16 = rect2.top;
        int i17 = rect3.top;
        int i18 = rect2.right;
        int i19 = rect3.right;
        int i20 = rect2.bottom;
        int i21 = rect3.bottom;
        int i22 = i18 - i14;
        int i23 = i20 - i16;
        int i24 = i19 - i15;
        int i25 = i21 - i17;
        Rect rect4 = (Rect) uVar.f3534a.get("android:changeBounds:clip");
        Rect rect5 = (Rect) uVar2.f3534a.get("android:changeBounds:clip");
        if ((i22 == 0 || i23 == 0) && (i24 == 0 || i25 == 0)) {
            i10 = 0;
        } else {
            i10 = (i14 == i15 && i16 == i17) ? 0 : 1;
            if (i18 != i19 || i20 != i21) {
                i10++;
            }
        }
        if ((rect4 != null && !rect4.equals(rect5)) || (rect4 == null && rect5 != null)) {
            i10++;
        }
        if (i10 <= 0) {
            return null;
        }
        if (this.f3424b) {
            view = view2;
            c0.f(view, i14, i16, Math.max(i22, i24) + i14, Math.max(i23, i25) + i16);
            ObjectAnimator a10 = (i14 == i15 && i16 == i17) ? null : androidx.transition.g.a(view, f3421j, getPathMotion().a(i14, i16, i15, i17));
            if (rect4 == null) {
                i11 = 0;
                rect = new Rect(0, 0, i22, i23);
            } else {
                i11 = 0;
                rect = rect4;
            }
            Rect rect6 = rect5 == null ? new Rect(i11, i11, i24, i25) : rect5;
            if (rect.equals(rect6)) {
                objectAnimator = null;
            } else {
                c1.r0(view, rect);
                l lVar = f3422k;
                Object[] objArr = new Object[2];
                objArr[i11] = rect;
                objArr[1] = rect6;
                ObjectAnimator ofObject = ObjectAnimator.ofObject(view, "clipBounds", lVar, objArr);
                ofObject.addListener(new i(view, rect5, i15, i17, i19, i21));
                objectAnimator = ofObject;
            }
            c10 = t.c(a10, objectAnimator);
        } else {
            view = view2;
            c0.f(view, i14, i16, i18, i20);
            if (i10 != 2) {
                c10 = (i14 == i15 && i16 == i17) ? androidx.transition.g.a(view, f3419h, getPathMotion().a(i18, i20, i19, i21)) : androidx.transition.g.a(view, f3420i, getPathMotion().a(i14, i16, i15, i17));
            } else if (i22 == i24 && i23 == i25) {
                c10 = androidx.transition.g.a(view, f3421j, getPathMotion().a(i14, i16, i15, i17));
            } else {
                k kVar = new k(view);
                ObjectAnimator a11 = androidx.transition.g.a(kVar, f3417f, getPathMotion().a(i14, i16, i15, i17));
                ObjectAnimator a12 = androidx.transition.g.a(kVar, f3418g, getPathMotion().a(i18, i20, i19, i21));
                AnimatorSet animatorSet = new AnimatorSet();
                animatorSet.playTogether(a11, a12);
                animatorSet.addListener(new h(kVar));
                c10 = animatorSet;
            }
        }
        if (view.getParent() instanceof ViewGroup) {
            ViewGroup viewGroup4 = (ViewGroup) view.getParent();
            z.c(viewGroup4, true);
            addListener(new j(viewGroup4));
        }
        return c10;
    }

    @Override // androidx.transition.n
    public String[] getTransitionProperties() {
        return f3415d;
    }

    public final boolean r(View view, View view2) {
        if (!this.f3425c) {
            return true;
        }
        u matchedTransitionValues = getMatchedTransitionValues(view, true);
        if (matchedTransitionValues == null) {
            if (view == view2) {
                return true;
            }
        } else if (view2 == matchedTransitionValues.f3535b) {
            return true;
        }
        return false;
    }
}
