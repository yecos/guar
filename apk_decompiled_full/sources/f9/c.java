package f9;

import com.google.common.base.MoreObjects;
import java.util.List;
import y8.o0;

/* loaded from: classes3.dex */
public abstract class c extends o0.h {
    @Override // y8.o0.h
    public List b() {
        return i().b();
    }

    @Override // y8.o0.h
    public Object d() {
        return i().d();
    }

    @Override // y8.o0.h
    public void e() {
        i().e();
    }

    @Override // y8.o0.h
    public void f() {
        i().f();
    }

    @Override // y8.o0.h
    public void g(o0.j jVar) {
        i().g(jVar);
    }

    public abstract o0.h i();

    public String toString() {
        return MoreObjects.toStringHelper(this).add("delegate", i()).toString();
    }
}
