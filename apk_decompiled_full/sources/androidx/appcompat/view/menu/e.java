package androidx.appcompat.view.menu;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import androidx.appcompat.R$layout;
import androidx.appcompat.view.menu.m;
import androidx.appcompat.view.menu.n;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class e implements m, AdapterView.OnItemClickListener {

    /* renamed from: a, reason: collision with root package name */
    public Context f1175a;

    /* renamed from: b, reason: collision with root package name */
    public LayoutInflater f1176b;

    /* renamed from: c, reason: collision with root package name */
    public g f1177c;

    /* renamed from: d, reason: collision with root package name */
    public ExpandedMenuView f1178d;

    /* renamed from: e, reason: collision with root package name */
    public int f1179e;

    /* renamed from: f, reason: collision with root package name */
    public int f1180f;

    /* renamed from: g, reason: collision with root package name */
    public int f1181g;

    /* renamed from: h, reason: collision with root package name */
    public m.a f1182h;

    /* renamed from: i, reason: collision with root package name */
    public a f1183i;

    /* renamed from: j, reason: collision with root package name */
    public int f1184j;

    public class a extends BaseAdapter {

        /* renamed from: a, reason: collision with root package name */
        public int f1185a = -1;

        public a() {
            a();
        }

        public void a() {
            i expandedItem = e.this.f1177c.getExpandedItem();
            if (expandedItem != null) {
                ArrayList<i> nonActionItems = e.this.f1177c.getNonActionItems();
                int size = nonActionItems.size();
                for (int i10 = 0; i10 < size; i10++) {
                    if (nonActionItems.get(i10) == expandedItem) {
                        this.f1185a = i10;
                        return;
                    }
                }
            }
            this.f1185a = -1;
        }

        @Override // android.widget.Adapter
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public i getItem(int i10) {
            ArrayList<i> nonActionItems = e.this.f1177c.getNonActionItems();
            int i11 = i10 + e.this.f1179e;
            int i12 = this.f1185a;
            if (i12 >= 0 && i11 >= i12) {
                i11++;
            }
            return nonActionItems.get(i11);
        }

        @Override // android.widget.Adapter
        public int getCount() {
            int size = e.this.f1177c.getNonActionItems().size() - e.this.f1179e;
            return this.f1185a < 0 ? size : size - 1;
        }

        @Override // android.widget.Adapter
        public long getItemId(int i10) {
            return i10;
        }

        @Override // android.widget.Adapter
        public View getView(int i10, View view, ViewGroup viewGroup) {
            if (view == null) {
                e eVar = e.this;
                view = eVar.f1176b.inflate(eVar.f1181g, viewGroup, false);
            }
            ((n.a) view).initialize(getItem(i10), 0);
            return view;
        }

        @Override // android.widget.BaseAdapter
        public void notifyDataSetChanged() {
            a();
            super.notifyDataSetChanged();
        }
    }

    public e(Context context, int i10) {
        this(i10, 0);
        this.f1175a = context;
        this.f1176b = LayoutInflater.from(context);
    }

    public ListAdapter a() {
        if (this.f1183i == null) {
            this.f1183i = new a();
        }
        return this.f1183i;
    }

    public n b(ViewGroup viewGroup) {
        if (this.f1178d == null) {
            this.f1178d = (ExpandedMenuView) this.f1176b.inflate(R$layout.abc_expanded_menu_layout, viewGroup, false);
            if (this.f1183i == null) {
                this.f1183i = new a();
            }
            this.f1178d.setAdapter((ListAdapter) this.f1183i);
            this.f1178d.setOnItemClickListener(this);
        }
        return this.f1178d;
    }

    public void c(Bundle bundle) {
        SparseArray<Parcelable> sparseParcelableArray = bundle.getSparseParcelableArray("android:menu:list");
        if (sparseParcelableArray != null) {
            this.f1178d.restoreHierarchyState(sparseParcelableArray);
        }
    }

    @Override // androidx.appcompat.view.menu.m
    public boolean collapseItemActionView(g gVar, i iVar) {
        return false;
    }

    public void d(Bundle bundle) {
        SparseArray<Parcelable> sparseArray = new SparseArray<>();
        ExpandedMenuView expandedMenuView = this.f1178d;
        if (expandedMenuView != null) {
            expandedMenuView.saveHierarchyState(sparseArray);
        }
        bundle.putSparseParcelableArray("android:menu:list", sparseArray);
    }

    @Override // androidx.appcompat.view.menu.m
    public boolean expandItemActionView(g gVar, i iVar) {
        return false;
    }

    @Override // androidx.appcompat.view.menu.m
    public boolean flagActionItems() {
        return false;
    }

    @Override // androidx.appcompat.view.menu.m
    public int getId() {
        return this.f1184j;
    }

    @Override // androidx.appcompat.view.menu.m
    public void initForMenu(Context context, g gVar) {
        if (this.f1180f != 0) {
            ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(context, this.f1180f);
            this.f1175a = contextThemeWrapper;
            this.f1176b = LayoutInflater.from(contextThemeWrapper);
        } else if (this.f1175a != null) {
            this.f1175a = context;
            if (this.f1176b == null) {
                this.f1176b = LayoutInflater.from(context);
            }
        }
        this.f1177c = gVar;
        a aVar = this.f1183i;
        if (aVar != null) {
            aVar.notifyDataSetChanged();
        }
    }

    @Override // androidx.appcompat.view.menu.m
    public void onCloseMenu(g gVar, boolean z10) {
        m.a aVar = this.f1182h;
        if (aVar != null) {
            aVar.onCloseMenu(gVar, z10);
        }
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView adapterView, View view, int i10, long j10) {
        this.f1177c.performItemAction(this.f1183i.getItem(i10), this, 0);
    }

    @Override // androidx.appcompat.view.menu.m
    public void onRestoreInstanceState(Parcelable parcelable) {
        c((Bundle) parcelable);
    }

    @Override // androidx.appcompat.view.menu.m
    public Parcelable onSaveInstanceState() {
        if (this.f1178d == null) {
            return null;
        }
        Bundle bundle = new Bundle();
        d(bundle);
        return bundle;
    }

    @Override // androidx.appcompat.view.menu.m
    public boolean onSubMenuSelected(r rVar) {
        if (!rVar.hasVisibleItems()) {
            return false;
        }
        new h(rVar).c(null);
        m.a aVar = this.f1182h;
        if (aVar == null) {
            return true;
        }
        aVar.a(rVar);
        return true;
    }

    @Override // androidx.appcompat.view.menu.m
    public void setCallback(m.a aVar) {
        this.f1182h = aVar;
    }

    @Override // androidx.appcompat.view.menu.m
    public void updateMenuView(boolean z10) {
        a aVar = this.f1183i;
        if (aVar != null) {
            aVar.notifyDataSetChanged();
        }
    }

    public e(int i10, int i11) {
        this.f1181g = i10;
        this.f1180f = i11;
    }
}
