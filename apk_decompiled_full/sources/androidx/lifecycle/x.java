package androidx.lifecycle;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* loaded from: classes.dex */
public class x {

    /* renamed from: a, reason: collision with root package name */
    public final HashMap f2609a = new HashMap();

    public final void a() {
        Iterator it = this.f2609a.values().iterator();
        while (it.hasNext()) {
            ((v) it.next()).a();
        }
        this.f2609a.clear();
    }

    public final v b(String str) {
        return (v) this.f2609a.get(str);
    }

    public Set c() {
        return new HashSet(this.f2609a.keySet());
    }

    public final void d(String str, v vVar) {
        v vVar2 = (v) this.f2609a.put(str, vVar);
        if (vVar2 != null) {
            vVar2.d();
        }
    }
}
