package y8;

import com.google.common.base.MoreObjects;

/* loaded from: classes3.dex */
public abstract class b1 extends g {
    @Override // y8.g
    public void a(String str, Throwable th) {
        f().a(str, th);
    }

    @Override // y8.g
    public void b() {
        f().b();
    }

    @Override // y8.g
    public void c(int i10) {
        f().c(i10);
    }

    public abstract g f();

    public String toString() {
        return MoreObjects.toStringHelper(this).add("delegate", f()).toString();
    }
}
