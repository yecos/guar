package k3;

import b3.k;
import b3.r;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;
import java.util.Set;
import l3.e;

/* loaded from: classes.dex */
public abstract class c {

    /* renamed from: a, reason: collision with root package name */
    public final j f14847a;

    public c(j jVar) {
        this.f14847a = jVar;
    }

    public abstract boolean A();

    public abstract Object B(boolean z10);

    public boolean C() {
        return u().t();
    }

    public abstract r3.i a();

    public abstract r3.i b();

    public abstract List c();

    public abstract r3.e d();

    public abstract Class[] e();

    public abstract d4.j f();

    public abstract k.d g(k.d dVar);

    public abstract Method h(Class... clsArr);

    public abstract Map i();

    public abstract r3.i j();

    public abstract r3.i k();

    public abstract r3.j l(String str, Class[] clsArr);

    public abstract Class m();

    public abstract e.a n();

    public abstract List o();

    public abstract r.b p(r.b bVar);

    public abstract d4.j q();

    public abstract Constructor r(Class... clsArr);

    public Class s() {
        return this.f14847a.q();
    }

    public abstract d4.b t();

    public abstract r3.c u();

    public abstract List v();

    public abstract List w();

    public abstract Set x();

    public abstract r3.b0 y();

    public j z() {
        return this.f14847a;
    }
}
