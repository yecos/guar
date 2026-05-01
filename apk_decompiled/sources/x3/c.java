package x3;

import d4.y;
import java.util.BitSet;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public class c extends g {

    /* renamed from: m, reason: collision with root package name */
    public static final BitSet f19417m = new BitSet(0);

    /* renamed from: k, reason: collision with root package name */
    public final Map f19418k;

    /* renamed from: l, reason: collision with root package name */
    public final Map f19419l;

    public c(k3.j jVar, w3.f fVar, k3.j jVar2, k3.f fVar2, Collection collection) {
        super(jVar, fVar, null, false, jVar2, null);
        this.f19418k = new HashMap();
        this.f19419l = y(fVar2, collection);
    }

    public static void z(List list, int i10) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            if (!((BitSet) it.next()).get(i10)) {
                it.remove();
            }
        }
    }

    @Override // x3.g, x3.a, w3.e
    public Object e(c3.k kVar, k3.g gVar) {
        String str;
        c3.n n10 = kVar.n();
        if (n10 == c3.n.START_OBJECT) {
            n10 = kVar.s0();
        } else if (n10 != c3.n.FIELD_NAME) {
            return x(kVar, gVar, null, "Unexpected input");
        }
        if (n10 == c3.n.END_OBJECT && (str = (String) this.f19419l.get(f19417m)) != null) {
            return w(kVar, gVar, null, str);
        }
        LinkedList linkedList = new LinkedList(this.f19419l.keySet());
        y yVar = new y(kVar, gVar);
        boolean o02 = gVar.o0(k3.q.ACCEPT_CASE_INSENSITIVE_PROPERTIES);
        while (n10 == c3.n.FIELD_NAME) {
            String m10 = kVar.m();
            if (o02) {
                m10 = m10.toLowerCase();
            }
            yVar.V0(kVar);
            Integer num = (Integer) this.f19418k.get(m10);
            if (num != null) {
                z(linkedList, num.intValue());
                if (linkedList.size() == 1) {
                    return w(kVar, gVar, yVar, (String) this.f19419l.get(linkedList.get(0)));
                }
            }
            n10 = kVar.s0();
        }
        return x(kVar, gVar, yVar, String.format("Cannot deduce unique subtype of %s (%d candidates match)", d4.h.G(this.f19441b), Integer.valueOf(linkedList.size())));
    }

    @Override // x3.g, x3.a, w3.e
    public w3.e g(k3.d dVar) {
        return dVar == this.f19442c ? this : new c(this, dVar);
    }

    public Map y(k3.f fVar, Collection collection) {
        boolean D = fVar.D(k3.q.ACCEPT_CASE_INSENSITIVE_PROPERTIES);
        HashMap hashMap = new HashMap();
        Iterator it = collection.iterator();
        int i10 = 0;
        while (it.hasNext()) {
            w3.b bVar = (w3.b) it.next();
            List o10 = fVar.g0(fVar.z().H(bVar.b())).o();
            BitSet bitSet = new BitSet(o10.size() + i10);
            Iterator it2 = o10.iterator();
            while (it2.hasNext()) {
                String name = ((r3.s) it2.next()).getName();
                if (D) {
                    name = name.toLowerCase();
                }
                Integer num = (Integer) this.f19418k.get(name);
                if (num == null) {
                    num = Integer.valueOf(i10);
                    this.f19418k.put(name, Integer.valueOf(i10));
                    i10++;
                }
                bitSet.set(num.intValue());
            }
            String str = (String) hashMap.put(bitSet, bVar.b().getName());
            if (str != null) {
                throw new IllegalStateException(String.format("Subtypes %s and %s have the same signature and cannot be uniquely deduced.", str, bVar.b().getName()));
            }
        }
        return hashMap;
    }

    public c(c cVar, k3.d dVar) {
        super(cVar, dVar);
        this.f19418k = cVar.f19418k;
        this.f19419l = cVar.f19419l;
    }
}
