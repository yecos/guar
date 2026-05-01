package x3;

import java.io.Serializable;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: classes.dex */
public class n extends w3.d implements Serializable {

    /* renamed from: a, reason: collision with root package name */
    public LinkedHashSet f19428a;

    @Override // w3.d
    public Collection a(m3.m mVar, r3.c cVar) {
        k3.b g10 = mVar.g();
        HashMap hashMap = new HashMap();
        if (this.f19428a != null) {
            Class e10 = cVar.e();
            Iterator it = this.f19428a.iterator();
            while (it.hasNext()) {
                w3.b bVar = (w3.b) it.next();
                if (e10.isAssignableFrom(bVar.b())) {
                    f(r3.d.m(mVar, bVar.b()), bVar, mVar, g10, hashMap);
                }
            }
        }
        f(cVar, new w3.b(cVar.e(), null), mVar, g10, hashMap);
        return new ArrayList(hashMap.values());
    }

    @Override // w3.d
    public Collection b(m3.m mVar, r3.i iVar, k3.j jVar) {
        List<w3.b> a02;
        k3.b g10 = mVar.g();
        Class e10 = jVar == null ? iVar.e() : jVar.q();
        HashMap hashMap = new HashMap();
        LinkedHashSet linkedHashSet = this.f19428a;
        if (linkedHashSet != null) {
            Iterator it = linkedHashSet.iterator();
            while (it.hasNext()) {
                w3.b bVar = (w3.b) it.next();
                if (e10.isAssignableFrom(bVar.b())) {
                    f(r3.d.m(mVar, bVar.b()), bVar, mVar, g10, hashMap);
                }
            }
        }
        if (iVar != null && (a02 = g10.a0(iVar)) != null) {
            for (w3.b bVar2 : a02) {
                f(r3.d.m(mVar, bVar2.b()), bVar2, mVar, g10, hashMap);
            }
        }
        f(r3.d.m(mVar, e10), new w3.b(e10, null), mVar, g10, hashMap);
        return new ArrayList(hashMap.values());
    }

    @Override // w3.d
    public Collection c(m3.m mVar, r3.c cVar) {
        Class e10 = cVar.e();
        HashSet hashSet = new HashSet();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        g(cVar, new w3.b(e10, null), mVar, hashSet, linkedHashMap);
        LinkedHashSet linkedHashSet = this.f19428a;
        if (linkedHashSet != null) {
            Iterator it = linkedHashSet.iterator();
            while (it.hasNext()) {
                w3.b bVar = (w3.b) it.next();
                if (e10.isAssignableFrom(bVar.b())) {
                    g(r3.d.m(mVar, bVar.b()), bVar, mVar, hashSet, linkedHashMap);
                }
            }
        }
        return h(e10, hashSet, linkedHashMap);
    }

    @Override // w3.d
    public Collection d(m3.m mVar, r3.i iVar, k3.j jVar) {
        List<w3.b> a02;
        k3.b g10 = mVar.g();
        Class q10 = jVar.q();
        HashSet hashSet = new HashSet();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        g(r3.d.m(mVar, q10), new w3.b(q10, null), mVar, hashSet, linkedHashMap);
        if (iVar != null && (a02 = g10.a0(iVar)) != null) {
            for (w3.b bVar : a02) {
                g(r3.d.m(mVar, bVar.b()), bVar, mVar, hashSet, linkedHashMap);
            }
        }
        LinkedHashSet linkedHashSet = this.f19428a;
        if (linkedHashSet != null) {
            Iterator it = linkedHashSet.iterator();
            while (it.hasNext()) {
                w3.b bVar2 = (w3.b) it.next();
                if (q10.isAssignableFrom(bVar2.b())) {
                    g(r3.d.m(mVar, bVar2.b()), bVar2, mVar, hashSet, linkedHashMap);
                }
            }
        }
        return h(q10, hashSet, linkedHashMap);
    }

    @Override // w3.d
    public void e(w3.b... bVarArr) {
        if (this.f19428a == null) {
            this.f19428a = new LinkedHashSet();
        }
        for (w3.b bVar : bVarArr) {
            this.f19428a.add(bVar);
        }
    }

    public void f(r3.c cVar, w3.b bVar, m3.m mVar, k3.b bVar2, HashMap hashMap) {
        String b02;
        if (!bVar.c() && (b02 = bVar2.b0(cVar)) != null) {
            bVar = new w3.b(bVar.b(), b02);
        }
        w3.b bVar3 = new w3.b(bVar.b());
        if (hashMap.containsKey(bVar3)) {
            if (!bVar.c() || ((w3.b) hashMap.get(bVar3)).c()) {
                return;
            }
            hashMap.put(bVar3, bVar);
            return;
        }
        hashMap.put(bVar3, bVar);
        List<w3.b> a02 = bVar2.a0(cVar);
        if (a02 == null || a02.isEmpty()) {
            return;
        }
        for (w3.b bVar4 : a02) {
            f(r3.d.m(mVar, bVar4.b()), bVar4, mVar, bVar2, hashMap);
        }
    }

    public void g(r3.c cVar, w3.b bVar, m3.m mVar, Set set, Map map) {
        List<w3.b> a02;
        String b02;
        k3.b g10 = mVar.g();
        if (!bVar.c() && (b02 = g10.b0(cVar)) != null) {
            bVar = new w3.b(bVar.b(), b02);
        }
        if (bVar.c()) {
            map.put(bVar.a(), bVar);
        }
        if (!set.add(bVar.b()) || (a02 = g10.a0(cVar)) == null || a02.isEmpty()) {
            return;
        }
        for (w3.b bVar2 : a02) {
            g(r3.d.m(mVar, bVar2.b()), bVar2, mVar, set, map);
        }
    }

    public Collection h(Class cls, Set set, Map map) {
        ArrayList arrayList = new ArrayList(map.values());
        Iterator it = map.values().iterator();
        while (it.hasNext()) {
            set.remove(((w3.b) it.next()).b());
        }
        Iterator it2 = set.iterator();
        while (it2.hasNext()) {
            Class cls2 = (Class) it2.next();
            if (cls2 != cls || !Modifier.isAbstract(cls2.getModifiers())) {
                arrayList.add(new w3.b(cls2));
            }
        }
        return arrayList;
    }
}
