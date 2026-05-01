package b1;

import a1.q;
import android.os.Handler;
import android.os.Looper;

/* loaded from: classes.dex */
public class a implements q {

    /* renamed from: a, reason: collision with root package name */
    public final Handler f4383a = x.f.a(Looper.getMainLooper());

    @Override // a1.q
    public void a(Runnable runnable) {
        this.f4383a.removeCallbacks(runnable);
    }

    @Override // a1.q
    public void b(long j10, Runnable runnable) {
        this.f4383a.postDelayed(runnable, j10);
    }
}
