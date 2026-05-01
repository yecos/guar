package i9;

import java.util.Collection;
import java.util.Iterator;

/* loaded from: classes3.dex */
public final class c implements Collection, u9.a {

    /* renamed from: a, reason: collision with root package name */
    public final Object[] f14396a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f14397b;

    public c(Object[] objArr, boolean z10) {
        t9.i.g(objArr, "values");
        this.f14396a = objArr;
        this.f14397b = z10;
    }

    public int a() {
        return this.f14396a.length;
    }

    @Override // java.util.Collection
    public boolean add(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean addAll(Collection collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean contains(Object obj) {
        return g.e(this.f14396a, obj);
    }

    @Override // java.util.Collection
    public boolean containsAll(Collection collection) {
        t9.i.g(collection, "elements");
        if (collection.isEmpty()) {
            return true;
        }
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            if (!contains(it.next())) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.Collection
    public boolean isEmpty() {
        return this.f14396a.length == 0;
    }

    @Override // java.util.Collection, java.lang.Iterable
    public Iterator iterator() {
        return t9.b.a(this.f14396a);
    }

    @Override // java.util.Collection
    public boolean remove(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean removeAll(Collection collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean retainAll(Collection collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public final /* bridge */ int size() {
        return a();
    }

    @Override // java.util.Collection
    public Object[] toArray(Object[] objArr) {
        t9.i.g(objArr, "array");
        return t9.f.b(this, objArr);
    }

    @Override // java.util.Collection
    public final Object[] toArray() {
        return i.a(this.f14396a, this.f14397b);
    }
}
