package com.mobile.brasiltv.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.widget.AppCompatSeekBar;
import com.mobile.brasiltv.utils.s0;
import com.msandroid.mobile.R;
import com.zhy.autolayout.utils.AutoUtils;
import java.util.LinkedHashMap;
import java.util.Map;

/* loaded from: classes3.dex */
public final class CurTimeSeekBar extends AppCompatSeekBar {
    public Map<Integer, View> _$_findViewCache;
    private final Rect mProgressTextRect;
    private TextPaint mTextPaint;
    private final int textSizePx;
    private final float textSizeSp;

    /* renamed from: y, reason: collision with root package name */
    private final int f8811y;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CurTimeSeekBar(Context context) {
        super(context);
        t9.i.g(context, com.umeng.analytics.pro.f.X);
        this._$_findViewCache = new LinkedHashMap();
        this.mTextPaint = new TextPaint();
        this.mProgressTextRect = new Rect();
        this.textSizePx = 24;
        this.textSizeSp = 12.0f;
        this.f8811y = AutoUtils.getPercentHeightSize(24);
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

    @Override // androidx.appcompat.widget.AppCompatSeekBar, android.widget.AbsSeekBar, android.widget.ProgressBar, android.view.View
    public void onDraw(Canvas canvas) {
        t9.i.g(canvas, "canvas");
        super.onDraw(canvas);
        String k10 = y6.a.k(getProgress());
        this.mTextPaint.getTextBounds(k10, 0, k10.length(), this.mProgressTextRect);
        canvas.drawText(k10, (((getWidth() - (getPaddingLeft() * 2.0f)) * getProgress()) / getMax()) + getPaddingLeft(), this.f8811y, this.mTextPaint);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CurTimeSeekBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        t9.i.g(context, com.umeng.analytics.pro.f.X);
        t9.i.g(attributeSet, "attrs");
        this._$_findViewCache = new LinkedHashMap();
        this.mTextPaint = new TextPaint();
        this.mProgressTextRect = new Rect();
        this.textSizePx = 24;
        this.textSizeSp = 12.0f;
        int percentHeightSize = AutoUtils.getPercentHeightSize(24);
        this.f8811y = percentHeightSize;
        this.mTextPaint.setColor(context.getResources().getColor(R.color.color_important_white));
        this.mTextPaint.setTextSize(s0.d(context, 12.0f));
        this.mTextPaint.setTextAlign(Paint.Align.CENTER);
        setPadding(getPaddingLeft(), percentHeightSize, getPaddingRight(), getPaddingBottom());
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CurTimeSeekBar(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        t9.i.g(context, com.umeng.analytics.pro.f.X);
        t9.i.g(attributeSet, "attrs");
        this._$_findViewCache = new LinkedHashMap();
        this.mTextPaint = new TextPaint();
        this.mProgressTextRect = new Rect();
        this.textSizePx = 24;
        this.textSizeSp = 12.0f;
        this.f8811y = AutoUtils.getPercentHeightSize(24);
    }
}
