package i9;

import java.util.Collections;
import java.util.Map;

/* loaded from: classes3.dex */
public abstract class y extends x {
    public static final int a(int i10) {
        if (i10 < 0) {
            return i10;
        }
        if (i10 < 3) {
            return i10 + 1;
        }
        if (i10 < 1073741824) {
            return (int) ((i10 / 0.75f) + 1.0f);
        }
        return Integer.MAX_VALUE;
    }

    public static final Map b(h9.k kVar) {
        t9.i.g(kVar, "pair");
        Map singletonMap = Collections.singletonMap(kVar.c(), kVar.d());
        t9.i.f(singletonMap, "singletonMap(pair.first, pair.second)");
        return singletonMap;
    }

    public static final Map c(Map map) {
        t9.i.g(map, "<this>");
        Map.Entry entry = (Map.Entry) map.entrySet().iterator().next();
        Map singletonMap = Collections.singletonMap(entry.getKey(), entry.getValue());
        t9.i.f(singletonMap, "with(entries.iterator().…ingletonMap(key, value) }");
        return singletonMap;
    }
}
