package g;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

/* loaded from: classes.dex */
public abstract class b {

    /* renamed from: a, reason: collision with root package name */
    public Object f13420a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f13421b;

    public interface a {
        boolean a(b bVar, MenuItem menuItem);

        void b(b bVar);

        boolean c(b bVar, Menu menu);

        boolean d(b bVar, Menu menu);
    }

    public abstract void a();

    public abstract View b();

    public abstract Menu c();

    public abstract MenuInflater d();

    public abstract CharSequence e();

    public Object f() {
        return this.f13420a;
    }

    public abstract CharSequence g();

    public boolean h() {
        return this.f13421b;
    }

    public abstract void i();

    public abstract boolean j();

    public abstract void k(View view);

    public abstract void l(int i10);

    public abstract void m(CharSequence charSequence);

    public void n(Object obj) {
        this.f13420a = obj;
    }

    public abstract void o(int i10);

    public abstract void p(CharSequence charSequence);

    public void q(boolean z10) {
        this.f13421b = z10;
    }
}
