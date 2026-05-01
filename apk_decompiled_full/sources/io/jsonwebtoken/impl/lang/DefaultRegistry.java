package io.jsonwebtoken.impl.lang;

import io.jsonwebtoken.lang.Assert;
import io.jsonwebtoken.lang.Collections;
import io.jsonwebtoken.lang.Registry;
import io.jsonwebtoken.lang.Strings;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

/* loaded from: classes3.dex */
public class DefaultRegistry<K, V> extends DelegatingMap<K, V, Map<K, V>> implements Registry<K, V>, Function<K, V> {
    private final String qualifiedKeyName;

    public DefaultRegistry(String str, String str2, Collection<? extends V> collection, Function<V, K> function) {
        super(toMap(collection, function));
        this.qualifiedKeyName = ((String) Assert.hasText(Strings.clean(str), "name cannot be null or empty.")) + " " + ((String) Assert.hasText(Strings.clean(str2), "keyName cannot be null or empty."));
    }

    public static <T> T immutable() {
        throw new UnsupportedOperationException("Registries are immutable and cannot be modified.");
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static <K, V> Map<K, V> toMap(Collection<? extends V> collection, Function<V, K> function) {
        Assert.notEmpty(collection, "Collection of values may not be null or empty.");
        Assert.notNull(function, "Key function cannot be null.");
        LinkedHashMap linkedHashMap = new LinkedHashMap(collection.size());
        for (V v10 : collection) {
            linkedHashMap.put(Assert.notNull(function.apply(v10), "Key function cannot return a null value."), v10);
        }
        return Collections.immutable(linkedHashMap);
    }

    @Override // io.jsonwebtoken.impl.lang.Function
    public V apply(K k10) {
        return get(k10);
    }

    @Override // io.jsonwebtoken.impl.lang.DelegatingMap, java.util.Map
    public void clear() {
        immutable();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Map
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof DefaultRegistry)) {
            return false;
        }
        DefaultRegistry defaultRegistry = (DefaultRegistry) obj;
        return this.qualifiedKeyName.equals(defaultRegistry.qualifiedKeyName) && this.DELEGATE.equals(defaultRegistry.DELEGATE);
    }

    @Override // io.jsonwebtoken.lang.Registry
    public V forKey(K k10) {
        V v10 = get(k10);
        if (v10 != null) {
            return v10;
        }
        throw new IllegalArgumentException("Unrecognized " + this.qualifiedKeyName + ": " + k10);
    }

    @Override // java.util.Map
    public int hashCode() {
        return this.DELEGATE.hashCode();
    }

    @Override // io.jsonwebtoken.impl.lang.DelegatingMap, java.util.Map
    public V put(K k10, V v10) {
        return (V) immutable();
    }

    @Override // io.jsonwebtoken.impl.lang.DelegatingMap, java.util.Map
    public void putAll(Map<? extends K, ? extends V> map) {
        immutable();
    }

    @Override // io.jsonwebtoken.impl.lang.DelegatingMap, java.util.Map
    public V remove(Object obj) {
        return (V) immutable();
    }

    public String toString() {
        return this.DELEGATE.toString();
    }
}
