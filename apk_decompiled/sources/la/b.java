package la;

import okhttp3.Interceptor;
import s9.l;
import t9.g;
import t9.i;

/* loaded from: classes3.dex */
public final class b implements Interceptor {

    /* renamed from: b, reason: collision with root package name */
    public static final a f16439b = new a(null);

    /* renamed from: c, reason: collision with root package name */
    public static l f16440c;

    /* renamed from: a, reason: collision with root package name */
    public final String f16441a;

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(g gVar) {
            this();
        }

        public final void a(l lVar) {
            i.g(lVar, "slbCallback");
            b(lVar);
        }

        public final void b(l lVar) {
            b.f16440c = lVar;
        }
    }

    public b() {
        String simpleName = b.class.getSimpleName();
        i.f(simpleName, "javaClass.simpleName");
        this.f16441a = simpleName;
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x00f2, code lost:
    
        if (ba.t.o(r4, "Canceled", false, r3, r2) == true) goto L31;
     */
    @Override // okhttp3.Interceptor
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public okhttp3.Response intercept(okhttp3.Interceptor.Chain r24) {
        /*
            Method dump skipped, instructions count: 351
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: la.b.intercept(okhttp3.Interceptor$Chain):okhttp3.Response");
    }
}
