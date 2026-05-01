package i9;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* loaded from: classes3.dex */
public abstract class n extends m {
    public static final void l(List list) {
        t9.i.g(list, "<this>");
        if (list.size() > 1) {
            Collections.sort(list);
        }
    }

    public static final void m(List list, Comparator comparator) {
        t9.i.g(list, "<this>");
        t9.i.g(comparator, "comparator");
        if (list.size() > 1) {
            Collections.sort(list, comparator);
        }
    }
}
