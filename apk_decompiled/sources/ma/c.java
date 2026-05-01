package ma;

import android.content.Context;
import okhttp3.Interceptor;

/* loaded from: classes.dex */
public final class c implements Interceptor {

    /* renamed from: a, reason: collision with root package name */
    public final Context f16850a;

    /* renamed from: b, reason: collision with root package name */
    public final String f16851b;

    public c(Context context) {
        t9.i.g(context, com.umeng.analytics.pro.f.X);
        this.f16850a = context;
        String simpleName = c.class.getSimpleName();
        t9.i.f(simpleName, "javaClass.simpleName");
        this.f16851b = simpleName;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(9:0|1|(2:2|3)|(7:(5:(1:54)|56|13|14|15)|10|11|12|13|14|15)|6|7|8|9|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x00aa, code lost:
    
        if (ba.t.o(r9, "Canceled", r6, 2, null) == true) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x008b, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x008c, code lost:
    
        r18 = r6;
        r6 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x0051, code lost:
    
        if (ba.t.o(r14, "epg/", false, 2, null) == false) goto L9;
     */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00b0  */
    @Override // okhttp3.Interceptor
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public okhttp3.Response intercept(okhttp3.Interceptor.Chain r18) {
        /*
            Method dump skipped, instructions count: 294
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ma.c.intercept(okhttp3.Interceptor$Chain):okhttp3.Response");
    }
}
