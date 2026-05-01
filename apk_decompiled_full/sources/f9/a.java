package f9;

import com.google.common.base.MoreObjects;
import y8.k1;
import y8.o0;

/* loaded from: classes3.dex */
public abstract class a extends o0 {
    @Override // y8.o0
    public boolean b() {
        return f().b();
    }

    @Override // y8.o0
    public void c(k1 k1Var) {
        f().c(k1Var);
    }

    @Override // y8.o0
    public void d(o0.g gVar) {
        f().d(gVar);
    }

    public abstract o0 f();

    public String toString() {
        return MoreObjects.toStringHelper(this).add("delegate", f()).toString();
    }
}
