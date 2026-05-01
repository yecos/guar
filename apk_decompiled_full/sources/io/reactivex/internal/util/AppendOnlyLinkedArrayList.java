package io.reactivex.internal.util;

import fb.c;
import io.reactivex.Observer;
import io.reactivex.functions.BiPredicate;
import io.reactivex.functions.Predicate;

/* loaded from: classes3.dex */
public class AppendOnlyLinkedArrayList<T> {
    final int capacity;
    final Object[] head;
    int offset;
    Object[] tail;

    public interface NonThrowingPredicate<T> extends Predicate<T> {
        @Override // io.reactivex.functions.Predicate
        boolean test(T t10);
    }

    public AppendOnlyLinkedArrayList(int i10) {
        this.capacity = i10;
        Object[] objArr = new Object[i10 + 1];
        this.head = objArr;
        this.tail = objArr;
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0019, code lost:
    
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public <U> boolean accept(c cVar) {
        Object[] objArr = this.head;
        int i10 = this.capacity;
        while (true) {
            if (objArr == null) {
                return false;
            }
            for (int i11 = 0; i11 < i10; i11++) {
                Object[] objArr2 = objArr[i11];
                if (objArr2 == null) {
                    break;
                }
                if (NotificationLite.acceptFull(objArr2, cVar)) {
                    return true;
                }
            }
            objArr = objArr[i10];
        }
    }

    public void add(T t10) {
        int i10 = this.capacity;
        int i11 = this.offset;
        if (i11 == i10) {
            Object[] objArr = new Object[i10 + 1];
            this.tail[i10] = objArr;
            this.tail = objArr;
            i11 = 0;
        }
        this.tail[i11] = t10;
        this.offset = i11 + 1;
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0018, code lost:
    
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void forEachWhile(NonThrowingPredicate<? super T> nonThrowingPredicate) {
        int i10 = this.capacity;
        for (Object[] objArr = this.head; objArr != null; objArr = (Object[]) objArr[i10]) {
            for (int i11 = 0; i11 < i10; i11++) {
                Object obj = objArr[i11];
                if (obj == null) {
                    break;
                } else {
                    if (nonThrowingPredicate.test(obj)) {
                        return;
                    }
                }
            }
        }
    }

    public void setFirst(T t10) {
        this.head[0] = t10;
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0019, code lost:
    
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public <U> boolean accept(Observer<? super U> observer) {
        Object[] objArr = this.head;
        int i10 = this.capacity;
        while (true) {
            if (objArr == null) {
                return false;
            }
            for (int i11 = 0; i11 < i10; i11++) {
                Object[] objArr2 = objArr[i11];
                if (objArr2 == null) {
                    break;
                }
                if (NotificationLite.acceptFull(objArr2, observer)) {
                    return true;
                }
            }
            objArr = objArr[i10];
        }
    }

    public <S> void forEachWhile(S s10, BiPredicate<? super S, ? super T> biPredicate) {
        Object[] objArr = this.head;
        int i10 = this.capacity;
        while (true) {
            for (int i11 = 0; i11 < i10; i11++) {
                Object obj = objArr[i11];
                if (obj == null || biPredicate.test(s10, obj)) {
                    return;
                }
            }
            objArr = (Object[]) objArr[i10];
        }
    }
}
