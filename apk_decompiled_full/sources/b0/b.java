package b0;

import android.content.Context;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

/* loaded from: classes.dex */
public abstract class b {

    /* renamed from: a, reason: collision with root package name */
    public final Context f4306a;

    /* renamed from: b, reason: collision with root package name */
    public a f4307b;

    /* renamed from: c, reason: collision with root package name */
    public InterfaceC0069b f4308c;

    public interface a {
    }

    /* renamed from: b0.b$b, reason: collision with other inner class name */
    public interface InterfaceC0069b {
        void onActionProviderVisibilityChanged(boolean z10);
    }

    public b(Context context) {
        this.f4306a = context;
    }

    public Context a() {
        return this.f4306a;
    }

    public boolean b() {
        return false;
    }

    public abstract boolean c();

    public abstract View d();

    public View e(MenuItem menuItem) {
        return d();
    }

    public abstract boolean f();

    public void g(SubMenu subMenu) {
    }

    public abstract boolean h();

    public void i() {
        if (this.f4308c == null || !h()) {
            return;
        }
        this.f4308c.onActionProviderVisibilityChanged(c());
    }

    public void j() {
        this.f4308c = null;
        this.f4307b = null;
    }

    public void k(a aVar) {
        this.f4307b = aVar;
    }

    public void l(InterfaceC0069b interfaceC0069b) {
        if (this.f4308c != null && interfaceC0069b != null) {
            StringBuilder sb = new StringBuilder();
            sb.append("setVisibilityListener: Setting a new ActionProvider.VisibilityListener when one is already set. Are you reusing this ");
            sb.append(getClass().getSimpleName());
            sb.append(" instance while it is still in use somewhere else?");
        }
        this.f4308c = interfaceC0069b;
    }
}
