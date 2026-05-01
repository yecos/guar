package com.mobile.brasiltv.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.widget.ImageView;
import com.mobile.brasiltv.utils.s0;

/* loaded from: classes3.dex */
public class RoundImageView extends ImageView {
    public static final int DEFAUT_ROUND_RADIUS = 10;
    public static final int TYPE_CIRCLE = 0;
    public static final int TYPE_OVAL = 2;
    public static final int TYPE_ROUND = 1;
    private boolean isCardViewParent;
    private BitmapShader mBitmapShader;
    private int mHeight;
    private Matrix mMatrix;
    private Paint mPaint;
    private int mRadius;
    private RectF mRect;
    private int mRoundRadius;
    private int mType;
    private int mWidth;

    public RoundImageView(Context context) {
        this(context, null);
    }

    private Bitmap drawableToBitmap(Drawable drawable) {
        if (drawable instanceof BitmapDrawable) {
            return ((BitmapDrawable) drawable).getBitmap();
        }
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int intrinsicHeight = drawable.getIntrinsicHeight();
        Bitmap createBitmap = Bitmap.createBitmap(intrinsicWidth, intrinsicHeight, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        drawable.setBounds(0, 0, intrinsicWidth, intrinsicHeight);
        drawable.draw(canvas);
        return createBitmap;
    }

    private void initView() {
        Paint paint = new Paint();
        this.mPaint = paint;
        paint.setAntiAlias(true);
        this.mMatrix = new Matrix();
        this.mRoundRadius = s0.a(getContext(), 10.0f);
    }

    private void setBitmapShader() {
        Drawable drawable = getDrawable();
        if (drawable == null) {
            return;
        }
        Bitmap drawableToBitmap = drawableToBitmap(drawable);
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        this.mBitmapShader = new BitmapShader(drawableToBitmap, tileMode, tileMode);
        int i10 = this.mType;
        float f10 = 1.0f;
        if (i10 == 0) {
            f10 = (this.mWidth * 1.0f) / Math.min(drawableToBitmap.getWidth(), drawableToBitmap.getHeight());
        } else if (i10 == 1 || i10 == 2) {
            f10 = Math.max((getWidth() * 1.0f) / drawableToBitmap.getWidth(), (getHeight() * 1.0f) / drawableToBitmap.getHeight());
        }
        this.mMatrix.setScale(f10, f10);
        this.mBitmapShader.setLocalMatrix(this.mMatrix);
        this.mPaint.setShader(this.mBitmapShader);
    }

    public int dpTodx(int i10) {
        return (int) TypedValue.applyDimension(1, i10, getResources().getDisplayMetrics());
    }

    public int getRoundRadius() {
        return this.mRoundRadius;
    }

    public int getType() {
        return this.mType;
    }

    public boolean isCardViewParent() {
        return this.isCardViewParent;
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDraw(Canvas canvas) {
        if (getDrawable() == null) {
            return;
        }
        setBitmapShader();
        int i10 = this.mType;
        if (i10 == 0) {
            int i11 = this.mRadius;
            canvas.drawCircle(i11, i11, i11, this.mPaint);
            return;
        }
        if (i10 != 1) {
            if (i10 == 2) {
                canvas.drawOval(this.mRect, this.mPaint);
                return;
            }
            return;
        }
        this.mPaint.setColor(-65536);
        if (this.isCardViewParent) {
            canvas.drawRoundRect(this.mRect, this.mRoundRadius, 0.0f, this.mPaint);
            return;
        }
        RectF rectF = this.mRect;
        int i12 = this.mRoundRadius;
        canvas.drawRoundRect(rectF, i12, i12, this.mPaint);
    }

    @Override // android.widget.ImageView, android.view.View
    public void onMeasure(int i10, int i11) {
        super.onMeasure(i10, i11);
        if (this.mType == 0) {
            int min = Math.min(getMeasuredWidth(), getMeasuredHeight());
            this.mWidth = min;
            this.mRadius = min / 2;
            setMeasuredDimension(min, min);
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int i10, int i11, int i12, int i13) {
        super.onSizeChanged(i10, i11, i12, i13);
        this.mRect = new RectF(0.0f, 0.0f, getWidth(), getHeight());
    }

    public void setCardViewParent(boolean z10) {
        this.isCardViewParent = z10;
    }

    public void setRoundRadius(int i10) {
        if (this.mRoundRadius != i10) {
            this.mRoundRadius = i10;
            invalidate();
        }
    }

    public void setType(int i10) {
        if (this.mType != i10) {
            this.mType = i10;
            invalidate();
        }
    }

    public RoundImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RoundImageView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.mType = 1;
        this.isCardViewParent = false;
        initView();
    }
}
