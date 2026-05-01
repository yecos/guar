package com.mobile.brasiltv.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.mobile.brasiltv.R$styleable;
import com.msandroid.mobile.R;
import com.zhy.autolayout.utils.AutoUtils;

/* loaded from: classes3.dex */
public class CleanableEditText extends androidx.appcompat.widget.l {
    private static final int DRAWABLE_BOTTOM = 3;
    private static final int DRAWABLE_LEFT = 0;
    private static final int DRAWABLE_RIGHT = 2;
    private static final int DRAWABLE_TOP = 1;
    private Drawable mClearDrawable;

    public CleanableEditText(Context context) {
        super(context);
        init(context, null);
    }

    private void init(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.f7784d);
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(0, 14);
        obtainStyledAttributes.recycle();
        setTextColor(getResources().getColor(R.color.color_ff333333));
        setHintTextColor(getResources().getColor(R.color.color_98757575));
        setTextSize(dimensionPixelSize);
        setSingleLine();
        if (getBackground() != null) {
            setBackgroundResource(R.drawable.et_underline_selector);
        }
        setPadding(AutoUtils.getPercentWidthSize(24), 0, 0, 0);
        this.mClearDrawable = getResources().getDrawable(R.drawable.register_icon_empty);
    }

    private void setClearIconVisible(boolean z10) {
        setCompoundDrawablesWithIntrinsicBounds(getCompoundDrawables()[0], getCompoundDrawables()[1], z10 ? this.mClearDrawable : null, getCompoundDrawables()[3]);
    }

    @Override // android.widget.TextView, android.view.View
    public void onFocusChanged(boolean z10, int i10, Rect rect) {
        super.onFocusChanged(z10, i10, rect);
        setClearIconVisible(z10 && length() > 0);
    }

    @Override // android.widget.TextView
    public void onTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
        super.onTextChanged(charSequence, i10, i11, i12);
        setClearIconVisible(hasFocus() && charSequence.length() > 0);
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        Drawable drawable;
        if (motionEvent.getAction() == 1 && (drawable = getCompoundDrawables()[2]) != null && motionEvent.getX() <= getWidth() - getPaddingRight() && motionEvent.getX() >= (getWidth() - getPaddingRight()) - drawable.getBounds().width()) {
            setText("");
        }
        return super.onTouchEvent(motionEvent);
    }

    public CleanableEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context, attributeSet);
    }

    public CleanableEditText(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        init(context, attributeSet);
    }
}
