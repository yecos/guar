package com.zhy.autolayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.zhy.autolayout.AutoLayoutInfo;
import com.zhy.autolayout.R;
import com.zhy.autolayout.utils.AutoLayoutHelper;
import com.zhy.autolayout.utils.AutoUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/* loaded from: classes3.dex */
public class MetroLayout extends ViewGroup {
    private List<MetroBlock> mAvailablePos;
    private int mDivider;
    private final AutoLayoutHelper mHelper;

    public static class MetroBlock {
        int left;
        int top;
        int width;

        private MetroBlock() {
        }
    }

    public MetroLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mHelper = new AutoLayoutHelper(this);
        this.mAvailablePos = new ArrayList();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.MetroLayout);
        int dimensionPixelOffset = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.MetroLayout_metro_divider, 0);
        this.mDivider = dimensionPixelOffset;
        this.mDivider = AutoUtils.getPercentWidthSizeBigger(dimensionPixelOffset);
        obtainStyledAttributes.recycle();
    }

    private MetroBlock findAvailablePos(View view) {
        MetroBlock metroBlock = new MetroBlock();
        if (this.mAvailablePos.size() == 0) {
            metroBlock.left = getPaddingLeft();
            metroBlock.top = getPaddingTop();
            metroBlock.width = getMeasuredWidth();
            return metroBlock;
        }
        int i10 = this.mAvailablePos.get(0).top;
        MetroBlock metroBlock2 = this.mAvailablePos.get(0);
        for (MetroBlock metroBlock3 : this.mAvailablePos) {
            int i11 = metroBlock3.top;
            if (i11 < i10) {
                metroBlock2 = metroBlock3;
                i10 = i11;
            }
        }
        return metroBlock2;
    }

    private void initAvailablePosition() {
        this.mAvailablePos.clear();
        MetroBlock metroBlock = new MetroBlock();
        metroBlock.left = getPaddingLeft();
        metroBlock.top = getPaddingTop();
        metroBlock.width = getMeasuredWidth();
        this.mAvailablePos.add(metroBlock);
    }

    private void mergeAvailablePosition() {
        MetroBlock metroBlock;
        if (this.mAvailablePos.size() <= 1) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        MetroBlock metroBlock2 = this.mAvailablePos.get(0);
        MetroBlock metroBlock3 = this.mAvailablePos.get(1);
        int size = this.mAvailablePos.size();
        for (int i10 = 1; i10 < size - 1; i10++) {
            if (metroBlock2.top == metroBlock3.top) {
                metroBlock2.width += metroBlock3.width;
                arrayList.add(metroBlock2);
                metroBlock3.left = metroBlock2.left;
                metroBlock = this.mAvailablePos.get(i10 + 1);
            } else {
                metroBlock2 = this.mAvailablePos.get(i10);
                metroBlock = this.mAvailablePos.get(i10 + 1);
            }
            metroBlock3 = metroBlock;
        }
        this.mAvailablePos.removeAll(arrayList);
    }

    private void randomColor() {
        Random random = new Random(255L);
        int childCount = getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            getChildAt(i10).setBackgroundColor(Color.argb(100, random.nextInt(), random.nextInt(), random.nextInt()));
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        initAvailablePosition();
        int i14 = this.mDivider;
        int childCount = getChildCount();
        for (int i15 = 0; i15 < childCount; i15++) {
            View childAt = getChildAt(i15);
            if (childAt.getVisibility() != 8) {
                MetroBlock findAvailablePos = findAvailablePos(childAt);
                int i16 = findAvailablePos.left;
                int i17 = findAvailablePos.top;
                int measuredWidth = childAt.getMeasuredWidth();
                int measuredHeight = childAt.getMeasuredHeight() + i17;
                childAt.layout(i16, i17, i16 + measuredWidth, measuredHeight);
                int i18 = measuredWidth + i14;
                int i19 = findAvailablePos.width;
                if (i18 < i19) {
                    findAvailablePos.left += i18;
                    findAvailablePos.width = i19 - i18;
                } else {
                    this.mAvailablePos.remove(findAvailablePos);
                }
                MetroBlock metroBlock = new MetroBlock();
                metroBlock.left = i16;
                metroBlock.top = measuredHeight + i14;
                metroBlock.width = measuredWidth;
                this.mAvailablePos.add(metroBlock);
                mergeAvailablePosition();
            }
        }
    }

    @Override // android.view.View
    public void onMeasure(int i10, int i11) {
        randomColor();
        if (!isInEditMode()) {
            this.mHelper.adjustChildren();
        }
        measureChildren(i10, i11);
        super.onMeasure(i10, i11);
    }

    public static class LayoutParams extends ViewGroup.MarginLayoutParams implements AutoLayoutHelper.AutoLayoutParams {
        private AutoLayoutInfo mAutoLayoutInfo;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.mAutoLayoutInfo = AutoLayoutHelper.getAutoLayoutInfo(context, attributeSet);
        }

        @Override // com.zhy.autolayout.utils.AutoLayoutHelper.AutoLayoutParams
        public AutoLayoutInfo getAutoLayoutInfo() {
            return this.mAutoLayoutInfo;
        }

        public LayoutParams(int i10, int i11) {
            super(i10, i11);
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }

        public LayoutParams(LayoutParams layoutParams) {
            this((ViewGroup.LayoutParams) layoutParams);
            this.mAutoLayoutInfo = layoutParams.mAutoLayoutInfo;
        }
    }

    @Override // android.view.ViewGroup
    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }
}
