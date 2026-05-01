package r;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.CancellationSignal;
import android.util.Log;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.concurrent.ConcurrentHashMap;
import q.d;
import y.f;

/* loaded from: classes.dex */
public class k {

    /* renamed from: a, reason: collision with root package name */
    public ConcurrentHashMap f18285a = new ConcurrentHashMap();

    public class a implements c {
        public a() {
        }

        @Override // r.k.c
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public int b(f.b bVar) {
            return bVar.e();
        }

        @Override // r.k.c
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public boolean a(f.b bVar) {
            return bVar.f();
        }
    }

    public class b implements c {
        public b() {
        }

        @Override // r.k.c
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public int b(d.c cVar) {
            return cVar.e();
        }

        @Override // r.k.c
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public boolean a(d.c cVar) {
            return cVar.f();
        }
    }

    public interface c {
        boolean a(Object obj);

        int b(Object obj);
    }

    public static Object g(Object[] objArr, int i10, c cVar) {
        int i11 = (i10 & 1) == 0 ? 400 : 700;
        boolean z10 = (i10 & 2) != 0;
        Object obj = null;
        int i12 = Integer.MAX_VALUE;
        for (Object obj2 : objArr) {
            int abs = (Math.abs(cVar.b(obj2) - i11) * 2) + (cVar.a(obj2) == z10 ? 0 : 1);
            if (obj == null || i12 > abs) {
                obj = obj2;
                i12 = abs;
            }
        }
        return obj;
    }

    public static long j(Typeface typeface) {
        if (typeface == null) {
            return 0L;
        }
        try {
            Field declaredField = Typeface.class.getDeclaredField("native_instance");
            declaredField.setAccessible(true);
            return ((Number) declaredField.get(typeface)).longValue();
        } catch (IllegalAccessException e10) {
            Log.e("TypefaceCompatBaseImpl", "Could not retrieve font from family.", e10);
            return 0L;
        } catch (NoSuchFieldException e11) {
            Log.e("TypefaceCompatBaseImpl", "Could not retrieve font from family.", e11);
            return 0L;
        }
    }

    public final void a(Typeface typeface, d.b bVar) {
        long j10 = j(typeface);
        if (j10 != 0) {
            this.f18285a.put(Long.valueOf(j10), bVar);
        }
    }

    public Typeface b(Context context, d.b bVar, Resources resources, int i10) {
        d.c f10 = f(bVar, i10);
        if (f10 == null) {
            return null;
        }
        Typeface d10 = e.d(context, resources, f10.b(), f10.a(), i10);
        a(d10, bVar);
        return d10;
    }

    public Typeface c(Context context, CancellationSignal cancellationSignal, f.b[] bVarArr, int i10) {
        InputStream inputStream;
        InputStream inputStream2 = null;
        if (bVarArr.length < 1) {
            return null;
        }
        try {
            inputStream = context.getContentResolver().openInputStream(h(bVarArr, i10).d());
        } catch (IOException unused) {
            inputStream = null;
        } catch (Throwable th) {
            th = th;
        }
        try {
            Typeface d10 = d(context, inputStream);
            l.a(inputStream);
            return d10;
        } catch (IOException unused2) {
            l.a(inputStream);
            return null;
        } catch (Throwable th2) {
            th = th2;
            inputStream2 = inputStream;
            l.a(inputStream2);
            throw th;
        }
    }

    public Typeface d(Context context, InputStream inputStream) {
        File e10 = l.e(context);
        if (e10 == null) {
            return null;
        }
        try {
            if (l.d(e10, inputStream)) {
                return Typeface.createFromFile(e10.getPath());
            }
            return null;
        } catch (RuntimeException unused) {
            return null;
        } finally {
            e10.delete();
        }
    }

    public Typeface e(Context context, Resources resources, int i10, String str, int i11) {
        File e10 = l.e(context);
        if (e10 == null) {
            return null;
        }
        try {
            if (l.c(e10, resources, i10)) {
                return Typeface.createFromFile(e10.getPath());
            }
            return null;
        } catch (RuntimeException unused) {
            return null;
        } finally {
            e10.delete();
        }
    }

    public final d.c f(d.b bVar, int i10) {
        return (d.c) g(bVar.a(), i10, new b());
    }

    public f.b h(f.b[] bVarArr, int i10) {
        return (f.b) g(bVarArr, i10, new a());
    }

    public d.b i(Typeface typeface) {
        long j10 = j(typeface);
        if (j10 == 0) {
            return null;
        }
        return (d.b) this.f18285a.get(Long.valueOf(j10));
    }
}
