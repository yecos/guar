package d4;

import k3.c0;

/* loaded from: classes.dex */
public class u implements k3.n {

    /* renamed from: a, reason: collision with root package name */
    public Object f12577a;

    public u(String str) {
        this.f12577a = str;
    }

    public void a(c3.h hVar) {
        Object obj = this.f12577a;
        if (obj instanceof c3.q) {
            hVar.q0((c3.q) obj);
        } else {
            hVar.r0(String.valueOf(obj));
        }
    }

    @Override // k3.n
    public void d(c3.h hVar, c0 c0Var) {
        Object obj = this.f12577a;
        if (obj instanceof k3.n) {
            ((k3.n) obj).d(hVar, c0Var);
        } else {
            a(hVar);
        }
    }

    @Override // k3.n
    public void e(c3.h hVar, c0 c0Var, w3.h hVar2) {
        Object obj = this.f12577a;
        if (obj instanceof k3.n) {
            ((k3.n) obj).e(hVar, c0Var, hVar2);
        } else if (obj instanceof c3.q) {
            d(hVar, c0Var);
        }
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof u)) {
            return false;
        }
        Object obj2 = this.f12577a;
        Object obj3 = ((u) obj).f12577a;
        if (obj2 == obj3) {
            return true;
        }
        return obj2 != null && obj2.equals(obj3);
    }

    public int hashCode() {
        Object obj = this.f12577a;
        if (obj == null) {
            return 0;
        }
        return obj.hashCode();
    }

    public String toString() {
        return String.format("[RawValue of type %s]", h.h(this.f12577a));
    }
}
