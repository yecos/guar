package com.mobile.brasiltv.view;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.TextView;
import androidx.appcompat.widget.q0;
import com.zhy.autolayout.utils.AutoUtils;
import java.util.LinkedHashMap;
import java.util.Map;

/* loaded from: classes3.dex */
public final class AutoText extends q0 {
    public Map<Integer, View> _$_findViewCache;
    private boolean isMeasured;
    private boolean isWaitMeasure;
    private int mPaddingLeft;
    private ValueAnimator mScrollAnim;
    private Paint mScrollPaint;
    private float mScrollX;
    private float mTextBaseLine;
    private int textWith;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AutoText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        t9.i.g(context, com.umeng.analytics.pro.f.X);
        t9.i.g(attributeSet, "attrs");
        this._$_findViewCache = new LinkedHashMap();
        setSingleLine(true);
        setEllipsize(null);
        setFocusable(false);
        setSelected(false);
        initScrollPaint();
    }

    private final void initScrollPaint() {
        TextPaint textPaint = new TextPaint(5);
        this.mScrollPaint = textPaint;
        t9.i.d(textPaint);
        textPaint.setTextSize(getTextSize());
        Paint paint = this.mScrollPaint;
        t9.i.d(paint);
        paint.setColor(getCurrentTextColor());
    }

    private final void launchScrollAnim() {
        CharSequence text = getText();
        if (text == null || text.length() == 0) {
            return;
        }
        measureTextWidth();
        ValueAnimator duration = ValueAnimator.ofFloat(0.0f, 1.0f).setDuration(((long) ((getText().length() * 1.0f) / 3)) * 1000);
        this.mScrollAnim = duration;
        if (duration != null) {
            duration.setInterpolator(new LinearInterpolator());
        }
        ValueAnimator valueAnimator = this.mScrollAnim;
        if (valueAnimator != null) {
            valueAnimator.setRepeatCount(-1);
        }
        ValueAnimator valueAnimator2 = this.mScrollAnim;
        if (valueAnimator2 != null) {
            valueAnimator2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.mobile.brasiltv.view.e
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator3) {
                    AutoText.launchScrollAnim$lambda$2(AutoText.this, valueAnimator3);
                }
            });
        }
        ValueAnimator valueAnimator3 = this.mScrollAnim;
        if (valueAnimator3 != null) {
            valueAnimator3.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void launchScrollAnim$lambda$2(AutoText autoText, ValueAnimator valueAnimator) {
        t9.i.g(autoText, "this$0");
        t9.i.g(valueAnimator, "it");
        Object animatedValue = valueAnimator.getAnimatedValue();
        t9.i.e(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        autoText.mScrollX = (((Float) animatedValue).floatValue() * (-autoText.textWith)) + AutoUtils.getPercentWidthSize(autoText.mPaddingLeft);
        autoText.invalidate();
    }

    private final void measureTextWidth() {
        if (this.mScrollPaint == null) {
            initScrollPaint();
            h9.t tVar = h9.t.f14242a;
        }
        Paint paint = this.mScrollPaint;
        t9.i.d(paint);
        this.textWith = (int) paint.measureText(getText().toString());
        Paint paint2 = this.mScrollPaint;
        t9.i.d(paint2);
        Paint.FontMetrics fontMetrics = paint2.getFontMetrics();
        t9.i.f(fontMetrics, "mScrollPaint!!.fontMetrics");
        float f10 = fontMetrics.top;
        float f11 = fontMetrics.bottom;
        float f12 = 2;
        this.mTextBaseLine = ((getMeasuredHeight() * 1.0f) / f12) + (((f11 - f10) / f12) - f11);
        this.isMeasured = true;
    }

    public void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

    public View _$_findCachedViewById(int i10) {
        Map<Integer, View> map = this._$_findViewCache;
        View view = map.get(Integer.valueOf(i10));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i10);
        if (findViewById == null) {
            return null;
        }
        map.put(Integer.valueOf(i10), findViewById);
        return findViewById;
    }

    @Override // android.widget.TextView, android.view.View
    public void onDraw(Canvas canvas) {
        t9.i.g(canvas, "canvas");
        String obj = getText().toString();
        if (obj == null || obj.length() == 0) {
            super.onDraw(canvas);
            return;
        }
        Paint paint = this.mScrollPaint;
        if (paint != null) {
            canvas.drawText(getText().toString(), this.mScrollX, this.mTextBaseLine, paint);
        }
    }

    @Override // androidx.appcompat.widget.q0, android.widget.TextView, android.view.View
    public void onMeasure(int i10, int i11) {
        super.onMeasure(i10, i11);
        if (this.isWaitMeasure) {
            this.isWaitMeasure = false;
            launchScrollAnim();
        }
    }

    public final void pauseScroll() {
        ValueAnimator valueAnimator = this.mScrollAnim;
        if (valueAnimator != null) {
            valueAnimator.pause();
        }
    }

    public final void resumeScroll() {
        ValueAnimator valueAnimator = this.mScrollAnim;
        if (valueAnimator != null) {
            valueAnimator.resume();
        }
    }

    public final void setContentPaddingLeft(int i10) {
        this.mPaddingLeft = i10;
    }

    @Override // android.widget.TextView
    public void setText(CharSequence charSequence, TextView.BufferType bufferType) {
        super.setText(charSequence, bufferType);
        this.isMeasured = false;
    }

    @Override // android.widget.TextView
    public void setTextColor(int i10) {
        super.setTextColor(i10);
        Paint paint = this.mScrollPaint;
        if (paint == null) {
            return;
        }
        paint.setColor(i10);
    }

    @Override // android.widget.TextView
    public void setTextSize(float f10) {
        super.setTextSize(f10);
        Paint paint = this.mScrollPaint;
        if (paint == null) {
            return;
        }
        paint.setTextSize(f10);
    }

    public final void startScroll() {
        stopScroll();
        this.isWaitMeasure = true;
        requestLayout();
    }

    public final void stopScroll() {
        ValueAnimator valueAnimator = this.mScrollAnim;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        this.mScrollAnim = null;
    }
}
