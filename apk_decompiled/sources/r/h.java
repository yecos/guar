package r;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.fonts.FontVariationAxis;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.Map;
import q.d;
import y.f;

/* loaded from: classes.dex */
public class h extends f {

    /* renamed from: g, reason: collision with root package name */
    public final Class f18278g;

    /* renamed from: h, reason: collision with root package name */
    public final Constructor f18279h;

    /* renamed from: i, reason: collision with root package name */
    public final Method f18280i;

    /* renamed from: j, reason: collision with root package name */
    public final Method f18281j;

    /* renamed from: k, reason: collision with root package name */
    public final Method f18282k;

    /* renamed from: l, reason: collision with root package name */
    public final Method f18283l;

    /* renamed from: m, reason: collision with root package name */
    public final Method f18284m;

    public h() {
        Class cls;
        Constructor constructor;
        Method method;
        Method method2;
        Method method3;
        Method method4;
        Method method5;
        try {
            cls = y();
            constructor = z(cls);
            method = v(cls);
            method2 = w(cls);
            method3 = A(cls);
            method4 = u(cls);
            method5 = x(cls);
        } catch (ClassNotFoundException | NoSuchMethodException e10) {
            Log.e("TypefaceCompatApi26Impl", "Unable to collect necessary methods for class " + e10.getClass().getName(), e10);
            cls = null;
            constructor = null;
            method = null;
            method2 = null;
            method3 = null;
            method4 = null;
            method5 = null;
        }
        this.f18278g = cls;
        this.f18279h = constructor;
        this.f18280i = method;
        this.f18281j = method2;
        this.f18282k = method3;
        this.f18283l = method4;
        this.f18284m = method5;
    }

    private Object o() {
        try {
            return this.f18279h.newInstance(new Object[0]);
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException unused) {
            return null;
        }
    }

    public Method A(Class cls) {
        return cls.getMethod("freeze", new Class[0]);
    }

    @Override // r.f, r.k
    public Typeface b(Context context, d.b bVar, Resources resources, int i10) {
        if (!t()) {
            return super.b(context, bVar, resources, i10);
        }
        Object o10 = o();
        if (o10 == null) {
            return null;
        }
        for (d.c cVar : bVar.a()) {
            if (!q(context, o10, cVar.a(), cVar.c(), cVar.e(), cVar.f() ? 1 : 0, FontVariationAxis.fromFontVariationSettings(cVar.d()))) {
                p(o10);
                return null;
            }
        }
        if (s(o10)) {
            return l(o10);
        }
        return null;
    }

    @Override // r.f, r.k
    public Typeface c(Context context, CancellationSignal cancellationSignal, f.b[] bVarArr, int i10) {
        Typeface l10;
        if (bVarArr.length < 1) {
            return null;
        }
        if (!t()) {
            f.b h10 = h(bVarArr, i10);
            try {
                ParcelFileDescriptor openFileDescriptor = context.getContentResolver().openFileDescriptor(h10.d(), "r", cancellationSignal);
                if (openFileDescriptor == null) {
                    if (openFileDescriptor != null) {
                        openFileDescriptor.close();
                    }
                    return null;
                }
                try {
                    Typeface build = new Typeface.Builder(openFileDescriptor.getFileDescriptor()).setWeight(h10.e()).setItalic(h10.f()).build();
                    openFileDescriptor.close();
                    return build;
                } finally {
                }
            } catch (IOException unused) {
                return null;
            }
        }
        Map h11 = l.h(context, bVarArr, cancellationSignal);
        Object o10 = o();
        if (o10 == null) {
            return null;
        }
        boolean z10 = false;
        for (f.b bVar : bVarArr) {
            ByteBuffer byteBuffer = (ByteBuffer) h11.get(bVar.d());
            if (byteBuffer != null) {
                if (!r(o10, byteBuffer, bVar.c(), bVar.e(), bVar.f() ? 1 : 0)) {
                    p(o10);
                    return null;
                }
                z10 = true;
            }
        }
        if (!z10) {
            p(o10);
            return null;
        }
        if (s(o10) && (l10 = l(o10)) != null) {
            return Typeface.create(l10, i10);
        }
        return null;
    }

    @Override // r.k
    public Typeface e(Context context, Resources resources, int i10, String str, int i11) {
        if (!t()) {
            return super.e(context, resources, i10, str, i11);
        }
        Object o10 = o();
        if (o10 == null) {
            return null;
        }
        if (!q(context, o10, str, 0, -1, -1, null)) {
            p(o10);
            return null;
        }
        if (s(o10)) {
            return l(o10);
        }
        return null;
    }

    public Typeface l(Object obj) {
        try {
            Object newInstance = Array.newInstance((Class<?>) this.f18278g, 1);
            Array.set(newInstance, 0, obj);
            return (Typeface) this.f18284m.invoke(null, newInstance, -1, -1);
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return null;
        }
    }

    public final void p(Object obj) {
        try {
            this.f18283l.invoke(obj, new Object[0]);
        } catch (IllegalAccessException | InvocationTargetException unused) {
        }
    }

    public final boolean q(Context context, Object obj, String str, int i10, int i11, int i12, FontVariationAxis[] fontVariationAxisArr) {
        try {
            return ((Boolean) this.f18280i.invoke(obj, context.getAssets(), str, 0, Boolean.FALSE, Integer.valueOf(i10), Integer.valueOf(i11), Integer.valueOf(i12), fontVariationAxisArr)).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return false;
        }
    }

    public final boolean r(Object obj, ByteBuffer byteBuffer, int i10, int i11, int i12) {
        try {
            return ((Boolean) this.f18281j.invoke(obj, byteBuffer, Integer.valueOf(i10), null, Integer.valueOf(i11), Integer.valueOf(i12))).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return false;
        }
    }

    public final boolean s(Object obj) {
        try {
            return ((Boolean) this.f18282k.invoke(obj, new Object[0])).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return false;
        }
    }

    public final boolean t() {
        return this.f18280i != null;
    }

    public Method u(Class cls) {
        return cls.getMethod("abortCreation", new Class[0]);
    }

    public Method v(Class cls) {
        Class<?> cls2 = Integer.TYPE;
        return cls.getMethod("addFontFromAssetManager", AssetManager.class, String.class, cls2, Boolean.TYPE, cls2, cls2, cls2, FontVariationAxis[].class);
    }

    public Method w(Class cls) {
        Class<?> cls2 = Integer.TYPE;
        return cls.getMethod("addFontFromBuffer", ByteBuffer.class, cls2, FontVariationAxis[].class, cls2, cls2);
    }

    public Method x(Class cls) {
        Class cls2 = Integer.TYPE;
        Method declaredMethod = Typeface.class.getDeclaredMethod("createFromFamiliesWithDefault", Array.newInstance((Class<?>) cls, 1).getClass(), cls2, cls2);
        declaredMethod.setAccessible(true);
        return declaredMethod;
    }

    public Class y() {
        return Class.forName("android.graphics.FontFamily");
    }

    public Constructor z(Class cls) {
        return cls.getConstructor(new Class[0]);
    }
}
