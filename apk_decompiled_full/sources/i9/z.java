package i9;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes3.dex */
public abstract class z extends y {
    public static final Map d() {
        u uVar = u.f14402a;
        t9.i.e(uVar, "null cannot be cast to non-null type kotlin.collections.Map<K of kotlin.collections.MapsKt__MapsKt.emptyMap, V of kotlin.collections.MapsKt__MapsKt.emptyMap>");
        return uVar;
    }

    public static final Map e(Map map) {
        t9.i.g(map, "<this>");
        int size = map.size();
        return size != 0 ? size != 1 ? map : y.c(map) : d();
    }

    public static final void f(Map map, Iterable iterable) {
        t9.i.g(map, "<this>");
        t9.i.g(iterable, "pairs");
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            h9.k kVar = (h9.k) it.next();
            map.put(kVar.a(), kVar.b());
        }
    }

    public static final Map g(Iterable iterable) {
        t9.i.g(iterable, "<this>");
        if (!(iterable instanceof Collection)) {
            return e(h(iterable, new LinkedHashMap()));
        }
        Collection collection = (Collection) iterable;
        int size = collection.size();
        if (size == 0) {
            return d();
        }
        if (size != 1) {
            return h(iterable, new LinkedHashMap(y.a(collection.size())));
        }
        return y.b((h9.k) (iterable instanceof List ? ((List) iterable).get(0) : iterable.iterator().next()));
    }

    public static final Map h(Iterable iterable, Map map) {
        t9.i.g(iterable, "<this>");
        t9.i.g(map, FirebaseAnalytics.Param.DESTINATION);
        f(map, iterable);
        return map;
    }
}
