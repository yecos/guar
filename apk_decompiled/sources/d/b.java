package d;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.Log;
import android.util.SparseArray;
import android.util.TypedValue;
import androidx.appcompat.widget.e2;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public abstract class b {

    /* renamed from: a, reason: collision with root package name */
    public static final ThreadLocal f12457a = new ThreadLocal();

    /* renamed from: b, reason: collision with root package name */
    public static final WeakHashMap f12458b = new WeakHashMap(0);

    /* renamed from: c, reason: collision with root package name */
    public static final Object f12459c = new Object();

    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public final ColorStateList f12460a;

        /* renamed from: b, reason: collision with root package name */
        public final Configuration f12461b;

        public a(ColorStateList colorStateList, Configuration configuration) {
            this.f12460a = colorStateList;
            this.f12461b = configuration;
        }
    }

    public static void a(Context context, int i10, ColorStateList colorStateList) {
        synchronized (f12459c) {
            WeakHashMap weakHashMap = f12458b;
            SparseArray sparseArray = (SparseArray) weakHashMap.get(context);
            if (sparseArray == null) {
                sparseArray = new SparseArray();
                weakHashMap.put(context, sparseArray);
            }
            sparseArray.append(i10, new a(colorStateList, context.getResources().getConfiguration()));
        }
    }

    public static ColorStateList b(Context context, int i10) {
        a aVar;
        synchronized (f12459c) {
            SparseArray sparseArray = (SparseArray) f12458b.get(context);
            if (sparseArray != null && sparseArray.size() > 0 && (aVar = (a) sparseArray.get(i10)) != null) {
                if (aVar.f12461b.equals(context.getResources().getConfiguration())) {
                    return aVar.f12460a;
                }
                sparseArray.remove(i10);
            }
            return null;
        }
    }

    public static ColorStateList c(Context context, int i10) {
        ColorStateList colorStateList;
        if (Build.VERSION.SDK_INT >= 23) {
            colorStateList = context.getColorStateList(i10);
            return colorStateList;
        }
        ColorStateList b10 = b(context, i10);
        if (b10 != null) {
            return b10;
        }
        ColorStateList f10 = f(context, i10);
        if (f10 == null) {
            return p.a.getColorStateList(context, i10);
        }
        a(context, i10, f10);
        return f10;
    }

    public static Drawable d(Context context, int i10) {
        return e2.h().j(context, i10);
    }

    public static TypedValue e() {
        ThreadLocal threadLocal = f12457a;
        TypedValue typedValue = (TypedValue) threadLocal.get();
        if (typedValue != null) {
            return typedValue;
        }
        TypedValue typedValue2 = new TypedValue();
        threadLocal.set(typedValue2);
        return typedValue2;
    }

    public static ColorStateList f(Context context, int i10) {
        if (g(context, i10)) {
            return null;
        }
        Resources resources = context.getResources();
        try {
            return q.a.a(resources, resources.getXml(i10), context.getTheme());
        } catch (Exception e10) {
            Log.e("AppCompatResources", "Failed to inflate ColorStateList, leaving it to the framework", e10);
            return null;
        }
    }

    public static boolean g(Context context, int i10) {
        Resources resources = context.getResources();
        TypedValue e10 = e();
        resources.getValue(i10, e10, true);
        int i11 = e10.type;
        return i11 >= 28 && i11 <= 31;
    }
}
