package androidx.fragment.app;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

/* loaded from: classes.dex */
public class j {

    /* renamed from: a, reason: collision with root package name */
    public final l f2297a;

    public j(l lVar) {
        this.f2297a = lVar;
    }

    public static j b(l lVar) {
        return new j((l) a0.h.e(lVar, "callbacks == null"));
    }

    public void a(Fragment fragment) {
        l lVar = this.f2297a;
        lVar.f2332e.k(lVar, lVar, fragment);
    }

    public void c() {
        this.f2297a.f2332e.y();
    }

    public void d(Configuration configuration) {
        this.f2297a.f2332e.A(configuration);
    }

    public boolean e(MenuItem menuItem) {
        return this.f2297a.f2332e.B(menuItem);
    }

    public void f() {
        this.f2297a.f2332e.C();
    }

    public boolean g(Menu menu, MenuInflater menuInflater) {
        return this.f2297a.f2332e.D(menu, menuInflater);
    }

    public void h() {
        this.f2297a.f2332e.E();
    }

    public void i() {
        this.f2297a.f2332e.G();
    }

    public void j(boolean z10) {
        this.f2297a.f2332e.H(z10);
    }

    public boolean k(MenuItem menuItem) {
        return this.f2297a.f2332e.J(menuItem);
    }

    public void l(Menu menu) {
        this.f2297a.f2332e.K(menu);
    }

    public void m() {
        this.f2297a.f2332e.M();
    }

    public void n(boolean z10) {
        this.f2297a.f2332e.N(z10);
    }

    public boolean o(Menu menu) {
        return this.f2297a.f2332e.O(menu);
    }

    public void p() {
        this.f2297a.f2332e.Q();
    }

    public void q() {
        this.f2297a.f2332e.R();
    }

    public void r() {
        this.f2297a.f2332e.T();
    }

    public boolean s() {
        return this.f2297a.f2332e.a0(true);
    }

    public o t() {
        return this.f2297a.f2332e;
    }

    public void u() {
        this.f2297a.f2332e.T0();
    }

    public View v(View view, String str, Context context, AttributeSet attributeSet) {
        return this.f2297a.f2332e.u0().onCreateView(view, str, context, attributeSet);
    }

    public void w(Parcelable parcelable) {
        l lVar = this.f2297a;
        if (!(lVar instanceof androidx.lifecycle.y)) {
            throw new IllegalStateException("Your FragmentHostCallback must implement ViewModelStoreOwner to call restoreSaveState(). Call restoreAllState()  if you're still using retainNestedNonConfig().");
        }
        lVar.f2332e.h1(parcelable);
    }

    public Parcelable x() {
        return this.f2297a.f2332e.j1();
    }
}
