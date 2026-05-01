package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import java.util.Comparator;
import java.util.Iterator;

@GwtCompatible
@ElementTypesAreNonnullByDefault
/* loaded from: classes2.dex */
public final class Comparators {
    private Comparators() {
    }

    public static <T> boolean isInOrder(Iterable<? extends T> iterable, Comparator<T> comparator) {
        Preconditions.checkNotNull(comparator);
        Iterator<? extends T> it = iterable.iterator();
        if (!it.hasNext()) {
            return true;
        }
        T next = it.next();
        while (it.hasNext()) {
            T next2 = it.next();
            if (comparator.compare(next, next2) > 0) {
                return false;
            }
            next = next2;
        }
        return true;
    }

    public static <T> boolean isInStrictOrder(Iterable<? extends T> iterable, Comparator<T> comparator) {
        Preconditions.checkNotNull(comparator);
        Iterator<? extends T> it = iterable.iterator();
        if (!it.hasNext()) {
            return true;
        }
        T next = it.next();
        while (it.hasNext()) {
            T next2 = it.next();
            if (comparator.compare(next, next2) >= 0) {
                return false;
            }
            next = next2;
        }
        return true;
    }

    public static <T, S extends T> Comparator<Iterable<S>> lexicographical(Comparator<T> comparator) {
        return new LexicographicalOrdering((Comparator) Preconditions.checkNotNull(comparator));
    }

    public static <T extends Comparable<? super T>> T max(T t10, T t11) {
        return t10.compareTo(t11) >= 0 ? t10 : t11;
    }

    public static <T extends Comparable<? super T>> T min(T t10, T t11) {
        return t10.compareTo(t11) <= 0 ? t10 : t11;
    }

    @ParametricNullness
    public static <T> T max(@ParametricNullness T t10, @ParametricNullness T t11, Comparator<T> comparator) {
        return comparator.compare(t10, t11) >= 0 ? t10 : t11;
    }

    @ParametricNullness
    public static <T> T min(@ParametricNullness T t10, @ParametricNullness T t11, Comparator<T> comparator) {
        return comparator.compare(t10, t11) <= 0 ? t10 : t11;
    }
}
