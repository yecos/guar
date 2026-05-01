package androidx.work;

import a1.k;
import a1.t;
import android.content.Context;
import androidx.work.a;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public final class WorkManagerInitializer implements v0.b {

    /* renamed from: a, reason: collision with root package name */
    public static final String f3604a = k.f("WrkMgrInitializer");

    @Override // v0.b
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public t a(Context context) {
        k.c().a(f3604a, "Initializing WorkManager with default configuration.", new Throwable[0]);
        t.d(context, new a.b().a());
        return t.c(context);
    }

    @Override // v0.b
    public List dependencies() {
        return Collections.emptyList();
    }
}
