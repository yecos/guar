package androidx.savedstate;

import android.os.Bundle;
import androidx.lifecycle.d;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final b f3348a;

    /* renamed from: b, reason: collision with root package name */
    public final SavedStateRegistry f3349b = new SavedStateRegistry();

    public a(b bVar) {
        this.f3348a = bVar;
    }

    public static a a(b bVar) {
        return new a(bVar);
    }

    public SavedStateRegistry b() {
        return this.f3349b;
    }

    public void c(Bundle bundle) {
        d lifecycle = this.f3348a.getLifecycle();
        if (lifecycle.b() != d.c.INITIALIZED) {
            throw new IllegalStateException("Restarter must be created only during owner's initialization stage");
        }
        lifecycle.a(new Recreator(this.f3348a));
        this.f3349b.b(lifecycle, bundle);
    }

    public void d(Bundle bundle) {
        this.f3349b.c(bundle);
    }
}
