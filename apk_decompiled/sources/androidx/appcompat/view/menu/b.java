package androidx.appcompat.view.menu;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.view.menu.m;
import androidx.appcompat.view.menu.n;
import java.util.ArrayList;

/* loaded from: classes.dex */
public abstract class b implements m {

    /* renamed from: a, reason: collision with root package name */
    public Context f1127a;

    /* renamed from: b, reason: collision with root package name */
    public Context f1128b;

    /* renamed from: c, reason: collision with root package name */
    public g f1129c;

    /* renamed from: d, reason: collision with root package name */
    public LayoutInflater f1130d;

    /* renamed from: e, reason: collision with root package name */
    public LayoutInflater f1131e;

    /* renamed from: f, reason: collision with root package name */
    public m.a f1132f;

    /* renamed from: g, reason: collision with root package name */
    public int f1133g;

    /* renamed from: h, reason: collision with root package name */
    public int f1134h;

    /* renamed from: i, reason: collision with root package name */
    public n f1135i;

    /* renamed from: j, reason: collision with root package name */
    public int f1136j;

    public b(Context context, int i10, int i11) {
        this.f1127a = context;
        this.f1130d = LayoutInflater.from(context);
        this.f1133g = i10;
        this.f1134h = i11;
    }

    public void a(View view, int i10) {
        ViewGroup viewGroup = (ViewGroup) view.getParent();
        if (viewGroup != null) {
            viewGroup.removeView(view);
        }
        ((ViewGroup) this.f1135i).addView(view, i10);
    }

    public abstract void b(i iVar, n.a aVar);

    public n.a c(ViewGroup viewGroup) {
        return (n.a) this.f1130d.inflate(this.f1134h, viewGroup, false);
    }

    @Override // androidx.appcompat.view.menu.m
    public boolean collapseItemActionView(g gVar, i iVar) {
        return false;
    }

    public boolean d(ViewGroup viewGroup, int i10) {
        viewGroup.removeViewAt(i10);
        return true;
    }

    public m.a e() {
        return this.f1132f;
    }

    @Override // androidx.appcompat.view.menu.m
    public boolean expandItemActionView(g gVar, i iVar) {
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public View f(i iVar, View view, ViewGroup viewGroup) {
        n.a c10 = view instanceof n.a ? (n.a) view : c(viewGroup);
        b(iVar, c10);
        return (View) c10;
    }

    public n g(ViewGroup viewGroup) {
        if (this.f1135i == null) {
            n nVar = (n) this.f1130d.inflate(this.f1133g, viewGroup, false);
            this.f1135i = nVar;
            nVar.initialize(this.f1129c);
            updateMenuView(true);
        }
        return this.f1135i;
    }

    @Override // androidx.appcompat.view.menu.m
    public int getId() {
        return this.f1136j;
    }

    public void h(int i10) {
        this.f1136j = i10;
    }

    public abstract boolean i(int i10, i iVar);

    @Override // androidx.appcompat.view.menu.m
    public void initForMenu(Context context, g gVar) {
        this.f1128b = context;
        this.f1131e = LayoutInflater.from(context);
        this.f1129c = gVar;
    }

    @Override // androidx.appcompat.view.menu.m
    public void onCloseMenu(g gVar, boolean z10) {
        m.a aVar = this.f1132f;
        if (aVar != null) {
            aVar.onCloseMenu(gVar, z10);
        }
    }

    @Override // androidx.appcompat.view.menu.m
    public boolean onSubMenuSelected(r rVar) {
        m.a aVar = this.f1132f;
        if (aVar != null) {
            return aVar.a(rVar);
        }
        return false;
    }

    @Override // androidx.appcompat.view.menu.m
    public void setCallback(m.a aVar) {
        this.f1132f = aVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.appcompat.view.menu.m
    public void updateMenuView(boolean z10) {
        ViewGroup viewGroup = (ViewGroup) this.f1135i;
        if (viewGroup == null) {
            return;
        }
        g gVar = this.f1129c;
        int i10 = 0;
        if (gVar != null) {
            gVar.flagActionItems();
            ArrayList<i> visibleItems = this.f1129c.getVisibleItems();
            int size = visibleItems.size();
            int i11 = 0;
            for (int i12 = 0; i12 < size; i12++) {
                i iVar = visibleItems.get(i12);
                if (i(i11, iVar)) {
                    View childAt = viewGroup.getChildAt(i11);
                    i itemData = childAt instanceof n.a ? ((n.a) childAt).getItemData() : null;
                    View f10 = f(iVar, childAt, viewGroup);
                    if (iVar != itemData) {
                        f10.setPressed(false);
                        f10.jumpDrawablesToCurrentState();
                    }
                    if (f10 != childAt) {
                        a(f10, i11);
                    }
                    i11++;
                }
            }
            i10 = i11;
        }
        while (i10 < viewGroup.getChildCount()) {
            if (!d(viewGroup, i10)) {
                i10++;
            }
        }
    }
}
