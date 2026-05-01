package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.common.math.IntMath;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import javax.annotation.CheckForNull;

@GwtCompatible
@ElementTypesAreNonnullByDefault
/* loaded from: classes2.dex */
final class TopKSelector<T> {
    private final T[] buffer;
    private int bufferSize;
    private final Comparator<? super T> comparator;

    /* renamed from: k, reason: collision with root package name */
    private final int f6861k;

    @CheckForNull
    private T threshold;

    private TopKSelector(Comparator<? super T> comparator, int i10) {
        this.comparator = (Comparator) Preconditions.checkNotNull(comparator, "comparator");
        this.f6861k = i10;
        Preconditions.checkArgument(i10 >= 0, "k (%s) must be >= 0", i10);
        Preconditions.checkArgument(i10 <= 1073741823, "k (%s) must be <= Integer.MAX_VALUE / 2", i10);
        this.buffer = (T[]) new Object[IntMath.checkedMultiply(i10, 2)];
        this.bufferSize = 0;
        this.threshold = null;
    }

    public static <T extends Comparable<? super T>> TopKSelector<T> greatest(int i10) {
        return greatest(i10, Ordering.natural());
    }

    public static <T extends Comparable<? super T>> TopKSelector<T> least(int i10) {
        return least(i10, Ordering.natural());
    }

    private int partition(int i10, int i11, int i12) {
        Object uncheckedCastNullableTToT = NullnessCasts.uncheckedCastNullableTToT(this.buffer[i12]);
        T[] tArr = this.buffer;
        tArr[i12] = tArr[i11];
        int i13 = i10;
        while (i10 < i11) {
            if (this.comparator.compare((Object) NullnessCasts.uncheckedCastNullableTToT(this.buffer[i10]), uncheckedCastNullableTToT) < 0) {
                swap(i13, i10);
                i13++;
            }
            i10++;
        }
        T[] tArr2 = this.buffer;
        tArr2[i11] = tArr2[i13];
        tArr2[i13] = uncheckedCastNullableTToT;
        return i13;
    }

    private void swap(int i10, int i11) {
        T[] tArr = this.buffer;
        T t10 = tArr[i10];
        tArr[i10] = tArr[i11];
        tArr[i11] = t10;
    }

    private void trim() {
        int i10 = (this.f6861k * 2) - 1;
        int log2 = IntMath.log2(i10 + 0, RoundingMode.CEILING) * 3;
        int i11 = 0;
        int i12 = 0;
        int i13 = 0;
        while (true) {
            if (i11 >= i10) {
                break;
            }
            int partition = partition(i11, i10, ((i11 + i10) + 1) >>> 1);
            int i14 = this.f6861k;
            if (partition <= i14) {
                if (partition >= i14) {
                    break;
                }
                i11 = Math.max(partition, i11 + 1);
                i13 = partition;
            } else {
                i10 = partition - 1;
            }
            i12++;
            if (i12 >= log2) {
                Arrays.sort(this.buffer, i11, i10 + 1, this.comparator);
                break;
            }
        }
        this.bufferSize = this.f6861k;
        this.threshold = (T) NullnessCasts.uncheckedCastNullableTToT(this.buffer[i13]);
        while (true) {
            i13++;
            if (i13 >= this.f6861k) {
                return;
            }
            if (this.comparator.compare((Object) NullnessCasts.uncheckedCastNullableTToT(this.buffer[i13]), (Object) NullnessCasts.uncheckedCastNullableTToT(this.threshold)) > 0) {
                this.threshold = this.buffer[i13];
            }
        }
    }

    public void offer(@ParametricNullness T t10) {
        int i10 = this.f6861k;
        if (i10 == 0) {
            return;
        }
        int i11 = this.bufferSize;
        if (i11 == 0) {
            this.buffer[0] = t10;
            this.threshold = t10;
            this.bufferSize = 1;
            return;
        }
        if (i11 < i10) {
            T[] tArr = this.buffer;
            this.bufferSize = i11 + 1;
            tArr[i11] = t10;
            if (this.comparator.compare(t10, (Object) NullnessCasts.uncheckedCastNullableTToT(this.threshold)) > 0) {
                this.threshold = t10;
                return;
            }
            return;
        }
        if (this.comparator.compare(t10, (Object) NullnessCasts.uncheckedCastNullableTToT(this.threshold)) < 0) {
            T[] tArr2 = this.buffer;
            int i12 = this.bufferSize;
            int i13 = i12 + 1;
            this.bufferSize = i13;
            tArr2[i12] = t10;
            if (i13 == this.f6861k * 2) {
                trim();
            }
        }
    }

    public void offerAll(Iterable<? extends T> iterable) {
        offerAll(iterable.iterator());
    }

    public List<T> topK() {
        Arrays.sort(this.buffer, 0, this.bufferSize, this.comparator);
        int i10 = this.bufferSize;
        int i11 = this.f6861k;
        if (i10 > i11) {
            T[] tArr = this.buffer;
            Arrays.fill(tArr, i11, tArr.length, (Object) null);
            int i12 = this.f6861k;
            this.bufferSize = i12;
            this.threshold = this.buffer[i12 - 1];
        }
        return Collections.unmodifiableList(Arrays.asList(Arrays.copyOf(this.buffer, this.bufferSize)));
    }

    public static <T> TopKSelector<T> greatest(int i10, Comparator<? super T> comparator) {
        return new TopKSelector<>(Ordering.from(comparator).reverse(), i10);
    }

    public static <T> TopKSelector<T> least(int i10, Comparator<? super T> comparator) {
        return new TopKSelector<>(comparator, i10);
    }

    public void offerAll(Iterator<? extends T> it) {
        while (it.hasNext()) {
            offer(it.next());
        }
    }
}
