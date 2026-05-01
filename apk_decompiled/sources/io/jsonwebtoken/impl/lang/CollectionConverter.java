package io.jsonwebtoken.impl.lang;

import io.jsonwebtoken.lang.Assert;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/* loaded from: classes3.dex */
class CollectionConverter<T, C extends Collection<T>> implements Converter<C, Object> {
    private final Converter<T, Object> elementConverter;
    private final Function<Integer, C> fn;

    public static class CreateListFunction<A> implements Function<Integer, List<A>> {
        private CreateListFunction() {
        }

        @Override // io.jsonwebtoken.impl.lang.Function
        public List<A> apply(Integer num) {
            return num.intValue() > 0 ? new ArrayList(num.intValue()) : new ArrayList();
        }
    }

    public static class CreateSetFunction<T> implements Function<Integer, Set<T>> {
        private CreateSetFunction() {
        }

        @Override // io.jsonwebtoken.impl.lang.Function
        public Set<T> apply(Integer num) {
            return num.intValue() > 0 ? new LinkedHashSet(num.intValue()) : new LinkedHashSet();
        }
    }

    public CollectionConverter(Converter<T, Object> converter, Function<Integer, C> function) {
        this.elementConverter = (Converter) Assert.notNull(converter, "Element converter cannot be null.");
        this.fn = (Function) Assert.notNull(function, "Collection function cannot be null.");
    }

    public static <T> CollectionConverter<T, List<T>> forList(Converter<T, Object> converter) {
        return new CollectionConverter<>(converter, new CreateListFunction());
    }

    public static <T> CollectionConverter<T, Set<T>> forSet(Converter<T, Object> converter) {
        return new CollectionConverter<>(converter, new CreateSetFunction());
    }

    private C toElementList(Collection<?> collection) {
        Assert.notEmpty(collection, "Collection cannot be null or empty.");
        C apply = this.fn.apply(Integer.valueOf(collection.size()));
        Iterator<?> it = collection.iterator();
        while (it.hasNext()) {
            apply.add(this.elementConverter.applyFrom(it.next()));
        }
        return apply;
    }

    @Override // io.jsonwebtoken.impl.lang.Converter
    public C applyFrom(Object obj) {
        if (obj == null) {
            return null;
        }
        Collection<?> singletonList = (!obj.getClass().isArray() || obj.getClass().getComponentType().isPrimitive()) ? obj instanceof Collection ? (Collection) obj : Collections.singletonList(obj) : io.jsonwebtoken.lang.Collections.arrayToList(obj);
        return io.jsonwebtoken.lang.Collections.isEmpty(singletonList) ? this.fn.apply(0) : toElementList(singletonList);
    }

    @Override // io.jsonwebtoken.impl.lang.Converter
    public Object applyTo(C c10) {
        if (io.jsonwebtoken.lang.Collections.isEmpty((Collection<?>) c10)) {
            return c10;
        }
        C apply = this.fn.apply(Integer.valueOf(c10.size()));
        Iterator it = c10.iterator();
        while (it.hasNext()) {
            apply.add(this.elementConverter.applyTo(it.next()));
        }
        return apply;
    }
}
