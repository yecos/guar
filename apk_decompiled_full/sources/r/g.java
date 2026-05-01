package r;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.CancellationSignal;
import android.util.Log;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.List;
import q.d;
import y.f;

/* loaded from: classes.dex */
public class g extends k {

    /* renamed from: b, reason: collision with root package name */
    public static final Class f18274b;

    /* renamed from: c, reason: collision with root package name */
    public static final Constructor f18275c;

    /* renamed from: d, reason: collision with root package name */
    public static final Method f18276d;

    /* renamed from: e, reason: collision with root package name */
    public static final Method f18277e;

    static {
        Class<?> cls;
        Method method;
        Constructor<?> constructor;
        Method method2;
        try {
            cls = Class.forName("android.graphics.FontFamily");
            constructor = cls.getConstructor(new Class[0]);
            Class<?> cls2 = Integer.TYPE;
            method2 = cls.getMethod("addFontWeightStyle", ByteBuffer.class, cls2, List.class, cls2, Boolean.TYPE);
            method = Typeface.class.getMethod("createFromFamiliesWithDefault", Array.newInstance(cls, 1).getClass());
        } catch (ClassNotFoundException | NoSuchMethodException e10) {
            Log.e("TypefaceCompatApi24Impl", e10.getClass().getName(), e10);
            cls = null;
            method = null;
            constructor = null;
            method2 = null;
        }
        f18275c = constructor;
        f18274b = cls;
        f18276d = method2;
        f18277e = method;
    }

    public static boolean k(Object obj, ByteBuffer byteBuffer, int i10, int i11, boolean z10) {
        try {
            return ((Boolean) f18276d.invoke(obj, byteBuffer, Integer.valueOf(i10), null, Integer.valueOf(i11), Boolean.valueOf(z10))).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return false;
        }
    }

    public static Typeface l(Object obj) {
        try {
            Object newInstance = Array.newInstance((Class<?>) f18274b, 1);
            Array.set(newInstance, 0, obj);
            return (Typeface) f18277e.invoke(null, newInstance);
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return null;
        }
    }

    public static boolean m() {
        return f18276d != null;
    }

    public static Object n() {
        try {
            return f18275c.newInstance(new Object[0]);
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException unused) {
            return null;
        }
    }

    @Override // r.k
    public Typeface b(Context context, d.b bVar, Resources resources, int i10) {
        Object n10 = n();
        if (n10 == null) {
            return null;
        }
        for (d.c cVar : bVar.a()) {
            ByteBuffer b10 = l.b(context, resources, cVar.b());
            if (b10 == null || !k(n10, b10, cVar.c(), cVar.e(), cVar.f())) {
                return null;
            }
        }
        return l(n10);
    }

    @Override // r.k
    public Typeface c(Context context, CancellationSignal cancellationSignal, f.b[] bVarArr, int i10) {
        Object n10 = n();
        if (n10 == null) {
            return null;
        }
        androidx.collection.g gVar = new androidx.collection.g();
        for (f.b bVar : bVarArr) {
            Uri d10 = bVar.d();
            ByteBuffer byteBuffer = (ByteBuffer) gVar.get(d10);
            if (byteBuffer == null) {
                byteBuffer = l.f(context, cancellationSignal, d10);
                gVar.put(d10, byteBuffer);
            }
            if (byteBuffer == null || !k(n10, byteBuffer, bVar.c(), bVar.e(), bVar.f())) {
                return null;
            }
        }
        Typeface l10 = l(n10);
        if (l10 == null) {
            return null;
        }
        return Typeface.create(l10, i10);
    }
}
