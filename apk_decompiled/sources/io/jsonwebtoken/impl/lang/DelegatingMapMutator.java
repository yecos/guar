package io.jsonwebtoken.impl.lang;

import io.jsonwebtoken.lang.MapMutator;
import java.util.Map;

/* loaded from: classes3.dex */
public class DelegatingMapMutator<K, V, D extends Map<K, V>, T extends MapMutator<K, V, T>> extends DelegatingMap<K, V, D> implements MapMutator<K, V, T> {
    public DelegatingMapMutator(D d10) {
        super(d10);
    }

    @Override // io.jsonwebtoken.lang.MapMutator
    public T add(K k10, V v10) {
        put(k10, v10);
        return self();
    }

    @Override // io.jsonwebtoken.lang.MapMutator
    public T delete(K k10) {
        remove(k10);
        return self();
    }

    @Override // io.jsonwebtoken.lang.MapMutator
    public T empty() {
        clear();
        return self();
    }

    public final T self() {
        return this;
    }

    @Override // io.jsonwebtoken.lang.MapMutator
    public T add(Map<? extends K, ? extends V> map) {
        putAll(map);
        return self();
    }
}
