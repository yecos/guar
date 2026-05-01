package h1;

import android.content.Context;

/* loaded from: classes.dex */
public class l {

    /* renamed from: e, reason: collision with root package name */
    public static l f14111e;

    /* renamed from: a, reason: collision with root package name */
    public a f14112a;

    /* renamed from: b, reason: collision with root package name */
    public b f14113b;

    /* renamed from: c, reason: collision with root package name */
    public j f14114c;

    /* renamed from: d, reason: collision with root package name */
    public k f14115d;

    public l(Context context, m1.a aVar) {
        Context applicationContext = context.getApplicationContext();
        this.f14112a = new a(applicationContext, aVar);
        this.f14113b = new b(applicationContext, aVar);
        this.f14114c = new j(applicationContext, aVar);
        this.f14115d = new k(applicationContext, aVar);
    }

    public static synchronized l c(Context context, m1.a aVar) {
        l lVar;
        synchronized (l.class) {
            if (f14111e == null) {
                f14111e = new l(context, aVar);
            }
            lVar = f14111e;
        }
        return lVar;
    }

    public a a() {
        return this.f14112a;
    }

    public b b() {
        return this.f14113b;
    }

    public j d() {
        return this.f14114c;
    }

    public k e() {
        return this.f14115d;
    }
}
