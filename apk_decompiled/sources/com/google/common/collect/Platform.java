package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Map;
import java.util.Set;

@GwtCompatible(emulated = true)
@ElementTypesAreNonnullByDefault
/* loaded from: classes2.dex */
final class Platform {
    private Platform() {
    }

    public static void checkGwtRpcEnabled() {
    }

    public static <T> T[] copy(Object[] objArr, int i10, int i11, T[] tArr) {
        return (T[]) Arrays.copyOfRange(objArr, i10, i11, tArr.getClass());
    }

    public static <T> T[] newArray(T[] tArr, int i10) {
        return (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), i10));
    }

    public static <K, V> Map<K, V> newHashMapWithExpectedSize(int i10) {
        return CompactHashMap.createWithExpectedSize(i10);
    }

    public static <E> Set<E> newHashSetWithExpectedSize(int i10) {
        return CompactHashSet.createWithExpectedSize(i10);
    }

    public static <K, V> Map<K, V> newLinkedHashMapWithExpectedSize(int i10) {
        return CompactLinkedHashMap.createWithExpectedSize(i10);
    }

    public static <E> Set<E> newLinkedHashSetWithExpectedSize(int i10) {
        return CompactLinkedHashSet.createWithExpectedSize(i10);
    }

    public static <E> Set<E> preservesInsertionOrderOnAddsSet() {
        return CompactHashSet.create();
    }

    public static <K, V> Map<K, V> preservesInsertionOrderOnPutsMap() {
        return CompactHashMap.create();
    }

    public static int reduceExponentIfGwt(int i10) {
        return i10;
    }

    public static int reduceIterationsIfGwt(int i10) {
        return i10;
    }

    public static MapMaker tryWeakKeys(MapMaker mapMaker) {
        return mapMaker.weakKeys();
    }
}
