package com.google.android.gms.cast.framework.internal.featurehighlight;

import android.R;
import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.TypedValue;
import androidx.annotation.Keep;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.internal.cast.zzda;
import com.google.android.gms.internal.cast.zzdb;
import r.a;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* loaded from: classes.dex */
class OuterHighlightDrawable extends Drawable {
    private final int zza;
    private final int zzb;
    private final int zzc;
    private final Rect zzd = new Rect();
    private final Rect zze = new Rect();
    private final Paint zzf;
    private float zzg;
    private float zzh;
    private float zzi;
    private float zzj;
    private float zzk;
    private float zzl;
    private int zzm;

    public OuterHighlightDrawable(Context context) {
        Paint paint = new Paint();
        this.zzf = paint;
        this.zzh = 1.0f;
        this.zzk = 0.0f;
        this.zzl = 0.0f;
        this.zzm = IjkMediaMeta.FF_PROFILE_H264_HIGH_444_PREDICTIVE;
        if (PlatformVersion.isAtLeastLollipop()) {
            TypedValue typedValue = new TypedValue();
            context.getTheme().resolveAttribute(R.attr.colorPrimary, typedValue, true);
            zze(a.m(typedValue.data, IjkMediaMeta.FF_PROFILE_H264_HIGH_444_PREDICTIVE));
        } else {
            zze(context.getResources().getColor(com.google.android.gms.cast.framework.R.color.cast_libraries_material_featurehighlight_outer_highlight_default_color));
        }
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.FILL);
        Resources resources = context.getResources();
        this.zza = resources.getDimensionPixelSize(com.google.android.gms.cast.framework.R.dimen.cast_libraries_material_featurehighlight_center_threshold);
        this.zzb = resources.getDimensionPixelSize(com.google.android.gms.cast.framework.R.dimen.cast_libraries_material_featurehighlight_center_horizontal_offset);
        this.zzc = resources.getDimensionPixelSize(com.google.android.gms.cast.framework.R.dimen.cast_libraries_material_featurehighlight_outer_padding);
    }

    private static final float zzh(float f10, float f11, Rect rect) {
        float f12 = rect.left;
        float f13 = rect.top;
        float f14 = rect.right;
        float f15 = rect.bottom;
        float zza = zzdb.zza(f10, f11, f12, f13);
        float zza2 = zzdb.zza(f10, f11, f14, f13);
        float zza3 = zzdb.zza(f10, f11, f14, f15);
        float zza4 = zzdb.zza(f10, f11, f12, f15);
        if (zza <= zza2 || zza <= zza3 || zza <= zza4) {
            zza = (zza2 <= zza3 || zza2 <= zza4) ? zza3 > zza4 ? zza3 : zza4 : zza2;
        }
        return (float) Math.ceil(zza);
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas canvas) {
        canvas.drawCircle(this.zzi + this.zzk, this.zzj + this.zzl, this.zzg * this.zzh, this.zzf);
    }

    @Override // android.graphics.drawable.Drawable
    public final int getAlpha() {
        return this.zzf.getAlpha();
    }

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int i10) {
        this.zzf.setAlpha(i10);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter colorFilter) {
        this.zzf.setColorFilter(colorFilter);
        invalidateSelf();
    }

    @Keep
    public void setScale(float f10) {
        this.zzh = f10;
        invalidateSelf();
    }

    @Keep
    public void setTranslationX(float f10) {
        this.zzk = f10;
        invalidateSelf();
    }

    @Keep
    public void setTranslationY(float f10) {
        this.zzl = f10;
        invalidateSelf();
    }

    public final float zza() {
        return this.zzi;
    }

    public final float zzb() {
        return this.zzj;
    }

    public final int zzc() {
        return this.zzf.getColor();
    }

    public final Animator zzd(float f10, float f11) {
        ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this, PropertyValuesHolder.ofFloat("scale", 0.0f, 1.0f), PropertyValuesHolder.ofFloat("translationX", f10, 0.0f), PropertyValuesHolder.ofFloat("translationY", f11, 0.0f), PropertyValuesHolder.ofInt("alpha", 0, this.zzm));
        ofPropertyValuesHolder.setInterpolator(zzda.zzc());
        return ofPropertyValuesHolder.setDuration(350L);
    }

    public final void zze(int i10) {
        this.zzf.setColor(i10);
        this.zzm = this.zzf.getAlpha();
        invalidateSelf();
    }

    public final void zzf(Rect rect, Rect rect2) {
        this.zzd.set(rect);
        this.zze.set(rect2);
        float exactCenterX = rect.exactCenterX();
        float exactCenterY = rect.exactCenterY();
        Rect bounds = getBounds();
        if (Math.min(exactCenterY - bounds.top, bounds.bottom - exactCenterY) < this.zza) {
            this.zzi = exactCenterX;
            this.zzj = exactCenterY;
        } else {
            this.zzi = exactCenterX <= bounds.exactCenterX() ? rect2.exactCenterX() + this.zzb : rect2.exactCenterX() - this.zzb;
            exactCenterY = rect2.exactCenterY();
            this.zzj = exactCenterY;
        }
        this.zzg = this.zzc + Math.max(zzh(this.zzi, exactCenterY, rect), zzh(this.zzi, this.zzj, rect2));
        invalidateSelf();
    }

    public final boolean zzg(float f10, float f11) {
        return zzdb.zza(f10, f11, this.zzi, this.zzj) < this.zzg;
    }
}
