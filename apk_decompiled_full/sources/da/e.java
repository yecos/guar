package da;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.view.Choreographer;
import h9.l;
import h9.m;

/* loaded from: classes3.dex */
public abstract class e {

    /* renamed from: a, reason: collision with root package name */
    public static final d f12755a;
    private static volatile Choreographer choreographer;

    static {
        Object a10;
        try {
            l.a aVar = l.f14231a;
            a10 = l.a(new c(a(Looper.getMainLooper(), true), null, 2, null));
        } catch (Throwable th) {
            l.a aVar2 = l.f14231a;
            a10 = l.a(m.a(th));
        }
        f12755a = (d) (l.c(a10) ? null : a10);
    }

    public static final Handler a(Looper looper, boolean z10) {
        if (!z10) {
            return new Handler(looper);
        }
        if (Build.VERSION.SDK_INT < 28) {
            try {
                return (Handler) Handler.class.getDeclaredConstructor(Looper.class, Handler.Callback.class, Boolean.TYPE).newInstance(looper, null, Boolean.TRUE);
            } catch (NoSuchMethodException unused) {
                return new Handler(looper);
            }
        }
        Object invoke = Handler.class.getDeclaredMethod("createAsync", Looper.class).invoke(null, looper);
        if (invoke != null) {
            return (Handler) invoke;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.os.Handler");
    }
}
