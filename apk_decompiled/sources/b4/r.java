package b4;

import java.util.Iterator;
import java.util.Map;
import k3.c0;

/* loaded from: classes.dex */
public class r extends a4.c {

    /* renamed from: u, reason: collision with root package name */
    public final d4.q f4641u;

    public r(a4.c cVar, d4.q qVar) {
        super(cVar);
        this.f4641u = qVar;
    }

    public r F(d4.q qVar, f3.i iVar) {
        return new r(this, qVar, iVar);
    }

    @Override // a4.c
    /* renamed from: G, reason: merged with bridge method [inline-methods] */
    public r w(d4.q qVar) {
        return F(d4.q.a(qVar, this.f4641u), new f3.i(qVar.c(this.f184c.getValue())));
    }

    @Override // a4.c
    public void g(z3.r rVar, k3.m mVar) {
        k3.m n10 = mVar.n("properties");
        if (n10 != null) {
            Iterator m10 = n10.m();
            while (m10.hasNext()) {
                Map.Entry entry = (Map.Entry) m10.next();
                String str = (String) entry.getKey();
                d4.q qVar = this.f4641u;
                if (qVar != null) {
                    str = qVar.c(str);
                }
                rVar.G(str, (k3.m) entry.getValue());
            }
        }
    }

    @Override // a4.c
    public k3.o h(k kVar, Class cls, c0 c0Var) {
        k3.j jVar = this.f188g;
        k3.o U = jVar != null ? c0Var.U(c0Var.A(jVar, cls), this) : c0Var.S(cls, this);
        d4.q qVar = this.f4641u;
        if (U.isUnwrappingSerializer() && (U instanceof s)) {
            qVar = d4.q.a(qVar, ((s) U).f4642k);
        }
        k3.o unwrappingSerializer = U.unwrappingSerializer(qVar);
        this.f196o = this.f196o.i(cls, unwrappingSerializer);
        return unwrappingSerializer;
    }

    @Override // a4.c
    public void l(k3.o oVar) {
        if (oVar != null) {
            d4.q qVar = this.f4641u;
            if (oVar.isUnwrappingSerializer() && (oVar instanceof s)) {
                qVar = d4.q.a(qVar, ((s) oVar).f4642k);
            }
            oVar = oVar.unwrappingSerializer(qVar);
        }
        super.l(oVar);
    }

    @Override // a4.c
    public void y(Object obj, c3.h hVar, c0 c0Var) {
        Object p10 = p(obj);
        if (p10 == null) {
            return;
        }
        k3.o oVar = this.f193l;
        if (oVar == null) {
            Class<?> cls = p10.getClass();
            k kVar = this.f196o;
            k3.o j10 = kVar.j(cls);
            oVar = j10 == null ? h(kVar, cls, c0Var) : j10;
        }
        Object obj2 = this.f198q;
        if (obj2 != null) {
            if (a4.c.f183t == obj2) {
                if (oVar.isEmpty(c0Var, p10)) {
                    return;
                }
            } else if (obj2.equals(p10)) {
                return;
            }
        }
        if (p10 == obj && i(obj, hVar, c0Var, oVar)) {
            return;
        }
        if (!oVar.isUnwrappingSerializer()) {
            hVar.Y(this.f184c);
        }
        w3.h hVar2 = this.f195n;
        if (hVar2 == null) {
            oVar.serialize(p10, hVar, c0Var);
        } else {
            oVar.serializeWithType(p10, hVar, c0Var, hVar2);
        }
    }

    public r(r rVar, d4.q qVar, f3.i iVar) {
        super(rVar, iVar);
        this.f4641u = qVar;
    }
}
