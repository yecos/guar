package e;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.SystemClock;
import android.util.SparseArray;

/* loaded from: classes.dex */
public abstract class h extends Drawable implements Drawable.Callback {

    /* renamed from: a, reason: collision with root package name */
    public c f12788a;

    /* renamed from: b, reason: collision with root package name */
    public Rect f12789b;

    /* renamed from: c, reason: collision with root package name */
    public Drawable f12790c;

    /* renamed from: d, reason: collision with root package name */
    public Drawable f12791d;

    /* renamed from: f, reason: collision with root package name */
    public boolean f12793f;

    /* renamed from: i, reason: collision with root package name */
    public boolean f12796i;

    /* renamed from: j, reason: collision with root package name */
    public Runnable f12797j;

    /* renamed from: k, reason: collision with root package name */
    public long f12798k;

    /* renamed from: l, reason: collision with root package name */
    public long f12799l;

    /* renamed from: m, reason: collision with root package name */
    public b f12800m;

    /* renamed from: e, reason: collision with root package name */
    public int f12792e = 255;

    /* renamed from: g, reason: collision with root package name */
    public int f12794g = -1;

    /* renamed from: h, reason: collision with root package name */
    public int f12795h = -1;

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            h.this.a(true);
            h.this.invalidateSelf();
        }
    }

    public static class b implements Drawable.Callback {

        /* renamed from: a, reason: collision with root package name */
        public Drawable.Callback f12802a;

        public Drawable.Callback a() {
            Drawable.Callback callback = this.f12802a;
            this.f12802a = null;
            return callback;
        }

        public b b(Drawable.Callback callback) {
            this.f12802a = callback;
            return this;
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void invalidateDrawable(Drawable drawable) {
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void scheduleDrawable(Drawable drawable, Runnable runnable, long j10) {
            Drawable.Callback callback = this.f12802a;
            if (callback != null) {
                callback.scheduleDrawable(drawable, runnable, j10);
            }
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
            Drawable.Callback callback = this.f12802a;
            if (callback != null) {
                callback.unscheduleDrawable(drawable, runnable);
            }
        }
    }

    public static abstract class c extends Drawable.ConstantState {
        public int A;
        public int B;
        public boolean C;
        public ColorFilter D;
        public boolean E;
        public ColorStateList F;
        public PorterDuff.Mode G;
        public boolean H;
        public boolean I;

        /* renamed from: a, reason: collision with root package name */
        public final h f12803a;

        /* renamed from: b, reason: collision with root package name */
        public Resources f12804b;

        /* renamed from: c, reason: collision with root package name */
        public int f12805c;

        /* renamed from: d, reason: collision with root package name */
        public int f12806d;

        /* renamed from: e, reason: collision with root package name */
        public int f12807e;

        /* renamed from: f, reason: collision with root package name */
        public SparseArray f12808f;

        /* renamed from: g, reason: collision with root package name */
        public Drawable[] f12809g;

        /* renamed from: h, reason: collision with root package name */
        public int f12810h;

        /* renamed from: i, reason: collision with root package name */
        public boolean f12811i;

        /* renamed from: j, reason: collision with root package name */
        public boolean f12812j;

        /* renamed from: k, reason: collision with root package name */
        public Rect f12813k;

        /* renamed from: l, reason: collision with root package name */
        public boolean f12814l;

        /* renamed from: m, reason: collision with root package name */
        public boolean f12815m;

        /* renamed from: n, reason: collision with root package name */
        public int f12816n;

        /* renamed from: o, reason: collision with root package name */
        public int f12817o;

        /* renamed from: p, reason: collision with root package name */
        public int f12818p;

        /* renamed from: q, reason: collision with root package name */
        public int f12819q;

        /* renamed from: r, reason: collision with root package name */
        public boolean f12820r;

        /* renamed from: s, reason: collision with root package name */
        public int f12821s;

        /* renamed from: t, reason: collision with root package name */
        public boolean f12822t;

        /* renamed from: u, reason: collision with root package name */
        public boolean f12823u;

        /* renamed from: v, reason: collision with root package name */
        public boolean f12824v;

        /* renamed from: w, reason: collision with root package name */
        public boolean f12825w;

        /* renamed from: x, reason: collision with root package name */
        public boolean f12826x;

        /* renamed from: y, reason: collision with root package name */
        public boolean f12827y;

        /* renamed from: z, reason: collision with root package name */
        public int f12828z;

        public c(c cVar, h hVar, Resources resources) {
            this.f12805c = 160;
            this.f12811i = false;
            this.f12814l = false;
            this.f12826x = true;
            this.A = 0;
            this.B = 0;
            this.f12803a = hVar;
            this.f12804b = resources != null ? resources : cVar != null ? cVar.f12804b : null;
            int f10 = h.f(resources, cVar != null ? cVar.f12805c : 0);
            this.f12805c = f10;
            if (cVar == null) {
                this.f12809g = new Drawable[10];
                this.f12810h = 0;
                return;
            }
            this.f12806d = cVar.f12806d;
            this.f12807e = cVar.f12807e;
            this.f12824v = true;
            this.f12825w = true;
            this.f12811i = cVar.f12811i;
            this.f12814l = cVar.f12814l;
            this.f12826x = cVar.f12826x;
            this.f12827y = cVar.f12827y;
            this.f12828z = cVar.f12828z;
            this.A = cVar.A;
            this.B = cVar.B;
            this.C = cVar.C;
            this.D = cVar.D;
            this.E = cVar.E;
            this.F = cVar.F;
            this.G = cVar.G;
            this.H = cVar.H;
            this.I = cVar.I;
            if (cVar.f12805c == f10) {
                if (cVar.f12812j) {
                    this.f12813k = new Rect(cVar.f12813k);
                    this.f12812j = true;
                }
                if (cVar.f12815m) {
                    this.f12816n = cVar.f12816n;
                    this.f12817o = cVar.f12817o;
                    this.f12818p = cVar.f12818p;
                    this.f12819q = cVar.f12819q;
                    this.f12815m = true;
                }
            }
            if (cVar.f12820r) {
                this.f12821s = cVar.f12821s;
                this.f12820r = true;
            }
            if (cVar.f12822t) {
                this.f12823u = cVar.f12823u;
                this.f12822t = true;
            }
            Drawable[] drawableArr = cVar.f12809g;
            this.f12809g = new Drawable[drawableArr.length];
            this.f12810h = cVar.f12810h;
            SparseArray sparseArray = cVar.f12808f;
            if (sparseArray != null) {
                this.f12808f = sparseArray.clone();
            } else {
                this.f12808f = new SparseArray(this.f12810h);
            }
            int i10 = this.f12810h;
            for (int i11 = 0; i11 < i10; i11++) {
                Drawable drawable = drawableArr[i11];
                if (drawable != null) {
                    Drawable.ConstantState constantState = drawable.getConstantState();
                    if (constantState != null) {
                        this.f12808f.put(i11, constantState);
                    } else {
                        this.f12809g[i11] = drawableArr[i11];
                    }
                }
            }
        }

        public final int a(Drawable drawable) {
            int i10 = this.f12810h;
            if (i10 >= this.f12809g.length) {
                o(i10, i10 + 10);
            }
            drawable.mutate();
            drawable.setVisible(false, true);
            drawable.setCallback(this.f12803a);
            this.f12809g[i10] = drawable;
            this.f12810h++;
            this.f12807e = drawable.getChangingConfigurations() | this.f12807e;
            p();
            this.f12813k = null;
            this.f12812j = false;
            this.f12815m = false;
            this.f12824v = false;
            return i10;
        }

        public final void b(Resources.Theme theme) {
            Resources resources;
            boolean canApplyTheme;
            if (theme != null) {
                e();
                int i10 = this.f12810h;
                Drawable[] drawableArr = this.f12809g;
                for (int i11 = 0; i11 < i10; i11++) {
                    Drawable drawable = drawableArr[i11];
                    if (drawable != null) {
                        canApplyTheme = drawable.canApplyTheme();
                        if (canApplyTheme) {
                            drawableArr[i11].applyTheme(theme);
                            this.f12807e |= drawableArr[i11].getChangingConfigurations();
                        }
                    }
                }
                resources = theme.getResources();
                y(resources);
            }
        }

        public synchronized boolean c() {
            if (this.f12824v) {
                return this.f12825w;
            }
            e();
            this.f12824v = true;
            int i10 = this.f12810h;
            Drawable[] drawableArr = this.f12809g;
            for (int i11 = 0; i11 < i10; i11++) {
                if (drawableArr[i11].getConstantState() == null) {
                    this.f12825w = false;
                    return false;
                }
            }
            this.f12825w = true;
            return true;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public boolean canApplyTheme() {
            boolean canApplyTheme;
            boolean canApplyTheme2;
            int i10 = this.f12810h;
            Drawable[] drawableArr = this.f12809g;
            for (int i11 = 0; i11 < i10; i11++) {
                Drawable drawable = drawableArr[i11];
                if (drawable != null) {
                    canApplyTheme2 = drawable.canApplyTheme();
                    if (canApplyTheme2) {
                        return true;
                    }
                } else {
                    Drawable.ConstantState constantState = (Drawable.ConstantState) this.f12808f.get(i11);
                    if (constantState != null) {
                        canApplyTheme = constantState.canApplyTheme();
                        if (canApplyTheme) {
                            return true;
                        }
                    } else {
                        continue;
                    }
                }
            }
            return false;
        }

        public void d() {
            this.f12815m = true;
            e();
            int i10 = this.f12810h;
            Drawable[] drawableArr = this.f12809g;
            this.f12817o = -1;
            this.f12816n = -1;
            this.f12819q = 0;
            this.f12818p = 0;
            for (int i11 = 0; i11 < i10; i11++) {
                Drawable drawable = drawableArr[i11];
                int intrinsicWidth = drawable.getIntrinsicWidth();
                if (intrinsicWidth > this.f12816n) {
                    this.f12816n = intrinsicWidth;
                }
                int intrinsicHeight = drawable.getIntrinsicHeight();
                if (intrinsicHeight > this.f12817o) {
                    this.f12817o = intrinsicHeight;
                }
                int minimumWidth = drawable.getMinimumWidth();
                if (minimumWidth > this.f12818p) {
                    this.f12818p = minimumWidth;
                }
                int minimumHeight = drawable.getMinimumHeight();
                if (minimumHeight > this.f12819q) {
                    this.f12819q = minimumHeight;
                }
            }
        }

        public final void e() {
            SparseArray sparseArray = this.f12808f;
            if (sparseArray != null) {
                int size = sparseArray.size();
                for (int i10 = 0; i10 < size; i10++) {
                    this.f12809g[this.f12808f.keyAt(i10)] = s(((Drawable.ConstantState) this.f12808f.valueAt(i10)).newDrawable(this.f12804b));
                }
                this.f12808f = null;
            }
        }

        public final int f() {
            return this.f12809g.length;
        }

        public final Drawable g(int i10) {
            int indexOfKey;
            Drawable drawable = this.f12809g[i10];
            if (drawable != null) {
                return drawable;
            }
            SparseArray sparseArray = this.f12808f;
            if (sparseArray == null || (indexOfKey = sparseArray.indexOfKey(i10)) < 0) {
                return null;
            }
            Drawable s10 = s(((Drawable.ConstantState) this.f12808f.valueAt(indexOfKey)).newDrawable(this.f12804b));
            this.f12809g[i10] = s10;
            this.f12808f.removeAt(indexOfKey);
            if (this.f12808f.size() == 0) {
                this.f12808f = null;
            }
            return s10;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return this.f12806d | this.f12807e;
        }

        public final int h() {
            return this.f12810h;
        }

        public final int i() {
            if (!this.f12815m) {
                d();
            }
            return this.f12817o;
        }

        public final int j() {
            if (!this.f12815m) {
                d();
            }
            return this.f12819q;
        }

        public final int k() {
            if (!this.f12815m) {
                d();
            }
            return this.f12818p;
        }

        public final Rect l() {
            Rect rect = null;
            if (this.f12811i) {
                return null;
            }
            Rect rect2 = this.f12813k;
            if (rect2 != null || this.f12812j) {
                return rect2;
            }
            e();
            Rect rect3 = new Rect();
            int i10 = this.f12810h;
            Drawable[] drawableArr = this.f12809g;
            for (int i11 = 0; i11 < i10; i11++) {
                if (drawableArr[i11].getPadding(rect3)) {
                    if (rect == null) {
                        rect = new Rect(0, 0, 0, 0);
                    }
                    int i12 = rect3.left;
                    if (i12 > rect.left) {
                        rect.left = i12;
                    }
                    int i13 = rect3.top;
                    if (i13 > rect.top) {
                        rect.top = i13;
                    }
                    int i14 = rect3.right;
                    if (i14 > rect.right) {
                        rect.right = i14;
                    }
                    int i15 = rect3.bottom;
                    if (i15 > rect.bottom) {
                        rect.bottom = i15;
                    }
                }
            }
            this.f12812j = true;
            this.f12813k = rect;
            return rect;
        }

        public final int m() {
            if (!this.f12815m) {
                d();
            }
            return this.f12816n;
        }

        public final int n() {
            if (this.f12820r) {
                return this.f12821s;
            }
            e();
            int i10 = this.f12810h;
            Drawable[] drawableArr = this.f12809g;
            int opacity = i10 > 0 ? drawableArr[0].getOpacity() : -2;
            for (int i11 = 1; i11 < i10; i11++) {
                opacity = Drawable.resolveOpacity(opacity, drawableArr[i11].getOpacity());
            }
            this.f12821s = opacity;
            this.f12820r = true;
            return opacity;
        }

        public void o(int i10, int i11) {
            Drawable[] drawableArr = new Drawable[i11];
            System.arraycopy(this.f12809g, 0, drawableArr, 0, i10);
            this.f12809g = drawableArr;
        }

        public void p() {
            this.f12820r = false;
            this.f12822t = false;
        }

        public final boolean q() {
            return this.f12814l;
        }

        public abstract void r();

        public final Drawable s(Drawable drawable) {
            if (Build.VERSION.SDK_INT >= 23) {
                drawable.setLayoutDirection(this.f12828z);
            }
            Drawable mutate = drawable.mutate();
            mutate.setCallback(this.f12803a);
            return mutate;
        }

        public final void t(boolean z10) {
            this.f12814l = z10;
        }

        public final void u(int i10) {
            this.A = i10;
        }

        public final void v(int i10) {
            this.B = i10;
        }

        public final boolean w(int i10, int i11) {
            int i12 = this.f12810h;
            Drawable[] drawableArr = this.f12809g;
            boolean z10 = false;
            for (int i13 = 0; i13 < i12; i13++) {
                Drawable drawable = drawableArr[i13];
                if (drawable != null) {
                    boolean layoutDirection = Build.VERSION.SDK_INT >= 23 ? drawable.setLayoutDirection(i10) : false;
                    if (i13 == i11) {
                        z10 = layoutDirection;
                    }
                }
            }
            this.f12828z = i10;
            return z10;
        }

        public final void x(boolean z10) {
            this.f12811i = z10;
        }

        public final void y(Resources resources) {
            if (resources != null) {
                this.f12804b = resources;
                int f10 = h.f(resources, this.f12805c);
                int i10 = this.f12805c;
                this.f12805c = f10;
                if (i10 != f10) {
                    this.f12815m = false;
                    this.f12812j = false;
                }
            }
        }
    }

    public static int f(Resources resources, int i10) {
        if (resources != null) {
            i10 = resources.getDisplayMetrics().densityDpi;
        }
        if (i10 == 0) {
            return 160;
        }
        return i10;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x003f  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x006d A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:23:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0068  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(boolean z10) {
        boolean z11;
        Drawable drawable;
        boolean z12 = true;
        this.f12793f = true;
        long uptimeMillis = SystemClock.uptimeMillis();
        Drawable drawable2 = this.f12790c;
        if (drawable2 != null) {
            long j10 = this.f12798k;
            if (j10 != 0) {
                if (j10 > uptimeMillis) {
                    drawable2.setAlpha(((255 - (((int) ((j10 - uptimeMillis) * 255)) / this.f12788a.A)) * this.f12792e) / 255);
                    z11 = true;
                    drawable = this.f12791d;
                    if (drawable == null) {
                        long j11 = this.f12799l;
                        if (j11 != 0) {
                            if (j11 > uptimeMillis) {
                                drawable.setAlpha(((((int) ((j11 - uptimeMillis) * 255)) / this.f12788a.B) * this.f12792e) / 255);
                                if (z10 && z12) {
                                    scheduleSelf(this.f12797j, uptimeMillis + 16);
                                    return;
                                }
                                return;
                            }
                            drawable.setVisible(false, false);
                            this.f12791d = null;
                            this.f12795h = -1;
                            this.f12799l = 0L;
                        }
                    } else {
                        this.f12799l = 0L;
                    }
                    z12 = z11;
                    if (z10) {
                        return;
                    } else {
                        return;
                    }
                }
                drawable2.setAlpha(this.f12792e);
                this.f12798k = 0L;
            }
        } else {
            this.f12798k = 0L;
        }
        z11 = false;
        drawable = this.f12791d;
        if (drawable == null) {
        }
        z12 = z11;
        if (z10) {
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void applyTheme(Resources.Theme theme) {
        this.f12788a.b(theme);
    }

    public abstract c b();

    public int c() {
        return this.f12794g;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean canApplyTheme() {
        return this.f12788a.canApplyTheme();
    }

    public final void d(Drawable drawable) {
        int layoutDirection;
        if (this.f12800m == null) {
            this.f12800m = new b();
        }
        drawable.setCallback(this.f12800m.b(drawable.getCallback()));
        try {
            if (this.f12788a.A <= 0 && this.f12793f) {
                drawable.setAlpha(this.f12792e);
            }
            c cVar = this.f12788a;
            if (cVar.E) {
                drawable.setColorFilter(cVar.D);
            } else {
                if (cVar.H) {
                    s.h.o(drawable, cVar.F);
                }
                c cVar2 = this.f12788a;
                if (cVar2.I) {
                    s.h.p(drawable, cVar2.G);
                }
            }
            drawable.setVisible(isVisible(), true);
            drawable.setDither(this.f12788a.f12826x);
            drawable.setState(getState());
            drawable.setLevel(getLevel());
            drawable.setBounds(getBounds());
            int i10 = Build.VERSION.SDK_INT;
            if (i10 >= 23) {
                layoutDirection = getLayoutDirection();
                drawable.setLayoutDirection(layoutDirection);
            }
            drawable.setAutoMirrored(this.f12788a.C);
            Rect rect = this.f12789b;
            if (i10 >= 21 && rect != null) {
                drawable.setHotspotBounds(rect.left, rect.top, rect.right, rect.bottom);
            }
        } finally {
            drawable.setCallback(this.f12800m.a());
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Drawable drawable = this.f12790c;
        if (drawable != null) {
            drawable.draw(canvas);
        }
        Drawable drawable2 = this.f12791d;
        if (drawable2 != null) {
            drawable2.draw(canvas);
        }
    }

    public final boolean e() {
        return isAutoMirrored() && s.h.f(this) == 1;
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0079  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean g(int i10) {
        Runnable runnable;
        if (i10 == this.f12794g) {
            return false;
        }
        long uptimeMillis = SystemClock.uptimeMillis();
        if (this.f12788a.B > 0) {
            Drawable drawable = this.f12791d;
            if (drawable != null) {
                drawable.setVisible(false, false);
            }
            Drawable drawable2 = this.f12790c;
            if (drawable2 != null) {
                this.f12791d = drawable2;
                this.f12795h = this.f12794g;
                this.f12799l = this.f12788a.B + uptimeMillis;
            } else {
                this.f12791d = null;
                this.f12795h = -1;
                this.f12799l = 0L;
            }
        } else {
            Drawable drawable3 = this.f12790c;
            if (drawable3 != null) {
                drawable3.setVisible(false, false);
            }
        }
        if (i10 >= 0) {
            c cVar = this.f12788a;
            if (i10 < cVar.f12810h) {
                Drawable g10 = cVar.g(i10);
                this.f12790c = g10;
                this.f12794g = i10;
                if (g10 != null) {
                    int i11 = this.f12788a.A;
                    if (i11 > 0) {
                        this.f12798k = uptimeMillis + i11;
                    }
                    d(g10);
                }
                if (this.f12798k == 0 || this.f12799l != 0) {
                    runnable = this.f12797j;
                    if (runnable != null) {
                        this.f12797j = new a();
                    } else {
                        unscheduleSelf(runnable);
                    }
                    a(true);
                }
                invalidateSelf();
                return true;
            }
        }
        this.f12790c = null;
        this.f12794g = -1;
        if (this.f12798k == 0) {
        }
        runnable = this.f12797j;
        if (runnable != null) {
        }
        a(true);
        invalidateSelf();
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.f12792e;
    }

    @Override // android.graphics.drawable.Drawable
    public int getChangingConfigurations() {
        return super.getChangingConfigurations() | this.f12788a.getChangingConfigurations();
    }

    @Override // android.graphics.drawable.Drawable
    public final Drawable.ConstantState getConstantState() {
        if (!this.f12788a.c()) {
            return null;
        }
        this.f12788a.f12806d = getChangingConfigurations();
        return this.f12788a;
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable getCurrent() {
        return this.f12790c;
    }

    @Override // android.graphics.drawable.Drawable
    public void getHotspotBounds(Rect rect) {
        Rect rect2 = this.f12789b;
        if (rect2 != null) {
            rect.set(rect2);
        } else {
            super.getHotspotBounds(rect);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        if (this.f12788a.q()) {
            return this.f12788a.i();
        }
        Drawable drawable = this.f12790c;
        if (drawable != null) {
            return drawable.getIntrinsicHeight();
        }
        return -1;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        if (this.f12788a.q()) {
            return this.f12788a.m();
        }
        Drawable drawable = this.f12790c;
        if (drawable != null) {
            return drawable.getIntrinsicWidth();
        }
        return -1;
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumHeight() {
        if (this.f12788a.q()) {
            return this.f12788a.j();
        }
        Drawable drawable = this.f12790c;
        if (drawable != null) {
            return drawable.getMinimumHeight();
        }
        return 0;
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumWidth() {
        if (this.f12788a.q()) {
            return this.f12788a.k();
        }
        Drawable drawable = this.f12790c;
        if (drawable != null) {
            return drawable.getMinimumWidth();
        }
        return 0;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        Drawable drawable = this.f12790c;
        if (drawable == null || !drawable.isVisible()) {
            return -2;
        }
        return this.f12788a.n();
    }

    @Override // android.graphics.drawable.Drawable
    public void getOutline(Outline outline) {
        Drawable drawable = this.f12790c;
        if (drawable != null) {
            drawable.getOutline(outline);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean getPadding(Rect rect) {
        boolean padding;
        Rect l10 = this.f12788a.l();
        if (l10 != null) {
            rect.set(l10);
            padding = (l10.right | ((l10.left | l10.top) | l10.bottom)) != 0;
        } else {
            Drawable drawable = this.f12790c;
            padding = drawable != null ? drawable.getPadding(rect) : super.getPadding(rect);
        }
        if (e()) {
            int i10 = rect.left;
            rect.left = rect.right;
            rect.right = i10;
        }
        return padding;
    }

    public void h(c cVar) {
        this.f12788a = cVar;
        int i10 = this.f12794g;
        if (i10 >= 0) {
            Drawable g10 = cVar.g(i10);
            this.f12790c = g10;
            if (g10 != null) {
                d(g10);
            }
        }
        this.f12795h = -1;
        this.f12791d = null;
    }

    public final void i(Resources resources) {
        this.f12788a.y(resources);
    }

    public void invalidateDrawable(Drawable drawable) {
        c cVar = this.f12788a;
        if (cVar != null) {
            cVar.p();
        }
        if (drawable != this.f12790c || getCallback() == null) {
            return;
        }
        getCallback().invalidateDrawable(this);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isAutoMirrored() {
        return this.f12788a.C;
    }

    @Override // android.graphics.drawable.Drawable
    public void jumpToCurrentState() {
        boolean z10;
        Drawable drawable = this.f12791d;
        boolean z11 = true;
        if (drawable != null) {
            drawable.jumpToCurrentState();
            this.f12791d = null;
            this.f12795h = -1;
            z10 = true;
        } else {
            z10 = false;
        }
        Drawable drawable2 = this.f12790c;
        if (drawable2 != null) {
            drawable2.jumpToCurrentState();
            if (this.f12793f) {
                this.f12790c.setAlpha(this.f12792e);
            }
        }
        if (this.f12799l != 0) {
            this.f12799l = 0L;
            z10 = true;
        }
        if (this.f12798k != 0) {
            this.f12798k = 0L;
        } else {
            z11 = z10;
        }
        if (z11) {
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        if (!this.f12796i && super.mutate() == this) {
            c b10 = b();
            b10.r();
            h(b10);
            this.f12796i = true;
        }
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        Drawable drawable = this.f12791d;
        if (drawable != null) {
            drawable.setBounds(rect);
        }
        Drawable drawable2 = this.f12790c;
        if (drawable2 != null) {
            drawable2.setBounds(rect);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onLayoutDirectionChanged(int i10) {
        return this.f12788a.w(i10, c());
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onLevelChange(int i10) {
        Drawable drawable = this.f12791d;
        if (drawable != null) {
            return drawable.setLevel(i10);
        }
        Drawable drawable2 = this.f12790c;
        if (drawable2 != null) {
            return drawable2.setLevel(i10);
        }
        return false;
    }

    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j10) {
        if (drawable != this.f12790c || getCallback() == null) {
            return;
        }
        getCallback().scheduleDrawable(this, runnable, j10);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i10) {
        if (this.f12793f && this.f12792e == i10) {
            return;
        }
        this.f12793f = true;
        this.f12792e = i10;
        Drawable drawable = this.f12790c;
        if (drawable != null) {
            if (this.f12798k == 0) {
                drawable.setAlpha(i10);
            } else {
                a(false);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAutoMirrored(boolean z10) {
        c cVar = this.f12788a;
        if (cVar.C != z10) {
            cVar.C = z10;
            Drawable drawable = this.f12790c;
            if (drawable != null) {
                s.h.j(drawable, z10);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        c cVar = this.f12788a;
        cVar.E = true;
        if (cVar.D != colorFilter) {
            cVar.D = colorFilter;
            Drawable drawable = this.f12790c;
            if (drawable != null) {
                drawable.setColorFilter(colorFilter);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setDither(boolean z10) {
        c cVar = this.f12788a;
        if (cVar.f12826x != z10) {
            cVar.f12826x = z10;
            Drawable drawable = this.f12790c;
            if (drawable != null) {
                drawable.setDither(z10);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setHotspot(float f10, float f11) {
        Drawable drawable = this.f12790c;
        if (drawable != null) {
            s.h.k(drawable, f10, f11);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setHotspotBounds(int i10, int i11, int i12, int i13) {
        Rect rect = this.f12789b;
        if (rect == null) {
            this.f12789b = new Rect(i10, i11, i12, i13);
        } else {
            rect.set(i10, i11, i12, i13);
        }
        Drawable drawable = this.f12790c;
        if (drawable != null) {
            s.h.l(drawable, i10, i11, i12, i13);
        }
    }

    @Override // android.graphics.drawable.Drawable, s.w
    public void setTintList(ColorStateList colorStateList) {
        c cVar = this.f12788a;
        cVar.H = true;
        if (cVar.F != colorStateList) {
            cVar.F = colorStateList;
            s.h.o(this.f12790c, colorStateList);
        }
    }

    @Override // android.graphics.drawable.Drawable, s.w
    public void setTintMode(PorterDuff.Mode mode) {
        c cVar = this.f12788a;
        cVar.I = true;
        if (cVar.G != mode) {
            cVar.G = mode;
            s.h.p(this.f12790c, mode);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z10, boolean z11) {
        boolean visible = super.setVisible(z10, z11);
        Drawable drawable = this.f12791d;
        if (drawable != null) {
            drawable.setVisible(z10, z11);
        }
        Drawable drawable2 = this.f12790c;
        if (drawable2 != null) {
            drawable2.setVisible(z10, z11);
        }
        return visible;
    }

    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        if (drawable != this.f12790c || getCallback() == null) {
            return;
        }
        getCallback().unscheduleDrawable(this, runnable);
    }
}
