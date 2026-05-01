package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.VisibleForTesting;
import java.util.Arrays;

@GwtCompatible(emulated = true, serializable = true)
@ElementTypesAreNonnullByDefault
/* loaded from: classes2.dex */
class ObjectCountLinkedHashMap<K> extends ObjectCountHashMap<K> {
    private static final int ENDPOINT = -2;
    private transient int firstEntry;
    private transient int lastEntry;

    @VisibleForTesting
    transient long[] links;

    public ObjectCountLinkedHashMap() {
        this(3);
    }

    public static <K> ObjectCountLinkedHashMap<K> create() {
        return new ObjectCountLinkedHashMap<>();
    }

    public static <K> ObjectCountLinkedHashMap<K> createWithExpectedSize(int i10) {
        return new ObjectCountLinkedHashMap<>(i10);
    }

    private int getPredecessor(int i10) {
        return (int) (this.links[i10] >>> 32);
    }

    private int getSuccessor(int i10) {
        return (int) this.links[i10];
    }

    private void setPredecessor(int i10, int i11) {
        long[] jArr = this.links;
        jArr[i10] = (jArr[i10] & 4294967295L) | (i11 << 32);
    }

    private void setSucceeds(int i10, int i11) {
        if (i10 == -2) {
            this.firstEntry = i11;
        } else {
            setSuccessor(i10, i11);
        }
        if (i11 == -2) {
            this.lastEntry = i10;
        } else {
            setPredecessor(i11, i10);
        }
    }

    private void setSuccessor(int i10, int i11) {
        long[] jArr = this.links;
        jArr[i10] = (jArr[i10] & (-4294967296L)) | (i11 & 4294967295L);
    }

    @Override // com.google.common.collect.ObjectCountHashMap
    public void clear() {
        super.clear();
        this.firstEntry = -2;
        this.lastEntry = -2;
    }

    @Override // com.google.common.collect.ObjectCountHashMap
    public int firstIndex() {
        int i10 = this.firstEntry;
        if (i10 == -2) {
            return -1;
        }
        return i10;
    }

    @Override // com.google.common.collect.ObjectCountHashMap
    public void init(int i10, float f10) {
        super.init(i10, f10);
        this.firstEntry = -2;
        this.lastEntry = -2;
        long[] jArr = new long[i10];
        this.links = jArr;
        Arrays.fill(jArr, -1L);
    }

    @Override // com.google.common.collect.ObjectCountHashMap
    public void insertEntry(int i10, @ParametricNullness K k10, int i11, int i12) {
        super.insertEntry(i10, k10, i11, i12);
        setSucceeds(this.lastEntry, i10);
        setSucceeds(i10, -2);
    }

    @Override // com.google.common.collect.ObjectCountHashMap
    public void moveLastEntry(int i10) {
        int size = size() - 1;
        setSucceeds(getPredecessor(i10), getSuccessor(i10));
        if (i10 < size) {
            setSucceeds(getPredecessor(size), i10);
            setSucceeds(i10, getSuccessor(size));
        }
        super.moveLastEntry(i10);
    }

    @Override // com.google.common.collect.ObjectCountHashMap
    public int nextIndex(int i10) {
        int successor = getSuccessor(i10);
        if (successor == -2) {
            return -1;
        }
        return successor;
    }

    @Override // com.google.common.collect.ObjectCountHashMap
    public int nextIndexAfterRemove(int i10, int i11) {
        return i10 == size() ? i11 : i10;
    }

    @Override // com.google.common.collect.ObjectCountHashMap
    public void resizeEntries(int i10) {
        super.resizeEntries(i10);
        long[] jArr = this.links;
        int length = jArr.length;
        long[] copyOf = Arrays.copyOf(jArr, i10);
        this.links = copyOf;
        Arrays.fill(copyOf, length, i10, -1L);
    }

    public ObjectCountLinkedHashMap(int i10) {
        this(i10, 1.0f);
    }

    public ObjectCountLinkedHashMap(int i10, float f10) {
        super(i10, f10);
    }

    public ObjectCountLinkedHashMap(ObjectCountHashMap<K> objectCountHashMap) {
        init(objectCountHashMap.size(), 1.0f);
        int firstIndex = objectCountHashMap.firstIndex();
        while (firstIndex != -1) {
            put(objectCountHashMap.getKey(firstIndex), objectCountHashMap.getValue(firstIndex));
            firstIndex = objectCountHashMap.nextIndex(firstIndex);
        }
    }
}
