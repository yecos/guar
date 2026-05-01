package androidx.appcompat.view.menu;

import android.content.Context;
import android.view.MenuItem;
import android.view.SubMenu;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes.dex */
public abstract class c {

    /* renamed from: a, reason: collision with root package name */
    public final Context f1137a;

    /* renamed from: b, reason: collision with root package name */
    public Map f1138b;

    /* renamed from: c, reason: collision with root package name */
    public Map f1139c;

    public c(Context context) {
        this.f1137a = context;
    }

    public final MenuItem c(MenuItem menuItem) {
        if (!(menuItem instanceof u.b)) {
            return menuItem;
        }
        u.b bVar = (u.b) menuItem;
        if (this.f1138b == null) {
            this.f1138b = new androidx.collection.a();
        }
        MenuItem menuItem2 = (MenuItem) this.f1138b.get(menuItem);
        if (menuItem2 != null) {
            return menuItem2;
        }
        j jVar = new j(this.f1137a, bVar);
        this.f1138b.put(bVar, jVar);
        return jVar;
    }

    public final SubMenu d(SubMenu subMenu) {
        return subMenu;
    }

    public final void e() {
        Map map = this.f1138b;
        if (map != null) {
            map.clear();
        }
        Map map2 = this.f1139c;
        if (map2 != null) {
            map2.clear();
        }
    }

    public final void f(int i10) {
        Map map = this.f1138b;
        if (map == null) {
            return;
        }
        Iterator it = map.keySet().iterator();
        while (it.hasNext()) {
            if (i10 == ((MenuItem) it.next()).getGroupId()) {
                it.remove();
            }
        }
    }

    public final void g(int i10) {
        Map map = this.f1138b;
        if (map == null) {
            return;
        }
        Iterator it = map.keySet().iterator();
        while (it.hasNext()) {
            if (i10 == ((MenuItem) it.next()).getItemId()) {
                it.remove();
                return;
            }
        }
    }
}
