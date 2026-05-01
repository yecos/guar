package io.jsonwebtoken.lang;

import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;

/* loaded from: classes3.dex */
public final class Classes {
    private static final ClassLoaderAccessor THREAD_CL_ACCESSOR = new ExceptionIgnoringAccessor() { // from class: io.jsonwebtoken.lang.Classes.1
        @Override // io.jsonwebtoken.lang.Classes.ExceptionIgnoringAccessor
        public ClassLoader doGetClassLoader() {
            return Thread.currentThread().getContextClassLoader();
        }
    };
    private static final ClassLoaderAccessor CLASS_CL_ACCESSOR = new ExceptionIgnoringAccessor() { // from class: io.jsonwebtoken.lang.Classes.2
        @Override // io.jsonwebtoken.lang.Classes.ExceptionIgnoringAccessor
        public ClassLoader doGetClassLoader() {
            return Classes.class.getClassLoader();
        }
    };
    private static final ClassLoaderAccessor SYSTEM_CL_ACCESSOR = new ExceptionIgnoringAccessor() { // from class: io.jsonwebtoken.lang.Classes.3
        @Override // io.jsonwebtoken.lang.Classes.ExceptionIgnoringAccessor
        public ClassLoader doGetClassLoader() {
            return ClassLoader.getSystemClassLoader();
        }
    };

    public interface ClassLoaderAccessor {
        URL getResource(String str);

        InputStream getResourceStream(String str);

        Class<?> loadClass(String str);
    }

    public static abstract class ExceptionIgnoringAccessor implements ClassLoaderAccessor {
        private ExceptionIgnoringAccessor() {
        }

        public abstract ClassLoader doGetClassLoader();

        public final ClassLoader getClassLoader() {
            try {
                return doGetClassLoader();
            } catch (Throwable unused) {
                return null;
            }
        }

        @Override // io.jsonwebtoken.lang.Classes.ClassLoaderAccessor
        public URL getResource(String str) {
            ClassLoader classLoader = getClassLoader();
            if (classLoader != null) {
                return classLoader.getResource(str);
            }
            return null;
        }

        @Override // io.jsonwebtoken.lang.Classes.ClassLoaderAccessor
        public InputStream getResourceStream(String str) {
            ClassLoader classLoader = getClassLoader();
            if (classLoader != null) {
                return classLoader.getResourceAsStream(str);
            }
            return null;
        }

        @Override // io.jsonwebtoken.lang.Classes.ClassLoaderAccessor
        public Class<?> loadClass(String str) {
            ClassLoader classLoader = getClassLoader();
            if (classLoader != null) {
                try {
                    return classLoader.loadClass(str);
                } catch (ClassNotFoundException unused) {
                }
            }
            return null;
        }
    }

    private Classes() {
    }

    public static <T> Class<T> forName(String str) {
        GenericDeclaration loadClass = THREAD_CL_ACCESSOR.loadClass(str);
        if (loadClass == null) {
            loadClass = (Class<T>) CLASS_CL_ACCESSOR.loadClass(str);
        }
        if (loadClass == null) {
            loadClass = (Class<T>) SYSTEM_CL_ACCESSOR.loadClass(str);
        }
        if (loadClass != null) {
            return (Class<T>) loadClass;
        }
        String str2 = "Unable to load class named [" + str + "] from the thread context, current, or system/application ClassLoaders.  All heuristics have been exhausted.  Class could not be found.";
        if (str != null && str.startsWith("io.jsonwebtoken.impl")) {
            str2 = str2 + "  Have you remembered to include the jjwt-impl.jar in your runtime classpath?";
        }
        throw new UnknownClassException(str2);
    }

    public static <T> Constructor<T> getConstructor(Class<T> cls, Class<?>... clsArr) {
        try {
            return cls.getConstructor(clsArr);
        } catch (NoSuchMethodException e10) {
            throw new IllegalStateException(e10);
        }
    }

    public static <T> T getFieldValue(Object obj, String str, Class<T> cls) {
        if (obj == null) {
            return null;
        }
        try {
            Field declaredField = obj.getClass().getDeclaredField(str);
            declaredField.setAccessible(true);
            return cls.cast(declaredField.get(obj));
        } catch (Throwable th) {
            throw new IllegalStateException("Unable to read field " + obj.getClass().getName() + "#" + str + ": " + th.getMessage(), th);
        }
    }

    private static URL getResource(String str) {
        URL resource = THREAD_CL_ACCESSOR.getResource(str);
        if (resource == null) {
            resource = CLASS_CL_ACCESSOR.getResource(str);
        }
        return resource == null ? SYSTEM_CL_ACCESSOR.getResource(str) : resource;
    }

    public static InputStream getResourceAsStream(String str) {
        InputStream resourceStream = THREAD_CL_ACCESSOR.getResourceStream(str);
        if (resourceStream == null) {
            resourceStream = CLASS_CL_ACCESSOR.getResourceStream(str);
        }
        return resourceStream == null ? SYSTEM_CL_ACCESSOR.getResourceStream(str) : resourceStream;
    }

    public static <T> T instantiate(Constructor<T> constructor, Object... objArr) {
        try {
            return constructor.newInstance(objArr);
        } catch (Exception e10) {
            throw new InstantiationException("Unable to instantiate instance with constructor [" + constructor + "]", e10);
        }
    }

    public static <T> T invokeStatic(String str, String str2, Class<?>[] clsArr, Object... objArr) {
        try {
            return (T) invokeStatic((Class<?>) forName(str), str2, clsArr, objArr);
        } catch (Exception e10) {
            throw new IllegalStateException("Unable to invoke class method " + str + "#" + str2 + ".  Ensure the necessary implementation is in the runtime classpath.", e10);
        }
    }

    public static boolean isAvailable(String str) {
        try {
            forName(str);
            return true;
        } catch (UnknownClassException unused) {
            return false;
        }
    }

    public static <T> T newInstance(String str) {
        return (T) newInstance(forName(str));
    }

    public static <T> T newInstance(String str, Class<?>[] clsArr, Object... objArr) {
        return (T) instantiate(getConstructor(forName(str), clsArr), objArr);
    }

    public static <T> T invokeStatic(Class<?> cls, String str, Class<?>[] clsArr, Object... objArr) {
        try {
            Method declaredMethod = cls.getDeclaredMethod(str, clsArr);
            declaredMethod.setAccessible(true);
            return (T) declaredMethod.invoke(null, objArr);
        } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException e10) {
            Throwable cause = e10.getCause();
            if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            }
            throw new IllegalStateException("Unable to invoke class method " + cls.getName() + "#" + str + ". Ensure the necessary implementation is in the runtime classpath.", e10);
        }
    }

    public static <T> T newInstance(String str, Object... objArr) {
        return (T) newInstance(forName(str), objArr);
    }

    public static <T> T newInstance(Class<T> cls) {
        if (cls != null) {
            try {
                return cls.newInstance();
            } catch (Exception e10) {
                throw new InstantiationException("Unable to instantiate class [" + cls.getName() + "]", e10);
            }
        }
        throw new IllegalArgumentException("Class method parameter cannot be null.");
    }

    public static <T> T newInstance(Class<T> cls, Object... objArr) {
        Class[] clsArr = new Class[objArr.length];
        for (int i10 = 0; i10 < objArr.length; i10++) {
            clsArr[i10] = objArr[i10].getClass();
        }
        return (T) instantiate(getConstructor(cls, clsArr), objArr);
    }
}
