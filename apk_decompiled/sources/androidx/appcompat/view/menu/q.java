package androidx.appcompat.view.menu;

import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.os.Parcelable;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.appcompat.R$dimen;
import androidx.appcompat.R$layout;
import androidx.appcompat.view.menu.m;
import androidx.appcompat.widget.d2;
import b0.c1;

/* loaded from: classes.dex */
public final class q extends k implements PopupWindow.OnDismissListener, View.OnKeyListener {

    /* renamed from: v, reason: collision with root package name */
    public static final int f1250v = R$layout.abc_popup_menu_item_layout;

    /* renamed from: b, reason: collision with root package name */
    public final Context f1251b;

    /* renamed from: c, reason: collision with root package name */
    public final g f1252c;

    /* renamed from: d, reason: collision with root package name */
    public final f f1253d;

    /* renamed from: e, reason: collision with root package name */
    public final boolean f1254e;

    /* renamed from: f, reason: collision with root package name */
    public final int f1255f;

    /* renamed from: g, reason: collision with root package name */
    public final int f1256g;

    /* renamed from: h, reason: collision with root package name */
    public final int f1257h;

    /* renamed from: i, reason: collision with root package name */
    public final d2 f1258i;

    /* renamed from: l, reason: collision with root package name */
    public PopupWindow.OnDismissListener f1261l;

    /* renamed from: m, reason: collision with root package name */
    public View f1262m;

    /* renamed from: n, reason: collision with root package name */
    public View f1263n;

    /* renamed from: o, reason: collision with root package name */
    public m.a f1264o;

    /* renamed from: p, reason: collision with root package name */
    public ViewTreeObserver f1265p;

    /* renamed from: q, reason: collision with root package name */
    public boolean f1266q;

    /* renamed from: r, reason: collision with root package name */
    public boolean f1267r;

    /* renamed from: s, reason: collision with root package name */
    public int f1268s;

    /* renamed from: u, reason: collision with root package name */
    public boolean f1270u;

    /* renamed from: j, reason: collision with root package name */
    public final ViewTreeObserver.OnGlobalLayoutListener f1259j = new a();

    /* renamed from: k, reason: collision with root package name */
    public final View.OnAttachStateChangeListener f1260k = new b();

    /* renamed from: t, reason: collision with root package name */
    public int f1269t = 0;

    public class a implements ViewTreeObserver.OnGlobalLayoutListener {
        public a() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (!q.this.isShowing() || q.this.f1258i.u()) {
                return;
            }
            View view = q.this.f1263n;
            if (view == null || !view.isShown()) {
                q.this.dismiss();
            } else {
                q.this.f1258i.show();
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
            ViewTreeObserver viewTreeObserver = q.this.f1265p;
            if (viewTreeObserver != null) {
                if (!viewTreeObserver.isAlive()) {
                    q.this.f1265p = view.getViewTreeObserver();
                }
                q qVar = q.this;
                qVar.f1265p.removeGlobalOnLayoutListener(qVar.f1259j);
            }
            view.removeOnAttachStateChangeListener(this);
        }
    }

    public q(Context context, g gVar, View view, int i10, int i11, boolean z10) {
        this.f1251b = context;
        this.f1252c = gVar;
        this.f1254e = z10;
        this.f1253d = new f(gVar, LayoutInflater.from(context), z10, f1250v);
        this.f1256g = i10;
        this.f1257h = i11;
        Resources resources = context.getResources();
        this.f1255f = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(R$dimen.abc_config_prefDialogWidth));
        this.f1262m = view;
        this.f1258i = new d2(context, null, i10, i11);
        gVar.addMenuPresenter(this, context);
    }

    @Override // androidx.appcompat.view.menu.k
    public void a(g gVar) {
    }

    @Override // androidx.appcompat.view.menu.p
    public void dismiss() {
        if (isShowing()) {
            this.f1258i.dismiss();
        }
    }

    @Override // androidx.appcompat.view.menu.k
    public void e(View view) {
        this.f1262m = view;
    }

    @Override // androidx.appcompat.view.menu.m
    public boolean flagActionItems() {
        return false;
    }

    @Override // androidx.appcompat.view.menu.k
    public void g(boolean z10) {
        this.f1253d.d(z10);
    }

    @Override // androidx.appcompat.view.menu.k
    public void h(int i10) {
        this.f1269t = i10;
    }

    @Override // androidx.appcompat.view.menu.k
    public void i(int i10) {
        this.f1258i.c(i10);
    }

    @Override // androidx.appcompat.view.menu.p
    public boolean isShowing() {
        return !this.f1266q && this.f1258i.isShowing();
    }

    @Override // androidx.appcompat.view.menu.k
    public void j(PopupWindow.OnDismissListener onDismissListener) {
        this.f1261l = onDismissListener;
    }

    @Override // androidx.appcompat.view.menu.k
    public void k(boolean z10) {
        this.f1270u = z10;
    }

    @Override // androidx.appcompat.view.menu.k
    public void l(int i10) {
        this.f1258i.g(i10);
    }

    @Override // androidx.appcompat.view.menu.p
    public ListView m() {
        return this.f1258i.m();
    }

    @Override // androidx.appcompat.view.menu.m
    public void onCloseMenu(g gVar, boolean z10) {
        if (gVar != this.f1252c) {
            return;
        }
        dismiss();
        m.a aVar = this.f1264o;
        if (aVar != null) {
            aVar.onCloseMenu(gVar, z10);
        }
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        this.f1266q = true;
        this.f1252c.close();
        ViewTreeObserver viewTreeObserver = this.f1265p;
        if (viewTreeObserver != null) {
            if (!viewTreeObserver.isAlive()) {
                this.f1265p = this.f1263n.getViewTreeObserver();
            }
            this.f1265p.removeGlobalOnLayoutListener(this.f1259j);
            this.f1265p = null;
        }
        this.f1263n.removeOnAttachStateChangeListener(this.f1260k);
        PopupWindow.OnDismissListener onDismissListener = this.f1261l;
        if (onDismissListener != null) {
            onDismissListener.onDismiss();
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
        if (rVar.hasVisibleItems()) {
            l lVar = new l(this.f1251b, rVar, this.f1263n, this.f1254e, this.f1256g, this.f1257h);
            lVar.j(this.f1264o);
            lVar.g(k.n(rVar));
            lVar.i(this.f1261l);
            this.f1261l = null;
            this.f1252c.close(false);
            int a10 = this.f1258i.a();
            int j10 = this.f1258i.j();
            if ((Gravity.getAbsoluteGravity(this.f1269t, c1.z(this.f1262m)) & 7) == 5) {
                a10 += this.f1262m.getWidth();
            }
            if (lVar.n(a10, j10)) {
                m.a aVar = this.f1264o;
                if (aVar == null) {
                    return true;
                }
                aVar.a(rVar);
                return true;
            }
        }
        return false;
    }

    public final boolean p() {
        View view;
        if (isShowing()) {
            return true;
        }
        if (this.f1266q || (view = this.f1262m) == null) {
            return false;
        }
        this.f1263n = view;
        this.f1258i.D(this);
        this.f1258i.E(this);
        this.f1258i.C(true);
        View view2 = this.f1263n;
        boolean z10 = this.f1265p == null;
        ViewTreeObserver viewTreeObserver = view2.getViewTreeObserver();
        this.f1265p = viewTreeObserver;
        if (z10) {
            viewTreeObserver.addOnGlobalLayoutListener(this.f1259j);
        }
        view2.addOnAttachStateChangeListener(this.f1260k);
        this.f1258i.w(view2);
        this.f1258i.z(this.f1269t);
        if (!this.f1267r) {
            this.f1268s = k.d(this.f1253d, null, this.f1251b, this.f1255f);
            this.f1267r = true;
        }
        this.f1258i.y(this.f1268s);
        this.f1258i.B(2);
        this.f1258i.A(c());
        this.f1258i.show();
        ListView m10 = this.f1258i.m();
        m10.setOnKeyListener(this);
        if (this.f1270u && this.f1252c.getHeaderTitle() != null) {
            FrameLayout frameLayout = (FrameLayout) LayoutInflater.from(this.f1251b).inflate(R$layout.abc_popup_menu_header_item_layout, (ViewGroup) m10, false);
            TextView textView = (TextView) frameLayout.findViewById(R.id.title);
            if (textView != null) {
                textView.setText(this.f1252c.getHeaderTitle());
            }
            frameLayout.setEnabled(false);
            m10.addHeaderView(frameLayout, null, false);
        }
        this.f1258i.k(this.f1253d);
        this.f1258i.show();
        return true;
    }

    @Override // androidx.appcompat.view.menu.m
    public void setCallback(m.a aVar) {
        this.f1264o = aVar;
    }

    @Override // androidx.appcompat.view.menu.p
    public void show() {
        if (!p()) {
            throw new IllegalStateException("StandardMenuPopup cannot be used without an anchor");
        }
    }

    @Override // androidx.appcompat.view.menu.m
    public void updateMenuView(boolean z10) {
        this.f1267r = false;
        f fVar = this.f1253d;
        if (fVar != null) {
            fVar.notifyDataSetChanged();
        }
    }
}
