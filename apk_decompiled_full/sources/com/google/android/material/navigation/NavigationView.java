package com.google.android.material.navigation;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import androidx.appcompat.R$attr;
import androidx.appcompat.view.menu.g;
import androidx.appcompat.view.menu.i;
import androidx.appcompat.widget.r2;
import b0.c1;
import b0.f2;
import com.google.android.material.internal.NavigationMenu;
import com.google.android.material.internal.NavigationMenuPresenter;
import com.google.android.material.internal.ScrimInsetsFrameLayout;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.MaterialShapeUtils;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.common.primitives.Ints;
import d.b;
import g.g;

/* loaded from: classes2.dex */
public class NavigationView extends ScrimInsetsFrameLayout {
    private static final int[] CHECKED_STATE_SET = {R.attr.state_checked};
    private static final int[] DISABLED_STATE_SET = {-16842910};
    private static final int PRESENTER_NAVIGATION_VIEW_ID = 1;
    OnNavigationItemSelectedListener listener;
    private final int maxWidth;
    private final NavigationMenu menu;
    private MenuInflater menuInflater;
    private ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener;
    private final NavigationMenuPresenter presenter;
    private final int[] tmpLocation;

    public interface OnNavigationItemSelectedListener {
        boolean onNavigationItemSelected(MenuItem menuItem);
    }

    public NavigationView(Context context) {
        this(context, null);
    }

    private ColorStateList createDefaultColorStateList(int i10) {
        TypedValue typedValue = new TypedValue();
        if (!getContext().getTheme().resolveAttribute(i10, typedValue, true)) {
            return null;
        }
        ColorStateList c10 = b.c(getContext(), typedValue.resourceId);
        if (!getContext().getTheme().resolveAttribute(R$attr.colorPrimary, typedValue, true)) {
            return null;
        }
        int i11 = typedValue.data;
        int defaultColor = c10.getDefaultColor();
        int[] iArr = DISABLED_STATE_SET;
        return new ColorStateList(new int[][]{iArr, CHECKED_STATE_SET, FrameLayout.EMPTY_STATE_SET}, new int[]{c10.getColorForState(iArr, defaultColor), i11, defaultColor});
    }

    private final Drawable createDefaultItemBackground(r2 r2Var) {
        MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable(ShapeAppearanceModel.builder(getContext(), r2Var.n(com.google.android.material.R.styleable.NavigationView_itemShapeAppearance, 0), r2Var.n(com.google.android.material.R.styleable.NavigationView_itemShapeAppearanceOverlay, 0)).build());
        materialShapeDrawable.setFillColor(MaterialResources.getColorStateList(getContext(), r2Var, com.google.android.material.R.styleable.NavigationView_itemShapeFillColor));
        return new InsetDrawable((Drawable) materialShapeDrawable, r2Var.f(com.google.android.material.R.styleable.NavigationView_itemShapeInsetStart, 0), r2Var.f(com.google.android.material.R.styleable.NavigationView_itemShapeInsetTop, 0), r2Var.f(com.google.android.material.R.styleable.NavigationView_itemShapeInsetEnd, 0), r2Var.f(com.google.android.material.R.styleable.NavigationView_itemShapeInsetBottom, 0));
    }

    private MenuInflater getMenuInflater() {
        if (this.menuInflater == null) {
            this.menuInflater = new g(getContext());
        }
        return this.menuInflater;
    }

    private boolean hasShapeAppearance(r2 r2Var) {
        return r2Var.r(com.google.android.material.R.styleable.NavigationView_itemShapeAppearance) || r2Var.r(com.google.android.material.R.styleable.NavigationView_itemShapeAppearanceOverlay);
    }

    private void setupInsetScrimsListener() {
        this.onGlobalLayoutListener = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.google.android.material.navigation.NavigationView.2
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                int navigationBarColor;
                NavigationView navigationView = NavigationView.this;
                navigationView.getLocationOnScreen(navigationView.tmpLocation);
                boolean z10 = NavigationView.this.tmpLocation[1] == 0;
                NavigationView.this.presenter.setBehindStatusBar(z10);
                NavigationView.this.setDrawTopInsetForeground(z10);
                Context context = NavigationView.this.getContext();
                if (!(context instanceof Activity) || Build.VERSION.SDK_INT < 21) {
                    return;
                }
                Activity activity = (Activity) context;
                boolean z11 = activity.findViewById(R.id.content).getHeight() == NavigationView.this.getHeight();
                navigationBarColor = activity.getWindow().getNavigationBarColor();
                NavigationView.this.setDrawBottomInsetForeground(z11 && (Color.alpha(navigationBarColor) != 0));
            }
        };
        getViewTreeObserver().addOnGlobalLayoutListener(this.onGlobalLayoutListener);
    }

    public void addHeaderView(View view) {
        this.presenter.addHeaderView(view);
    }

    public MenuItem getCheckedItem() {
        return this.presenter.getCheckedItem();
    }

    public int getHeaderCount() {
        return this.presenter.getHeaderCount();
    }

    public View getHeaderView(int i10) {
        return this.presenter.getHeaderView(i10);
    }

    public Drawable getItemBackground() {
        return this.presenter.getItemBackground();
    }

    public int getItemHorizontalPadding() {
        return this.presenter.getItemHorizontalPadding();
    }

    public int getItemIconPadding() {
        return this.presenter.getItemIconPadding();
    }

    public ColorStateList getItemIconTintList() {
        return this.presenter.getItemTintList();
    }

    public int getItemMaxLines() {
        return this.presenter.getItemMaxLines();
    }

    public ColorStateList getItemTextColor() {
        return this.presenter.getItemTextColor();
    }

    public Menu getMenu() {
        return this.menu;
    }

    public View inflateHeaderView(int i10) {
        return this.presenter.inflateHeaderView(i10);
    }

    public void inflateMenu(int i10) {
        this.presenter.setUpdateSuspended(true);
        getMenuInflater().inflate(i10, this.menu);
        this.presenter.setUpdateSuspended(false);
        this.presenter.updateMenuView(false);
    }

    @Override // com.google.android.material.internal.ScrimInsetsFrameLayout, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        MaterialShapeUtils.setParentAbsoluteElevation(this);
    }

    @Override // com.google.android.material.internal.ScrimInsetsFrameLayout, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        getViewTreeObserver().removeOnGlobalLayoutListener(this.onGlobalLayoutListener);
    }

    @Override // com.google.android.material.internal.ScrimInsetsFrameLayout
    public void onInsetsChanged(f2 f2Var) {
        this.presenter.dispatchApplyWindowInsets(f2Var);
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i10, int i11) {
        int mode = View.MeasureSpec.getMode(i10);
        if (mode == Integer.MIN_VALUE) {
            i10 = View.MeasureSpec.makeMeasureSpec(Math.min(View.MeasureSpec.getSize(i10), this.maxWidth), Ints.MAX_POWER_OF_TWO);
        } else if (mode == 0) {
            i10 = View.MeasureSpec.makeMeasureSpec(this.maxWidth, Ints.MAX_POWER_OF_TWO);
        }
        super.onMeasure(i10, i11);
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.menu.restorePresenterStates(savedState.menuState);
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        Bundle bundle = new Bundle();
        savedState.menuState = bundle;
        this.menu.savePresenterStates(bundle);
        return savedState;
    }

    public void removeHeaderView(View view) {
        this.presenter.removeHeaderView(view);
    }

    public void setCheckedItem(int i10) {
        MenuItem findItem = this.menu.findItem(i10);
        if (findItem != null) {
            this.presenter.setCheckedItem((i) findItem);
        }
    }

    @Override // android.view.View
    public void setElevation(float f10) {
        if (Build.VERSION.SDK_INT >= 21) {
            super.setElevation(f10);
        }
        MaterialShapeUtils.setElevation(this, f10);
    }

    public void setItemBackground(Drawable drawable) {
        this.presenter.setItemBackground(drawable);
    }

    public void setItemBackgroundResource(int i10) {
        setItemBackground(p.a.getDrawable(getContext(), i10));
    }

    public void setItemHorizontalPadding(int i10) {
        this.presenter.setItemHorizontalPadding(i10);
    }

    public void setItemHorizontalPaddingResource(int i10) {
        this.presenter.setItemHorizontalPadding(getResources().getDimensionPixelSize(i10));
    }

    public void setItemIconPadding(int i10) {
        this.presenter.setItemIconPadding(i10);
    }

    public void setItemIconPaddingResource(int i10) {
        this.presenter.setItemIconPadding(getResources().getDimensionPixelSize(i10));
    }

    public void setItemIconSize(int i10) {
        this.presenter.setItemIconSize(i10);
    }

    public void setItemIconTintList(ColorStateList colorStateList) {
        this.presenter.setItemIconTintList(colorStateList);
    }

    public void setItemMaxLines(int i10) {
        this.presenter.setItemMaxLines(i10);
    }

    public void setItemTextAppearance(int i10) {
        this.presenter.setItemTextAppearance(i10);
    }

    public void setItemTextColor(ColorStateList colorStateList) {
        this.presenter.setItemTextColor(colorStateList);
    }

    public void setNavigationItemSelectedListener(OnNavigationItemSelectedListener onNavigationItemSelectedListener) {
        this.listener = onNavigationItemSelectedListener;
    }

    @Override // android.view.View
    public void setOverScrollMode(int i10) {
        super.setOverScrollMode(i10);
        NavigationMenuPresenter navigationMenuPresenter = this.presenter;
        if (navigationMenuPresenter != null) {
            navigationMenuPresenter.setOverScrollMode(i10);
        }
    }

    public static class SavedState extends f0.a {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator<SavedState>() { // from class: com.google.android.material.navigation.NavigationView.SavedState.1
            @Override // android.os.Parcelable.Creator
            public SavedState[] newArray(int i10) {
                return new SavedState[i10];
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.ClassLoaderCreator
            public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel, null);
            }
        };
        public Bundle menuState;

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.menuState = parcel.readBundle(classLoader);
        }

        @Override // f0.a, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            super.writeToParcel(parcel, i10);
            parcel.writeBundle(this.menuState);
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }
    }

    public NavigationView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, com.google.android.material.R.attr.navigationViewStyle);
    }

    public NavigationView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        ColorStateList createDefaultColorStateList;
        int i11;
        boolean z10;
        NavigationMenuPresenter navigationMenuPresenter = new NavigationMenuPresenter();
        this.presenter = navigationMenuPresenter;
        this.tmpLocation = new int[2];
        NavigationMenu navigationMenu = new NavigationMenu(context);
        this.menu = navigationMenu;
        r2 obtainTintedStyledAttributes = ThemeEnforcement.obtainTintedStyledAttributes(context, attributeSet, com.google.android.material.R.styleable.NavigationView, i10, com.google.android.material.R.style.Widget_Design_NavigationView, new int[0]);
        int i12 = com.google.android.material.R.styleable.NavigationView_android_background;
        if (obtainTintedStyledAttributes.r(i12)) {
            c1.o0(this, obtainTintedStyledAttributes.g(i12));
        }
        if (getBackground() == null || (getBackground() instanceof ColorDrawable)) {
            Drawable background = getBackground();
            MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable();
            if (background instanceof ColorDrawable) {
                materialShapeDrawable.setFillColor(ColorStateList.valueOf(((ColorDrawable) background).getColor()));
            }
            materialShapeDrawable.initializeElevationOverlay(context);
            c1.o0(this, materialShapeDrawable);
        }
        if (obtainTintedStyledAttributes.r(com.google.android.material.R.styleable.NavigationView_elevation)) {
            setElevation(obtainTintedStyledAttributes.f(r13, 0));
        }
        setFitsSystemWindows(obtainTintedStyledAttributes.a(com.google.android.material.R.styleable.NavigationView_android_fitsSystemWindows, false));
        this.maxWidth = obtainTintedStyledAttributes.f(com.google.android.material.R.styleable.NavigationView_android_maxWidth, 0);
        int i13 = com.google.android.material.R.styleable.NavigationView_itemIconTint;
        if (obtainTintedStyledAttributes.r(i13)) {
            createDefaultColorStateList = obtainTintedStyledAttributes.c(i13);
        } else {
            createDefaultColorStateList = createDefaultColorStateList(R.attr.textColorSecondary);
        }
        int i14 = com.google.android.material.R.styleable.NavigationView_itemTextAppearance;
        if (obtainTintedStyledAttributes.r(i14)) {
            i11 = obtainTintedStyledAttributes.n(i14, 0);
            z10 = true;
        } else {
            i11 = 0;
            z10 = false;
        }
        int i15 = com.google.android.material.R.styleable.NavigationView_itemIconSize;
        if (obtainTintedStyledAttributes.r(i15)) {
            setItemIconSize(obtainTintedStyledAttributes.f(i15, 0));
        }
        int i16 = com.google.android.material.R.styleable.NavigationView_itemTextColor;
        ColorStateList c10 = obtainTintedStyledAttributes.r(i16) ? obtainTintedStyledAttributes.c(i16) : null;
        if (!z10 && c10 == null) {
            c10 = createDefaultColorStateList(R.attr.textColorPrimary);
        }
        Drawable g10 = obtainTintedStyledAttributes.g(com.google.android.material.R.styleable.NavigationView_itemBackground);
        if (g10 == null && hasShapeAppearance(obtainTintedStyledAttributes)) {
            g10 = createDefaultItemBackground(obtainTintedStyledAttributes);
        }
        int i17 = com.google.android.material.R.styleable.NavigationView_itemHorizontalPadding;
        if (obtainTintedStyledAttributes.r(i17)) {
            navigationMenuPresenter.setItemHorizontalPadding(obtainTintedStyledAttributes.f(i17, 0));
        }
        int f10 = obtainTintedStyledAttributes.f(com.google.android.material.R.styleable.NavigationView_itemIconPadding, 0);
        setItemMaxLines(obtainTintedStyledAttributes.k(com.google.android.material.R.styleable.NavigationView_itemMaxLines, 1));
        navigationMenu.setCallback(new g.a() { // from class: com.google.android.material.navigation.NavigationView.1
            @Override // androidx.appcompat.view.menu.g.a
            public boolean onMenuItemSelected(androidx.appcompat.view.menu.g gVar, MenuItem menuItem) {
                OnNavigationItemSelectedListener onNavigationItemSelectedListener = NavigationView.this.listener;
                return onNavigationItemSelectedListener != null && onNavigationItemSelectedListener.onNavigationItemSelected(menuItem);
            }

            @Override // androidx.appcompat.view.menu.g.a
            public void onMenuModeChange(androidx.appcompat.view.menu.g gVar) {
            }
        });
        navigationMenuPresenter.setId(1);
        navigationMenuPresenter.initForMenu(context, navigationMenu);
        navigationMenuPresenter.setItemIconTintList(createDefaultColorStateList);
        navigationMenuPresenter.setOverScrollMode(getOverScrollMode());
        if (z10) {
            navigationMenuPresenter.setItemTextAppearance(i11);
        }
        navigationMenuPresenter.setItemTextColor(c10);
        navigationMenuPresenter.setItemBackground(g10);
        navigationMenuPresenter.setItemIconPadding(f10);
        navigationMenu.addMenuPresenter(navigationMenuPresenter);
        addView((View) navigationMenuPresenter.getMenuView(this));
        int i18 = com.google.android.material.R.styleable.NavigationView_menu;
        if (obtainTintedStyledAttributes.r(i18)) {
            inflateMenu(obtainTintedStyledAttributes.n(i18, 0));
        }
        int i19 = com.google.android.material.R.styleable.NavigationView_headerLayout;
        if (obtainTintedStyledAttributes.r(i19)) {
            inflateHeaderView(obtainTintedStyledAttributes.n(i19, 0));
        }
        obtainTintedStyledAttributes.v();
        setupInsetScrimsListener();
    }

    public void setCheckedItem(MenuItem menuItem) {
        MenuItem findItem = this.menu.findItem(menuItem.getItemId());
        if (findItem != null) {
            this.presenter.setCheckedItem((i) findItem);
            return;
        }
        throw new IllegalArgumentException("Called setCheckedItem(MenuItem) with an item that is not in the current menu.");
    }
}
