package r3;

import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.lang.reflect.Member;

/* loaded from: classes.dex */
public abstract class i extends b implements Serializable {

    /* renamed from: a, reason: collision with root package name */
    public final transient f0 f18439a;

    /* renamed from: b, reason: collision with root package name */
    public final transient p f18440b;

    public i(f0 f0Var, p pVar) {
        this.f18439a = f0Var;
        this.f18440b = pVar;
    }

    @Override // r3.b
    public final Annotation c(Class cls) {
        p pVar = this.f18440b;
        if (pVar == null) {
            return null;
        }
        return pVar.get(cls);
    }

    @Override // r3.b
    public final boolean g(Class cls) {
        p pVar = this.f18440b;
        if (pVar == null) {
            return false;
        }
        return pVar.a(cls);
    }

    @Override // r3.b
    public boolean h(Class[] clsArr) {
        p pVar = this.f18440b;
        if (pVar == null) {
            return false;
        }
        return pVar.b(clsArr);
    }

    public final void i(boolean z10) {
        Member m10 = m();
        if (m10 != null) {
            d4.h.g(m10, z10);
        }
    }

    public p j() {
        return this.f18440b;
    }

    public abstract Class k();

    public String l() {
        return k().getName() + "#" + d();
    }

    public abstract Member m();

    public abstract Object n(Object obj);

    public abstract void o(Object obj, Object obj2);

    public abstract b p(p pVar);
}
