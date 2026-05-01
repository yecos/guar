package com.mobile.brasiltv.view;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.mobile.brasiltv.R$styleable;

/* loaded from: classes3.dex */
public class RoundedImageView extends androidx.appcompat.widget.q {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final float DEFAULT_BORDER_WIDTH = 0.0f;
    public static final float DEFAULT_RADIUS = 0.0f;
    public static final Shader.TileMode DEFAULT_TILE_MODE = Shader.TileMode.CLAMP;
    private static final ImageView.ScaleType[] SCALE_TYPES = {ImageView.ScaleType.MATRIX, ImageView.ScaleType.FIT_XY, ImageView.ScaleType.FIT_START, ImageView.ScaleType.FIT_CENTER, ImageView.ScaleType.FIT_END, ImageView.ScaleType.CENTER, ImageView.ScaleType.CENTER_CROP, ImageView.ScaleType.CENTER_INSIDE};
    private static final int TILE_MODE_CLAMP = 0;
    private static final int TILE_MODE_MIRROR = 2;
    private static final int TILE_MODE_REPEAT = 1;
    private static final int TILE_MODE_UNDEFINED = -2;
    private ColorStateList borderColor;
    private float borderWidth;
    private float cornerRadius;
    private boolean isOval;
    private Drawable mBackgroundDrawable;
    private Drawable mDrawable;
    private int mResource;
    private ImageView.ScaleType mScaleType;
    private boolean mutateBackground;
    private Shader.TileMode tileModeX;
    private Shader.TileMode tileModeY;

    /* renamed from: com.mobile.brasiltv.view.RoundedImageView$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$android$widget$ImageView$ScaleType;

        static {
            int[] iArr = new int[ImageView.ScaleType.values().length];
            $SwitchMap$android$widget$ImageView$ScaleType = iArr;
            try {
                iArr[ImageView.ScaleType.CENTER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$android$widget$ImageView$ScaleType[ImageView.ScaleType.CENTER_CROP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$android$widget$ImageView$ScaleType[ImageView.ScaleType.CENTER_INSIDE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$android$widget$ImageView$ScaleType[ImageView.ScaleType.FIT_CENTER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$android$widget$ImageView$ScaleType[ImageView.ScaleType.FIT_START.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$android$widget$ImageView$ScaleType[ImageView.ScaleType.FIT_END.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$android$widget$ImageView$ScaleType[ImageView.ScaleType.FIT_XY.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    public RoundedImageView(Context context) {
        super(context);
        this.cornerRadius = 0.0f;
        this.borderWidth = 0.0f;
        this.borderColor = ColorStateList.valueOf(RoundedDrawable.DEFAULT_BORDER_COLOR);
        this.isOval = false;
        this.mutateBackground = false;
        Shader.TileMode tileMode = DEFAULT_TILE_MODE;
        this.tileModeX = tileMode;
        this.tileModeY = tileMode;
    }

    private static Shader.TileMode parseTileMode(int i10) {
        if (i10 == 0) {
            return Shader.TileMode.CLAMP;
        }
        if (i10 == 1) {
            return Shader.TileMode.REPEAT;
        }
        if (i10 != 2) {
            return null;
        }
        return Shader.TileMode.MIRROR;
    }

    private Drawable resolveResource() {
        Resources resources = getResources();
        Drawable drawable = null;
        if (resources == null) {
            return null;
        }
        int i10 = this.mResource;
        if (i10 != 0) {
            try {
                drawable = resources.getDrawable(i10);
            } catch (Exception unused) {
                k7.f.f("Unable to find resource: " + this.mResource, new Object[0]);
                this.mResource = 0;
            }
        }
        return RoundedDrawable.fromDrawable(drawable);
    }

    private void updateAttrs(Drawable drawable) {
        if (drawable == null) {
            return;
        }
        if (drawable instanceof RoundedDrawable) {
            ((RoundedDrawable) drawable).setScaleType(this.mScaleType).setCornerRadius(this.cornerRadius).setBorderWidth(this.borderWidth).setBorderColor(this.borderColor).setOval(this.isOval).setTileModeX(this.tileModeX).setTileModeY(this.tileModeY);
            return;
        }
        if (drawable instanceof LayerDrawable) {
            LayerDrawable layerDrawable = (LayerDrawable) drawable;
            int numberOfLayers = layerDrawable.getNumberOfLayers();
            for (int i10 = 0; i10 < numberOfLayers; i10++) {
                updateAttrs(layerDrawable.getDrawable(i10));
            }
        }
    }

    private void updateBackgroundDrawableAttrs(boolean z10) {
        if (this.mutateBackground) {
            if (z10) {
                this.mBackgroundDrawable = RoundedDrawable.fromDrawable(this.mBackgroundDrawable);
            }
            updateAttrs(this.mBackgroundDrawable);
        }
    }

    private void updateDrawableAttrs() {
        updateAttrs(this.mDrawable);
    }

    @Override // androidx.appcompat.widget.q, android.widget.ImageView, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        invalidate();
    }

    public int getBorderColor() {
        return this.borderColor.getDefaultColor();
    }

    public ColorStateList getBorderColors() {
        return this.borderColor;
    }

    public float getBorderWidth() {
        return this.borderWidth;
    }

    public float getCornerRadius() {
        return this.cornerRadius;
    }

    @Override // android.widget.ImageView
    public ImageView.ScaleType getScaleType() {
        return this.mScaleType;
    }

    public Shader.TileMode getTileModeX() {
        return this.tileModeX;
    }

    public Shader.TileMode getTileModeY() {
        return this.tileModeY;
    }

    public boolean isOval() {
        return this.isOval;
    }

    public void mutateBackground(boolean z10) {
        if (this.mutateBackground == z10) {
            return;
        }
        this.mutateBackground = z10;
        updateBackgroundDrawableAttrs(true);
        invalidate();
    }

    public boolean mutatesBackground() {
        return this.mutateBackground;
    }

    @Override // android.view.View
    public void setBackground(Drawable drawable) {
        setBackgroundDrawable(drawable);
    }

    @Override // androidx.appcompat.widget.q, android.view.View
    @Deprecated
    public void setBackgroundDrawable(Drawable drawable) {
        this.mBackgroundDrawable = drawable;
        updateBackgroundDrawableAttrs(true);
        super.setBackgroundDrawable(this.mBackgroundDrawable);
    }

    public void setBorderColor(int i10) {
        setBorderColor(ColorStateList.valueOf(i10));
    }

    public void setBorderWidth(int i10) {
        setBorderWidth(getResources().getDimension(i10));
    }

    public void setCornerRadius(int i10) {
        setCornerRadius(getResources().getDimension(i10));
    }

    @Override // androidx.appcompat.widget.q, android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        this.mResource = 0;
        this.mDrawable = RoundedDrawable.fromBitmap(bitmap);
        updateDrawableAttrs();
        super.setImageDrawable(this.mDrawable);
    }

    @Override // androidx.appcompat.widget.q, android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        this.mResource = 0;
        this.mDrawable = RoundedDrawable.fromDrawable(drawable);
        updateDrawableAttrs();
        super.setImageDrawable(this.mDrawable);
    }

    @Override // androidx.appcompat.widget.q, android.widget.ImageView
    public void setImageResource(int i10) {
        if (this.mResource != i10) {
            this.mResource = i10;
            this.mDrawable = resolveResource();
            updateDrawableAttrs();
            super.setImageDrawable(this.mDrawable);
        }
    }

    @Override // androidx.appcompat.widget.q, android.widget.ImageView
    public void setImageURI(Uri uri) {
        super.setImageURI(uri);
        setImageDrawable(getDrawable());
    }

    public void setOval(boolean z10) {
        this.isOval = z10;
        updateDrawableAttrs();
        updateBackgroundDrawableAttrs(false);
        invalidate();
    }

    @Override // android.widget.ImageView
    public void setScaleType(ImageView.ScaleType scaleType) {
        if (this.mScaleType != scaleType) {
            this.mScaleType = scaleType;
            switch (AnonymousClass1.$SwitchMap$android$widget$ImageView$ScaleType[scaleType.ordinal()]) {
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                case 7:
                    super.setScaleType(ImageView.ScaleType.FIT_XY);
                    break;
                default:
                    super.setScaleType(scaleType);
                    break;
            }
            updateDrawableAttrs();
            updateBackgroundDrawableAttrs(false);
            invalidate();
        }
    }

    public void setTileModeX(Shader.TileMode tileMode) {
        if (this.tileModeX == tileMode) {
            return;
        }
        this.tileModeX = tileMode;
        updateDrawableAttrs();
        updateBackgroundDrawableAttrs(false);
        invalidate();
    }

    public void setTileModeY(Shader.TileMode tileMode) {
        if (this.tileModeY == tileMode) {
            return;
        }
        this.tileModeY = tileMode;
        updateDrawableAttrs();
        updateBackgroundDrawableAttrs(false);
        invalidate();
    }

    public void setBorderColor(ColorStateList colorStateList) {
        if (this.borderColor.equals(colorStateList)) {
            return;
        }
        if (colorStateList == null) {
            colorStateList = ColorStateList.valueOf(RoundedDrawable.DEFAULT_BORDER_COLOR);
        }
        this.borderColor = colorStateList;
        updateDrawableAttrs();
        updateBackgroundDrawableAttrs(false);
        if (this.borderWidth > 0.0f) {
            invalidate();
        }
    }

    public void setBorderWidth(float f10) {
        if (this.borderWidth == f10) {
            return;
        }
        this.borderWidth = f10;
        updateDrawableAttrs();
        updateBackgroundDrawableAttrs(false);
        invalidate();
    }

    public void setCornerRadius(float f10) {
        if (this.cornerRadius == f10) {
            return;
        }
        this.cornerRadius = f10;
        updateDrawableAttrs();
        updateBackgroundDrawableAttrs(false);
    }

    public RoundedImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RoundedImageView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.cornerRadius = 0.0f;
        this.borderWidth = 0.0f;
        this.borderColor = ColorStateList.valueOf(RoundedDrawable.DEFAULT_BORDER_COLOR);
        this.isOval = false;
        this.mutateBackground = false;
        Shader.TileMode tileMode = DEFAULT_TILE_MODE;
        this.tileModeX = tileMode;
        this.tileModeY = tileMode;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.f7802v, i10, 0);
        int i11 = obtainStyledAttributes.getInt(0, -1);
        if (i11 >= 0) {
            setScaleType(SCALE_TYPES[i11]);
        } else {
            setScaleType(ImageView.ScaleType.FIT_CENTER);
        }
        this.cornerRadius = obtainStyledAttributes.getDimensionPixelSize(3, -1);
        float dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(2, -1);
        this.borderWidth = dimensionPixelSize;
        if (this.cornerRadius < 0.0f) {
            this.cornerRadius = 0.0f;
        }
        if (dimensionPixelSize < 0.0f) {
            this.borderWidth = 0.0f;
        }
        ColorStateList colorStateList = obtainStyledAttributes.getColorStateList(1);
        this.borderColor = colorStateList;
        if (colorStateList == null) {
            this.borderColor = ColorStateList.valueOf(RoundedDrawable.DEFAULT_BORDER_COLOR);
        }
        this.mutateBackground = obtainStyledAttributes.getBoolean(4, false);
        this.isOval = obtainStyledAttributes.getBoolean(5, false);
        int i12 = obtainStyledAttributes.getInt(6, -2);
        if (i12 != -2) {
            setTileModeX(parseTileMode(i12));
            setTileModeY(parseTileMode(i12));
        }
        int i13 = obtainStyledAttributes.getInt(7, -2);
        if (i13 != -2) {
            setTileModeX(parseTileMode(i13));
        }
        int i14 = obtainStyledAttributes.getInt(8, -2);
        if (i14 != -2) {
            setTileModeY(parseTileMode(i14));
        }
        updateDrawableAttrs();
        updateBackgroundDrawableAttrs(true);
        obtainStyledAttributes.recycle();
    }
}
