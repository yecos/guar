package r3;

import java.util.Collections;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes.dex */
public final class l implements Iterable {

    /* renamed from: a, reason: collision with root package name */
    public Map f18448a;

    public l() {
    }

    public l(Map map) {
        this.f18448a = map;
    }

    public j a(String str, Class[] clsArr) {
        Map map = this.f18448a;
        if (map == null) {
            return null;
        }
        return (j) map.get(new y(str, clsArr));
    }

    @Override // java.lang.Iterable
    public Iterator iterator() {
        Map map = this.f18448a;
        return map == null ? Collections.emptyIterator() : map.values().iterator();
    }
}
