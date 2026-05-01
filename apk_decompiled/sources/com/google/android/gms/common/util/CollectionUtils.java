package com.google.android.gms.common.util;

import androidx.collection.a;
import androidx.collection.b;
import com.google.android.gms.common.annotation.KeepForSdk;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@KeepForSdk
/* loaded from: classes.dex */
public final class CollectionUtils {
    private CollectionUtils() {
    }

    @KeepForSdk
    public static boolean isEmpty(Collection<?> collection) {
        if (collection == null) {
            return true;
        }
        return collection.isEmpty();
    }

    @KeepForSdk
    @Deprecated
    public static <T> List<T> listOf() {
        return Collections.emptyList();
    }

    @KeepForSdk
    public static <K, V> Map<K, V> mapOf(K k10, V v10, K k11, V v11, K k12, V v12) {
        Map zza = zza(3, false);
        zza.put(k10, v10);
        zza.put(k11, v11);
        zza.put(k12, v12);
        return Collections.unmodifiableMap(zza);
    }

    @KeepForSdk
    public static <K, V> Map<K, V> mapOfKeyValueArrays(K[] kArr, V[] vArr) {
        int length = kArr.length;
        int length2 = vArr.length;
        if (length != length2) {
            throw new IllegalArgumentException("Key and values array lengths not equal: " + length + " != " + length2);
        }
        if (length == 0) {
            return Collections.emptyMap();
        }
        if (length == 1) {
            return Collections.singletonMap(kArr[0], vArr[0]);
        }
        Map zza = zza(length, false);
        for (int i10 = 0; i10 < kArr.length; i10++) {
            zza.put(kArr[i10], vArr[i10]);
        }
        return Collections.unmodifiableMap(zza);
    }

    @KeepForSdk
    public static <T> Set<T> mutableSetOfWithSize(int i10) {
        return i10 == 0 ? new b() : zzb(i10, true);
    }

    @KeepForSdk
    @Deprecated
    public static <T> Set<T> setOf(T t10, T t11, T t12) {
        Set zzb = zzb(3, false);
        zzb.add(t10);
        zzb.add(t11);
        zzb.add(t12);
        return Collections.unmodifiableSet(zzb);
    }

    private static Map zza(int i10, boolean z10) {
        return i10 <= 256 ? new a(i10) : new HashMap(i10, 1.0f);
    }

    private static Set zzb(int i10, boolean z10) {
        return i10 <= (true != z10 ? 256 : 128) ? new b(i10) : new HashSet(i10, true != z10 ? 1.0f : 0.75f);
    }

    @KeepForSdk
    @Deprecated
    public static <T> List<T> listOf(T t10) {
        return Collections.singletonList(t10);
    }

    @KeepForSdk
    @Deprecated
    public static <T> List<T> listOf(T... tArr) {
        int length = tArr.length;
        if (length == 0) {
            return listOf();
        }
        if (length != 1) {
            return Collections.unmodifiableList(Arrays.asList(tArr));
        }
        return listOf(tArr[0]);
    }

    @KeepForSdk
    public static <K, V> Map<K, V> mapOf(K k10, V v10, K k11, V v11, K k12, V v12, K k13, V v13, K k14, V v14, K k15, V v15) {
        Map zza = zza(6, false);
        zza.put(k10, v10);
        zza.put(k11, v11);
        zza.put(k12, v12);
        zza.put(k13, v13);
        zza.put(k14, v14);
        zza.put(k15, v15);
        return Collections.unmodifiableMap(zza);
    }

    @KeepForSdk
    @Deprecated
    public static <T> Set<T> setOf(T... tArr) {
        int length = tArr.length;
        if (length == 0) {
            return Collections.emptySet();
        }
        if (length == 1) {
            return Collections.singleton(tArr[0]);
        }
        if (length == 2) {
            T t10 = tArr[0];
            T t11 = tArr[1];
            Set zzb = zzb(2, false);
            zzb.add(t10);
            zzb.add(t11);
            return Collections.unmodifiableSet(zzb);
        }
        if (length == 3) {
            return setOf(tArr[0], tArr[1], tArr[2]);
        }
        if (length != 4) {
            Set zzb2 = zzb(length, false);
            Collections.addAll(zzb2, tArr);
            return Collections.unmodifiableSet(zzb2);
        }
        T t12 = tArr[0];
        T t13 = tArr[1];
        T t14 = tArr[2];
        T t15 = tArr[3];
        Set zzb3 = zzb(4, false);
        zzb3.add(t12);
        zzb3.add(t13);
        zzb3.add(t14);
        zzb3.add(t15);
        return Collections.unmodifiableSet(zzb3);
    }
}
