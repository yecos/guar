package io.jsonwebtoken.lang;

import java.util.HashMap;
import java.util.Map;

/* loaded from: classes3.dex */
public final class Maps {

    public static class HashMapBuilder<K, V> implements MapBuilder<K, V> {
        private final Map<K, V> data;

        private HashMapBuilder() {
            this.data = new HashMap();
        }

        @Override // io.jsonwebtoken.lang.Maps.MapBuilder
        public MapBuilder<K, V> and(K k10, V v10) {
            this.data.put(k10, v10);
            return this;
        }

        @Override // io.jsonwebtoken.lang.Builder
        public Map<K, V> build() {
            return java.util.Collections.unmodifiableMap(this.data);
        }
    }

    public interface MapBuilder<K, V> extends Builder<Map<K, V>> {
        MapBuilder<K, V> and(K k10, V v10);

        @Override // io.jsonwebtoken.lang.Builder
        Map<K, V> build();
    }

    private Maps() {
    }

    public static <K, V> MapBuilder<K, V> of(K k10, V v10) {
        return new HashMapBuilder().and(k10, v10);
    }
}
