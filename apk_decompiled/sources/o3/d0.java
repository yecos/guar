package o3;

import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class d0 {

    /* renamed from: a, reason: collision with root package name */
    public final List f17504a;

    public d0() {
        this.f17504a = new ArrayList();
    }

    public void a(n3.t tVar) {
        this.f17504a.add(tVar);
    }

    public Object b(c3.k kVar, k3.g gVar, Object obj, d4.y yVar) {
        int size = this.f17504a.size();
        for (int i10 = 0; i10 < size; i10++) {
            n3.t tVar = (n3.t) this.f17504a.get(i10);
            c3.k R0 = yVar.R0();
            R0.s0();
            tVar.l(R0, gVar, obj);
        }
        return obj;
    }

    public d0 c(d4.q qVar) {
        k3.k unwrappingDeserializer;
        ArrayList arrayList = new ArrayList(this.f17504a.size());
        for (n3.t tVar : this.f17504a) {
            n3.t K = tVar.K(qVar.c(tVar.getName()));
            k3.k u10 = K.u();
            if (u10 != null && (unwrappingDeserializer = u10.unwrappingDeserializer(qVar)) != u10) {
                K = K.L(unwrappingDeserializer);
            }
            arrayList.add(K);
        }
        return new d0(arrayList);
    }

    public d0(List list) {
        this.f17504a = list;
    }
}
