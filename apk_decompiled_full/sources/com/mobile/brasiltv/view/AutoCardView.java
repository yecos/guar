package com.mobile.brasiltv.view;

import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import androidx.cardview.R$styleable;
import com.mobile.brasiltv.utils.s0;
import com.zhy.autolayout.AutoFrameLayout;
import com.zhy.autolayout.utils.AutoLayoutHelper;

/* loaded from: classes3.dex */
public class AutoCardView extends androidx.cardview.widget.a {
    private int cardCornerRadius;
    private final AutoLayoutHelper mHelper;

    public AutoCardView(Context context) {
        this(context, null);
    }

    @Override // androidx.cardview.widget.a, android.widget.FrameLayout, android.view.View
    public void onMeasure(int i10, int i11) {
        if (!isInEditMode()) {
            this.mHelper.adjustChildren();
        }
        super.onMeasure(i10, i11);
    }

    public void setDefaultRadius(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            this.cardCornerRadius = context.obtainStyledAttributes(attributeSet, R$styleable.f1758a).getDimensionPixelSize(3, 2);
        }
        setLayerType(2, null);
        setRadius(s0.a(getContext(), this.cardCornerRadius));
        if (Build.VERSION.SDK_INT >= 21) {
            setElevation(s0.a(getContext(), this.cardCornerRadius));
        }
    }

    public void setElevationCompat(float f10) {
        if (Build.VERSION.SDK_INT >= 21) {
            setElevation(f10);
        }
    }

    public AutoCardView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mHelper = new AutoLayoutHelper(this);
        this.cardCornerRadius = 2;
        setDefaultRadius(context, attributeSet);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public AutoFrameLayout.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new AutoFrameLayout.LayoutParams(getContext(), attributeSet);
    }

    public AutoCardView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.mHelper = new AutoLayoutHelper(this);
        this.cardCornerRadius = 2;
        setDefaultRadius(context, attributeSet);
    }
}
