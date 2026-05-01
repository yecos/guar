package io.jsonwebtoken.impl;

import io.jsonwebtoken.impl.lang.Nameable;
import io.jsonwebtoken.impl.lang.Parameter;
import io.jsonwebtoken.impl.lang.ParameterReadable;
import io.jsonwebtoken.impl.lang.Parameters;
import io.jsonwebtoken.impl.lang.RedactedSupplier;
import io.jsonwebtoken.lang.Assert;
import io.jsonwebtoken.lang.Collections;
import io.jsonwebtoken.lang.Objects;
import io.jsonwebtoken.lang.Registry;
import io.jsonwebtoken.lang.Strings;
import java.util.AbstractSet;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/* loaded from: classes3.dex */
public class ParameterMap implements Map<String, Object>, ParameterReadable, Nameable {
    protected final Registry<String, ? extends Parameter<?>> PARAMS;
    protected final Map<String, Object> idiomaticValues;
    private final boolean initialized;
    private final boolean mutable;
    protected final Map<String, Object> values;

    public class EntryIterator extends ParameterMapIterator<Map.Entry<String, Object>> {
        private EntryIterator() {
            super();
        }

        @Override // java.util.Iterator
        public Map.Entry<String, Object> next() {
            return nextEntry();
        }
    }

    public class EntrySet extends ParameterMapSet<Map.Entry<String, Object>> {
        private EntrySet() {
            super();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Map.Entry<String, Object>> iterator() {
            return new EntryIterator();
        }
    }

    public class KeyIterator extends ParameterMapIterator<String> {
        private KeyIterator() {
            super();
        }

        @Override // java.util.Iterator
        public String next() {
            return nextEntry().getKey();
        }
    }

    public class KeySet extends ParameterMapSet<String> {
        private KeySet() {
            super();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<String> iterator() {
            return new KeyIterator();
        }
    }

    public abstract class ParameterMapIterator<T> implements Iterator<T> {
        transient Map.Entry<String, Object> current = null;

        /* renamed from: i, reason: collision with root package name */
        final Iterator<Map.Entry<String, Object>> f14453i;

        public ParameterMapIterator() {
            this.f14453i = ParameterMap.this.values.entrySet().iterator();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f14453i.hasNext();
        }

        public Map.Entry<String, Object> nextEntry() {
            Map.Entry<String, Object> next = this.f14453i.next();
            this.current = next;
            return next;
        }

        @Override // java.util.Iterator
        public void remove() {
            Map.Entry<String, Object> entry = this.current;
            if (entry == null) {
                throw new IllegalStateException();
            }
            ParameterMap.this.remove(entry.getKey());
        }
    }

    public abstract class ParameterMapSet<T> extends AbstractSet<T> {
        private ParameterMapSet() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return ParameterMap.this.size();
        }
    }

    public class ValueIterator extends ParameterMapIterator<Object> {
        private ValueIterator() {
            super();
        }

        @Override // java.util.Iterator
        public Object next() {
            return nextEntry().getValue();
        }
    }

    public class ValueSet extends ParameterMapSet<Object> {
        private ValueSet() {
            super();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Object> iterator() {
            return new ValueIterator();
        }
    }

    public ParameterMap(Set<Parameter<?>> set) {
        this(Parameters.registry(set));
    }

    private <T> Object apply(Parameter<T> parameter, Object obj) {
        String id = parameter.getId();
        if (Objects.isEmpty(obj)) {
            return remove(id);
        }
        try {
            T applyFrom = parameter.applyFrom(obj);
            Assert.notNull(applyFrom, "Parameter's resulting idiomaticValue cannot be null.");
            Object applyTo = parameter.applyTo(applyFrom);
            Assert.notNull(applyTo, "Parameter's resulting canonicalValue cannot be null.");
            this.idiomaticValues.put(id, applyFrom);
            return this.values.put(id, applyTo);
        } catch (Exception e10) {
            StringBuilder sb = new StringBuilder(100);
            sb.append("Invalid ");
            sb.append(getName());
            sb.append(" ");
            sb.append(parameter);
            sb.append(" value");
            if (parameter.isSecret()) {
                sb.append(": ");
                sb.append(RedactedSupplier.REDACTED_VALUE);
            } else if (!(obj instanceof byte[])) {
                sb.append(": ");
                sb.append(Objects.nullSafeToString(obj));
            }
            sb.append(". ");
            sb.append(e10.getMessage());
            throw new IllegalArgumentException(sb.toString(), e10);
        }
    }

    private void assertMutable() {
        if (!this.initialized || this.mutable) {
            return;
        }
        throw new UnsupportedOperationException(getName() + " instance is immutable and may not be modified.");
    }

    private Object nullSafePut(String str, Object obj) {
        if (obj == null) {
            return remove(str);
        }
        this.idiomaticValues.put(str, obj);
        return this.values.put(str, obj);
    }

    @Override // java.util.Map
    public void clear() {
        assertMutable();
        this.values.clear();
        this.idiomaticValues.clear();
    }

    @Override // java.util.Map
    public boolean containsKey(Object obj) {
        return this.values.containsKey(obj);
    }

    @Override // java.util.Map
    public boolean containsValue(Object obj) {
        return this.values.containsValue(obj);
    }

    @Override // java.util.Map
    public Set<Map.Entry<String, Object>> entrySet() {
        return new EntrySet();
    }

    @Override // java.util.Map
    public boolean equals(Object obj) {
        return this.values.equals(obj);
    }

    @Override // io.jsonwebtoken.impl.lang.ParameterReadable
    public <T> T get(Parameter<T> parameter) {
        Assert.notNull(parameter, "Parameter cannot be null.");
        return parameter.cast(this.idiomaticValues.get((String) Assert.hasText(parameter.getId(), "Parameter id cannot be null or empty.")));
    }

    public String getName() {
        return "Map";
    }

    @Override // java.util.Map
    public int hashCode() {
        return this.values.hashCode();
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        return this.values.isEmpty();
    }

    @Override // java.util.Map
    public Set<String> keySet() {
        return new KeySet();
    }

    @Override // java.util.Map
    public void putAll(Map<? extends String, ? extends Object> map) {
        if (map == null) {
            return;
        }
        for (Map.Entry<? extends String, ? extends Object> entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    @Override // java.util.Map
    public Object remove(Object obj) {
        assertMutable();
        this.idiomaticValues.remove(obj);
        return this.values.remove(obj);
    }

    public ParameterMap replace(Parameter<?> parameter) {
        return new ParameterMap(Parameters.replace(this.PARAMS, parameter), this, this.mutable);
    }

    @Override // java.util.Map
    public int size() {
        return this.values.size();
    }

    public String toString() {
        return this.values.toString();
    }

    @Override // java.util.Map
    public Collection<Object> values() {
        return new ValueSet();
    }

    public ParameterMap(Registry<String, ? extends Parameter<?>> registry) {
        this(registry, null, true);
    }

    public final <T> Object put(Parameter<T> parameter, Object obj) {
        assertMutable();
        Assert.notNull(parameter, "Parameter cannot be null.");
        Assert.hasText(parameter.getId(), "Parameter id cannot be null or empty.");
        return apply(parameter, obj);
    }

    public ParameterMap(Registry<String, ? extends Parameter<?>> registry, Map<String, ?> map) {
        this(registry, (Map) Assert.notNull(map, "Map argument cannot be null."), false);
    }

    public ParameterMap(Registry<String, ? extends Parameter<?>> registry, Map<String, ?> map, boolean z10) {
        Assert.notNull(registry, "Parameter registry cannot be null.");
        Assert.notEmpty(registry.values(), "Parameter registry cannot be empty.");
        this.PARAMS = registry;
        this.values = new LinkedHashMap();
        this.idiomaticValues = new LinkedHashMap();
        if (!Collections.isEmpty(map)) {
            putAll(map);
        }
        this.mutable = z10;
        this.initialized = true;
    }

    @Override // java.util.Map
    public Object get(Object obj) {
        return this.values.get(obj);
    }

    @Override // java.util.Map
    public final Object put(String str, Object obj) {
        assertMutable();
        String str2 = (String) Assert.notNull(Strings.clean(str), "Member name cannot be null or empty.");
        Parameter<?> parameter = this.PARAMS.get(str2);
        if (parameter != null) {
            return put((Parameter) parameter, obj);
        }
        return nullSafePut(str2, obj);
    }
}
