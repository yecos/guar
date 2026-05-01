package x3;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes.dex */
public class s extends r {

    /* renamed from: c, reason: collision with root package name */
    public final m3.m f19450c;

    /* renamed from: d, reason: collision with root package name */
    public final ConcurrentHashMap f19451d;

    /* renamed from: e, reason: collision with root package name */
    public final Map f19452e;

    /* renamed from: f, reason: collision with root package name */
    public final boolean f19453f;

    public s(m3.m mVar, k3.j jVar, ConcurrentHashMap concurrentHashMap, HashMap hashMap) {
        super(jVar, mVar.z());
        this.f19450c = mVar;
        this.f19451d = concurrentHashMap;
        this.f19452e = hashMap;
        this.f19453f = mVar.D(k3.q.ACCEPT_CASE_INSENSITIVE_VALUES);
    }

    public static String g(Class cls) {
        String name = cls.getName();
        int lastIndexOf = name.lastIndexOf(46);
        return lastIndexOf < 0 ? name : name.substring(lastIndexOf + 1);
    }

    public static s i(m3.m mVar, k3.j jVar, Collection collection, boolean z10, boolean z11) {
        HashMap hashMap;
        ConcurrentHashMap concurrentHashMap;
        if (z10 == z11) {
            throw new IllegalArgumentException();
        }
        if (z10) {
            concurrentHashMap = new ConcurrentHashMap();
            hashMap = null;
        } else {
            hashMap = new HashMap();
            concurrentHashMap = new ConcurrentHashMap(4);
        }
        boolean D = mVar.D(k3.q.ACCEPT_CASE_INSENSITIVE_VALUES);
        if (collection != null) {
            Iterator it = collection.iterator();
            while (it.hasNext()) {
                w3.b bVar = (w3.b) it.next();
                Class b10 = bVar.b();
                String a10 = bVar.c() ? bVar.a() : g(b10);
                if (z10) {
                    concurrentHashMap.put(b10.getName(), a10);
                }
                if (z11) {
                    if (D) {
                        a10 = a10.toLowerCase();
                    }
                    k3.j jVar2 = (k3.j) hashMap.get(a10);
                    if (jVar2 == null || !b10.isAssignableFrom(jVar2.q())) {
                        hashMap.put(a10, mVar.e(b10));
                    }
                }
            }
        }
        return new s(mVar, jVar, concurrentHashMap, hashMap);
    }

    @Override // w3.f
    public String a(Object obj) {
        return j(obj.getClass());
    }

    @Override // w3.f
    public String b() {
        TreeSet treeSet = new TreeSet();
        for (Map.Entry entry : this.f19452e.entrySet()) {
            if (((k3.j) entry.getValue()).C()) {
                treeSet.add(entry.getKey());
            }
        }
        return treeSet.toString();
    }

    @Override // w3.f
    public String d(Object obj, Class cls) {
        return obj == null ? j(cls) : a(obj);
    }

    @Override // w3.f
    public k3.j f(k3.e eVar, String str) {
        return h(str);
    }

    public k3.j h(String str) {
        if (this.f19453f) {
            str = str.toLowerCase();
        }
        return (k3.j) this.f19452e.get(str);
    }

    public String j(Class cls) {
        if (cls == null) {
            return null;
        }
        String name = cls.getName();
        String str = (String) this.f19451d.get(name);
        if (str == null) {
            Class q10 = this.f19448a.H(cls).q();
            if (this.f19450c.C()) {
                str = this.f19450c.g().b0(this.f19450c.A(q10).u());
            }
            if (str == null) {
                str = g(q10);
            }
            this.f19451d.put(name, str);
        }
        return str;
    }

    public String toString() {
        return String.format("[%s; id-to-type=%s]", getClass().getName(), this.f19452e);
    }
}
