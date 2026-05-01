package t9;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* loaded from: classes3.dex */
public final class a implements Iterator, u9.a {

    /* renamed from: a, reason: collision with root package name */
    public final Object[] f18938a;

    /* renamed from: b, reason: collision with root package name */
    public int f18939b;

    public a(Object[] objArr) {
        i.g(objArr, "array");
        this.f18938a = objArr;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f18939b < this.f18938a.length;
    }

    @Override // java.util.Iterator
    public Object next() {
        try {
            Object[] objArr = this.f18938a;
            int i10 = this.f18939b;
            this.f18939b = i10 + 1;
            return objArr[i10];
        } catch (ArrayIndexOutOfBoundsException e10) {
            this.f18939b--;
            throw new NoSuchElementException(e10.getMessage());
        }
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
