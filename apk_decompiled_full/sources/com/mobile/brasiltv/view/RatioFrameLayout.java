package com.mobile.brasiltv.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import com.google.common.primitives.Ints;
import com.mobile.brasiltv.R$styleable;
import com.zhy.autolayout.AutoFrameLayout;

/* loaded from: classes3.dex */
public class RatioFrameLayout extends AutoFrameLayout {
    private float mRatio;
    private boolean mRatioEnable;

    public RatioFrameLayout(Context context) {
        super(context);
    }

    private void init(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.f7801u);
        this.mRatio = obtainStyledAttributes.getFloat(1, 0.0f);
        this.mRatioEnable = obtainStyledAttributes.getBoolean(0, false);
        obtainStyledAttributes.recycle();
    }

    @Override // com.zhy.autolayout.AutoFrameLayout, android.widget.FrameLayout, android.view.View
    public void onMeasure(int i10, int i11) {
        int size = View.MeasureSpec.getSize(i10);
        if (this.mRatioEnable) {
            float f10 = this.mRatio;
            if (f10 != 0.0f) {
                i11 = View.MeasureSpec.makeMeasureSpec((int) (size / f10), Ints.MAX_POWER_OF_TWO);
            }
        }
        super.onMeasure(i10, i11);
    }

    public void setRatioEnable(boolean z10) {
        this.mRatioEnable = z10;
    }

    public RatioFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context, attributeSet);
    }

    public RatioFrameLayout(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        init(context, attributeSet);
    }
}
