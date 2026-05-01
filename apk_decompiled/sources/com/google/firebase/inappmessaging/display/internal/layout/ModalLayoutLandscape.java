package com.google.firebase.inappmessaging.display.internal.layout;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.google.firebase.inappmessaging.display.R;
import com.google.firebase.inappmessaging.display.internal.Logging;
import com.google.firebase.inappmessaging.display.internal.layout.util.MeasureUtils;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public class ModalLayoutLandscape extends BaseModalLayout {
    private static final int ITEM_SPACING_DP = 24;
    private static final float MAX_IMG_WIDTH_PCT = 0.4f;
    private int barrierWidth;
    private View buttonChild;
    private View imageChild;
    private int leftContentHeight;
    private int rightContentHeight;
    private View scrollChild;
    private View titleChild;
    private int vertItemSpacing;

    public ModalLayoutLandscape(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void layoutCenterHorizontal(View view, int i10, int i11, int i12, int i13) {
        int measuredWidth = view.getMeasuredWidth() / 2;
        int i14 = i10 + ((i12 - i10) / 2);
        layoutChild(view, i14 - measuredWidth, i11, i14 + measuredWidth, i13);
    }

    @Override // com.google.firebase.inappmessaging.display.internal.layout.BaseModalLayout, android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        int i14;
        int i15;
        super.onLayout(z10, i10, i11, i12, i13);
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int measuredWidth = getMeasuredWidth() - getPaddingRight();
        int i16 = this.leftContentHeight;
        int i17 = this.rightContentHeight;
        if (i16 < i17) {
            i15 = (i17 - i16) / 2;
            i14 = 0;
        } else {
            i14 = (i16 - i17) / 2;
            i15 = 0;
        }
        Logging.logd("Layout image");
        int i18 = paddingTop + i15;
        int desiredWidth = getDesiredWidth(this.imageChild) + paddingLeft;
        layoutChild(this.imageChild, paddingLeft, i18, desiredWidth, i18 + getDesiredHeight(this.imageChild));
        int i19 = desiredWidth + this.barrierWidth;
        Logging.logd("Layout getTitle");
        int i20 = paddingTop + i14;
        int desiredHeight = getDesiredHeight(this.titleChild) + i20;
        layoutChild(this.titleChild, i19, i20, measuredWidth, desiredHeight);
        Logging.logd("Layout getBody");
        int i21 = desiredHeight + (this.titleChild.getVisibility() == 8 ? 0 : this.vertItemSpacing);
        int desiredHeight2 = getDesiredHeight(this.scrollChild) + i21;
        layoutChild(this.scrollChild, i19, i21, measuredWidth, desiredHeight2);
        Logging.logd("Layout button");
        layoutChild(this.buttonChild, i19, desiredHeight2 + (this.scrollChild.getVisibility() != 8 ? this.vertItemSpacing : 0));
    }

    @Override // com.google.firebase.inappmessaging.display.internal.layout.BaseModalLayout, android.widget.FrameLayout, android.view.View
    public void onMeasure(int i10, int i11) {
        super.onMeasure(i10, i11);
        this.imageChild = findChildById(R.id.image_view);
        this.titleChild = findChildById(R.id.message_title);
        this.scrollChild = findChildById(R.id.body_scroll);
        this.buttonChild = findChildById(R.id.button);
        int i12 = 0;
        this.barrierWidth = this.imageChild.getVisibility() == 8 ? 0 : dpToPixels(24);
        this.vertItemSpacing = dpToPixels(24);
        List asList = Arrays.asList(this.titleChild, this.scrollChild, this.buttonChild);
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        int paddingBottom = getPaddingBottom() + getPaddingTop();
        int calculateBaseWidth = calculateBaseWidth(i10);
        int calculateBaseHeight = calculateBaseHeight(i11) - paddingBottom;
        int i13 = calculateBaseWidth - paddingLeft;
        Logging.logd("Measuring image");
        MeasureUtils.measureAtMost(this.imageChild, (int) (i13 * 0.4f), calculateBaseHeight);
        int desiredWidth = getDesiredWidth(this.imageChild);
        int i14 = i13 - (this.barrierWidth + desiredWidth);
        float f10 = desiredWidth;
        Logging.logdPair("Max col widths (l, r)", f10, i14);
        Iterator it = asList.iterator();
        int i15 = 0;
        while (it.hasNext()) {
            if (((View) it.next()).getVisibility() != 8) {
                i15++;
            }
        }
        int max = Math.max(0, (i15 - 1) * this.vertItemSpacing);
        int i16 = calculateBaseHeight - max;
        Logging.logd("Measuring getTitle");
        MeasureUtils.measureAtMost(this.titleChild, i14, i16);
        Logging.logd("Measuring button");
        MeasureUtils.measureAtMost(this.buttonChild, i14, i16);
        Logging.logd("Measuring scroll view");
        MeasureUtils.measureAtMost(this.scrollChild, i14, (i16 - getDesiredHeight(this.titleChild)) - getDesiredHeight(this.buttonChild));
        this.leftContentHeight = getDesiredHeight(this.imageChild);
        this.rightContentHeight = max;
        Iterator it2 = asList.iterator();
        while (it2.hasNext()) {
            this.rightContentHeight += getDesiredHeight((View) it2.next());
        }
        int max2 = Math.max(this.leftContentHeight + paddingBottom, this.rightContentHeight + paddingBottom);
        Iterator it3 = asList.iterator();
        while (it3.hasNext()) {
            i12 = Math.max(getDesiredWidth((View) it3.next()), i12);
        }
        Logging.logdPair("Measured columns (l, r)", f10, i12);
        int i17 = desiredWidth + i12 + this.barrierWidth + paddingLeft;
        Logging.logdPair("Measured dims", i17, max2);
        setMeasuredDimension(i17, max2);
    }
}
