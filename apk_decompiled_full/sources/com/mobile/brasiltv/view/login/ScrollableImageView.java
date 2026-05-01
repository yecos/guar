package com.mobile.brasiltv.view.login;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapRegionDecoder;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;
import com.mobile.brasiltv.view.RoundedDrawable;
import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedHashMap;
import java.util.Map;

/* loaded from: classes3.dex */
public final class ScrollableImageView extends View {
    private final String COLOR_FILTER;
    private final long DURATING_SCROLL_ANIM;
    private final int STATE_ANIMING;
    private final int STATE_ANIM_DESTROY;
    private final int STATE_ANIM_PAUSE;
    private final int STATE_ANIM_START;
    private final int STATE_NORMAL;
    public Map<Integer, View> _$_findViewCache;
    private final Paint mBitmapPaint;
    private final Rect mBottomDrawRect;
    private final Rect mBottomViewRect;
    private int mImageHeight;
    private int mImageWidth;
    private Bitmap mLongPicBitmap;
    private s9.a mMeasureListener;
    private ValueAnimator mScrollAnim;
    private boolean mSetPicResource;
    private int mState;
    private final Rect mTopDrawRect;
    private final Rect mTopViewRect;
    private int mViewHeight;
    private int mViewWidth;
    private BitmapFactory.Options options;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ScrollableImageView(Context context) {
        this(context, null, 0, 6, null);
        t9.i.g(context, com.umeng.analytics.pro.f.X);
    }

    private final void registerScheduleScroll() {
        if (this.mViewWidth == 0 || this.mViewHeight == 0) {
            this.mMeasureListener = new ScrollableImageView$registerScheduleScroll$1(this);
        } else {
            scheduleScroll();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void scheduleScroll() {
        final int i10 = (int) (((this.mImageWidth * 1.0f) * this.mViewHeight) / this.mViewWidth);
        ValueAnimator ofInt = ValueAnimator.ofInt(0, this.mImageHeight - 1);
        this.mScrollAnim = ofInt;
        if (ofInt != null) {
            ofInt.setRepeatCount(-1);
        }
        ValueAnimator valueAnimator = this.mScrollAnim;
        if (valueAnimator != null) {
            valueAnimator.setInterpolator(new LinearInterpolator());
        }
        ValueAnimator valueAnimator2 = this.mScrollAnim;
        if (valueAnimator2 != null) {
            valueAnimator2.setDuration(this.DURATING_SCROLL_ANIM);
        }
        ValueAnimator valueAnimator3 = this.mScrollAnim;
        if (valueAnimator3 != null) {
            valueAnimator3.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.mobile.brasiltv.view.login.u
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator4) {
                    ScrollableImageView.scheduleScroll$lambda$0(i10, this, valueAnimator4);
                }
            });
        }
        ValueAnimator valueAnimator4 = this.mScrollAnim;
        if (valueAnimator4 != null) {
            valueAnimator4.start();
        }
        this.mState = this.STATE_ANIM_START;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void scheduleScroll$lambda$0(int i10, ScrollableImageView scrollableImageView, ValueAnimator valueAnimator) {
        t9.i.g(scrollableImageView, "this$0");
        t9.i.g(valueAnimator, "it");
        Object animatedValue = valueAnimator.getAnimatedValue();
        t9.i.e(animatedValue, "null cannot be cast to non-null type kotlin.Int");
        int intValue = ((Integer) animatedValue).intValue();
        int i11 = intValue + i10;
        int i12 = scrollableImageView.mImageHeight;
        if (i11 <= i12) {
            scrollableImageView.mTopDrawRect.set(0, intValue, scrollableImageView.mImageWidth, i11);
            scrollableImageView.mTopViewRect.set(0, 0, scrollableImageView.mViewWidth, scrollableImageView.mViewHeight);
            scrollableImageView.mBottomDrawRect.setEmpty();
            scrollableImageView.mBottomViewRect.setEmpty();
        } else {
            scrollableImageView.mTopDrawRect.set(0, intValue, scrollableImageView.mImageWidth, i12);
            int i13 = (int) ((((scrollableImageView.mImageHeight - intValue) * 1.0f) / i10) * scrollableImageView.mViewHeight);
            scrollableImageView.mTopViewRect.set(0, 0, scrollableImageView.mViewWidth, i13);
            scrollableImageView.mBottomDrawRect.set(0, 0, scrollableImageView.mImageWidth, i11 - scrollableImageView.mImageHeight);
            scrollableImageView.mBottomViewRect.set(0, i13, scrollableImageView.mViewWidth, scrollableImageView.mViewHeight);
        }
        scrollableImageView.mState = scrollableImageView.STATE_ANIMING;
        scrollableImageView.invalidate();
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

    public final void destroy() {
        ValueAnimator valueAnimator = this.mScrollAnim;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        this.mScrollAnim = null;
        this.mImageWidth = 0;
        this.mImageHeight = 0;
        this.mSetPicResource = false;
        Bitmap bitmap = this.mLongPicBitmap;
        if (bitmap != null) {
            bitmap.recycle();
        }
        this.mState = this.STATE_NORMAL;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        Bitmap bitmap;
        t9.i.g(canvas, "canvas");
        super.onDraw(canvas);
        int i10 = this.mState;
        if (i10 == this.STATE_NORMAL || i10 == this.STATE_ANIM_START || i10 == this.STATE_ANIM_DESTROY) {
            canvas.drawColor(RoundedDrawable.DEFAULT_BORDER_COLOR);
            return;
        }
        if ((i10 == this.STATE_ANIMING || i10 == this.STATE_ANIM_PAUSE) && (bitmap = this.mLongPicBitmap) != null) {
            canvas.drawBitmap(bitmap, this.mTopDrawRect, this.mTopViewRect, this.mBitmapPaint);
            if (this.mBottomDrawRect.isEmpty() || this.mBottomViewRect.isEmpty()) {
                return;
            }
            canvas.drawBitmap(bitmap, this.mBottomDrawRect, this.mBottomViewRect, this.mBitmapPaint);
        }
    }

    @Override // android.view.View
    public void onMeasure(int i10, int i11) {
        super.onMeasure(i10, i11);
        this.mViewWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        this.mViewHeight = measuredHeight;
        this.mTopViewRect.set(0, 0, this.mViewWidth, measuredHeight);
        this.mBottomViewRect.setEmpty();
        s9.a aVar = this.mMeasureListener;
        if (aVar != null) {
            aVar.invoke();
        }
    }

    public final void pauseScroll() {
        if (this.mSetPicResource) {
            int i10 = this.mState;
            if (i10 == this.STATE_ANIM_START || i10 == this.STATE_ANIMING) {
                ValueAnimator valueAnimator = this.mScrollAnim;
                if (valueAnimator != null) {
                    valueAnimator.pause();
                }
                this.mState = this.STATE_ANIM_PAUSE;
            }
        }
    }

    public final void resumeScroll() {
        int i10;
        if (!this.mSetPicResource || (i10 = this.mState) == this.STATE_ANIM_START || i10 == this.STATE_ANIMING) {
            return;
        }
        if (i10 == this.STATE_NORMAL || i10 == this.STATE_ANIM_DESTROY) {
            registerScheduleScroll();
            return;
        }
        ValueAnimator valueAnimator = this.mScrollAnim;
        if (valueAnimator != null) {
            valueAnimator.resume();
        }
    }

    public final void setImageInputStream(InputStream inputStream) {
        t9.i.g(inputStream, "imageIs");
        try {
            try {
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inJustDecodeBounds = true;
                BitmapFactory.decodeStream(inputStream, null, options);
                this.mImageWidth = options.outWidth;
                this.mImageHeight = options.outHeight;
                BitmapRegionDecoder newInstance = BitmapRegionDecoder.newInstance(inputStream, false);
                this.mLongPicBitmap = newInstance != null ? newInstance.decodeRegion(new Rect(0, 0, this.mImageWidth, this.mImageHeight), this.options) : null;
                this.mSetPicResource = true;
                com.mobile.brasiltv.utils.j.a(inputStream);
            } catch (IOException e10) {
                e10.printStackTrace();
                com.mobile.brasiltv.utils.j.a(inputStream);
            }
        } catch (Throwable th) {
            com.mobile.brasiltv.utils.j.a(inputStream);
            throw th;
        }
    }

    public final void startScroll() {
        if (this.mSetPicResource) {
            registerScheduleScroll();
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ScrollableImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        t9.i.g(context, com.umeng.analytics.pro.f.X);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ScrollableImageView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        t9.i.g(context, com.umeng.analytics.pro.f.X);
        this._$_findViewCache = new LinkedHashMap();
        this.STATE_ANIM_START = 1;
        this.STATE_ANIMING = 2;
        this.STATE_ANIM_PAUSE = 3;
        this.STATE_ANIM_DESTROY = 4;
        this.DURATING_SCROLL_ANIM = 40000L;
        this.COLOR_FILTER = "#80121418";
        this.mTopViewRect = new Rect();
        this.mBottomViewRect = new Rect();
        this.mTopDrawRect = new Rect();
        this.mBottomDrawRect = new Rect();
        Paint paint = new Paint(1);
        this.mBitmapPaint = paint;
        BitmapFactory.Options options = new BitmapFactory.Options();
        this.options = options;
        this.mState = this.STATE_NORMAL;
        options.inPreferredConfig = Bitmap.Config.RGB_565;
        paint.setFlags(6);
        paint.setColorFilter(new PorterDuffColorFilter(Color.parseColor("#80121418"), PorterDuff.Mode.SRC_OVER));
    }

    public /* synthetic */ ScrollableImageView(Context context, AttributeSet attributeSet, int i10, int i11, t9.g gVar) {
        this(context, (i11 & 2) != 0 ? null : attributeSet, (i11 & 4) != 0 ? 0 : i10);
    }
}
