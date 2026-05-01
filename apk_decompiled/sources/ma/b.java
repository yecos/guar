package ma;

import android.app.Activity;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public static final b f16848a = new b();

    /* renamed from: b, reason: collision with root package name */
    public static List f16849b = new ArrayList();

    public final void a(Activity activity) {
        t9.i.g(activity, "activity");
        f16849b.add(activity);
    }

    public final void b() {
        for (Activity activity : f16849b) {
            if (!activity.isFinishing()) {
                activity.finish();
            }
        }
    }

    public final Activity c() {
        return (Activity) f16849b.get(r0.size() - 1);
    }

    public final void d(Activity activity) {
        t9.i.g(activity, "activity");
        f16849b.remove(activity);
    }
}
