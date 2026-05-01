package q2;

import android.os.Build;
import java.lang.reflect.Field;

/* loaded from: classes.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    public static boolean f18191a;

    public static void a() {
        if (f18191a) {
            return;
        }
        f18191a = true;
        try {
            Class<?> cls = Class.forName("android.app.QueuedWork");
            if (Build.VERSION.SDK_INT >= 26) {
                Field declaredField = cls.getDeclaredField("sFinishers");
                declaredField.setAccessible(true);
                declaredField.set(null, new c());
            } else {
                Field declaredField2 = cls.getDeclaredField("sPendingWorkFinishers");
                declaredField2.setAccessible(true);
                declaredField2.set(null, new b());
            }
        } catch (Throwable th) {
            th.printStackTrace();
            m2.a.a(th, "FIX SP ANR FAIL");
        }
    }
}
