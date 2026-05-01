package com.flyco.tablayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.flyco.tablayout.R;
import com.google.common.primitives.Ints;

/* loaded from: classes.dex */
public class MsgView extends TextView {
    private int backgroundColor;
    private Context context;
    private int cornerRadius;
    private GradientDrawable gd_background;
    private boolean isRadiusHalfHeight;
    private boolean isWidthHeightEqual;
    private int strokeColor;
    private int strokeWidth;

    public MsgView(Context context) {
        this(context, null);
    }

    private void obtainAttributes(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.MsgView);
        this.backgroundColor = obtainStyledAttributes.getColor(R.styleable.MsgView_mv_backgroundColor, 0);
        this.cornerRadius = obtainStyledAttributes.getDimensionPixelSize(R.styleable.MsgView_mv_cornerRadius, 0);
        this.strokeWidth = obtainStyledAttributes.getDimensionPixelSize(R.styleable.MsgView_mv_strokeWidth, 0);
        this.strokeColor = obtainStyledAttributes.getColor(R.styleable.MsgView_mv_strokeColor, 0);
        this.isRadiusHalfHeight = obtainStyledAttributes.getBoolean(R.styleable.MsgView_mv_isRadiusHalfHeight, false);
        this.isWidthHeightEqual = obtainStyledAttributes.getBoolean(R.styleable.MsgView_mv_isWidthHeightEqual, false);
        obtainStyledAttributes.recycle();
    }

    private void setDrawable(GradientDrawable gradientDrawable, int i10, int i11) {
        gradientDrawable.setColor(i10);
        gradientDrawable.setCornerRadius(this.cornerRadius);
        gradientDrawable.setStroke(this.strokeWidth, i11);
    }

    public int dp2px(float f10) {
        return (int) ((f10 * this.context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public int getBackgroundColor() {
        return this.backgroundColor;
    }

    public int getCornerRadius() {
        return this.cornerRadius;
    }

    public int getStrokeColor() {
        return this.strokeColor;
    }

    public int getStrokeWidth() {
        return this.strokeWidth;
    }

    public boolean isRadiusHalfHeight() {
        return this.isRadiusHalfHeight;
    }

    public boolean isWidthHeightEqual() {
        return this.isWidthHeightEqual;
    }

    @Override // android.widget.TextView, android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        super.onLayout(z10, i10, i11, i12, i13);
        if (isRadiusHalfHeight()) {
            setCornerRadius(getHeight() / 2);
        } else {
            setBgSelector();
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void onMeasure(int i10, int i11) {
        if (!isWidthHeightEqual() || getWidth() <= 0 || getHeight() <= 0) {
            super.onMeasure(i10, i11);
        } else {
            int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(Math.max(getWidth(), getHeight()), Ints.MAX_POWER_OF_TWO);
            super.onMeasure(makeMeasureSpec, makeMeasureSpec);
        }
    }

    @Override // android.view.View
    public void setBackgroundColor(int i10) {
        this.backgroundColor = i10;
        setBgSelector();
    }

    public void setBgSelector() {
        StateListDrawable stateListDrawable = new StateListDrawable();
        setDrawable(this.gd_background, this.backgroundColor, this.strokeColor);
        stateListDrawable.addState(new int[]{-16842919}, this.gd_background);
        setBackground(stateListDrawable);
    }

    public void setCornerRadius(int i10) {
        this.cornerRadius = dp2px(i10);
        setBgSelector();
    }

    public void setIsRadiusHalfHeight(boolean z10) {
        this.isRadiusHalfHeight = z10;
        setBgSelector();
    }

    public void setIsWidthHeightEqual(boolean z10) {
        this.isWidthHeightEqual = z10;
        setBgSelector();
    }

    public void setStrokeColor(int i10) {
        this.strokeColor = i10;
        setBgSelector();
    }

    public void setStrokeWidth(int i10) {
        this.strokeWidth = dp2px(i10);
        setBgSelector();
    }

    public int sp2px(float f10) {
        return (int) ((f10 * this.context.getResources().getDisplayMetrics().scaledDensity) + 0.5f);
    }

    public MsgView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MsgView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.gd_background = new GradientDrawable();
        this.context = context;
        obtainAttributes(context, attributeSet);
    }
}
