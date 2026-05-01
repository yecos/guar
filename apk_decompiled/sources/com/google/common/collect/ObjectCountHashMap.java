package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.collect.Multiset;
import com.google.common.collect.Multisets;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Arrays;
import javax.annotation.CheckForNull;

@GwtCompatible(emulated = true, serializable = true)
@ElementTypesAreNonnullByDefault
/* loaded from: classes2.dex */
class ObjectCountHashMap<K> {
    static final float DEFAULT_LOAD_FACTOR = 1.0f;
    static final int DEFAULT_SIZE = 3;
    private static final long HASH_MASK = -4294967296L;
    private static final int MAXIMUM_CAPACITY = 1073741824;
    private static final long NEXT_MASK = 4294967295L;
    static final int UNSET = -1;

    @VisibleForTesting
    transient long[] entries;
    transient Object[] keys;
    private transient float loadFactor;
    transient int modCount;
    transient int size;
    private transient int[] table;
    private transient int threshold;
    transient int[] values;

    public class MapEntry extends Multisets.AbstractEntry<K> {

        @ParametricNullness
        final K key;
        int lastKnownIndex;

        public MapEntry(int i10) {
            this.key = (K) ObjectCountHashMap.this.keys[i10];
            this.lastKnownIndex = i10;
        }

        @Override // com.google.common.collect.Multiset.Entry
        public int getCount() {
            updateLastKnownIndex();
            int i10 = this.lastKnownIndex;
            if (i10 == -1) {
                return 0;
            }
            return ObjectCountHashMap.this.values[i10];
        }

        @Override // com.google.common.collect.Multiset.Entry
        @ParametricNullness
        public K getElement() {
            return this.key;
        }

        @CanIgnoreReturnValue
        public int setCount(int i10) {
            updateLastKnownIndex();
            int i11 = this.lastKnownIndex;
            if (i11 == -1) {
                ObjectCountHashMap.this.put(this.key, i10);
                return 0;
            }
            int[] iArr = ObjectCountHashMap.this.values;
            int i12 = iArr[i11];
            iArr[i11] = i10;
            return i12;
        }

        public void updateLastKnownIndex() {
            int i10 = this.lastKnownIndex;
            if (i10 == -1 || i10 >= ObjectCountHashMap.this.size() || !Objects.equal(this.key, ObjectCountHashMap.this.keys[this.lastKnownIndex])) {
                this.lastKnownIndex = ObjectCountHashMap.this.indexOf(this.key);
            }
        }
    }

    public ObjectCountHashMap() {
        init(3, 1.0f);
    }

    public static <K> ObjectCountHashMap<K> create() {
        return new ObjectCountHashMap<>();
    }

    public static <K> ObjectCountHashMap<K> createWithExpectedSize(int i10) {
        return new ObjectCountHashMap<>(i10);
    }

    private static int getHash(long j10) {
        return (int) (j10 >>> 32);
    }

    private static int getNext(long j10) {
        return (int) j10;
    }

    private int hashTableMask() {
        return this.table.length - 1;
    }

    private static long[] newEntries(int i10) {
        long[] jArr = new long[i10];
        Arrays.fill(jArr, -1L);
        return jArr;
    }

    private static int[] newTable(int i10) {
        int[] iArr = new int[i10];
        Arrays.fill(iArr, -1);
        return iArr;
    }

    private void resizeMeMaybe(int i10) {
        int length = this.entries.length;
        if (i10 > length) {
            int max = Math.max(1, length >>> 1) + length;
            if (max < 0) {
                max = Integer.MAX_VALUE;
            }
            if (max != length) {
                resizeEntries(max);
            }
        }
    }

    private void resizeTable(int i10) {
        if (this.table.length >= 1073741824) {
            this.threshold = Integer.MAX_VALUE;
            return;
        }
        int i11 = ((int) (i10 * this.loadFactor)) + 1;
        int[] newTable = newTable(i10);
        long[] jArr = this.entries;
        int length = newTable.length - 1;
        for (int i12 = 0; i12 < this.size; i12++) {
            int hash = getHash(jArr[i12]);
            int i13 = hash & length;
            int i14 = newTable[i13];
            newTable[i13] = i12;
            jArr[i12] = (hash << 32) | (NEXT_MASK & i14);
        }
        this.threshold = i11;
        this.table = newTable;
    }

    private static long swapNext(long j10, int i10) {
        return (j10 & HASH_MASK) | (NEXT_MASK & i10);
    }

    public void clear() {
        this.modCount++;
        Arrays.fill(this.keys, 0, this.size, (Object) null);
        Arrays.fill(this.values, 0, this.size, 0);
        Arrays.fill(this.table, -1);
        Arrays.fill(this.entries, -1L);
        this.size = 0;
    }

    public boolean containsKey(@CheckForNull Object obj) {
        return indexOf(obj) != -1;
    }

    public void ensureCapacity(int i10) {
        if (i10 > this.entries.length) {
            resizeEntries(i10);
        }
        if (i10 >= this.threshold) {
            resizeTable(Math.max(2, Integer.highestOneBit(i10 - 1) << 1));
        }
    }

    public int firstIndex() {
        return this.size == 0 ? -1 : 0;
    }

    public int get(@CheckForNull Object obj) {
        int indexOf = indexOf(obj);
        if (indexOf == -1) {
            return 0;
        }
        return this.values[indexOf];
    }

    public Multiset.Entry<K> getEntry(int i10) {
        Preconditions.checkElementIndex(i10, this.size);
        return new MapEntry(i10);
    }

    @ParametricNullness
    public K getKey(int i10) {
        Preconditions.checkElementIndex(i10, this.size);
        return (K) this.keys[i10];
    }

    public int getValue(int i10) {
        Preconditions.checkElementIndex(i10, this.size);
        return this.values[i10];
    }

    public int indexOf(@CheckForNull Object obj) {
        int smearedHash = Hashing.smearedHash(obj);
        int i10 = this.table[hashTableMask() & smearedHash];
        while (i10 != -1) {
            long j10 = this.entries[i10];
            if (getHash(j10) == smearedHash && Objects.equal(obj, this.keys[i10])) {
                return i10;
            }
            i10 = getNext(j10);
        }
        return -1;
    }

    public void init(int i10, float f10) {
        Preconditions.checkArgument(i10 >= 0, "Initial capacity must be non-negative");
        Preconditions.checkArgument(f10 > 0.0f, "Illegal load factor");
        int closedTableSize = Hashing.closedTableSize(i10, f10);
        this.table = newTable(closedTableSize);
        this.loadFactor = f10;
        this.keys = new Object[i10];
        this.values = new int[i10];
        this.entries = newEntries(i10);
        this.threshold = Math.max(1, (int) (closedTableSize * f10));
    }

    public void insertEntry(int i10, @ParametricNullness K k10, int i11, int i12) {
        this.entries[i10] = (i12 << 32) | NEXT_MASK;
        this.keys[i10] = k10;
        this.values[i10] = i11;
    }

    public void moveLastEntry(int i10) {
        int size = size() - 1;
        if (i10 >= size) {
            this.keys[i10] = null;
            this.values[i10] = 0;
            this.entries[i10] = -1;
            return;
        }
        Object[] objArr = this.keys;
        objArr[i10] = objArr[size];
        int[] iArr = this.values;
        iArr[i10] = iArr[size];
        objArr[size] = null;
        iArr[size] = 0;
        long[] jArr = this.entries;
        long j10 = jArr[size];
        jArr[i10] = j10;
        jArr[size] = -1;
        int hash = getHash(j10) & hashTableMask();
        int[] iArr2 = this.table;
        int i11 = iArr2[hash];
        if (i11 == size) {
            iArr2[hash] = i10;
            return;
        }
        while (true) {
            long j11 = this.entries[i11];
            int next = getNext(j11);
            if (next == size) {
                this.entries[i11] = swapNext(j11, i10);
                return;
            }
            i11 = next;
        }
    }

    public int nextIndex(int i10) {
        int i11 = i10 + 1;
        if (i11 < this.size) {
            return i11;
        }
        return -1;
    }

    public int nextIndexAfterRemove(int i10, int i11) {
        return i10 - 1;
    }

    @CanIgnoreReturnValue
    public int put(@ParametricNullness K k10, int i10) {
        CollectPreconditions.checkPositive(i10, "count");
        long[] jArr = this.entries;
        Object[] objArr = this.keys;
        int[] iArr = this.values;
        int smearedHash = Hashing.smearedHash(k10);
        int hashTableMask = hashTableMask() & smearedHash;
        int i11 = this.size;
        int[] iArr2 = this.table;
        int i12 = iArr2[hashTableMask];
        if (i12 == -1) {
            iArr2[hashTableMask] = i11;
        } else {
            while (true) {
                long j10 = jArr[i12];
                if (getHash(j10) == smearedHash && Objects.equal(k10, objArr[i12])) {
                    int i13 = iArr[i12];
                    iArr[i12] = i10;
                    return i13;
                }
                int next = getNext(j10);
                if (next == -1) {
                    jArr[i12] = swapNext(j10, i11);
                    break;
                }
                i12 = next;
            }
        }
        if (i11 == Integer.MAX_VALUE) {
            throw new IllegalStateException("Cannot contain more than Integer.MAX_VALUE elements!");
        }
        int i14 = i11 + 1;
        resizeMeMaybe(i14);
        insertEntry(i11, k10, i10, smearedHash);
        this.size = i14;
        if (i11 >= this.threshold) {
            resizeTable(this.table.length * 2);
        }
        this.modCount++;
        return 0;
    }

    @CanIgnoreReturnValue
    public int remove(@CheckForNull Object obj) {
        return remove(obj, Hashing.smearedHash(obj));
    }

    @CanIgnoreReturnValue
    public int removeEntry(int i10) {
        return remove(this.keys[i10], getHash(this.entries[i10]));
    }

    public void resizeEntries(int i10) {
        this.keys = Arrays.copyOf(this.keys, i10);
        this.values = Arrays.copyOf(this.values, i10);
        long[] jArr = this.entries;
        int length = jArr.length;
        long[] copyOf = Arrays.copyOf(jArr, i10);
        if (i10 > length) {
            Arrays.fill(copyOf, length, i10, -1L);
        }
        this.entries = copyOf;
    }

    public void setValue(int i10, int i11) {
        Preconditions.checkElementIndex(i10, this.size);
        this.values[i10] = i11;
    }

    public int size() {
        return this.size;
    }

    private int remove(@CheckForNull Object obj, int i10) {
        int hashTableMask = hashTableMask() & i10;
        int i11 = this.table[hashTableMask];
        if (i11 == -1) {
            return 0;
        }
        int i12 = -1;
        while (true) {
            if (getHash(this.entries[i11]) == i10 && Objects.equal(obj, this.keys[i11])) {
                int i13 = this.values[i11];
                if (i12 == -1) {
                    this.table[hashTableMask] = getNext(this.entries[i11]);
                } else {
                    long[] jArr = this.entries;
                    jArr[i12] = swapNext(jArr[i12], getNext(jArr[i11]));
                }
                moveLastEntry(i11);
                this.size--;
                this.modCount++;
                return i13;
            }
            int next = getNext(this.entries[i11]);
            if (next == -1) {
                return 0;
            }
            i12 = i11;
            i11 = next;
        }
    }

    public ObjectCountHashMap(ObjectCountHashMap<? extends K> objectCountHashMap) {
        init(objectCountHashMap.size(), 1.0f);
        int firstIndex = objectCountHashMap.firstIndex();
        while (firstIndex != -1) {
            put(objectCountHashMap.getKey(firstIndex), objectCountHashMap.getValue(firstIndex));
            firstIndex = objectCountHashMap.nextIndex(firstIndex);
        }
    }

    public ObjectCountHashMap(int i10) {
        this(i10, 1.0f);
    }

    public ObjectCountHashMap(int i10, float f10) {
        init(i10, f10);
    }
}
