package g;

import android.content.Context;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.view.menu.o;
import g.b;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class f extends ActionMode {

    /* renamed from: a, reason: collision with root package name */
    public final Context f13434a;

    /* renamed from: b, reason: collision with root package name */
    public final b f13435b;

    public static class a implements b.a {

        /* renamed from: a, reason: collision with root package name */
        public final ActionMode.Callback f13436a;

        /* renamed from: b, reason: collision with root package name */
        public final Context f13437b;

        /* renamed from: c, reason: collision with root package name */
        public final ArrayList f13438c = new ArrayList();

        /* renamed from: d, reason: collision with root package name */
        public final androidx.collection.g f13439d = new androidx.collection.g();

        public a(Context context, ActionMode.Callback callback) {
            this.f13437b = context;
            this.f13436a = callback;
        }

        @Override // g.b.a
        public boolean a(b bVar, MenuItem menuItem) {
            return this.f13436a.onActionItemClicked(e(bVar), new androidx.appcompat.view.menu.j(this.f13437b, (u.b) menuItem));
        }

        @Override // g.b.a
        public void b(b bVar) {
            this.f13436a.onDestroyActionMode(e(bVar));
        }

        @Override // g.b.a
        public boolean c(b bVar, Menu menu) {
            return this.f13436a.onPrepareActionMode(e(bVar), f(menu));
        }

        @Override // g.b.a
        public boolean d(b bVar, Menu menu) {
            return this.f13436a.onCreateActionMode(e(bVar), f(menu));
        }

        public ActionMode e(b bVar) {
            int size = this.f13438c.size();
            for (int i10 = 0; i10 < size; i10++) {
                f fVar = (f) this.f13438c.get(i10);
                if (fVar != null && fVar.f13435b == bVar) {
                    return fVar;
                }
            }
            f fVar2 = new f(this.f13437b, bVar);
            this.f13438c.add(fVar2);
            return fVar2;
        }

        public final Menu f(Menu menu) {
            Menu menu2 = (Menu) this.f13439d.get(menu);
            if (menu2 != null) {
                return menu2;
            }
            o oVar = new o(this.f13437b, (u.a) menu);
            this.f13439d.put(menu, oVar);
            return oVar;
        }
    }

    public f(Context context, b bVar) {
        this.f13434a = context;
        this.f13435b = bVar;
    }

    @Override // android.view.ActionMode
    public void finish() {
        this.f13435b.a();
    }

    @Override // android.view.ActionMode
    public View getCustomView() {
        return this.f13435b.b();
    }

    @Override // android.view.ActionMode
    public Menu getMenu() {
        return new o(this.f13434a, (u.a) this.f13435b.c());
    }

    @Override // android.view.ActionMode
    public MenuInflater getMenuInflater() {
        return this.f13435b.d();
    }

    @Override // android.view.ActionMode
    public CharSequence getSubtitle() {
        return this.f13435b.e();
    }

    @Override // android.view.ActionMode
    public Object getTag() {
        return this.f13435b.f();
    }

    @Override // android.view.ActionMode
    public CharSequence getTitle() {
        return this.f13435b.g();
    }

    @Override // android.view.ActionMode
    public boolean getTitleOptionalHint() {
        return this.f13435b.h();
    }

    @Override // android.view.ActionMode
    public void invalidate() {
        this.f13435b.i();
    }

    @Override // android.view.ActionMode
    public boolean isTitleOptional() {
        return this.f13435b.j();
    }

    @Override // android.view.ActionMode
    public void setCustomView(View view) {
        this.f13435b.k(view);
    }

    @Override // android.view.ActionMode
    public void setSubtitle(CharSequence charSequence) {
        this.f13435b.m(charSequence);
    }

    @Override // android.view.ActionMode
    public void setTag(Object obj) {
        this.f13435b.n(obj);
    }

    @Override // android.view.ActionMode
    public void setTitle(CharSequence charSequence) {
        this.f13435b.p(charSequence);
    }

    @Override // android.view.ActionMode
    public void setTitleOptionalHint(boolean z10) {
        this.f13435b.q(z10);
    }

    @Override // android.view.ActionMode
    public void setSubtitle(int i10) {
        this.f13435b.l(i10);
    }

    @Override // android.view.ActionMode
    public void setTitle(int i10) {
        this.f13435b.o(i10);
    }
}
