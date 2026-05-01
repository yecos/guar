package aa;

import java.util.Iterator;
import s9.l;
import t9.i;

/* loaded from: classes3.dex */
public final class h implements b {

    /* renamed from: a, reason: collision with root package name */
    public final b f484a;

    /* renamed from: b, reason: collision with root package name */
    public final l f485b;

    public static final class a implements Iterator, u9.a {

        /* renamed from: a, reason: collision with root package name */
        public final Iterator f486a;

        public a() {
            this.f486a = h.this.f484a.iterator();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f486a.hasNext();
        }

        @Override // java.util.Iterator
        public Object next() {
            return h.this.f485b.invoke(this.f486a.next());
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    public h(b bVar, l lVar) {
        i.g(bVar, "sequence");
        i.g(lVar, "transformer");
        this.f484a = bVar;
        this.f485b = lVar;
    }

    @Override // aa.b
    public Iterator iterator() {
        return new a();
    }
}
