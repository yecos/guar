package androidx.collection;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* loaded from: classes.dex */
public final class b implements Collection, Set {

    /* renamed from: e, reason: collision with root package name */
    public static final int[] f1793e = new int[0];

    /* renamed from: f, reason: collision with root package name */
    public static final Object[] f1794f = new Object[0];

    /* renamed from: g, reason: collision with root package name */
    public static Object[] f1795g;

    /* renamed from: h, reason: collision with root package name */
    public static int f1796h;

    /* renamed from: i, reason: collision with root package name */
    public static Object[] f1797i;

    /* renamed from: j, reason: collision with root package name */
    public static int f1798j;

    /* renamed from: a, reason: collision with root package name */
    public int[] f1799a;

    /* renamed from: b, reason: collision with root package name */
    public Object[] f1800b;

    /* renamed from: c, reason: collision with root package name */
    public int f1801c;

    /* renamed from: d, reason: collision with root package name */
    public f f1802d;

    public class a extends f {
        public a() {
        }

        @Override // androidx.collection.f
        public void a() {
            b.this.clear();
        }

        @Override // androidx.collection.f
        public Object b(int i10, int i11) {
            return b.this.f1800b[i10];
        }

        @Override // androidx.collection.f
        public Map c() {
            throw new UnsupportedOperationException("not a map");
        }

        @Override // androidx.collection.f
        public int d() {
            return b.this.f1801c;
        }

        @Override // androidx.collection.f
        public int e(Object obj) {
            return b.this.indexOf(obj);
        }

        @Override // androidx.collection.f
        public int f(Object obj) {
            return b.this.indexOf(obj);
        }

        @Override // androidx.collection.f
        public void g(Object obj, Object obj2) {
            b.this.add(obj);
        }

        @Override // androidx.collection.f
        public void h(int i10) {
            b.this.g(i10);
        }

        @Override // androidx.collection.f
        public Object i(int i10, Object obj) {
            throw new UnsupportedOperationException("not a map");
        }
    }

    public b() {
        this(0);
    }

    public static void c(int[] iArr, Object[] objArr, int i10) {
        if (iArr.length == 8) {
            synchronized (b.class) {
                if (f1798j < 10) {
                    objArr[0] = f1797i;
                    objArr[1] = iArr;
                    for (int i11 = i10 - 1; i11 >= 2; i11--) {
                        objArr[i11] = null;
                    }
                    f1797i = objArr;
                    f1798j++;
                }
            }
            return;
        }
        if (iArr.length == 4) {
            synchronized (b.class) {
                if (f1796h < 10) {
                    objArr[0] = f1795g;
                    objArr[1] = iArr;
                    for (int i12 = i10 - 1; i12 >= 2; i12--) {
                        objArr[i12] = null;
                    }
                    f1795g = objArr;
                    f1796h++;
                }
            }
        }
    }

    public final void a(int i10) {
        if (i10 == 8) {
            synchronized (b.class) {
                Object[] objArr = f1797i;
                if (objArr != null) {
                    this.f1800b = objArr;
                    f1797i = (Object[]) objArr[0];
                    this.f1799a = (int[]) objArr[1];
                    objArr[1] = null;
                    objArr[0] = null;
                    f1798j--;
                    return;
                }
            }
        } else if (i10 == 4) {
            synchronized (b.class) {
                Object[] objArr2 = f1795g;
                if (objArr2 != null) {
                    this.f1800b = objArr2;
                    f1795g = (Object[]) objArr2[0];
                    this.f1799a = (int[]) objArr2[1];
                    objArr2[1] = null;
                    objArr2[0] = null;
                    f1796h--;
                    return;
                }
            }
        }
        this.f1799a = new int[i10];
        this.f1800b = new Object[i10];
    }

    @Override // java.util.Collection, java.util.Set
    public boolean add(Object obj) {
        int i10;
        int e10;
        if (obj == null) {
            e10 = f();
            i10 = 0;
        } else {
            int hashCode = obj.hashCode();
            i10 = hashCode;
            e10 = e(obj, hashCode);
        }
        if (e10 >= 0) {
            return false;
        }
        int i11 = e10 ^ (-1);
        int i12 = this.f1801c;
        int[] iArr = this.f1799a;
        if (i12 >= iArr.length) {
            int i13 = 8;
            if (i12 >= 8) {
                i13 = (i12 >> 1) + i12;
            } else if (i12 < 4) {
                i13 = 4;
            }
            Object[] objArr = this.f1800b;
            a(i13);
            int[] iArr2 = this.f1799a;
            if (iArr2.length > 0) {
                System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
                System.arraycopy(objArr, 0, this.f1800b, 0, objArr.length);
            }
            c(iArr, objArr, this.f1801c);
        }
        int i14 = this.f1801c;
        if (i11 < i14) {
            int[] iArr3 = this.f1799a;
            int i15 = i11 + 1;
            System.arraycopy(iArr3, i11, iArr3, i15, i14 - i11);
            Object[] objArr2 = this.f1800b;
            System.arraycopy(objArr2, i11, objArr2, i15, this.f1801c - i11);
        }
        this.f1799a[i11] = i10;
        this.f1800b[i11] = obj;
        this.f1801c++;
        return true;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean addAll(Collection collection) {
        b(this.f1801c + collection.size());
        Iterator it = collection.iterator();
        boolean z10 = false;
        while (it.hasNext()) {
            z10 |= add(it.next());
        }
        return z10;
    }

    public void b(int i10) {
        int[] iArr = this.f1799a;
        if (iArr.length < i10) {
            Object[] objArr = this.f1800b;
            a(i10);
            int i11 = this.f1801c;
            if (i11 > 0) {
                System.arraycopy(iArr, 0, this.f1799a, 0, i11);
                System.arraycopy(objArr, 0, this.f1800b, 0, this.f1801c);
            }
            c(iArr, objArr, this.f1801c);
        }
    }

    @Override // java.util.Collection, java.util.Set
    public void clear() {
        int i10 = this.f1801c;
        if (i10 != 0) {
            c(this.f1799a, this.f1800b, i10);
            this.f1799a = f1793e;
            this.f1800b = f1794f;
            this.f1801c = 0;
        }
    }

    @Override // java.util.Collection, java.util.Set
    public boolean contains(Object obj) {
        return indexOf(obj) >= 0;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean containsAll(Collection collection) {
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            if (!contains(it.next())) {
                return false;
            }
        }
        return true;
    }

    public final f d() {
        if (this.f1802d == null) {
            this.f1802d = new a();
        }
        return this.f1802d;
    }

    public final int e(Object obj, int i10) {
        int i11 = this.f1801c;
        if (i11 == 0) {
            return -1;
        }
        int a10 = c.a(this.f1799a, i11, i10);
        if (a10 < 0) {
            return a10;
        }
        if (obj.equals(this.f1800b[a10])) {
            return a10;
        }
        int i12 = a10 + 1;
        while (i12 < i11 && this.f1799a[i12] == i10) {
            if (obj.equals(this.f1800b[i12])) {
                return i12;
            }
            i12++;
        }
        for (int i13 = a10 - 1; i13 >= 0 && this.f1799a[i13] == i10; i13--) {
            if (obj.equals(this.f1800b[i13])) {
                return i13;
            }
        }
        return i12 ^ (-1);
    }

    @Override // java.util.Collection, java.util.Set
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Set) {
            Set set = (Set) obj;
            if (size() != set.size()) {
                return false;
            }
            for (int i10 = 0; i10 < this.f1801c; i10++) {
                try {
                    if (!set.contains(h(i10))) {
                        return false;
                    }
                } catch (ClassCastException | NullPointerException unused) {
                }
            }
            return true;
        }
        return false;
    }

    public final int f() {
        int i10 = this.f1801c;
        if (i10 == 0) {
            return -1;
        }
        int a10 = c.a(this.f1799a, i10, 0);
        if (a10 < 0) {
            return a10;
        }
        if (this.f1800b[a10] == null) {
            return a10;
        }
        int i11 = a10 + 1;
        while (i11 < i10 && this.f1799a[i11] == 0) {
            if (this.f1800b[i11] == null) {
                return i11;
            }
            i11++;
        }
        for (int i12 = a10 - 1; i12 >= 0 && this.f1799a[i12] == 0; i12--) {
            if (this.f1800b[i12] == null) {
                return i12;
            }
        }
        return i11 ^ (-1);
    }

    public Object g(int i10) {
        Object[] objArr = this.f1800b;
        Object obj = objArr[i10];
        int i11 = this.f1801c;
        if (i11 <= 1) {
            c(this.f1799a, objArr, i11);
            this.f1799a = f1793e;
            this.f1800b = f1794f;
            this.f1801c = 0;
        } else {
            int[] iArr = this.f1799a;
            if (iArr.length <= 8 || i11 >= iArr.length / 3) {
                int i12 = i11 - 1;
                this.f1801c = i12;
                if (i10 < i12) {
                    int i13 = i10 + 1;
                    System.arraycopy(iArr, i13, iArr, i10, i12 - i10);
                    Object[] objArr2 = this.f1800b;
                    System.arraycopy(objArr2, i13, objArr2, i10, this.f1801c - i10);
                }
                this.f1800b[this.f1801c] = null;
            } else {
                a(i11 > 8 ? i11 + (i11 >> 1) : 8);
                this.f1801c--;
                if (i10 > 0) {
                    System.arraycopy(iArr, 0, this.f1799a, 0, i10);
                    System.arraycopy(objArr, 0, this.f1800b, 0, i10);
                }
                int i14 = this.f1801c;
                if (i10 < i14) {
                    int i15 = i10 + 1;
                    System.arraycopy(iArr, i15, this.f1799a, i10, i14 - i10);
                    System.arraycopy(objArr, i15, this.f1800b, i10, this.f1801c - i10);
                }
            }
        }
        return obj;
    }

    public Object h(int i10) {
        return this.f1800b[i10];
    }

    @Override // java.util.Collection, java.util.Set
    public int hashCode() {
        int[] iArr = this.f1799a;
        int i10 = this.f1801c;
        int i11 = 0;
        for (int i12 = 0; i12 < i10; i12++) {
            i11 += iArr[i12];
        }
        return i11;
    }

    public int indexOf(Object obj) {
        return obj == null ? f() : e(obj, obj.hashCode());
    }

    @Override // java.util.Collection, java.util.Set
    public boolean isEmpty() {
        return this.f1801c <= 0;
    }

    @Override // java.util.Collection, java.lang.Iterable, java.util.Set
    public Iterator iterator() {
        return d().m().iterator();
    }

    @Override // java.util.Collection, java.util.Set
    public boolean remove(Object obj) {
        int indexOf = indexOf(obj);
        if (indexOf < 0) {
            return false;
        }
        g(indexOf);
        return true;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean removeAll(Collection collection) {
        Iterator it = collection.iterator();
        boolean z10 = false;
        while (it.hasNext()) {
            z10 |= remove(it.next());
        }
        return z10;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean retainAll(Collection collection) {
        boolean z10 = false;
        for (int i10 = this.f1801c - 1; i10 >= 0; i10--) {
            if (!collection.contains(this.f1800b[i10])) {
                g(i10);
                z10 = true;
            }
        }
        return z10;
    }

    @Override // java.util.Collection, java.util.Set
    public int size() {
        return this.f1801c;
    }

    @Override // java.util.Collection, java.util.Set
    public Object[] toArray() {
        int i10 = this.f1801c;
        Object[] objArr = new Object[i10];
        System.arraycopy(this.f1800b, 0, objArr, 0, i10);
        return objArr;
    }

    public String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.f1801c * 14);
        sb.append(ASCIIPropertyListParser.DICTIONARY_BEGIN_TOKEN);
        for (int i10 = 0; i10 < this.f1801c; i10++) {
            if (i10 > 0) {
                sb.append(", ");
            }
            Object h10 = h(i10);
            if (h10 != this) {
                sb.append(h10);
            } else {
                sb.append("(this Set)");
            }
        }
        sb.append(ASCIIPropertyListParser.DICTIONARY_END_TOKEN);
        return sb.toString();
    }

    public b(int i10) {
        if (i10 == 0) {
            this.f1799a = f1793e;
            this.f1800b = f1794f;
        } else {
            a(i10);
        }
        this.f1801c = 0;
    }

    @Override // java.util.Collection, java.util.Set
    public Object[] toArray(Object[] objArr) {
        if (objArr.length < this.f1801c) {
            objArr = (Object[]) Array.newInstance(objArr.getClass().getComponentType(), this.f1801c);
        }
        System.arraycopy(this.f1800b, 0, objArr, 0, this.f1801c);
        int length = objArr.length;
        int i10 = this.f1801c;
        if (length > i10) {
            objArr[i10] = null;
        }
        return objArr;
    }
}
