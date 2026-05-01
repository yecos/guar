package androidx.appcompat.app;

import android.content.Context;
import android.content.res.Configuration;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import androidx.appcompat.view.menu.g;
import androidx.appcompat.view.menu.m;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.i1;
import androidx.appcompat.widget.s2;
import b0.c1;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class n extends androidx.appcompat.app.a {

    /* renamed from: a, reason: collision with root package name */
    public i1 f1000a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f1001b;

    /* renamed from: c, reason: collision with root package name */
    public Window.Callback f1002c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f1003d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f1004e;

    /* renamed from: f, reason: collision with root package name */
    public ArrayList f1005f = new ArrayList();

    /* renamed from: g, reason: collision with root package name */
    public final Runnable f1006g = new a();

    /* renamed from: h, reason: collision with root package name */
    public final Toolbar.f f1007h;

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            n.this.B();
        }
    }

    public class b implements Toolbar.f {
        public b() {
        }

        @Override // androidx.appcompat.widget.Toolbar.f
        public boolean onMenuItemClick(MenuItem menuItem) {
            return n.this.f1002c.onMenuItemSelected(0, menuItem);
        }
    }

    public final class c implements m.a {

        /* renamed from: a, reason: collision with root package name */
        public boolean f1010a;

        public c() {
        }

        @Override // androidx.appcompat.view.menu.m.a
        public boolean a(androidx.appcompat.view.menu.g gVar) {
            Window.Callback callback = n.this.f1002c;
            if (callback == null) {
                return false;
            }
            callback.onMenuOpened(108, gVar);
            return true;
        }

        @Override // androidx.appcompat.view.menu.m.a
        public void onCloseMenu(androidx.appcompat.view.menu.g gVar, boolean z10) {
            if (this.f1010a) {
                return;
            }
            this.f1010a = true;
            n.this.f1000a.r();
            Window.Callback callback = n.this.f1002c;
            if (callback != null) {
                callback.onPanelClosed(108, gVar);
            }
            this.f1010a = false;
        }
    }

    public final class d implements g.a {
        public d() {
        }

        @Override // androidx.appcompat.view.menu.g.a
        public boolean onMenuItemSelected(androidx.appcompat.view.menu.g gVar, MenuItem menuItem) {
            return false;
        }

        @Override // androidx.appcompat.view.menu.g.a
        public void onMenuModeChange(androidx.appcompat.view.menu.g gVar) {
            n nVar = n.this;
            if (nVar.f1002c != null) {
                if (nVar.f1000a.e()) {
                    n.this.f1002c.onPanelClosed(108, gVar);
                } else if (n.this.f1002c.onPreparePanel(0, null, gVar)) {
                    n.this.f1002c.onMenuOpened(108, gVar);
                }
            }
        }
    }

    public class e extends g.m {
        public e(Window.Callback callback) {
            super(callback);
        }

        @Override // g.m, android.view.Window.Callback
        public View onCreatePanelView(int i10) {
            return i10 == 0 ? new View(n.this.f1000a.getContext()) : super.onCreatePanelView(i10);
        }

        @Override // g.m, android.view.Window.Callback
        public boolean onPreparePanel(int i10, View view, Menu menu) {
            boolean onPreparePanel = super.onPreparePanel(i10, view, menu);
            if (onPreparePanel) {
                n nVar = n.this;
                if (!nVar.f1001b) {
                    nVar.f1000a.f();
                    n.this.f1001b = true;
                }
            }
            return onPreparePanel;
        }
    }

    public n(Toolbar toolbar, CharSequence charSequence, Window.Callback callback) {
        b bVar = new b();
        this.f1007h = bVar;
        this.f1000a = new s2(toolbar, false);
        e eVar = new e(callback);
        this.f1002c = eVar;
        this.f1000a.setWindowCallback(eVar);
        toolbar.setOnMenuItemClickListener(bVar);
        this.f1000a.setWindowTitle(charSequence);
    }

    public Window.Callback A() {
        return this.f1002c;
    }

    public void B() {
        Menu z10 = z();
        androidx.appcompat.view.menu.g gVar = z10 instanceof androidx.appcompat.view.menu.g ? (androidx.appcompat.view.menu.g) z10 : null;
        if (gVar != null) {
            gVar.stopDispatchingItemsChanged();
        }
        try {
            z10.clear();
            if (!this.f1002c.onCreatePanelMenu(0, z10) || !this.f1002c.onPreparePanel(0, null, z10)) {
                z10.clear();
            }
        } finally {
            if (gVar != null) {
                gVar.startDispatchingItemsChanged();
            }
        }
    }

    public void C(int i10, int i11) {
        this.f1000a.i((i10 & i11) | ((i11 ^ (-1)) & this.f1000a.x()));
    }

    @Override // androidx.appcompat.app.a
    public boolean g() {
        return this.f1000a.b();
    }

    @Override // androidx.appcompat.app.a
    public boolean h() {
        if (!this.f1000a.h()) {
            return false;
        }
        this.f1000a.collapseActionView();
        return true;
    }

    @Override // androidx.appcompat.app.a
    public void i(boolean z10) {
        if (z10 == this.f1004e) {
            return;
        }
        this.f1004e = z10;
        if (this.f1005f.size() <= 0) {
            return;
        }
        m.a(this.f1005f.get(0));
        throw null;
    }

    @Override // androidx.appcompat.app.a
    public int j() {
        return this.f1000a.x();
    }

    @Override // androidx.appcompat.app.a
    public Context k() {
        return this.f1000a.getContext();
    }

    @Override // androidx.appcompat.app.a
    public boolean l() {
        this.f1000a.n().removeCallbacks(this.f1006g);
        c1.c0(this.f1000a.n(), this.f1006g);
        return true;
    }

    @Override // androidx.appcompat.app.a
    public void m(Configuration configuration) {
        super.m(configuration);
    }

    @Override // androidx.appcompat.app.a
    public void n() {
        this.f1000a.n().removeCallbacks(this.f1006g);
    }

    @Override // androidx.appcompat.app.a
    public boolean o(int i10, KeyEvent keyEvent) {
        Menu z10 = z();
        if (z10 == null) {
            return false;
        }
        z10.setQwertyMode(KeyCharacterMap.load(keyEvent != null ? keyEvent.getDeviceId() : -1).getKeyboardType() != 1);
        return z10.performShortcut(i10, keyEvent, 0);
    }

    @Override // androidx.appcompat.app.a
    public boolean p(KeyEvent keyEvent) {
        if (keyEvent.getAction() == 1) {
            q();
        }
        return true;
    }

    @Override // androidx.appcompat.app.a
    public boolean q() {
        return this.f1000a.c();
    }

    @Override // androidx.appcompat.app.a
    public void r(boolean z10) {
    }

    @Override // androidx.appcompat.app.a
    public void s(boolean z10) {
        C(z10 ? 4 : 0, 4);
    }

    @Override // androidx.appcompat.app.a
    public void t(int i10) {
        this.f1000a.u(i10);
    }

    @Override // androidx.appcompat.app.a
    public void u(boolean z10) {
    }

    @Override // androidx.appcompat.app.a
    public void v(CharSequence charSequence) {
        this.f1000a.j(charSequence);
    }

    @Override // androidx.appcompat.app.a
    public void w(CharSequence charSequence) {
        this.f1000a.setTitle(charSequence);
    }

    @Override // androidx.appcompat.app.a
    public void x(CharSequence charSequence) {
        this.f1000a.setWindowTitle(charSequence);
    }

    public final Menu z() {
        if (!this.f1003d) {
            this.f1000a.v(new c(), new d());
            this.f1003d = true;
        }
        return this.f1000a.k();
    }
}
