package o3;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.NoSuchElementException;

/* loaded from: classes.dex */
public class c implements Iterable, Serializable {

    /* renamed from: a, reason: collision with root package name */
    public final boolean f17486a;

    /* renamed from: b, reason: collision with root package name */
    public int f17487b;

    /* renamed from: c, reason: collision with root package name */
    public int f17488c;

    /* renamed from: d, reason: collision with root package name */
    public int f17489d;

    /* renamed from: e, reason: collision with root package name */
    public Object[] f17490e;

    /* renamed from: f, reason: collision with root package name */
    public final n3.t[] f17491f;

    /* renamed from: g, reason: collision with root package name */
    public final Map f17492g;

    /* renamed from: h, reason: collision with root package name */
    public final Map f17493h;

    /* renamed from: i, reason: collision with root package name */
    public final Locale f17494i;

    public c(boolean z10, Collection collection, Map map, Locale locale) {
        this.f17486a = z10;
        this.f17491f = (n3.t[]) collection.toArray(new n3.t[collection.size()]);
        this.f17492g = map;
        this.f17494i = locale;
        this.f17493h = a(map, z10, locale);
        o(collection);
    }

    public static c j(m3.m mVar, Collection collection, Map map, boolean z10) {
        return new c(z10, collection, map, mVar.v());
    }

    public static final int l(int i10) {
        if (i10 <= 5) {
            return 8;
        }
        if (i10 <= 12) {
            return 16;
        }
        int i11 = 32;
        while (i11 < i10 + (i10 >> 2)) {
            i11 += i11;
        }
        return i11;
    }

    public final Map a(Map map, boolean z10, Locale locale) {
        if (map == null || map.isEmpty()) {
            return Collections.emptyMap();
        }
        HashMap hashMap = new HashMap();
        for (Map.Entry entry : map.entrySet()) {
            String str = (String) entry.getKey();
            if (z10) {
                str = str.toLowerCase(locale);
            }
            Iterator it = ((List) entry.getValue()).iterator();
            while (it.hasNext()) {
                String c10 = ((k3.x) it.next()).c();
                if (z10) {
                    c10 = c10.toLowerCase(locale);
                }
                hashMap.put(c10, str);
            }
        }
        return hashMap;
    }

    public final n3.t b(String str, int i10, Object obj) {
        if (obj == null) {
            return e((String) this.f17493h.get(str));
        }
        int i11 = this.f17487b + 1;
        int i12 = ((i10 >> 1) + i11) << 1;
        Object obj2 = this.f17490e[i12];
        if (str.equals(obj2)) {
            return (n3.t) this.f17490e[i12 + 1];
        }
        if (obj2 != null) {
            int i13 = (i11 + (i11 >> 1)) << 1;
            int i14 = this.f17489d + i13;
            while (i13 < i14) {
                Object obj3 = this.f17490e[i13];
                if (obj3 == str || str.equals(obj3)) {
                    return (n3.t) this.f17490e[i13 + 1];
                }
                i13 += 2;
            }
        }
        return e((String) this.f17493h.get(str));
    }

    public final n3.t c(String str, int i10, Object obj) {
        int i11 = this.f17487b + 1;
        int i12 = ((i10 >> 1) + i11) << 1;
        Object obj2 = this.f17490e[i12];
        if (str.equals(obj2)) {
            return (n3.t) this.f17490e[i12 + 1];
        }
        if (obj2 == null) {
            return null;
        }
        int i13 = (i11 + (i11 >> 1)) << 1;
        int i14 = this.f17489d + i13;
        while (i13 < i14) {
            Object obj3 = this.f17490e[i13];
            if (obj3 == str || str.equals(obj3)) {
                return (n3.t) this.f17490e[i13 + 1];
            }
            i13 += 2;
        }
        return null;
    }

    public final int d(n3.t tVar) {
        int length = this.f17491f.length;
        for (int i10 = 0; i10 < length; i10++) {
            if (this.f17491f[i10] == tVar) {
                return i10;
            }
        }
        throw new IllegalStateException("Illegal state: property '" + tVar.getName() + "' missing from _propsInOrder");
    }

    public final n3.t e(String str) {
        if (str == null) {
            return null;
        }
        int f10 = f(str);
        int i10 = f10 << 1;
        Object obj = this.f17490e[i10];
        if (str.equals(obj)) {
            return (n3.t) this.f17490e[i10 + 1];
        }
        if (obj == null) {
            return null;
        }
        return c(str, f10, obj);
    }

    public final int f(String str) {
        return str.hashCode() & this.f17487b;
    }

    public final List g() {
        ArrayList arrayList = new ArrayList(this.f17488c);
        int length = this.f17490e.length;
        for (int i10 = 1; i10 < length; i10 += 2) {
            n3.t tVar = (n3.t) this.f17490e[i10];
            if (tVar != null) {
                arrayList.add(tVar);
            }
        }
        return arrayList;
    }

    public n3.t h(n3.t tVar, d4.q qVar) {
        k3.k unwrappingDeserializer;
        if (tVar == null) {
            return tVar;
        }
        n3.t K = tVar.K(qVar.c(tVar.getName()));
        k3.k u10 = K.u();
        return (u10 == null || (unwrappingDeserializer = u10.unwrappingDeserializer(qVar)) == u10) ? K : K.L(unwrappingDeserializer);
    }

    public c i() {
        int length = this.f17490e.length;
        int i10 = 0;
        for (int i11 = 1; i11 < length; i11 += 2) {
            n3.t tVar = (n3.t) this.f17490e[i11];
            if (tVar != null) {
                tVar.j(i10);
                i10++;
            }
        }
        return this;
    }

    @Override // java.lang.Iterable
    public Iterator iterator() {
        return g().iterator();
    }

    public n3.t k(String str) {
        if (str == null) {
            throw new IllegalArgumentException("Cannot pass null property name");
        }
        if (this.f17486a) {
            str = str.toLowerCase(this.f17494i);
        }
        int hashCode = str.hashCode() & this.f17487b;
        int i10 = hashCode << 1;
        Object obj = this.f17490e[i10];
        return (obj == str || str.equals(obj)) ? (n3.t) this.f17490e[i10 + 1] : b(str, hashCode, obj);
    }

    public n3.t[] m() {
        return this.f17491f;
    }

    public final String n(n3.t tVar) {
        boolean z10 = this.f17486a;
        String name = tVar.getName();
        return z10 ? name.toLowerCase(this.f17494i) : name;
    }

    public void o(Collection collection) {
        int size = collection.size();
        this.f17488c = size;
        int l10 = l(size);
        this.f17487b = l10 - 1;
        int i10 = (l10 >> 1) + l10;
        Object[] objArr = new Object[i10 * 2];
        Iterator it = collection.iterator();
        int i11 = 0;
        while (it.hasNext()) {
            n3.t tVar = (n3.t) it.next();
            if (tVar != null) {
                String n10 = n(tVar);
                int f10 = f(n10);
                int i12 = f10 << 1;
                if (objArr[i12] != null) {
                    i12 = ((f10 >> 1) + l10) << 1;
                    if (objArr[i12] != null) {
                        i12 = (i10 << 1) + i11;
                        i11 += 2;
                        if (i12 >= objArr.length) {
                            objArr = Arrays.copyOf(objArr, objArr.length + 4);
                        }
                    }
                }
                objArr[i12] = n10;
                objArr[i12 + 1] = tVar;
            }
        }
        this.f17490e = objArr;
        this.f17489d = i11;
    }

    public boolean p() {
        return this.f17486a;
    }

    public void q(n3.t tVar) {
        ArrayList arrayList = new ArrayList(this.f17488c);
        String n10 = n(tVar);
        int length = this.f17490e.length;
        boolean z10 = false;
        for (int i10 = 1; i10 < length; i10 += 2) {
            Object[] objArr = this.f17490e;
            n3.t tVar2 = (n3.t) objArr[i10];
            if (tVar2 != null) {
                if (z10 || !(z10 = n10.equals(objArr[i10 - 1]))) {
                    arrayList.add(tVar2);
                } else {
                    this.f17491f[d(tVar2)] = null;
                }
            }
        }
        if (z10) {
            o(arrayList);
            return;
        }
        throw new NoSuchElementException("No entry '" + tVar.getName() + "' found, can't remove");
    }

    public c r(d4.q qVar) {
        if (qVar == null || qVar == d4.q.f12559a) {
            return this;
        }
        int length = this.f17491f.length;
        ArrayList arrayList = new ArrayList(length);
        for (int i10 = 0; i10 < length; i10++) {
            n3.t tVar = this.f17491f[i10];
            if (tVar == null) {
                arrayList.add(tVar);
            } else {
                arrayList.add(h(tVar, qVar));
            }
        }
        return new c(this.f17486a, arrayList, this.f17492g, this.f17494i);
    }

    public void s(n3.t tVar, n3.t tVar2) {
        int length = this.f17490e.length;
        for (int i10 = 1; i10 <= length; i10 += 2) {
            Object[] objArr = this.f17490e;
            if (objArr[i10] == tVar) {
                objArr[i10] = tVar2;
                this.f17491f[d(tVar)] = tVar2;
                return;
            }
        }
        throw new NoSuchElementException("No entry '" + tVar.getName() + "' found, can't replace");
    }

    public int size() {
        return this.f17488c;
    }

    public c t(boolean z10) {
        return this.f17486a == z10 ? this : new c(this, z10);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Properties=[");
        Iterator it = iterator();
        int i10 = 0;
        while (it.hasNext()) {
            n3.t tVar = (n3.t) it.next();
            int i11 = i10 + 1;
            if (i10 > 0) {
                sb.append(", ");
            }
            sb.append(tVar.getName());
            sb.append(ASCIIPropertyListParser.ARRAY_BEGIN_TOKEN);
            sb.append(tVar.getType());
            sb.append(ASCIIPropertyListParser.ARRAY_END_TOKEN);
            i10 = i11;
        }
        sb.append(']');
        if (!this.f17492g.isEmpty()) {
            sb.append("(aliases: ");
            sb.append(this.f17492g);
            sb.append(")");
        }
        return sb.toString();
    }

    public c u(n3.t tVar) {
        String n10 = n(tVar);
        int length = this.f17490e.length;
        for (int i10 = 1; i10 < length; i10 += 2) {
            n3.t tVar2 = (n3.t) this.f17490e[i10];
            if (tVar2 != null && tVar2.getName().equals(n10)) {
                return new c(this, tVar, i10, d(tVar2));
            }
        }
        return new c(this, tVar, n10, f(n10));
    }

    public c v(Collection collection, Collection collection2) {
        if ((collection == null || collection.isEmpty()) && collection2 == null) {
            return this;
        }
        int length = this.f17491f.length;
        ArrayList arrayList = new ArrayList(length);
        for (int i10 = 0; i10 < length; i10++) {
            n3.t tVar = this.f17491f[i10];
            if (tVar != null && !d4.m.c(tVar.getName(), collection, collection2)) {
                arrayList.add(tVar);
            }
        }
        return new c(this.f17486a, arrayList, this.f17492g, this.f17494i);
    }

    public c(c cVar, n3.t tVar, int i10, int i11) {
        this.f17486a = cVar.f17486a;
        this.f17494i = cVar.f17494i;
        this.f17487b = cVar.f17487b;
        this.f17488c = cVar.f17488c;
        this.f17489d = cVar.f17489d;
        this.f17492g = cVar.f17492g;
        this.f17493h = cVar.f17493h;
        Object[] objArr = cVar.f17490e;
        this.f17490e = Arrays.copyOf(objArr, objArr.length);
        n3.t[] tVarArr = cVar.f17491f;
        n3.t[] tVarArr2 = (n3.t[]) Arrays.copyOf(tVarArr, tVarArr.length);
        this.f17491f = tVarArr2;
        this.f17490e[i10] = tVar;
        tVarArr2[i11] = tVar;
    }

    public c(c cVar, n3.t tVar, String str, int i10) {
        this.f17486a = cVar.f17486a;
        this.f17494i = cVar.f17494i;
        this.f17487b = cVar.f17487b;
        this.f17488c = cVar.f17488c;
        this.f17489d = cVar.f17489d;
        this.f17492g = cVar.f17492g;
        this.f17493h = cVar.f17493h;
        Object[] objArr = cVar.f17490e;
        this.f17490e = Arrays.copyOf(objArr, objArr.length);
        n3.t[] tVarArr = cVar.f17491f;
        int length = tVarArr.length;
        n3.t[] tVarArr2 = (n3.t[]) Arrays.copyOf(tVarArr, length + 1);
        this.f17491f = tVarArr2;
        tVarArr2[length] = tVar;
        int i11 = this.f17487b + 1;
        int i12 = i10 << 1;
        Object[] objArr2 = this.f17490e;
        if (objArr2[i12] != null) {
            i12 = ((i10 >> 1) + i11) << 1;
            if (objArr2[i12] != null) {
                int i13 = this.f17489d;
                i12 = ((i11 + (i11 >> 1)) << 1) + i13;
                this.f17489d = i13 + 2;
                if (i12 >= objArr2.length) {
                    this.f17490e = Arrays.copyOf(objArr2, objArr2.length + 4);
                }
            }
        }
        Object[] objArr3 = this.f17490e;
        objArr3[i12] = str;
        objArr3[i12 + 1] = tVar;
    }

    public c(c cVar, boolean z10) {
        this.f17486a = z10;
        this.f17494i = cVar.f17494i;
        this.f17492g = cVar.f17492g;
        this.f17493h = cVar.f17493h;
        n3.t[] tVarArr = cVar.f17491f;
        n3.t[] tVarArr2 = (n3.t[]) Arrays.copyOf(tVarArr, tVarArr.length);
        this.f17491f = tVarArr2;
        o(Arrays.asList(tVarArr2));
    }
}
