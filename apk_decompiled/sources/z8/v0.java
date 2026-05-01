package z8;

import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Set;

/* loaded from: classes3.dex */
public abstract class v0 {

    /* renamed from: a, reason: collision with root package name */
    public final Set f20958a = Collections.newSetFromMap(new IdentityHashMap());

    public final boolean a(Object... objArr) {
        for (Object obj : objArr) {
            if (this.f20958a.contains(obj)) {
                return true;
            }
        }
        return false;
    }

    public abstract void b();

    public abstract void c();

    public final boolean d() {
        return !this.f20958a.isEmpty();
    }

    public final void e(Object obj, boolean z10) {
        int size = this.f20958a.size();
        if (z10) {
            this.f20958a.add(obj);
            if (size == 0) {
                b();
                return;
            }
            return;
        }
        if (this.f20958a.remove(obj) && size == 1) {
            c();
        }
    }
}
