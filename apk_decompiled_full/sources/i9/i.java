package i9;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* loaded from: classes3.dex */
public abstract class i {
    public static final Object[] a(Object[] objArr, boolean z10) {
        t9.i.g(objArr, "<this>");
        if (z10 && t9.i.b(objArr.getClass(), Object[].class)) {
            return objArr;
        }
        Object[] copyOf = Arrays.copyOf(objArr, objArr.length, Object[].class);
        t9.i.f(copyOf, "copyOf(this, this.size, Array<Any?>::class.java)");
        return copyOf;
    }

    public static final List b(Object obj) {
        List singletonList = Collections.singletonList(obj);
        t9.i.f(singletonList, "singletonList(element)");
        return singletonList;
    }
}
