package z8;

import com.google.common.base.MoreObjects;
import java.io.InputStream;

/* loaded from: classes3.dex */
public abstract class h0 implements q {
    @Override // z8.h2
    public void a(y8.n nVar) {
        f().a(nVar);
    }

    @Override // z8.h2
    public void b(int i10) {
        f().b(i10);
    }

    @Override // z8.q
    public void c(int i10) {
        f().c(i10);
    }

    @Override // z8.q
    public void d(int i10) {
        f().d(i10);
    }

    @Override // z8.q
    public void e(y8.k1 k1Var) {
        f().e(k1Var);
    }

    public abstract q f();

    @Override // z8.h2
    public void flush() {
        f().flush();
    }

    @Override // z8.q
    public void g(r rVar) {
        f().g(rVar);
    }

    @Override // z8.h2
    public void h(InputStream inputStream) {
        f().h(inputStream);
    }

    @Override // z8.h2
    public void i() {
        f().i();
    }

    @Override // z8.q
    public void j(boolean z10) {
        f().j(z10);
    }

    @Override // z8.q
    public void k(y8.t tVar) {
        f().k(tVar);
    }

    @Override // z8.q
    public void l(y8.v vVar) {
        f().l(vVar);
    }

    @Override // z8.h2
    public boolean m() {
        return f().m();
    }

    @Override // z8.q
    public void n(String str) {
        f().n(str);
    }

    @Override // z8.q
    public void o() {
        f().o();
    }

    @Override // z8.q
    public void p(w0 w0Var) {
        f().p(w0Var);
    }

    public String toString() {
        return MoreObjects.toStringHelper(this).add("delegate", f()).toString();
    }
}
