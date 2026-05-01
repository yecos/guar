package androidx.appcompat.view.menu;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.appcompat.R$attr;
import androidx.appcompat.R$id;
import androidx.appcompat.R$layout;
import androidx.appcompat.R$styleable;
import androidx.appcompat.view.menu.n;
import androidx.appcompat.widget.r2;
import b0.c1;

/* loaded from: classes.dex */
public class ListMenuItemView extends LinearLayout implements n.a, AbsListView.SelectionBoundsAdjuster {

    /* renamed from: a, reason: collision with root package name */
    public i f1087a;

    /* renamed from: b, reason: collision with root package name */
    public ImageView f1088b;

    /* renamed from: c, reason: collision with root package name */
    public RadioButton f1089c;

    /* renamed from: d, reason: collision with root package name */
    public TextView f1090d;

    /* renamed from: e, reason: collision with root package name */
    public CheckBox f1091e;

    /* renamed from: f, reason: collision with root package name */
    public TextView f1092f;

    /* renamed from: g, reason: collision with root package name */
    public ImageView f1093g;

    /* renamed from: h, reason: collision with root package name */
    public ImageView f1094h;

    /* renamed from: i, reason: collision with root package name */
    public LinearLayout f1095i;

    /* renamed from: j, reason: collision with root package name */
    public Drawable f1096j;

    /* renamed from: k, reason: collision with root package name */
    public int f1097k;

    /* renamed from: l, reason: collision with root package name */
    public Context f1098l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f1099m;

    /* renamed from: n, reason: collision with root package name */
    public Drawable f1100n;

    /* renamed from: o, reason: collision with root package name */
    public boolean f1101o;

    /* renamed from: p, reason: collision with root package name */
    public int f1102p;

    /* renamed from: q, reason: collision with root package name */
    public LayoutInflater f1103q;

    /* renamed from: r, reason: collision with root package name */
    public boolean f1104r;

    public ListMenuItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.listMenuViewStyle);
    }

    private LayoutInflater getInflater() {
        if (this.f1103q == null) {
            this.f1103q = LayoutInflater.from(getContext());
        }
        return this.f1103q;
    }

    private void setSubMenuArrowVisible(boolean z10) {
        ImageView imageView = this.f1093g;
        if (imageView != null) {
            imageView.setVisibility(z10 ? 0 : 8);
        }
    }

    public final void a(View view) {
        b(view, -1);
    }

    @Override // android.widget.AbsListView.SelectionBoundsAdjuster
    public void adjustListItemSelectionBounds(Rect rect) {
        ImageView imageView = this.f1094h;
        if (imageView == null || imageView.getVisibility() != 0) {
            return;
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f1094h.getLayoutParams();
        rect.top += this.f1094h.getHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
    }

    public final void b(View view, int i10) {
        LinearLayout linearLayout = this.f1095i;
        if (linearLayout != null) {
            linearLayout.addView(view, i10);
        } else {
            addView(view, i10);
        }
    }

    public final void c() {
        CheckBox checkBox = (CheckBox) getInflater().inflate(R$layout.abc_list_menu_item_checkbox, (ViewGroup) this, false);
        this.f1091e = checkBox;
        a(checkBox);
    }

    public final void d() {
        ImageView imageView = (ImageView) getInflater().inflate(R$layout.abc_list_menu_item_icon, (ViewGroup) this, false);
        this.f1088b = imageView;
        b(imageView, 0);
    }

    public final void e() {
        RadioButton radioButton = (RadioButton) getInflater().inflate(R$layout.abc_list_menu_item_radio, (ViewGroup) this, false);
        this.f1089c = radioButton;
        a(radioButton);
    }

    public void f(boolean z10, char c10) {
        int i10 = (z10 && this.f1087a.A()) ? 0 : 8;
        if (i10 == 0) {
            this.f1092f.setText(this.f1087a.h());
        }
        if (this.f1092f.getVisibility() != i10) {
            this.f1092f.setVisibility(i10);
        }
    }

    @Override // androidx.appcompat.view.menu.n.a
    public i getItemData() {
        return this.f1087a;
    }

    @Override // androidx.appcompat.view.menu.n.a
    public void initialize(i iVar, int i10) {
        this.f1087a = iVar;
        this.f1102p = i10;
        setVisibility(iVar.isVisible() ? 0 : 8);
        setTitle(iVar.i(this));
        setCheckable(iVar.isCheckable());
        f(iVar.A(), iVar.g());
        setIcon(iVar.getIcon());
        setEnabled(iVar.isEnabled());
        setSubMenuArrowVisible(iVar.hasSubMenu());
        setContentDescription(iVar.getContentDescription());
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        c1.o0(this, this.f1096j);
        TextView textView = (TextView) findViewById(R$id.title);
        this.f1090d = textView;
        int i10 = this.f1097k;
        if (i10 != -1) {
            textView.setTextAppearance(this.f1098l, i10);
        }
        this.f1092f = (TextView) findViewById(R$id.shortcut);
        ImageView imageView = (ImageView) findViewById(R$id.submenuarrow);
        this.f1093g = imageView;
        if (imageView != null) {
            imageView.setImageDrawable(this.f1100n);
        }
        this.f1094h = (ImageView) findViewById(R$id.group_divider);
        this.f1095i = (LinearLayout) findViewById(R$id.content);
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int i10, int i11) {
        if (this.f1088b != null && this.f1099m) {
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.f1088b.getLayoutParams();
            int i12 = layoutParams.height;
            if (i12 > 0 && layoutParams2.width <= 0) {
                layoutParams2.width = i12;
            }
        }
        super.onMeasure(i10, i11);
    }

    @Override // androidx.appcompat.view.menu.n.a
    public boolean prefersCondensedTitle() {
        return false;
    }

    public void setCheckable(boolean z10) {
        CompoundButton compoundButton;
        View view;
        if (!z10 && this.f1089c == null && this.f1091e == null) {
            return;
        }
        if (this.f1087a.m()) {
            if (this.f1089c == null) {
                e();
            }
            compoundButton = this.f1089c;
            view = this.f1091e;
        } else {
            if (this.f1091e == null) {
                c();
            }
            compoundButton = this.f1091e;
            view = this.f1089c;
        }
        if (z10) {
            compoundButton.setChecked(this.f1087a.isChecked());
            if (compoundButton.getVisibility() != 0) {
                compoundButton.setVisibility(0);
            }
            if (view == null || view.getVisibility() == 8) {
                return;
            }
            view.setVisibility(8);
            return;
        }
        CheckBox checkBox = this.f1091e;
        if (checkBox != null) {
            checkBox.setVisibility(8);
        }
        RadioButton radioButton = this.f1089c;
        if (radioButton != null) {
            radioButton.setVisibility(8);
        }
    }

    public void setChecked(boolean z10) {
        CompoundButton compoundButton;
        if (this.f1087a.m()) {
            if (this.f1089c == null) {
                e();
            }
            compoundButton = this.f1089c;
        } else {
            if (this.f1091e == null) {
                c();
            }
            compoundButton = this.f1091e;
        }
        compoundButton.setChecked(z10);
    }

    public void setForceShowIcon(boolean z10) {
        this.f1104r = z10;
        this.f1099m = z10;
    }

    public void setGroupDividerEnabled(boolean z10) {
        ImageView imageView = this.f1094h;
        if (imageView != null) {
            imageView.setVisibility((this.f1101o || !z10) ? 8 : 0);
        }
    }

    public void setIcon(Drawable drawable) {
        boolean z10 = this.f1087a.z() || this.f1104r;
        if (z10 || this.f1099m) {
            ImageView imageView = this.f1088b;
            if (imageView == null && drawable == null && !this.f1099m) {
                return;
            }
            if (imageView == null) {
                d();
            }
            if (drawable == null && !this.f1099m) {
                this.f1088b.setVisibility(8);
                return;
            }
            ImageView imageView2 = this.f1088b;
            if (!z10) {
                drawable = null;
            }
            imageView2.setImageDrawable(drawable);
            if (this.f1088b.getVisibility() != 0) {
                this.f1088b.setVisibility(0);
            }
        }
    }

    public void setTitle(CharSequence charSequence) {
        if (charSequence == null) {
            if (this.f1090d.getVisibility() != 8) {
                this.f1090d.setVisibility(8);
            }
        } else {
            this.f1090d.setText(charSequence);
            if (this.f1090d.getVisibility() != 0) {
                this.f1090d.setVisibility(0);
            }
        }
    }

    public ListMenuItemView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet);
        r2 u10 = r2.u(getContext(), attributeSet, R$styleable.C, i10, 0);
        this.f1096j = u10.g(R$styleable.MenuView_android_itemBackground);
        this.f1097k = u10.n(R$styleable.MenuView_android_itemTextAppearance, -1);
        this.f1099m = u10.a(R$styleable.MenuView_preserveIconSpacing, false);
        this.f1098l = context;
        this.f1100n = u10.g(R$styleable.MenuView_subMenuArrow);
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(null, new int[]{R.attr.divider}, R$attr.dropDownListViewStyle, 0);
        this.f1101o = obtainStyledAttributes.hasValue(0);
        u10.v();
        obtainStyledAttributes.recycle();
    }
}
