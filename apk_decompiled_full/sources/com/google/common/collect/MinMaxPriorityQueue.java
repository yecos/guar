package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.math.IntMath;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.j2objc.annotations.Weak;
import java.util.AbstractQueue;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Queue;
import javax.annotation.CheckForNull;

@Beta
@GwtCompatible
@ElementTypesAreNonnullByDefault
/* loaded from: classes2.dex */
public final class MinMaxPriorityQueue<E> extends AbstractQueue<E> {
    private static final int DEFAULT_CAPACITY = 11;
    private static final int EVEN_POWERS_OF_TWO = 1431655765;
    private static final int ODD_POWERS_OF_TWO = -1431655766;
    private final MinMaxPriorityQueue<E>.Heap maxHeap;

    @VisibleForTesting
    final int maximumSize;
    private final MinMaxPriorityQueue<E>.Heap minHeap;
    private int modCount;
    private Object[] queue;
    private int size;

    @Beta
    public static final class Builder<B> {
        private static final int UNSET_EXPECTED_SIZE = -1;
        private final Comparator<B> comparator;
        private int expectedSize;
        private int maximumSize;

        /* JADX INFO: Access modifiers changed from: private */
        public <T extends B> Ordering<T> ordering() {
            return Ordering.from(this.comparator);
        }

        public <T extends B> MinMaxPriorityQueue<T> create() {
            return create(Collections.emptySet());
        }

        @CanIgnoreReturnValue
        public Builder<B> expectedSize(int i10) {
            Preconditions.checkArgument(i10 >= 0);
            this.expectedSize = i10;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder<B> maximumSize(int i10) {
            Preconditions.checkArgument(i10 > 0);
            this.maximumSize = i10;
            return this;
        }

        private Builder(Comparator<B> comparator) {
            this.expectedSize = -1;
            this.maximumSize = Integer.MAX_VALUE;
            this.comparator = (Comparator) Preconditions.checkNotNull(comparator);
        }

        public <T extends B> MinMaxPriorityQueue<T> create(Iterable<? extends T> iterable) {
            MinMaxPriorityQueue<T> minMaxPriorityQueue = new MinMaxPriorityQueue<>(this, MinMaxPriorityQueue.initialQueueSize(this.expectedSize, this.maximumSize, iterable));
            Iterator<? extends T> it = iterable.iterator();
            while (it.hasNext()) {
                minMaxPriorityQueue.offer(it.next());
            }
            return minMaxPriorityQueue;
        }
    }

    public class Heap {
        final Ordering<E> ordering;

        @Weak
        MinMaxPriorityQueue<E>.Heap otherHeap;

        public Heap(Ordering<E> ordering) {
            this.ordering = ordering;
        }

        private int getGrandparentIndex(int i10) {
            return getParentIndex(getParentIndex(i10));
        }

        private int getLeftChildIndex(int i10) {
            return (i10 * 2) + 1;
        }

        private int getParentIndex(int i10) {
            return (i10 - 1) / 2;
        }

        private int getRightChildIndex(int i10) {
            return (i10 * 2) + 2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean verifyIndex(int i10) {
            if (getLeftChildIndex(i10) < MinMaxPriorityQueue.this.size && compareElements(i10, getLeftChildIndex(i10)) > 0) {
                return false;
            }
            if (getRightChildIndex(i10) < MinMaxPriorityQueue.this.size && compareElements(i10, getRightChildIndex(i10)) > 0) {
                return false;
            }
            if (i10 <= 0 || compareElements(i10, getParentIndex(i10)) <= 0) {
                return i10 <= 2 || compareElements(getGrandparentIndex(i10), i10) <= 0;
            }
            return false;
        }

        public void bubbleUp(int i10, E e10) {
            Heap heap;
            int crossOverUp = crossOverUp(i10, e10);
            if (crossOverUp == i10) {
                crossOverUp = i10;
                heap = this;
            } else {
                heap = this.otherHeap;
            }
            heap.bubbleUpAlternatingLevels(crossOverUp, e10);
        }

        @CanIgnoreReturnValue
        public int bubbleUpAlternatingLevels(int i10, E e10) {
            while (i10 > 2) {
                int grandparentIndex = getGrandparentIndex(i10);
                Object elementData = MinMaxPriorityQueue.this.elementData(grandparentIndex);
                if (this.ordering.compare(elementData, e10) <= 0) {
                    break;
                }
                MinMaxPriorityQueue.this.queue[i10] = elementData;
                i10 = grandparentIndex;
            }
            MinMaxPriorityQueue.this.queue[i10] = e10;
            return i10;
        }

        public int compareElements(int i10, int i11) {
            return this.ordering.compare(MinMaxPriorityQueue.this.elementData(i10), MinMaxPriorityQueue.this.elementData(i11));
        }

        public int crossOver(int i10, E e10) {
            int findMinChild = findMinChild(i10);
            if (findMinChild <= 0 || this.ordering.compare(MinMaxPriorityQueue.this.elementData(findMinChild), e10) >= 0) {
                return crossOverUp(i10, e10);
            }
            MinMaxPriorityQueue.this.queue[i10] = MinMaxPriorityQueue.this.elementData(findMinChild);
            MinMaxPriorityQueue.this.queue[findMinChild] = e10;
            return findMinChild;
        }

        public int crossOverUp(int i10, E e10) {
            int rightChildIndex;
            if (i10 == 0) {
                MinMaxPriorityQueue.this.queue[0] = e10;
                return 0;
            }
            int parentIndex = getParentIndex(i10);
            Object elementData = MinMaxPriorityQueue.this.elementData(parentIndex);
            if (parentIndex != 0 && (rightChildIndex = getRightChildIndex(getParentIndex(parentIndex))) != parentIndex && getLeftChildIndex(rightChildIndex) >= MinMaxPriorityQueue.this.size) {
                Object elementData2 = MinMaxPriorityQueue.this.elementData(rightChildIndex);
                if (this.ordering.compare(elementData2, elementData) < 0) {
                    parentIndex = rightChildIndex;
                    elementData = elementData2;
                }
            }
            if (this.ordering.compare(elementData, e10) >= 0) {
                MinMaxPriorityQueue.this.queue[i10] = e10;
                return i10;
            }
            MinMaxPriorityQueue.this.queue[i10] = elementData;
            MinMaxPriorityQueue.this.queue[parentIndex] = e10;
            return parentIndex;
        }

        public int fillHoleAt(int i10) {
            while (true) {
                int findMinGrandChild = findMinGrandChild(i10);
                if (findMinGrandChild <= 0) {
                    return i10;
                }
                MinMaxPriorityQueue.this.queue[i10] = MinMaxPriorityQueue.this.elementData(findMinGrandChild);
                i10 = findMinGrandChild;
            }
        }

        public int findMin(int i10, int i11) {
            if (i10 >= MinMaxPriorityQueue.this.size) {
                return -1;
            }
            Preconditions.checkState(i10 > 0);
            int min = Math.min(i10, MinMaxPriorityQueue.this.size - i11) + i11;
            for (int i12 = i10 + 1; i12 < min; i12++) {
                if (compareElements(i12, i10) < 0) {
                    i10 = i12;
                }
            }
            return i10;
        }

        public int findMinChild(int i10) {
            return findMin(getLeftChildIndex(i10), 2);
        }

        public int findMinGrandChild(int i10) {
            int leftChildIndex = getLeftChildIndex(i10);
            if (leftChildIndex < 0) {
                return -1;
            }
            return findMin(getLeftChildIndex(leftChildIndex), 4);
        }

        public int swapWithConceptuallyLastElement(E e10) {
            int rightChildIndex;
            int parentIndex = getParentIndex(MinMaxPriorityQueue.this.size);
            if (parentIndex != 0 && (rightChildIndex = getRightChildIndex(getParentIndex(parentIndex))) != parentIndex && getLeftChildIndex(rightChildIndex) >= MinMaxPriorityQueue.this.size) {
                Object elementData = MinMaxPriorityQueue.this.elementData(rightChildIndex);
                if (this.ordering.compare(elementData, e10) < 0) {
                    MinMaxPriorityQueue.this.queue[rightChildIndex] = e10;
                    MinMaxPriorityQueue.this.queue[MinMaxPriorityQueue.this.size] = elementData;
                    return rightChildIndex;
                }
            }
            return MinMaxPriorityQueue.this.size;
        }

        @CheckForNull
        public MoveDesc<E> tryCrossOverAndBubbleUp(int i10, int i11, E e10) {
            int crossOver = crossOver(i11, e10);
            if (crossOver == i11) {
                return null;
            }
            Object elementData = crossOver < i10 ? MinMaxPriorityQueue.this.elementData(i10) : MinMaxPriorityQueue.this.elementData(getParentIndex(i10));
            if (this.otherHeap.bubbleUpAlternatingLevels(crossOver, e10) < i10) {
                return new MoveDesc<>(e10, elementData);
            }
            return null;
        }
    }

    public static class MoveDesc<E> {
        final E replaced;
        final E toTrickle;

        public MoveDesc(E e10, E e11) {
            this.toTrickle = e10;
            this.replaced = e11;
        }
    }

    public class QueueIterator implements Iterator<E> {
        private boolean canRemove;
        private int cursor;
        private int expectedModCount;

        @CheckForNull
        private Queue<E> forgetMeNot;

        @CheckForNull
        private E lastFromForgetMeNot;
        private int nextCursor;

        @CheckForNull
        private List<E> skipMe;

        private QueueIterator() {
            this.cursor = -1;
            this.nextCursor = -1;
            this.expectedModCount = MinMaxPriorityQueue.this.modCount;
        }

        private void checkModCount() {
            if (MinMaxPriorityQueue.this.modCount != this.expectedModCount) {
                throw new ConcurrentModificationException();
            }
        }

        private boolean foundAndRemovedExactReference(Iterable<E> iterable, E e10) {
            Iterator<E> it = iterable.iterator();
            while (it.hasNext()) {
                if (it.next() == e10) {
                    it.remove();
                    return true;
                }
            }
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        private void nextNotInSkipMe(int i10) {
            if (this.nextCursor < i10) {
                if (this.skipMe != null) {
                    while (i10 < MinMaxPriorityQueue.this.size() && foundAndRemovedExactReference(this.skipMe, MinMaxPriorityQueue.this.elementData(i10))) {
                        i10++;
                    }
                }
                this.nextCursor = i10;
            }
        }

        private boolean removeExact(Object obj) {
            for (int i10 = 0; i10 < MinMaxPriorityQueue.this.size; i10++) {
                if (MinMaxPriorityQueue.this.queue[i10] == obj) {
                    MinMaxPriorityQueue.this.removeAt(i10);
                    return true;
                }
            }
            return false;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            checkModCount();
            nextNotInSkipMe(this.cursor + 1);
            if (this.nextCursor < MinMaxPriorityQueue.this.size()) {
                return true;
            }
            Queue<E> queue = this.forgetMeNot;
            return (queue == null || queue.isEmpty()) ? false : true;
        }

        @Override // java.util.Iterator
        public E next() {
            checkModCount();
            nextNotInSkipMe(this.cursor + 1);
            if (this.nextCursor < MinMaxPriorityQueue.this.size()) {
                int i10 = this.nextCursor;
                this.cursor = i10;
                this.canRemove = true;
                return (E) MinMaxPriorityQueue.this.elementData(i10);
            }
            if (this.forgetMeNot != null) {
                this.cursor = MinMaxPriorityQueue.this.size();
                E poll = this.forgetMeNot.poll();
                this.lastFromForgetMeNot = poll;
                if (poll != null) {
                    this.canRemove = true;
                    return poll;
                }
            }
            throw new NoSuchElementException("iterator moved past last element in queue.");
        }

        @Override // java.util.Iterator
        public void remove() {
            CollectPreconditions.checkRemove(this.canRemove);
            checkModCount();
            this.canRemove = false;
            this.expectedModCount++;
            if (this.cursor >= MinMaxPriorityQueue.this.size()) {
                E e10 = this.lastFromForgetMeNot;
                Objects.requireNonNull(e10);
                Preconditions.checkState(removeExact(e10));
                this.lastFromForgetMeNot = null;
                return;
            }
            MoveDesc<E> removeAt = MinMaxPriorityQueue.this.removeAt(this.cursor);
            if (removeAt != null) {
                if (this.forgetMeNot == null || this.skipMe == null) {
                    this.forgetMeNot = new ArrayDeque();
                    this.skipMe = new ArrayList(3);
                }
                if (!foundAndRemovedExactReference(this.skipMe, removeAt.toTrickle)) {
                    this.forgetMeNot.add(removeAt.toTrickle);
                }
                if (!foundAndRemovedExactReference(this.forgetMeNot, removeAt.replaced)) {
                    this.skipMe.add(removeAt.replaced);
                }
            }
            this.cursor--;
            this.nextCursor--;
        }
    }

    private int calculateNewCapacity() {
        int length = this.queue.length;
        return capAtMaximumSize(length < 64 ? (length + 1) * 2 : IntMath.checkedMultiply(length / 2, 3), this.maximumSize);
    }

    private static int capAtMaximumSize(int i10, int i11) {
        return Math.min(i10 - 1, i11) + 1;
    }

    public static <E extends Comparable<E>> MinMaxPriorityQueue<E> create() {
        return new Builder(Ordering.natural()).create();
    }

    public static Builder<Comparable> expectedSize(int i10) {
        return new Builder(Ordering.natural()).expectedSize(i10);
    }

    @CheckForNull
    private MoveDesc<E> fillHole(int i10, E e10) {
        MinMaxPriorityQueue<E>.Heap heapForIndex = heapForIndex(i10);
        int fillHoleAt = heapForIndex.fillHoleAt(i10);
        int bubbleUpAlternatingLevels = heapForIndex.bubbleUpAlternatingLevels(fillHoleAt, e10);
        if (bubbleUpAlternatingLevels == fillHoleAt) {
            return heapForIndex.tryCrossOverAndBubbleUp(i10, fillHoleAt, e10);
        }
        if (bubbleUpAlternatingLevels < i10) {
            return new MoveDesc<>(e10, elementData(i10));
        }
        return null;
    }

    private int getMaxElementIndex() {
        int i10 = this.size;
        if (i10 != 1) {
            return (i10 == 2 || this.maxHeap.compareElements(1, 2) <= 0) ? 1 : 2;
        }
        return 0;
    }

    private void growIfNeeded() {
        if (this.size > this.queue.length) {
            Object[] objArr = new Object[calculateNewCapacity()];
            Object[] objArr2 = this.queue;
            System.arraycopy(objArr2, 0, objArr, 0, objArr2.length);
            this.queue = objArr;
        }
    }

    private MinMaxPriorityQueue<E>.Heap heapForIndex(int i10) {
        return isEvenLevel(i10) ? this.minHeap : this.maxHeap;
    }

    @VisibleForTesting
    public static int initialQueueSize(int i10, int i11, Iterable<?> iterable) {
        if (i10 == -1) {
            i10 = 11;
        }
        if (iterable instanceof Collection) {
            i10 = Math.max(i10, ((Collection) iterable).size());
        }
        return capAtMaximumSize(i10, i11);
    }

    @VisibleForTesting
    public static boolean isEvenLevel(int i10) {
        int i11 = ((i10 + 1) ^ (-1)) ^ (-1);
        Preconditions.checkState(i11 > 0, "negative index");
        return (EVEN_POWERS_OF_TWO & i11) > (i11 & ODD_POWERS_OF_TWO);
    }

    public static Builder<Comparable> maximumSize(int i10) {
        return new Builder(Ordering.natural()).maximumSize(i10);
    }

    public static <B> Builder<B> orderedBy(Comparator<B> comparator) {
        return new Builder<>(comparator);
    }

    private E removeAndGet(int i10) {
        E elementData = elementData(i10);
        removeAt(i10);
        return elementData;
    }

    @Override // java.util.AbstractQueue, java.util.AbstractCollection, java.util.Collection, java.util.Queue
    @CanIgnoreReturnValue
    public boolean add(E e10) {
        offer(e10);
        return true;
    }

    @Override // java.util.AbstractQueue, java.util.AbstractCollection, java.util.Collection
    @CanIgnoreReturnValue
    public boolean addAll(Collection<? extends E> collection) {
        Iterator<? extends E> it = collection.iterator();
        boolean z10 = false;
        while (it.hasNext()) {
            offer(it.next());
            z10 = true;
        }
        return z10;
    }

    @VisibleForTesting
    public int capacity() {
        return this.queue.length;
    }

    @Override // java.util.AbstractQueue, java.util.AbstractCollection, java.util.Collection
    public void clear() {
        for (int i10 = 0; i10 < this.size; i10++) {
            this.queue[i10] = null;
        }
        this.size = 0;
    }

    public Comparator<? super E> comparator() {
        return this.minHeap.ordering;
    }

    public E elementData(int i10) {
        E e10 = (E) this.queue[i10];
        Objects.requireNonNull(e10);
        return e10;
    }

    @VisibleForTesting
    public boolean isIntact() {
        for (int i10 = 1; i10 < this.size; i10++) {
            if (!heapForIndex(i10).verifyIndex(i10)) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public Iterator<E> iterator() {
        return new QueueIterator();
    }

    @Override // java.util.Queue
    @CanIgnoreReturnValue
    public boolean offer(E e10) {
        Preconditions.checkNotNull(e10);
        this.modCount++;
        int i10 = this.size;
        this.size = i10 + 1;
        growIfNeeded();
        heapForIndex(i10).bubbleUp(i10, e10);
        return this.size <= this.maximumSize || pollLast() != e10;
    }

    @Override // java.util.Queue
    @CheckForNull
    public E peek() {
        if (isEmpty()) {
            return null;
        }
        return elementData(0);
    }

    @CheckForNull
    public E peekFirst() {
        return peek();
    }

    @CheckForNull
    public E peekLast() {
        if (isEmpty()) {
            return null;
        }
        return elementData(getMaxElementIndex());
    }

    @Override // java.util.Queue
    @CanIgnoreReturnValue
    @CheckForNull
    public E poll() {
        if (isEmpty()) {
            return null;
        }
        return removeAndGet(0);
    }

    @CanIgnoreReturnValue
    @CheckForNull
    public E pollFirst() {
        return poll();
    }

    @CanIgnoreReturnValue
    @CheckForNull
    public E pollLast() {
        if (isEmpty()) {
            return null;
        }
        return removeAndGet(getMaxElementIndex());
    }

    @VisibleForTesting
    @CanIgnoreReturnValue
    @CheckForNull
    public MoveDesc<E> removeAt(int i10) {
        Preconditions.checkPositionIndex(i10, this.size);
        this.modCount++;
        int i11 = this.size - 1;
        this.size = i11;
        if (i11 == i10) {
            this.queue[i11] = null;
            return null;
        }
        E elementData = elementData(i11);
        int swapWithConceptuallyLastElement = heapForIndex(this.size).swapWithConceptuallyLastElement(elementData);
        if (swapWithConceptuallyLastElement == i10) {
            this.queue[this.size] = null;
            return null;
        }
        E elementData2 = elementData(this.size);
        this.queue[this.size] = null;
        MoveDesc<E> fillHole = fillHole(i10, elementData2);
        return swapWithConceptuallyLastElement < i10 ? fillHole == null ? new MoveDesc<>(elementData, elementData2) : new MoveDesc<>(elementData, fillHole.replaced) : fillHole;
    }

    @CanIgnoreReturnValue
    public E removeFirst() {
        return remove();
    }

    @CanIgnoreReturnValue
    public E removeLast() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return removeAndGet(getMaxElementIndex());
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public int size() {
        return this.size;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public Object[] toArray() {
        int i10 = this.size;
        Object[] objArr = new Object[i10];
        System.arraycopy(this.queue, 0, objArr, 0, i10);
        return objArr;
    }

    private MinMaxPriorityQueue(Builder<? super E> builder, int i10) {
        Ordering ordering = builder.ordering();
        MinMaxPriorityQueue<E>.Heap heap = new Heap(ordering);
        this.minHeap = heap;
        MinMaxPriorityQueue<E>.Heap heap2 = new Heap(ordering.reverse());
        this.maxHeap = heap2;
        heap.otherHeap = heap2;
        heap2.otherHeap = heap;
        this.maximumSize = ((Builder) builder).maximumSize;
        this.queue = new Object[i10];
    }

    public static <E extends Comparable<E>> MinMaxPriorityQueue<E> create(Iterable<? extends E> iterable) {
        return new Builder(Ordering.natural()).create(iterable);
    }
}
