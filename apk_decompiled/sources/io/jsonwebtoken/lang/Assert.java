package io.jsonwebtoken.lang;

import java.util.Collection;
import java.util.Map;

/* loaded from: classes3.dex */
public final class Assert {
    private Assert() {
    }

    private static <T extends Comparable<T>> int compareTo(T t10, T t11) {
        notNull(t10, "value cannot be null.");
        notNull(t11, "requirement cannot be null.");
        return t10.compareTo(t11);
    }

    public static void doesNotContain(String str, String str2, String str3) {
        if (Strings.hasLength(str) && Strings.hasLength(str2) && str.indexOf(str2) != -1) {
            throw new IllegalArgumentException(str3);
        }
    }

    public static <T extends Comparable<T>> T eq(T t10, T t11, String str) {
        if (compareTo(t10, t11) == 0) {
            return t10;
        }
        throw new IllegalArgumentException(str);
    }

    public static <T extends Comparable<T>> T gt(T t10, T t11, String str) {
        if (compareTo(t10, t11) > 0) {
            return t10;
        }
        throw new IllegalArgumentException(str);
    }

    public static void hasLength(String str, String str2) {
        if (!Strings.hasLength(str)) {
            throw new IllegalArgumentException(str2);
        }
    }

    public static <T extends CharSequence> T hasText(T t10, String str) {
        if (Strings.hasText(t10)) {
            return t10;
        }
        throw new IllegalArgumentException(str);
    }

    public static void isAssignable(Class cls, Class cls2) {
        isAssignable(cls, cls2, "");
    }

    public static <T> T isInstanceOf(Class<T> cls, Object obj) {
        return (T) isInstanceOf(cls, obj, "");
    }

    public static void isNull(Object obj, String str) {
        if (obj != null) {
            throw new IllegalArgumentException(str);
        }
    }

    public static void isTrue(boolean z10, String str) {
        if (!z10) {
            throw new IllegalArgumentException(str);
        }
    }

    public static <T extends Comparable<T>> T lte(T t10, T t11, String str) {
        if (compareTo(t10, t11) <= 0) {
            return t10;
        }
        throw new IllegalArgumentException(str);
    }

    public static void noNullElements(Object[] objArr, String str) {
        if (objArr != null) {
            for (Object obj : objArr) {
                if (obj == null) {
                    throw new IllegalArgumentException(str);
                }
            }
        }
    }

    public static Object[] notEmpty(Object[] objArr, String str) {
        if (Objects.isEmpty(objArr)) {
            throw new IllegalArgumentException(str);
        }
        return objArr;
    }

    public static <T> T notNull(T t10, String str) {
        if (t10 != null) {
            return t10;
        }
        throw new IllegalArgumentException(str);
    }

    public static void state(boolean z10, String str) {
        if (!z10) {
            throw new IllegalStateException(str);
        }
    }

    public static <T> T stateIsInstance(Class<T> cls, Object obj, String str) {
        notNull(cls, "Type to check cannot be null.");
        if (cls.isInstance(obj)) {
            return cls.cast(obj);
        }
        throw new IllegalStateException(str + "Object of class [" + Objects.nullSafeClassName(obj) + "] must be an instance of " + cls);
    }

    public static <T> T stateNotNull(T t10, String str) {
        if (t10 != null) {
            return t10;
        }
        throw new IllegalStateException(str);
    }

    public static void isAssignable(Class cls, Class cls2, String str) {
        notNull(cls, "Type to check against must not be null");
        if (cls2 == null || !cls.isAssignableFrom(cls2)) {
            throw new IllegalArgumentException(str + cls2 + " is not assignable to " + cls);
        }
    }

    public static <T> T isInstanceOf(Class<T> cls, Object obj, String str) {
        notNull(cls, "Type to check against must not be null");
        if (cls.isInstance(obj)) {
            return cls.cast(obj);
        }
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append("Object of class [");
        sb.append(obj != null ? obj.getClass().getName() : "null");
        sb.append("] must be an instance of ");
        sb.append(cls);
        throw new IllegalArgumentException(sb.toString());
    }

    public static void isNull(Object obj) {
        isNull(obj, "[Assertion failed] - the object argument must be null");
    }

    public static void isTrue(boolean z10) {
        isTrue(z10, "[Assertion failed] - this expression must be true");
    }

    public static void notNull(Object obj) {
        notNull(obj, "[Assertion failed] - this argument is required; it must not be null");
    }

    public static void state(boolean z10) {
        state(z10, "[Assertion failed] - this state invariant must be true");
    }

    public static void doesNotContain(String str, String str2) {
        doesNotContain(str, str2, "[Assertion failed] - this String argument must not contain the substring [" + str2 + "]");
    }

    public static void hasLength(String str) {
        hasLength(str, "[Assertion failed] - this String argument must have length; it must not be null or empty");
    }

    public static void hasText(String str) {
        hasText(str, "[Assertion failed] - this String argument must have text; it must not be null, empty, or blank");
    }

    public static void notEmpty(Object[] objArr) {
        notEmpty(objArr, "[Assertion failed] - this array must not be empty: it must contain at least 1 element");
    }

    public static void noNullElements(Object[] objArr) {
        noNullElements(objArr, "[Assertion failed] - this array must not contain any null elements");
    }

    public static byte[] notEmpty(byte[] bArr, String str) {
        if (Objects.isEmpty(bArr)) {
            throw new IllegalArgumentException(str);
        }
        return bArr;
    }

    public static char[] notEmpty(char[] cArr, String str) {
        if (Objects.isEmpty(cArr)) {
            throw new IllegalArgumentException(str);
        }
        return cArr;
    }

    public static <T extends Collection<?>> T notEmpty(T t10, String str) {
        if (Collections.isEmpty(t10)) {
            throw new IllegalArgumentException(str);
        }
        return t10;
    }

    public static void notEmpty(Collection<?> collection) {
        notEmpty(collection, "[Assertion failed] - this collection must not be empty: it must contain at least 1 element");
    }

    public static <T extends Map<?, ?>> T notEmpty(T t10, String str) {
        if (Collections.isEmpty(t10)) {
            throw new IllegalArgumentException(str);
        }
        return t10;
    }

    public static void notEmpty(Map map) {
        notEmpty(map, "[Assertion failed] - this map must not be empty; it must contain at least one entry");
    }
}
