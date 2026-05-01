package androidx.transition;

import android.view.View;
import android.view.WindowId;

/* loaded from: classes.dex */
public class q0 implements r0 {

    /* renamed from: a, reason: collision with root package name */
    public final WindowId f3522a;

    public q0(View view) {
        this.f3522a = view.getWindowId();
    }

    public boolean equals(Object obj) {
        return (obj instanceof q0) && ((q0) obj).f3522a.equals(this.f3522a);
    }

    public int hashCode() {
        return this.f3522a.hashCode();
    }
}
