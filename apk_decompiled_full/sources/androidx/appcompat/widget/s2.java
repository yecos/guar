package androidx.appcompat.widget;

import android.R;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import androidx.appcompat.R$attr;
import androidx.appcompat.R$drawable;
import androidx.appcompat.R$id;
import androidx.appcompat.R$string;
import androidx.appcompat.R$styleable;
import androidx.appcompat.view.menu.g;
import androidx.appcompat.view.menu.m;

/* loaded from: classes.dex */
public class s2 implements i1 {

    /* renamed from: a, reason: collision with root package name */
    public Toolbar f1619a;

    /* renamed from: b, reason: collision with root package name */
    public int f1620b;

    /* renamed from: c, reason: collision with root package name */
    public View f1621c;

    /* renamed from: d, reason: collision with root package name */
    public View f1622d;

    /* renamed from: e, reason: collision with root package name */
    public Drawable f1623e;

    /* renamed from: f, reason: collision with root package name */
    public Drawable f1624f;

    /* renamed from: g, reason: collision with root package name */
    public Drawable f1625g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f1626h;

    /* renamed from: i, reason: collision with root package name */
    public CharSequence f1627i;

    /* renamed from: j, reason: collision with root package name */
    public CharSequence f1628j;

    /* renamed from: k, reason: collision with root package name */
    public CharSequence f1629k;

    /* renamed from: l, reason: collision with root package name */
    public Window.Callback f1630l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f1631m;

    /* renamed from: n, reason: collision with root package name */
    public d f1632n;

    /* renamed from: o, reason: collision with root package name */
    public int f1633o;

    /* renamed from: p, reason: collision with root package name */
    public int f1634p;

    /* renamed from: q, reason: collision with root package name */
    public Drawable f1635q;

    public class a implements View.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        public final androidx.appcompat.view.menu.a f1636a;

        public a() {
            this.f1636a = new androidx.appcompat.view.menu.a(s2.this.f1619a.getContext(), 0, R.id.home, 0, 0, s2.this.f1627i);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            s2 s2Var = s2.this;
            Window.Callback callback = s2Var.f1630l;
            if (callback == null || !s2Var.f1631m) {
                return;
            }
            callback.onMenuItemSelected(0, this.f1636a);
        }
    }

    public class b extends b0.c2 {

        /* renamed from: a, reason: collision with root package name */
        public boolean f1638a = false;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f1639b;

        public b(int i10) {
            this.f1639b = i10;
        }

        @Override // b0.c2, b0.b2
        public void a(View view) {
            this.f1638a = true;
        }

        @Override // b0.b2
        public void b(View view) {
            if (this.f1638a) {
                return;
            }
            s2.this.f1619a.setVisibility(this.f1639b);
        }

        @Override // b0.c2, b0.b2
        public void c(View view) {
            s2.this.f1619a.setVisibility(0);
        }
    }

    public s2(Toolbar toolbar, boolean z10) {
        this(toolbar, z10, R$string.abc_action_bar_up_description, R$drawable.abc_ic_ab_back_material);
    }

    public void A(View view) {
        View view2 = this.f1622d;
        if (view2 != null && (this.f1620b & 16) != 0) {
            this.f1619a.removeView(view2);
        }
        this.f1622d = view;
        if (view == null || (this.f1620b & 16) == 0) {
            return;
        }
        this.f1619a.addView(view);
    }

    public void B(int i10) {
        if (i10 == this.f1634p) {
            return;
        }
        this.f1634p = i10;
        if (TextUtils.isEmpty(this.f1619a.getNavigationContentDescription())) {
            D(this.f1634p);
        }
    }

    public void C(Drawable drawable) {
        this.f1624f = drawable;
        J();
    }

    public void D(int i10) {
        E(i10 == 0 ? null : getContext().getString(i10));
    }

    public void E(CharSequence charSequence) {
        this.f1629k = charSequence;
        H();
    }

    public void F(Drawable drawable) {
        this.f1625g = drawable;
        I();
    }

    public final void G(CharSequence charSequence) {
        this.f1627i = charSequence;
        if ((this.f1620b & 8) != 0) {
            this.f1619a.setTitle(charSequence);
        }
    }

    public final void H() {
        if ((this.f1620b & 4) != 0) {
            if (TextUtils.isEmpty(this.f1629k)) {
                this.f1619a.setNavigationContentDescription(this.f1634p);
            } else {
                this.f1619a.setNavigationContentDescription(this.f1629k);
            }
        }
    }

    public final void I() {
        if ((this.f1620b & 4) == 0) {
            this.f1619a.setNavigationIcon((Drawable) null);
            return;
        }
        Toolbar toolbar = this.f1619a;
        Drawable drawable = this.f1625g;
        if (drawable == null) {
            drawable = this.f1635q;
        }
        toolbar.setNavigationIcon(drawable);
    }

    public final void J() {
        Drawable drawable;
        int i10 = this.f1620b;
        if ((i10 & 2) == 0) {
            drawable = null;
        } else if ((i10 & 1) != 0) {
            drawable = this.f1624f;
            if (drawable == null) {
                drawable = this.f1623e;
            }
        } else {
            drawable = this.f1623e;
        }
        this.f1619a.setLogo(drawable);
    }

    @Override // androidx.appcompat.widget.i1
    public boolean a() {
        return this.f1619a.canShowOverflowMenu();
    }

    @Override // androidx.appcompat.widget.i1
    public boolean b() {
        return this.f1619a.hideOverflowMenu();
    }

    @Override // androidx.appcompat.widget.i1
    public boolean c() {
        return this.f1619a.showOverflowMenu();
    }

    @Override // androidx.appcompat.widget.i1
    public void collapseActionView() {
        this.f1619a.collapseActionView();
    }

    @Override // androidx.appcompat.widget.i1
    public void d(Menu menu, m.a aVar) {
        if (this.f1632n == null) {
            d dVar = new d(this.f1619a.getContext());
            this.f1632n = dVar;
            dVar.h(R$id.action_menu_presenter);
        }
        this.f1632n.setCallback(aVar);
        this.f1619a.setMenu((androidx.appcompat.view.menu.g) menu, this.f1632n);
    }

    @Override // androidx.appcompat.widget.i1
    public boolean e() {
        return this.f1619a.isOverflowMenuShowing();
    }

    @Override // androidx.appcompat.widget.i1
    public void f() {
        this.f1631m = true;
    }

    @Override // androidx.appcompat.widget.i1
    public boolean g() {
        return this.f1619a.isOverflowMenuShowPending();
    }

    @Override // androidx.appcompat.widget.i1
    public Context getContext() {
        return this.f1619a.getContext();
    }

    @Override // androidx.appcompat.widget.i1
    public CharSequence getTitle() {
        return this.f1619a.getTitle();
    }

    @Override // androidx.appcompat.widget.i1
    public boolean h() {
        return this.f1619a.hasExpandedActionView();
    }

    @Override // androidx.appcompat.widget.i1
    public void i(int i10) {
        View view;
        int i11 = this.f1620b ^ i10;
        this.f1620b = i10;
        if (i11 != 0) {
            if ((i11 & 4) != 0) {
                if ((i10 & 4) != 0) {
                    H();
                }
                I();
            }
            if ((i11 & 3) != 0) {
                J();
            }
            if ((i11 & 8) != 0) {
                if ((i10 & 8) != 0) {
                    this.f1619a.setTitle(this.f1627i);
                    this.f1619a.setSubtitle(this.f1628j);
                } else {
                    this.f1619a.setTitle((CharSequence) null);
                    this.f1619a.setSubtitle((CharSequence) null);
                }
            }
            if ((i11 & 16) == 0 || (view = this.f1622d) == null) {
                return;
            }
            if ((i10 & 16) != 0) {
                this.f1619a.addView(view);
            } else {
                this.f1619a.removeView(view);
            }
        }
    }

    @Override // androidx.appcompat.widget.i1
    public void j(CharSequence charSequence) {
        this.f1628j = charSequence;
        if ((this.f1620b & 8) != 0) {
            this.f1619a.setSubtitle(charSequence);
        }
    }

    @Override // androidx.appcompat.widget.i1
    public Menu k() {
        return this.f1619a.getMenu();
    }

    @Override // androidx.appcompat.widget.i1
    public int l() {
        return this.f1633o;
    }

    @Override // androidx.appcompat.widget.i1
    public b0.a2 m(int i10, long j10) {
        return b0.c1.c(this.f1619a).a(i10 == 0 ? 1.0f : 0.0f).d(j10).f(new b(i10));
    }

    @Override // androidx.appcompat.widget.i1
    public ViewGroup n() {
        return this.f1619a;
    }

    @Override // androidx.appcompat.widget.i1
    public void o(boolean z10) {
    }

    @Override // androidx.appcompat.widget.i1
    public void p() {
    }

    @Override // androidx.appcompat.widget.i1
    public void q(boolean z10) {
        this.f1619a.setCollapsible(z10);
    }

    @Override // androidx.appcompat.widget.i1
    public void r() {
        this.f1619a.dismissPopupMenus();
    }

    @Override // androidx.appcompat.widget.i1
    public void s(j2 j2Var) {
        View view = this.f1621c;
        if (view != null) {
            ViewParent parent = view.getParent();
            Toolbar toolbar = this.f1619a;
            if (parent == toolbar) {
                toolbar.removeView(this.f1621c);
            }
        }
        this.f1621c = j2Var;
    }

    @Override // androidx.appcompat.widget.i1
    public void setIcon(int i10) {
        setIcon(i10 != 0 ? d.b.d(getContext(), i10) : null);
    }

    @Override // androidx.appcompat.widget.i1
    public void setTitle(CharSequence charSequence) {
        this.f1626h = true;
        G(charSequence);
    }

    @Override // androidx.appcompat.widget.i1
    public void setWindowCallback(Window.Callback callback) {
        this.f1630l = callback;
    }

    @Override // androidx.appcompat.widget.i1
    public void setWindowTitle(CharSequence charSequence) {
        if (this.f1626h) {
            return;
        }
        G(charSequence);
    }

    @Override // androidx.appcompat.widget.i1
    public void t(int i10) {
        C(i10 != 0 ? d.b.d(getContext(), i10) : null);
    }

    @Override // androidx.appcompat.widget.i1
    public void u(int i10) {
        F(i10 != 0 ? d.b.d(getContext(), i10) : null);
    }

    @Override // androidx.appcompat.widget.i1
    public void v(m.a aVar, g.a aVar2) {
        this.f1619a.setMenuCallbacks(aVar, aVar2);
    }

    @Override // androidx.appcompat.widget.i1
    public void w(int i10) {
        this.f1619a.setVisibility(i10);
    }

    @Override // androidx.appcompat.widget.i1
    public int x() {
        return this.f1620b;
    }

    @Override // androidx.appcompat.widget.i1
    public void y() {
    }

    public final int z() {
        if (this.f1619a.getNavigationIcon() == null) {
            return 11;
        }
        this.f1635q = this.f1619a.getNavigationIcon();
        return 15;
    }

    public s2(Toolbar toolbar, boolean z10, int i10, int i11) {
        Drawable drawable;
        this.f1633o = 0;
        this.f1634p = 0;
        this.f1619a = toolbar;
        this.f1627i = toolbar.getTitle();
        this.f1628j = toolbar.getSubtitle();
        this.f1626h = this.f1627i != null;
        this.f1625g = toolbar.getNavigationIcon();
        r2 u10 = r2.u(toolbar.getContext(), null, R$styleable.f803a, R$attr.actionBarStyle, 0);
        this.f1635q = u10.g(R$styleable.ActionBar_homeAsUpIndicator);
        if (z10) {
            CharSequence p10 = u10.p(R$styleable.ActionBar_title);
            if (!TextUtils.isEmpty(p10)) {
                setTitle(p10);
            }
            CharSequence p11 = u10.p(R$styleable.ActionBar_subtitle);
            if (!TextUtils.isEmpty(p11)) {
                j(p11);
            }
            Drawable g10 = u10.g(R$styleable.ActionBar_logo);
            if (g10 != null) {
                C(g10);
            }
            Drawable g11 = u10.g(R$styleable.ActionBar_icon);
            if (g11 != null) {
                setIcon(g11);
            }
            if (this.f1625g == null && (drawable = this.f1635q) != null) {
                F(drawable);
            }
            i(u10.k(R$styleable.ActionBar_displayOptions, 0));
            int n10 = u10.n(R$styleable.ActionBar_customNavigationLayout, 0);
            if (n10 != 0) {
                A(LayoutInflater.from(this.f1619a.getContext()).inflate(n10, (ViewGroup) this.f1619a, false));
                i(this.f1620b | 16);
            }
            int m10 = u10.m(R$styleable.ActionBar_height, 0);
            if (m10 > 0) {
                ViewGroup.LayoutParams layoutParams = this.f1619a.getLayoutParams();
                layoutParams.height = m10;
                this.f1619a.setLayoutParams(layoutParams);
            }
            int e10 = u10.e(R$styleable.ActionBar_contentInsetStart, -1);
            int e11 = u10.e(R$styleable.ActionBar_contentInsetEnd, -1);
            if (e10 >= 0 || e11 >= 0) {
                this.f1619a.setContentInsetsRelative(Math.max(e10, 0), Math.max(e11, 0));
            }
            int n11 = u10.n(R$styleable.ActionBar_titleTextStyle, 0);
            if (n11 != 0) {
                Toolbar toolbar2 = this.f1619a;
                toolbar2.setTitleTextAppearance(toolbar2.getContext(), n11);
            }
            int n12 = u10.n(R$styleable.ActionBar_subtitleTextStyle, 0);
            if (n12 != 0) {
                Toolbar toolbar3 = this.f1619a;
                toolbar3.setSubtitleTextAppearance(toolbar3.getContext(), n12);
            }
            int n13 = u10.n(R$styleable.ActionBar_popupTheme, 0);
            if (n13 != 0) {
                this.f1619a.setPopupTheme(n13);
            }
        } else {
            this.f1620b = z();
        }
        u10.v();
        B(i10);
        this.f1629k = this.f1619a.getNavigationContentDescription();
        this.f1619a.setNavigationOnClickListener(new a());
    }

    @Override // androidx.appcompat.widget.i1
    public void setIcon(Drawable drawable) {
        this.f1623e = drawable;
        J();
    }
}
