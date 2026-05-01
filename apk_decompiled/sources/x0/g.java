package x0;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;

/* loaded from: classes.dex */
public class g extends m implements Animatable {

    /* renamed from: b, reason: collision with root package name */
    public b f19302b;

    /* renamed from: c, reason: collision with root package name */
    public Context f19303c;

    /* renamed from: d, reason: collision with root package name */
    public ArgbEvaluator f19304d;

    /* renamed from: e, reason: collision with root package name */
    public Animator.AnimatorListener f19305e;

    /* renamed from: f, reason: collision with root package name */
    public ArrayList f19306f;

    /* renamed from: g, reason: collision with root package name */
    public final Drawable.Callback f19307g;

    public class a implements Drawable.Callback {
        public a() {
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void invalidateDrawable(Drawable drawable) {
            g.this.invalidateSelf();
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void scheduleDrawable(Drawable drawable, Runnable runnable, long j10) {
            g.this.scheduleSelf(runnable, j10);
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
            g.this.unscheduleSelf(runnable);
        }
    }

    public static class b extends Drawable.ConstantState {

        /* renamed from: a, reason: collision with root package name */
        public int f19309a;

        /* renamed from: b, reason: collision with root package name */
        public n f19310b;

        /* renamed from: c, reason: collision with root package name */
        public AnimatorSet f19311c;

        /* renamed from: d, reason: collision with root package name */
        public ArrayList f19312d;

        /* renamed from: e, reason: collision with root package name */
        public androidx.collection.a f19313e;

        public b(Context context, b bVar, Drawable.Callback callback, Resources resources) {
            if (bVar != null) {
                this.f19309a = bVar.f19309a;
                n nVar = bVar.f19310b;
                if (nVar != null) {
                    Drawable.ConstantState constantState = nVar.getConstantState();
                    if (resources != null) {
                        this.f19310b = (n) constantState.newDrawable(resources);
                    } else {
                        this.f19310b = (n) constantState.newDrawable();
                    }
                    n nVar2 = (n) this.f19310b.mutate();
                    this.f19310b = nVar2;
                    nVar2.setCallback(callback);
                    this.f19310b.setBounds(bVar.f19310b.getBounds());
                    this.f19310b.h(false);
                }
                ArrayList arrayList = bVar.f19312d;
                if (arrayList != null) {
                    int size = arrayList.size();
                    this.f19312d = new ArrayList(size);
                    this.f19313e = new androidx.collection.a(size);
                    for (int i10 = 0; i10 < size; i10++) {
                        Animator animator = (Animator) bVar.f19312d.get(i10);
                        Animator clone = animator.clone();
                        String str = (String) bVar.f19313e.get(animator);
                        clone.setTarget(this.f19310b.d(str));
                        this.f19312d.add(clone);
                        this.f19313e.put(clone, str);
                    }
                    a();
                }
            }
        }

        public void a() {
            if (this.f19311c == null) {
                this.f19311c = new AnimatorSet();
            }
            this.f19311c.playTogether(this.f19312d);
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return this.f19309a;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            throw new IllegalStateException("No constant state support for SDK < 24.");
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            throw new IllegalStateException("No constant state support for SDK < 24.");
        }
    }

    public g() {
        this(null, null, null);
    }

    public static g a(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        g gVar = new g(context);
        gVar.inflate(resources, xmlPullParser, attributeSet, theme);
        return gVar;
    }

    @Override // x0.m, android.graphics.drawable.Drawable
    public void applyTheme(Resources.Theme theme) {
        Drawable drawable = this.f19319a;
        if (drawable != null) {
            s.h.a(drawable, theme);
        }
    }

    public final void b(String str, Animator animator) {
        animator.setTarget(this.f19302b.f19310b.d(str));
        if (Build.VERSION.SDK_INT < 21) {
            c(animator);
        }
        b bVar = this.f19302b;
        if (bVar.f19312d == null) {
            bVar.f19312d = new ArrayList();
            this.f19302b.f19313e = new androidx.collection.a();
        }
        this.f19302b.f19312d.add(animator);
        this.f19302b.f19313e.put(animator, str);
    }

    public final void c(Animator animator) {
        ArrayList<Animator> childAnimations;
        if ((animator instanceof AnimatorSet) && (childAnimations = ((AnimatorSet) animator).getChildAnimations()) != null) {
            for (int i10 = 0; i10 < childAnimations.size(); i10++) {
                c(childAnimations.get(i10));
            }
        }
        if (animator instanceof ObjectAnimator) {
            ObjectAnimator objectAnimator = (ObjectAnimator) animator;
            String propertyName = objectAnimator.getPropertyName();
            if ("fillColor".equals(propertyName) || "strokeColor".equals(propertyName)) {
                if (this.f19304d == null) {
                    this.f19304d = new ArgbEvaluator();
                }
                objectAnimator.setEvaluator(this.f19304d);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean canApplyTheme() {
        Drawable drawable = this.f19319a;
        if (drawable != null) {
            return s.h.b(drawable);
        }
        return false;
    }

    @Override // x0.m, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void clearColorFilter() {
        super.clearColorFilter();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Drawable drawable = this.f19319a;
        if (drawable != null) {
            drawable.draw(canvas);
            return;
        }
        this.f19302b.f19310b.draw(canvas);
        if (this.f19302b.f19311c.isStarted()) {
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        Drawable drawable = this.f19319a;
        return drawable != null ? s.h.d(drawable) : this.f19302b.f19310b.getAlpha();
    }

    @Override // android.graphics.drawable.Drawable
    public int getChangingConfigurations() {
        Drawable drawable = this.f19319a;
        return drawable != null ? drawable.getChangingConfigurations() : super.getChangingConfigurations() | this.f19302b.f19309a;
    }

    @Override // android.graphics.drawable.Drawable
    public ColorFilter getColorFilter() {
        Drawable drawable = this.f19319a;
        return drawable != null ? s.h.e(drawable) : this.f19302b.f19310b.getColorFilter();
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        if (this.f19319a == null || Build.VERSION.SDK_INT < 24) {
            return null;
        }
        return new c(this.f19319a.getConstantState());
    }

    @Override // x0.m, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ Drawable getCurrent() {
        return super.getCurrent();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        Drawable drawable = this.f19319a;
        return drawable != null ? drawable.getIntrinsicHeight() : this.f19302b.f19310b.getIntrinsicHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        Drawable drawable = this.f19319a;
        return drawable != null ? drawable.getIntrinsicWidth() : this.f19302b.f19310b.getIntrinsicWidth();
    }

    @Override // x0.m, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getMinimumHeight() {
        return super.getMinimumHeight();
    }

    @Override // x0.m, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getMinimumWidth() {
        return super.getMinimumWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        Drawable drawable = this.f19319a;
        return drawable != null ? drawable.getOpacity() : this.f19302b.f19310b.getOpacity();
    }

    @Override // x0.m, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ boolean getPadding(Rect rect) {
        return super.getPadding(rect);
    }

    @Override // x0.m, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int[] getState() {
        return super.getState();
    }

    @Override // x0.m, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ Region getTransparentRegion() {
        return super.getTransparentRegion();
    }

    @Override // android.graphics.drawable.Drawable
    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        Drawable drawable = this.f19319a;
        if (drawable != null) {
            s.h.g(drawable, resources, xmlPullParser, attributeSet, theme);
            return;
        }
        int eventType = xmlPullParser.getEventType();
        int depth = xmlPullParser.getDepth() + 1;
        while (eventType != 1 && (xmlPullParser.getDepth() >= depth || eventType != 3)) {
            if (eventType == 2) {
                String name = xmlPullParser.getName();
                if ("animated-vector".equals(name)) {
                    TypedArray k10 = q.i.k(resources, theme, attributeSet, x0.a.f19294e);
                    int resourceId = k10.getResourceId(0, 0);
                    if (resourceId != 0) {
                        n b10 = n.b(resources, resourceId, theme);
                        b10.h(false);
                        b10.setCallback(this.f19307g);
                        n nVar = this.f19302b.f19310b;
                        if (nVar != null) {
                            nVar.setCallback(null);
                        }
                        this.f19302b.f19310b = b10;
                    }
                    k10.recycle();
                } else if ("target".equals(name)) {
                    TypedArray obtainAttributes = resources.obtainAttributes(attributeSet, x0.a.f19295f);
                    String string = obtainAttributes.getString(0);
                    int resourceId2 = obtainAttributes.getResourceId(1, 0);
                    if (resourceId2 != 0) {
                        Context context = this.f19303c;
                        if (context == null) {
                            obtainAttributes.recycle();
                            throw new IllegalStateException("Context can't be null when inflating animators");
                        }
                        b(string, j.i(context, resourceId2));
                    }
                    obtainAttributes.recycle();
                } else {
                    continue;
                }
            }
            eventType = xmlPullParser.next();
        }
        this.f19302b.a();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isAutoMirrored() {
        Drawable drawable = this.f19319a;
        return drawable != null ? s.h.h(drawable) : this.f19302b.f19310b.isAutoMirrored();
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        boolean isRunning;
        Drawable drawable = this.f19319a;
        if (drawable == null) {
            return this.f19302b.f19311c.isRunning();
        }
        isRunning = x0.c.a(drawable).isRunning();
        return isRunning;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        Drawable drawable = this.f19319a;
        return drawable != null ? drawable.isStateful() : this.f19302b.f19310b.isStateful();
    }

    @Override // x0.m, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void jumpToCurrentState() {
        super.jumpToCurrentState();
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        Drawable drawable = this.f19319a;
        if (drawable != null) {
            drawable.mutate();
        }
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        Drawable drawable = this.f19319a;
        if (drawable != null) {
            drawable.setBounds(rect);
        } else {
            this.f19302b.f19310b.setBounds(rect);
        }
    }

    @Override // x0.m, android.graphics.drawable.Drawable
    public boolean onLevelChange(int i10) {
        Drawable drawable = this.f19319a;
        return drawable != null ? drawable.setLevel(i10) : this.f19302b.f19310b.setLevel(i10);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onStateChange(int[] iArr) {
        Drawable drawable = this.f19319a;
        return drawable != null ? drawable.setState(iArr) : this.f19302b.f19310b.setState(iArr);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i10) {
        Drawable drawable = this.f19319a;
        if (drawable != null) {
            drawable.setAlpha(i10);
        } else {
            this.f19302b.f19310b.setAlpha(i10);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAutoMirrored(boolean z10) {
        Drawable drawable = this.f19319a;
        if (drawable != null) {
            s.h.j(drawable, z10);
        } else {
            this.f19302b.f19310b.setAutoMirrored(z10);
        }
    }

    @Override // x0.m, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setChangingConfigurations(int i10) {
        super.setChangingConfigurations(i10);
    }

    @Override // x0.m, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setColorFilter(int i10, PorterDuff.Mode mode) {
        super.setColorFilter(i10, mode);
    }

    @Override // x0.m, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setFilterBitmap(boolean z10) {
        super.setFilterBitmap(z10);
    }

    @Override // x0.m, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setHotspot(float f10, float f11) {
        super.setHotspot(f10, f11);
    }

    @Override // x0.m, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setHotspotBounds(int i10, int i11, int i12, int i13) {
        super.setHotspotBounds(i10, i11, i12, i13);
    }

    @Override // x0.m, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ boolean setState(int[] iArr) {
        return super.setState(iArr);
    }

    @Override // android.graphics.drawable.Drawable, s.w
    public void setTint(int i10) {
        Drawable drawable = this.f19319a;
        if (drawable != null) {
            s.h.n(drawable, i10);
        } else {
            this.f19302b.f19310b.setTint(i10);
        }
    }

    @Override // android.graphics.drawable.Drawable, s.w
    public void setTintList(ColorStateList colorStateList) {
        Drawable drawable = this.f19319a;
        if (drawable != null) {
            s.h.o(drawable, colorStateList);
        } else {
            this.f19302b.f19310b.setTintList(colorStateList);
        }
    }

    @Override // android.graphics.drawable.Drawable, s.w
    public void setTintMode(PorterDuff.Mode mode) {
        Drawable drawable = this.f19319a;
        if (drawable != null) {
            s.h.p(drawable, mode);
        } else {
            this.f19302b.f19310b.setTintMode(mode);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z10, boolean z11) {
        Drawable drawable = this.f19319a;
        if (drawable != null) {
            return drawable.setVisible(z10, z11);
        }
        this.f19302b.f19310b.setVisible(z10, z11);
        return super.setVisible(z10, z11);
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        Drawable drawable = this.f19319a;
        if (drawable != null) {
            x0.c.a(drawable).start();
        } else {
            if (this.f19302b.f19311c.isStarted()) {
                return;
            }
            this.f19302b.f19311c.start();
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        Drawable drawable = this.f19319a;
        if (drawable != null) {
            x0.c.a(drawable).stop();
        } else {
            this.f19302b.f19311c.end();
        }
    }

    public g(Context context) {
        this(context, null, null);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        Drawable drawable = this.f19319a;
        if (drawable != null) {
            drawable.setColorFilter(colorFilter);
        } else {
            this.f19302b.f19310b.setColorFilter(colorFilter);
        }
    }

    public static class c extends Drawable.ConstantState {

        /* renamed from: a, reason: collision with root package name */
        public final Drawable.ConstantState f19314a;

        public c(Drawable.ConstantState constantState) {
            this.f19314a = constantState;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public boolean canApplyTheme() {
            boolean canApplyTheme;
            canApplyTheme = this.f19314a.canApplyTheme();
            return canApplyTheme;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return this.f19314a.getChangingConfigurations();
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            g gVar = new g();
            Drawable newDrawable = this.f19314a.newDrawable();
            gVar.f19319a = newDrawable;
            newDrawable.setCallback(gVar.f19307g);
            return gVar;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            g gVar = new g();
            Drawable newDrawable = this.f19314a.newDrawable(resources);
            gVar.f19319a = newDrawable;
            newDrawable.setCallback(gVar.f19307g);
            return gVar;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources, Resources.Theme theme) {
            Drawable newDrawable;
            g gVar = new g();
            newDrawable = this.f19314a.newDrawable(resources, theme);
            gVar.f19319a = newDrawable;
            newDrawable.setCallback(gVar.f19307g);
            return gVar;
        }
    }

    public g(Context context, b bVar, Resources resources) {
        this.f19304d = null;
        this.f19305e = null;
        this.f19306f = null;
        a aVar = new a();
        this.f19307g = aVar;
        this.f19303c = context;
        if (bVar != null) {
            this.f19302b = bVar;
        } else {
            this.f19302b = new b(context, bVar, aVar, resources);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet) {
        inflate(resources, xmlPullParser, attributeSet, null);
    }
}
