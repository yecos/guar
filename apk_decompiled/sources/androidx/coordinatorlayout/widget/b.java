package androidx.coordinatorlayout.widget;

import a0.e;
import a0.f;
import androidx.collection.g;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public final e f2003a = new f(10);

    /* renamed from: b, reason: collision with root package name */
    public final g f2004b = new g();

    /* renamed from: c, reason: collision with root package name */
    public final ArrayList f2005c = new ArrayList();

    /* renamed from: d, reason: collision with root package name */
    public final HashSet f2006d = new HashSet();

    public void a(Object obj, Object obj2) {
        if (!this.f2004b.containsKey(obj) || !this.f2004b.containsKey(obj2)) {
            throw new IllegalArgumentException("All nodes must be present in the graph before being added as an edge");
        }
        ArrayList arrayList = (ArrayList) this.f2004b.get(obj);
        if (arrayList == null) {
            arrayList = f();
            this.f2004b.put(obj, arrayList);
        }
        arrayList.add(obj2);
    }

    public void b(Object obj) {
        if (this.f2004b.containsKey(obj)) {
            return;
        }
        this.f2004b.put(obj, null);
    }

    public void c() {
        int size = this.f2004b.size();
        for (int i10 = 0; i10 < size; i10++) {
            ArrayList arrayList = (ArrayList) this.f2004b.valueAt(i10);
            if (arrayList != null) {
                k(arrayList);
            }
        }
        this.f2004b.clear();
    }

    public boolean d(Object obj) {
        return this.f2004b.containsKey(obj);
    }

    public final void e(Object obj, ArrayList arrayList, HashSet hashSet) {
        if (arrayList.contains(obj)) {
            return;
        }
        if (hashSet.contains(obj)) {
            throw new RuntimeException("This graph contains cyclic dependencies");
        }
        hashSet.add(obj);
        ArrayList arrayList2 = (ArrayList) this.f2004b.get(obj);
        if (arrayList2 != null) {
            int size = arrayList2.size();
            for (int i10 = 0; i10 < size; i10++) {
                e(arrayList2.get(i10), arrayList, hashSet);
            }
        }
        hashSet.remove(obj);
        arrayList.add(obj);
    }

    public final ArrayList f() {
        ArrayList arrayList = (ArrayList) this.f2003a.acquire();
        return arrayList == null ? new ArrayList() : arrayList;
    }

    public List g(Object obj) {
        return (List) this.f2004b.get(obj);
    }

    public List h(Object obj) {
        int size = this.f2004b.size();
        ArrayList arrayList = null;
        for (int i10 = 0; i10 < size; i10++) {
            ArrayList arrayList2 = (ArrayList) this.f2004b.valueAt(i10);
            if (arrayList2 != null && arrayList2.contains(obj)) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(this.f2004b.keyAt(i10));
            }
        }
        return arrayList;
    }

    public ArrayList i() {
        this.f2005c.clear();
        this.f2006d.clear();
        int size = this.f2004b.size();
        for (int i10 = 0; i10 < size; i10++) {
            e(this.f2004b.keyAt(i10), this.f2005c, this.f2006d);
        }
        return this.f2005c;
    }

    public boolean j(Object obj) {
        int size = this.f2004b.size();
        for (int i10 = 0; i10 < size; i10++) {
            ArrayList arrayList = (ArrayList) this.f2004b.valueAt(i10);
            if (arrayList != null && arrayList.contains(obj)) {
                return true;
            }
        }
        return false;
    }

    public final void k(ArrayList arrayList) {
        arrayList.clear();
        this.f2003a.release(arrayList);
    }
}
