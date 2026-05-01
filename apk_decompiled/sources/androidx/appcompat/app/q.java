package androidx.appcompat.app;

import android.R;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import androidx.appcompat.R$attr;
import androidx.appcompat.R$id;
import androidx.appcompat.R$styleable;
import androidx.appcompat.view.menu.g;
import androidx.appcompat.widget.ActionBarContainer;
import androidx.appcompat.widget.ActionBarContextView;
import androidx.appcompat.widget.ActionBarOverlayLayout;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.i1;
import b0.a2;
import b0.b2;
import b0.c1;
import b0.c2;
import b0.d2;
import g.b;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class q extends androidx.appcompat.app.a implements ActionBarOverlayLayout.d {
    public static final Interpolator E = new AccelerateInterpolator();
    public static final Interpolator F = new DecelerateInterpolator();
    public boolean A;

    /* renamed from: a, reason: collision with root package name */
    public Context f1028a;

    /* renamed from: b, reason: collision with root package name */
    public Context f1029b;

    /* renamed from: c, reason: collision with root package name */
    public Activity f1030c;

    /* renamed from: d, reason: collision with root package name */
    public Dialog f1031d;

    /* renamed from: e, reason: collision with root package name */
    public ActionBarOverlayLayout f1032e;

    /* renamed from: f, reason: collision with root package name */
    public ActionBarContainer f1033f;

    /* renamed from: g, reason: collision with root package name */
    public i1 f1034g;

    /* renamed from: h, reason: collision with root package name */
    public ActionBarContextView f1035h;

    /* renamed from: i, reason: collision with root package name */
    public View f1036i;

    /* renamed from: l, reason: collision with root package name */
    public boolean f1039l;

    /* renamed from: m, reason: collision with root package name */
    public d f1040m;

    /* renamed from: n, reason: collision with root package name */
    public g.b f1041n;

    /* renamed from: o, reason: collision with root package name */
    public b.a f1042o;

    /* renamed from: p, reason: collision with root package name */
    public boolean f1043p;

    /* renamed from: r, reason: collision with root package name */
    public boolean f1045r;

    /* renamed from: u, reason: collision with root package name */
    public boolean f1048u;

    /* renamed from: v, reason: collision with root package name */
    public boolean f1049v;

    /* renamed from: w, reason: collision with root package name */
    public boolean f1050w;

    /* renamed from: y, reason: collision with root package name */
    public g.h f1052y;

    /* renamed from: z, reason: collision with root package name */
    public boolean f1053z;

    /* renamed from: j, reason: collision with root package name */
    public ArrayList f1037j = new ArrayList();

    /* renamed from: k, reason: collision with root package name */
    public int f1038k = -1;

    /* renamed from: q, reason: collision with root package name */
    public ArrayList f1044q = new ArrayList();

    /* renamed from: s, reason: collision with root package name */
    public int f1046s = 0;

    /* renamed from: t, reason: collision with root package name */
    public boolean f1047t = true;

    /* renamed from: x, reason: collision with root package name */
    public boolean f1051x = true;
    public final b2 B = new a();
    public final b2 C = new b();
    public final d2 D = new c();

    public class a extends c2 {
        public a() {
        }

        @Override // b0.b2
        public void b(View view) {
            View view2;
            q qVar = q.this;
            if (qVar.f1047t && (view2 = qVar.f1036i) != null) {
                view2.setTranslationY(0.0f);
                q.this.f1033f.setTranslationY(0.0f);
            }
            q.this.f1033f.setVisibility(8);
            q.this.f1033f.setTransitioning(false);
            q qVar2 = q.this;
            qVar2.f1052y = null;
            qVar2.B();
            ActionBarOverlayLayout actionBarOverlayLayout = q.this.f1032e;
            if (actionBarOverlayLayout != null) {
                c1.h0(actionBarOverlayLayout);
            }
        }
    }

    public class b extends c2 {
        public b() {
        }

        @Override // b0.b2
        public void b(View view) {
            q qVar = q.this;
            qVar.f1052y = null;
            qVar.f1033f.requestLayout();
        }
    }

    public class c implements d2 {
        public c() {
        }

        @Override // b0.d2
        public void a(View view) {
            ((View) q.this.f1033f.getParent()).invalidate();
        }
    }

    public class d extends g.b implements g.a {

        /* renamed from: c, reason: collision with root package name */
        public final Context f1057c;

        /* renamed from: d, reason: collision with root package name */
        public final androidx.appcompat.view.menu.g f1058d;

        /* renamed from: e, reason: collision with root package name */
        public b.a f1059e;

        /* renamed from: f, reason: collision with root package name */
        public WeakReference f1060f;

        public d(Context context, b.a aVar) {
            this.f1057c = context;
            this.f1059e = aVar;
            androidx.appcompat.view.menu.g defaultShowAsAction = new androidx.appcompat.view.menu.g(context).setDefaultShowAsAction(1);
            this.f1058d = defaultShowAsAction;
            defaultShowAsAction.setCallback(this);
        }

        @Override // g.b
        public void a() {
            q qVar = q.this;
            if (qVar.f1040m != this) {
                return;
            }
            if (q.A(qVar.f1048u, qVar.f1049v, false)) {
                this.f1059e.b(this);
            } else {
                q qVar2 = q.this;
                qVar2.f1041n = this;
                qVar2.f1042o = this.f1059e;
            }
            this.f1059e = null;
            q.this.z(false);
            q.this.f1035h.g();
            q.this.f1034g.n().sendAccessibilityEvent(32);
            q qVar3 = q.this;
            qVar3.f1032e.setHideOnContentScrollEnabled(qVar3.A);
            q.this.f1040m = null;
        }

        @Override // g.b
        public View b() {
            WeakReference weakReference = this.f1060f;
            if (weakReference != null) {
                return (View) weakReference.get();
            }
            return null;
        }

        @Override // g.b
        public Menu c() {
            return this.f1058d;
        }

        @Override // g.b
        public MenuInflater d() {
            return new g.g(this.f1057c);
        }

        @Override // g.b
        public CharSequence e() {
            return q.this.f1035h.getSubtitle();
        }

        @Override // g.b
        public CharSequence g() {
            return q.this.f1035h.getTitle();
        }

        @Override // g.b
        public void i() {
            if (q.this.f1040m != this) {
                return;
            }
            this.f1058d.stopDispatchingItemsChanged();
            try {
                this.f1059e.c(this, this.f1058d);
            } finally {
                this.f1058d.startDispatchingItemsChanged();
            }
        }

        @Override // g.b
        public boolean j() {
            return q.this.f1035h.j();
        }

        @Override // g.b
        public void k(View view) {
            q.this.f1035h.setCustomView(view);
            this.f1060f = new WeakReference(view);
        }

        @Override // g.b
        public void l(int i10) {
            m(q.this.f1028a.getResources().getString(i10));
        }

        @Override // g.b
        public void m(CharSequence charSequence) {
            q.this.f1035h.setSubtitle(charSequence);
        }

        @Override // g.b
        public void o(int i10) {
            p(q.this.f1028a.getResources().getString(i10));
        }

        @Override // androidx.appcompat.view.menu.g.a
        public boolean onMenuItemSelected(androidx.appcompat.view.menu.g gVar, MenuItem menuItem) {
            b.a aVar = this.f1059e;
            if (aVar != null) {
                return aVar.a(this, menuItem);
            }
            return false;
        }

        @Override // androidx.appcompat.view.menu.g.a
        public void onMenuModeChange(androidx.appcompat.view.menu.g gVar) {
            if (this.f1059e == null) {
                return;
            }
            i();
            q.this.f1035h.l();
        }

        @Override // g.b
        public void p(CharSequence charSequence) {
            q.this.f1035h.setTitle(charSequence);
        }

        @Override // g.b
        public void q(boolean z10) {
            super.q(z10);
            q.this.f1035h.setTitleOptional(z10);
        }

        public boolean r() {
            this.f1058d.stopDispatchingItemsChanged();
            try {
                return this.f1059e.d(this, this.f1058d);
            } finally {
                this.f1058d.startDispatchingItemsChanged();
            }
        }
    }

    public q(Activity activity, boolean z10) {
        this.f1030c = activity;
        View decorView = activity.getWindow().getDecorView();
        H(decorView);
        if (z10) {
            return;
        }
        this.f1036i = decorView.findViewById(R.id.content);
    }

    public static boolean A(boolean z10, boolean z11, boolean z12) {
        if (z12) {
            return true;
        }
        return (z10 || z11) ? false : true;
    }

    public void B() {
        b.a aVar = this.f1042o;
        if (aVar != null) {
            aVar.b(this.f1041n);
            this.f1041n = null;
            this.f1042o = null;
        }
    }

    public void C(boolean z10) {
        View view;
        g.h hVar = this.f1052y;
        if (hVar != null) {
            hVar.a();
        }
        if (this.f1046s != 0 || (!this.f1053z && !z10)) {
            this.B.b(null);
            return;
        }
        this.f1033f.setAlpha(1.0f);
        this.f1033f.setTransitioning(true);
        g.h hVar2 = new g.h();
        float f10 = -this.f1033f.getHeight();
        if (z10) {
            this.f1033f.getLocationInWindow(new int[]{0, 0});
            f10 -= r5[1];
        }
        a2 k10 = c1.c(this.f1033f).k(f10);
        k10.i(this.D);
        hVar2.c(k10);
        if (this.f1047t && (view = this.f1036i) != null) {
            hVar2.c(c1.c(view).k(f10));
        }
        hVar2.f(E);
        hVar2.e(250L);
        hVar2.g(this.B);
        this.f1052y = hVar2;
        hVar2.h();
    }

    public void D(boolean z10) {
        View view;
        View view2;
        g.h hVar = this.f1052y;
        if (hVar != null) {
            hVar.a();
        }
        this.f1033f.setVisibility(0);
        if (this.f1046s == 0 && (this.f1053z || z10)) {
            this.f1033f.setTranslationY(0.0f);
            float f10 = -this.f1033f.getHeight();
            if (z10) {
                this.f1033f.getLocationInWindow(new int[]{0, 0});
                f10 -= r5[1];
            }
            this.f1033f.setTranslationY(f10);
            g.h hVar2 = new g.h();
            a2 k10 = c1.c(this.f1033f).k(0.0f);
            k10.i(this.D);
            hVar2.c(k10);
            if (this.f1047t && (view2 = this.f1036i) != null) {
                view2.setTranslationY(f10);
                hVar2.c(c1.c(this.f1036i).k(0.0f));
            }
            hVar2.f(F);
            hVar2.e(250L);
            hVar2.g(this.C);
            this.f1052y = hVar2;
            hVar2.h();
        } else {
            this.f1033f.setAlpha(1.0f);
            this.f1033f.setTranslationY(0.0f);
            if (this.f1047t && (view = this.f1036i) != null) {
                view.setTranslationY(0.0f);
            }
            this.C.b(null);
        }
        ActionBarOverlayLayout actionBarOverlayLayout = this.f1032e;
        if (actionBarOverlayLayout != null) {
            c1.h0(actionBarOverlayLayout);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final i1 E(View view) {
        if (view instanceof i1) {
            return (i1) view;
        }
        if (view instanceof Toolbar) {
            return ((Toolbar) view).getWrapper();
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Can't make a decor toolbar out of ");
        sb.append(view != 0 ? view.getClass().getSimpleName() : "null");
        throw new IllegalStateException(sb.toString());
    }

    public int F() {
        return this.f1034g.l();
    }

    public final void G() {
        if (this.f1050w) {
            this.f1050w = false;
            ActionBarOverlayLayout actionBarOverlayLayout = this.f1032e;
            if (actionBarOverlayLayout != null) {
                actionBarOverlayLayout.setShowingForActionMode(false);
            }
            P(false);
        }
    }

    public final void H(View view) {
        ActionBarOverlayLayout actionBarOverlayLayout = (ActionBarOverlayLayout) view.findViewById(R$id.decor_content_parent);
        this.f1032e = actionBarOverlayLayout;
        if (actionBarOverlayLayout != null) {
            actionBarOverlayLayout.setActionBarVisibilityCallback(this);
        }
        this.f1034g = E(view.findViewById(R$id.action_bar));
        this.f1035h = (ActionBarContextView) view.findViewById(R$id.action_context_bar);
        ActionBarContainer actionBarContainer = (ActionBarContainer) view.findViewById(R$id.action_bar_container);
        this.f1033f = actionBarContainer;
        i1 i1Var = this.f1034g;
        if (i1Var == null || this.f1035h == null || actionBarContainer == null) {
            throw new IllegalStateException(getClass().getSimpleName() + " can only be used with a compatible window decor layout");
        }
        this.f1028a = i1Var.getContext();
        boolean z10 = (this.f1034g.x() & 4) != 0;
        if (z10) {
            this.f1039l = true;
        }
        g.a b10 = g.a.b(this.f1028a);
        M(b10.a() || z10);
        K(b10.e());
        TypedArray obtainStyledAttributes = this.f1028a.obtainStyledAttributes(null, R$styleable.f803a, R$attr.actionBarStyle, 0);
        if (obtainStyledAttributes.getBoolean(R$styleable.ActionBar_hideOnContentScroll, false)) {
            L(true);
        }
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(R$styleable.ActionBar_elevation, 0);
        if (dimensionPixelSize != 0) {
            J(dimensionPixelSize);
        }
        obtainStyledAttributes.recycle();
    }

    public void I(int i10, int i11) {
        int x10 = this.f1034g.x();
        if ((i11 & 4) != 0) {
            this.f1039l = true;
        }
        this.f1034g.i((i10 & i11) | ((i11 ^ (-1)) & x10));
    }

    public void J(float f10) {
        c1.s0(this.f1033f, f10);
    }

    public final void K(boolean z10) {
        this.f1045r = z10;
        if (z10) {
            this.f1033f.setTabContainer(null);
            this.f1034g.s(null);
        } else {
            this.f1034g.s(null);
            this.f1033f.setTabContainer(null);
        }
        boolean z11 = F() == 2;
        this.f1034g.q(!this.f1045r && z11);
        this.f1032e.setHasNonEmbeddedTabs(!this.f1045r && z11);
    }

    public void L(boolean z10) {
        if (z10 && !this.f1032e.q()) {
            throw new IllegalStateException("Action bar must be in overlay mode (Window.FEATURE_OVERLAY_ACTION_BAR) to enable hide on content scroll");
        }
        this.A = z10;
        this.f1032e.setHideOnContentScrollEnabled(z10);
    }

    public void M(boolean z10) {
        this.f1034g.o(z10);
    }

    public final boolean N() {
        return c1.Q(this.f1033f);
    }

    public final void O() {
        if (this.f1050w) {
            return;
        }
        this.f1050w = true;
        ActionBarOverlayLayout actionBarOverlayLayout = this.f1032e;
        if (actionBarOverlayLayout != null) {
            actionBarOverlayLayout.setShowingForActionMode(true);
        }
        P(false);
    }

    public final void P(boolean z10) {
        if (A(this.f1048u, this.f1049v, this.f1050w)) {
            if (this.f1051x) {
                return;
            }
            this.f1051x = true;
            D(z10);
            return;
        }
        if (this.f1051x) {
            this.f1051x = false;
            C(z10);
        }
    }

    @Override // androidx.appcompat.widget.ActionBarOverlayLayout.d
    public void a() {
        if (this.f1049v) {
            this.f1049v = false;
            P(true);
        }
    }

    @Override // androidx.appcompat.widget.ActionBarOverlayLayout.d
    public void b(int i10) {
        this.f1046s = i10;
    }

    @Override // androidx.appcompat.widget.ActionBarOverlayLayout.d
    public void c() {
    }

    @Override // androidx.appcompat.widget.ActionBarOverlayLayout.d
    public void d(boolean z10) {
        this.f1047t = z10;
    }

    @Override // androidx.appcompat.widget.ActionBarOverlayLayout.d
    public void e() {
        if (this.f1049v) {
            return;
        }
        this.f1049v = true;
        P(true);
    }

    @Override // androidx.appcompat.widget.ActionBarOverlayLayout.d
    public void f() {
        g.h hVar = this.f1052y;
        if (hVar != null) {
            hVar.a();
            this.f1052y = null;
        }
    }

    @Override // androidx.appcompat.app.a
    public boolean h() {
        i1 i1Var = this.f1034g;
        if (i1Var == null || !i1Var.h()) {
            return false;
        }
        this.f1034g.collapseActionView();
        return true;
    }

    @Override // androidx.appcompat.app.a
    public void i(boolean z10) {
        if (z10 == this.f1043p) {
            return;
        }
        this.f1043p = z10;
        if (this.f1044q.size() <= 0) {
            return;
        }
        m.a(this.f1044q.get(0));
        throw null;
    }

    @Override // androidx.appcompat.app.a
    public int j() {
        return this.f1034g.x();
    }

    @Override // androidx.appcompat.app.a
    public Context k() {
        if (this.f1029b == null) {
            TypedValue typedValue = new TypedValue();
            this.f1028a.getTheme().resolveAttribute(R$attr.actionBarWidgetTheme, typedValue, true);
            int i10 = typedValue.resourceId;
            if (i10 != 0) {
                this.f1029b = new ContextThemeWrapper(this.f1028a, i10);
            } else {
                this.f1029b = this.f1028a;
            }
        }
        return this.f1029b;
    }

    @Override // androidx.appcompat.app.a
    public void m(Configuration configuration) {
        K(g.a.b(this.f1028a).e());
    }

    @Override // androidx.appcompat.app.a
    public boolean o(int i10, KeyEvent keyEvent) {
        Menu c10;
        d dVar = this.f1040m;
        if (dVar == null || (c10 = dVar.c()) == null) {
            return false;
        }
        c10.setQwertyMode(KeyCharacterMap.load(keyEvent != null ? keyEvent.getDeviceId() : -1).getKeyboardType() != 1);
        return c10.performShortcut(i10, keyEvent, 0);
    }

    @Override // androidx.appcompat.app.a
    public void r(boolean z10) {
        if (this.f1039l) {
            return;
        }
        s(z10);
    }

    @Override // androidx.appcompat.app.a
    public void s(boolean z10) {
        I(z10 ? 4 : 0, 4);
    }

    @Override // androidx.appcompat.app.a
    public void t(int i10) {
        this.f1034g.u(i10);
    }

    @Override // androidx.appcompat.app.a
    public void u(boolean z10) {
        g.h hVar;
        this.f1053z = z10;
        if (z10 || (hVar = this.f1052y) == null) {
            return;
        }
        hVar.a();
    }

    @Override // androidx.appcompat.app.a
    public void v(CharSequence charSequence) {
        this.f1034g.j(charSequence);
    }

    @Override // androidx.appcompat.app.a
    public void w(CharSequence charSequence) {
        this.f1034g.setTitle(charSequence);
    }

    @Override // androidx.appcompat.app.a
    public void x(CharSequence charSequence) {
        this.f1034g.setWindowTitle(charSequence);
    }

    @Override // androidx.appcompat.app.a
    public g.b y(b.a aVar) {
        d dVar = this.f1040m;
        if (dVar != null) {
            dVar.a();
        }
        this.f1032e.setHideOnContentScrollEnabled(false);
        this.f1035h.k();
        d dVar2 = new d(this.f1035h.getContext(), aVar);
        if (!dVar2.r()) {
            return null;
        }
        this.f1040m = dVar2;
        dVar2.i();
        this.f1035h.h(dVar2);
        z(true);
        this.f1035h.sendAccessibilityEvent(32);
        return dVar2;
    }

    public void z(boolean z10) {
        a2 m10;
        a2 f10;
        if (z10) {
            O();
        } else {
            G();
        }
        if (!N()) {
            if (z10) {
                this.f1034g.w(4);
                this.f1035h.setVisibility(0);
                return;
            } else {
                this.f1034g.w(0);
                this.f1035h.setVisibility(8);
                return;
            }
        }
        if (z10) {
            f10 = this.f1034g.m(4, 100L);
            m10 = this.f1035h.f(0, 200L);
        } else {
            m10 = this.f1034g.m(0, 200L);
            f10 = this.f1035h.f(8, 100L);
        }
        g.h hVar = new g.h();
        hVar.d(f10, m10);
        hVar.h();
    }

    public q(Dialog dialog) {
        this.f1031d = dialog;
        H(dialog.getWindow().getDecorView());
    }
}
