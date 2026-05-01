package i9;

import java.util.Collection;
import java.util.Iterator;

/* loaded from: classes3.dex */
public abstract class o extends n {
    public static final boolean n(Collection collection, Iterable iterable) {
        t9.i.g(collection, "<this>");
        t9.i.g(iterable, "elements");
        if (iterable instanceof Collection) {
            return collection.addAll((Collection) iterable);
        }
        Iterator it = iterable.iterator();
        boolean z10 = false;
        while (it.hasNext()) {
            if (collection.add(it.next())) {
                z10 = true;
            }
        }
        return z10;
    }
}
