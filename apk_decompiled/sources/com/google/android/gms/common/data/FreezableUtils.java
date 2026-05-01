package com.google.android.gms.common.data;

import java.util.ArrayList;
import java.util.Iterator;
import org.simpleframework.xml.core.TreeModel;

/* loaded from: classes.dex */
public final class FreezableUtils {
    public static <T, E extends Freezable<T>> ArrayList<T> freeze(ArrayList<E> arrayList) {
        TreeModel.OrderList orderList = (ArrayList<T>) new ArrayList(arrayList.size());
        int size = arrayList.size();
        for (int i10 = 0; i10 < size; i10++) {
            orderList.add(arrayList.get(i10).freeze());
        }
        return orderList;
    }

    public static <T, E extends Freezable<T>> ArrayList<T> freezeIterable(Iterable<E> iterable) {
        TreeModel.OrderList orderList = (ArrayList<T>) new ArrayList();
        Iterator<E> it = iterable.iterator();
        while (it.hasNext()) {
            orderList.add(it.next().freeze());
        }
        return orderList;
    }

    public static <T, E extends Freezable<T>> ArrayList<T> freeze(E[] eArr) {
        TreeModel.OrderList orderList = (ArrayList<T>) new ArrayList(eArr.length);
        for (E e10 : eArr) {
            orderList.add(e10.freeze());
        }
        return orderList;
    }
}
