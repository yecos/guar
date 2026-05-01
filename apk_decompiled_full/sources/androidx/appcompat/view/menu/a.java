package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.view.ActionProvider;
import android.view.ContextMenu;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

/* loaded from: classes.dex */
public class a implements u.b {

    /* renamed from: a, reason: collision with root package name */
    public final int f1105a;

    /* renamed from: b, reason: collision with root package name */
    public final int f1106b;

    /* renamed from: c, reason: collision with root package name */
    public final int f1107c;

    /* renamed from: d, reason: collision with root package name */
    public final int f1108d;

    /* renamed from: e, reason: collision with root package name */
    public CharSequence f1109e;

    /* renamed from: f, reason: collision with root package name */
    public CharSequence f1110f;

    /* renamed from: g, reason: collision with root package name */
    public Intent f1111g;

    /* renamed from: h, reason: collision with root package name */
    public char f1112h;

    /* renamed from: j, reason: collision with root package name */
    public char f1114j;

    /* renamed from: l, reason: collision with root package name */
    public Drawable f1116l;

    /* renamed from: n, reason: collision with root package name */
    public Context f1118n;

    /* renamed from: o, reason: collision with root package name */
    public MenuItem.OnMenuItemClickListener f1119o;

    /* renamed from: p, reason: collision with root package name */
    public CharSequence f1120p;

    /* renamed from: q, reason: collision with root package name */
    public CharSequence f1121q;

    /* renamed from: i, reason: collision with root package name */
    public int f1113i = 4096;

    /* renamed from: k, reason: collision with root package name */
    public int f1115k = 4096;

    /* renamed from: m, reason: collision with root package name */
    public int f1117m = 0;

    /* renamed from: r, reason: collision with root package name */
    public ColorStateList f1122r = null;

    /* renamed from: s, reason: collision with root package name */
    public PorterDuff.Mode f1123s = null;

    /* renamed from: t, reason: collision with root package name */
    public boolean f1124t = false;

    /* renamed from: u, reason: collision with root package name */
    public boolean f1125u = false;

    /* renamed from: v, reason: collision with root package name */
    public int f1126v = 16;

    public a(Context context, int i10, int i11, int i12, int i13, CharSequence charSequence) {
        this.f1118n = context;
        this.f1105a = i11;
        this.f1106b = i10;
        this.f1107c = i12;
        this.f1108d = i13;
        this.f1109e = charSequence;
    }

    @Override // u.b
    public b0.b a() {
        return null;
    }

    @Override // u.b
    public u.b b(b0.b bVar) {
        throw new UnsupportedOperationException();
    }

    public final void c() {
        Drawable drawable = this.f1116l;
        if (drawable != null) {
            if (this.f1124t || this.f1125u) {
                Drawable r10 = s.h.r(drawable);
                this.f1116l = r10;
                Drawable mutate = r10.mutate();
                this.f1116l = mutate;
                if (this.f1124t) {
                    s.h.o(mutate, this.f1122r);
                }
                if (this.f1125u) {
                    s.h.p(this.f1116l, this.f1123s);
                }
            }
        }
    }

    @Override // u.b, android.view.MenuItem
    public boolean collapseActionView() {
        return false;
    }

    @Override // u.b, android.view.MenuItem
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public u.b setActionView(int i10) {
        throw new UnsupportedOperationException();
    }

    @Override // u.b, android.view.MenuItem
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public u.b setActionView(View view) {
        throw new UnsupportedOperationException();
    }

    @Override // u.b, android.view.MenuItem
    public boolean expandActionView() {
        return false;
    }

    @Override // u.b, android.view.MenuItem
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public u.b setShowAsActionFlags(int i10) {
        setShowAsAction(i10);
        return this;
    }

    @Override // android.view.MenuItem
    public ActionProvider getActionProvider() {
        throw new UnsupportedOperationException();
    }

    @Override // u.b, android.view.MenuItem
    public View getActionView() {
        return null;
    }

    @Override // u.b, android.view.MenuItem
    public int getAlphabeticModifiers() {
        return this.f1115k;
    }

    @Override // android.view.MenuItem
    public char getAlphabeticShortcut() {
        return this.f1114j;
    }

    @Override // u.b, android.view.MenuItem
    public CharSequence getContentDescription() {
        return this.f1120p;
    }

    @Override // android.view.MenuItem
    public int getGroupId() {
        return this.f1106b;
    }

    @Override // android.view.MenuItem
    public Drawable getIcon() {
        return this.f1116l;
    }

    @Override // u.b, android.view.MenuItem
    public ColorStateList getIconTintList() {
        return this.f1122r;
    }

    @Override // u.b, android.view.MenuItem
    public PorterDuff.Mode getIconTintMode() {
        return this.f1123s;
    }

    @Override // android.view.MenuItem
    public Intent getIntent() {
        return this.f1111g;
    }

    @Override // android.view.MenuItem
    public int getItemId() {
        return this.f1105a;
    }

    @Override // android.view.MenuItem
    public ContextMenu.ContextMenuInfo getMenuInfo() {
        return null;
    }

    @Override // u.b, android.view.MenuItem
    public int getNumericModifiers() {
        return this.f1113i;
    }

    @Override // android.view.MenuItem
    public char getNumericShortcut() {
        return this.f1112h;
    }

    @Override // android.view.MenuItem
    public int getOrder() {
        return this.f1108d;
    }

    @Override // android.view.MenuItem
    public SubMenu getSubMenu() {
        return null;
    }

    @Override // android.view.MenuItem
    public CharSequence getTitle() {
        return this.f1109e;
    }

    @Override // android.view.MenuItem
    public CharSequence getTitleCondensed() {
        CharSequence charSequence = this.f1110f;
        return charSequence != null ? charSequence : this.f1109e;
    }

    @Override // u.b, android.view.MenuItem
    public CharSequence getTooltipText() {
        return this.f1121q;
    }

    @Override // android.view.MenuItem
    public boolean hasSubMenu() {
        return false;
    }

    @Override // u.b, android.view.MenuItem
    public boolean isActionViewExpanded() {
        return false;
    }

    @Override // android.view.MenuItem
    public boolean isCheckable() {
        return (this.f1126v & 1) != 0;
    }

    @Override // android.view.MenuItem
    public boolean isChecked() {
        return (this.f1126v & 2) != 0;
    }

    @Override // android.view.MenuItem
    public boolean isEnabled() {
        return (this.f1126v & 16) != 0;
    }

    @Override // android.view.MenuItem
    public boolean isVisible() {
        return (this.f1126v & 8) == 0;
    }

    @Override // android.view.MenuItem
    public MenuItem setActionProvider(ActionProvider actionProvider) {
        throw new UnsupportedOperationException();
    }

    @Override // android.view.MenuItem
    public MenuItem setAlphabeticShortcut(char c10) {
        this.f1114j = Character.toLowerCase(c10);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setCheckable(boolean z10) {
        this.f1126v = (z10 ? 1 : 0) | (this.f1126v & (-2));
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setChecked(boolean z10) {
        this.f1126v = (z10 ? 2 : 0) | (this.f1126v & (-3));
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setEnabled(boolean z10) {
        this.f1126v = (z10 ? 16 : 0) | (this.f1126v & (-17));
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(Drawable drawable) {
        this.f1116l = drawable;
        this.f1117m = 0;
        c();
        return this;
    }

    @Override // u.b, android.view.MenuItem
    public MenuItem setIconTintList(ColorStateList colorStateList) {
        this.f1122r = colorStateList;
        this.f1124t = true;
        c();
        return this;
    }

    @Override // u.b, android.view.MenuItem
    public MenuItem setIconTintMode(PorterDuff.Mode mode) {
        this.f1123s = mode;
        this.f1125u = true;
        c();
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIntent(Intent intent) {
        this.f1111g = intent;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setNumericShortcut(char c10) {
        this.f1112h = c10;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener onActionExpandListener) {
        throw new UnsupportedOperationException();
    }

    @Override // android.view.MenuItem
    public MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        this.f1119o = onMenuItemClickListener;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setShortcut(char c10, char c11) {
        this.f1112h = c10;
        this.f1114j = Character.toLowerCase(c11);
        return this;
    }

    @Override // u.b, android.view.MenuItem
    public void setShowAsAction(int i10) {
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(CharSequence charSequence) {
        this.f1109e = charSequence;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitleCondensed(CharSequence charSequence) {
        this.f1110f = charSequence;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setVisible(boolean z10) {
        this.f1126v = (this.f1126v & 8) | (z10 ? 0 : 8);
        return this;
    }

    @Override // u.b, android.view.MenuItem
    public MenuItem setAlphabeticShortcut(char c10, int i10) {
        this.f1114j = Character.toLowerCase(c10);
        this.f1115k = KeyEvent.normalizeMetaState(i10);
        return this;
    }

    @Override // android.view.MenuItem
    public u.b setContentDescription(CharSequence charSequence) {
        this.f1120p = charSequence;
        return this;
    }

    @Override // u.b, android.view.MenuItem
    public MenuItem setNumericShortcut(char c10, int i10) {
        this.f1112h = c10;
        this.f1113i = KeyEvent.normalizeMetaState(i10);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(int i10) {
        this.f1109e = this.f1118n.getResources().getString(i10);
        return this;
    }

    @Override // android.view.MenuItem
    public u.b setTooltipText(CharSequence charSequence) {
        this.f1121q = charSequence;
        return this;
    }

    @Override // u.b, android.view.MenuItem
    public MenuItem setShortcut(char c10, char c11, int i10, int i11) {
        this.f1112h = c10;
        this.f1113i = KeyEvent.normalizeMetaState(i10);
        this.f1114j = Character.toLowerCase(c11);
        this.f1115k = KeyEvent.normalizeMetaState(i11);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(int i10) {
        this.f1117m = i10;
        this.f1116l = p.a.getDrawable(this.f1118n, i10);
        c();
        return this;
    }
}
