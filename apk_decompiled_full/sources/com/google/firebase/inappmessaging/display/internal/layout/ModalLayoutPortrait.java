package com.google.firebase.inappmessaging.display.internal.layout;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.google.firebase.inappmessaging.display.R;
import com.google.firebase.inappmessaging.display.internal.Logging;
import com.google.firebase.inappmessaging.display.internal.layout.util.MeasureUtils;
import com.google.firebase.inappmessaging.display.internal.layout.util.VerticalViewGroupMeasure;
import com.google.firebase.inappmessaging.display.internal.layout.util.ViewMeasure;

/* loaded from: classes2.dex */
public class ModalLayoutPortrait extends BaseModalLayout {
    private static final int ITEM_SPACING_DP = 24;
    private int vertItemSpacing;
    private VerticalViewGroupMeasure vgm;

    public ModalLayoutPortrait(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.vgm = new VerticalViewGroupMeasure();
    }

    private boolean isFlex(View view) {
        return view.getId() == R.id.body_scroll || view.getId() == R.id.image_view;
    }

    @Override // com.google.firebase.inappmessaging.display.internal.layout.BaseModalLayout, android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        int i14;
        int i15;
        super.onLayout(z10, i10, i11, i12, i13);
        int paddingTop = getPaddingTop();
        int paddingLeft = getPaddingLeft();
        int size = getVisibleChildren().size();
        for (int i16 = 0; i16 < size; i16++) {
            View view = getVisibleChildren().get(i16);
            FrameLayout.LayoutParams layoutParams = getLayoutParams(view);
            int measuredHeight = view.getMeasuredHeight();
            int measuredWidth = view.getMeasuredWidth();
            int i17 = measuredHeight + paddingTop;
            if ((layoutParams.gravity & 1) == 1) {
                int i18 = (i12 - i10) / 2;
                int i19 = measuredWidth / 2;
                i15 = i18 - i19;
                i14 = i18 + i19;
            } else {
                i14 = paddingLeft + measuredWidth;
                i15 = paddingLeft;
            }
            Logging.logd("Layout child " + i16);
            Logging.logdPair("\t(top, bottom)", (float) paddingTop, (float) i17);
            Logging.logdPair("\t(left, right)", (float) i15, (float) i14);
            view.layout(i15, paddingTop, i14, i17);
            paddingTop += view.getMeasuredHeight();
            if (i16 < size - 1) {
                paddingTop += this.vertItemSpacing;
            }
        }
    }

    @Override // com.google.firebase.inappmessaging.display.internal.layout.BaseModalLayout, android.widget.FrameLayout, android.view.View
    public void onMeasure(int i10, int i11) {
        super.onMeasure(i10, i11);
        this.vertItemSpacing = dpToPixels(24);
        int paddingRight = getPaddingRight() + getPaddingLeft();
        int paddingBottom = getPaddingBottom() + getPaddingTop();
        int calculateBaseWidth = calculateBaseWidth(i10);
        int calculateBaseHeight = calculateBaseHeight(i11);
        int size = paddingBottom + ((getVisibleChildren().size() - 1) * this.vertItemSpacing);
        this.vgm.reset(calculateBaseWidth, calculateBaseHeight);
        for (int i12 = 0; i12 < getChildCount(); i12++) {
            View childAt = getChildAt(i12);
            this.vgm.add(childAt, isFlex(childAt));
        }
        Logging.logd("Screen dimens: " + getDisplayMetrics());
        Logging.logdPair("Max pct", getMaxWidthPct(), getMaxHeightPct());
        float f10 = (float) calculateBaseWidth;
        Logging.logdPair("Base dimens", f10, (float) calculateBaseHeight);
        for (ViewMeasure viewMeasure : this.vgm.getViews()) {
            Logging.logd("Pre-measure child");
            viewMeasure.preMeasure(calculateBaseWidth, calculateBaseHeight);
        }
        int totalHeight = this.vgm.getTotalHeight() + size;
        Logging.logdNumber("Total reserved height", size);
        Logging.logdNumber("Total desired height", totalHeight);
        boolean z10 = totalHeight > calculateBaseHeight;
        Logging.logd("Total height constrained: " + z10);
        if (z10) {
            this.vgm.allocateSpace((calculateBaseHeight - size) - this.vgm.getTotalFixedHeight());
        }
        int i13 = calculateBaseWidth - paddingRight;
        for (ViewMeasure viewMeasure2 : this.vgm.getViews()) {
            Logging.logd("Measuring child");
            MeasureUtils.measureAtMost(viewMeasure2.getView(), i13, viewMeasure2.getMaxHeight());
            size += getDesiredHeight(viewMeasure2.getView());
        }
        Logging.logdPair("Measured dims", f10, size);
        setMeasuredDimension(calculateBaseWidth, size);
    }
}
