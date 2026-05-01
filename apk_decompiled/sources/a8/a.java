package a8;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.umeng.analytics.pro.f;
import t9.i;

/* loaded from: classes3.dex */
public final class a implements z7.b {
    @Override // z7.b
    public boolean a(int i10) {
        return true;
    }

    @Override // z7.b
    public void b(z7.a aVar) {
        i.g(aVar, "callback");
    }

    @Override // z7.b
    public int c(Context context) {
        i.g(context, f.X);
        return 0;
    }

    @Override // z7.b
    public void d(Activity activity) {
        i.g(activity, "activity");
    }

    @Override // z7.b
    public void e(int i10, int i11, Intent intent) {
    }

    @Override // z7.b
    public void f(Activity activity) {
        i.g(activity, "activity");
    }
}
