package androidx.appcompat.view.menu;

import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Build;
import android.os.Handler;
import android.os.Parcelable;
import android.os.SystemClock;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.appcompat.R$dimen;
import androidx.appcompat.R$layout;
import androidx.appcompat.view.menu.m;
import androidx.appcompat.widget.d2;
import androidx.appcompat.widget.z1;
import b0.c1;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public final class d extends k implements View.OnKeyListener, PopupWindow.OnDismissListener {
    public static final int B = R$layout.abc_cascading_menu_item_layout;
    public boolean A;

    /* renamed from: b, reason: collision with root package name */
    public final Context f1140b;

    /* renamed from: c, reason: collision with root package name */
    public final int f1141c;

    /* renamed from: d, reason: collision with root package name */
    public final int f1142d;

    /* renamed from: e, reason: collision with root package name */
    public final int f1143e;

    /* renamed from: f, reason: collision with root package name */
    public final boolean f1144f;

    /* renamed from: g, reason: collision with root package name */
    public final Handler f1145g;

    /* renamed from: o, reason: collision with root package name */
    public View f1153o;

    /* renamed from: p, reason: collision with root package name */
    public View f1154p;

    /* renamed from: r, reason: collision with root package name */
    public boolean f1156r;

    /* renamed from: s, reason: collision with root package name */
    public boolean f1157s;

    /* renamed from: t, reason: collision with root package name */
    public int f1158t;

    /* renamed from: u, reason: collision with root package name */
    public int f1159u;

    /* renamed from: w, reason: collision with root package name */
    public boolean f1161w;

    /* renamed from: x, reason: collision with root package name */
    public m.a f1162x;

    /* renamed from: y, reason: collision with root package name */
    public ViewTreeObserver f1163y;

    /* renamed from: z, reason: collision with root package name */
    public PopupWindow.OnDismissListener f1164z;

    /* renamed from: h, reason: collision with root package name */
    public final List f1146h = new ArrayList();

    /* renamed from: i, reason: collision with root package name */
    public final List f1147i = new ArrayList();

    /* renamed from: j, reason: collision with root package name */
    public final ViewTreeObserver.OnGlobalLayoutListener f1148j = new a();

    /* renamed from: k, reason: collision with root package name */
    public final View.OnAttachStateChangeListener f1149k = new b();

    /* renamed from: l, reason: collision with root package name */
    public final z1 f1150l = new c();

    /* renamed from: m, reason: collision with root package name */
    public int f1151m = 0;

    /* renamed from: n, reason: collision with root package name */
    public int f1152n = 0;

    /* renamed from: v, reason: collision with root package name */
    public boolean f1160v = false;

    /* renamed from: q, reason: collision with root package name */
    public int f1155q = t();

    public class a implements ViewTreeObserver.OnGlobalLayoutListener {
        public a() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (!d.this.isShowing() || d.this.f1147i.size() <= 0 || ((C0017d) d.this.f1147i.get(0)).f1172a.u()) {
                return;
            }
            View view = d.this.f1154p;
            if (view == null || !view.isShown()) {
                d.this.dismiss();
                return;
            }
            Iterator it = d.this.f1147i.iterator();
            while (it.hasNext()) {
                ((C0017d) it.next()).f1172a.show();
            }
        }
    }

    public class b implements View.OnAttachStateChangeListener {
        public b() {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            ViewTreeObserver viewTreeObserver = d.this.f1163y;
            if (viewTreeObserver != null) {
                if (!viewTreeObserver.isAlive()) {
                    d.this.f1163y = view.getViewTreeObserver();
                }
                d dVar = d.this;
                dVar.f1163y.removeGlobalOnLayoutListener(dVar.f1148j);
            }
            view.removeOnAttachStateChangeListener(this);
        }
    }

    public class c implements z1 {

        public class a implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ C0017d f1168a;

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ MenuItem f1169b;

            /* renamed from: c, reason: collision with root package name */
            public final /* synthetic */ g f1170c;

            public a(C0017d c0017d, MenuItem menuItem, g gVar) {
                this.f1168a = c0017d;
                this.f1169b = menuItem;
                this.f1170c = gVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                C0017d c0017d = this.f1168a;
                if (c0017d != null) {
                    d.this.A = true;
                    c0017d.f1173b.close(false);
                    d.this.A = false;
                }
                if (this.f1169b.isEnabled() && this.f1169b.hasSubMenu()) {
                    this.f1170c.performItemAction(this.f1169b, 4);
                }
            }
        }

        public c() {
        }

        @Override // androidx.appcompat.widget.z1
        public void b(g gVar, MenuItem menuItem) {
            d.this.f1145g.removeCallbacksAndMessages(null);
            int size = d.this.f1147i.size();
            int i10 = 0;
            while (true) {
                if (i10 >= size) {
                    i10 = -1;
                    break;
                } else if (gVar == ((C0017d) d.this.f1147i.get(i10)).f1173b) {
                    break;
                } else {
                    i10++;
                }
            }
            if (i10 == -1) {
                return;
            }
            int i11 = i10 + 1;
            d.this.f1145g.postAtTime(new a(i11 < d.this.f1147i.size() ? (C0017d) d.this.f1147i.get(i11) : null, menuItem, gVar), gVar, SystemClock.uptimeMillis() + 200);
        }

        @Override // androidx.appcompat.widget.z1
        public void l(g gVar, MenuItem menuItem) {
            d.this.f1145g.removeCallbacksAndMessages(gVar);
        }
    }

    /* renamed from: androidx.appcompat.view.menu.d$d, reason: collision with other inner class name */
    public static class C0017d {

        /* renamed from: a, reason: collision with root package name */
        public final d2 f1172a;

        /* renamed from: b, reason: collision with root package name */
        public final g f1173b;

        /* renamed from: c, reason: collision with root package name */
        public final int f1174c;

        public C0017d(d2 d2Var, g gVar, int i10) {
            this.f1172a = d2Var;
            this.f1173b = gVar;
            this.f1174c = i10;
        }

        public ListView a() {
            return this.f1172a.m();
        }
    }

    public d(Context context, View view, int i10, int i11, boolean z10) {
        this.f1140b = context;
        this.f1153o = view;
        this.f1142d = i10;
        this.f1143e = i11;
        this.f1144f = z10;
        Resources resources = context.getResources();
        this.f1141c = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(R$dimen.abc_config_prefDialogWidth));
        this.f1145g = new Handler();
    }

    @Override // androidx.appcompat.view.menu.k
    public void a(g gVar) {
        gVar.addMenuPresenter(this, this.f1140b);
        if (isShowing()) {
            v(gVar);
        } else {
            this.f1146h.add(gVar);
        }
    }

    @Override // androidx.appcompat.view.menu.k
    public boolean b() {
        return false;
    }

    @Override // androidx.appcompat.view.menu.p
    public void dismiss() {
        int size = this.f1147i.size();
        if (size > 0) {
            C0017d[] c0017dArr = (C0017d[]) this.f1147i.toArray(new C0017d[size]);
            for (int i10 = size - 1; i10 >= 0; i10--) {
                C0017d c0017d = c0017dArr[i10];
                if (c0017d.f1172a.isShowing()) {
                    c0017d.f1172a.dismiss();
                }
            }
        }
    }

    @Override // androidx.appcompat.view.menu.k
    public void e(View view) {
        if (this.f1153o != view) {
            this.f1153o = view;
            this.f1152n = b0.j.b(this.f1151m, c1.z(view));
        }
    }

    @Override // androidx.appcompat.view.menu.m
    public boolean flagActionItems() {
        return false;
    }

    @Override // androidx.appcompat.view.menu.k
    public void g(boolean z10) {
        this.f1160v = z10;
    }

    @Override // androidx.appcompat.view.menu.k
    public void h(int i10) {
        if (this.f1151m != i10) {
            this.f1151m = i10;
            this.f1152n = b0.j.b(i10, c1.z(this.f1153o));
        }
    }

    @Override // androidx.appcompat.view.menu.k
    public void i(int i10) {
        this.f1156r = true;
        this.f1158t = i10;
    }

    @Override // androidx.appcompat.view.menu.p
    public boolean isShowing() {
        return this.f1147i.size() > 0 && ((C0017d) this.f1147i.get(0)).f1172a.isShowing();
    }

    @Override // androidx.appcompat.view.menu.k
    public void j(PopupWindow.OnDismissListener onDismissListener) {
        this.f1164z = onDismissListener;
    }

    @Override // androidx.appcompat.view.menu.k
    public void k(boolean z10) {
        this.f1161w = z10;
    }

    @Override // androidx.appcompat.view.menu.k
    public void l(int i10) {
        this.f1157s = true;
        this.f1159u = i10;
    }

    @Override // androidx.appcompat.view.menu.p
    public ListView m() {
        if (this.f1147i.isEmpty()) {
            return null;
        }
        return ((C0017d) this.f1147i.get(r0.size() - 1)).a();
    }

    @Override // androidx.appcompat.view.menu.m
    public void onCloseMenu(g gVar, boolean z10) {
        int q10 = q(gVar);
        if (q10 < 0) {
            return;
        }
        int i10 = q10 + 1;
        if (i10 < this.f1147i.size()) {
            ((C0017d) this.f1147i.get(i10)).f1173b.close(false);
        }
        C0017d c0017d = (C0017d) this.f1147i.remove(q10);
        c0017d.f1173b.removeMenuPresenter(this);
        if (this.A) {
            c0017d.f1172a.L(null);
            c0017d.f1172a.x(0);
        }
        c0017d.f1172a.dismiss();
        int size = this.f1147i.size();
        if (size > 0) {
            this.f1155q = ((C0017d) this.f1147i.get(size - 1)).f1174c;
        } else {
            this.f1155q = t();
        }
        if (size != 0) {
            if (z10) {
                ((C0017d) this.f1147i.get(0)).f1173b.close(false);
                return;
            }
            return;
        }
        dismiss();
        m.a aVar = this.f1162x;
        if (aVar != null) {
            aVar.onCloseMenu(gVar, true);
        }
        ViewTreeObserver viewTreeObserver = this.f1163y;
        if (viewTreeObserver != null) {
            if (viewTreeObserver.isAlive()) {
                this.f1163y.removeGlobalOnLayoutListener(this.f1148j);
            }
            this.f1163y = null;
        }
        this.f1154p.removeOnAttachStateChangeListener(this.f1149k);
        this.f1164z.onDismiss();
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        C0017d c0017d;
        int size = this.f1147i.size();
        int i10 = 0;
        while (true) {
            if (i10 >= size) {
                c0017d = null;
                break;
            }
            c0017d = (C0017d) this.f1147i.get(i10);
            if (!c0017d.f1172a.isShowing()) {
                break;
            } else {
                i10++;
            }
        }
        if (c0017d != null) {
            c0017d.f1173b.close(false);
        }
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View view, int i10, KeyEvent keyEvent) {
        if (keyEvent.getAction() != 1 || i10 != 82) {
            return false;
        }
        dismiss();
        return true;
    }

    @Override // androidx.appcompat.view.menu.m
    public void onRestoreInstanceState(Parcelable parcelable) {
    }

    @Override // androidx.appcompat.view.menu.m
    public Parcelable onSaveInstanceState() {
        return null;
    }

    @Override // androidx.appcompat.view.menu.m
    public boolean onSubMenuSelected(r rVar) {
        for (C0017d c0017d : this.f1147i) {
            if (rVar == c0017d.f1173b) {
                c0017d.a().requestFocus();
                return true;
            }
        }
        if (!rVar.hasVisibleItems()) {
            return false;
        }
        a(rVar);
        m.a aVar = this.f1162x;
        if (aVar != null) {
            aVar.a(rVar);
        }
        return true;
    }

    public final d2 p() {
        d2 d2Var = new d2(this.f1140b, null, this.f1142d, this.f1143e);
        d2Var.M(this.f1150l);
        d2Var.E(this);
        d2Var.D(this);
        d2Var.w(this.f1153o);
        d2Var.z(this.f1152n);
        d2Var.C(true);
        d2Var.B(2);
        return d2Var;
    }

    public final int q(g gVar) {
        int size = this.f1147i.size();
        for (int i10 = 0; i10 < size; i10++) {
            if (gVar == ((C0017d) this.f1147i.get(i10)).f1173b) {
                return i10;
            }
        }
        return -1;
    }

    public final MenuItem r(g gVar, g gVar2) {
        int size = gVar.size();
        for (int i10 = 0; i10 < size; i10++) {
            MenuItem item = gVar.getItem(i10);
            if (item.hasSubMenu() && gVar2 == item.getSubMenu()) {
                return item;
            }
        }
        return null;
    }

    public final View s(C0017d c0017d, g gVar) {
        f fVar;
        int i10;
        int firstVisiblePosition;
        MenuItem r10 = r(c0017d.f1173b, gVar);
        if (r10 == null) {
            return null;
        }
        ListView a10 = c0017d.a();
        ListAdapter adapter = a10.getAdapter();
        int i11 = 0;
        if (adapter instanceof HeaderViewListAdapter) {
            HeaderViewListAdapter headerViewListAdapter = (HeaderViewListAdapter) adapter;
            i10 = headerViewListAdapter.getHeadersCount();
            fVar = (f) headerViewListAdapter.getWrappedAdapter();
        } else {
            fVar = (f) adapter;
            i10 = 0;
        }
        int count = fVar.getCount();
        while (true) {
            if (i11 >= count) {
                i11 = -1;
                break;
            }
            if (r10 == fVar.getItem(i11)) {
                break;
            }
            i11++;
        }
        if (i11 != -1 && (firstVisiblePosition = (i11 + i10) - a10.getFirstVisiblePosition()) >= 0 && firstVisiblePosition < a10.getChildCount()) {
            return a10.getChildAt(firstVisiblePosition);
        }
        return null;
    }

    @Override // androidx.appcompat.view.menu.m
    public void setCallback(m.a aVar) {
        this.f1162x = aVar;
    }

    @Override // androidx.appcompat.view.menu.p
    public void show() {
        if (isShowing()) {
            return;
        }
        Iterator it = this.f1146h.iterator();
        while (it.hasNext()) {
            v((g) it.next());
        }
        this.f1146h.clear();
        View view = this.f1153o;
        this.f1154p = view;
        if (view != null) {
            boolean z10 = this.f1163y == null;
            ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
            this.f1163y = viewTreeObserver;
            if (z10) {
                viewTreeObserver.addOnGlobalLayoutListener(this.f1148j);
            }
            this.f1154p.addOnAttachStateChangeListener(this.f1149k);
        }
    }

    public final int t() {
        return c1.z(this.f1153o) == 1 ? 0 : 1;
    }

    public final int u(int i10) {
        List list = this.f1147i;
        ListView a10 = ((C0017d) list.get(list.size() - 1)).a();
        int[] iArr = new int[2];
        a10.getLocationOnScreen(iArr);
        Rect rect = new Rect();
        this.f1154p.getWindowVisibleDisplayFrame(rect);
        return this.f1155q == 1 ? (iArr[0] + a10.getWidth()) + i10 > rect.right ? 0 : 1 : iArr[0] - i10 < 0 ? 1 : 0;
    }

    @Override // androidx.appcompat.view.menu.m
    public void updateMenuView(boolean z10) {
        Iterator it = this.f1147i.iterator();
        while (it.hasNext()) {
            k.o(((C0017d) it.next()).a().getAdapter()).notifyDataSetChanged();
        }
    }

    public final void v(g gVar) {
        C0017d c0017d;
        View view;
        int i10;
        int i11;
        int i12;
        LayoutInflater from = LayoutInflater.from(this.f1140b);
        f fVar = new f(gVar, from, this.f1144f, B);
        if (!isShowing() && this.f1160v) {
            fVar.d(true);
        } else if (isShowing()) {
            fVar.d(k.n(gVar));
        }
        int d10 = k.d(fVar, null, this.f1140b, this.f1141c);
        d2 p10 = p();
        p10.k(fVar);
        p10.y(d10);
        p10.z(this.f1152n);
        if (this.f1147i.size() > 0) {
            List list = this.f1147i;
            c0017d = (C0017d) list.get(list.size() - 1);
            view = s(c0017d, gVar);
        } else {
            c0017d = null;
            view = null;
        }
        if (view != null) {
            p10.N(false);
            p10.K(null);
            int u10 = u(d10);
            boolean z10 = u10 == 1;
            this.f1155q = u10;
            if (Build.VERSION.SDK_INT >= 26) {
                p10.w(view);
                i11 = 0;
                i10 = 0;
            } else {
                int[] iArr = new int[2];
                this.f1153o.getLocationOnScreen(iArr);
                int[] iArr2 = new int[2];
                view.getLocationOnScreen(iArr2);
                if ((this.f1152n & 7) == 5) {
                    iArr[0] = iArr[0] + this.f1153o.getWidth();
                    iArr2[0] = iArr2[0] + view.getWidth();
                }
                i10 = iArr2[0] - iArr[0];
                i11 = iArr2[1] - iArr[1];
            }
            if ((this.f1152n & 5) == 5) {
                if (!z10) {
                    d10 = view.getWidth();
                    i12 = i10 - d10;
                }
                i12 = i10 + d10;
            } else {
                if (z10) {
                    d10 = view.getWidth();
                    i12 = i10 + d10;
                }
                i12 = i10 - d10;
            }
            p10.c(i12);
            p10.F(true);
            p10.g(i11);
        } else {
            if (this.f1156r) {
                p10.c(this.f1158t);
            }
            if (this.f1157s) {
                p10.g(this.f1159u);
            }
            p10.A(c());
        }
        this.f1147i.add(new C0017d(p10, gVar, this.f1155q));
        p10.show();
        ListView m10 = p10.m();
        m10.setOnKeyListener(this);
        if (c0017d == null && this.f1161w && gVar.getHeaderTitle() != null) {
            FrameLayout frameLayout = (FrameLayout) from.inflate(R$layout.abc_popup_menu_header_item_layout, (ViewGroup) m10, false);
            TextView textView = (TextView) frameLayout.findViewById(R.id.title);
            frameLayout.setEnabled(false);
            textView.setText(gVar.getHeaderTitle());
            m10.addHeaderView(frameLayout, null, false);
            p10.show();
        }
    }
}
