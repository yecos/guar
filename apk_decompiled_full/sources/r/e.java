package r;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Build;
import android.os.CancellationSignal;
import android.os.Handler;
import com.raizlabs.android.dbflow.sql.language.Operator;
import q.d;
import q.h;
import y.f;

/* loaded from: classes.dex */
public abstract class e {

    /* renamed from: a, reason: collision with root package name */
    public static final k f18266a;

    /* renamed from: b, reason: collision with root package name */
    public static final androidx.collection.e f18267b;

    public static class a extends f.c {

        /* renamed from: a, reason: collision with root package name */
        public h.c f18268a;

        public a(h.c cVar) {
            this.f18268a = cVar;
        }

        @Override // y.f.c
        public void a(int i10) {
            h.c cVar = this.f18268a;
            if (cVar != null) {
                cVar.onFontRetrievalFailed(i10);
            }
        }

        @Override // y.f.c
        public void b(Typeface typeface) {
            h.c cVar = this.f18268a;
            if (cVar != null) {
                cVar.onFontRetrieved(typeface);
            }
        }
    }

    static {
        int i10 = Build.VERSION.SDK_INT;
        if (i10 >= 29) {
            f18266a = new j();
        } else if (i10 >= 28) {
            f18266a = new i();
        } else if (i10 >= 26) {
            f18266a = new h();
        } else if (i10 >= 24 && g.m()) {
            f18266a = new g();
        } else if (i10 >= 21) {
            f18266a = new f();
        } else {
            f18266a = new k();
        }
        f18267b = new androidx.collection.e(16);
    }

    public static Typeface a(Context context, Typeface typeface, int i10) {
        Typeface g10;
        if (context != null) {
            return (Build.VERSION.SDK_INT >= 21 || (g10 = g(context, typeface, i10)) == null) ? Typeface.create(typeface, i10) : g10;
        }
        throw new IllegalArgumentException("Context cannot be null");
    }

    public static Typeface b(Context context, CancellationSignal cancellationSignal, f.b[] bVarArr, int i10) {
        return f18266a.c(context, cancellationSignal, bVarArr, i10);
    }

    public static Typeface c(Context context, d.a aVar, Resources resources, int i10, int i11, h.c cVar, Handler handler, boolean z10) {
        Typeface b10;
        if (aVar instanceof d.C0311d) {
            d.C0311d c0311d = (d.C0311d) aVar;
            Typeface h10 = h(c0311d.c());
            if (h10 != null) {
                if (cVar != null) {
                    cVar.callbackSuccessAsync(h10, handler);
                }
                return h10;
            }
            b10 = y.f.a(context, c0311d.b(), i11, !z10 ? cVar != null : c0311d.a() != 0, z10 ? c0311d.d() : -1, h.c.getHandler(handler), new a(cVar));
        } else {
            b10 = f18266a.b(context, (d.b) aVar, resources, i11);
            if (cVar != null) {
                if (b10 != null) {
                    cVar.callbackSuccessAsync(b10, handler);
                } else {
                    cVar.callbackFailAsync(-3, handler);
                }
            }
        }
        if (b10 != null) {
            f18267b.put(e(resources, i10, i11), b10);
        }
        return b10;
    }

    public static Typeface d(Context context, Resources resources, int i10, String str, int i11) {
        Typeface e10 = f18266a.e(context, resources, i10, str, i11);
        if (e10 != null) {
            f18267b.put(e(resources, i10, i11), e10);
        }
        return e10;
    }

    public static String e(Resources resources, int i10, int i11) {
        return resources.getResourcePackageName(i10) + Operator.Operation.MINUS + i10 + Operator.Operation.MINUS + i11;
    }

    public static Typeface f(Resources resources, int i10, int i11) {
        return (Typeface) f18267b.get(e(resources, i10, i11));
    }

    public static Typeface g(Context context, Typeface typeface, int i10) {
        k kVar = f18266a;
        d.b i11 = kVar.i(typeface);
        if (i11 == null) {
            return null;
        }
        return kVar.b(context, i11, context.getResources(), i10);
    }

    public static Typeface h(String str) {
        if (str == null || str.isEmpty()) {
            return null;
        }
        Typeface create = Typeface.create(str, 0);
        Typeface create2 = Typeface.create(Typeface.DEFAULT, 0);
        if (create == null || create.equals(create2)) {
            return null;
        }
        return create;
    }
}
