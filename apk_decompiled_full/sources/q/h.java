package q;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.util.SparseArray;
import android.util.TypedValue;
import java.io.IOException;
import java.util.WeakHashMap;
import org.xmlpull.v1.XmlPullParserException;
import q.d;

/* loaded from: classes.dex */
public abstract class h {

    /* renamed from: a, reason: collision with root package name */
    public static final ThreadLocal f18091a = new ThreadLocal();

    /* renamed from: b, reason: collision with root package name */
    public static final WeakHashMap f18092b = new WeakHashMap(0);

    /* renamed from: c, reason: collision with root package name */
    public static final Object f18093c = new Object();

    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public final ColorStateList f18094a;

        /* renamed from: b, reason: collision with root package name */
        public final Configuration f18095b;

        public a(ColorStateList colorStateList, Configuration configuration) {
            this.f18094a = colorStateList;
            this.f18095b = configuration;
        }
    }

    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public final Resources f18096a;

        /* renamed from: b, reason: collision with root package name */
        public final Resources.Theme f18097b;

        public b(Resources resources, Resources.Theme theme) {
            this.f18096a = resources;
            this.f18097b = theme;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || b.class != obj.getClass()) {
                return false;
            }
            b bVar = (b) obj;
            return this.f18096a.equals(bVar.f18096a) && a0.c.a(this.f18097b, bVar.f18097b);
        }

        public int hashCode() {
            return a0.c.b(this.f18096a, this.f18097b);
        }
    }

    public static abstract class c {

        public class a implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ Typeface f18098a;

            public a(Typeface typeface) {
                this.f18098a = typeface;
            }

            @Override // java.lang.Runnable
            public void run() {
                c.this.onFontRetrieved(this.f18098a);
            }
        }

        public class b implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ int f18100a;

            public b(int i10) {
                this.f18100a = i10;
            }

            @Override // java.lang.Runnable
            public void run() {
                c.this.onFontRetrievalFailed(this.f18100a);
            }
        }

        public static Handler getHandler(Handler handler) {
            return handler == null ? new Handler(Looper.getMainLooper()) : handler;
        }

        public final void callbackFailAsync(int i10, Handler handler) {
            getHandler(handler).post(new b(i10));
        }

        public final void callbackSuccessAsync(Typeface typeface, Handler handler) {
            getHandler(handler).post(new a(typeface));
        }

        public abstract void onFontRetrievalFailed(int i10);

        public abstract void onFontRetrieved(Typeface typeface);
    }

    public static void a(b bVar, int i10, ColorStateList colorStateList) {
        synchronized (f18093c) {
            WeakHashMap weakHashMap = f18092b;
            SparseArray sparseArray = (SparseArray) weakHashMap.get(bVar);
            if (sparseArray == null) {
                sparseArray = new SparseArray();
                weakHashMap.put(bVar, sparseArray);
            }
            sparseArray.append(i10, new a(colorStateList, bVar.f18096a.getConfiguration()));
        }
    }

    public static ColorStateList b(b bVar, int i10) {
        a aVar;
        synchronized (f18093c) {
            SparseArray sparseArray = (SparseArray) f18092b.get(bVar);
            if (sparseArray != null && sparseArray.size() > 0 && (aVar = (a) sparseArray.get(i10)) != null) {
                if (aVar.f18095b.equals(bVar.f18096a.getConfiguration())) {
                    return aVar.f18094a;
                }
                sparseArray.remove(i10);
            }
            return null;
        }
    }

    public static ColorStateList c(Resources resources, int i10, Resources.Theme theme) {
        ColorStateList colorStateList;
        if (Build.VERSION.SDK_INT >= 23) {
            colorStateList = resources.getColorStateList(i10, theme);
            return colorStateList;
        }
        b bVar = new b(resources, theme);
        ColorStateList b10 = b(bVar, i10);
        if (b10 != null) {
            return b10;
        }
        ColorStateList i11 = i(resources, i10, theme);
        if (i11 == null) {
            return resources.getColorStateList(i10);
        }
        a(bVar, i10, i11);
        return i11;
    }

    public static Drawable d(Resources resources, int i10, Resources.Theme theme) {
        Drawable drawable;
        if (Build.VERSION.SDK_INT < 21) {
            return resources.getDrawable(i10);
        }
        drawable = resources.getDrawable(i10, theme);
        return drawable;
    }

    public static Typeface e(Context context, int i10) {
        if (context.isRestricted()) {
            return null;
        }
        return k(context, i10, new TypedValue(), 0, null, null, false, false);
    }

    public static Typeface f(Context context, int i10, TypedValue typedValue, int i11, c cVar) {
        if (context.isRestricted()) {
            return null;
        }
        return k(context, i10, typedValue, i11, cVar, null, true, false);
    }

    public static void g(Context context, int i10, c cVar, Handler handler) {
        a0.h.d(cVar);
        if (context.isRestricted()) {
            cVar.callbackFailAsync(-4, handler);
        } else {
            k(context, i10, new TypedValue(), 0, cVar, handler, false, false);
        }
    }

    public static TypedValue h() {
        ThreadLocal threadLocal = f18091a;
        TypedValue typedValue = (TypedValue) threadLocal.get();
        if (typedValue != null) {
            return typedValue;
        }
        TypedValue typedValue2 = new TypedValue();
        threadLocal.set(typedValue2);
        return typedValue2;
    }

    public static ColorStateList i(Resources resources, int i10, Resources.Theme theme) {
        if (j(resources, i10)) {
            return null;
        }
        try {
            return q.a.a(resources, resources.getXml(i10), theme);
        } catch (Exception e10) {
            Log.e("ResourcesCompat", "Failed to inflate ColorStateList, leaving it to the framework", e10);
            return null;
        }
    }

    public static boolean j(Resources resources, int i10) {
        TypedValue h10 = h();
        resources.getValue(i10, h10, true);
        int i11 = h10.type;
        return i11 >= 28 && i11 <= 31;
    }

    public static Typeface k(Context context, int i10, TypedValue typedValue, int i11, c cVar, Handler handler, boolean z10, boolean z11) {
        Resources resources = context.getResources();
        resources.getValue(i10, typedValue, true);
        Typeface l10 = l(context, resources, typedValue, i10, i11, cVar, handler, z10, z11);
        if (l10 != null || cVar != null || z11) {
            return l10;
        }
        throw new Resources.NotFoundException("Font resource ID #0x" + Integer.toHexString(i10) + " could not be retrieved.");
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x00a6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Typeface l(Context context, Resources resources, TypedValue typedValue, int i10, int i11, c cVar, Handler handler, boolean z10, boolean z11) {
        CharSequence charSequence = typedValue.string;
        if (charSequence == null) {
            throw new Resources.NotFoundException("Resource \"" + resources.getResourceName(i10) + "\" (" + Integer.toHexString(i10) + ") is not a Font: " + typedValue);
        }
        String charSequence2 = charSequence.toString();
        if (!charSequence2.startsWith("res/")) {
            if (cVar != null) {
                cVar.callbackFailAsync(-3, handler);
            }
            return null;
        }
        Typeface f10 = r.e.f(resources, i10, i11);
        if (f10 != null) {
            if (cVar != null) {
                cVar.callbackSuccessAsync(f10, handler);
            }
            return f10;
        }
        if (z11) {
            return null;
        }
        try {
            if (!charSequence2.toLowerCase().endsWith(".xml")) {
                Typeface d10 = r.e.d(context, resources, i10, charSequence2, i11);
                if (cVar != null) {
                    if (d10 != null) {
                        cVar.callbackSuccessAsync(d10, handler);
                    } else {
                        cVar.callbackFailAsync(-3, handler);
                    }
                }
                return d10;
            }
            d.a b10 = d.b(resources.getXml(i10), resources);
            if (b10 != null) {
                return r.e.c(context, b10, resources, i10, i11, cVar, handler, z10);
            }
            Log.e("ResourcesCompat", "Failed to find font-family tag");
            if (cVar != null) {
                cVar.callbackFailAsync(-3, handler);
            }
            return null;
        } catch (IOException e10) {
            Log.e("ResourcesCompat", "Failed to read xml resource " + charSequence2, e10);
            if (cVar != null) {
                cVar.callbackFailAsync(-3, handler);
            }
            return null;
        } catch (XmlPullParserException e11) {
            Log.e("ResourcesCompat", "Failed to parse xml resource " + charSequence2, e11);
            if (cVar != null) {
            }
            return null;
        }
    }
}
