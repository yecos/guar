package i;

import com.raizlabs.android.dbflow.sql.language.Operator;
import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public class b implements Iterable {

    /* renamed from: a, reason: collision with root package name */
    public c f14248a;

    /* renamed from: b, reason: collision with root package name */
    public c f14249b;

    /* renamed from: c, reason: collision with root package name */
    public WeakHashMap f14250c = new WeakHashMap();

    /* renamed from: d, reason: collision with root package name */
    public int f14251d = 0;

    public static class a extends e {
        public a(c cVar, c cVar2) {
            super(cVar, cVar2);
        }

        @Override // i.b.e
        public c b(c cVar) {
            return cVar.f14255d;
        }

        @Override // i.b.e
        public c c(c cVar) {
            return cVar.f14254c;
        }
    }

    /* renamed from: i.b$b, reason: collision with other inner class name */
    public static class C0227b extends e {
        public C0227b(c cVar, c cVar2) {
            super(cVar, cVar2);
        }

        @Override // i.b.e
        public c b(c cVar) {
            return cVar.f14254c;
        }

        @Override // i.b.e
        public c c(c cVar) {
            return cVar.f14255d;
        }
    }

    public static class c implements Map.Entry {

        /* renamed from: a, reason: collision with root package name */
        public final Object f14252a;

        /* renamed from: b, reason: collision with root package name */
        public final Object f14253b;

        /* renamed from: c, reason: collision with root package name */
        public c f14254c;

        /* renamed from: d, reason: collision with root package name */
        public c f14255d;

        public c(Object obj, Object obj2) {
            this.f14252a = obj;
            this.f14253b = obj2;
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof c)) {
                return false;
            }
            c cVar = (c) obj;
            return this.f14252a.equals(cVar.f14252a) && this.f14253b.equals(cVar.f14253b);
        }

        @Override // java.util.Map.Entry
        public Object getKey() {
            return this.f14252a;
        }

        @Override // java.util.Map.Entry
        public Object getValue() {
            return this.f14253b;
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            return this.f14252a.hashCode() ^ this.f14253b.hashCode();
        }

        @Override // java.util.Map.Entry
        public Object setValue(Object obj) {
            throw new UnsupportedOperationException("An entry modification is not supported");
        }

        public String toString() {
            return this.f14252a + Operator.Operation.EQUALS + this.f14253b;
        }
    }

    public class d implements Iterator, f {

        /* renamed from: a, reason: collision with root package name */
        public c f14256a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f14257b = true;

        public d() {
        }

        @Override // i.b.f
        public void a(c cVar) {
            c cVar2 = this.f14256a;
            if (cVar == cVar2) {
                c cVar3 = cVar2.f14255d;
                this.f14256a = cVar3;
                this.f14257b = cVar3 == null;
            }
        }

        @Override // java.util.Iterator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public Map.Entry next() {
            if (this.f14257b) {
                this.f14257b = false;
                this.f14256a = b.this.f14248a;
            } else {
                c cVar = this.f14256a;
                this.f14256a = cVar != null ? cVar.f14254c : null;
            }
            return this.f14256a;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.f14257b) {
                return b.this.f14248a != null;
            }
            c cVar = this.f14256a;
            return (cVar == null || cVar.f14254c == null) ? false : true;
        }
    }

    public static abstract class e implements Iterator, f {

        /* renamed from: a, reason: collision with root package name */
        public c f14259a;

        /* renamed from: b, reason: collision with root package name */
        public c f14260b;

        public e(c cVar, c cVar2) {
            this.f14259a = cVar2;
            this.f14260b = cVar;
        }

        @Override // i.b.f
        public void a(c cVar) {
            if (this.f14259a == cVar && cVar == this.f14260b) {
                this.f14260b = null;
                this.f14259a = null;
            }
            c cVar2 = this.f14259a;
            if (cVar2 == cVar) {
                this.f14259a = b(cVar2);
            }
            if (this.f14260b == cVar) {
                this.f14260b = e();
            }
        }

        public abstract c b(c cVar);

        public abstract c c(c cVar);

        @Override // java.util.Iterator
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public Map.Entry next() {
            c cVar = this.f14260b;
            this.f14260b = e();
            return cVar;
        }

        public final c e() {
            c cVar = this.f14260b;
            c cVar2 = this.f14259a;
            if (cVar == cVar2 || cVar2 == null) {
                return null;
            }
            return c(cVar);
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f14260b != null;
        }
    }

    public interface f {
        void a(c cVar);
    }

    public Map.Entry a() {
        return this.f14248a;
    }

    public c b(Object obj) {
        c cVar = this.f14248a;
        while (cVar != null && !cVar.f14252a.equals(obj)) {
            cVar = cVar.f14254c;
        }
        return cVar;
    }

    public d c() {
        d dVar = new d();
        this.f14250c.put(dVar, Boolean.FALSE);
        return dVar;
    }

    public Map.Entry d() {
        return this.f14249b;
    }

    public Iterator descendingIterator() {
        C0227b c0227b = new C0227b(this.f14249b, this.f14248a);
        this.f14250c.put(c0227b, Boolean.FALSE);
        return c0227b;
    }

    public c e(Object obj, Object obj2) {
        c cVar = new c(obj, obj2);
        this.f14251d++;
        c cVar2 = this.f14249b;
        if (cVar2 == null) {
            this.f14248a = cVar;
            this.f14249b = cVar;
            return cVar;
        }
        cVar2.f14254c = cVar;
        cVar.f14255d = cVar2;
        this.f14249b = cVar;
        return cVar;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        if (size() != bVar.size()) {
            return false;
        }
        Iterator it = iterator();
        Iterator it2 = bVar.iterator();
        while (it.hasNext() && it2.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            Object next = it2.next();
            if ((entry == null && next != null) || (entry != null && !entry.equals(next))) {
                return false;
            }
        }
        return (it.hasNext() || it2.hasNext()) ? false : true;
    }

    public Object f(Object obj, Object obj2) {
        c b10 = b(obj);
        if (b10 != null) {
            return b10.f14253b;
        }
        e(obj, obj2);
        return null;
    }

    public Object g(Object obj) {
        c b10 = b(obj);
        if (b10 == null) {
            return null;
        }
        this.f14251d--;
        if (!this.f14250c.isEmpty()) {
            Iterator it = this.f14250c.keySet().iterator();
            while (it.hasNext()) {
                ((f) it.next()).a(b10);
            }
        }
        c cVar = b10.f14255d;
        if (cVar != null) {
            cVar.f14254c = b10.f14254c;
        } else {
            this.f14248a = b10.f14254c;
        }
        c cVar2 = b10.f14254c;
        if (cVar2 != null) {
            cVar2.f14255d = cVar;
        } else {
            this.f14249b = cVar;
        }
        b10.f14254c = null;
        b10.f14255d = null;
        return b10.f14253b;
    }

    public int hashCode() {
        Iterator it = iterator();
        int i10 = 0;
        while (it.hasNext()) {
            i10 += ((Map.Entry) it.next()).hashCode();
        }
        return i10;
    }

    @Override // java.lang.Iterable
    public Iterator iterator() {
        a aVar = new a(this.f14248a, this.f14249b);
        this.f14250c.put(aVar, Boolean.FALSE);
        return aVar;
    }

    public int size() {
        return this.f14251d;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Iterator it = iterator();
        while (it.hasNext()) {
            sb.append(((Map.Entry) it.next()).toString());
            if (it.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
