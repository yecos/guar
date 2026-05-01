package a4;

import com.fasterxml.jackson.databind.ser.std.t;
import java.util.Map;
import k3.a0;
import k3.c0;

/* loaded from: classes.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public final k3.d f174a;

    /* renamed from: b, reason: collision with root package name */
    public final r3.i f175b;

    /* renamed from: c, reason: collision with root package name */
    public k3.o f176c;

    /* renamed from: d, reason: collision with root package name */
    public t f177d;

    public a(k3.d dVar, r3.i iVar, k3.o oVar) {
        this.f175b = iVar;
        this.f174a = dVar;
        this.f176c = oVar;
        if (oVar instanceof t) {
            this.f177d = (t) oVar;
        }
    }

    public void a(a0 a0Var) {
        this.f175b.i(a0Var.D(k3.q.OVERRIDE_PUBLIC_ACCESS_MODIFIERS));
    }

    public void b(Object obj, c3.h hVar, c0 c0Var) {
        Object n10 = this.f175b.n(obj);
        if (n10 == null) {
            return;
        }
        if (!(n10 instanceof Map)) {
            c0Var.q(this.f174a.getType(), String.format("Value returned by 'any-getter' %s() not java.util.Map but %s", this.f175b.d(), n10.getClass().getName()));
        }
        t tVar = this.f177d;
        if (tVar != null) {
            tVar.w((Map) n10, hVar, c0Var);
        } else {
            this.f176c.serialize(n10, hVar, c0Var);
        }
    }

    public void c(c0 c0Var) {
        k3.o oVar = this.f176c;
        if (oVar instanceof i) {
            k3.o h02 = c0Var.h0(oVar, this.f174a);
            this.f176c = h02;
            if (h02 instanceof t) {
                this.f177d = (t) h02;
            }
        }
    }
}
