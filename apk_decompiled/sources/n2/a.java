package n2;

import android.app.Application;
import com.core.sysopt.so.SoOptimizer;
import p2.d;

/* loaded from: classes.dex */
public abstract class a {
    public static void a(Application application) {
        q2.a.a();
        SoOptimizer.bindApplication(application);
        new d().f(application);
    }
}
