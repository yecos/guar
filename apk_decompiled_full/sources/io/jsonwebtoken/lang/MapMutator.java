package io.jsonwebtoken.lang;

import io.jsonwebtoken.lang.MapMutator;
import java.util.Map;

/* loaded from: classes3.dex */
public interface MapMutator<K, V, T extends MapMutator<K, V, T>> {
    T add(K k10, V v10);

    T add(Map<? extends K, ? extends V> map);

    T delete(K k10);

    T empty();
}
