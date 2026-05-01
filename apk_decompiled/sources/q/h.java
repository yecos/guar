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
import java.util.WeakHashMap;

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
        To view partially-correct add '--show-bad-code' argument
    */
    public static android.graphics.Typeface l(android.content.Context r15, android.content.res.Resources r16, android.util.TypedValue r17, int r18, int r19, q.h.c r20, android.os.Handler r21, boolean r22, boolean r23) {
        /*
            r0 = r16
            r1 = r17
            r4 = r18
            r5 = r19
            r9 = r20
            r10 = r21
            java.lang.String r11 = "ResourcesCompat"
            java.lang.CharSequence r2 = r1.string
            if (r2 == 0) goto Laa
            java.lang.String r12 = r2.toString()
            java.lang.String r1 = "res/"
            boolean r1 = r12.startsWith(r1)
            r13 = -3
            r14 = 0
            if (r1 != 0) goto L26
            if (r9 == 0) goto L25
            r9.callbackFailAsync(r13, r10)
        L25:
            return r14
        L26:
            android.graphics.Typeface r1 = r.e.f(r0, r4, r5)
            if (r1 == 0) goto L32
            if (r9 == 0) goto L31
            r9.callbackSuccessAsync(r1, r10)
        L31:
            return r1
        L32:
            if (r23 == 0) goto L35
            return r14
        L35:
            java.lang.String r1 = r12.toLowerCase()     // Catch: java.io.IOException -> L79 org.xmlpull.v1.XmlPullParserException -> L8f
            java.lang.String r2 = ".xml"
            boolean r1 = r1.endsWith(r2)     // Catch: java.io.IOException -> L79 org.xmlpull.v1.XmlPullParserException -> L8f
            if (r1 == 0) goto L68
            android.content.res.XmlResourceParser r1 = r0.getXml(r4)     // Catch: java.io.IOException -> L79 org.xmlpull.v1.XmlPullParserException -> L8f
            q.d$a r2 = q.d.b(r1, r0)     // Catch: java.io.IOException -> L79 org.xmlpull.v1.XmlPullParserException -> L8f
            if (r2 != 0) goto L56
            java.lang.String r0 = "Failed to find font-family tag"
            android.util.Log.e(r11, r0)     // Catch: java.io.IOException -> L79 org.xmlpull.v1.XmlPullParserException -> L8f
            if (r9 == 0) goto L55
            r9.callbackFailAsync(r13, r10)     // Catch: java.io.IOException -> L79 org.xmlpull.v1.XmlPullParserException -> L8f
        L55:
            return r14
        L56:
            r1 = r15
            r3 = r16
            r4 = r18
            r5 = r19
            r6 = r20
            r7 = r21
            r8 = r22
            android.graphics.Typeface r0 = r.e.c(r1, r2, r3, r4, r5, r6, r7, r8)     // Catch: java.io.IOException -> L79 org.xmlpull.v1.XmlPullParserException -> L8f
            return r0
        L68:
            r1 = r15
            android.graphics.Typeface r0 = r.e.d(r15, r0, r4, r12, r5)     // Catch: java.io.IOException -> L79 org.xmlpull.v1.XmlPullParserException -> L8f
            if (r9 == 0) goto L78
            if (r0 == 0) goto L75
            r9.callbackSuccessAsync(r0, r10)     // Catch: java.io.IOException -> L79 org.xmlpull.v1.XmlPullParserException -> L8f
            goto L78
        L75:
            r9.callbackFailAsync(r13, r10)     // Catch: java.io.IOException -> L79 org.xmlpull.v1.XmlPullParserException -> L8f
        L78:
            return r0
        L79:
            r0 = move-exception
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Failed to read xml resource "
            r1.append(r2)
            r1.append(r12)
            java.lang.String r1 = r1.toString()
            android.util.Log.e(r11, r1, r0)
            goto La4
        L8f:
            r0 = move-exception
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Failed to parse xml resource "
            r1.append(r2)
            r1.append(r12)
            java.lang.String r1 = r1.toString()
            android.util.Log.e(r11, r1, r0)
        La4:
            if (r9 == 0) goto La9
            r9.callbackFailAsync(r13, r10)
        La9:
            return r14
        Laa:
            android.content.res.Resources$NotFoundException r2 = new android.content.res.Resources$NotFoundException
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r5 = "Resource \""
            r3.append(r5)
            java.lang.String r0 = r0.getResourceName(r4)
            r3.append(r0)
            java.lang.String r0 = "\" ("
            r3.append(r0)
            java.lang.String r0 = java.lang.Integer.toHexString(r18)
            r3.append(r0)
            java.lang.String r0 = ") is not a Font: "
            r3.append(r0)
            r3.append(r1)
            java.lang.String r0 = r3.toString()
            r2.<init>(r0)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: q.h.l(android.content.Context, android.content.res.Resources, android.util.TypedValue, int, int, q.h$c, android.os.Handler, boolean, boolean):android.graphics.Typeface");
    }
}
