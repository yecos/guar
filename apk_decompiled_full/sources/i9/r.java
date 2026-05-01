package i9;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

/* loaded from: classes3.dex */
public abstract class r extends q {

    public static final class a implements aa.b {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Iterable f14398a;

        public a(Iterable iterable) {
            this.f14398a = iterable;
        }

        @Override // aa.b
        public Iterator iterator() {
            return this.f14398a.iterator();
        }
    }

    public static final class b extends t9.j implements s9.l {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f14399a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(int i10) {
            super(1);
            this.f14399a = i10;
        }

        public final Object b(int i10) {
            throw new IndexOutOfBoundsException("Collection doesn't contain element at index " + this.f14399a + '.');
        }

        @Override // s9.l
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            return b(((Number) obj).intValue());
        }
    }

    public static final Object A(Iterable iterable) {
        t9.i.g(iterable, "<this>");
        if (iterable instanceof List) {
            return B((List) iterable);
        }
        Iterator it = iterable.iterator();
        if (!it.hasNext()) {
            throw new NoSuchElementException("Collection is empty.");
        }
        Object next = it.next();
        if (it.hasNext()) {
            throw new IllegalArgumentException("Collection has more than one element.");
        }
        return next;
    }

    public static final Object B(List list) {
        t9.i.g(list, "<this>");
        int size = list.size();
        if (size == 0) {
            throw new NoSuchElementException("List is empty.");
        }
        if (size == 1) {
            return list.get(0);
        }
        throw new IllegalArgumentException("List has more than one element.");
    }

    public static final List C(Iterable iterable, Comparator comparator) {
        t9.i.g(iterable, "<this>");
        t9.i.g(comparator, "comparator");
        if (!(iterable instanceof Collection)) {
            List H = H(iterable);
            n.m(H, comparator);
            return H;
        }
        Collection collection = (Collection) iterable;
        if (collection.size() <= 1) {
            return G(iterable);
        }
        Object[] array = collection.toArray(new Object[0]);
        f.d(array, comparator);
        return f.a(array);
    }

    public static final List D(Iterable iterable, int i10) {
        t9.i.g(iterable, "<this>");
        int i11 = 0;
        if (!(i10 >= 0)) {
            throw new IllegalArgumentException(("Requested element count " + i10 + " is less than zero.").toString());
        }
        if (i10 == 0) {
            return j.d();
        }
        if (iterable instanceof Collection) {
            if (i10 >= ((Collection) iterable).size()) {
                return G(iterable);
            }
            if (i10 == 1) {
                return i.b(s(iterable));
            }
        }
        ArrayList arrayList = new ArrayList(i10);
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next());
            i11++;
            if (i11 == i10) {
                break;
            }
        }
        return j.i(arrayList);
    }

    public static final Collection E(Iterable iterable, Collection collection) {
        t9.i.g(iterable, "<this>");
        t9.i.g(collection, FirebaseAnalytics.Param.DESTINATION);
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            collection.add(it.next());
        }
        return collection;
    }

    public static final int[] F(Collection collection) {
        t9.i.g(collection, "<this>");
        int[] iArr = new int[collection.size()];
        Iterator it = collection.iterator();
        int i10 = 0;
        while (it.hasNext()) {
            iArr[i10] = ((Number) it.next()).intValue();
            i10++;
        }
        return iArr;
    }

    public static final List G(Iterable iterable) {
        t9.i.g(iterable, "<this>");
        if (!(iterable instanceof Collection)) {
            return j.i(H(iterable));
        }
        Collection collection = (Collection) iterable;
        int size = collection.size();
        if (size == 0) {
            return j.d();
        }
        if (size != 1) {
            return I(collection);
        }
        return i.b(iterable instanceof List ? ((List) iterable).get(0) : iterable.iterator().next());
    }

    public static final List H(Iterable iterable) {
        t9.i.g(iterable, "<this>");
        return iterable instanceof Collection ? I((Collection) iterable) : (List) E(iterable, new ArrayList());
    }

    public static final List I(Collection collection) {
        t9.i.g(collection, "<this>");
        return new ArrayList(collection);
    }

    public static final Set J(Iterable iterable) {
        t9.i.g(iterable, "<this>");
        if (!(iterable instanceof Collection)) {
            return b0.c((Set) E(iterable, new LinkedHashSet()));
        }
        Collection collection = (Collection) iterable;
        int size = collection.size();
        if (size == 0) {
            return b0.b();
        }
        if (size != 1) {
            return (Set) E(iterable, new LinkedHashSet(y.a(collection.size())));
        }
        return a0.a(iterable instanceof List ? ((List) iterable).get(0) : iterable.iterator().next());
    }

    public static final aa.b o(Iterable iterable) {
        t9.i.g(iterable, "<this>");
        return new a(iterable);
    }

    public static final boolean p(Iterable iterable, Object obj) {
        t9.i.g(iterable, "<this>");
        return iterable instanceof Collection ? ((Collection) iterable).contains(obj) : v(iterable, obj) >= 0;
    }

    public static final Object q(Iterable iterable, int i10) {
        t9.i.g(iterable, "<this>");
        return iterable instanceof List ? ((List) iterable).get(i10) : r(iterable, i10, new b(i10));
    }

    public static final Object r(Iterable iterable, int i10, s9.l lVar) {
        t9.i.g(iterable, "<this>");
        t9.i.g(lVar, "defaultValue");
        if (iterable instanceof List) {
            List list = (List) iterable;
            return (i10 < 0 || i10 > j.f(list)) ? lVar.invoke(Integer.valueOf(i10)) : list.get(i10);
        }
        if (i10 < 0) {
            return lVar.invoke(Integer.valueOf(i10));
        }
        int i11 = 0;
        for (Object obj : iterable) {
            int i12 = i11 + 1;
            if (i10 == i11) {
                return obj;
            }
            i11 = i12;
        }
        return lVar.invoke(Integer.valueOf(i10));
    }

    public static final Object s(Iterable iterable) {
        t9.i.g(iterable, "<this>");
        if (iterable instanceof List) {
            return t((List) iterable);
        }
        Iterator it = iterable.iterator();
        if (it.hasNext()) {
            return it.next();
        }
        throw new NoSuchElementException("Collection is empty.");
    }

    public static final Object t(List list) {
        t9.i.g(list, "<this>");
        if (list.isEmpty()) {
            throw new NoSuchElementException("List is empty.");
        }
        return list.get(0);
    }

    public static final Object u(List list, int i10) {
        t9.i.g(list, "<this>");
        if (i10 < 0 || i10 > j.f(list)) {
            return null;
        }
        return list.get(i10);
    }

    public static final int v(Iterable iterable, Object obj) {
        t9.i.g(iterable, "<this>");
        if (iterable instanceof List) {
            return ((List) iterable).indexOf(obj);
        }
        int i10 = 0;
        for (Object obj2 : iterable) {
            if (i10 < 0) {
                j.j();
            }
            if (t9.i.b(obj, obj2)) {
                return i10;
            }
            i10++;
        }
        return -1;
    }

    public static final Appendable w(Iterable iterable, Appendable appendable, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i10, CharSequence charSequence4, s9.l lVar) {
        t9.i.g(iterable, "<this>");
        t9.i.g(appendable, "buffer");
        t9.i.g(charSequence, "separator");
        t9.i.g(charSequence2, "prefix");
        t9.i.g(charSequence3, "postfix");
        t9.i.g(charSequence4, "truncated");
        appendable.append(charSequence2);
        int i11 = 0;
        for (Object obj : iterable) {
            i11++;
            if (i11 > 1) {
                appendable.append(charSequence);
            }
            if (i10 >= 0 && i11 > i10) {
                break;
            }
            ba.k.a(appendable, obj, lVar);
        }
        if (i10 >= 0 && i11 > i10) {
            appendable.append(charSequence4);
        }
        appendable.append(charSequence3);
        return appendable;
    }

    public static final String x(Iterable iterable, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i10, CharSequence charSequence4, s9.l lVar) {
        t9.i.g(iterable, "<this>");
        t9.i.g(charSequence, "separator");
        t9.i.g(charSequence2, "prefix");
        t9.i.g(charSequence3, "postfix");
        t9.i.g(charSequence4, "truncated");
        String sb = ((StringBuilder) w(iterable, new StringBuilder(), charSequence, charSequence2, charSequence3, i10, charSequence4, lVar)).toString();
        t9.i.f(sb, "joinTo(StringBuilder(), …ed, transform).toString()");
        return sb;
    }

    public static /* synthetic */ String y(Iterable iterable, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i10, CharSequence charSequence4, s9.l lVar, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            charSequence = ", ";
        }
        CharSequence charSequence5 = (i11 & 2) != 0 ? "" : charSequence2;
        CharSequence charSequence6 = (i11 & 4) == 0 ? charSequence3 : "";
        int i12 = (i11 & 8) != 0 ? -1 : i10;
        if ((i11 & 16) != 0) {
            charSequence4 = "...";
        }
        CharSequence charSequence7 = charSequence4;
        if ((i11 & 32) != 0) {
            lVar = null;
        }
        return x(iterable, charSequence, charSequence5, charSequence6, i12, charSequence7, lVar);
    }

    public static final Object z(Collection collection, w9.c cVar) {
        t9.i.g(collection, "<this>");
        t9.i.g(cVar, "random");
        if (collection.isEmpty()) {
            throw new NoSuchElementException("Collection is empty.");
        }
        return q(collection, cVar.c(collection.size()));
    }
}
