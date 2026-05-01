package b0;

import android.content.Context;
import android.os.Build;
import android.view.PointerIcon;

/* loaded from: classes.dex */
public final class f0 {

    /* renamed from: a, reason: collision with root package name */
    public Object f4333a;

    public f0(Object obj) {
        this.f4333a = obj;
    }

    public static f0 b(Context context, int i10) {
        PointerIcon systemIcon;
        if (Build.VERSION.SDK_INT < 24) {
            return new f0(null);
        }
        systemIcon = PointerIcon.getSystemIcon(context, i10);
        return new f0(systemIcon);
    }

    public Object a() {
        return this.f4333a;
    }
}
