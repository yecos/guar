package androidx.transition;

import android.os.Build;
import android.view.ViewGroup;

/* loaded from: classes.dex */
public abstract class z {

    /* renamed from: a, reason: collision with root package name */
    public static boolean f3542a = true;

    public static x a(ViewGroup viewGroup) {
        return new w(viewGroup);
    }

    public static void b(ViewGroup viewGroup, boolean z10) {
        if (f3542a) {
            try {
                viewGroup.suppressLayout(z10);
            } catch (NoSuchMethodError unused) {
                f3542a = false;
            }
        }
    }

    public static void c(ViewGroup viewGroup, boolean z10) {
        if (Build.VERSION.SDK_INT >= 29) {
            viewGroup.suppressLayout(z10);
        } else {
            b(viewGroup, z10);
        }
    }
}
