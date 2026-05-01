package y;

import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Typeface;
import com.raizlabs.android.dbflow.sql.language.Operator;
import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import y.f;

/* loaded from: classes.dex */
public abstract class e {

    /* renamed from: a, reason: collision with root package name */
    public static final androidx.collection.e f19677a = new androidx.collection.e(16);

    /* renamed from: b, reason: collision with root package name */
    public static final ExecutorService f19678b = g.a("fonts-androidx", 10, 10000);

    /* renamed from: c, reason: collision with root package name */
    public static final Object f19679c = new Object();

    /* renamed from: d, reason: collision with root package name */
    public static final androidx.collection.g f19680d = new androidx.collection.g();

    public class a implements Callable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f19681a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Context f19682b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ y.d f19683c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ int f19684d;

        public a(String str, Context context, y.d dVar, int i10) {
            this.f19681a = str;
            this.f19682b = context;
            this.f19683c = dVar;
            this.f19684d = i10;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public C0339e call() {
            return e.c(this.f19681a, this.f19682b, this.f19683c, this.f19684d);
        }
    }

    public class b implements a0.a {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ y.a f19685a;

        public b(y.a aVar) {
            this.f19685a = aVar;
        }

        @Override // a0.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(C0339e c0339e) {
            this.f19685a.b(c0339e);
        }
    }

    public class c implements Callable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f19686a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Context f19687b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ y.d f19688c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ int f19689d;

        public c(String str, Context context, y.d dVar, int i10) {
            this.f19686a = str;
            this.f19687b = context;
            this.f19688c = dVar;
            this.f19689d = i10;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public C0339e call() {
            return e.c(this.f19686a, this.f19687b, this.f19688c, this.f19689d);
        }
    }

    public class d implements a0.a {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f19690a;

        public d(String str) {
            this.f19690a = str;
        }

        @Override // a0.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(C0339e c0339e) {
            synchronized (e.f19679c) {
                androidx.collection.g gVar = e.f19680d;
                ArrayList arrayList = (ArrayList) gVar.get(this.f19690a);
                if (arrayList == null) {
                    return;
                }
                gVar.remove(this.f19690a);
                for (int i10 = 0; i10 < arrayList.size(); i10++) {
                    ((a0.a) arrayList.get(i10)).accept(c0339e);
                }
            }
        }
    }

    public static String a(y.d dVar, int i10) {
        return dVar.d() + Operator.Operation.MINUS + i10;
    }

    public static int b(f.a aVar) {
        int i10 = 1;
        if (aVar.c() != 0) {
            return aVar.c() != 1 ? -3 : -2;
        }
        f.b[] b10 = aVar.b();
        if (b10 != null && b10.length != 0) {
            i10 = 0;
            for (f.b bVar : b10) {
                int b11 = bVar.b();
                if (b11 != 0) {
                    if (b11 < 0) {
                        return -3;
                    }
                    return b11;
                }
            }
        }
        return i10;
    }

    public static C0339e c(String str, Context context, y.d dVar, int i10) {
        androidx.collection.e eVar = f19677a;
        Typeface typeface = (Typeface) eVar.get(str);
        if (typeface != null) {
            return new C0339e(typeface);
        }
        try {
            f.a d10 = y.c.d(context, dVar, null);
            int b10 = b(d10);
            if (b10 != 0) {
                return new C0339e(b10);
            }
            Typeface b11 = r.e.b(context, null, d10.b(), i10);
            if (b11 == null) {
                return new C0339e(-3);
            }
            eVar.put(str, b11);
            return new C0339e(b11);
        } catch (PackageManager.NameNotFoundException unused) {
            return new C0339e(-1);
        }
    }

    public static Typeface d(Context context, y.d dVar, int i10, Executor executor, y.a aVar) {
        String a10 = a(dVar, i10);
        Typeface typeface = (Typeface) f19677a.get(a10);
        if (typeface != null) {
            aVar.b(new C0339e(typeface));
            return typeface;
        }
        b bVar = new b(aVar);
        synchronized (f19679c) {
            androidx.collection.g gVar = f19680d;
            ArrayList arrayList = (ArrayList) gVar.get(a10);
            if (arrayList != null) {
                arrayList.add(bVar);
                return null;
            }
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add(bVar);
            gVar.put(a10, arrayList2);
            c cVar = new c(a10, context, dVar, i10);
            if (executor == null) {
                executor = f19678b;
            }
            g.b(executor, cVar, new d(a10));
            return null;
        }
    }

    public static Typeface e(Context context, y.d dVar, y.a aVar, int i10, int i11) {
        String a10 = a(dVar, i10);
        Typeface typeface = (Typeface) f19677a.get(a10);
        if (typeface != null) {
            aVar.b(new C0339e(typeface));
            return typeface;
        }
        if (i11 == -1) {
            C0339e c10 = c(a10, context, dVar, i10);
            aVar.b(c10);
            return c10.f19691a;
        }
        try {
            C0339e c0339e = (C0339e) g.c(f19678b, new a(a10, context, dVar, i10), i11);
            aVar.b(c0339e);
            return c0339e.f19691a;
        } catch (InterruptedException unused) {
            aVar.b(new C0339e(-3));
            return null;
        }
    }

    /* renamed from: y.e$e, reason: collision with other inner class name */
    public static final class C0339e {

        /* renamed from: a, reason: collision with root package name */
        public final Typeface f19691a;

        /* renamed from: b, reason: collision with root package name */
        public final int f19692b;

        public C0339e(int i10) {
            this.f19691a = null;
            this.f19692b = i10;
        }

        public boolean a() {
            return this.f19692b == 0;
        }

        public C0339e(Typeface typeface) {
            this.f19691a = typeface;
            this.f19692b = 0;
        }
    }
}
