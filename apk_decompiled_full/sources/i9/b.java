package i9;

import anet.channel.strategy.dispatch.DispatchConstants;
import com.umeng.analytics.pro.bt;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.RandomAccess;

/* loaded from: classes3.dex */
public abstract class b extends i9.a implements List {

    /* renamed from: a, reason: collision with root package name */
    public static final a f14389a = new a(null);

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(t9.g gVar) {
            this();
        }

        public final void a(int i10, int i11) {
            if (i10 < 0 || i10 >= i11) {
                throw new IndexOutOfBoundsException("index: " + i10 + ", size: " + i11);
            }
        }

        public final void b(int i10, int i11) {
            if (i10 < 0 || i10 > i11) {
                throw new IndexOutOfBoundsException("index: " + i10 + ", size: " + i11);
            }
        }

        public final void c(int i10, int i11, int i12) {
            if (i10 < 0 || i11 > i12) {
                throw new IndexOutOfBoundsException("fromIndex: " + i10 + ", toIndex: " + i11 + ", size: " + i12);
            }
            if (i10 <= i11) {
                return;
            }
            throw new IllegalArgumentException("fromIndex: " + i10 + " > toIndex: " + i11);
        }

        public final boolean d(Collection collection, Collection collection2) {
            t9.i.g(collection, bt.aL);
            t9.i.g(collection2, DispatchConstants.OTHER);
            if (collection.size() != collection2.size()) {
                return false;
            }
            Iterator it = collection2.iterator();
            Iterator it2 = collection.iterator();
            while (it2.hasNext()) {
                if (!t9.i.b(it2.next(), it.next())) {
                    return false;
                }
            }
            return true;
        }

        public final int e(Collection collection) {
            t9.i.g(collection, bt.aL);
            Iterator it = collection.iterator();
            int i10 = 1;
            while (it.hasNext()) {
                Object next = it.next();
                i10 = (i10 * 31) + (next != null ? next.hashCode() : 0);
            }
            return i10;
        }
    }

    /* renamed from: i9.b$b, reason: collision with other inner class name */
    public class C0234b implements Iterator, u9.a {

        /* renamed from: a, reason: collision with root package name */
        public int f14390a;

        public C0234b() {
        }

        public final int a() {
            return this.f14390a;
        }

        public final void b(int i10) {
            this.f14390a = i10;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f14390a < b.this.size();
        }

        @Override // java.util.Iterator
        public Object next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            b bVar = b.this;
            int i10 = this.f14390a;
            this.f14390a = i10 + 1;
            return bVar.get(i10);
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    public class c extends C0234b implements ListIterator {
        public c(int i10) {
            super();
            b.f14389a.b(i10, b.this.size());
            b(i10);
        }

        @Override // java.util.ListIterator
        public void add(Object obj) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.ListIterator
        public boolean hasPrevious() {
            return a() > 0;
        }

        @Override // java.util.ListIterator
        public int nextIndex() {
            return a();
        }

        @Override // java.util.ListIterator
        public Object previous() {
            if (!hasPrevious()) {
                throw new NoSuchElementException();
            }
            b bVar = b.this;
            b(a() - 1);
            return bVar.get(a());
        }

        @Override // java.util.ListIterator
        public int previousIndex() {
            return a() - 1;
        }

        @Override // java.util.ListIterator
        public void set(Object obj) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    public static final class d extends b implements RandomAccess {

        /* renamed from: b, reason: collision with root package name */
        public final b f14393b;

        /* renamed from: c, reason: collision with root package name */
        public final int f14394c;

        /* renamed from: d, reason: collision with root package name */
        public int f14395d;

        public d(b bVar, int i10, int i11) {
            t9.i.g(bVar, "list");
            this.f14393b = bVar;
            this.f14394c = i10;
            b.f14389a.c(i10, i11, bVar.size());
            this.f14395d = i11 - i10;
        }

        @Override // i9.a
        public int a() {
            return this.f14395d;
        }

        @Override // i9.b, java.util.List
        public Object get(int i10) {
            b.f14389a.a(i10, this.f14395d);
            return this.f14393b.get(this.f14394c + i10);
        }
    }

    @Override // java.util.List
    public void add(int i10, Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public boolean addAll(int i10, Collection collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection, java.util.List
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof List) {
            return f14389a.d(this, (Collection) obj);
        }
        return false;
    }

    public abstract Object get(int i10);

    @Override // java.util.Collection, java.util.List
    public int hashCode() {
        return f14389a.e(this);
    }

    public int indexOf(Object obj) {
        Iterator it = iterator();
        int i10 = 0;
        while (it.hasNext()) {
            if (t9.i.b(it.next(), obj)) {
                return i10;
            }
            i10++;
        }
        return -1;
    }

    @Override // java.util.Collection, java.lang.Iterable, java.util.List
    public Iterator iterator() {
        return new C0234b();
    }

    public int lastIndexOf(Object obj) {
        ListIterator listIterator = listIterator(size());
        while (listIterator.hasPrevious()) {
            if (t9.i.b(listIterator.previous(), obj)) {
                return listIterator.nextIndex();
            }
        }
        return -1;
    }

    @Override // java.util.List
    public ListIterator listIterator() {
        return new c(0);
    }

    @Override // java.util.List
    public Object remove(int i10) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public Object set(int i10, Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public List subList(int i10, int i11) {
        return new d(this, i10, i11);
    }

    @Override // java.util.List
    public ListIterator listIterator(int i10) {
        return new c(i10);
    }
}
