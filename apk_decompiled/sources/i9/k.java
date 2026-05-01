package i9;

import java.util.Collection;

/* loaded from: classes3.dex */
public abstract class k extends j {
    public static final int k(Iterable iterable, int i10) {
        t9.i.g(iterable, "<this>");
        return iterable instanceof Collection ? ((Collection) iterable).size() : i10;
    }
}
