package e;

import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.StateSet;
import androidx.appcompat.resources.R$styleable;
import androidx.appcompat.widget.e2;
import com.hpplay.component.protocol.PlistBuilder;
import e.h;
import e.n;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import s.w;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* loaded from: classes.dex */
public class c extends n implements w {

    /* renamed from: p, reason: collision with root package name */
    public C0211c f12776p;

    /* renamed from: q, reason: collision with root package name */
    public g f12777q;

    /* renamed from: r, reason: collision with root package name */
    public int f12778r;

    /* renamed from: s, reason: collision with root package name */
    public int f12779s;

    /* renamed from: t, reason: collision with root package name */
    public boolean f12780t;

    public static class b extends g {

        /* renamed from: a, reason: collision with root package name */
        public final Animatable f12781a;

        public b(Animatable animatable) {
            super();
            this.f12781a = animatable;
        }

        @Override // e.c.g
        public void c() {
            this.f12781a.start();
        }

        @Override // e.c.g
        public void d() {
            this.f12781a.stop();
        }
    }

    /* renamed from: e.c$c, reason: collision with other inner class name */
    public static class C0211c extends n.a {
        public androidx.collection.d K;
        public androidx.collection.h L;

        public C0211c(C0211c c0211c, c cVar, Resources resources) {
            super(c0211c, cVar, resources);
            if (c0211c != null) {
                this.K = c0211c.K;
                this.L = c0211c.L;
            } else {
                this.K = new androidx.collection.d();
                this.L = new androidx.collection.h();
            }
        }

        public static long D(int i10, int i11) {
            return i11 | (i10 << 32);
        }

        public int B(int[] iArr, Drawable drawable, int i10) {
            int z10 = super.z(iArr, drawable);
            this.L.i(z10, Integer.valueOf(i10));
            return z10;
        }

        public int C(int i10, int i11, Drawable drawable, boolean z10) {
            int a10 = super.a(drawable);
            long D = D(i10, i11);
            long j10 = z10 ? IjkMediaMeta.AV_CH_SURROUND_DIRECT_LEFT : 0L;
            long j11 = a10;
            this.K.a(D, Long.valueOf(j11 | j10));
            if (z10) {
                this.K.a(D(i11, i10), Long.valueOf(IjkMediaMeta.AV_CH_WIDE_RIGHT | j11 | j10));
            }
            return a10;
        }

        public int E(int i10) {
            if (i10 < 0) {
                return 0;
            }
            return ((Integer) this.L.f(i10, 0)).intValue();
        }

        public int F(int[] iArr) {
            int A = super.A(iArr);
            return A >= 0 ? A : super.A(StateSet.WILD_CARD);
        }

        public int G(int i10, int i11) {
            return (int) ((Long) this.K.g(D(i10, i11), -1L)).longValue();
        }

        public boolean H(int i10, int i11) {
            return (((Long) this.K.g(D(i10, i11), -1L)).longValue() & IjkMediaMeta.AV_CH_WIDE_RIGHT) != 0;
        }

        public boolean I(int i10, int i11) {
            return (((Long) this.K.g(D(i10, i11), -1L)).longValue() & IjkMediaMeta.AV_CH_SURROUND_DIRECT_LEFT) != 0;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            return new c(this, null);
        }

        @Override // e.n.a, e.h.c
        public void r() {
            this.K = this.K.clone();
            this.L = this.L.clone();
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            return new c(this, resources);
        }
    }

    public static class d extends g {

        /* renamed from: a, reason: collision with root package name */
        public final x0.g f12782a;

        public d(x0.g gVar) {
            super();
            this.f12782a = gVar;
        }

        @Override // e.c.g
        public void c() {
            this.f12782a.start();
        }

        @Override // e.c.g
        public void d() {
            this.f12782a.stop();
        }
    }

    public static class e extends g {

        /* renamed from: a, reason: collision with root package name */
        public final ObjectAnimator f12783a;

        /* renamed from: b, reason: collision with root package name */
        public final boolean f12784b;

        public e(AnimationDrawable animationDrawable, boolean z10, boolean z11) {
            super();
            int numberOfFrames = animationDrawable.getNumberOfFrames();
            int i10 = z10 ? numberOfFrames - 1 : 0;
            int i11 = z10 ? 0 : numberOfFrames - 1;
            f fVar = new f(animationDrawable, z10);
            ObjectAnimator ofInt = ObjectAnimator.ofInt(animationDrawable, "currentIndex", i10, i11);
            ofInt.setAutoCancel(true);
            ofInt.setDuration(fVar.a());
            ofInt.setInterpolator(fVar);
            this.f12784b = z11;
            this.f12783a = ofInt;
        }

        @Override // e.c.g
        public boolean a() {
            return this.f12784b;
        }

        @Override // e.c.g
        public void b() {
            this.f12783a.reverse();
        }

        @Override // e.c.g
        public void c() {
            this.f12783a.start();
        }

        @Override // e.c.g
        public void d() {
            this.f12783a.cancel();
        }
    }

    public static class f implements TimeInterpolator {

        /* renamed from: a, reason: collision with root package name */
        public int[] f12785a;

        /* renamed from: b, reason: collision with root package name */
        public int f12786b;

        /* renamed from: c, reason: collision with root package name */
        public int f12787c;

        public f(AnimationDrawable animationDrawable, boolean z10) {
            b(animationDrawable, z10);
        }

        public int a() {
            return this.f12787c;
        }

        public int b(AnimationDrawable animationDrawable, boolean z10) {
            int numberOfFrames = animationDrawable.getNumberOfFrames();
            this.f12786b = numberOfFrames;
            int[] iArr = this.f12785a;
            if (iArr == null || iArr.length < numberOfFrames) {
                this.f12785a = new int[numberOfFrames];
            }
            int[] iArr2 = this.f12785a;
            int i10 = 0;
            for (int i11 = 0; i11 < numberOfFrames; i11++) {
                int duration = animationDrawable.getDuration(z10 ? (numberOfFrames - i11) - 1 : i11);
                iArr2[i11] = duration;
                i10 += duration;
            }
            this.f12787c = i10;
            return i10;
        }

        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f10) {
            int i10 = (int) ((f10 * this.f12787c) + 0.5f);
            int i11 = this.f12786b;
            int[] iArr = this.f12785a;
            int i12 = 0;
            while (i12 < i11) {
                int i13 = iArr[i12];
                if (i10 < i13) {
                    break;
                }
                i10 -= i13;
                i12++;
            }
            return (i12 / i11) + (i12 < i11 ? i10 / this.f12787c : 0.0f);
        }
    }

    public static abstract class g {
        public g() {
        }

        public boolean a() {
            return false;
        }

        public void b() {
        }

        public abstract void c();

        public abstract void d();
    }

    public c() {
        this(null, null);
    }

    public static c l(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        String name = xmlPullParser.getName();
        if (name.equals("animated-selector")) {
            c cVar = new c();
            cVar.m(context, resources, xmlPullParser, attributeSet, theme);
            return cVar;
        }
        throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": invalid animated-selector tag " + name);
    }

    @Override // e.n, e.h, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void applyTheme(Resources.Theme theme) {
        super.applyTheme(theme);
    }

    @Override // e.h, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ boolean canApplyTheme() {
        return super.canApplyTheme();
    }

    @Override // e.h, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void draw(Canvas canvas) {
        super.draw(canvas);
    }

    @Override // e.h, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getAlpha() {
        return super.getAlpha();
    }

    @Override // e.h, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getChangingConfigurations() {
        return super.getChangingConfigurations();
    }

    @Override // e.h, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ Drawable getCurrent() {
        return super.getCurrent();
    }

    @Override // e.h, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void getHotspotBounds(Rect rect) {
        super.getHotspotBounds(rect);
    }

    @Override // e.h, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getIntrinsicHeight() {
        return super.getIntrinsicHeight();
    }

    @Override // e.h, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getIntrinsicWidth() {
        return super.getIntrinsicWidth();
    }

    @Override // e.h, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getMinimumHeight() {
        return super.getMinimumHeight();
    }

    @Override // e.h, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getMinimumWidth() {
        return super.getMinimumWidth();
    }

    @Override // e.h, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getOpacity() {
        return super.getOpacity();
    }

    @Override // e.h, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void getOutline(Outline outline) {
        super.getOutline(outline);
    }

    @Override // e.h, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ boolean getPadding(Rect rect) {
        return super.getPadding(rect);
    }

    @Override // e.n, e.h
    public void h(h.c cVar) {
        super.h(cVar);
        if (cVar instanceof C0211c) {
            this.f12776p = (C0211c) cVar;
        }
    }

    @Override // e.h, android.graphics.drawable.Drawable.Callback
    public /* bridge */ /* synthetic */ void invalidateDrawable(Drawable drawable) {
        super.invalidateDrawable(drawable);
    }

    @Override // e.h, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ boolean isAutoMirrored() {
        return super.isAutoMirrored();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        return true;
    }

    @Override // e.h, android.graphics.drawable.Drawable
    public void jumpToCurrentState() {
        super.jumpToCurrentState();
        g gVar = this.f12777q;
        if (gVar != null) {
            gVar.d();
            this.f12777q = null;
            g(this.f12778r);
            this.f12778r = -1;
            this.f12779s = -1;
        }
    }

    @Override // e.h
    /* renamed from: k, reason: merged with bridge method [inline-methods] */
    public C0211c b() {
        return new C0211c(this.f12776p, this, null);
    }

    public void m(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        TypedArray k10 = q.i.k(resources, theme, attributeSet, R$styleable.f1062a);
        setVisible(k10.getBoolean(R$styleable.AnimatedStateListDrawableCompat_android_visible, true), true);
        s(k10);
        i(resources);
        k10.recycle();
        n(context, resources, xmlPullParser, attributeSet, theme);
        o();
    }

    @Override // e.n, e.h, android.graphics.drawable.Drawable
    public Drawable mutate() {
        if (!this.f12780t && super.mutate() == this) {
            this.f12776p.r();
            this.f12780t = true;
        }
        return this;
    }

    public final void n(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        int depth = xmlPullParser.getDepth() + 1;
        while (true) {
            int next = xmlPullParser.next();
            if (next == 1) {
                return;
            }
            int depth2 = xmlPullParser.getDepth();
            if (depth2 < depth && next == 3) {
                return;
            }
            if (next == 2 && depth2 <= depth) {
                if (xmlPullParser.getName().equals(PlistBuilder.KEY_ITEM)) {
                    p(context, resources, xmlPullParser, attributeSet, theme);
                } else if (xmlPullParser.getName().equals("transition")) {
                    q(context, resources, xmlPullParser, attributeSet, theme);
                }
            }
        }
    }

    public final void o() {
        onStateChange(getState());
    }

    @Override // e.h, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ boolean onLayoutDirectionChanged(int i10) {
        return super.onLayoutDirectionChanged(i10);
    }

    @Override // e.n, android.graphics.drawable.Drawable
    public boolean onStateChange(int[] iArr) {
        int F = this.f12776p.F(iArr);
        boolean z10 = F != c() && (r(F) || g(F));
        Drawable current = getCurrent();
        return current != null ? z10 | current.setState(iArr) : z10;
    }

    public final int p(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        int next;
        TypedArray k10 = q.i.k(resources, theme, attributeSet, R$styleable.f1063b);
        int resourceId = k10.getResourceId(R$styleable.AnimatedStateListDrawableItem_android_id, 0);
        int resourceId2 = k10.getResourceId(R$styleable.AnimatedStateListDrawableItem_android_drawable, -1);
        Drawable j10 = resourceId2 > 0 ? e2.h().j(context, resourceId2) : null;
        k10.recycle();
        int[] j11 = j(attributeSet);
        if (j10 == null) {
            do {
                next = xmlPullParser.next();
            } while (next == 4);
            if (next != 2) {
                throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": <item> tag requires a 'drawable' attribute or child tag defining a drawable");
            }
            j10 = xmlPullParser.getName().equals("vector") ? x0.n.c(resources, xmlPullParser, attributeSet, theme) : Build.VERSION.SDK_INT >= 21 ? Drawable.createFromXmlInner(resources, xmlPullParser, attributeSet, theme) : Drawable.createFromXmlInner(resources, xmlPullParser, attributeSet);
        }
        if (j10 != null) {
            return this.f12776p.B(j11, j10, resourceId);
        }
        throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": <item> tag requires a 'drawable' attribute or child tag defining a drawable");
    }

    public final int q(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        int next;
        TypedArray k10 = q.i.k(resources, theme, attributeSet, R$styleable.f1064c);
        int resourceId = k10.getResourceId(R$styleable.AnimatedStateListDrawableTransition_android_fromId, -1);
        int resourceId2 = k10.getResourceId(R$styleable.AnimatedStateListDrawableTransition_android_toId, -1);
        int resourceId3 = k10.getResourceId(R$styleable.AnimatedStateListDrawableTransition_android_drawable, -1);
        Drawable j10 = resourceId3 > 0 ? e2.h().j(context, resourceId3) : null;
        boolean z10 = k10.getBoolean(R$styleable.AnimatedStateListDrawableTransition_android_reversible, false);
        k10.recycle();
        if (j10 == null) {
            do {
                next = xmlPullParser.next();
            } while (next == 4);
            if (next != 2) {
                throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": <transition> tag requires a 'drawable' attribute or child tag defining a drawable");
            }
            j10 = xmlPullParser.getName().equals("animated-vector") ? x0.g.a(context, resources, xmlPullParser, attributeSet, theme) : Build.VERSION.SDK_INT >= 21 ? Drawable.createFromXmlInner(resources, xmlPullParser, attributeSet, theme) : Drawable.createFromXmlInner(resources, xmlPullParser, attributeSet);
        }
        if (j10 == null) {
            throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": <transition> tag requires a 'drawable' attribute or child tag defining a drawable");
        }
        if (resourceId != -1 && resourceId2 != -1) {
            return this.f12776p.C(resourceId, resourceId2, j10, z10);
        }
        throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": <transition> tag requires 'fromId' & 'toId' attributes");
    }

    public final boolean r(int i10) {
        int c10;
        int G;
        g bVar;
        g gVar = this.f12777q;
        if (gVar == null) {
            c10 = c();
        } else {
            if (i10 == this.f12778r) {
                return true;
            }
            if (i10 == this.f12779s && gVar.a()) {
                gVar.b();
                this.f12778r = this.f12779s;
                this.f12779s = i10;
                return true;
            }
            c10 = this.f12778r;
            gVar.d();
        }
        this.f12777q = null;
        this.f12779s = -1;
        this.f12778r = -1;
        C0211c c0211c = this.f12776p;
        int E = c0211c.E(c10);
        int E2 = c0211c.E(i10);
        if (E2 == 0 || E == 0 || (G = c0211c.G(E, E2)) < 0) {
            return false;
        }
        boolean I = c0211c.I(E, E2);
        g(G);
        Object current = getCurrent();
        if (current instanceof AnimationDrawable) {
            bVar = new e((AnimationDrawable) current, c0211c.H(E, E2), I);
        } else {
            if (!(current instanceof x0.g)) {
                if (current instanceof Animatable) {
                    bVar = new b((Animatable) current);
                }
                return false;
            }
            bVar = new d((x0.g) current);
        }
        bVar.c();
        this.f12777q = bVar;
        this.f12779s = c10;
        this.f12778r = i10;
        return true;
    }

    public final void s(TypedArray typedArray) {
        int changingConfigurations;
        C0211c c0211c = this.f12776p;
        if (Build.VERSION.SDK_INT >= 21) {
            int i10 = c0211c.f12806d;
            changingConfigurations = typedArray.getChangingConfigurations();
            c0211c.f12806d = i10 | changingConfigurations;
        }
        c0211c.x(typedArray.getBoolean(R$styleable.AnimatedStateListDrawableCompat_android_variablePadding, c0211c.f12811i));
        c0211c.t(typedArray.getBoolean(R$styleable.AnimatedStateListDrawableCompat_android_constantSize, c0211c.f12814l));
        c0211c.u(typedArray.getInt(R$styleable.AnimatedStateListDrawableCompat_android_enterFadeDuration, c0211c.A));
        c0211c.v(typedArray.getInt(R$styleable.AnimatedStateListDrawableCompat_android_exitFadeDuration, c0211c.B));
        setDither(typedArray.getBoolean(R$styleable.AnimatedStateListDrawableCompat_android_dither, c0211c.f12826x));
    }

    @Override // e.h, android.graphics.drawable.Drawable.Callback
    public /* bridge */ /* synthetic */ void scheduleDrawable(Drawable drawable, Runnable runnable, long j10) {
        super.scheduleDrawable(drawable, runnable, j10);
    }

    @Override // e.h, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setAlpha(int i10) {
        super.setAlpha(i10);
    }

    @Override // e.h, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setAutoMirrored(boolean z10) {
        super.setAutoMirrored(z10);
    }

    @Override // e.h, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setColorFilter(ColorFilter colorFilter) {
        super.setColorFilter(colorFilter);
    }

    @Override // e.h, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setDither(boolean z10) {
        super.setDither(z10);
    }

    @Override // e.h, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setHotspot(float f10, float f11) {
        super.setHotspot(f10, f11);
    }

    @Override // e.h, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setHotspotBounds(int i10, int i11, int i12, int i13) {
        super.setHotspotBounds(i10, i11, i12, i13);
    }

    @Override // e.h, android.graphics.drawable.Drawable, s.w
    public /* bridge */ /* synthetic */ void setTintList(ColorStateList colorStateList) {
        super.setTintList(colorStateList);
    }

    @Override // e.h, android.graphics.drawable.Drawable, s.w
    public /* bridge */ /* synthetic */ void setTintMode(PorterDuff.Mode mode) {
        super.setTintMode(mode);
    }

    @Override // e.h, android.graphics.drawable.Drawable
    public boolean setVisible(boolean z10, boolean z11) {
        boolean visible = super.setVisible(z10, z11);
        g gVar = this.f12777q;
        if (gVar != null && (visible || z11)) {
            if (z10) {
                gVar.c();
            } else {
                jumpToCurrentState();
            }
        }
        return visible;
    }

    @Override // e.h, android.graphics.drawable.Drawable.Callback
    public /* bridge */ /* synthetic */ void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        super.unscheduleDrawable(drawable, runnable);
    }

    public c(C0211c c0211c, Resources resources) {
        super(null);
        this.f12778r = -1;
        this.f12779s = -1;
        h(new C0211c(c0211c, this, resources));
        onStateChange(getState());
        jumpToCurrentState();
    }
}
