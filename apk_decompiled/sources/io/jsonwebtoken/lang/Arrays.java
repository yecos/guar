package io.jsonwebtoken.lang;

import java.lang.reflect.Array;
import java.util.List;

/* loaded from: classes3.dex */
public final class Arrays {
    private Arrays() {
    }

    public static <T> List<T> asList(T[] tArr) {
        return Objects.isEmpty((Object[]) tArr) ? Collections.emptyList() : java.util.Arrays.asList(tArr);
    }

    public static byte[] clean(byte[] bArr) {
        if (length(bArr) > 0) {
            return bArr;
        }
        return null;
    }

    public static Object copy(Object obj) {
        if (obj == null) {
            return null;
        }
        Assert.isTrue(Objects.isArray(obj), "Argument must be an array.");
        if (obj instanceof Object[]) {
            return ((Object[]) obj).clone();
        }
        if (obj instanceof boolean[]) {
            return ((boolean[]) obj).clone();
        }
        if (obj instanceof byte[]) {
            return ((byte[]) obj).clone();
        }
        if (obj instanceof char[]) {
            return ((char[]) obj).clone();
        }
        if (obj instanceof double[]) {
            return ((double[]) obj).clone();
        }
        if (obj instanceof float[]) {
            return ((float[]) obj).clone();
        }
        if (obj instanceof int[]) {
            return ((int[]) obj).clone();
        }
        if (obj instanceof long[]) {
            return ((long[]) obj).clone();
        }
        if (obj instanceof short[]) {
            return ((short[]) obj).clone();
        }
        Class<?> componentType = obj.getClass().getComponentType();
        int length = Array.getLength(obj);
        Object[] objArr = (Object[]) Array.newInstance(componentType, length);
        for (int i10 = 0; i10 < length; i10++) {
            objArr[i10] = Array.get(obj, i10);
        }
        return objArr;
    }

    public static <T> int length(T[] tArr) {
        if (tArr == null) {
            return 0;
        }
        return tArr.length;
    }

    public static int length(byte[] bArr) {
        if (bArr != null) {
            return bArr.length;
        }
        return 0;
    }
}
