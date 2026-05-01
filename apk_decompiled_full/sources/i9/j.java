package i9;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* loaded from: classes3.dex */
public abstract class j extends i {
    public static final ArrayList c(Object... objArr) {
        t9.i.g(objArr, "elements");
        return objArr.length == 0 ? new ArrayList() : new ArrayList(new c(objArr, true));
    }

    public static final List d() {
        return t.f14401a;
    }

    public static final y9.c e(Collection collection) {
        t9.i.g(collection, "<this>");
        return new y9.c(0, collection.size() - 1);
    }

    public static final int f(List list) {
        t9.i.g(list, "<this>");
        return list.size() - 1;
    }

    public static final List g(Object... objArr) {
        t9.i.g(objArr, "elements");
        return objArr.length > 0 ? f.a(objArr) : d();
    }

    public static final List h(Object... objArr) {
        t9.i.g(objArr, "elements");
        return objArr.length == 0 ? new ArrayList() : new ArrayList(new c(objArr, true));
    }

    public static final List i(List list) {
        t9.i.g(list, "<this>");
        int size = list.size();
        return size != 0 ? size != 1 ? list : i.b(list.get(0)) : d();
    }

    public static final void j() {
        throw new ArithmeticException("Index overflow has happened.");
    }
}
