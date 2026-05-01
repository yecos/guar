package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.SparseBooleanArray;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.R$attr;
import androidx.appcompat.R$layout;
import androidx.appcompat.view.menu.ActionMenuItemView;
import androidx.appcompat.view.menu.m;
import androidx.appcompat.view.menu.n;
import androidx.appcompat.widget.ActionMenuView;
import b0.b;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class d extends androidx.appcompat.view.menu.b implements b.a {
    public c A;
    public b B;
    public final f C;
    public int D;

    /* renamed from: k, reason: collision with root package name */
    public C0019d f1437k;

    /* renamed from: l, reason: collision with root package name */
    public Drawable f1438l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f1439m;

    /* renamed from: n, reason: collision with root package name */
    public boolean f1440n;

    /* renamed from: o, reason: collision with root package name */
    public boolean f1441o;

    /* renamed from: p, reason: collision with root package name */
    public int f1442p;

    /* renamed from: q, reason: collision with root package name */
    public int f1443q;

    /* renamed from: r, reason: collision with root package name */
    public int f1444r;

    /* renamed from: s, reason: collision with root package name */
    public boolean f1445s;

    /* renamed from: t, reason: collision with root package name */
    public boolean f1446t;

    /* renamed from: u, reason: collision with root package name */
    public boolean f1447u;

    /* renamed from: v, reason: collision with root package name */
    public boolean f1448v;

    /* renamed from: w, reason: collision with root package name */
    public int f1449w;

    /* renamed from: x, reason: collision with root package name */
    public final SparseBooleanArray f1450x;

    /* renamed from: y, reason: collision with root package name */
    public e f1451y;

    /* renamed from: z, reason: collision with root package name */
    public a f1452z;

    public class a extends androidx.appcompat.view.menu.l {
        public a(Context context, androidx.appcompat.view.menu.r rVar, View view) {
            super(context, rVar, view, false, R$attr.actionOverflowMenuStyle);
            if (!((androidx.appcompat.view.menu.i) rVar.getItem()).l()) {
                View view2 = d.this.f1437k;
                f(view2 == null ? (View) d.this.f1135i : view2);
            }
            j(d.this.C);
        }

        @Override // androidx.appcompat.view.menu.l
        public void e() {
            d dVar = d.this;
            dVar.f1452z = null;
            dVar.D = 0;
            super.e();
        }
    }

    public class b extends ActionMenuItemView.b {
        public b() {
        }

        @Override // androidx.appcompat.view.menu.ActionMenuItemView.b
        public androidx.appcompat.view.menu.p a() {
            a aVar = d.this.f1452z;
            if (aVar != null) {
                return aVar.c();
            }
            return null;
        }
    }

    public class c implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public e f1455a;

        public c(e eVar) {
            this.f1455a = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.f1129c != null) {
                d.this.f1129c.changeMenuMode();
            }
            View view = (View) d.this.f1135i;
            if (view != null && view.getWindowToken() != null && this.f1455a.m()) {
                d.this.f1451y = this.f1455a;
            }
            d.this.A = null;
        }
    }

    /* renamed from: androidx.appcompat.widget.d$d, reason: collision with other inner class name */
    public class C0019d extends q implements ActionMenuView.a {

        /* renamed from: a, reason: collision with root package name */
        public final float[] f1457a;

        /* renamed from: androidx.appcompat.widget.d$d$a */
        public class a extends t1 {

            /* renamed from: j, reason: collision with root package name */
            public final /* synthetic */ d f1459j;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(View view, d dVar) {
                super(view);
                this.f1459j = dVar;
            }

            @Override // androidx.appcompat.widget.t1
            public androidx.appcompat.view.menu.p b() {
                e eVar = d.this.f1451y;
                if (eVar == null) {
                    return null;
                }
                return eVar.c();
            }

            @Override // androidx.appcompat.widget.t1
            public boolean c() {
                d.this.B();
                return true;
            }

            @Override // androidx.appcompat.widget.t1
            public boolean d() {
                d dVar = d.this;
                if (dVar.A != null) {
                    return false;
                }
                dVar.s();
                return true;
            }
        }

        public C0019d(Context context) {
            super(context, null, R$attr.actionOverflowButtonStyle);
            this.f1457a = new float[2];
            setClickable(true);
            setFocusable(true);
            setVisibility(0);
            setEnabled(true);
            u2.a(this, getContentDescription());
            setOnTouchListener(new a(this, d.this));
        }

        @Override // androidx.appcompat.widget.ActionMenuView.a
        public boolean a() {
            return false;
        }

        @Override // androidx.appcompat.widget.ActionMenuView.a
        public boolean b() {
            return false;
        }

        @Override // android.view.View
        public boolean performClick() {
            if (super.performClick()) {
                return true;
            }
            playSoundEffect(0);
            d.this.B();
            return true;
        }

        @Override // android.widget.ImageView
        public boolean setFrame(int i10, int i11, int i12, int i13) {
            boolean frame = super.setFrame(i10, i11, i12, i13);
            Drawable drawable = getDrawable();
            Drawable background = getBackground();
            if (drawable != null && background != null) {
                int width = getWidth();
                int height = getHeight();
                int max = Math.max(width, height) / 2;
                int paddingLeft = (width + (getPaddingLeft() - getPaddingRight())) / 2;
                int paddingTop = (height + (getPaddingTop() - getPaddingBottom())) / 2;
                s.h.l(background, paddingLeft - max, paddingTop - max, paddingLeft + max, paddingTop + max);
            }
            return frame;
        }
    }

    public class e extends androidx.appcompat.view.menu.l {
        public e(Context context, androidx.appcompat.view.menu.g gVar, View view, boolean z10) {
            super(context, gVar, view, z10, R$attr.actionOverflowMenuStyle);
            h(8388613);
            j(d.this.C);
        }

        @Override // androidx.appcompat.view.menu.l
        public void e() {
            if (d.this.f1129c != null) {
                d.this.f1129c.close();
            }
            d.this.f1451y = null;
            super.e();
        }
    }

    public class f implements m.a {
        public f() {
        }

        @Override // androidx.appcompat.view.menu.m.a
        public boolean a(androidx.appcompat.view.menu.g gVar) {
            if (gVar == null) {
                return false;
            }
            d.this.D = ((androidx.appcompat.view.menu.r) gVar).getItem().getItemId();
            m.a e10 = d.this.e();
            if (e10 != null) {
                return e10.a(gVar);
            }
            return false;
        }

        @Override // androidx.appcompat.view.menu.m.a
        public void onCloseMenu(androidx.appcompat.view.menu.g gVar, boolean z10) {
            if (gVar instanceof androidx.appcompat.view.menu.r) {
                gVar.getRootMenu().close(false);
            }
            m.a e10 = d.this.e();
            if (e10 != null) {
                e10.onCloseMenu(gVar, z10);
            }
        }
    }

    public static class g implements Parcelable {
        public static final Parcelable.Creator<g> CREATOR = new a();

        /* renamed from: a, reason: collision with root package name */
        public int f1463a;

        public static class a implements Parcelable.Creator {
            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public g createFromParcel(Parcel parcel) {
                return new g(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public g[] newArray(int i10) {
                return new g[i10];
            }
        }

        public g() {
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            parcel.writeInt(this.f1463a);
        }

        public g(Parcel parcel) {
            this.f1463a = parcel.readInt();
        }
    }

    public d(Context context) {
        super(context, R$layout.abc_action_menu_layout, R$layout.abc_action_menu_item_layout);
        this.f1450x = new SparseBooleanArray();
        this.C = new f();
    }

    public void A(boolean z10) {
        this.f1440n = z10;
        this.f1441o = true;
    }

    public boolean B() {
        androidx.appcompat.view.menu.g gVar;
        if (!this.f1440n || v() || (gVar = this.f1129c) == null || this.f1135i == null || this.A != null || gVar.getNonActionItems().isEmpty()) {
            return false;
        }
        c cVar = new c(new e(this.f1128b, this.f1129c, this.f1437k, true));
        this.A = cVar;
        ((View) this.f1135i).post(cVar);
        super.onSubMenuSelected(null);
        return true;
    }

    @Override // androidx.appcompat.view.menu.b
    public void b(androidx.appcompat.view.menu.i iVar, n.a aVar) {
        aVar.initialize(iVar, 0);
        ActionMenuItemView actionMenuItemView = (ActionMenuItemView) aVar;
        actionMenuItemView.setItemInvoker((ActionMenuView) this.f1135i);
        if (this.B == null) {
            this.B = new b();
        }
        actionMenuItemView.setPopupCallback(this.B);
    }

    @Override // androidx.appcompat.view.menu.b
    public boolean d(ViewGroup viewGroup, int i10) {
        if (viewGroup.getChildAt(i10) == this.f1437k) {
            return false;
        }
        return super.d(viewGroup, i10);
    }

    @Override // androidx.appcompat.view.menu.b
    public View f(androidx.appcompat.view.menu.i iVar, View view, ViewGroup viewGroup) {
        View actionView = iVar.getActionView();
        if (actionView == null || iVar.j()) {
            actionView = super.f(iVar, view, viewGroup);
        }
        actionView.setVisibility(iVar.isActionViewExpanded() ? 8 : 0);
        ActionMenuView actionMenuView = (ActionMenuView) viewGroup;
        ViewGroup.LayoutParams layoutParams = actionView.getLayoutParams();
        if (!actionMenuView.checkLayoutParams(layoutParams)) {
            actionView.setLayoutParams(actionMenuView.generateLayoutParams(layoutParams));
        }
        return actionView;
    }

    @Override // androidx.appcompat.view.menu.m
    public boolean flagActionItems() {
        ArrayList<androidx.appcompat.view.menu.i> arrayList;
        int i10;
        int i11;
        int i12;
        int i13;
        d dVar = this;
        androidx.appcompat.view.menu.g gVar = dVar.f1129c;
        View view = null;
        int i14 = 0;
        if (gVar != null) {
            arrayList = gVar.getVisibleItems();
            i10 = arrayList.size();
        } else {
            arrayList = null;
            i10 = 0;
        }
        int i15 = dVar.f1444r;
        int i16 = dVar.f1443q;
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        ViewGroup viewGroup = (ViewGroup) dVar.f1135i;
        boolean z10 = false;
        int i17 = 0;
        int i18 = 0;
        for (int i19 = 0; i19 < i10; i19++) {
            androidx.appcompat.view.menu.i iVar = arrayList.get(i19);
            if (iVar.o()) {
                i17++;
            } else if (iVar.n()) {
                i18++;
            } else {
                z10 = true;
            }
            if (dVar.f1448v && iVar.isActionViewExpanded()) {
                i15 = 0;
            }
        }
        if (dVar.f1440n && (z10 || i18 + i17 > i15)) {
            i15--;
        }
        int i20 = i15 - i17;
        SparseBooleanArray sparseBooleanArray = dVar.f1450x;
        sparseBooleanArray.clear();
        if (dVar.f1446t) {
            int i21 = dVar.f1449w;
            i12 = i16 / i21;
            i11 = i21 + ((i16 % i21) / i12);
        } else {
            i11 = 0;
            i12 = 0;
        }
        int i22 = 0;
        int i23 = 0;
        while (i22 < i10) {
            androidx.appcompat.view.menu.i iVar2 = arrayList.get(i22);
            if (iVar2.o()) {
                View f10 = dVar.f(iVar2, view, viewGroup);
                if (dVar.f1446t) {
                    i12 -= ActionMenuView.q(f10, i11, i12, makeMeasureSpec, i14);
                } else {
                    f10.measure(makeMeasureSpec, makeMeasureSpec);
                }
                int measuredWidth = f10.getMeasuredWidth();
                i16 -= measuredWidth;
                if (i23 == 0) {
                    i23 = measuredWidth;
                }
                int groupId = iVar2.getGroupId();
                if (groupId != 0) {
                    sparseBooleanArray.put(groupId, true);
                }
                iVar2.u(true);
                i13 = i10;
            } else if (iVar2.n()) {
                int groupId2 = iVar2.getGroupId();
                boolean z11 = sparseBooleanArray.get(groupId2);
                boolean z12 = (i20 > 0 || z11) && i16 > 0 && (!dVar.f1446t || i12 > 0);
                boolean z13 = z12;
                i13 = i10;
                if (z12) {
                    View f11 = dVar.f(iVar2, null, viewGroup);
                    if (dVar.f1446t) {
                        int q10 = ActionMenuView.q(f11, i11, i12, makeMeasureSpec, 0);
                        i12 -= q10;
                        if (q10 == 0) {
                            z13 = false;
                        }
                    } else {
                        f11.measure(makeMeasureSpec, makeMeasureSpec);
                    }
                    boolean z14 = z13;
                    int measuredWidth2 = f11.getMeasuredWidth();
                    i16 -= measuredWidth2;
                    if (i23 == 0) {
                        i23 = measuredWidth2;
                    }
                    z12 = z14 & (!dVar.f1446t ? i16 + i23 <= 0 : i16 < 0);
                }
                if (z12 && groupId2 != 0) {
                    sparseBooleanArray.put(groupId2, true);
                } else if (z11) {
                    sparseBooleanArray.put(groupId2, false);
                    for (int i24 = 0; i24 < i22; i24++) {
                        androidx.appcompat.view.menu.i iVar3 = arrayList.get(i24);
                        if (iVar3.getGroupId() == groupId2) {
                            if (iVar3.l()) {
                                i20++;
                            }
                            iVar3.u(false);
                        }
                    }
                }
                if (z12) {
                    i20--;
                }
                iVar2.u(z12);
            } else {
                i13 = i10;
                iVar2.u(false);
                i22++;
                view = null;
                dVar = this;
                i10 = i13;
                i14 = 0;
            }
            i22++;
            view = null;
            dVar = this;
            i10 = i13;
            i14 = 0;
        }
        return true;
    }

    @Override // androidx.appcompat.view.menu.b
    public androidx.appcompat.view.menu.n g(ViewGroup viewGroup) {
        androidx.appcompat.view.menu.n nVar = this.f1135i;
        androidx.appcompat.view.menu.n g10 = super.g(viewGroup);
        if (nVar != g10) {
            ((ActionMenuView) g10).setPresenter(this);
        }
        return g10;
    }

    @Override // androidx.appcompat.view.menu.b
    public boolean i(int i10, androidx.appcompat.view.menu.i iVar) {
        return iVar.l();
    }

    @Override // androidx.appcompat.view.menu.b, androidx.appcompat.view.menu.m
    public void initForMenu(Context context, androidx.appcompat.view.menu.g gVar) {
        super.initForMenu(context, gVar);
        Resources resources = context.getResources();
        g.a b10 = g.a.b(context);
        if (!this.f1441o) {
            this.f1440n = b10.f();
        }
        if (!this.f1447u) {
            this.f1442p = b10.c();
        }
        if (!this.f1445s) {
            this.f1444r = b10.d();
        }
        int i10 = this.f1442p;
        if (this.f1440n) {
            if (this.f1437k == null) {
                C0019d c0019d = new C0019d(this.f1127a);
                this.f1437k = c0019d;
                if (this.f1439m) {
                    c0019d.setImageDrawable(this.f1438l);
                    this.f1438l = null;
                    this.f1439m = false;
                }
                int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
                this.f1437k.measure(makeMeasureSpec, makeMeasureSpec);
            }
            i10 -= this.f1437k.getMeasuredWidth();
        } else {
            this.f1437k = null;
        }
        this.f1443q = i10;
        this.f1449w = (int) (resources.getDisplayMetrics().density * 56.0f);
    }

    @Override // androidx.appcompat.view.menu.b, androidx.appcompat.view.menu.m
    public void onCloseMenu(androidx.appcompat.view.menu.g gVar, boolean z10) {
        p();
        super.onCloseMenu(gVar, z10);
    }

    @Override // androidx.appcompat.view.menu.m
    public void onRestoreInstanceState(Parcelable parcelable) {
        int i10;
        MenuItem findItem;
        if ((parcelable instanceof g) && (i10 = ((g) parcelable).f1463a) > 0 && (findItem = this.f1129c.findItem(i10)) != null) {
            onSubMenuSelected((androidx.appcompat.view.menu.r) findItem.getSubMenu());
        }
    }

    @Override // androidx.appcompat.view.menu.m
    public Parcelable onSaveInstanceState() {
        g gVar = new g();
        gVar.f1463a = this.D;
        return gVar;
    }

    @Override // androidx.appcompat.view.menu.b, androidx.appcompat.view.menu.m
    public boolean onSubMenuSelected(androidx.appcompat.view.menu.r rVar) {
        boolean z10 = false;
        if (!rVar.hasVisibleItems()) {
            return false;
        }
        androidx.appcompat.view.menu.r rVar2 = rVar;
        while (rVar2.getParentMenu() != this.f1129c) {
            rVar2 = (androidx.appcompat.view.menu.r) rVar2.getParentMenu();
        }
        View q10 = q(rVar2.getItem());
        if (q10 == null) {
            return false;
        }
        this.D = rVar.getItem().getItemId();
        int size = rVar.size();
        int i10 = 0;
        while (true) {
            if (i10 >= size) {
                break;
            }
            MenuItem item = rVar.getItem(i10);
            if (item.isVisible() && item.getIcon() != null) {
                z10 = true;
                break;
            }
            i10++;
        }
        a aVar = new a(this.f1128b, rVar, q10);
        this.f1452z = aVar;
        aVar.g(z10);
        this.f1452z.k();
        super.onSubMenuSelected(rVar);
        return true;
    }

    public boolean p() {
        return s() | t();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final View q(MenuItem menuItem) {
        ViewGroup viewGroup = (ViewGroup) this.f1135i;
        if (viewGroup == null) {
            return null;
        }
        int childCount = viewGroup.getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = viewGroup.getChildAt(i10);
            if ((childAt instanceof n.a) && ((n.a) childAt).getItemData() == menuItem) {
                return childAt;
            }
        }
        return null;
    }

    public Drawable r() {
        C0019d c0019d = this.f1437k;
        if (c0019d != null) {
            return c0019d.getDrawable();
        }
        if (this.f1439m) {
            return this.f1438l;
        }
        return null;
    }

    public boolean s() {
        Object obj;
        c cVar = this.A;
        if (cVar != null && (obj = this.f1135i) != null) {
            ((View) obj).removeCallbacks(cVar);
            this.A = null;
            return true;
        }
        e eVar = this.f1451y;
        if (eVar == null) {
            return false;
        }
        eVar.b();
        return true;
    }

    public boolean t() {
        a aVar = this.f1452z;
        if (aVar == null) {
            return false;
        }
        aVar.b();
        return true;
    }

    public boolean u() {
        return this.A != null || v();
    }

    @Override // androidx.appcompat.view.menu.b, androidx.appcompat.view.menu.m
    public void updateMenuView(boolean z10) {
        super.updateMenuView(z10);
        ((View) this.f1135i).requestLayout();
        androidx.appcompat.view.menu.g gVar = this.f1129c;
        boolean z11 = false;
        if (gVar != null) {
            ArrayList<androidx.appcompat.view.menu.i> actionItems = gVar.getActionItems();
            int size = actionItems.size();
            for (int i10 = 0; i10 < size; i10++) {
                b0.b a10 = actionItems.get(i10).a();
                if (a10 != null) {
                    a10.k(this);
                }
            }
        }
        androidx.appcompat.view.menu.g gVar2 = this.f1129c;
        ArrayList<androidx.appcompat.view.menu.i> nonActionItems = gVar2 != null ? gVar2.getNonActionItems() : null;
        if (this.f1440n && nonActionItems != null) {
            int size2 = nonActionItems.size();
            if (size2 == 1) {
                z11 = !nonActionItems.get(0).isActionViewExpanded();
            } else if (size2 > 0) {
                z11 = true;
            }
        }
        if (z11) {
            if (this.f1437k == null) {
                this.f1437k = new C0019d(this.f1127a);
            }
            ViewGroup viewGroup = (ViewGroup) this.f1437k.getParent();
            if (viewGroup != this.f1135i) {
                if (viewGroup != null) {
                    viewGroup.removeView(this.f1437k);
                }
                ActionMenuView actionMenuView = (ActionMenuView) this.f1135i;
                actionMenuView.addView(this.f1437k, actionMenuView.k());
            }
        } else {
            C0019d c0019d = this.f1437k;
            if (c0019d != null) {
                Object parent = c0019d.getParent();
                Object obj = this.f1135i;
                if (parent == obj) {
                    ((ViewGroup) obj).removeView(this.f1437k);
                }
            }
        }
        ((ActionMenuView) this.f1135i).setOverflowReserved(this.f1440n);
    }

    public boolean v() {
        e eVar = this.f1451y;
        return eVar != null && eVar.d();
    }

    public void w(Configuration configuration) {
        if (!this.f1445s) {
            this.f1444r = g.a.b(this.f1128b).d();
        }
        androidx.appcompat.view.menu.g gVar = this.f1129c;
        if (gVar != null) {
            gVar.onItemsChanged(true);
        }
    }

    public void x(boolean z10) {
        this.f1448v = z10;
    }

    public void y(ActionMenuView actionMenuView) {
        this.f1135i = actionMenuView;
        actionMenuView.initialize(this.f1129c);
    }

    public void z(Drawable drawable) {
        C0019d c0019d = this.f1437k;
        if (c0019d != null) {
            c0019d.setImageDrawable(drawable);
        } else {
            this.f1439m = true;
            this.f1438l = drawable;
        }
    }
}
