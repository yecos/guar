package com.google.firebase.inappmessaging.display.internal.layout;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.google.firebase.inappmessaging.display.R;
import com.google.firebase.inappmessaging.display.internal.Logging;
import com.google.firebase.inappmessaging.display.internal.layout.util.MeasureUtils;

/* loaded from: classes2.dex */
public class CardLayoutPortrait extends BaseModalLayout {
    private static double IMAGE_MAX_HEIGHT_PCT = 0.8d;
    private View actionBarChild;
    private View imageChild;
    private View scrollChild;
    private View titleChild;

    public CardLayoutPortrait(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // com.google.firebase.inappmessaging.display.internal.layout.BaseModalLayout, android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        super.onLayout(z10, i10, i11, i12, i13);
        int size = getVisibleChildren().size();
        int i14 = 0;
        for (int i15 = 0; i15 < size; i15++) {
            View view = getVisibleChildren().get(i15);
            int measuredHeight = view.getMeasuredHeight() + i14;
            int measuredWidth = view.getMeasuredWidth() + 0;
            Logging.logd("Layout child " + i15);
            Logging.logdPair("\t(top, bottom)", (float) i14, (float) measuredHeight);
            Logging.logdPair("\t(left, right)", (float) 0, (float) measuredWidth);
            view.layout(0, i14, measuredWidth, measuredHeight);
            Logging.logdPair("Child " + i15 + " wants to be ", view.getMeasuredWidth(), view.getMeasuredHeight());
            i14 += view.getMeasuredHeight();
        }
    }

    @Override // com.google.firebase.inappmessaging.display.internal.layout.BaseModalLayout, android.widget.FrameLayout, android.view.View
    public void onMeasure(int i10, int i11) {
        super.onMeasure(i10, i11);
        this.imageChild = findChildById(R.id.image_view);
        this.titleChild = findChildById(R.id.message_title);
        this.scrollChild = findChildById(R.id.body_scroll);
        this.actionBarChild = findChildById(R.id.action_bar);
        int calculateBaseWidth = calculateBaseWidth(i10);
        int calculateBaseHeight = calculateBaseHeight(i11);
        double d10 = IMAGE_MAX_HEIGHT_PCT;
        double d11 = calculateBaseHeight;
        Double.isNaN(d11);
        int roundToNearest = roundToNearest((int) (d10 * d11), 4);
        Logging.logd("Measuring image");
        MeasureUtils.measureFullWidth(this.imageChild, calculateBaseWidth, calculateBaseHeight);
        if (getDesiredHeight(this.imageChild) > roundToNearest) {
            Logging.logd("Image exceeded maximum height, remeasuring image");
            MeasureUtils.measureFullHeight(this.imageChild, calculateBaseWidth, roundToNearest);
        }
        int desiredWidth = getDesiredWidth(this.imageChild);
        Logging.logd("Measuring title");
        MeasureUtils.measureFullWidth(this.titleChild, desiredWidth, calculateBaseHeight);
        Logging.logd("Measuring action bar");
        MeasureUtils.measureFullWidth(this.actionBarChild, desiredWidth, calculateBaseHeight);
        Logging.logd("Measuring scroll view");
        MeasureUtils.measureFullWidth(this.scrollChild, desiredWidth, ((calculateBaseHeight - getDesiredHeight(this.imageChild)) - getDesiredHeight(this.titleChild)) - getDesiredHeight(this.actionBarChild));
        int size = getVisibleChildren().size();
        int i12 = 0;
        for (int i13 = 0; i13 < size; i13++) {
            i12 += getDesiredHeight(getVisibleChildren().get(i13));
        }
        setMeasuredDimension(desiredWidth, i12);
    }
}
