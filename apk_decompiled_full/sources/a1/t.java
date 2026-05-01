package a1;

import android.content.Context;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public abstract class t {
    public static t c(Context context) {
        return b1.j.j(context);
    }

    public static void d(Context context, androidx.work.a aVar) {
        b1.j.d(context, aVar);
    }

    public final n a(u uVar) {
        return b(Collections.singletonList(uVar));
    }

    public abstract n b(List list);
}
