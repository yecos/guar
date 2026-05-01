package io.jsonwebtoken.lang;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

/* loaded from: classes3.dex */
public final class Collections {

    public static class EnumerationIterator<E> implements Iterator<E> {
        private final Enumeration<E> enumeration;

        public EnumerationIterator(Enumeration<E> enumeration) {
            this.enumeration = enumeration;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.enumeration.hasMoreElements();
        }

        @Override // java.util.Iterator
        public E next() {
            return this.enumeration.nextElement();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Not supported");
        }
    }

    private Collections() {
    }

    public static List arrayToList(Object obj) {
        return java.util.Arrays.asList(Objects.toObjectArray(obj));
    }

    public static <T> Set<T> asSet(Collection<T> collection) {
        return collection instanceof Set ? (Set) collection : isEmpty((Collection<?>) collection) ? java.util.Collections.emptySet() : java.util.Collections.unmodifiableSet(new LinkedHashSet(collection));
    }

    @SafeVarargs
    public static <T> Set<T> concat(Set<T> set, T... tArr) {
        LinkedHashSet linkedHashSet = new LinkedHashSet(Math.max(1, size(set) + Arrays.length(tArr)));
        linkedHashSet.addAll(set);
        java.util.Collections.addAll(linkedHashSet, tArr);
        return immutable((Set) linkedHashSet);
    }

    public static boolean contains(Iterator it, Object obj) {
        if (it == null) {
            return false;
        }
        while (it.hasNext()) {
            if (Objects.nullSafeEquals(it.next(), obj)) {
                return true;
            }
        }
        return false;
    }

    public static boolean containsAny(Collection collection, Collection collection2) {
        if (!isEmpty((Collection<?>) collection) && !isEmpty((Collection<?>) collection2)) {
            Iterator it = collection2.iterator();
            while (it.hasNext()) {
                if (collection.contains(it.next())) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean containsInstance(Collection collection, Object obj) {
        if (collection == null) {
            return false;
        }
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            if (it.next() == obj) {
                return true;
            }
        }
        return false;
    }

    public static <T> List<T> emptyList() {
        return java.util.Collections.emptyList();
    }

    public static <K, V> Map<K, V> emptyMap() {
        return java.util.Collections.emptyMap();
    }

    public static <T> Set<T> emptySet() {
        return java.util.Collections.emptySet();
    }

    public static Class<?> findCommonElementType(Collection collection) {
        if (isEmpty((Collection<?>) collection)) {
            return null;
        }
        Class<?> cls = null;
        for (Object obj : collection) {
            if (obj != null) {
                if (cls == null) {
                    cls = obj.getClass();
                } else if (cls != obj.getClass()) {
                    return null;
                }
            }
        }
        return cls;
    }

    public static Object findFirstMatch(Collection collection, Collection collection2) {
        if (!isEmpty((Collection<?>) collection) && !isEmpty((Collection<?>) collection2)) {
            for (Object obj : collection2) {
                if (collection.contains(obj)) {
                    return obj;
                }
            }
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T> T findValueOfType(Collection<?> collection, Class<T> cls) {
        if (isEmpty(collection)) {
            return null;
        }
        T t10 = null;
        for (Object obj : collection) {
            if (cls == null || cls.isInstance(obj)) {
                if (t10 != null) {
                    return null;
                }
                t10 = obj;
            }
        }
        return t10;
    }

    public static boolean hasUniqueObject(Collection collection) {
        if (isEmpty((Collection<?>) collection)) {
            return false;
        }
        Object obj = null;
        boolean z10 = false;
        for (Object obj2 : collection) {
            if (!z10) {
                obj = obj2;
                z10 = true;
            } else if (obj != obj2) {
                return false;
            }
        }
        return true;
    }

    public static <K, V> Map<K, V> immutable(Map<K, V> map) {
        if (map != null) {
            return java.util.Collections.unmodifiableMap(map);
        }
        return null;
    }

    public static boolean isEmpty(Collection<?> collection) {
        return size(collection) == 0;
    }

    public static void mergeArrayIntoCollection(Object obj, Collection collection) {
        if (collection == null) {
            throw new IllegalArgumentException("Collection must not be null");
        }
        java.util.Collections.addAll(collection, Objects.toObjectArray(obj));
    }

    public static void mergePropertiesIntoMap(Properties properties, Map map) {
        if (map == null) {
            throw new IllegalArgumentException("Map must not be null");
        }
        if (properties != null) {
            Enumeration<?> propertyNames = properties.propertyNames();
            while (propertyNames.hasMoreElements()) {
                String str = (String) propertyNames.nextElement();
                Object property = properties.getProperty(str);
                if (property == null) {
                    property = properties.get(str);
                }
                map.put(str, property);
            }
        }
    }

    public static <T> Set<T> nullSafe(Set<T> set) {
        return set == null ? emptySet() : set;
    }

    @SafeVarargs
    public static <T> List<T> of(T... tArr) {
        return (tArr == null || tArr.length == 0) ? java.util.Collections.emptyList() : java.util.Collections.unmodifiableList(java.util.Arrays.asList(tArr));
    }

    @SafeVarargs
    public static <T> Set<T> setOf(T... tArr) {
        return (tArr == null || tArr.length == 0) ? java.util.Collections.emptySet() : immutable((Set) new LinkedHashSet(java.util.Arrays.asList(tArr)));
    }

    public static int size(Collection<?> collection) {
        if (collection == null) {
            return 0;
        }
        return collection.size();
    }

    public static <A, E extends A> A[] toArray(Enumeration<E> enumeration, A[] aArr) {
        ArrayList arrayList = new ArrayList();
        while (enumeration.hasMoreElements()) {
            arrayList.add(enumeration.nextElement());
        }
        return (A[]) arrayList.toArray(aArr);
    }

    public static <E> Iterator<E> toIterator(Enumeration<E> enumeration) {
        return new EnumerationIterator(enumeration);
    }

    public static <T> Set<T> immutable(Set<T> set) {
        if (set != null) {
            return java.util.Collections.unmodifiableSet(set);
        }
        return null;
    }

    public static boolean isEmpty(Map<?, ?> map) {
        return size(map) == 0;
    }

    public static <T> Collection<T> nullSafe(Collection<T> collection) {
        return collection == null ? emptyList() : collection;
    }

    public static int size(Map<?, ?> map) {
        if (map == null) {
            return 0;
        }
        return map.size();
    }

    public static <T> List<T> immutable(List<T> list) {
        if (list != null) {
            return java.util.Collections.unmodifiableList(list);
        }
        return null;
    }

    public static boolean contains(Enumeration enumeration, Object obj) {
        if (enumeration == null) {
            return false;
        }
        while (enumeration.hasMoreElements()) {
            if (Objects.nullSafeEquals(enumeration.nextElement(), obj)) {
                return true;
            }
        }
        return false;
    }

    public static Object findValueOfType(Collection<?> collection, Class<?>[] clsArr) {
        if (!isEmpty(collection) && !Objects.isEmpty((Object[]) clsArr)) {
            for (Class<?> cls : clsArr) {
                Object findValueOfType = findValueOfType(collection, cls);
                if (findValueOfType != null) {
                    return findValueOfType;
                }
            }
        }
        return null;
    }

    public static <T, C extends Collection<T>> C immutable(C c10) {
        if (c10 == null) {
            return null;
        }
        if (c10 instanceof Set) {
            return java.util.Collections.unmodifiableSet((Set) c10);
        }
        if (c10 instanceof List) {
            return java.util.Collections.unmodifiableList((List) c10);
        }
        return (C) java.util.Collections.unmodifiableCollection(c10);
    }
}
