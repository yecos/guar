package androidx.appcompat.view.menu;

import android.R;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import androidx.appcompat.view.menu.g;
import androidx.appcompat.widget.r2;

/* loaded from: classes.dex */
public final class ExpandedMenuView extends ListView implements g.b, n, AdapterView.OnItemClickListener {

    /* renamed from: c, reason: collision with root package name */
    public static final int[] f1084c = {R.attr.background, R.attr.divider};

    /* renamed from: a, reason: collision with root package name */
    public g f1085a;

    /* renamed from: b, reason: collision with root package name */
    public int f1086b;

    public ExpandedMenuView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.listViewStyle);
    }

    @Override // androidx.appcompat.view.menu.g.b
    public boolean b(i iVar) {
        return this.f1085a.performItemAction(iVar, 0);
    }

    public int getWindowAnimations() {
        return this.f1086b;
    }

    @Override // androidx.appcompat.view.menu.n
    public void initialize(g gVar) {
        this.f1085a = gVar;
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        setChildrenDrawingCacheEnabled(false);
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView adapterView, View view, int i10, long j10) {
        b((i) getAdapter().getItem(i10));
    }

    public ExpandedMenuView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet);
        setOnItemClickListener(this);
        r2 u10 = r2.u(context, attributeSet, f1084c, i10, 0);
        if (u10.r(0)) {
            setBackgroundDrawable(u10.g(0));
        }
        if (u10.r(1)) {
            setDivider(u10.g(1));
        }
        u10.v();
    }
}
