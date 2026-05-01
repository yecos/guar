package g;

import android.content.Context;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.view.menu.g;
import androidx.appcompat.widget.ActionBarContextView;
import g.b;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
public class e extends b implements g.a {

    /* renamed from: c, reason: collision with root package name */
    public Context f13427c;

    /* renamed from: d, reason: collision with root package name */
    public ActionBarContextView f13428d;

    /* renamed from: e, reason: collision with root package name */
    public b.a f13429e;

    /* renamed from: f, reason: collision with root package name */
    public WeakReference f13430f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f13431g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f13432h;

    /* renamed from: i, reason: collision with root package name */
    public androidx.appcompat.view.menu.g f13433i;

    public e(Context context, ActionBarContextView actionBarContextView, b.a aVar, boolean z10) {
        this.f13427c = context;
        this.f13428d = actionBarContextView;
        this.f13429e = aVar;
        androidx.appcompat.view.menu.g defaultShowAsAction = new androidx.appcompat.view.menu.g(actionBarContextView.getContext()).setDefaultShowAsAction(1);
        this.f13433i = defaultShowAsAction;
        defaultShowAsAction.setCallback(this);
        this.f13432h = z10;
    }

    @Override // g.b
    public void a() {
        if (this.f13431g) {
            return;
        }
        this.f13431g = true;
        this.f13428d.sendAccessibilityEvent(32);
        this.f13429e.b(this);
    }

    @Override // g.b
    public View b() {
        WeakReference weakReference = this.f13430f;
        if (weakReference != null) {
            return (View) weakReference.get();
        }
        return null;
    }

    @Override // g.b
    public Menu c() {
        return this.f13433i;
    }

    @Override // g.b
    public MenuInflater d() {
        return new g(this.f13428d.getContext());
    }

    @Override // g.b
    public CharSequence e() {
        return this.f13428d.getSubtitle();
    }

    @Override // g.b
    public CharSequence g() {
        return this.f13428d.getTitle();
    }

    @Override // g.b
    public void i() {
        this.f13429e.c(this, this.f13433i);
    }

    @Override // g.b
    public boolean j() {
        return this.f13428d.j();
    }

    @Override // g.b
    public void k(View view) {
        this.f13428d.setCustomView(view);
        this.f13430f = view != null ? new WeakReference(view) : null;
    }

    @Override // g.b
    public void l(int i10) {
        m(this.f13427c.getString(i10));
    }

    @Override // g.b
    public void m(CharSequence charSequence) {
        this.f13428d.setSubtitle(charSequence);
    }

    @Override // g.b
    public void o(int i10) {
        p(this.f13427c.getString(i10));
    }

    @Override // androidx.appcompat.view.menu.g.a
    public boolean onMenuItemSelected(androidx.appcompat.view.menu.g gVar, MenuItem menuItem) {
        return this.f13429e.a(this, menuItem);
    }

    @Override // androidx.appcompat.view.menu.g.a
    public void onMenuModeChange(androidx.appcompat.view.menu.g gVar) {
        i();
        this.f13428d.l();
    }

    @Override // g.b
    public void p(CharSequence charSequence) {
        this.f13428d.setTitle(charSequence);
    }

    @Override // g.b
    public void q(boolean z10) {
        super.q(z10);
        this.f13428d.setTitleOptional(z10);
    }
}
