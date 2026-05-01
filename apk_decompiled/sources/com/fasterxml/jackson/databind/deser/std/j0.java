package com.fasterxml.jackson.databind.deser.std;

import com.taobao.accs.common.Constants;
import java.util.Set;

/* loaded from: classes.dex */
public class j0 extends n3.c {
    public j0(n3.c cVar) {
        super(cVar);
        this.f17197h = false;
    }

    @Override // n3.c, n3.d
    public Object s(c3.k kVar, k3.g gVar) {
        if (this.f17195f != null) {
            return c(kVar, gVar);
        }
        k3.k kVar2 = this.f17193d;
        if (kVar2 != null) {
            return this.f17192c.y(gVar, kVar2.deserialize(kVar, gVar));
        }
        if (this.f17190a.z()) {
            return gVar.W(handledType(), getValueInstantiator(), kVar, "abstract type (need to add/enable type information?)", new Object[0]);
        }
        boolean h10 = this.f17192c.h();
        boolean j10 = this.f17192c.j();
        if (!h10 && !j10) {
            return gVar.W(handledType(), getValueInstantiator(), kVar, "Throwable needs a default constructor, a single-String-arg constructor; or explicit @JsonCreator", new Object[0]);
        }
        Object obj = null;
        Object[] objArr = null;
        int i10 = 0;
        while (!kVar.j0(c3.n.END_OBJECT)) {
            String m10 = kVar.m();
            n3.t k10 = this.f17198i.k(m10);
            kVar.s0();
            if (k10 != null) {
                if (obj != null) {
                    k10.l(kVar, gVar, obj);
                } else {
                    if (objArr == null) {
                        int size = this.f17198i.size();
                        objArr = new Object[size + size];
                    }
                    int i11 = i10 + 1;
                    objArr[i10] = k10;
                    i10 = i11 + 1;
                    objArr[i11] = k10.k(kVar, gVar);
                }
            } else if (Constants.SHARED_MESSAGE_ID_FILE.equals(m10) && h10) {
                obj = this.f17192c.v(gVar, kVar.g0());
                if (objArr != null) {
                    for (int i12 = 0; i12 < i10; i12 += 2) {
                        ((n3.t) objArr[i12]).C(obj, objArr[i12 + 1]);
                    }
                    objArr = null;
                }
            } else {
                Set set = this.f17201l;
                if (set == null || !set.contains(m10)) {
                    n3.s sVar = this.f17200k;
                    if (sVar != null) {
                        sVar.c(kVar, gVar, obj, m10);
                    } else {
                        handleUnknownProperty(kVar, gVar, obj, m10);
                    }
                } else {
                    kVar.D0();
                }
            }
            kVar.s0();
        }
        if (obj == null) {
            obj = h10 ? this.f17192c.v(gVar, null) : this.f17192c.x(gVar);
            if (objArr != null) {
                for (int i13 = 0; i13 < i10; i13 += 2) {
                    ((n3.t) objArr[i13]).C(obj, objArr[i13 + 1]);
                }
            }
        }
        return obj;
    }

    @Override // n3.c, n3.d, k3.k
    public k3.k unwrappingDeserializer(d4.q qVar) {
        return getClass() != j0.class ? this : new j0(this, qVar);
    }

    public j0(n3.c cVar, d4.q qVar) {
        super(cVar, qVar);
    }
}
