package androidx.appcompat.view.menu;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.ActionProvider;
import android.view.ContextMenu;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.appcompat.R$string;
import androidx.appcompat.view.menu.n;
import b0.b;

/* loaded from: classes.dex */
public final class i implements u.b {
    public View A;
    public b0.b B;
    public MenuItem.OnActionExpandListener C;
    public ContextMenu.ContextMenuInfo E;

    /* renamed from: a, reason: collision with root package name */
    public final int f1197a;

    /* renamed from: b, reason: collision with root package name */
    public final int f1198b;

    /* renamed from: c, reason: collision with root package name */
    public final int f1199c;

    /* renamed from: d, reason: collision with root package name */
    public final int f1200d;

    /* renamed from: e, reason: collision with root package name */
    public CharSequence f1201e;

    /* renamed from: f, reason: collision with root package name */
    public CharSequence f1202f;

    /* renamed from: g, reason: collision with root package name */
    public Intent f1203g;

    /* renamed from: h, reason: collision with root package name */
    public char f1204h;

    /* renamed from: j, reason: collision with root package name */
    public char f1206j;

    /* renamed from: l, reason: collision with root package name */
    public Drawable f1208l;

    /* renamed from: n, reason: collision with root package name */
    public g f1210n;

    /* renamed from: o, reason: collision with root package name */
    public r f1211o;

    /* renamed from: p, reason: collision with root package name */
    public Runnable f1212p;

    /* renamed from: q, reason: collision with root package name */
    public MenuItem.OnMenuItemClickListener f1213q;

    /* renamed from: r, reason: collision with root package name */
    public CharSequence f1214r;

    /* renamed from: s, reason: collision with root package name */
    public CharSequence f1215s;

    /* renamed from: z, reason: collision with root package name */
    public int f1222z;

    /* renamed from: i, reason: collision with root package name */
    public int f1205i = 4096;

    /* renamed from: k, reason: collision with root package name */
    public int f1207k = 4096;

    /* renamed from: m, reason: collision with root package name */
    public int f1209m = 0;

    /* renamed from: t, reason: collision with root package name */
    public ColorStateList f1216t = null;

    /* renamed from: u, reason: collision with root package name */
    public PorterDuff.Mode f1217u = null;

    /* renamed from: v, reason: collision with root package name */
    public boolean f1218v = false;

    /* renamed from: w, reason: collision with root package name */
    public boolean f1219w = false;

    /* renamed from: x, reason: collision with root package name */
    public boolean f1220x = false;

    /* renamed from: y, reason: collision with root package name */
    public int f1221y = 16;
    public boolean D = false;

    public class a implements b.InterfaceC0069b {
        public a() {
        }

        @Override // b0.b.InterfaceC0069b
        public void onActionProviderVisibilityChanged(boolean z10) {
            i iVar = i.this;
            iVar.f1210n.onItemVisibleChanged(iVar);
        }
    }

    public i(g gVar, int i10, int i11, int i12, int i13, CharSequence charSequence, int i14) {
        this.f1210n = gVar;
        this.f1197a = i11;
        this.f1198b = i10;
        this.f1199c = i12;
        this.f1200d = i13;
        this.f1201e = charSequence;
        this.f1222z = i14;
    }

    public static void d(StringBuilder sb, int i10, int i11, String str) {
        if ((i10 & i11) == i11) {
            sb.append(str);
        }
    }

    public boolean A() {
        return this.f1210n.isShortcutsVisible() && g() != 0;
    }

    public boolean B() {
        return (this.f1222z & 4) == 4;
    }

    @Override // u.b
    public b0.b a() {
        return this.B;
    }

    @Override // u.b
    public u.b b(b0.b bVar) {
        b0.b bVar2 = this.B;
        if (bVar2 != null) {
            bVar2.j();
        }
        this.A = null;
        this.B = bVar;
        this.f1210n.onItemsChanged(true);
        b0.b bVar3 = this.B;
        if (bVar3 != null) {
            bVar3.l(new a());
        }
        return this;
    }

    public void c() {
        this.f1210n.onItemActionRequestChanged(this);
    }

    @Override // u.b, android.view.MenuItem
    public boolean collapseActionView() {
        if ((this.f1222z & 8) == 0) {
            return false;
        }
        if (this.A == null) {
            return true;
        }
        MenuItem.OnActionExpandListener onActionExpandListener = this.C;
        if (onActionExpandListener == null || onActionExpandListener.onMenuItemActionCollapse(this)) {
            return this.f1210n.collapseItemActionView(this);
        }
        return false;
    }

    public final Drawable e(Drawable drawable) {
        if (drawable != null && this.f1220x && (this.f1218v || this.f1219w)) {
            drawable = s.h.r(drawable).mutate();
            if (this.f1218v) {
                s.h.o(drawable, this.f1216t);
            }
            if (this.f1219w) {
                s.h.p(drawable, this.f1217u);
            }
            this.f1220x = false;
        }
        return drawable;
    }

    @Override // u.b, android.view.MenuItem
    public boolean expandActionView() {
        if (!j()) {
            return false;
        }
        MenuItem.OnActionExpandListener onActionExpandListener = this.C;
        if (onActionExpandListener == null || onActionExpandListener.onMenuItemActionExpand(this)) {
            return this.f1210n.expandItemActionView(this);
        }
        return false;
    }

    public int f() {
        return this.f1200d;
    }

    public char g() {
        return this.f1210n.isQwertyMode() ? this.f1206j : this.f1204h;
    }

    @Override // android.view.MenuItem
    public ActionProvider getActionProvider() {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.getActionProvider()");
    }

    @Override // u.b, android.view.MenuItem
    public View getActionView() {
        View view = this.A;
        if (view != null) {
            return view;
        }
        b0.b bVar = this.B;
        if (bVar == null) {
            return null;
        }
        View e10 = bVar.e(this);
        this.A = e10;
        return e10;
    }

    @Override // u.b, android.view.MenuItem
    public int getAlphabeticModifiers() {
        return this.f1207k;
    }

    @Override // android.view.MenuItem
    public char getAlphabeticShortcut() {
        return this.f1206j;
    }

    @Override // u.b, android.view.MenuItem
    public CharSequence getContentDescription() {
        return this.f1214r;
    }

    @Override // android.view.MenuItem
    public int getGroupId() {
        return this.f1198b;
    }

    @Override // android.view.MenuItem
    public Drawable getIcon() {
        Drawable drawable = this.f1208l;
        if (drawable != null) {
            return e(drawable);
        }
        if (this.f1209m == 0) {
            return null;
        }
        Drawable d10 = d.b.d(this.f1210n.getContext(), this.f1209m);
        this.f1209m = 0;
        this.f1208l = d10;
        return e(d10);
    }

    @Override // u.b, android.view.MenuItem
    public ColorStateList getIconTintList() {
        return this.f1216t;
    }

    @Override // u.b, android.view.MenuItem
    public PorterDuff.Mode getIconTintMode() {
        return this.f1217u;
    }

    @Override // android.view.MenuItem
    public Intent getIntent() {
        return this.f1203g;
    }

    @Override // android.view.MenuItem
    public int getItemId() {
        return this.f1197a;
    }

    @Override // android.view.MenuItem
    public ContextMenu.ContextMenuInfo getMenuInfo() {
        return this.E;
    }

    @Override // u.b, android.view.MenuItem
    public int getNumericModifiers() {
        return this.f1205i;
    }

    @Override // android.view.MenuItem
    public char getNumericShortcut() {
        return this.f1204h;
    }

    @Override // android.view.MenuItem
    public int getOrder() {
        return this.f1199c;
    }

    @Override // android.view.MenuItem
    public SubMenu getSubMenu() {
        return this.f1211o;
    }

    @Override // android.view.MenuItem
    public CharSequence getTitle() {
        return this.f1201e;
    }

    @Override // android.view.MenuItem
    public CharSequence getTitleCondensed() {
        CharSequence charSequence = this.f1202f;
        return charSequence != null ? charSequence : this.f1201e;
    }

    @Override // u.b, android.view.MenuItem
    public CharSequence getTooltipText() {
        return this.f1215s;
    }

    public String h() {
        char g10 = g();
        if (g10 == 0) {
            return "";
        }
        Resources resources = this.f1210n.getContext().getResources();
        StringBuilder sb = new StringBuilder();
        if (ViewConfiguration.get(this.f1210n.getContext()).hasPermanentMenuKey()) {
            sb.append(resources.getString(R$string.abc_prepend_shortcut_label));
        }
        int i10 = this.f1210n.isQwertyMode() ? this.f1207k : this.f1205i;
        d(sb, i10, 65536, resources.getString(R$string.abc_menu_meta_shortcut_label));
        d(sb, i10, 4096, resources.getString(R$string.abc_menu_ctrl_shortcut_label));
        d(sb, i10, 2, resources.getString(R$string.abc_menu_alt_shortcut_label));
        d(sb, i10, 1, resources.getString(R$string.abc_menu_shift_shortcut_label));
        d(sb, i10, 4, resources.getString(R$string.abc_menu_sym_shortcut_label));
        d(sb, i10, 8, resources.getString(R$string.abc_menu_function_shortcut_label));
        if (g10 == '\b') {
            sb.append(resources.getString(R$string.abc_menu_delete_shortcut_label));
        } else if (g10 == '\n') {
            sb.append(resources.getString(R$string.abc_menu_enter_shortcut_label));
        } else if (g10 != ' ') {
            sb.append(g10);
        } else {
            sb.append(resources.getString(R$string.abc_menu_space_shortcut_label));
        }
        return sb.toString();
    }

    @Override // android.view.MenuItem
    public boolean hasSubMenu() {
        return this.f1211o != null;
    }

    public CharSequence i(n.a aVar) {
        return (aVar == null || !aVar.prefersCondensedTitle()) ? getTitle() : getTitleCondensed();
    }

    @Override // u.b, android.view.MenuItem
    public boolean isActionViewExpanded() {
        return this.D;
    }

    @Override // android.view.MenuItem
    public boolean isCheckable() {
        return (this.f1221y & 1) == 1;
    }

    @Override // android.view.MenuItem
    public boolean isChecked() {
        return (this.f1221y & 2) == 2;
    }

    @Override // android.view.MenuItem
    public boolean isEnabled() {
        return (this.f1221y & 16) != 0;
    }

    @Override // android.view.MenuItem
    public boolean isVisible() {
        b0.b bVar = this.B;
        return (bVar == null || !bVar.h()) ? (this.f1221y & 8) == 0 : (this.f1221y & 8) == 0 && this.B.c();
    }

    public boolean j() {
        b0.b bVar;
        if ((this.f1222z & 8) == 0) {
            return false;
        }
        if (this.A == null && (bVar = this.B) != null) {
            this.A = bVar.e(this);
        }
        return this.A != null;
    }

    public boolean k() {
        MenuItem.OnMenuItemClickListener onMenuItemClickListener = this.f1213q;
        if (onMenuItemClickListener != null && onMenuItemClickListener.onMenuItemClick(this)) {
            return true;
        }
        g gVar = this.f1210n;
        if (gVar.dispatchMenuItemSelected(gVar, this)) {
            return true;
        }
        Runnable runnable = this.f1212p;
        if (runnable != null) {
            runnable.run();
            return true;
        }
        if (this.f1203g != null) {
            try {
                this.f1210n.getContext().startActivity(this.f1203g);
                return true;
            } catch (ActivityNotFoundException e10) {
                Log.e("MenuItemImpl", "Can't find activity to handle intent; ignoring", e10);
            }
        }
        b0.b bVar = this.B;
        return bVar != null && bVar.f();
    }

    public boolean l() {
        return (this.f1221y & 32) == 32;
    }

    public boolean m() {
        return (this.f1221y & 4) != 0;
    }

    public boolean n() {
        return (this.f1222z & 1) == 1;
    }

    public boolean o() {
        return (this.f1222z & 2) == 2;
    }

    @Override // u.b, android.view.MenuItem
    /* renamed from: p, reason: merged with bridge method [inline-methods] */
    public u.b setActionView(int i10) {
        Context context = this.f1210n.getContext();
        setActionView(LayoutInflater.from(context).inflate(i10, (ViewGroup) new LinearLayout(context), false));
        return this;
    }

    @Override // u.b, android.view.MenuItem
    /* renamed from: q, reason: merged with bridge method [inline-methods] */
    public u.b setActionView(View view) {
        int i10;
        this.A = view;
        this.B = null;
        if (view != null && view.getId() == -1 && (i10 = this.f1197a) > 0) {
            view.setId(i10);
        }
        this.f1210n.onItemActionRequestChanged(this);
        return this;
    }

    public void r(boolean z10) {
        this.D = z10;
        this.f1210n.onItemsChanged(false);
    }

    public void s(boolean z10) {
        int i10 = this.f1221y;
        int i11 = (z10 ? 2 : 0) | (i10 & (-3));
        this.f1221y = i11;
        if (i10 != i11) {
            this.f1210n.onItemsChanged(false);
        }
    }

    @Override // android.view.MenuItem
    public MenuItem setActionProvider(ActionProvider actionProvider) {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.setActionProvider()");
    }

    @Override // android.view.MenuItem
    public MenuItem setAlphabeticShortcut(char c10) {
        if (this.f1206j == c10) {
            return this;
        }
        this.f1206j = Character.toLowerCase(c10);
        this.f1210n.onItemsChanged(false);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setCheckable(boolean z10) {
        int i10 = this.f1221y;
        int i11 = (z10 ? 1 : 0) | (i10 & (-2));
        this.f1221y = i11;
        if (i10 != i11) {
            this.f1210n.onItemsChanged(false);
        }
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setChecked(boolean z10) {
        if ((this.f1221y & 4) != 0) {
            this.f1210n.setExclusiveItemChecked(this);
        } else {
            s(z10);
        }
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setEnabled(boolean z10) {
        if (z10) {
            this.f1221y |= 16;
        } else {
            this.f1221y &= -17;
        }
        this.f1210n.onItemsChanged(false);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(Drawable drawable) {
        this.f1209m = 0;
        this.f1208l = drawable;
        this.f1220x = true;
        this.f1210n.onItemsChanged(false);
        return this;
    }

    @Override // u.b, android.view.MenuItem
    public MenuItem setIconTintList(ColorStateList colorStateList) {
        this.f1216t = colorStateList;
        this.f1218v = true;
        this.f1220x = true;
        this.f1210n.onItemsChanged(false);
        return this;
    }

    @Override // u.b, android.view.MenuItem
    public MenuItem setIconTintMode(PorterDuff.Mode mode) {
        this.f1217u = mode;
        this.f1219w = true;
        this.f1220x = true;
        this.f1210n.onItemsChanged(false);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIntent(Intent intent) {
        this.f1203g = intent;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setNumericShortcut(char c10) {
        if (this.f1204h == c10) {
            return this;
        }
        this.f1204h = c10;
        this.f1210n.onItemsChanged(false);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener onActionExpandListener) {
        this.C = onActionExpandListener;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        this.f1213q = onMenuItemClickListener;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setShortcut(char c10, char c11) {
        this.f1204h = c10;
        this.f1206j = Character.toLowerCase(c11);
        this.f1210n.onItemsChanged(false);
        return this;
    }

    @Override // u.b, android.view.MenuItem
    public void setShowAsAction(int i10) {
        int i11 = i10 & 3;
        if (i11 != 0 && i11 != 1 && i11 != 2) {
            throw new IllegalArgumentException("SHOW_AS_ACTION_ALWAYS, SHOW_AS_ACTION_IF_ROOM, and SHOW_AS_ACTION_NEVER are mutually exclusive.");
        }
        this.f1222z = i10;
        this.f1210n.onItemActionRequestChanged(this);
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(CharSequence charSequence) {
        this.f1201e = charSequence;
        this.f1210n.onItemsChanged(false);
        r rVar = this.f1211o;
        if (rVar != null) {
            rVar.setHeaderTitle(charSequence);
        }
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitleCondensed(CharSequence charSequence) {
        this.f1202f = charSequence;
        this.f1210n.onItemsChanged(false);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setVisible(boolean z10) {
        if (y(z10)) {
            this.f1210n.onItemVisibleChanged(this);
        }
        return this;
    }

    public void t(boolean z10) {
        this.f1221y = (z10 ? 4 : 0) | (this.f1221y & (-5));
    }

    public String toString() {
        CharSequence charSequence = this.f1201e;
        if (charSequence != null) {
            return charSequence.toString();
        }
        return null;
    }

    public void u(boolean z10) {
        if (z10) {
            this.f1221y |= 32;
        } else {
            this.f1221y &= -33;
        }
    }

    public void v(ContextMenu.ContextMenuInfo contextMenuInfo) {
        this.E = contextMenuInfo;
    }

    @Override // u.b, android.view.MenuItem
    /* renamed from: w, reason: merged with bridge method [inline-methods] */
    public u.b setShowAsActionFlags(int i10) {
        setShowAsAction(i10);
        return this;
    }

    public void x(r rVar) {
        this.f1211o = rVar;
        rVar.setHeaderTitle(getTitle());
    }

    public boolean y(boolean z10) {
        int i10 = this.f1221y;
        int i11 = (z10 ? 0 : 8) | (i10 & (-9));
        this.f1221y = i11;
        return i10 != i11;
    }

    public boolean z() {
        return this.f1210n.getOptionalIconsVisible();
    }

    @Override // android.view.MenuItem
    public u.b setContentDescription(CharSequence charSequence) {
        this.f1214r = charSequence;
        this.f1210n.onItemsChanged(false);
        return this;
    }

    @Override // android.view.MenuItem
    public u.b setTooltipText(CharSequence charSequence) {
        this.f1215s = charSequence;
        this.f1210n.onItemsChanged(false);
        return this;
    }

    @Override // u.b, android.view.MenuItem
    public MenuItem setAlphabeticShortcut(char c10, int i10) {
        if (this.f1206j == c10 && this.f1207k == i10) {
            return this;
        }
        this.f1206j = Character.toLowerCase(c10);
        this.f1207k = KeyEvent.normalizeMetaState(i10);
        this.f1210n.onItemsChanged(false);
        return this;
    }

    @Override // u.b, android.view.MenuItem
    public MenuItem setNumericShortcut(char c10, int i10) {
        if (this.f1204h == c10 && this.f1205i == i10) {
            return this;
        }
        this.f1204h = c10;
        this.f1205i = KeyEvent.normalizeMetaState(i10);
        this.f1210n.onItemsChanged(false);
        return this;
    }

    @Override // u.b, android.view.MenuItem
    public MenuItem setShortcut(char c10, char c11, int i10, int i11) {
        this.f1204h = c10;
        this.f1205i = KeyEvent.normalizeMetaState(i10);
        this.f1206j = Character.toLowerCase(c11);
        this.f1207k = KeyEvent.normalizeMetaState(i11);
        this.f1210n.onItemsChanged(false);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(int i10) {
        this.f1208l = null;
        this.f1209m = i10;
        this.f1220x = true;
        this.f1210n.onItemsChanged(false);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(int i10) {
        return setTitle(this.f1210n.getContext().getString(i10));
    }
}
