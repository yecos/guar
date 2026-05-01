package io.jsonwebtoken.impl.lang;

import io.jsonwebtoken.lang.Arrays;
import io.jsonwebtoken.lang.Assert;
import java.util.Iterator;
import java.util.List;
import java.util.ServiceLoader;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* loaded from: classes3.dex */
public final class Services {
    private static final ConcurrentMap<Class<?>, Object> SERVICES = new ConcurrentHashMap();
    private static final List<ClassLoaderAccessor> CLASS_LOADER_ACCESSORS = Arrays.asList(new ClassLoaderAccessor[]{new ClassLoaderAccessor() { // from class: io.jsonwebtoken.impl.lang.Services.1
        @Override // io.jsonwebtoken.impl.lang.Services.ClassLoaderAccessor
        public ClassLoader getClassLoader() {
            return Thread.currentThread().getContextClassLoader();
        }
    }, new ClassLoaderAccessor() { // from class: io.jsonwebtoken.impl.lang.Services.2
        @Override // io.jsonwebtoken.impl.lang.Services.ClassLoaderAccessor
        public ClassLoader getClassLoader() {
            return Services.class.getClassLoader();
        }
    }, new ClassLoaderAccessor() { // from class: io.jsonwebtoken.impl.lang.Services.3
        @Override // io.jsonwebtoken.impl.lang.Services.ClassLoaderAccessor
        public ClassLoader getClassLoader() {
            return ClassLoader.getSystemClassLoader();
        }
    }});

    public interface ClassLoaderAccessor {
        ClassLoader getClassLoader();
    }

    private Services() {
    }

    private static <T> T findCached(Class<T> cls) {
        Assert.notNull(cls, "Service interface cannot be null.");
        Object obj = SERVICES.get(cls);
        if (obj != null) {
            return (T) Assert.isInstanceOf(cls, obj, "Unexpected cached service implementation type.");
        }
        return null;
    }

    public static <T> T get(Class<T> cls) {
        T t10 = (T) findCached(cls);
        if (t10 != null) {
            return t10;
        }
        T t11 = (T) loadFirst(cls);
        SERVICES.putIfAbsent(cls, t11);
        return t11;
    }

    private static <T> T loadFirst(Class<T> cls) {
        Iterator<ClassLoaderAccessor> it = CLASS_LOADER_ACCESSORS.iterator();
        while (it.hasNext()) {
            ServiceLoader load = ServiceLoader.load(cls, it.next().getClassLoader());
            Assert.stateNotNull(load, "JDK ServiceLoader#load should never return null.");
            Iterator it2 = load.iterator();
            Assert.stateNotNull(it2, "JDK ServiceLoader#iterator() should never return null.");
            if (it2.hasNext()) {
                return (T) it2.next();
            }
        }
        throw new UnavailableImplementationException(cls);
    }

    public static void reload() {
        SERVICES.clear();
    }
}
