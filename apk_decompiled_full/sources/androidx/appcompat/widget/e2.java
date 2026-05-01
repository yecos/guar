package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.util.Xml;
import androidx.appcompat.resources.R$drawable;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes.dex */
public final class e2 {

    /* renamed from: i, reason: collision with root package name */
    public static e2 f1485i;

    /* renamed from: a, reason: collision with root package name */
    public WeakHashMap f1487a;

    /* renamed from: b, reason: collision with root package name */
    public androidx.collection.a f1488b;

    /* renamed from: c, reason: collision with root package name */
    public androidx.collection.h f1489c;

    /* renamed from: d, reason: collision with root package name */
    public final WeakHashMap f1490d = new WeakHashMap(0);

    /* renamed from: e, reason: collision with root package name */
    public TypedValue f1491e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f1492f;

    /* renamed from: g, reason: collision with root package name */
    public e f1493g;

    /* renamed from: h, reason: collision with root package name */
    public static final PorterDuff.Mode f1484h = PorterDuff.Mode.SRC_IN;

    /* renamed from: j, reason: collision with root package name */
    public static final c f1486j = new c(6);

    public static class a implements d {
        @Override // androidx.appcompat.widget.e2.d
        public Drawable a(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
            try {
                return e.c.l(context, context.getResources(), xmlPullParser, attributeSet, theme);
            } catch (Exception e10) {
                Log.e("AsldcInflateDelegate", "Exception while inflating <animated-selector>", e10);
                return null;
            }
        }
    }

    public static class b implements d {
        @Override // androidx.appcompat.widget.e2.d
        public Drawable a(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
            try {
                return x0.g.a(context, context.getResources(), xmlPullParser, attributeSet, theme);
            } catch (Exception e10) {
                Log.e("AvdcInflateDelegate", "Exception while inflating <animated-vector>", e10);
                return null;
            }
        }
    }

    public static class c extends androidx.collection.e {
        public c(int i10) {
            super(i10);
        }

        public static int b(int i10, PorterDuff.Mode mode) {
            return ((i10 + 31) * 31) + mode.hashCode();
        }

        public PorterDuffColorFilter c(int i10, PorterDuff.Mode mode) {
            return (PorterDuffColorFilter) get(Integer.valueOf(b(i10, mode)));
        }

        public PorterDuffColorFilter d(int i10, PorterDuff.Mode mode, PorterDuffColorFilter porterDuffColorFilter) {
            return (PorterDuffColorFilter) put(Integer.valueOf(b(i10, mode)), porterDuffColorFilter);
        }
    }

    public interface d {
        Drawable a(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme);
    }

    public interface e {
        Drawable a(e2 e2Var, Context context, int i10);

        ColorStateList b(Context context, int i10);

        boolean c(Context context, int i10, Drawable drawable);

        PorterDuff.Mode d(int i10);

        boolean e(Context context, int i10, Drawable drawable);
    }

    public static class f implements d {
        @Override // androidx.appcompat.widget.e2.d
        public Drawable a(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
            try {
                return x0.n.c(context.getResources(), xmlPullParser, attributeSet, theme);
            } catch (Exception e10) {
                Log.e("VdcInflateDelegate", "Exception while inflating <vector>", e10);
                return null;
            }
        }
    }

    public static long e(TypedValue typedValue) {
        return (typedValue.assetCookie << 32) | typedValue.data;
    }

    public static PorterDuffColorFilter g(ColorStateList colorStateList, PorterDuff.Mode mode, int[] iArr) {
        if (colorStateList == null || mode == null) {
            return null;
        }
        return l(colorStateList.getColorForState(iArr, 0), mode);
    }

    public static synchronized e2 h() {
        e2 e2Var;
        synchronized (e2.class) {
            if (f1485i == null) {
                e2 e2Var2 = new e2();
                f1485i = e2Var2;
                p(e2Var2);
            }
            e2Var = f1485i;
        }
        return e2Var;
    }

    public static synchronized PorterDuffColorFilter l(int i10, PorterDuff.Mode mode) {
        PorterDuffColorFilter c10;
        synchronized (e2.class) {
            c cVar = f1486j;
            c10 = cVar.c(i10, mode);
            if (c10 == null) {
                c10 = new PorterDuffColorFilter(i10, mode);
                cVar.d(i10, mode, c10);
            }
        }
        return c10;
    }

    public static void p(e2 e2Var) {
        if (Build.VERSION.SDK_INT < 24) {
            e2Var.a("vector", new f());
            e2Var.a("animated-vector", new b());
            e2Var.a("animated-selector", new a());
        }
    }

    public static boolean q(Drawable drawable) {
        return (drawable instanceof x0.n) || "android.graphics.drawable.VectorDrawable".equals(drawable.getClass().getName());
    }

    public static void w(Drawable drawable, p2 p2Var, int[] iArr) {
        if (!o1.a(drawable) || drawable.mutate() == drawable) {
            boolean z10 = p2Var.f1593d;
            if (z10 || p2Var.f1592c) {
                drawable.setColorFilter(g(z10 ? p2Var.f1590a : null, p2Var.f1592c ? p2Var.f1591b : f1484h, iArr));
            } else {
                drawable.clearColorFilter();
            }
            if (Build.VERSION.SDK_INT <= 23) {
                drawable.invalidateSelf();
            }
        }
    }

    public final void a(String str, d dVar) {
        if (this.f1488b == null) {
            this.f1488b = new androidx.collection.a();
        }
        this.f1488b.put(str, dVar);
    }

    public final synchronized boolean b(Context context, long j10, Drawable drawable) {
        Drawable.ConstantState constantState = drawable.getConstantState();
        if (constantState == null) {
            return false;
        }
        androidx.collection.d dVar = (androidx.collection.d) this.f1490d.get(context);
        if (dVar == null) {
            dVar = new androidx.collection.d();
            this.f1490d.put(context, dVar);
        }
        dVar.j(j10, new WeakReference(constantState));
        return true;
    }

    public final void c(Context context, int i10, ColorStateList colorStateList) {
        if (this.f1487a == null) {
            this.f1487a = new WeakHashMap();
        }
        androidx.collection.h hVar = (androidx.collection.h) this.f1487a.get(context);
        if (hVar == null) {
            hVar = new androidx.collection.h();
            this.f1487a.put(context, hVar);
        }
        hVar.a(i10, colorStateList);
    }

    public final void d(Context context) {
        if (this.f1492f) {
            return;
        }
        this.f1492f = true;
        Drawable j10 = j(context, R$drawable.abc_vector_test);
        if (j10 == null || !q(j10)) {
            this.f1492f = false;
            throw new IllegalStateException("This app has been built with an incorrect configuration. Please configure your build for VectorDrawableCompat.");
        }
    }

    public final Drawable f(Context context, int i10) {
        if (this.f1491e == null) {
            this.f1491e = new TypedValue();
        }
        TypedValue typedValue = this.f1491e;
        context.getResources().getValue(i10, typedValue, true);
        long e10 = e(typedValue);
        Drawable i11 = i(context, e10);
        if (i11 != null) {
            return i11;
        }
        e eVar = this.f1493g;
        Drawable a10 = eVar == null ? null : eVar.a(this, context, i10);
        if (a10 != null) {
            a10.setChangingConfigurations(typedValue.changingConfigurations);
            b(context, e10, a10);
        }
        return a10;
    }

    public final synchronized Drawable i(Context context, long j10) {
        androidx.collection.d dVar = (androidx.collection.d) this.f1490d.get(context);
        if (dVar == null) {
            return null;
        }
        WeakReference weakReference = (WeakReference) dVar.f(j10);
        if (weakReference != null) {
            Drawable.ConstantState constantState = (Drawable.ConstantState) weakReference.get();
            if (constantState != null) {
                return constantState.newDrawable(context.getResources());
            }
            dVar.d(j10);
        }
        return null;
    }

    public synchronized Drawable j(Context context, int i10) {
        return k(context, i10, false);
    }

    public synchronized Drawable k(Context context, int i10, boolean z10) {
        Drawable r10;
        d(context);
        r10 = r(context, i10);
        if (r10 == null) {
            r10 = f(context, i10);
        }
        if (r10 == null) {
            r10 = p.a.getDrawable(context, i10);
        }
        if (r10 != null) {
            r10 = v(context, i10, z10, r10);
        }
        if (r10 != null) {
            o1.b(r10);
        }
        return r10;
    }

    public synchronized ColorStateList m(Context context, int i10) {
        ColorStateList n10;
        n10 = n(context, i10);
        if (n10 == null) {
            e eVar = this.f1493g;
            n10 = eVar == null ? null : eVar.b(context, i10);
            if (n10 != null) {
                c(context, i10, n10);
            }
        }
        return n10;
    }

    public final ColorStateList n(Context context, int i10) {
        androidx.collection.h hVar;
        WeakHashMap weakHashMap = this.f1487a;
        if (weakHashMap == null || (hVar = (androidx.collection.h) weakHashMap.get(context)) == null) {
            return null;
        }
        return (ColorStateList) hVar.e(i10);
    }

    public PorterDuff.Mode o(int i10) {
        e eVar = this.f1493g;
        if (eVar == null) {
            return null;
        }
        return eVar.d(i10);
    }

    public final Drawable r(Context context, int i10) {
        int next;
        androidx.collection.a aVar = this.f1488b;
        if (aVar == null || aVar.isEmpty()) {
            return null;
        }
        androidx.collection.h hVar = this.f1489c;
        if (hVar != null) {
            String str = (String) hVar.e(i10);
            if ("appcompat_skip_skip".equals(str) || (str != null && this.f1488b.get(str) == null)) {
                return null;
            }
        } else {
            this.f1489c = new androidx.collection.h();
        }
        if (this.f1491e == null) {
            this.f1491e = new TypedValue();
        }
        TypedValue typedValue = this.f1491e;
        Resources resources = context.getResources();
        resources.getValue(i10, typedValue, true);
        long e10 = e(typedValue);
        Drawable i11 = i(context, e10);
        if (i11 != null) {
            return i11;
        }
        CharSequence charSequence = typedValue.string;
        if (charSequence != null && charSequence.toString().endsWith(".xml")) {
            try {
                XmlResourceParser xml = resources.getXml(i10);
                AttributeSet asAttributeSet = Xml.asAttributeSet(xml);
                do {
                    next = xml.next();
                    if (next == 2) {
                        break;
                    }
                } while (next != 1);
                if (next != 2) {
                    throw new XmlPullParserException("No start tag found");
                }
                String name = xml.getName();
                this.f1489c.a(i10, name);
                d dVar = (d) this.f1488b.get(name);
                if (dVar != null) {
                    i11 = dVar.a(context, xml, asAttributeSet, context.getTheme());
                }
                if (i11 != null) {
                    i11.setChangingConfigurations(typedValue.changingConfigurations);
                    b(context, e10, i11);
                }
            } catch (Exception e11) {
                Log.e("ResourceManagerInternal", "Exception while inflating drawable", e11);
            }
        }
        if (i11 == null) {
            this.f1489c.a(i10, "appcompat_skip_skip");
        }
        return i11;
    }

    public synchronized void s(Context context) {
        androidx.collection.d dVar = (androidx.collection.d) this.f1490d.get(context);
        if (dVar != null) {
            dVar.b();
        }
    }

    public synchronized Drawable t(Context context, x2 x2Var, int i10) {
        Drawable r10 = r(context, i10);
        if (r10 == null) {
            r10 = x2Var.c(i10);
        }
        if (r10 == null) {
            return null;
        }
        return v(context, i10, false, r10);
    }

    public synchronized void u(e eVar) {
        this.f1493g = eVar;
    }

    public final Drawable v(Context context, int i10, boolean z10, Drawable drawable) {
        ColorStateList m10 = m(context, i10);
        if (m10 == null) {
            e eVar = this.f1493g;
            if ((eVar == null || !eVar.e(context, i10, drawable)) && !x(context, i10, drawable) && z10) {
                return null;
            }
            return drawable;
        }
        if (o1.a(drawable)) {
            drawable = drawable.mutate();
        }
        Drawable r10 = s.h.r(drawable);
        s.h.o(r10, m10);
        PorterDuff.Mode o10 = o(i10);
        if (o10 == null) {
            return r10;
        }
        s.h.p(r10, o10);
        return r10;
    }

    public boolean x(Context context, int i10, Drawable drawable) {
        e eVar = this.f1493g;
        return eVar != null && eVar.c(context, i10, drawable);
    }
}
