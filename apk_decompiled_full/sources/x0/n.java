package x0;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import com.hpplay.component.common.ParamsMap;
import com.hpplay.cybergarage.upnp.UPnP;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import r.d;

/* loaded from: classes.dex */
public class n extends m {

    /* renamed from: k, reason: collision with root package name */
    public static final PorterDuff.Mode f19320k = PorterDuff.Mode.SRC_IN;

    /* renamed from: b, reason: collision with root package name */
    public h f19321b;

    /* renamed from: c, reason: collision with root package name */
    public PorterDuffColorFilter f19322c;

    /* renamed from: d, reason: collision with root package name */
    public ColorFilter f19323d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f19324e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f19325f;

    /* renamed from: g, reason: collision with root package name */
    public Drawable.ConstantState f19326g;

    /* renamed from: h, reason: collision with root package name */
    public final float[] f19327h;

    /* renamed from: i, reason: collision with root package name */
    public final Matrix f19328i;

    /* renamed from: j, reason: collision with root package name */
    public final Rect f19329j;

    public static class b extends f {
        public b() {
        }

        @Override // x0.n.f
        public boolean c() {
            return true;
        }

        public void e(Resources resources, AttributeSet attributeSet, Resources.Theme theme, XmlPullParser xmlPullParser) {
            if (q.i.j(xmlPullParser, "pathData")) {
                TypedArray k10 = q.i.k(resources, theme, attributeSet, x0.a.f19293d);
                f(k10, xmlPullParser);
                k10.recycle();
            }
        }

        public final void f(TypedArray typedArray, XmlPullParser xmlPullParser) {
            String string = typedArray.getString(0);
            if (string != null) {
                this.f19356b = string;
            }
            String string2 = typedArray.getString(1);
            if (string2 != null) {
                this.f19355a = r.d.d(string2);
            }
            this.f19357c = q.i.g(typedArray, xmlPullParser, "fillType", 2, 0);
        }

        public b(b bVar) {
            super(bVar);
        }
    }

    public static abstract class e {
        public e() {
        }

        public boolean a() {
            return false;
        }

        public boolean b(int[] iArr) {
            return false;
        }
    }

    public static class h extends Drawable.ConstantState {

        /* renamed from: a, reason: collision with root package name */
        public int f19376a;

        /* renamed from: b, reason: collision with root package name */
        public g f19377b;

        /* renamed from: c, reason: collision with root package name */
        public ColorStateList f19378c;

        /* renamed from: d, reason: collision with root package name */
        public PorterDuff.Mode f19379d;

        /* renamed from: e, reason: collision with root package name */
        public boolean f19380e;

        /* renamed from: f, reason: collision with root package name */
        public Bitmap f19381f;

        /* renamed from: g, reason: collision with root package name */
        public ColorStateList f19382g;

        /* renamed from: h, reason: collision with root package name */
        public PorterDuff.Mode f19383h;

        /* renamed from: i, reason: collision with root package name */
        public int f19384i;

        /* renamed from: j, reason: collision with root package name */
        public boolean f19385j;

        /* renamed from: k, reason: collision with root package name */
        public boolean f19386k;

        /* renamed from: l, reason: collision with root package name */
        public Paint f19387l;

        public h(h hVar) {
            this.f19378c = null;
            this.f19379d = n.f19320k;
            if (hVar != null) {
                this.f19376a = hVar.f19376a;
                g gVar = new g(hVar.f19377b);
                this.f19377b = gVar;
                if (hVar.f19377b.f19364e != null) {
                    gVar.f19364e = new Paint(hVar.f19377b.f19364e);
                }
                if (hVar.f19377b.f19363d != null) {
                    this.f19377b.f19363d = new Paint(hVar.f19377b.f19363d);
                }
                this.f19378c = hVar.f19378c;
                this.f19379d = hVar.f19379d;
                this.f19380e = hVar.f19380e;
            }
        }

        public boolean a(int i10, int i11) {
            return i10 == this.f19381f.getWidth() && i11 == this.f19381f.getHeight();
        }

        public boolean b() {
            return !this.f19386k && this.f19382g == this.f19378c && this.f19383h == this.f19379d && this.f19385j == this.f19380e && this.f19384i == this.f19377b.getRootAlpha();
        }

        public void c(int i10, int i11) {
            if (this.f19381f == null || !a(i10, i11)) {
                this.f19381f = Bitmap.createBitmap(i10, i11, Bitmap.Config.ARGB_8888);
                this.f19386k = true;
            }
        }

        public void d(Canvas canvas, ColorFilter colorFilter, Rect rect) {
            canvas.drawBitmap(this.f19381f, (Rect) null, rect, e(colorFilter));
        }

        public Paint e(ColorFilter colorFilter) {
            if (!f() && colorFilter == null) {
                return null;
            }
            if (this.f19387l == null) {
                Paint paint = new Paint();
                this.f19387l = paint;
                paint.setFilterBitmap(true);
            }
            this.f19387l.setAlpha(this.f19377b.getRootAlpha());
            this.f19387l.setColorFilter(colorFilter);
            return this.f19387l;
        }

        public boolean f() {
            return this.f19377b.getRootAlpha() < 255;
        }

        public boolean g() {
            return this.f19377b.f();
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return this.f19376a;
        }

        public boolean h(int[] iArr) {
            boolean g10 = this.f19377b.g(iArr);
            this.f19386k |= g10;
            return g10;
        }

        public void i() {
            this.f19382g = this.f19378c;
            this.f19383h = this.f19379d;
            this.f19384i = this.f19377b.getRootAlpha();
            this.f19385j = this.f19380e;
            this.f19386k = false;
        }

        public void j(int i10, int i11) {
            this.f19381f.eraseColor(0);
            this.f19377b.b(new Canvas(this.f19381f), i10, i11, null);
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            return new n(this);
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            return new n(this);
        }

        public h() {
            this.f19378c = null;
            this.f19379d = n.f19320k;
            this.f19377b = new g();
        }
    }

    public n() {
        this.f19325f = true;
        this.f19327h = new float[9];
        this.f19328i = new Matrix();
        this.f19329j = new Rect();
        this.f19321b = new h();
    }

    public static int a(int i10, float f10) {
        return (i10 & UPnP.CONFIGID_UPNP_ORG_MAX) | (((int) (Color.alpha(i10) * f10)) << 24);
    }

    public static n b(Resources resources, int i10, Resources.Theme theme) {
        int next;
        if (Build.VERSION.SDK_INT >= 24) {
            n nVar = new n();
            nVar.f19319a = q.h.d(resources, i10, theme);
            nVar.f19326g = new i(nVar.f19319a.getConstantState());
            return nVar;
        }
        try {
            XmlResourceParser xml = resources.getXml(i10);
            AttributeSet asAttributeSet = Xml.asAttributeSet(xml);
            do {
                next = xml.next();
                if (next == 2) {
                    break;
                }
            } while (next != 1);
            if (next == 2) {
                return c(resources, xml, asAttributeSet, theme);
            }
            throw new XmlPullParserException("No start tag found");
        } catch (IOException e10) {
            Log.e("VectorDrawableCompat", "parser error", e10);
            return null;
        } catch (XmlPullParserException e11) {
            Log.e("VectorDrawableCompat", "parser error", e11);
            return null;
        }
    }

    public static n c(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        n nVar = new n();
        nVar.inflate(resources, xmlPullParser, attributeSet, theme);
        return nVar;
    }

    public static PorterDuff.Mode g(int i10, PorterDuff.Mode mode) {
        if (i10 == 3) {
            return PorterDuff.Mode.SRC_OVER;
        }
        if (i10 == 5) {
            return PorterDuff.Mode.SRC_IN;
        }
        if (i10 == 9) {
            return PorterDuff.Mode.SRC_ATOP;
        }
        switch (i10) {
            case 14:
                return PorterDuff.Mode.MULTIPLY;
            case 15:
                return PorterDuff.Mode.SCREEN;
            case 16:
                return PorterDuff.Mode.ADD;
            default:
                return mode;
        }
    }

    @Override // x0.m, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void applyTheme(Resources.Theme theme) {
        super.applyTheme(theme);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean canApplyTheme() {
        Drawable drawable = this.f19319a;
        if (drawable == null) {
            return false;
        }
        s.h.b(drawable);
        return false;
    }

    @Override // x0.m, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void clearColorFilter() {
        super.clearColorFilter();
    }

    public Object d(String str) {
        return this.f19321b.f19377b.f19375p.get(str);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Drawable drawable = this.f19319a;
        if (drawable != null) {
            drawable.draw(canvas);
            return;
        }
        copyBounds(this.f19329j);
        if (this.f19329j.width() <= 0 || this.f19329j.height() <= 0) {
            return;
        }
        ColorFilter colorFilter = this.f19323d;
        if (colorFilter == null) {
            colorFilter = this.f19322c;
        }
        canvas.getMatrix(this.f19328i);
        this.f19328i.getValues(this.f19327h);
        float abs = Math.abs(this.f19327h[0]);
        float abs2 = Math.abs(this.f19327h[4]);
        float abs3 = Math.abs(this.f19327h[1]);
        float abs4 = Math.abs(this.f19327h[3]);
        if (abs3 != 0.0f || abs4 != 0.0f) {
            abs = 1.0f;
            abs2 = 1.0f;
        }
        int min = Math.min(2048, (int) (this.f19329j.width() * abs));
        int min2 = Math.min(2048, (int) (this.f19329j.height() * abs2));
        if (min <= 0 || min2 <= 0) {
            return;
        }
        int save = canvas.save();
        Rect rect = this.f19329j;
        canvas.translate(rect.left, rect.top);
        if (f()) {
            canvas.translate(this.f19329j.width(), 0.0f);
            canvas.scale(-1.0f, 1.0f);
        }
        this.f19329j.offsetTo(0, 0);
        this.f19321b.c(min, min2);
        if (!this.f19325f) {
            this.f19321b.j(min, min2);
        } else if (!this.f19321b.b()) {
            this.f19321b.j(min, min2);
            this.f19321b.i();
        }
        this.f19321b.d(canvas, colorFilter, this.f19329j);
        canvas.restoreToCount(save);
    }

    public final void e(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        h hVar = this.f19321b;
        g gVar = hVar.f19377b;
        ArrayDeque arrayDeque = new ArrayDeque();
        arrayDeque.push(gVar.f19367h);
        int eventType = xmlPullParser.getEventType();
        int depth = xmlPullParser.getDepth() + 1;
        boolean z10 = true;
        while (eventType != 1 && (xmlPullParser.getDepth() >= depth || eventType != 3)) {
            if (eventType == 2) {
                String name = xmlPullParser.getName();
                d dVar = (d) arrayDeque.peek();
                if ("path".equals(name)) {
                    c cVar = new c();
                    cVar.g(resources, attributeSet, theme, xmlPullParser);
                    dVar.f19343b.add(cVar);
                    if (cVar.getPathName() != null) {
                        gVar.f19375p.put(cVar.getPathName(), cVar);
                    }
                    hVar.f19376a = cVar.f19358d | hVar.f19376a;
                    z10 = false;
                } else if ("clip-path".equals(name)) {
                    b bVar = new b();
                    bVar.e(resources, attributeSet, theme, xmlPullParser);
                    dVar.f19343b.add(bVar);
                    if (bVar.getPathName() != null) {
                        gVar.f19375p.put(bVar.getPathName(), bVar);
                    }
                    hVar.f19376a = bVar.f19358d | hVar.f19376a;
                } else if ("group".equals(name)) {
                    d dVar2 = new d();
                    dVar2.c(resources, attributeSet, theme, xmlPullParser);
                    dVar.f19343b.add(dVar2);
                    arrayDeque.push(dVar2);
                    if (dVar2.getGroupName() != null) {
                        gVar.f19375p.put(dVar2.getGroupName(), dVar2);
                    }
                    hVar.f19376a = dVar2.f19352k | hVar.f19376a;
                }
            } else if (eventType == 3 && "group".equals(xmlPullParser.getName())) {
                arrayDeque.pop();
            }
            eventType = xmlPullParser.next();
        }
        if (z10) {
            throw new XmlPullParserException("no path defined");
        }
    }

    public final boolean f() {
        return isAutoMirrored() && s.h.f(this) == 1;
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        Drawable drawable = this.f19319a;
        return drawable != null ? s.h.d(drawable) : this.f19321b.f19377b.getRootAlpha();
    }

    @Override // android.graphics.drawable.Drawable
    public int getChangingConfigurations() {
        Drawable drawable = this.f19319a;
        return drawable != null ? drawable.getChangingConfigurations() : super.getChangingConfigurations() | this.f19321b.getChangingConfigurations();
    }

    @Override // android.graphics.drawable.Drawable
    public ColorFilter getColorFilter() {
        Drawable drawable = this.f19319a;
        return drawable != null ? s.h.e(drawable) : this.f19323d;
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        if (this.f19319a != null && Build.VERSION.SDK_INT >= 24) {
            return new i(this.f19319a.getConstantState());
        }
        this.f19321b.f19376a = getChangingConfigurations();
        return this.f19321b;
    }

    @Override // x0.m, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ Drawable getCurrent() {
        return super.getCurrent();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        Drawable drawable = this.f19319a;
        return drawable != null ? drawable.getIntrinsicHeight() : (int) this.f19321b.f19377b.f19369j;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        Drawable drawable = this.f19319a;
        return drawable != null ? drawable.getIntrinsicWidth() : (int) this.f19321b.f19377b.f19368i;
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
        if (drawable != null) {
            return drawable.getOpacity();
        }
        return -3;
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

    public void h(boolean z10) {
        this.f19325f = z10;
    }

    public final void i(TypedArray typedArray, XmlPullParser xmlPullParser, Resources.Theme theme) {
        h hVar = this.f19321b;
        g gVar = hVar.f19377b;
        hVar.f19379d = g(q.i.g(typedArray, xmlPullParser, "tintMode", 6, -1), PorterDuff.Mode.SRC_IN);
        ColorStateList c10 = q.i.c(typedArray, xmlPullParser, theme, "tint", 1);
        if (c10 != null) {
            hVar.f19378c = c10;
        }
        hVar.f19380e = q.i.a(typedArray, xmlPullParser, "autoMirrored", 5, hVar.f19380e);
        gVar.f19370k = q.i.f(typedArray, xmlPullParser, "viewportWidth", 7, gVar.f19370k);
        float f10 = q.i.f(typedArray, xmlPullParser, "viewportHeight", 8, gVar.f19371l);
        gVar.f19371l = f10;
        if (gVar.f19370k <= 0.0f) {
            throw new XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires viewportWidth > 0");
        }
        if (f10 <= 0.0f) {
            throw new XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires viewportHeight > 0");
        }
        gVar.f19368i = typedArray.getDimension(3, gVar.f19368i);
        float dimension = typedArray.getDimension(2, gVar.f19369j);
        gVar.f19369j = dimension;
        if (gVar.f19368i <= 0.0f) {
            throw new XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires width > 0");
        }
        if (dimension <= 0.0f) {
            throw new XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires height > 0");
        }
        gVar.setAlpha(q.i.f(typedArray, xmlPullParser, "alpha", 4, gVar.getAlpha()));
        String string = typedArray.getString(0);
        if (string != null) {
            gVar.f19373n = string;
            gVar.f19375p.put(string, gVar);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet) {
        Drawable drawable = this.f19319a;
        if (drawable != null) {
            drawable.inflate(resources, xmlPullParser, attributeSet);
        } else {
            inflate(resources, xmlPullParser, attributeSet, null);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void invalidateSelf() {
        Drawable drawable = this.f19319a;
        if (drawable != null) {
            drawable.invalidateSelf();
        } else {
            super.invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isAutoMirrored() {
        Drawable drawable = this.f19319a;
        return drawable != null ? s.h.h(drawable) : this.f19321b.f19380e;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        h hVar;
        ColorStateList colorStateList;
        Drawable drawable = this.f19319a;
        return drawable != null ? drawable.isStateful() : super.isStateful() || ((hVar = this.f19321b) != null && (hVar.g() || ((colorStateList = this.f19321b.f19378c) != null && colorStateList.isStateful())));
    }

    public PorterDuffColorFilter j(PorterDuffColorFilter porterDuffColorFilter, ColorStateList colorStateList, PorterDuff.Mode mode) {
        if (colorStateList == null || mode == null) {
            return null;
        }
        return new PorterDuffColorFilter(colorStateList.getColorForState(getState(), 0), mode);
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
            return this;
        }
        if (!this.f19324e && super.mutate() == this) {
            this.f19321b = new h(this.f19321b);
            this.f19324e = true;
        }
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        Drawable drawable = this.f19319a;
        if (drawable != null) {
            drawable.setBounds(rect);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onStateChange(int[] iArr) {
        boolean z10;
        PorterDuff.Mode mode;
        Drawable drawable = this.f19319a;
        if (drawable != null) {
            return drawable.setState(iArr);
        }
        h hVar = this.f19321b;
        ColorStateList colorStateList = hVar.f19378c;
        if (colorStateList == null || (mode = hVar.f19379d) == null) {
            z10 = false;
        } else {
            this.f19322c = j(this.f19322c, colorStateList, mode);
            invalidateSelf();
            z10 = true;
        }
        if (!hVar.g() || !hVar.h(iArr)) {
            return z10;
        }
        invalidateSelf();
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public void scheduleSelf(Runnable runnable, long j10) {
        Drawable drawable = this.f19319a;
        if (drawable != null) {
            drawable.scheduleSelf(runnable, j10);
        } else {
            super.scheduleSelf(runnable, j10);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i10) {
        Drawable drawable = this.f19319a;
        if (drawable != null) {
            drawable.setAlpha(i10);
        } else if (this.f19321b.f19377b.getRootAlpha() != i10) {
            this.f19321b.f19377b.setRootAlpha(i10);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAutoMirrored(boolean z10) {
        Drawable drawable = this.f19319a;
        if (drawable != null) {
            s.h.j(drawable, z10);
        } else {
            this.f19321b.f19380e = z10;
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
            setTintList(ColorStateList.valueOf(i10));
        }
    }

    @Override // android.graphics.drawable.Drawable, s.w
    public void setTintList(ColorStateList colorStateList) {
        Drawable drawable = this.f19319a;
        if (drawable != null) {
            s.h.o(drawable, colorStateList);
            return;
        }
        h hVar = this.f19321b;
        if (hVar.f19378c != colorStateList) {
            hVar.f19378c = colorStateList;
            this.f19322c = j(this.f19322c, colorStateList, hVar.f19379d);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable, s.w
    public void setTintMode(PorterDuff.Mode mode) {
        Drawable drawable = this.f19319a;
        if (drawable != null) {
            s.h.p(drawable, mode);
            return;
        }
        h hVar = this.f19321b;
        if (hVar.f19379d != mode) {
            hVar.f19379d = mode;
            this.f19322c = j(this.f19322c, hVar.f19378c, mode);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z10, boolean z11) {
        Drawable drawable = this.f19319a;
        return drawable != null ? drawable.setVisible(z10, z11) : super.setVisible(z10, z11);
    }

    @Override // android.graphics.drawable.Drawable
    public void unscheduleSelf(Runnable runnable) {
        Drawable drawable = this.f19319a;
        if (drawable != null) {
            drawable.unscheduleSelf(runnable);
        } else {
            super.unscheduleSelf(runnable);
        }
    }

    public static class i extends Drawable.ConstantState {

        /* renamed from: a, reason: collision with root package name */
        public final Drawable.ConstantState f19388a;

        public i(Drawable.ConstantState constantState) {
            this.f19388a = constantState;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public boolean canApplyTheme() {
            boolean canApplyTheme;
            canApplyTheme = this.f19388a.canApplyTheme();
            return canApplyTheme;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return this.f19388a.getChangingConfigurations();
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            n nVar = new n();
            nVar.f19319a = o.a(this.f19388a.newDrawable());
            return nVar;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            n nVar = new n();
            nVar.f19319a = o.a(this.f19388a.newDrawable(resources));
            return nVar;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources, Resources.Theme theme) {
            Drawable newDrawable;
            n nVar = new n();
            newDrawable = this.f19388a.newDrawable(resources, theme);
            nVar.f19319a = o.a(newDrawable);
            return nVar;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        Drawable drawable = this.f19319a;
        if (drawable != null) {
            drawable.setColorFilter(colorFilter);
        } else {
            this.f19323d = colorFilter;
            invalidateSelf();
        }
    }

    public static abstract class f extends e {

        /* renamed from: a, reason: collision with root package name */
        public d.b[] f19355a;

        /* renamed from: b, reason: collision with root package name */
        public String f19356b;

        /* renamed from: c, reason: collision with root package name */
        public int f19357c;

        /* renamed from: d, reason: collision with root package name */
        public int f19358d;

        public f() {
            super();
            this.f19355a = null;
            this.f19357c = 0;
        }

        public boolean c() {
            return false;
        }

        public void d(Path path) {
            path.reset();
            d.b[] bVarArr = this.f19355a;
            if (bVarArr != null) {
                d.b.e(bVarArr, path);
            }
        }

        public d.b[] getPathData() {
            return this.f19355a;
        }

        public String getPathName() {
            return this.f19356b;
        }

        public void setPathData(d.b[] bVarArr) {
            if (r.d.b(this.f19355a, bVarArr)) {
                r.d.j(this.f19355a, bVarArr);
            } else {
                this.f19355a = r.d.f(bVarArr);
            }
        }

        public f(f fVar) {
            super();
            this.f19355a = null;
            this.f19357c = 0;
            this.f19356b = fVar.f19356b;
            this.f19358d = fVar.f19358d;
            this.f19355a = r.d.f(fVar.f19355a);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        Drawable drawable = this.f19319a;
        if (drawable != null) {
            s.h.g(drawable, resources, xmlPullParser, attributeSet, theme);
            return;
        }
        h hVar = this.f19321b;
        hVar.f19377b = new g();
        TypedArray k10 = q.i.k(resources, theme, attributeSet, x0.a.f19290a);
        i(k10, xmlPullParser, theme);
        k10.recycle();
        hVar.f19376a = getChangingConfigurations();
        hVar.f19386k = true;
        e(resources, xmlPullParser, attributeSet, theme);
        this.f19322c = j(this.f19322c, hVar.f19378c, hVar.f19379d);
    }

    public n(h hVar) {
        this.f19325f = true;
        this.f19327h = new float[9];
        this.f19328i = new Matrix();
        this.f19329j = new Rect();
        this.f19321b = hVar;
        this.f19322c = j(this.f19322c, hVar.f19378c, hVar.f19379d);
    }

    public static class c extends f {

        /* renamed from: e, reason: collision with root package name */
        public int[] f19330e;

        /* renamed from: f, reason: collision with root package name */
        public q.b f19331f;

        /* renamed from: g, reason: collision with root package name */
        public float f19332g;

        /* renamed from: h, reason: collision with root package name */
        public q.b f19333h;

        /* renamed from: i, reason: collision with root package name */
        public float f19334i;

        /* renamed from: j, reason: collision with root package name */
        public float f19335j;

        /* renamed from: k, reason: collision with root package name */
        public float f19336k;

        /* renamed from: l, reason: collision with root package name */
        public float f19337l;

        /* renamed from: m, reason: collision with root package name */
        public float f19338m;

        /* renamed from: n, reason: collision with root package name */
        public Paint.Cap f19339n;

        /* renamed from: o, reason: collision with root package name */
        public Paint.Join f19340o;

        /* renamed from: p, reason: collision with root package name */
        public float f19341p;

        public c() {
            this.f19332g = 0.0f;
            this.f19334i = 1.0f;
            this.f19335j = 1.0f;
            this.f19336k = 0.0f;
            this.f19337l = 1.0f;
            this.f19338m = 0.0f;
            this.f19339n = Paint.Cap.BUTT;
            this.f19340o = Paint.Join.MITER;
            this.f19341p = 4.0f;
        }

        @Override // x0.n.e
        public boolean a() {
            return this.f19333h.i() || this.f19331f.i();
        }

        @Override // x0.n.e
        public boolean b(int[] iArr) {
            return this.f19331f.j(iArr) | this.f19333h.j(iArr);
        }

        public final Paint.Cap e(int i10, Paint.Cap cap) {
            return i10 != 0 ? i10 != 1 ? i10 != 2 ? cap : Paint.Cap.SQUARE : Paint.Cap.ROUND : Paint.Cap.BUTT;
        }

        public final Paint.Join f(int i10, Paint.Join join) {
            return i10 != 0 ? i10 != 1 ? i10 != 2 ? join : Paint.Join.BEVEL : Paint.Join.ROUND : Paint.Join.MITER;
        }

        public void g(Resources resources, AttributeSet attributeSet, Resources.Theme theme, XmlPullParser xmlPullParser) {
            TypedArray k10 = q.i.k(resources, theme, attributeSet, x0.a.f19292c);
            h(k10, xmlPullParser, theme);
            k10.recycle();
        }

        public float getFillAlpha() {
            return this.f19335j;
        }

        public int getFillColor() {
            return this.f19333h.e();
        }

        public float getStrokeAlpha() {
            return this.f19334i;
        }

        public int getStrokeColor() {
            return this.f19331f.e();
        }

        public float getStrokeWidth() {
            return this.f19332g;
        }

        public float getTrimPathEnd() {
            return this.f19337l;
        }

        public float getTrimPathOffset() {
            return this.f19338m;
        }

        public float getTrimPathStart() {
            return this.f19336k;
        }

        public final void h(TypedArray typedArray, XmlPullParser xmlPullParser, Resources.Theme theme) {
            this.f19330e = null;
            if (q.i.j(xmlPullParser, "pathData")) {
                String string = typedArray.getString(0);
                if (string != null) {
                    this.f19356b = string;
                }
                String string2 = typedArray.getString(2);
                if (string2 != null) {
                    this.f19355a = r.d.d(string2);
                }
                this.f19333h = q.i.e(typedArray, xmlPullParser, theme, "fillColor", 1, 0);
                this.f19335j = q.i.f(typedArray, xmlPullParser, "fillAlpha", 12, this.f19335j);
                this.f19339n = e(q.i.g(typedArray, xmlPullParser, "strokeLineCap", 8, -1), this.f19339n);
                this.f19340o = f(q.i.g(typedArray, xmlPullParser, "strokeLineJoin", 9, -1), this.f19340o);
                this.f19341p = q.i.f(typedArray, xmlPullParser, "strokeMiterLimit", 10, this.f19341p);
                this.f19331f = q.i.e(typedArray, xmlPullParser, theme, "strokeColor", 3, 0);
                this.f19334i = q.i.f(typedArray, xmlPullParser, "strokeAlpha", 11, this.f19334i);
                this.f19332g = q.i.f(typedArray, xmlPullParser, "strokeWidth", 4, this.f19332g);
                this.f19337l = q.i.f(typedArray, xmlPullParser, "trimPathEnd", 6, this.f19337l);
                this.f19338m = q.i.f(typedArray, xmlPullParser, "trimPathOffset", 7, this.f19338m);
                this.f19336k = q.i.f(typedArray, xmlPullParser, "trimPathStart", 5, this.f19336k);
                this.f19357c = q.i.g(typedArray, xmlPullParser, "fillType", 13, this.f19357c);
            }
        }

        public void setFillAlpha(float f10) {
            this.f19335j = f10;
        }

        public void setFillColor(int i10) {
            this.f19333h.k(i10);
        }

        public void setStrokeAlpha(float f10) {
            this.f19334i = f10;
        }

        public void setStrokeColor(int i10) {
            this.f19331f.k(i10);
        }

        public void setStrokeWidth(float f10) {
            this.f19332g = f10;
        }

        public void setTrimPathEnd(float f10) {
            this.f19337l = f10;
        }

        public void setTrimPathOffset(float f10) {
            this.f19338m = f10;
        }

        public void setTrimPathStart(float f10) {
            this.f19336k = f10;
        }

        public c(c cVar) {
            super(cVar);
            this.f19332g = 0.0f;
            this.f19334i = 1.0f;
            this.f19335j = 1.0f;
            this.f19336k = 0.0f;
            this.f19337l = 1.0f;
            this.f19338m = 0.0f;
            this.f19339n = Paint.Cap.BUTT;
            this.f19340o = Paint.Join.MITER;
            this.f19341p = 4.0f;
            this.f19330e = cVar.f19330e;
            this.f19331f = cVar.f19331f;
            this.f19332g = cVar.f19332g;
            this.f19334i = cVar.f19334i;
            this.f19333h = cVar.f19333h;
            this.f19357c = cVar.f19357c;
            this.f19335j = cVar.f19335j;
            this.f19336k = cVar.f19336k;
            this.f19337l = cVar.f19337l;
            this.f19338m = cVar.f19338m;
            this.f19339n = cVar.f19339n;
            this.f19340o = cVar.f19340o;
            this.f19341p = cVar.f19341p;
        }
    }

    public static class g {

        /* renamed from: q, reason: collision with root package name */
        public static final Matrix f19359q = new Matrix();

        /* renamed from: a, reason: collision with root package name */
        public final Path f19360a;

        /* renamed from: b, reason: collision with root package name */
        public final Path f19361b;

        /* renamed from: c, reason: collision with root package name */
        public final Matrix f19362c;

        /* renamed from: d, reason: collision with root package name */
        public Paint f19363d;

        /* renamed from: e, reason: collision with root package name */
        public Paint f19364e;

        /* renamed from: f, reason: collision with root package name */
        public PathMeasure f19365f;

        /* renamed from: g, reason: collision with root package name */
        public int f19366g;

        /* renamed from: h, reason: collision with root package name */
        public final d f19367h;

        /* renamed from: i, reason: collision with root package name */
        public float f19368i;

        /* renamed from: j, reason: collision with root package name */
        public float f19369j;

        /* renamed from: k, reason: collision with root package name */
        public float f19370k;

        /* renamed from: l, reason: collision with root package name */
        public float f19371l;

        /* renamed from: m, reason: collision with root package name */
        public int f19372m;

        /* renamed from: n, reason: collision with root package name */
        public String f19373n;

        /* renamed from: o, reason: collision with root package name */
        public Boolean f19374o;

        /* renamed from: p, reason: collision with root package name */
        public final androidx.collection.a f19375p;

        public g() {
            this.f19362c = new Matrix();
            this.f19368i = 0.0f;
            this.f19369j = 0.0f;
            this.f19370k = 0.0f;
            this.f19371l = 0.0f;
            this.f19372m = 255;
            this.f19373n = null;
            this.f19374o = null;
            this.f19375p = new androidx.collection.a();
            this.f19367h = new d();
            this.f19360a = new Path();
            this.f19361b = new Path();
        }

        public static float a(float f10, float f11, float f12, float f13) {
            return (f10 * f13) - (f11 * f12);
        }

        public void b(Canvas canvas, int i10, int i11, ColorFilter colorFilter) {
            c(this.f19367h, f19359q, canvas, i10, i11, colorFilter);
        }

        public final void c(d dVar, Matrix matrix, Canvas canvas, int i10, int i11, ColorFilter colorFilter) {
            dVar.f19342a.set(matrix);
            dVar.f19342a.preConcat(dVar.f19351j);
            canvas.save();
            for (int i12 = 0; i12 < dVar.f19343b.size(); i12++) {
                e eVar = (e) dVar.f19343b.get(i12);
                if (eVar instanceof d) {
                    c((d) eVar, dVar.f19342a, canvas, i10, i11, colorFilter);
                } else if (eVar instanceof f) {
                    d(dVar, (f) eVar, canvas, i10, i11, colorFilter);
                }
            }
            canvas.restore();
        }

        public final void d(d dVar, f fVar, Canvas canvas, int i10, int i11, ColorFilter colorFilter) {
            float f10 = i10 / this.f19370k;
            float f11 = i11 / this.f19371l;
            float min = Math.min(f10, f11);
            Matrix matrix = dVar.f19342a;
            this.f19362c.set(matrix);
            this.f19362c.postScale(f10, f11);
            float e10 = e(matrix);
            if (e10 == 0.0f) {
                return;
            }
            fVar.d(this.f19360a);
            Path path = this.f19360a;
            this.f19361b.reset();
            if (fVar.c()) {
                this.f19361b.setFillType(fVar.f19357c == 0 ? Path.FillType.WINDING : Path.FillType.EVEN_ODD);
                this.f19361b.addPath(path, this.f19362c);
                canvas.clipPath(this.f19361b);
                return;
            }
            c cVar = (c) fVar;
            float f12 = cVar.f19336k;
            if (f12 != 0.0f || cVar.f19337l != 1.0f) {
                float f13 = cVar.f19338m;
                float f14 = (f12 + f13) % 1.0f;
                float f15 = (cVar.f19337l + f13) % 1.0f;
                if (this.f19365f == null) {
                    this.f19365f = new PathMeasure();
                }
                this.f19365f.setPath(this.f19360a, false);
                float length = this.f19365f.getLength();
                float f16 = f14 * length;
                float f17 = f15 * length;
                path.reset();
                if (f16 > f17) {
                    this.f19365f.getSegment(f16, length, path, true);
                    this.f19365f.getSegment(0.0f, f17, path, true);
                } else {
                    this.f19365f.getSegment(f16, f17, path, true);
                }
                path.rLineTo(0.0f, 0.0f);
            }
            this.f19361b.addPath(path, this.f19362c);
            if (cVar.f19333h.l()) {
                q.b bVar = cVar.f19333h;
                if (this.f19364e == null) {
                    Paint paint = new Paint(1);
                    this.f19364e = paint;
                    paint.setStyle(Paint.Style.FILL);
                }
                Paint paint2 = this.f19364e;
                if (bVar.h()) {
                    Shader f18 = bVar.f();
                    f18.setLocalMatrix(this.f19362c);
                    paint2.setShader(f18);
                    paint2.setAlpha(Math.round(cVar.f19335j * 255.0f));
                } else {
                    paint2.setShader(null);
                    paint2.setAlpha(255);
                    paint2.setColor(n.a(bVar.e(), cVar.f19335j));
                }
                paint2.setColorFilter(colorFilter);
                this.f19361b.setFillType(cVar.f19357c == 0 ? Path.FillType.WINDING : Path.FillType.EVEN_ODD);
                canvas.drawPath(this.f19361b, paint2);
            }
            if (cVar.f19331f.l()) {
                q.b bVar2 = cVar.f19331f;
                if (this.f19363d == null) {
                    Paint paint3 = new Paint(1);
                    this.f19363d = paint3;
                    paint3.setStyle(Paint.Style.STROKE);
                }
                Paint paint4 = this.f19363d;
                Paint.Join join = cVar.f19340o;
                if (join != null) {
                    paint4.setStrokeJoin(join);
                }
                Paint.Cap cap = cVar.f19339n;
                if (cap != null) {
                    paint4.setStrokeCap(cap);
                }
                paint4.setStrokeMiter(cVar.f19341p);
                if (bVar2.h()) {
                    Shader f19 = bVar2.f();
                    f19.setLocalMatrix(this.f19362c);
                    paint4.setShader(f19);
                    paint4.setAlpha(Math.round(cVar.f19334i * 255.0f));
                } else {
                    paint4.setShader(null);
                    paint4.setAlpha(255);
                    paint4.setColor(n.a(bVar2.e(), cVar.f19334i));
                }
                paint4.setColorFilter(colorFilter);
                paint4.setStrokeWidth(cVar.f19332g * min * e10);
                canvas.drawPath(this.f19361b, paint4);
            }
        }

        public final float e(Matrix matrix) {
            float[] fArr = {0.0f, 1.0f, 1.0f, 0.0f};
            matrix.mapVectors(fArr);
            float hypot = (float) Math.hypot(fArr[0], fArr[1]);
            float hypot2 = (float) Math.hypot(fArr[2], fArr[3]);
            float a10 = a(fArr[0], fArr[1], fArr[2], fArr[3]);
            float max = Math.max(hypot, hypot2);
            if (max > 0.0f) {
                return Math.abs(a10) / max;
            }
            return 0.0f;
        }

        public boolean f() {
            if (this.f19374o == null) {
                this.f19374o = Boolean.valueOf(this.f19367h.a());
            }
            return this.f19374o.booleanValue();
        }

        public boolean g(int[] iArr) {
            return this.f19367h.b(iArr);
        }

        public float getAlpha() {
            return getRootAlpha() / 255.0f;
        }

        public int getRootAlpha() {
            return this.f19372m;
        }

        public void setAlpha(float f10) {
            setRootAlpha((int) (f10 * 255.0f));
        }

        public void setRootAlpha(int i10) {
            this.f19372m = i10;
        }

        public g(g gVar) {
            this.f19362c = new Matrix();
            this.f19368i = 0.0f;
            this.f19369j = 0.0f;
            this.f19370k = 0.0f;
            this.f19371l = 0.0f;
            this.f19372m = 255;
            this.f19373n = null;
            this.f19374o = null;
            androidx.collection.a aVar = new androidx.collection.a();
            this.f19375p = aVar;
            this.f19367h = new d(gVar.f19367h, aVar);
            this.f19360a = new Path(gVar.f19360a);
            this.f19361b = new Path(gVar.f19361b);
            this.f19368i = gVar.f19368i;
            this.f19369j = gVar.f19369j;
            this.f19370k = gVar.f19370k;
            this.f19371l = gVar.f19371l;
            this.f19366g = gVar.f19366g;
            this.f19372m = gVar.f19372m;
            this.f19373n = gVar.f19373n;
            String str = gVar.f19373n;
            if (str != null) {
                aVar.put(str, this);
            }
            this.f19374o = gVar.f19374o;
        }
    }

    public static class d extends e {

        /* renamed from: a, reason: collision with root package name */
        public final Matrix f19342a;

        /* renamed from: b, reason: collision with root package name */
        public final ArrayList f19343b;

        /* renamed from: c, reason: collision with root package name */
        public float f19344c;

        /* renamed from: d, reason: collision with root package name */
        public float f19345d;

        /* renamed from: e, reason: collision with root package name */
        public float f19346e;

        /* renamed from: f, reason: collision with root package name */
        public float f19347f;

        /* renamed from: g, reason: collision with root package name */
        public float f19348g;

        /* renamed from: h, reason: collision with root package name */
        public float f19349h;

        /* renamed from: i, reason: collision with root package name */
        public float f19350i;

        /* renamed from: j, reason: collision with root package name */
        public final Matrix f19351j;

        /* renamed from: k, reason: collision with root package name */
        public int f19352k;

        /* renamed from: l, reason: collision with root package name */
        public int[] f19353l;

        /* renamed from: m, reason: collision with root package name */
        public String f19354m;

        public d(d dVar, androidx.collection.a aVar) {
            super();
            f bVar;
            this.f19342a = new Matrix();
            this.f19343b = new ArrayList();
            this.f19344c = 0.0f;
            this.f19345d = 0.0f;
            this.f19346e = 0.0f;
            this.f19347f = 1.0f;
            this.f19348g = 1.0f;
            this.f19349h = 0.0f;
            this.f19350i = 0.0f;
            Matrix matrix = new Matrix();
            this.f19351j = matrix;
            this.f19354m = null;
            this.f19344c = dVar.f19344c;
            this.f19345d = dVar.f19345d;
            this.f19346e = dVar.f19346e;
            this.f19347f = dVar.f19347f;
            this.f19348g = dVar.f19348g;
            this.f19349h = dVar.f19349h;
            this.f19350i = dVar.f19350i;
            this.f19353l = dVar.f19353l;
            String str = dVar.f19354m;
            this.f19354m = str;
            this.f19352k = dVar.f19352k;
            if (str != null) {
                aVar.put(str, this);
            }
            matrix.set(dVar.f19351j);
            ArrayList arrayList = dVar.f19343b;
            for (int i10 = 0; i10 < arrayList.size(); i10++) {
                Object obj = arrayList.get(i10);
                if (obj instanceof d) {
                    this.f19343b.add(new d((d) obj, aVar));
                } else {
                    if (obj instanceof c) {
                        bVar = new c((c) obj);
                    } else {
                        if (!(obj instanceof b)) {
                            throw new IllegalStateException("Unknown object in the tree!");
                        }
                        bVar = new b((b) obj);
                    }
                    this.f19343b.add(bVar);
                    Object obj2 = bVar.f19356b;
                    if (obj2 != null) {
                        aVar.put(obj2, bVar);
                    }
                }
            }
        }

        @Override // x0.n.e
        public boolean a() {
            for (int i10 = 0; i10 < this.f19343b.size(); i10++) {
                if (((e) this.f19343b.get(i10)).a()) {
                    return true;
                }
            }
            return false;
        }

        @Override // x0.n.e
        public boolean b(int[] iArr) {
            boolean z10 = false;
            for (int i10 = 0; i10 < this.f19343b.size(); i10++) {
                z10 |= ((e) this.f19343b.get(i10)).b(iArr);
            }
            return z10;
        }

        public void c(Resources resources, AttributeSet attributeSet, Resources.Theme theme, XmlPullParser xmlPullParser) {
            TypedArray k10 = q.i.k(resources, theme, attributeSet, x0.a.f19291b);
            e(k10, xmlPullParser);
            k10.recycle();
        }

        public final void d() {
            this.f19351j.reset();
            this.f19351j.postTranslate(-this.f19345d, -this.f19346e);
            this.f19351j.postScale(this.f19347f, this.f19348g);
            this.f19351j.postRotate(this.f19344c, 0.0f, 0.0f);
            this.f19351j.postTranslate(this.f19349h + this.f19345d, this.f19350i + this.f19346e);
        }

        public final void e(TypedArray typedArray, XmlPullParser xmlPullParser) {
            this.f19353l = null;
            this.f19344c = q.i.f(typedArray, xmlPullParser, ParamsMap.MirrorParams.KEY_ROTATION, 5, this.f19344c);
            this.f19345d = typedArray.getFloat(1, this.f19345d);
            this.f19346e = typedArray.getFloat(2, this.f19346e);
            this.f19347f = q.i.f(typedArray, xmlPullParser, "scaleX", 3, this.f19347f);
            this.f19348g = q.i.f(typedArray, xmlPullParser, "scaleY", 4, this.f19348g);
            this.f19349h = q.i.f(typedArray, xmlPullParser, "translateX", 6, this.f19349h);
            this.f19350i = q.i.f(typedArray, xmlPullParser, "translateY", 7, this.f19350i);
            String string = typedArray.getString(0);
            if (string != null) {
                this.f19354m = string;
            }
            d();
        }

        public String getGroupName() {
            return this.f19354m;
        }

        public Matrix getLocalMatrix() {
            return this.f19351j;
        }

        public float getPivotX() {
            return this.f19345d;
        }

        public float getPivotY() {
            return this.f19346e;
        }

        public float getRotation() {
            return this.f19344c;
        }

        public float getScaleX() {
            return this.f19347f;
        }

        public float getScaleY() {
            return this.f19348g;
        }

        public float getTranslateX() {
            return this.f19349h;
        }

        public float getTranslateY() {
            return this.f19350i;
        }

        public void setPivotX(float f10) {
            if (f10 != this.f19345d) {
                this.f19345d = f10;
                d();
            }
        }

        public void setPivotY(float f10) {
            if (f10 != this.f19346e) {
                this.f19346e = f10;
                d();
            }
        }

        public void setRotation(float f10) {
            if (f10 != this.f19344c) {
                this.f19344c = f10;
                d();
            }
        }

        public void setScaleX(float f10) {
            if (f10 != this.f19347f) {
                this.f19347f = f10;
                d();
            }
        }

        public void setScaleY(float f10) {
            if (f10 != this.f19348g) {
                this.f19348g = f10;
                d();
            }
        }

        public void setTranslateX(float f10) {
            if (f10 != this.f19349h) {
                this.f19349h = f10;
                d();
            }
        }

        public void setTranslateY(float f10) {
            if (f10 != this.f19350i) {
                this.f19350i = f10;
                d();
            }
        }

        public d() {
            super();
            this.f19342a = new Matrix();
            this.f19343b = new ArrayList();
            this.f19344c = 0.0f;
            this.f19345d = 0.0f;
            this.f19346e = 0.0f;
            this.f19347f = 1.0f;
            this.f19348g = 1.0f;
            this.f19349h = 0.0f;
            this.f19350i = 0.0f;
            this.f19351j = new Matrix();
            this.f19354m = null;
        }
    }
}
