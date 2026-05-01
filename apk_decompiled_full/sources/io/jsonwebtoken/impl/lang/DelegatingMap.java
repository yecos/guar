package io.jsonwebtoken.impl.lang;

import io.jsonwebtoken.lang.Assert;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

/* loaded from: classes3.dex */
public class DelegatingMap<K, V, T extends Map<K, V>> implements Map<K, V> {
    protected T DELEGATE;

    public DelegatingMap(T t10) {
        setDelegate(t10);
    }

    @Override // java.util.Map
    public void clear() {
        this.DELEGATE.clear();
    }

    @Override // java.util.Map
    public boolean containsKey(Object obj) {
        return this.DELEGATE.containsKey(obj);
    }

    @Override // java.util.Map
    public boolean containsValue(Object obj) {
        return this.DELEGATE.containsValue(obj);
    }

    @Override // java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        return this.DELEGATE.entrySet();
    }

    @Override // java.util.Map
    public V get(Object obj) {
        return (V) this.DELEGATE.get(obj);
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        return this.DELEGATE.isEmpty();
    }

    @Override // java.util.Map
    public Set<K> keySet() {
        return this.DELEGATE.keySet();
    }

    @Override // java.util.Map
    public V put(K k10, V v10) {
        return (V) this.DELEGATE.put(k10, v10);
    }

    @Override // java.util.Map
    public void putAll(Map<? extends K, ? extends V> map) {
        this.DELEGATE.putAll(map);
    }

    @Override // java.util.Map
    public V remove(Object obj) {
        return (V) this.DELEGATE.remove(obj);
    }

    public void setDelegate(T t10) {
        this.DELEGATE = (T) Assert.notNull(t10, "Delegate cannot be null.");
    }

    @Override // java.util.Map
    public int size() {
        return this.DELEGATE.size();
    }

    @Override // java.util.Map
    public Collection<V> values() {
        return this.DELEGATE.values();
    }
}
